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
package org.eclipse.papyrus.infra.nattable.celleditor.config;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;

/**
 * 
 * The abstract class to used for CellEditorFactory
 * 
 */
public abstract class AbstractCellEditorConfigurationFactory {

	/**
	 * the id of the factory
	 */
	private String id;

	/**
	 * the id of the extension point used to register contribution
	 */
	public static final String EXTENSION_ID = "org.eclipse.papyrus.infra.nattable.celleditor.configuration"; //$NON-NLS-1$

	public static final String CLASS_ATTRIBUTE = "class"; //$NON-NLS-1$

	public static final String FACTORY_ID_ATTRIBUTE = "factoryId"; //$NON-NLS-1$

	public static final String ORDER_ATTRIBUTE = "order"; //$NON-NLS-1$

	/**
	 * 
	 * @param id
	 *        the id of the factory
	 */
	public void initFactory(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 *         the id of the factory
	 */
	public final String getFactoryId() {
		return this.id;
	}

	/**
	 * 
	 * @return
	 *         the registered element for this factory
	 */
	public Collection<IConfigurationElement> getAllRegisteredCellEditorConfiguration() {
		Collection<IConfigurationElement> elements = new ArrayList<IConfigurationElement>();
		final IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);
		for(final IConfigurationElement iConfigurationElement : configElements) {
			final String current = iConfigurationElement.getAttribute(FACTORY_ID_ATTRIBUTE);
			if(current.equals(this.id)) {
				elements.add(iConfigurationElement);
			}
		}
		return elements;
	}

	/**
	 * 
	 * @param editorId
	 *        the editor id
	 * @return
	 *         the configuration for this editor or <code>null</code> if the editor is not registered in this factory
	 */
	public abstract IAxisCellEditorConfiguration getCellEditorConfiguration(final String editorId);

	/**
	 * 
	 * @param table
	 *        the table
	 * @param axisElement
	 *        an eobject
	 * @return
	 *         <code>true</code> if this factory allows to edit the object for this table
	 */
	public abstract boolean handles(final Table table, final Object axisElement);

	/**
	 * 
	 * @param table
	 *        the table
	 * @param axisElement
	 *        an eobject
	 * @return
	 *         the cell editor configuration for the couple table - axisElement
	 */
	public abstract IAxisCellEditorConfiguration getCellEditorConfiguration(Table table, final Object axisElement);
}
