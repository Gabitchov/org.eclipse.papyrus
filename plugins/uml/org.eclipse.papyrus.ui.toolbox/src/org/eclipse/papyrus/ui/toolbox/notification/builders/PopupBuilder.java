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
import org.eclipse.papyrus.ui.toolbox.notification.INotification;
import org.eclipse.papyrus.ui.toolbox.notification.dialogs.PapyrusPopup;
import org.eclipse.papyrus.ui.toolbox.notification.popups.IconAndMessagePapyrusPopup;
import org.eclipse.papyrus.ui.toolbox.notification.popups.MessagePapyrusPopup;
import org.eclipse.papyrus.ui.toolbox.notification.popups.PopupNotification;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * A Builder able to create {@link PapyrusPopup} instances
 * 
 * @author tristan faure
 * 
 */
public class PopupBuilder implements IBuilder {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.ui.toolbox.notification.IBuilder#build(org.eclipse.papyrus.ui.toolbox.notification.PropertyWrapper,
	 * org.eclipse.ui.forms.widgets.FormToolkit)
	 */
	public INotification build(PropertyWrapper wrapper, FormToolkit toolkit) {
		PapyrusPopup popup = null;
		String title = "Papyrus";
		if(wrapper.getTitle() != null) {
			title = wrapper.getTitle();
		}
		String message = null;
		if(wrapper.getMessage() != null) {
			message = wrapper.getMessage();
		}
		if(wrapper.getType() != null) {
			popup = new IconAndMessagePapyrusPopup(Display.getDefault().getActiveShell(), toolkit, message, wrapper.getType());
		} else if(wrapper.getImage() != null) {
			popup = new IconAndMessagePapyrusPopup(Display.getDefault().getActiveShell(), toolkit, message);
			((IconAndMessagePapyrusPopup)popup).setImage(wrapper.getImage());
		} else {
			popup = new MessagePapyrusPopup(Display.getDefault().getActiveShell(), toolkit, message);
		}
		popup.setTitle(title);
		popup.setUseHtml(wrapper.isHtml());
		if(wrapper.getComposite() != null) {
			popup.setCompositeCreator(wrapper.getComposite());
			popup.setTitle(title);
		}
		if(wrapper.getActions() != null) {
			popup.addRunnables(wrapper.getActions());
		}
		PopupNotification result = new PopupNotification(popup);
		// assign the open result to the result of the run
		result.setResult(popup.open());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.ui.toolbox.notification.IBuilder#accept(java.lang.String, java.lang.Object)
	 */
	public boolean accept(String parameterName, Object value) {
		if(NotificationBuilder.ASYNCHRONOUS.equals(parameterName)) {
			return value instanceof Boolean && !((Boolean)value);
		}
		if(NotificationBuilder.DELAY.equals(parameterName)) {
			return false;
		}
		if(NotificationBuilder.TITLE.equals(parameterName)) {
			return true;
		}
		if(NotificationBuilder.TYPE.equals(parameterName)) {
			return true;
		}
		if(NotificationBuilder.IMAGE.equals(parameterName)) {
			return true;
		}
		if(NotificationBuilder.MESSAGE.equals(parameterName)) {
			return true;
		}
		if(NotificationBuilder.COMPOSITE.equals(parameterName)) {
			return true;
		}
		if(NotificationBuilder.HTML.equals(parameterName)) {
			return true;
		}
		if(NotificationBuilder.ACTION.equals(parameterName)) {
			return true;
		}
		if(NotificationBuilder.TEMPORARY.equals(parameterName)) {
			return value instanceof Boolean && !((Boolean)value);
		}
		return false;
	}

}
