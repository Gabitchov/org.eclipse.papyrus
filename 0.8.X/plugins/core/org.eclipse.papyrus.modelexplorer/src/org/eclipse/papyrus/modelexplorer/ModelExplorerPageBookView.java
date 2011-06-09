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

package org.eclipse.papyrus.modelexplorer;

import static org.eclipse.papyrus.core.Activator.log;

import java.util.LinkedList;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.core.ui.pagebookview.MultiViewPageBookView;
import org.eclipse.papyrus.core.ui.pagebookview.ViewPartPage;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;


/**
 * A Page Book containing one {@link ModelExplorerView} for each opened Papyrus Editor.
 * 
 * @author cedric dumoulin
 * 
 */
public class ModelExplorerPageBookView extends MultiViewPageBookView implements IGotoMarker, ITabbedPropertySheetPageContributor {

	/** ID of the view, as given in the plugin.xml file */
	public static final String VIEW_ID = "org.eclipse.papyrus.modelexplorer.modelexplorer"; //$NON-NLS-1$
	
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
	 * Find an Element within the tree (a ModelElementItem) when given an EObject
	 *
	 * @param eObjectToFind
	 * @param treeViewer
	 * @return
	 */
	public Object findElementForEObject(TreeViewer treeViewer, EObject eObjectToFind) {
		ITreeContentProvider contentProvider = (ITreeContentProvider) treeViewer.getContentProvider();
		Object[] elements = contentProvider.getElements(treeViewer.getInput());
			
		LinkedList<Object> elementsToHandle = new LinkedList<Object>();
		for (Object element : elements) {
			elementsToHandle.add(element);
		}
		while (!elementsToHandle.isEmpty()) {
			Object e = elementsToHandle.removeFirst();
			EObject eObject = (EObject) Platform.getAdapterManager().getAdapter(e, EObject.class);
			if (eObject != null && eObject.equals(eObjectToFind)) {
				return e;
			}
			if (contentProvider.hasChildren(e)) {
				Object[] children = contentProvider.getChildren(e);
				if (children != null) {
					for (Object child : children) {
						elementsToHandle.addLast(child);
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void gotoMarker(IMarker marker) {
		try {
			if (marker.isSubtypeOf((EValidator.MARKER))) {
				String uriAttribute = marker.getAttribute(EValidator.URI_ATTRIBUTE, null);
				if(uriAttribute != null) {
					URI uri = URI.createURI(uriAttribute);
					IViewPart viewPart = getActiveView();
					if (viewPart instanceof ModelExplorerView) {
						ModelExplorerView modelExplorerView =  (ModelExplorerView) viewPart;
						EditingDomain domain = modelExplorerView.getEditingDomain();
						EObject eObject = domain.getResourceSet().getEObject(uri, true);
						if (eObject != null) {
							CommonViewer treeViewer = ((ModelExplorerView) viewPart).getCommonViewer();
							// The common viewer is in fact a tree viewer
							Object modelElementItem = findElementForEObject (treeViewer, eObject);
							if (modelElementItem != null) {
								TreePath treePath = new TreePath(new Object[] {
									modelElementItem
								});
								EObject parent = eObject.eContainer();
								if (parent != null) {
									// workaround: in case of a pseudo parent (like "ownedConnector", the expansion
									// is not made automatically
									Object parentElement = findElementForEObject (treeViewer, parent);
									treeViewer.expandToLevel(parentElement, 1);
								}
								treeViewer.setSelection(new TreeSelection (treePath), true);
							}
						}
					}
				}
			}
		} catch (CoreException exception) {
			log.error(exception);
		}
	}
}
