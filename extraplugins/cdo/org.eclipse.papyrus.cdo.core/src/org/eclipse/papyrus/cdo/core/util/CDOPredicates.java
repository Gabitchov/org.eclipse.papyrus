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
package org.eclipse.papyrus.cdo.core.util;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

/**
 * This is the CDOPredicates type. Enjoy.
 */
public class CDOPredicates {

	// Not instantiable by clients.
	private CDOPredicates() {
		super();
	}

	public static <T> Predicate<T> adaptsTo(Class<?> adapterType) {
		return Predicates.<T, Object> compose(Predicates.notNull(), CDOFunctions.<T, Object> adapt(adapterType));
	}
}
