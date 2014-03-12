/*****************************************************************************
 * Copyright (c) 2010, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 404874
 *  
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.creation;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.papyrus.views.properties.contexts.Section;
import org.eclipse.papyrus.views.properties.contexts.Tab;
import org.eclipse.papyrus.views.properties.contexts.View;
import org.eclipse.papyrus.views.properties.messages.Messages;
import org.eclipse.papyrus.views.properties.runtime.DefaultDisplayEngine;
import org.eclipse.papyrus.views.properties.runtime.DisplayEngine;
import org.eclipse.papyrus.views.properties.xwt.XWTSection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
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
//TODO : This dialog should use the Embedded Display Engine
public class EditionDialog extends SelectionDialog {

	private Set<View> views;

	private Object input;

	private Set<XWTSection> sections = new HashSet<XWTSection>();

	private boolean cancelable = false;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param shell
	 *        The shell in which the dialog will be opened
	 * @param cancelable
	 *        Whether the cancel button is active or not. The values are data-binded, ie.
	 *        edited in real time, before the ok button is pressed. If the cancel button
	 *        is active, callers are responsible for undoing the changes.
	 */
	protected EditionDialog(Shell shell, boolean cancelable) {
		super(shell);
		this.cancelable = cancelable;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param shell
	 *        The shell in which the dialog will be opened
	 */
	protected EditionDialog(Shell shell) {
		this(shell, false);
	}

	@Override
	public void create() {
		super.create();
		if(getShell().getText() == null || "".equals(getShell().getText())) { //$NON-NLS-1$
			setTitle(Messages.EditionDialog_CreateANewElement);
		}
		getShell().setImage(Activator.getDefault().getImage("org.eclipse.papyrus.infra.widgets", "/icons/papyrus.png")); //$NON-NLS-1$ //$NON-NLS-2$
		getShell().addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				dispose();
			}

		});

		display();

		//The values are data-binded, thus are edited in real time. It is not possible to cancel (However, Ctrl+Z should work)
		getButton(IDialogConstants.CANCEL_ID).setEnabled(cancelable);
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

		final Set<Tab> tabsList = new LinkedHashSet<Tab>();

		for(View view : views) {
			for(Section section : view.getSections()) {
				tabsList.add(section.getTab());
			}
		}

		List<Tab> allTabs = new LinkedList<Tab>(tabsList);

		Collections.sort(allTabs, new Comparator<Tab>() {

			/**
			 * compares two tabs each other
			 * 
			 * @param tab1
			 *        first tab to compare
			 * @param tab2
			 *        second tab to compare
			 * @return a negative integer if the first tab should be placed before the second tab
			 */
			public int compare(Tab tab1, Tab tab2) {
				int priority1 = getPriority(tab1);
				int priority2 = getPriority(tab2);

				if(priority1 < priority2) {
					return -1;
				}

				if(priority1 > priority2) {
					return 1;
				}

				//p1 == p2

				priority1 = getXWTTabPriority(tab1);
				priority2 = getXWTTabPriority(tab2);

				if(priority1 < priority2) {
					return -1;
				}

				if(priority1 > priority2) {
					return 1;
				}

				//p1 == p2

				String label1 = tab1.getLabel();
				String label2 = tab2.getLabel();

				return Collator.getInstance().compare(label1, label2);
			}

			private Tab getPreviousTab(Tab tab) {
				Tab afterTab = tab.getAfterTab();
				if(tabsList.contains(afterTab)) {
					return afterTab;
				}

				// not found. Return null
				return null;
			}

			private int getPriority(Tab tab) {
				Tab previousTab = getPreviousTab(tab);
				if(previousTab != null) {
					return getPriority(previousTab) + 1;
				}

				return getXWTTabPriority(tab);
			}

			private int getXWTTabPriority(Tab tab) {
				return tab.getPriority();
			}

		});

		Map<Tab, Composite> tabs = new LinkedHashMap<Tab, Composite>();
		if(allTabs.size() > 1) {
			CTabFolder tabFolder = new CTabFolder(parent, SWT.BOTTOM);
			tabFolder.setSelectionBackground(new Color[]{ tabFolder.getDisplay().getSystemColor(SWT.COLOR_WHITE), tabFolder.getBackground() }, new int[]{ 100 }, true);
			tabFolder.setLayout(new FillLayout());
			for(Tab tab : allTabs) {
				CTabItem item = new CTabItem(tabFolder, SWT.NONE);
				Composite tabControl = new Composite(tabFolder, SWT.NONE);
				item.setControl(tabControl);
				item.setText(tab.getLabel());
				tabs.put(tab, tabControl);
			}
		} else if(!allTabs.isEmpty()) {
			Tab tab = allTabs.get(0);
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
		Point size = getShell().getSize();
		int minWidth = 600;
		if(size.x < minWidth) {
			size.x = minWidth;
		}
		getShell().setSize(size);
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

	@Override
	protected void okPressed() {
		// Bug 404874: Work-around for Mac platform, where finishing the dialog does not trigger
		// focus-lost on the last edited control (which would commit its changes)
		getOkButton().forceFocus();
		super.okPressed();
	}
}
