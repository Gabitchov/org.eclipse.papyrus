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
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.properties.Activator;
import org.eclipse.papyrus.properties.contexts.Section;
import org.eclipse.papyrus.properties.contexts.Tab;
import org.eclipse.papyrus.properties.contexts.View;
import org.eclipse.papyrus.properties.messages.Messages;
import org.eclipse.papyrus.properties.runtime.DefaultDisplayEngine;
import org.eclipse.papyrus.properties.runtime.DisplayEngine;
import org.eclipse.papyrus.properties.xwt.XWTSection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionDialog;


/**
 * A dialog used to display an edition form for a given object.
 * The form is described by the given {@link View}s
 * 
 * @author Camille Letavernier
 */
public class EditionDialog extends SelectionDialog {

	private Set<View> views;

	private Object input;

	private Set<XWTSection> sections = new HashSet<XWTSection>();

	/**
	 * 
	 * Constructor.
	 * 
	 * @param shell
	 *        The shell in which the dialog will be opened
	 */
	protected EditionDialog(Shell shell) {
		super(shell);
	}

	@Override
	public void create() {
		setTitle(Messages.EditionDialog_CreateANewElement);
		super.create();
		getShell().setImage(Activator.getDefault().getImage("org.eclipse.papyrus.widgets", "/icons/papyrus.png")); //$NON-NLS-1$ //$NON-NLS-2$
		getShell().addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				dispose();
			}

		});

		display();

		//The values are data-binded, thus are edited in real time. It is not possible to cancel (However, Ctrl+Z should work)
		getButton(IDialogConstants.CANCEL_ID).setEnabled(false);
	}

	@Override
	public Composite getDialogArea() {
		return (Composite)super.getDialogArea();
	}

	/**
	 * Sets the object being edited by this dialog
	 * 
	 * @param input
	 */
	public void setInput(Object input) {
		this.input = input;
	}

	/**
	 * Sets the Views used to edit the input object
	 * 
	 * @param views
	 */
	public void setViews(Set<View> views) {
		this.views = views;
	}

	private void display() {
		DisplayEngine display = new DefaultDisplayEngine();

		IStructuredSelection selection = new StructuredSelection(input);

		Composite parent = new Composite(getDialogArea(), SWT.NONE);
		parent.setLayout(new FillLayout());
		parent.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		getShell().setSize(600, 400);

		Map<Tab, Composite> tabs = new LinkedHashMap<Tab, Composite>();

		for(View view : views) {
			for(Section section : view.getSections()) {
				tabs.put(section.getTab(), null);
			}
		}

		if(tabs.size() > 1) {
			//TODO : order tabs
			CTabFolder tabFolder = new CTabFolder(parent, SWT.BOTTOM);
			tabFolder.setLayout(new FillLayout());
			for(Tab tab : tabs.keySet()) {
				CTabItem item = new CTabItem(tabFolder, SWT.NONE);
				Composite tabControl = new Composite(tabFolder, SWT.NONE);
				item.setControl(tabControl);
				item.setText(tab.getLabel());
				tabs.put(tab, tabControl);
			}
		} else {
			Tab tab = tabs.keySet().iterator().next();
			tabs.put(tab, parent);
		}

		for(View view : views) {
			for(Section section : view.getSections()) {
				XWTSection xwtSection = new XWTSection(section, view, display);
				sections.add(xwtSection);

				xwtSection.createControls(tabs.get(section.getTab()), null);
				xwtSection.setInput(null, selection);
				xwtSection.refresh();
			}
		}

		getShell().pack();
	}

	/**
	 * Disposes this dialog
	 */
	public void dispose() {
		for(XWTSection section : sections) {
			section.dispose();
		}
		sections.clear();
	}

}
