/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.xwt.databinding;

import org.eclipse.papyrus.xwt.IObservableValueListener;
import org.eclipse.papyrus.xwt.internal.core.IEventController;
import org.eclipse.papyrus.xwt.internal.utils.LoggerManager;
import org.eclipse.papyrus.xwt.internal.utils.ObservableValueManager;
import org.eclipse.papyrus.xwt.internal.utils.UserData;
import org.eclipse.papyrus.xwt.javabean.metadata.properties.EventProperty;
import org.eclipse.papyrus.xwt.metadata.IEvent;

public class EventPropertyObservableValue extends XWTObservableValue {

	private EventProperty property;

	public EventPropertyObservableValue(Object observed, EventProperty property) {
		super(Boolean.class, observed, property.getName());
		this.property = property;
		IEventController controller = UserData.findEventController(observed);
		if(controller == null) {
			controller = UserData.updateEventController(observed);
		}
		IEvent event = property.getEvent();

		IObservableValueListener manager = UserData.getObservableValueManager(observed);
		if(manager == null) {
			manager = new ObservableValueManager(observed);
			UserData.setObservableValueManager(observed, manager);
		}
		try {
			controller.setEvent(event, UserData.getWidget(observed), manager, property, IObservableValueListener.class.getDeclaredMethod("changeValueHandle", Object.class, org.eclipse.swt.widgets.Event.class));
			manager.registerValue(property, this);
		} catch (Exception e) {
			LoggerManager.log(e);
			return;
		}
	}

	@Override
	protected void doSetApprovedValue(Object value) {
		UserData.setLocalData(getObserved(), property.getName(), value);
	}

	protected Object doGetValue() {
		return UserData.getLocalData(getObserved(), property.getName());
	}
}
