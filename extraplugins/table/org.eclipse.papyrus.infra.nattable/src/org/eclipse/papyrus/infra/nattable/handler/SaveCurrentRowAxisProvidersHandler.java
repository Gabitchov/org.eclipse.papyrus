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
 * Concrete handler to save the current axis provider, in this case for rows.
 * 
 */
public class SaveCurrentRowAxisProvidersHandler extends AbstractSaveCurrentAxisProvidersHandler {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.handler.AbstractSaveCurrentAxisProvidersHandler#getAxisProviderHistoryEReference()
	 * 
	 * @return
	 */
	@Override
	public EReference getAxisProviderHistoryEReference() {
		return NattablePackage.eINSTANCE.getTable_RowAxisProvidersHistory();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.handler.AbstractSaveCurrentAxisProvidersHandler#getAxisProviderHistory()
	 * 
	 * @return
	 */
	@Override
	public EList<AbstractAxisProvider> getAxisProviderHistory() {
		return this.getCurrentNattableModelManager().getTable().getRowAxisProvidersHistory();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.handler.AbstractSaveCurrentAxisProvidersHandler#getAxisProvider()
	 * 
	 * @return
	 */
	@Override
	public AbstractAxisProvider getAxisProvider() {
		return this.getCurrentNattableModelManager().getHorizontalAxisProvider();
	}

	/**
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

}
