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
 *   Atos - Initial API and implementation
 *   Arthur Daussy Bug 366159 - [ActivityDiagram] Activity Diagram should be able to handle correctly Interruptible Edge
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.policies;

import java.util.Collections;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.common.core.util.Trace;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIDebugOptions;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIPlugin;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIStatusCodes;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.activity.edit.part.interfaces.InterruptibleEdge;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.ActivityEdge;

/**
 * InterruptibleEdgeEditPolicy handle all action relative to interruptible Edge.
 * WARNING : All EditPart where this EditPolicy is installed has to implement {@link InterruptibleEdge}
 * 
 * @author arthur daussy
 * 
 */
public class InterruptibleEdgeEditPolicy extends AbstractEditPolicy {

	/** constant for this edit policy role */
	public static String INTERRUPTIBLE_ICON_POLICY = "interruptibleIconPolicy";

	/**
	 * Validate the consistency of the view of the Interruptible Edge Icon
	 */
	@Override
	public void activate() {
		validateConsistency();
		super.activate();
	}

	/**
	 * Validate the Consistency of the InterruptibleEdgeIcon
	 */
	protected void validateConsistency() {
		try {
			final IGraphicalEditPart graphicalHost = (IGraphicalEditPart)getHost();
			final InterruptibleEdge interruptibleEdge = (InterruptibleEdge)getHost();
			EObject resolveSemanticElement = graphicalHost.resolveSemanticElement();
			ActivityEdge activityEdgeAux;
			if(resolveSemanticElement instanceof ActivityEdge) {
				activityEdgeAux = (ActivityEdge)resolveSemanticElement;
			} else {
				activityEdgeAux = null;
			}
			final ActivityEdge activityEdge = activityEdgeAux;
			final View interruptbleEdgeIcon = getInterruptbleEdgeIcon(graphicalHost, interruptibleEdge);
			//If property == null and there is an view => delete
			if(activityEdge != null) {
				if(activityEdge.getInterrupts() == null && interruptbleEdgeIcon != null) {
					ICommand destroyCommand = new AbstractTransactionalCommand(graphicalHost.getEditingDomain(), "Destroy Interruptible Edge Icon", null) {

						@Override
						protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
							ViewUtil.destroy(interruptbleEdgeIcon);
							return CommandResult.newOKCommandResult();
						}
					};
					executeCommand(new ICommandProxy(destroyCommand));
				}
				//If property is set and no view exist => create a view
				if(activityEdge.getInterrupts() != null && interruptbleEdgeIcon == null) {
					ICommand createCommand = new AbstractTransactionalCommand(graphicalHost.getEditingDomain(), "Create Interruptible Edge Icon", null) {

						@Override
						protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
							Object model = graphicalHost.getModel();
							if(model != null) {
								Node node = ViewService.createNode((View)model, UMLVisualIDRegistry.getType(interruptibleEdge.getInterruptibleEdgeIconVisualID()), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
								if(node != null) {
									return CommandResult.newOKCommandResult(node);
								} else {
									return CommandResult.newErrorCommandResult("Unable to create the view for Interruptible Edge label");
								}
							}
							return null;
						}
					};
					executeCommand(new ICommandProxy(createCommand));
				}
			}
		} catch (ClassCastException e) {
			throw new RuntimeException("The host of InterruptibleEdgeEditPolicy should implement IGraphicalEditPart and InterruptibleEdge which refer to an ActivityEdge");////$NON-NLS-0$
		}
	}

	/**
	 * Retreive the view corresponding to interruptible edge icon
	 */
	private View getInterruptbleEdgeIcon(IGraphicalEditPart graphicalHost, InterruptibleEdge interruptibleEdge) {
		View view = graphicalHost.getNotationView();
		if(view != null) {
			return ViewUtil.getChildBySemanticHint(view, String.valueOf(interruptibleEdge.getInterruptibleEdgeIconVisualID()));
		}
		return null;
	}

	/**
	 * Executes the supplied command inside an <code>unchecked action</code> COPIED FROM CANONICAL EDIT POLICY
	 * 
	 * @param cmd
	 *        command that can be executed (i.e., cmd.canExecute() == true)
	 */
	protected void executeCommand(final Command cmd) {
		Map<String, Boolean> options = null;
		EditPart ep = getHost();
		boolean isActivating = true;
		// use the viewer to determine if we are still initializing the diagram
		// do not use the DiagramEditPart.isActivating since ConnectionEditPart's
		// parent will not be a diagram edit part
		EditPartViewer viewer = ep.getViewer();
		if(viewer instanceof DiagramGraphicalViewer) {
			isActivating = ((DiagramGraphicalViewer)viewer).isInitializing();
		}
		if(isActivating || !EditPartUtil.isWriteTransactionInProgress((IGraphicalEditPart)getHost(), false, false))
			options = Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);
		AbstractEMFOperation operation = new AbstractEMFOperation(((IGraphicalEditPart)getHost()).getEditingDomain(), StringStatics.BLANK, options) {

			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				cmd.execute();
				return Status.OK_STATUS;
			}
		};
		try {
			operation.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			Trace.catching(DiagramUIPlugin.getInstance(), DiagramUIDebugOptions.EXCEPTIONS_CATCHING, getClass(), "executeCommand", e); //$NON-NLS-1$
			Log.warning(DiagramUIPlugin.getInstance(), DiagramUIStatusCodes.IGNORED_EXCEPTION_WARNING, "executeCommand", e); //$NON-NLS-1$
		}
	}

	@Override
	public EditPart getTargetEditPart(Request request) {
		return getHost();
	}

	/**
	 * Get the type of the node to create
	 * 
	 * @return
	 */
	protected int getInterruptibleEdgeIconID() {
		return getInterruptibleEdgeIcon().getInterruptibleEdgeIconVisualID();
	}

	/**
	 * Get the interruptible Edge
	 */
	protected InterruptibleEdge getInterruptibleEdgeIcon() {
		return ((InterruptibleEdge)getHost());
	}

	/**
	 * Get the Actvity Edge
	 */
	protected ActivityEdge getActivtyEdge() {
		EObject eObject = ((IGraphicalEditPart)getHost()).resolveSemanticElement();
		if(eObject instanceof ActivityEdge) {
			return (ActivityEdge)eObject;
		}
		return null;
	}

	/**
	 * Get the {@link TransactionalEditingDomain}
	 * 
	 * @return
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		EditPart getHost = getHost();
		if(getHost instanceof GraphicalEditPart) {
			GraphicalEditPart host = (GraphicalEditPart)getHost;
			return host.getEditingDomain();
		}
		Object view = getHost.getModel();
		if(view instanceof EObject) {
			EditingDomain editinDomain = AdapterFactoryEditingDomain.getEditingDomainFor((EObject)view);
			if(editinDomain instanceof TransactionalEditingDomain) {
				return (TransactionalEditingDomain)editinDomain;
			}
		}
		return null;
	}
}
