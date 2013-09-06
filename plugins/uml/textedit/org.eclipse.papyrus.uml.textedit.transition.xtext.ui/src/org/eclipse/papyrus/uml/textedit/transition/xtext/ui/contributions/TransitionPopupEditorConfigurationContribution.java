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
package org.eclipse.papyrus.uml.textedit.transition.xtext.ui.contributions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.uml.textedit.transition.xtext.ui.internal.UmlTransitionActivator;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.BehaviorKind;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.CallOrSignalEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.ChangeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.RelativeTimeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TimeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TransitionRule;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.ChangeEvent;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.TimeEvent;
import org.eclipse.uml2.uml.TimeExpression;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;

import com.google.inject.Injector;

/**
 * @author CEA LIST
 * 
 *         This class is used for contribution to the Papyrus extension point
 *         DirectEditor. It is used for the integration of an xtext generated
 *         editor, for Transitions of UML StateMachines.
 * 
 */
public class TransitionPopupEditorConfigurationContribution extends DefaultXtextDirectEditorConfiguration {

	private Transition transition = null;

	private final static String EVENTS = "events";

	private TransitionRule transitionRuleObject = null;

	@Override
	public Injector getInjector() {
		return UmlTransitionActivator.getInstance().getInjector(
				UmlTransitionActivator.ORG_ECLIPSE_PAPYRUS_UML_TEXTEDIT_TRANSITION_XTEXT_UMLTRANSITION);
	}
	
	protected ICommand getParseCommand(EObject modelObject, EObject xtextObject) {
		transition = (Transition) modelObject;
		// first: retrieves / determines if the xtextObject is a
		// TransitionRule object
		EObject modifiedObject = xtextObject;
		if (!(modelObject instanceof Transition)) {
			return UnexecutableCommand.INSTANCE;
		}
		while (xtextObject != null && !(xtextObject instanceof TransitionRule)) {
			modifiedObject = modifiedObject.eContainer();
		}
		if (modifiedObject == null) {
			return UnexecutableCommand.INSTANCE;
		}
		transitionRuleObject = (TransitionRule) xtextObject;

		// Creates and executes the update command
		UpdateUMLTransitionCommand updateCommand = new UpdateUMLTransitionCommand(
				TransactionUtil.getEditingDomain(transition), transition);
		return updateCommand;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.infra.gmfdiag.xtext.glue.PopupEditorConfiguration
	 * #getTextToEdit(java.lang.Object)
	 */
	@Override
	public String getTextToEdit(Object editedObject) {
		if (editedObject instanceof Transition) {
			Transition transition = (Transition) editedObject;
			String textToEdit = "";

			// Triggers
			if (!transition.getTriggers().isEmpty()) {
				boolean isFirstTrigger = true;
				for (Trigger t : transition.getTriggers()) {
					if (!isFirstTrigger) {
						textToEdit = textToEdit + ", ";
					} else {
						isFirstTrigger = false;
					}
					Event e = t.getEvent();
					if (e instanceof CallEvent) {
						textToEdit = textToEdit + ((CallEvent) e).getOperation().getName();
					} else if (e instanceof SignalEvent) {
						textToEdit = textToEdit + ((SignalEvent) e).getSignal().getName();
					} else if (e instanceof ChangeEvent) {

						textToEdit = textToEdit
								+ "when "
								+ "\""
								+ retrieveBody((OpaqueExpression) ((ChangeEvent) e).getChangeExpression(),
										"Natural language") + "\"";
					} else if (e instanceof TimeEvent) {
						String absRelPrefix = "" + (((TimeEvent) e).isRelative() ? "after " : "at ");
						textToEdit = textToEdit
								+ absRelPrefix
								+ "\""
								+ retrieveBody((OpaqueExpression) ((TimeEvent) e).getWhen().getExpr(),
										"Natural language") + "\"";
					} else { // any receive event
						textToEdit = textToEdit + "all";
					}
				}
			}

			// Guard
			if (transition.getGuard() != null && transition.getGuard().getSpecification() != null) {
				textToEdit = textToEdit + " [" + "\""
						+ retrieveBody((OpaqueExpression) transition.getGuard().getSpecification(), "Natural language")
						+ "\"" + "]";
			}

			if (transition.getEffect() != null) {
				textToEdit = textToEdit + " / ";
				String behaviorKind = "";
				behaviorKind = behaviorKind
						+ ((behaviorKind.equals("") && (transition.getEffect() instanceof Activity)) ? "Activity " : "");
				behaviorKind = behaviorKind
						+ ((behaviorKind.equals("") && (transition.getEffect() instanceof StateMachine)) ? "StateMachine "
								: "");
				behaviorKind = behaviorKind
						+ ((behaviorKind.equals("") && (transition.getEffect() instanceof OpaqueBehavior)) ? "OpaqueBehavior "
								: "");
				textToEdit = textToEdit + behaviorKind + " " + transition.getEffect().getName();
			}

			return textToEdit;
		}

		return "not a State";
	}

	private String retrieveBody(OpaqueExpression exp, String languageName) {
		String body = "";
		if (exp == null) {
			return body;
		}
		int index = 0;
		for (String _languageName : exp.getLanguages()) {
			if (_languageName.equals(languageName)) {
				if (index < exp.getBodies().size()) {
					return exp.getBodies().get(index);
				} else {
					return "";
				}
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
		 * @see org.eclipse.gmf.runtime.emf.commands.core.command.
		 * AbstractTransactionalCommand
		 * #doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor ,
		 * org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {

			// //////////////////////////////////////////////////////////
			// First delete any elements associated with the transition
			// //////////////////////////////////////////////////////////
			// - Owned effect behavior
			Behavior effect = transition.getEffect();
			transition.setEffect(null);
			if (effect != null) {
				effect.destroy();
			}
			// - Events associated with triggers of this transition
			for (Trigger t : transition.getTriggers()) {
				Event e = t.getEvent();
				t.setEvent(null);
				if (UML2Util.getNonNavigableInverseReferences(e).size() == 0) {
					// no trigger is referencing the event any more, delete call
					// event
					e.destroy();
				}
			}
			// - Triggers owned by this transition
			transition.getTriggers().removeAll(transition.getTriggers());
			// - Guard associated with the transition
			Constraint guard = transition.getGuard();
			transition.setGuard(null);
			if (guard != null) {
				guard.destroy();
			}

			// ////////////////////////////////////////////////////////////////////////////////////////////////
			// Then extract any relevant information from the
			// TransitionRuleObject, and update the Transition
			// ////////////////////////////////////////////////////////////////////////////////////////////////

			// Create the new triggers
			if (transitionRuleObject.getTriggers() != null) {
				for (EventRule eventRule : transitionRuleObject.getTriggers()) {
					Trigger newTrigger = UMLFactory.eINSTANCE.createTrigger();
					this.newTriggers.add(newTrigger);
					newTrigger.setEvent(createUMLEvent(eventRule));
				}
				transition.getTriggers().addAll(this.newTriggers);
			}
			// Create the new constraint
			if (transitionRuleObject.getGuard() != null && transitionRuleObject.getGuard().getConstraint() != null) {
				this.newConstraint = transition.createGuard("");
				OpaqueExpression guardSpecification = UMLFactory.eINSTANCE.createOpaqueExpression();
				guardSpecification.getLanguages().add("Natural language");
				guardSpecification.getBodies().add("" + transitionRuleObject.getGuard().getConstraint());
				this.newConstraint.setSpecification(guardSpecification);
			}
			// Create the new behavior
			if (transitionRuleObject.getEffect() != null && transitionRuleObject.getEffect().getKind() != null
					&& transitionRuleObject.getEffect().getBehaviorName() != null) {
				this.newEffectBehavior = createUMLBehavior(transitionRuleObject.getEffect().getKind(),
						transitionRuleObject.getEffect().getBehaviorName());
				this.transition.setEffect(newEffectBehavior);
			}

			return CommandResult.newOKCommandResult(transition);
		}

		/**
		 * put events in a sub-directory of the nearest package
		 * 
		 * @return the resulting package
		 */
		protected Package getEventPackage() {
			Package np = transition.getNearestPackage();
			for (int i = 0;; i++) {
				String name = EVENTS;
				if (i > 0) {
					name += i;
				}
				PackageableElement ep = np.getPackagedElement(name);
				if (ep instanceof Package) {
					return (Package) ep;
				} else if (ep == null) {
					// does not exist, create
					return np.createNestedPackage(name);
				}
				// exists, but is not a package, try again with different name
				// ...
			}
		}

		/**
		 * Create a new call event (or get an existing call event) for an
		 * operation
		 * 
		 * @param operation
		 * @return
		 */
		private CallEvent getOrCreateCallEvent(Operation operation) {
			String name = "CE - " + operation.getClass_().getName() + " - " + operation.getName();
			Package eventPkg = getEventPackage();
			for (PackageableElement existingPE : eventPkg.getPackagedElements()) {
				if (existingPE instanceof CallEvent) {
					// Call event with this operation exists already
					if (((CallEvent) existingPE).getOperation() == operation) {
						((CallEvent) existingPE).setName(name);
						return (CallEvent) existingPE;
					}
				}
			}
			CallEvent ce = UMLFactory.eINSTANCE.createCallEvent();
			ce.setOperation(operation);
			ce.setName(name);
			eventPkg.getPackagedElements().add(ce);
			return ce;
		}

		/**
		 * Create a new signal event (or get an existing) for a signal
		 * 
		 * @param operation
		 * @return
		 */
		private SignalEvent getOrCreateSignalEvent(Signal signal) {
			Package eventPkg = getEventPackage();
			String name = "SE - " + signal.getName();
			for (PackageableElement existingPE : eventPkg.getPackagedElements()) {
				if (existingPE instanceof SignalEvent) {
					// Call event with this operation exists already
					if (((SignalEvent) existingPE).getSignal() == signal) {
						((SignalEvent) existingPE).setName(name);
						return (SignalEvent) existingPE;
					}
				}
			}
			SignalEvent se = UMLFactory.eINSTANCE.createSignalEvent();
			se.setSignal(signal);
			se.setName(name);
			eventPkg.getPackagedElements().add(se);
			return se;
		}

		/**
		 * Create a new change event (or get an existing) for an opaque change
		 * expression
		 * 
		 * @param operation
		 * @return
		 */
		private ChangeEvent getOrCreateChangeEvent(String opaqueChangeExpr) {
			Package eventPkg = getEventPackage();
			String name = "CE - " + opaqueChangeExpr;
			for (PackageableElement existingPE : eventPkg.getPackagedElements()) {
				if (existingPE instanceof ChangeEvent) {
					// Call event with this operation exists already
					ValueSpecification vs = ((ChangeEvent) existingPE).getChangeExpression();
					if (vs instanceof OpaqueExpression) {
						EList<String> bodies = ((OpaqueExpression) vs).getBodies();
						if ((bodies.size() > 0) && bodies.get(0).equals(opaqueChangeExpr)) {
							((ChangeEvent) existingPE).setName(name);
							return (ChangeEvent) existingPE;
						}
					}
				}
			}
			ChangeEvent ce = UMLFactory.eINSTANCE.createChangeEvent();
			OpaqueExpression changeExpression = UMLFactory.eINSTANCE.createOpaqueExpression();
			changeExpression.getLanguages().add("Natural language");
			changeExpression.getBodies().add(opaqueChangeExpr);
			ce.setChangeExpression(changeExpression);
			ce.setName(name);
			eventPkg.getPackagedElements().add(ce);
			return ce;
		}

		/**
		 * Create a new time event (or get an existing) for an opaque time
		 * expression
		 * 
		 * @param operation
		 * @return
		 */
		private TimeEvent getOrCreateTimeEvent(String opaqueWhen, boolean isRelative) {
			Package eventPkg = getEventPackage();
			String name = "TE - " + opaqueWhen;
			for (PackageableElement existingPE : eventPkg.getPackagedElements()) {
				if (existingPE instanceof TimeEvent) {
					// Call event with this operation exists already
					ValueSpecification vs = ((TimeEvent) existingPE).getWhen().getExpr();
					if (vs instanceof OpaqueExpression) {
						EList<String> bodies = ((OpaqueExpression) vs).getBodies();
						if ((bodies.size() > 0) && bodies.get(0).equals(opaqueWhen)) {
							((TimeEvent) existingPE).setName(name);
							return (TimeEvent) existingPE;
						}
					}
				}
			}
			TimeEvent te = UMLFactory.eINSTANCE.createTimeEvent();
			OpaqueExpression timeExpressionExp = UMLFactory.eINSTANCE.createOpaqueExpression();
			timeExpressionExp.getLanguages().add("Natural language");
			timeExpressionExp.getBodies().add(opaqueWhen);
			TimeExpression timeExpression = UMLFactory.eINSTANCE.createTimeExpression();
			timeExpression.setExpr(timeExpressionExp);
			te.setWhen(timeExpression);
			te.setIsRelative(isRelative);
			te.setName(name);
			eventPkg.getPackagedElements().add(te);
			return te;
		}

		private Event createUMLEvent(EventRule eventRule) {
			Event e = null;
			// TODO : implement
			if (eventRule instanceof CallOrSignalEventRule) {
				CallOrSignalEventRule callOrSignalEventRule = (CallOrSignalEventRule) eventRule;
				if (callOrSignalEventRule.getOperationOrSignal() != null) {
					NamedElement operationOrSignal = callOrSignalEventRule.getOperationOrSignal();
					if (operationOrSignal instanceof Operation) {
						e = getOrCreateCallEvent((Operation) operationOrSignal);
					} else { // instanceof Signal
						e = getOrCreateSignalEvent((Signal) operationOrSignal);
					}
				}
			} else if (eventRule instanceof ChangeEventRule) {
				ChangeEventRule changeEventRule = (ChangeEventRule) eventRule;
				if (changeEventRule.getExp() != null) {
					e = getOrCreateChangeEvent(changeEventRule.getExp());
				}
			} else if (eventRule instanceof TimeEventRule) {
				TimeEventRule timeEventRule = (TimeEventRule) eventRule;
				if (timeEventRule.getExpr() != null) {
					e = getOrCreateTimeEvent(timeEventRule.getExpr(), timeEventRule instanceof RelativeTimeEventRule);
				}
			} else { // AnyReceiveEventRule
				e = UMLFactory.eINSTANCE.createAnyReceiveEvent();
				getEventPackage().getPackagedElements().add(e);
				e.setName("any");
			}
			return e;
		}

		private Behavior createUMLBehavior(BehaviorKind kind, String name) {

			if (kind == null) {
				return null;
			}

			Behavior behavior = null;

			switch (kind) {
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

		public UpdateUMLTransitionCommand(TransactionalEditingDomain domain, Transition transition) {
			super(domain, "Transition Update", getWorkspaceFiles(transition));
			this.transition = transition;
		}
	}

}
