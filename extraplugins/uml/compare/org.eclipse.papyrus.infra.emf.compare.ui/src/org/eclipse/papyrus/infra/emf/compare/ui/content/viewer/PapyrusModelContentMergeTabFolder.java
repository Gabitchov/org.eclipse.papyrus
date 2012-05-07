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
package org.eclipse.papyrus.infra.emf.compare.ui.content.viewer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.ui.TypedElementWrapper;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.emf.compare.ui.viewer.content.part.IModelContentMergeViewerTab;
import org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder;
import org.eclipse.emf.compare.ui.viewer.content.part.diff.ModelContentMergeDiffTab;
import org.eclipse.emf.compare.util.AdapterUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.emf.compare.ui.internal.utils.CustomizationAndViewerActionDispatcher;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;


/**
 * The Class UMLModelContentMergeTabFolder.
 */
public class PapyrusModelContentMergeTabFolder extends ModelContentMergeTabFolder {

	/** The my uml viewer. */
	protected final PapyrusCustomizableModelContentMergeViewer myUMLViewer;

	/** the label provider */
	private LabelProvider labelProvider;

	/** the diff tab */
	protected ModelContentMergeDiffTab diffTab;

	/**
	 * Instantiates a new uML model content merge tab folder.
	 * 
	 * @param viewer
	 *        the viewer
	 * @param composite
	 *        the composite
	 * @param side
	 *        the side
	 */
	public PapyrusModelContentMergeTabFolder(final ModelContentMergeViewer viewer, final Composite composite, final int side) {
		super(viewer, composite, side);
		myUMLViewer = (PapyrusCustomizableModelContentMergeViewer)viewer;
	}

	/**
	 * Set the labelProvider for the viewer
	 * 
	 * @param labelProvider
	 *        the labelProvider
	 */
	public void setLabelProvider(final LabelProvider labelProvider) {
		this.labelProvider = labelProvider;
		CustomizationAndViewerActionDispatcher.associateViewerAndLabelProvider(diffTab, this.labelProvider);
		diffTab.setLabelProvider(labelProvider);
	}

	/**
	 * 
	 * @see org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder#createModelContentMergeDiffTab(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 * @return
	 */
	@Override
	protected IModelContentMergeViewerTab createModelContentMergeDiffTab(final Composite parent) {
		diffTab = new ModelContentMergeDiffTab(parent, partSide, this);
		diffTab.setContentProvider(createDiffTabContentProvider());
		return diffTab;

	}

	/**
	 * 
	 * @see org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder#createContents(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param composite
	 */
	@Override
	protected void createContents(final Composite composite) {
		super.createContents(composite);
		//we set the layout here, because, it we don't set, we have a little treeviwer...
		Control ctrl = tree.getControl();
		ctrl.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

	/**
	 * 
	 * @see org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder#dispose()
	 * 
	 */
	@Override
	public void dispose() {
		if(labelProvider != null) {
			CustomizationAndViewerActionDispatcher.dissociateTreeViewerAndLabelProvider(diffTab, labelProvider);
			diffTab = null;
			labelProvider = null;
		}
		super.dispose();
	}

	/**
	 * 
	 * @return
	 */
	protected IContentProvider createDiffTabContentProvider() {
		return new ModelContentMergeDiffTabContentProvider(AdapterUtils.getAdapterFactory());
	}


	/**
	 * This implementation of an {@link AdapterFactoryContentProvider} will strip ComparisonSnapshots out of
	 * the view.
	 * 
	 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
	 */
	//FIXME duplicated code from EMF-Compare :ModelContentMergeDiffTab.ModelContentMergeDiffTabContentProvider
	public class ModelContentMergeDiffTabContentProvider extends AdapterFactoryContentProvider {

		/**
		 * Default constructor. Delegates to the super implementation.
		 * 
		 * @param factory
		 *        Factory to get labels and icons from.
		 */
		public ModelContentMergeDiffTabContentProvider(final AdapterFactory factory) {
			super(factory);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getElements(java.lang.Object)
		 */
		@SuppressWarnings("unchecked")
		@Override
		public Object[] getElements(final Object object) {
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
		public Object[] getChildren(final Object object) {
			if(object instanceof Resource) {
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
		public boolean hasChildren(final Object object) {
			if(object instanceof Resource) {
				return ((Resource)object).getContents().size() > 0;
			}
			return super.hasChildren(object);
		}
	}

}