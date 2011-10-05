package org.eclipse.papyrus.diagram.sequence.edit.parts;

import java.util.ArrayList;
import java.util.Collections;

import java.util.List;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.internal.editpolicies.ConnectionEditPolicy;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.papyrus.diagram.common.commands.RemoveEObjectReferencesFromDiagram;
import org.eclipse.papyrus.diagram.common.editpolicies.DeleteOnlyViewComponentEditPolicy;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.sequence.edit.policies.ElementOwnedCommentItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.policies.SequenceDeleteOnlyViewComponentEditPolicy;

/**
 * @generated
 */
public class ElementOwnedCommentEditPart extends ConnectionNodeEditPart
		implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3007;

	/**
	 * @generated
	 */
	public ElementOwnedCommentEditPart(View view) {
		super(view);
	}

	/**
	 * @author gmerin
	 * @generated NOT
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ElementOwnedCommentItemSemanticEditPolicy());
		// ** install new ComponentEditPolicy
		installEditPolicy(EditPolicy.COMPONENT_ROLE,
				new SequenceDeleteOnlyViewComponentEditPolicy()); // changed by
		// gmerin
		// ** install new ConnectionEditPolicy
		installEditPolicy(EditPolicy.CONNECTION_ROLE,
				new ConnectionEditPolicy() {
					@Override
					protected boolean shouldDeleteSemantic() {
						return false;
					}

					@Override
					protected Command createDeleteViewCommand(
							GroupRequest deleteRequest) {
						Command command = super
								.createDeleteViewCommand(deleteRequest);
						command = command
								.chain(new ICommandProxy(
										new RemoveEObjectReferencesFromDiagram(
												getEditingDomain(),
												ElementOwnedCommentEditPart.this
														.getDiagramView(),
												Collections
														.singletonList(resolveSemanticElement()))));
						return command;
					}
				});
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */

	@Override
	protected Connection createConnectionFigure() {
		return new CommentLinkFigure();
	}

	/**
	 * @generated
	 */
	public CommentLinkFigure getPrimaryShape() {
		return (CommentLinkFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class CommentLinkFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public CommentLinkFigure() {
			this.setLineStyle(Graphics.LINE_DASHDOT);
			this.setForegroundColor(ColorConstants.lightGray);

		}

	}

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();

		// no target or source features found
		DiagramEditPartsUtil.handleNotificationForDiagram(this, notification,
				features);
	}

	/**
	 * @generated not
	 */
	@Override
	public Command getCommand(Request _request) {
		if (_request instanceof GroupRequest
				&& RequestConstants.REQ_DELETE.equals(_request.getType())) {
			return getEditPolicy(EditPolicyRoles.SEMANTIC_ROLE).getCommand(
					_request);
		}

		return super.getCommand(_request);
	}
}
