/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.common.edit.policy;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.DuplicateRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.DuplicatePasteEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;


/**
 * Specific edit policy for compartment, to forbid the duplication of ports as affixed children. 
 * @see bug 375041
 */
public class CustomDuplicatePasteEditPolicy extends DuplicatePasteEditPolicy {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command constructDuplicationCommand(List notationViewsToDuplicate, Set elementsToDuplicate, DuplicateRequest request, TransactionalEditingDomain editingDomain) {
		if(notationViewsToDuplicate !=null && !notationViewsToDuplicate.isEmpty()) {
			for(Object o : notationViewsToDuplicate) {
				if(o instanceof View) {
					String type = ((View)o).getType();
					if(SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID.equals(type) || UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID.equals(type)) {
						return UnexecutableCommand.INSTANCE;
					}
				}
			}
		}
		
		
		return super.constructDuplicationCommand(notationViewsToDuplicate, elementsToDuplicate, request, editingDomain);
	}
	
}

	 