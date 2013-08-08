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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;
import org.eclipse.papyrus.infra.nattable.utils.AxisConfigurationUtils;

/**
 * Observable value for the element type id
 * 
 * @author VL222926
 * 
 */
public class ColumnPasteObjectPostActionsObservableValue extends AbstractPasteObjectPostActionsObservableValue {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param table
	 */
	public ColumnPasteObjectPostActionsObservableValue(final EditingDomain domain, final Table table) {
		super(domain, table);
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.properties.observable.AbstractColumnPasteEObjectConfigurationObservableValue#getEditedEObject()
	 * 
	 * @return
	 */
	protected EObject getEditedEObject() {
		return AxisConfigurationUtils.getIAxisConfigurationUsedInTable(getTable(), NattableaxisconfigurationPackage.eINSTANCE.getPasteEObjectConfiguration(), true);
	}


}
