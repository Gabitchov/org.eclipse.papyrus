/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers.stackmodel.exprmatcher;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.papyrus.layers.stackmodel.util.TriggeredEventTraces;


/**
 * A listener on {@link LayersModelEventNotifier}. This listener trace events from
 * the notifier.
 * 
 * @author cedric dumoulin
 *
 */
public class TraceValueChangedEventListener implements IValueChangedEventListener {

	public TriggeredEventTraces<Notification> traces = new TriggeredEventTraces<Notification>();
	
	/**
	 * @see org.eclipse.papyrus.layers.runtime.ILayersModelEventListener#layerAdded(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	@Override
	public void valueChanged(Notification notification) {
		traces.addTrace("valueChanged", notification);
		
	}
	

}
