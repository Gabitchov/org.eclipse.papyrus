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

import java.util.Collection;
import java.util.TreeSet;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.services.edit.utils.ElementTypeUtils;

/**
 * 
 * @author VL222926
 * 
 */
public class CreatableEObjectAxisUtils {

	private CreatableEObjectAxisUtils() {
		//to prevent instanciation
	}

	/**
	 * 
	 * @param table
	 *        the table
	 * @param onColumn
	 *        <code>true</code> if we are working on column, false if not
	 * @return
	 *         the list of the creatable element on the axis
	 */
	public static final Collection<String> getCreatableElementIds(final Table table, final boolean onColumn) {
		final INattableModelManager nattableModelManager = new NattableModelManager(table);
		return getCreatableElementIds(nattableModelManager, onColumn);
	}

	/**
	 * 
	 * @param tableManager
	 *        the tableManager
	 * @param onColumn
	 *        <code>true</code> if we are working on column, false if not
	 * @return
	 *         the list of the creatable element on the axis
	 */
	public static final Collection<String> getCreatableElementIds(final INattableModelManager nattableModelManager, final boolean onColumn) {
		final IAxisManager axisManager;
		if(onColumn) {
			axisManager = nattableModelManager.getColumnAxisManager();
		} else {
			axisManager = nattableModelManager.getRowAxisManager();
		}
		final Collection<IElementType> possibleValues = ElementTypeUtils.getAllExistingElementTypes();
		final Collection<String> allowedElements = new TreeSet<String>();
		for(final IElementType current : possibleValues) {
			final String id = current.getId();
			if(axisManager.canCreateAxisElement(id)) {
				allowedElements.add(id);
			}
		}
		return allowedElements;
	}





}
