/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.uml.modelrepair.internal.stereotypes;

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.IModelSetSnippet;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResourceSet;
import org.eclipse.papyrus.uml.modelrepair.ui.ZombieStereotypeDialogPresenter;
import org.eclipse.ui.IEditorPart;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;


/**
 * A snippet on the UML Model for detecting and initiating repair of zombie stereotype applications.
 */
public class StereotypeApplicationRepairSnippet implements IModelSetSnippet {

	private final UMLResourceLoadAdaper adapter = new UMLResourceLoadAdaper();

	private final Supplier<Profile> dynamicProfileSupplier;
	
	private ZombieStereotypeDialogPresenter presenter;

	public StereotypeApplicationRepairSnippet() {
		this(null);
	}

	protected StereotypeApplicationRepairSnippet(Supplier<Profile> dynamicProfileSupplier) {
		super();

		this.dynamicProfileSupplier = dynamicProfileSupplier;
	}

	protected void handleResourceLoaded(Resource resource) {
		Element root = getRootUMLElement(resource);

		// Only check for zombies in resources that we can modify (those being the resources in the user model opened in the editor)
		if((root != null) && !EMFHelper.isReadOnly(resource, EMFHelper.resolveEditingDomain(root))) {
			ZombieStereotypesDescriptor zombies = getZombieStereotypes(resource, root);
			if((zombies != null) && (presenter != null)) {
				presenter.addZombies(zombies);
			}
		}
	}

	protected Element getRootUMLElement(Resource resource) {
		return (Element)EcoreUtil.getObjectByType(resource.getContents(), UMLPackage.Literals.ELEMENT);
	}

	protected ZombieStereotypesDescriptor getZombieStereotypes(Resource resource, Element root) {
		ZombieStereotypesDescriptor result = null;

		Package contextPackage = root.getNearestPackage();

		// Could be a Class or something that is a disconnected controlled unit?
		if(contextPackage != null) {
			Collection<ProfileApplication> profileApplications = contextPackage.getAllProfileApplications();
			Set<EPackage> appliedDefinitions = getAppliedDefinitions(profileApplications);
			Supplier<Profile> profileSupplier = (dynamicProfileSupplier != null) ? dynamicProfileSupplier : presenter.getDynamicProfileSupplier();
			ZombieStereotypesDescriptor zombies = new ZombieStereotypesDescriptor(resource, root, appliedDefinitions, profileSupplier);

			for(EObject next : resource.getContents()) {
				if(!(next instanceof Element)) {
					zombies.analyze(next);
				}
			}

			if(zombies.hasZombies()) {
				result = zombies;
			}
		}

		return result;
	}

	protected Set<EPackage> getAppliedDefinitions(Iterable<? extends ProfileApplication> profileApplications) {
		Set<EPackage> result = Sets.newHashSet();

		for(ProfileApplication next : profileApplications) {
			EPackage definition = next.getAppliedDefinition();
			if((definition != null) && !definition.eIsProxy()) {
				result.add(definition);
			}
		}

		return result;
	}

	//
	// Snippet lifecycle
	//

	public void start(ModelSet modelsManager) {
		try {
			IEditorPart editor = ServiceUtilsForResourceSet.getInstance().getService(IMultiDiagramEditor.class, modelsManager);

			if(editor != null) {
				// this model is opened in an editor. That is the context in which we want to provide our services
				presenter = new ZombieStereotypeDialogPresenter(editor.getSite().getShell(), modelsManager);
				adapter.adapt(modelsManager);
			}
		} catch (ServiceException e) {
			// OK, there is no editor, so we aren't needed
		}
	}

	public void dispose(ModelSet modelsManager) {
		if(presenter != null) {
			presenter.dispose();
			presenter = null;
		}

		adapter.unadapt(modelsManager);
	}

	//
	// Nested types
	//

	private class UMLResourceLoadAdaper extends AdapterImpl {

		@Override
		public void notifyChanged(Notification msg) {
			Object notifier = msg.getNotifier();

			if(notifier instanceof ResourceSet) {
				handleNotification((ResourceSet)notifier, msg);
			} else if(notifier instanceof Resource) {
				handleNotification((Resource)notifier, msg);
			}
		}

		ResourceSet getResourceSet() {
			return (ResourceSet)getTarget();
		}

		@Override
		public void setTarget(Notifier newTarget) {
			if((newTarget == null) || (newTarget instanceof ResourceSet)) {
				super.setTarget(newTarget);
			}

			if(newTarget instanceof ResourceSet) {
				// Iterate a defensive copy because other adapters cause concurrent additions by loading additional resources
				for(Resource next : ImmutableList.copyOf(((ResourceSet)newTarget).getResources())) {
					adapt(next);
				}
			} else if(newTarget instanceof Resource) {
				Resource resource = (Resource)newTarget;
				if(resource.isLoaded()) {
					// already loaded? Handled it
					handleResourceLoaded(resource);
				}
			}
		}

		@Override
		public void unsetTarget(Notifier oldTarget) {
			if(oldTarget == getResourceSet()) {
				for(Resource next : getResourceSet().getResources()) {
					unadapt(next);
				}
			}

			super.unsetTarget(oldTarget);
		}

		protected void adapt(Notifier notifier) {
			if(!notifier.eAdapters().contains(this)) {
				notifier.eAdapters().add(this);
			}
		}

		protected void unadapt(Notifier notifier) {
			notifier.eAdapters().remove(this);
		}

		protected void handleNotification(ResourceSet rset, Notification msg) {
			switch(msg.getFeatureID(ResourceSet.class)) {
			case ResourceSet.RESOURCE_SET__RESOURCES:
				switch(msg.getEventType()) {
				case Notification.ADD:
					adapt((Resource)msg.getNewValue());
					break;
				case Notification.ADD_MANY:
					for(Object next : (Collection<?>)msg.getNewValue()) {
						adapt((Resource)next);
					}
					break;
				}
				break;
			}
		}

		protected void handleNotification(Resource resource, Notification msg) {
			switch(msg.getFeatureID(Resource.class)) {
			case Resource.RESOURCE__IS_LOADED:
				if(msg.getNewBooleanValue()) {
					handleResourceLoaded(resource);
				}
				break;
			}
		}
	}
}
