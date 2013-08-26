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
package org.eclipse.papyrus.uml.diagram.menu.actions.handlers;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.papyrus.uml.diagram.common.handlers.ParametricAndListeningHandler;
import org.eclipse.papyrus.uml.diagram.common.layout.LayoutUtils;
import org.eclipse.papyrus.uml.diagram.menu.actions.CustomAlignAction;


/**
 * 
 * Handler for the AlignmentAction
 * 
 */
public class AlignementHandler extends ParametricAndListeningHandler {

	/** the action executed by this handler */
	protected CustomAlignAction action = null;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public AlignementHandler() {
		super("org.eclipse.papyrus.uml.diagram.menu.commandAlignmentParameter"); //$NON-NLS-1$
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.handlers.GraphicalCommandHandler#getCommand()
	 * 
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected Command getCommand() {
		super.getCommand();
		this.action = new CustomAlignAction(getAlignment(this.parameter), this.getSelectedElements());
		Command cmd = action.getCommand();
		return (cmd == null) ? UnexecutableCommand.INSTANCE : cmd;
	}

	/**
	 * 
	 * @param param
	 *        the parameter for the alignment action
	 * @return
	 *         the value represented by this parameter, this valu can be :
	 *         <ul>
	 *         <li> {@link PositionConstants#NONE}</li>
	 *         <li> {@link PositionConstants#TOP}</li>
	 *         <li> {@link PositionConstants#BOTTOM}</li>
	 *         <li> {@link PositionConstants#MIDDLE}</li>
	 *         <li> {@link PositionConstants#LEFT}</li>
	 *         <li> {@link PositionConstants#RIGHT}</li>
	 *         <li> {@link PositionConstants#CENTER}</li>
	 *         </ul>
	 */
	public int getAlignment(String param) {
		if(param.equals(LayoutUtils.LEFT)) {
			return PositionConstants.LEFT;
		} else if(param.equals(LayoutUtils.CENTER)) {
			return PositionConstants.CENTER;
		} else if(param.equals(LayoutUtils.RIGHT)) {
			return PositionConstants.RIGHT;
		} else if(param.equals(LayoutUtils.BOTTOM)) {
			return PositionConstants.BOTTOM;
		} else if(param.equals(LayoutUtils.MIDDLE)) {
			return PositionConstants.MIDDLE;
		} else if(param.equals(LayoutUtils.TOP)) {
			return PositionConstants.TOP;
		}
		return PositionConstants.NONE;
	}
}
