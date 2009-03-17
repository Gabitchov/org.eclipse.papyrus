/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
package org.eclipse.papyrus.diagram.common.figure.node;

import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.swt.graphics.RGB;

/**
 * Figure to represent primitive types
 */
public class DataTypeFigure extends ClassifierFigure {

	public DataTypeFigure() {
		this("DataType");
	}

	/**
	 * constructor to create a TaggedElementFigure.
	 * 
	 * @param keyword
	 */
	public DataTypeFigure(String keyword) {
		super();
		this.createTagLabel(keyword);

		this.setOpaque(true); // non-transparent figure
		this.setBackgroundColor(Activator.colorManager.get(new RGB(235, 248, 255)));
		this.setForegroundColor(Activator.colorManager.get(new RGB(177, 207, 229)));
		// The area accepting inner figures.
	}

}