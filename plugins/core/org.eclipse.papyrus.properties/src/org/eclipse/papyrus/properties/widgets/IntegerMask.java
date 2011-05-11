/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.widgets;

import org.eclipse.swt.widgets.Composite;

/**
 * A widget to edit mask-based Integer values
 * The integer value is interpreted as a list of boolean values
 * The widget cannot use more than 32 masks
 * 
 * @author Camille Letavernier
 */
public class IntegerMask extends AbstractPropertyEditor {

	private org.eclipse.papyrus.widgets.editors.IntegerMask editor;

	private MaskProvider maskProvider;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 *        The composite in which this widget will be created
	 * @param style
	 */
	public IntegerMask(Composite parent, int style) {
		editor = new org.eclipse.papyrus.widgets.editors.IntegerMask(parent, style);
		setEditor(editor);
	}

	@Override
	protected void checkInput() {
		if(propertyPath != null && input != null && maskProvider != null) {
			super.checkInput();
		}
	}

	@Override
	protected void doBinding() {
		super.doBinding();
	}

	/**
	 * @return the number of columns for this editor
	 * 
	 */
	public int getNumColumns() {
		return editor.getNumColumns();
	}

	/**
	 * Sets the number of columns for this editor. The mask checkboxes will be
	 * distributed according to this number
	 * 
	 * @param numColumns
	 */
	public void setNumColumns(int numColumns) {
		editor.setNumColumns(numColumns);
	}

	/**
	 * Sets the MaskProvider for this editor
	 * 
	 * @param provider
	 */
	public void setMaskProvider(MaskProvider provider) {
		this.maskProvider = provider;
		editor.setMasks(maskProvider.getMasks());
		checkInput();
	}

	/**
	 * 
	 * @return the MaskProvider associated to this editor
	 */
	public MaskProvider getMaskProvider() {
		return maskProvider;
	}
}
