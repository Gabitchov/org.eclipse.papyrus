/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.domain.policies;

import org.eclipse.papyrus.uml.diagram.domain.edit.policy.DomainDiagramDragDropEditPolicy;

/**
 * <pre>
 * Customization of the DND edit policy for the Package Diagram.
 * 
 * Never use specific drop implemented in ClassDiagram, which are 
 * related to elements that are not used currently in PackageDiagram.
 * </pre>
 */
public class CustomDragDropEditPolicy extends DomainDiagramDragDropEditPolicy {

	
	
}
