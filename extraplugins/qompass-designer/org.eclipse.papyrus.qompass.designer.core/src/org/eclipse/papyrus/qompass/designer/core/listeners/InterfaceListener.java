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
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.qompass.designer.core.Log;
import org.eclipse.papyrus.qompass.designer.core.sync.CompImplSync;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Interface;

public class InterfaceListener implements IPapyrusListener {

	public static InterfaceListener getInstance() {
		if(instance == null) {
			instance = new InterfaceListener();
		}
		return instance;
	}

	private static InterfaceListener instance = null;

	public void notifyChanged(Notification notification) {
		Log.log(Status.INFO, Log.TRAFO_SYNC, "Interface adapter"); //$NON-NLS-1$
		int evtType = notification.getEventType();
		Object notifier = notification.getNotifier();
		if(evtType == Notification.SET) {
			if(notifier instanceof Class) {
				// UMLExecutor.addCCM_intf ((Class) notifier);
			}
		} else if(evtType == Notification.ADD) {

			if(notifier instanceof Interface) {
				// Interface intf = (Interface) notifier;

				// never executed since name is always unset when
				// an operation is newly added
			}
		} else if(evtType == Notification.REMOVE) {
			Object oldValue = notification.getOldValue();
			if(oldValue instanceof BehavioralFeature) {
				BehavioralFeature toBeRemoved = (BehavioralFeature)oldValue;

				Interface intf = (Interface)notifier;
				CompImplSync.syncViaInterface(intf, toBeRemoved);
			}
		}
	}
}
