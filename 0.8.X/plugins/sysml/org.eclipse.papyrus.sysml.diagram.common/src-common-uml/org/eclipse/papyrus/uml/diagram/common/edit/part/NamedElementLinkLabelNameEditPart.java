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

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.LinkLabelDragEditPolicy;
import org.eclipse.papyrus.preferences.Activator;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Edit Part for link label showing {@link NamedElement} name.
 */
public class NamedElementLinkLabelNameEditPart extends AbstractElementLabelEditPart {

	/** Constructor */
	public NamedElementLinkLabelNameEditPart(View view) {
		super(view);

		// Use default view position as snap back position
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();

		String xKey = PreferenceConstantHelper.getElementConstant(view.getDiagram().getType() + "_" + view.getType(), PreferenceConstantHelper.LOCATION_X);
		String yKey = PreferenceConstantHelper.getElementConstant(view.getDiagram().getType() + "_" + view.getType(), PreferenceConstantHelper.LOCATION_Y);

		Point snapBackPosition = new Point(store.getInt(xKey), store.getInt(yKey));

		registerSnapBackPosition(view.getType(), snapBackPosition);
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
	public String getLabelRole() {
		return "Name"; //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 */
	public String getIconPathRole() {
		return ""; //$NON-NLS-1$
	}
}
