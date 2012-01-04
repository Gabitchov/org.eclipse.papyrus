/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.providers;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.infra.emf.providers.GraphicalModelExplorerBasedContentProvider;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * this content provider is specific for UML, it specifies getvalidValue by taking in account stereotypes
 * 
 */
public class UMLElementMEBContentProvider extends GraphicalModelExplorerBasedContentProvider {

	public UMLElementMEBContentProvider(EObject semanticRoot, String historyId) {
		super(semanticRoot, historyId);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.modelexplorer.widgets.EclassModelExplorerBasedContentProvider#isValidValue(java.lang.Object)
	 * 
	 */
	@Override
	public boolean isValidValue(Object element) {

		if(metaClassWanted != null) {
			EObject semanticObject = null;
			if(element instanceof IAdaptable) {
				semanticObject = (EObject)brige.getSemanticElement(element);
			}
			if(element instanceof EObject) {
				semanticObject = (EObject)element;
			}
			//return false for Ereference
			if(element instanceof EReference || semanticObject instanceof EReference) {
				return false;
			}

			//this is a Eclass
			if(semanticObject != null) {
				if(metaClassWanted instanceof EClass) {
					if(((EClass)metaClassWanted).isSuperTypeOf(semanticObject.eClass())) {
						if(metaClassNotWantedList.size() > 0) {
							Iterator<Object> iternotwanted = metaClassNotWantedList.iterator();
							while(iternotwanted.hasNext()) {
								Object notWanted = iternotwanted.next();
								if(notWanted instanceof EClass) {
									if(((EClass)notWanted).isSuperTypeOf(semanticObject.eClass())) {
										return false;
									}
								}
							}
						}
						return true;
					}
				}
				//this is a stereotype (Dynamic profile)
				if(metaClassWanted instanceof Stereotype) {
					if(semanticObject instanceof Element) {
						Element selectedUMLelement = (Element)semanticObject;
						return selectedUMLelement.getAppliedStereotypes().contains(metaClassWanted);
					}
				}
				//This is a Stereotype (Static profile)
				if(metaClassWanted instanceof EClass && !(metaClassWanted instanceof Element)) {
					if(semanticObject instanceof Element) {
						Element selectedUMLElement = (Element)semanticObject;
						for(EObject stereotypeApplication : selectedUMLElement.getStereotypeApplications()) {
							if(((EClass)metaClassWanted).isInstance(stereotypeApplication)) {
								return true;
							}
						}
					}
				}
			}
			return false;
		}

		return super.isValidValue(element);
	}

	@Override
	public Object getAdaptedValue(Object selection) {
		selection = super.getAdaptedValue(selection);
		if(isStereotype() && selection instanceof Element) {
			Element element = (Element)selection;
			EObject stereotypeApplication = null;
			if(metaClassWanted instanceof Stereotype) { //Dynamic profile
				stereotypeApplication = element.getStereotypeApplication((Stereotype)metaClassWanted);
				if(stereotypeApplication == null) {
					List<Stereotype> subStereotypes = element.getAppliedSubstereotypes((Stereotype)metaClassWanted);
					for(Stereotype subSteretoype : subStereotypes) {
						stereotypeApplication = element.getStereotypeApplication(subSteretoype);
						if(stereotypeApplication != null) {
							break;
						}
					}
				}
			} else { //Static profile
				for(EObject appliedStereotype : element.getStereotypeApplications()) {
					if(((EClass)metaClassWanted).isInstance(appliedStereotype)) {
						stereotypeApplication = appliedStereotype;
					}
				}
			}

			if(stereotypeApplication != null) {
				return stereotypeApplication;
			}
		}
		return selection;
	}

	@Override
	public Object getContainerValue(Object selection) {
		Object semanticElement = selection;;
		if(isStereotype() && selection instanceof EObject) {
			if(selection instanceof EObject) {
				semanticElement = UMLUtil.getBaseElement((EObject)selection);
			}
		}
		return super.getContainerValue(semanticElement);
	}

	protected boolean isStereotype() {
		boolean isStereotype = metaClassWanted instanceof Stereotype;
		boolean isUMLElement = false;
		if(metaClassWanted instanceof EClass) {
			EClass eClass = (EClass)metaClassWanted;
			isUMLElement = eClass.getEAllSuperTypes().contains(UMLPackage.eINSTANCE.getElement()) || eClass == UMLPackage.eINSTANCE.getElement();
		}

		return isStereotype || !isUMLElement;
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		super.inputChanged(viewer, oldInput, newInput);
		if(this.viewer != null) {
			this.viewer.setFilters(new ViewerFilter[]{ new UMLHierarchicViewerFilter(this) });
		}
	}

	//	@Override
	//	protected IStructuredContentProvider getMetamodelContentProvider() {
	//		return new ProfileContentProvider();
	//	}
	//
	//	@Override
	//	protected IStructuredContentProvider getMetaclassContentProvider() {
	//		return new StereotypeContentProvider(metaClassWanted, metaClassNotWantedList);
	//	}
	//
	//	@Override
	//	protected ViewerFilter getMetaclassViewerFilter(Object selectedMetaClass) {
	//		return new StereotypeViewerFilter(selectedMetaClass);
	//	}
}
