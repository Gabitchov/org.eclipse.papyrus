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

package org.eclipse.papyrus.modelexplorer.queries;

import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;

/**
 * 
 * An abstract class to get the pageMngr
 *
 */
public abstract class AbstractEditorContainerQuery {//we don't need to implements IJavaModelQuery  here

	/**
	 * 
	 * @return
	 * @throws ServiceException
	 */
	protected IPageMngr getPageMngr() throws ServiceException {
		IPageMngr pageMngr;//can't be static, because there is a new IPageMngr each time we open a Papyrus Editor
		IMultiDiagramEditor papyrusEditor = EditorUtils.getMultiDiagramEditor();
		ServicesRegistry serviceRegistry = papyrusEditor.getServicesRegistry();
		pageMngr = org.eclipse.papyrus.core.utils.ServiceUtils.getInstance().getIPageMngr(serviceRegistry);
		return pageMngr;
	}
}
