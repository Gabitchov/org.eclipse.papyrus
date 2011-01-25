/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.creation;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.properties.contexts.Section;
import org.eclipse.papyrus.properties.contexts.View;
import org.eclipse.papyrus.properties.runtime.DefaultDisplayEngine;
import org.eclipse.papyrus.properties.runtime.DisplayEngine;
import org.eclipse.papyrus.properties.xwt.XWTSection;
import org.eclipse.papyrus.widgets.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionDialog;


public class EditionDialog extends SelectionDialog {

	private Set<View> views;

	private Object input;

	private Set<XWTSection> sections = new HashSet<XWTSection>();

	protected EditionDialog(Shell shell) {
		super(shell);
	}

	@Override
	public void create() {
		super.create();
		getShell().setImage(Activator.getImage("/icons/papyrus.png")); //$NON-NLS-1$
		getShell().addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				dispose();
			}

		});
		display();

		//The values are data-binded, thus are edited in real time.
		getButton(IDialogConstants.CANCEL_ID).setEnabled(false);
	}

	@Override
	public Composite getDialogArea() {
		return (Composite)super.getDialogArea();
	}

	public void setInput(Object input) {
		this.input = input;
	}

	public void setViews(Set<View> views) {
		this.views = views;
	}

	public void display() {
		DisplayEngine display = new DefaultDisplayEngine();

		IStructuredSelection selection = new StructuredSelection(input);

		Composite parent = new Composite(getDialogArea(), SWT.BORDER);
		parent.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		getShell().setSize(600, 400);

		for(View view : views) {
			for(Section section : view.getSections()) {
				XWTSection xwtSection = new XWTSection(section, view, display);
				sections.add(xwtSection);

				xwtSection.createControls(parent, null);
				xwtSection.setInput(null, selection);
				xwtSection.refresh();
			}
		}

		getShell().pack();
	}

	public void dispose() {
		for(XWTSection section : sections) {
			section.dispose();
		}
		sections.clear();
	}

}
