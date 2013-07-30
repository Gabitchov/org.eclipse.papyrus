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
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.helper;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.GravityConstrainedFlowLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.GravityDirectionType;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.papyrus.uml.diagram.common.figure.node.CenteredWrappedLabel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;

/**
 * StereotypeFigureHelper helps a Figure implement IPapyrusNodeUMLElementFigure
 * class to support stereotypes
 */
public abstract class StereotypeFigureHelper {

	/** @generated */
	private CenteredWrappedLabel fActionStereotypeLabel;

	/** Added for stereotypes properties, displayed in the InBrace location */
	private CenteredWrappedLabel stereotypePropertiesInBraceContent;

	/** Added for stereotypes properties */
	private WrappingLabel stereotypePropertiesContent;

	/** The rectangle displaying stereotype elements */
	private RectangleFigure stereotypeRectangle;

	/** whether the stereotypeRectangle is displayed */
	private boolean stereotypePrinted;

	private IFigure container;
	/**
	 * Inset used by then centered wrappe label
	 */
	private int topInset = 2;
	private int leftInset = 5;
	private int bottomInset = 5;
	private int rightInset = 5;
	/**
	 * True if the container of the stereotype has to be filled
	 */
	private boolean isStereotypeContainerFilled = false;

	/**
	 * @generated
	 */
	public StereotypeFigureHelper(IFigure containingFigure) {
		container = containingFigure;
		init();
		createContents();
	}
	/**
	 * Method use to be override by child class to set the options
	 */
	protected void init() {
	}

	/**
	 * @generated NOT
	 */
	private void createContents() {

		stereotypeRectangle = new RectangleFigure();
		stereotypeRectangle.setFill(isStereotypeContainerFilled);
		stereotypeRectangle.setOutline(false);
		stereotypeRectangle.setLineWidth(1);
		stereotypePrinted = false;

		GravityConstrainedFlowLayout layoutStereotypeRect0 = new GravityConstrainedFlowLayout();
		layoutStereotypeRect0.setGravity(GravityDirectionType.NORTH);
		layoutStereotypeRect0.setIgnoreInvisibleChildren(true);
		layoutStereotypeRect0.setStretchMajorAxis(false);
		layoutStereotypeRect0.setStretchMinorAxis(false);
		stereotypeRectangle.setLayoutManager(layoutStereotypeRect0);
	}

	/**
	 * This method is used to draw the rectangle displaying stereotype elements
	 * if not displayed
	 */
	protected void ensureStereotypeRectanglePrinted() {
		if(!stereotypePrinted) {
			Object constraintStereotypeRect0 = getStereotypeRectangleConstraint();

			container.add(stereotypeRectangle, constraintStereotypeRect0, 0);
			stereotypePrinted = true;
		}
	}

	/**
	 * This method is used to ensure the rectangle displaying stereotype
	 * elements is not displayed if empty
	 */
	protected void cleanStereotypeRectangle() {
		if(stereotypePrinted && stereotypeRectangle.getChildren().isEmpty()) {
			container.remove(stereotypeRectangle);
			stereotypePrinted = false;
		}
	}

	/**
	 * this method is used to remove the stereotype label.
	 */
	protected void removeStereotypeLabel() {
		// Remove label if any
		if(fActionStereotypeLabel != null) {
			stereotypeRectangle.remove(fActionStereotypeLabel);
			fActionStereotypeLabel = null;
		}
		cleanStereotypeRectangle();
	}

	/**
	 * this method is used to create the stereotype label.
	 */
	protected void createStereotypeLabel() {
		ensureStereotypeRectanglePrinted();
		fActionStereotypeLabel = new CenteredWrappedLabel();
		//fActionStereotypeLabel.setBorder(new MarginBorder(getMapMode().DPtoLP(topInset), getMapMode().DPtoLP(leftInset), getMapMode().DPtoLP(bottomInset ), getMapMode().DPtoLP(rightInset)));
		// Add the stereotype label to the figure
		stereotypeRectangle.add(fActionStereotypeLabel, GravityConstrainedFlowLayout.ALIGN_CENTER, 0);
	}

	/**
	 * this method is used to remove the stereotype label.
	 */
	protected void removeStereotypePropertiesInBraceLabel() {
		// Remove label if any
		if(stereotypePropertiesInBraceContent != null) {
			stereotypeRectangle.remove(stereotypePropertiesInBraceContent);
			stereotypePropertiesInBraceContent = null;
		}
		cleanStereotypeRectangle();
	}

	/**
	 * this method is used to create the stereotype label.
	 */
	protected void createStereotypePropertiesInBraceLabel() {
		ensureStereotypeRectanglePrinted();
		stereotypePropertiesInBraceContent = new CenteredWrappedLabel();
		//stereotypePropertiesInBraceContent.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode().DPtoLP(5), getMapMode().DPtoLP(5), getMapMode().DPtoLP(5)));
		// Add the stereotype label to the figure
		stereotypeRectangle.add(stereotypePropertiesInBraceContent, GravityConstrainedFlowLayout.ALIGN_CENTER, -1);
	}

	/**
	 * this method is used to remove the stereotype label.
	 */
	protected void removeStereotypePropertiesInCompartment() {
		// Remove label if any
		if(stereotypePropertiesContent != null) {
			stereotypeRectangle.remove(stereotypePropertiesContent);
			stereotypePropertiesContent = null;
		}
		cleanStereotypeRectangle();
	}

	/**
	 * Create properties compartment for displaying visible properties of
	 * applied stereotypes
	 */
	protected void createStereotypePropertiesInCompartment() {
		ensureStereotypeRectanglePrinted();
		stereotypePropertiesContent = new WrappingLabel();
		stereotypePropertiesContent.setTextJustification(SWT.LEFT);
		stereotypePropertiesContent.setTextAlignment(PositionConstants.LEFT);
		stereotypePropertiesContent.setTextWrap(true);
		//stereotypePropertiesContent.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode().DPtoLP(5), getMapMode().DPtoLP(5), getMapMode().DPtoLP(5)));
		// Add the stereotype label to the figure
		stereotypeRectangle.add(stereotypePropertiesContent, GravityConstrainedFlowLayout.ALIGN_TOPLEFT, -1);
	}

	/**
	 * Fill properties compartment with displayed properties
	 * 
	 * @param stereotypeProperties
	 *        the properties string
	 */
	private void fillStereotypePropertiesInCompartment(String stereotypeProperties) {

		String propertiesString = stereotypeProperties;
		propertiesString = propertiesString.replace(";", "\n");
		propertiesString = propertiesString.replace("#", "\n  ");
		propertiesString = propertiesString.replace("|", "\n  ");
		stereotypePropertiesContent.setText(propertiesString);
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
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusUMLElementFigure#setStereotypeDisplay(java.lang.String,
	 *      org.eclipse.swt.graphics.Image)
	 */
	public void setStereotypeDisplay(String stereotypes, Image image) {
		if(("".equals(stereotypes) || stereotypes == null) && image == null) {
			removeStereotypeLabel();
		} else {
			// Set the stereotype label if it does not already exist
			if(fActionStereotypeLabel == null) {
				createStereotypeLabel();
			}
			// Set stereotype text on figure
			fActionStereotypeLabel.setText(stereotypes);
			// Set stereotype icon on figure
			fActionStereotypeLabel.setIcon(image);
		}
		// refreshLayout();
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
	 *        the string representing the stereotype properties to be
	 *        displayed
	 */
	public void setStereotypePropertiesInBrace(String stereotypeProperties) {
		if("".equals(stereotypeProperties) || stereotypeProperties == null) {
			removeStereotypePropertiesInBraceLabel();
		} else {
			// Set the stereotype label if it does not already exist
			if(stereotypePropertiesInBraceContent == null) {
				createStereotypePropertiesInBraceLabel();
			}
			// Set stereotype text on figure
			stereotypePropertiesInBraceContent.setText("{" + stereotypeProperties + "}");
		}
		// refreshLayout();
	}

	/**
	 * displays the new string corresponding to the list of stereotypes.
	 * 
	 * if the string is <code>null</code>, then the figure that displays the
	 * stereotype label is removed from the NodeNamedElementFigure.
	 * 
	 * @param stereotypeProperties
	 *        the string to be displayed.
	 */
	public void setStereotypePropertiesInCompartment(String stereotypeProperties) {
		if("".equals(stereotypeProperties) || stereotypeProperties == null) {
			removeStereotypePropertiesInCompartment();
		} else {
			// set stereotype properties content
			if(stereotypePropertiesContent == null) {
				createStereotypePropertiesInCompartment();
			}
			fillStereotypePropertiesInCompartment(stereotypeProperties);
		}
		// refreshLayout();
	}

	/**
	 * @generated
	 */
	public CenteredWrappedLabel getActionStereotypeLabel() {
		return fActionStereotypeLabel;
	}

	/**
	 * Make the layout constraint which must be used to layout the stereotype
	 * rectangle
	 */
	public abstract Object getStereotypeRectangleConstraint();

	/**
	 * Get the map mode of the corresponding edit part
	 */
	//public abstract IMapMode getMapMode();

	public int getTopInset() {
		return topInset;
	}

	/**
	 * 
	 * @param topInset
	 */
	public void setTopInset(int topInset) {
		this.topInset = topInset;
	}

	/**
	 * 
	 * @return
	 */
	public int getLeftInset() {
		return leftInset;
	}

	/**
	 * 
	 * @param leftInset
	 */
	public void setLeftInset(int leftInset) {
		this.leftInset = leftInset;
	}

	/**
	 * 
	 * @return
	 */
	public int getBottomInset() {
		return bottomInset;
	}

	/**
	 * 
	 * @param bottomInset
	 */
	public void setBottomInset(int bottomInset) {
		this.bottomInset = bottomInset;
	}

	/**
	 * 
	 * @return
	 */
	public int getRightInset() {
		return rightInset;
	}

	/**
	 * 
	 * @param rightInset
	 */
	public void setRightInset(int rightInset) {
		this.rightInset = rightInset;
	}

	/**
	 * Return true if the Rectangle containing the the stereotype has to be
	 * filled
	 * @return
	 */
	public boolean isStereotypeContainerFilled() {
		return isStereotypeContainerFilled;
	}

	/**
	 * If set to true the rectangle containing the stereotype will be filled
	 * @param isStereotypeContainerFilled
	 */
	public void setStereotypeContainerFilled(boolean isStereotypeContainerFilled) {
		this.isStereotypeContainerFilled = isStereotypeContainerFilled;
	}
}
