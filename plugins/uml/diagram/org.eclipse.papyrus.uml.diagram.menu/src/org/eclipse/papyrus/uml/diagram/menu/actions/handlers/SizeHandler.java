/*****************************************************************************
 * Copyright (c) 2009-2010 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.menu.actions.handlers;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ScrollPane;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.papyrus.uml.diagram.common.handlers.ParametricAndListeningHandler;
import org.eclipse.papyrus.uml.diagram.menu.actions.SizeAction;

/**
 * The Class SizeHandler.
 */
public class SizeHandler extends ParametricAndListeningHandler {

	/** the SizeAction */
	// Removed (bug 384145)
	//	SizeAction action;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public SizeHandler() {
		super("org.eclipse.papyrus.uml.diagram.menu.commandSizeParameter"); //$NON-NLS-1$
	}

	// Overload the method (execute) to update the position of Scroll Bar
	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.handlers.GraphicalCommandHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		List<IGraphicalEditPart> selem = getSelectedElements();


		if(!selem.isEmpty()) {

			Iterator<IGraphicalEditPart> editParts = selem.iterator();


			while(editParts.hasNext()) {
				EditPart editPart = editParts.next();
				List<?> editPartChildS = editPart.getChildren();


				for(int k = 0; k < editPartChildS.size(); k++) {
					if(!editPartChildS.isEmpty()) {
						EditPart ept = (EditPart)editPartChildS.get(k);

						final GraphicalEditPart graphicalEditPart = (GraphicalEditPart)ept;

						final IFigure fig = graphicalEditPart.getFigure();

						if(fig instanceof ResizableCompartmentFigure) {

							ScrollPane fScrollPane = ((ResizableCompartmentFigure)fig).getScrollPane();
							if(fScrollPane != null) {
								fScrollPane.scrollHorizontalTo(0);
								fScrollPane.scrollVerticalTo(0);
							}
						}
					}
				}
			}
		}
		return super.execute(event);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.handlers.ParametricAndListeningHandler#getCommand()
	 * 
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected Command getCommand() {
		super.getCommand();
		SizeAction action = new SizeAction(this.parameter, getSelectedElements());
		Command cmd = action.getCommand();

		return (cmd == null) ? UnexecutableCommand.INSTANCE : cmd;
	}
}
