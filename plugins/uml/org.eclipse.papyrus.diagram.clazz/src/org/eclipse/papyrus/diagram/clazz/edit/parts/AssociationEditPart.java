package org.eclipse.papyrus.diagram.clazz.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.figure.AssociationFigure;
import org.eclipse.papyrus.diagram.clazz.edit.policies.AssociationItemSemanticEditPolicy;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;

/**
 * @generated
 */
public class AssociationEditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4001;

	/**
	 * @generated
	 */
	public AssociationEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	public void activate() {
		super.activate();
		addAssociationEndListeners();
	}

	/**
	 * @generated NOT
	 */
	protected void addAssociationEndListeners() {
		EObject sourceEnd = ((Association) resolveSemanticElement())
				.getMemberEnds().get(0);
		EObject targetEnd = ((Association) resolveSemanticElement())
				.getMemberEnds().get(1);
		addListenerFilter("AssociationEndListenersSource", this, sourceEnd); //$NON-NLS-1$
		addListenerFilter("AssociationEndListenersTarget", this, targetEnd); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof AppliedStereotypeAssociationEditPart) {
			((AppliedStereotypeAssociationEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getAppliedStereotypeAssociationLabel());
			return true;
		}
		if (childEditPart instanceof AssociationName2EditPart) {
			((AssociationName2EditPart) childEditPart)
					.setLabel(getPrimaryShape().getAssociationNameLabel());
			return true;
		}
		if (childEditPart instanceof AssociationName3EditPart) {
			((AssociationName3EditPart) childEditPart)
					.setLabel(getPrimaryShape().getRoleSourceLabel());
			return true;
		}
		if (childEditPart instanceof AssociationName4EditPart) {
			((AssociationName4EditPart) childEditPart)
					.setLabel(getPrimaryShape().getMultiplicitySourceLabel());
			return true;
		}
		if (childEditPart instanceof AssociationName5EditPart) {
			((AssociationName5EditPart) childEditPart)
					.setLabel(getPrimaryShape().getMultiplicityTargetLabel());
			return true;
		}
		if (childEditPart instanceof AssociationName6EditPart) {
			((AssociationName6EditPart) childEditPart)
					.setLabel(getPrimaryShape().getRoleTargetLabel());
			return true;
		}
		return false;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so
	 * you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */

	protected Connection createConnectionFigure() {
		return new AssociationFigure();
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new AssociationItemSemanticEditPolicy());
	}

	/**
	 * @generated NOT
	 */

	public void deactivate() {
		removeAssociationEndListeners();
		super.deactivate();
	}

	/**
	 * @generated
	 */
	public AssociationFigure getPrimaryShape() {
		return (AssociationFigure) getFigure();
	}

	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);

		// set the good ends for the association figure
		if (resolveSemanticElement() != null) {

			refreshVisuals();
		}
	}

	/**
	 * @generated NOT
	 */
	protected void refreshVisuals() {
		Property source = (Property) ((Association) resolveSemanticElement())
				.getMembers().get(0);
		Property target = (Property) ((Association) resolveSemanticElement())
				.getMembers().get(1);
		int sourceType = 0;
		int targetType = 0;
		// owned?
		if (source.getOwner().equals(resolveSemanticElement())) {
			sourceType += AssociationFigure.owned;
		}
		if (target.getOwner().equals(resolveSemanticElement())) {
			targetType += AssociationFigure.owned;
		}
		// aggregation?
		if (source.getAggregation() == AggregationKind.SHARED_LITERAL) {
			sourceType += AssociationFigure.aggregation;
		}
		if (target.getAggregation() == AggregationKind.SHARED_LITERAL) {
			targetType += AssociationFigure.aggregation;
		}
		// composite?
		if (source.getAggregation() == AggregationKind.COMPOSITE_LITERAL) {
			sourceType += AssociationFigure.composition;
		}
		if (target.getAggregation() == AggregationKind.COMPOSITE_LITERAL) {
			targetType += AssociationFigure.composition;
		}
		// navigable?
		if (source.isNavigable()) {
			sourceType += AssociationFigure.navigable;
		}
		if (target.isNavigable()) {
			targetType += AssociationFigure.navigable;
		}
		getPrimaryShape().setEnd(sourceType, targetType);
		super.refreshVisuals();
	}

	/**
	 * @generated NOT
	 */
	protected void removeAssociationEndListeners() {
		removeListenerFilter("AssociationEndListenersSource");
		removeListenerFilter("AssociationEndListenersTarget");

	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof AppliedStereotypeAssociationEditPart) {
			return true;
		}
		if (childEditPart instanceof AssociationName2EditPart) {
			return true;
		}
		if (childEditPart instanceof AssociationName3EditPart) {
			return true;
		}
		if (childEditPart instanceof AssociationName4EditPart) {
			return true;
		}
		if (childEditPart instanceof AssociationName5EditPart) {
			return true;
		}
		if (childEditPart instanceof AssociationName6EditPart) {
			return true;
		}
		return false;
	}

}
