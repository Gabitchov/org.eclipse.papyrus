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
package org.eclipse.papyrus.ui.toolbox.notification.popups;

import org.eclipse.papyrus.ui.toolbox.notification.PapyrusToolkit;
import org.eclipse.papyrus.ui.toolbox.notification.Type;
import org.eclipse.papyrus.ui.toolbox.notification.utils.PapyrusControlsFactory;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;


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
	protected void createSection(Composite c, ScrolledForm form) {
		Section section = toolkit.createSection(form.getBody(), PapyrusToolkit.DEFAULT_STYLE);
		section.setText("Papyrus");
		section.setClient(doCreateContents(section));
		getShell().setFocus();
		section.setLayoutData(new GridData(GridData.FILL_BOTH));
	}

	@Override
	protected Composite createText(Composite composite) {
		Composite top = PapyrusControlsFactory.createCompositeWithType(getShell(), toolkit, composite, type, image, message, useHtml, creator, context);
		return top;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}
