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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IAxisConfiguration;

/**
 * 
 * @author VL222926
 * 
 */
public class AxisConfigurationUtils {

	private AxisConfigurationUtils() {
		//to prevent instanciation
	}

	/**
	 * 
	 * @param table
	 *        the table
	 * @param eClass
	 *        the eclass of the wanted configuration
	 * @param onColumn
	 *        <code>true</code> if we want a column configuration and false if we want a row configuration
	 * @return
	 */
	public static IAxisConfiguration getIAxisConfigurationUsedInTable(final Table table, final EClass eClass, final boolean onColumn) {
		IAxisConfiguration iAxisConfiguration = null;
		final Collection<AbstractHeaderAxisConfiguration> headerConfigurations = new ArrayList<AbstractHeaderAxisConfiguration>();
		if(onColumn) {
			AbstractHeaderAxisConfiguration localConf = HeaderAxisConfigurationManagementUtils.getColumnAbstractHeaderAxisInTable(table);
			if(localConf != null) {
				headerConfigurations.add(localConf);
			}
			localConf = HeaderAxisConfigurationManagementUtils.getColumnAbstractHeaderAxisInTableConfiguration(table);
			if(localConf != null) {
				headerConfigurations.add(localConf);
			}
		} else {
			AbstractHeaderAxisConfiguration localConf = HeaderAxisConfigurationManagementUtils.getRowAbstractHeaderAxisInTable(table);
			if(localConf != null) {
				headerConfigurations.add(localConf);
			}
			localConf = HeaderAxisConfigurationManagementUtils.getRowAbstractHeaderAxisInTableConfiguration(table);
			if(localConf != null) {
				headerConfigurations.add(localConf);
			}
		}
		final Iterator<AbstractHeaderAxisConfiguration> iter = headerConfigurations.iterator();
		while(iter.hasNext() && iAxisConfiguration == null) {
			final Iterator<IAxisConfiguration> confIter = iter.next().getOwnedAxisConfigurations().iterator();
			while(confIter.hasNext() && iAxisConfiguration == null) {
				final IAxisConfiguration current = confIter.next();
				if(current.eClass() == eClass) {
					iAxisConfiguration = current;
				}
			}
		}
		return iAxisConfiguration;
	}
}
