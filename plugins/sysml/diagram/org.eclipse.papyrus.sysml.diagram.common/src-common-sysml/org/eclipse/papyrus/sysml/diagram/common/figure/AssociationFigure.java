/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 * 	Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 * 	CEA LIST - Adaptation for SysML purpose.
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.common.figure;

import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.figure.NamedElementEdgeFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusWrappingLabel;

/**
 * This figure is used to represent {@link Association} in SysML diagrams.
 */
public class AssociationFigure extends NamedElementEdgeFigure {

	/** The multiplicity source label. */
	private WrappingLabel fSourceMultiplicityLabel;

	/** The multiplicity target label. */
	private WrappingLabel fTargetMultiplicityLabel;

	/** The role source label. */
	private WrappingLabel fSourceRoleLabel;

	/** The role target label. */
	private WrappingLabel fTargetRoleLabel;

	/**
	 * Instantiates a new association figure.
	 */
	public AssociationFigure() {
		super();
		createContents();
	}

	/**
	 * Creates the contents.
	 */
	@Override
	protected void createContents() {
		super.createContents();

		fSourceRoleLabel = new PapyrusWrappingLabel();
		fSourceRoleLabel.setText("");

		this.add(fSourceRoleLabel);

		fSourceMultiplicityLabel = new PapyrusWrappingLabel();
		fSourceMultiplicityLabel.setText("");

		this.add(fSourceMultiplicityLabel);

		fTargetRoleLabel = new PapyrusWrappingLabel();
		fTargetRoleLabel.setText("");

		this.add(fTargetRoleLabel);

		fTargetMultiplicityLabel = new PapyrusWrappingLabel();
		fTargetMultiplicityLabel.setText("");

		this.add(fTargetMultiplicityLabel);

	}

	/**
	 * Gets the applied stereotype association label.
	 *
	 * @return the applied stereotype association label
	 */
	@Override
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

	/**
	 * Gets the role source label.
	 *
	 * @return the role source label
	 */
	public WrappingLabel getSourceRoleLabel() {
		return fSourceRoleLabel;
	}

	/**
	 * Gets the role target label.
	 *
	 * @return the role target label
	 */
	public WrappingLabel getTargetRoleLabel() {
		return fTargetRoleLabel;
	}
}
