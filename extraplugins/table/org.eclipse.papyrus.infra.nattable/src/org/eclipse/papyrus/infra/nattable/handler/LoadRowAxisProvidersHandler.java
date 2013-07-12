/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.handler;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;

/**
 * Concrete handler to load row axis providers from the table's historic.
 * 
 */
public class LoadRowAxisProvidersHandler extends AbstractLoadAxisProvidersHandler {

	/**
	 * This handler is enabled only if the concerned axis manager allows to save a configuration.
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.handler.AbstractTableHandler#setEnabled(java.lang.Object)
	 * 
	 * @param evaluationContext
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		IAxisManager rowAxisManager = this.getCurrentNattableModelManager().getRowAxisManager();
		setBaseEnabled(rowAxisManager.canBeSavedAsConfig());
	}

	/**
	 * Getter to obtain the current axis provider, in this case for rows.
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.handler.AbstractLoadAxisProvidersHandler#getAxisProvidersHistory()
	 * 
	 * @return
	 */
	public EList<AbstractAxisProvider> getAxisProvidersHistory() {
		return this.getCurrentNattableModelManager().getTable().getRowAxisProvidersHistory();
	}

	/**
	 * Getter to obtain the current axis provider, in this case for rows.
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.handler.AbstractLoadAxisProvidersHandler#getCurrentAxisProvider()
	 * 
	 * @return
	 */
	public AbstractAxisProvider getCurrentAxisProvider() {
		return this.getCurrentNattableModelManager().getTable().getCurrentRowAxisProvider();
	}

	/**
	 * Get the EReference where the current column provider will be set.
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.handler.AbstractLoadAxisProvidersHandler#getCurrentAxisProviderEFeature()
	 * 
	 * @return
	 */
	public EReference getCurrentAxisProviderEFeature() {
		return NattablePackage.eINSTANCE.getTable_CurrentRowAxisProvider();
	}

}
