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
package org.eclipse.papyrus.ui.toolbox.notification.utils;

import org.eclipse.papyrus.ui.toolbox.notification.ICompositeCreator;
import org.eclipse.papyrus.ui.toolbox.notification.PapyrusToolkit;
import org.eclipse.papyrus.ui.toolbox.notification.Type;
import org.eclipse.papyrus.ui.toolbox.notification.builders.IContext;
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

	/**
	 * Create a composite according to the type
	 * 
	 * @param shell
	 *        , the shell of the element
	 * @param toolkit
	 *        , the toolkit used
	 * @param parent
	 *        , the parent containing the composite created
	 * @param type
	 *        , the type to create
	 * @param image
	 *        , the image to associate
	 * @param message
	 *        , the message to display
	 * @param useHTML
	 *        , if the composite use html
	 * @return the composite created
	 */
	public static Composite createCompositeWithType(Shell shell, FormToolkit toolkit, Composite parent, Type type, Image image, String message, boolean useHTML) {
		return createCompositeWithType(shell, toolkit, parent, type, image, message, useHTML, null, null);
	}

	/**
	 * Create a composite according to the type
	 * 
	 * @param shell
	 *        , the shell of the element
	 * @param toolkit
	 *        , the toolkit used
	 * @param parent
	 *        , the parent containing the composite created
	 * @param type
	 *        , the type to create
	 * @param image
	 *        , the image to associate
	 * @param message
	 *        , the message to display
	 * @param useHTML
	 *        , if the composite use html
	 * @param creator
	 *        , the composite creator it can be null
	 * @param context
	 *        , the context to add the composite created by the creator
	 * @return the composite created
	 */
	public static Composite createCompositeWithType(Shell shell, FormToolkit toolkit, Composite parent, Type type, Image image, String message, boolean useHTML, ICompositeCreator creator, IContext context) {
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
		if(creator == null) {
			if(toolkit != null) {
				FormText label = toolkit.createFormText(top, false);
				label.setText(message, useHTML, true);
				label.setLayoutData(new GridData(GridData.FILL_BOTH));
			} else {
				Label label = new Label(top, SWT.None);
				label.setText(message);
				label.setLayoutData(new GridData(GridData.FILL_BOTH));
			}
		} else {
			if(toolkit == null) {
				toolkit = PapyrusToolkit.INSTANCE;
			}
			Composite compo = creator.createComposite(top, toolkit);
			if(context != null) {
				context.put(IContext.COMPOSITE_CREATED, compo);
			}
		}
		return top;
	}

}
