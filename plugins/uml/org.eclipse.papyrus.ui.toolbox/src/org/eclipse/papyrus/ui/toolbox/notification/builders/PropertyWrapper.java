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
package org.eclipse.papyrus.ui.toolbox.notification.builders;

import java.util.Collection;
import java.util.Map;

import org.eclipse.papyrus.ui.toolbox.notification.ICompositeCreator;
import org.eclipse.papyrus.ui.toolbox.notification.NotificationRunnable;
import org.eclipse.papyrus.ui.toolbox.notification.Type;
import org.eclipse.swt.graphics.Image;


/**
 * This class provides a more comfortable usage
 * to access to properties from NotificationBuilder map
 * 
 * @author tristan faure
 * 
 */
public class PropertyWrapper {

	private boolean asynchronous = false;

	private String message = null;

	private ICompositeCreator composite = null;

	private Collection<NotificationRunnable> actions = null;

	private Long delay = null;

	private boolean temporary = false;

	private String title = null;

	private boolean html = false;

	private Type type = null;

	private Image image = null;

	/**
	 * The class analyses the map and set the fields of the objects according to the values of the map.
	 * 
	 * @param properties
	 *        the map from Notification Builder
	 */
	@SuppressWarnings("unchecked")
	public PropertyWrapper(Map<String, Object> properties) {
		for(String s : properties.keySet()) {
			if(NotificationBuilder.ASYNCHRONOUS.equals(s)) {
				asynchronous = (Boolean)properties.get(s);
			} else if(NotificationBuilder.COMPOSITE.equals(s)) {
				composite = (ICompositeCreator)properties.get(s);
			} else if(NotificationBuilder.MESSAGE.equals(s)) {
				message = (String)properties.get(s);
			} else if(NotificationBuilder.ACTION.equals(s)) {
				actions = (Collection<NotificationRunnable>)properties.get(s);
			} else if(NotificationBuilder.DELAY.equals(s)) {
				delay = (Long)properties.get(s);
			} else if(NotificationBuilder.HTML.equals(s)) {
				html = (Boolean)properties.get(s);
			} else if(NotificationBuilder.TEMPORARY.equals(s)) {
				temporary = (Boolean)properties.get(s);
			} else if(NotificationBuilder.TITLE.equals(s)) {
				title = (String)properties.get(s);
			} else if(NotificationBuilder.TYPE.equals(s)) {
				type = (Type)properties.get(s);
			} else if(NotificationBuilder.IMAGE.equals(s)) {
				image = (Image)properties.get(s);
			}
		}
	}

	/**
	 * Checks if is asynchronous.
	 * 
	 * @return true, if is asynchronous
	 */
	public boolean isAsynchronous() {
		return asynchronous;
	}

	/**
	 * Gets the message.
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Gets the composite.
	 * 
	 * @return the composite
	 */
	public ICompositeCreator getComposite() {
		return composite;
	}

	/**
	 * Gets the actions.
	 * 
	 * @return the actions
	 */
	public Collection<NotificationRunnable> getActions() {
		return actions;
	}

	/**
	 * Gets the delay.
	 * 
	 * @return the delay
	 */
	public Long getDelay() {
		return delay;
	}

	/**
	 * Checks if is temporary.
	 * 
	 * @return true, if is temporary
	 */
	public boolean isTemporary() {
		return temporary;
	}

	/**
	 * Gets the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Checks if is html.
	 * 
	 * @return true, if is html
	 */
	public boolean isHtml() {
		return html;
	}

	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * Gets the image.
	 * 
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

}
