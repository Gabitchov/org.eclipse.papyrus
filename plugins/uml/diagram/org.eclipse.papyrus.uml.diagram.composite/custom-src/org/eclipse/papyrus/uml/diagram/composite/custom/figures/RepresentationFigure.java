/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.figures;

import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.figure.edge.DashedEdgeFigure;

/**
 * Create an {@link RepresentationFigure} with the tag <code>&laquo representation &raquo</code>
 * 
 * This figure represents the representation link between an InformationItem and the possible
 * elements (Signal, Class, Actor, InformationItem, Interface, Component.
 * 
 */
public class RepresentationFigure extends DashedEdgeFigure {

	/** Label for the tag display */
	private WrappingLabel tagLabel;

	/** Get the tag label */
	public WrappingLabel getTagLabel() {
		return tagLabel;
	}

	/** Value of the textual tag added to the figure. */
	private static String TAG_LABEL = "representation"; //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 */
	protected void createContents() {
		super.createContents();
		initTagLabel(TAG_LABEL);
	}

	/**
	 * Create the tag label in the figure. The tag label is created if value is not null.
	 * 
	 * @param value
	 *        the value to use
	 */
	protected void initTagLabel(String value) {
		if(value != null && value.length() > 0) {
			tagLabel = new WrappingLabel();
			String textToDisplay = Activator.ST_LEFT + value + Activator.ST_RIGHT;
			tagLabel.setText(textToDisplay);
			tagLabel.setOpaque(false);
			tagLabel.setForegroundColor(getNameLabel().getForegroundColor());
			tagLabel.setFont(getNameLabel().getFont());
			add(tagLabel, 0);
		}
	}
}
