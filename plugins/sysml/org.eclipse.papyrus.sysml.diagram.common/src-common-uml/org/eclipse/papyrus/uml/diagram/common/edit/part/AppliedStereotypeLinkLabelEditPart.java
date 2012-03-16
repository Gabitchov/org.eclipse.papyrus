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
package org.eclipse.papyrus.uml.diagram.common.edit.part;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.editpolicies.IDirectEdition;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.LinkLabelDragEditPolicy;

/**
 * Abstract non-diagram specific edit part for link label representing applied stereotypes.
 * This class is adapted from edit parts generated by GMF Tooling.
 */
public class AppliedStereotypeLinkLabelEditPart extends AbstractElementLabelEditPart {

	/** Constructor */
	public AppliedStereotypeLinkLabelEditPart(View view) {
		super(view);
		addSnapBackLocation();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new LinkLabelDragEditPolicy());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean isEditable() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ParserOptions getParserOptions() {
		return ParserOptions.NONE;
	}

	/**
	 * Forbid direct edition on this label.
	 */
	public int getDirectEditionType() {
		// The label is read-only (defined in GMFGen model)
		return IDirectEdition.NO_DIRECT_EDITION;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLabelRole() {
		return "Stereotype";//$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 */
	public String getIconPathRole() {
		return "";//$NON-NLS-1$
	}
}