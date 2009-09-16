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
 *
  *****************************************************************************/

package org.eclipse.papyrus.sashwindows.di.util;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.sashwindows.di.DiFactory;
import org.eclipse.papyrus.sashwindows.di.PageList;
import org.eclipse.papyrus.sashwindows.di.SashModel;
import org.eclipse.papyrus.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.sashwindows.di.TabFolder;
import org.eclipse.papyrus.sashwindows.di.Window;


/**
 * Set of utility methods
 * @author dumoulin
 */
public class DiUtils {

	/**
	 * Create a default SashModel with one window and one folder.
	 * Set the current folder.
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
		sashModel.setCurrentSelection(folder);
		
		return sashModel;
	}

	/**
	 * Create a default SashWindowsMngr with one PageLit and one default SashModel.
	 * Set the current folder.
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
	 * @param diResource 
	 * @return The {@link DiSashModel} or null if not found.
	 */
	static public SashWindowsMngr lookupSashWindowsMngr(Resource diResource) {
		
		for( Object node : diResource.getContents() )
		{
			if( node instanceof SashWindowsMngr)
				return (SashWindowsMngr)node;
		}
		return null;
	}


}
