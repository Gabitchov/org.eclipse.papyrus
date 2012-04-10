/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.       *
 * All rights reserved. This program and the accompanying materials            *
 * are made available under the terms of the Eclipse Public License v1.0       *
 * which accompanies this distribution, and is available at                    *
 * http://www.eclipse.org/legal/epl-v10.html                                   *
 *                                                                             *  
 * Contributors:                                                               *        
 *     Soyatec - initial API and implementation                                *
 *******************************************************************************/
package org.eclipse.papyrus.xwt.javabean.metadata.properties;

import org.eclipse.papyrus.xwt.metadata.IEvent;

/**
 * A property to hold the event state
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class EventProperty extends DataProperty {

	protected IEvent event;

	public EventProperty(String name, String key, IEvent event) {
		super(name, key, Boolean.class, false);
		this.event = event;
	}

	public IEvent getEvent() {
		return event;
	}
}
