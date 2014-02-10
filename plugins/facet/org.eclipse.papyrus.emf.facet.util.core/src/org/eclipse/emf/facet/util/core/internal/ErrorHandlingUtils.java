/*******************************************************************************
 * Copyright (c) 2011 Mia-Software
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software) - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.facet.util.core.internal;

public final class ErrorHandlingUtils {
	private ErrorHandlingUtils() {
		// utility class
	}

	/**
	 * Builds an error message for when an element doesn't have the expected type.
	 *
	 * @param baseMessage
	 *            the beginning of the message
	 * @param expectedType
	 *            the expected type
	 * @param element
	 *            the element that doesn't match the expected type
	 * @return the full message
	 */
	public static String buildWrongTypeMessage(final String baseMessage, final Class<?> expectedType, final Object element) {
		StringBuilder builder = new StringBuilder();
		builder.append(baseMessage);
		builder.append("\n"); //$NON-NLS-1$
		if (expectedType != null) {
			builder.append("Expected type: "); //$NON-NLS-1$
			builder.append(expectedType.getName());
			builder.append(". "); //$NON-NLS-1$
		} else {
			builder.append("Expected type is null. "); //$NON-NLS-1$
		}

		if (element != null) {
			builder.append("Got an instance of type: "); //$NON-NLS-1$
			builder.append(element.getClass().getName());
			builder.append("."); //$NON-NLS-1$
		} else {
			builder.append("Got null."); //$NON-NLS-1$
		}
		return builder.toString();
	}
}
