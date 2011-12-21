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
package org.eclipse.papyrus.diagram.activity.edit.policies;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.EMFtoGEFCommandWrapper;
import org.eclipse.papyrus.diagram.activity.edit.part.interfaces.InterruptibleEdge;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.activity.request.InterruptibleEdgeRequest;
import org.eclipse.papyrus.diagram.common.groups.request.EdgeGroupFrameworkRequest;
import org.eclipse.papyrus.diagram.common.groups.request.EdgeGroupFrameworkRequest.EdgeType;
import org.eclipse.papyrus.diagram.common.groups.request.GroupFrameworkRequest;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.UMLPackage;

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

	@Override
	public Command getCommand(Request request) {
		if(InterruptibleEdgeRequest.SET_INTERRUPTIBLE_EDGE.equals(request.getType())) {
			//Set interruptible edge icon
			return createInterruptibleEdgeIcon();
		} else if(InterruptibleEdgeRequest.UNSET_INTERRUPTIBLE_EDGE.equals(request.getType())) {
			//Unset interruptible edge icon
			return destroyInterruptibleIcon();
		} else if(GroupFrameworkRequest.EDGE_GROUP_REQUEST.equals(request.getType())) {
			//Handle group modification
			if(getInterruptibleEdgeIcon().getInterrutibleEgdeIcon() != null) {
				EdgeGroupFrameworkRequest edgeRequest = (EdgeGroupFrameworkRequest)request;
				boolean isNotValideSource = EdgeType.SOURCE.equals(edgeRequest.getEdgeType()) && !validateSource(edgeRequest);
				boolean isNotValideTarget = EdgeType.TARGET.equals(edgeRequest.getEdgeType()) && !validateTarget(edgeRequest);
				if(isNotValideSource || isNotValideTarget) {
					return new EMFtoGEFCommandWrapper(new SetCommand(getEditingDomain(), getActivtyEdge(), UMLPackage.Literals.ACTIVITY_EDGE__INTERRUPTS, null));
				}
			}
		}
		return super.getCommand(request);
	}

	/**
	 * Validate part constraint :
	 * "Interrupting edges of a region must have their source node in the region and their target node outside the region in the
	 * same activity containing the region" from UML SuperStructure
	 */
	protected boolean validateTarget(EdgeGroupFrameworkRequest edgeRequest) {
		ActivityEdge activityEdge = getActivtyEdge();
		if(activityEdge != null) {
			InterruptibleActivityRegion interupt = activityEdge.getInterrupts();
			if(interupt != null) {
				return !activityEdge.getTarget().getInInterruptibleRegions().contains(interupt);
			}
		}
		return false;
	}
	/**
	 * Validate part constraint :
	 * "Interrupting edges of a region must have their source node in the region and their target node outside the region in the
	 * same activity containing the region" from UML SuperStructure
	 */
	protected boolean validateSource(EdgeGroupFrameworkRequest request) {
		ActivityEdge activityEdge = getActivtyEdge();
		if(activityEdge != null) {
			InterruptibleActivityRegion interupt = activityEdge.getInterrupts();
			if(interupt != null) {
				return activityEdge.getSource().getInInterruptibleRegions().contains(interupt);
			}
		}
		return false;
	}

	/**
	 * Create the command to withdraw interruptible edge icon from the activity edge
	 * 
	 * @return
	 */
	private Command destroyInterruptibleIcon() {
		TransactionalEditingDomain editingDomain = getEditingDomain();
		if(editingDomain != null) {
			AbstractTransactionalCommand cmd = new AbstractTransactionalCommand(editingDomain, "Destroy Interruptible Edge Icon", null) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					Object model = getHost().getModel();
					if(model instanceof View) {
						View interruptibleEdgeIconView = ViewUtil.getChildBySemanticHint((View)model, UMLVisualIDRegistry.getType(getInterruptibleEdgeIconID()));
						ViewUtil.destroy(interruptibleEdgeIconView);
						return CommandResult.newOKCommandResult();
					}
					return null;
				}
			};
			return new ICommandProxy(cmd);
		}
		return null;
	}

	/**
	 * Create the Interruptible Edge Icon View
	 * 
	 * @return Command to be executed or {@link UnexecutableCommand#INSTANCE} if unable to create
	 */
	private Command createInterruptibleEdgeIcon() {
		TransactionalEditingDomain editingDomain = getEditingDomain();
		if(editingDomain != null) {
			AbstractTransactionalCommand cmd = new AbstractTransactionalCommand(editingDomain, "Create Interruptible Edge Icon", null) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					Object model = getHost().getModel();
					if(model instanceof View) {
						if(getInterruptibleEdgeIcon().getInterrutibleEgdeIcon() == null) {
							Node node = ViewService.createNode((View)model, UMLVisualIDRegistry.getType(getInterruptibleEdgeIconID()), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
							if(node != null) {
								return CommandResult.newOKCommandResult(node);
							} else {
								return CommandResult.newErrorCommandResult("Unable to create the view for Interruptible Edge label");
							}
						}
					}
					return null;
				}
			};
			return new ICommandProxy(cmd);
		}
		return null;
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

	@Override
	public boolean understandsRequest(Request req) {
		return req instanceof InterruptibleEdgeRequest || req instanceof GroupFrameworkRequest;
	}
}
