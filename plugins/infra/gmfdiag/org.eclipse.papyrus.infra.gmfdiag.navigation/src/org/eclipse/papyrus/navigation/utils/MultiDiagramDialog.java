/*******************************************************************************
 * Copyright (c) 2011 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Anass RADOUANI (AtoS)
 *******************************************************************************/

package org.eclipse.papyrus.navigation.utils;

import java.util.List;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.modelexplorer.MoDiscoLabelProvider;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;

/**
 * This class Provide a dialog filled with a list of reachable diagrams
 * 
 * @author aradouan
 * 
 */
public class MultiDiagramDialog extends Dialog {

	private List<Diagram> diagrams;

	private Composite dialogComposite;

	protected int selectedDiagram;

	private Table table;

	private TableViewer list;

	public int getSelectedDiagram() {
		return selectedDiagram;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(Messages.MultiDiagramDialog_0);
	}

	public MultiDiagramDialog(Shell parentShell, List<Diagram> diagrams) {
		super(parentShell);
		this.diagrams = diagrams;
		setShellStyle(getShellStyle() | SWT.RESIZE);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		dialogComposite = (Composite)super.createDialogArea(parent);
		parent.setLayout(new GridLayout());
		dialogComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		createDialogComposite();
		createDialogContents(dialogComposite);
		hookListeners();
		loadData();
		defaultSelection();

		return dialogComposite;
	}

	private void createDialogContents(Composite parent) {
		dialogComposite.setLayout(new GridLayout(1, false));
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		Label lblDiagrams = new Label(composite, SWT.NONE);
		lblDiagrams.setText(Messages.MultiDiagramDialog_1);

		Composite composite_1 = new Composite(parent, SWT.NONE);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		composite_1.setLayout(new GridLayout(1, false));

		list = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.H_SCROLL);
		list.setUseHashlookup(true);
		table = list.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		list.setLabelProvider(new MoDiscoLabelProvider());
		list.setContentProvider(new IStructuredContentProvider() {

			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}

			public void dispose() {
			}

			public Object[] getElements(Object inputElement) {
				if(inputElement instanceof List) {
					return ((List)inputElement).toArray();
				} else {
					return new Object[]{ inputElement };
				}
			}
		});
	}

	private void createDialogComposite() {
		GridData dialogLayoutData = new GridData(GridData.FILL_BOTH);
		dialogComposite.setLayoutData(dialogLayoutData);

	}

	private void hookListeners() {
		table.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				MultiDiagramDialog.this.selectedDiagram = table.getSelectionIndex();
			}

		});
	}

	private void loadData() {
		list.setInput(diagrams);
	}

	private void defaultSelection() {
		boolean found = false;
		IPageMngr pageMngr;
		try {
			pageMngr = EditorUtils.getServiceRegistry().getService(IPageMngr.class);

			for(Diagram diagram : diagrams) {
				if(pageMngr.isOpen(diagram)) {
					table.select(diagrams.indexOf(diagram));
					found = true;
					break;
				}
			}

			if(!found) {
				int diagFound = 0;
				int diagFoundTemp = 0;
				for(Diagram diagram : diagrams) {
					diagFoundTemp = pageMngr.isInHsitory(diagram);
					if(diagFoundTemp > diagFound) {
						diagFound = diagFoundTemp;
						table.select(diagrams.indexOf(diagram));
						found = true;
					}
				}
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		if(!found) {
			table.select(0);
		}
	}
}
