/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.operations.IOperationApprover2;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CopyCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.internal.service.ResourceStatus;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIPlugin;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIStatusCodes;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.diagram.activity.edit.dialogs.ConfirmPinAndParameterSyncDialog;
import org.eclipse.papyrus.diagram.activity.edit.dialogs.WarningAndLinkDialog;
import org.eclipse.papyrus.diagram.activity.part.Messages;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallAction;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.InvocationAction;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Pin;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.SendObjectAction;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * The PinAndParameterSynchronizer is a validator which ensure Pins and their corresponding (if a
 * correspondence can be established) Parameters are correctly synchronized
 * 
 */
public class PinAndParameterSynchronizer extends AbstractModelConstraint {

	/** The label provider */
	private static final ILabelProvider labelProvider = new AdapterFactoryLabelProvider(UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/** The constant to initialize target pin name */
	private static final String TARGET_PIN_INITIALIZATION_NAME = "target";

	/** The constant to initialize request pin name */
	private static final String REQUEST_PIN_INITIALIZATION_NAME = "request";

	/**
	 * This approver is used to disable any operation during opening of a popup to avoid side
	 * effects
	 */
	private static IOperationApprover2 operationDisapprover = new IOperationApprover2() {

		public IStatus proceedUndoing(IUndoableOperation operation, IOperationHistory history, IAdaptable info) {
			return ResourceStatus.CANCEL_STATUS;
		}

		public IStatus proceedRedoing(IUndoableOperation operation, IOperationHistory history, IAdaptable info) {
			return ResourceStatus.CANCEL_STATUS;
		}

		public IStatus proceedExecuting(IUndoableOperation operation, IOperationHistory history, IAdaptable info) {
			return ResourceStatus.CANCEL_STATUS;
		}
	};

	/**
	 * Validate modification and update associated elements if necessary
	 * 
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 * 
	 * @param ctx
	 *        validation context
	 * @return status
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		try {
			EObject eObject = ctx.getTarget();
			// handle action creation separately not to confuse with case when Behavior is modified
			if((EMFEventType.ADD.equals(ctx.getEventType()) || EMFEventType.ADD_MANY.equals(ctx.getEventType())) && ctx.getFeatureNewValue() instanceof CallBehaviorAction) {
				// CallBehaviorAction created
				CompoundCommand cmd = getResetPinsCmd((CallAction)ctx.getFeatureNewValue());
				if(!cmd.isEmpty() && cmd.canExecute()) {
					cmd.execute();
				}
			} else if((EMFEventType.ADD.equals(ctx.getEventType()) || EMFEventType.ADD_MANY.equals(ctx.getEventType())) && ctx.getFeatureNewValue() instanceof CallOperationAction) {
				// CallOperationAction created
				CompoundCommand cmd = getResetPinsCmd((CallAction)ctx.getFeatureNewValue());
				if(!cmd.isEmpty() && cmd.canExecute()) {
					cmd.execute();
				}
			} else if((EMFEventType.ADD.equals(ctx.getEventType()) || EMFEventType.ADD_MANY.equals(ctx.getEventType())) && ctx.getFeatureNewValue() instanceof SendSignalAction) {
				// SendSignalAction created
				CompoundCommand cmd = getResetPinsCmd((SendSignalAction)ctx.getFeatureNewValue());
				if(!cmd.isEmpty() && cmd.canExecute()) {
					cmd.execute();
				}
			} else if((EMFEventType.ADD.equals(ctx.getEventType()) || EMFEventType.ADD_MANY.equals(ctx.getEventType())) && ctx.getFeatureNewValue() instanceof SendObjectAction) {
				// SendObjectAction created
				CompoundCommand cmd = getResetPinsCmd((SendObjectAction)ctx.getFeatureNewValue());
				if(!cmd.isEmpty() && cmd.canExecute()) {
					cmd.execute();
				}
			}
			// handle Operation move for redefining target pin type
			if((EMFEventType.SET.equals(ctx.getEventType()) || EMFEventType.UNSET.equals(ctx.getEventType())) && UMLPackage.eINSTANCE.getOperation_Class().equals(ctx.getFeature()) && eObject instanceof Operation) {
				// Operation moved
				CompoundCommand cmd = getUpdateTargetPinsType((Operation)eObject);
				if(!cmd.isEmpty() && cmd.canExecute()) {
					if(askForValidation(getCallingActions((Operation)eObject))) {
						cmd.execute();
					} else {
						return ctx.createFailureStatus();
					}
				}
			}
			if(eObject instanceof ValueSpecification) {
				// the value specification may be in an upperValue or lowerValue
				// replace values with appropriate ones
				EObject topValueSpec = eObject;
				while(topValueSpec.eContainer() instanceof ValueSpecification) {
					topValueSpec = topValueSpec.eContainer();
				}
				eObject = topValueSpec.eContainer();
			}
			if(eObject instanceof Pin) {
				// special case for CallOperationAction target pin : no synchronization, but type
				Element owner = ((Pin)eObject).getOwner();
				Pin target = null;
				if(owner instanceof CallOperationAction) {
					target = ((CallOperationAction)owner).getTarget();
				}
				if(target != null && target.equals(eObject)) {
					return handleTargetPinModification((Pin)eObject, ctx);
				} else {
					// Pin is modified, report modification on Parameter/Property
					return handlePinModification((Pin)eObject, ctx);
				}
			} else if(eObject instanceof Parameter) {
				// Parameter is modified, report modification on Pins
				return handleParameterModification((Parameter)eObject, ctx);
			} else if(eObject instanceof Property) {
				// Property is modified, report modification on Pins
				return handlePropertyModification((Property)eObject, ctx);
			} else if(eObject instanceof CallOperationAction) {
				// action is modified, ensure deleted/added Pin impact a Parameter
				return handleCallOperationActionModification((CallOperationAction)eObject, ctx);
			} else if(eObject instanceof Operation) {
				// Operation is modified, ensure deleted/added Parameter impact Pins
				return handleOperationModification((Operation)eObject, ctx);
			} else if(eObject instanceof CallBehaviorAction) {
				// action is modified, ensure deleted/added Pin impact a Parameter
				return handleCallBehaviorActionModification((CallBehaviorAction)eObject, ctx);
			} else if(eObject instanceof Behavior) {
				// Behavior is modified, ensure deleted/added Parameter impact Pins
				return handleBehaviorModification((Behavior)eObject, ctx);
			} else if(eObject instanceof SendSignalAction) {
				// action is modified, ensure deleted/added Pin impact a Property
				return handleSendSignalActionModification((SendSignalAction)eObject, ctx);
			} else if(eObject instanceof Signal) {
				// Signal is modified, ensure deleted/added Property impact Pins
				return handleSignalModification((Signal)eObject, ctx);
			} else if(eObject instanceof SendObjectAction) {
				// action is modified, ensure deleted/added Pin are authorized
				return handleSendObjectActionModification((SendObjectAction)eObject, ctx);
			}
			return ctx.createSuccessStatus();
		} catch (RuntimeException rte) {
			// avoid throwing uncaught exception which would disable the constraint
			Log.warning(DiagramUIPlugin.getInstance(), DiagramUIStatusCodes.IGNORED_EXCEPTION_WARNING, "Unexpected exception during Pin and Parameter synchronization : ", rte);
			// ensure that the constraint's failure does not prevent modification
			return ctx.createSuccessStatus();
		}
	}

	/**
	 * Test if the Pin feature impacts the parameter or if the Parameter feature impacts pins
	 * 
	 * @param modifiedFeature
	 *        the feature to test
	 * @return true if the feature impacts the associated Parameter or Pin objects
	 */
	private boolean testPinOrParameterOrPropertyFeature(EStructuralFeature modifiedFeature) {
		boolean type = UMLPackage.eINSTANCE.getTypedElement_Type().equals(modifiedFeature);
		boolean ordering = UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered().equals(modifiedFeature);
		boolean multiplicity = UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique().equals(modifiedFeature) || UMLPackage.eINSTANCE.getMultiplicityElement_Lower().equals(modifiedFeature) || UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue().equals(modifiedFeature) || UMLPackage.eINSTANCE.getMultiplicityElement_Upper().equals(modifiedFeature) || UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue().equals(modifiedFeature);
		boolean inAValueSpecification = ValueSpecification.class.isAssignableFrom(modifiedFeature.getContainerClass());
		return type || ordering || multiplicity || inAValueSpecification;
	}

	/**
	 * Test if the Action feature impacts the number of Pins and Parameters
	 * 
	 * @param modifiedFeature
	 *        the feature to test
	 * @return true if the feature impacts the number of Parameters or Pins
	 */
	private boolean testActionFeature(EStructuralFeature modifiedFeature) {
		boolean input = UMLPackage.eINSTANCE.getInvocationAction_Argument().equals(modifiedFeature) || UMLPackage.eINSTANCE.getCallOperationAction_Target().equals(modifiedFeature);
		boolean output = UMLPackage.eINSTANCE.getCallAction_Result().equals(modifiedFeature);
		return input || output;
	}

	/**
	 * Ensure target Pin modification is correct
	 * 
	 * @param pin
	 *        modified pin
	 * @param ctx
	 *        validation context
	 * @return status
	 */
	private IStatus handleTargetPinModification(Pin pin, IValidationContext ctx) {
		// the type of the target pin can not be modified.
		if(UMLPackage.eINSTANCE.getTypedElement_Type().equals(ctx.getFeature())) {
			Element owner = pin.getOwner();
			if(owner instanceof CallOperationAction && ((CallOperationAction)owner).getOperation() != null) {
				proposeNavigation(((CallOperationAction)owner).getOperation());
				return ctx.createFailureStatus();
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Propose the user to navigate to the given element
	 * 
	 * @param element
	 *        element to navigate to
	 */
	private void proposeNavigation(final NamedElement element) {
		final String elementLabel = labelProvider.getText(element);
		final String message = NLS.bind(Messages.PinAndParameterSynchronizer_UnauthorizedModificationRedirection, elementLabel);
		/*
		 * We are currently validating an ongoing operation. Opening a popup here may have
		 * side-effects such as re-launching the same operation. (the editor has not been
		 * deactivated yet, and its loss of focus will open a new operation) For this reason, we
		 * temporarily disable all operations on the history, just enough time for opening the
		 * popup.
		 */
		IOperationHistory history = OperationHistoryFactory.getOperationHistory();
		history.addOperationApprover(operationDisapprover);
		WarningAndLinkDialog dialog = new WarningAndLinkDialog(new Shell(Display.getDefault()), Messages.PinAndParameterSynchronizer_UnauthorizedModificationTitle, message, element, elementLabel);
		dialog.open();
		history.removeOperationApprover(operationDisapprover);
	}

	/**
	 * Ensure Pin modification is in accordance with associated Parameter
	 * 
	 * @param pin
	 *        modified pin (not a target pin)
	 * @param ctx
	 *        validation context
	 * @return status
	 */
	private IStatus handlePinModification(Pin pin, IValidationContext ctx) {
		if(EMFEventType.SET.equals(ctx.getEventType()) || EMFEventType.UNSET.equals(ctx.getEventType())) {
			if(testPinOrParameterOrPropertyFeature(ctx.getFeature())) {
				NamedElement invoked = getInvokedObject(pin);
				if(invoked != null) {
					proposeNavigation(invoked);
					return ctx.createFailureStatus();
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Ensure Parameter modification is reported on associated Pins
	 * 
	 * @param parameter
	 *        modified parameter
	 * @param ctx
	 *        validation context
	 * @return status
	 */
	private IStatus handleParameterModification(Parameter parameter, IValidationContext ctx) {
		if(EMFEventType.SET.equals(ctx.getEventType()) || EMFEventType.UNSET.equals(ctx.getEventType())) {
			if(testPinOrParameterOrPropertyFeature(ctx.getFeature())) {
				// Update corresponding pins
				CompoundCommand cmd = getUpdatePinsCmd(getPins(parameter), parameter.getType(), parameter.isOrdered(), parameter.isUnique(), parameter.getLower(), parameter.getLowerValue(), parameter.getUpper(), parameter.getUpperValue());
				if(!cmd.isEmpty() && cmd.canExecute()) {
					if(askForValidation(getCallingActions(parameter.getOwner()))) {
						cmd.execute();
					} else {
						return ctx.createFailureStatus();
					}
				}
			} else if(UMLPackage.eINSTANCE.getParameter_Direction().equals(ctx.getFeature())) {
				// Remove/Add corresponding pins with type in accordance to direction
				for(Notification event : ctx.getAllEvents()) {
					if(UMLPackage.eINSTANCE.getParameter_Direction().equals(event.getFeature()) || UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameter().equals(event.getFeature())) {
						return changePinsBecauseOfParameterDirection(parameter, event, ctx);
					}
				}
			} else if(UMLPackage.eINSTANCE.getNamedElement_Name().equals(ctx.getFeature())) {
				// Synchronize the pin name if not set yet
				CompoundCommand cmd = getSetPinsNamesCmd(getPins(parameter), parameter.getName());
				if(!cmd.isEmpty() && cmd.canExecute()) {
					if(askForValidation(getCallingActions(parameter.getOwner()))) {
						cmd.execute();
					} else {
						return ctx.createFailureStatus();
					}
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Ensure Property modification is reported on associated Pins
	 * 
	 * @param property
	 *        modified property
	 * @param ctx
	 *        validation context
	 * @return status
	 */
	private IStatus handlePropertyModification(Property property, IValidationContext ctx) {
		if(EMFEventType.SET.equals(ctx.getEventType()) || EMFEventType.UNSET.equals(ctx.getEventType())) {
			if(testPinOrParameterOrPropertyFeature(ctx.getFeature())) {
				// Update corresponding pins
				CompoundCommand cmd = getUpdatePinsCmd(getPins(property), property.getType(), property.isOrdered(), property.isUnique(), property.getLower(), property.getLowerValue(), property.getUpper(), property.getUpperValue());
				if(!cmd.isEmpty() && cmd.canExecute()) {
					if(askForValidation(getCallingActions(property.getOwner()))) {
						cmd.execute();
					} else {
						return ctx.createFailureStatus();
					}
				}
			} else if(UMLPackage.eINSTANCE.getNamedElement_Name().equals(ctx.getFeature())) {
				// Synchronize the pin name if not set yet
				CompoundCommand cmd = getSetPinsNamesCmd(getPins(property), property.getName());
				if(!cmd.isEmpty() && cmd.canExecute()) {
					if(askForValidation(getCallingActions(property.getOwner()))) {
						cmd.execute();
					} else {
						return ctx.createFailureStatus();
					}
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Change the Pins because parameter's direction has changed
	 * 
	 * @param parameter
	 *        the modified parameter
	 * @param event
	 *        the direction change event
	 * @param ctx
	 *        validation context
	 * @return status
	 */
	private IStatus changePinsBecauseOfParameterDirection(Parameter parameter, Notification event, IValidationContext ctx) {
		// constants used for type safety
		List<Integer> emptyList = Collections.emptyList();
		Map<Integer, Parameter> emptyMap = Collections.emptyMap();

		Object oldDir = event.getOldValue();
		Object newDir = event.getNewValue();
		int inIndex = getIndex(parameter, true);
		int outIndex = getIndex(parameter, false);
		CompoundCommand globalCmd = new CompoundCommand();
		List<InvocationAction> callingActions = getCallingActions(parameter.getOwner());
		if(ParameterDirectionKind.IN_LITERAL.equals(oldDir)) {
			if(ParameterDirectionKind.OUT_LITERAL.equals(newDir) || ParameterDirectionKind.RETURN_LITERAL.equals(newDir)) {
				// explore referencing actions to remove in and add out
				for(InvocationAction action : callingActions) {
					if(action instanceof CallAction) {
						CompoundCommand cmd = getRemovePinsCmd((CallAction)action, Collections.singletonList(inIndex), emptyList);
						globalCmd.append(cmd);
						cmd = getAddPinsCmd((CallAction)action, emptyMap, Collections.singletonMap(outIndex, parameter));
						globalCmd.append(cmd);
					}
				}
			} else if(ParameterDirectionKind.INOUT_LITERAL.equals(newDir)) {
				// explore referencing actions to add out
				for(InvocationAction action : callingActions) {
					if(action instanceof CallAction) {
						CompoundCommand cmd = getAddPinsCmd((CallAction)action, emptyMap, Collections.singletonMap(outIndex, parameter));
						globalCmd.append(cmd);
					}
				}
			}
		} else if(ParameterDirectionKind.OUT_LITERAL.equals(oldDir) || ParameterDirectionKind.RETURN_LITERAL.equals(oldDir)) {
			if(ParameterDirectionKind.IN_LITERAL.equals(newDir)) {
				// explore referencing actions to remove out and add in
				for(InvocationAction action : callingActions) {
					if(action instanceof CallAction) {
						CompoundCommand cmd = getRemovePinsCmd((CallAction)action, emptyList, Collections.singletonList(outIndex));
						globalCmd.append(cmd);
						cmd = getAddPinsCmd((CallAction)action, Collections.singletonMap(inIndex, parameter), emptyMap);
						globalCmd.append(cmd);
					}
				}
			} else if(ParameterDirectionKind.INOUT_LITERAL.equals(newDir)) {
				// explore referencing actions to add in
				for(InvocationAction action : callingActions) {
					if(action instanceof CallAction) {
						CompoundCommand cmd = getAddPinsCmd((CallAction)action, Collections.singletonMap(inIndex, parameter), emptyMap);
						globalCmd.append(cmd);
					}
				}
			}
		} else if(ParameterDirectionKind.INOUT_LITERAL.equals(oldDir)) {
			if(ParameterDirectionKind.IN_LITERAL.equals(newDir)) {
				// explore referencing actions to remove out
				for(InvocationAction action : callingActions) {
					if(action instanceof CallAction) {
						CompoundCommand cmd = getRemovePinsCmd((CallAction)action, emptyList, Collections.singletonList(outIndex));
						globalCmd.append(cmd);
					}
				}
			} else if(ParameterDirectionKind.OUT_LITERAL.equals(newDir) || ParameterDirectionKind.RETURN_LITERAL.equals(newDir)) {
				// explore referencing actions to remove in
				for(InvocationAction action : callingActions) {
					if(action instanceof CallAction) {
						CompoundCommand cmd = getRemovePinsCmd((CallAction)action, Collections.singletonList(inIndex), emptyList);
						globalCmd.append(cmd);
					}
				}
			}
		}
		if(!globalCmd.isEmpty() && globalCmd.canExecute()) {
			if(askForValidation(callingActions)) {
				globalCmd.execute();
			} else {
				return ctx.createFailureStatus();
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Get the list of actions invoking this element
	 * 
	 * @param element
	 *        an Operation or a Behavior or a Signal
	 * @return list of InvocationAction
	 */
	private static List<InvocationAction> getCallingActions(Element element) {
		// explore referencing actions
		Set<InvocationAction> callingActions = new HashSet<InvocationAction>();
		if(element instanceof Behavior || element instanceof Operation) {
			Collection<Setting> references = CacheAdapter.INSTANCE.getNonNavigableInverseReferences(element);
			for(Setting ref : references) {
				EObject action = ref.getEObject();
				// parameter's owner is action's called Operation
				boolean operationCase = UMLPackage.eINSTANCE.getCallOperationAction_Operation().equals(ref.getEStructuralFeature());
				// parameter's owner is action's called Behavior
				boolean behaviorCase = UMLPackage.eINSTANCE.getCallBehaviorAction_Behavior().equals(ref.getEStructuralFeature());
				if((operationCase || behaviorCase) && action instanceof CallAction && action.eContainer() != null) {
					callingActions.add((CallAction)action);
				}
			}
		} else if(element instanceof Signal) {
			Collection<Setting> references = CacheAdapter.INSTANCE.getNonNavigableInverseReferences(element);
			for(Setting ref : references) {
				EObject action = ref.getEObject();
				// parameter's owner is action's sent Signal
				boolean signalCase = UMLPackage.eINSTANCE.getSendSignalAction_Signal().equals(ref.getEStructuralFeature());
				if(signalCase && action instanceof SendSignalAction && action.eContainer() != null) {
					callingActions.add((SendSignalAction)action);
				}
			}
		}
		return new ArrayList<InvocationAction>(callingActions);
	}

	/**
	 * Ensure CallOperationAction modification is reported on associated Operation
	 * 
	 * @param action
	 *        modified action
	 * @param ctx
	 *        validation context
	 * @return status
	 */
	private IStatus handleCallOperationActionModification(CallOperationAction action, IValidationContext ctx) {
		if(testTransformPinCase(ctx)) {
			return ctx.createSuccessStatus();
		} else if(EMFEventType.ADD.equals(ctx.getEventType()) || EMFEventType.ADD_MANY.equals(ctx.getEventType())) {
			if(testActionFeature(ctx.getFeature()) && action.getOperation() != null) {
				/*
				 * Yet, no modification of parameters is allowed from the CallOperationAction. This
				 * means we can not add Pins
				 */
				if(action.getOperation() != null) {
					proposeNavigation(action.getOperation());
					return ctx.createFailureStatus();
				}
			}
		} else if(EMFEventType.REMOVE.equals(ctx.getEventType()) || EMFEventType.REMOVE_MANY.equals(ctx.getEventType())) {
			if(testActionFeature(ctx.getFeature()) && action.getOperation() != null) {
				/*
				 * Yet, no modification of parameters is allowed from the CallOperationAction. This
				 * means we can not remove Pins
				 */
				if(action.getOperation() != null) {
					proposeNavigation(action.getOperation());
					return ctx.createFailureStatus();
				}
			}
		} else if(EMFEventType.SET.equals(ctx.getEventType()) || EMFEventType.UNSET.equals(ctx.getEventType())) {
			if(UMLPackage.eINSTANCE.getCallOperationAction_Operation().equals(ctx.getFeature())) {
				/*
				 * The operation changes, so must the pins
				 */
				CompoundCommand cmd = getResetPinsCmd(action);
				if(!cmd.isEmpty() && cmd.canExecute()) {
					cmd.execute();
				}
			}
			if(UMLPackage.eINSTANCE.getCallOperationAction_Target().equals(ctx.getFeature())) {
				/*
				 * Try to remove or assign target pin. This must not be authorized.
				 */
				String msg = NLS.bind(Messages.PinAndParameterSynchronizer_UndeleteablePinMessage, UMLPackage.eINSTANCE.getCallOperationAction_Target().getName());
				MessageDialog.openWarning(new Shell(Display.getDefault()), Messages.PinAndParameterSynchronizer_UndeleteablePinTitle, msg);
				return ctx.createFailureStatus();
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Ensure CallBehaviorAction modification is reported on associated Behavior
	 * 
	 * @param action
	 *        modified action
	 * @param ctx
	 *        validation context
	 * @return status
	 */
	private IStatus handleCallBehaviorActionModification(CallBehaviorAction action, IValidationContext ctx) {
		if(testTransformPinCase(ctx)) {
			return ctx.createSuccessStatus();
		} else if(EMFEventType.ADD.equals(ctx.getEventType()) || EMFEventType.ADD_MANY.equals(ctx.getEventType())) {
			if(testActionFeature(ctx.getFeature()) && action.getBehavior() != null) {
				/*
				 * Yet, no modification of parameters is allowed from the CallBehaviorAction. This
				 * means we can not add Pins
				 */
				if(action.getBehavior() != null) {
					proposeNavigation(action.getBehavior());
					return ctx.createFailureStatus();
				}
			}
		} else if(EMFEventType.REMOVE.equals(ctx.getEventType()) || EMFEventType.REMOVE_MANY.equals(ctx.getEventType())) {
			if(testActionFeature(ctx.getFeature()) && action.getBehavior() != null) {
				/*
				 * Yet, no modification of parameters is allowed from the CallBehaviorAction. This
				 * means we can not remove Pins
				 */
				if(action.getBehavior() != null) {
					proposeNavigation(action.getBehavior());
					return ctx.createFailureStatus();
				}
			}
		} else if(EMFEventType.SET.equals(ctx.getEventType()) || EMFEventType.UNSET.equals(ctx.getEventType())) {
			if(UMLPackage.eINSTANCE.getCallBehaviorAction_Behavior().equals(ctx.getFeature())) {
				/*
				 * The behavior changes, so must the pins
				 */
				CompoundCommand cmd = getResetPinsCmd(action);
				if(action.getBehavior() != null) {
					String behaviorName = action.getBehavior().getName();
					if(behaviorName != null && !"".equals(behaviorName)) {
						// By the way, update the CallBehaviorAction name
						TransactionalEditingDomain editingdomain = EditorUtils.getTransactionalEditingDomain();
						cmd.append(SetCommand.create(editingdomain, action, UMLPackage.eINSTANCE.getNamedElement_Name(), behaviorName));
					}
				}
				if(!cmd.isEmpty() && cmd.canExecute()) {
					cmd.execute();
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Ensure SendSignalAction modification is reported on associated Signal
	 * 
	 * @param action
	 *        modified action
	 * @param ctx
	 *        validation context
	 * @return status
	 */
	private IStatus handleSendSignalActionModification(SendSignalAction action, IValidationContext ctx) {
		if(testTransformPinCase(ctx)) {
			return ctx.createSuccessStatus();
		} else if(EMFEventType.ADD.equals(ctx.getEventType()) || EMFEventType.ADD_MANY.equals(ctx.getEventType())) {
			if(testActionFeature(ctx.getFeature()) && action.getSignal() != null) {
				/*
				 * Yet, no modification of parameters is allowed from the CallBehaviorAction. This
				 * means we can not add Pins
				 */
				if(action.getSignal() != null) {
					proposeNavigation(action.getSignal());
					return ctx.createFailureStatus();
				}
			}
		} else if(EMFEventType.REMOVE.equals(ctx.getEventType()) || EMFEventType.REMOVE_MANY.equals(ctx.getEventType())) {
			if(testActionFeature(ctx.getFeature()) && action.getSignal() != null) {
				/*
				 * Yet, no modification of parameters is allowed from the CallBehaviorAction. This
				 * means we can not remove Pins
				 */
				if(action.getSignal() != null) {
					proposeNavigation(action.getSignal());
					return ctx.createFailureStatus();
				}
			}
		} else if(EMFEventType.SET.equals(ctx.getEventType()) || EMFEventType.UNSET.equals(ctx.getEventType())) {
			if(UMLPackage.eINSTANCE.getSendSignalAction_Signal().equals(ctx.getFeature())) {
				/*
				 * The signal changes, so must the pins
				 */
				CompoundCommand cmd = getResetPinsCmd(action);
				if(!cmd.isEmpty() && cmd.canExecute()) {
					cmd.execute();
				}
			}
			if(UMLPackage.eINSTANCE.getSendSignalAction_Target().equals(ctx.getFeature())) {
				/*
				 * Try to remove or assign target pin. This must not be authorized.
				 */
				String msg = NLS.bind(Messages.PinAndParameterSynchronizer_UndeleteablePinMessage, UMLPackage.eINSTANCE.getSendSignalAction_Target().getName());
				MessageDialog.openWarning(new Shell(Display.getDefault()), Messages.PinAndParameterSynchronizer_UndeleteablePinTitle, msg);
				return ctx.createFailureStatus();
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Ensure SendObjectAction modification is authorized
	 * 
	 * @param action
	 *        modified action
	 * @param ctx
	 *        validation context
	 * @return status
	 */
	private IStatus handleSendObjectActionModification(SendObjectAction action, IValidationContext ctx) {
		if(testTransformPinCase(ctx)) {
			return ctx.createSuccessStatus();
		} else if(EMFEventType.SET.equals(ctx.getEventType()) || EMFEventType.UNSET.equals(ctx.getEventType())) {
			if(UMLPackage.eINSTANCE.getSendObjectAction_Target().equals(ctx.getFeature())) {
				/*
				 * Try to remove or assign target pin. This must not be authorized.
				 */
				String msg = NLS.bind(Messages.PinAndParameterSynchronizer_UndeleteablePinMessage, UMLPackage.eINSTANCE.getSendObjectAction_Target().getName());
				MessageDialog.openWarning(new Shell(Display.getDefault()), Messages.PinAndParameterSynchronizer_UndeleteablePinTitle, msg);
				return ctx.createFailureStatus();
			}
			if(UMLPackage.eINSTANCE.getSendObjectAction_Request().equals(ctx.getFeature())) {
				/*
				 * Try to remove or assign target pin. This must not be authorized.
				 */
				String msg = NLS.bind(Messages.PinAndParameterSynchronizer_UndeleteablePinMessage, UMLPackage.eINSTANCE.getSendObjectAction_Request().getName());
				MessageDialog.openWarning(new Shell(Display.getDefault()), Messages.PinAndParameterSynchronizer_UndeleteablePinTitle, msg);
				return ctx.createFailureStatus();
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Test whether the executing operation is a transform into on a pin
	 * 
	 * @param ctx
	 *        the validation context
	 * @return true if we are executing a transform into on a pin
	 */
	private boolean testTransformPinCase(IValidationContext ctx) {
		List<Notification> events = ctx.getAllEvents();
		Object removed = null;
		Object added = null;
		if(events.size() == 1) {
			Notification set = events.get(0);
			if(Notification.SET == set.getEventType()) {
				removed = set.getOldValue();
				added = set.getNewValue();
			}
		} else if(events.size() == 2) {
			Notification remove = events.get(0);
			Notification add = events.get(1);
			if(Notification.REMOVE == remove.getEventType() && Notification.ADD == add.getEventType()) {
				if(remove.getPosition() == add.getPosition() && add.getFeature().equals(remove.getFeature())) {
					removed = remove.getOldValue();
					added = add.getNewValue();
				}
			}
		}
		// check that replacing pin object is similar before concluding a transform into
		if(removed instanceof Pin && added instanceof Pin) {
			Pin removedPin = (Pin)removed;
			Pin addedPin = (Pin)added;
			boolean similars = true;
			// test name
			similars &= removedPin.getName() == null || removedPin.getName().equals(addedPin.getName());
			// test type
			similars &= EcoreUtil.equals(removedPin.getType(), addedPin.getType());
			// test is ordered
			similars &= removedPin.isOrdered() == addedPin.isOrdered();
			// test multiplicity : is unique
			similars &= removedPin.isUnique() == addedPin.isUnique();
			// test multiplicity : lower value
			similars &= EcoreUtil.equals(removedPin.getLowerValue(), addedPin.getLowerValue());
			// test multiplicity : upper value
			similars &= EcoreUtil.equals(removedPin.getUpperValue(), addedPin.getUpperValue());
			return similars;
		}
		return false;
	}

	/**
	 * Ensure Operation modification is reported on associated actions
	 * 
	 * @param operation
	 *        modified operation
	 * @param ctx
	 *        validation context
	 * @return status
	 */
	private IStatus handleOperationModification(Operation operation, IValidationContext ctx) {
		if(EMFEventType.ADD.equals(ctx.getEventType()) || EMFEventType.ADD_MANY.equals(ctx.getEventType())) {
			if(UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameter().equals(ctx.getFeature())) {
				return handleParametersAdded(operation, ctx);
			}
		} else if(EMFEventType.REMOVE.equals(ctx.getEventType()) || EMFEventType.REMOVE_MANY.equals(ctx.getEventType())) {
			if(UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameter().equals(ctx.getFeature())) {
				return handleParametersRemoved(operation, ctx);
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Ensure Behavior modification is reported on associated actions
	 * 
	 * @param behavior
	 *        modified behavior
	 * @param ctx
	 *        validation context
	 * @return status
	 */
	private IStatus handleBehaviorModification(Behavior behavior, IValidationContext ctx) {
		if(EMFEventType.ADD.equals(ctx.getEventType()) || EMFEventType.ADD_MANY.equals(ctx.getEventType())) {
			if(UMLPackage.eINSTANCE.getBehavior_OwnedParameter().equals(ctx.getFeature())) {
				return handleParametersAdded(behavior, ctx);
			}
		} else if(EMFEventType.REMOVE.equals(ctx.getEventType()) || EMFEventType.REMOVE_MANY.equals(ctx.getEventType())) {
			if(UMLPackage.eINSTANCE.getBehavior_OwnedParameter().equals(ctx.getFeature())) {
				return handleParametersRemoved(behavior, ctx);
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Ensure Signal modification is reported on associated actions
	 * 
	 * @param signal
	 *        modified signal
	 * @param ctx
	 *        validation context
	 * @return status
	 */
	private IStatus handleSignalModification(Signal signal, IValidationContext ctx) {
		if(EMFEventType.ADD.equals(ctx.getEventType()) || EMFEventType.ADD_MANY.equals(ctx.getEventType())) {
			if(UMLPackage.eINSTANCE.getSignal_OwnedAttribute().equals(ctx.getFeature())) {
				return handleAttributesAdded(signal, ctx);
			}
		} else if(EMFEventType.REMOVE.equals(ctx.getEventType()) || EMFEventType.REMOVE_MANY.equals(ctx.getEventType())) {
			if(UMLPackage.eINSTANCE.getSignal_OwnedAttribute().equals(ctx.getFeature())) {
				return handleAttributesRemoved(signal, ctx);
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Ensure Pins corresponding to parameters are removed
	 * 
	 * @param element
	 *        modified operation or behavior
	 * @param ctx
	 *        validation context
	 * @return status
	 */
	private IStatus handleParametersRemoved(NamedElement element, IValidationContext ctx) {
		// construct the list of removed indexes and their direction
		Map<Integer, ParameterDirectionKind> removedParameterIndexes = new HashMap<Integer, ParameterDirectionKind>();
		for(Notification event : ctx.getAllEvents()) {
			if(UMLPackage.eINSTANCE.getBehavior_OwnedParameter().equals(event.getFeature()) || UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameter().equals(event.getFeature())) {
				Object removedValue = event.getOldValue();
				if(removedValue instanceof Parameter) {
					// handle parameter direction
					ParameterDirectionKind dir = ((Parameter)removedValue).getDirection();
					removedParameterIndexes.put(event.getPosition(), dir);
				}
			}
		}
		List<Parameter> newParameters = Collections.emptyList();
		if(element instanceof Behavior) {
			newParameters = ((Behavior)element).getOwnedParameters();
		} else if(element instanceof Operation) {
			newParameters = ((Operation)element).getOwnedParameters();
		}
		List<Integer> removedInputPinIndexes = new LinkedList<Integer>();
		List<Integer> removedOutputPinIndexes = new LinkedList<Integer>();
		Iterator<Parameter> parametersIterator = newParameters.iterator();
		// iterate on the virtual list of old parameters (correspondingParameterIndex) to deduce
		// pins indexes
		int correspondingParameterIndex = 0;
		int correspondingInputPinIndex = 0;
		int correspondingOutputPinIndex = 0;
		while(removedParameterIndexes.containsKey(correspondingParameterIndex) || parametersIterator.hasNext()) {
			if(removedParameterIndexes.containsKey(correspondingParameterIndex)) {
				// parameter removed, pin(s) removed
				switch(removedParameterIndexes.get(correspondingParameterIndex)) {
				case IN_LITERAL:
					removedInputPinIndexes.add(correspondingInputPinIndex);
					correspondingInputPinIndex++;
					break;
				case OUT_LITERAL:
				case RETURN_LITERAL:
					removedOutputPinIndexes.add(correspondingOutputPinIndex);
					correspondingOutputPinIndex++;
					break;
				case INOUT_LITERAL:
					// in-out parameter has two pins
					removedInputPinIndexes.add(correspondingInputPinIndex);
					correspondingInputPinIndex++;
					removedOutputPinIndexes.add(correspondingOutputPinIndex);
					correspondingOutputPinIndex++;
					break;
				}
			} else {
				// parameter not removed, pin(s) not removed
				Parameter nextParam = parametersIterator.next();
				switch(nextParam.getDirection()) {
				case IN_LITERAL:
					correspondingInputPinIndex++;
					break;
				case OUT_LITERAL:
				case RETURN_LITERAL:
					correspondingOutputPinIndex++;
					break;
				case INOUT_LITERAL:
					// in-out parameter has two pins
					correspondingInputPinIndex++;
					correspondingOutputPinIndex++;
					break;
				}
			}
			// explore next parameter
			correspondingParameterIndex++;
		}

		CompoundCommand globalCmd = new CompoundCommand();
		// explore referencing actions
		List<InvocationAction> callingActions = getCallingActions(element);
		for(InvocationAction action : callingActions) {
			if(action instanceof CallAction) {
				CompoundCommand cmd = getRemovePinsCmd((CallAction)action, removedInputPinIndexes, removedOutputPinIndexes);
				globalCmd.append(cmd);
			}
		}
		if(!globalCmd.isEmpty() && globalCmd.canExecute()) {
			if(askForValidation(callingActions)) {
				globalCmd.execute();
			} else {
				return ctx.createFailureStatus();
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Ensure Pins corresponding to parameters are added
	 * 
	 * @param element
	 *        modified operation or behavior
	 * @param ctx
	 *        validation context
	 * @return status
	 */
	private IStatus handleParametersAdded(NamedElement element, IValidationContext ctx) {
		// construct the list of added indexes and their direction
		List<Parameter> addedParameters = new LinkedList<Parameter>();
		for(Notification event : ctx.getAllEvents()) {
			if(UMLPackage.eINSTANCE.getBehavior_OwnedParameter().equals(event.getFeature()) || UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameter().equals(event.getFeature())) {
				Object addedValue = event.getNewValue();
				if(addedValue instanceof Parameter) {
					addedParameters.add((Parameter)addedValue);
				}
			}
		}
		List<Parameter> newParameters = Collections.emptyList();
		if(element instanceof Behavior) {
			newParameters = ((Behavior)element).getOwnedParameters();
		} else if(element instanceof Operation) {
			newParameters = ((Operation)element).getOwnedParameters();
		}
		Map<Integer, Parameter> addedInputPinMap = new HashMap<Integer, Parameter>();
		Map<Integer, Parameter> addedOutputPinMap = new HashMap<Integer, Parameter>();
		// iterate on the list of new parameters to deduce pins indexes
		int correspondingInputPinIndex = 0;
		int correspondingOutputPinIndex = 0;
		for(Parameter param : newParameters) {
			if(addedParameters.contains(param)) {
				// parameter added, pin(s) to add
				switch(param.getDirection()) {
				case IN_LITERAL:
					addedInputPinMap.put(correspondingInputPinIndex, param);
					correspondingInputPinIndex++;
					break;
				case OUT_LITERAL:
				case RETURN_LITERAL:
					addedOutputPinMap.put(correspondingOutputPinIndex, param);
					correspondingOutputPinIndex++;
					break;
				case INOUT_LITERAL:
					// in-out parameter has two pins
					addedInputPinMap.put(correspondingInputPinIndex, param);
					correspondingInputPinIndex++;
					addedOutputPinMap.put(correspondingOutputPinIndex, param);
					correspondingOutputPinIndex++;
					break;
				}
			} else {
				// parameter not added, pin already exists
				switch(param.getDirection()) {
				case IN_LITERAL:
					correspondingInputPinIndex++;
					break;
				case OUT_LITERAL:
				case RETURN_LITERAL:
					correspondingOutputPinIndex++;
					break;
				case INOUT_LITERAL:
					// in-out parameter has two pins
					correspondingInputPinIndex++;
					correspondingOutputPinIndex++;
					break;
				}
			}
			// explore next parameter
		}

		CompoundCommand globalCmd = new CompoundCommand();
		// explore referencing actions
		List<InvocationAction> callingActions = getCallingActions(element);
		for(InvocationAction action : callingActions) {
			if(action instanceof CallAction) {
				CompoundCommand cmd = getAddPinsCmd((CallAction)action, addedInputPinMap, addedOutputPinMap);
				globalCmd.append(cmd);
			}
		}
		if(!globalCmd.isEmpty() && globalCmd.canExecute()) {
			if(askForValidation(callingActions)) {
				globalCmd.execute();
			} else {
				return ctx.createFailureStatus();
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Ensure Pins corresponding to parameters are removed
	 * 
	 * @param element
	 *        modified signal
	 * @param ctx
	 *        validation context
	 * @return status
	 */
	private IStatus handleAttributesRemoved(Signal element, IValidationContext ctx) {
		// construct the list of removed indexes and their direction
		Set<Integer> removedAttributeIndexes = new HashSet<Integer>();
		for(Notification event : ctx.getAllEvents()) {
			if(UMLPackage.eINSTANCE.getSignal_OwnedAttribute().equals(event.getFeature())) {
				Object removedValue = event.getOldValue();
				if(removedValue instanceof Property) {
					removedAttributeIndexes.add(event.getPosition());
				}
			}
		}
		// deduce pins indexes from old attributes indexes
		List<Integer> removedInputPinIndexes = new LinkedList<Integer>(removedAttributeIndexes);

		CompoundCommand globalCmd = new CompoundCommand();
		// explore referencing actions
		List<InvocationAction> callingActions = getCallingActions(element);
		for(InvocationAction action : callingActions) {
			if(action instanceof SendSignalAction) {
				CompoundCommand cmd = getRemovePinsCmd((SendSignalAction)action, removedInputPinIndexes);
				globalCmd.append(cmd);
			}
		}
		if(!globalCmd.isEmpty() && globalCmd.canExecute()) {
			if(askForValidation(callingActions)) {
				globalCmd.execute();
			} else {
				return ctx.createFailureStatus();
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Ensure Pins corresponding to attributes are added
	 * 
	 * @param element
	 *        modified signal
	 * @param ctx
	 *        validation context
	 * @return status
	 */
	private IStatus handleAttributesAdded(Signal element, IValidationContext ctx) {
		// construct the list of added indexes and their direction
		List<Property> addedAttributes = new LinkedList<Property>();
		for(Notification event : ctx.getAllEvents()) {
			if(UMLPackage.eINSTANCE.getSignal_OwnedAttribute().equals(event.getFeature())) {
				Object addedValue = event.getNewValue();
				if(addedValue instanceof Property) {
					addedAttributes.add((Property)addedValue);
				}
			}
		}
		List<Property> newAttributes = Collections.emptyList();
		if(element instanceof Signal) {
			newAttributes = ((Signal)element).getOwnedAttributes();
		}
		Map<Integer, Property> addedInputPinMap = new HashMap<Integer, Property>();
		// iterate on the list of added attributes to deduce pins indexes
		for(Property param : addedAttributes) {
			if(newAttributes.contains(param)) {
				addedInputPinMap.put(newAttributes.indexOf(param), param);
			}
		}

		CompoundCommand globalCmd = new CompoundCommand();
		// explore referencing actions
		List<InvocationAction> callingActions = getCallingActions(element);
		for(InvocationAction action : callingActions) {
			if(action instanceof SendSignalAction) {
				CompoundCommand cmd = getAddPinsCmd((SendSignalAction)action, addedInputPinMap);
				globalCmd.append(cmd);
			}
		}
		if(!globalCmd.isEmpty() && globalCmd.canExecute()) {
			if(askForValidation(callingActions)) {
				globalCmd.execute();
			} else {
				return ctx.createFailureStatus();
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Get the command to update type of target input pins referring the operation
	 * 
	 * @param operation
	 *        the operation which parent type has changed
	 * @return the command
	 */
	private CompoundCommand getUpdateTargetPinsType(Operation operation) {
		CompoundCommand globalCmd = new CompoundCommand();
		// get operation parent type
		Type type = null;
		Element owner = operation.getOwner();
		if(owner instanceof Type) {
			type = (Type)owner;
		}
		if(type != null) {// Get the editing domain
			TransactionalEditingDomain editingdomain = EditorUtils.getTransactionalEditingDomain();
			// explore referencing actions
			for(InvocationAction action : getCallingActions(operation)) {// operation is action's
																			// called Operation
				if(action instanceof CallOperationAction) {
					InputPin targetPin = ((CallOperationAction)action).getTarget();
					if(targetPin != null) {
						Command cmd = SetCommand.create(editingdomain, targetPin, UMLPackage.eINSTANCE.getTypedElement_Type(), type);
						globalCmd.append(cmd);
					}
				}
			}
		}
		return globalCmd;
	}

	/**
	 * Get the command to remove pins linked with parameter at the given indexes
	 * 
	 * @param action
	 *        the CallOperationAction or CallBehaviorAction (no effect otherwise)
	 * @param removedInputPinsIndexes
	 *        the indexes of input pins to remove (except target)
	 * @param removedOutputPinsIndexes
	 *        the indexes of output pins to remove
	 * @return the command to remove corresponding Pins
	 */
	private CompoundCommand getRemovePinsCmd(CallAction action, List<Integer> removedInputPinsIndexes, List<Integer> removedOutputPinsIndexes) {
		CompoundCommand globalCmd = new CompoundCommand();
		// Get the editing domain
		TransactionalEditingDomain editingdomain = EditorUtils.getTransactionalEditingDomain();
		if(action instanceof CallBehaviorAction || action instanceof CallOperationAction) {
			ArrayList<InputPin> removedIn = new ArrayList<InputPin>(removedInputPinsIndexes.size());
			for(int i : removedInputPinsIndexes) {
				if(i < action.getArguments().size()) {
					removedIn.add(action.getArguments().get(i));
				}
			}
			if(!removedIn.isEmpty()) {
				Command cmd = RemoveCommand.create(editingdomain, action, UMLPackage.eINSTANCE.getInvocationAction_Argument(), removedIn);
				globalCmd.append(cmd);
			}
			ArrayList<OutputPin> removedOut = new ArrayList<OutputPin>(removedInputPinsIndexes.size());
			for(int i : removedOutputPinsIndexes) {
				if(i < action.getResults().size()) {
					removedOut.add(action.getResults().get(i));
				}
			}
			if(!removedOut.isEmpty()) {
				Command cmd = RemoveCommand.create(editingdomain, action, UMLPackage.eINSTANCE.getCallAction_Result(), removedOut);
				globalCmd.append(cmd);
			}
		}
		return globalCmd;
	}

	/**
	 * Get the command to remove pins linked with attribute at the given indexes
	 * 
	 * @param action
	 *        the SendSignalAction
	 * @param removedInputPinsIndexes
	 *        the indexes of input pins to remove (except target)
	 * @return the command to remove corresponding Pins
	 */
	private CompoundCommand getRemovePinsCmd(SendSignalAction action, List<Integer> removedInputPinsIndexes) {
		CompoundCommand globalCmd = new CompoundCommand();
		// Get the editing domain
		TransactionalEditingDomain editingdomain = EditorUtils.getTransactionalEditingDomain();
		if(action instanceof SendSignalAction) {
			ArrayList<InputPin> removedIn = new ArrayList<InputPin>(removedInputPinsIndexes.size());
			for(int i : removedInputPinsIndexes) {
				if(i < action.getArguments().size()) {
					removedIn.add(action.getArguments().get(i));
				}
			}
			if(!removedIn.isEmpty()) {
				Command cmd = RemoveCommand.create(editingdomain, action, UMLPackage.eINSTANCE.getInvocationAction_Argument(), removedIn);
				globalCmd.append(cmd);
			}
		}
		return globalCmd;
	}

	/**
	 * Get the command to add pins linked with parameter at the given indexes
	 * 
	 * @param action
	 *        the CallBehaviorAction or CallOperationAction (no effect otherwise)
	 * @param addedInputPinMap
	 *        the indexes of input pins to add and parameters to copy
	 * @param addedOutputPinMap
	 *        the indexes of output pins to add and parameters to copy
	 * @return the command to add corresponding Pins
	 */
	private CompoundCommand getAddPinsCmd(CallAction action, Map<Integer, Parameter> addedInputPinMap, Map<Integer, Parameter> addedOutputPinMap) {
		CompoundCommand globalCmd = new CompoundCommand();
		// Get the editing domain
		TransactionalEditingDomain editingdomain = EditorUtils.getTransactionalEditingDomain();
		if(action instanceof CallBehaviorAction || action instanceof CallOperationAction) {
			/*
			 * An element can not be added at an index bigger than the size. Hence, add commands
			 * must be sorted according to the decreasing index and the index must be adapted taking
			 * in account elements that will be added. We use a bucket sort on indexes of both maps.
			 */
			int nextKey = addedInputPinMap.size() + action.getArguments().size();
			int numberOfPinsToAdd = addedInputPinMap.size();
			while(numberOfPinsToAdd > 0) {
				if(addedInputPinMap.containsKey(nextKey)) {
					numberOfPinsToAdd--;
					InputPin pin = createInputPin(addedInputPinMap.get(nextKey));
					// index at which pin is added must take in account other pins added after
					int addIndex = nextKey - numberOfPinsToAdd;
					Command cmd = AddCommand.create(editingdomain, action, UMLPackage.eINSTANCE.getInvocationAction_Argument(), pin, addIndex);
					globalCmd.append(cmd);
				}
				nextKey--;
			}
			nextKey = addedOutputPinMap.size() + action.getResults().size();
			numberOfPinsToAdd = addedOutputPinMap.size();
			while(numberOfPinsToAdd > 0) {
				if(addedOutputPinMap.containsKey(nextKey)) {
					numberOfPinsToAdd--;
					OutputPin pin = createOutputPin(addedOutputPinMap.get(nextKey));
					// index at which pin is added must take in account other pins added after
					int addIndex = nextKey - numberOfPinsToAdd;
					Command cmd = AddCommand.create(editingdomain, action, UMLPackage.eINSTANCE.getCallAction_Result(), pin, addIndex);
					globalCmd.append(cmd);
				}
				nextKey--;
			}
		}
		return globalCmd;
	}

	/**
	 * Get the command to add pins linked with properties at the given indexes
	 * 
	 * @param action
	 *        the SendSignalAction
	 * @param addedInputPinMap
	 *        the indexes of input pins to add and properties to copy
	 * @return the command to add corresponding Pins
	 */
	private CompoundCommand getAddPinsCmd(SendSignalAction action, Map<Integer, Property> addedInputPinMap) {
		CompoundCommand globalCmd = new CompoundCommand();
		// Get the editing domain
		TransactionalEditingDomain editingdomain = EditorUtils.getTransactionalEditingDomain();
		/*
		 * An element can not be added at an index bigger than the size. Hence, add commands must be
		 * sorted according to the decreasing index and the index must be adapted taking in account
		 * elements that will be added. We use a bucket sort on indexes of both maps.
		 */
		int nextKey = addedInputPinMap.size() + action.getArguments().size();
		int numberOfPinsToAdd = addedInputPinMap.size();
		while(numberOfPinsToAdd > 0) {
			if(addedInputPinMap.containsKey(nextKey)) {
				numberOfPinsToAdd--;
				InputPin pin = createInputPin(addedInputPinMap.get(nextKey));
				// index at which pin is added must take in account other pins added after
				int addIndex = nextKey - numberOfPinsToAdd;
				Command cmd = AddCommand.create(editingdomain, action, UMLPackage.eINSTANCE.getInvocationAction_Argument(), pin, addIndex);
				globalCmd.append(cmd);
			}
			nextKey--;
		}
		return globalCmd;
	}

	/**
	 * Create an output pin with valued copied from the parameter
	 * 
	 * @param parameter
	 *        the reference parameter
	 */
	private OutputPin createOutputPin(Parameter parameter) {
		OutputPin pin = UMLFactory.eINSTANCE.createOutputPin();
		// Initialize name
		pin.setName(parameter.getName());
		// Synchronize type
		pin.setType(parameter.getType());
		// Synchronize is ordered
		pin.setIsOrdered(parameter.isOrdered());
		// Synchronize mutliplicity : is unique
		pin.setIsUnique(parameter.isUnique());
		// Synchronize mutliplicity : lower value
		ValueSpecification lowerValue = parameter.getLowerValue();
		if(lowerValue != null) {
			// use a copy command for new value
			Command copy = CopyCommand.create(EditorUtils.getTransactionalEditingDomain(), Collections.singleton(lowerValue));
			copy.execute();
			Collection<?> result = copy.getResult();
			Object valueToAffect = null;
			if(!result.isEmpty()) {
				valueToAffect = result.iterator().next();
			}
			if(valueToAffect instanceof ValueSpecification) {
				pin.setLowerValue((ValueSpecification)valueToAffect);
			}
		}
		// Synchronize mutliplicity : upper value
		ValueSpecification upperValue = parameter.getUpperValue();
		if(upperValue != null) {
			// use a copy command for new value
			Command copy = CopyCommand.create(EditorUtils.getTransactionalEditingDomain(), Collections.singleton(upperValue));
			copy.execute();
			Collection<?> result = copy.getResult();
			Object valueToAffect = null;
			if(!result.isEmpty()) {
				valueToAffect = result.iterator().next();
			}
			if(valueToAffect instanceof ValueSpecification) {
				pin.setUpperValue((ValueSpecification)valueToAffect);
			}
		}
		return pin;
	}

	/**
	 * Create a target input pin, eventually from a given operation
	 * 
	 * @param operation
	 *        the invoked operation or null
	 */
	private InputPin createTargetPin(Operation operation) {
		InputPin pin = UMLFactory.eINSTANCE.createInputPin();
		if(operation != null) {
			Element owningType = operation.getOwner();
			if(owningType instanceof Type) {
				pin.setType((Type)owningType);
			}
		}
		pin.setName(TARGET_PIN_INITIALIZATION_NAME);
		return pin;
	}

	/**
	 * Create a request input pin
	 * 
	 * @param operation
	 *        the invoked operation or null
	 */
	private InputPin createRequestPin() {
		InputPin pin = UMLFactory.eINSTANCE.createInputPin();
		pin.setName(REQUEST_PIN_INITIALIZATION_NAME);
		return pin;
	}

	/**
	 * Create an input pin with valued copied from the property
	 * 
	 * @param property
	 *        the reference property
	 */
	private InputPin createInputPin(Property property) {
		InputPin pin = UMLFactory.eINSTANCE.createInputPin();
		// Initialize name
		pin.setName(property.getName());
		// Synchronize type
		pin.setType(property.getType());
		// Synchronize is ordered
		pin.setIsOrdered(property.isOrdered());
		// Synchronize multiplicity : is unique
		pin.setIsUnique(property.isUnique());
		// Synchronize multiplicity : lower value
		ValueSpecification lowerValue = property.getLowerValue();
		if(lowerValue != null) {
			// use a copy command for new value
			Command copy = CopyCommand.create(EditorUtils.getTransactionalEditingDomain(), Collections.singleton(lowerValue));
			copy.execute();
			Collection<?> result = copy.getResult();
			Object valueToAffect = null;
			if(!result.isEmpty()) {
				valueToAffect = result.iterator().next();
			}
			if(valueToAffect instanceof ValueSpecification) {
				pin.setLowerValue((ValueSpecification)valueToAffect);
			}
		}
		// Synchronize multiplicity : upper value
		ValueSpecification upperValue = property.getUpperValue();
		if(upperValue != null) {
			// use a copy command for new value
			Command copy = CopyCommand.create(EditorUtils.getTransactionalEditingDomain(), Collections.singleton(upperValue));
			copy.execute();
			Collection<?> result = copy.getResult();
			Object valueToAffect = null;
			if(!result.isEmpty()) {
				valueToAffect = result.iterator().next();
			}
			if(valueToAffect instanceof ValueSpecification) {
				pin.setUpperValue((ValueSpecification)valueToAffect);
			}
		}
		return pin;
	}

	/**
	 * Create an input pin with valued copied from the parameter
	 * 
	 * @param parameter
	 *        the reference parameter
	 */
	private InputPin createInputPin(Parameter parameter) {
		InputPin pin = UMLFactory.eINSTANCE.createInputPin();
		// Initialize name
		pin.setName(parameter.getName());
		// Synchronize type
		pin.setType(parameter.getType());
		// Synchronize is ordered
		pin.setIsOrdered(parameter.isOrdered());
		// Synchronize multiplicity : is unique
		pin.setIsUnique(parameter.isUnique());
		// Synchronize multiplicity : lower value
		ValueSpecification lowerValue = parameter.getLowerValue();
		if(lowerValue != null) {
			// use a copy command for new value
			Command copy = CopyCommand.create(EditorUtils.getTransactionalEditingDomain(), Collections.singleton(lowerValue));
			copy.execute();
			Collection<?> result = copy.getResult();
			Object valueToAffect = null;
			if(!result.isEmpty()) {
				valueToAffect = result.iterator().next();
			}
			if(valueToAffect instanceof ValueSpecification) {
				pin.setLowerValue((ValueSpecification)valueToAffect);
			}
		}
		// Synchronize multiplicity : upper value
		ValueSpecification upperValue = parameter.getUpperValue();
		if(upperValue != null) {
			// use a copy command for new value
			Command copy = CopyCommand.create(EditorUtils.getTransactionalEditingDomain(), Collections.singleton(upperValue));
			copy.execute();
			Collection<?> result = copy.getResult();
			Object valueToAffect = null;
			if(!result.isEmpty()) {
				valueToAffect = result.iterator().next();
			}
			if(valueToAffect instanceof ValueSpecification) {
				pin.setUpperValue((ValueSpecification)valueToAffect);
			}
		}
		return pin;
	}

	/**
	 * Get the command to reset all pins of the action.
	 * 
	 * @param action
	 *        action to reinitialize pins (SendObjectAction)
	 * @return command
	 */
	private CompoundCommand getResetPinsCmd(SendObjectAction action) {
		// Get the editing domain
		TransactionalEditingDomain editingdomain = EditorUtils.getTransactionalEditingDomain();
		CompoundCommand globalCmd = new CompoundCommand();

		// add target pin
		if(action.getTarget() == null) {
			InputPin targetPin = createTargetPin(null);
			Command cmd = SetCommand.create(editingdomain, action, UMLPackage.eINSTANCE.getSendObjectAction_Target(), targetPin);
			globalCmd.append(cmd);
		}
		// add request pin
		if(action.getRequest() == null) {
			InputPin requestPin = createRequestPin();
			Command cmd = SetCommand.create(editingdomain, action, UMLPackage.eINSTANCE.getSendObjectAction_Request(), requestPin);
			globalCmd.append(cmd);
		}

		return globalCmd;
	}

	/**
	 * Get the command to reset all pins of the action.
	 * 
	 * @param action
	 *        action to reinitialize pins (SendSignalAction)
	 * @return command
	 */
	private CompoundCommand getResetPinsCmd(SendSignalAction action) {
		// Get the editing domain
		TransactionalEditingDomain editingdomain = EditorUtils.getTransactionalEditingDomain();
		CompoundCommand globalCmd = new CompoundCommand();

		// remove argument pins
		if(!action.getArguments().isEmpty()) {
			Command cmd = RemoveCommand.create(editingdomain, action, UMLPackage.eINSTANCE.getInvocationAction_Argument(), action.getArguments());
			globalCmd.append(cmd);
		}

		// recover attributes
		List<Property> attributes = Collections.emptyList();
		Signal signal = action.getSignal();
		if(signal != null) {
			attributes = signal.getOwnedAttributes();
		}

		// add pins corresponding to attributes
		Map<Integer, Property> inParameters = new HashMap<Integer, Property>();
		int inIndex = 0;
		for(Property att : attributes) {
			inParameters.put(inIndex, att);
			inIndex++;
		}
		if(!inParameters.isEmpty()) {
			Command cmd = getAddPinsCmd(action, inParameters);
			globalCmd.append(cmd);
		}

		// add target pin
		if(action.getTarget() == null) {
			InputPin targetPin = createTargetPin(null);
			Command cmd = SetCommand.create(editingdomain, action, UMLPackage.eINSTANCE.getSendSignalAction_Target(), targetPin);
			globalCmd.append(cmd);
		}

		return globalCmd;
	}

	/**
	 * Get the command to reset all pins of the action.
	 * 
	 * @param action
	 *        action to reinitialize pins (CallOperationAction or CallBehaviorAction)
	 * @return command
	 */
	private CompoundCommand getResetPinsCmd(CallAction action) {
		// Get the editing domain
		TransactionalEditingDomain editingdomain = EditorUtils.getTransactionalEditingDomain();
		CompoundCommand globalCmd = new CompoundCommand();

		// remove argument pins
		if(!action.getArguments().isEmpty()) {
			Command cmd = RemoveCommand.create(editingdomain, action, UMLPackage.eINSTANCE.getInvocationAction_Argument(), action.getArguments());
			globalCmd.append(cmd);
		}
		// remove result pins
		if(!action.getResults().isEmpty()) {
			Command cmd = RemoveCommand.create(editingdomain, action, UMLPackage.eINSTANCE.getCallAction_Result(), action.getResults());
			globalCmd.append(cmd);
		}
		if(action instanceof CallOperationAction) {
			// remove target pin
			InputPin target = ((CallOperationAction)action).getTarget();
			if(target != null) {
				Command cmd = SetCommand.create(editingdomain, action, UMLPackage.eINSTANCE.getCallOperationAction_Target(), null);
				globalCmd.append(cmd);
			}
		}

		// recover parameters
		List<Parameter> parameters = Collections.emptyList();
		if(action instanceof CallOperationAction) {
			Operation operation = ((CallOperationAction)action).getOperation();
			if(operation != null) {
				parameters = operation.getOwnedParameters();
			}
		}
		if(action instanceof CallBehaviorAction) {
			Behavior behavior = ((CallBehaviorAction)action).getBehavior();
			if(behavior != null) {
				parameters = behavior.getOwnedParameters();
			}
		}

		// add pins corresponding to parameters
		Map<Integer, Parameter> inParameters = new HashMap<Integer, Parameter>();
		Map<Integer, Parameter> outParameters = new HashMap<Integer, Parameter>();
		int inIndex = 0;
		int outIndex = 0;
		for(Parameter param : parameters) {
			switch(param.getDirection()) {
			case IN_LITERAL:
				inParameters.put(inIndex, param);
				inIndex++;
				break;
			case OUT_LITERAL:
			case RETURN_LITERAL:
				outParameters.put(outIndex, param);
				outIndex++;
				break;
			case INOUT_LITERAL:
				inParameters.put(inIndex, param);
				inIndex++;
				outParameters.put(outIndex, param);
				outIndex++;
				break;
			}
		}
		if(!inParameters.isEmpty() || !outParameters.isEmpty()) {
			Command cmd = getAddPinsCmd(action, inParameters, outParameters);
			globalCmd.append(cmd);
		}

		if(action instanceof CallOperationAction) {
			// add target pin
			Operation operation = ((CallOperationAction)action).getOperation();
			if(operation != null) {
				InputPin targetPin = createTargetPin(operation);
				Command cmd = SetCommand.create(editingdomain, action, UMLPackage.eINSTANCE.getCallOperationAction_Target(), targetPin);
				globalCmd.append(cmd);
			}
		}

		return globalCmd;
	}

	/**
	 * Get the command to update a pins list with the name if not set yet
	 * 
	 * @param pins
	 *        the list of pins to update
	 * @param name
	 *        the new name set on parameter
	 * @return the command to execute
	 */
	private CompoundCommand getSetPinsNamesCmd(List<Pin> pins, String name) {
		CompoundCommand globalCmd = new CompoundCommand();
		if(pins == null || name == null || "".equals(name)) {
			return globalCmd;
		}
		// Get the editing domain
		TransactionalEditingDomain editingdomain = EditorUtils.getTransactionalEditingDomain();
		for(Pin pin : pins) {
			// erase the name only if null (not set, the user may have set an empty string name)
			if(pin.getName() == null) {
				// add the command
				Command cmd = SetCommand.create(editingdomain, pin, UMLPackage.eINSTANCE.getNamedElement_Name(), name);
				globalCmd.append(cmd);
			}
		}
		return globalCmd;
	}

	/**
	 * Get the command to update a pins list with given values
	 * 
	 * @param pins
	 *        the list of pins to update
	 * @param type
	 *        the new type value
	 * @param ordered
	 *        the new isOrdered value
	 * @param unique
	 *        the new isUnique value
	 * @param lower
	 *        the new lower value
	 * @param lowerValue
	 *        the new lowerValue value
	 * @param upper
	 *        the new upper value
	 * @param upperValue
	 *        the new upperValue value
	 * @return the command to execute
	 */
	private CompoundCommand getUpdatePinsCmd(List<Pin> pins, Type type, boolean ordered, boolean unique, int lower, ValueSpecification lowerValue, int upper, ValueSpecification upperValue) {
		CompoundCommand globalCmd = new CompoundCommand();
		if(pins == null) {
			return globalCmd;
		}
		// Get the editing domain
		TransactionalEditingDomain editingdomain = EditorUtils.getTransactionalEditingDomain();
		for(Pin pin : pins) {
			if(!EcoreUtil.equals(pin.getType(), type)) {
				// add the command
				Command cmd = SetCommand.create(editingdomain, pin, UMLPackage.eINSTANCE.getTypedElement_Type(), type);
				globalCmd.append(cmd);
			}
			if(pin.isOrdered() != ordered) {
				// add the command
				Command cmd = SetCommand.create(editingdomain, pin, UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered(), ordered);
				globalCmd.append(cmd);
			}
			if(pin.isUnique() != unique) {
				// add the command
				Command cmd = SetCommand.create(editingdomain, pin, UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique(), unique);
				globalCmd.append(cmd);
			}
			// UMLPackage.eINSTANCE.getMultiplicityElement_Lower() is derived from
			// UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue()
			if(!EcoreUtil.equals(pin.getLowerValue(), lowerValue)) {
				Object affectedvalue = null;
				// Execute a copy command then add the set command
				if(lowerValue != null) {
					Command copy = CopyCommand.create(editingdomain, Collections.singleton(lowerValue));
					copy.execute();
					Collection<?> result = copy.getResult();
					if(!result.isEmpty()) {
						affectedvalue = result.iterator().next();
					}
				}
				Command cmd = SetCommand.create(editingdomain, pin, UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue(), affectedvalue);
				globalCmd.append(cmd);
			}
			// UMLPackage.eINSTANCE.getMultiplicityElement_Upper() is derived from
			// UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue()
			if(!EcoreUtil.equals(pin.getUpperValue(), upperValue)) {
				Object affectedvalue = null;
				// Execute a copy command then add the set command
				if(upperValue != null) {
					Command copy = CopyCommand.create(editingdomain, Collections.singleton(upperValue));
					copy.execute();
					Collection<?> result = copy.getResult();
					if(!result.isEmpty()) {
						affectedvalue = result.iterator().next();
					}
				}
				Command cmd = SetCommand.create(editingdomain, pin, UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue(), affectedvalue);
				globalCmd.append(cmd);
			}
		}
		return globalCmd;
	}

	/**
	 * Get the object invoked by the pin's parent action
	 * 
	 * @return invoked operation, invoked behavior or null
	 */
	static private NamedElement getInvokedObject(Pin pin) {
		Element action = pin.getOwner();
		if(action instanceof CallOperationAction) {
			Operation operation = ((CallOperationAction)action).getOperation();
			return operation;
		} else if(action instanceof CallBehaviorAction) {
			Behavior behavior = ((CallBehaviorAction)action).getBehavior();
			return behavior;
		} else if(action instanceof SendSignalAction) {
			Signal signal = ((SendSignalAction)action).getSignal();
			return signal;
		}
		return null;
	}

	/**
	 * Get all Pins associated to the property (provided no pin or property has been added without
	 * synchronization)
	 * 
	 * @param property
	 *        the property
	 * @return the list of associated pins
	 */
	static private List<Pin> getPins(Property property) {
		Element owner = property.getOwner();
		if(owner instanceof Signal) {
			// initialize listOfPins
			List<Pin> listOfPins = new LinkedList<Pin>();
			// get index of pins
			int inIndex = ((Signal)owner).getAttributes().indexOf(property);
			List<InvocationAction> callingActions = getCallingActions(owner);
			// inspect each referencing action
			for(InvocationAction action : callingActions) {
				// owner is action's sent Signal
				Pin pin = ((SendSignalAction)action).getArguments().get(inIndex);
				if(pin != null) {
					listOfPins.add(pin);
				}
			}
			return listOfPins;
		}
		return Collections.emptyList();
	}

	/**
	 * Get all Pins associated to the parameter (provided no pin or parameter has been added without
	 * synchronization)
	 * 
	 * @param parameter
	 *        the parameter
	 * @return the list of associated pins
	 */
	static private List<Pin> getPins(Parameter parameter) {
		Element owner = parameter.getOwner();
		List<InvocationAction> callingActions = getCallingActions(owner);
		// initialize listOfPins
		List<Pin> listOfPins = new LinkedList<Pin>();
		// get index of pins
		int inIndex = -1;
		int outIndex = -1;
		switch(parameter.getDirection()) {
		case IN_LITERAL:
			inIndex = getIndex(parameter, true);
			break;
		case OUT_LITERAL:
		case RETURN_LITERAL:
			outIndex = getIndex(parameter, false);
			break;
		case INOUT_LITERAL:
			inIndex = getIndex(parameter, true);
			outIndex = getIndex(parameter, false);
			break;
		}
		if(owner instanceof Operation) {
			// inspect each referencing action
			for(InvocationAction action : callingActions) {
				// owner is action's called Operation
				switch(parameter.getDirection()) {
				case IN_LITERAL:
					Pin pin = ((CallOperationAction)action).getArguments().get(inIndex);
					if(pin != null) {
						listOfPins.add(pin);
					}
					break;
				case OUT_LITERAL:
				case RETURN_LITERAL:
					pin = ((CallOperationAction)action).getResults().get(outIndex);
					if(pin != null) {
						listOfPins.add(pin);
					}
					break;
				case INOUT_LITERAL:
					pin = ((CallOperationAction)action).getArguments().get(inIndex);
					if(pin != null) {
						listOfPins.add(pin);
					}
					pin = ((CallOperationAction)action).getResults().get(outIndex);
					if(pin != null) {
						listOfPins.add(pin);
					}
					break;
				}
			}
			return listOfPins;
		} else if(owner instanceof Behavior) {
			// inspect each referencing action
			for(InvocationAction action : callingActions) {
				// owner is action's called Behavior
				switch(parameter.getDirection()) {
				case IN_LITERAL:
					Pin pin = ((CallBehaviorAction)action).getArguments().get(inIndex);
					if(pin != null) {
						listOfPins.add(pin);
					}
					break;
				case OUT_LITERAL:
				case RETURN_LITERAL:
					pin = ((CallBehaviorAction)action).getResults().get(outIndex);
					if(pin != null) {
						listOfPins.add(pin);
					}
					break;
				case INOUT_LITERAL:
					pin = ((CallBehaviorAction)action).getArguments().get(inIndex);
					if(pin != null) {
						listOfPins.add(pin);
					}
					pin = ((CallBehaviorAction)action).getResults().get(outIndex);
					if(pin != null) {
						listOfPins.add(pin);
					}
					break;
				}
			}
			return listOfPins;
		}
		return Collections.emptyList();
	}

	/**
	 * Get the index (considering Parameters in or out parameters only) at which the parameter
	 * appears in its container. For convenience with Pin mapping, in-out parameters counted are in
	 * both solution. Note that this count does not take in account the searched for parameter
	 * direction. This means that this method works even if the searched parameter has a different
	 * direction than the one specified in in (usefull when direction changes).
	 * 
	 * @param parameter
	 *        the searched parameter
	 * @param in
	 *        if true, compute position in Parameters of direction in, if false, of direction
	 *        out
	 * @return the position in which the parameter appears (0 based) or -1 if failed
	 */
	static private int getIndex(Parameter parameter, boolean in) {
		if(parameter == null) {
			return -1;
		}
		Element owner = parameter.getOwner();
		List<Parameter> parametersList = Collections.emptyList();
		if(owner instanceof Operation) {
			parametersList = ((Operation)owner).getOwnedParameters();
		} else if(owner instanceof Behavior) {
			parametersList = ((Behavior)owner).getOwnedParameters();
		}
		int index = 0;
		for(Parameter param : parametersList) {
			if(param.equals(parameter)) {
				return index;
			}
			if(in && (ParameterDirectionKind.IN_LITERAL.equals(param.getDirection()) || ParameterDirectionKind.INOUT_LITERAL.equals(param.getDirection()))) {
				index++;
			} else if(!in && (ParameterDirectionKind.OUT_LITERAL.equals(param.getDirection()) || ParameterDirectionKind.RETURN_LITERAL.equals(param.getDirection()) || ParameterDirectionKind.INOUT_LITERAL.equals(param.getDirection()))) {
				index++;
			}
		}
		return -1;
	}

	/**
	 * Ask the user to validate all the implied modifications (parameters and all associated pins)
	 * 
	 * @param listOfActions
	 *        the list of impacted calling actions
	 * @return whether the user validates the modifications
	 */
	protected boolean askForValidation(List<? extends NamedElement> listOfActions) {
		/*
		 * We are currently validating an ongoing operation. Opening a popup here may have
		 * side-effects such as re-launching the same operation. (the editor has not been
		 * deactivated yet, and its loss of focus will open a new operation) For this reason, we
		 * temporarily disable all operations on the history, just enough time for opening the
		 * popup.
		 */
		IOperationHistory history = OperationHistoryFactory.getOperationHistory();
		history.addOperationApprover(operationDisapprover);
		boolean result = ConfirmPinAndParameterSyncDialog.openConfirmFromParameter(Display.getDefault().getActiveShell(), listOfActions, labelProvider);
		history.removeOperationApprover(operationDisapprover);
		return result;
	}
}
