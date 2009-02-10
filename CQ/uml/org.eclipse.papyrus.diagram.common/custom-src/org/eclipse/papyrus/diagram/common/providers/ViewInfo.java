/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.providers;

import java.util.Collection;

// TODO: Auto-generated Javadoc
/**
 * The Interface ViewInfo.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public interface ViewInfo {

	/** The None. */
	public static int None = -1;

	/** The Head. */
	public static int Head = 0;

	/** The Node. */
	public static int Node = 2;

	/** The Edge. */
	public static int Edge = 3;

	/** The Label. */
	public static int Label = 4;

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
}
