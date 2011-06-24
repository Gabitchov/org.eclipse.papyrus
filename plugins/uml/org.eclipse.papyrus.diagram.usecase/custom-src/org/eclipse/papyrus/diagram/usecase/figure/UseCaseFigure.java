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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.figure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.GravityConstrainedFlowLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.GravityDirectionType;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.papyrus.diagram.common.draw2d.SplitEllipseLayout;
import org.eclipse.papyrus.diagram.common.figure.node.CenteredWrappedLabel;
import org.eclipse.papyrus.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.diagram.common.helper.StereotypeFigureHelper;
import org.eclipse.swt.graphics.Image;

/**
 * The Class UseCaseFigure.
 * 
 * @author eperico
 */
public class UseCaseFigure extends Ellipse implements IPapyrusNodeUMLElementFigure {

	/** The use case figure_name. */
	private WrappingLabel fUseCaseFigure_name;

	/** The use case figure_contents. */
	private RectangleFigure fUseCaseFigure_contents;

	/** The my use local coordinates. */
	private boolean myUseLocalCoordinates = false;

	/** The helper which handles stereotype aspects */
	protected StereotypeFigureHelper stereotypeHelper;

	/**
	 * Instantiates a new use case figure.
	 */
	public UseCaseFigure() {

		SplitEllipseLayout layoutThis = new SplitEllipseLayout();
		this.setLayoutManager(layoutThis);
		this.setLineWidth(1);
		createContents();
		// use StereotypeFigureHelper
		stereotypeHelper = new StereotypeFigureHelper(this) {

			@Override
			public IMapMode getMapMode() {
				return MapModeUtil.getMapMode(UseCaseFigure.this);
			}

			@Override
			public Object getStereotypeRectangleConstraint() {
				return GravityConstrainedFlowLayout.ALIGN_CENTER;
			}
		};
	}

	/**
	 * Creates the contents.
	 */
	private void createContents() {

		fUseCaseFigure_name = new CenteredWrappedLabel();
		fUseCaseFigure_name.setText("");
		this.add(fUseCaseFigure_name, GravityConstrainedFlowLayout.ALIGN_CENTER);

		fUseCaseFigure_contents = new RectangleFigure();
		fUseCaseFigure_contents.setFill(false);
		fUseCaseFigure_contents.setOutline(false);
		fUseCaseFigure_contents.setLineWidth(1);
		fUseCaseFigure_contents.setBorder(createBorder0());
		this.add(fUseCaseFigure_contents, GravityConstrainedFlowLayout.ALIGN_TOPLEFT);
	}

	/**
	 * Creates the border0.
	 * 
	 * @return the border
	 */
	private Border createBorder0() {
		MarginBorder result = new MarginBorder(2);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	protected boolean useLocalCoordinates() {
		return myUseLocalCoordinates;
	}

	/**
	 * Sets the use local coordinates.
	 * 
	 * @param useLocalCoordinates
	 *        the new use local coordinates
	 */
	protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
		myUseLocalCoordinates = useLocalCoordinates;
	}

	/**
	 * Gets the use case figure_name.
	 * 
	 * @return the use case figure_name
	 */
	public WrappingLabel getUseCaseFigure_name() {
		return fUseCaseFigure_name;
	}

	/**
	 * Gets the use case figure_contents.
	 * 
	 * @return the use case figure_contents
	 */
	public RectangleFigure getUseCaseFigure_contents() {
		return fUseCaseFigure_contents;
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
