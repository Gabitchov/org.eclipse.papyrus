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
package org.eclipse.papyrus.infra.gmfdiag.common.commands.requests;

import java.util.Collection;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;

/**
 * 
 * The request used to show/hide related links
 * 
 */
public class ShowHideRelatedLinkRequest extends Request {

	/**
	 * 
	 * this enumeration describe the several ways to use this request
	 * 
	 */
	public static enum ShowHideKind {
		OPEN_DIALOG, SHOW_ALL_LINK_IN_DIAGRAM, SHOW_ALL_LINK_BETWEEN_SELECTED_ELEMENT
	};

	/**
	 * the list of the selected editpart
	 */
	private final Collection<EditPart> selectedEditParts;


	/**
	 * the way to use this request
	 */
	private final ShowHideKind mode;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param selectedEditPart
	 */
	public ShowHideRelatedLinkRequest(final Collection<EditPart> selectedEditPart, final ShowHideKind mode) {
		super();
		this.selectedEditParts = selectedEditPart;
		this.mode = mode;
	}

	/**
	 * 
	 * @return
	 *         the selected edit part
	 */
	public Collection<EditPart> getSelectedEditParts() {
		return selectedEditParts;
	}

	/**
	 * 
	 * @return
	 *         the mode to use this request
	 */
	public ShowHideKind getMode() {
		return mode;
	}

}
