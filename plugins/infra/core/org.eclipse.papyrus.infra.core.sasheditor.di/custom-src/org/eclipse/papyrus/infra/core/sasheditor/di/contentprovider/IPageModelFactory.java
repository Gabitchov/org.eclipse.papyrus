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

package org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;


/**
 * Factory used to create IPageModel from an object identifying a page.
 * IPageModel are objects used by the Sash Windows to create a page.
 * 
 * @author cedric dumoulin
 */
public interface IPageModelFactory {

	/**
	 * Create the IPageModel for the pageIdentifier. The pageIdentifier is the object passed to
	 * the {@link IPageMngr#addEditor(EObject)}.
	 * This factory method is called by the Sash Windows whenever it needs to create a page. The identifier
	 * is found in the sash model.
	 * 
	 * @param pageIdentifier
	 *        The identifier identifying the page to create.
	 * @return
	 */
	public IPageModel createIPageModel(Object pageIdentifier);
}
