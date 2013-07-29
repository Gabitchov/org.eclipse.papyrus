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
package org.eclipse.papyrus.uml.diagram.common.layout;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;

/**
 * 
 * This class provides methods to represent an EditPart.
 * 
 */
public class EditPartRepresentation {

	/** the represented {@linkplain EditPart} */
	private final EditPart representedEditPart;

	/** the request to move this editpart */
	private Request request = null;

	/** value of the shift */
	private Dimension delta = new Dimension(0, 0);

	/**
	 * 
	 * Constructor.
	 * 
	 * @param ep
	 */
	public EditPartRepresentation(EditPart ep) {
		this.representedEditPart = ep;
	}

	/**
	 * Getter for {@link #representedEditPart}
	 * 
	 * @return {@link #representedEditPart}
	 */
	public EditPart getRepresentedEditPart() {
		return representedEditPart;
	}

	/**
	 * Returns the position of the {@link EditPart} before its shift
	 * 
	 * 
	 * @return the position of the {@link EditPart} before its shift
	 */
	public PrecisionRectangle getPosition() {
		return LayoutUtils.getAbsolutePosition(representedEditPart);
	}

	/**
	 * 
	 * Returns the command for this {@link EditPart}
	 * 
	 * @return the command for this {@link EditPart}
	 */
	public Command getCommand() {
		if(request != null) {
			return representedEditPart.getCommand(request);
		}

		return null;
	}

	/**
	 * Setter for {@link #request}
	 * 
	 * @param req
	 *        the request
	 */
	public void setRequest(ChangeBoundsRequest req) {
		this.request = req;

	}

	/**
	 * Setter for {@link #delta}
	 * 
	 * @param delta
	 *        the delta between initial position and new position
	 */
	public void setMoveDelta(Dimension delta) {
		this.delta = delta;
	}

	/**
	 * Getter for {@link EditPartRepresentation#delta}
	 * 
	 * @return {@link #delta}
	 */
	public Dimension getMoveDelta() {
		return this.delta;
	}
}
