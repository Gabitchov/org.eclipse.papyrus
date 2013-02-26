/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Arthur Daussy (Atos) - Initial API and implementation
 *   Arthur Daussy - 371712 : [Activitydiagram] Papyrus should provide a way to manually resynchronize pins and parameters on Call Actions
 *   Olivier Mélois (Atos) : olivier.melois@atos.net - 371712
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.handlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.commands.DestroyElementPapyrusCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.Type;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.view.PapyrusNotificationView;
import org.eclipse.papyrus.uml.diagram.activity.commands.CreatePinToParameterLinkEAnnotation;
import org.eclipse.papyrus.uml.diagram.activity.helper.IPinToParameterLinkCommand;
import org.eclipse.papyrus.uml.diagram.activity.helper.PinAndParameterSynchronizer;
import org.eclipse.papyrus.uml.diagram.activity.helper.datastructure.LinkPinToParameter;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLMarkerNavigationProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BroadcastSignalAction;
import org.eclipse.uml2.uml.CallAction;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.InvocationAction;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Pin;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * Handler to synchronized the pin and parameter manually
 * 
 * @author arthur daussy
 * 
 */
public class SynchronizePinsParametersHandler extends AbstractSynchronizePinsAndParameters {

	/**
	 * Label for the handler (use in notification and dialog)
	 */
	private static final String SYNCHRONIZE_PINS_AND_PARAMETERS = "Synchronize pins and parameters";

	/**
	 * Constructor
	 */
	public SynchronizePinsParametersHandler() {
	}

	/**
	 * Execute unprotected command
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		if(selection instanceof StructuredSelection) {
			StructuredSelection structuredSelection = (StructuredSelection)selection;
			Object obj = structuredSelection.getFirstElement();
			EObject element = null;
			if(obj instanceof IAdaptable) {
				element = (EObject)((IAdaptable)obj).getAdapter(EObject.class);
				if(element instanceof View) {
					element = ((View)element).getElement();
				}
				if(element instanceof InvocationAction) {
					syncInvocationAction((InvocationAction)element);
				}
			}
		}
		return null;
	}

	/**
	 * Synchronizes a Call Action
	 * 
	 * @param callAction
	 */
	public static void syncInvocationAction(InvocationAction invocationAction) {
		if(!isAccessible(invocationAction)) {
			createNotification(SYNCHRONIZE_PINS_AND_PARAMETERS, "Unable to synchronize pins on " + invocationAction.getQualifiedName() + " : the ressource is unreachable", Type.WARNING);
			return;
		}
		//Trying to match pins of the callAction with parameters of same index/direction/type.
		//The pins that can not be matched will be destroyed by the "syncCallActionWhenOutdated" method.
		matchPinsAndParams(invocationAction);
		if(isUpToDate(invocationAction)) {
			createNotification(SYNCHRONIZE_PINS_AND_PARAMETERS, "The call action " + invocationAction.getQualifiedName() + " is up to date", Type.INFO);
		} else {
			//Synchronization when a link between pins and params already exists but is outdated.
			syncCallActionWhenOutdated(invocationAction);
		}
		//Renaming pins according to their associated parameters.
		renamePins(invocationAction);
	}

	/**
	 * Rename the pins according to their parameters when possible.
	 * 
	 * @param invocationAction
	 */
	private static void renamePins(final InvocationAction invocationAction) {
		//Command used as renaming the pins change the model.
		AbstractTransactionalCommand renamePinsCommand = new AbstractTransactionalCommand(EditorUtils.getTransactionalEditingDomain(), "renaming pins", null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				Iterable<? extends Pin> allPins = Lists.newArrayList(invocationAction.getArguments());
				if(invocationAction instanceof CallAction) {
					allPins = Iterables.concat(((CallAction)invocationAction).getResults(), allPins);
				}
				Element behaviorStructural = null;
				if(invocationAction instanceof CallBehaviorAction) {
					behaviorStructural = ((CallBehaviorAction)invocationAction).getBehavior();
				} else if(invocationAction instanceof CallOperationAction) {
					behaviorStructural = ((CallOperationAction)invocationAction).getOperation();
				} else if(invocationAction instanceof SendSignalAction) {
					behaviorStructural = ((SendSignalAction)invocationAction).getSignal();
				} else if(invocationAction instanceof BroadcastSignalAction) {
					behaviorStructural = ((BroadcastSignalAction)invocationAction).getSignal();
				}
				XMIResource xmiResource = PinAndParameterSynchronizer.getXMIResource(behaviorStructural);
				for(Pin pin : allPins) {
					TypedElement typedElement = PinAndParameterSynchronizer.getLinkedParemeter(pin, xmiResource);
					if(typedElement != null) {
						String paramName = typedElement.getName();
						pin.setName(paramName);
					}
				}
				return CommandResult.newOKCommandResult();
			}
		};
		executeCommand(new GMFtoEMFCommandWrapper(renamePinsCommand), invocationAction);
	}

	/**
	 * Method used to match the pins of a call action with parameters of that same call action,
	 * when the pins do not have eAnnotations already linking to parameters. If no match can
	 * be performed, the pin is destroyed along with its edges.
	 * 
	 * @param callAction
	 */
	private static void matchPinsAndParams(InvocationAction invocationAction) {
		List<InputPin> inputPins = Lists.newArrayList(invocationAction.getArguments());
		List<OutputPin> outputPins = null;
		if(outputPins instanceof CallAction) {
			CallAction callAction = (CallAction)outputPins;
			outputPins = callAction.getResults();
		} else {
			outputPins = Collections.emptyList();
		}
		//The command that is going to be executed.
		CompoundCommand linkingPinsAndParamsCommand = new CompoundCommand();
		//		CompositeTransactionalCommand linkingPinsAndParamsCommand = new CompositeTransactionalCommand(EditorUtils.getTransactionalEditingDomain(), "Pin synchronization");////$NON-NLS-1$
		if(invocationAction instanceof CallAction) {
			CallAction callAction = (CallAction)invocationAction;
			List<Parameter> callActionParams = getParametersFromCallAction(callAction);
			Map<Integer, TypedElement> inputParameters = new HashMap<Integer, TypedElement>();
			Map<Integer, TypedElement> outputParameters = new HashMap<Integer, TypedElement>();
			//Splitting parameters.
			PinAndParameterSynchronizer.splitParameters(callActionParams, Lists.<Parameter> newArrayList(), inputParameters, outputParameters, invocationAction);
			//Matching pins and parameters.
			matchPinsAndParams(inputPins, inputParameters, linkingPinsAndParamsCommand);
			matchPinsAndParams(outputPins, outputParameters, linkingPinsAndParamsCommand);
		} else if(invocationAction instanceof InvocationAction) {
			Map<Integer, TypedElement> invocationActionProperties = getPropertyFromInvocationAction(invocationAction);
			matchPinsAndParams(inputPins, invocationActionProperties, linkingPinsAndParamsCommand);
		}
		//Execution of the command
		executeCommand(linkingPinsAndParamsCommand, invocationAction);
	}

	/**
	 * Refinement for the matchPinsAndParams(CallAction) method.
	 * 
	 * @param pins
	 *        : the list of all input (or output) pins. The list will be filtered
	 *        to try to just perform a matching on pins that do not have eAnnotations linking
	 *        to parameters.
	 * @param parameters
	 *        : parameters with the same direction as the pins.
	 * @param globalCmd
	 *        : the command used to create the eAnnotations.
	 */
	private static void matchPinsAndParams(List<? extends Pin> pins, Map<Integer, ? extends TypedElement> parameters, CompoundCommand globalCmd) {
		for(int pinIndex = 0; pinIndex < pins.size(); pinIndex++) {
			Pin pin = pins.get(pinIndex);
			//The matching is performed only on pins that do not have a pin-to-parameter link.
			if(lacksPinToParameterLink(pin)) {
				TypedElement paramWithSameIndex = parameters.get(pinIndex);
				boolean foundMatchingParam = false;
				if(paramWithSameIndex != null) {
					//A parameter has been found with the same index as the pin. If both have the same type, a link is created.
					if(pin.getType() == paramWithSameIndex.getType()) {
						LinkPinToParameter link = new LinkPinToParameter(pin, paramWithSameIndex);
						CreatePinToParameterLinkEAnnotation linkCommand = new CreatePinToParameterLinkEAnnotation(EditorUtils.getTransactionalEditingDomain(), link);
						if(linkCommand != null) {
							globalCmd.append(linkCommand);
							foundMatchingParam = true;
						}
						createNotification(SYNCHRONIZE_PINS_AND_PARAMETERS, "The pin " + pin.getQualifiedName() + " " + "has been linked to the parameter " + paramWithSameIndex.getQualifiedName(), Type.INFO);
					}
				}
				if(!foundMatchingParam) {
					createNotification(SYNCHRONIZE_PINS_AND_PARAMETERS, "The pin " + pin.getQualifiedName() + " will be deleted, along with its edges", Type.WARNING);
				}
			}
		}
	}

	/**
	 * Checks whether a pin lacks the Pin-to-Parameter link
	 */
	private static boolean lacksPinToParameterLink(Pin pin) {
		return pin.getEAnnotation(IPinToParameterLinkCommand.PIN_TO_PARAMETER_LINK) == null;
	}

	/**
	 * @param callAction
	 * @return the parameters from the behavior or the operation of the call action.
	 */
	private static List<Parameter> getParametersFromCallAction(CallAction callAction) {
		List<Parameter> result = Lists.newArrayList();
		if(callAction instanceof CallBehaviorAction) {
			Behavior behavior = ((CallBehaviorAction)callAction).getBehavior();
			if(behavior != null) {
				result = behavior.getOwnedParameters();
			}
		} else if(callAction instanceof CallOperationAction) {
			Operation operation = ((CallOperationAction)callAction).getOperation();
			if(operation != null) {
				result = operation.getOwnedParameters();
			}
		}
		return result;
	}

	/**
	 * @param callAction
	 * @return the properties from the signal of the Invocation action (if any)
	 */
	private static Map<Integer, TypedElement> getPropertyFromInvocationAction(InvocationAction invocationAction) {
		Map<Integer, TypedElement> result = Maps.newHashMap();
		if(invocationAction instanceof SendSignalAction) {
			Signal signal = ((SendSignalAction)invocationAction).getSignal();
			if(signal != null) {
				EList<Property> properties = signal.getOwnedAttributes();
				for(int index = 0; index < properties.size(); index++) {
					result.put(index, properties.get(index));
				}
			}
		} else if(invocationAction instanceof BroadcastSignalAction) {
			Signal signal = ((BroadcastSignalAction)invocationAction).getSignal();
			if(signal != null) {
				EList<Property> properties = signal.getOwnedAttributes();
				for(int index = 0; index < properties.size(); index++) {
					result.put(index, properties.get(index));
				}
			}
		}
		return result;
	}

	/**
	 * Refining for the syncCallAction method.
	 */
	private static void syncCallActionWhenOutdated(InvocationAction invocationAction) {
		//Command to reset all pins
		CompoundCommand cmd = null;
		if(invocationAction instanceof CallAction) {
			cmd = PinAndParameterSynchronizer.getResetPinsCmd(invocationAction);
		} else if(invocationAction instanceof SendSignalAction) {
			cmd = PinAndParameterSynchronizer.getResetPinsCmd(invocationAction);
		} else if(invocationAction instanceof BroadcastSignalAction) {
			cmd = PinAndParameterSynchronizer.getResetPinsCmd(invocationAction);
		}
		Element behaviorStructural = null;
		if(invocationAction instanceof CallBehaviorAction) {
			behaviorStructural = ((CallBehaviorAction)invocationAction).getBehavior();
		} else if(invocationAction instanceof CallOperationAction) {
			behaviorStructural = ((CallOperationAction)invocationAction).getOperation();
		} else if(invocationAction instanceof SendSignalAction) {
			behaviorStructural = ((SendSignalAction)invocationAction).getSignal();
		} else if(invocationAction instanceof BroadcastSignalAction) {
			behaviorStructural = ((BroadcastSignalAction)invocationAction).getSignal();
		}
		XMIResource xmiResource = PinAndParameterSynchronizer.getXMIResource(behaviorStructural);
		if(!cmd.isEmpty() && cmd.canExecute()) {
			//calculate incoming and outcoming edge
			Iterable<ActivityEdge> outgoing = Collections.emptyList();
			Iterable<ActivityEdge> incoming = Collections.emptyList();
			if(invocationAction instanceof CallAction) {
				for(Pin p : ((CallAction)invocationAction).getResults()) {
					if(!isUpToDate(p, xmiResource)) {
						outgoing = Iterables.concat(outgoing, p.getOutgoings());
					}
				}
			}
			for(Pin p : invocationAction.getArguments()) {
				if(!isUpToDate(p, xmiResource)) {
					incoming = Iterables.concat(incoming, p.getIncomings());
				}
			}
			HashSet<ActivityEdge> newHashSet = Sets.newHashSet(Iterables.concat(outgoing, incoming));
			//Notifify User that Edge will deleted
			DeleteActivityEdgeDialog dialog = new DeleteActivityEdgeDialog(new Shell(), newHashSet, invocationAction);
			if(dialog.open() == MessageDialog.OK) {
				IFile target = invocationAction.eResource() != null ? WorkspaceSynchronizer.getFile(invocationAction.eResource()) : null;
				for(ActivityEdge activityEdge : dialog.getEgdesToDelete()) {
					//Create a marker for all deleted edges
					if(!newHashSet.isEmpty()) {
						UMLItemProviderAdapterFactory umlAdapterFactory = new UMLItemProviderAdapterFactory();
						IItemLabelProvider edgeLabelProvider = (IItemLabelProvider)umlAdapterFactory.adapt(activityEdge, IItemLabelProvider.class);
						IItemLabelProvider callActionLabelProvider = (IItemLabelProvider)umlAdapterFactory.adapt(invocationAction, IItemLabelProvider.class);
						UMLMarkerNavigationProvider.addMarker(target, activityEdge.eResource().getURIFragment(activityEdge), EMFCoreUtil.getQualifiedName(invocationAction, true), "The edge " + edgeLabelProvider.getText(activityEdge) + " has been deleted since " + callActionLabelProvider.getText(invocationAction) + " has been synchronized", IStatus.WARNING);
					}
					//Destroy all edge
					EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(activityEdge);
					if(editingDomain instanceof TransactionalEditingDomain) {
						DestroyElementCommand detryCmd = new DestroyElementPapyrusCommand(new DestroyElementRequest(activityEdge, false));
						if(detryCmd != null && detryCmd.canExecute()) {
							((TransactionalEditingDomain)editingDomain).getCommandStack().execute(new GMFtoEMFCommandWrapper(detryCmd));
						}
					}
				}
				//Reset all pin
				executeCommand(cmd, invocationAction);
				createNotification(SYNCHRONIZE_PINS_AND_PARAMETERS, "The call action " + invocationAction.getQualifiedName() + " has been synchronized", Type.INFO);
			}
		}
	}

	public static void createNotification(String title, String text, Type type) {
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(PapyrusNotificationView.ID);
		} catch (PartInitException e) {
		}
		new NotificationBuilder().setAsynchronous(true).setTemporary(false).setTitle(title).setMessage(text).setType(type).run();
	}

	/**
	 * Calculate if the call action needs to be synchronized
	 * 
	 * @param invocationAction
	 * @return
	 */
	private static boolean isUpToDate(InvocationAction invocationAction) {
		ArrayList<TypedElement> typedElementArgument = null;
		ArrayList<InputPin> invocationActionArguments = Lists.newArrayList(invocationAction.getArguments());
		ArrayList<OutputPin> callActionResult = Lists.newArrayList();
		if(invocationAction instanceof CallAction) {
			callActionResult.addAll(((CallAction)invocationAction).getResults());
		}
		XMIResource xmiResource = null;
		if(invocationAction instanceof CallOperationAction) {
			CallOperationAction callOperationAction = (CallOperationAction)invocationAction;
			Operation operation = callOperationAction.getOperation();
			if(operation != null) {
				xmiResource = PinAndParameterSynchronizer.getXMIResource(operation);
				typedElementArgument = Lists.newArrayList(transformeToTypedElementIterable(callOperationAction.getOperation().getOwnedParameters()));
			}
		} else if(invocationAction instanceof CallBehaviorAction) {
			CallBehaviorAction callBehaviorAction = (CallBehaviorAction)invocationAction;
			Behavior behavior = callBehaviorAction.getBehavior();
			if(behavior != null) {
				xmiResource = PinAndParameterSynchronizer.getXMIResource(behavior);
				typedElementArgument = Lists.newArrayList(transformeToTypedElementIterable(behavior.getOwnedParameters()));
			}
		} else if(invocationAction instanceof SendSignalAction) {
			Signal signal = ((SendSignalAction)invocationAction).getSignal();
			if(signal != null) {
				xmiResource = PinAndParameterSynchronizer.getXMIResource(signal);
				typedElementArgument = Lists.newArrayList(transformeToTypedElementIterable(signal.getOwnedAttributes()));
			}
		} else if(invocationAction instanceof BroadcastSignalAction) {
			Signal signal = ((BroadcastSignalAction)invocationAction).getSignal();
			if(signal != null) {
				xmiResource = PinAndParameterSynchronizer.getXMIResource(signal);
				typedElementArgument = Lists.newArrayList(transformeToTypedElementIterable(signal.getOwnedAttributes()));
			}
		}
		if(typedElementArgument == null) {
			return true;
		}
		//checking if each pin is up to date.
		final Set<TypedElement> typedElementArgumentFound = new HashSet<TypedElement>();
		for(InputPin p : invocationActionArguments) {
			if(!isUpToDate(p, xmiResource)) {
				return false;
			} else {
				TypedElement pa = PinAndParameterSynchronizer.getLinkedParemeter(p, xmiResource);
				typedElementArgumentFound.add(pa);
			}
		}
		for(OutputPin p : callActionResult) {
			if(!isUpToDate(p, xmiResource)) {
				return false;
			} else {
				TypedElement pa = PinAndParameterSynchronizer.getLinkedParemeter(p, xmiResource);
				typedElementArgumentFound.add(pa);
			}
		}
		// Checking whether new pins should be created (meaning some parameters do not have matching pins)
		Iterable<TypedElement> intersectionBetweenPinParamsAndAllParams = Iterables.filter(typedElementArgument, new Predicate<TypedElement>() {

			public boolean apply(TypedElement input) {
				return !typedElementArgumentFound.contains(input);
			}
		});
		return Iterables.size(intersectionBetweenPinParamsAndAllParams) == 0;
	}

	/**
	 * Transform a eObject to typed elements
	 * 
	 * @param input
	 * @return
	 */
	private static Iterable<TypedElement> transformeToTypedElementIterable(Iterable<? extends EObject> input) {
		Iterable<TypedElement> typedElements = Iterables.transform(input, new Function<EObject, TypedElement>() {

			public TypedElement apply(EObject from) {
				if(from instanceof TypedElement) {
					return (TypedElement)from;
				}
				return null;
			}
		});
		return Iterables.filter(typedElements, Predicates.notNull());
	}

	/**
	 * Refining of the isUpToDate method (checks whether the pin has the same
	 * type & direction than its associated parameter.
	 */
	public static boolean isUpToDate(Pin pin, XMIResource xmiResource) {
		boolean result = false;
		TypedElement typedElement = PinAndParameterSynchronizer.getLinkedParemeter(pin, xmiResource);
		if(typedElement != null) {
			if(pin.getType() != null) {
				result = pin.getType().isCompatibleWith(typedElement.getType());
			} else {
				result = (pin.getType() == typedElement.getType());
			}
			if(typedElement instanceof Parameter) {
				Parameter pa = (Parameter)typedElement;
				if(pin instanceof OutputPin) {
					boolean directionIsOut;
					directionIsOut = (pa.getDirection().getValue() == ParameterDirectionKind.OUT);
					directionIsOut |= (pa.getDirection().getValue() == ParameterDirectionKind.INOUT);
					directionIsOut |= (pa.getDirection().getValue() == ParameterDirectionKind.RETURN);
					result &= directionIsOut;
				} else if(pin instanceof InputPin) {
					boolean directionIsIn;
					directionIsIn = (pa.getDirection().getValue() == ParameterDirectionKind.IN);
					directionIsIn |= (pa.getDirection().getValue() == ParameterDirectionKind.INOUT);
					result &= directionIsIn;
				}
			}
		}
		return result;
	}

	/**
	 * Test if the action can be reached (return false if the CallAction is in a controled package which is not loaded).
	 * 
	 * @param callAction
	 * @return
	 */
	public static boolean isAccessible(InvocationAction callAction) {
		boolean result = false;
		EObject targetedBehavior = null;
		if(callAction instanceof CallBehaviorAction) {
			CallBehaviorAction cba = (CallBehaviorAction)callAction;
			targetedBehavior = cba.getBehavior();
		} else if(callAction instanceof CallOperationAction) {
			targetedBehavior = ((CallOperationAction)callAction).getOperation();
		} else if(callAction instanceof SendSignalAction) {
			targetedBehavior = ((SendSignalAction)callAction).getSignal();
		} else if(callAction instanceof BroadcastSignalAction) {
			targetedBehavior = ((BroadcastSignalAction)callAction).getSignal();
		}
		if(targetedBehavior != null) {
			result = !targetedBehavior.eIsProxy();
		}
		return result;
	}

	/**
	 * Executes the supplied command inside an <code>unchecked action</code>
	 * 
	 * @param cmd
	 *        command that can be executed (i.e., cmd.canExecute() == true)
	 */
	protected static void executeCommand(final org.eclipse.emf.common.command.Command cmd, EObject eObject) {
		if(cmd != null && cmd.canExecute()) {
			Map<String, Boolean> options = null;
			options = Collections.singletonMap(Transaction.OPTION_NO_VALIDATION, Boolean.TRUE);
			EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
			if(editingDomain instanceof TransactionalEditingDomain) {
				TransactionalEditingDomain d = (TransactionalEditingDomain)editingDomain;
				try {
					if(d.getCommandStack() instanceof TransactionalCommandStack) {
						TransactionalCommandStack comStack = (TransactionalCommandStack)d.getCommandStack();
						comStack.execute(cmd, options);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (RollbackException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @return a list of selected objects view
	 */
	protected static List<IGraphicalEditPart> getIGraphicalPartSelection() {
		List<IGraphicalEditPart> viewSelected = new ArrayList<IGraphicalEditPart>();
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		if(false == selection instanceof IStructuredSelection) {
			return Collections.emptyList();
		}
		for(Object object : ((IStructuredSelection)selection).toList()) {
			if(false == object instanceof IGraphicalEditPart) {
				continue;
			}
			if(object instanceof DiagramEditPart) {
				continue;
			}
			viewSelected.add((IGraphicalEditPart)object);
		}
		return viewSelected;
	}

	/**
	 * Dialog to display to the user that egdes will be deleted
	 * 
	 * @author arthur daussy
	 * 
	 */
	public static class DeleteActivityEdgeDialog extends MessageDialog {

		/**
		 * All incoming out coming edges
		 */
		private Iterable<ActivityEdge> egdes;

		/***
		 * {@link CallAction} to sync
		 */
		private InvocationAction callAction;

		public DeleteActivityEdgeDialog(Shell parentShell, Iterable<ActivityEdge> egdes, InvocationAction callAction) {
			super(parentShell, SYNCHRONIZE_PINS_AND_PARAMETERS, getIcon(), "", WARNING, new String[]{ "Synchronize", "Cancel" }, 0);////$NON-NLS-1$////$NON-NLS-2$
			this.egdes = egdes;
			this.callAction = callAction;
			this.message = getEdgeListString();
		}

		private String getEdgeListString() {
			UMLItemProviderAdapterFactory t = new UMLItemProviderAdapterFactory();
			IItemLabelProvider provider = (IItemLabelProvider)t.adapt(callAction, IItemLabelProvider.class);
			StringBuilder builder = new StringBuilder("If you synchronize " + provider.getText(callAction) + " the following edges will be deleted : \n ");////$NON-NLS-1$
			for(ActivityEdge e : egdes) {
				provider = (IItemLabelProvider)t.adapt(e, IItemLabelProvider.class);
				builder.append(provider.getText(e)).append(" \n");
			}
			return builder.toString();
		}

		@Override
		public int open() {
			//If no edge to delete nothing to do
			if(egdes.iterator().hasNext()) {
				return super.open();
			}
			return 0;
		}

		public Iterable<ActivityEdge> getEgdesToDelete() {
			return egdes;
		}
	}
}
