/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.util.INotationType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.command.AssociationClassViewCreateCommand;
import org.eclipse.papyrus.diagram.clazz.custom.helper.MultiAssociationHelper;
import org.eclipse.papyrus.diagram.clazz.custom.helper.MultiDependencyHelper;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;

/**
 * This class is used to launch command to create associationClass
 * 
 * @author Patrick Tessier
 */
public class CustomGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {

	/**
	 * This method is used to produce a set of commands in charge of the
	 * creation of AssociationClass
	 * 
	 * @param createConnectionViewAndElementRequest
	 * @param command
	 *            the command that is used to create the link associationClass
	 * @return the set of command to create an association Class
	 */
	private Command getAssociationClassElementCommand(
			CreateConnectionViewAndElementRequest createConnectionViewAndElementRequest,
			Command command) {
		if (command instanceof ICommandProxy) {
			GraphicalEditPart sourceEditPart = (GraphicalEditPart) createConnectionViewAndElementRequest
					.getSourceEditPart();

			// 1. calculus of the position of the associationClass node
			Point p = sourceEditPart.getFigure().getBounds().getTopRight()
					.getCopy();
			sourceEditPart.getFigure().translateToAbsolute(p);
			int edgeCount = sourceEditPart.getNotationView().getSourceEdges()
					.size();
			int offset = (edgeCount * 50) - 100;
			p = p.translate(100, offset);

			// 2. creation of the associationClass Node without semantic element
			GraphicalEditPart parent = (GraphicalEditPart) sourceEditPart
					.getParent();
			AssociationClassViewCreateCommand assCommand = new AssociationClassViewCreateCommand(
					createConnectionViewAndElementRequest, getEditingDomain(),
					(View) parent.getModel(), (EditPartViewer) sourceEditPart
							.getViewer(), sourceEditPart
							.getDiagramPreferencesHint(), p);
			command = command.chain(new ICommandProxy(assCommand));

			// 3. creation of the dashed line between the associationClass link
			// and associationClass Node
			// target
			IAdaptable associationClassLinkViewAdapter = (IAdaptable) (createConnectionViewAndElementRequest
					.getNewObject());

			ConnectionViewDescriptor viewDescriptor = new ConnectionViewDescriptor(
					UMLElementTypes.Link_4016,
					((INotationType) UMLElementTypes.Link_4016)
							.getSemanticHint(), sourceEditPart
							.getDiagramPreferencesHint());
			ICommand dashedLineCmd = new CustomDeferredCreateConnectionViewCommand(
					getEditingDomain(),
					((IHintedType) UMLElementTypes.Link_4016).getSemanticHint(),
					associationClassLinkViewAdapter, null, sourceEditPart
							.getViewer(), sourceEditPart
							.getDiagramPreferencesHint(), viewDescriptor,
					assCommand);

			command = command.chain(new ICommandProxy(dashedLineCmd));
			return command;
		}
		return null;
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
				CreateElementRequestAdapter requestAdapter = ((CreateConnectionViewAndElementRequest) request)
						.getConnectionViewAndElementDescriptor()
						.getCreateElementRequestAdapter();
				CreateRelationshipRequest createElementRequest = (CreateRelationshipRequest) requestAdapter
						.getAdapter(CreateRelationshipRequest.class);
				if (UMLElementTypes.AssociationClass_4017
						.equals(createElementRequest.getElementType())) {
					return getAssociationClassElementCommand(
							((CreateConnectionViewAndElementRequest) request),
							c);

				} else if (UMLElementTypes.Dependency_4018
						.equals(createElementRequest.getElementType())) {
					MultiDependencyHelper multiDependencyHelper = new MultiDependencyHelper(
							getEditingDomain());
					return multiDependencyHelper.getCommand(
							((CreateConnectionViewAndElementRequest) request),
							c);

				} else if (UMLElementTypes.Association_4019
						.equals(createElementRequest.getElementType())) {
					MultiAssociationHelper multiAssociationHelper = new MultiAssociationHelper(
							getEditingDomain());
					return multiAssociationHelper.getCommand(
							((CreateConnectionViewAndElementRequest) request),
							c);

				} else {
					return c;
				}
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