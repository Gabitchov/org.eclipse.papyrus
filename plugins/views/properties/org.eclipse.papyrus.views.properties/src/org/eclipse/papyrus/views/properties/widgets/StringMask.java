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
package org.eclipse.papyrus.views.properties.widgets;

import org.eclipse.papyrus.views.properties.providers.XWTCompliantMaskProvider;
import org.eclipse.papyrus.views.properties.providers.XWTCompliantMaskProviderListener;
import org.eclipse.swt.widgets.Composite;

/**
 * A widget to edit mask-based Integer values
 * The integer value is interpreted as a list of boolean values
 * The widget cannot use more than 32 masks
 *
 * @author Camille Letavernier
 */
public class StringMask extends AbstractPropertyEditor implements XWTCompliantMaskProviderListener {

	private org.eclipse.papyrus.infra.widgets.editors.StringMask editor;

	private XWTCompliantMaskProvider maskProvider;

	private boolean maskProviderReady = false;

	/**
	 *
	 * Constructor.
	 *
	 * @param parent
	 *        The composite in which this widget will be created
	 * @param style
	 */
	public StringMask(Composite parent, int style) {
		editor = createStringMask(parent, style);
		setEditor(editor);
	}

	/**
	 * Creates the integer mask.
	 *
	 * @param parent
	 *        The composite in which the widget will be displayed
	 * @param style
	 *        The style for the widget
	 * @return the integer mask.
	 */
	protected org.eclipse.papyrus.infra.widgets.editors.StringMask createStringMask(Composite parent, int style) {
		return new org.eclipse.papyrus.infra.widgets.editors.StringMask(parent, style);
	}

	@Override
	protected void checkInput() {
		if(maskProvider != null && maskProviderReady) {
			super.checkInput();
		}
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
	public void setMaskProvider(XWTCompliantMaskProvider provider) {
		if(this.maskProvider != null) {
			maskProvider.removeMaskProviderListener(this);
		}

		maskProviderReady = false;
		this.maskProvider = provider;
		provider.addMaskProviderListener(this);
		checkInput();
	}

	/**
	 *
	 * @return the MaskProvider associated to this editor
	 */
	public XWTCompliantMaskProvider getMaskProvider() {
		return maskProvider;
	}

	public void notifyReady(XWTCompliantMaskProvider provider) {
		this.maskProviderReady = true;
		editor.setMasks(maskProvider.getMasks());
		provider.removeMaskProviderListener(this);
		checkInput();
	}
}
