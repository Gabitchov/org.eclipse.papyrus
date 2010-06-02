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
package org.eclipse.papyrus.diagram.common.groups.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.groups.core.GroupNotificationBuilderFactory.NotificationBuilderAndResultingCommand;
import org.eclipse.papyrus.diagram.common.groups.core.groupcontainment.GroupContainmentRegistry;
import org.eclipse.papyrus.diagram.common.groups.core.ui.ChooseContainedElementsCreator;
import org.eclipse.papyrus.diagram.common.groups.core.utils.Utils;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.ui.toolbox.notification.INotification;


public class GroupManagementListener extends ResourceSetListenerImpl {

	/** the diagram edit part to recover other edit parts */
	private DiagramEditPart diagramPart = null;

	/**
	 * Constructor.
	 * 
	 * @param diagramEditPart
	 *        the diagram edit part in which groups must be managed
	 */
	public GroupManagementListener(DiagramEditPart diagramEditPart) {
		diagramPart = diagramEditPart;
	}

	/**
	 * Complete the transaction which is about to commit with the group management.
	 * 
	 * @see org.eclipse.emf.transaction.ResourceSetListenerImpl#transactionAboutToCommit(org.eclipse.emf.transaction.ResourceSetChangeEvent)
	 * 
	 * @param event
	 *        event about to commit
	 * @return the command to add group management
	 * @throws RollbackException
	 */
	@Override
	public Command transactionAboutToCommit(ResourceSetChangeEvent event) throws RollbackException {
		CompoundCommand globalCmd = new CompoundCommand();
		handleMovedContainedParts(globalCmd, event);
		handleMovedGroup(globalCmd, event);
		if(!globalCmd.isEmpty() && globalCmd.canExecute()) {
			return globalCmd;
		} else {
			return null;
		}
	}

	/**
	 * Complete globalCmd to handle moved groups and changing their children
	 * 
	 * @param globalCmd
	 *        the command to complete
	 * @param event
	 *        the change event
	 * @return globalCmd for convenience
	 */
	private CompoundCommand handleMovedGroup(CompoundCommand globalCmd, ResourceSetChangeEvent event) {
		/*
		 * Detect which groups are moved.
		 * A group has moved if one of these two condition is met:
		 * - (1) Its graphical container has changed.
		 * - (2) Its bounds have changed and it is in the area of different groups.
		 * Find its children and :
		 * - (A) Update the group to child reference for this group,
		 * - (B) Update the group to child reference for children moved with it,
		 * - (C) Open a notification to know whether new children must be graphically contained.
		 */
		Map<IGraphicalEditPart, List<IGraphicalEditPart>> movedPartsAndChildren = new HashMap<IGraphicalEditPart, List<IGraphicalEditPart>>();
		// this map stores the old and new bounds to detect children
		Map<IGraphicalEditPart, List<Rectangle>> movedPartsAndBounds = new HashMap<IGraphicalEditPart, List<Rectangle>>();
		for(Notification notification : event.getNotifications()) {
			// (1) detect graphical container change
			updateBoundsOfPartWhichContainerChanges(movedPartsAndBounds, notification);
			// (2) detect move and update bounds changes
			Object notifier = notification.getNotifier();
			if(notifier instanceof Bounds) {
				// get moved edit part
				View view = ViewUtil.getViewContainer((Bounds)notifier);
				if(view != null) {
					updateBoundsChange(movedPartsAndBounds, view, notification, false);
				}
			}
		}
		// (1) (2) among moved parts, find which are groups with a change of children
		for(IGraphicalEditPart editPart : movedPartsAndBounds.keySet()) {
			// get list of parents according to new and old locations
			Rectangle oldArea = movedPartsAndBounds.get(editPart).get(0);
			List<IGraphicalEditPart> oldChildren = Utils.findPossibleChildren(oldArea, editPart, diagramPart);
			Rectangle newArea = movedPartsAndBounds.get(editPart).get(1);
			List<IGraphicalEditPart> newChildren = Utils.findPossibleChildren(newArea, editPart, diagramPart);
			List<IGraphicalEditPart> removedChildren = new ArrayList<IGraphicalEditPart>(oldChildren);
			removedChildren.removeAll(newChildren);
			List<IGraphicalEditPart> addedChildren = new ArrayList<IGraphicalEditPart>(newChildren);
			addedChildren.removeAll(oldChildren);

			// we have to update the graphical container when the list of parents has changed
			if(addedChildren.size() != 0 || removedChildren.size() != 0) {
				movedPartsAndChildren.put((IGraphicalEditPart)editPart, newChildren);
				// (A) Update the group to child reference
				updateChildReferences(globalCmd, editPart, addedChildren, removedChildren);
			}
			// (B) explore children moved with it to update their parent groups
			for(Object childPart : editPart.getChildren()) {
				// get list of parents according to new and old locations
				if(childPart instanceof IGraphicalEditPart) {
					IGraphicalEditPart movedChildPart = (IGraphicalEditPart)childPart;
					Rectangle oldChildBounds = movedChildPart.getFigure().getBounds().getCopy();
					movedChildPart.getFigure().translateToAbsolute(oldChildBounds);
					// compute new child bounds with area difference
					Rectangle newChildBounds = oldChildBounds.getCopy();
					newChildBounds.translate(newArea.getLocation()).translate(oldArea.getLocation().getNegated());
					// ensure moved graphical container is in both parent lists
					List<IGraphicalEditPart> oldParents = Utils.findPossibleParents(oldChildBounds, diagramPart);
					oldParents.add(editPart);
					List<IGraphicalEditPart> newParents = Utils.findPossibleParents(newChildBounds, diagramPart);
					newParents.add(editPart);
					List<IGraphicalEditPart> removedParents = new ArrayList<IGraphicalEditPart>(oldParents);
					removedParents.removeAll(newParents);
					List<IGraphicalEditPart> addedParents = new ArrayList<IGraphicalEditPart>(newParents);
					addedParents.removeAll(oldParents);
					// we have to update the graphical container when the list of parents has changed
					if(addedParents.size() != 0 || removedParents.size() != 0) {
						// Update the group to child reference
						updateParentReferences(globalCmd, editPart, addedParents, removedParents);
					}
				}
			}
		}
		//(C) Then open a notification for each group to know their children.
		for(Entry<IGraphicalEditPart, List<IGraphicalEditPart>> partAndNewChildren : movedPartsAndChildren.entrySet()) {
			// complete with merging old notifications
			PendingGroupNotificationsManager man = PendingGroupNotificationsManager.getInstanceForDiagram(diagramPart);
			if(man != null) {
				IGraphicalEditPart group = partAndNewChildren.getKey();
				man.removeChooseChildrenNotification(group);
				List<IGraphicalEditPart> children = partAndNewChildren.getValue();
				if(!children.isEmpty()) {
					// run the notification build for all modified parts
					NotificationBuilderAndResultingCommand builder = GroupNotificationBuilderFactory.getChooseChildrenBuilder(group, children);
					// check if notification opening can be skipped
					boolean skip = false;
					if(builder.getCreator() instanceof ChooseContainedElementsCreator) {
						skip = !((ChooseContainedElementsCreator)builder.getCreator()).needToOpen();
					}
					if(!skip) {
						INotification notification = builder.getBuilder().run();
						man.storeNotification(builder.getCreator(), notification);
					}
					// in case the notification is immediately answered (synchronous notification) or is skipped
					Command cmd = builder.getResultingCommand();
					if(cmd != null && cmd.canExecute()) {
						globalCmd.append(cmd);
					}
				}
			}
		}
		return globalCmd;
	}

	/**
	 * Complete globalCmd to handle moved parts which can be contained by groups
	 * 
	 * @param globalCmd
	 *        the command to complete
	 * @param event
	 *        the change event
	 * @return globalCmd for convenience
	 */
	private CompoundCommand handleMovedContainedParts(CompoundCommand globalCmd, ResourceSetChangeEvent event) {
		/*
		 * Detect which parts have moved (from a group point of view) (as keys),
		 * And which are their new parents (as values).
		 * A part has moved if one of these two condition is met:
		 * - (1) Its graphical container has changed.
		 * - (2) Its bounds have changed and it is in the area of different groups.
		 * In such cases :
		 * - (A) Update the group to child reference,
		 * - (B) Then open a common notification.
		 */
		Map<IGraphicalEditPart, List<IGraphicalEditPart>> movedPartsAndParents = new HashMap<IGraphicalEditPart, List<IGraphicalEditPart>>();
		// this map stores the old and new bounds to detect (2)
		Map<IGraphicalEditPart, List<Rectangle>> movedPartsAndBounds = new HashMap<IGraphicalEditPart, List<Rectangle>>();
		// inspect event's notifications
		for(Notification notification : event.getNotifications()) {
			// (1) detect graphical container change
			updateBoundsOfPartWhichContainerChanges(movedPartsAndBounds, notification);
			// (2) detect move and update bounds changes
			Object notifier = notification.getNotifier();
			if(notifier instanceof Bounds) {
				// get moved edit part
				View view = ViewUtil.getViewContainer((Bounds)notifier);
				if(view != null) {
					updateBoundsChange(movedPartsAndBounds, view, notification, true);
				}
			}
		}
		// (1) (2) among moved parts, find which have changed their group area
		for(IGraphicalEditPart editPart : movedPartsAndBounds.keySet()) {
			// get list of parents according to new and old locations
			List<IGraphicalEditPart> oldParents = Utils.findPossibleParents(movedPartsAndBounds.get(editPart).get(0), diagramPart);
			List<IGraphicalEditPart> newParents = Utils.findPossibleParents(movedPartsAndBounds.get(editPart).get(1), diagramPart);
			List<IGraphicalEditPart> removedParents = new ArrayList<IGraphicalEditPart>(oldParents);
			removedParents.removeAll(newParents);
			List<IGraphicalEditPart> addedParents = new ArrayList<IGraphicalEditPart>(newParents);
			addedParents.removeAll(oldParents);

			// we have to update the graphical container when the list of parents has changed
			if(addedParents.size() != 0 || removedParents.size() != 0) {
				movedPartsAndParents.put((IGraphicalEditPart)editPart, newParents);
				// (A) Update the group to child reference
				updateParentReferences(globalCmd, editPart, addedParents, removedParents);
			}
		}


		//(B) Then open a common notification.
		if(!movedPartsAndParents.isEmpty()) {
			// complete with merging old notifications
			PendingGroupNotificationsManager man = PendingGroupNotificationsManager.getInstanceForDiagram(diagramPart);
			if(man != null) {
				man.updateParentAssignementsMap(movedPartsAndParents);
				if(!movedPartsAndParents.isEmpty()) {
					// run the notification build for all modified parts
					NotificationBuilderAndResultingCommand builder = GroupNotificationBuilderFactory.getChooseParentBuilder(movedPartsAndParents);
					INotification notification = builder.getBuilder().run();
					man.storeNotification(builder.getCreator(), notification);
					// in case the notification is immediately answered (synchronous notification)
					Command cmd = builder.getResultingCommand();
					if(cmd != null && cmd.canExecute()) {
						globalCmd.append(cmd);
					}
				}
			}
		}
		return globalCmd;
	}

	/**
	 * Complete the map to add parts which graphical container has changed, inserting their old or new bounds
	 * 
	 * @param movedPartsAndBounds
	 *        the map to update
	 * @param notification
	 *        the notification to inspect
	 */
	private void updateBoundsOfPartWhichContainerChanges(Map<IGraphicalEditPart, List<Rectangle>> movedPartsAndBounds, Notification notification) {
		Entry<IGraphicalEditPart, IGraphicalEditPart> newContainerChange = getMovedPartAndItsNewContainer(notification);
		Entry<IGraphicalEditPart, IGraphicalEditPart> oldContainerChange = getMovedPartAndItsOldContainer(notification);
		if(newContainerChange != null) {
			addBoundsToMapWithChangedBounds(movedPartsAndBounds, newContainerChange.getKey(), newContainerChange.getValue(), true);
		}
		if(oldContainerChange != null) {
			addBoundsToMapWithChangedBounds(movedPartsAndBounds, oldContainerChange.getKey(), oldContainerChange.getValue(), false);
		}
	}

	/**
	 * Add the compute bounds in the map containing old and new bounds of moved parts.
	 * 
	 * @param movedPartsAndBounds
	 *        the map to add a bounds value in
	 * @param movedPart
	 *        the moved part (key of the map)
	 * @param container
	 *        the graphical container of the moved part (old or new)
	 * @param isNewBounds
	 *        if true, new bounds are added and container is the new container, otherwise, old bounds are added and container is the old container
	 */
	private void addBoundsToMapWithChangedBounds(Map<IGraphicalEditPart, List<Rectangle>> movedPartsAndBounds, IGraphicalEditPart movedPart, IGraphicalEditPart container, boolean isNewBounds) {
		if(!movedPartsAndBounds.containsKey(movedPart)) {
			// store a key with default values
			List<Rectangle> oldAndNewBounds = new ArrayList<Rectangle>(2);
			movedPartsAndBounds.put(movedPart, oldAndNewBounds);
			oldAndNewBounds.add(0, new Rectangle());
			oldAndNewBounds.add(1, new Rectangle());
		}
		Rectangle bounds = movedPart.getFigure().getBounds().getCopy();
		movedPart.getFigure().translateToAbsolute(bounds);
		//bounds.translate(container.getFigure().getBounds().getLocation());
		int indexOfBounds = 0;
		if(isNewBounds) {
			indexOfBounds = 1;
		}
		movedPartsAndBounds.get(movedPart).set(indexOfBounds, bounds);
	}

	/**
	 * Update the model references from parent groups to their children (through the command, not immediately)
	 * 
	 * @param globalCmdToUpdate
	 *        the command to update
	 * @param childEditPart
	 *        the child edit part
	 * @param addedParents
	 *        the new parents which did not have parent reference
	 * @param removedParents
	 *        the old parents which no longer have parent reference
	 */
	private void updateParentReferences(CompoundCommand globalCmdToUpdate, IGraphicalEditPart childEditPart, List<IGraphicalEditPart> addedParents, List<IGraphicalEditPart> removedParents) {
		// update by adding new references
		for(IGraphicalEditPart newParent : addedParents) {
			if(!GroupContainmentRegistry.isContainerModel(newParent)) {
				Command cmd = Utils.getAddReferenceToChildCmd(newParent, childEditPart);
				if(cmd != null && cmd.canExecute()) {
					globalCmdToUpdate.append(cmd);
				}
			}
		}
		// update by removing old references
		for(IGraphicalEditPart oldParent : removedParents) {
			if(!GroupContainmentRegistry.isContainerModel(oldParent)) {
				Command cmd = Utils.getRemoveReferenceToChildCmd(oldParent, childEditPart);
				if(cmd != null && cmd.canExecute()) {
					globalCmdToUpdate.append(cmd);
				}
			}
		}
		// model container references are automatically managed, since there is only one
	}

	/**
	 * Update the model references from parent groups to their children (through the command, not immediately)
	 * 
	 * @param globalCmdToUpdate
	 *        the command to update
	 * @param parentEditPart
	 *        the parent edit part
	 * @param addedChildren
	 *        the new children which were not referenced
	 * @param removedChildren
	 *        the old children which are no longer referenced
	 */
	private void updateChildReferences(CompoundCommand globalCmdToUpdate, IGraphicalEditPart parentEditPart, List<IGraphicalEditPart> addedChildren, List<IGraphicalEditPart> removedChildren) {
		// update by adding new references
		for(IGraphicalEditPart newChild : addedChildren) {
			// handle the addition to a container the same way as by reference (containment updated automatically)
			Command cmd = Utils.getAddReferenceToChildCmd(parentEditPart, newChild);
			if(cmd != null && cmd.canExecute()) {
				globalCmdToUpdate.append(cmd);
			}
		}
		// update by removing old references
		for(IGraphicalEditPart oldChild : removedChildren) {
			if(!GroupContainmentRegistry.isContainerModel(parentEditPart)) {
				Command cmd = Utils.getRemoveReferenceToChildCmd(parentEditPart, oldChild);
				if(cmd != null && cmd.canExecute()) {
					globalCmdToUpdate.append(cmd);
				}
			} else {
				// handle child reassignment in nearest parent
				EObject child = oldChild.resolveSemanticElement();
				EObject parentOfGroup = parentEditPart.resolveSemanticElement().eContainer();
				EReference feat = Utils.getBestReferenceAmongList(parentOfGroup.eClass().getEAllContainments(), child);
				while(feat == null && parentOfGroup != null) {
					parentOfGroup = parentOfGroup.eContainer();
					feat = Utils.getBestReferenceAmongList(parentOfGroup.eClass().getEAllContainments(), child);
				}
				if(feat != null) {
					Command cmd = new AddCommand(oldChild.getEditingDomain(), parentOfGroup, feat, oldChild.resolveSemanticElement());
					if(cmd != null && cmd.canExecute()) {
						globalCmdToUpdate.append(cmd);
					}
				}
			}
		}
		// model container references are automatically managed, since there is only one
	}

	/**
	 * Update the map of the moved parts and its old and new bounds
	 * 
	 * @param movedPartsAndBounds
	 *        the map to update
	 * @param view
	 *        the moved view
	 * @param notification
	 *        the notification which tells how the view is moved
	 * @param checkParentIsGroupInsteadOfIsGroup
	 *        if true, check that view has a parent corresponding to a group, otherwise, check that view correspond to a group
	 */
	private void updateBoundsChange(Map<IGraphicalEditPart, List<Rectangle>> movedPartsAndBounds, View view, Notification notification, boolean checkParentIsGroupInsteadOfIsGroup) {
		IGraphicalEditPart editPart = null;
		// check that moved edit part is concerned by the group framework
		boolean groupFramework = false;
		if(checkParentIsGroupInsteadOfIsGroup) {
			EditPart uncheckedEditPart = DiagramEditPartsUtil.getEditPartFromView(view, diagramPart);
			if(uncheckedEditPart instanceof IGraphicalEditPart) {
				editPart = (IGraphicalEditPart)uncheckedEditPart;
				EditPart uncheckedParentPart = editPart.getParent();
				if(uncheckedParentPart instanceof IGraphicalEditPart) {
					IGraphicalEditPart parentPart = (IGraphicalEditPart)uncheckedParentPart;
					groupFramework = GroupContainmentRegistry.isContainerConcerned(parentPart);
				}
			}
		} else {
			editPart = GroupContainmentRegistry.getGroupContainingPartFromView(view, diagramPart);
			groupFramework = GroupContainmentRegistry.isContainerConcerned(editPart);
		}

		if(groupFramework) {
			if(notification.getNotifier() instanceof Bounds) {
				// store the edit part and its bounds in the map
				Bounds bNotif = ((Bounds)notification.getNotifier());
				if(!movedPartsAndBounds.containsKey(editPart)) {
					List<Rectangle> oldAndNewBounds = new ArrayList<Rectangle>(2);
					movedPartsAndBounds.put(editPart, oldAndNewBounds);
					// store initial bounds (except they have already been modified)
					Rectangle bounds = new Rectangle(bNotif.getX(), bNotif.getY(), bNotif.getWidth(), bNotif.getHeight());
					editPart.getFigure().translateToAbsolute(bounds);
					movedPartsAndBounds.get(editPart).add(0, bounds);
					// store new bounds 
					Rectangle newBounds = new Rectangle(bounds);
					oldAndNewBounds.add(1, newBounds);

				}
				// update initial bounds with notification's difference
				if(NotationPackage.Literals.SIZE__HEIGHT.equals(notification.getFeature())) {
					movedPartsAndBounds.get(editPart).get(0).height += notification.getOldIntValue() - notification.getNewIntValue();
				}
				if(NotationPackage.Literals.SIZE__WIDTH.equals(notification.getFeature())) {
					movedPartsAndBounds.get(editPart).get(0).width += notification.getOldIntValue() - notification.getNewIntValue();
				}
				if(NotationPackage.Literals.LOCATION__X.equals(notification.getFeature())) {
					movedPartsAndBounds.get(editPart).get(0).x += notification.getOldIntValue() - notification.getNewIntValue();
				}
				if(NotationPackage.Literals.LOCATION__Y.equals(notification.getFeature())) {
					movedPartsAndBounds.get(editPart).get(0).y += notification.getOldIntValue() - notification.getNewIntValue();
				}
			}
		}
	}

	/**
	 * In case the notification correspond to an edit part addition to another, return a result
	 * 
	 * @param notification
	 *        the notification to inspect
	 * @return the added part and its new container
	 */
	private Entry<IGraphicalEditPart, IGraphicalEditPart> getMovedPartAndItsNewContainer(Notification notification) {
		// detect a graphical container change
		if(NotationPackage.eINSTANCE.getView_PersistedChildren().equals(notification.getFeature())) {
			int eventType = notification.getEventType();
			if(Notification.ADD == eventType || Notification.ADD_MANY == eventType) {
				Object newContainer = notification.getNotifier();
				Object newContainerPart = diagramPart.getViewer().getEditPartRegistry().get(newContainer);
				Object newChild = notification.getNewValue();
				Object newChildPart = diagramPart.getViewer().getEditPartRegistry().get(newChild);
				if(newChildPart instanceof IGraphicalEditPart && newContainerPart instanceof IGraphicalEditPart) {
					Map<IGraphicalEditPart, IGraphicalEditPart> singleton = Collections.singletonMap((IGraphicalEditPart)newChildPart, (IGraphicalEditPart)newContainerPart);
					return singleton.entrySet().iterator().next();
				}
			}
		}
		return null;
	}

	/**
	 * In case the notification correspond to an edit part removal from another, return a result
	 * 
	 * @param notification
	 *        the notification to inspect
	 * @return the removed part and its old container
	 */
	private Entry<IGraphicalEditPart, IGraphicalEditPart> getMovedPartAndItsOldContainer(Notification notification) {
		// detect a graphical container change
		if(NotationPackage.eINSTANCE.getView_PersistedChildren().equals(notification.getFeature())) {
			int eventType = notification.getEventType();
			if(Notification.REMOVE == eventType || Notification.REMOVE_MANY == eventType) {
				Object oldContainer = notification.getNotifier();
				Object oldContainerPart = diagramPart.getViewer().getEditPartRegistry().get(oldContainer);
				Object oldChild = notification.getOldValue();
				Object oldChildPart = diagramPart.getViewer().getEditPartRegistry().get(oldChild);
				if(oldChildPart instanceof IGraphicalEditPart && oldContainerPart instanceof IGraphicalEditPart) {
					Map<IGraphicalEditPart, IGraphicalEditPart> singleton = Collections.singletonMap((IGraphicalEditPart)oldChildPart, (IGraphicalEditPart)oldContainerPart);
					return singleton.entrySet().iterator().next();
				}
			}
		}
		return null;
	}

	/**
	 * Provides the default filter
	 * 
	 * @return the default filter
	 */
	@Override
	public NotificationFilter getFilter() {
		return NotificationFilter.NOT_TOUCH;
	}

}
