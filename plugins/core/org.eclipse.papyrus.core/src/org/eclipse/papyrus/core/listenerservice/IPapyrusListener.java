/*******************************************************************************
 * Copyright (c) 2008 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.core.listenerservice;

import org.eclipse.emf.common.notify.Notification;

/**
 * This interface is a listener that will listen directly all events in papyrus: uml. It will be very useful for external plug-in.
 * 
 *An implementation may be an adapter.
 */
public interface IPapyrusListener {

	/**
	 * Notifies that a change to some feature has occurred.
	 * 
	 * @param notification
	 *        - a description of the change.
	 **/
	public void notifyChanged(Notification notification);
}
