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

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.diagram.common.draw2d.OneLineDashedBorder;
import org.eclipse.papyrus.diagram.common.draw2d.SplitEllipseLayout;

/**
 * The Class UseCaseFigure.
 * 
 * @author eperico
 */
public class UseCaseFigure extends Ellipse {

	/** The use case figure_name. */
	private WrappingLabel fUseCaseFigure_name;

	/** The use case figure_contents. */
	private RectangleFigure fUseCaseFigure_contents;

	/** The my use local coordinates. */
	private boolean myUseLocalCoordinates = false;

	/**
	 * Instantiates a new use case figure.
	 */
	public UseCaseFigure() {

		SplitEllipseLayout layoutThis = new SplitEllipseLayout();
		this.setLayoutManager(layoutThis);
		this.setLineWidth(1);
		createContents();
	}

	/**
	 * Creates the contents.
	 */
	private void createContents() {

		fUseCaseFigure_name = new WrappingLabel();
		fUseCaseFigure_name.setText("");

		this.add(fUseCaseFigure_name, BorderLayout.TOP);

		fUseCaseFigure_contents = new RectangleFigure();
		fUseCaseFigure_contents.setFill(false);
		fUseCaseFigure_contents.setOutline(false);
		fUseCaseFigure_contents.setLineWidth(1);
		fUseCaseFigure_contents.setBorder(createBorder0());

		this.add(fUseCaseFigure_contents, BorderLayout.CENTER);
	}

	/**
	 * Creates the border0.
	 * 
	 * @return the border
	 */
	private Border createBorder0() {
		OneLineDashedBorder result = new OneLineDashedBorder();
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
	 *            the new use local coordinates
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

}
