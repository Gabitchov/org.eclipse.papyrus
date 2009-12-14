/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.listeners;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.core.listenerservice.IPapyrusListener;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * this class is used to listen remove element and has in charge to remove application of stereotype that are not used
 * 
 */
public class RemoveStereotypeApplicationListener implements IPapyrusListener {

	public RemoveStereotypeApplicationListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see org.eclipse.papyrus.core.listenerservice.IPapyrusListener#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 * 
	 * @param notification
	 */

	public void notifyChanged(Notification notification) {
		Resource resource = null;
		ArrayList<DynamicEObjectImpl> appliedstereotypeToRemove = new ArrayList<DynamicEObjectImpl>();
		//listen remove and Set notification
		if(notification.getEventType() == Notification.REMOVE || notification.getEventType() == Notification.SET) {

			//listen if the the notifier  is an eObject
			if(notification.getNotifier() instanceof EObject) {
				resource = ((EObject)notification.getNotifier()).eResource();
				if(resource != null) {
					TreeIterator<EObject> iterator = resource.getAllContents();

					//look for applied stereotype without based element
					while(iterator.hasNext()) {
						EObject eObject = (EObject)iterator.next();
						if(eObject instanceof DynamicEObjectImpl && UMLUtil.getBaseElement(eObject) == null) {
							appliedstereotypeToRemove.add((DynamicEObjectImpl)eObject);
						}
					}
				}
			}
		}
		Iterator<DynamicEObjectImpl> iterator = appliedstereotypeToRemove.iterator();
		while(iterator.hasNext()) {
			DynamicEObjectImpl dynamicEObjectImpl = (DynamicEObjectImpl)iterator.next();
			resource.getContents().remove(dynamicEObjectImpl);
		}


	}

}
