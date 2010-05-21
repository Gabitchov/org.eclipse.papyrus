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

import org.eclipse.papyrus.ui.toolbox.notification.IBuilder;
import org.eclipse.papyrus.ui.toolbox.notification.ICompositeCreator;
import org.eclipse.papyrus.ui.toolbox.notification.dialogs.ImagePapyrusAsyncNotificationPopup;
import org.eclipse.papyrus.ui.toolbox.notification.dialogs.PapyrusAsyncNotificationPopup;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;


/**
 * A Builder able to create {@link PapyrusAsyncNotificationPopup} instances
 * 
 * @author tristan faure
 * 
 */
public class AsyncNotifierBuilder implements IBuilder {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.ui.toolbox.notification.IBuilder#build(org.eclipse.papyrus.ui.toolbox.notification.PropertyWrapper,
	 * org.eclipse.ui.forms.widgets.FormToolkit)
	 */
	public void build(PropertyWrapper wrapper, final FormToolkit toolkit) {
		PapyrusAsyncNotificationPopup popup = null;
		if(wrapper.getComposite() != null) {
			final ICompositeCreator composite = wrapper.getComposite();
			popup = new PapyrusAsyncNotificationPopup(Display.getDefault(), toolkit) {

				@Override
				protected void doCreateClient(Composite parent) {
					Composite compo = composite.createComposite(parent, toolkit);
					setCompositeCreated(compo);
				}
			};
		} else {
			if(wrapper.getType() != null) {
				popup = new ImagePapyrusAsyncNotificationPopup(Display.getDefault(), toolkit, wrapper.getType());
			} else {
				popup = new PapyrusAsyncNotificationPopup(Display.getDefault(), toolkit);
			}
			String text = wrapper.getMessage();
			if(text == null) {
				text = "no text";
			}
			popup.setText(text);
		}
		if(wrapper.getDelay() != null) {
			popup.setDelayClose((Long)wrapper.getDelay());
		}
		if(wrapper.getActions() != null) {
			popup.addAllRunnable(wrapper.getActions());
		}
		popup.setTitle(wrapper.getTitle() == null ? "Papyrus" : wrapper.getTitle());
		popup.open();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.ui.toolbox.notification.IBuilder#accept(java.lang.String, java.lang.Object)
	 */
	public boolean accept(String parameterName, Object value) {
		if(NotificationBuilder.ASYNCHRONOUS.equals(parameterName)) {
			return value instanceof Boolean && ((Boolean)value);
		}
		if(NotificationBuilder.TEMPORARY.equals(parameterName)) {
			return value instanceof Boolean && (Boolean)value;
		}
		if(NotificationBuilder.MESSAGE.equals(parameterName)) {
			return true;
		}
		if(NotificationBuilder.COMPOSITE.equals(parameterName)) {
			return true;
		}
		if(NotificationBuilder.ACTION.equals(parameterName)) {
			return true;
		}
		if(NotificationBuilder.DELAY.equals(parameterName)) {
			return true;
		}
		if(NotificationBuilder.IMAGE.equals(parameterName)) {
			return true;
		}
		if(NotificationBuilder.TYPE.equals(parameterName)) {
			return true;
		}
		if(NotificationBuilder.HTML.equals(parameterName)) {
			return value instanceof Boolean && !(Boolean)value;
		}
		if(NotificationBuilder.TITLE.equals(parameterName)) {
			return true;
		}
		return false;
	}
}
