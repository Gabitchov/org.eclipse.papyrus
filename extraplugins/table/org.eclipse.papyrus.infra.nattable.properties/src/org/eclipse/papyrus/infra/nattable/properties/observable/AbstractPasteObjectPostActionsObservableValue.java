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
package org.eclipse.papyrus.infra.nattable.properties.observable;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.emf.databinding.EMFObservableList;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;

/**
 * Observable value for the element type id
 * 
 * @author VL222926
 * 
 */
public abstract class AbstractPasteObjectPostActionsObservableValue extends EMFObservableList {

	private Table table;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param table
	 */
	public AbstractPasteObjectPostActionsObservableValue(final EditingDomain domain, final Table table) {
		super(Collections.EMPTY_LIST, domain, table, NattableaxisconfigurationPackage.eINSTANCE.getIPasteConfiguration_PostActions());
		this.table = table;
		updateList();
	}


	/**
 * 
 */
	protected void updateList() {
		final List<?> list = EMFProperties.list(NattableaxisconfigurationPackage.eINSTANCE.getIPasteConfiguration_PostActions()).observe(getEditedEObject());
		this.wrappedList = new LinkedList<Object>(list);
		this.concreteList = list;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.properties.observable.AbstractColumnPasteEObjectConfigurationObservableValue#getEditedEObject()
	 * 
	 * @return
	 */
	protected abstract EObject getEditedEObject();

	/**
	 * 
	 * @return
	 *         the table
	 */
	protected Table getTable() {
		return this.table;
	}

}
