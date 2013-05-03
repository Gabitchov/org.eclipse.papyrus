/*****************************************************************************
 * Copyright (c) 2011-2012 CEA LIST.
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
package org.eclipse.papyrus.sysml.service.types.filter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.papyrus.uml.service.types.filter.ICommandFilter;

/**
 * Filter for available Sysml commands. Moved from oep.sysml.modelexplorer
 * 
 * @author JC236769
 * 
 */
public class SysmlCommandFilter implements ICommandFilter {

	private List<IElementType> visibleCommands;

	public List<IElementType> getVisibleCommands() {
		if(visibleCommands == null) {
			visibleCommands = new ArrayList<IElementType>();

			visibleCommands.add(SysMLElementTypes.ACTOR_PART_PROPERTY);
			// visibleCommands.add(SysMLElementTypes.ALLOCATE);
			// visibleCommands.add(SysMLElementTypes.ASSOCIATION);
			// visibleCommands.add(SysMLElementTypes.ASSOCIATION_COMPOSITE);
			// visibleCommands.add(SysMLElementTypes.ASSOCIATION_COMPOSITE_DIRECTED);
			// visibleCommands.add(SysMLElementTypes.ASSOCIATION_NONE);
			// visibleCommands.add(SysMLElementTypes.ASSOCIATION_NONE_DIRECTED);
			// visibleCommands.add(SysMLElementTypes.ASSOCIATION_SHARED);
			// visibleCommands.add(SysMLElementTypes.ASSOCIATION_SHARED_DIRECTED);
			visibleCommands.add(SysMLElementTypes.BLOCK);
			// visibleCommands.add(SysMLElementTypes.CONFORM);
			visibleCommands.add(SysMLElementTypes.CONSTRAINT_BLOCK);
			visibleCommands.add(SysMLElementTypes.CONSTRAINT_PROPERTY);
			// visibleCommands.add(SysMLElementTypes.COPY);
			// visibleCommands.add(SysMLElementTypes.DERIVE_REQT);
			visibleCommands.add(SysMLElementTypes.DIMENSION);
			visibleCommands.add(SysMLElementTypes.FLOW_PORT);
			visibleCommands.add(SysMLElementTypes.FLOW_PORT_IN_OUT);
			visibleCommands.add(SysMLElementTypes.FLOW_PORT_IN);
			visibleCommands.add(SysMLElementTypes.FLOW_PORT_OUT);
			// visibleCommands.add(SysMLElementTypes.FLOW_PORT_NA);
			visibleCommands.add(SysMLElementTypes.FLOW_PROPERTY);
			visibleCommands.add(SysMLElementTypes.FLOW_SPECIFICATION);
			// visibleCommands.add(SysMLElementTypes.ITEM_FLOW);
			visibleCommands.add(SysMLElementTypes.PART_PROPERTY);
			visibleCommands.add(SysMLElementTypes.PROBLEM);
			visibleCommands.add(SysMLElementTypes.RATIONALE);
			visibleCommands.add(SysMLElementTypes.REFERENCE_PROPERTY);
			visibleCommands.add(SysMLElementTypes.REQUIREMENT);
			// visibleCommands.add(SysMLElementTypes.SATISFY);
			visibleCommands.add(SysMLElementTypes.UNIT);
			visibleCommands.add(SysMLElementTypes.VALUE_PROPERTY);
			visibleCommands.add(SysMLElementTypes.VALUE_TYPE);
			// visibleCommands.add(SysMLElementTypes.VALUE_TYPE_ENUMERATION);
			// visibleCommands.add(SysMLElementTypes.VALUE_TYPE_PRIMITIVE_TYPE);
			// visibleCommands.add(SysMLElementTypes.VERIFY);
			visibleCommands.add(SysMLElementTypes.VIEW);
			visibleCommands.add(SysMLElementTypes.VIEW_POINT);

			// UMLElementTypes.PROPERTY is required by ConstraintBlock Parameter 
			visibleCommands.add(UMLElementTypes.PROPERTY);

		}

		return visibleCommands;
	}
}
