/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.prototype.infra.gmfdiag.css.custom;


public interface UMLCustomStyle {

	/**
	 * Indicates whether the element's icon should be displayed in the diagram
	 */
	boolean getCSSElementIcon();

	/**
	 * Indicates whether a shadow should be displayed under the element in the diagram
	 * 
	 * @return
	 */
	boolean getCSSShadow();

	/**
	 * Indicates the depth of the element's qualified name to display
	 * 
	 * Full (0)
	 * None (-1000)
	 * Integer
	 */
	int getCSSQualifiedNameDepth();

	/**
	 * Indicates the way the stereotype should be displayed
	 * 
	 * Text
	 * Text and Icon
	 * Icon
	 * Shape
	 */
	String getCSSStereotypeDisplay();

	/**
	 * If the stereotype display is set to Text, indicates the text alignment
	 * 
	 * Vertical
	 * Horizontal
	 */
	String getCSSTextAlignment();

	/**
	 * Returns the position of the stereotype properties
	 * 
	 * Compartment
	 * With braces
	 * Comment
	 */
	String getCSSDisplayPlace();

}
