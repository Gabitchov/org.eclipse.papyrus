/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alexia Allanic (Atos Origin) alexia.allanic@atosorigin.com - LayouttoolInterface Interface
 *
 *****************************************************************************/

package org.eclipse.papyrus.layouttool;

import java.util.Map;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;

/**
 * The class LayouttoolInterface.
 */
public interface LayouttoolInterface {

	/**
	 * Get the registered editor class.
	 * 
	 * @return Class
	 */
	Class getEditorClass();

	/**
	 * Is a node.
	 * 
	 * @param element
	 *        the element
	 * 
	 * @return true, if the EditPart is a node
	 */
	boolean isNode(EditPart element);

	/**
	 * Is a relationship.
	 * 
	 * @param element
	 *        the element
	 * 
	 * @return true, if the EditPart is a relationship
	 */
	boolean isRelationship(EditPart element);

	/**
	 * Get bounds of EditPart.
	 * 
	 * @param element
	 *        the Node to have their coordinates
	 * 
	 * @return Rectangle coordinates of the node
	 */
	Rectangle getBounds(EditPart element);

	/**
	 * Get source of relationship.
	 * 
	 * @param element
	 *        relationship to have his source
	 * 
	 * @return EditPart source node of the relationship
	 */
	EditPart getSource(EditPart element);

	/**
	 * Get destination of relationship.
	 * 
	 * @param element
	 *        relationship to have his destination
	 * 
	 * @return EditPart destination node of the relationship
	 */
	EditPart getTarget(EditPart element);

	/**
	 * Get layout area.
	 * 
	 * @param element
	 *        the element
	 * 
	 * @return Rectangle coordinates of layout area
	 */
	Rectangle getLayoutArea(EditPart[] element);

	/**
	 * Execute layout.
	 * 
	 * @param map
	 *        the map
	 */
	void execute(Map<EditPart, Rectangle> map);

}
