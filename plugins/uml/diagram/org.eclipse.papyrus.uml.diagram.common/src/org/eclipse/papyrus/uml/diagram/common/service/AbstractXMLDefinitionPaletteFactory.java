/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.service;

import org.w3c.dom.Node;

/**
 * Basic factory to create elements from the xml definition of the palette
 */
public abstract class AbstractXMLDefinitionPaletteFactory {

	/**
	 * action when visiting a content node
	 * 
	 * @param node
	 *        the node to visit
	 */
	public abstract void traverseContentNode(Node node);

	/**
	 * action when visiting a drawer node
	 * 
	 * @param node
	 *        the node to visit
	 */
	public abstract void traverseDrawerNode(Node node);

	/**
	 * action when visiting a drawer node
	 * 
	 * @param node
	 *        the node to visit
	 */
	public abstract void traverseToolEntryNode(Node node);

	/**
	 * action when visiting a drawer node
	 * 
	 * @param node
	 *        the node to visit
	 */
	public abstract void traverseStackNode(Node node);

	/**
	 * action when visiting a drawer node
	 * 
	 * @param node
	 *        the node to visit
	 */
	public abstract void traverseSeparatorNode(Node node);

	/**
	 * action when visiting a aspect tool node
	 * 
	 * @param node
	 *        the node to visit
	 */
	public abstract void traverseAspectToolEntryNode(Node node);

}
