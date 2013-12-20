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

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.uml.search.ui.providers.ParticipantTypeElement;
import org.eclipse.uml2.uml.NamedElement;

/**
 * A <em>Parameter Object</em> for creation of {@link AbstractPapyrusQuery} instances via an {@link IPapyrusQueryProvider}.
 */
public class QueryInfo {

	private String queryText;

	private boolean caseSensitive;

	private boolean regularExpression;

	private boolean searchAllStringAttributes;

	private Collection<? extends ParticipantTypeElement> participantTypes;
	
	private boolean searchForAllSter;

	private Collection<URI> scope;

	/**
	 * Creates a query info for simple query.
	 * 
	 * @param queryText
	 *        the user-supplied search query text
	 * @param caseSensitive
	 *        whether the {@code queryText} is to be applied in case-sensitive fashion
	 * @param regularExpression
	 *        whether the {@code queryText} is to be taken as a regular expression
	 * @param searchAllStringAttributes
	 *        whether to search all string attributes of UML metaclasses ({@code true}), or just named element {@linkplain NamedElement#getName()
	 *        names} ({@code false})
	 * @param scope
	 *        the domain-specific search scope
	 */
	public QueryInfo(String queryText, boolean caseSensitive, boolean regularExpression, boolean searchAllStringAttributes, Collection<URI> scope) {
		super();

		
		this.queryText = queryText;
		this.caseSensitive = caseSensitive;
		this.regularExpression = regularExpression;
		this.searchAllStringAttributes = searchAllStringAttributes;
		this.participantTypes = Collections.emptyList();
		this.scope = scope;
	}

	/**
	 * Creates a query info for advanced query.
	 * 
	 * @param queryText
	 *        the user-supplied search query text
	 * @param caseSensitive
	 *        whether the {@code queryText} is to be applied in case-sensitive fashion
	 * @param regularExpression
	 *        whether the {@code queryText} is to be taken as a regular expression
	 * @param participantTypes
	 *        the participant types (identifying specific metaclasses and/or attributes) to include in the search
	 * @param searchForAllSter
	 *        stereotype application must all applied or not
	 * @param scope
	 *        the domain-specific search scope
	 */
	public QueryInfo(String queryText, boolean caseSensitive, boolean regularExpression, Collection<? extends ParticipantTypeElement> participantTypes, Collection<URI> scope,boolean searchForAllSter) {
		super();

		this.queryText = queryText;
		this.caseSensitive = caseSensitive;
		this.regularExpression = regularExpression;
		this.searchAllStringAttributes = false;
		this.participantTypes = participantTypes;
		this.scope = scope;
		this.searchForAllSter = searchForAllSter;
	}
	
	/**
	 * Partition copy constructor.
	 */
	private QueryInfo(QueryInfo original, Collection<URI> scope) {
		super();

		this.queryText = original.queryText;
		this.caseSensitive = original.caseSensitive;
		this.regularExpression = original.regularExpression;
		this.searchAllStringAttributes = original.searchAllStringAttributes;
		this.participantTypes = original.participantTypes;
		this.searchForAllSter = original.searchForAllSter;
		this.scope = scope;
	}

	public String getQueryText() {
		return queryText;
	}

	public boolean isCaseSensitive() {
		return caseSensitive;
	}

	public boolean isRegularExpression() {
		return regularExpression;
	}

	public boolean isSearchAllStringAttributes() {
		return searchAllStringAttributes;
	}

	public Collection<? extends ParticipantTypeElement> getParticipantTypes() {
		return participantTypes;
	}

	public Collection<URI> getScope() {
		return scope;
	}
	
	public boolean isSearchForAllSter() {
		return searchForAllSter;
	}


	/**
	 * Creates a new instance encapsulating query parameters for the specified partition (strict subset) of my {@linkplain #getScope() scope}.
	 * 
	 * @param scopePartition a partition of my scope
	 * 
	 * @return the partition query info
	 * 
	 * @see #getScope()
	 */
	public QueryInfo partition(Collection<URI> scopePartition) {
		return new QueryInfo(this, scopePartition);
	}
}
