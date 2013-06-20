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

package org.eclipse.papyrus.qompass.designer.core.dialogs;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.dialogs.FilteredList;


public class DialogUtils {

	public static FilteredList createFilteredList(Composite parent, ILabelProvider labelProvider,
			int width, int height, int style) {
		FilteredList list = new FilteredList(parent, style, labelProvider,
				true, true, true);

		GridData data = new GridData();
		data.widthHint = width;
		// data.heightHint = convertHeightInCharsToPixels(height);
		data.heightHint = height;
		data.grabExcessVerticalSpace = true;
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = GridData.FILL;
		data.verticalAlignment = GridData.FILL;
		list.setLayoutData(data);
		list.setFont(parent.getFont());
		return list;
	}

	/*
	 * public static List createList (Composite parent, ILabelProvider labelProvider,
	 * int width, int height, int style)
	 * {
	 * style = SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | style;
	 * 
	 * List list = new List (parent, style);
	 * 
	 * GridData data = new GridData();
	 * data.widthHint = width;
	 * // data.heightHint = convertHeightInCharsToPixels(height);
	 * data.heightHint = height;
	 * data.grabExcessVerticalSpace = true;
	 * data.grabExcessHorizontalSpace = true;
	 * data.horizontalAlignment = GridData.FILL;
	 * data.verticalAlignment = GridData.FILL;
	 * list.setLayoutData(data);
	 * list.setFont (parent.getFont());
	 * return list;
	 * }
	 */

	public static Combo createComboWithText(Composite parent, String label, int flags, int compFlags) {
		Composite comboComposite = new Composite(parent, compFlags);
		comboComposite.setLayout(new GridLayout(2, false));
		Label comboLabel = new Label(comboComposite, SWT.NONE);
		comboLabel.setText(label);
		Combo combo = new Combo(comboComposite, flags);
		comboComposite.pack();
		return combo;
	}

	public static Button createButtonWithText(Composite parent, String label, int flags, int compFlags) {
		Composite buttonComposite = new Composite(parent, compFlags);
		buttonComposite.setLayout(new GridLayout(2, false));
		Label buttonLabel = new Label(buttonComposite, SWT.NONE);
		buttonLabel.setText(label);
		Button button = new Button(buttonComposite, flags);
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
