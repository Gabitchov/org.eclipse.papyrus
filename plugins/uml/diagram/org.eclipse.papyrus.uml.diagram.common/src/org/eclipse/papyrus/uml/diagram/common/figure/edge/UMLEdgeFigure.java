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
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.figure.edge;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusUMLElementFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;

/**
 * An UML edge is an edge that owns a label to display applied stereotypes
 */
public class UMLEdgeFigure extends PolylineConnectionEx implements IPapyrusUMLElementFigure {

	/** Child label that displays applied stereotypes string */
	protected WrappingLabel appliedStereotypeLabel;

	/**
	 * get the applied stereotype label
	 * 
	 * @return applied stereotype label
	 */
	public WrappingLabel getAppliedStereotypeLabel() {
		return appliedStereotypeLabel;
	}

	/**
	 * Creates a new UMLEdgeFigure.
	 */
	public UMLEdgeFigure() {
		super();
		setAntialias(SWT.ON);
		createContents();
	}

	/**
	 * Creates the contents of the figure, i.e. child node. This basic
	 * implementation creates only a new stereotype label.
	 * <p>
	 * This method should be called when the parent figure is created, or when the label was removed and a string has to be displayed.
	 * </p>
	 */
	protected void createContents() {
		createStereotypeLabel();
	}

	/**
	 * Creates the stereotype label for this figure.
	 */
	protected void createStereotypeLabel() {
		appliedStereotypeLabel = new WrappingLabel();
		appliedStereotypeLabel.setTextWrap(true);
		appliedStereotypeLabel.setTextJustification(PositionConstants.CENTER);
		appliedStereotypeLabel.setText("");
		add(appliedStereotypeLabel);
	}

	/**
	 * Sets the stereotypes for this figure.
	 * <p>
	 * This implementation checks if the specified string is null or not.
	 * <ul>
	 * <li>if the string is <code>null</code>, it removes the label representing the stereotypes.</li>
	 * <li>if this is not <code>null</code>, it creates the stereotype label if needed and displays the specified string.</li>
	 * </ul>
	 * </p>
	 * 
	 * @param stereotypes
	 *        the string representing the stereotypes to be displayed
	 */
	public void setStereotypeDisplay(String stereotypes, Image image) {

		// Set stereotype text on figure
		if(!"".equals(stereotypes)) {
			appliedStereotypeLabel.setText(stereotypes);
		} else {
			appliedStereotypeLabel.setText("");
		}

		appliedStereotypeLabel.setIcon(image);
	}
}
