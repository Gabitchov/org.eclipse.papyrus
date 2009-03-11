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

import org.eclipse.draw2d.LineBorder;
import org.eclipse.papyrus.editor.Activator;
import org.eclipse.swt.graphics.RGB;

// TODO: Auto-generated Javadoc
/**
 * Figure to represent primitive types.
 */
public class ComponentFigure extends ClassifierFigure {

	/**
	 * Instantiates a new component figure.
	 */
	public ComponentFigure() {
		this("Component");
	}

	/**
	 * constructor to create a TaggedElementFigure.
	 * 
	 * @param keyword
	 *            the keyword
	 */
	public ComponentFigure(String keyword) {
		super();
		this.createTagLabel(keyword);
		this.setOpaque(true); // non-transparent figure
		this.setBorder(new LineBorder(Activator.colorManager.get(new RGB(177, 207, 229))));
		this.setBackgroundColor(Activator.colorManager.get(new RGB(235, 248, 255)));
		this.setForegroundColor(Activator.colorManager.get(new RGB(177, 207, 229)));
		// The area accepting inner figures.
	}
}