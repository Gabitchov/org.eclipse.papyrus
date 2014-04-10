/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.custom.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SemanticCreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.component.custom.edit.helpers.MultiDependencyHelper;
import org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes;

/**
 * This class is used to launch command to create associationClass
 * 
 * @author Patrick Tessier
 */
public class CustomGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {
	/** The ID for the additional parameter SOURCE_PARENT used in creation request. */
	public static final String CONNECTOR_CREATE_REQUEST_SOURCE_PARENT = "SOURCE_PARENT"; //$NON-NLS-1$
	/** The ID for the additional parameter TARGET_PARENT used in creation request. */
	public static final String CONNECTOR_CREATE_REQUEST_TARGET_PARENT = "TARGET_PARENT"; //$NON-NLS-1$
	/** The ID for the additional parameter SOURCE_GRAPHICAL used in creation request. */
	public static final String CONNECTOR_CREATE_REQUEST_SOURCE_GRAPHICAL = "SOURCE_GRAPHICAL"; //$NON-NLS-1$
	/** The ID for the additional parameter TARGET_GRAPHICAL used in creation request. */
	public static final String CONNECTOR_CREATE_REQUEST_TARGET_GRAPHICAL = "TARGET_GRAPHICAL"; //$NON-NLS-1$

	/**
	 * <pre>
	 * This method is overridden in order to add information (graphical parent of Port)
	 * in the CreationRelationshipRequest.
	 * 
	 * These information is stored in the request as Parameters under the following keys:
	 * - &quot;SOURCE_PARENT&quot; : UML Element used as Graphical parent of the source Port (end of Connector)
	 * - &quot;TARGET_PARENT&quot; : UML Element used as Graphical parent of the target Port (end of Connector)
	 * - &quot;SOURCE_GRAPHICAL&quot; : GraphicalEditPart of the source
	 * - &quot;TARGET_GRAPHICAL&quot; : GraphicalEditPart of the target
	 * 
	 * This method is used too to call the custom command for InformationFlow creation.
	 * 
	 * @param request the request
	 * @return the connection and relationship complete command
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected Command getConnectionAndRelationshipCompleteCommand(CreateConnectionViewAndElementRequest request) {
		// return super.getConnectionAndRelationshipCompleteCommand(request);
		// get the element descriptor
		CreateElementRequestAdapter requestAdapter = request.getConnectionViewAndElementDescriptor().getCreateElementRequestAdapter();
		// get the semantic request
		CreateRelationshipRequest createElementRequest = (CreateRelationshipRequest) requestAdapter.getAdapter(CreateRelationshipRequest.class);
		createElementRequest.setPrompt(!request.isUISupressed());
		// complete the semantic request by filling in the source and
		// destination
		INodeEditPart targetEP = getConnectionCompleteEditPart(request);
		View sourceView = (View) request.getSourceEditPart().getModel();
		View targetView = (View) targetEP.getModel();
		// resolve the source
		EObject source = ViewUtil.resolveSemanticElement(sourceView);
		if (source == null) {
			source = sourceView;
		}
		// resolve the source parent (meaning graphical parent here)
		View sourceParentView = (View) request.getSourceEditPart().getParent().getModel();
		EObject sourceParent = ViewUtil.resolveSemanticElement(sourceParentView);
		if (sourceParent == null) {
			sourceParent = sourceParentView;
		}
		createElementRequest.setParameter(CONNECTOR_CREATE_REQUEST_SOURCE_PARENT, sourceParent);
		createElementRequest.setParameter(CONNECTOR_CREATE_REQUEST_SOURCE_GRAPHICAL, request.getSourceEditPart());
		createElementRequest.setSource(source);
		// resolve the target
		EObject target = ViewUtil.resolveSemanticElement(targetView);
		if (target == null) {
			target = targetView;
		}
		// resolve the source parent (meaning graphical parent here)
		View targetParentView = (View) request.getTargetEditPart().getParent().getModel();
		EObject targetParent = ViewUtil.resolveSemanticElement(targetParentView);
		if (targetParent == null) {
			targetParent = targetParentView;
		}
		createElementRequest.setParameter(CONNECTOR_CREATE_REQUEST_TARGET_PARENT, targetParent);
		createElementRequest.setParameter(CONNECTOR_CREATE_REQUEST_TARGET_GRAPHICAL, request.getTargetEditPart());
		createElementRequest.setTarget(target);
		Command createElementCommand = null;
		// get the create element request based on the elementdescriptor's
		// request
		createElementCommand = targetEP.getCommand(new EditCommandRequestWrapper((CreateRelationshipRequest) requestAdapter.getAdapter(CreateRelationshipRequest.class), request.getExtendedData()));
		// create the create semantic element wrapper command
		if (null == createElementCommand)
			return null;
		SemanticCreateCommand semanticCommand = new SemanticCreateCommand(requestAdapter, createElementCommand);
		// get the view command
		Command viewCommand = getConnectionCompleteCommand(request);
		if (null == viewCommand)
			return null;
		// form the compound command and return
		CompositeCommand cc = new CompositeCommand(semanticCommand.getLabel());
		cc.compose(semanticCommand);
		cc.compose(new CommandProxy(viewCommand));
		return new ICommandProxy(cc);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public Command getCommand(Request request) {
		// we have to distinguish the case where this is an association class
		if (REQ_CONNECTION_END.equals(request.getType())) {
			if (request instanceof CreateConnectionViewAndElementRequest) {
				// default behavior
				Command c = getConnectionAndRelationshipCompleteCommand((CreateConnectionViewAndElementRequest) request);
				// case of associationClass
				CreateElementRequestAdapter requestAdapter = ((CreateConnectionViewAndElementRequest) request).getConnectionViewAndElementDescriptor().getCreateElementRequestAdapter();
				CreateRelationshipRequest createElementRequest = (CreateRelationshipRequest) requestAdapter.getAdapter(CreateRelationshipRequest.class);
				if (UMLElementTypes.Dependency_4017.equals(createElementRequest.getElementType())) {
					MultiDependencyHelper multiDependencyHelper = new MultiDependencyHelper(getEditingDomain());
					return multiDependencyHelper.getCommand(((CreateConnectionViewAndElementRequest) request), c);
				} else {
					return c;
				}
			} else if (request instanceof CreateUnspecifiedTypeConnectionRequest) {
				return getUnspecifiedConnectionCompleteCommand((CreateUnspecifiedTypeConnectionRequest) request);
			}
		}
		return super.getCommand(request);
	}

	/**
	 * used to obtain the transactional edit domain
	 * 
	 * @return the current transactional edit domain
	 */
	private TransactionalEditingDomain getEditingDomain() {
		return ((IGraphicalEditPart) getHost()).getEditingDomain();
	}
}
