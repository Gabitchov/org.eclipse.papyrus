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
package org.eclipse.papyrus.infra.nattable.manager.cell;

import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.papyrus.infra.tools.converter.AbstractStringValueConverter;

/**
 * The interface to implements for a cell manager
 * 
 * @author Vincent Lorenzo
 * 
 */
public interface ICellManager {

	/**
	 * The string displayed for Not_AVAILABLE
	 */
	public static final String NOT_AVALAIBLE = Messages.ICellManager_NotAvailable;

	/**
	 * 
	 * @param columnElement
	 *        the column element as described in the model (you must ignore the invert axis)
	 * @param rowElement
	 *        the row element as described in the model (you must ignore the invert axis)
	 * @return
	 */
	public boolean handles(final Object columnElement, final Object rowElement);


	/**
	 * 
	 * @param columnElement
	 *        the column element as described in the model (you must ignore the invert axis)
	 * @param rowElement
	 *        the row element as described in the model (you must ignore the invert axis)
	 * @param tableManager
	 *        the table manager
	 * @return
	 *         the value of the cell or {@value #NOT_AVALAIBLE} if the cell is meaningless for the couple of parameters
	 * 
	 *         THIS METHOD MUST NOT BE USED IN REPLACEMENT OF A SPECIFIC LABEL PROVIDER
	 */
	public Object getValue(final Object columnElement, final Object rowElement, final INattableModelManager tableManager);

	/**
	 * Set the newValue to the intersection of the 2 objects
	 * 
	 * @param domain
	 *        the editing domain
	 * @param columnElement
	 *        the column element as described in the model (so you must ignore the invert axis)
	 * @param rowElement
	 *        the row element as described in the model (you must ignore the invert axis)
	 * @param newValue
	 *        the new value
	 * @param tableManager
	 *        the table manager
	 */
	public void setValue(final TransactionalEditingDomain domain, final Object columnElement, final Object rowElement, final Object newValue, final INattableModelManager tableManager);

	/**
	 * 
	 * @param columnElement
	 *        the column element as described in the model (you must ignore the invert axis)
	 * @param rowElement
	 *        the row element as described in the model (you must ignore the invert axis)
	 * @return
	 *         <code>true</code> if the intersection of the 2 objects is editable
	 */
	public boolean isCellEditable(final Object columnElement, final Object rowElement);

	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param columnElement
	 *        the column element as described in the model (you must ignore the invert axis)
	 * @param rowElement
	 *        the row element as described in the model (you must ignore the invert axis)
	 * @param newValue
	 *        the new value to set to the intersection of these 2 objects
	 * @param tableManager
	 * @return
	 *         the command to set the value or <code>null</code>
	 */
	public Command getSetValueCommand(final TransactionalEditingDomain domain, final Object columnElement, final Object rowElement, final Object newValue, final INattableModelManager tableManager);

	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param newValue
	 *        the newValue, represented by a String
	 * @param valueConverter
	 *        the solver used to resolve values
	 * @param columnElement
	 *        the columnElement
	 * @param rowElement
	 *        the rowElement
	 */
	public Command getSetStringValueCommand(final TransactionalEditingDomain domain, final Object columnElement, final Object rowElement, final String newValue, final AbstractStringValueConverter valueConverter, final INattableModelManager tableManager);


	/**
	 * 
	 * @param tableManager
	 *        the table manager
	 * @param existingConverters
	 *        a map with the existing converters, to avoid to create them too often
	 * @param multiValueSeparator
	 *        the separator used for multi values
	 * @return
	 *         the class to use to converter the string into values. If the method create them, the method must add it to the map existingConverters
	 */
	public AbstractStringValueConverter getOrCreateStringValueConverterClass(INattableModelManager tableManager, final Map<Class<? extends AbstractStringValueConverter>, AbstractStringValueConverter> existingConverters, final String multiValueSeparator);

	/**
	 * This method is used when we are pasting element in detached mode
	 * 
	 * @param columnElement
	 *        the column element as described in the model (you must ignore the invert axis)
	 * @param rowElement
	 *        the row element as described in the model (you must ignore the invert axis)
	 * @param sharedMap
	 *        a map with shared elements
	 * @return
	 *         <code>true</code> if the intersection of the 2 objects is editable
	 */
	public boolean isCellEditable(final Object columnElement, final Object rowElement, final Map<?, ?> sharedMap);

	/**
	 * This method is used when we are pasting elements in detached mode
	 * 
	 * @param columnElement
	 *        the column element
	 * @param rowElement
	 *        the row element
	 * @param valueAsString
	 *        the value as string
	 * @param valueConverter
	 *        the value converter to use
	 * @param tableManager
	 *        the table manager
	 * @param sharedMap
	 *        a map with shared elements. The method may read/add elements to the shared map. These contributions will be managed by a paste post
	 *        action or by the paste manager itself
	 * 
	 */
	public void setStringValue(final Object columnElement, final Object rowElement, final String valueAsString, final AbstractStringValueConverter valueConverter, final INattableModelManager tableManager, final Map<?, ?> sharedMap);
}
