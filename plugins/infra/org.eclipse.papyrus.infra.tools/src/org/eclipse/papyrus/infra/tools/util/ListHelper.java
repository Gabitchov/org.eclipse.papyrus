/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.tools.util;

import java.util.ArrayList;
import java.util.List;

public class ListHelper {

	/**
	 * Converts an array to a List
	 * 
	 * This method is similar to Arrays.asList, except that it returns
	 * a writeable list
	 * 
	 * @param array
	 *        The array to transform into a List
	 * @return
	 *         A List containing the same elements as the array
	 */
	public static <T> List<T> asList(T[] array) {
		if(array == null) {
			return new ArrayList<T>();
		}

		List<T> result = new ArrayList<T>(array.length);
		for(T t : array) {
			result.add(t);
		}
		return result;
	}

	/**
	 * Invokes the toString() method recursively on this list's elements.
	 * The values are separated by ", "
	 * 
	 * @param list
	 *        The list whose string representation to return
	 * @return
	 * 
	 * @see #deepToString(List, String)
	 */
	public static String deepToString(List<?> list) {
		return deepToString(list, ", ");
	}

	/**
	 * Invokes the toString() method recursively on this list's elements.
	 * The values are separated by the given separator
	 * 
	 * @param list
	 *        The list whose string representation to return
	 * @param separator
	 *        The string to insert between each element's string representation
	 * @return
	 * 
	 * @see #deepToString(List)
	 */
	public static String deepToString(List<?> list, String separator) {
		boolean firstElement = true;
		String result = "";
		for(Object item : list) {
			if(firstElement) {
				firstElement = false;
			} else {
				result += separator;
			}
			result += item == null ? null : item.toString();
		}
		return result;
	}
}
