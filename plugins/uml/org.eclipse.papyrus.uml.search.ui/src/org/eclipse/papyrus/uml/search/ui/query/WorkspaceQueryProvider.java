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
 *   Christian W. Damus (CEA LIST) - Extracted portions of the PapyrusSearchPage code.
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.search.ui.query;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.views.search.scope.ScopeEntry;
import org.eclipse.papyrus.views.search.utils.DefaultServiceRegistryTracker;
import org.eclipse.papyrus.views.search.utils.IServiceRegistryTracker;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * The default query provider implementation that knows how to query model resources in the Eclipse workspace.
 */
public class WorkspaceQueryProvider implements IPapyrusQueryProvider {

	protected Set<EObject> umlMetaClasses = new HashSet<EObject>();

	public WorkspaceQueryProvider() {
		super();
	}

	public boolean canProvideFor(URI scope) {
		// I always brute-force load the model to query it, so I can provide for any URI
		return true;
	}

	public AbstractPapyrusQuery createSimpleSearchQuery(QueryInfo queryInfo) {
		initMetaClasses();
		Collection<ScopeEntry> scopeEntries = createScopeEntries(queryInfo.getScope());
		return new PapyrusQuery(queryInfo.getQueryText(), queryInfo.isCaseSensitive(), queryInfo.isRegularExpression(), scopeEntries, umlMetaClasses.toArray(), queryInfo.isSearchAllStringAttributes());
	}

	public AbstractPapyrusQuery createAdvancedSearchQuery(QueryInfo queryInfo) {
		Collection<ScopeEntry> scopeEntries = createScopeEntries(queryInfo.getScope());
		return new PapyrusAdvancedQuery(queryInfo.getQueryText(), queryInfo.isCaseSensitive(), queryInfo.isRegularExpression(), scopeEntries, queryInfo.getParticipantTypes().toArray());
	}


	private void initMetaClasses() {
		// the UML metamodel doesn't change once we have scraped it
		if(umlMetaClasses.isEmpty()) {
			for(EClassifier eClassifier : UMLPackage.eINSTANCE.getEClassifiers()) {
				if(eClassifier instanceof EClass) {
					umlMetaClasses.add(eClassifier);
				}
			}
		}
	}

	/**
	 * Create scopeEntries based on URIs.
	 * 
	 * @return the created scopeEntries
	 */
	public static Collection<ScopeEntry> createScopeEntries(Collection<URI> scope) {
		IServiceRegistryTracker tracker = createServiceRegistryTracker();
		Collection<ScopeEntry> results = new HashSet<ScopeEntry>();

		for(URI uri : scope) {

			ScopeEntry scopeEntry = new ScopeEntry(uri, tracker);

			results.add(scopeEntry);

		}

		return results;
	}

	static IServiceRegistryTracker createServiceRegistryTracker() {
		return new DefaultServiceRegistryTracker();
	}
}
