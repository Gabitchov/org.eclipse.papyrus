/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.core.expressions;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;

/**
 * This is the EObjectPropertyTester type. Enjoy.
 */
public class EObjectPropertyTester
		extends PropertyTester {

	public static final String IS_CDO_OBJECT = "isCDOObject";

	public EObjectPropertyTester() {
		super();
	}

	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {

		boolean result = false;

		CDOObject cdoObject = CDOUtils.getCDOObject((EObject) receiver);
		if (cdoObject != null) {
			if (IS_CDO_OBJECT.equals(property)) {
				result = true;
			}
		}

		return result;
	}
}
