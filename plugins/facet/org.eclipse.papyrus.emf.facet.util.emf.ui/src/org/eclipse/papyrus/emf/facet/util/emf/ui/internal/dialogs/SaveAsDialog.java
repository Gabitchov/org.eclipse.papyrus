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
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IWithResultDialogCallback;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class SaveAsDialog extends Dialog {

	private URIComposite uriComposite;
	private final String initialText;
	private final IWithResultDialogCallback<String> callBack;

	public SaveAsDialog(final Shell parent, final String initialText,
			final IWithResultDialogCallback<String> callBack) {
		super(parent);
		this.initialText = initialText;
		this.callBack = callBack;
	}

	@Override
	protected Control createDialogArea(final Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		final Label text = new Label(composite, SWT.NONE);
		text.setText(Messages.SaveAsDialog_YouHaveToProvideAValidEMFURI);
		this.uriComposite = new URIComposite(composite, this.initialText);
		return composite;
	}

	@Override
	protected void cancelPressed() {
		cancelled();
	}

	public void cancelled() {
		final String text = this.uriComposite.getText();
		this.callBack.canceled(text);
		super.cancelPressed();
	}

	@Override
	protected void okPressed() {
		commit();
	}

	public void commit() {
		this.callBack.commited(this.uriComposite.getText());
		super.okPressed();
	}

}
