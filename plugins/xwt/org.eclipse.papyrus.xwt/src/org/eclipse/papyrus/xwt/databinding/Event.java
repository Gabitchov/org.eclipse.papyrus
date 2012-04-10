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

/**
 * @author jliu jin.liu@soyatec.com
 */
public class Event {

	private Object eventTarget;

	private Object oldValue;

	private Object newValue;

	private String eventType;

	public Event(Object eventTarget, Object oldValue, Object newValue, String eventType) {
		this.eventTarget = eventTarget;
		this.oldValue = oldValue;
		this.newValue = newValue;
		this.eventType = eventType;
	}

	/**
	 * @return the eventTarget
	 */
	public Object getEventTarget() {
		return eventTarget;
	}

	/**
	 * @param eventTarget
	 *        the eventTarget to set
	 */
	public void setEventTarget(Object eventTarget) {
		this.eventTarget = eventTarget;
	}

	/**
	 * @return the oldValue
	 */
	public Object getOldValue() {
		return oldValue;
	}

	/**
	 * @param oldValue
	 *        the oldValue to set
	 */
	public void setOldValue(Object oldValue) {
		this.oldValue = oldValue;
	}

	/**
	 * @return the newValue
	 */
	public Object getNewValue() {
		return newValue;
	}

	/**
	 * @param newValue
	 *        the newValue to set
	 */
	public void setNewValue(Object newValue) {
		this.newValue = newValue;
	}

	/**
	 * @return the eventType
	 */
	public String getEventType() {
		return eventType;
	}

	/**
	 * @param eventType
	 *        the eventType to set
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

}
