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

import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.LinkLabelDragEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.utils.AssociationViewUtils;
import org.eclipse.uml2.uml.Association;

/**
 * Edit Part for link label showing {@link Association} source role.
 */
public class AssociationLinkLabelSourceRoleEditPart extends AbstractElementLabelEditPart {

	/** Constructor */
	public AssociationLinkLabelSourceRoleEditPart(View view) {
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
	public int getKeyPoint() {
		return ConnectionLocator.SOURCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EObject getParserElement() {
		Association association = (Association)resolveSemanticElement();
		if((getNotationView() != null) && (ViewUtil.getContainerView(getNotationView()) != null)) {
			View owner = ViewUtil.getContainerView(getNotationView());

			if((association != null) && (association.getMemberEnds().size() == 2)) {
				return AssociationViewUtils.getSourceSemanticEnd(owner);
			}
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLabelRole() {
		return "SourceRole"; //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 */
	public String getIconPathRole() {
		return ""; //$NON-NLS-1$
	}
}
