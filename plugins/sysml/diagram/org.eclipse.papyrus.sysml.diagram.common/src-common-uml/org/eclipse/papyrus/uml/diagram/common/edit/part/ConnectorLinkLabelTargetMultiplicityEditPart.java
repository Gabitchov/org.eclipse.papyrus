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
import org.eclipse.uml2.uml.Connector;

/**
 * Edit Part for link label showing {@link Connector} target {@link ConnectorEnd} multiplicity.
 */
public class ConnectorLinkLabelTargetMultiplicityEditPart extends AbstractElementLabelEditPart {

	/** Constructor */
	public ConnectorLinkLabelTargetMultiplicityEditPart(View view) {
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
		return ConnectionLocator.TARGET;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EObject getParserElement() {
		Connector connector = (Connector)resolveSemanticElement();
		if((getNotationView() != null) && (ViewUtil.getContainerView(getNotationView()) != null)) {
			View owner = ViewUtil.getContainerView(getNotationView());

			if((connector != null) && (connector.getEnds().size() == 2)) {
				connector.getEnds().get(1);
			}
		}

		return null;
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
	public String getLabelRole() {
		return "TargetMultiplicity"; //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 */
	public String getIconPathRole() {
		return ""; //$NON-NLS-1$
	}
}
