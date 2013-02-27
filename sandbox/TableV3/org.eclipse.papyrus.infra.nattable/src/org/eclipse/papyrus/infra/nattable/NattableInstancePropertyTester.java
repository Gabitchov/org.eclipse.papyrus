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
package org.eclipse.papyrus.infra.nattable;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.papyrus.infra.nattable.manager.INattableModelManager;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;


public class NattableInstancePropertyTester extends PropertyTester {

	private static final String IS_EMF_NATTABLE_EDITOR = "isEMFNattableEditor"; //$NON-NLS-1$

	public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
		if(IS_EMF_NATTABLE_EDITOR.equals(property) && expectedValue instanceof Boolean) {
			final IWorkbenchPart current = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService().getActivePart();
			final INattableModelManager manager = (INattableModelManager)current.getAdapter(INattableModelManager.class);
			return expectedValue.equals(manager != null);
		}

		return false;
	}
}
