/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal;

import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.IPageModelFactory;
import org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryExp;
import org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.QueryException;
import org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.SashModelQuery;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashModel;
import org.eclipse.papyrus.infra.core.sashwindows.di.util.DiUtils;
import org.junit.After;
import org.junit.Before;

/**
 * @author dumoulin
 *
 */
public class DiContentProvider2Test extends AbstractDiContentProviderTest {

	/*
	 * 
	 */
	@Before
	public void setUp() throws Exception {
		IPageModelFactory pageModelFactory = new FakePageModelFactory();
		SashModel diSashModel = DiUtils.createDefaultSashModel();
		diContentProvider = new DiContentProvider(diSashModel, pageModelFactory);
		contentProvider = diContentProvider;
		
		// Create model query
		modelQuery = new SashModelQuery(diSashModel);
	}

	/**
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal.AbstractDiContentProviderTest#createModel(org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryTerm)
	 *
	 * @param query
	 * @throws QueryException 
	 */
	@Override
	protected void createModel(IQueryExp query) throws QueryException {
		modelQuery.createModel(query);
	}

}
