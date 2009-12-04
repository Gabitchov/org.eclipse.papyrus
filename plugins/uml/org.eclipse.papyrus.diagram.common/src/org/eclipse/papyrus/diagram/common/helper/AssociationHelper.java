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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.common.helper;

import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * this class is used to help design to code the managment of Association
 * 
 * 
 */
public class AssociationHelper {

	public static int source = 0;

	public static int target = 1;

	/**
	 * use to change the type of the end with the new type
	 * 
	 * @param end
	 *        source or target?
	 * @param association
	 *        the association that is reconnected
	 * @param newType
	 *        the new source or the new target
	 * @return the CommandResult
	 */
	public static CommandResult reconnect(int end, Association association, Type newType) {

		((Property)association.getMemberEnds().get(end)).setType(newType);

		return CommandResult.newOKCommandResult(association);
	}

}
