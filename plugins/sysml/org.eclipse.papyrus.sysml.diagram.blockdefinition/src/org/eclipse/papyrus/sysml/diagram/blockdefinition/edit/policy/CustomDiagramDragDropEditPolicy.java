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
package org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy;

import java.util.Collections;
import java.util.Set;

import org.eclipse.papyrus.gmf.diagram.common.edit.policy.CommonDiagramDragDropEditPolicy;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.dnd.helper.CustomLinkMappingHelper;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.CustomGraphicalTypeRegistry;

/**
 * Custom diagram drag drop edit policy for elements handling drop in the Block Definition Diagram.
 */
public class CustomDiagramDragDropEditPolicy extends CommonDiagramDragDropEditPolicy {

	/** Default constructor. */
	public CustomDiagramDragDropEditPolicy() {
		super(new CustomLinkMappingHelper());
		registry = new CustomGraphicalTypeRegistry();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Set<String> getSpecificDropBehaviorTypes() {
		return Collections.emptySet();
	}
}
