/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.xwt.internal.core;

import java.lang.reflect.Method;

import org.eclipse.papyrus.xwt.IEventInvoker;
import org.eclipse.papyrus.xwt.metadata.IEvent;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Widget;

public interface IEventController {

	boolean hasEvent(Object receiver, IEvent event);

	void addEvent(int eventType, String name, IEvent event, Widget control, Object receiver, Object arg, Method method);

	void addEvent(int eventType, String name, IEvent event, Widget control, Object arg, IEventInvoker eventInvoker);

	void setEvent(IEvent event, Widget control, Object receiver, Object arg, Method method);

	void setEvent(IEvent event, Widget control, Object arg, IEventInvoker eventInvoker);

	void handleEvent(Event e);
}
