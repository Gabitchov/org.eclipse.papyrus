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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
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
			protected void buildUpdates(ControlModeRequest request, IUpdate.Collector updates) {
				collectProxyCrossReferenceUpdates(updates, request.getModelSet(), request.getNewURI());
			}
		};
	}

	/**
	 * Obtains an {@linkplain IUpdate update} operation that converts external cross-references to the elements
	 * in a logical model unit indicated by the given representative {@code resource} to proxies.
	 * 
	 * @param resource
	 *        a resource that is a component of a logical model unit
	 * 
	 * @return an operation that, when {@linkplain IUpdate#apply() applied}, will convert incoming cross-references to proxies
	 */
	public IUpdate getProxyCrossReferencesUpdate(Resource resource) {
		IUpdate.Compound result = new CompoundUpdate();

		collectProxyCrossReferenceUpdates(result, resource.getResourceSet(), resource.getURI());

		return result;
	}

	private void collectProxyCrossReferenceUpdates(IUpdate.Collector updates, ResourceSet resourceSet, URI unitURI) {
		for(final EObject object : getAllPersistentSubunitContents(resourceSet, unitURI)) {
			// replace references to the element by a proxy
			final CDOID proxy = CDOIDUtil.createExternal(CDOProxyManager.createPapyrusCDOURI(object));
			for(EStructuralFeature.Setting next : getExternalCrossReferences(object)) {
				updates.add(new ControlUpdate(next, object, proxy));
			}
		}
	}

	public ICommand getPreUncontrolCommand(ControlModeRequest request) {
		return new AbstractCDOControlCommand(request) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				objectsToClearResource = Lists.newArrayList();

				return super.doExecuteWithResult(monitor, info);
			}

			@Override
			protected void buildUpdates(ControlModeRequest request, IUpdate.Collector updates) {
				final URI sourceURI = getRequest().getSourceURI();

				IUpdate resolveProxies = IUpdate.EMPTY;

				// update references from other units to the unit being re-integrated
				for(final EObject object : getAllPersistentSubunitContents(getRequest().getModelSet(), sourceURI)) {
					// replace proxy references to the element by the element or an updated proxy
					// which will be located in the destination resource
					Resource sourceResource = object.eResource();
					final CDOID sourceProxy = CDOIDUtil.createExternal(CDOProxyManager.createPapyrusCDOURI(object));

					Resource destinationResource = request.getTargetResource(sourceResource.getURI().fileExtension());
					String proxyURI = CDOProxyManager.createPapyrusCDOURI(destinationResource.getURI(), object);
					final CDOID proxy = CDOIDUtil.createExternal(proxyURI);

					// internal cross-references within the unit won't be affected, as they are all moving
					for(final EStructuralFeature.Setting next : getExternalCrossReferences(object)) {
						if(next.getEObject().eIsProxy()) {
							// the cross-reference will be from a proxy only when it is a proxy owned by the cross-referenced object,
							// by virtue of an opposite reference.  In this case, it's only interesting if the proxy targets the
							// parent (re-integrated-into) resource. So, resolve this proxy because we need to update the
							// reference, below
							resolveProxies = resolveProxies.chain(new OneWayUpdate() {

								public void apply() {
									resolve(object, (EReference)next.getEStructuralFeature(), next.getEObject());
								}
							});

						} else {
							updates.add(new UncontrolUpdate(next, object, sourceProxy, destinationResource.getURI(), proxy));
						}
					}

					// upon removal from their resources, root elements will nonetheless retain a
					// reference to the resource that formerly contained them.  We need to force
					// clearing of this reference in the CDO store
					if(((InternalEObject)object).eDirectResource() != null) {
						objectsToClearResource.add(object);
					}
				}

				// resolve proxies as per above, after completing the loop, to avoid concurrent modifications
				resolveProxies.apply();

				// update references from the unit being re-integrated to the unit it is re-integrating into
				for(final EObject object : getAllPersistentSubunitContents(getRequest().getModelSet(), getRequest().getNewURI())) {
					// replace proxy references to the element by the element or an updated proxy
					// which will be located in the destination resource
					final CDOID targetProxy = CDOIDUtil.createExternal(CDOProxyManager.createPapyrusCDOURI(object));

					for(EStructuralFeature.Setting next : getExternalCrossReferences(object)) {
						if(inUnit(next.getEObject(), sourceURI)) {
							// replace proxy references from the sub-unit into the parent with a direct reference, as this will
							// no longer be a cross-unit reference
							updates.add(new UncontrolUpdate(next, object, targetProxy));
						}
					}
				}
			}
		};
	}

	void resolve(EObject object, EReference reference, EObject proxy) {
		EReference opposite = reference.getEOpposite();
		if(opposite != null) {
			if(opposite.isMany()) {
				InternalEList<?> list = (InternalEList<?>)object.eGet(opposite, false);
				int index = list.basicIndexOf(proxy);
				if(index >= 0) {
					list.get(index); // resolve just this index
				}
			} else {
				object.eGet(opposite, true); // resolve the scalar reference
			}
		}
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
			protected void buildUpdates(ControlModeRequest request, IUpdate.Collector updates) {
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
		URI uri = other.eIsProxy() ? ((InternalEObject)other).eProxyURI().trimFragment() : other.eResource().getURI();
		return inUnit(object, uri);
	}

	static boolean inUnit(EObject object, URI unit) {
		// get the extension-less model URIs
		URI uri = object.eIsProxy() ? ((InternalEObject)object).eProxyURI().trimFragment() : object.eResource().getURI();
		uri = uri.trimFileExtension();
		URI otherURI = unit.trimFileExtension();

		return uri.equals(otherURI);
	}

	/**
	 * Iterates all of the proper contents of the resources comprising the logical model unit
	 * indicated by the representative {@code unitURI}.
	 * 
	 * @param rset
	 *        a resource set in which to load and/or iterate the resource contents
	 * @param unitURI
	 *        the URI of one of the resources in the logical model unit, which therefore is representative of the unit
	 * 
	 * @return an iterator over the entire logical model unit's proper contents
	 */
	static Iterable<EObject> getAllPersistentSubunitContents(ResourceSet rset, URI unitURI) {
		final URI base = unitURI.trimFileExtension();
		Iterable<Resource> resources = filter(rset.getResources(), new Predicate<Resource>() {

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

	public static interface IUpdate {

		/**
		 * An update that does nothing. It is {@linkplain IUpdate#isEmpty() empty}.
		 */
		IUpdate EMPTY = new IUpdate() {

			public boolean isEmpty() {
				return true;
			}

			public void apply() {
				// pass
			}

			public void revert() {
				// revert
			}

			public IUpdate chain(IUpdate update) {
				return (update == null) ? this : update;
			}

		};

		/**
		 * Queries whether I have nothing to do on {@link #apply() apply}.
		 * 
		 * @return whether I am empty
		 */
		boolean isEmpty();

		void apply();

		void revert();

		IUpdate chain(IUpdate update);

		interface Collector {

			void add(IUpdate update);
		}

		interface Compound extends IUpdate, Collector {
			// all methods inherited
		}

	}

	static final class CompoundUpdate implements IUpdate.Compound {

		private final List<IUpdate> updates = Lists.newArrayList();

		public void add(IUpdate update) {
			updates.add(update);
		}

		public Compound chain(IUpdate update) {
			if((update != null) && !update.isEmpty()) {
				add(update);
			}

			return this;
		}

		public boolean isEmpty() {
			return updates.isEmpty();
		}

		public void apply() {
			for(IUpdate next : updates) {
				next.apply();
			}
		}

		public void revert() {
			for(ListIterator<IUpdate> iter = updates.listIterator(updates.size()); iter.hasPrevious();) {
				iter.previous().revert();
			}
		}

		static IUpdate compose(IUpdate first, IUpdate second) {
			IUpdate result;

			if((second == null) || second.isEmpty()) {
				result = (first == null) ? IUpdate.EMPTY : first;
			} else if((first == null) || first.isEmpty()) {
				// we already know it's not null or empty
				result = second;
			} else {
				IUpdate.Compound compound = new CompoundUpdate();
				compound.add(first);
				compound.add(second);
				result = compound;
			}

			return result;
		}
	}

	private static abstract class OneWayUpdate implements IUpdate {

		public void revert() {
			throw new UnsupportedOperationException("OneWayUpdate cannot be reverted");
		}

		public IUpdate chain(IUpdate update) {
			return CompoundUpdate.compose(this, update);
		}

		public boolean isEmpty() {
			return false;
		}
	}

	private static abstract class Update implements IUpdate {

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

		public IUpdate chain(IUpdate update) {
			return CompoundUpdate.compose(this, update);
		}

		public boolean isEmpty() {
			// a leaf update is, by definition, not empty
			return false;
		}
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

		public void apply() {
			EStructuralFeature feature = setting.getEStructuralFeature();

			if((index >= 0) || !feature.isMany()) {
				InternalEObject owner = (InternalEObject)setting.getEObject();
				store.set(owner, feature, index, proxy);
			}
		}

		public void revert() {
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

		UncontrolUpdate(EStructuralFeature.Setting setting, EObject originalObject, CDOID originalProxy) {
			this(setting, originalObject, originalProxy, null, null);
		}

		public void apply() {
			EStructuralFeature feature = setting.getEStructuralFeature();

			if((index >= 0) || !feature.isMany()) {
				InternalEObject owner = (InternalEObject)setting.getEObject();

				if((destinationURI == null) || inUnit(owner, destinationURI)) {
					// direct reference
					store.set(owner, feature, index, CDOUtils.getCDOID(originalObject));
				} else {
					// proxy reference for cross-unit
					store.set(owner, feature, index, destinationProxy);
				}
			}
		}

		public void revert() {
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

		public void apply() {
			InternalEObject object = (InternalEObject)CDOUtil.getEObject(this.object);
			store.setContainer(object, null, object.eInternalContainer(), object.eContainerFeatureID());
		}

		public void revert() {
			// there is no need to revert clearing the resource reference; it will be
			// reestablished naturally by undo of the base command
		}
	}

	private static abstract class AbstractCDOControlCommand extends AbstractControlCommand implements IUpdate.Compound {

		AbstractCDOControlCommand(ControlModeRequest request) {
			super(Messages.CDOControlModeParticipant_commandLabel, Collections.emptyList(), request);
		}

		private List<IUpdate> updates;

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			final ImmutableListCollector collector = new ImmutableListCollector();

			buildUpdates(getRequest(), collector);

			this.updates = collector.close();

			apply();

			return CommandResult.newOKCommandResult();
		}

		protected abstract void buildUpdates(ControlModeRequest request, IUpdate.Collector updates);

		@Override
		protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			IStatus result = super.doUndo(monitor, info);

			if(result.isOK()) {
				// setting proxies in the way we did is not recorded by EMF, so we have to undo it ourselves
				revert();
			}

			return result;
		}

		@Override
		protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			IStatus result = super.doRedo(monitor, info);

			if(result.isOK()) {
				// setting proxies in the way we did is not recorded by EMF, so we have to redo it ourselves
				apply();
			}

			return result;
		}

		public boolean isEmpty() {
			return (updates == null) || updates.isEmpty();
		}

		public void apply() {
			for(IUpdate next : updates) {
				next.apply();
			}
		}

		public void revert() {
			for(ListIterator<IUpdate> iter = updates.listIterator(updates.size()); iter.hasPrevious();) {
				iter.previous().revert();
			}
		}

		public void add(IUpdate update) {
			throw new UnsupportedOperationException("AbtsractCDOControlCommand is not externally modifiable"); //$NON-NLS-1$
		}

		public Compound chain(IUpdate update) {
			throw new UnsupportedOperationException("AbtsractCDOControlCommand is not externally modifiable"); //$NON-NLS-1$
		}
	};

	private static final class ImmutableListCollector implements IUpdate.Collector {

		private final ImmutableList.Builder<IUpdate> builder = ImmutableList.builder();

		public void add(IUpdate update) {
			builder.add(update);
		}

		List<IUpdate> close() {
			return builder.build();
		}
	}
}
