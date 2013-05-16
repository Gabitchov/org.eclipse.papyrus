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
import java.util.Collections;
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

	/**
	 * Singleton instance
	 */
	public static final SysmlCommandFilter INSTANCE = new SysmlCommandFilter();

	private SysmlCommandFilter() {
		//to prevent instantiation
	}

	private List<IElementType> visibleCommands;

	public List<IElementType> getVisibleCommands() {
		if(visibleCommands == null) {
			List<IElementType> localVisibleCommands = new ArrayList<IElementType>();

			localVisibleCommands = new ArrayList<IElementType>();

			localVisibleCommands.add(SysMLElementTypes.ACTOR_PART_PROPERTY);
			// localVisibleCommands.add(SysMLElementTypes.ALLOCATE);
			// localVisibleCommands.add(SysMLElementTypes.ASSOCIATION);
			// localVisibleCommands.add(SysMLElementTypes.ASSOCIATION_COMPOSITE);
			// localVisibleCommands.add(SysMLElementTypes.ASSOCIATION_COMPOSITE_DIRECTED);
			// localVisibleCommands.add(SysMLElementTypes.ASSOCIATION_NONE);
			// localVisibleCommands.add(SysMLElementTypes.ASSOCIATION_NONE_DIRECTED);
			// localVisibleCommands.add(SysMLElementTypes.ASSOCIATION_SHARED);
			// localVisibleCommands.add(SysMLElementTypes.ASSOCIATION_SHARED_DIRECTED);
			localVisibleCommands.add(SysMLElementTypes.BLOCK);
			// localVisibleCommands.add(SysMLElementTypes.CONFORM);
			localVisibleCommands.add(SysMLElementTypes.CONSTRAINT_BLOCK);
			localVisibleCommands.add(SysMLElementTypes.CONSTRAINT_PROPERTY);
			// localVisibleCommands.add(SysMLElementTypes.COPY);
			// localVisibleCommands.add(SysMLElementTypes.DERIVE_REQT);
			localVisibleCommands.add(SysMLElementTypes.DIMENSION);
			localVisibleCommands.add(SysMLElementTypes.FLOW_PORT);
			localVisibleCommands.add(SysMLElementTypes.FLOW_PORT_IN_OUT);
			localVisibleCommands.add(SysMLElementTypes.FLOW_PORT_IN);
			localVisibleCommands.add(SysMLElementTypes.FLOW_PORT_OUT);
			// localVisibleCommands.add(SysMLElementTypes.FLOW_PORT_NA);
			localVisibleCommands.add(SysMLElementTypes.FLOW_PROPERTY);
			localVisibleCommands.add(SysMLElementTypes.FLOW_SPECIFICATION);
			// localVisibleCommands.add(SysMLElementTypes.ITEM_FLOW);
			localVisibleCommands.add(SysMLElementTypes.PART_PROPERTY);
			localVisibleCommands.add(SysMLElementTypes.PROBLEM);
			localVisibleCommands.add(SysMLElementTypes.RATIONALE);
			localVisibleCommands.add(SysMLElementTypes.REFERENCE_PROPERTY);
			localVisibleCommands.add(SysMLElementTypes.REQUIREMENT);
			// localVisibleCommands.add(SysMLElementTypes.SATISFY);
			localVisibleCommands.add(SysMLElementTypes.UNIT);
			localVisibleCommands.add(SysMLElementTypes.VALUE_PROPERTY);
			localVisibleCommands.add(SysMLElementTypes.VALUE_TYPE);
			// localVisibleCommands.add(SysMLElementTypes.VALUE_TYPE_ENUMERATION);
			// localVisibleCommands.add(SysMLElementTypes.VALUE_TYPE_PRIMITIVE_TYPE);
			// localVisibleCommands.add(SysMLElementTypes.VERIFY);
			localVisibleCommands.add(SysMLElementTypes.VIEW);
			localVisibleCommands.add(SysMLElementTypes.VIEW_POINT);

			// UMLElementTypes.PROPERTY is required by ConstraintBlock Parameter 
			localVisibleCommands.add(UMLElementTypes.PROPERTY);

			this.visibleCommands = Collections.unmodifiableList(localVisibleCommands);

		}

		return visibleCommands;
	}
}
