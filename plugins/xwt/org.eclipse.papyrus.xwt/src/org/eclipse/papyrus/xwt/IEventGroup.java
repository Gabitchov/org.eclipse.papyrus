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
package org.eclipse.papyrus.xwt;

import org.eclipse.papyrus.xwt.metadata.IProperty;

/**
 * This class manages the coordination between events' state
 * 
 * @author yyang
 */
public interface IEventGroup {

	String[] getEventNames();

	/**
	 * Fire the event to update other when an event occurs
	 * 
	 * @param object
	 * @param property
	 */
	void fireEvent(IObservableValueListener manager, IProperty property);

	/**
	 * Register the event
	 * 
	 * @param manager
	 * @param property
	 */
	void registerEvent(IObservableValueListener manager, IProperty property);
}
