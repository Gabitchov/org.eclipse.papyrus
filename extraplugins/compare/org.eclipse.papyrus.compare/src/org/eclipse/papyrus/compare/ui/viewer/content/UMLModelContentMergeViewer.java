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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.contentmergeviewer.IMergeViewerContentProvider;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.ui.ModelCompareInput;
import org.eclipse.emf.compare.ui.TypedElementWrapper;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeContentProvider;
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
import org.eclipse.emf.facet.infra.browser.custom.MetamodelView;
import org.eclipse.emf.facet.infra.browser.custom.core.CustomizationsCatalog;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizableModelLabelProvider;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;
import org.eclipse.emf.facet.infra.browser.uicore.internal.AppearanceConfiguration;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ITreeElement;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ModelElementItem;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.papyrus.compare.Activator;
import org.eclipse.papyrus.compare.UMLCompareUtils;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.CompareTwoElementsDiffModel;
import org.eclipse.swt.graphics.Image;
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

	@Override
	public void setInput(Object input) {
		// TODO Auto-generated method stub
		super.setInput(input);
	}

	protected IMergeViewerContentProvider createMergeViewerContentProvider() {
		return new ModelContentMergeContentProvider(configuration) {

			@Override
			public Object getLeftContent(Object element) {
				if(element instanceof ModelCompareInput) {
					// if we compared a complete resource set, we should display the different resources
					final Object diff = ((ModelCompareInput)element).getDiff();
					if(diff instanceof CompareTwoElementsDiffModel) {
						return new RootObject(((CompareTwoElementsDiffModel)diff).getLeftRoots().get(0));
					}
				}
				return super.getLeftContent(element);
			}

			@Override
			public Object getRightContent(Object element) {
				if(element instanceof ModelCompareInput) {
					// if we compared a complete resource set, we should display the different resources
					final Object diff = ((ModelCompareInput)element).getDiff();
					if(diff instanceof CompareTwoElementsDiffModel) {
						return new RootObject(((CompareTwoElementsDiffModel)diff).getRightRoots().get(0));
					}
				}
				return super.getRightContent(element);
			}

		};
	}

	private class RootObject {

		public final Object object;

		public RootObject(Object object) {
			this.object = object;
		}
	}


	protected ModelContentMergeTabFolder createModelContentMergeTabFolder(Composite composite, int side) {
		return new UMLModelContentMergeTabFolder(this, composite, side);
	}

	protected IContentProvider createDiffTabContentProvider() {
		List<AdapterFactory> factories = new ArrayList<AdapterFactory>();
		factories.add(new UMLResourceItemProviderAdapterFactory());
		factories.add(new UMLItemProviderAdapterFactory());
		factories.add(new EcoreItemProviderAdapterFactory());
		factories.add(new UMLReflectiveItemProviderAdapterFactory());

		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(factories);
		AdapterFactoryContentProvider result = new AdapterFactoryContentProvider(adapterFactory) {

			@Override
			public Object[] getElements(Object object) {
				if(object instanceof RootObject) {
					return new Object[]{ ((RootObject)object).object };
				}
				return super.getElements(object);
			}
		};

		return result;
	}

	protected IContentProvider createPropertyTabContentProvider() {
		return new PropertyContentProvider() {

			public Object[] getElements(Object inputElement) {
				// init inputObject value
				super.getElements(inputElement);
				Object[] elements = new Object[]{};
				if(getInputEObject() != null) {
					final List<List<Object>> inputElements = new ArrayList<List<Object>>();
					// This will fetch the property source of the input object
					List<AdapterFactory> factories = new ArrayList<AdapterFactory>();
					factories.add(new UMLResourceItemProviderAdapterFactory());
					factories.add(new UMLItemProviderAdapterFactory());
					factories.add(new EcoreItemProviderAdapterFactory());
					factories.add(new UMLReflectiveItemProviderAdapterFactory());

					ComposedAdapterFactory factory = new ComposedAdapterFactory(factories);

					final IItemPropertySource inputPropertySource = (IItemPropertySource)factory.adapt(getInputEObject(), IItemPropertySource.class);
					// Iterates through the property descriptor to display only the "property" features of the input
					// object
					for(final IItemPropertyDescriptor descriptor : inputPropertySource.getPropertyDescriptors(getInputEObject())) {
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
		 *        Factory to get labels and icons from.
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
			if(object instanceof ResourceSet) {
				final List<Resource> resources = ((ResourceSet)object).getResources();
				final List<Resource> elements = new ArrayList<Resource>(resources.size());
				for(final Resource resource : resources) {
					if(resource.getContents().isEmpty() || !(resource.getContents().get(0) instanceof ComparisonSnapshot)) {
						elements.add(resource);
					}
				}
				result = elements.toArray();
			} else if(object instanceof TypedElementWrapper) {
				result = new Object[]{ ((EObject)object).eResource(), };
			} else if(object instanceof List) {
				// we may also display a list of resources
				result = ((List)object).toArray();
			} else if(object instanceof Resource) {
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
			for(int i = 0; i < contents.size(); i++) {
				EObject next = contents.get(i);
				if(!UMLCompareUtils.isStereotypeApplication(next)) {
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
			if(object instanceof Resource) {
				// return ((Resource)object).getContents().toArray();
				return new Object[]{ ((Resource)object).getContents().get(0) };
			}
			ArrayList<Object> result = new ArrayList<Object>();
			result.addAll(Arrays.asList(super.getChildren(object)));
			result.addAll(getStereotypeApplications(object));
			return result.toArray(new Object[result.size()]);
		}

		private List<EObject> getStereotypeApplications(Object eObject) {
			if(eObject instanceof Element) {
				return ((Element)eObject).getStereotypeApplications();
			}
			return Collections.emptyList();
		}


		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#hasChildren(java.lang.Object)
		 */
		@Override
		public boolean hasChildren(Object object) {
			return getChildren(object).length > 0;
		}

	}

	public class ExtendedLabelProvider extends CustomizableModelLabelProvider {

		private final CustomizationManager customizationManager2;

		private AppearanceConfiguration configuration;

		/**
		 * Constructor.
		 * 
		 * @param customizationManager
		 */
		public ExtendedLabelProvider(CustomizationManager customizationManager) {
			super(customizationManager);
			customizationManager2 = customizationManager;

			configuration = getAppearanceConfiguration();
		}

		private AppearanceConfiguration getAppearanceConfiguration() {
			Method getApperanceConfigurationMethod;
			try {
				getApperanceConfigurationMethod = CustomizationManager.class.getDeclaredMethod("getAppearanceConfiguration");
				if(getApperanceConfigurationMethod != null) {
					getApperanceConfigurationMethod.setAccessible(true);
					return (AppearanceConfiguration)getApperanceConfigurationMethod.invoke(customizationManager2);
				}
			} catch (SecurityException e) {
				Activator.log.error(e);
			} catch (NoSuchMethodException e) {
				Activator.log.error(e);
			} catch (IllegalArgumentException e) {
				Activator.log.error(e);
			} catch (IllegalAccessException e) {
				Activator.log.error(e);
			} catch (InvocationTargetException e) {
				Activator.log.error(e);
			}
			return new AppearanceConfiguration(null); // default one.
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getText(Object element) {
			if(element == null) {
				return "";
			}
			if(element instanceof EObject) {
				ITreeElement treeElement = getTreeElement((EObject)element);
				return super.getText(treeElement);
			}
			return super.getText(element);
		}

		@Override
		public Image getImage(Object element) {
			if(element == null) {
				return null;
			}
			if(element instanceof EObject) {
				ITreeElement treeElement = getTreeElement((EObject)element);
				return super.getImage(treeElement);
			}
			return super.getImage(element);
		}


		/**
		 * @param eObject
		 * @return
		 */
		private ITreeElement getTreeElement(EObject eObject) {
			if(eObject == null) {
				return null;
			}
			return new ModelElementItem(eObject, getTreeElement(eObject.eContainer()), configuration);
		}
	}

	private class UMLModelContentMergeTabFolder extends ModelContentMergeTabFolder {

		private CustomizationManager manager;

		private ExtendedLabelProvider labelProvider2;

		public UMLModelContentMergeTabFolder(ModelContentMergeViewer viewer, Composite composite, int side) {
			super(viewer, composite, side);
		}

		protected IModelContentMergeViewerTab createModelContentMergeDiffTab(Composite parent) {
			UMLModelContentMergeDiffTab diffTab = new UMLModelContentMergeDiffTab(parent, partSide, this);
			diffTab.setContentProvider(createDiffTabContentProvider());
			initCustomizationManager();
			diffTab.setLabelProvider(labelProvider2);
			return diffTab;

		}

		protected void initCustomizationManager() {
			manager = new CustomizationManager();
			try {
				List<MetamodelView> registryDefaultCustomizations = CustomizationsCatalog.getInstance().getRegistryDefaultCustomizations();
				for(MetamodelView metamodelView : registryDefaultCustomizations) {
					manager.registerCustomization(metamodelView);
				}
				manager.loadCustomizations();

			} catch (Throwable e) {
				Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error initializing customizations", e)); //$NON-NLS-1$
			}
			manager.setShowFullQualifiedNames(true);
			manager.setShowURI(true);
			manager.setShowDerivedLinks(false);
			labelProvider2 = new ExtendedLabelProvider(manager);
		}



		protected IModelContentMergeViewerTab createModelContentMergeViewerTab(Composite parent) {
			ModelContentMergePropertyTab propertyTab = new ModelContentMergePropertyTab(parent, partSide, this);
			propertyTab.setContentProvider(createPropertyTabContentProvider());
			return propertyTab;
		}



	}


	private static class UMLModelContentMergeDiffTab extends ModelContentMergeDiffTab {

		public UMLModelContentMergeDiffTab(Composite parentComposite, int side, ModelContentMergeTabFolder parentFolder) {
			super(parentComposite, side, parentFolder);
		}

		protected void setSelectionToWidget(List l, boolean reveal) {
			List result = new ArrayList();
			for(Object next : l) {
				if(next instanceof EObject && UMLCompareUtils.isStereotypeApplication((EObject)next)) {
					EObject stereotypeApplication = (EObject)next;
					result.add(UMLUtil.getBaseElement(stereotypeApplication));
				} else {
					result.add(next);
				}
			}
			super.setSelectionToWidget(result, reveal);
		}

		public void setReflectiveInput(Object object) {
			// We *need* to invalidate the cache here since setInput() would try to
			// use it otherwise
			clearCaches();

			// setLabelProvider(createLabelProvider()); // already set in constructor
			if(object instanceof EObject) {
				setInput(object);
			} else {
				// may be invoked with a resourceSet, a list of resources, or a single resource
				assert object instanceof Resource || object instanceof List;
				if(object instanceof List) {
					for(Object item : (List)object) {
						assert item instanceof Resource;
					}
				}
				setInput(object);
			}

			setupCaches();
			needsRedraw = true;
		}

	}
}
