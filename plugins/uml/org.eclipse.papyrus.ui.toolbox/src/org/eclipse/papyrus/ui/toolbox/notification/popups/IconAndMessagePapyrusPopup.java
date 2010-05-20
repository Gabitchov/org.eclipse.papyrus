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
package org.eclipse.papyrus.ui.toolbox.notification.popups;

import org.eclipse.papyrus.ui.toolbox.notification.Type;
import org.eclipse.papyrus.ui.toolbox.notification.utils.PapyrusControlsFactory;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;


/**
 * A notification with icon and message
 * 
 * @author tristan faure
 * 
 */
public class IconAndMessagePapyrusPopup extends MessagePapyrusPopup {

	private Type type = null;

	private Image image;

	public IconAndMessagePapyrusPopup(Shell parentShell, FormToolkit toolkit, String message, Type type) {
		super(parentShell, toolkit, message);
		this.type = type;
	}

	public IconAndMessagePapyrusPopup(Shell activeShell, FormToolkit toolkit, String message) {
		super(activeShell, toolkit, message);
	}

	@Override
	protected Composite createText(Composite composite) {
		Composite top = PapyrusControlsFactory.createCompositeWithType(getShell(), toolkit, composite, type, image, message, useHtml);
		return top;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}
