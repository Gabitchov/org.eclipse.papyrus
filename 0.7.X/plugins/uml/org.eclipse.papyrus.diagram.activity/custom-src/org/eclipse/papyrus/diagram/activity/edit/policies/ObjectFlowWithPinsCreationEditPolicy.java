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
package org.eclipse.papyrus.diagram.activity.edit.policies;

import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionEndsCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ObjectFlow;

public class ObjectFlowWithPinsCreationEditPolicy extends GraphicalNodeEditPolicy {

	/**
	 * Returns a command that will initialize connection creation.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy#getConnectionCreateCommand(org.eclipse.gef.requests.CreateConnectionRequest)
	 * @param request
	 *        the request for creating the connection
	 * @return the command
	 */
	@Override
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		if(!(request instanceof CreateConnectionViewRequest))
			return null;
		CreateConnectionViewRequest req = (CreateConnectionViewRequest)request;
		CompositeCommand cc = new CompositeCommand(DiagramUIMessages.Commands_CreateCommand_Connection_Label);
		Diagram diagramView = ((View)getHost().getModel()).getDiagram();
		TransactionalEditingDomain editingDomain = getEditingDomain();
		CreateCommand createCommand = new CreateCommand(editingDomain, req.getConnectionViewDescriptor(), diagramView.getDiagram());
		setViewAdapter((IAdaptable)createCommand.getCommandResult().getReturnValue());

		SetConnectionEndsCommand sceCommand = new SetConnectionEndsCommand(editingDomain, StringStatics.BLANK);
		sceCommand.setEdgeAdaptor(getViewAdapter());
		if(getObjectFlowHint().equals(req.getConnectionViewDescriptor().getSemanticHint())) {
			// handle redirection of Object flow on created child pin
			sceCommand.setNewSourceAdaptor(getObjectFlowSourceViewAdapter(request));
		} else {
			sceCommand.setNewSourceAdaptor(new EObjectAdapter(getView()));
		}
		ConnectionAnchor sourceAnchor = getConnectableEditPart().getSourceConnectionAnchor(request);
		SetConnectionAnchorsCommand scaCommand = new SetConnectionAnchorsCommand(editingDomain, StringStatics.BLANK);
		scaCommand.setEdgeAdaptor(getViewAdapter());
		scaCommand.setNewSourceTerminal(getConnectableEditPart().mapConnectionAnchorToTerminal(sourceAnchor));
		SetConnectionBendpointsCommand sbbCommand = new SetConnectionBendpointsCommand(editingDomain);
		sbbCommand.setEdgeAdapter(getViewAdapter());
		cc.compose(createCommand);
		cc.compose(sceCommand);
		cc.compose(scaCommand);
		cc.compose(sbbCommand);
		Command c = new ICommandProxy(cc);
		request.setStartCommand(c);
		return c;
	}

	/**
	 * Get the semantic hint for an object flow edge
	 * 
	 * @return semantic hint
	 */
	private static String getObjectFlowHint() {
		IHintedType objectFlowType = (IHintedType)UMLElementTypes.ObjectFlow_4003;
		return objectFlowType.getSemanticHint();
	}

	/**
	 * Returns a command that will create the connection.
	 * 
	 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCompleteCommand(org.eclipse.gef.requests.CreateConnectionRequest)
	 * @param request
	 *        the request for creating the connection
	 * @return the command
	 */
	protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
		ICommandProxy proxy = (ICommandProxy)request.getStartCommand();
		if(proxy == null) {
			return null;
		}

		// reset the target edit-part for the request
		INodeEditPart targetEP = getConnectionCompleteEditPart(request);
		if(targetEP == null) {
			return null;
		}

		CompositeCommand cc = (CompositeCommand)proxy.getICommand();
		ConnectionAnchor targetAnchor = targetEP.getTargetConnectionAnchor(request);
		Iterator commandItr = cc.iterator();
		commandItr.next(); //0
		SetConnectionEndsCommand sceCommand = (SetConnectionEndsCommand)commandItr.next(); //1
		if(request instanceof CreateConnectionViewRequest && getObjectFlowHint().equals(((CreateConnectionViewRequest)request).getConnectionViewDescriptor().getSemanticHint())) {
			// handle redirection of Object flow on created child pin
			sceCommand.setNewTargetAdaptor(getObjectFlowTargetViewAdapter(request));
		} else {
			sceCommand.setNewTargetAdaptor(new EObjectAdapter(((IGraphicalEditPart)targetEP).getNotationView()));
		}
		SetConnectionAnchorsCommand scaCommand = (SetConnectionAnchorsCommand)commandItr.next(); //2
		scaCommand.setNewTargetTerminal(targetEP.mapConnectionAnchorToTerminal(targetAnchor));
		setViewAdapter(sceCommand.getEdgeAdaptor());
		INodeEditPart sourceEditPart = (INodeEditPart)request.getSourceEditPart();
		ConnectionAnchor sourceAnchor = sourceEditPart.mapTerminalToConnectionAnchor(scaCommand.getNewSourceTerminal());
		PointList pointList = new PointList();
		if(request.getLocation() == null) {
			pointList.addPoint(sourceAnchor.getLocation(targetAnchor.getReferencePoint()));
			pointList.addPoint(targetAnchor.getLocation(sourceAnchor.getReferencePoint()));
		} else {
			pointList.addPoint(sourceAnchor.getLocation(request.getLocation()));
			pointList.addPoint(targetAnchor.getLocation(request.getLocation()));
		}
		SetConnectionBendpointsCommand sbbCommand = (SetConnectionBendpointsCommand)commandItr.next(); //3
		sbbCommand.setNewPointList(pointList, sourceAnchor.getReferencePoint(), targetAnchor.getReferencePoint());
		return request.getStartCommand();
	}

	/**
	 * Get the adapter to recover the object flow source view
	 * 
	 * @param request
	 *        connection creation request
	 * @return adapter
	 */
	private IAdaptable getObjectFlowSourceViewAdapter(final CreateConnectionRequest request) {
		return new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if(adapter != null && adapter.isAssignableFrom(ShapeImpl.class)) {
					return getObjectFlowExtremityView(true);
				}
				return null;
			}
		};
	}

	/**
	 * Get the adapter to recover the object flow target view
	 * 
	 * @param request
	 *        connection creation request
	 * @return adapter
	 */
	private IAdaptable getObjectFlowTargetViewAdapter(final CreateConnectionRequest request) {
		return new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if(adapter != null && adapter.isAssignableFrom(ShapeImpl.class)) {
					return getObjectFlowExtremityView(false);
				}
				return null;
			}
		};
	}

	/**
	 * Try and get an extremity view of the object flow contained in this host.
	 * 
	 * @param isStartEnd
	 *        true if view is the object flow start end, false for the target end
	 * @return the view or null
	 */
	protected View getObjectFlowExtremityView(boolean isStartEnd) {

		Object objectFlowView = getViewAdapter().getAdapter(Connector.class);
		if(objectFlowView instanceof Connector) {
			EObject objectFlow = ((Connector)objectFlowView).getElement();
			if(objectFlow instanceof ObjectFlow) {
				ActivityNode actNode = null;
				if(isStartEnd) {
					actNode = ((ObjectFlow)objectFlow).getSource();
				} else {
					actNode = ((ObjectFlow)objectFlow).getTarget();
				}
				if(actNode != null) {
					if(getHost().getModel() instanceof View) {
						View view = (View)getHost().getModel();
						if(actNode.equals(view.getElement())) {
							return view;
						}
					}
					// refresh view children which have not been created yet.
					EditPolicy policy = getHost().getEditPolicy(EditPolicyRoles.CANONICAL_ROLE);
					if(policy instanceof CanonicalEditPolicy) {
						CanonicalEditPolicy canonical = (CanonicalEditPolicy)policy;
						if(!canonical.isEnabled()) {
							canonical.setEnable(true);
							canonical.refresh();
							canonical.setEnable(false);
						} else {
							canonical.refresh();
						}
					}
					// recover the appropriate child view
					for(Object childPart : getHost().getChildren()) {
						if(childPart instanceof EditPart) {
							Object containedView = ((EditPart)childPart).getModel();
							if(containedView instanceof View) {
								if(actNode.equals(((View)containedView).getElement())) {
									return (View)containedView;
								}
							}
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * Get the editing domain
	 * 
	 * @return editing domain
	 */
	private TransactionalEditingDomain getEditingDomain() {
		return ((IGraphicalEditPart)getHost()).getEditingDomain();
	}
}
