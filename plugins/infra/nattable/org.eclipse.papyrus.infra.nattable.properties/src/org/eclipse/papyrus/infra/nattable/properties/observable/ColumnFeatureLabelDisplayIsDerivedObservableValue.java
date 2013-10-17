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

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderPackage;


/**
 * The Class ColumnFeatureLabelDisplayIsDerivedObservableValue.
 */
public class ColumnFeatureLabelDisplayIsDerivedObservableValue extends AbstractColumnFeatureLabelProviderConfigurationObservableValue {

	/**
	 * Instantiates a new column feature label display is derived observable value.
	 * 
	 * @param table
	 *        the table
	 */
	public ColumnFeatureLabelDisplayIsDerivedObservableValue(Table table) {
		super(table, NattablelabelproviderPackage.eINSTANCE.getFeatureLabelProviderConfiguration_DisplayIsDerived());
	}

	/**
	 * @see org.eclipse.core.databinding.observable.value.IObservableValue#getValueType()
	 * 
	 * @return
	 */

	@Override
	public Object getValueType() {
		return EcorePackage.eINSTANCE.getEBoolean();
	}

}
