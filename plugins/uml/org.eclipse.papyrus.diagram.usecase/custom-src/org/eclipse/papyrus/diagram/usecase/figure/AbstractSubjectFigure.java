/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.figure;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.papyrus.diagram.common.draw2d.PileLayout;
import org.eclipse.papyrus.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.diagram.common.helper.StereotypeFigureHelper;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;


public abstract class AbstractSubjectFigure extends RectangleFigure implements IPapyrusNodeUMLElementFigure {

	static final Color THIS_BACK = new Color(null, 245, 245, 245);

	/** @generated */
	private boolean myUseLocalCoordinates = false;

	/** The helper which handles stereotype aspects */
	protected StereotypeFigureHelper stereotypeHelper;

	/**
	 * Instantiates a new abstract subject figure.
	 */
	public AbstractSubjectFigure() {
		PileLayout layoutThis = new PileLayout();
		layoutThis.setStretchBottom(true);
		this.setLayoutManager(layoutThis);
		this.setLineWidth(1);
		this.setBackgroundColor(THIS_BACK);
	}

	/**
	 * Refresh the layout of the figure
	 */
	protected void refreshLayout() {
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
	 * @param image
	 *        the image representing the stereotypes to be displayed
	 * @see org.eclipse.papyrus.diagram.common.figure.node.IPapyrusUMLElementFigure#setStereotypeDisplay(java.lang.String,
	 *      org.eclipse.swt.graphics.Image)
	 */
	public void setStereotypeDisplay(String stereotypes, Image image) {
		stereotypeHelper.setStereotypeDisplay(stereotypes, image);
		refreshLayout();
	}

	/**
	 * Sets the stereotypes properties for this figure.
	 * <p>
	 * This implementation checks if the specified string is null or not.
	 * <ul>
	 * <li>if the string is <code>null</code>, it removes the label representing the stereotypes properties with brace.</li>
	 * <li>if this is not <code>null</code>, it creates the stereotype properties label if needed and displays the specified string.</li>
	 * </ul>
	 * </p>
	 * 
	 * @param stereotypeProperties
	 *        the string representing the stereotype properties to be displayed
	 */
	public void setStereotypePropertiesInBrace(String stereotypeProperties) {
		stereotypeHelper.setStereotypePropertiesInBrace(stereotypeProperties);
		refreshLayout();
	}

	/**
	 * displays the new string corresponding to the list of stereotypes.
	 * 
	 * if the string is <code>null</code>, then the figure that displays the stereotype label is
	 * removed from the NodeNamedElementFigure.
	 * 
	 * @param stereotypeProperties
	 *        the string to be displayed.
	 */
	public void setStereotypePropertiesInCompartment(String stereotypeProperties) {
		stereotypeHelper.setStereotypePropertiesInCompartment(stereotypeProperties);
		refreshLayout();
	}

	/**
	 * @generated
	 */
	protected boolean useLocalCoordinates() {
		return myUseLocalCoordinates;
	}

	/**
	 * @generated
	 */
	protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
		myUseLocalCoordinates = useLocalCoordinates;
	}

	/**
	 * Gets the stereotype label.
	 * 
	 * @return the stereotype label
	 * @unused
	 * @deprecated
	 */
	public Label getStereotypesLabel() {
		return null;//fActionStereotypeLabel;
	}

}
