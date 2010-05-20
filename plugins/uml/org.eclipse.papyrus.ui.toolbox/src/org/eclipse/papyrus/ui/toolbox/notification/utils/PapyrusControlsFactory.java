/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.ui.toolbox.notification.utils;

import org.eclipse.papyrus.ui.toolbox.notification.Type;
import org.eclipse.papyrus.ui.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;


public class PapyrusControlsFactory {

	public static Composite createCompositeWithType(Shell shell, FormToolkit toolkit, Composite parent, Type type, Image image, String message, boolean useHTML) {
		Composite top = null;
		if(toolkit == null) {
			top = new Composite(parent, SWT.None);
		} else {
			top = toolkit.createComposite(parent, SWT.NONE);
		}
		top.setLayout(new GridLayout(2, false));
		Image anImage = image;
		switch(type) {
		case ERROR:
			anImage = NotificationBuilder.getSWTImage(SWT.ICON_ERROR, shell);
			break;
		case INFO:
			anImage = NotificationBuilder.getSWTImage(SWT.ICON_INFORMATION, shell);
			break;
		case WARNING:
			anImage = NotificationBuilder.getSWTImage(SWT.ICON_WARNING, shell);
			break;
		case QUESTION:
			anImage = NotificationBuilder.getSWTImage(SWT.ICON_QUESTION, shell);
			break;
		default:
		}
		Label labelImage = new Label(top, SWT.None);
		if(anImage != null) {
			labelImage.setImage(anImage);
		}
		if(toolkit != null) {
			FormText label = toolkit.createFormText(top, false);
			label.setText(message, useHTML, true);
			label.setLayoutData(new GridData(GridData.FILL_BOTH));
		} else {
			Label label = new Label(top, SWT.None);
			label.setText(message);
			label.setLayoutData(new GridData(GridData.FILL_BOTH));
		}
		return top;
	}

}
