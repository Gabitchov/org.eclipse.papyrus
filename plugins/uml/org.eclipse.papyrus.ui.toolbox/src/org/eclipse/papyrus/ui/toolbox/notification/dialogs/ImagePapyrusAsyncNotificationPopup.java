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
package org.eclipse.papyrus.ui.toolbox.notification.dialogs;

import org.eclipse.papyrus.ui.toolbox.notification.Type;
import org.eclipse.papyrus.ui.toolbox.notification.utils.PapyrusControlsFactory;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;


/**
 * An async notification with a message and an image
 * 
 * @author tristan faure
 * 
 */
public class ImagePapyrusAsyncNotificationPopup extends PapyrusAsyncNotificationPopup {

	private final Type type;

	private Image image = null;

	/**
	 * Create an async popup with a specific type
	 * 
	 * @param display
	 *        , the display of the application
	 * @param toolkit
	 *        , the toolkit able to create the controls
	 * @param type
	 *        , the type of the window
	 */
	public ImagePapyrusAsyncNotificationPopup(Display display, FormToolkit toolkit, Type type) {
		super(display, toolkit);
		this.type = type;
	}

	/**
	 * Set the image to display
	 * 
	 * @param image
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.ui.toolbox.notification.dialogs.PapyrusAsyncNotificationPopup#doCreateClient(org.eclipse.swt.widgets.Composite)
	 * 
	 * @Override
	 */
	protected void doCreateClient(Composite parent) {
		PapyrusControlsFactory.createCompositeWithType(getShell(), null, parent, type, image, text, false);
	}
}
