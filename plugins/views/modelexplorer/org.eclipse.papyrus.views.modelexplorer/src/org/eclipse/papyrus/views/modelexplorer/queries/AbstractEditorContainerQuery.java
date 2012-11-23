/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.views.modelexplorer.queries;


/**
 * 
 * An abstract class to get the pageMngr
 * 
 */
public abstract class AbstractEditorContainerQuery {//we don't need to implements IJavaModelQuery  here

	//	/**
	//	 * 
	//	 * @return
	//	 * @throws ServiceException
	//	 */
	//	@Deprecated
	//	//@unused
	//	protected IPageMngr getPageMngr() throws ServiceException {
	//		// pageMngr can't be static, because there is a new IPageMngr each time we open a Papyrus Editor
	//		IMultiDiagramEditor papyrusEditor = EditorUtils.getMultiDiagramEditor();
	//		if (papyrusEditor != null) {
	//			ServicesRegistry serviceRegistry = papyrusEditor.getServicesRegistry();
	//			return ServiceUtils.getInstance().getIPageMngr(serviceRegistry);
	//		}
	//		throw new ServiceException("Can't retrieve the IPageMngr");
	//	}
}
