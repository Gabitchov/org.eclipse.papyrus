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
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelConfiguration;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;


public class NattableWidgetPropertyTester extends PropertyTester {

	private static final String IS_NATTABLE_WIDGET = "isNattableWidget"; //$NON-NLS-1$

	private static final String IS_FEATURE_ROW_HEADER_CONFIGURATION = "isFeatureRowHeaderConfiguration";

	private static final String IS_FEATURE_COLUMN_HEADER_CONFIGURATION = "isFeatureColumnHeaderConfiguration";

	public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
		final IWorkbenchPart current = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService().getActivePart();
		if(current != null) {
			final INattableModelManager manager = (INattableModelManager)current.getAdapter(INattableModelManager.class);
			if(IS_NATTABLE_WIDGET.equals(property) && expectedValue instanceof Boolean) {
				return expectedValue.equals(manager != null);
			} else if(IS_FEATURE_ROW_HEADER_CONFIGURATION.equals(property) && expectedValue instanceof Boolean) {
				final ILabelConfiguration configuration = manager.getRowAxisConfiguration().getLabelConfiguration();
				return expectedValue.equals(configuration instanceof FeatureLabelProviderConfiguration);
			} else if(IS_FEATURE_COLUMN_HEADER_CONFIGURATION.equals(property) && expectedValue instanceof Boolean) {
				final ILabelConfiguration configuration = manager.getColumnAxisConfiguration().getLabelConfiguration();
				return expectedValue.equals(configuration instanceof FeatureLabelProviderConfiguration);

			}
		}
		return false;
	}
}
