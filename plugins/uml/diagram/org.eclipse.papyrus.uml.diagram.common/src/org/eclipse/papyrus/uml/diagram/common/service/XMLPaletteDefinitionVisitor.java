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
 *  Laurent Wouters (CEA LIST) laurent.wouters@cea.fr - Refactoring
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.service;

import org.w3c.dom.Node;

/**
 * Represents a handler of events fired when walking through the XML definition of a palette
 */
public interface XMLPaletteDefinitionVisitor {

	/**
	 * action when visiting a content node
	 * 
	 * @param node
	 *        the node to visit
	 */
	void onContent(Node node);

	/**
	 * action when visiting a drawer node
	 * 
	 * @param node
	 *        the node to visit
	 */
	void onDrawer(Node node);

	/**
	 * action when visiting a drawer node
	 * 
	 * @param node
	 *        the node to visit
	 */
	void onToolEntry(Node node);

	/**
	 * action when visiting a drawer node
	 * 
	 * @param node
	 *        the node to visit
	 */
	void onStack(Node node);

	/**
	 * action when visiting a drawer node
	 * 
	 * @param node
	 *        the node to visit
	 */
	void onSeparator(Node node);

	/**
	 * action when visiting a aspect tool node
	 * 
	 * @param node
	 *        the node to visit
	 */
	void onAspectToolEntry(Node node);

}
