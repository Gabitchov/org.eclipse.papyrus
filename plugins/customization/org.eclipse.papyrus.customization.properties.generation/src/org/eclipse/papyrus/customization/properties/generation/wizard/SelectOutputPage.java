/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Thibault Le Ouay t.leouay@sherpa-eng.com
 *****************************************************************************/

package org.eclipse.papyrus.customization.properties.generation.wizard;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.papyrus.customization.properties.generation.messages.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.uml2.uml.Package;

public class SelectOutputPage extends AbstractCreateContextPage implements Listener {

	private CheckboxTableViewer viewer;

	protected CCombo combo;

	private Table table;

	public SelectOutputPage() {
		super(Messages.SelectOutputPage_0);
	}

	public void createControl(Composite parent) {

		Composite root = new Composite(parent, SWT.NONE);
		root.setLayout(new GridLayout(1, false));

		combo = new CCombo(root, SWT.BORDER);
		setDescription(Messages.SelectOutputPage_1);
		combo.add(Messages.SelectOutputPage_2);
		combo.add(Messages.SelectOutputPage_3);
		combo.add(Messages.SelectOutputPage_4);
		combo.setEditable(false);
		combo.setBackground(new Color(combo.getDisplay(), 255, 255, 255));
		combo.select(0);
		combo.addListener(SWT.Selection, this);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		setControl(root);
		viewer = new CheckboxTableViewer(root, SWT.MULTI | SWT.H_SCROLL | SWT.FILL | SWT.FULL_SELECTION | SWT.BORDER);
		table = viewer.getTable();
		table.setVisible(false);
		table.setHeaderVisible(true);
		viewer.setContentProvider(new ArrayContentProvider());

		GridData gridData = new GridData();
		gridData.verticalAlignment = GridData.FILL;
		gridData.horizontalSpan = 1;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;

		viewer.getControl().setLayoutData(gridData);
		viewer.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {

				if(element instanceof EPackage) {
					EPackage p = (EPackage)element;
					return "Ecore package Name : " + p.getName(); //$NON-NLS-1$

				}
				if(element instanceof Package) {
					Package p = (Package)element;
					return "Profile name : " + p.getName(); //$NON-NLS-1$
				}
				return null;
			}

		});
		viewer.setInput(new Object());
		viewer.setSorter(new ViewerSorter());
		viewer.addCheckStateListener(new ICheckStateListener() {

			public void checkStateChanged(CheckStateChangedEvent event) {
				UpdateButton();

			}
		});
	}

	public void handleEvent(Event event) {

		if(combo.getSelectionIndex() != 0) {
			table.setVisible(true);

		} else {
			table.setVisible(false);
		}
		canFlipToNextPage();
		super.getContainer().updateButtons();
	}

	public void setSelectorData() {

		viewer.setInput(getWizard().generator.getExternalReference());
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);

		if(visible) {
			setSelectorData();
		}
	}

	@Override
	public IWizardPage getNextPage() {
		int selection = combo.getSelectionIndex();
		getWizard().selectFieldsPage.setTargetURI(getListPackage(selection));
		getWizard().generatorPage.setStrategy(selection);
		return getWizard().selectFieldsPage;
	}

	public List<URI> getListPackage(int selection) {
		List<URI> list = new ArrayList<URI>();

		if(selection == 0) {
			list.add(getWizard().generatorPage.oldURI);

		} else {
			for(Object o : viewer.getCheckedElements()) {
				if(o instanceof EPackage) {
					EPackage p = (EPackage)o;
					if(selection == 1) {
						list.add(getWizard().generatorPage.oldURI);
					} else {
						String temp = getWizard().generatorPage.oldURI.toString();
						temp = temp.substring(0, temp.lastIndexOf("/")); //$NON-NLS-1$
						String result = temp + "/" + p.getName() + ".ctx"; //$NON-NLS-1$ //$NON-NLS-2$
						list.add(URI.createURI(result, true));
					}
					getWizard().generator.addCheckElement(o);
				}
				if(o instanceof Package) {
					Package p = (Package)o;
					if(selection == 1) {
						list.add(getWizard().generatorPage.oldURI);
					} else {
						String temp = getWizard().generatorPage.oldURI.toString();
						temp = temp.substring(0, temp.lastIndexOf("/")); //$NON-NLS-1$
						String result = temp + "/" + p.getName() + ".ctx"; //$NON-NLS-1$ //$NON-NLS-2$
						list.add(URI.createURI(result, true));
					}
					getWizard().generator.addCheckElement(o);

				}

			}
		}
		return list;
	}

	@Override
	public boolean canFlipToNextPage() {
		if(combo.getSelectionIndex() != 0) {
			if(viewer.getCheckedElements().length == 0) {
				return false;
			}
		}
		return true;

	}

	public void UpdateButton() {
		canFlipToNextPage();
		super.getContainer().updateButtons();
	}
}
