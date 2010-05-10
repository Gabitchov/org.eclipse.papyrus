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
 *   Atos Origin - Initial API and implementation
 *  Saadia DHOUIB (CEA LIST) saadia.dhouib@cea.fr - adapted from sequence diagram
 *****************************************************************************/
package org.eclipse.papyrus.diagram.communication.custom.figures;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

/**
 * 
 * LifelineFigure
 * 
 */
public class LifeLineFigure extends org.eclipse.draw2d.RectangleFigure {

	/**
	 * @generated
	 */
	private WrappingLabel fFigureLifelineLabelFigure;

	/**
	 * @generated
	 */
	private RectangleFigure fFigureLifelineNameContainerFigure;

	/**
	 * @generated
	 */
	private RectangleFigure fFigureExecutionsContainerFigure;


	/**
	 * @generated
	 */
	public void LifelineFigure() {

		BorderLayout layoutThis = new BorderLayout();
		this.setLayoutManager(layoutThis);

		this.setFill(false);
		this.setOutline(false);
		this.setLineWidth(1);
		// this.setPreferredSize(new Dimension(getMapMode().DPtoLP(100),
		// getMapMode().DPtoLP(200)));
		createContents();
	}

	/**
	 * @generated
	 */
	private void createContents() {

		fFigureLifelineNameContainerFigure = new RectangleFigure();
		fFigureLifelineNameContainerFigure.setLineWidth(1);

		// fFigureLifelineNameContainerFigure.setBorder(new
		// org.eclipse.draw2d.MarginBorder(
		// getMapMode().DPtoLP(7), getMapMode().DPtoLP(7),
		// getMapMode().DPtoLP(7), getMapMode().DPtoLP(7)));

		this.add(fFigureLifelineNameContainerFigure, BorderLayout.TOP);
		fFigureLifelineNameContainerFigure.setLayoutManager(new StackLayout());

		fFigureLifelineLabelFigure = new WrappingLabel();

		fFigureLifelineLabelFigure.setText("<...>"); //$NON-NLS-1$

		fFigureLifelineLabelFigure.setTextWrap(true);

		fFigureLifelineLabelFigure.setAlignment(PositionConstants.CENTER);

		fFigureLifelineNameContainerFigure.add(fFigureLifelineLabelFigure);

		fFigureExecutionsContainerFigure = new RectangleFigure();
		fFigureExecutionsContainerFigure.setFill(false);
		fFigureExecutionsContainerFigure.setOutline(false);
		fFigureExecutionsContainerFigure.setLineWidth(1);

		this.add(fFigureExecutionsContainerFigure, BorderLayout.CENTER);
		fFigureExecutionsContainerFigure.setLayoutManager(new StackLayout());

		// fFigureLifelineDotLineFigure = new LifelineDotLineCustomFigure();

		// fFigureExecutionsContainerFigure.add(fFigureLifelineDotLineFigure);

	}

	/**
	 *
	 */
	private boolean myUseLocalCoordinates = false;

	/**
	 * 
	 */
	@Override
	protected boolean useLocalCoordinates() {
		return myUseLocalCoordinates;
	}

	/**
	 *
	 */
	protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
		myUseLocalCoordinates = useLocalCoordinates;
	}

	/**
	 * 
	 * @return fFigureLifelineLabelFigure
	 */
	public WrappingLabel getFigureLifelineLabelFigure() {
		return fFigureLifelineLabelFigure;
	}

	/**
	 * 
	 * @return fFigureLifelineNameContainerFigure
	 */
	public RectangleFigure getFigureLifelineNameContainerFigure() {
		return fFigureLifelineNameContainerFigure;
	}

	/**
	 * 
	 * @return fFigureExecutionsContainerFigure
	 */
	public RectangleFigure getFigureExecutionsContainerFigure() {
		return fFigureExecutionsContainerFigure;
	}


}
