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
package org.eclipse.papyrus.uml.diagram.common.groups.core;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.uml.diagram.common.groups.core.ui.ChooseChildrenNotificationConfigurator;
import org.eclipse.papyrus.uml.diagram.common.groups.core.ui.ChooseParentNotificationConfigurator;
import org.eclipse.papyrus.uml.diagram.common.groups.core.ui.NotificationConfigurator;

/**
 * The pending group notifications manager handles notifications which have not been resolved.
 * It ensures that notifications are reconducted in the next notification and that old notifications are deleted.
 * 
 * @author vhemery
 */
public class PendingGroupNotificationsManager {

	/** the instances */
	private static Map<DiagramEditPart, PendingGroupNotificationsManager> instances = new HashMap<DiagramEditPart, PendingGroupNotificationsManager>();

	private DiagramEditPart diagramEditPart = null;

	private Map<IGraphicalEditPart, NotificationConfigurator> chooseParentNotifications = new HashMap<IGraphicalEditPart, NotificationConfigurator>();

	private HashMap<IGraphicalEditPart, NotificationConfigurator> chooseChildrenNotifications = new HashMap<IGraphicalEditPart, NotificationConfigurator>();

	private PendingGroupNotificationsManager(DiagramEditPart diagramPart) {
		diagramEditPart = diagramPart;
	}

	/**
	 * Delete this manager and its external references.
	 */
	public void delete() {
		chooseParentNotifications.clear();
		chooseChildrenNotifications.clear();
		instances.remove(diagramEditPart);
		diagramEditPart = null;

	}

	/**
	 * Access to an existing instance or create a new one for an active diagram
	 * 
	 * @param diagramPart
	 *        the active diagram part
	 * @return the PendingGroupNotificationsManager instance for the active diagram or null if the diagram is unactive
	 */
	public static PendingGroupNotificationsManager getInstanceForDiagram(DiagramEditPart diagramPart) {
		if(diagramPart.isActive()) {
			if(!instances.containsKey(diagramPart)) {
				PendingGroupNotificationsManager instance = new PendingGroupNotificationsManager(diagramPart);
				instances.put(diagramPart, instance);
				return instance;
			} else {
				return instances.get(diagramPart);
			}
		} else {
			return null;
		}
	}

	/**
	 * Delete the PendingGroupNotificationsManager instance corresponding to this diagram part
	 * 
	 * @param diagramPart
	 *        the diagram edit part
	 */
	public static void removeInstanceForDiagram(DiagramEditPart diagramPart) {
		if(instances.containsKey(diagramPart)) {
			instances.get(diagramPart).delete();
		}
	}

	/**
	 * Update the map and delete the no longer needed notifications.
	 * The old notification entries are added to the map, unneccessary entries are removed.
	 * 
	 * @param movedPartsAndParents
	 *        the map with moved parts and their parent groups
	 */
	//	public void updateParentAssignementsMap(Map<IGraphicalEditPart, List<IGraphicalEditPart>> movedPartsAndParents) {
	//		Set<IGraphicalEditPart> newlyMovedParts = movedPartsAndParents.keySet();
	//		if(newlyMovedParts.size() > 0) {
	//			// the parent assignment from the same diagram must be combined
	//			// 1. report unchanged assignments in the new map
	//			Map<INotification, ChooseContainingGroupCreator> copy = new HashMap<INotification, ChooseContainingGroupCreator>(chooseParentNotifications);
	//			for(Entry<INotification, ChooseContainingGroupCreator> creatorEntry : copy.entrySet()) {
	//				if(!creatorEntry.getKey().isDeleted()) {
	//					// report
	//					ChooseContainingGroupCreator creator = creatorEntry.getValue();
	//					Map<IGraphicalEditPart, List<IGraphicalEditPart>> previousAssignement = creator.getElementsAndParents();
	//					Set<IGraphicalEditPart> oldlyMovedParts = new HashSet<IGraphicalEditPart>(previousAssignement.keySet());
	//					oldlyMovedParts.removeAll(newlyMovedParts);
	//					for(IGraphicalEditPart partToReport : oldlyMovedParts) {
	//						// do not report orphan parts
	//						if(partToReport.getParent() != null) {
	//							movedPartsAndParents.put(partToReport, previousAssignement.get(partToReport));
	//						}
	//					}
	//				} else {
	//					// remove deleted notification from manager
	//					chooseParentNotifications.remove(creatorEntry.getKey());
	//				}
	//			}
	//			// 2. delete old notification
	//			removeChooseParentNotification();
	//		}
	//		// clean useless assignments with only one parent
	//		for(Entry<IGraphicalEditPart, List<IGraphicalEditPart>> entry : new HashMap<IGraphicalEditPart, List<IGraphicalEditPart>>(movedPartsAndParents).entrySet()) {
	//			if(entry.getValue().size() < 2) {
	//				movedPartsAndParents.remove(entry.getKey());
	//			}
	//		}
	//	}

	/**
	 * Remove notifications to assign the graphical parent group
	 */
	public void removeChooseParentNotification(IGraphicalEditPart childEditPart) {
		chooseParentNotifications.remove(childEditPart);
	}

	/**
	 * Remove notification to assign a group's graphical children
	 * 
	 * @param parentGroup
	 *        the group
	 */
	public void removeChooseChildrenNotification(IGraphicalEditPart parentGroup) {
		chooseChildrenNotifications.remove(parentGroup);
	}



	/**
	 * Store a notification and its composite creator to let it be managed
	 * 
	 * @param creator
	 *        the composite creator
	 * @param notification
	 *        the notification
	 */
	public void storeNotification(NotificationConfigurator configurator) {
		if(configurator instanceof ChooseParentNotificationConfigurator) {
			chooseParentNotifications.put(((ChooseParentNotificationConfigurator)configurator).getMainEditPart(), configurator);
		} else if(configurator instanceof ChooseChildrenNotificationConfigurator) {
			chooseChildrenNotifications.put(((ChooseChildrenNotificationConfigurator)configurator).getMainEditPart(), configurator);
		}
	}

	/**
	 * Get the {@link INotification} for choosing the children of an edit and return null is there none
	 * 
	 * @param parentEditPart
	 * @return
	 */
	public NotificationConfigurator getChooseChildrenPendingNotification(IGraphicalEditPart parentEditPart) {
		if(chooseChildrenNotifications.containsKey(parentEditPart)) {
			return chooseChildrenNotifications.get(parentEditPart);
		} else {
			return null;
		}
	}
}
