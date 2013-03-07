/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.search.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.papyrus.views.search.results.AbstractResultEntry;
import org.eclipse.search.ui.text.AbstractTextSearchResult;
import org.eclipse.search.ui.text.Match;

/**
 * 
 * Util class to manipulate ModelMatches
 * 
 */
public class MatchUtils {

	/**
	 * Get all matches from a search result whose element as a specific type
	 * 
	 * @param searchResult
	 * @param type
	 *        the type of the element
	 * @param checkFiltered
	 *        whether filtered matches must be considered are not
	 * @return
	 */
	public static Set<AbstractResultEntry> getMatches(AbstractTextSearchResult searchResult, Class<?> type, boolean checkFiltered) {
		Set<AbstractResultEntry> results = new HashSet<AbstractResultEntry>();

		List<Object> elementList = Arrays.asList(searchResult.getElements());

		for(Object element : elementList) {
			for(Match match : searchResult.getMatches(element)) {
				if(match instanceof AbstractResultEntry) {
					boolean toAdd = false;
					if(checkFiltered) {
						if(!match.isFiltered()) {
							toAdd = true;
						}
					} else {
						toAdd = true;
					}

					if(toAdd) {
						if(type.isAssignableFrom(((AbstractResultEntry)match).elementToCheckFilterFor().getClass())) {
							results.add((AbstractResultEntry)match);
						}
					}
				}
			}
		}

		return results;
	}

	/**
	 * Get all matches from a search result whose element as a specific type
	 * 
	 * @param searchResult
	 * @param checkFiltered
	 *        whether filtered matches must be considered are not
	 * 
	 * @return
	 */
	public static Set<AbstractResultEntry> getMatches(AbstractTextSearchResult searchResult, boolean checkFiltered) {
		return getMatches(searchResult, Object.class, checkFiltered);
	}
}
