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
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SemanticCreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.diagram.ui.requests.RefreshConnectionsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This creation Edit Policy is to be applied on nodes managing their children automatically. It avoids creation of a graphical children from the
 * palette, since this element should already be created through the model listening.
 * Subclasses of this Edit Policy shall be installed with the key EditPolicyRoles.CREATION_ROLE
 */
public abstract class AutoManagedNodeCreationEditPolicy extends CreationEditPolicy {


	/**
	 * Construct a new creation policy.
	 */
	public AutoManagedNodeCreationEditPolicy() {
		super();
	}

	/**
	 * Called in response to a <tt>REQ_CREATE</tt> request.
	 * 
	 * Creates a compound command and populated with the following commands for
	 * each element to be created (except if element representation is automatically
	 * managed by this part): <BR>
	 * <OL>
	 * <LI>a {@link CreateCommand}for each of the request's view descriptor.
	 * </OL>
	 * 
	 * @param request
	 *        a create request (understands instances of {@link CreateViewRequest}).
	 * @return a command to satify the request; <tt>null</tt> if the request
	 *         is not understood.
	 */
	protected Command getCreateCommand(CreateViewRequest request) {

		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(editingDomain, DiagramUIMessages.AddCommand_Label);

		Iterator<? extends ViewDescriptor> descriptors = request.getViewDescriptors().iterator();

		while(descriptors.hasNext()) {
			ViewDescriptor descriptor = descriptors.next();
			// create the view only if it is not automatically managed from model
			if(!isSemanticHintAutoManaged(descriptor.getSemanticHint())) {
				CreateCommand createCommand = new CreateCommand(editingDomain, descriptor, (View)(getHost().getModel()));

				cc.compose(createCommand);
			}
		}
		return new ICommandProxy(cc.reduce());

	}

	/**
	 * Method getCreateElementAndViewCommand.
	 * 
	 * @param request
	 * @return Command Which creates the semantic and the view command for the
	 *         given CreateViewAndElementRequest
	 */
	protected Command getCreateElementAndViewCommand(CreateViewAndElementRequest request) {
		// get the element descriptor
		CreateElementRequestAdapter requestAdapter = request.getViewAndElementDescriptor().getCreateElementRequestAdapter();

		// get the semantic request
		CreateElementRequest createElementRequest = (CreateElementRequest)requestAdapter.getAdapter(CreateElementRequest.class);

		if(createElementRequest.getContainer() == null) {
			// complete the semantic request by filling in the host's semantic
			// element as the context
			View view = (View)getHost().getModel();
			EObject hostElement = ViewUtil.resolveSemanticElement(view);

			if(hostElement == null && view.getElement() == null) {
				hostElement = view;
			}

			// Returns null if host is unresolvable so that trying to create a
			// new element in an unresolved shape will not be allowed.
			if(hostElement == null) {
				return null;
			}
			createElementRequest.setContainer(hostElement);
		}

		// get the create element command based on the elementdescriptor's
		// request
		Command createElementCommand = getHost().getCommand(new EditCommandRequestWrapper((CreateElementRequest)requestAdapter.getAdapter(CreateElementRequest.class), request.getExtendedData()));

		if(createElementCommand == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if(!createElementCommand.canExecute()) {
			return createElementCommand;
		}
		// create the semantic create wrapper command
		SemanticCreateCommand semanticCommand = new SemanticCreateCommand(requestAdapter, createElementCommand);
		Command viewCommand = getCreateCommand(request);

		Command refreshConnectionCommand = getHost().getCommand(new RefreshConnectionsRequest(((List<?>)request.getNewObject())));


		// form the compound command and return
		CompositeCommand cc = new CompositeCommand(semanticCommand.getLabel());
		cc.compose(semanticCommand);
		// viewCommand can be empty, since we have decided no to draw every parts
		if(viewCommand.canExecute()) {
			cc.compose(new CommandProxy(viewCommand));
		}
		if(refreshConnectionCommand != null) {
			cc.compose(new CommandProxy(refreshConnectionCommand));
		}

		return new ICommandProxy(cc);
	}

	/**
	 * Subclasses must define this method.
	 * Returns whether the node kind is automatically managed by its parent view (on which policy is applied).
	 * In such a case, the view is drawn by listening the model,
	 * and the view creation command is not called by this policy during creation from the palette.
	 * 
	 * @param semanticHint
	 *        the semantic hint of the node being created
	 * @return true if the view kind is managed automatically
	 */
	abstract protected boolean isSemanticHintAutoManaged(String semanticHint);
}
