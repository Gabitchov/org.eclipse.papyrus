/*****************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.search.ui.query;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.papyrus.uml.search.ui.Activator;
import org.eclipse.papyrus.uml.search.ui.results.PapyrusSearchResult;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultListener;
import org.eclipse.search.ui.SearchResultEvent;
import org.eclipse.search.ui.text.AbstractTextSearchResult;
import org.eclipse.search.ui.text.Match;
import org.eclipse.search.ui.text.MatchEvent;
import org.eclipse.search.ui.text.RemoveAllEvent;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;

/**
 * A composite query delegates execution to multiple nested queries and synthesizes their results.
 */
public class CompositePapyrusQuery extends AbstractPapyrusQuery {

	private final List<? extends AbstractPapyrusQuery> queries;

	private final CompositeSearchResult searchResult = new CompositeSearchResult();

	protected CompositePapyrusQuery(List<? extends AbstractPapyrusQuery> queries) {
		this.queries = queries;
	}

	/**
	 * Creates the most efficient composition of zero or more {@code queries}.
	 * 
	 * @param queries
	 *        zero or more queries to delegate to
	 * 
	 * @return a composition of the {@code queries}
	 */
	public static AbstractPapyrusQuery compose(Iterable<? extends AbstractPapyrusQuery> queries) {
		switch(Iterables.size(queries)) {
		case 0:
			return AbstractPapyrusQuery.Empty.INSTANCE;
		case 1:
			return Iterables.getOnlyElement(queries);
		default:
			return new CompositePapyrusQuery(ImmutableList.copyOf(queries));
		}
	}

	public String getLabel() {
		return queries.get(0).getLabel();
	}

	@Override
	public String getSearchQueryText() {
		return queries.get(0).getSearchQueryText();
	}

	public boolean canRerun() {
		boolean result = true;

		for(AbstractPapyrusQuery next : queries) {
			if(!next.canRerun()) {
				result = false;
				break;
			}
		}

		return result;
	}

	public boolean canRunInBackground() {
		boolean result = true;

		for(AbstractPapyrusQuery next : queries) {
			if(!next.canRunInBackground()) {
				result = false;
				break;
			}
		}

		return result;
	}

	public IStatus run(IProgressMonitor monitor) throws OperationCanceledException {
		List<IStatus> result = new java.util.ArrayList<IStatus>(queries.size());

		searchResult.clear();

		SubMonitor sub = SubMonitor.convert(monitor, result.size());
		for(AbstractPapyrusQuery next : queries) {
			IStatus status = next.run(sub.newChild(1));
			if(!status.isOK()) {
				result.add(status);
			}

			searchResult.addSearchResult((AbstractTextSearchResult)next.getSearchResult());
		}

		return result.isEmpty() ? Status.OK_STATUS : (result.size() == 1) ? result.get(0) : new MultiStatus(Activator.PLUGIN_ID, 0, result.toArray(new IStatus[result.size()]), "Problems occurred in search.", null);
	}

	public ISearchResult getSearchResult() {
		return searchResult;
	}

	//
	// Nested types
	//

	private final class CompositeSearchResult extends PapyrusSearchResult implements ISearchResultListener {

		private final Multimap<AbstractTextSearchResult, Match> searchResults = ArrayListMultimap.create();

		CompositeSearchResult() {
			super(CompositePapyrusQuery.this);
		}

		void clear() {
			for(AbstractTextSearchResult next : searchResults.keySet()) {
				next.removeListener(this);
			}
			searchResults.clear();
		}

		void addSearchResult(AbstractTextSearchResult searchResult) {
			Object[] elements = searchResult.getElements();
			for(int i = 0; i < elements.length; i++) {
				Match[] matches = searchResult.getMatches(elements[i]);
				searchResults.putAll(searchResult, Arrays.asList(matches));
				addMatches(matches); // I need them, too
			}

			if(!searchResults.containsKey(searchResult)) {
				// we have to make sure that we remember this empty result!
				searchResults.putAll(searchResult, Collections.<Match> emptyList());
			}

			searchResult.addListener(this);
		}

		public void searchResultChanged(SearchResultEvent e) {
			AbstractTextSearchResult source = (AbstractTextSearchResult)e.getSearchResult();

			if(e instanceof RemoveAllEvent) {
				removeAll(source);
			} else if(e instanceof MatchEvent) {
				MatchEvent event = (MatchEvent)e;
				switch(event.getKind()) {
				case MatchEvent.ADDED:
					add(source, event.getMatches());
					break;
				case MatchEvent.REMOVED:
					remove(source, event.getMatches());
					break;
				default:
					Activator.log.warn("Unrecognized MatcheEvent kind: " + event.getKind()); //$NON-NLS-1$
					break;
				}
			}
		}

		private void removeAll(AbstractTextSearchResult searchResult) {
			Match[] removed = Iterables.toArray(searchResults.get(searchResult), Match.class);

			// we still need the search result in the keys!
			searchResults.get(searchResult).clear();

			removeMatches(removed);
		}

		private void remove(AbstractTextSearchResult searchResult, Match[] matches) {
			searchResults.get(searchResult).removeAll(Arrays.asList(matches));
			removeMatches(matches);
		}

		private void add(AbstractTextSearchResult searchResult, Match[] matches) {
			searchResults.putAll(searchResult, Arrays.asList(matches));
		}
	}
}
