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
package org.eclipse.papyrus.diagram.common.groups.edit.policies;

import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SemanticCreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.diagram.ui.requests.RefreshConnectionsRequest;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.groups.core.groupcontainment.GroupContainmentRegistry;
import org.eclipse.papyrus.diagram.common.groups.core.utils.Utils;
import org.eclipse.papyrus.diagram.common.groups.utils.GroupRequestConstants;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;

/**
 * This Edit Policy applies on the compartment of a group which owns its elements by reference. It enables to recover the correct model container in
 * order to create the element at the right place in the model, before linking it to the referencing group.
 * 
 * In order to do so, the semantic creation command, inheriting {@link EditElementCommand}, must recover the
 * {@link GroupRequestConstants#MODEL_CONTAINER} parameter from the request to know the model container of the created element and assign it itself.
 * 
 * @author vhemery
 */
public class CreateInReferencingGroupEditPolicy extends CreationEditPolicy {

	/**
	 * Get the command to create a group referenced child and create it in the appropriate place.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy#getCreateElementAndViewCommand(org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest)
	 * 
	 * @param request
	 *        the creation request
	 * @return the creation command or null
	 */
	@Override
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

			// recover the model container to store it in request
			Dimension size = request.getSize();
			if(size == null || size.isEmpty()) {
				size = new Dimension();
			}
			Rectangle bounds = new Rectangle(request.getLocation(), size);
			if(getHost() instanceof IGraphicalEditPart) {
				//((IGraphicalEditPart)getHost()).getFigure().translateToRelative(bounds);
				//bounds.translate(((IGraphicalEditPart)getHost()).getFigure().getBounds().getLocation());
				DiagramEditPart diagramPart = DiagramEditPartsUtil.getDiagramEditPart(getHost());
				List<IGraphicalEditPart> parents = Utils.findPossibleParents(bounds, diagramPart);
				IGraphicalEditPart modelParent = selectBestModelContainer(parents);
				EObject modelContainer = null;
				if(modelParent != null) {
					modelContainer = modelParent.resolveSemanticElement();
				} else {
					modelContainer = getDefaultModelParent(createElementRequest);
				}
				if(modelContainer != null) {
					createElementRequest.setParameter(GroupRequestConstants.MODEL_CONTAINER, modelContainer);
				}
			}
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
		cc.compose(new CommandProxy(viewCommand));
		if(refreshConnectionCommand != null) {
			cc.compose(new CommandProxy(refreshConnectionCommand));
		}

		return new ICommandProxy(cc);
	}

	/**
	 * Get the eobject to use as container for creation in this edit part. This method is intended to be overridden by diagrams which need to.
	 * 
	 * @param createElementRequest
	 *        the creation request
	 * @return the model container to use
	 */
	private EObject getDefaultModelParent(CreateElementRequest createElementRequest) {
		if(getHost() instanceof IGraphicalEditPart) {
			return ((IGraphicalEditPart)getHost()).resolveSemanticElement().eContainer();
		} else {
			return null;
		}
	}

	/**
	 * Select the best model container among the list of possible parents
	 * 
	 * @param parents
	 *        group parents
	 * @return the best model container (deepest one) or null if none
	 */
	protected IGraphicalEditPart selectBestModelContainer(List<IGraphicalEditPart> parents) {
		IGraphicalEditPart container = null;
		int containerDepth = 0;
		for(IGraphicalEditPart parent : parents) {
			// select model containers only
			if(GroupContainmentRegistry.isContainerModel(parent)) {
				// select part the deepest in the diagram
				int depth = getDepth(parent);
				if(depth > containerDepth) {
					container = parent;
				}
			}
		}
		return container;
	}

	/**
	 * Get the depth at which the edit part is in the diagram
	 * 
	 * @param part
	 *        the edit part to test depth
	 * @return number of parents + 1
	 */
	protected int getDepth(IGraphicalEditPart part) {
		int depth = 0;
		EditPart parentPart = part;
		while(parentPart != null) {
			parentPart = parentPart.getParent();
			depth++;
		}
		return depth;
	}
}
