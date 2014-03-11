/*****************************************************************************
 * Copyright (c) 2011-2012 CEA LIST.
 *   
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - refactor common behavior between diagrams
 *  
 *  CEA LIST - Adapted to use a local graphical type registry.
 *  
 *****************************************************************************/
package org.eclipse.papyrus.gmf.diagram.common.edit.policy;

import static org.eclipse.papyrus.gmf.diagram.common.provider.IGraphicalTypeRegistry.UNDEFINED_TYPE;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RefreshConnectionsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.CommandProxyWithResult;
import org.eclipse.papyrus.gmf.diagram.common.provider.IGraphicalTypeRegistry;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.DeferredSnapToGridCommand;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.ViewDescriptorUtil;
import org.eclipse.papyrus.uml.diagram.common.commands.CommonDeferredCreateConnectionViewCommand;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AbstractElementBorderEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AbstractElementLabelEditPart;
import org.eclipse.papyrus.uml.diagram.common.util.CrossReferencerUtil;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;

/**
 * Abstract DND edit policy delegating the choice of the view to create for an EObject to a local
 * graphical type registry.
 */
public abstract class CommonDiagramDragDropEditPolicy extends DiagramDragDropEditPolicy {

	/** The graphical type registry. */
	protected IGraphicalTypeRegistry registry;

	/** The list of element types that require a specific drop command. */
	private Set<String> specificDropList = null;

	/** The specified link mapping helper depending on the diagram */
	protected ILinkMappingHelper linkMappingHelper;

	/** Constructor */
	public CommonDiagramDragDropEditPolicy(ILinkMappingHelper linkMappingHelper) {
		this.linkMappingHelper = linkMappingHelper;
	}

	private Set<String> getSpecificDropList() {
		if(specificDropList == null) {
			specificDropList = getSpecificDropBehaviorTypes();
		}
		return specificDropList;
	}

	protected abstract Set<String> getSpecificDropBehaviorTypes();

	/**
	 * <pre>
	 * {@inheritedDoc}.
	 * 
	 * Overridden method to fix some exception occurring while moving affixed element (nodes or labels)
	 * (https://bugs.eclipse.org/bugs/show_bug.cgi?id=350680).
	 * </pre>
	 */
	@Override
	protected Command getDropCommand(ChangeBoundsRequest request) {

		Iterator<?> iter = request.getEditParts().iterator();
		EObject graphicalParentObject = ((GraphicalEditPart)getHost()).resolveSemanticElement();
		while((graphicalParentObject != null) && (iter.hasNext())) {
			EditPart droppedEditPart = (EditPart)iter.next();
			if(droppedEditPart instanceof AbstractElementBorderEditPart) {
				return UnexecutableCommand.INSTANCE;
			}
			if(droppedEditPart instanceof AbstractElementLabelEditPart) {
				return UnexecutableCommand.INSTANCE;
			}
		}
		return super.getDropCommand(request);
	}

	/**
	 * {@inheritedDoc}.
	 */
	@Override
	public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {

		CompoundCommand completeDropCommand = new CompoundCommand("DropObjectsAndArrange"); //$NON-NLS-1$

		// Detect file drop
		if((dropRequest.getObjects().size() > 0) && (dropRequest.getObjects().get(0) instanceof String)) {
			return getDropFileCommand(dropRequest);
		}

		// Create the drop command by composite drop command for each dropped elements
		CompositeCommand gmfDropCommand = new CompositeCommand("DropObjects"); //$NON-NLS-1$
		Iterator<?> iter = dropRequest.getObjects().iterator();
		while(iter.hasNext()) {
			EObject droppedObject = (EObject)iter.next();
			gmfDropCommand.add(getDropObjectCommand(dropRequest, droppedObject));
		}

		// Create the complete drop command by adding an arrange command after drop
		if(!gmfDropCommand.isEmpty()) {

			// Retrieve drop result (most probably created view but not necessarily) and update the request
			CommandResult result = gmfDropCommand.getCommandResult();
			List<?> newValues = (List<?>)result.getReturnValue();
			dropRequest.setResult(newValues);

			// Prepare refresh command
			RefreshConnectionsRequest refreshRequest = new RefreshConnectionsRequest(newValues);
			Command refreshCommand = getHost().getCommand(refreshRequest);

			// Prepare an arrange command to avoid every dropped view to appear at the same location
			ArrangeRequest arrangeRequest = new ArrangeRequest(RequestConstants.REQ_ARRANGE_DEFERRED);
			arrangeRequest.setViewAdaptersToArrange(newValues);
			Command arrangeCommand = getHost().getCommand(arrangeRequest);

			// Update the complete drop command (drop - refresh - arrange)
			Command dropCommand = new ICommandProxy(gmfDropCommand);
			completeDropCommand.add(dropCommand.chain(refreshCommand));
			completeDropCommand.add(arrangeCommand);

			//add snap command if required
			//430099: [Diagram] Snap to Grid for elements dropped from the ModelExplorer is ignored
			//https://bugs.eclipse.org/bugs/show_bug.cgi?id=430099
			final Object value = dropRequest.getExtendedData().get(PreferencesConstantsHelper.SNAP_TO_GRID_CONSTANT);
			if(value instanceof Boolean && Boolean.TRUE.equals(value)) {
				DeferredSnapToGridCommand snapCommand = new DeferredSnapToGridCommand(getEditingDomain(), newValues, (IGraphicalEditPart)getHost());
				completeDropCommand.add(new ICommandProxy(snapCommand));
			}

		}

		return completeDropCommand;
	}

	protected ICommand getDropObjectCommand(DropObjectsRequest dropRequest, EObject droppedObject) {

		Point location = dropRequest.getLocation().getCopy();

		View dropTargetView = ((IGraphicalEditPart)getHost()).getNotationView();
		EObject dropTargetElement = dropTargetView.getElement();

		String droppedNodeType = registry.getNodeGraphicalType(droppedObject, dropTargetView.getType());
		String droppedEdgeType = registry.getEdgeGraphicalType(droppedObject);

		// Test if a specific drop command should be used
		if(getSpecificDropList().contains(droppedNodeType) || getSpecificDropList().contains(droppedEdgeType)) {
			return getSpecificDropCommand(dropRequest, droppedObject, droppedNodeType, droppedEdgeType);
		}

		// Decide unknown type handling
		if(UNDEFINED_TYPE.equals(droppedNodeType) && UNDEFINED_TYPE.equals(droppedEdgeType)) {
			return getUnknownDropCommand(dropRequest, droppedObject);
		}

		// The dropped element is a node
		if(!UNDEFINED_TYPE.equals(droppedNodeType)) {

			// Drop restriction:
			// - no restriction when dropped on diagram
			// - require containment when dropped on any other EObject		
			 if((dropTargetView instanceof Diagram) || dropTargetElement.eContents().contains(droppedObject)) {
				return getDefaultDropNodeCommand(droppedNodeType, location, droppedObject);
			 }

			 // Allow drop for inherited elements
			 if (dropTargetElement instanceof Classifier && ((Classifier) dropTargetElement).getAllAttributes().contains(droppedObject) ) {
				return getDefaultDropNodeCommand(droppedNodeType, location, droppedObject);
			 }		
			 return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
		}

		// The dropped element is a edge
		if(!UNDEFINED_TYPE.equals(droppedEdgeType)) {

			Collection<?> sources = linkMappingHelper.getSource((Element)droppedObject);
			Collection<?> targets = linkMappingHelper.getTarget((Element)droppedObject);

			// Only manage binary link during drop
			if((sources.size() > 0) && (targets.size() > 0)) {
				EObject source = (EObject)sources.toArray()[0];
				EObject target = (EObject)targets.toArray()[0];
				return getDefaultDropEdgeCommand(droppedObject, source, target, droppedEdgeType, location);
			}

			return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
		}

		return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
	}

	protected ICommand getDefaultDropNodeCommand(String droppedObjectGraphicalType, Point absoluteLocation, EObject droppedObject) {

		IAdaptable elementAdapter = new EObjectAdapter(droppedObject);

		ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, droppedObjectGraphicalType, ViewUtil.APPEND, ViewDescriptorUtil.PERSISTED, getDiagramPreferencesHint());
		CreateViewRequest createViewRequest = new CreateViewRequest(descriptor);
		createViewRequest.setLocation(absoluteLocation);

		// Get view creation command for the dropped object
		Command command = getHost().getCommand(createViewRequest);

		// Use the ViewDescriptor as command result, it then can be used as an adaptable to retrieve the View
		return new CommandProxyWithResult(command, descriptor);
	}

	protected ICommand getDefaultDropEdgeCommand(EObject droppedObject, EObject source, EObject target, String droppedEdgeType, Point absoluteLocation) {

		CompositeCommand completeDropCommand = new CompositeCommand("CompleteDropEdge"); //$NON-NLS-1$

		// Find views in current diagram representing source and target 
		Collection<View> sourceViews = getViews(source);
		Collection<View> targetViews = getViews(target);

		IAdaptable sourceViewAdapter = null;
		IAdaptable targetViewAdapter = null;

		// If either a source or target lacks create view for these elements
		// - using defaultDrop command (assumed to be a view creation)
		// - try to create view on host
		if(sourceViews.isEmpty() || targetViews.isEmpty()) {

			CompositeCommand createEndViewsCommand = new CompositeCommand("CreateSourceTargetViews"); //$NON-NLS-1$

			View dropContainerView = ((IGraphicalEditPart)getHost()).getNotationView();
			EObject dropContainerElement = dropContainerView.getElement();

			if(sourceViews.isEmpty()) {
				if(dropContainerElement.eContents().contains(source)) {
					ICommand dropSourceCommand = getDefaultDropNodeCommand(registry.getNodeGraphicalType(source, dropContainerView.getType()), absoluteLocation.getCopy(), source);
					CompositeCommand.compose(createEndViewsCommand, dropSourceCommand);
					sourceViewAdapter = (IAdaptable)dropSourceCommand.getCommandResult().getReturnValue();
				} else {
					return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
				}
			}

			if(targetViews.isEmpty()) {
				if(dropContainerElement.eContents().contains(target)) {
					ICommand dropTargetCommand = getDefaultDropNodeCommand(registry.getNodeGraphicalType(target, dropContainerView.getType()), absoluteLocation.getCopy(), target);
					CompositeCommand.compose(createEndViewsCommand, dropTargetCommand);
					targetViewAdapter = (IAdaptable)dropTargetCommand.getCommandResult().getReturnValue();
				} else {
					return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
				}
			}

			CompositeCommand.compose(completeDropCommand, createEndViewsCommand);
		}

		// Create source adapter
		if(!sourceViews.isEmpty()) { // sourceViewAdapter should still be null in this case
			sourceViewAdapter = new SemanticAdapter(null, sourceViews.toArray()[0]);
		}

		// Create target adapter
		if(!targetViews.isEmpty()) { // targetViewAdapter should still be null in this case
			targetViewAdapter = new SemanticAdapter(null, targetViews.toArray()[0]);
		}

		// Create a view for the dropped link between the source and target view adapters
		IAdaptable droppedObjectAdapter = new SemanticAdapter(droppedObject, null);

		CreateConnectionViewRequest.ConnectionViewDescriptor linkdescriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(droppedObjectAdapter, droppedEdgeType, getDiagramPreferencesHint());

		CommonDeferredCreateConnectionViewCommand createConnectionViewCommand = new CommonDeferredCreateConnectionViewCommand(getEditingDomain(), droppedEdgeType, sourceViewAdapter, targetViewAdapter, getViewer(), getDiagramPreferencesHint(), linkdescriptor, null);
		createConnectionViewCommand.setElement(droppedObject);

		CompositeCommand.compose(completeDropCommand, createConnectionViewCommand);

		return completeDropCommand.reduce();
	}

	/**
	 * <pre>
	 * Sub-classes have to implement this method in order to provides specific drop command for
	 * element which require a specific treatment.
	 * 
	 * @param dropRequest current drop request
	 * @param droppedEObject the dropped object
	 * @param nodeType the graphical type of the dropped element (node representation)
	 * @param edgeType the graphical type of the dropped element (edge representation)
	 * @return the drop command
	 * </pre>
	 */
	protected ICommand getSpecificDropCommand(DropObjectsRequest dropRequest, EObject droppedEObject, String nodeType, String edgeType) {
		return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
	}

	/**
	 * <pre>
	 * Sub-classes have to implement this method in order to provides drop command for
	 * elements that are not natively known by the diagram.
	 * 
	 * @param dropRequest current drop request
	 * @param droppedEObject the dropped object
	 * @return the drop command
	 * </pre>
	 */
	protected ICommand getUnknownDropCommand(DropObjectsRequest dropRequest, EObject droppedEObject) {
		return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
	}

	protected EditPartViewer getViewer() {
		return ((IGraphicalEditPart)getHost()).getViewer();
	}

	protected TransactionalEditingDomain getEditingDomain() {
		return ((IGraphicalEditPart)getHost()).getEditingDomain();
	}

	protected PreferencesHint getDiagramPreferencesHint() {
		return ((IGraphicalEditPart)getHost()).getDiagramPreferencesHint();
	}

	/**
	 * This methods looks for views representing a given EObject in the host diagram.
	 * 
	 * @param eObject
	 *        the {@link EObject} to look for.
	 * @return the list of {@link View} representing the eObject.
	 */
	private Set<View> getViews(EObject eObject) {
		Set<View> views = new HashSet<View>();

		// Retrieve host diagram
		View hostView = ((IGraphicalEditPart)getHost()).getNotationView();
		View hostDiagram = (hostView instanceof Diagram) ? hostView : hostView.getDiagram();

		// Retrieve all views for the eObject
		Collection<View> relatedViews =  CrossReferencerUtil.getCrossReferencingViews(eObject, hostDiagram.getType());
		
		// Parse and select views from host diagram only	
		Iterator<View> it = relatedViews.iterator();
		while(it.hasNext()) {
			View currentView = it.next();
			if(!(currentView instanceof Diagram) && (currentView.getDiagram() == hostDiagram)) {
				views.add(currentView);
			}
		}

		return views;
	}
}
