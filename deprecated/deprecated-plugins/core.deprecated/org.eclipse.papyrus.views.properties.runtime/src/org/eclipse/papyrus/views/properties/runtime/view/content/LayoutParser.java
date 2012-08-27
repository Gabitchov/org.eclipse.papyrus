/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime.view.content;

import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 * Utility class to parse layouts. <BR>
 * Nota: Entry point for future possible extension point</BR>
 */
public class LayoutParser {

	/** kind for grid layout (default value) */
	public static final String GRID_KIND = "Grid";

	/**
	 * Parses the content of the layout node and returns the descriptor
	 * 
	 * @param layoutNode
	 *        the node to parse
	 * @return the created layout descriptor
	 */
	public static LayoutDescriptor parseLayoutNode(Node layoutNode) {
		// default layout
		if(layoutNode == null) {
			return new GridLayoutDescriptor();
		}
		String type = getType(layoutNode);
		if(GRID_KIND.equals(type)) {
			NamedNodeMap attributes = layoutNode.getAttributes();
			if(attributes == null) {
				Activator.log.warn("Impossible to parse the attribute set for grid layout: " + layoutNode);
				return new GridLayoutDescriptor();
			}

			int numColumns = 2;
			Node numColumnsNode = attributes.getNamedItem("numColumns");
			if(numColumnsNode != null) {
				try {
					numColumns = Integer.parseInt(numColumnsNode.getNodeValue());
				} catch (NumberFormatException e) {
					Activator.log.error(e);
				}
			}

			boolean sameWidth = true;
			Node sameWidthNode = attributes.getNamedItem("sameWidth");
			if(sameWidthNode != null) {
				sameWidth = Boolean.parseBoolean(sameWidthNode.getNodeValue());
			}

			return new GridLayoutDescriptor(numColumns, sameWidth);
		}

		return new GridLayoutDescriptor();
	}

	/**
	 * Returns the kind of layout
	 * 
	 * @param layoutNode
	 *        the node to parse
	 * @return the kind of layout
	 */
	private static String getType(Node layoutNode) {
		NamedNodeMap attributes = layoutNode.getAttributes();
		if(attributes == null) {
			Activator.log.warn("Impossible to parse the attribute set for layout node: " + layoutNode);
			return GRID_KIND;
		}
		Node kindNode = attributes.getNamedItem("kind");
		if(kindNode == null) {
			Activator.log.warn("Impossible to find the kind attribute for the layout node: " + layoutNode);
			return GRID_KIND;
		}

		return kindNode.getNodeValue();
	}
}
