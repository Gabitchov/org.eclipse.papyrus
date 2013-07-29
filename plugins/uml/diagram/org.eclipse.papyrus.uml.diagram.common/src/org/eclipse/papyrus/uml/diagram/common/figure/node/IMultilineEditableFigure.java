/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;

/**
 * This interface is used to indicate that this kind of figure contains a
 * multiline field. It provides method to edit and the position to edit this
 * field.
 */
public interface IMultilineEditableFigure extends IFigure {

	/**
	 * Gets the text of the multi-line field
	 * 
	 * @return the text
	 */
	public String getText();

	/**
	 * Gets the location of the multi-line field
	 * 
	 * @return the edition location
	 */
	public Point getEditionLocation();

}
