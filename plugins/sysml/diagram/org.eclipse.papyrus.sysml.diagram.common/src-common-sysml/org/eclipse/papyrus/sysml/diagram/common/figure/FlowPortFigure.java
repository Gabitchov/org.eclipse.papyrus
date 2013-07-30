/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.common.figure;

import org.eclipse.papyrus.uml.diagram.common.figure.node.AffixedNamedElementFigure;
import org.eclipse.swt.graphics.Image;


/**
 * Figure for Port representation.
 */
public class FlowPortFigure extends AffixedNamedElementFigure {

	/**
	 * Set the image in FlowPort figure.
	 * 
	 * @param image
	 *        the image to show in the FlowPort
	 */
	public void setImage(Image image) {
		setIcon(image);
	}
}
