package org.eclipse.papyrus.sysml.modelexplorer.filter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;

public class CommandFilter {

	private static List<IElementType> visibleCommands;

	public static List<IElementType> getVisibleCommands() {
		if(visibleCommands == null) {
			visibleCommands = new ArrayList<IElementType>();

			// visibleCommands.add(SysMLElementTypes.ALLOCATE);
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
			visibleCommands.add(SysMLElementTypes.FLOW_PROPERTY);
			visibleCommands.add(SysMLElementTypes.FLOW_SPECIFICATION);
			// visibleCommands.add(SysMLElementTypes.ITEM_FLOW);
			visibleCommands.add(SysMLElementTypes.PROBLEM);
			visibleCommands.add(SysMLElementTypes.RATIONALE);
			visibleCommands.add(SysMLElementTypes.REQUIREMENT);
			visibleCommands.add(SysMLElementTypes.UNIT);
			visibleCommands.add(SysMLElementTypes.VALUE_TYPE);
			// visibleCommands.add(SysMLElementTypes.VALUE_TYPE_ENUMERATION);
			// visibleCommands.add(SysMLElementTypes.VALUE_TYPE_PRIMITIVE_TYPE);
			// visibleCommands.add(SysMLElementTypes.VERIFY);
			visibleCommands.add(SysMLElementTypes.VIEW);
			visibleCommands.add(SysMLElementTypes.VIEW_POINT);
			// visibleCommands.add(SysMLElementTypes.SATISFY);
		}

		return visibleCommands;
	}
}
