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
package org.eclipse.papyrus.infra.nattable.handler;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.HeaderAxisConfigurationManagementUtils;

/**
 * Abstract class to edit the header cofniguration
 * 
 * @author Vincent Lorenzo
 * 
 */
public abstract class AbstractRowChangeHeaderConfigurationHandler extends AbstractChangeHeaderConfigurationHandler {

	/**
	 * 
	 * @return
	 *         the axis configuration used by the table, can't be <code>null</code>;
	 */
	@Override
	protected AbstractHeaderAxisConfiguration getEditedAxisConfiguration() {
		AbstractHeaderAxisConfiguration conf = HeaderAxisConfigurationManagementUtils.getAbstractHeaderAxisConfigurationUsedInTable(getCurrentNattableModelManager().getTable());
		return conf;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.handler.AbstractChangeHeaderConfigurationHandler#getLocalHeaderAxisConfigurationFeature()
	 * 
	 * @return
	 */
	@Override
	protected EStructuralFeature getLocalHeaderAxisConfigurationFeature() {
		final Table table = getCurrentNattableModelManager().getTable();
		if(table.isInvertAxis()) {
			return NattablePackage.eINSTANCE.getTable_LocalColumnHeaderAxisConfiguration();
		}
		return NattablePackage.eINSTANCE.getTable_LocalRowHeaderAxisConfiguration();
	}


}
