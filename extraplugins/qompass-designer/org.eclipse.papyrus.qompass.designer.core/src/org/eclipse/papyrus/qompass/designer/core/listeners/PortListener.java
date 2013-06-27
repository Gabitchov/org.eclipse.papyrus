/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.designer.core.listeners;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.qompass.designer.core.Log;
import org.eclipse.papyrus.qompass.designer.core.sync.CompTypeSync;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Port;

public class PortListener implements IPapyrusListener {

	public Notifier getTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	public static PortListener getInstance() {
		if(instance == null) {
			instance = new PortListener();
		}
		return instance;
	}

	private static PortListener instance;


	public boolean isAdapterForType(Object type) {
		// TODO Auto-generated method stub
		return false;
	}

	public void notifyChanged(Notification notification) {
		int evtType = notification.getEventType();
		Object notifier = notification.getNotifier();

		if(evtType == Notification.SET) {
			Log.log(Status.INFO, Log.TRAFO_SYNC, "Port adapter, set: " + ((NamedElement)notifier).getName());
			Object obj = notification.getFeature();
			if(notifier instanceof Port) {
				Port port = (Port)notifier;
				if(obj instanceof ENamedElement) {
					ENamedElement ne = (ENamedElement)obj;
					if(ne.getName().equals("name")) {
						String oldName = notification.getOldStringValue();
						CompTypeSync.renamePort((Class)port.getOwner(), port, oldName);
						// profile modifications are also be indicated as name changes, but might imply a change
						// of provided and required interfaces.
						CompTypeSync.syncPort((Class)port.getOwner(), port);
					} else if(ne.getName().equals("type")) {
						CompTypeSync.syncPort((Class)port.getOwner(), port);
					}
				}
			}
		} else {
			Log.log(Status.INFO, Log.TRAFO_SYNC, "Port adapter, code: " + notification.getEventType() + ", " + notifier);
		}
	}
}
