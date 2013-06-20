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
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Port;

/**
 * Main listener for model changes (registered via plugin.xml). It will delegate
 * to the sub-listeners for specific sub-elements (type, operation, port, ...) that
 * can be found in this package
 * 
 * @author ansgar
 * 
 */
public class ModelListener implements IPapyrusListener {

	public void notifyChanged(Notification notification) {
		Log.log(Log.INFO_MSG, Log.TRAFO_SYNC, "ModelListener.notifyChanged: " + notification.getFeature());
		Object notifier = notification.getNotifier();
		if(notifier instanceof NamedElement) {
			String name = ((NamedElement)notifier).getName();
			Log.log(Log.INFO_MSG, Log.TRAFO_SYNC, "Change notification for element: " + name);
		}

		if(notifier instanceof Operation) {
			OperationListener.getInstance().notifyChanged(notification);
		} else if(notifier instanceof Parameter) {
			ParameterListener.getInstance().notifyChanged(notification);
		} else if(notifier instanceof Interface) {
			InterfaceListener.getInstance().notifyChanged(notification);
		} else if(notifier instanceof Port) {
			PortListener.getInstance().notifyChanged(notification);
		}
	}
}
