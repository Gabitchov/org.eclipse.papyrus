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
package org.eclipse.papyrus.views.properties.tabbed.customization.dialog;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizableModelContentProvider;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ModelElementItem;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.core.utils.FilteredCollectionView;
import org.eclipse.papyrus.infra.core.utils.IFilter;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.AppliedStereotypeConstraintDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.ObjectTypeConstraintDescriptor;
import org.eclipse.papyrus.views.properties.tabbed.core.view.SectionSetDescriptorState;
import org.eclipse.papyrus.views.properties.tabbed.customization.Activator;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;


/**
 * Content Provider for the metamodel viewer. It will display the metaclass elements, and the section sets that are available for these elements
 */
@SuppressWarnings("restriction")
public class MetamodelContentProvider extends CustomizableModelContentProvider implements PropertyChangeListener {

	/** list of available section sets */
	protected final List<SectionSetDescriptorState> availableSectionSets;

	/** metamodel tree viewer */
	private TreeViewer fViewer;

	/**
	 * Creates a new MetamodelContentProvider.
	 */
	public MetamodelContentProvider(List<SectionSetDescriptorState> availableSectionSets) {
		super(Activator.getDefault().getCustomizationManager());
		this.availableSectionSets = availableSectionSets;
		for(SectionSetDescriptorState state : availableSectionSets) {
			state.addPropertyChangeListener(this);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		super.inputChanged(viewer, oldInput, newInput);
		fViewer = (TreeViewer)viewer;
	}


	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EObject[] getRootElements(Object inputElement) {
		if(inputElement instanceof EPackage) {
			return ((EPackage)inputElement).getEClassifiers().toArray(new EClassifier[]{});
		} else if(inputElement instanceof Profile) {
			return ((Profile)inputElement).getOwnedStereotypes().toArray(new EObject[]{});
		} else if(inputElement instanceof EObject) {
			return ((EObject)inputElement).eContents().toArray(new EObject[]{});
		} else if(inputElement instanceof List<?>) {
			List<EClassifier> objects = new ArrayList<EClassifier>();
			objects.addAll((List<EClassifier>)inputElement);
			//order the list by name, if required ?
			Collections.sort(objects, new Comparator<EClassifier>() {

				/**
				 * {@inheritDoc}
				 */
				public int compare(EClassifier o1, EClassifier o2) {
					if(o1.getName() == null) {
						return 0;
					}
					return o1.getName().compareTo(o2.getName());
				}

			});
			return objects.toArray(new EObject[]{});
		}
		return new EObject[0];

	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getChildren(Object parentElement) {
		if(parentElement instanceof ModelElementItem) {
			if(((ModelElementItem)(parentElement)).getEObject() instanceof EClassifier) {
				EClassifier parentClassifier = (EClassifier)((ModelElementItem)(parentElement)).getEObject();
				// List<SectionSetDescriptorState> sectionSetDescriptorStates = new ArrayList<SectionSetDescriptorState>();
				String qualifiedInstanceClassName = parentClassifier.getInstanceClassName();
				try {
					final Class<?> metamodelClass = Class.forName(qualifiedInstanceClassName);

					// populate the section sets
					FilteredCollectionView<SectionSetDescriptorState> filteredList = new FilteredCollectionView<SectionSetDescriptorState>(availableSectionSets, new IFilter() {

						/**
						 * {@inheritDoc}
						 */
						public boolean isAllowed(Object object) {
							if(object instanceof SectionSetDescriptorState) {
								List<IConstraintDescriptor> constraintDescriptors = ((SectionSetDescriptorState)object).getDescriptor().getConstraintDescriptors();
								for(IConstraintDescriptor constraintDescriptor : constraintDescriptors) {
									if(constraintDescriptor instanceof ObjectTypeConstraintDescriptor) {
										Class<?> elementClass = ((ObjectTypeConstraintDescriptor)constraintDescriptor).getElementClass();
										if(elementClass.isAssignableFrom(metamodelClass)) {
											return true;
										}
									}
								}
							}
							return false;
						}

					});
					return filteredList.toArray();

				} catch (ClassNotFoundException e) {
					// Activator.log.error(e);
					return new Object[0];
				}

			} else if(((ModelElementItem)(parentElement)).getEObject() instanceof Stereotype) {
				final Stereotype parentStereotype = (Stereotype)((ModelElementItem)(parentElement)).getEObject();
				// List<SectionSetDescriptorState> sectionSetDescriptorStates = new ArrayList<SectionSetDescriptorState>();
				// populate the section sets
				FilteredCollectionView<SectionSetDescriptorState> filteredList = new FilteredCollectionView<SectionSetDescriptorState>(availableSectionSets, new IFilter() {

					/**
					 * {@inheritDoc}
					 */
					public boolean isAllowed(Object object) {
						if(object instanceof SectionSetDescriptorState) {
							List<IConstraintDescriptor> constraintDescriptors = ((SectionSetDescriptorState)object).getDescriptor().getConstraintDescriptors();
							for(IConstraintDescriptor constraintDescriptor : constraintDescriptors) {
								if(constraintDescriptor instanceof AppliedStereotypeConstraintDescriptor) {
									List<String> stereotypeNames = ((AppliedStereotypeConstraintDescriptor)constraintDescriptor).getStereotypeQualifiedNames();
									// look only for the first one, this could lead to bugs...
									if(stereotypeNames.size() > 0) {
										String stereotypeName = stereotypeNames.get(0);
										// we have the stereotype qualified name. Now, should check if it fits to the current stereotype or one of its parent
										if(stereotypeName.equals(parentStereotype.getQualifiedName())) {
											return true;
										}
										// check in the general stereotypes list
										List<Stereotype> generalStereotypes = StereotypeUtil.getAllSuperStereotypes(parentStereotype);
										for(Stereotype stereotype : generalStereotypes) {
											if(stereotypeName.equals(stereotype.getQualifiedName())) {
												return true;
											}
										}
									}

								}
							}
						}
						return false;
					}

				});
				return filteredList.toArray();
			}
		}

		return new Object[0];
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasChildren(Object element) {
		// force computation, instead of returning true as treeElement.hasChildren() does.
		Object[] children = getChildren(element);
		return children != null && children.length > 0;
	}

	/**
	 * {@inheritDoc}
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getSource() instanceof SectionSetDescriptorState) {
			((TreeViewer)fViewer).refresh(true);
		}
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		for(SectionSetDescriptorState state : availableSectionSets) {
			state.removePropertyChangeListener(this);
		}
		super.dispose();
	}
}
