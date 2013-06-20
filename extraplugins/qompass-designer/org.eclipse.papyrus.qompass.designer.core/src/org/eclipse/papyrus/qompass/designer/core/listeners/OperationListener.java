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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.qompass.designer.core.Log;
import org.eclipse.papyrus.qompass.designer.core.sync.CompImplSync;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;

/**
 * Track changes of an operation, typically within an interface provided
 * by a port. This is used to update derived oeprations, e.g. when parameters
 * are added or removed.
 * 
 * @author ansgar
 * 
 */
public class OperationListener implements IPapyrusListener {

	// TODO: used by TypeAdapter (useful??)
	public static OperationListener getInstance() {
		if(instance == null) {
			instance = new OperationListener();
		}
		return instance;
	}

	private static OperationListener instance = null;

	public void notifyChanged(Notification notification) {
		int evtType = notification.getEventType();
		Object notifier = notification.getNotifier();
		String name = "";
		if(notifier instanceof NamedElement) {
			name = ((NamedElement)notifier).getName();
		}
		if((evtType == Notification.SET) || (evtType == Notification.ADD)) {
			Log.log(Log.INFO_MSG, Log.TRAFO_SYNC, "Operation.adapter, set " + name);

			if(notifier instanceof Operation) {
				Operation operation = (Operation)notifier;

				Element owner = operation.getOwner();
				if(owner instanceof Interface) {
					Interface intf = (Interface)owner;
					CompImplSync.syncViaInterface(intf);
				}
			}
		} else {
			Log.log(Log.INFO_MSG, Log.TRAFO_SYNC, "Operation.adapter, code: " + notification.getEventType() + ", name: " + name);
		}
	}
}
