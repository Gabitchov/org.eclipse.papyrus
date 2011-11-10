/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
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
package org.eclipse.papyrus.uml.diagram.common.groups.commands;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.groups.core.utils.Utils;
import org.eclipse.papyrus.uml.diagram.common.groups.utils.GroupRequestConstants;

/**
 * This command change the graphical parent of an edit part without changing the absolute position of the element
 * 
 * @author arthur daussy
 * 
 */
public class ChangeGraphicalParentCommand extends AbstractTransactionalCommand {

	public enum Mode {
		/**
		 * Case when the parent is in creation.
		 */
		CREATION_PARENT,
		/**
		 * Case when the child is in creation
		 */
		CREATION_CHILD,
		/**
		 * Case when the child is moving (ChangeBoundsRequest)
		 */
		MOVE_CHILD,
		/**
		 * case when the parent is moving
		 */
		MOVE_PARENT,
		/**
		 * Case when there is no need of a request. All elements has been placed annd all element ared fixed
		 */
		NORMAL
	}


	/** child part */
	private EditPart child;

	/** parent part */
	private EditPart parent;

	private Request request;

	private IGraphicalEditPart host;

	/**
	 * Current mode @see #mode
	 */
	private Mode mode;



	/**
	 * 
	 * Command constructor.
	 * Create a command from to existing EditPart which exist at the time of the creation of the command
	 * 
	 * @param domain
	 *        editing domain
	 * @param label
	 *        command label
	 * @param parent
	 *        new parent edit part
	 * @param child
	 *        child edit part to reroute parent
	 */
	public ChangeGraphicalParentCommand(TransactionalEditingDomain domain, String label, EditPart parent, EditPart child, IGraphicalEditPart getHost) {
		super(domain, label, null);
		this.parent = parent;
		this.child = child;
		this.request = null;
		this.host = getHost;
		this.mode = Mode.NORMAL;
	}

	/**
	 * 
	 * Command constructor.
	 * Create a command from to existing EditPart which exist at the time of the creation of the command.
	 * In this constructor the request is needed if any translation has to be made (e.g {@link ChangeBoundsRequest} @see
	 * {@link XYLayoutEditGroupPolicy#getCommand(Request)}
	 * 
	 * @param domain
	 *        editing domain
	 * @param label
	 *        command label
	 * @param parent
	 *        new parent edit part
	 * @param child
	 *        child edit part to reroute parent
	 */
	public ChangeGraphicalParentCommand(TransactionalEditingDomain domain, String label, EditPart parent, EditPart child, IGraphicalEditPart getHost, Request request) {
		super(domain, label, null);
		this.parent = parent;
		this.child = child;
		this.request = request;
		this.host = getHost;
		this.mode = Mode.MOVE_PARENT;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param domain
	 *        editing domain
	 * @param label
	 *        command label
	 * @param request
	 *        Create element request to be able to find the IGraphicalEditPart of the create element
	 *        ( WARNING the IGraphicalEditPart has to be already created at the execution time of this command and it has to be have it's bounds set)
	 * @param child
	 *        IGraphicalEditPart of the child (has to be available a the creation time of the request)
	 */
	public ChangeGraphicalParentCommand(TransactionalEditingDomain domain, String label, CreateRequest request, EditPart child, IGraphicalEditPart getHost) {
		super(domain, label, null);
		this.parent = null;
		this.child = child;
		this.request = (CreateViewAndElementRequest)request;
		this.host = getHost;
		this.mode = Mode.CREATION_PARENT;
	}

	/**
	 * This command change the view of the parent and the child edit part to make all the changes needed.
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {
		//Get the IGraphical edit part of the old parent
		IGraphicalEditPart oldParentPart = (IGraphicalEditPart)child.getParent();
		Map<?, ?> editPartRegistry = getEditPartRegistery();
		if(editPartRegistry == null) {
			return CommandResult.newErrorCommandResult(CommandResultMessagesError.THE_EDIT_PART_REGISTERY_WAS_NOT_FOUND);
		}
		//Get the view of the new parent, old parent and the child
		// If the parent is null then check if the request is an creation request
		if(parent == null) {
			if(request instanceof CreateViewAndElementRequest) {
				//If true try to get the EditPart of the element in creation
				parent = getEditPartFromViewDescriptor((IGraphicalEditPart)child, (CreateViewAndElementRequest)request);
			}
		} else {
			parent = Utils.getCompartementEditPartFromMainEditPart(editPartRegistry, parent);
		}
		if(parent == null) {
			//If no parent is found then an error is thrown
			return CommandResult.newErrorCommandResult(CommandResultMessagesError.IGRAPHICAL_EDIT_PART_NOT_CREATED_YET);
		}
		View newParentView = (View)parent.getModel();
		View childView = (View)child.getModel();
		/*
		 * Translate the new node to the corresponding location in its new father.
		 */
		CommandResult cmdChangeCoordinate = changeCoordinateInNewFather(oldParentPart, childView);
		if(cmdChangeCoordinate != null) {
			return cmdChangeCoordinate;
		}
		newParentView.insertChild(childView);
		return CommandResult.newOKCommandResult();
	}

	/**
	 * This method will change the coordinate of the element on which we are changing it's parent.
	 * This method is not generic. It will handle differently if the command is came from a createRequest or the cahgneBounds request or without any
	 * request.
	 * This method should be reviewed later.(TODO)
	 * 
	 * @param oldParentPart
	 *        {@link IGraphicalEditPart} of the old paret
	 * @param childView
	 *        View of the child
	 * @return
	 */
	private CommandResult changeCoordinateInNewFather(IGraphicalEditPart oldParentPart, View childView) {
		/*
		 * Deleted because do not find the case where should it should be applied
		 * if(host != parent) {
		 */
		if(childView instanceof Node) {
			IFigure parentCompartmentFigure = ((AbstractGraphicalEditPart)parent).getFigure();
			/*
			 * If the change graphical parent come after a move
			 */
			if(Mode.MOVE_CHILD.equals(mode) || Mode.MOVE_PARENT.equals(mode)) {
				Rectangle newDimension = computeDeltaToChangeParent((IGraphicalEditPart)parent);
				LayoutConstraint layoutConstraint = ((Node)childView).getLayoutConstraint();
				if(layoutConstraint instanceof Location) {
					Location location = (Location)layoutConstraint;
					location.setX(newDimension.x);
					location.setY(newDimension.y);
				} else {
					return CommandResult.newErrorCommandResult("The layoutConstraint is not an instance of Location");
				}
				/*
				 * If the change come after a creation or after nothing
				 */
			} else if(Mode.CREATION_CHILD.equals(mode) || Mode.CREATION_PARENT.equals(mode) || Mode.NORMAL.equals(mode)) {
				/*
				 * Handle change graphical parent from a create request or with no request
				 * 1 - If the group in creation is the parent then
				 * 1.1 Used the Hack to force the figure to draw (in order to have it's position)
				 * 2 - Compute delta from computeDeltaToChangeParent
				 * 3 - Translate the location of the constraint
				 */
				Dimension newDimension;
				if(parentCompartmentFigure.getBounds().isEmpty()) {
					Rectangle oldBounds = parentCompartmentFigure.getBounds().getCopy();
					Point compLoc = emulateFigureCreation(parentCompartmentFigure);
					newDimension = Utils.computeDeltaToChangeParent(oldParentPart, (IGraphicalEditPart)parent.getParent());
					reajustNewDimensionIfNeeded(parentCompartmentFigure, compLoc, newDimension);
					parentCompartmentFigure.getBounds().setBounds(oldBounds);
				} else {
					newDimension = Utils.computeDeltaToChangeParent(oldParentPart, (IGraphicalEditPart)parent);
				}
				LayoutConstraint layoutConstraint = ((Node)childView).getLayoutConstraint();
				if(layoutConstraint instanceof Location) {
					Location location = (Location)layoutConstraint;
					Point newLocation = new Point(newDimension.width + location.getX(), newDimension.height + location.getY());
					location.setX(newLocation.x);
					location.setY(newLocation.y);
				} else {
					return CommandResult.newErrorCommandResult("The layoutConstraint is not an instance of Location");
				}
			}

		} else {
			/*
			 * Error in group framework usage
			 */
			return CommandResult.newErrorCommandResult("The new containing edit part should be compartment node. The extension point org.eclipse.papyrus.uml.diagram.common.groups.groupcontainment may have been incorrectly used.");
		}
		return null;
	}

	/**
	 * Compute the new rectangle of the child from the original position set in the request and with the newParent {@link IGraphicalEditPart}
	 * 
	 * @param newParent
	 *        {@link IGraphicalEditPart} of the new parent
	 * @return new rectangle of the child
	 */
	private Rectangle computeDeltaToChangeParent(IGraphicalEditPart newParent) {
		/*
		 * Get the absolute bound of a child
		 */
		Rectangle childAbsoluteRectangle = getChildAbsoluteBounds();
		if(childAbsoluteRectangle instanceof Rectangle) {
			IFigure newPartFigure = ((IGraphicalEditPart)parent).getContentPane();
			newPartFigure.translateToRelative(childAbsoluteRectangle);
			newPartFigure.translateFromParent(childAbsoluteRectangle);
			Point negatedLayoutOrigin = newPartFigure.getClientArea().getLocation().getNegated();
			childAbsoluteRectangle.performTranslate(negatedLayoutOrigin.x, negatedLayoutOrigin.y);
			/*
			 * Correct the position of the child in the parent if any @see getChildCorrectionFromParent
			 */
			Point negatedMoved = getChildCorrectionFromParent();
			childAbsoluteRectangle.performTranslate(negatedMoved.x, negatedMoved.y);
			return childAbsoluteRectangle;
		}

		return null;
	}

	/**
	 * Get the EditpartRegistery
	 * 
	 * @return Map if found null is not found
	 */
	private Map<?, ?> getEditPartRegistery() {
		Map<?, ?> editPartRegistry = null;
		//Check if the parent in valid compartment EditPart
		if(parent != null) {
			EditPartViewer parentViewer = parent.getViewer();
			if(parentViewer != null) {
				editPartRegistry = parentViewer.getEditPartRegistry();
			}
		}
		if(editPartRegistry == null && child != null && child.getViewer() != null) {
			editPartRegistry = child.getViewer().getEditPartRegistry();
		}
		return editPartRegistry;
	}


	/**
	 * Used to readjusts the coordinate of the child if the parentComptmentFigure is not well set yet.
	 * Used to hack the system if the editPart is not properly set
	 * 
	 * @param parentCompartmentFigure
	 *        The compartment figure of the parent
	 * @param compLoc
	 * @see {@link #emulateFigureCreation(IFigure)}
	 * @param correctionDimension
	 *        New {@link Dimension} which are going to modify in order to correctt the coordinatte of the child
	 */
	private void reajustNewDimensionIfNeeded(IFigure parentCompartmentFigure, Point compLoc, Dimension correctionDimension) {
		if(compLoc != null) {
			correctionDimension.shrink(compLoc.x + parentCompartmentFigure.getInsets().left, compLoc.y + parentCompartmentFigure.getInsets().top);
		}
	}

	/**
	 * Emulate the figure creation it's not already done. This allow the system to know the absolute solution even if the edit part of the parent is
	 * not yet finish
	 * 
	 * @return null is the figure is already done. Return the translation needed to take into account the child position in it's parent ( e.g
	 *         ActivityPartitionCompartement from its ActivityPartitionEditPart)
	 */
	private Point emulateFigureCreation(IFigure parentCompartmentFigure) {
		if(parentCompartmentFigure.getBounds().isEmpty()) {
			// layout parent node correctly to recover the correct location of compartment which has not been set previously
			IFigure parentNodeFigure = parentCompartmentFigure.getParent();
			if(parentNodeFigure != null) {
				IFigure grandParentFigure = parentNodeFigure.getParent();
				if(grandParentFigure != null) {
					grandParentFigure.getLayoutManager().layout(grandParentFigure);
				}
				parentNodeFigure.getLayoutManager().layout(parentNodeFigure);
			}
			Point compLoc = parentCompartmentFigure.getBounds().getLocation();
			return compLoc;
		}
		return null;

	}

	/**
	 * This method is going to get the edit part from the request.
	 * 1 - Get descriptors
	 * 2 - Get View (adapter)
	 * 3 - Get IGraphicalEditPart if it exists
	 * 
	 * @param anyPart
	 *        Any IGraphicalEditPart in order to get the EditPartRegistery
	 * @return true if it as found the edit part
	 */
	private EditPart getEditPartFromViewDescriptor(IGraphicalEditPart anyPart, CreateViewAndElementRequest _request) {

		EditPart result = null;
		Iterator<? extends CreateViewRequest.ViewDescriptor> descriptors = _request.getViewDescriptors().iterator();
		Map<?, ?> editPartRegistry = anyPart.getViewer().getEditPartRegistry();
		while(descriptors.hasNext()) {
			CreateViewRequest.ViewDescriptor descriptor = (CreateViewRequest.ViewDescriptor)descriptors.next();
			Object view = descriptor.getAdapter(View.class);
			if(view instanceof View) {
				View childView = (View)view;
				result = getCompartmentEditPartFromView(editPartRegistry, childView);
			}
		}
		return result;
	}

	/**
	 * Get a compartment editPart from a view and the editPartRegistery
	 * 
	 * @param editPartRegistry
	 *        EditPartRegistery
	 * @param view
	 *        View of the element we want to find the compartment
	 * @return the EdiPart of compartment and null if not found
	 */
	public EditPart getCompartmentEditPartFromView(Map<?, ?> editPartRegistry, View view) {
		EditPart resultCompartmentEditPart = null;
		Object editPartAux = editPartRegistry.get(view);
		if(editPartAux instanceof EditPart) {
			EditPart _editPart = (EditPart)editPartAux;
			resultCompartmentEditPart = Utils.getCompartementEditPartFromMainEditPart(editPartRegistry, _editPart);
		}
		return resultCompartmentEditPart;
	}



	public Mode getMode() {
		return mode;
	}


	public void setMode(Mode mode) {
		this.mode = mode;
	}

	/**
	 * Give the absolute rectangle of the child. (Depending of the mode)
	 * 
	 * @return {@link Rectangle} of the child
	 */
	private Rectangle getChildAbsoluteBounds() {
		Rectangle result = null;
		if(child instanceof IGraphicalEditPart) {
			switch(mode) {
			case MOVE_CHILD:
				if(request instanceof ChangeBoundsRequest) {
					Object _origineConstraint = request.getExtendedData().get(GroupRequestConstants.CONSTRAINT_AFTER_MOVING);
					if(_origineConstraint instanceof Rectangle) {
						result = (Rectangle)_origineConstraint;
					}
				}
				break;
			case MOVE_PARENT:
				result = Utils.getAbsoluteBounds((IGraphicalEditPart)child).getCopy();
				break;
			default:
				result = Utils.getAbsoluteBounds((IGraphicalEditPart)child).getCopy();
				break;
			}
		}
		return result;
	}

	/**
	 * Get the correction to be applied to the child in function of the mode
	 * 
	 * @return {@link Point} to translate the child
	 */
	private Point getChildCorrectionFromParent() {
		Point result = null;
		if(child instanceof IGraphicalEditPart) {
			switch(mode) {
			case MOVE_PARENT:
				result = ((ChangeBoundsRequest)request).getMoveDelta().getNegated();
				break;
			default:
				result = new Point(0, 0);
				break;
			}
		}
		return result;
	}


}
