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
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.sequence.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.papyrus.diagram.common.draw2d.LifelineDotLineFigure;

/**
 * The figure of the LifelineDotLine
 */
public class LifelineDotLineCustomFigure extends LifelineDotLineFigure {

	/**
	 * Layout manager for the inline mode
	 */
	private LayoutManager inlineModeManager;

	/**
	 * Layout manager for the inline mode
	 */
	private LayoutManager normalModeManager;

	/**
	 * True if the lifeline is in inline mode
	 */
	private boolean inlineMode;

	/**
	 * Number of inner ConnectableElements
	 */
	private int innerConnectableElementsNumber;

	/**
	 * Default constructor
	 */
	public LifelineDotLineCustomFigure() {
		super();
		normalModeManager = new XYLayout();

		inlineModeManager = new FlowLayout(true) {

			{
				majorSpacing = 10;
				minorSpacing = 10;
				fill = true;
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			protected Dimension getChildSize(IFigure child, int wHint, int hHint) {
				wHint = getParent().getBounds().width;
				hHint = getParent().getBounds().height;
				if(innerConnectableElementsNumber > 0) {
					wHint /= innerConnectableElementsNumber;
				}
				if(!child.getParent().getChildren().get(innerConnectableElementsNumber - 1).equals(child)) {
					wHint = wHint - majorSpacing;
				}

				((Figure)child).setPreferredSize(wHint, hHint);
				Dimension childSize = super.getChildSize(child, wHint, hHint);
				return childSize;
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
				Dimension calculatePreferredSize = super.calculatePreferredSize(container, wHint, hHint);
				calculatePreferredSize.width = wHint;
				calculatePreferredSize.height = hHint;
				return calculatePreferredSize;
			}
		};

		setLayoutManager(normalModeManager);
	}

	/**
	 * Configure the lifeline figure
	 * 
	 * @param inlineMode
	 *        true if inline mode enabled
	 * @param innerConnectableElementsNumber
	 *        Number of children
	 */
	public void configure(boolean inlineMode, int innerConnectableElementsNumber) {
		if(inlineMode) {
			this.innerConnectableElementsNumber = innerConnectableElementsNumber;
		}
		if(this.inlineMode != inlineMode) {
			this.inlineMode = inlineMode;
			if(inlineMode) {
				setLayoutManager(inlineModeManager);
			} else {
				setLayoutManager(normalModeManager);
			}
		}
	}

	/**
	 * Print lifeline if the edit part is not in inline mode
	 */
	protected void outlineShape(Graphics graphics) {
		if(!inlineMode) {
			super.outlineShape(graphics);
		}
	}

}
