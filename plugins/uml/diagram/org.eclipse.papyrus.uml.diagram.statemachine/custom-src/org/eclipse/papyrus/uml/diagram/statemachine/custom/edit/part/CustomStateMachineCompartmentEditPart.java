package org.eclipse.papyrus.uml.diagram.statemachine.custom.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.figures.CustomStateCompartmentFigure;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateMachineCompartmentEditPart;
import org.eclipse.uml2.uml.StateMachine;

public class CustomStateMachineCompartmentEditPart extends StateMachineCompartmentEditPart {

	public CustomStateMachineCompartmentEditPart(View view) {
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
		CustomStateCompartmentFigure result = new CustomStateCompartmentFigure(getCompartmentName(), getMapMode());
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

		View smView = (View)((View)getModel()).eContainer();
		StateMachine sm = (StateMachine)smView.getElement();

		((CustomStateCompartmentFigure)getFigure()).setToolTip(sm.getName());

	}

}
