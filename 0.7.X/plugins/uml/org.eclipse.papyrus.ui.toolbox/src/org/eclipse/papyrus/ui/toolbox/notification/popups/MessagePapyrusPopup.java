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

import org.eclipse.papyrus.ui.toolbox.notification.dialogs.PapyrusPopup;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;


/**
 * A notification with a message
 * 
 * @author tristan faure
 * 
 */
public class MessagePapyrusPopup extends PapyrusPopup {

	protected final String message;


	/**
	 * Create a Papyrus message popup
	 * 
	 * @param parentShell
	 *        , the shell
	 * @param toolkit
	 *        , the toolkit to create elements
	 * @param message
	 *        , the message to display
	 */
	public MessagePapyrusPopup(Shell parentShell, FormToolkit toolkit, String message) {
		super(parentShell, toolkit);
		this.message = message;

	}

	@Override
	protected Control doCreateContents(Composite composite) {
		composite.setLayout(getCompositeLayout());
		Composite label = createText(composite);
		return label;
	}

	protected Layout getCompositeLayout() {
		return new FillLayout();
	}

	protected Composite createText(Composite composite) {
		FormText label = toolkit.createFormText(composite, false);
		label.setText(message, useHtml, true);
		return label;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
	}


}
