/*******************************************************************************
 * Copyright (c) 2007-2009 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) – Initial API 
 * implementation.
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.activity.edit.commands;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.core.commands.AddCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.RemoveValueCommand;
import org.eclipse.papyrus.diagram.common.commands.RemoveValueRequest;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The Class AddChildToActivityPartitionCommand.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class AddChildToActivityPartitionCommand extends Command {

	/** The cc. */
	CompoundCommand cc = new CompoundCommand();

	/**
	 * Instantiates a new adds the child to activity partition command.
	 * 
	 * @param request
	 *            the request
	 * @param parent
	 *            the parent
	 */
	public AddChildToActivityPartitionCommand(ChangeBoundsRequest request, IAdaptable parent) {
		setLabel("Move child");
		List<EditPart> editParts = request.getEditParts();
		GraphicalEditPart parentEditPart = (GraphicalEditPart) parent.getAdapter(GraphicalEditPart.class);

		Command command = null;
		for (EditPart ep : editParts) {

			if (!(ep instanceof GraphicalEditPart)) {
				continue;
			}

			if (((GraphicalEditPart) ep).resolveSemanticElement() instanceof ActivityPartition) {
				command = getDeleteViewCommand((GraphicalEditPart) ep);
				if (command != null) {
					cc.add(command);
					command = getSetValueCommand(((GraphicalEditPart) ep).resolveSemanticElement(), parentEditPart.resolveSemanticElement());
					if (command != null) {
						cc.add(command);
					}
				}
				continue;
			}

			command = getAddCommand(ep, parentEditPart);
			if (command == null)
				continue;
			cc.add(command);

			command = getSetValueCommand(((View) ep.getModel()).getElement(), ((View) parentEditPart.getModel()).getElement());
			if (command != null) {
				cc.add(command);
			}

			command = getEdgesCommand(ep, parentEditPart);
			if (command != null) {
				cc.add(command);
			}

			command = getSetBoundsCommand(request, (GraphicalEditPart) ep, parentEditPart);
			if (command != null) {
				cc.add(command);
			}
		}
	}

	/**
	 * Gets the adds the command.
	 * 
	 * @param editPart
	 *            the edit part
	 * @param parent
	 *            the parent
	 * 
	 * @return the adds the command
	 */
	private Command getAddCommand(EditPart editPart, GraphicalEditPart parent) {
		EObject element = ((View) editPart.getModel()).getElement();

		if (element instanceof ActivityPartition || element instanceof ActivityNode || element instanceof OpaqueBehavior) {
			TransactionalEditingDomain domain = parent.getEditingDomain();
			IAdaptable parentAdaptable = (IAdaptable) parent.getAdapter(IAdaptable.class);
			IAdaptable childAdaptable = (IAdaptable) editPart.getAdapter(IAdaptable.class);

			if (parentAdaptable != null && childAdaptable != null && domain != null) {
				return new ICommandProxy(new AddCommand(domain, parentAdaptable, childAdaptable));
			}
		}

		return null;
	}

	private Command getDeleteViewCommand(GraphicalEditPart editPart) {
		if (editPart == null) {
			return null;
		}
		return new ICommandProxy(new DeleteCommand(editPart.getNotationView()));
	}

	/**
	 * Gets the sets the value command.
	 * 
	 * @param element
	 *            the element
	 * @param parent
	 *            the parent
	 * 
	 * @return the sets the value command
	 */
	private Command getSetValueCommand(EObject element, EObject parent) {
		EReference partitionReference = null, activityReference = null;
		Object partitionValue = null, activityValue = null;
		SetRequest partitionRequest = null, activityRequest = null;

		EList parentList;
		Command activityPartitionChildrenCommand = null;
		if (element instanceof ActivityNode) {
			activityReference = UMLPackage.eINSTANCE.getActivityNode_Activity();
			partitionReference = UMLPackage.eINSTANCE.getActivityNode_InPartition();

			parentList = new BasicEList();
			if (parent instanceof Activity) {
				partitionValue = parentList;
				activityValue = parent;
			} else if (parent instanceof ActivityPartition) {
				parentList.add(parent);
				partitionValue = parentList;
				activityValue = getActivityPartitionActivity(((ActivityPartition) parent));
			} else {
				return null;
			}
			partitionRequest = new SetRequest(element, partitionReference, parentList);
		} else if (element instanceof OpaqueBehavior) {
			return null;
		} else if (element instanceof ActivityPartition) {
			SetRequest setRequest1 = null;
			// SetRequest setRequest2 = null;
			activityReference = UMLPackage.eINSTANCE.getActivityGroup_InActivity();
			partitionReference = UMLPackage.eINSTANCE.getActivityPartition_SuperPartition();
			if (parent instanceof Activity) {
				setRequest1 = new SetRequest(element, activityReference, parent);
				// setRequest2 = new SetRequest(element, partitionReference, SetCommand.UNSET_VALUE);
			} else if (parent instanceof ActivityPartition) {
				// setRequest1 = new SetRequest(element, activityReference, SetCommand.UNSET_VALUE);
				setRequest1 = new SetRequest(element, partitionReference, parent);
			} else {
				return null;
			}
			Command setCommand = new ICommandProxy(new SetValueCommand(setRequest1));
			// if (setCommand != null) {
			// setCommand = setCommand.chain(new ICommandProxy(new SetValueCommand(setRequest2)));
			// }
			return setCommand;
		}

		activityRequest = new SetRequest(element, activityReference, activityValue);

		if (partitionRequest != null && activityRequest != null) {
			CompoundCommand cc = new CompoundCommand();
			cc.setLabel("Activity Hierarchy");

			cc.add(new ICommandProxy(new SetValueCommand(partitionRequest)));
			cc.add(new ICommandProxy(new SetValueCommand(activityRequest)));

			if (activityPartitionChildrenCommand != null) {
				cc.add(activityPartitionChildrenCommand);
			}

			return cc;
		}

		return null;
	}

	/**
	 * Gets the activity partition activity.
	 * 
	 * @param activityPartition
	 *            the activity partition
	 * 
	 * @return the activity partition activity
	 */
	private Activity getActivityPartitionActivity(ActivityPartition activityPartition) {
		if (activityPartition.getInActivity() != null) {
			return activityPartition.getInActivity();
		}

		ActivityPartition superPartition, actualPartition;

		superPartition = null;
		actualPartition = activityPartition;

		while ((superPartition = actualPartition.getSuperPartition()) != null) {
			actualPartition = superPartition;
		}

		return actualPartition.getInActivity();
	}

	/**
	 * Gets the sets the bounds command.
	 * 
	 * @param request
	 *            the request
	 * @param child
	 *            the child
	 * @param parent
	 *            the parent
	 * 
	 * @return the sets the bounds command
	 */
	private Command getSetBoundsCommand(ChangeBoundsRequest request, GraphicalEditPart child, GraphicalEditPart parent) {

		if (((View) child.getModel()).getElement() instanceof ActivityPartition) {
			Rectangle bounds = getActivityPartitionBounds(parent);
			if (bounds != null) {
				IAdaptable viewAdaptable = (IAdaptable) child.getAdapter(IAdaptable.class);
				return new ICommandProxy(new SetBoundsCommand(parent.getEditingDomain(), "Relocate ActivityPartition", viewAdaptable, bounds));
			}
		}

		Point point = request.getLocation().getCopy();
		Point localPoint = translateToLocal(parent, point);

		TransactionalEditingDomain domain = parent.getEditingDomain();
		IAdaptable childAdaptable = (IAdaptable) child.getAdapter(IAdaptable.class);

		SetBoundsCommand command = new SetBoundsCommand(domain, "Relocate childEditPart", childAdaptable, localPoint);
		return new ICommandProxy(command);
	}

	/**
	 * Gets the activity partition bounds.
	 * 
	 * @param parent
	 *            the parent
	 * 
	 * @return the activity partition bounds
	 */
	private Rectangle getActivityPartitionBounds(GraphicalEditPart parent) {
		List<GraphicalEditPart> sortedPartitions = SortActivitiesPartitionsByX(getAllActivityPartitions(parent));

		if (sortedPartitions.size() <= 0)
			return null;

		GraphicalEditPart last = sortedPartitions.get(sortedPartitions.size() - 1);
		Rectangle lastBounds = last.getFigure().getBounds();
		Rectangle bounds = new Rectangle();
		bounds.x = lastBounds.x + lastBounds.width;
		bounds.y = lastBounds.y;
		bounds.height = lastBounds.height;
		bounds.width = lastBounds.width <= 200 ? lastBounds.width : 200;

		return bounds;
	}

	/**
	 * Gets the all activity partitions.
	 * 
	 * @param apep
	 *            the apep
	 * 
	 * @return the all activity partitions
	 */
	private List<GraphicalEditPart> getAllActivityPartitions(GraphicalEditPart apep) {

		List<GraphicalEditPart> activities = new LinkedList<GraphicalEditPart>();
		for (Iterator<EditPart> it = apep.getChildren().iterator(); it.hasNext();) {
			EditPart ep = it.next();
			if (((View) ep.getModel()).getElement() instanceof ActivityPartition) {
				activities.add((GraphicalEditPart) ep);
			}
		}

		return activities;
	}

	/**
	 * Sort activities partitions by x.
	 * 
	 * @param activities
	 *            the activities
	 * 
	 * @return the list< graphical edit part>
	 */
	private List<GraphicalEditPart> SortActivitiesPartitionsByX(List<GraphicalEditPart> activities) {
		// Compare two ActivityPartitionEditParts by their x coordinate
		Comparator<GraphicalEditPart> comp = new Comparator<GraphicalEditPart>() {

			public int compare(GraphicalEditPart o1, GraphicalEditPart o2) {

				int o1x, o2x;
				o1x = o1.getFigure().getBounds().x;
				o2x = o2.getFigure().getBounds().y;

				if (o1x > o2x) {
					return 1;
				} else if (o1x < o2x) {
					return -1;
				}

				return 0;
			}

		};

		GraphicalEditPart[] activitiesArray = new GraphicalEditPart[activities.size()];
		activities.toArray(activitiesArray);

		Arrays.sort(activitiesArray, comp);

		List<GraphicalEditPart> sortedActivities = new LinkedList<GraphicalEditPart>();

		for (GraphicalEditPart ap : activitiesArray) {
			sortedActivities.add(ap);
		}

		return sortedActivities;
	}

	/**
	 * Translate to local.
	 * 
	 * @param part
	 *            the part
	 * @param location
	 *            the location
	 * 
	 * @return the point
	 */
	private Point translateToLocal(GraphicalEditPart part, Point location) {
		Point point = new Point();
		Point partPoint = part.getFigure().getBounds().getTopLeft().getCopy();
		part.getFigure().translateToAbsolute(partPoint);
		Rectangle partBounds = part.getFigure().getBounds();

		point.x = location.x - partPoint.x;
		point.y = location.y - partPoint.y;

		return point;
	}

	/**
	 * Gets the absolute location.
	 * 
	 * @param part
	 *            the part
	 * 
	 * @return the absolute location
	 */
	private Point getAbsoluteLocation(GraphicalEditPart part) {
		Point point = part.getFigure().getBounds().getTopLeft();

		GraphicalEditPart parent = null;
		if (part.getParent() instanceof GraphicalEditPart) {
			parent = (GraphicalEditPart) part.getParent();
		}

		if (parent != null) {
			Point parentPoint = getAbsoluteLocation(parent);
			Point myPoint = new Point(point.x + parentPoint.x, point.y + parentPoint.y);
			return myPoint;
		}

		return point;
	}

	/**
	 * Gets the edges command.
	 * 
	 * @param editPart
	 *            the edit part
	 * @param targetEP
	 *            the target ep
	 * 
	 * @return the edges command
	 */
	private Command getEdgesCommand(EditPart editPart, EditPart targetEP) {
		// source and target editParts -> model elements
		EObject element = ((View) editPart.getModel()).getElement();
		EObject target = ((View) targetEP.getModel()).getElement();
		EObject source = null;

		CompoundCommand ccommand = new CompoundCommand();

		// get source container
		if (element instanceof ActivityNode) {
			if (((ActivityNode) element).getInPartitions().size() > 0) {
				source = ((ActivityNode) element).getInPartitions().get(0);
			} else {
				source = ((ActivityNode) element).getActivity();
			}
		}

		ActivityNode anElement = (ActivityNode) element;

		// get all edges connected to this ActivityNode
		EList<ActivityEdge> edges = new BasicEList<ActivityEdge>();
		edges.addAll(anElement.getIncomings());
		edges.addAll(anElement.getOutgoings());

		// no edges means no command
		if (edges.size() <= 0) {
			return null;
		}

		// remove al edges related to this node from source container
		if (source instanceof ActivityPartition) {
			Command command = removeEdgesFromSource(edges, (ActivityPartition) source);
			if (command != null) {
				ccommand.add(command);
			}
		}

		// remove all edges related to this node from target container
		if (target instanceof ActivityPartition) {
			Command command = removeEdgesFromSource(edges, (ActivityPartition) target);
			if (command != null) {
				ccommand.add(command);
			}
		}

		// add appliable edges to target container
		EList<ActivityEdge> edgesToAddToTarget = new BasicEList<ActivityEdge>();

		// incoming edges
		EList<ActivityEdge> edgesIncoming = anElement.getIncomings();
		for (ActivityEdge e : edgesIncoming) {
			ActivityNode sourceObject = e.getSource();
			EObject parent = null;
			if (sourceObject.getInPartitions().size() > 0) {
				parent = sourceObject.getInPartitions().get(0);
			} else {
				parent = sourceObject.getActivity();
			}

			if (parent != target) {
				if (parent != null && parent instanceof ActivityPartition) {
					SetRequest request = new SetRequest(parent, UMLPackage.eINSTANCE.getActivityPartition_Edge(), e);
					SetValueCommand command = new SetValueCommand(request);
					ccommand.add(new ICommandProxy(command));
				}
				if (target != null && target instanceof ActivityPartition) {
					SetRequest request = new SetRequest(target, UMLPackage.eINSTANCE.getActivityPartition_Edge(), e);
					SetValueCommand command = new SetValueCommand(request);
					ccommand.add(new ICommandProxy(command));
				}
			}
		}

		// outgoing edges
		EList<ActivityEdge> edgesOutgoing = anElement.getOutgoings();
		for (ActivityEdge e : edgesOutgoing) {
			ActivityNode targetObject = e.getTarget();
			EObject parent = null;
			if (targetObject.getInPartitions().size() > 0) {
				parent = targetObject.getInPartitions().get(0);
			} else {
				parent = targetObject.getActivity();
			}

			if (parent != target) {
				if (parent != null && parent instanceof ActivityPartition) {
					SetRequest request = new SetRequest(parent, UMLPackage.eINSTANCE.getActivityPartition_Edge(), e);
					SetValueCommand command = new SetValueCommand(request);
					ccommand.add(new ICommandProxy(command));
				}
				if (target != null && target instanceof ActivityPartition) {
					SetRequest request = new SetRequest(target, UMLPackage.eINSTANCE.getActivityPartition_Edge(), e);
					SetValueCommand command = new SetValueCommand(request);
					ccommand.add(new ICommandProxy(command));
				}
			}
		}

		return ccommand;
	}

	/**
	 * Removes the edges from source.
	 * 
	 * @param edges
	 *            the edges
	 * @param source
	 *            the source
	 * 
	 * @return the command
	 */
	private Command removeEdgesFromSource(EList<ActivityEdge> edges, ActivityPartition source) {

		if (edges.size() <= 0) {
			return null;
		}

		EList<ActivityEdge> sourceEdges = source.getEdges();
		EReference reference = UMLPackage.eINSTANCE.getActivityPartition_Edge();

		RemoveValueRequest request = new RemoveValueRequest(source, reference, edges);
		RemoveValueCommand command = new RemoveValueCommand(request);

		return new ICommandProxy(command);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return cc.canExecute();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canUndo()
	 */
	@Override
	public boolean canUndo() {
		return cc.canUndo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#chain(org.eclipse.gef.commands.Command)
	 */
	@Override
	public Command chain(Command command) {
		cc.chain(command);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#dispose()
	 */
	@Override
	public void dispose() {
		cc.dispose();
		super.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		cc.execute();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	@Override
	public void redo() {
		cc.redo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		cc.undo();
	}

}
