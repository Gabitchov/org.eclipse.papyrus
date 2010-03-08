/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz;

import java.util.Collection;
import java.util.List;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionContext;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandler;
import org.eclipse.gmf.runtime.diagram.ui.requests.PasteViewRequest;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.jface.viewers.ISelection;


public class ClazzDiagramGlobalActionHandler extends DiagramGlobalActionHandler {

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandler#canCopy(org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionContext)
	 *
	 * @param cntxt
	 * @return
	 */
	
	@Override
	protected boolean canCopy(IGlobalActionContext cntxt) {
		// TODO Auto-generated method stub
		System.err.println("canCopy(IGlobalActionContext cntxt)");
		return super.canCopy(cntxt);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandler#canCut(org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionContext)
	 *
	 * @param cntxt
	 * @return
	 */
	
	@Override
	protected boolean canCut(IGlobalActionContext cntxt) {
		// TODO Auto-generated method stub
		System.err.println("canCut(IGlobalActionContext cntxt)");
		return super.canCut(cntxt);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandler#canHandle(org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionContext)
	 *
	 * @param cntxt
	 * @return
	 */
	
	@Override
	public boolean canHandle(IGlobalActionContext cntxt) {
		// TODO Auto-generated method stub
		System.err.println("canHandle(IGlobalActionContext cntxt)");
		return super.canHandle(cntxt);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandler#canPaste(org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionContext)
	 *
	 * @param cntxt
	 * @return
	 */
	
	@Override
	protected boolean canPaste(IGlobalActionContext cntxt) {
		// TODO Auto-generated method stub
		System.err.println("canPaste(IGlobalActionContext cntxt)");
		return super.canPaste(cntxt);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandler#canSave(org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionContext)
	 *
	 * @param cntxt
	 * @return
	 */
	
	@Override
	protected boolean canSave(IGlobalActionContext cntxt) {
		// TODO Auto-generated method stub
		System.err.println("canSave(IGlobalActionContext cntxt)");
		return super.canSave(cntxt);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandler#createPasteViewRequest()
	 *
	 * @return
	 */
	
	@Override
	protected PasteViewRequest createPasteViewRequest() {
		// TODO Auto-generated method stub
		System.err.println("createPasteViewRequest()");
		return super.createPasteViewRequest();
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandler#getCommand(org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionContext)
	 *
	 * @param cntxt
	 * @return
	 */
	
	@Override
	public ICommand getCommand(IGlobalActionContext cntxt) {
		// TODO Auto-generated method stub
		System.err.println("getCommand(IGlobalActionContext cntxt)");
		return super.getCommand(cntxt);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandler#getCopyCommand(org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionContext, org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart, boolean)
	 *
	 * @param cntxt
	 * @param diagramPart
	 * @param isUndoable
	 * @return
	 */
	
	@Override
	protected ICommand getCopyCommand(IGlobalActionContext cntxt, IDiagramWorkbenchPart diagramPart, boolean isUndoable) {
		// TODO Auto-generated method stub
		System.err.println("getCopyCommand(IGlobalActionContext cntxt, IDiagramWorkbenchPart diagramPart, boolean isUndoable)");
		return super.getCopyCommand(cntxt, diagramPart, isUndoable);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandler#getCutCommand(org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionContext, org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart)
	 *
	 * @param cntxt
	 * @param diagramPart
	 * @return
	 */
	
	@Override
	protected ICommand getCutCommand(IGlobalActionContext cntxt, IDiagramWorkbenchPart diagramPart) {
		// TODO Auto-generated method stub
		System.err.println("getCutCommand(IGlobalActionContext cntxt, IDiagramWorkbenchPart diagramPart)");
		return super.getCutCommand(cntxt, diagramPart);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandler#getMapMode(org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionContext)
	 *
	 * @param cntxt
	 * @return
	 */
	
	@Override
	protected IMapMode getMapMode(IGlobalActionContext cntxt) {
		// TODO Auto-generated method stub
		System.err.println("getMapMode(IGlobalActionContext cntxt)");
		return super.getMapMode(cntxt);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandler#getSelectedViews(org.eclipse.jface.viewers.ISelection)
	 *
	 * @param sel
	 * @return
	 */
	
	@Override
	protected List getSelectedViews(ISelection sel) {
		// TODO Auto-generated method stub
		System.err.println("getSelectedViews(ISelection sel)");
		return super.getSelectedViews(sel);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandler#selectAddedObject(org.eclipse.gef.EditPartViewer, java.util.Collection)
	 *
	 * @param viewer
	 * @param objects
	 */
	
	@Override
	protected void selectAddedObject(EditPartViewer viewer, Collection objects) {
		// TODO Auto-generated method stub
		System.err.println("selectAddedObject(EditPartViewer viewer, Collection objects)");
		super.selectAddedObject(viewer, objects);
	}

}
