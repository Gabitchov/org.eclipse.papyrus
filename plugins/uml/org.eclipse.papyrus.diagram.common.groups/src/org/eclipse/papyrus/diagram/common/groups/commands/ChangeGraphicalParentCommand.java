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
package org.eclipse.papyrus.diagram.common.groups.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.groups.core.utils.Utils;

/**
 * This command change the graphical parent of an edit part.
 * 
 * @author adaussy
 * 
 */
public class ChangeGraphicalParentCommand extends AbstractTransactionalCommand {

	/** child part */
	private EditPart child;

	/** parent part */
	private EditPart parent;

	private CreateViewAndElementRequest request;



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
	public ChangeGraphicalParentCommand(TransactionalEditingDomain domain, String label, EditPart parent, EditPart child) {
		super(domain, label, null);
		this.parent = parent;
		this.child = child;
		this.request = null;
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
	public ChangeGraphicalParentCommand(TransactionalEditingDomain domain, String label, CreateRequest request, EditPart child) {
		super(domain, label, null);
		this.parent = null;
		this.child = child;
		this.request = (CreateViewAndElementRequest)request;
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
		//Get the view of the new parent, old parent and the child
		if(parent == null) {
			parent = getEditPartFromViewDescriptor((IGraphicalEditPart)child, request);
			if (parent == null)
			{
				return CommandResult.newErrorCommandResult("The IGraphicalEditPart of the parent is not created yet");
			}	
		} else {
			parent = getCompartementEditPartFromMainEditPart(child.getViewer().getEditPartRegistry(), parent);
		}
		View newParentView = (View)parent.getModel();
		View childView = (View)child.getModel();


		/*
		 * Translate the new node to the corresponding location in its new father.
		 */

		if(childView instanceof Node) {
			/*
			 * FIXME Try to find another way without a hack.
			 * Problem:
			 * If the parent EditPart is not fully created the Utils.computeDeltaToChangeParent do not succeed in computing the newDimension because
			 * it did not succeed in calculating it's absolute bound. So emulateFigureCreation force the figure to be created before it's normally.
			 * Moreover the Utils.computeDeltaToChangeParent still can not compute the absolute bound of the parent.
			 */
			IFigure parentCompartmentFigure = ((AbstractGraphicalEditPart)parent).getFigure();
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
				location.setX(location.getX() + newDimension.width);
				location.setY(location.getY() + newDimension.height);
			} else {
				return CommandResult.newErrorCommandResult("The layoutConstraint is not an instance of Location");
			}
		} else {
			// error in group framework usage
			return CommandResult.newErrorCommandResult("The new containing edit part should be compartment node. The extension point org.eclipse.papyrus.diagram.common.groups.groupcontainment may have been incorrectly used.");
		}
		newParentView.insertChild(childView);
		return CommandResult.newOKCommandResult();
	}

	private void reajustNewDimensionIfNeeded(IFigure parentCompartmentFigure, Point compLoc, Dimension newDimension) {
		if(compLoc != null) {
			newDimension.shrink(compLoc.x + parentCompartmentFigure.getInsets().left, compLoc.y + parentCompartmentFigure.getInsets().top);
		}
	}

	/**
	 * Emulate the figure creation it's not already done. This allow the system to know the absolute solution even if the edit part of the parent is
	 * not yet finish
	 * 
	 * @return null is the figure is already done. Return the translation needed to take care of the child position in it's parent ( e.g
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
	private EditPart getEditPartFromViewDescriptor(IGraphicalEditPart anyPart,CreateViewAndElementRequest _request) {
		
		EditPart result = null;
		Iterator<? extends CreateViewRequest.ViewDescriptor> descriptors = _request.getViewDescriptors().iterator();
		Map editPartRegistry = anyPart.getViewer().getEditPartRegistry();
		while(descriptors.hasNext()) {
			CreateViewRequest.ViewDescriptor descriptor = (CreateViewRequest.ViewDescriptor)descriptors.next();
			Object view = descriptor.getAdapter(View.class);
			if(view instanceof View) {
				View childView = (View)view;
				result = getCompartmentEditPartFromView(editPartRegistry,childView);
			}
		}
		return result;
	}
	
	/**
	 * Get a compartment editPart from a view and the editPartRegistery
	 * @param editPartRegistry EditPartRegistery
	 * @param view View of the element we want to find the compartment
	 * @return the EdiPart of compartment and null if not found
	 */
	public EditPart getCompartmentEditPartFromView(Map editPartRegistry, View view){
		EditPart resultCompartmentEditPart = null;
		Object editPartAux = editPartRegistry.get(view);
		if(editPartAux instanceof EditPart) {
			EditPart _editPart = (EditPart)editPartAux;
			resultCompartmentEditPart = getCompartementEditPartFromMainEditPart(editPartRegistry, _editPart);
		}
		return resultCompartmentEditPart;
	}
	
	/**
	 * Get the compartment editPart from a parent editPart
	 * @param editPartRegistry EditPartRegistery
	 * @param parentEditPart EditPart of the parent
	 * @return the CompartementEditPart and null if not found
	 */
	private EditPart getCompartementEditPartFromMainEditPart (Map editPartRegistry,EditPart parentEditPart){
		EditPart resultCompartmentEditPart = null;
		//An edit part has been found
		if(parentEditPart instanceof CompartmentEditPart) {
			resultCompartmentEditPart = parentEditPart;
			return resultCompartmentEditPart;
		} else {
			List<EditPart> potentialCompartementPart = new ArrayList<EditPart>();
			for(Object _child : parentEditPart.getChildren()) {
				if(isAGoodCompartementEditPart(editPartRegistry, _child)) {
					potentialCompartementPart.add((EditPart)_child);
				}
			}
			if(potentialCompartementPart.size() == 1) {
				resultCompartmentEditPart = potentialCompartementPart.get(0);
				return resultCompartmentEditPart;
			} else if(potentialCompartementPart.size() == 1) {
				//FIXME find a correct behavior if several potentialCompartementPart  (should normally never be the case
				resultCompartmentEditPart = potentialCompartementPart.get(0);
				return resultCompartmentEditPart;
			}
		}
		return resultCompartmentEditPart;
	}

	/**
	 * Test is the element is a compartment edit part that can be used to create the child
	 * @param editPartRegistry
	 * @param _child
	 * @return
	 */
	private boolean isAGoodCompartementEditPart(Map editPartRegistry, Object _child) {
		return _child instanceof CompartmentEditPart && isContainedInRegistery(editPartRegistry, _child) && ((EditPart)_child) instanceof ShapeCompartmentEditPart;
	}

	/**
	 * 
	 * @param editPartRegistry
	 *        Check if the object is contained in the editPartRegistery
	 * @param _child
	 * @return
	 */
	private boolean isContainedInRegistery(Map editPartRegistry, Object _child) {
		if(_child instanceof EditPart) {
			return editPartRegistry.containsKey((View)((EditPart)_child).getModel());
		}
		return false;

	}
}
