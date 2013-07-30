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
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;

/**
 * 
 * This EditPolicy provides the command for the alignment. In the case of
 * AffixedNode, the parent is not a {@link CompartmentEditPart}, but directly
 * the object. For example, a port is owned by a ClassCompositeEditPart and not
 * by a ClassCompositeCompartmentEditPart
 */
public class AffixedNodeAlignmentEditPolicy extends ConstrainedItemBorderLayoutEditPolicy {

	/** the key for the Port Alignment EditPolicy */
	public static final String AFFIXED_CHILD_ALIGNMENT_ROLE = "affixed node alignment editpolicy"; //$NON-NLS-1$

	/**
	 * Creates command for <tt>REQ_ALIGN_CHILDREN</tt> requests only; all others
	 * requests are ignored
	 * 
	 * @see #getCommand(Request)
	 */
	@Override
	public Command getCommand(Request request) {
		if(REQ_ALIGN_CHILDREN.equals(request.getType())) {
			return super.getCommand(request);
		}

		return null;
	}
}
