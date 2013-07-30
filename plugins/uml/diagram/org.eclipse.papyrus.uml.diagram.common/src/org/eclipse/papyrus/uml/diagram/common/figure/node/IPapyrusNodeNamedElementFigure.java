/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import org.eclipse.draw2d.Label;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

public interface IPapyrusNodeNamedElementFigure extends IPapyrusNodeUMLElementFigure {

	/**
	 * Sets the qualified name.
	 * 
	 * @param qualifiedName
	 *        the qualified name
	 */
	public void setQualifiedName(String qualifiedName);

	/**
	 * return the label that contains the qualified name.
	 * 
	 * @return the label that contains the qualified name
	 */
	public Label getQualifiedNameLabel();

	/**
	 * Get the label containing the tagged value
	 * 
	 * @return
	 */
	public Label getTaggedLabel();

	/**
	 * Sets the depth.
	 * 
	 * @param depth
	 *        the new depth
	 */
	public void setDepth(int depth);

	/**
	 * Gets the name label.
	 * 
	 * @return the name label
	 */
	public WrappingLabel getNameLabel();

	/**
	 * display or not the icon associated to the label
	 * 
	 * @param displayNameLabelIcon
	 */

	public void setNameLabelIcon(boolean displayNameLabelIcon);

}
