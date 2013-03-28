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
package org.eclipse.papyrus.uml.diagram.activity.figures;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.papyrus.uml.diagram.common.figure.node.CenteredWrappedLabel;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.common.helper.StereotypeFigureHelper;
import org.eclipse.swt.graphics.Image;

/**
 * AbstractActionFigure is an abstract super class for Action figures in order
 * to manage stereotype display
 * 
 * @generated
 */
public abstract class AbstractActionFigure extends RoundedRectangle implements IPapyrusNodeUMLElementFigure {

	/** @generated */
	private boolean myUseLocalCoordinates = false;

	/** The helper which handles stereotype aspects */
	private StereotypeFigureHelper stereotypeHelper;

	/**
	 * use StereotypeFigureHelper
	 */
	public AbstractActionFigure() {
		GridLayout layoutThis = new GridLayout();
		layoutThis.numColumns = 1;
		layoutThis.makeColumnsEqualWidth = true;
		setLayoutManager(layoutThis);
		setCornerDimensions(new Dimension(getMapMode().DPtoLP(16), getMapMode().DPtoLP(16)));
		setLineWidth(1);
		// use StereotypeFigureHelper
		stereotypeHelper = new StereotypeFigureHelper(this) {

//			@Override
//			public IMapMode getMapMode() {
//				return AbstractActionFigure.this.getMapMode();
//			}

			@Override
			public Object getStereotypeRectangleConstraint() {
				GridData constraintStereotypeRect0 = new GridData();
				constraintStereotypeRect0.verticalAlignment = GridData.BEGINNING;
				constraintStereotypeRect0.horizontalAlignment = GridData.FILL;
				constraintStereotypeRect0.horizontalIndent = 0;
				constraintStereotypeRect0.horizontalSpan = 1;
				constraintStereotypeRect0.verticalSpan = 1;
				constraintStereotypeRect0.grabExcessHorizontalSpace = false;
				constraintStereotypeRect0.grabExcessVerticalSpace = false;
				return constraintStereotypeRect0;
			}
		};
		// createContents();
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
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusUMLElementFigure#setStereotypeDisplay(java.lang.String,
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
	 *        the string representing the stereotype properties to be
	 *        displayed
	 */
	public void setStereotypePropertiesInBrace(String stereotypeProperties) {
		stereotypeHelper.setStereotypePropertiesInBrace(stereotypeProperties);
		refreshLayout();
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
		return null;// fActionStereotypeLabel;
	}

	/**
	 * Get the label of the action
	 */
	public abstract CenteredWrappedLabel getActionLabel();

	/**
	 * Get the map mode of the corresponding edit part
	 */
	public abstract IMapMode getMapMode();
}
