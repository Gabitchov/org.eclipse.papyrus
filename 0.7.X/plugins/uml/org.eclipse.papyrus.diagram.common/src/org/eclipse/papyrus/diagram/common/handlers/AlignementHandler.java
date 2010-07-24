/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.diagram.common.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.diagram.common.actions.CustomAlignAction;
import org.eclipse.papyrus.diagram.common.layout.LayoutUtils;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;


/**
 * 
 * This class provides keybinding for the alignment actions. The allowed parameters are :
 * <ul>
 * <li> {@link AlignementHandler#LEFT}</li>
 * <li> {@link AlignementHandler#CENTER}</li>
 * <li> {@link AlignementHandler#RIGHT}</li>
 * <li> {@link AlignementHandler#BOTTOM}</li>
 * <li> {@link AlignementHandler#MIDDLE}</li>
 * <li> {@link AlignementHandler#TOP}</li>
 * 
 * </ul>
 * 
 */
public class AlignementHandler extends AbstractHandler {


	/** the alignment */
	private int alignment = PositionConstants.NONE;

	/** the id for this alignment */
	private String id = null;

	/** the workbenchpage */
	private IWorkbenchPage workbenchPage = null;

	/** the selected elements */
	private ISelection selection = null;

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * 
	 */
	public Object execute(ExecutionEvent event) {
		init(event);
		if(this.alignment != PositionConstants.NONE && workbenchPage != null && ((StructuredSelection)this.selection).size() >= 1) {
			CustomAlignAction action = new CustomAlignAction(workbenchPage, id, alignment, false);
			action.init();
			if(action.isEnabled()) {
				action.run();
			}
		}
		return null;
	}

	/**
	 * This function initializes the following fields :
	 * <ul>
	 * <li>{@link #alignment}</li>
	 * <li> {@link #id}</li>
	 * <li> {@link #selection}</li>
	 * <li> {@link #workbenchPage}</li>
	 * </ul>
	 * 
	 * @param evt
	 *        the received event
	 */
	protected void init(ExecutionEvent evt) {
		workbenchPage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		this.selection = workbenchPage.getSelection();
		String param = evt.getParameter("org.eclipse.papyrus.diagram.common.commandAlignmentParameter");
		if(param.equals(LayoutUtils.LEFT)) {
			this.alignment = PositionConstants.LEFT;
			this.id = GEFActionConstants.ALIGN_LEFT;

		} else if(param.equals(LayoutUtils.CENTER)) {
			this.alignment = PositionConstants.CENTER;
			this.id = GEFActionConstants.ALIGN_CENTER;

		} else if(param.equals(LayoutUtils.RIGHT)) {
			this.alignment = PositionConstants.RIGHT;
			this.id = GEFActionConstants.ALIGN_RIGHT;

		} else if(param.equals(LayoutUtils.BOTTOM)) {
			this.alignment = PositionConstants.BOTTOM;
			this.id = GEFActionConstants.ALIGN_BOTTOM;

		} else if(param.equals(LayoutUtils.MIDDLE)) {
			this.alignment = PositionConstants.MIDDLE;
			this.id = GEFActionConstants.ALIGN_MIDDLE;

		} else if(param.equals(LayoutUtils.TOP)) {
			this.alignment = PositionConstants.TOP;
			this.id = GEFActionConstants.ALIGN_TOP;
		}
	}
}
