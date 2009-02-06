/*******************************************************************************
 * Copyright (c) 2008 
 * Conselleria de Infraestructuras y Transporte, Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *	  Francisco Javier Cano Muñoz (Prodevelop) - initial API implementation
 ******************************************************************************/
package org.eclipse.papyrus.diagram.activity.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.internal.editpolicies.ConnectionEditPolicy;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.edit.policies.ObjectNodeSelectionItemSemanticEditPolicy;

import org.eclipse.papyrus.diagram.common.commands.RemoveEObjectReferencesFromDiagram;
import org.eclipse.papyrus.diagram.common.edit.policies.DeleteOnlyViewComponentEditPolicy;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;

/**
 * @generated
 */
public class ObjectNodeSelectionEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3003;

	/**
	 * @generated
	 */
	public ObjectNodeSelectionEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ObjectNodeSelectionItemSemanticEditPolicy());
		// ** install new ComponentEditPolicy
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new DeleteOnlyViewComponentEditPolicy());
		// ** install new ConnectionEditPolicy
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new ConnectionEditPolicy() {

			@Override
			protected boolean shouldDeleteSemantic() {
				return false;
			}

			@Override
			protected Command createDeleteViewCommand(GroupRequest deleteRequest) {
				Command command = super.createDeleteViewCommand(deleteRequest);
				command = command.chain(new ICommandProxy(new RemoveEObjectReferencesFromDiagram(getEditingDomain(), ObjectNodeSelectionEditPart.this.getDiagramView(), Collections
						.singletonList(resolveSemanticElement()))));
				return command;
			}
		});
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */

	@Override
	protected Connection createConnectionFigure() {
		return new DashedLineConnection();
	}

	/**
	 * @generated
	 */
	public DashedLineConnection getPrimaryShape() {
		return (DashedLineConnection) getFigure();
	}

	/**
	 * @generated
	 */
	public class DashedLineConnection extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public DashedLineConnection() {
			this.setLineStyle(Graphics.LINE_DASH);

		}

	}

	/**
	 * @generated
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();

		// no target or source features found
		DiagramEditPartsUtil.handleNotificationForDiagram(this, notification, features);
	}

}
