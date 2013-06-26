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

import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;

/**
 * The column observable value for {@link AbstractHeaderAxisConfiguration#indexStyle}
 * 
 * @author vl222926
 * 
 */
public final class ColumnIndexHeaderStyleObservableValue extends AbstractColumnHeaderAxisConfigurationObservableValue {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param table
	 */
	public ColumnIndexHeaderStyleObservableValue(Table table) {
		super(table, NattableaxisconfigurationPackage.eINSTANCE.getAbstractHeaderAxisConfiguration_IndexStyle());
	}

	/**
	 * 
	 * @see org.eclipse.core.databinding.observable.value.IObservableValue#getValueType()
	 * 
	 * @return
	 */
	@Override
	public Object getValueType() {
		return NattableaxisconfigurationPackage.eINSTANCE.getAxisIndexStyle();
	}
}
