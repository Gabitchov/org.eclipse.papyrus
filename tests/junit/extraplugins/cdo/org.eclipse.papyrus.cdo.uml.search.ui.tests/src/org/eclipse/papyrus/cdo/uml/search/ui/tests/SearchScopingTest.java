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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Collections;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.cdo.uml.search.internal.ui.query.CDOSearchQueryProvider;
import org.eclipse.papyrus.uml.search.ui.query.AbstractPapyrusQuery;
import org.eclipse.papyrus.uml.search.ui.query.QueryInfo;
import org.junit.Test;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;


/**
 * This is the BasicTextSearchTest.java type. Enjoy.
 */
public class SearchScopingTest extends AbstractPapyrusCDOSearchTest {

	public SearchScopingTest() {
		super();
	}

	@Test
	public void testCanProvideFor() {
		CDOSearchQueryProvider provider = new CDOSearchQueryProvider();
		assertThat(provider.canProvideFor(getRepositoryURI()), is(true));
		assertThat(provider.canProvideFor(getTestFolderURI()), is(true));
		assertThat(provider.canProvideFor(URI.createPlatformResourceURI("/GarageModel/garage.uml", true)), is(false));
	}

	@Test
	public void testSearchWholeFolder() {
		CDOSearchQueryProvider provider = new CDOSearchQueryProvider();
		QueryInfo info = new QueryInfo("close", false, false, false, Collections.singleton(getTestFolderURI()));

		AbstractPapyrusQuery query = provider.createSimpleSearchQuery(info);
		query.run(new NullProgressMonitor());

		assertMatchedAny(query.getSearchResult(), resourceName("garage"));
		assertMatchedAny(query.getSearchResult(), resourceName("tracker"));
	}

	@Test
	public void testSearchModel() {
		CDOSearchQueryProvider provider = new CDOSearchQueryProvider();

		QueryInfo info = new QueryInfo("close", false, false, false, //
		// trim the trailing empty segment of the folder URI to avoid getting a double separator ("//")
		Collections.singleton(getTestFolderURI().trimSegments(1).appendSegment("GarageModel").appendSegment("garage.uml")));

		AbstractPapyrusQuery query = provider.createSimpleSearchQuery(info);
		query.run(new NullProgressMonitor());

		assertMatched(query.getSearchResult(), resourceName("garage"));
		assertNotMatched(query.getSearchResult(), resourceName("tracker"));
	}

	//
	// Test framework
	//

	protected Predicate<EObject> resourceName(final String name) {
		return new Predicate<EObject>() {

			@Override
			public boolean apply(EObject input) {
				Resource resource = input.eResource();
				return Objects.equal(resource.getURI().trimFileExtension().lastSegment(), name);
			}
		};
	}

}
