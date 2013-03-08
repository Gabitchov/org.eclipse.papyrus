/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.pkg.edit.policy;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 * Customization of the DND edit policy for the Package Diagram.
 * 
 * Never use specific drop implemented in ClassDiagram, which are 
 * related to elements that are not used currently in PackageDiagram.
 * </pre>
 */
public class CustomDragDropEditPolicy extends PackageDiagramDragDropEditPolicy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Set<Integer> getDroppableElementVisualId() {
		Set<Integer> droppableElementsVisualID = new HashSet<Integer>();
		return droppableElementsVisualID;
	}
}
