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

import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;


/**
 * The Class SelectModelTemplateComposite.
 */
public class SelectModelTemplateComposite extends Composite {


	/** The template table viewer. */
	private TableViewer templateTableViewer;

	/**
	 * Instantiates a new select model template composite.
	 * 
	 * @param parent
	 *        the parent
	 */
	public SelectModelTemplateComposite(Composite parent) {
		super(parent, SWT.NONE);
		
		setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		GridLayout layout = new GridLayout();
		layout.marginWidth = layout.marginHeight = 0;
		setLayout(layout);
		createTemplatesViewer(this);
	}

	/**
	 * Creates the templates viewer.
	 * 
	 * @param composite
	 *        the composite
	 */
	private void createTemplatesViewer(Composite composite) {
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, false);
		templateTableViewer = CheckboxTableViewer.newCheckList(composite, SWT.NO_BACKGROUND);
		templateTableViewer.getTable().setBackground(composite.getBackground());
		templateTableViewer.getTable().setLayoutData(data);

		templateTableViewer.setContentProvider(new ModelTemplatesContentProvider());
		templateTableViewer.setLabelProvider(new ModelTemplatesLabelProvider());
		templateTableViewer.getControl().setEnabled(true);
		
		templateTableViewer.getTable().setLayout(new GridLayout());
	}

	/**
	 * Gets the template path.
	 * 
	 * @return the template path
	 */
	public String getTemplatePath() {
		//		if(this.useTemplateButton.getSelection()) {
		if(this.templateTableViewer.getSelection() instanceof IStructuredSelection) {
			Object first = ((IStructuredSelection)this.templateTableViewer.getSelection()).getFirstElement();
			if(first instanceof ModelTemplateDescription) {
				return ((ModelTemplateDescription)first).getPath();
			}
		}
		//		}

		return null;
	}

	/**
	 * Gets the template plugin id.
	 * 
	 * @return the template plugin id
	 */
	public String getTemplatePluginId() {
		//		if(this.useTemplateButton.getSelection()) {
		if(this.templateTableViewer.getSelection() instanceof IStructuredSelection) {
			Object first = ((IStructuredSelection)this.templateTableViewer.getSelection()).getFirstElement();
			if(first instanceof ModelTemplateDescription) {
				return ((ModelTemplateDescription)first).getPluginId();
			}
		}
		//		}

		return null;
	}

	/**
	 * Sets the input.
	 * 
	 * @param input
	 *        the new input
	 */
	public void setInput(Object input) {
		templateTableViewer.setInput(input);
	}

}
