/**
 * Copyright (c) 2013 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Gregoire Dupe (Mia-Software) - Bug 406570 - Handlers to Save and SaveAs EMF resources
 */

package org.eclipse.papyrus.emf.facet.util.emf.ui.internal.dialogs;

import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class URIComposite extends Composite {

	private final Text text;

	public URIComposite(final Composite parent, final String initialText) {
		super(parent, SWT.NONE);
		this.setLayout(new GridLayout(2, false));
		final Label label = new Label(this, SWT.NONE);
		label.setText(Messages.SaveAsDialog_ResourceURI);
		this.text = new Text(this, SWT.BORDER);
		this.text.setText(initialText);
		this.getShell().setText(Messages.SaveAsDialog_SaveAs);
	}

	public String getText() {
		return this.text.getText();
	}

}
