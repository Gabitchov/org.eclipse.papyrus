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

package org.eclipse.papyrus.uml.properties.xtext.sheet;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;

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
		Object notifier = notification.getNotifier();
		if (notifier instanceof EObject && currentEditor != null) {
			EObject notifierEObj = (EObject) notifier;
			while (notifierEObj != null) {
				if (notifierEObj == currentEditor.currentEObj) {
					currentEditor.refresh();
					break;
				}
				notifierEObj = notifierEObj.eContainer();
			}
		}
	}
	
	protected static AdvancedEditingPropertySection currentEditor;
}
