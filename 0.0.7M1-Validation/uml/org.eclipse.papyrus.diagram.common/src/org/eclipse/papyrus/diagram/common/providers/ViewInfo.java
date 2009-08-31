/*******************************************************************************
 * Copyright (c) 2009 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) – Initial implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.providers;

import java.util.Collection;

/**
 * A ViewInfo represents the information to be used in the filtering of views in diagrams. It has
 * information of the IElementType it represents, its visualID in the diagram, its parent figure and
 * label to be shown in the filtering dialog. <br>
 * Having information about the parent figure allows the creation of hierarchical structures of
 * ViewInfo elements.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * @NOT-generated
 */
public interface ViewInfo {

	/** The None. */
	public static int None = -1;

	public static String NONE_LITERAL = "None";

	/** The Head. */
	public static int Head = 0;

	public static String HEAD_LITERAL = "Head";

	/** The Node. */
	public static int Node = 2;

	public static String NODE_LITERAL = "Node";

	/** The Edge. */
	public static int Edge = 3;

	public static String EDGE_LITERAL = "Edge";

	/** The Label. */
	public static int Label = 4;

	public static String LABEL_LITERAL = "Label";

	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	int getType();

	/**
	 * Gets the visual id.
	 * 
	 * @return the visual id
	 */
	int getVisualID();

	/**
	 * Gets the children.
	 * 
	 * @return the children
	 */
	Collection<ViewInfo> getChildren();

	/**
	 * Gets the label.
	 * 
	 * @return the label
	 */
	String getLabel();

	/**
	 * Gets the parent.
	 * 
	 * @return the parent
	 */
	ViewInfo getParent();

	/**
	 * Sets the type.
	 * 
	 * @param type
	 *            the new type
	 */
	void setType(int type);

	/**
	 * Sets the visual id.
	 * 
	 * @param visualID
	 *            the new visual id
	 */
	void setVisualID(int visualID);

	/**
	 * Sets the children.
	 * 
	 * @param children
	 *            the new children
	 */
	void setChildren(Collection<ViewInfo> children);

	/**
	 * Sets the label.
	 * 
	 * @param label
	 *            the new label
	 */
	void setLabel(String label);

	/**
	 * Sets the parent.
	 * 
	 * @param parent
	 *            the new parent
	 */
	void setParent(ViewInfo parent);

	/**
	 * Adds the node.
	 * 
	 * @param parentVisualID
	 *            the parent visual id
	 * @param info
	 *            the info
	 * 
	 * @return true, if successful
	 */
	boolean addNode(int parentVisualID, ViewInfo info);

	/**
	 * True if this view info can be selected to be filtered.
	 * 
	 * @return
	 */
	boolean isSelectable();
}
