/*******************************************************************************
 * Copyright (c) 2011 Mia-Software
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Guyomar (Mia-Software) - Bug 349566 - Need some new query utils method for query creation
 *     Nicolas Bros (Mia-Software) - Bug 349566 - Need some new query utils method for query creation
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.util.core.internal;

public final class JavaUtils {

	private JavaUtils() {
		// utility class
	}

	/**
	 * Converts a Java primitive type to a Java object type.
	 *
	 * @param primitiveType
	 *            the primitive type
	 * @return the object type
	 */
	public static String objectType(final String primitiveType) {
		if ("byte".equals(primitiveType)) { //$NON-NLS-1$
			return "Byte"; //$NON-NLS-1$
		}
		if ("short".equals(primitiveType)) { //$NON-NLS-1$
			return "Short"; //$NON-NLS-1$
		}
		if ("int".equals(primitiveType)) { //$NON-NLS-1$
			return "Integer"; //$NON-NLS-1$
		}
		if ("long".equals(primitiveType)) { //$NON-NLS-1$
			return "Long"; //$NON-NLS-1$
		}
		if ("float".equals(primitiveType)) { //$NON-NLS-1$
			return "Float"; //$NON-NLS-1$
		}
		if ("double".equals(primitiveType)) { //$NON-NLS-1$
			return "Double"; //$NON-NLS-1$
		}
		if ("boolean".equals(primitiveType)) { //$NON-NLS-1$
			return "Boolean"; //$NON-NLS-1$
		}
		if ("char".equals(primitiveType)) { //$NON-NLS-1$
			return "Character"; //$NON-NLS-1$
		}
		return primitiveType;
	}
}
