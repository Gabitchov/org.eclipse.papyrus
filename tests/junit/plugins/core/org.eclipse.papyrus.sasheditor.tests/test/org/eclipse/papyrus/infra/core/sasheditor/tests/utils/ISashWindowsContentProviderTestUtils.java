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

package org.eclipse.papyrus.infra.core.sasheditor.tests.utils;

import java.util.Map;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.IModelExp;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.PagesModelException;


/**
 * Common interface for utilities dedicated to IContentProvider tests. Implementations of this class
 * allow to create an internal model according to a provided {@link IModelExp}. It is also possible
 * to check if the internal model is conform to the {@link IModelExp}.
 * 
 * <br>
 * There is several {@link ISashWindowsContentProvider} implementations, but a lot of tests are commons to
 * all the implementations. The interface allows to develop common tests regardless of the real implementation.
 * <br>
 * One develop common tests using {@link ISashWindowsContentProvider} and {@link IContentProviderTestUtils}. Then,
 * this test is subclassed and the appropriate implementations are specified in the subclasses.
 * 
 * 
 * @author cedric dumoulin
 *
 */
public interface ISashWindowsContentProviderTestUtils {

	/**
	 * Create an internal model conform to the specified query.
	 * Any previous model is disguarded.
	 * 
	 * Some implementations do not allow to call this method more than once. In this case,
	 * the implementation should throw an Exception.
	 * 
	 * @param query Should be a subtype PanelTerm (Folder, HSash, VSash)
	 * @throws QueryException 
	 * 
	 */
	public abstract void createModel(IModelExp query) throws PagesModelException;

	/**
	 * Check if the internal model is conformed to the specified query.
	 * @param query
	 * @throws QueryException 
	 */
	public abstract void assertConform(IModelExp query) throws PagesModelException;

	/**
	 * Get element in the model.
	 * Each model element whose corresponding model query part as a name is added to the result map.
	 * The element is then accessible with the name set in the query part.
	 * 
	 * @param query
	 * @return
	 * @throws QueryException
	 */
	public abstract Map<String, Object> queryModel(IModelExp query) throws PagesModelException;

	/**
	 * Get the {@link ISashWindowsContentProvider} associated to this utility class.
	 * @return
	 */
	public ISashWindowsContentProvider getIContentProvider();
}
