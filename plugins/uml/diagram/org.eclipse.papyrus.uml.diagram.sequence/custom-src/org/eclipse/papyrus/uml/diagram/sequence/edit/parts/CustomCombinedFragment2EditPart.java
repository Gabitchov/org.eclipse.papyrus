/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic.CustomCombinedFragment2ItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.figures.CoRegionCombinedFragmentFigure;
import org.eclipse.uml2.uml.Lifeline;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomCombinedFragment2EditPart extends CombinedFragment2EditPart {

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomCombinedFragment2EditPart(View view) {
		super(view);
	}

	/**
	 * @Override
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomCombinedFragment2ItemSemanticEditPolicy());
	}

	/**
	 * Overrides to return a ghost central vertical line which will be used for creating message (message will be bound to the lifeline and not the
	 * outline of this shape).
	 */
	@Override
	protected NodeFigure getNodeFigure() {
		NodeFigure centerFigure = null;
		if(getContentPane() instanceof CoRegionCombinedFragmentFigure) {
			centerFigure = ((CoRegionCombinedFragmentFigure)getContentPane()).getCentralVerticalLine();
		}
		return centerFigure;
	}

	/**
	 * Get the lifeline element where the CoRegion is drawn
	 * 
	 * @return the attached lifeline
	 */
	public Lifeline getAttachedLifeline() {
		Lifeline attachedLifeline = null;
		EditPart editPartParent = getParent();
		if(editPartParent instanceof LifelineEditPart) {
			attachedLifeline = (Lifeline)((LifelineEditPart)editPartParent).resolveSemanticElement();
		}
		return attachedLifeline;
	}

	@Override
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		Object feature = notification.getFeature();
		if((getModel() != null) && (getModel() == notification.getNotifier())) {
			if(NotationPackage.eINSTANCE.getLineStyle_LineWidth().equals(feature)) {
				refreshLineWidth();
			}
		}
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshLineWidth();
	}
}
