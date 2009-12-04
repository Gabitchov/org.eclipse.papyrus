/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) – Initial implementation.
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.editpolicies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RefreshConnectionsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.AddEObjectReferencesToDiagram;
import org.eclipse.papyrus.diagram.common.commands.UpdateDiagramCommand;
import org.eclipse.papyrus.diagram.common.util.MDTUtil;

// TODO: Auto-generated Javadoc
/**
 * A DragAndDropEditPolicy for compartment nodes. Checks whether the dropped elements can be shown
 * as views in the compartment and if so, created their views and add their references to the
 * diagram's list of references.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * @deprecated
 */
public class DragDropEditPolicy extends org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy {

	/** The view resolver. */
	private ViewResolver viewResolver = null;

	/**
	 * Instantiates a new drag drop edit policy.
	 * 
	 * @param resolver
	 *        the resolver
	 */
	public DragDropEditPolicy(ViewResolver resolver) {
		this.viewResolver = resolver;
	}

	/**
	 * Gets the view resolver.
	 * 
	 * @return the view resolver
	 */
	protected ViewResolver getViewResolver() {
		return viewResolver;
	}

	/**
	 * Gets the graphical host.
	 * 
	 * @return the graphical host
	 */
	public IGraphicalEditPart getGraphicalHost() {
		if(getHost() instanceof IGraphicalEditPart) {
			return (IGraphicalEditPart)getHost();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy#
	 * getDropCommand(org.eclipse .gef.requests.ChangeBoundsRequest)
	 */
	@Override
	protected Command getDropCommand(ChangeBoundsRequest request) {
		if(request.getType() != null && request.getType().equals(RequestConstants.REQ_DROP)) {
			// for each EditPart, get its semantic element and check if there's
			// any View available for that kind of element in this container.
			for(Object o : request.getEditParts()) {
				EObject element = MDTUtil.resolveSemantic(o);
				if(getViewResolver().isEObjectNode(element) == false) {
					return UnexecutableCommand.INSTANCE;
				}
			}
		}
		return super.getDropCommand(request);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy#
	 * getDropObjectsCommand( org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest)
	 */
	@Override
	public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {
		// get nodes and edges to add to this Diagram.
		List<EObject> nodeObjects = findNodesInDrop(dropRequest);
		List<ViewDescriptor> viewDescriptors = createViewDescriptors(nodeObjects);
		List<EObject> edgeObjects = findEdgesInDrop(dropRequest);
		Command command = buildDropCommand(dropRequest, nodeObjects, viewDescriptors, edgeObjects);
		return command;
	}

	/**
	 * Find nodes in drop.
	 * 
	 * @param request
	 *        the request
	 * 
	 * @return the list< e object>
	 */
	protected List<EObject> findNodesInDrop(DropObjectsRequest request) {
		List<EObject> nodes = new ArrayList<EObject>();
		for(Object object : request.getObjects()) {
			if(object instanceof EObject) {
				EObject element = (EObject)object;
				if(getViewResolver().isEObjectNode(element)) {
					nodes.add(element);
				}
			}
		}
		return nodes;
	}

	/**
	 * Find edges in drop.
	 * 
	 * @param request
	 *        the request
	 * 
	 * @return the list< e object>
	 */
	protected List<EObject> findEdgesInDrop(DropObjectsRequest request) {
		List<EObject> edges = new ArrayList<EObject>();
		for(Object object : request.getObjects()) {
			if(object instanceof EObject) {
				EObject element = (EObject)object;
				if(getViewResolver().isEObjectLink(element)) {
					edges.add(element);
				}
			}
		}
		return edges;
	}

	/**
	 * Creates the view descriptors.
	 * 
	 * @param elements
	 *        the elements
	 * 
	 * @return the list< view descriptor>
	 */
	protected List<ViewDescriptor> createViewDescriptors(List<EObject> elements) {
		List<ViewDescriptor> viewDescriptors = new ArrayList<ViewDescriptor>();
		for(EObject element : elements) {
			int semanticHint = viewResolver.getEObjectSemanticHint(element);
			if(semanticHint > -1) {
				ViewDescriptor viewDescriptor = new ViewDescriptor(new EObjectAdapter(element), Node.class, String
						.valueOf(semanticHint), getGraphicalHost().getDiagramPreferencesHint());
				viewDescriptors.add(viewDescriptor);
			}
		}
		return viewDescriptors;
	}

	/**
	 * Builds the drop command.
	 * 
	 * @param request
	 *        the request
	 * @param nodes
	 *        the nodes
	 * @param views
	 *        the views
	 * @param edges
	 *        the edges
	 * 
	 * @return the command
	 */
	protected Command buildDropCommand(DropObjectsRequest request, List<EObject> nodes, List<ViewDescriptor> views,
			List<EObject> edges) {
		// build commands that add references to the diagram.
		Command command = buildAddEObjectsReferencesCommand(nodes);
		Command edgesCommand = buildAddEObjectsReferencesCommand(edges);
		command = command == null ? edgesCommand : command.chain(edgesCommand);
		// if no nodes or edges are to be added, there is nothing to do.
		if(command == null) {
			return null;
		}
		// build the create views commands.
		Command viewsCommand = createViewsAndArrangeCommand(request, views);
		if(viewsCommand != null && viewsCommand.canExecute()) {
			command = command.chain(viewsCommand);
		}
		// update diagram.
		command = command.chain(new UpdateDiagramCommand(getGraphicalHost()));
		// return command
		return command;
	}

	/**
	 * Builds the add e objects references command.
	 * 
	 * @param elements
	 *        the elements
	 * 
	 * @return the command
	 */
	protected Command buildAddEObjectsReferencesCommand(List<EObject> elements) {
		if(elements != null && elements.size() > 0) {
			TransactionalEditingDomain domain = getGraphicalHost().getEditingDomain();
			View view = getGraphicalHost().getNotationView();
			if(view != null) {
				return new ICommandProxy(new AddEObjectReferencesToDiagram(domain, view.getDiagram(), elements));
			}
		}
		return null;
	}

	/**
	 * createViewsAndArrangeCommand Method to create all the view based on the viewDescriptors list
	 * and provide a default arrangement of them.
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param viewDescriptors
	 *        the view descriptors
	 * 
	 * @return command
	 */
	protected Command createViewsAndArrangeCommand(DropObjectsRequest dropRequest, List viewDescriptors) {
		CreateViewRequest createViewRequest = new CreateViewRequest(viewDescriptors);
		createViewRequest.setLocation(dropRequest.getLocation());
		Command createCommand = getHost().getCommand(createViewRequest);

		if(createCommand != null) {
			List result = (List)createViewRequest.getNewObject();
			dropRequest.setResult(result);

			RefreshConnectionsRequest refreshRequest = new RefreshConnectionsRequest(result);
			Command refreshCommand = getHost().getCommand(refreshRequest);

			ArrangeRequest arrangeRequest = new ArrangeRequest(RequestConstants.REQ_ARRANGE_DEFERRED);
			arrangeRequest.setViewAdaptersToArrange(result);
			Command arrangeCommand = getHost().getCommand(arrangeRequest);

			CompoundCommand cc = new CompoundCommand(createCommand.getLabel());
			cc.add(createCommand.chain(refreshCommand));
			cc.add(arrangeCommand);

			return cc;
		}
		return null;
	}
}
