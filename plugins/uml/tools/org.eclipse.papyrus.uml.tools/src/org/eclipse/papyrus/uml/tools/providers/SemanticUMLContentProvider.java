/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.providers;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.providers.strategy.SemanticEMFContentProvider;
import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * A semantic Hierarchic Content Provider for UML
 * 
 * @author Camille Letavernier
 */
public class SemanticUMLContentProvider extends SemanticEMFContentProvider {


	public SemanticUMLContentProvider() {
		//Empty (@see #inputChanged(Viewer, Object, Object))
	}

	public SemanticUMLContentProvider(EObject editedEObject, EStructuralFeature feature, EObject[] roots) {
		super(editedEObject, feature, roots);
	}

	public SemanticUMLContentProvider(EObject editedEObject, EStructuralFeature feature) {
		this(editedEObject, feature, findRoots(editedEObject));
	}

	public SemanticUMLContentProvider(EObject[] roots) {
		super(roots);
	}

	public SemanticUMLContentProvider(ResourceSet root) {
		this(null, null, root);
	}

	public SemanticUMLContentProvider(EObject editedEObject, EStructuralFeature feature, ResourceSet root) {
		this(editedEObject, feature, getRoots(root));
		listenOnResourceSet(root);
	}

	protected static EObject[] findRoots(EObject source) {
		if(source.eResource() == null || source.eResource().getResourceSet() == null) {
			return SemanticEMFContentProvider.findRoots(source);
		}

		//We have a full resourceSet : we return its contents
		return getRoots(source.eResource().getResourceSet());
	}

	protected static EObject[] getRoots(ResourceSet root) {
		EObject rootElement = null;

		if(root instanceof ModelSet) {
			ModelSet modelSet = (ModelSet)root;
			UmlModel umlModel = (UmlModel)modelSet.getModel(UmlModel.MODEL_ID);
			if(umlModel != null) {
				try {
					rootElement = umlModel.lookupRoot();
				} catch (NotFoundException ex) {
					//Ignore and treat the ModelSet as a standard resource set
				}
			}
		}

		List<EObject> rootElements = new LinkedList<EObject>();
		for(Resource resource : root.getResources()) {
			if(isUMLModel(resource, rootElement)) {
				for(EObject rootEObject : resource.getContents()) {
					if(rootEObject instanceof Element) {
						rootElements.add(rootEObject);
					}
				}
			}
		}
		return rootElements.toArray(new EObject[0]);

		//		if(root instanceof ModelSet) {
		//			ModelSet modelSet = (ModelSet)root;
		//TODO : Find all semantic roots, including Models and Libraries
		//This is related to the ModelSet evolution
		//			try {
		//				EObject rootElement = UmlUtils.getUmlModel(modelSet).lookupRoot();
		//				if(rootElement == null) {
		//					return new EObject[0];
		//				}
		//
		//				Resource rootResource = rootElement.eResource();
		//				if(rootResource == null) {
		//					return new EObject[]{ rootElement };
		//				}
		//
		//				List<EObject> rootObjects = new LinkedList<EObject>();
		//				for(EObject rootObject : rootResource.getContents()) {
		//					if(rootObject instanceof Element) {
		//						rootObjects.add(rootObject);
		//					}
		//				}
		//
		//				if(rootObjects.isEmpty()) {
		//					return new EObject[]{ rootElement };
		//				}
		//
		//				return rootObjects.toArray(new EObject[0]);
		//			} catch (NotFoundException ex) {
		//				Activator.log.error(ex);
		//			}
		//		}
		//
		//return SemanticEMFContentProvider.getRoots(root);
	}

	//	protected static URI[] excludedModels = new URI[0];

	//TODO: Currently, some resources are explicitly excluded.
	//We need more use cases and user feedback to determine how we should filter them
	protected static URI[] excludedModels = new URI[]{
		//		URI.createURI(UMLResource.STANDARD_L2_PROFILE_URI),
		//		URI.createURI(UMLResource.STANDARD_L3_PROFILE_URI),
	URI.createURI(UMLResource.UML_METAMODEL_URI), URI.createURI(UMLResource.ECORE_METAMODEL_URI)
	//		URI.createURI(UMLResource.ECORE_PRIMITIVE_TYPES_LIBRARY_URI)
	};

	protected static boolean isUMLModel(Resource resource, EObject rootElement) {
		if(!isUMLResource(resource)) {
			return false;
		}

		for(URI uri : excludedModels) {
			if(uri.equals(resource.getURI())) {
				return false;
			}
		}

		for(EObject rootObject : resource.getContents()) {
			if(rootObject.eContainer() != null) { //Controlled element
				return false;
			}

			if(rootObject instanceof Profile && !(rootElement instanceof Profile)) {
				return false;
			}
		}

		return true;
	}

	protected static boolean isUMLResource(Resource resource) {
		if(resource instanceof UMLResource) {
			return true;
		}

		URI uri = resource.getURI();
		return (uri != null && UMLResource.FILE_EXTENSION.equals(uri.fileExtension()));
	}

	@Override
	protected boolean isCompatibleMetaclass(Object containerElement, Object metaclass) {
		Element semanticElement = UMLUtil.resolveUMLElement(containerElement);

		if(semanticElement == null) {
			return false;
		}

		if(metaclass instanceof Stereotype) {
			Stereotype stereotype = (Stereotype)metaclass;
			boolean res = semanticElement.getAppliedStereotype(stereotype.getQualifiedName()) != null;
			if(!res) {
				EClass definition = stereotype.getDefinition();
				for(EObject e : semanticElement.getStereotypeApplications()) {
					EClass c = e.eClass();
					if(definition != null && definition.isSuperTypeOf(c)) {
						res = true;
						break;
					}
				}
			}
			return res;
		}

		//TODO : We should use super.isCompatibleMetaclass(), but the super-implementation
		//may not be compatible with our implementation of getAdaptedValue()
		if(metaclass instanceof EClassifier) {
			return ((EClassifier)metaclass).isInstance(semanticElement);
		}

		return false;
	}

	/**
	 * This method should return either the StereotypeApplication (For Sto - Sto associations),
	 * or the UML Element (For Sto - UML associations)
	 * 
	 * This depends on the wanted metaclass.
	 */
	//TODO : In some cases, we may have a filter based on both a UML Metaclass and a Stereotype
	//In such a specific case, a specific implementation is probably needed
	//
	//This case may especially occur in the case of dynamic creation of stereotype associations.
	@Override
	public Object getAdaptedValue(Object containerElement) {
		Object semanticElement = super.getAdaptedValue(containerElement);

		if(semanticElement instanceof Element) {
			Element element = (Element)semanticElement;
			//Looks for a compatible Stereotype application
			for(Object metaclassWanted : getWantedMetaclasses()) {

				if(metaclassWanted instanceof Stereotype) {
					EObject stereotypeApplication = null;

					stereotypeApplication = element.getStereotypeApplication((Stereotype)metaclassWanted);
					if(stereotypeApplication == null) {
						List<Stereotype> subStereotypes = element.getAppliedSubstereotypes((Stereotype)metaclassWanted);
						for(Stereotype subSteretoype : subStereotypes) {
							stereotypeApplication = element.getStereotypeApplication(subSteretoype);
							if(stereotypeApplication != null) {
								break;
							}
						}
					}

					if(stereotypeApplication != null) {
						return stereotypeApplication;
					}
				}
			}
		}

		//If no stereotype application is found, return the UML Element
		return semanticElement;
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		ResourceSet resourceSet = root;

		if(newInput instanceof ResourceSet) {
			resourceSet = (ResourceSet)newInput;
		} else if(newInput instanceof ServicesRegistry) {
			try {
				resourceSet = ServiceUtils.getInstance().getModelSet((ServicesRegistry)newInput);
			} catch (Exception ex) {
				Activator.log.error(ex);
			}
		}

		listenOnResourceSet(resourceSet);

		this.viewer = viewer;

		super.inputChanged(viewer, oldInput, newInput);
	}

	protected void listenOnResourceSet(ResourceSet resourceSet) {
		if(this.root != null) {
			this.root.eAdapters().remove(resourceSetListener);
		}

		if(resourceSet != null) {
			this.root = resourceSet;
			resourceSet.eAdapters().add(resourceSetListener);
			this.roots = getRoots(root);
		}
	}

	private ResourceSet root;

	private Viewer viewer;

	private Adapter resourceSetListener = new AdapterImpl() {

		private boolean needsRefresh = false;

		@Override
		public void notifyChanged(Notification msg) {
			if(root == null || msg.isTouch()) {
				return;
			}

			if(msg.getNotifier() instanceof ResourceSet) {
				notifyResourceSetChanged(msg);
			} else if(msg.getNotifier() instanceof Resource) {
				notifyResourceChanged(msg);
			}
		};

		private void notifyResourceSetChanged(Notification msg) {
			switch(msg.getEventType()) {
			case Notification.ADD:
			case Notification.ADD_MANY:
				//Action for ADD and ADD_MANY
				Object value = msg.getNewValue();
				if(value instanceof Resource) {
					Resource resource = (Resource)value;
					resource.eAdapters().add(this);
				} else if(value instanceof List<?>) {
					List<?> list = (List<?>)value;
					for(Object element : list) {
						if(element instanceof Resource) {
							((Resource)element).eAdapters().add(this);
						}
					}
				}

				//do not break the switch: we keep going with the following instructions (refresh the viewer)
			case Notification.REMOVE:
			case Notification.REMOVE_MANY:
				//Actions for ADD, ADD_MANY, REMOVE, REMOVE_MANY
				triggerRefresh();
				break;
			}
		}

		private void notifyResourceChanged(Notification msg) {
			switch(msg.getEventType()) {
			case Notification.ADD:
			case Notification.ADD_MANY:
			case Notification.REMOVE:
			case Notification.REMOVE_MANY:
				triggerRefresh();
			}
		}

		private synchronized void triggerRefresh() {
			roots = getRoots(root);
			//During display, a resource has been loaded (e.g. by a Label provider).
			//Schedule an update (in the future, to avoid conflicts with a potential current update)
			if(viewer != null && viewer.getControl() != null && !viewer.getControl().isDisposed()) {
				needsRefresh = true;
				viewer.getControl().getDisplay().asyncExec(new Runnable() {

					public void run() {
						if(!needsRefresh || viewer == null || viewer.getControl() == null || viewer.getControl().isDisposed()) {
							return;
						}
						needsRefresh = false;
						viewer.refresh();
					};
				});
			}
		}
	};
}
