/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.figure;

import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusWrappingLabel;

/**
 * Figure for UML {@link Connector} Edges.
 */
public class ConnectorEdgeFigure extends NamedElementEdgeFigure {

	/** The multiplicity source label. */
	private WrappingLabel fSourceMultiplicityLabel;

	/** The multiplicity target label. */
	private WrappingLabel fTargetMultiplicityLabel;

	/**
	 * Instantiates a new association figure.
	 */
	public ConnectorEdgeFigure() {
		super();
		createContents();
	}

	/**
	 * Creates the contents.
	 */
	protected void createContents() {
		super.createContents();

		fSourceMultiplicityLabel = new PapyrusWrappingLabel();
		fSourceMultiplicityLabel.setText("");

		this.add(fSourceMultiplicityLabel);

		fTargetMultiplicityLabel = new PapyrusWrappingLabel();
		fTargetMultiplicityLabel.setText("");

		this.add(fTargetMultiplicityLabel);

	}

	/**
	 * Gets the applied stereotype association label.
	 * 
	 * @return the applied stereotype association label
	 */
	public WrappingLabel getAppliedStereotypeLabel() {
		return appliedStereotypeLabel;
	}

	/**
	 * Gets the multiplicity source label.
	 * 
	 * @return the multiplicity source label
	 */
	public WrappingLabel getSourceMultiplicityLabel() {
		return fSourceMultiplicityLabel;
	}

	/**
	 * Gets the multiplicity target label.
	 * 
	 * @return the multiplicity target label
	 */
	public WrappingLabel getTargetMultiplicityLabel() {
		return fTargetMultiplicityLabel;
	}

}
