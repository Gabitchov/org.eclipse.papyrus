/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.usecase.ui;

import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

/**
 * code generated to create this chooser of metaclasses to create a subject
 */
public class AbstractSubjectMetaclassesSelectionDialog extends Dialog {

	protected Object result;

	protected Shell shlmetaclassSelection;

	protected Table table;

	protected Button btnOk;

	protected Button btnCancel;

	/**
	 * Create the dialog.
	 * 
	 * @param parent
	 * @param style
	 */
	public AbstractSubjectMetaclassesSelectionDialog(Shell parent, int style) {
		super(parent, SWT.DIALOG_TRIM | SWT.PRIMARY_MODAL);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * 
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlmetaclassSelection.open();
		shlmetaclassSelection.layout();
		Display display = getParent().getDisplay();
		while(!shlmetaclassSelection.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	protected void createContents() {
		shlmetaclassSelection = new Shell(getParent(), getStyle());
		shlmetaclassSelection.setSize(501, 250);
		shlmetaclassSelection.setText("Subject Metaclasses Selection");
		shlmetaclassSelection.setLayout(new FillLayout(SWT.HORIZONTAL));
		Composite composite = new Composite(shlmetaclassSelection, SWT.NONE);
		composite.setLayout(null);
		composite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		Label lblSelectTheAssociation = new Label(composite, SWT.NONE);
		lblSelectTheAssociation.setLocation(24, 10);
		lblSelectTheAssociation.setSize(441, 30);
		lblSelectTheAssociation.setText("A subject can be a classfier, choose your concrete classifier:");
		lblSelectTheAssociation.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		FontData[] fontdatas = { new FontData("Tahoma", 9, SWT.BOLD) };
		lblSelectTheAssociation.setFont(Activator.getFontManager().get(fontdatas));
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(25, 48, 440, 130);
		btnOk = new Button(composite, SWT.NONE);
		btnOk.setBounds(396, 180, 68, 23);
		btnOk.setText("Ok");
		btnCancel = new Button(composite, SWT.NONE);
		btnCancel.setBounds(291, 180, 68, 23);
		btnCancel.setText("Cancel");
	}
}
