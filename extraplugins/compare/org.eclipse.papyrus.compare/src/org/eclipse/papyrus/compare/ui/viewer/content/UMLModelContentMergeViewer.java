/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.compare.ui.viewer.content;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.ui.TypedElementWrapper;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.emf.compare.ui.viewer.content.part.IModelContentMergeViewerTab;
import org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder;
import org.eclipse.emf.compare.ui.viewer.content.part.diff.ModelContentMergeDiffTab;
import org.eclipse.emf.compare.ui.viewer.content.part.property.ModelContentMergePropertyTab;
import org.eclipse.emf.compare.ui.viewer.content.part.property.PropertyContentProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.papyrus.compare.UMLCompareUtils;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;
import org.eclipse.uml2.uml.edit.providers.UMLReflectiveItemProviderAdapterFactory;
import org.eclipse.uml2.uml.edit.providers.UMLResourceItemProviderAdapterFactory;
import org.eclipse.uml2.uml.util.UMLUtil;


public class UMLModelContentMergeViewer extends ModelContentMergeViewer {

	public UMLModelContentMergeViewer(Composite parent, CompareConfiguration config) {
		super(parent, config);
	}

	protected ModelContentMergeTabFolder createModelContentMergeTabFolder(Composite composite, int side) {
		return new ModelContentMergeTabFolder(this, composite, side) {

			protected IModelContentMergeViewerTab createModelContentMergeDiffTab(Composite parent) {
				ModelContentMergeDiffTab diffTab = new ModelContentMergeDiffTab(parent, partSide, this) {
					protected void setSelectionToWidget(List l, boolean reveal) {
						List result = new ArrayList();
						for (Object next: l) {
							if (next instanceof EObject && UMLCompareUtils.isStereotypeApplication((EObject)next)) {
								EObject stereotypeApplication = (EObject)next;
								result.add(UMLUtil.getBaseElement(stereotypeApplication));
							} else {
								result.add(next);
							}
						}
						super.setSelectionToWidget(result, reveal);
					}

				};
				
				diffTab.setContentProvider(createDiffTabContentProvider());
				return diffTab;
			}
			
			protected IModelContentMergeViewerTab createModelContentMergeViewerTab(Composite parent) {
				ModelContentMergePropertyTab propertyTab = new ModelContentMergePropertyTab(parent, partSide, this);
				propertyTab.setContentProvider(createPropertyTabContentProvider());
				return propertyTab;
			}

		};
	}
	
	protected IContentProvider createDiffTabContentProvider() {
		List<AdapterFactory> factories = new ArrayList<AdapterFactory>();
		factories.add(new UMLResourceItemProviderAdapterFactory());
		factories.add(new UMLItemProviderAdapterFactory());
		factories.add(new EcoreItemProviderAdapterFactory());
		factories.add(new UMLReflectiveItemProviderAdapterFactory());

		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(factories);
		
		return new AdapterFactoryContentProvider(adapterFactory);
	}
	
	protected IContentProvider createPropertyTabContentProvider() {
		return new PropertyContentProvider() {
			public Object[] getElements(Object inputElement) {
				// init inputObject value
				super.getElements(inputElement);
				Object[] elements = new Object[] {};
				if (getInputEObject() != null) {
					final List<List<Object>> inputElements = new ArrayList<List<Object>>();
					// This will fetch the property source of the input object
					List<AdapterFactory> factories = new ArrayList<AdapterFactory>();
					factories.add(new UMLResourceItemProviderAdapterFactory());
					factories.add(new UMLItemProviderAdapterFactory());
					factories.add(new EcoreItemProviderAdapterFactory());
					factories.add(new UMLReflectiveItemProviderAdapterFactory());

					ComposedAdapterFactory factory = new ComposedAdapterFactory(factories);

					final IItemPropertySource inputPropertySource = (IItemPropertySource)factory.adapt(getInputEObject(),
							IItemPropertySource.class);
					// Iterates through the property descriptor to display only the "property" features of the input
					// object
					for (final IItemPropertyDescriptor descriptor : inputPropertySource
							.getPropertyDescriptors(getInputEObject())) {
						/*
						 * Filtering out "advanced" properties can be done by hiding properties on which
						 * Arrays.binarySearch(descriptor.getFilterFlags(input),
						 * "org.eclipse.ui.views.properties.expert") returns an int > 0.
						 */
						final EStructuralFeature feature = (EStructuralFeature)descriptor.getFeature(getInputEObject());
						final List<Object> row = new ArrayList<Object>();
						row.add(feature);
						row.add(getInputEObject().eGet(feature));
						inputElements.add(row);
					}

					elements = inputElements.toArray();
					Arrays.sort(elements, new Comparator<Object>() {
						public int compare(Object first, Object second) {
							final String name1 = ((EStructuralFeature)((List<?>)first).get(0)).getName();
							final String name2 = ((EStructuralFeature)((List<?>)second).get(0)).getName();

							return name1.compareTo(name2);
						}
					});
				}
				return elements;
			}
		};
		
	}
	
	/**
	 * @author tatiana
	 *
	 */
	class ModelContentMergeDiffTabContentProvider extends AdapterFactoryContentProvider {
		/**
		 * Default constructor. Delegates to the super implementation.
		 * 
		 * @param factory
		 *            Factory to get labels and icons from.
		 */
		public ModelContentMergeDiffTabContentProvider(AdapterFactory factory) {
			super(factory);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getElements(java.lang.Object)
		 */
		@SuppressWarnings("unchecked")
		@Override
		public Object[] getElements(Object object) {
			// overwritten to ensure contents of ResourceSets, List<Resource>, and Resource are correclty
			// returned.
			Object[] result = null;
			if (object instanceof ResourceSet) {
				final List<Resource> resources = ((ResourceSet)object).getResources();
				final List<Resource> elements = new ArrayList<Resource>(resources.size());
				for (final Resource resource : resources) {
					if (resource.getContents().isEmpty()
							|| !(resource.getContents().get(0) instanceof ComparisonSnapshot)) {
						elements.add(resource);
					}
				}
				result = elements.toArray();
			} else if (object instanceof TypedElementWrapper) {
				result = new Object[] {((EObject)object).eResource(), };
			} else if (object instanceof List) {
				// we may also display a list of resources
				result = ((List)object).toArray();
			} else if (object instanceof Resource) {
				// return contents of resource
				return filterStereotypeApplications((Resource)object);
			} else {
				result = super.getElements(object);
			}
			return result;
		}
		
		private Object[] filterStereotypeApplications(Resource object) {
			EList<EObject> contents = object.getContents();
			List<EObject> result = new ArrayList<EObject>();
			for (int i = 0; i < contents.size(); i++) {
				EObject next = contents.get(i);
				if (!UMLCompareUtils.isStereotypeApplication(next)) {
					result.add(next);
				}
			}
			return result.toArray(new Object[result.size()]);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getChildren(java.lang.Object)
		 */
		@Override
 		public Object[] getChildren(Object object) {
 			if (object instanceof Resource) {
				// return ((Resource)object).getContents().toArray();
				return new Object[] {((Resource)object).getContents().get(0) };
 			}
			ArrayList<Object> result = new ArrayList<Object>();
			result.addAll(Arrays.asList(super.getChildren(object)));
			result.addAll(getStereotypeApplications(object));
			return result.toArray(new Object[result.size()]);
		}

		private List<EObject> getStereotypeApplications(Object eObject) {
			if (eObject instanceof Element) {
				return ((Element)eObject).getStereotypeApplications();
			}
			return Collections.emptyList();
 		}
		

		/**
		 *{@inheritDoc}
		 * 
		 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#hasChildren(java.lang.Object)
		 */
		@Override
 		public boolean hasChildren(Object object) {
			return getChildren(object).length > 0;
 		}

	}

}
