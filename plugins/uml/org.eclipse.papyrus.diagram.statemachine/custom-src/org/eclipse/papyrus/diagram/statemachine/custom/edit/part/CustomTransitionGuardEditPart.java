package org.eclipse.papyrus.diagram.statemachine.custom.edit.part;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionGuardEditPart;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.ChangeEvent;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.TimeEvent;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;


public class CustomTransitionGuardEditPart extends TransitionGuardEditPart {

	public CustomTransitionGuardEditPart(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void handleNotificationEvent(Notification notification) {
		// TODO Auto-generated method stub
		super.handleNotificationEvent(notification);


		refreshVisuals();
	}
	
	private String retrieveBody(OpaqueExpression exp, String languageName) {
		String body = "";
		if(exp == null)
			return body;
		int index = 0;
		for(String _languageName : exp.getLanguages()) {
			if(_languageName.equals(languageName)) {
				if(index < exp.getBodies().size())
					return exp.getBodies().get(index);
				else
					return "";
			}
			index++;
		}
		return body;
	}

	public String getInformationFromTransition(Transition transition) {
		String textToEdit = "";

		// Triggers
		if(!transition.getTriggers().isEmpty()) {
			boolean isFirstTrigger = true;
			for(Trigger t : transition.getTriggers()) {
				if(!isFirstTrigger)
					textToEdit = textToEdit + ", ";
				else
					isFirstTrigger = false;
				Event e = t.getEvent();
				if(e instanceof CallEvent) {
					textToEdit = textToEdit + ((CallEvent)e).getOperation().getName();
				} else if(e instanceof SignalEvent) {
					textToEdit = textToEdit + ((SignalEvent)e).getSignal().getName();
				} else if(e instanceof ChangeEvent) {

					textToEdit = textToEdit + "when " + "\"" + retrieveBody((OpaqueExpression)((ChangeEvent)e).getChangeExpression(), "Natural language") + "\"";
				} else if(e instanceof TimeEvent) {
					String absRelPrefix = "" + (((TimeEvent)e).isRelative() ? "after " : "at ");
					textToEdit = textToEdit + absRelPrefix + "\"" + retrieveBody((OpaqueExpression)((TimeEvent)e).getWhen().getExpr(), "Natural language") + "\"";
				} else { // any receive event
					textToEdit = textToEdit + "all";
				}
			}
		}

		// Guard
		if(transition.getGuard() != null && transition.getGuard().getSpecification() != null) {
			textToEdit = textToEdit + " [" + "\"" + retrieveBody((OpaqueExpression)transition.getGuard().getSpecification(), "Natural language") + "\"" + "]";
		}

		if(transition.getEffect() != null) {
			textToEdit = textToEdit + " / ";
			String behaviorKind = "";
			behaviorKind = behaviorKind + ((behaviorKind.equals("") && (transition.getEffect() instanceof Activity)) ? "Activity " : "");
			behaviorKind = behaviorKind + ((behaviorKind.equals("") && (transition.getEffect() instanceof StateMachine)) ? "StateMachine " : "");
			behaviorKind = behaviorKind + ((behaviorKind.equals("") && (transition.getEffect() instanceof OpaqueBehavior)) ? "OpaqueBehavior " : "");
			textToEdit = textToEdit + behaviorKind + " " + transition.getEffect().getName();
		}

		return textToEdit;
	}

	@Override
	protected void refreshVisuals() {
		// TODO Auto-generated method stub
		super.refreshVisuals();

		WrappingLabel transitionGuardLabel = (WrappingLabel)getFigure();
		Transition transition = (Transition)((View)getModel()).getElement();
		transitionGuardLabel.setText(getInformationFromTransition(transition));
	}

}
