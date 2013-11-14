/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.widgets.toolbox.utils;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.dialogs.FilteredList;

/**
 * Some static utility functions in the context of dialogs
 */
public class DialogUtils {

	/**
	 * Create a filtered list that automatically uses the available space (@see createFillGridData)
	 * and a width & height hint
	 * 
	 * @param parent the parent composite 
	 * @param labelProvider the label provider for the filtered list
	 * @param width a with hint
	 * @param height a height hint
	 * @param style the style of the filtered list
	 * @return the created list
	 */
	public static FilteredList createFilteredList(Composite parent, ILabelProvider labelProvider,
			int width, int height, int style) {
		FilteredList list = new FilteredList(parent, style, labelProvider,
				true, true, true);

		GridData data = createFillGridData();
		data.widthHint = width;
		data.heightHint = height;
		list.setLayoutData(data);
		list.setFont(parent.getFont());
		return list;
	}

	/**
	 * Create a composite containing a label and a combo box within a given parent composite
	 * The label is positioned left of the button
	 * 
	 * @param parent the parent composite
	 * @param label the text of the label
	 * @param comboFlags SWT flags for the combo box
	 * @param compFlags SWT flags for the created composite (that contains combo and label)
	 * @return
	 */
	public static Combo createComboWithText(Composite parent, String label, int comboFlags, int compFlags) {
		Composite comboComposite = new Composite(parent, compFlags);
		comboComposite.setLayout(new GridLayout(2, false));
		Label comboLabel = new Label(comboComposite, SWT.NONE);
		comboLabel.setText(label);
		Combo combo = new Combo(comboComposite, comboFlags);
		comboComposite.pack();
		return combo;
	}

	/**
	 * Create a composite containing a label and a button within a given parent composite
	 * The label is positioned left of the combo box
	 * 
	 * @param parent the parent composite
	 * @param label the text of the label
	 * @param buttonFlags SWT flags for the button
	 * @param compFlags SWT flags for the created composite (that contains combo and label)
	 * @return
	 */
	public static Button createButtonWithText(Composite parent, String label, int buttonFlags, int compFlags) {
		Composite buttonComposite = new Composite(parent, compFlags);
		buttonComposite.setLayout(new GridLayout(2, false));
		Label buttonLabel = new Label(buttonComposite, SWT.NONE);
		buttonLabel.setText(label);
		Button button = new Button(buttonComposite, buttonFlags);
		buttonComposite.pack();
		return button;
	}

	/**
	 * Create a GridData object which fills the available vertical and horizontal space
	 * 
	 * @return
	 */
	public static GridData createFillGridData() {
		GridData gridData = new GridData();
		gridData.grabExcessVerticalSpace = true;
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		return gridData;
	}
}
