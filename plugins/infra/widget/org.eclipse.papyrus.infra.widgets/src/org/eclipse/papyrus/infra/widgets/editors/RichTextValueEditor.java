/*****************************************************************************
 * Copyright (c) 2014 CEA
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.editors;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.epf.richtext.extension.RichText;
import org.eclipse.epf.richtext.extension.RichTextEditor;
import org.eclipse.papyrus.infra.widgets.databinding.RichTextObservableValue;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;


// TODO: Auto-generated Javadoc
/**
 * The Class RichTextValueEditor.
 */
public class RichTextValueEditor extends AbstractValueEditor {

	//track the modification
	/** The is page modified. */
	private boolean isPageModified;

	/** The is read only. */
	private boolean isReadOnly = false;

	/** The rich text editor. */
	private RichTextEditor richTextEditor;

	/**
	 * Instantiates a new rich text value editor.
	 *
	 * @param parent
	 *        the parent
	 * @param style
	 *        the style
	 */
	protected RichTextValueEditor(Composite parent, int style) {
		super(parent, style);

		createRichTextEditor(parent);
		setCommitOnFocusLost(richTextEditor.getControl());
	}

	/**
	 * Gets the rich text.
	 *
	 * @return the rich text
	 */
	public RichTextEditor getRichTextEditor() {
		return richTextEditor;
	}

	/**
	 * Gets the new editor.
	 *
	 * @return the new editor
	 */
	public RichTextEditor getNewEditor() {
		return richTextEditor;
	}

	/**
	 * Sets the new editor.
	 *
	 * @param newEditor
	 *        the new new editor
	 */
	public void setNewEditor(RichTextEditor newEditor) {
		this.richTextEditor = newEditor;
	}

	/**
	 * Creates the rich text editor.
	 *
	 * @param parent
	 *        the parent
	 */
	public void createRichTextEditor(Composite parent) {
		try {
			richTextEditor = new RichTextEditor(parent, SWT.NONE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see org.eclipse.papyrus.infra.widgets.editors.AbstractValueEditor#getValue()
	 *
	 * @return
	 */
	@Override
	public String getValue() {
		return richTextEditor.getText();
	}

	/**
	 * @see org.eclipse.papyrus.infra.widgets.editors.AbstractEditor#getEditableType()
	 *
	 * @return
	 */

	@Override
	public Object getEditableType() {
		return RichText.class;
	}

	/**
	 * @see org.eclipse.papyrus.infra.widgets.editors.AbstractEditor#setReadOnly(boolean)
	 *
	 * @param readOnly
	 */

	@Override
	public void setReadOnly(boolean readOnly) {
		isReadOnly = readOnly;
	}

	/**
	 * @see org.eclipse.papyrus.infra.widgets.editors.AbstractEditor#isReadOnly()
	 *
	 * @return
	 */

	@Override
	public boolean isReadOnly() {
		return isReadOnly;
	}

	/**
	 * @see org.eclipse.papyrus.infra.widgets.editors.AbstractEditor#setToolTipText(java.lang.String)
	 *
	 * @param tooltip
	 */

	@Override
	public void setToolTipText(String tooltip) {
		super.setLabelToolTipText(tooltip);
	}

	/**
	 * Sets the current text value for this editor.
	 *
	 * @param value
	 *        the new value
	 */
	public void setValue(Object value) {
		if(value instanceof String) {
			this.richTextEditor.setText((String)value);
		} else {
			this.richTextEditor.setText(""); //$NON-NLS-1$;
		}
	}


	/**
	 * @see org.eclipse.papyrus.infra.widgets.editors.AbstractValueEditor#setModelObservable(org.eclipse.core.databinding.observable.value.IObservableValue)
	 *
	 * @param observable
	 */

	@Override
	public void setModelObservable(IObservableValue observable) {
		setWidgetObservable(new RichTextObservableValue(richTextEditor, observable, SWT.FocusOut), true); //SWT.FocusOut
		super.setModelObservable(observable);
	}
}
