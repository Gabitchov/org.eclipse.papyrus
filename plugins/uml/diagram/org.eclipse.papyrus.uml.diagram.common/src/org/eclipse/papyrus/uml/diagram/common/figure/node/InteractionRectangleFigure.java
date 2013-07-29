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
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.draw2d.InteractionFigure;
import org.eclipse.papyrus.uml.diagram.common.draw2d.LeftToolbarLayout;

public class InteractionRectangleFigure extends NodeNamedElementFigure {

	protected InteractionFigure interactionLabelContainer;

	protected RectangleFigure interactionContentPane;

	protected WrappingLabel interactionLabel;

	private boolean myUseLocalCoordinates = false;

	/**
	 * @param marginBorder
	 * 
	 */
	public InteractionRectangleFigure() {
		setLayoutManager(new BorderLayout());
		createContents();
	}

	/**
	 * @generated
	 */

	protected void createContents() {
		add(createHeader(), BorderLayout.TOP);
		add(createContentPane(), BorderLayout.CENTER);
	}

	protected RectangleFigure createContentPane() {
		interactionContentPane = new RectangleFigure();
		// Margin allow to add message easily
		interactionContentPane.setBorder(new MarginBorder(5, 5, 5, 5));
		interactionContentPane.setFill(false);
		interactionContentPane.setOutline(true);

		return interactionContentPane;
	}

	protected RectangleFigure createHeader() {
		interactionLabel = new WrappingLabel();

		interactionLabelContainer = new InteractionFigure();
		interactionLabelContainer.setBorder(new MarginBorder(3, 3, 3, 3));
		interactionLabelContainer.setLayoutManager(new LeftToolbarLayout());

		interactionLabelContainer.add(interactionLabel);

		RectangleFigure container = new RectangleFigure();
		container.setOutline(false);
		container.setFill(false);
		container.setLayoutManager(new ToolbarLayout(false));
		container.add(interactionLabelContainer, ToolbarLayout.ALIGN_CENTER);
		return container;
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
	 * @generated
	 */
	public WrappingLabel getHeaderLabel() {
		return interactionLabel;
	}

	public RectangleFigure getCompartmentFigure() {
		return interactionContentPane;
	}

}
