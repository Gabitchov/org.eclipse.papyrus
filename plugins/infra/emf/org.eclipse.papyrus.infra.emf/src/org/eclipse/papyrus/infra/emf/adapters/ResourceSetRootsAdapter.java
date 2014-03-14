/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.adapters;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;

/**
 * An EMF Adapter which listens on Resource Set root elements
 * 
 * @author Camille Letavernier
 * 
 */
public abstract class ResourceSetRootsAdapter extends EContentAdapter {

	@Override
	public void notifyChanged(Notification msg) {
		switch(msg.getEventType()) {
		case Notification.ADD:
		case Notification.ADD_MANY:
		case Notification.REMOVE:
		case Notification.REMOVE_MANY:
		case Notification.UNSET:
			doNotify(msg);
			break;
		}

		super.notifyChanged(msg);
	}

	@Override
	protected void setTarget(ResourceSet target) {
		if(target instanceof ResourceSet) {
			ResourceSet resourceSet = target;
			if(!resourceSet.eAdapters().contains(this)) {
				addAdapter(resourceSet);
			}
		}
		super.setTarget(target);
	}

	@Override
	protected void setTarget(Resource target) {
		//Ignore
	}

	@Override
	protected void setTarget(EObject target) {
		//Ignore
	}

	@Override
	protected void unsetTarget(EObject target) {
		//Ignore
	}

	@Override
	protected void unsetTarget(Resource target) {
		//Ignore
	}

	@Override
	protected void addAdapter(Notifier notifier) {
		super.addAdapter(notifier);
	}

	@Override
	protected void removeAdapter(Notifier notifier) {
		super.removeAdapter(notifier);
	}

	@Override
	protected void unsetTarget(ResourceSet target) {
		if(target != null) {
			removeAdapter(target);
		}
		super.unsetTarget(target);
	}

	@Override
	protected void handleContainment(Notification notification) {
		if(notification.getEventType() == Notification.ADD || notification.getEventType() == Notification.ADD_MANY) {
			//Do not propagate listeners to EObjects. We're only interested on events on the ResourceSet (Add/remove resources) and Resources (Add/remove EObjects)
			if(notification.getNotifier() == getTarget()) {
				super.handleContainment(notification);
			}
		} else {
			super.handleContainment(notification);
		}
	}

	protected abstract void doNotify(Notification msg);

}
