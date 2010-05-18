/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.tabbed.customization.dialog;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.properties.runtime.view.PropertyViewService;
import org.eclipse.papyrus.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.properties.runtime.view.constraints.ObjectTypeConstraintDescriptor;
import org.eclipse.papyrus.properties.tabbed.core.view.DynamicSectionDescriptor;
import org.eclipse.papyrus.properties.tabbed.core.view.IPropertyTabViewProvider;
import org.eclipse.ui.views.properties.tabbed.ISectionDescriptor;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;


/**
 * Content Provider for the metamodel viewer. It will display the metaclass elements, and the section sets that are available for these elements
 */
public class MetamodelContentProvider implements ITreeContentProvider {

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		// nothing to do here
	}

	/**
	 * {@inheritDoc}
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// nothing to do here
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getElements(Object inputElement) {
		if(inputElement instanceof EPackage) {
			return ((EPackage)inputElement).getEClassifiers().toArray();
		} else if(inputElement instanceof EObject) {
			return ((EObject)inputElement).eContents().toArray();
		} else if(inputElement instanceof List<?>) {
			return ((List<?>)inputElement).toArray();
		}
		return new Object[0];

	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getChildren(Object parentElement) {
		if(parentElement instanceof EClass) {
			List<DynamicSectionDescriptor> descriptors = new ArrayList<DynamicSectionDescriptor>();
			String qualifiedInstanceClassName = ((EClassifier)parentElement).getInstanceClassName();
			Class<?> metamodelClass;
			try {
				metamodelClass = Class.forName(qualifiedInstanceClassName);
			} catch (ClassNotFoundException e) {
				// Activator.log.error(e);
				return new Object[0];
			}

			// populate the section sets



			// find actions sets valid for this instance class
			List<?> providers = PropertyViewService.getInstance().findAllProviders();
			for(Object provider : providers) {
				if(provider instanceof PropertyViewService.ProviderDescriptor) {
					IProvider providerDescriptor = (IProvider)((PropertyViewService.ProviderDescriptor)provider).getProvider();
					if(providerDescriptor instanceof IPropertyTabViewProvider) {

						// get the list of all tab descriptors, which gives access to all section descriptors
						// we will then have access to the section for the given element
						List<ITabDescriptor> tabDescriptors = ((IPropertyTabViewProvider)providerDescriptor).getTabDescriptors();
						for(ITabDescriptor tabDescriptor : tabDescriptors) {
							List<ISectionDescriptor> sectionDescriptors = tabDescriptor.getSectionDescriptors();
							for(ISectionDescriptor sectionDescriptor : sectionDescriptors) {
								if(sectionDescriptor instanceof DynamicSectionDescriptor) {
									DynamicSectionDescriptor dynamicSectionDescriptor = (DynamicSectionDescriptor)sectionDescriptor;
									List<IConstraintDescriptor> constraintDescriptors = dynamicSectionDescriptor.getConstraints();
									for(IConstraintDescriptor constraintDescriptor : constraintDescriptors) {
										if(constraintDescriptor instanceof ObjectTypeConstraintDescriptor) {
											Class<?> elementClass = ((ObjectTypeConstraintDescriptor)constraintDescriptor).getElementClass();
											if(elementClass.isAssignableFrom(metamodelClass)) {
												descriptors.add(dynamicSectionDescriptor);
											}
										}
									}

								}
							}
						}
					}
				}
			}
			return descriptors.toArray();
		}
		return new Object[0];
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getParent(Object element) {
		if(element instanceof EClassifier) {
			return ((EClassifier)element).getEPackage();
		} else if(element instanceof EObject) {
			return ((EObject)element).eContainer();
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasChildren(Object element) {
		Object[] children = getChildren(element);
		return children != null && children.length > 0;
	}

}
