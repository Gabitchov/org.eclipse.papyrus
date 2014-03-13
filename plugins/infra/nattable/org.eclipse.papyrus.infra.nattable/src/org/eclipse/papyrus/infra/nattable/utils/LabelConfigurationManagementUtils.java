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

import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ObjectLabelProviderConfiguration;

/**
 * Utils class for LabelConfiguration management
 * 
 * @author Vincent Lorenzo
 * 
 */
public class LabelConfigurationManagementUtils {

	private LabelConfigurationManagementUtils() {
		//to prevent instanciation
	}

	/**
	 * 
	 * @param table
	 *        a table
	 * @return
	 *         the FeatureLabelProviderConfiguration for rows defined in the table, managing the inversion of the axis or <code>null</code>
	 */
	public static final FeatureLabelProviderConfiguration getRowFeatureLabelConfigurationInTable(final Table table) {
		AbstractHeaderAxisConfiguration config = table.getLocalRowHeaderAxisConfiguration();
		if(table.isInvertAxis()) {
			config = table.getLocalColumnHeaderAxisConfiguration();
		}
		if(config != null) {
			for(final ILabelProviderConfiguration current : config.getOwnedLabelConfigurations()) {
				if(current instanceof FeatureLabelProviderConfiguration) {
					return (FeatureLabelProviderConfiguration)current;
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @param table
	 *        a table
	 * @return
	 *         the FeatureLabelProviderConfiguration for rows defined in the configuration, managing the inversion of the axis or <code>null</code>
	 */
	public static final FeatureLabelProviderConfiguration getRowFeatureLabelConfigurationInTableConfiguration(final Table table) {
		AbstractHeaderAxisConfiguration config = table.getTableConfiguration().getRowHeaderAxisConfiguration();
		if(table.isInvertAxis()) {
			config = table.getTableConfiguration().getColumnHeaderAxisConfiguration();
		}
		//can be null according to the metamodel
		for(final ILabelProviderConfiguration current : config.getOwnedLabelConfigurations()) {
			if(current instanceof FeatureLabelProviderConfiguration) {
				return (FeatureLabelProviderConfiguration)current;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param table
	 *        a table
	 * @return
	 *         <code>true</code> if a FeatureLabelProviderConfiguration is defined for rows for the table, managing the inversion of the axis
	 */
	public static final boolean hasRowFeatureLabelConfiguration(final Table table) {
		return getRowFeatureLabelConfigurationInTable(table) != null || getRowFeatureLabelConfigurationInTableConfiguration(table) != null;
	}

	/**
	 * 
	 * @param table
	 *        a table
	 * @return
	 *         the FeatureLabelProviderConfiguration for columns defined in the table, managing the inversion of the axis or <code>null</code>
	 */
	public static final FeatureLabelProviderConfiguration getColumnFeatureLabelConfigurationInTable(final Table table) {
		AbstractHeaderAxisConfiguration config = table.getLocalRowHeaderAxisConfiguration();
		if(!table.isInvertAxis()) {
			config = table.getLocalColumnHeaderAxisConfiguration();
		}
		if(config != null) {
			for(final ILabelProviderConfiguration current : config.getOwnedLabelConfigurations()) {
				if(current instanceof FeatureLabelProviderConfiguration) {
					return (FeatureLabelProviderConfiguration)current;
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @param table
	 *        a table
	 * @return
	 *         the FeatureLabelProviderConfiguration for columns defined in the configuration, managing the inversion of the axis or <code>null</code>
	 */
	public static final FeatureLabelProviderConfiguration getColumnFeatureLabelConfigurationInTableConfiguration(final Table table) {
		AbstractHeaderAxisConfiguration config = table.getTableConfiguration().getRowHeaderAxisConfiguration();
		if(!table.isInvertAxis()) {
			config = table.getTableConfiguration().getColumnHeaderAxisConfiguration();
		}
		//can be null according to the metamodel
		for(final ILabelProviderConfiguration current : config.getOwnedLabelConfigurations()) {
			if(current instanceof FeatureLabelProviderConfiguration) {
				return (FeatureLabelProviderConfiguration)current;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param table
	 *        a table
	 * @return
	 *         <code>true</code> if a FeatureLabelProviderConfiguration is defined for columns for the table, managing the inversion of the axis
	 */
	public static final boolean hasColumnFeatureLabelConfiguration(final Table table) {
		return getColumnFeatureLabelConfigurationInTable(table) != null || getColumnFeatureLabelConfigurationInTableConfiguration(table) != null;
	}


	/**
	 * 
	 * @param table
	 *        a table
	 * @return
	 *         the ObjectLabelProviderConfiguration for rows defined in the table, managing the inversion of the axis or <code>null</code>
	 */
	public static final ObjectLabelProviderConfiguration getRowObjectLabelConfigurationInTable(final Table table) {
		AbstractHeaderAxisConfiguration config = table.getLocalRowHeaderAxisConfiguration();
		if(table.isInvertAxis()) {
			config = table.getLocalColumnHeaderAxisConfiguration();
		}
		if(config != null) {
			for(final ILabelProviderConfiguration current : config.getOwnedLabelConfigurations()) {
				if(current instanceof ObjectLabelProviderConfiguration) {
					return (ObjectLabelProviderConfiguration)current;
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @param table
	 *        a table
	 * @return
	 *         the ObjectLabelProviderConfiguration for rows defined in the configuration, managing the inversion of the axis or <code>null</code>
	 */
	public static final ObjectLabelProviderConfiguration getRowObjectLabelConfigurationInTableConfiguration(final Table table) {
		AbstractHeaderAxisConfiguration config = table.getTableConfiguration().getRowHeaderAxisConfiguration();
		if(table.isInvertAxis()) {
			config = table.getTableConfiguration().getColumnHeaderAxisConfiguration();
		}
		//can be null according to the metamodel
		for(final ILabelProviderConfiguration current : config.getOwnedLabelConfigurations()) {
			if(current instanceof ObjectLabelProviderConfiguration) {
				return (ObjectLabelProviderConfiguration)current;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param table
	 *        a table
	 * @return
	 *         <code>true</code> if a ObjectLabelProviderConfiguration is defined for rows for the table, managing the inversion of the axis
	 */
	public static final boolean hasRowObjectLabelConfiguration(final Table table) {
		return getRowObjectLabelConfigurationInTable(table) != null || getRowObjectLabelConfigurationInTableConfiguration(table) != null;
	}

	/**
	 * 
	 * @param table
	 *        a table
	 * @return
	 *         the ObjectLabelProviderConfiguration for columns defined in the table, managing the inversion of the axis or <code>null</code>
	 */
	public static final ObjectLabelProviderConfiguration getColumnObjectLabelConfigurationInTable(final Table table) {
		AbstractHeaderAxisConfiguration config = table.getLocalRowHeaderAxisConfiguration();
		if(!table.isInvertAxis()) {
			config = table.getLocalColumnHeaderAxisConfiguration();
		}
		if(config != null) {
			for(final ILabelProviderConfiguration current : config.getOwnedLabelConfigurations()) {
				if(current instanceof ObjectLabelProviderConfiguration) {
					return (ObjectLabelProviderConfiguration)current;
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @param table
	 *        a table
	 * @return
	 *         the ObjectLabelProviderConfiguration for columns defined in the configuration, managing the inversion of the axis or <code>null</code>
	 */
	public static final ObjectLabelProviderConfiguration getColumnObjectLabelConfigurationInTableConfiguration(final Table table) {
		AbstractHeaderAxisConfiguration config = table.getTableConfiguration().getRowHeaderAxisConfiguration();
		if(!table.isInvertAxis()) {
			config = table.getTableConfiguration().getColumnHeaderAxisConfiguration();
		}
		//can be null according to the metamodel
		for(final ILabelProviderConfiguration current : config.getOwnedLabelConfigurations()) {
			if(current instanceof ObjectLabelProviderConfiguration) {
				return (ObjectLabelProviderConfiguration)current;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param table
	 *        a table
	 * @return
	 *         <code>true</code> if a ObjectLabelProviderConfiguration is defined for columns for the table, managing the inversion of the axis
	 */
	public static final boolean hasColumnObjectLabelConfiguration(final Table table) {
		return getColumnObjectLabelConfigurationInTable(table) != null || getColumnObjectLabelConfigurationInTableConfiguration(table) != null;
	}

	/**
	 * 
	 * @param table
	 *        the table
	 * @return
	 *         the object label configuration currently used in the table
	 */
	public static final FeatureLabelProviderConfiguration getUsedColumnFeatureLabelConfiguration(final Table table) {
		FeatureLabelProviderConfiguration conf = getColumnFeatureLabelConfigurationInTable(table);
		if(conf == null) {
			conf = getColumnFeatureLabelConfigurationInTableConfiguration(table);
		}
		return conf;
	}

	/**
	 * 
	 * @param table
	 *        the table
	 * @return
	 *         the object label configuration currently used in the table
	 */
	public static final FeatureLabelProviderConfiguration getUsedRowFeatureLabelConfiguration(final Table table) {
		FeatureLabelProviderConfiguration conf = getRowFeatureLabelConfigurationInTable(table);
		if(conf == null) {
			conf = getRowFeatureLabelConfigurationInTableConfiguration(table);
		}
		return conf;
	}

	/**
	 * 
	 * @param table
	 *        the table
	 * @return
	 *         the object label configuration currently used in the table
	 */
	public static final ObjectLabelProviderConfiguration getUsedColumnObjectLabelConfiguration(final Table table) {
		ObjectLabelProviderConfiguration conf = getColumnObjectLabelConfigurationInTable(table);
		if(conf == null) {
			conf = getColumnObjectLabelConfigurationInTableConfiguration(table);
		}
		return conf;
	}

	/**
	 * 
	 * @param table
	 *        the table
	 * @return
	 *         the object label configuration currently used in the table
	 */
	public static final ObjectLabelProviderConfiguration getUsedRowObjectLabelConfiguration(final Table table) {
		ObjectLabelProviderConfiguration conf = getRowObjectLabelConfigurationInTable(table);
		if(conf == null) {
			conf = getRowObjectLabelConfigurationInTableConfiguration(table);
		}
		return conf;
	}
}
