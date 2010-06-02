/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.wizards.template;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;


/**
 * The Class SelectModelTemplateComposite.
 */
public class SelectModelTemplateComposite extends Composite {
	
	/** The new model button. */
	private Button newModelButton;

	/** The template table viewer. */
	private TableViewer templateTableViewer;
	
	/** The use template button. */
	private Button useTemplateButton;

	/**
	 * Instantiates a new select model template composite.
	 *
	 * @param parent the parent
	 */
	public SelectModelTemplateComposite(Composite parent) {
		super(parent, SWT.NONE);
		setLayout(new GridLayout());
		
		Group composite = new Group(this, 0);
		composite.setText("Creation  approach");

		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 20;
		gridLayout.marginTop = 10;
		gridLayout.verticalSpacing = 10;
		composite.setLayout(gridLayout);
		createDialogArea(composite);
	}
	
	/**
	 * Creates the dialog area.
	 *
	 * @param composite the composite
	 */
	private void createDialogArea(Composite composite) {
		createApproachSelectionButtons(composite);
		createTemplatesViewer(composite);
	}

	/**
	 * Creates the templates viewer.
	 *
	 * @param composite the composite
	 */
	private void createTemplatesViewer(Composite composite) {
		GridData data = new GridData(GridData.FILL_BOTH);
		templateTableViewer = new TableViewer(composite);
		templateTableViewer.getTable().setLayoutData(data);

		templateTableViewer.setContentProvider(new ModelTemplatesContentProvider());
		templateTableViewer.setLabelProvider(new ModelTemplatesLabelProvider());
		if(templateTableViewer.getTable().getItemCount() > 0) {
			IStructuredSelection ss = new StructuredSelection(templateTableViewer.getElementAt(0));
			templateTableViewer.setSelection(ss);
		} else {
			useTemplateButton.setEnabled(true);
		}
		templateTableViewer.getControl().setEnabled(false);
	}

	/**
	 * Creates the approach selection buttons.
	 *
	 * @param composite the composite
	 */
	private void createApproachSelectionButtons(Composite composite) {
		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		newModelButton = new Button(composite, SWT.RADIO);
		newModelButton.setText("Create new model");
		newModelButton.setLayoutData(data);
		newModelButton.setSelection(true);

		data = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		useTemplateButton = new Button(composite, SWT.RADIO);
		useTemplateButton.setText("Initialize from template");
		useTemplateButton.setLayoutData(data);
		useTemplateButton.setSelection(false);

		useTemplateButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}

			public void widgetSelected(SelectionEvent e) {
				if(useTemplateButton.getSelection()) {
					templateTableViewer.getControl().setEnabled(true);
				} else {
					templateTableViewer.getControl().setEnabled(false);
				}
			}

		});

	}
	
	/**
	 * Gets the template path.
	 *
	 * @return the template path
	 */
	public String getTemplatePath() {
		if(this.useTemplateButton.getSelection()) {
			if(this.templateTableViewer.getSelection() instanceof IStructuredSelection) {
				Object first = ((IStructuredSelection)this.templateTableViewer.getSelection()).getFirstElement();
				if(first instanceof ModelTemplateDescription) {
					return ((ModelTemplateDescription)first).getPath();
				}
			}
		}

		return null;
	}
	
	/**
	 * Gets the template plugin id.
	 *
	 * @return the template plugin id
	 */
	public String getTemplatePluginId() {
		if(this.useTemplateButton.getSelection()) {
			if(this.templateTableViewer.getSelection() instanceof IStructuredSelection) {
				Object first = ((IStructuredSelection)this.templateTableViewer.getSelection()).getFirstElement();
				if(first instanceof ModelTemplateDescription) {
					return ((ModelTemplateDescription)first).getPluginId();
				}
			}
		}

		return null;
	}

	/**
	 * Sets the input.
	 *
	 * @param input the new input
	 */
	public void setInput(Object input) {
		templateTableViewer.setInput(input);
	}

}	
	
