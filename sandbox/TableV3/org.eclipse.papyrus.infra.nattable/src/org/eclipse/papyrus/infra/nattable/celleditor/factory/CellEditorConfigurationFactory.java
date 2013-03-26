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
package org.eclipse.papyrus.infra.nattable.celleditor.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.nattable.celleditor.configs.IAxisCellEditorConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;

/**
 * 
 * This class allows to load and get all registered CellEditorConfigurationFactory
 * 
 */
public class CellEditorConfigurationFactory {

	private Map<Integer, IAxisCellEditorConfiguration> registry;

	public static final String EXTENSION_ID = "org.eclipse.papyrus.infra.nattable.celleditor.configuration"; //$NON-NLS-1$

	//	public static final String FACTORY_ID_ATTRIBUTE = "id"; //$NON-NLS-1$

	public static final String CELL_EDITOR_CONFIGURATION_CLASS_ATTRIBUTE = "class"; //$NON-NLS-1$

	public static final String ORDER_ATTRIBUTE = "order"; //$NON-NLS-1$

	public static final CellEditorConfigurationFactory INSTANCE = new CellEditorConfigurationFactory();

	/**
	 * 
	 * Constructor.
	 * Initial the registry of the configuration factories
	 */
	private CellEditorConfigurationFactory() {
		//to prevent instanciation
		final IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);
		this.registry = new TreeMap<Integer, IAxisCellEditorConfiguration>();
		for(final IConfigurationElement iConfigurationElement : configElements) {
			//			final String id = iConfigurationElement.getAttribute(FACTORY_ID_ATTRIBUTE);
			final Integer order = new Integer(iConfigurationElement.getAttribute(ORDER_ATTRIBUTE));
			try {
				final IAxisCellEditorConfiguration factory = (IAxisCellEditorConfiguration)iConfigurationElement.createExecutableExtension(CELL_EDITOR_CONFIGURATION_CLASS_ATTRIBUTE);
				//				factory.initFactory(id);

				if(factory != null) {
					this.registry.put(order, factory);
				}
			} catch (final CoreException e) {
				Activator.log.error(e);
			}
		}
	}

	/**
	 * 
	 * @param configurationId
	 *        the id of the factory
	 * @return
	 *         the cellEditorFactory declared on this id or <code>null</code> if not found
	 */
	public IAxisCellEditorConfiguration getCellEditorConfigruation(final String configurationId) {
		assert configurationId != null;
		for(final Integer order : this.registry.keySet()) {
			final IAxisCellEditorConfiguration current = this.registry.get(order);
			if(configurationId.equals(current.getEditorId())) {
				return current;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param table
	 *        the table for which we are looking for a cell editor factory
	 * @param obj
	 *        the object for which we are looking for a cell editor factory
	 * @return
	 *         the first cell editor configuration factory which is able to manage this object
	 */
	public IAxisCellEditorConfiguration getFirstCellEditorConfiguration(final Table table, final Object obj) {
		final List<IAxisCellEditorConfiguration> factories = getCellEditorConfigurationFactories(table, obj);
		if(!factories.isEmpty()) {
			return factories.get(0);
		}
		return null;
	}

	/**
	 * 
	 * @param table
	 *        the table for which we are looking for a cell editor factory
	 * @param obj
	 *        the object for which we are looking for a cell editor factory
	 * @return
	 *         the list of the cell editor configuration which are able to manage this object
	 */
	public List<IAxisCellEditorConfiguration> getCellEditorConfigurationFactories(final Table table, final Object obj) {
		final List<IAxisCellEditorConfiguration> factories = new ArrayList<IAxisCellEditorConfiguration>();
		for(final IAxisCellEditorConfiguration current : this.registry.values()) {
			if(current.handles(table, obj)) {
				factories.add(current);
			}
		}
		return factories;
	}
}
