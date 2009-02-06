/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.tabbedproperties.core.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * A figure with a label on the left and a composite on the right. Subclass can extends this class and provide an implementation for either {@link createRightControl(Composite parent,
 * TabbedPropertySheetPage tabbedPropertySheetPage)} or {@link createRightEditor(Composite, TabbedPropertySheetPage)}.
 * 
 * @author dumoulin
 * 
 */
public abstract class LabeledPropertyEditor extends AbstractPropertyEditor implements PropertyEditor {

	private String labelValue;

	private String description;

	private int labelPos = SWT.CENTER;

	/**
	 * Set to true if you want the right element be justified to the right end.
	 */
	private boolean isRightJustified = false;

	/**
	 * 
	 * @param label
	 * @param isRightJustified
	 *            Set to true if you want the right element be justified to the right end.
	 */
	public LabeledPropertyEditor(String label, boolean isRightJustified) {
		this.labelValue = label;
		this.isRightJustified = isRightJustified;
	}

	/**
     * 
     */
	public LabeledPropertyEditor(String label, String description) {
		this.labelValue = label;
		this.description = description;
	}

	/**
	 * Allows to specify the label position : SWT.CENTER SWT.TOP
	 */
	public LabeledPropertyEditor(String label, int labelPos) {
		this.labelValue = label;
		this.labelPos = labelPos;
	}

	/**
	 * Set to true if you want the right element be justified to the right end.
	 * 
	 * @param isRightJustified
	 *            the isRightJustified to set
	 */
	public void setRightJustified(boolean isRightJustified) {
		this.isRightJustified = isRightJustified;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.core.PropertyEditor#createControls(org.eclipse.swt.widgets.Composite, org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		if (parent instanceof ExpandableComposite) {
			((ExpandableComposite) parent).setClient(composite);
		}

		CLabel label = getWidgetFactory().createCLabel(composite, labelValue);
		label.setToolTipText(description);
		FormData data = new FormData();

		data.left = new FormAttachment(0, 0);
		data.top = new FormAttachment(0, 0);
		data.width = STANDARD_LABEL_WIDTH;
		label.setLayoutData(data);

		// Create associated composite
		Control leftControl = createRightControl(composite, tabbedPropertySheetPage);

		data = new FormData();
		data.left = new FormAttachment(label, -ITabbedPropertyConstants.VMARGIN);
		data.top = new FormAttachment(label, 0, labelPos);
		if (isRightJustified)
			data.right = new FormAttachment(100, 0);

		leftControl.setLayoutData(data);

		// return composite;
	}

	/**
	 * Create the right editor of the label. Subclasses can implements this method. Subclass should implement only one of createLeftControl() or createLeftEditor().
	 * 
	 * @param parent
	 * @param tabbedPropertySheetPage
	 * @return
	 */
	protected ControlWrapper createRightEditor(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		throw new UnsupportedOperationException("One of createRightEditor or createRightControl should be implemented by subclass.");
	}

	/**
	 * Create the left control. This method create the control that will be set to the right of the label. The default implementation delegate to createRightEditor(). Subclass should implement only
	 * one of createLeftControl() or createLeftEditor().
	 * 
	 * @param parent
	 * @param tabbedPropertySheetPage
	 * @return The created control.
	 */
	protected Control createRightControl(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		ControlWrapper editor = createRightEditor(parent, tabbedPropertySheetPage);
		editor.createControls(parent, tabbedPropertySheetPage);
		return editor.getControl();
	}

}
