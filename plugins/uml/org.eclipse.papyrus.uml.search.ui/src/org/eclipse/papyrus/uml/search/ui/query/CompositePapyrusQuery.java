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
import org.eclipse.search.ui.text.AbstractTextSearchResult;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * A composite query delegates execution to multiple nested queries and synthesizes their results.
 */
public class CompositePapyrusQuery extends AbstractPapyrusQuery {

	private final List<? extends AbstractPapyrusQuery> queries;

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

		SubMonitor sub = SubMonitor.convert(monitor, result.size());
		for(AbstractPapyrusQuery next : queries) {
			IStatus status = next.run(sub.newChild(1));
			if(!status.isOK()) {
				result.add(status);
			}
		}

		return result.isEmpty() ? Status.OK_STATUS : (result.size() == 1) ? result.get(0) : new MultiStatus(Activator.PLUGIN_ID, 0, result.toArray(new IStatus[result.size()]), "Problems occurred in search.", null);
	}

	public ISearchResult getSearchResult() {
		PapyrusSearchResult result = new PapyrusSearchResult(this);

		for(AbstractPapyrusQuery next : queries) {
			AbstractTextSearchResult nextResult = (AbstractTextSearchResult)next.getSearchResult();

			Object[] elements = nextResult.getElements();
			for(int i = 0; i < elements.length; i++) {
				result.addMatches(nextResult.getMatches(elements[i]));
			}
		}

		return result;
	}
}
