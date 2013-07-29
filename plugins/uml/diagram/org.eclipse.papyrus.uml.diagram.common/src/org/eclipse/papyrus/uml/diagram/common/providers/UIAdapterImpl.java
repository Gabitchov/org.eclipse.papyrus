/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), 
 *    Nicolas Lalevee (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.providers;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.swt.widgets.Display;

/**
 * This EMF listener receives an event and then handles this event in the UI
 * thread
 * 
 * @author <a href="david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public abstract class UIAdapterImpl extends AdapterImpl {

	/**
	 * Call the handlePropertyChanged method in the UI thread
	 * 
	 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public final void notifyChanged(Notification msg) {
		if(Display.getCurrent() != Display.getDefault()) {
			syncNotifyChanged(msg);
		} else {
			safeNotifyChanged(msg);
		}
	}

	/**
	 * Handles the event notification in the UI thread
	 * 
	 * @param msg
	 *        the event notification
	 */
	private void syncNotifyChanged(final Notification msg) {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				safeNotifyChanged(msg);
			}
		});
	}

	/**
	 * This method is called when an event occured on the model objects.<br>
	 * This method is always called in the Ui thread
	 * 
	 * @param msg
	 *        the event notification
	 */
	protected abstract void safeNotifyChanged(Notification msg);
}
