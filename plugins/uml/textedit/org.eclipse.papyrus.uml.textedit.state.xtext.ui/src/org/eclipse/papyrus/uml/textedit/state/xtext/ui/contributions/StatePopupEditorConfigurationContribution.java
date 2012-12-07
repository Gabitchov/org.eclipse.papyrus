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
package org.eclipse.papyrus.uml.textedit.state.xtext.ui.contributions;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.extensionpoints.editors.ui.IPopupEditorHelper;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.uml.textedit.state.xtext.ui.contentassist.UmlStateProposalProvider;
import org.eclipse.papyrus.uml.textedit.state.xtext.ui.internal.UmlStateActivator;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.BehaviorKind;
import org.eclipse.papyrus.uml.textedit.state.xtext.umlState.StateRule;
import org.eclipse.papyrus.uml.textedit.state.xtext.validation.SemanticValidator;
import org.eclipse.papyrus.uml.textedit.state.xtext.validation.UmlStateJavaValidator;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.xtext.gmf.glue.PopupEditorConfiguration;
import org.eclipse.xtext.gmf.glue.edit.part.IXtextEMFReconciler;

import com.google.inject.Injector;

/**
 * @author CEA LIST
 * 
 *         This class is used for contribution to the Papyrus extension point DirectEditor. It is used for the integration
 *         of an xtext generated editor, for States of UML StateMachines.
 * 
 */
public class StatePopupEditorConfigurationContribution extends PopupEditorConfiguration {

	private State state = null;

	private StateMachine newSubmachine = null;

	private String newStateName;

	private String newEntryName = null;

	private BehaviorKind newEntryKind;

	private String newDoName = null;

	private BehaviorKind newDoKind;

	private String newExitName = null;

	private BehaviorKind newExitKind;

	private enum BehaviorRole_Local {
		ENTRY, DO, EXIT
	}

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
		if(!(editPart instanceof IGraphicalEditPart)) {
			return null;
		}
		graphicalEditPart = (IGraphicalEditPart)editPart;

		if(!(graphicalEditPart.resolveSemanticElement() instanceof State)) {
			return null;
		}
		state = (State)graphicalEditPart.resolveSemanticElement();

		UmlStateJavaValidator.init(state);

		// retrieves the XText injector
		Injector injector = UmlStateActivator.getInstance().getInjector("org.eclipse.papyrus.uml.textedit.state.xtext.UmlState");

		// builds the text content and extension for a temporary file, to be edited by the xtext editor
		String textToEdit = "" + this.getTextToEdit(graphicalEditPart.resolveSemanticElement());
		String fileExtension = "" + ".umlstate";

		// builds a new IXtextEMFReconciler.
		// Its purpose is to extract any relevant information from the textual specification,
		// and then merge it in the context UML model if necessary
		IXtextEMFReconciler reconciler = new IXtextEMFReconciler() {

			public void reconcile(EObject modelObject, EObject xtextObject) {
				// first: retrieves / determines if the xtextObject is a StateRule object
				EObject modifiedObject = xtextObject;
				if(!(modelObject instanceof State)) {
					return;
				}
				while(xtextObject != null && !(xtextObject instanceof StateRule)) {
					modifiedObject = modifiedObject.eContainer();
				}
				if(modifiedObject == null) {
					return;
				}
				StateRule stateRuleObject = (StateRule)xtextObject;

				// Retrieves the information to be populated in modelObject
				newStateName = "" + stateRuleObject.getName();

				newSubmachine = null;

				newEntryName = "";
				newDoName = "";
				newExitName = "";

				if(stateRuleObject.getSubmachine() != null) {
					newSubmachine = stateRuleObject.getSubmachine().getSubmachine();
				}

				if(stateRuleObject.getEntry() != null) {
					newEntryKind = stateRuleObject.getEntry().getKind();
					if(stateRuleObject.getEntry().getBehaviorName() != null) {
						newEntryName = "" + stateRuleObject.getEntry().getBehaviorName();
					}
				}

				if(stateRuleObject.getDo() != null) {
					newDoKind = stateRuleObject.getDo().getKind();
					if(stateRuleObject.getDo().getBehaviorName() != null) {
						newDoName = stateRuleObject.getDo().getBehaviorName();
					}
				}

				if(stateRuleObject.getExit() != null) {
					newExitKind = stateRuleObject.getExit().getKind();
					if(stateRuleObject.getExit().getBehaviorName() != null) {
						newExitName = stateRuleObject.getExit().getBehaviorName();
					}
				}

				// Creates and executes the update command
				UpdateUMLStateCommand updateCommand = new UpdateUMLStateCommand(state);

				TransactionalEditingDomain domain = getEditingDomain(modelObject);
				domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(updateCommand));
			}
		};
		return super.createPopupEditorHelper(graphicalEditPart, injector, reconciler, textToEdit, fileExtension, new SemanticValidator());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.gmf.glue.PopupEditorConfiguration#getTextToEdit(java.lang.Object)
	 */
	@Override
	public String getTextToEdit(Object editedObject) {
		if(editedObject instanceof State) {
			State state = (State)editedObject;
			String textToEdit = "";

			// name
			textToEdit = textToEdit + state.getName();

			if(state.isSubmachineState()) {
				textToEdit += " : " + UmlStateProposalProvider.getSubmachineLabel(state.getSubmachine());
			}

			// entryActivity
			if(state.getEntry() != null) {
				String kind = behaviorKindAsString(state.getEntry());
				textToEdit = textToEdit + "\nentry " + kind + " " + state.getEntry().getName();
			}

			// doActivity
			if(state.getDoActivity() != null) {
				String kind = behaviorKindAsString(state.getDoActivity());
				textToEdit = textToEdit + "\ndo " + kind + " " + state.getDoActivity().getName();
			}

			// exitActivity
			if(state.getExit() != null) {
				String kind = behaviorKindAsString(state.getExit());
				textToEdit = textToEdit + "\nexit " + kind + " " + state.getExit().getName();
			}

			return textToEdit;
		}

		return "not a State";
	}

	/**
	 * @author CEA LIST
	 * 
	 *         A command for updating the context UML model
	 */
	protected class UpdateUMLStateCommand extends AbstractTransactionalCommand {

		private State state;

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor
		 * , org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {

			state.setName(newStateName);
			state.setSubmachine(newSubmachine);
			state.setEntry(updateOrCreateBehavior(BehaviorRole_Local.ENTRY, newEntryKind, newEntryName));
			state.setDoActivity(updateOrCreateBehavior(BehaviorRole_Local.DO, newDoKind, newDoName));
			state.setExit(updateOrCreateBehavior(BehaviorRole_Local.EXIT, newExitKind, newExitName));
			return CommandResult.newOKCommandResult(state);
		}

		public UpdateUMLStateCommand(State state) {
			super(StatePopupEditorConfigurationContribution.getEditingDomain(state), "State Update", getWorkspaceFiles(state));
			this.state = state;
		}
	}

	static TransactionalEditingDomain getEditingDomain(EObject context) {
		try {
			return ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(context);
		} catch (ServiceException ex) {
			ex.printStackTrace(System.err);
		}
		return null;
	}

	private String behaviorKindAsString(Behavior b) {
		if(b instanceof Activity) {
			return "Activity";
		}
		if(b instanceof StateMachine) {
			return "StateMachine";
		}
		if(b instanceof OpaqueBehavior) {
			return "OpaqueBehavior";
		}
		return "";
	}

	private BehaviorKind behaviorKindAsBehaviorKind(Behavior b) {
		if(b instanceof Activity) {
			return BehaviorKind.ACTIVITY;
		}
		if(b instanceof StateMachine) {
			return BehaviorKind.STATE_MACHINE;
		}
		if(b instanceof OpaqueBehavior) {
			return BehaviorKind.OPAQUE_BEHAVIOR;
		}

		return BehaviorKind.OPAQUE_BEHAVIOR;
	}

	private Behavior updateOrCreateBehavior(BehaviorRole_Local role, BehaviorKind kind, String behaviorName) {
		Behavior behavior = null;
		switch(role) {
		case DO:
			behavior = state.getDoActivity();
			if(behavior != null) {
				if(behaviorName.equals("")) {
					// behavior needs to be deleted
					state.setDoActivity(null);
					behavior.destroy();
					behavior = null;
				} else {
					if(behaviorKindAsBehaviorKind(behavior) != kind) {
						// behavior needs to deleted, and a new one needs to be created
						state.setDoActivity(null);
						behavior.destroy();
						behavior = createBehavior(kind, behaviorName);
					} else {
						// Behavior simply needs to be renamed
						behavior.setName("" + behaviorName);
					}
				}
			} else {
				if(behaviorName.equals("")) {
					// nothing needs to be done
				} else {
					// behavior needs to be created
					behavior = createBehavior(kind, behaviorName);
				}
			}
			break;

		case ENTRY:
			behavior = state.getEntry();
			if(behavior != null) {
				if(behaviorName.equals("")) {
					// behavior needs to be deleted
					state.setEntry(null);
					behavior.destroy();
					behavior = null;
				} else {
					if(behaviorKindAsBehaviorKind(behavior) != kind) {
						// behavior needs to deleted, and a new one needs to be created
						state.setEntry(null);
						behavior.destroy();
						behavior = createBehavior(kind, behaviorName);
					} else {
						// Behavior simply needs to be renamed
						behavior.setName("" + behaviorName);
					}
				}
			} else {
				if(behaviorName.equals("")) {
					// nothing needs to be done
				} else {
					// behavior needs to be created
					behavior = createBehavior(kind, behaviorName);
				}
			}
			break;

		case EXIT:
			behavior = state.getExit();
			if(behavior != null) {
				if(behaviorName.equals("")) {
					// behavior needs to be deleted
					state.setExit(null);
					behavior.destroy();
					behavior = null;
				} else {
					if(behaviorKindAsBehaviorKind(behavior) != kind) {
						// behavior needs to deleted, and a new one needs to be created
						state.setExit(null);
						behavior.destroy();
						behavior = createBehavior(kind, behaviorName);
					} else {
						// Behavior simply needs to be renamed
						behavior.setName("" + behaviorName);
					}
				}
			} else {
				if(behaviorName.equals("")) {
					// nothing needs to be done
				} else {
					// behavior needs to be created
					behavior = createBehavior(kind, behaviorName);
				}
			}
			break;

		default:
			break;
		}

		return behavior;
	}

	private Behavior createBehavior(BehaviorKind kind, String name) {

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

		behavior.setName("" + name);

		return behavior;
	}
}
