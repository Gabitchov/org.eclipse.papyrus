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
package org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.service.types.matcher.BlockMatcher;

/**
 * Custom drag'n'drop edit policy when the target edit part is the diagram itself.
 * <P>
 * In this case, it should be impossible to drop elements in this Internal Block Diagram, except the block context of that diagram, if it is not
 * already displayed in the diagram.
 * </P>
 */
public class CustomDiagramDropEditPolicy extends CustomDragDropEditPolicy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Set<String> getSpecificDropBehaviorTypes() {
		Set<String> specificDropBehaviorTypes = super.getSpecificDropBehaviorTypes();
		specificDropBehaviorTypes.add(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID);
		return specificDropBehaviorTypes;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getSpecificDropCommand(DropObjectsRequest dropRequest, EObject droppedEObject, String nodeType, String edgeType) {
		if(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID.equals(nodeType)) {
			// should not be possible to execute, unless 2 conditions: 
			// 1. the block is the context of the diagram
			// 2. the block is not already displayed in the diagram
			BlockMatcher matcher = new BlockMatcher();
			if(!matcher.matches(droppedEObject)) { // should check for additional free elements, like comments, constraints.
				return UnexecutableCommand.INSTANCE;
			}

			// this is a block. checking if the element context of the diagram is the block dropped
			Object model = getHost().getModel();
			if(model instanceof Diagram) { // should be...
				EObject element = ((Diagram)model).getElement();
				if(droppedEObject.equals(element)) {
					// check no view exists for this block already
					@SuppressWarnings("unchecked")
					Iterator<View> it = ((Diagram)model).getChildren().iterator();
					while(it.hasNext()) {
						View view = it.next();
						if(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID.equals(view.getType())) {
							// there is already a block displayed in the diagram. Should be unexecutable.
							return UnexecutableCommand.INSTANCE;
						}
					}
				} else {
					// block that do not corresponds to block the context of the diagram.
					return UnexecutableCommand.INSTANCE;
				}
			} else {
				return UnexecutableCommand.INSTANCE;
			}

			// it should be possible to create a view for the block now. It is not displayed and this is the context of the diagram
			return getDefaultDropNodeCommand(nodeType, dropRequest.getLocation(), droppedEObject);

		}
		return super.getSpecificDropCommand(dropRequest, droppedEObject, nodeType, edgeType);
	}
}
