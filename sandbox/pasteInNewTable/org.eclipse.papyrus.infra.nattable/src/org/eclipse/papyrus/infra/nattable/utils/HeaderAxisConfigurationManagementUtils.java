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

import org.eclipse.emf.validation.internal.service.GetLiveConstraintsOperation;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.LocalTableHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.TableHeaderAxisConfiguration;

/**
 * Utils class for AxisConfiguration
 * 
 * @author Vincent Lorenzo
 * 
 */
public class HeaderAxisConfigurationManagementUtils {

	private HeaderAxisConfigurationManagementUtils() {
		//to prevent instanciation
	}

	/**
	 * 
	 * @param table
	 *        a table
	 * @return
	 *         the header configuration defined in the table and used for rows, mananing the inversion of the axis or <code>null</code> if we aer
	 *         using the
	 *         configuration defined in the table configuration
	 */
	public static final AbstractHeaderAxisConfiguration getRowAbstractHeaderAxisInTable(final Table table) {
		AbstractHeaderAxisConfiguration config = table.getLocalRowHeaderAxisConfiguration();
		if(table.isInvertAxis()) {
			config = table.getLocalColumnHeaderAxisConfiguration();
		}
		return config;
	}

	/**
	 * 
	 * @param table
	 *        a table
	 * @return
	 *         the header configuration defined in the tableconfiguration for rows, mananing the inversion of the axis. The result can't be
	 *         <code>null</code>
	 */
	public static final AbstractHeaderAxisConfiguration getRowAbstractHeaderAxisInTableConfiguration(final Table table) {
		AbstractHeaderAxisConfiguration config = table.getTableConfiguration().getRowHeaderAxisConfiguration();
		if(table.isInvertAxis()) {
			config = table.getTableConfiguration().getColumnHeaderAxisConfiguration();
		}
		assert config != null;
		return config;
	}

	/**
	 * 
	 * @param table
	 *        the table
	 * @return
	 *         the header configuration used for rows in the table. The result can't be <code>null</code>
	 */
	public static final AbstractHeaderAxisConfiguration getAbstractHeaderAxisConfigurationUsedInTable(final Table table) {
		AbstractHeaderAxisConfiguration config = getRowAbstractHeaderAxisInTable(table);
		if(config == null) {
			config = getRowAbstractHeaderAxisInTableConfiguration(table);
		}
		assert config != null;
		return config;
	}

	/**
	 * 
	 * @param table
	 *        a table
	 * @return
	 *         the header configuration defined in the table and used for columns, managing the inversion of the axis or <code>null</code> if we are
	 *         using the configuration defined in the table configuration
	 */
	public static final AbstractHeaderAxisConfiguration getColumnAbstractHeaderAxisInTable(final Table table) {
		AbstractHeaderAxisConfiguration config = table.getLocalColumnHeaderAxisConfiguration();
		if(table.isInvertAxis()) {
			config = table.getLocalRowHeaderAxisConfiguration();
		}
		return config;
	}

	/**
	 * 
	 * @param table
	 *        a table
	 * @return
	 *         the header configuration defined in the tableconfiguration for columns, mananing the inversion of the axis. The result can't be
	 *         <code>null</code>
	 */
	public static final AbstractHeaderAxisConfiguration getColumnAbstractHeaderAxisInTableConfiguration(final Table table) {
		AbstractHeaderAxisConfiguration config = table.getTableConfiguration().getColumnHeaderAxisConfiguration();
		if(table.isInvertAxis()) {
			config = table.getTableConfiguration().getRowHeaderAxisConfiguration();
		}
		assert config != null;
		return config;
	}

	/**
	 * 
	 * @param table
	 *        the table
	 * @return
	 *         the header configuration used for columns in the table. The result can't be <code>null</code>
	 */
	public static final AbstractHeaderAxisConfiguration getColumnAbstractHeaderAxisUsedInTable(final Table table) {
		AbstractHeaderAxisConfiguration config = getColumnAbstractHeaderAxisInTable(table);
		if(config == null) {
			config = getColumnAbstractHeaderAxisInTableConfiguration(table);
		}
		assert config != null;
		return config;
	}

	/**
	 * 
	 * @param table
	 *        the table
	 * @return
	 *         the header configuration used for row in the table. The result can't be <code>null</code>
	 */
	public static final AbstractHeaderAxisConfiguration getRowAbstractHeaderAxisUsedInTable(final Table table) {
		AbstractHeaderAxisConfiguration config = getRowAbstractHeaderAxisInTable(table);
		if(config == null) {
			config = getRowAbstractHeaderAxisInTableConfiguration(table);
		}
		assert config != null;
		return config;
	}

	/**
	 * 
	 * @param configuration
	 *        the configuration to duplicate
	 * @return
	 *         the {@link LocalTableHeaderAxisConfiguration} mapped on the {@link TableHeaderAxisConfiguration}
	 */
	public static LocalTableHeaderAxisConfiguration transformToLocalHeaderConfiguration(final TableHeaderAxisConfiguration configuration) {
		LocalTableHeaderAxisConfiguration conf = NattableaxisconfigurationFactory.eINSTANCE.createLocalTableHeaderAxisConfiguration();
		conf.setDisplayFilter(configuration.isDisplayFilter());
		conf.setDisplayIndex(configuration.isDisplayIndex());
		conf.setDisplayLabel(configuration.isDisplayLabel());
		conf.setIndexStyle(configuration.getIndexStyle());
		return conf;
	}

}
