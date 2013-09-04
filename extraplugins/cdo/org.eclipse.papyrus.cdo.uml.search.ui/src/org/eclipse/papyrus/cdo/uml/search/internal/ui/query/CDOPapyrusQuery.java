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
package org.eclipse.papyrus.cdo.uml.search.internal.ui.query;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.cdo.view.CDOQuery;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.net4j.util.lifecycle.ILifecycle;
import org.eclipse.net4j.util.lifecycle.LifecycleEventAdapter;
import org.eclipse.papyrus.cdo.uml.search.internal.ui.Activator;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResourceSet;
import org.eclipse.papyrus.uml.search.ui.query.AbstractPapyrusQuery;
import org.eclipse.papyrus.uml.search.ui.results.PapyrusSearchResult;
import org.eclipse.papyrus.views.search.results.ModelElementMatch;
import org.eclipse.papyrus.views.search.scope.ScopeEntry;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.common.collect.Maps;


/**
 * This is the CDOPapyrusQuery type. Enjoy.
 */
public class CDOPapyrusQuery extends AbstractPapyrusQuery {

	private final String searchText;

	private final CDOView view;

	private final CDOQuery query;

	private final PapyrusSearchResult searchResult = new PapyrusSearchResult(this);

	public CDOPapyrusQuery(String searchText, CDOView view, CDOQuery query) {
		super();

		this.searchText = searchText;
		this.view = view;
		this.query = query;

		view.addListener(createViewClosedListener());
	}

	@Override
	public String getLabel() {
		return "Papyrus Model Repository Search";
	}

	@Override
	public String getSearchQueryText() {
		return searchText;
	}

	@Override
	public boolean canRerun() {
		// I can be run again as long as my view is open
		return (view != null) && !view.isClosed();
	}

	@Override
	public boolean canRunInBackground() {
		return true;
	}

	@Override
	public IStatus run(IProgressMonitor monitor) throws OperationCanceledException {
		IStatus result = Status.OK_STATUS;

		searchResult.removeAll();

		// we cannot query for EClasses that the server doesn't know about. And,
		// if it doesn't know about an EClass, then a priori, none of its
		// instances exist, so we don't need to run the query
		if(view.getSession().getPackageRegistry().getPackageInfo(UMLPackage.eINSTANCE) != null) {
			List<Element> queryResult = query.getResult(Element.class);

			final Map<URI, ScopeEntry> scopeEntries = Maps.newHashMap();

			// don't use an iterator because it won't be able to advance
			// past a resource proxy that cannot be resolved
			for(int i = 0; i < queryResult.size(); i++) {
				try {
					Element next = queryResult.get(i);

					Resource resource = next.eResource();
					ResourceSet rset = resource.getResourceSet();
					ServicesRegistry services = ServiceUtilsForResourceSet.getInstance().getServiceRegistry(rset);
					ScopeEntry scopeEntry = scopeEntries.get(resource.getURI());
					if(scopeEntry == null) {
						scopeEntry = new ScopeEntry(resource.getURI(), services);
						scopeEntries.put(resource.getURI(), scopeEntry);
					}

					// TODO: Post-process query results to determine attribute matches?
					searchResult.addMatch(new ModelElementMatch(next, scopeEntry));
				} catch (Exception e) {
					// can get "node not found" exceptions on incompletely
					// deleted resources
					Activator.log.error("Error retrieving resource result from CDO query.", e); //$NON-NLS-1$
				}
			}

		}

		return result;
	}

	@Override
	public ISearchResult getSearchResult() {
		return searchResult;
	}

	private IListener createViewClosedListener() {
		return new LifecycleEventAdapter() {

			@Override
			protected void onDeactivated(ILifecycle lifecycle) {
				// the view is closed.  The user probably closed the repository session.  Attempts to access the search results
				// will fail henceforth, so clear them
				if(searchResult != null) {
					searchResult.removeAll();
				}
			}
		};
	}
}
