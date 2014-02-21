/*******************************************************************************
 * Copyright (c) 2011, 2012 Mia-Software
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values.
 *     Nicolas Bros (Mia-Software) - Bug 361612 - New core for new version of the Facet metamodel
 *     Grégoire Dupé (Mia-Software) - Bug 361612 - [Restructuring] New core for new version of the Facet metamodel
 *     Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.efacet.core.internal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.papyrus.emf.facet.efacet.core.internal.exception.UnmatchingExpectedTypeException;

public final class CastUtils {
	
	private CastUtils() {
		//Must no be used.
	}

	/**
	 * Cast the given value to a List of the given type
	 *
	 * @param value
	 *            the list
	 * @param expectedType
	 *            the expected type of the list elements
	 * @param checkType
	 *            whether to check the type of each element in the given list; should be
	 *            <code>true</code> if the list comes from outside the framework, and
	 *            <code>false</code> if the list is managed by the framework (and so already
	 *            checked)
	 * @return the cast list
	 * @throws UnmatchingExpectedTypeException
	 */
	@SuppressWarnings("unchecked")
	//@SuppressWarnings("unchecked") The cast is checked by the both if statement.
	public static <T> List<T> castToExpectedListType(final Object value, final Class<T> expectedType, final boolean checkType)
			throws UnmatchingExpectedTypeException {
		List<T> newList = new LinkedList<T>();
		if (value instanceof List) {
			newList = (List<T>) value;
		} else {
			newList.add((T) value);
		}
		final List<T> list = newList;
		if (checkType) {
			checkTypeOfAllListElements(list, expectedType);
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	//@SuppressWarnings("unchecked") This method is used to isolate unsafe cast.
	public static <T> T castToExpectedType(final Object value, final Class<T> expectedType)
			throws UnmatchingExpectedTypeException {
		try {
			return (T) value;
		} catch (ClassCastException e) {
			throw new UnmatchingExpectedTypeException("Type mismatch. Expected: " + //$NON-NLS-1$
					expectedType.getClass().getName() + ", got " + value.getClass().getName(), e); //$NON-NLS-1$);
		}
	}

	public static void checkTypeOfAllListElements(final List<?> list, final Class<?> expectedType) throws UnmatchingExpectedTypeException {
		if (expectedType == null) {
			// null means match everything
			return;
		}
		final Iterator<?> iterator = list.iterator();
		int index = -1;
		while (iterator.hasNext()) {
			final Object object = iterator.next();
			index++;
			if (object != null && !expectedType.isInstance(object)) {
				throw new UnmatchingExpectedTypeException("Type mismatch at index " + index, expectedType, object); //$NON-NLS-1$
			}
		}
	}

}
