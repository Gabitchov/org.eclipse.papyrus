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
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.papyrus.cdo.internal.core.l10n.Messages;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequest;
import org.eclipse.papyrus.infra.services.controlmode.commands.AbstractControlCommand;
import org.eclipse.papyrus.infra.services.controlmode.participants.IControlCommandParticipant;
import org.eclipse.papyrus.infra.services.controlmode.participants.IControlModeParticipant;
import org.eclipse.papyrus.infra.services.controlmode.participants.IUncontrolCommandParticipant;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableCollection.Builder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;


/**
 * A {@link IControlModeParticipant} for CDO resources that handles replacing references to controlled
 * elements with proxies that, even in a CDO view, must be resolved by the usual EMF mechanism.
 */
public class CDOControlModeParticipant implements IControlCommandParticipant, IUncontrolCommandParticipant {

	private static final Set<CDOState> TEMPORARY_ID_STATES = EnumSet.of(CDOState.TRANSIENT, CDOState.NEW);

	private List<EObject> objectsToClearResource;

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
		return isCDOResource(request);
	}

	private boolean isCDOResource(ControlModeRequest request) {
		return CDOUtils.isCDOURI(request.getSourceURI());
	}

	public boolean provideUnControlCommand(ControlModeRequest request) {
		return isCDOResource(request);
	}

	public ICommand getPreControlCommand(ControlModeRequest request) {
		return IdentityCommand.INSTANCE;
	}

	public ICommand getPostControlCommand(ControlModeRequest request) {
		return new AbstractCDOControlCommand(request) {

			@Override
			protected void buildUpdates(ControlModeRequest request, Builder<? super Update> updates) {
				for(final EObject object : getAllPersistentSubunitContents(getRequest(), true)) {
					// replace references to the element by a proxy
					final CDOID proxy = CDOIDUtil.createExternal(CDOProxyManager.createPapyrusCDOURI(object));
					for(EStructuralFeature.Setting next : getExternalCrossReferences(object)) {
						updates.add(new ControlUpdate(next, object, proxy));
					}
				}
			}
		};
	}

	public ICommand getPreUncontrolCommand(ControlModeRequest request) {
		return new AbstractCDOControlCommand(request) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				objectsToClearResource = Lists.newArrayList();

				return super.doExecuteWithResult(monitor, info);
			}

			@Override
			protected void buildUpdates(ControlModeRequest request, Builder<? super Update> updates) {
				for(final EObject object : getAllPersistentSubunitContents(getRequest(), false)) {
					// replace proxy references to the element by the element or an updated proxy
					// which will be located in the destination resource
					Resource sourceResource = object.eResource();
					final CDOID sourceProxy = CDOIDUtil.createExternal(CDOProxyManager.createPapyrusCDOURI(object));

					Resource destinationResource = request.getTargetResource(sourceResource.getURI().fileExtension());
					String proxyURI = CDOProxyManager.createPapyrusCDOURI(destinationResource.getURI(), object);
					final CDOID proxy = CDOIDUtil.createExternal(proxyURI);

					// internal cross-references within the unit won't be affected, as they are all moving
					for(EStructuralFeature.Setting next : getExternalCrossReferences(object)) {
						updates.add(new UncontrolUpdate(next, object, sourceProxy, destinationResource.getURI(), proxy));
					}

					// upon removal from their resources, root elements will nonetheless retain a
					// reference to the resource that formerly contained them.  We need to force
					// clearing of this reference in the CDO store
					if(((InternalEObject)object).eDirectResource() != null) {
						objectsToClearResource.add(object);
					}
				}
			}
		};
	}

	public ICommand getPostUncontrolCommand(ControlModeRequest request) {
		return new AbstractCDOControlCommand(request) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				CommandResult result = super.doExecuteWithResult(monitor, info);

				objectsToClearResource = null;

				return result;
			}

			@Override
			protected void buildUpdates(ControlModeRequest request, Builder<? super Update> updates) {
				for(EObject next : objectsToClearResource) {
					// some former resource roots may not be reattached (e.g., SashWindowsMgr)
					if(CDOUtil.getCDOObject(next).cdoState() != CDOState.TRANSIENT) {
						updates.add(new ClearResourceUpdate(next));
					}
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
		boolean result = !object.eIsProxy();

		if(result) {
			CDOObject cdo = CDOUtils.getCDOObject(object);
			result = (cdo != null) && !TEMPORARY_ID_STATES.contains(cdo.cdoState());
		}

		return result;
	}

	static boolean inSameUnit(EObject object, EObject other) {
		// is the one object in the other's unit?
		return inUnit(object, other.eResource().getURI());
	}

	static boolean inUnit(EObject object, URI unit) {
		// get the extension-less model URIs
		URI uri = object.eResource().getURI().trimFileExtension();
		URI otherURI = unit.trimFileExtension();

		return uri.equals(otherURI);
	}

	static Iterable<EObject> getAllPersistentSubunitContents(final ControlModeRequest request, boolean isControl) {
		final URI base = isControl ? request.getNewURI().trimFileExtension() : request.getSourceURI().trimFileExtension();
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

	private static abstract class Update {

		final EStructuralFeature.Setting setting;

		final CDOStore store;

		Update(EStructuralFeature.Setting setting) {
			this.setting = setting;

			InternalEObject owner = (InternalEObject)setting.getEObject();
			CDOObject cdoOwner = CDOUtil.getCDOObject(owner);

			InternalCDOView view = (InternalCDOView)cdoOwner.cdoView();
			store = view.getStore();
		}

		Update(EObject object) {
			this.setting = null;

			CDOObject cdo = CDOUtil.getCDOObject(object);
			CDOView view = cdo.cdoView();
			this.store = (view instanceof InternalCDOView) ? ((InternalCDOView)view).getStore() : null;
		}

		abstract void apply();

		abstract void revert();
	}

	private static final class ControlUpdate extends Update {

		final EObject originalObject;

		final CDOID proxy;

		final int index;

		ControlUpdate(EStructuralFeature.Setting setting, EObject originalObject, CDOID proxy) {
			super(setting);
			this.originalObject = originalObject;
			this.proxy = proxy;

			EStructuralFeature feature = setting.getEStructuralFeature();
			InternalEObject owner = (InternalEObject)setting.getEObject();

			if(!feature.isMany()) {
				index = CDOStore.NO_INDEX;
			} else {
				// don't go directly to the store because it may have proxies.
				// Use the resolved view in the EObject, instead
				index = ((EList<?>)owner.eGet(feature)).indexOf(originalObject);
				if(index < 0) {
					Activator.log.error("Setting does not include the object being replaced by a proxy.", null); //$NON-NLS-1$
				}
			}
		}

		@Override
		void apply() {
			EStructuralFeature feature = setting.getEStructuralFeature();

			if((index >= 0) || !feature.isMany()) {
				InternalEObject owner = (InternalEObject)setting.getEObject();
				store.set(owner, feature, index, proxy);
			}
		}

		@Override
		void revert() {
			EStructuralFeature feature = setting.getEStructuralFeature();

			if(index >= 0 || !feature.isMany()) {
				InternalEObject owner = (InternalEObject)setting.getEObject();
				store.set(owner, feature, index, CDOUtils.getCDOID(originalObject));
			}
		}
	}

	private static final class UncontrolUpdate extends Update {

		final EObject originalObject;

		final CDOID originalProxy;

		final URI destinationURI;

		final CDOID destinationProxy;

		final int index;

		UncontrolUpdate(EStructuralFeature.Setting setting, EObject originalObject, CDOID originalProxy, URI destinationURI, CDOID destinationProxy) {
			super(setting);
			this.originalObject = originalObject;
			this.originalProxy = originalProxy;
			this.destinationURI = destinationURI;
			this.destinationProxy = destinationProxy;

			EStructuralFeature feature = setting.getEStructuralFeature();
			InternalEObject owner = (InternalEObject)setting.getEObject();

			if(!feature.isMany()) {
				index = CDOStore.NO_INDEX;
			} else {
				// don't go directly to the store because it may have proxies.
				// Use the resolved view in the EObject, instead
				index = ((EList<?>)owner.eGet(feature)).indexOf(originalObject);
				if(index < 0) {
					Activator.log.error("Setting does not include the object being replaced by a proxy.", null); //$NON-NLS-1$
				}
			}
		}

		@Override
		void apply() {
			EStructuralFeature feature = setting.getEStructuralFeature();

			if((index >= 0) || !feature.isMany()) {
				InternalEObject owner = (InternalEObject)setting.getEObject();

				if(inUnit(owner, destinationURI)) {
					// direct reference
					store.set(owner, feature, index, CDOUtils.getCDOID(originalObject));
				} else {
					// proxy reference for cross-unit
					store.set(owner, feature, index, destinationProxy);
				}
			}
		}

		@Override
		void revert() {
			EStructuralFeature feature = setting.getEStructuralFeature();

			if(index >= 0 || !feature.isMany()) {
				InternalEObject owner = (InternalEObject)setting.getEObject();

				// on reversion, we are processing only references that were external
				// to the unit that was to be re-integrated, so necessarily all
				// references must be set to the original proxies
				store.set(owner, feature, index, originalProxy);
			}
		}
	}

	private static final class ClearResourceUpdate extends Update {

		private CDOObject object;

		ClearResourceUpdate(EObject object) {
			super(object);

			this.object = CDOUtil.getCDOObject(object);
		}

		@Override
		void apply() {
			InternalEObject object = (InternalEObject)CDOUtil.getEObject(this.object);
			store.setContainer(object, null, object.eInternalContainer(), object.eContainerFeatureID());
		}

		@Override
		void revert() {
			// there is no need to revert clearing the resource reference; it will be
			// reestablished naturally by undo of the base command
		}
	}

	private static abstract class AbstractCDOControlCommand extends AbstractControlCommand {

		AbstractCDOControlCommand(ControlModeRequest request) {
			super(Messages.CDOControlModeParticipant_commandLabel, Collections.emptyList(), request);
		}

		private List<Update> updates;

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			final ImmutableList.Builder<Update> updates = ImmutableList.builder();

			buildUpdates(getRequest(), updates);

			this.updates = updates.build();

			applyUpdates();

			return CommandResult.newOKCommandResult();
		}

		protected abstract void buildUpdates(ControlModeRequest request, ImmutableCollection.Builder<? super Update> updates);

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
