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
 * Concrete handler to save the current axis provider, in this case for columns.
 * 
 */
public class SaveCurrentColumnAxisProvidersHandler extends AbstractSaveCurrentAxisProvidersHandler {

	@Override
	public void setEnabled(Object evaluationContext) {
		IAxisManager columnAxisManager = this.getCurrentNattableModelManager().getColumnAxisManager();
		setBaseEnabled(columnAxisManager.canBeSavedAsConfig());
	}

	public AbstractAxisProvider getAxisProvider() {
		return this.getCurrentNattableModelManager().getVerticalAxisProvider();
	}

	public EList<AbstractAxisProvider> getAxisProviderHistory() {
		return this.getCurrentNattableModelManager().getTable().getColumnAxisProvidersHistory();
	}

	public EReference getAxisProviderHistoryEReference() {
		return NattablePackage.eINSTANCE.getTable_ColumnAxisProvidersHistory();
	}



}
