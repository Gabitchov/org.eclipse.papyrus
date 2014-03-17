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
import org.w3c.dom.NodeList;

/**
 * Walks through the XML definition of a palette and fires events on nodes
 */
public class XMLPaletteDefinitionWalker implements IPapyrusPaletteConstant {

	/**
	 * The handler for the walking events
	 */
	final private XMLPaletteDefinitionVisitor handler;

	/**
	 * Initializes this walker
	 * 
	 * @param handler The handler to be used for the walking events
	 */
	public XMLPaletteDefinitionWalker(XMLPaletteDefinitionVisitor handler) {
		this.handler = handler;
	}

	/**
	 * Parse the given node, assuming its type is a palette definition
	 * 
	 * @param node
	 *        the node to parse
	 */
	public void walk(Node paletteDefinitionNode) {
		NodeList nodes = paletteDefinitionNode.getChildNodes();
		for(int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if(CONTENT.equals(node.getNodeName())) {
				handler.onContent(node);
				walkContentNode(node);
			}
		}
	}

	/**
	 * Parse the given node, assuming its type is a palette content
	 * 
	 * @param node
	 *        the node to parse
	 */
	private void walkContentNode(Node paletteContentNode) {
		NodeList nodes = paletteContentNode.getChildNodes();
		for(int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			String name = node.getNodeName();
			if(DRAWER.equals(name)) {
				walkDrawerNode(node);
			} else if(STACK.equals(name)) {
				walkStackNode(node);
			} else if(SEPARATOR.equals(name)) {
				walkSeparatorNode(node);
			} else if(TOOL.equals(name)) {
				walkToolNode(node);
			} else if(ASPECT_TOOL.equals(name)) {
				walkAspectToolNode(node);
			}

		}
	}

	/**
	 * Parse the given aspect node, assuming its type is a palette aspect tool
	 * 
	 * @param node
	 *        the node to parse
	 */
	private void walkAspectToolNode(Node node) {
		handler.onAspectToolEntry(node);
	}

	/**
	 * Parse the given node, assuming its type is a palette drawer
	 * 
	 * @param node
	 *        the node to parse
	 */
	private void walkDrawerNode(Node node) {
		handler.onDrawer(node);
		if(node.getChildNodes().getLength() > 0) {
			walkContentNode(node);
		}
	}

	/**
	 * Parse the given node, assuming its type is a stack
	 * 
	 * @param node
	 *        the node to parse
	 */
	private void walkStackNode(Node node) {
		handler.onStack(node);
		if(node.getChildNodes().getLength() > 0) {
			walkContentNode(node);
		}
	}

	/**
	 * Parse the given node, assuming its type is a node
	 * 
	 * @param node
	 *        the node to parse
	 */
	private void walkToolNode(Node node) {
		handler.onToolEntry(node);
		if(node.getChildNodes().getLength() > 0) {
			walkContentNode(node);
		}
	}

	/**
	 * Parse the given node, assuming its type is a separator
	 * 
	 * @param node
	 *        the node to parse
	 */
	private void walkSeparatorNode(Node node) {
		handler.onSeparator(node);
		if(node.getChildNodes().getLength() > 0) {
			walkContentNode(node);
		}
	}

}
