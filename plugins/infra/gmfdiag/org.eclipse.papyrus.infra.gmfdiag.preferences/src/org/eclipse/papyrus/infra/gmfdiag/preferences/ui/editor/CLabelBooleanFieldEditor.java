/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.preferences.ui.editor;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;



/**
 * A field editor for a boolean type preference.
 * This field accepts 2 styles :
 * <ul>
 * <li>SWT.LEFT : the CLabel will be on the left</li>
 * <li>SWT.RIGHT : the CLabel will be on the right</li>
 * </ul>
 */
public class CLabelBooleanFieldEditor extends BooleanFieldEditor {

	/**
	 * A CLabel
	 */
	private CLabel cLabel = null;

	/**
	 * the checkbox
	 */
	private Button checkBox = null;

	/**
	 * Style bits. Either <code>SWT.LEFT</code> or <code>SWT.RIGHT</code>.
	 */
	private int style = SWT.LEFT;

	/**
	 * the image to display
	 */
	private Image image = null;

	/**
	 * Creates a boolean field editor in the given style.
	 * 
	 * @param preferenceKey
	 *        the name of the preference this field editor works on
	 * @param labelText
	 *        the label text of the field editor
	 * @param style
	 *        the style, either <code>SWT.LEFT</code> or <code>SWT.RIGHT</code>. If style value is different, we use <code>SWT.RIGHT</code> The style
	 *        allows to define if the label is on the left side or in the right side
	 * @param parent
	 *        the parent of the field editor's control
	 */
	public CLabelBooleanFieldEditor(String preferenceKey, String labelText, int style, Image im, Composite parent) {
		this.image = im;
		this.style = (SWT.LEFT == style ? SWT.LEFT : SWT.RIGHT);
		init(preferenceKey, labelText);
		createControl(parent);

	}

	/**
	 * 
	 * Constructor. This constructor build a CLabelFieldEditor with the label in the right of the checkbox.
	 * 
	 * @param preferenceKey
	 *        the key for the preference
	 * @param labelText
	 *        the label text
	 * @param im
	 *        an image to illustrate the preference
	 * @param parent
	 *        the composite parent
	 */
	public CLabelBooleanFieldEditor(String preferenceKey, String labelText, Image im, Composite parent) {
		this(preferenceKey, labelText, SWT.RIGHT, im, parent);
	}

	/**
	 * 
	 * @see org.eclipse.jface.preference.BooleanFieldEditor#doFillIntoGrid(org.eclipse.swt.widgets.Composite, int)
	 * 
	 * @param parent
	 * @param numColumns
	 */
	@Override
	protected void doFillIntoGrid(Composite parent, int numColumns) {
		GridData gd = new GridData();
		switch(this.style) {
		case SWT.LEFT:
			getCLabelControl(parent);
			checkBox = getChangeControl(parent);
			checkBox.setLayoutData(gd);
			break;
		case SWT.RIGHT:
			checkBox = getChangeControl(parent);
			checkBox.setLayoutData(gd);
			getCLabelControl(parent);
			break;
		default:
			break;
		}
	}

	/**
	 * Returns the label control.
	 * 
	 * @return the label control, or <code>null</code> if no label control has been created
	 */
	protected CLabel getCLabelControl() {
		return cLabel;
	}

	/**
	 * Returns this field editor's label component.
	 * <p>
	 * The label is created if it does not already exist
	 * </p>
	 * 
	 * @param parent
	 *        the parent
	 * @return the label control
	 */
	public CLabel getCLabelControl(Composite parent) {
		if(cLabel == null) {
			cLabel = new CLabel(parent, SWT.LEFT);
			cLabel.setFont(parent.getFont());

			if(image != null) {
				cLabel.setImage(image);
			}
			String text = getLabelText();
			if(text != null) {
				cLabel.setText(text);
			}
			cLabel.addDisposeListener(new DisposeListener() {

				public void widgetDisposed(DisposeEvent event) {
					cLabel = null;
				}
			});
		} else {
			checkParent(cLabel, parent);
		}
		return cLabel;
	}

	/*
	 * (non-Javadoc) Method declared on FieldEditor.
	 */
	public void setCLabelText(String text) {
		super.setLabelText(text);
		Assert.isNotNull(text);
		cLabel = getCLabelControl();
		if(cLabel == null && checkBox != null) {
			checkBox.setText(text);
		}
	}

	/*
	 * 
	 * The following methods are duplicated from BooleanFieldEditor, because, we need the style value before the end of the constructor execution!
	 */

	/**
	 * 
	 * @see org.eclipse.jface.preference.BooleanFieldEditor#adjustForNumColumns(int)
	 * 
	 * @param numColumns
	 */
	@Override
	protected void adjustForNumColumns(int numColumns) {
		//		if(style == SEPARATE_LABEL) {
		//			numColumns--;
		//		}
		//		((GridData)checkBox.getLayoutData()).horizontalSpan = numColumns;
	}

	/**
	 * 
	 * @see org.eclipse.jface.preference.BooleanFieldEditor#getDescriptionControl(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 * @return
	 */
	@Override
	public Control getDescriptionControl(Composite parent) {
		if(style == SEPARATE_LABEL) {
			return getLabelControl(parent);
		}
		return getChangeControl(parent);
	}

	/**
	 * 
	 * @see org.eclipse.jface.preference.BooleanFieldEditor#getNumberOfControls()
	 * 
	 * @return
	 */
	@Override
	public int getNumberOfControls() {
		return 2;
	}

	/**
	 * 
	 * @see org.eclipse.jface.preference.BooleanFieldEditor#setEnabled(boolean, org.eclipse.swt.widgets.Composite)
	 * 
	 * @param enabled
	 * @param parent
	 */
	@Override
	public void setEnabled(boolean enabled, Composite parent) {
		getCLabelControl(parent).setEnabled(enabled);
		getChangeControl(parent).setEnabled(enabled);
	}


}
