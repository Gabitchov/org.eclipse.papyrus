/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.ui.hyperlinkshell;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.core.utils.ServiceUtils;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;

/**
 * The Class HyperLinkDiagram a container of diagram
 */
public class HyperLinkDiagram extends HyperlinkObject {

	/**
	 * Gets the diagram.
	 * 
	 * @return the diagram
	 */
	public Diagram getDiagram() {
		// TODO Auto-generated method stub
		return (Diagram)super.getObject();
	}

	/**
	 * Sets the diagram.
	 * 
	 * @param object
	 *        the new diagram
	 */
	public void setDiagram(Diagram object) {
		// TODO Auto-generated method stub
		super.setObject(object);
	}

	@Override
	public void executeMousePressed() {
		IMultiDiagramEditor papyrusEditor=EditorUtils.getMultiDiagramEditor();
		IPageMngr pageMngr=null;
		try {
			pageMngr = ServiceUtils.getInstance().getIPageMngr(papyrusEditor.getServicesRegistry());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		// better to set focus on existing page than close and
		// open
		if(pageMngr.isOpen(this.getDiagram())) {
			pageMngr.closePage(this.getDiagram());
		}
		pageMngr.openPage((this.getDiagram()));
	}
}
