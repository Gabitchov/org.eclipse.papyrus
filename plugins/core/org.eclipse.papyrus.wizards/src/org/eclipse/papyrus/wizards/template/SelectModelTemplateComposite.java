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
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;


/**
 * The Class SelectModelTemplateComposite.
 */
public class SelectModelTemplateComposite extends Composite {


	/** The template table viewer. */
	private CheckboxTableViewer templateTableViewer;

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
		Object[] selected = templateTableViewer.getCheckedElements();
		if (selected.length > 0) {
			return ((ModelTemplateDescription)selected[0]).getPath();
		}
		return null;
	}

	/**
	 * Gets the template plugin id.
	 * 
	 * @return the template plugin id
	 */
	public String getTemplatePluginId() {
		Object[] selected = templateTableViewer.getCheckedElements();
		if (selected.length > 0) {
			return ((ModelTemplateDescription)selected[0]).getPluginId();
		}
		return null;
	}
	
	/**
	 * Select template.
	 *
	 * @param toSelect the to select
	 */
	public void selectElement(Object toSelect) {
		templateTableViewer.setCheckedElements(new Object[]{toSelect});
	}
	
	/**
	 * Gets the content provider.
	 *
	 * @return the content provider
	 */
	public ModelTemplatesContentProvider getContentProvider() {
		return (ModelTemplatesContentProvider)templateTableViewer.getContentProvider();
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
