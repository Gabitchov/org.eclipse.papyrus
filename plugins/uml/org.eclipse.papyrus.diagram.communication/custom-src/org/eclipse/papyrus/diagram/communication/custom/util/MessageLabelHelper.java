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
 *  Saadia DHOUIB (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.communication.custom.util;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Message;

/**
 * this is an helper that is specific for the Message Label
 */
public class MessageLabelHelper {

	/**
	 * 
	 * @param editPart
	 * @return the message
	 */
	public Message getUMLElement(GraphicalEditPart editPart) {
		return (Message)((View)editPart.getModel()).getElement();
	}
}
