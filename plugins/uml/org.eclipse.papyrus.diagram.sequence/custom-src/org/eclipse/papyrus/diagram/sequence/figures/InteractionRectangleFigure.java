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

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.diagram.common.draw2d.InteractionFigure;
import org.eclipse.papyrus.diagram.common.draw2d.LeftToolbarLayout;
import org.eclipse.papyrus.diagram.common.figure.node.NodeNamedElementFigure;

public class InteractionRectangleFigure extends NodeNamedElementFigure {

	protected InteractionFigure labelContainer;

	protected RectangleFigure fFigureInteractionCompartmentFigure;

	/**
	 *
	 */
	protected WrappingLabel fFigureInteractionNameFigure;

	/**
	 * @param marginBorder
	 * 
	 */
	public InteractionRectangleFigure() {

		BorderLayout layoutThis = new BorderLayout();
		setLayoutManager(layoutThis);

		createContents();
	}

	/**
	 * @generated
	 */

	protected void createContents() {

		ToolbarLayout layout = new ToolbarLayout(false);

		RectangleFigure figureTest = new RectangleFigure();
		figureTest.setOutline(false);
		figureTest.setFill(false);
		figureTest.setLayoutManager(layout);

		fFigureInteractionNameFigure = new WrappingLabel();

		labelContainer = new InteractionFigure();

		labelContainer.setBorder(new MarginBorder(3, 3, 3, 3));
		figureTest.add(labelContainer, ToolbarLayout.ALIGN_CENTER);
		add(figureTest, BorderLayout.TOP);

		LeftToolbarLayout layoutInteractionLabelContainer1 = new LeftToolbarLayout();

		labelContainer.setLayoutManager(layoutInteractionLabelContainer1);

		labelContainer.add(fFigureInteractionNameFigure);

		fFigureInteractionCompartmentFigure = new RectangleFigure();
		// Margin allow to add mesage easily
		fFigureInteractionCompartmentFigure.setBorder(new MarginBorder(5, 5, 5, 5));
		fFigureInteractionCompartmentFigure.setFill(false);
		fFigureInteractionCompartmentFigure.setOutline(true);

		add(fFigureInteractionCompartmentFigure, BorderLayout.CENTER);

	}

	/**
	 * @generated
	 */
	protected boolean myUseLocalCoordinates = false;

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
	 * @generated
	 */
	public WrappingLabel getFigureInteractionLabelFigure() {
		return fFigureInteractionNameFigure;
	}

	public RectangleFigure getCompartmentFigure() {
		return fFigureInteractionCompartmentFigure;
	}

}
