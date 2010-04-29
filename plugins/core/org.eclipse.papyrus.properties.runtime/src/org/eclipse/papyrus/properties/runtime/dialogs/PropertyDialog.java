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
package org.eclipse.papyrus.properties.runtime.dialogs;

import java.util.List;

import org.eclipse.jface.dialogs.StatusDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;


/**
 * Dialog displaying properties of an element
 */
public class PropertyDialog extends StatusDialog {

	/** list of views in this dialog */
	private final List<String> viewsId;

	/** list of objects to edit */
	private final List<Object> objectsToEdit;

	/** widget factory */
	private final TabbedPropertySheetWidgetFactory widgetFactory;

	/**
	 * Creates a new PropertyDialog.
	 * 
	 * @param parent
	 *        the parent shell for this dialog
	 */
	public PropertyDialog(Shell parent, List<String> viewsId, List<Object> objectsToEdit, TabbedPropertySheetWidgetFactory widgetFactory) {
		super(parent);
		this.viewsId = viewsId;
		this.objectsToEdit = objectsToEdit;
		this.widgetFactory = widgetFactory;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite)super.createDialogArea(parent);

		// creates the content, given the configuration
		getWidgetFactory().createCLabel(composite, "Test dialog : " + objectsToEdit);


		return composite;
	}

	/**
	 * Returns the list of identifier of views for this dialog
	 * 
	 * @return the list of identifier of views for this dialog
	 */
	protected List<String> getViewsId() {
		return viewsId;
	}

	/**
	 * Returns the objects edited in this dialog
	 * 
	 * @return the objects edited in this dialog
	 */
	protected List<Object> getObjectsToEdit() {
		return objectsToEdit;
	}

	/**
	 * Returns the widget factory
	 * 
	 * @return the widget factory
	 */
	protected TabbedPropertySheetWidgetFactory getWidgetFactory() {
		return widgetFactory;
	}

}
