/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.tabbed.core.view.content;

import java.util.List;

import org.eclipse.papyrus.properties.runtime.controller.PropertyEditorController;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.w3c.dom.Node;

/**
 * Container descriptor for the groups
 */
public class GroupContainerDescriptor extends ContainerDescriptor {

	/** label for the folder */
	protected final String label;

	/**
	 * Creates a new SectionConfiguration.FolderContainerDescriptor.
	 * 
	 */
	public GroupContainerDescriptor(Layout layout, String label, Node containerNode) {
		super(layout, containerNode);
		this.label = label;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Group getDescribedComposite() {
		return (Group)super.getDescribedComposite();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<PropertyEditorController> createContent(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage, List<Object> objectsToEdit) {
		this.objectsToEdit = objectsToEdit;
		if(getDescribedComposite() == null || getDescribedComposite().isDisposed()) {
			setDescribedComposite(tabbedPropertySheetPage.getWidgetFactory().createGroup(parent, label));
			getDescribedComposite().setText(label);
			// creates the layout
			getDescribedComposite().setLayout(layout);
			getDescribedComposite().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		}

		controllers = updateControllers();

		return controllers;
	}
}
