/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL 
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Emilien Perico emilien.perico@atosorigin.com - add methods to manage di resource
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.sashwindows.di.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.sashwindows.di.DiFactory;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageList;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashModel;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder;
import org.eclipse.papyrus.infra.core.sashwindows.di.Window;
import org.eclipse.papyrus.infra.core.sashwindows.di.exception.SashEditorException;


/**
 * Set of utility methods
 * 
 * @author dumoulin
 */
public class DiUtils {

	/**
	 * Create a default SashModel with one window and one folder.
	 * Set the current folder.
	 * 
	 * @param diResource
	 * @return
	 */
	static public SashModel createDefaultSashModel() {

		// SashModel
		SashModel sashModel = DiFactory.eINSTANCE.createSashModel();
		Window window = DiFactory.eINSTANCE.createWindow();
		sashModel.getWindows().add(window);

		TabFolder folder = DiFactory.eINSTANCE.createTabFolder();
		window.setPanel(folder);
		// Default folder
		sashModel.setCurrentSelectionSilently(folder);

		return sashModel;
	}

	/**
	 * Create a default SashWindowsMngr with one PageLit and one default SashModel.
	 * Set the current folder.
	 * 
	 * @param diResource
	 * @return
	 */
	static public SashWindowsMngr createDefaultSashWindowsMngr() {
		SashWindowsMngr model;

		model = DiFactory.eINSTANCE.createSashWindowsMngr();

		// SashModel
		SashModel layout = createDefaultSashModel();

		model.setSashModel(layout);

		// PageList
		PageList pageList = DiFactory.eINSTANCE.createPageList();
		model.setPageList(pageList);
		return model;
	}

	/**
	 * Lookup for the SashModel object in the resource.
	 * 
	 * @param diResource
	 * @return The {@link DiSashModel} or null if not found.
	 */
	static public SashWindowsMngr lookupSashWindowsMngr(Resource diResource) {

		for(Object node : diResource.getContents()) {
			if(node instanceof SashWindowsMngr)
				return (SashWindowsMngr)node;
		}
		return null;
	}

	/**
	 * Gets the page reference of the specified eObject
	 * 
	 * @param diResource
	 * @param eObject
	 * 
	 * @return the page ref of eObject, null if not found
	 *         TODO This method use too low level mechanism for its implementation. Consider to move it in a
	 *         more appropriate class. Furthermore, some similar methods already exist. Can't we use them
	 *         instead ?
	 *         
	 * @deprecated Should use IPageMngr instead.
	 */
	static public PageRef getPageRef(Resource diResource, EObject eObject) {
		SashWindowsMngr windowsMngr = lookupSashWindowsMngr(diResource);
		if(windowsMngr != null && windowsMngr.getPageList() != null) {

			for(PageRef pageRef : windowsMngr.getPageList().getAvailablePage()) {

				EObject emfPageIdentifier = pageRef.getEmfPageIdentifier();
				if(eObject != null && eObject.equals(emfPageIdentifier)) {
					return pageRef;
				}
			}
		}
		return null;
	}

	/**
	 * Adds page to the page list of the sash windows manager
	 * 
	 * @param diResource
	 * @param pageRef
	 * @throws SashEditorException
	 *         TODO This method use too low level mechanism for its implementation. Consider to move it in a
	 *         more appropriate class. Furthermore, some similar methods already exist. Can't we use them
	 *         instead ?
	 * @deprecated Should use IPageMngr instead.
	 */
	static public void addPageToPageList(Resource diResource, PageRef pageRef) throws SashEditorException {
		SashWindowsMngr windowsMngr = lookupSashWindowsMngr(diResource);
		addPageToPageList(windowsMngr, pageRef);
	}

	/**
	 * Adds page to the page list of the sash windows manager.
	 * 
	 * @param pageRef
	 * @param windowsMngr
	 * @throws SashEditorException
	 *         TODO This method use too low level mechanism for its implementation. Consider to move it in a
	 *         more appropriate class. Furthermore, some similar methods already exist. Can't we use them
	 *         instead ?
	 *         
	 * @deprecated Should use IPageMngr instead.
	 */
	static public void addPageToPageList(SashWindowsMngr windowsMngr, PageRef pageRef) throws SashEditorException {
		if(windowsMngr != null && windowsMngr.getPageList() != null) {
			windowsMngr.getPageList().addPage(pageRef.getPageIdentifier());
		} else {
			throw new SashEditorException("Unable to add the page to the windows manager");
		}
	}

	/**
	 * Adds page to tab folder.
	 * 
	 * @param windowsMngr
	 * @param pageRef
	 * @throws SashEditorException
	 *         TODO This method use too low level mechanism for its implementation. Consider to move it in a
	 *         more appropriate class. Furthermore, some similar methods already exist. Can't we use them
	 *         instead ?
	 *         
	 * @deprecated Should use IPageMngr instead.
	 */
	static public void addPageToTabFolder(SashWindowsMngr windowsMngr, PageRef pageRef) throws SashEditorException {

		// Check parameters
		if(pageRef == null || pageRef.getPageIdentifier() == null)
			throw new SashEditorException("Unable to add the page to the tab folder: parameters are null");

		SashModel sashModel = windowsMngr.getSashModel();
		if(sashModel == null) {
			throw new SashEditorException("Unable to add the page to the tab folder: can't find SashModel");
		}

		// Get the currently active folder in order to add the page.
		TabFolder tabFolder = sashModel.getCurrentSelection();
		if(tabFolder == null) {
			throw new SashEditorException("Unable to add the page to the tab folder: No active folder");
		}

		tabFolder.addPage(pageRef.getPageIdentifier());
	}

}
