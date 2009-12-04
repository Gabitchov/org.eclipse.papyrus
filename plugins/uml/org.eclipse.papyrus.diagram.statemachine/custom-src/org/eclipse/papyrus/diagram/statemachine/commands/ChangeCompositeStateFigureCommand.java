/*******************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Francisco Javier Cano Mu�oz (Prodevelop) - Initial API 
 *  implementation.
 *  Marc Gil Sendra (Prodevelop)
 *
 ******************************************************************************/

package org.eclipse.papyrus.diagram.statemachine.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.UMLUpdateDiagramCommand;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionSubvertices2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.State2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionEditPart;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;

/**
 * The Class ChangeCompositeStateFigureCommand.
 */
public class ChangeCompositeStateFigureCommand extends Command {

	/** The compound command. */
	CompoundCommand compoundCommand = new CompoundCommand();

	/** The delete view command. */
	private Command deleteViewCommand;

	/** The create view command. */
	private Command createViewCommand;

	/** The relocate connections command. */
	private Command relocateConnectionsCommand;

	/** The restore children transitions command. */
	private Command restoreChildrenTransitionsCommand;

	/** The arrange command. */
	private Command arrangeCommand;

	/** The view descriptor. */
	private ViewDescriptor viewDescriptor;

	/** The root edit part. */
	private EditPart rootEditPart;

	/** The new state edit part. */
	private GraphicalEditPart newStateEditPart;

	/** The old state edit part. */
	private GraphicalEditPart oldStateEditPart;

	/** The all edit parts. */
	private List<IGraphicalEditPart> allEditParts;

	/**
	 * Sets the delete command.
	 * 
	 * @param command
	 *        the new delete command
	 */
	public void setDeleteCommand(Command command) {
		deleteViewCommand = command;
	}

	/**
	 * Sets the creates the command.
	 * 
	 * @param command
	 *        the new creates the command
	 */
	public void setCreateCommand(Command command) {
		createViewCommand = command;
	}

	/**
	 * Sets the relocate command.
	 * 
	 * @param command
	 *        the new relocate command
	 */
	public void setRelocateCommand(Command command) {
		relocateConnectionsCommand = command;
	}

	/**
	 * Sets the view descriptor.
	 * 
	 * @param request
	 *        the new view descriptor
	 */
	public void setViewDescriptor(ViewDescriptor request) {
		viewDescriptor = request;
	}

	/**
	 * Sets the root edit part.
	 * 
	 * @param editPart
	 *        the new root edit part
	 */
	public void setRootEditPart(EditPart editPart) {
		rootEditPart = editPart;
	}

	/**
	 * Sets the old state edit part.
	 * 
	 * @param editPart
	 *        the new old state edit part
	 */
	public void setOldStateEditPart(GraphicalEditPart editPart) {
		oldStateEditPart = editPart;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		createViewCommand.execute();
		compoundCommand.add(createViewCommand);

		View newView = (View)viewDescriptor.getAdapter(View.class);

		newStateEditPart = SearchEditPartByNode(rootEditPart, (Node)newView);

		if(newStateEditPart instanceof State2EditPart) {
			allEditParts = DiagramEditPartsUtil.getAllEditParts(rootEditPart);
			arrangeCommand = getArrangeCommand();
			if(arrangeCommand != null) {
				compoundCommand.add(arrangeCommand);
				arrangeCommand.execute();
			}
		}

		deleteViewCommand.execute();
		compoundCommand.add(deleteViewCommand);

		/*
		 * the following command change the new view bounds to set her where the
		 * old view.
		 */
		SetBoundsCommand sbc = new SetBoundsCommand(newStateEditPart.getEditingDomain(),
				"relocate new figure",
				DiagramEditPartsUtil.getEditPartFromView(newView, newStateEditPart),
				oldStateEditPart.getFigure().getBounds().getLocation());
		try {
			sbc.execute(new NullProgressMonitor(), null);
			compoundCommand.add(new ICommandProxy(sbc));
		} catch (ExecutionException e) {

		}
		//end

		Command updateCommand = new UMLUpdateDiagramCommand(newStateEditPart);
		if(updateCommand != null) {
			updateCommand.execute();
			compoundCommand.add(updateCommand);
		}

		return;
	}

	/**
	 * Search edit part by node.
	 * 
	 * @param editPart
	 *        the edit part
	 * @param node
	 *        the node
	 * 
	 * @return the graphical edit part
	 */
	private GraphicalEditPart SearchEditPartByNode(EditPart editPart, Node node) {
		View view = (View)editPart.getModel();

		if(view instanceof Node) {
			Node modelNode = (Node)view;

			if(modelNode.equals(node)) {
				return (GraphicalEditPart)editPart;
			}
		}

		List<EditPart> children = editPart.getChildren();

		if(children.size() <= 0)
			return null;

		EditPart found = null;
		for(EditPart child : children) {
			found = SearchEditPartByNode(child, node);
			if(found != null)
				break;
		}

		return (GraphicalEditPart)found;
	}

	/**
	 * Gets the restore connections command.
	 * 
	 * @param editPart
	 *        the edit part
	 * 
	 * @return the restore connections command
	 */
	private Command getRestoreConnectionsCommand(GraphicalEditPart editPart) {
		if(editPart == null)
			return null;

		List<ConnectionNodeEditPart> connections = getEditPartConnections(editPart);

		if(connections == null || connections.size() <= 0) {
			return null;
		}

		CompoundCommand compoundCommand = new CompoundCommand(
				"Rebuild connections");
		Command command = null;
		for(ConnectionNodeEditPart edge : connections) {
			command = getCreateConnectionsViewCommand(edge);
			if(command != null) {
				compoundCommand.add(command);
			}
		}

		if(compoundCommand.size() <= 0) {
			return null;
		}

		compoundCommand.setLabel("Reconnect connections");
		return compoundCommand;
	}

	/**
	 * Gets the creates the connections view command.
	 * 
	 * @param editPart
	 *        the edit part
	 * 
	 * @return the creates the connections view command
	 */
	private Command getCreateConnectionsViewCommand(
			ConnectionNodeEditPart editPart) {
		CreateConnectionViewRequest createViewRequest = getCreateConnectionViewRequest(editPart);
		if(createViewRequest == null) {
			return null;
		}

		Command command = findTargetEditPart(editPart).getCommand(
				createViewRequest);
		command.setLabel("Reconnect this connection");

		return command;
	}

	/**
	 * Gets the creates the connection view request.
	 * 
	 * @param editPart
	 *        the edit part
	 * 
	 * @return the creates the connection view request
	 */
	private CreateConnectionViewRequest getCreateConnectionViewRequest(
			ConnectionNodeEditPart editPart) {
		View view = (View)editPart.getModel();
		if(view == null) {
			return null;
		}

		EObject eObject = view.getElement();
		String semanticHint = String.valueOf(TransitionEditPart.VISUAL_ID);
		ConnectionViewDescriptor viewDescriptor = new ConnectionViewDescriptor(
				new EObjectAdapter(eObject), semanticHint,
				PreferencesHint.USE_DEFAULTS);

		CreateConnectionViewRequest createViewRequest = new CreateConnectionViewRequest(
				viewDescriptor);

		EditPart sourceEditPart, targetEditPart;
		sourceEditPart = findSourceEditPart(editPart);
		targetEditPart = findTargetEditPart(editPart);

		createViewRequest.setType(RequestConstants.REQ_CONNECTION_START);
		createViewRequest.setTargetEditPart(targetEditPart);
		sourceEditPart.getCommand(createViewRequest);

		createViewRequest.setType(RequestConstants.REQ_CONNECTION_END);
		createViewRequest.setSourceEditPart(sourceEditPart);
		createViewRequest.setTargetEditPart(targetEditPart);

		return createViewRequest;
	}

	/**
	 * Gets the edits the part connections.
	 * 
	 * @param editPart
	 *        the edit part
	 * 
	 * @return the edits the part connections
	 */
	private List getEditPartConnections(GraphicalEditPart editPart) {
		List connections = new ArrayList();

		connections.addAll(editPart.getSourceConnections());
		connections.addAll(editPart.getTargetConnections());

		return connections;
	}

	/**
	 * Find source edit part.
	 * 
	 * @param editPart
	 *        the edit part
	 * 
	 * @return the edits the part
	 */
	private EditPart findSourceEditPart(ConnectionNodeEditPart editPart) {
		EditPart source = editPart.getSource();

		if(source.equals(oldStateEditPart)) {
			return newStateEditPart;
		} else {
			return source;
		}

	}

	/**
	 * Find target edit part.
	 * 
	 * @param editPart
	 *        the edit part
	 * 
	 * @return the edits the part
	 */
	private EditPart findTargetEditPart(ConnectionNodeEditPart editPart) {
		EditPart target = editPart.getTarget();

		if(target.equals(oldStateEditPart)) {
			return newStateEditPart;
		} else {
			return target;
		}
	}

	/**
	 * Gets the restore children connections command.
	 * 
	 * @param editPart
	 *        the edit part
	 * 
	 * @return the restore children connections command
	 */
	private Command getRestoreChildrenConnectionsCommand(
			GraphicalEditPart editPart) {

		List<Transition> transitions = getAllChildrenTransitions(editPart);

		CompoundCommand cc = new CompoundCommand();

		for(int i = 0; i < transitions.size(); i++) {
			Transition transition = transitions.get(i);
			if(!isAlreadyRequested(transition, i, transitions)) {
				Command command = getChildrenTransitionCreateViewCommand(transition);
				if(command != null) {
					cc.add(command);
				}
			}
		}

		if(cc.size() > 0) {
			return cc;
		}

		return null;
	}

	/**
	 * Gets the children transition create view request.
	 * 
	 * @param transition
	 *        the transition
	 * 
	 * @return the children transition create view request
	 */
	private CreateConnectionViewRequest getChildrenTransitionCreateViewRequest(
			Transition transition) {

		String semanticHint = String.valueOf(TransitionEditPart.VISUAL_ID);
		ConnectionViewDescriptor viewDescriptor = new ConnectionViewDescriptor(
				new EObjectAdapter(transition), semanticHint,
				PreferencesHint.USE_DEFAULTS);
		CreateConnectionViewRequest createViewRequest = new CreateConnectionViewRequest(
				viewDescriptor);

		EditPart source, target;

		source = findEditPartByElement(transition.getSource());
		target = findEditPartByElement(transition.getTarget());

		if(source == null || target == null) {
			return null;
		}

		createViewRequest.setType(RequestConstants.REQ_CONNECTION_START);
		createViewRequest.setTargetEditPart(target);
		source.getCommand(createViewRequest);

		createViewRequest.setType(RequestConstants.REQ_CONNECTION_END);
		createViewRequest.setSourceEditPart(source);
		createViewRequest.setTargetEditPart(target);

		return createViewRequest;
	}

	/**
	 * Gets the children transition create view command.
	 * 
	 * @param transition
	 *        the transition
	 * 
	 * @return the children transition create view command
	 */
	private Command getChildrenTransitionCreateViewCommand(Transition transition) {
		CreateConnectionViewRequest request = getChildrenTransitionCreateViewRequest(transition);
		if(request == null) {
			return null;
		}

		Command command = request.getTargetEditPart().getCommand(request);

		return command;
	}

	/**
	 * Checks if is already requested.
	 * 
	 * @param o
	 *        the o
	 * @param j
	 *        the j
	 * @param l
	 *        the l
	 * 
	 * @return true, if is already requested
	 */
	private boolean isAlreadyRequested(Object o, int j, List l) {
		for(int i = 0; i < l.size() && i < j; i++) {
			if(l.get(i).equals(o)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Gets the all children transitions.
	 * 
	 * @param editPart
	 *        the edit part
	 * 
	 * @return the all children transitions
	 */
	private List<Transition> getAllChildrenTransitions(
			GraphicalEditPart editPart) {

		List<Transition> transitions = new ArrayList<Transition>();

		List<EditPart> children = editPart.getChildren();

		for(EditPart ep : children) {
			if(ep instanceof GraphicalEditPart) {
				transitions
						.addAll(getAllChildrenTransitions(((GraphicalEditPart)ep)));
				Object model = ep.getModel();
				View view = model != null && model instanceof View ? (View)model
						: null;
				Vertex vertex = view != null
						&& view.getElement() instanceof Vertex ? (Vertex)view
						.getElement() : null;
				if(vertex != null) {
					transitions.addAll(vertex.getIncomings());
					transitions.addAll(vertex.getOutgoings());
				}
			}
		}

		return transitions;
	}

	/**
	 * Find edit part by element.
	 * 
	 * @param element
	 *        the element
	 * 
	 * @return the edits the part
	 */
	private EditPart findEditPartByElement(EObject element) {

		for(IGraphicalEditPart ep : allEditParts) {
			Object view = ep.getModel();
			if(view != null && view instanceof View) {
				EObject eo = ((View)view).getElement();
				if(eo.equals(element)) {
					return ep;
				}
			}
		}

		return null;
	}

	/**
	 * Gets the arrange command.
	 * 
	 * @return the arrange command
	 */
	private Command getArrangeCommand() {

		List<RegionSubvertices2EditPart> regions = new ArrayList<RegionSubvertices2EditPart>();

		getAllRegionsToArrange(newStateEditPart, regions);

		if(regions.size() <= 0) {
			return null;
		}

		CompoundCommand cc = new CompoundCommand();
		cc.setLabel("Arrange Regions");

		for(RegionSubvertices2EditPart r : regions) {
			Command command = getArrangeRegionCommand(r);
			if(command != null) {
				cc.add(command);
			}
		}

		if(cc.size() > 0) {
			return cc;
		}

		return null;
	}

	/**
	 * Gets the arrange region command.
	 * 
	 * @param region
	 *        the region
	 * 
	 * @return the arrange region command
	 */
	private Command getArrangeRegionCommand(RegionSubvertices2EditPart region) {

		if(region == null) {
			return null;
		}

		List<EditPart> children = region.getChildren();
		if(children.size() <= 0) {
			return null;
		}

		ArrangeRequest request = new ArrangeRequest(
				ActionIds.ACTION_ARRANGE_ALL);
		request.setPartsToArrange(children);
		Command command = region.getCommand(request);
		return command;
	}

	/**
	 * Gets the all regions to arrange.
	 * 
	 * @param editPart
	 *        the edit part
	 * @param list
	 *        the list
	 * 
	 * @return the all regions to arrange
	 */
	private void getAllRegionsToArrange(EditPart editPart,
			List<RegionSubvertices2EditPart> list) {

		if(editPart == null) {
			return;
		}

		List<EditPart> children = editPart.getChildren();

		for(EditPart ep : children) {
			getAllRegionsToArrange(ep, list);
			if(ep instanceof RegionSubvertices2EditPart) {
				list.add((RegionSubvertices2EditPart)ep);
			}
		}

		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {

		return (deleteViewCommand != null && createViewCommand != null
				&& rootEditPart != null && viewDescriptor != null && oldStateEditPart != null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canUndo()
	 */
	@Override
	public boolean canUndo() {
		return compoundCommand.canUndo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#chain(org.eclipse.gef.commands.Command)
	 */
	@Override
	public Command chain(Command command) {
		return compoundCommand.chain(command);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#dispose()
	 */
	@Override
	public void dispose() {
		compoundCommand.dispose();
		super.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#getDebugLabel()
	 */
	@Override
	public String getDebugLabel() {
		return compoundCommand.getDebugLabel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#getLabel()
	 */
	@Override
	public String getLabel() {
		return compoundCommand.getLabel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	@Override
	public void redo() {
		compoundCommand.redo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#setDebugLabel(java.lang.String)
	 */
	@Override
	public void setDebugLabel(String label) {
		compoundCommand.setDebugLabel(label);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#setLabel(java.lang.String)
	 */
	@Override
	public void setLabel(String label) {
		compoundCommand.setLabel(label);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		compoundCommand.undo();
	}

}
