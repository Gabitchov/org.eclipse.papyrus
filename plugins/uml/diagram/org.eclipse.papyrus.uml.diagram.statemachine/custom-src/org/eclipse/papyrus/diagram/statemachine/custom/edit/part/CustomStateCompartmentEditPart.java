package org.eclipse.papyrus.diagram.statemachine.custom.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.statemachine.custom.figures.CustomShapeCompartmentFigure;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateCompartmentEditPart;
import org.eclipse.uml2.uml.State;

public class CustomStateCompartmentEditPart extends StateCompartmentEditPart {

	public CustomStateCompartmentEditPart(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void createDefaultEditPolicies() {
		// TODO Auto-generated method stub
		super.createDefaultEditPolicies();
		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
		removeEditPolicy(EditPolicyRoles.POPUPBAR_ROLE);

	}

	public IFigure createFigure() {
		CustomShapeCompartmentFigure result = new CustomShapeCompartmentFigure(getCompartmentName(), getMapMode());
		return result;
	}

	@Override
	protected void handleNotificationEvent(Notification notification) {
		// TODO Auto-generated method stub
		super.handleNotificationEvent(notification);
		refreshVisuals();
	}

	@Override
	protected void refreshVisuals() {
		// TODO Auto-generated method stub
		super.refreshVisuals();

		View stateView = (View)((View)getModel()).eContainer();
		State state = (State)stateView.getElement();

		((CustomShapeCompartmentFigure)getFigure()).setToolTip(state.getName());

	}

}
