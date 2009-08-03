package org.eclipse.papyrus.diagram.activity.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.internal.editpolicies.ConnectionEditPolicy;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.edit.policies.ObjectFlowItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.common.commands.RemoveEObjectReferencesFromDiagram;
import org.eclipse.papyrus.diagram.common.editpolicies.DeleteOnlyViewComponentEditPolicy;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ObjectFlowEditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3002;

	/**
	 * @generated
	 */
	public ObjectFlowEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ObjectFlowItemSemanticEditPolicy());
		// ** install new ComponentEditPolicy
		installEditPolicy(EditPolicy.COMPONENT_ROLE,
				new DeleteOnlyViewComponentEditPolicy());
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
												ObjectFlowEditPart.this
														.getDiagramView(),
												Collections
														.singletonList(resolveSemanticElement()))));
						return command;
					}
				});
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ObjectFlowNameEditPart) {
			((ObjectFlowNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureActivityEdgeFigure_name());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
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
		return new ActivityEdgeConnection();
	}

	/**
	 * @generated
	 */
	public ActivityEdgeConnection getPrimaryShape() {
		return (ActivityEdgeConnection) getFigure();
	}

	/**
	 * @generated
	 */
	public class ActivityEdgeConnection extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureActivityEdgeFigure_name;

		/**
		 * @generated
		 */
		public ActivityEdgeConnection() {
			this.setForegroundColor(ColorConstants.black);

			createContents();
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureActivityEdgeFigure_name = new WrappingLabel();
			fFigureActivityEdgeFigure_name.setText("");

			fFigureActivityEdgeFigure_name
					.setFont(FFIGUREACTIVITYEDGEFIGURE_NAME_FONT);

			this.add(fFigureActivityEdgeFigure_name);

		}

		/**
		 * @generated
		 */
		private RotatableDecoration createTargetDecoration() {
			PolygonDecoration df = new PolygonDecoration();
			df.setFill(true);
			df.setBackgroundColor(ColorConstants.white);
			PointList pl = new PointList();
			pl.addPoint(getMapMode().DPtoLP(-2), getMapMode().DPtoLP(-2));
			pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0));
			pl.addPoint(getMapMode().DPtoLP(-2), getMapMode().DPtoLP(2));
			pl.addPoint(getMapMode().DPtoLP(-2), getMapMode().DPtoLP(-2));
			df.setTemplate(pl);
			df.setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));
			return df;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureActivityEdgeFigure_name() {
			return fFigureActivityEdgeFigure_name;
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGUREACTIVITYEDGEFIGURE_NAME_FONT = new Font(Display
			.getCurrent(), "SANS", 9, SWT.NORMAL);

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();

		features.add(UMLPackage.eINSTANCE.getActivityEdge_Source());
		features.add(UMLPackage.eINSTANCE.getActivityEdge_Target());
		DiagramEditPartsUtil.handleNotificationForDiagram(this, notification,
				features);
	}

}
