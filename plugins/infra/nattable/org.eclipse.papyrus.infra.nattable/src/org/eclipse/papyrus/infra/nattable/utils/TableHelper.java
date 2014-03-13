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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattableFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration;

/**
 * 
 * @author Vincent Lorenzo
 * 
 */
public class TableHelper {

	private TableHelper() {
		//to prevent instanciation
	}

	/**
	 * 
	 * @param configuration
	 *        the configuration used to create the table
	 * @return
	 *         the table created from this configuration
	 */
	public static final Table createTable(final TableConfiguration configuration) {
		return createTable(configuration, null);
	}

	/**
	 * 
	 * @param configuration
	 *        the configuration used to create the table
	 * @param context
	 *        the context of the table
	 * @return
	 *         the table created from these parameters
	 */
	public static final Table createTable(final TableConfiguration configuration, final EObject context) {
		return createTable(configuration, null, null);
	}

	/**
	 * 
	 * @param configuration
	 *        the configuration used to create the table
	 * @param context
	 *        the context of the table
	 * @param name
	 *        the name for the table
	 * @return
	 *         the table created from these parameters
	 */
	public static final Table createTable(final TableConfiguration configuration, final EObject context, final String name) {
		return createTable(configuration, null, null, null);
	}

	/**
	 * 
	 * @param configuration
	 *        the configuration used to create the table
	 * @param context
	 *        the context of the table
	 * @param name
	 *        the name for the table
	 * @param description
	 *        the description for the table
	 * @return
	 *         the table created from these parameters
	 */
	public static final Table createTable(final TableConfiguration configuration, final EObject context, final String name, final String description) {
		assert configuration != null;

		Table table = NattableFactory.eINSTANCE.createTable();
		table.setTableConfiguration(configuration);
		table.setDescription(description);
		table.setName(name);
		table.setContext(context);

		//the configuration always provides axis provider
		AbstractAxisProvider rowProvider = configuration.getDefaultRowAxisProvider();
		rowProvider = EcoreUtil.copy(rowProvider);

		AbstractAxisProvider columnProvider = configuration.getDefaultColumnAxisProvider();
		columnProvider = EcoreUtil.copy(columnProvider);

		table.setCurrentRowAxisProvider(rowProvider);
		table.setCurrentColumnAxisProvider(columnProvider);
		table.getRowAxisProvidersHistory().add(rowProvider);
		table.getColumnAxisProvidersHistory().add(columnProvider);
		return table;

	}

}
