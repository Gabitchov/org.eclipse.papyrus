/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Atos Origin - Initial API and implementation
 *  Saadia DHOUIB (CEA LIST) saadia.dhouib@cea.fr - adapted from sequence diagram
 *****************************************************************************/
package org.eclipse.papyrus.diagram.communication.custom.figures;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.diagram.common.draw2d.InteractionFigure;
import org.eclipse.papyrus.diagram.common.draw2d.LeftToolbarLayout;
import org.eclipse.papyrus.diagram.common.figure.node.NodeNamedElementFigure;

/**
 * 
 * 
 *
 */
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

	@Override
	protected boolean useLocalCoordinates() {
		return myUseLocalCoordinates;
	}

	protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
		myUseLocalCoordinates = useLocalCoordinates;
	}

	/**
	 * 
	 * @return the interaction wrapping label
	 */
	public WrappingLabel getHeaderLabel() {
		return interactionLabel;
	}

	/**
	 * 
	 * @return the interactionContentPane
	 */
	public RectangleFigure getCompartmentFigure() {
		return interactionContentPane;
	}

}
