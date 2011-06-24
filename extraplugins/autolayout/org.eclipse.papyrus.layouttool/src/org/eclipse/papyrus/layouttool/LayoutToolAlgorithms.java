/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alexia Allanic (Atos Origin) alexia.allanic@atosorigin.com - LayoutToolAlgorithms Implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.layouttool;

import org.eclipse.swt.graphics.Image;
import org.eclipse.zest.layouts.algorithms.AbstractLayoutAlgorithm;

/**
 * The class LayoutToolAlgorithms contains all information needed for an algorithm.
 */
public class LayoutToolAlgorithms {

	/** The algorithm. */
	private AbstractLayoutAlgorithm algorithm = null;

	/** The name. */
	private String name = null;

	/** The icon. */
	private Image icon = null;

	/** The tool tip text. */
	private String toolTipText = null;

	/** The path. */
	private String path = null;

	/**
	 * Gets the path.
	 * 
	 * @return path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Sets the path.
	 * 
	 * @param path
	 *        the path
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Gets the tool tip text.
	 * 
	 * @return toolTip text
	 */
	public String getToolTipText() {
		return toolTipText;
	}

	/**
	 * Sets the tool tip text.
	 * 
	 * @param toolTipText
	 *        the toolTip text
	 */
	public void setToolTipText(String toolTipText) {
		this.toolTipText = toolTipText;
	}

	/**
	 * Sets the algorithm.
	 * 
	 * @param algorithm
	 *        the algorithm to apply
	 */
	public void setAlgorithm(AbstractLayoutAlgorithm algorithm) {
		this.algorithm = algorithm;
	}

	/**
	 * Gets the algorithm.
	 * 
	 * @return algorithm
	 */
	public AbstractLayoutAlgorithm getAlgorithm() {
		return algorithm;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *        the name of the algorithm
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the name.
	 * 
	 * @return name of the algorithm
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the icon.
	 * 
	 * @param icon
	 *        display on the toolbar
	 */
	public void setIcon(Image icon) {
		this.icon = icon;
	}

	/**
	 * Gets the icon.
	 * 
	 * @return icon
	 */
	public Image getIcon() {
		return icon;
	}

}
