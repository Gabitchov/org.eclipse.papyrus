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
package org.eclipse.papyrus.infra.nattable.common.celleditor.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;

/**
 * 
 * This class allows to load and get all registered CellEditorConfigurationFactory
 * 
 */
public class CellEditorConfigurationFactoryRegistry {

	private Map<Integer, AbstractCellEditorConfigurationFactory> registry;

	public static final String EXTENSION_ID = "org.eclipse.papyrus.infra.nattable.celleditor.configuration.factory"; //$NON-NLS-1$

	public static final String FACTORY_ID_ATTRIBUTE = "id"; //$NON-NLS-1$

	public static final String FACTORY_CLASS_ATTRIBUTE = "class"; //$NON-NLS-1$

	public static final String ORDER_ATTRIBUTE = "order"; //$NON-NLS-1$

	public static final CellEditorConfigurationFactoryRegistry INSTANCE = new CellEditorConfigurationFactoryRegistry();

	/**
	 * 
	 * Constructor.
	 * Initial the registry of the configuration factories
	 */
	private CellEditorConfigurationFactoryRegistry() {
		//to prevent instanciation
		final IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);
		registry = new HashMap<Integer, AbstractCellEditorConfigurationFactory>();
		for(final IConfigurationElement iConfigurationElement : configElements) {
			final String id = iConfigurationElement.getAttribute(FACTORY_ID_ATTRIBUTE);
			final Integer order = new Integer(iConfigurationElement.getAttribute(ORDER_ATTRIBUTE));
			try {
				final AbstractCellEditorConfigurationFactory factory = (AbstractCellEditorConfigurationFactory)iConfigurationElement.createExecutableExtension(FACTORY_CLASS_ATTRIBUTE);
				factory.initFactory(id);

				if(factory != null) {
					registry.put(order, factory);
				}
			} catch (final CoreException e) {
				Activator.log.error(e);
			}
		}
	}

	/**
	 * 
	 * @param factoryId
	 *        the id of the factory
	 * @return
	 *         the cellEditorFactory declared on this id or <code>null</code> if not found
	 */
	public AbstractCellEditorConfigurationFactory getCellEditorFactory(final String factoryId) {
		assert factoryId != null;
		for(final Integer order : registry.keySet()) {
			final AbstractCellEditorConfigurationFactory current = registry.get(order);
			if(factoryId.equals(current.getFactoryId())) {
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
	public AbstractCellEditorConfigurationFactory getFirstCellEditorConfigurationFactory(final Table table, final Object obj) {
		final List<AbstractCellEditorConfigurationFactory> factories = getCellEditorConfigurationFactories(table, obj);
		if(!factories.isEmpty()){
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
	public List<AbstractCellEditorConfigurationFactory> getCellEditorConfigurationFactories(final Table table, final Object obj) {
		final List<AbstractCellEditorConfigurationFactory> factories = new ArrayList<AbstractCellEditorConfigurationFactory>();
		for(final AbstractCellEditorConfigurationFactory current : this.registry.values()) {
			if(current.handles(table, obj)) {
				factories.add(current);
			}
		}
		return factories;
	}
}
