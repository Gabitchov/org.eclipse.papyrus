/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib saadia.dhouib@cea.fr  
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.communication.custom.edit.policies;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.editpolicies.OrphanViewPolicy;
import org.eclipse.papyrus.diagram.communication.edit.parts.MessageEditPart;
import org.eclipse.papyrus.diagram.communication.part.UMLVisualIDRegistry;


// TODO: Auto-generated Javadoc
/**
 * The Class CustomOrphanViewPolicy is intended to ignore the communication diagram message connectors when searching for orphan views
 */
public class CustomOrphanViewPolicy extends OrphanViewPolicy {

	/**
	 * @see org.eclipse.papyrus.diagram.common.editpolicies.OrphanViewPolicy#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 * 
	 * @param notification
	 */

	public void notifyChanged(Notification notification) {
		// something has change. What ? :)
		// check who is responsible of notification. If this is host edit part related semantic element, act as standard
		Object notifier = notification.getNotifier();
		// View hostView = (View)getHost().getModel();
		if(notifier.equals(hostSemanticElement)) {
			if(Notification.REMOVE == notification.getEventType() || Notification.SET == notification.getEventType()) {
				refreshViews();
			}
		} else {
			// this is perhaps one of the scoped semantic parent
			if(notifier instanceof EObject) {
				if(!(notifier instanceof View)) {
					if(Notification.REMOVE == notification.getEventType()) {

						// 2 cases... remove or simple move ? 
						// this can be checked with the view, if it is now orphaned or not
						// if it is orphaned, element has to be destroyed, remove from parent listener, etc.
						// if not, this was just a move => change listener using new parent
						// checks also for whole hierarchy...
						EObject parentNotifier = (EObject)notifier;

						if(additionalParentToListen.containsKey(parentNotifier)) {
							// this should be one of the elements that are inside the 
							List<View> views = additionalParentToListen.get(parentNotifier);

							List<View> orphaned = findOrphanView(views.iterator());
							//
							// delete all the remaining views
							deleteViews(orphaned.iterator());

							removeListeners(orphaned);
						}
					}
				} else { // Notifier is a View
					// REMOVE or ADD are interesting events:
					// if remove, remove the list (perhaps) from the views contributing to the delete action
					// if add, checks it does not need to be watched
					if(Notification.REMOVE == notification.getEventType()) {
						if(notification.getNewValue() instanceof View) {
							View oldView = (View)notification.getOldValue();
							removeListenerForView(oldView);
						}

					} else if(Notification.ADD == notification.getEventType()) {
						// check the parent of the associated semantic element
						if(notification.getNewValue() instanceof View) {
							View newView = (View)notification.getNewValue();
							addListenerForView(newView);
						}
					}

				}
			}
		}
	}

	/**
	 * Retrieve the list of orphaned views among the specified list view.
	 * Ignore the message connector views
	 * 
	 * @param viewChildrenIterator
	 *        the iterator on the list of views to check
	 * @return the list of views that are orphaned
	 */
	protected List<View> findOrphanView(Iterator<? extends EObject> viewChildrenIterator) {
		ArrayList<View> orphanView = new ArrayList<View>();
		while(viewChildrenIterator.hasNext()) {
			EObject view = viewChildrenIterator.next();

			if(view instanceof View) {
				//Verify if the view is  a message connector, in this case it should not be considered as an orphan view, 
				//because the message connector has no semantic element associated to it
				if(((View)view).getType().equals(UMLVisualIDRegistry.getType(MessageEditPart.VISUAL_ID))) {
					continue;
				}
				if(isOrphaned((View)view)) {
					orphanView.add((View)view);
				}

			}
		}
		return orphanView;
	}
}
