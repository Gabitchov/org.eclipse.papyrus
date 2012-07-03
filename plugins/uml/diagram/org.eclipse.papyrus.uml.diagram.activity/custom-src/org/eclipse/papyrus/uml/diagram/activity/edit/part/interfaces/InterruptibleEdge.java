/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *   Arthur Daussy Bug 366159 - [ActivityDiagram] Activity Diagram should be able to handle correctly Interruptible Edge
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.part.interfaces;

import org.eclipse.gmf.runtime.notation.Node;

/**
 * Interfaces that need to be implemented by all activity edges
 * 
 * @author arthur daussy
 * 
 */
public interface InterruptibleEdge {

	/**
	 * @return return the visual ID of the edit which should hold the InterruptibleEdge icon
	 */
	public int getInterruptibleEdgeIconVisualID();

	/**
	 * Get the Interruptible edge icon or null if not set
	 * 
	 * @return
	 */
	public Node getInterrutibleEgdeIcon();
}
