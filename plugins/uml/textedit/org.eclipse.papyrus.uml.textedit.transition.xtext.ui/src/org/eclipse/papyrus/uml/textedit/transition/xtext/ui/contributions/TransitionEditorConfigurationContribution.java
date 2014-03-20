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
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.extensionpoints.editors.configuration.ICustomDirectEditorConfiguration;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.uml.textedit.transition.xtext.ui.internal.UmlTransitionActivator;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.BehaviorKind;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.CallOrSignalEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.ChangeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.EventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.RelativeTimeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TimeEventRule;
import org.eclipse.papyrus.uml.textedit.transition.xtext.umlTransition.TransitionRule;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.swt.SWT;
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
 *         This class is used for contribution to the Papyrus extension point DirectEditor. It is used for the integration
 *         of an xtext generated editor, for Transitions of UML StateMachines.
 * 
 */
@SuppressWarnings("nls")
public class TransitionEditorConfigurationContribution extends DefaultXtextDirectEditorConfiguration implements ICustomDirectEditorConfiguration {

	private static final String EMPTY = ""; //$NON-NLS-1$
	private final static String EVENTS = "events"; //$NON-NLS-1$

	/**
	 * Override to change style to {@link SWT}.MULTI
	 */
	@Override
	public int getStyle() {
		return SWT.MULTI | SWT.WRAP;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.xtext.glue.PopupEditorConfiguration#getTextToEdit(java.lang.Object)
	 */
	@SuppressWarnings("nls")
	@Override
	public String getTextToEdit(Object editedObject) {
		if(editedObject instanceof Transition) {
			Transition transition = (Transition)editedObject;
			String textToEdit = EMPTY;

			// Triggers
			if(!transition.getTriggers().isEmpty()) {
				boolean isFirstTrigger = true;
				for(Trigger t : transition.getTriggers()) {
					if(!isFirstTrigger) {
						textToEdit = textToEdit + ", ";
					} else {
						isFirstTrigger = false;
					}
					Event e = t.getEvent();
					if(e instanceof CallEvent) {
						textToEdit = textToEdit + ((CallEvent)e).getOperation().getName();
					} else if(e instanceof SignalEvent) {
						textToEdit = textToEdit + ((SignalEvent)e).getSignal().getName();
					} else if(e instanceof ChangeEvent) {

						textToEdit = textToEdit + "when \"" + retrieveBody((OpaqueExpression)((ChangeEvent)e).getChangeExpression(), "Natural language") + "\"";
					} else if(e instanceof TimeEvent) {
						String absRelPrefix = EMPTY + (((TimeEvent)e).isRelative() ? "after " : "at ");
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
				textToEdit = textToEdit + " /\n";
				String behaviorKind = EMPTY;
				behaviorKind = behaviorKind + ((behaviorKind.equals(EMPTY) && (transition.getEffect() instanceof Activity)) ? "Activity " : EMPTY);
				behaviorKind = behaviorKind + ((behaviorKind.equals(EMPTY) && (transition.getEffect() instanceof StateMachine)) ? "StateMachine " : EMPTY);
				behaviorKind = behaviorKind + ((behaviorKind.equals(EMPTY) && (transition.getEffect() instanceof OpaqueBehavior)) ? "OpaqueBehavior " : EMPTY);
				textToEdit = textToEdit + behaviorKind + " " + transition.getEffect().getName();
			}

			return textToEdit;
		}

		return "not a State";
	}

	private String retrieveBody(OpaqueExpression exp, String languageName) {
		String body = EMPTY;
		if(exp == null) {
			return body;
		}
		int index = 0;
		for(String _languageName : exp.getLanguages()) {
			if(_languageName.equals(languageName)) {
				if(index < exp.getBodies().size()) {
					return exp.getBodies().get(index);
				} else {
					return EMPTY;
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

		private static final String ANY = "any"; //$NON-NLS-1$

		private static final String NATURAL_LANGUAGE = "Natural language"; //$NON-NLS-1$

		private final Transition transition;

		private final TransitionRule transitionRuleObject;

		private List<Trigger> newTriggers = new ArrayList<Trigger>();

		private Constraint newConstraint = null;

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor
		 * , org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {

			// - Events associated with triggers of this transition
			for(Trigger t : transition.getTriggers()) {
				Event e = t.getEvent();
				t.setEvent(null);
				if(UML2Util.getNonNavigableInverseReferences(e).size() == 0) {
					// no trigger is referencing the event any more, delete call event
					e.destroy();
				}
			}
			// - Triggers owned by this transition
			transition.getTriggers().removeAll(transition.getTriggers());
			// - Guard associated with the transition
			Constraint guard = transition.getGuard();
			transition.setGuard(null);
			if(guard != null) {
				guard.destroy();
			}

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
				this.newConstraint = transition.createGuard(EMPTY);
				OpaqueExpression guardSpecification = UMLFactory.eINSTANCE.createOpaqueExpression();
				guardSpecification.getLanguages().add(NATURAL_LANGUAGE);
				guardSpecification.getBodies().add(EMPTY + transitionRuleObject.getGuard().getConstraint());
				this.newConstraint.setSpecification(guardSpecification);
			}

			boolean hasEffect = transitionRuleObject.getEffect() != null && transitionRuleObject.getEffect().getKind() != null && transitionRuleObject.getEffect().getBehaviorName() != null;
			BehaviorKind oldKind = getBehaviorKind(transition.getEffect());

			if((!hasEffect) || (transitionRuleObject.getEffect().getKind() != oldKind)) {
				// delete owned effect behavior
				Behavior effect = transition.getEffect();
				transition.setEffect(null);
				if(effect != null) {
					effect.destroy();
				}
			}

			// Create the new behavior
			if(hasEffect) {
				String behaviorName = transitionRuleObject.getEffect().getBehaviorName();
				if(transition.getEffect() == null) {
					// behavior does exist yet => create
					Behavior newEffectBehavior = createUMLBehavior(transitionRuleObject.getEffect().getKind(), behaviorName);
					transition.setEffect(newEffectBehavior);
				} else {
					transition.getEffect().setName(behaviorName);
				}
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
			for(int i = 0;; i++) {
				String name = EVENTS;
				if(i > 0) {
					name += i;
				}
				PackageableElement ep = np.getPackagedElement(name);
				if(ep instanceof Package) {
					return (Package)ep;
				} else if(ep == null) {
					// does not exist, create
					return np.createNestedPackage(name);
				}
				// exists, but is not a package, try again with different name ...
			}
		}

		/**
		 * Create a new call event (or get an existing call event) for an operation
		 * 
		 * @param operation
		 * @return
		 */
		private CallEvent getOrCreateCallEvent(Operation operation) {
			String name = "CE - " + operation.getClass_().getName() + " - " + operation.getName(); //$NON-NLS-1$ //$NON-NLS-2$
			Package eventPkg = getEventPackage();
			for(PackageableElement existingPE : eventPkg.getPackagedElements()) {
				if(existingPE instanceof CallEvent) {
					// Call event with this operation exists already
					if(((CallEvent)existingPE).getOperation() == operation) {
						((CallEvent)existingPE).setName(name);
						return (CallEvent)existingPE;
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
			String name = "SE - " + signal.getName(); //$NON-NLS-1$
			for(PackageableElement existingPE : eventPkg.getPackagedElements()) {
				if(existingPE instanceof SignalEvent) {
					// Call event with this operation exists already
					if(((SignalEvent)existingPE).getSignal() == signal) {
						((SignalEvent)existingPE).setName(name);
						return (SignalEvent)existingPE;
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
		 * Create a new change event (or get an existing) for an opaque change expression
		 * 
		 * @param operation
		 * @return
		 */
		private ChangeEvent getOrCreateChangeEvent(String opaqueChangeExpr) {
			Package eventPkg = getEventPackage();
			String name = "CE - " + opaqueChangeExpr; //$NON-NLS-1$
			for(PackageableElement existingPE : eventPkg.getPackagedElements()) {
				if(existingPE instanceof ChangeEvent) {
					// Call event with this operation exists already
					ValueSpecification vs = ((ChangeEvent)existingPE).getChangeExpression();
					if(vs instanceof OpaqueExpression) {
						EList<String> bodies = ((OpaqueExpression)vs).getBodies();
						if((bodies.size() > 0) && bodies.get(0).equals(opaqueChangeExpr)) {
							((ChangeEvent)existingPE).setName(name);
							return (ChangeEvent)existingPE;
						}
					}
				}
			}
			ChangeEvent ce = UMLFactory.eINSTANCE.createChangeEvent();
			OpaqueExpression changeExpression = UMLFactory.eINSTANCE.createOpaqueExpression();
			changeExpression.getLanguages().add(NATURAL_LANGUAGE);
			changeExpression.getBodies().add(opaqueChangeExpr);
			ce.setChangeExpression(changeExpression);
			ce.setName(name);
			eventPkg.getPackagedElements().add(ce);
			return ce;
		}

		/**
		 * Create a new time event (or get an existing) for an opaque time expression
		 * 
		 * @param operation
		 * @return
		 */
		private TimeEvent getOrCreateTimeEvent(String opaqueWhen, boolean isRelative) {
			Package eventPkg = getEventPackage();
			String name = "TE - " + opaqueWhen; //$NON-NLS-1$
			for(PackageableElement existingPE : eventPkg.getPackagedElements()) {
				if(existingPE instanceof TimeEvent) {
					// Call event with this operation exists already
					ValueSpecification vs = ((TimeEvent)existingPE).getWhen().getExpr();
					if(vs instanceof OpaqueExpression) {
						EList<String> bodies = ((OpaqueExpression)vs).getBodies();
						if((bodies.size() > 0) && bodies.get(0).equals(opaqueWhen)) {
							((TimeEvent)existingPE).setName(name);
							return (TimeEvent)existingPE;
						}
					}
				}
			}
			TimeEvent te = UMLFactory.eINSTANCE.createTimeEvent();
			OpaqueExpression timeExpressionExp = UMLFactory.eINSTANCE.createOpaqueExpression();
			timeExpressionExp.getLanguages().add(NATURAL_LANGUAGE);
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
			if(eventRule instanceof CallOrSignalEventRule) {
				CallOrSignalEventRule callOrSignalEventRule = (CallOrSignalEventRule)eventRule;
				if(callOrSignalEventRule.getOperationOrSignal() != null) {
					NamedElement operationOrSignal = callOrSignalEventRule.getOperationOrSignal();
					if(operationOrSignal instanceof Operation) {
						e = getOrCreateCallEvent((Operation)operationOrSignal);
					} else { // instanceof Signal
						e = getOrCreateSignalEvent((Signal)operationOrSignal);
					}
				}
			} else if(eventRule instanceof ChangeEventRule) {
				ChangeEventRule changeEventRule = (ChangeEventRule)eventRule;
				if(changeEventRule.getExp() != null) {
					e = getOrCreateChangeEvent(changeEventRule.getExp());
				}
			} else if(eventRule instanceof TimeEventRule) {
				TimeEventRule timeEventRule = (TimeEventRule)eventRule;
				if(timeEventRule.getExpr() != null) {
					e = getOrCreateTimeEvent(timeEventRule.getExpr(), timeEventRule instanceof RelativeTimeEventRule);
				}
			} else { // AnyReceiveEventRule
				e = UMLFactory.eINSTANCE.createAnyReceiveEvent();
				getEventPackage().getPackagedElements().add(e);
				e.setName(ANY);
			}
			return e;
		}

		/**
		 * Return the behaviorKind for a given behavior
		 * 
		 * @param behavior
		 *        the behavior
		 * @return
		 */
		protected BehaviorKind getBehaviorKind(Behavior behavior) {
			if(behavior instanceof OpaqueBehavior) {
				return BehaviorKind.OPAQUE_BEHAVIOR;
			} else if(behavior instanceof Activity) {
				return BehaviorKind.ACTIVITY;
			} else if(behavior instanceof StateMachine) {
				return BehaviorKind.STATE_MACHINE;
			} else {
				return null;
			}
		}

		/**
		 * Create a new UML behavior of a given kind
		 * 
		 * @param kind
		 *        the behavior kind
		 * @param name
		 *        the name of the behavior
		 * @return the created behavior
		 */
		protected Behavior createUMLBehavior(BehaviorKind kind, String name) {
			if(kind == null) {
				return null;
			}

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

			behavior.setName(name);

			return behavior;
		}

		public UpdateUMLTransitionCommand(TransactionalEditingDomain domain, Transition transition, TransitionRule transitionRule) {
			super(domain, "Transition Update", getWorkspaceFiles(transition)); //$NON-NLS-1$
			this.transition = transition;
			this.transitionRuleObject = transitionRule;
		}
	}

	@Override
	public Injector getInjector() {
		return UmlTransitionActivator.getInstance().getInjector(UmlTransitionActivator.ORG_ECLIPSE_PAPYRUS_UML_TEXTEDIT_TRANSITION_XTEXT_UMLTRANSITION);
	}

	@Override
	protected ICommand getParseCommand(EObject modelObject, EObject xtextObject) {
		// first: retrieves / determines if the xtextObject is a TransitionRule object
		EObject modifiedObject = xtextObject;

		if(!(modelObject instanceof Transition)) {
			return null;
		}

		Transition transition = (Transition)modelObject;

		while(xtextObject != null && !(xtextObject instanceof TransitionRule)) {
			modifiedObject = modifiedObject.eContainer();
		}
		if(modifiedObject == null) {
			return null;
		}
		TransitionRule transitionRuleObject = (TransitionRule)xtextObject;

		// Creates and executes the update command
		try {
			TransactionalEditingDomain dom = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(transition);
			UpdateUMLTransitionCommand updateCommand = new UpdateUMLTransitionCommand(dom, transition, transitionRuleObject);
			return updateCommand;
		} catch (ServiceException ex) {
			Activator.log.error(ex);
			return null;
		}
	}

}
