/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */

package org.eclipse.papyrus.uml.diagram.statemachine.custom.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.TransitionGuardEditPart;


public class CustomTransitionGuardEditPart extends TransitionGuardEditPart {

	public CustomTransitionGuardEditPart(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Label should be capable of wrapping, i.e. of displaying text in multiple lines
	 * which is in particular required when the code of an operation is shown instead of the operations name
	 * [see bug 369305]
	 * 
	 * @see org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionGuardEditPart#setLabelTextHelper(org.eclipse.draw2d.IFigure,
	 *      java.lang.String)
	 * 
	 * @param figure
	 * @param text
	 */
	@Override
	protected void setLabelTextHelper(IFigure figure, String text) {
		if(figure instanceof WrappingLabel) {
			((WrappingLabel)figure).setText(text);
			// [addition for bug 369305]
			((WrappingLabel)figure).setTextWrap(true);
		} else if(figure instanceof ILabelFigure) {
			((ILabelFigure)figure).setText(text);
		} else {
			((Label)figure).setText(text);
		}
	}

	/**
	 * The following code has been commented, since the custom class was not in use (CustomUMLEditPartFactory
	 * returned generated TransitionGuardEditPart instead of this one) before adding setLabelTextHelper above.
	 * 
	 * 
	 * public String getInformationFromTransition(Transition transition) {
	 * String textToEdit = "";
	 * 
	 * // Triggers
	 * if(!transition.getTriggers().isEmpty()) {
	 * boolean isFirstTrigger = true;
	 * for(Trigger t : transition.getTriggers()) {
	 * if(!isFirstTrigger)
	 * textToEdit = textToEdit + ", ";
	 * else
	 * isFirstTrigger = false;
	 * Event e = t.getEvent();
	 * if(e instanceof CallEvent) {
	 * if(((CallEvent)e).getOperation() != null)
	 * textToEdit = textToEdit + ((CallEvent)e).getOperation().getName();
	 * else
	 * textToEdit = textToEdit + ((CallEvent)e).getName();
	 * 
	 * } else if(e instanceof SignalEvent) {
	 * if(((SignalEvent)e).getSignal() != null)
	 * textToEdit = textToEdit + ((SignalEvent)e).getSignal().getName();
	 * else
	 * textToEdit = textToEdit + ((SignalEvent)e).getName();
	 * } else if(e instanceof ChangeEvent) {
	 * 
	 * textToEdit = textToEdit + "when " + "\"" + retrieveBody((OpaqueExpression)((ChangeEvent)e).getChangeExpression(), "Natural language") + "\"";
	 * } else if(e instanceof TimeEvent) {
	 * String absRelPrefix = "" + (((TimeEvent)e).isRelative() ? "after " : "at ");
	 * textToEdit = textToEdit + absRelPrefix + "\"" + retrieveBody((OpaqueExpression)((TimeEvent)e).getWhen().getExpr(), "Natural language") + "\"";
	 * } else { // any receive event
	 * textToEdit = textToEdit + "all";
	 * }
	 * }
	 * }
	 * 
	 * // Guard
	 * if(transition.getGuard() != null && transition.getGuard().getSpecification() != null) {
	 * textToEdit = textToEdit + " [" + "\"" + retrieveBody((OpaqueExpression)transition.getGuard().getSpecification(), "Natural language") + "\"" +
	 * "]";
	 * }
	 * 
	 * if(transition.getEffect() != null) {
	 * textToEdit = textToEdit + " / ";
	 * String behaviorKind = "";
	 * behaviorKind = behaviorKind + ((behaviorKind.equals("") && (transition.getEffect() instanceof Activity)) ? "Activity " : "");
	 * behaviorKind = behaviorKind + ((behaviorKind.equals("") && (transition.getEffect() instanceof StateMachine)) ? "StateMachine " : "");
	 * behaviorKind = behaviorKind + ((behaviorKind.equals("") && (transition.getEffect() instanceof OpaqueBehavior)) ? "OpaqueBehavior " : "");
	 * textToEdit = textToEdit + behaviorKind + " " + transition.getEffect().getName();
	 * }
	 * 
	 * return textToEdit;
	 * }
	 * 
	 * @Override
	 *           protected void handleNotificationEvent(Notification notification) {
	 *           // TODO Auto-generated method stub
	 *           super.handleNotificationEvent(notification);
	 * 
	 * 
	 *           refreshVisuals();
	 *           }
	 * @Override
	 *           protected void refreshVisuals() {
	 *           // TODO Auto-generated method stub
	 *           super.refreshVisuals();
	 * 
	 *           WrappingLabel transitionGuardLabel = (WrappingLabel)getFigure();
	 *           Transition transition = (Transition)((View)getModel()).getElement();
	 *           transitionGuardLabel.setText(getInformationFromTransition(transition));
	 *           }
	 * 
	 *           private String retrieveBody(OpaqueExpression exp, String languageName) {
	 *           String body = "";
	 *           if(exp == null)
	 *           return body;
	 *           int index = 0;
	 *           for(String _languageName : exp.getLanguages()) {
	 *           if(_languageName.equals(languageName)) {
	 *           if(index < exp.getBodies().size())
	 *           return exp.getBodies().get(index);
	 *           else
	 *           return "";
	 *           }
	 *           index++;
	 *           }
	 *           return body;
	 *           }
	 */
}
