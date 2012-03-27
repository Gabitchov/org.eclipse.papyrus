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
package org.eclipse.papyrus.diagram.activity.handlers;

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
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.commands.wrappers.EMFtoGEFCommandWrapper;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.diagram.activity.commands.CreatePinToParameterLinkEAnnotation;
import org.eclipse.papyrus.diagram.activity.helper.IPinToParameterLinkCommand;
import org.eclipse.papyrus.diagram.activity.helper.PinAndParameterSynchronizer;
import org.eclipse.papyrus.diagram.activity.helper.datastructure.LinkPinToParameter;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.activity.providers.UMLMarkerNavigationProvider;
import org.eclipse.papyrus.diagram.common.commands.DestroyElementPapyrusCommand;
import org.eclipse.papyrus.ui.toolbox.notification.Type;
import org.eclipse.papyrus.ui.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.papyrus.ui.toolbox.notification.view.PapyrusNotificationView;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallAction;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Pin;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
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
				if(element instanceof CallAction) {
					CallAction callAction = (CallAction)element;
					syncCallAction(callAction);
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
	public static void syncCallAction(CallAction callAction) {
		if(!isAccessible(callAction)) {
			createNotification(SYNCHRONIZE_PINS_AND_PARAMETERS, "Unable to synchronize pins on " + callAction.getQualifiedName() + " : the ressource is unreachable", Type.WARNING);
			return;
		}

		//Trying to match pins of the callAction with parameters of same index/direction/type.
		//The pins that can not be matched will be destroyed by the "syncCallActionWhenOutdated" method.
		matchPinsAndParams(callAction);

		if(isUpToDate(callAction)) {
			createNotification(SYNCHRONIZE_PINS_AND_PARAMETERS, "The call action " + callAction.getQualifiedName() + " is up to date", Type.INFO);
		} else {
			//Synchronization when a link between pins and params already exists but is outdated.
			syncCallActionWhenOutdated(callAction);
		}
		//Renaming pins according to their associated parameters.
		renamePins(callAction);
	}

	/**
	 * Rename the pins according to their parameters when possible.
	 * 
	 * @param callAction
	 */
	private static void renamePins(final CallAction callAction) {
		//Command used as renaming the pins change the model.
		AbstractTransactionalCommand renamePinsCommand = new AbstractTransactionalCommand(EditorUtils.getTransactionalEditingDomain(), "renaming pins", null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				Iterable<Pin> allPins = Iterables.concat(callAction.getResults(), callAction.getArguments());
				Element behaviorStructural = null;
				if(callAction instanceof CallBehaviorAction) {
					behaviorStructural = ((CallBehaviorAction)callAction).getBehavior();
				} else if(callAction instanceof CallOperationAction) {
					behaviorStructural = ((CallOperationAction)callAction).getOperation();
				}
				XMIResource xmiResource = PinAndParameterSynchronizer.getXMIResource(behaviorStructural);

				for(Pin pin : allPins) {
					Parameter parameter = PinAndParameterSynchronizer.getLinkedParemeter(pin, xmiResource);
					if(parameter != null) {
						String paramName = parameter.getName();
						pin.setName(paramName);
					}
				}

				return CommandResult.newOKCommandResult();
			}
		};
		ICommandProxy renamePinsCommandProxy = new ICommandProxy(renamePinsCommand);
		executeCommand(renamePinsCommandProxy, callAction);
	}

	/**
	 * Method used to match the pins of a call action with parameters of that same call action,
	 * when the pins do not have eAnnotations already linking to parameters. If no match can
	 * be performed, the pin is destroyed along with its edges.
	 * 
	 * @param callAction
	 */
	private static void matchPinsAndParams(CallAction callAction) {
		List<InputPin> inputPins = Lists.newArrayList(callAction.getArguments());
		List<OutputPin> outputPins = Lists.newArrayList(callAction.getResults());

		//The command that is going to be executed.
		CompoundCommand linkingPinsAndParamsCommand = new CompoundCommand();

		List<Parameter> callActionParams = getParametersFromCallAction(callAction);
		Map<Integer, Parameter> inputParameters = new HashMap<Integer, Parameter>();
		Map<Integer, Parameter> outputParameters = new HashMap<Integer, Parameter>();
		//Splitting parameters.
		PinAndParameterSynchronizer.splitParameters(callActionParams, Collections.<Parameter> emptyList(), inputParameters, outputParameters);

		//Matching pins and parameters.
		matchPinsAndParams(inputPins, inputParameters, linkingPinsAndParamsCommand);
		matchPinsAndParams(outputPins, outputParameters, linkingPinsAndParamsCommand);

		//Execution of the command
		executeCommand(new EMFtoGEFCommandWrapper(linkingPinsAndParamsCommand), callAction);
	}

	/**
	 * Refinement for the matchPinsAndParams(CallAction) method.
	 * 
	 * @param pins
	 *        : the list of all input (xor output) pins. The list will be filtered
	 *        to try to just perform a matching on pins that do not have eAnnotations linking
	 *        to parameters.
	 * @param parameters
	 *        : parameters with the same direction as the pins.
	 * @param globalCmd
	 *        : the command used to create the eAnnotations.
	 */
	private static void matchPinsAndParams(List<? extends Pin> pins, Map<Integer, Parameter> parameters, CompoundCommand globalCmd) {
		for(int pinIndex = 0; pinIndex < pins.size(); pinIndex++) {
			Pin pin = pins.get(pinIndex);
			//The matching is performed only on pins that do not have a pin-to-parameter link.
			if(lacksPinToParameterLink(pin)) {
				Parameter paramWithSameIndex = parameters.get(pinIndex);
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
		List<Parameter> result = null;
		if(callAction instanceof CallBehaviorAction) {
			result = ((CallBehaviorAction)callAction).getBehavior().getOwnedParameters();

		} else if(callAction instanceof CallOperationAction) {
			result = ((CallOperationAction)callAction).getOperation().getOwnedParameters();
		}
		return result;
	}

	/**
	 * Refining for the syncCallAction method.
	 */
	private static void syncCallActionWhenOutdated(CallAction callAction) {
		//Command to reset all pins
		final CompoundCommand cmd = PinAndParameterSynchronizer.getResetPinsCmd(callAction);

		Element behaviorStructural = null;
		if(callAction instanceof CallBehaviorAction) {
			behaviorStructural = ((CallBehaviorAction)callAction).getBehavior();
		} else if(callAction instanceof CallOperationAction) {
			behaviorStructural = ((CallOperationAction)callAction).getOperation();
		}
		XMIResource xmiResource = PinAndParameterSynchronizer.getXMIResource(behaviorStructural);

		if(!cmd.isEmpty() && cmd.canExecute()) {
			//calculate incoming and outcoming edge
			Iterable<ActivityEdge> outgoing = Collections.emptyList();
			Iterable<ActivityEdge> incoming = Collections.emptyList();
			for(Pin p : callAction.getResults()) {
				if (!isUpToDate(p, xmiResource)){
					outgoing = Iterables.concat(outgoing, p.getOutgoings());
				}
			}
			for(Pin p : callAction.getArguments()) {
				if (!isUpToDate(p, xmiResource)){
					incoming = Iterables.concat(incoming, p.getIncomings());
				}
			}

			HashSet<ActivityEdge> newHashSet = Sets.newHashSet(Iterables.concat(outgoing, incoming));
			//Notifify User that Edge will deleted
			DeleteActivityEdgeDialog dialog = new DeleteActivityEdgeDialog(new Shell(), newHashSet, callAction);
			if(dialog.open() == MessageDialog.OK) {
				IFile target = callAction.eResource() != null ? WorkspaceSynchronizer.getFile(callAction.eResource()) : null;
				for(ActivityEdge activityEdge : dialog.getEgdesToDelete()) {
					//Create a marker for all deleted edges
					if(!newHashSet.isEmpty()) {
						UMLItemProviderAdapterFactory umlAdapterFactory = new UMLItemProviderAdapterFactory();
						IItemLabelProvider edgeLabelProvider = (IItemLabelProvider)umlAdapterFactory.adapt(activityEdge, IItemLabelProvider.class);
						IItemLabelProvider callActionLabelProvider = (IItemLabelProvider)umlAdapterFactory.adapt(callAction, IItemLabelProvider.class);
						UMLMarkerNavigationProvider.addMarker(target, activityEdge.eResource().getURIFragment(activityEdge), EMFCoreUtil.getQualifiedName(callAction, true), "The edge " + edgeLabelProvider.getText(activityEdge) + " has been deleted since " + callActionLabelProvider.getText(callAction) + " has been synchronized", IStatus.WARNING);
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
				executeCommand(new EMFtoGEFCommandWrapper(cmd), callAction);
				createNotification(SYNCHRONIZE_PINS_AND_PARAMETERS, "The call action " + callAction.getQualifiedName() + " has been synchronized", Type.INFO);
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
	 * @param callAction
	 * @return
	 */
	private static boolean isUpToDate(CallAction callAction) {
		ArrayList<Parameter> operationArgument = null;
		ArrayList<InputPin> callActionArgument = Lists.newArrayList(callAction.getArguments());
		ArrayList<OutputPin> callActionResult = Lists.newArrayList(callAction.getResults());
		XMIResource xmiResource = null;
		if(callAction instanceof CallOperationAction) {
			CallOperationAction callOperationAction = (CallOperationAction)callAction;
			Operation operation = callOperationAction.getOperation();
			xmiResource = operation != null ? PinAndParameterSynchronizer.getXMIResource(operation) : null;
			operationArgument = Lists.newArrayList(callOperationAction.getOperation().getOwnedParameters());
		} else if(callAction instanceof CallBehaviorAction) {
			CallBehaviorAction callBehaviorAction = (CallBehaviorAction)callAction;
			Behavior behavior = callBehaviorAction.getBehavior();
			xmiResource = behavior != null ? PinAndParameterSynchronizer.getXMIResource(behavior) : null;
			operationArgument = Lists.newArrayList(callBehaviorAction.getBehavior().getOwnedParameters());
		}
		if(operationArgument == null) {
			return true;
		}

		//checking if each pin is up to date.
		final Set<Parameter> operationArgumentFound = new HashSet<Parameter>();
		for(InputPin p : callActionArgument) {
			if(!isUpToDate(p, xmiResource)) {
				return false;
			} else {
				Parameter pa = PinAndParameterSynchronizer.getLinkedParemeter(p, xmiResource);
				operationArgumentFound.add(pa);
			}
		}
		for(OutputPin p : callActionResult) {
			if(!isUpToDate(p, xmiResource)) {
				return false;
			} else {
				Parameter pa = PinAndParameterSynchronizer.getLinkedParemeter(p, xmiResource);
				operationArgumentFound.add(pa);
			}
		}

		// Checking whether new pins should be created (meaning some parameters do not have matching pins)
		Iterable<Parameter> intersectionBetweenPinParamsAndAllParams = Iterables.filter(operationArgument, new Predicate<Parameter>() {

			public boolean apply(Parameter input) {
				return !operationArgumentFound.contains(input);
			}
		});
		return Iterables.size(intersectionBetweenPinParamsAndAllParams) == 0;
	}

	/**
	 * Refining of the isUpToDate method (checks whether the pin has the same
	 * type & direction than its associated parameter.
	 */
	public static boolean isUpToDate(Pin pin, XMIResource xmiResource) {
		boolean result = false;
		Parameter pa = PinAndParameterSynchronizer.getLinkedParemeter(pin, xmiResource);
		if(pa != null) {
			if(pin.getType() != null) {
				result = pin.getType().isCompatibleWith(pa.getType());
			} else {
				result = (pin.getType() == pa.getType());
			}
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
		return result;
	}


	/**
	 * Test if the action can be reached (return false if the CallAction is in a controled package which is not loaded).
	 * 
	 * @param callAction
	 * @return
	 */
	public static boolean isAccessible(CallAction callAction) {
		boolean result = false;
		EObject targetedBehavior = null;
		if(callAction instanceof CallBehaviorAction) {
			CallBehaviorAction cba = (CallBehaviorAction)callAction;
			targetedBehavior = cba.getBehavior();
		} else if(callAction instanceof CallOperationAction) {
			targetedBehavior = ((CallOperationAction)callAction).getOperation();
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
	protected static void executeCommand(final Command cmd, EObject eObject) {
		Map<String, Boolean> options = null;
		options = Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
		if(editingDomain instanceof TransactionalEditingDomain) {
			AbstractEMFOperation operation = new AbstractEMFOperation(((TransactionalEditingDomain)editingDomain), StringStatics.BLANK, options) {

				protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					cmd.execute();
					return Status.OK_STATUS;
				}
			};
			try {
				operation.execute(new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				Log.warning(UMLDiagramEditorPlugin.getInstance(), AbstractSynchronizePinsAndParameters.IGNORED_EXCEPTION_WARNING, "executeCommand", e); //$NON-NLS-1$
			}
		}
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
		private CallAction callAction;

		public DeleteActivityEdgeDialog(Shell parentShell, Iterable<ActivityEdge> egdes, CallAction callAction) {
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
