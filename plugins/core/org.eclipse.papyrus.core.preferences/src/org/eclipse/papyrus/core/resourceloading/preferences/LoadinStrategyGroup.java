/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.resourceloading.preferences;

import java.util.Map;

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.papyrus.core.resourceloading.impl.ProxyManager;
import org.eclipse.papyrus.preferences.ui.AbstractGroup;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class LoadinStrategyGroup extends AbstractGroup {

	private static final String LABEL_LOADING_STRATEGY = "Loading strategy: ";

	private static final String SELECT_LOADING_STRATEGY = "Select the loading strategy when model is opened";

	private ComboFieldEditor fComboSize;

	public LoadinStrategyGroup(Composite parent, String title, DialogPage dialogPage) {
		super(parent, title, dialogPage);
		createContent(parent);
	}

	public void createContent(Composite parent) {
		Group group = new Group(parent, SWT.SCROLL_PAGE);
		group.setLayout(new GridLayout());
		group.setText(SELECT_LOADING_STRATEGY);
		fComboSize = createComboSize(group);
		addFieldEditor(fComboSize);
	}

	private static ComboFieldEditor createComboSize(Group group) {
		String[][] values = getValuesFromExtensionPoint();
		ComboFieldEditor combo = new ComboFieldEditor(ICorePreferenceConstants.PREF_CORE_DEFINE_LOADING_STRATEGY, LABEL_LOADING_STRATEGY, values, group);
		return combo;
	}

	/**
	 * Gets the strategies value from extension point.
	 * 
	 * @return the strategies value
	 */
	private static String[][] getValuesFromExtensionPoint() {
		Map<Integer, String> allStrategies = ProxyManager.getAllStrategies();
		String[][] result = new String[allStrategies.size()][2];
		int i = 0;
		for(Integer val : allStrategies.keySet()) {
			result[i][0] = allStrategies.get(val);
			result[i][1] = String.valueOf(val);
			i++;
		}
		return result;
	}



}
