/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 408491
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.modelrepair.ui;

import java.io.IOException;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.emf.resource.DependencyManager;
import org.eclipse.papyrus.uml.modelrepair.Activator;
import org.eclipse.papyrus.uml.modelrepair.ui.providers.ResourceLabelProvider;
import org.eclipse.papyrus.uml.modelrepair.ui.providers.ResourceLinksContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;


public class ModelRepairDialog extends TrayDialog {

	private ModelSet modelSet;

	public ModelRepairDialog(Shell shell, ModelSet modelSet) {
		super(shell);

		this.modelSet = modelSet;
	}

	protected TreeViewer viewer;

	protected Tree tree;

	protected TreeEditor editor;

	protected Text textEditor;

	protected TreeItem currentSelection;

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite contents = (Composite)super.createDialogArea(parent);

		Composite self = new Composite(contents, SWT.NONE);
		self.setLayout(new GridLayout(1, false));
		self.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Label descriptionLabel = new Label(self, SWT.NONE);
		String description = "Press F2 or double click on an element to change its URI\n";
		description += "Edit a root element to modify all dependencies to the selected resource\n";
		description += "Edit a child element to modify only the dependencies from the root resource to the selected one\n";
		descriptionLabel.setText(description);

		descriptionLabel.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

		Label warningLabel = new Label(self, SWT.NONE);
		String warning = "/!\\ Modifying the dependencies between models may result into an inconsistent state and a corrupted model /!\\\n";
		warning += "Most corrupted model can be repaired with this tool";
		warningLabel.setText(warning);
		warningLabel.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED));

		warningLabel.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));


		viewer = new TreeViewer(self, SWT.FULL_SELECTION | SWT.BORDER);
		tree = viewer.getTree();
		TableLayout layout = new TableLayout();
		tree.setLayout(layout);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		tree.setHeaderVisible(true);


		TreeColumn nameColumn = new TreeColumn(tree, SWT.NONE);
		nameColumn.setText("Resource");
		layout.addColumnData(new ColumnWeightData(25, 250, true));

		TreeColumn locationColumn = new TreeColumn(tree, SWT.NONE);
		locationColumn.setText("Location");
		layout.addColumnData(new ColumnWeightData(45, 450, true));

		TreeColumn versionColumn = new TreeColumn(tree, SWT.NONE);
		versionColumn.setText("Read-only");
		layout.addColumnData(new ColumnWeightData(10, 100, true));


		viewer.setContentProvider(new ResourceLinksContentProvider());
		viewer.setLabelProvider(new ResourceLabelProvider(modelSet));
		viewer.setInput(modelSet);

		editor = new TreeEditor(tree);
		editor.setColumn(1);
		editor.horizontalAlignment = SWT.CENTER;
		editor.grabHorizontal = true;
		textEditor = new Text(tree, SWT.BORDER);

		textEditor.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				if(e.widget == textEditor) {
					validate();
				}
			}

			public void focusGained(FocusEvent e) {
				//Nothing
			}
		});

		textEditor.addKeyListener(new KeyListener() {

			public void keyReleased(KeyEvent e) {
				if(e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR) {
					validate();
					e.doit = false;
				}
			}

			public void keyPressed(KeyEvent e) {
				//Nothing
			}
		});

		viewer.getTree().addKeyListener(new KeyListener() {

			public void keyReleased(KeyEvent e) {
				if(e.keyCode == SWT.F2 && e.widget == tree) {
					editElement(tree);
				}
			}

			public void keyPressed(KeyEvent e) {
				//Nothing
			}
		});

		tree.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				//Nothing
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				//Double click
				if(e.widget == tree) {
					editElement(tree);
					e.doit = false;
				}
			}
		});

		return contents;
	}

	protected void editElement(Tree tree) {
		if(tree.getSelection().length == 0) {
			return;
		}

		currentSelection = tree.getSelection()[0];
		Object element = currentSelection.getData();
		textEditor.setText(((ILabelProvider)viewer.getLabelProvider()).getText(element));
		editor.setEditor(textEditor, currentSelection);
		textEditor.setFocus();
		textEditor.forceFocus();
		textEditor.setSelection(textEditor.getText().length()); //At the end
	}

	protected void validate() {
		editor.setEditor(null);
		textEditor.setVisible(false);

		if(currentSelection == null) {
			return;
		}

		TransactionalEditingDomain domain = TransactionalEditingDomain.Factory.INSTANCE.getEditingDomain(modelSet);
		domain.getCommandStack().execute(new RecordingCommand(domain, "Change URI") {

			@Override
			protected void doExecute() {
				doValidate();
			}

		});


		viewer.refresh();
	}

	protected void doValidate() {
		URI newURI = URI.createURI(textEditor.getText());

		URI uriToReplace;

		Resource fromResource = null;

		if(currentSelection.getParentItem() == null) { //We selected a root, which is a resource
			Object element = currentSelection.getData();

			if(element instanceof Resource) {
				uriToReplace = ((Resource)element).getURI();
			} else {
				return;
			}
		} else { //We selected a child, which is a URI. Its parent is a Resource.
			TreeItem parentItem = currentSelection.getParentItem();
			Object parentData = parentItem.getData();
			if(parentData instanceof Resource) {
				fromResource = (Resource)parentData;
			} else {
				return;
			}

			Object element = currentSelection.getData();

			if(element instanceof URI) {
				uriToReplace = (URI)element;
			} else {
				return;
			}
		}

		if(uriToReplace == null) {
			return;
		}

		if(uriToReplace.equals(newURI)) {
			return;
		}

		DependencyManager dependencyManager;
		if(fromResource == null) {
			dependencyManager = new DependencyManager(modelSet);
		} else {
			dependencyManager = new DependencyManager(fromResource);
		}
		dependencyManager.updateDependencies(uriToReplace, newURI, null, null);
	}

	@Override
	protected void okPressed() {
		try {
			modelSet.save(new NullProgressMonitor());
		} catch (IOException ex) {
			Activator.log.error(ex);
		}
		super.okPressed();
	}

	@Override
	public void create() {
		super.create();
		getShell().setText("Edit model links");
		getShell().pack();
	}


	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	public boolean isHelpAvailable() {
		return false;
	}

}
