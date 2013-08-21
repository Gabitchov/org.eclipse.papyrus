/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.core.controlmode;

import static com.google.common.collect.Iterables.concat;
import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.transform;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOState;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.eresource.EresourcePackage;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.spi.cdo.CDOStore;
import org.eclipse.emf.spi.cdo.InternalCDOView;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.IdentityCommand;
import org.eclipse.papyrus.cdo.internal.core.Activator;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequest;
import org.eclipse.papyrus.infra.services.controlmode.commands.AbstractControlCommand;
import org.eclipse.papyrus.infra.services.controlmode.participants.IControlCommandParticipant;
import org.eclipse.papyrus.infra.services.controlmode.participants.IControlModeParticipant;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;


/**
 * A {@link IControlModeParticipant} for CDO resources that handles replacing references to controlled
 * elements with proxies that, even in a CDO view, must be resolved by the usual EMF mechanism.
 */
public class CDOControlModeParticipant implements IControlCommandParticipant {

	private static final Set<CDOState> TEMPORARY_ID_STATES = EnumSet.of(CDOState.TRANSIENT, CDOState.NEW);

	public CDOControlModeParticipant() {
		super();
	}

	public String getID() {
		return CDOControlModeParticipant.class.getName();
	}

	public int getPriority() {
		return 255;
	}

	public boolean provideControlCommand(ControlModeRequest request) {
		return CDOUtils.isCDOURI(request.getSourceURI());
	}

	public ICommand getPreControlCommand(ControlModeRequest request) {
		return IdentityCommand.INSTANCE;
	}

	public ICommand getPostControlCommand(ControlModeRequest request) {
		return new AbstractControlCommand("CDO aspects", Collections.emptyList(), request) {

			private List<Update> updates;

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				final ImmutableList.Builder<Update> updates = ImmutableList.builder();

				for(final EObject object : getAllPersistentSubunitContents(getRequest())) {
					if(isPersistentObject(object)) {
						// replace references to the element by a proxy
						final CDOID proxy = CDOIDUtil.createExternal(CDOProxyManager.createPapyrusCDOURI(object).toString());
						for(EStructuralFeature.Setting next : getExternalCrossReferences(object)) {
							updates.add(new Update(next, object, proxy));
						}
					}
				}

				this.updates = updates.build();

				applyUpdates();

				return CommandResult.newOKCommandResult();
			}

			@Override
			protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				IStatus result = super.doUndo(monitor, info);

				if(result.isOK()) {
					// setting proxies in the way we did is not recorded by EMF, so we have to undo it ourselves
					revertUpdates();
				}

				return result;
			}

			@Override
			protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				IStatus result = super.doRedo(monitor, info);

				if(result.isOK()) {
					// setting proxies in the way we did is not recorded by EMF, so we have to redo it ourselves
					applyUpdates();
				}

				return result;
			}

			private void applyUpdates() {
				for(Update next : updates) {
					next.apply();
				}
			}

			private void revertUpdates() {
				for(ListIterator<Update> iter = updates.listIterator(updates.size()); iter.hasPrevious();) {
					iter.previous().revert();
				}
			}
		};
	}

	/**
	 * Get all cross-references to an {@code object} from outside of its own controlled unit.
	 * 
	 * @param object
	 *        an object being controlled
	 * @return references to it from outside of its (new) controlled unit
	 */
	Iterable<EStructuralFeature.Setting> getExternalCrossReferences(final EObject object) {
		return Iterables.filter(CDOUtils.crossReference(object), new Predicate<EStructuralFeature.Setting>() {

			public boolean apply(EStructuralFeature.Setting input) {
				boolean result = false;

				EStructuralFeature ref = input.getEStructuralFeature();
				if((ref != EresourcePackage.Literals.CDO_RESOURCE__CONTENTS) && ref.isChangeable() && !ref.isDerived()) {
					result = !inSameUnit(input.getEObject(), object);
				}

				return result;
			}
		});

	}

	static boolean isPersistentObject(EObject object) {
		CDOObject cdo = CDOUtils.getCDOObject(object);
		return (cdo != null) && !TEMPORARY_ID_STATES.contains(cdo.cdoState());
	}

	static boolean inSameUnit(EObject object, EObject other) {
		// get the extension-less model URIs
		URI uri = object.eResource().getURI().trimFileExtension();
		URI otherURI = other.eResource().getURI().trimFileExtension();

		return uri.equals(otherURI);
	}

	static Iterable<EObject> getAllPersistentSubunitContents(final ControlModeRequest request) {
		final URI base = request.getNewURI().trimFileExtension();
		Iterable<Resource> resources = filter(request.getModelSet().getResources(), new Predicate<Resource>() {

			public boolean apply(Resource input) {
				return input.getURI().trimFileExtension().equals(base);
			}
		});

		Iterable<EObject> result = concat(transform(resources, new Function<Resource, Iterable<EObject>>() {

			public Iterable<EObject> apply(final Resource input) {
				return new Iterable<EObject>() {

					public Iterator<EObject> iterator() {
						return EcoreUtil.getAllProperContents(input, false);
					}
				};
			}
		}));

		result = filter(result, new Predicate<EObject>() {

			public boolean apply(EObject input) {
				return isPersistentObject(input);
			}
		});

		return result;
	}

	//
	// Nested types
	//

	private static final class Update {

		final EStructuralFeature.Setting setting;

		final EObject originalObject;

		final CDOID proxy;

		final CDOStore store;

		final int index;

		Update(EStructuralFeature.Setting setting, EObject originalObject, CDOID proxy) {
			this.setting = setting;
			this.originalObject = originalObject;
			this.proxy = proxy;

			EStructuralFeature feature = setting.getEStructuralFeature();
			InternalEObject owner = (InternalEObject)setting.getEObject();
			CDOObject cdoOwner = CDOUtil.getCDOObject(owner);

			InternalCDOView view = (InternalCDOView)cdoOwner.cdoView();
			store = view.getStore();

			if(!feature.isMany()) {
				index = CDOStore.NO_INDEX;
			} else {
				index = store.indexOf(owner, feature, originalObject);
				if(index < 0) {
					Activator.log.error("Setting does not include the object being replaced by a proxy.", null);
				}
			}
		}

		void apply() {
			EStructuralFeature feature = setting.getEStructuralFeature();

			if((index >= 0) || !feature.isMany()) {
				InternalEObject owner = (InternalEObject)setting.getEObject();
				store.set(owner, feature, index, proxy);
			}
		}

		void revert() {
			EStructuralFeature feature = setting.getEStructuralFeature();

			if(index >= 0 || !feature.isMany()) {
				InternalEObject owner = (InternalEObject)setting.getEObject();
				store.set(owner, feature, index, originalObject);
			}
		}
	}
}
