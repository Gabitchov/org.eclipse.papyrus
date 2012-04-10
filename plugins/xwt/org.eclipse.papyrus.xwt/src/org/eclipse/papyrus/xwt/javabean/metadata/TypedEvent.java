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
package org.eclipse.papyrus.xwt.javabean.metadata;

import org.eclipse.papyrus.xwt.metadata.IEvent;

/**
 * @author jliu
 */
public class TypedEvent implements IEvent {

	private String name;

	private int eventType;

	/**
	 * SWT event type.
	 */
	public TypedEvent(String name, int eventType) {
		this.name = name;
		this.eventType = eventType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.core.metadata.IBehavior#getName()
	 */
	public String getName() {
		return name;
	}

	public int getEventType() {
		return eventType;
	}

	public void setName(String name) {
		this.name = name;
	}

}
