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

import static org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants.DISP_MULTIPLICITY;

import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.LinkLabelDragEditPolicy;
import org.eclipse.papyrus.preferences.Activator;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.uml.diagram.common.utils.AssociationViewUtils;
import org.eclipse.uml2.uml.Association;

/**
 * Edit Part for link label showing {@link Association} target multiplicity.
 */
public class AssociationLinkLabelTargetMultiplicityEditPart extends AbstractElementLabelEditPart {

	/** Constructor */
	public AssociationLinkLabelTargetMultiplicityEditPart(View view) {
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
	@Override
	public int getKeyPoint() {
		return ConnectionLocator.TARGET;
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
				return AssociationViewUtils.getTargetSemanticEnd(owner);
			}
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ParserOptions getParserOptions() {
		return new ParserOptions(DISP_MULTIPLICITY);
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
