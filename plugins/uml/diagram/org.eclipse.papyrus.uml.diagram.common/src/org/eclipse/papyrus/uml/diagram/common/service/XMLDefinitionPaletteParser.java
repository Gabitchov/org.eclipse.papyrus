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
import org.w3c.dom.NodeList;

/**
 * Parser for the local definition of palettes.
 */
public class XMLDefinitionPaletteParser implements IPapyrusPaletteConstant {

	/** factory used to create elements from the parsed xml file */
	final protected AbstractXMLDefinitionPaletteFactory factory;

	/**
	 * Create a new XMLDefinitionPaletteParser
	 * 
	 * @param factory
	 *        the factory used to create elements from the parsing of the
	 *        xml file
	 */
	public XMLDefinitionPaletteParser(AbstractXMLDefinitionPaletteFactory factory) {
		this.factory = factory;
	}

	/**
	 * Parse the given node, assuming its type is a palette definition
	 * 
	 * @param node
	 *        the node to parse
	 */
	public void parsePaletteDefinition(Node paletteDefinitionNode) {
		NodeList nodes = paletteDefinitionNode.getChildNodes();
		for(int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if(CONTENT.equals(node.getNodeName())) {
				factory.traverseContentNode(node);
				parsePaletteContent(node);
			}
		}
	}

	/**
	 * Parse the given node, assuming its type is a palette content
	 * 
	 * @param node
	 *        the node to parse
	 * @param root
	 *        the palette root to fill
	 */
	public void parsePaletteContent(Node paletteContentNode) {
		NodeList nodes = paletteContentNode.getChildNodes();
		for(int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			String name = node.getNodeName();
			if(DRAWER.equals(name)) {
				parserDrawerNode(node);
			} else if(STACK.equals(name)) {
				parserStackNode(node);
			} else if(SEPARATOR.equals(name)) {
				parseSeparatorNode(node);
			} else if(TOOL.equals(name)) {
				parseToolNode(node);
			} else if(ASPECT_TOOL.equals(name)) {
				parseAspectToolNode(node);
			}

		}
	}

	/**
	 * Parse the given aspect node, assuming its type is a palette aspect tool
	 * 
	 * @param node
	 *        the node to parse
	 */
	public void parseAspectToolNode(Node node) {
		factory.traverseAspectToolEntryNode(node);
	}

	/**
	 * Parse the given node, assuming its type is a palette drawer
	 * 
	 * @param node
	 *        the node to parse
	 */
	public void parserDrawerNode(Node node) {
		factory.traverseDrawerNode(node);
		if(node.getChildNodes().getLength() > 0) {
			parsePaletteContent(node);
		}
		// return entry;
	}

	/**
	 * Parse the given node, assuming its type is a stack
	 * 
	 * @param node
	 *        the node to parse
	 */
	public void parserStackNode(Node node) {
		factory.traverseStackNode(node);

		if(node.getChildNodes().getLength() > 0) {
			parsePaletteContent(node);
		}
	}

	/**
	 * Parse the given node, assuming its type is a node
	 * 
	 * @param node
	 *        the node to parse
	 */
	public void parseToolNode(Node node) {
		factory.traverseToolEntryNode(node);

		if(node.getChildNodes().getLength() > 0) {
			parsePaletteContent(node);
		}
	}

	/**
	 * Parse the given node, assuming its type is a separator
	 * 
	 * @param node
	 *        the node to parse
	 */
	public void parseSeparatorNode(Node node) {
		factory.traverseSeparatorNode(node);

		if(node.getChildNodes().getLength() > 0) {
			parsePaletteContent(node);
		}
	}

}
