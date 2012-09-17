/*****************************************************************************
 * Copyright (c) 2010 LIFL & CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin (LIFL) cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Ansgar Radermacher (CEA) ansgar.radermacher@cea.fr - Added support for IGotoMarker
 *
 *****************************************************************************/

package org.eclipse.papyrus.views.modelexplorer;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.views.modelexplorer.core.ui.pagebookview.MultiViewPageBookView;
import org.eclipse.papyrus.views.modelexplorer.core.ui.pagebookview.ViewPartPage;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.google.common.collect.Lists;


/**
 * A Page Book containing one {@link ModelExplorerView} for each opened Papyrus Editor.
 * 
 * @author cedric dumoulin
 * 
 */
public class ModelExplorerPageBookView extends MultiViewPageBookView implements IGotoMarker, ITabbedPropertySheetPageContributor {

	/** ID of the view, as given in the plugin.xml file */
	public static final String VIEW_ID = "org.eclipse.papyrus.views.modelexplorer.modelexplorer"; //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected PageRec doCreatePage(IWorkbenchPart part) {

		// part is of type IMultiDiagramEditor (because of isImportant() )

		ViewPartPage page = new ModelExplorerPage();

		// Init the page, and so the View
		initPage(page, part);
		page.createControl(getPageBook());
		return new PageRec(part, page);
	}


	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class adapter) {

		if(IPropertySheetPage.class == adapter) {
			// Do not test if tabbedPropertySheetPage is null before calling new
			// this is managed by Eclipse which only call current method when necessary
			return new TabbedPropertySheetPage(this);
		}

		return super.getAdapter(adapter);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getContributorId() {
		// return Activator.PLUGIN_ID;
		return "TreeOutlinePage";

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
				ModelExplorerView modelExplorerView = (ModelExplorerView)viewPart;
				EditingDomain domain = modelExplorerView.getEditingDomain();
				EObject eObject = domain.getResourceSet().getEObject(uri, false);
				if(eObject != null) {
					CommonViewer treeViewer = ((ModelExplorerView)viewPart).getCommonViewer();
					// The common viewer is in fact a tree viewer
					// bug enhancement: use function in ModelExplorerView instead of findElementForEObject
					ModelExplorerView.reveal(Lists.newArrayList(eObject), treeViewer);
				}
			}
		}
	}
}
