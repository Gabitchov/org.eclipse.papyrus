/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.transition.editor.xtext.ui.contributions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.extensionpoints.editors.ui.IPopupEditorHelper;
import org.eclipse.papyrus.transition.editor.xtext.ui.internal.UmlTransitionActivator;
import org.eclipse.papyrus.transition.editor.xtext.umlTransition.BehaviorKind;
import org.eclipse.papyrus.transition.editor.xtext.umlTransition.CallOrSignalEventRule;
import org.eclipse.papyrus.transition.editor.xtext.umlTransition.ChangeEventRule;
import org.eclipse.papyrus.transition.editor.xtext.umlTransition.EventRule;
import org.eclipse.papyrus.transition.editor.xtext.umlTransition.RelativeTimeEventRule;
import org.eclipse.papyrus.transition.editor.xtext.umlTransition.TimeEventRule;
import org.eclipse.papyrus.transition.editor.xtext.umlTransition.TransitionRule;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.ChangeEvent;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.TimeEvent;
import org.eclipse.uml2.uml.TimeExpression;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.xtext.gmf.glue.PopupEditorConfiguration;
import org.eclipse.xtext.gmf.glue.edit.part.IXtextEMFReconciler;

import com.google.inject.Injector;

/**
 * @author CEA LIST
 * 
 *         This class is used for contribution to the Papyrus extension point DirectEditor. It is used for the integration
 *         of an xtext generated editor, for Transitions of UML StateMachines.
 * 
 */
public class TransitionPopupEditorConfigurationContribution extends PopupEditorConfiguration {

	private Transition transition = null;

	private TransitionRule transitionRuleObject = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.gmf.glue.PopupEditorConfiguration#createPopupEditorHelper(org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart)
	 */
	@Override
	public IPopupEditorHelper createPopupEditorHelper(Object editPart) {

		// resolves the edit part, and the associated semantic element
		IGraphicalEditPart graphicalEditPart = null;
		if(!(editPart instanceof IGraphicalEditPart))
			return null;
		graphicalEditPart = (IGraphicalEditPart)editPart;

		if(!(graphicalEditPart.resolveSemanticElement() instanceof Transition))
			return null;
		transition = (Transition)graphicalEditPart.resolveSemanticElement();

		// retrieves the XText injector
		Injector injector = UmlTransitionActivator.getInstance().getInjector("org.eclipse.papyrus.transition.editor.xtext.UmlTransition");

		// builds the text content and extension for a temporary file, to be edited by the xtext editor
		String textToEdit = "" + this.getTextToEdit(graphicalEditPart.resolveSemanticElement());
		String fileExtension = "" + ".umltransition";

		// builds a new IXtextEMFReconciler.
		// Its purpose is to extract any relevant information from the textual specification,
		// and then merge it in the context UML model if necessary
		IXtextEMFReconciler reconciler = new IXtextEMFReconciler() {

			/**
			 * {@inheritDoc}
			 */
			public void reconcile(EObject modelObject, EObject xtextObject) {
				// first: retrieves / determines if the xtextObject is a TransitionRule object
				EObject modifiedObject = xtextObject;
				if(!(modelObject instanceof Transition))
					return;
				while(xtextObject != null && !(xtextObject instanceof TransitionRule)) {
					modifiedObject = modifiedObject.eContainer();
				}
				if(modifiedObject == null)
					return;
				transitionRuleObject = (TransitionRule)xtextObject;

				// Creates and executes the update command
				UpdateUMLTransitionCommand updateCommand = new UpdateUMLTransitionCommand(transition);

				try {
					OperationHistoryFactory.getOperationHistory().execute(updateCommand, new NullProgressMonitor(), null);
				} catch (ExecutionException e) {
					org.eclipse.papyrus.properties.runtime.Activator.log.error(e);
				}
			}
		};
		return super.createPopupEditorHelper(graphicalEditPart, injector, reconciler, textToEdit, fileExtension);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.gmf.glue.PopupEditorConfiguration#getTextToEdit(java.lang.Object)
	 */
	@Override
	public String getTextToEdit(Object editedObject) {
		if(editedObject instanceof Transition) {
			Transition transition = (Transition)editedObject;
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

		return "not a State";
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

	/**
	 * @author CEA LIST
	 * 
	 *         A command for updating the context UML model
	 */
	protected class UpdateUMLTransitionCommand extends AbstractTransactionalCommand {

		private Transition transition;

		private String newName = "";

		private List<Trigger> newTriggers = new ArrayList<Trigger>();

		private Constraint newConstraint = null;

		private Behavior newEffectBehavior = null;

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor
		 * , org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {

			////////////////////////////////////////////////////////////
			// First delete any elements associated with the transition
			////////////////////////////////////////////////////////////
			// - Owned effect behavior
			Behavior effect = transition.getEffect();
			transition.setEffect(null);
			if(effect != null)
				effect.destroy();
			// - Events associated with triggers of this transition
			for(Trigger t : transition.getTriggers()) {
				Event e = t.getEvent();
				t.setEvent(null);
				e.destroy();
			}
			// - Triggers owned by this transition
			transition.getTriggers().removeAll(transition.getTriggers());
			// - Guard associated with the transition
			Constraint guard = transition.getGuard();
			transition.setGuard(null);
			if(guard != null)
				guard.destroy();

			//////////////////////////////////////////////////////////////////////////////////////////////////
			// Then extract any relevant information from the TransitionRuleObject, and update the Transition
			//////////////////////////////////////////////////////////////////////////////////////////////////

			// Create the new triggers
			if(transitionRuleObject.getTriggers() != null) {
				for(EventRule eventRule : transitionRuleObject.getTriggers()) {
					Trigger newTrigger = UMLFactory.eINSTANCE.createTrigger();
					this.newTriggers.add(newTrigger);
					newTrigger.setEvent(createUMLEvent(eventRule));
				}
				transition.getTriggers().addAll(this.newTriggers);
			}
			// Create the new constraint
			if(transitionRuleObject.getGuard() != null && transitionRuleObject.getGuard().getConstraint() != null) {
				this.newConstraint = transition.createGuard("");
				OpaqueExpression guardSpecification = UMLFactory.eINSTANCE.createOpaqueExpression();
				guardSpecification.getLanguages().add("Natural language");
				guardSpecification.getBodies().add("" + transitionRuleObject.getGuard().getConstraint());
				this.newConstraint.setSpecification(guardSpecification);
			}
			// Create the new behavior
			if(transitionRuleObject.getEffect() != null && transitionRuleObject.getEffect().getKind() != null && transitionRuleObject.getEffect().getBehaviorName() != null) {
				this.newEffectBehavior = createUMLBehavior(transitionRuleObject.getEffect().getKind(), transitionRuleObject.getEffect().getBehaviorName());
				this.transition.setEffect(newEffectBehavior);
			}

			return CommandResult.newOKCommandResult(transition);
		}

		private Event createUMLEvent(EventRule eventRule) {
			Event e = null;
			// TODO : implement
			if(eventRule instanceof CallOrSignalEventRule) {
				CallOrSignalEventRule callOrSignalEventRule = (CallOrSignalEventRule)eventRule;
				if(callOrSignalEventRule.getOperationOrSignal() != null) {
					if(callOrSignalEventRule.getOperationOrSignal() instanceof Operation) {
						e = UMLFactory.eINSTANCE.createCallEvent();
						e.setName("");
						transition.getNearestPackage().getPackagedElements().add(e);
						((CallEvent)e).setOperation((Operation)callOrSignalEventRule.getOperationOrSignal());
					} else { // instanceof Signal
						e = UMLFactory.eINSTANCE.createSignalEvent();
						transition.getNearestPackage().getPackagedElements().add(e);
						((SignalEvent)e).setSignal((Signal)callOrSignalEventRule.getOperationOrSignal());
					}
				}
			} else if(eventRule instanceof ChangeEventRule) {
				ChangeEventRule changeEventRule = (ChangeEventRule)eventRule;
				if(changeEventRule.getExp() != null) {
					e = UMLFactory.eINSTANCE.createChangeEvent();
					e.setName("");
					transition.getNearestPackage().getPackagedElements().add(e);
					OpaqueExpression changeExpression = UMLFactory.eINSTANCE.createOpaqueExpression();
					changeExpression.getLanguages().add("Natural language");
					changeExpression.getBodies().add("" + changeEventRule.getExp());
					((ChangeEvent)e).setChangeExpression(changeExpression);
				}
			} else if(eventRule instanceof TimeEventRule) {
				TimeEventRule timeEventRule = (TimeEventRule)eventRule;
				if(timeEventRule.getExpr() != null) {
					e = UMLFactory.eINSTANCE.createTimeEvent();
					e.setName("");
					transition.getNearestPackage().getPackagedElements().add(e);
					OpaqueExpression timeExpressionExp = UMLFactory.eINSTANCE.createOpaqueExpression();
					timeExpressionExp.getLanguages().add("Natural language");
					timeExpressionExp.getBodies().add("" + timeEventRule.getExpr());
					TimeExpression timeExpression = UMLFactory.eINSTANCE.createTimeExpression();
					timeExpression.setExpr(timeExpressionExp);
					((TimeEvent)e).setWhen(timeExpression);
					if(timeEventRule instanceof RelativeTimeEventRule) // relative time event
						((TimeEvent)e).setIsRelative(true);
					else
						// absolute time event
						((TimeEvent)e).setIsRelative(false);
				}
			} else { // AnyReceiveEventRule
				e = UMLFactory.eINSTANCE.createAnyReceiveEvent();
				transition.getNearestPackage().getPackagedElements().add(e);
				e.setName("");
			}
			return e;
		}



		private Behavior createUMLBehavior(BehaviorKind kind, String name) {

			if(kind == null)
				return null;

			Behavior behavior = null;

			switch(kind) {
			case ACTIVITY:
				behavior = UMLFactory.eINSTANCE.createActivity();
				break;

			case OPAQUE_BEHAVIOR:
				behavior = UMLFactory.eINSTANCE.createOpaqueBehavior();
				break;

			case STATE_MACHINE:
				behavior = UMLFactory.eINSTANCE.createStateMachine();
				break;

			default:
				break;
			}

			behavior.setName("" + name);

			return behavior;
		}

		public UpdateUMLTransitionCommand(Transition transition) {
			super(EditorUtils.getTransactionalEditingDomain(), "Transition Update", getWorkspaceFiles(transition));
			this.transition = transition;
		}
	}

}
