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
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.handlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
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
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.commands.wrappers.EMFtoGEFCommandWrapper;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.diagram.activity.helper.PinAndParameterSynchronizer;
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
import org.eclipse.uml2.uml.CallAction;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Parameter;
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
	 * Synchronized Call Action
	 * 
	 * @param callAction
	 */
	public static void syncCallAction(CallAction callAction) {
		if(!isAccessible(callAction)) {
			createNotification(SYNCHRONIZE_PINS_AND_PARAMETERS, "Unable to synchronize pins on " + callAction.getQualifiedName() + " : the ressource is unreachable", Type.WARNING);
			return;
		}
		if(isUpOfDate(callAction)) {
			createNotification(SYNCHRONIZE_PINS_AND_PARAMETERS, "The call action " + callAction.getQualifiedName() + " is up to date", Type.INFO);
			return;
		}
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
				Parameter pa = PinAndParameterSynchronizer.getLinkedParemeter(p, xmiResource);
				if(pa == null) {
					outgoing = Iterables.concat(outgoing, p.getOutgoings());
				}
			}
			for(Pin p : callAction.getArguments()) {
				Parameter pa = PinAndParameterSynchronizer.getLinkedParemeter(p, xmiResource);
				if(pa == null) {
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
						UMLMarkerNavigationProvider.addMarker(target, activityEdge.eResource().getURIFragment(activityEdge), EMFCoreUtil.getQualifiedName(callAction, true), "The edge " + edgeLabelProvider.getText(activityEdge) + " has been delete since " + callActionLabelProvider.getText(callAction) + " has been synchronized", IStatus.WARNING);
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
	private static boolean isUpOfDate(CallAction callAction) {
		ArrayList<Parameter> operationArgument = null;
		ArrayList<InputPin> callActionArgument = Lists.newArrayList(callAction.getArguments());
		ArrayList<OutputPin> callActionResult = Lists.newArrayList(callAction.getResults());
		XMIResource xmiResource = null;
		if(callAction instanceof CallOperationAction) {
			CallOperationAction callOperationAction = (CallOperationAction)callAction;
			xmiResource = PinAndParameterSynchronizer.getXMIResource(callOperationAction);
			operationArgument = Lists.newArrayList(callOperationAction.getOperation().getOwnedParameters());
		} else if(callAction instanceof CallBehaviorAction) {
			CallBehaviorAction callBehaviorAction = (CallBehaviorAction)callAction;
			xmiResource = PinAndParameterSynchronizer.getXMIResource(callBehaviorAction);
			operationArgument = Lists.newArrayList(callBehaviorAction.getBehavior().getOwnedParameters());
		}
		if(operationArgument == null) {
			return true;
		}

		//test arguments elements
		final Set<Parameter> operationArgumentFounded = new HashSet<Parameter>();
		for(InputPin p : callActionArgument) {
			Parameter pa = PinAndParameterSynchronizer.getLinkedParemeter(p, xmiResource);
			if(pa == null) {
				return false;
			}
			operationArgumentFounded.add(pa);
		}
		for(OutputPin p : callActionResult) {
			Parameter pa = PinAndParameterSynchronizer.getLinkedParemeter(p, xmiResource);
			if(pa == null) {
				return false;
			}
			operationArgumentFounded.add(pa);
		}
		//Intersect bot parameter collection
		Iterable<Parameter> intersection = Iterables.filter(operationArgument, new Predicate<Parameter>() {

			public boolean apply(Parameter input) {
				return !operationArgumentFounded.contains(input);
			}
		});
		return Iterables.size(intersection) == 0;

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
