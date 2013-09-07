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
package org.eclipse.papyrus.cdo.uml.search.ui.tests;

import java.util.Collections;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.papyrus.cdo.uml.search.internal.ui.query.CDOSearchQueryProvider;
import org.eclipse.papyrus.uml.search.ui.query.AbstractPapyrusQuery;
import org.eclipse.papyrus.uml.search.ui.query.QueryInfo;
import org.junit.Test;


/**
 * This is the BasicTextSearchTest type. Enjoy.
 */
public class BasicTextSearchTest extends AbstractPapyrusCDOSearchTest {

	public BasicTextSearchTest() {
		super();
	}

	@Test
	public void testSearchByName() {
		CDOSearchQueryProvider provider = new CDOSearchQueryProvider();
		QueryInfo info = new QueryInfo("close", false, false, false, Collections.singleton(getTestFolderURI()));

		AbstractPapyrusQuery query = provider.createSimpleSearchQuery(info);
		query.run(new NullProgressMonitor());

		assertMatched(query.getSearchResult(), name(Pattern.compile(".*close.*", Pattern.CASE_INSENSITIVE)));
	}

	@Test
	public void testSearchByNameCaseSensitive() {
		CDOSearchQueryProvider provider = new CDOSearchQueryProvider();
		QueryInfo info = new QueryInfo("Bug", true, false, false, Collections.singleton(getTestFolderURI()));

		AbstractPapyrusQuery query = provider.createSimpleSearchQuery(info);
		query.run(new NullProgressMonitor());

		assertMatched(query.getSearchResult(), name(Pattern.compile(".*Bug.*")));
		assertNotMatched(query.getSearchResult(), name(Pattern.compile(".*bug.*")));
	}

	@Test
	public void testSearchByNameRegex() {
		CDOSearchQueryProvider provider = new CDOSearchQueryProvider();
		QueryInfo info = new QueryInfo("^[Bb]ug.*", false, true, false, Collections.singleton(getTestFolderURI()));

		AbstractPapyrusQuery query = provider.createSimpleSearchQuery(info);
		query.run(new NullProgressMonitor());

		assertMatchedAny(query.getSearchResult(), name(Pattern.compile("Bug.*")));
		assertMatchedAny(query.getSearchResult(), name(Pattern.compile("bug.*")));
		assertNotMatched(query.getSearchResult(), name(Pattern.compile(".+[Bb]ug.*")));
	}


	@Test
	public void testSearchByAnyString() {
		CDOSearchQueryProvider provider = new CDOSearchQueryProvider();
		QueryInfo info = new QueryInfo("Bug", true, false, true, Collections.singleton(getTestFolderURI()));

		AbstractPapyrusQuery query = provider.createSimpleSearchQuery(info);
		query.run(new NullProgressMonitor());

		assertMatched(query.getSearchResult(), anyString(Pattern.compile(".*Bug.*")));
		assertNotMatchedAny(query.getSearchResult(), name(Pattern.compile(".*Bug.*")));
	}

}
