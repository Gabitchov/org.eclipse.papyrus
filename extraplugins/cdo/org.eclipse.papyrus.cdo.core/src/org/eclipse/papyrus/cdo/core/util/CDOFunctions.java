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

import org.eclipse.papyrus.cdo.internal.core.CDOUtils;

import com.google.common.base.Function;

/**
 * This is the CDOFunctions type. Enjoy.
 */
public class CDOFunctions {

	// Not instantiable by clients.
	private CDOFunctions() {
		super();
	}

	public static <F, T> Function<F, T> adapt(Class<? extends T> adapterType) {
		return new AdaptFunction<F, T>(adapterType);
	}

	//
	// Nested types
	//

	private static class AdaptFunction<F, T> implements Function<F, T> {

		private final Class<? extends T> adapterType;

		AdaptFunction(Class<? extends T> adapterType) {
			this.adapterType = adapterType;
		}

		public T apply(F input) {
			return CDOUtils.adapt(input, adapterType);
		}

		@Override
		public String toString() {
			return String.format("adapt(%s)", adapterType.getName()); //$NON-NLS-1$
		}

		@Override
		public int hashCode() {
			return adapterType.hashCode();
		}

		@Override
		public boolean equals(Object other) {
			return (other instanceof AdaptFunction<?, ?>) && (((AdaptFunction<?, ?>)other).adapterType == adapterType);
		}
	}
}
