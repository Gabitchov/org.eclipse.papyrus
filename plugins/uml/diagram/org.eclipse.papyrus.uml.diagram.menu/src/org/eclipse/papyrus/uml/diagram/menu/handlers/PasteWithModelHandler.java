/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.menu.handlers;

import java.awt.Toolkit;
import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.common.helper.CleanDiagramHelper;
import org.eclipse.papyrus.uml.diagram.common.service.PasteCommandService;

/**
 * The handler for the paste with model action
 * 
 */
public class PasteWithModelHandler extends AbstractHandler {

	/**
	 * the paste command
	 */
	private ICommand pasteCommand = null;

	/**
	 * the target edit part
	 */
	private GraphicalEditPart targetEditPart = null;

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if(pasteCommand != null && pasteCommand.canExecute()) {
			targetEditPart.getEditingDomain().getCommandStack().execute(new GMFtoEMFCommandWrapper(pasteCommand));
			RootEditPart topEditPart = targetEditPart.getRoot();
			if(topEditPart.getChildren().get(0) instanceof DiagramEditPart) {
				CleanDiagramHelper.getInstance().run((DiagramEditPart)topEditPart.getChildren().get(0));
			}
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#setEnabled(java.lang.Object)
	 * 
	 * @param evaluationContext
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		boolean enabled = false;
		pasteCommand = null;
		targetEditPart = null;
		if(evaluationContext instanceof IEvaluationContext) {
			Object defaultVariable = ((IEvaluationContext)evaluationContext).getDefaultVariable();
			if(defaultVariable instanceof Collection<?>) {
				int size = ((Collection<?>)defaultVariable).size();
				if(size == 1) {
					final Object current = ((Collection<?>)defaultVariable).iterator().next();
					if(current instanceof GraphicalEditPart) {
						targetEditPart = (GraphicalEditPart)current;
						pasteCommand = PasteCommandService.getInstance().getPasteWithModelCommand(targetEditPart, Toolkit.getDefaultToolkit().getSystemClipboard(), targetEditPart.getEditingDomain().getClipboard());
						enabled = pasteCommand != null && pasteCommand.canExecute();
					}
				}
			}
		}
		setBaseEnabled(enabled);
	}


}
