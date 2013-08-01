/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.psf.ui;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionDialog;

/**
 * A Checkbox Dialog to filter the projects to be imported.
 * 
 * Note: the projects are represented by their PSF Reference, which is specific for each
 * team provider. The reference does not necessarily represent a single project
 * (Although it is the most common case)
 * 
 * @author Camille Letavernier
 */
public class FilterProjectsDialog extends SelectionDialog {



	public class PSFLabelProvider extends LabelProvider {

		@Override
		public String getText(Object element) {
			if(element instanceof String) {
				String ref = (String)element;

				char[] splitStrings = new char[]{ '/', ',', '\\' };

				int lastIndex = -1;
				for(char split : splitStrings) {
					lastIndex = Math.max(lastIndex, ref.lastIndexOf(split));
				}

				if(lastIndex == -1) {
					return ref;
				}
				return ref.substring(lastIndex + 1);
			}

			return super.getText(element);
		}
	}

	public class MapContentProvider implements ITreeContentProvider {

		public void dispose() {
			//Nothing
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			//Nothing
		}

		public Object[] getElements(Object inputElement) {
			if(inputElement instanceof Map<?, ?>) {
				return ((Map<?, ?>)inputElement).keySet().toArray();
			}
			return new Object[0];
		}

		public Object[] getChildren(Object parentElement) {
			if(parentElement instanceof String && providersToProjects.containsKey(parentElement)) {
				return providersToProjects.get(parentElement).toArray();
			}
			return new Object[0];
		}

		public Object getParent(Object element) {
			return null;
		}

		public boolean hasChildren(Object element) {
			return providersToProjects.containsKey(element);
		}

	}

	private final Map<String, List<String>> providersToProjects;

	private CheckboxTreeViewer treeViewer;

	public FilterProjectsDialog(Shell parentShell, Map<String, List<String>> providersToProjects) {
		super(parentShell);

		this.providersToProjects = providersToProjects;
	}

	@Override
	public void create() {
		setTitle("Select the projects to import");
		super.create();

		getShell().setMinimumSize(400, 450);
		getShell().pack();
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite dialogArea = (Composite)super.createDialogArea(parent);
		Composite self = new Composite(dialogArea, SWT.CHECK);

		self.setLayout(new GridLayout(1, true));
		self.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Label description = new Label(self, SWT.WRAP);
		description.setText("Select the projects to import");
		Label warning = new Label(self, SWT.WRAP);
		warning.setText("Note: Depending on the provider, project names may not be accurate");

		Composite buttonsBar = new Composite(self, SWT.NONE);
		buttonsBar.setLayoutData(new GridData(SWT.END, SWT.BEGINNING, true, false));
		buttonsBar.setLayout(new FillLayout());

		Button selectAll = new Button(buttonsBar, SWT.PUSH);
		selectAll.setText("Select all");


		Button unselectAll = new Button(buttonsBar, SWT.PUSH);
		unselectAll.setText("Unselect all");



		treeViewer = new CheckboxTreeViewer(self);

		treeViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		treeViewer.setContentProvider(new MapContentProvider());
		treeViewer.setLabelProvider(new PSFLabelProvider());
		treeViewer.setInput(providersToProjects);

		for(String key : providersToProjects.keySet()) {
			treeViewer.setSubtreeChecked(key, true);
		}

		//Propagate check to children
		treeViewer.addCheckStateListener(new ICheckStateListener() {

			public void checkStateChanged(CheckStateChangedEvent event) {
				treeViewer.setSubtreeChecked(event.getElement(), event.getChecked());
				computeGrayedRoots();
			}

		});

		selectAll.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				for(String provider : providersToProjects.keySet()) {
					treeViewer.setSubtreeChecked(provider, true);
					computeGrayedRoots();
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				//Nothing
			}
		});

		unselectAll.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				for(String provider : providersToProjects.keySet()) {
					treeViewer.setSubtreeChecked(provider, false);
					computeGrayedRoots();
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				//Nothing
			}
		});

		return dialogArea;
	}

	private void computeGrayedRoots() {
		provider: for(String provider : providersToProjects.keySet()) {

			boolean oneChecked = false;

			boolean oneUnchecked = false;

			for(String project : providersToProjects.get(provider)) {
				if(treeViewer.getChecked(project)) {
					oneChecked = true;
				} else {
					oneUnchecked = true;
				}

				if(oneChecked && oneUnchecked) {
					treeViewer.setGrayChecked(provider, true);
					continue provider; //Go to the next provider
				}
			}

			//We get here only when all projects under this provider have the same state (either checked or unchecked)
			treeViewer.setChecked(provider, oneChecked);
			treeViewer.setGrayed(provider, false);
		}
	}

	@Override
	protected void okPressed() {
		//Remove the unchecked projects/providers
		Iterator<String> providerIterator = providersToProjects.keySet().iterator();
		while(providerIterator.hasNext()) {
			String provider = providerIterator.next();
			if(!treeViewer.getChecked(provider)) { //Unchecked
				providerIterator.remove();
			} else { //Grayed or checked
				if(treeViewer.getGrayed(provider)) { //Grayed
					Iterator<String> projectIterator = providersToProjects.get(provider).iterator();
					while(projectIterator.hasNext()) {
						String project = projectIterator.next();
						if(!treeViewer.getChecked(project)) {
							projectIterator.remove();
						}
					}
				}
				//Else: checked, do nothing
			}
		}

		super.okPressed();
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	public boolean isHelpAvailable() {
		return false;
	}

	public Map<String, List<String>> getFilteredProjects() {
		return providersToProjects;
	}

}
