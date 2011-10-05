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
package org.eclipse.papyrus.ui.toolbox.notification.view;

import java.util.Collection;

import org.eclipse.papyrus.ui.toolbox.notification.ICallBack;
import org.eclipse.papyrus.ui.toolbox.notification.NotificationRunnable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

public class MessageComposite extends AbstractInsideComposite {

	protected FormText text;


	public MessageComposite(ICallBack callBack, ScrolledForm parent, FormToolkit toolkit, Collection<NotificationRunnable> collection) {
		super(callBack, parent, toolkit, collection);
		setLayout(new FillLayout(SWT.HORIZONTAL));
	}

	@Override
	protected Control doCreateContents(FormToolkit toolkit, Composite composite) {
		text = toolkit.createFormText(composite, false);
		return text;
	}

	public void setText(String text) {
		this.text.setText(text, false, false);
	}

	@Override
	protected String getSectionName() {
		return "Message";
	}
}
