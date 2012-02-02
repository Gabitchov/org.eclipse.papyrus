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
 *  Vincent Lorenzo (CEA LIST) - 349650: [Papyrus Merge] IndexOfBoundException
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.ui.viewer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.ui.TypedElementWrapper;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.emf.compare.ui.viewer.content.part.IModelContentMergeViewerTab;
import org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder;
import org.eclipse.emf.compare.util.AdapterUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.papyrus.infra.emf.compare.ui.Activator;
import org.eclipse.papyrus.infra.emf.compare.ui.provider.PapyrusLabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;


/**
 * The Class UMLModelContentMergeTabFolder.
 */
//duplicate code from tatiana
//TODO verify the super class
public class TransactionalModelContentMergeTabFolder extends ModelContentMergeTabFolder {

	/** The my uml viewer. */
	protected final TransactionalModelContentMergeViewer myUMLViewer;

	/**
	 * Instantiates a new uML model content merge tab folder.
	 *
	 * @param viewer the viewer
	 * @param composite the composite
	 * @param side the side
	 */
	public TransactionalModelContentMergeTabFolder(ModelContentMergeViewer viewer, Composite composite, int side) {
		super(viewer, composite, side);
		myUMLViewer = (TransactionalModelContentMergeViewer)viewer;
	}

	
	@Override
	protected IModelContentMergeViewerTab createModelContentMergeDiffTab(Composite parent) {
//		IModelContentMergeViewerTab tab = super.createModelContentMergeDiffTab(parent);
		TransactionalModelContentMergeDiffTab diffTab = new TransactionalModelContentMergeDiffTab(parent, partSide, this);
		diffTab.setContentProvider(createDiffTabContentProvider());
		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		CustomizationManager manager = Activator.getDefault().getCustomizationManager(activeEditor);
		diffTab.setLabelProvider(new PapyrusLabelProvider(manager));
		return diffTab;

	}
	
	@Override
	public void dispose() {
//		Activator.getDefault().
		super.dispose();
	}
//
//	/* (non-Javadoc)
//	 * @see org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder#createModelContentMergeViewerTab(org.eclipse.swt.widgets.Composite)
//	 */
//	@Override
//	protected IModelContentMergeViewerTab createModelContentMergeViewerTab(Composite parent) {
//		ModelContentMergePropertyTab propertyTab = new ModelContentMergePropertyTab(parent, partSide, this);
//		propertyTab.setContentProvider(new UMLPropertyContentProvider());
//		return propertyTab;
//	}
//
//	/**
//	 * Creates the diff tab content provider.
//	 *
//	 * @return the i content provider
//	 */
//	protected IContentProvider createDiffTabContentProvider() {
//		ComposedAdapterFactory adapterFactory = new UMLAdapterFactory();
//		AdapterFactoryContentProvider result = new AdapterFactoryContentProvider(adapterFactory) {
//
//			@Override
//			public Object[] getElements(Object object) {
//				if(object instanceof RootObject) {
//					return new Object[]{ ((RootObject)object).object };
//				}
//				return super.getElements(object);
//			}
//		};
//
//		return result;
//	}
//
//	/* (non-Javadoc)
//	 * @see org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder#findMatchFromElement(org.eclipse.emf.ecore.EObject)
//	 */
//	protected EObject findMatchFromElement(EObject element) {
//		EObject matchElement = super.findMatchFromElement(element);
//		if(!myUMLViewer.isShowAllProperties() && matchElement instanceof Match2Elements) {
//			if(myUMLViewer.getCurrentSelection().size()!=0){//see bug  349650
//				return new Match2ElementsWithDiff((Match2Elements)matchElement, myUMLViewer.getCurrentSelection().get(0));
//			}
//		}
//		return matchElement;
//	}
//
//	/**
//	 * Gets the selected tab.
//	 *
//	 * @return the selected tab
//	 */
//	public int getSelectedTab() {
//		return tabFolder.getSelectionIndex();
//	}
//
//	/**
//	 * Checks if is property tab.
//	 *
//	 * @param index the index
//	 * @return true, if is property tab
//	 */
//	public boolean isPropertyTab(int index) {
//		final IModelContentMergeViewerTab currentTab = tabs.get(index);
//		return (currentTab == getPropertyPart());
//	}

//TODO : use the content provider from the new EMF-Compare
	protected IContentProvider createDiffTabContentProvider() {
//		private ModelContentMergeDiffTabContentProvider createContentProvider() {
		 
			return new ModelContentMergeDiffTabContentProvider(AdapterUtils.getAdapterFactory());
//		}

	//	ComposedAdapterFactory adapterFactory = new UMLAdapterFactory();
//		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory();
//		AdapterFactoryContentProvider result = new AdapterFactoryContentProvider(adapterFactory) {
//
//			@Override
//			public Object[] getElements(Object object) {
////				if(object instanceof RootObject) {
////					return new Object[]{ ((RootObject)object).object };
////				}
//				return super.getElements(object);
//			}
//		}

//		return result;
	}
	
	
	/**
	 * This implementation of an {@link AdapterFactoryContentProvider} will strip ComparisonSnapshots out of
	 * the view.
	 * 
	 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
	 */
	//duplicate code from EMF-Compare :ModelContentMergeDiffTab.ModelContentMergeDiffTabContentProvider
	public class ModelContentMergeDiffTabContentProvider extends AdapterFactoryContentProvider {
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
				result = ((Resource)object).getContents().toArray();
			} else {
				result = super.getElements(object);
			}
			return result;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getChildren(java.lang.Object)
		 */
		@Override
		public Object[] getChildren(Object object) {
			if (object instanceof Resource) {
				return ((Resource)object).getContents().toArray();
			}
			return super.getChildren(object);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#hasChildren(java.lang.Object)
		 */
		@Override
		public boolean hasChildren(Object object) {
			if (object instanceof Resource) {
				return ((Resource)object).getContents().size() > 0;
			}
			return super.hasChildren(object);
		}
	}
	
	@Override
	protected void fireSelectionChanged(SelectionChangedEvent event) {
		// TODO Auto-generated method stub
		super.fireSelectionChanged(event);
	}
}
