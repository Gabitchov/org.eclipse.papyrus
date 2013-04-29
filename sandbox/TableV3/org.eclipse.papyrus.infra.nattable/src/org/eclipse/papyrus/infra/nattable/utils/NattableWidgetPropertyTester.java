/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.infra.nattable.utils;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;


public class NattableWidgetPropertyTester extends PropertyTester {

	private static final String IS_NATTABLE_WIDGET = "isNattableWidget"; //$NON-NLS-1$

	private static final String HAS_FEATURE_ROW_HEADER_CONFIGURATION = "hasFeatureRowHeaderConfiguration"; //$NON-NLS-1$

	private static final String HAS_FEATURE_COLUMN_HEADER_CONFIGURATION = "hasFeatureColumnHeaderConfiguration"; //$NON-NLS-1$

	public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
		final IWorkbenchPart current = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService().getActivePart();
		if(current != null) {
			final INattableModelManager manager = (INattableModelManager)current.getAdapter(INattableModelManager.class);
			if(IS_NATTABLE_WIDGET.equals(property) && expectedValue instanceof Boolean) {
				return expectedValue.equals(manager != null);
			} else if(HAS_FEATURE_ROW_HEADER_CONFIGURATION.equals(property) && expectedValue instanceof Boolean) {
				LabelConfigurationManagementUtils.getRowFeatureLabelConfigurationInTable(manager.getTable());
				return expectedValue.equals(LabelConfigurationManagementUtils.hasRowFeatureLabelConfiguration(manager.getTable()));
			} else if(HAS_FEATURE_COLUMN_HEADER_CONFIGURATION.equals(property) && expectedValue instanceof Boolean) {
				return expectedValue.equals(LabelConfigurationManagementUtils.hasColumnFeatureLabelConfiguration(manager.getTable()));
			}
		}
		return false;
	}
}
