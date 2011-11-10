/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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

import org.eclipse.swt.widgets.Composite;

/**
 * A PropertyEditor for editing booleans with radio buttons.
 * This Editor should only be used with Enums which have only
 * a small amount of values.
 * 
 * @see org.eclipse.papyrus.infra.widgets.editors.EnumRadio
 * 
 * @author Camille Letavernier
 */
public class EnumRadio extends AbstractPropertyEditor {

	/**
	 * The EnumRadio widget
	 */
	protected org.eclipse.papyrus.infra.widgets.editors.EnumRadio enumRadio;

	private int numColumns = -1;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *        The composite in which the widget will be displayed
	 * @param style
	 *        The style for the widget
	 */
	public EnumRadio(Composite parent, int style) {
		super(new org.eclipse.papyrus.infra.widgets.editors.EnumRadio(parent, style));
		enumRadio = (org.eclipse.papyrus.infra.widgets.editors.EnumRadio)valueEditor;
	}

	/**
	 * Sets the maximum number of columns for this editor. The radio values
	 * will be distributed according to this number
	 * 
	 * @param numColumns
	 */
	public void setNumColumns(int numColumns) {
		this.numColumns = numColumns;
		enumRadio.setNumColumns(numColumns);
	}

	/**
	 * Return the maximum number of columns for this editor
	 * 
	 * @return
	 *         The number of columns for this editor
	 */
	public int getNumColumns() {
		return numColumns;
	}

	@Override
	protected void doBinding() {
		enumRadio.setProviders(input.getContentProvider(propertyPath), input.getLabelProvider(propertyPath));

		//enumRadio.setUnsettable(! input.isMandatory(propertyPath));

		super.doBinding();
	}
}
