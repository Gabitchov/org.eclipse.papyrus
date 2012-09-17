/*****************************************************************************
 * Copyright (c) 2010 ATOS ORIGIN.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.toolbox.notification;

import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.PropertyWrapper;
import org.eclipse.ui.forms.widgets.FormToolkit;


/**
 * An IBuilder helps the notification builder to create a notification
 * 
 * @author tfaure
 * 
 */
public interface IBuilder {

	/**
	 * This method displays the notification message
	 * 
	 * @param wrapper
	 *        , a wrapper containing all the options to create the message
	 * @param toolkit
	 *        , the toolkit for form creation
	 */
	INotification build(PropertyWrapper wrapper, FormToolkit toolkit);

	/**
	 * Determines if the IBuilder can manage the parameter with its value
	 * 
	 * @param parameterName
	 *        , the name of the parameter (see constants in {@link NotificationBuilder} calss
	 * @param value
	 *        , the value of the corresponding parameter
	 * @return true if the parameterName or the value can be managed by the builder
	 */
	boolean accept(String parameterName, Object value);
}
