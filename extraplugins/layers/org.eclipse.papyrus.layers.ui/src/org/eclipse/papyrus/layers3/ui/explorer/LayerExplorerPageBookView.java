/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers3.ui.explorer;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.papyrus.views.modelexplorer.core.ui.pagebookview.MultiViewPageBookView;
import org.eclipse.papyrus.views.modelexplorer.core.ui.pagebookview.ViewPartPage;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.PageBookView;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;


/**
 * A {@link PageBookView} allowing to render multiple LayerExplorerPage in one Eclipse View.
 * 
 * @author cedric dumoulin
 *
 */
public class LayerExplorerPageBookView extends MultiViewPageBookView {

	/** ID of the view, as given in the plugin.xml file */
	public static final String VIEW_ID = "org.eclipse.papyrus.views.layers.layersexplorer"; //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected PageRec doCreatePage(IWorkbenchPart part) {

		// part is of type IMultiDiagramEditor (because of isImportant() )

		ViewPartPage page = new LayersExplorerPage();

		// Init the page, and so the View
		initPage(page, part);
		page.createControl(getPageBook());
		return new PageRec(part, page);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getAdapter(Class adapter) {

		if(IPropertySheetPage.class == adapter) {
			// Do not test if tabbedPropertySheetPage is null before calling new
			// this is managed by Eclipse which only call current method when necessary
//			return new TabbedPropertySheetPage(this);
		}

		return super.getAdapter(adapter);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getContributorId() {
		// return Activator.PLUGIN_ID;
		return "TreeOutlinePage"; //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 */
	public void gotoMarker(IMarker marker) {
		String uriAttribute = marker.getAttribute(EValidator.URI_ATTRIBUTE, null);
		if(uriAttribute != null) {
			URI uri = URI.createURI(uriAttribute);
			IViewPart viewPart = getActiveView();
			if(viewPart instanceof ModelExplorerView) {
				LayersExplorerView modelExplorerView = (LayersExplorerView)viewPart;
//				EditingDomain domain = modelExplorerView.getEditingDomain();
//				EObject eObject = domain.getResourceSet().getEObject(uri, false);
//				if(eObject != null) {
//					CommonViewer treeViewer = ((ModelExplorerView)viewPart).getCommonViewer();
//					// The common viewer is in fact a tree viewer
//					// bug enhancement: use function in ModelExplorerView instead of findElementForEObject
//					ModelExplorerView.reveal(Lists.newArrayList(eObject), treeViewer);
				}
			}
		}
}
