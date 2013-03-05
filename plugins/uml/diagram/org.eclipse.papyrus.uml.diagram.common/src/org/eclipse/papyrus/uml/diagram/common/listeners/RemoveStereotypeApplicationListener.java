/*****************************************************************************
 * Copyright (c) 2009, 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - filter out EObjects that are Resources (CDO)
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.listeners;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * this class is used to listen remove element and has in charge to remove
 * application of stereotype that are not used
 * 
 */
public class RemoveStereotypeApplicationListener implements IPapyrusListener {

	/**
	 * Creates a new RemoveStereotypeApplicationListener.
	 */
	public RemoveStereotypeApplicationListener() {
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 * 
	 * @param notification
	 */
	public void notifyChanged(Notification notification) {
		Resource resource = null;
		
		// note that stereotype applications from static profiles are not
		// DynamicEObjectImpls!  Neither are stereotype applications from
		// dynamic profiles in a CDO context
		ArrayList<EObject> appliedstereotypeToRemove = new ArrayList<EObject>();
		// listen remove and Set notification
		if(notification.getEventType() == Notification.REMOVE || notification.getEventType() == Notification.SET) {

			// listen if the the notifier is an eObject
			EObject notifier = EMFHelper.asEMFModelElement(notification.getNotifier());
			if(notifier != null) {
				resource = ((EObject)notification.getNotifier()).eResource();
				if(resource != null) {
					TreeIterator<EObject> iterator = resource.getAllContents();

					// look for applied stereotype without based element
					while(iterator.hasNext()) {
						EObject eObject = (EObject)iterator.next();
						if ((UMLUtil.getStereotype(eObject) != null)
							&& (UMLUtil.getBaseElement(eObject) == null)) {
							
							appliedstereotypeToRemove.add(eObject);
						}
					}
				}
			}
		}
		Iterator<EObject> iterator = appliedstereotypeToRemove.iterator();
		while(iterator.hasNext()) {
			resource.getContents().remove(iterator.next());
		}
	}

}
