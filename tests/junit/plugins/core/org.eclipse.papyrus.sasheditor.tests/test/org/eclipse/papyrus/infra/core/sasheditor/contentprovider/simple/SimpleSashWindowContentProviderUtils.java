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

package org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple;

import java.util.Map;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.IModelExp;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.PagesModelException;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.PanelTerm;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.WindowTerm;
import org.eclipse.papyrus.infra.core.sasheditor.tests.utils.ISashWindowsContentProviderTestUtils;

/**
 * Class providing some utilities to check the {@link SimpleSashWindowsContentProvider} class.
 * <br>
 * This utilities allow to: populate a contentProvider, compare the contentProvider structure
 * query the contentProvider structure.
 * 
 * @author cedric dumoulin
 *
 */
public class SimpleSashWindowContentProviderUtils implements ISashWindowsContentProviderTestUtils {

	/**
	 * ContentProvider used .
	 */
	protected SimpleSashWindowsContentProvider contentProvider;
	
	/**
	 * Constructor.
	 * Create a default internal {@link SimpleSashWindowsContentProvider};
	 * @param modelMngr
	 */
	public SimpleSashWindowContentProviderUtils() {
		this.contentProvider = new SimpleSashWindowsContentProvider();
	}

	/**
	 * Constructor.
	 *
	 * @param modelMngr
	 */
	public SimpleSashWindowContentProviderUtils(SimpleSashWindowsContentProvider contentProvider) {
		this.contentProvider = contentProvider;
	}


	
	/**
	 * @return the contentProvider
	 */
	public ISashWindowsContentProvider getIContentProvider() {
		return contentProvider;
	}


	/**
	 * Check if the sashModel is conformed to the specified query.
	 * @param query
	 * @throws QueryException 
	 */
	public void assertConform(IModelExp query) throws PagesModelException {
		
		Object first;
		if( query instanceof WindowTerm) {
			first = getFirstWindowModel();
		}
		else if( query instanceof PanelTerm) {
			first = getFirstPanelModel();
		}
		else {
			throw new PagesModelException("Don't know how to get the model associated to the first term of the expression (" + query.toString() + ")");
		}
		
		CheckVisitor visitor = new CheckVisitor();
		query.accept(visitor, first);
	}

	/**
	 * Create an internal model conform to the specified query.
	 * Any previous model is disguarded.
	 * 
	 * This method should only be called once on a {@link SimpleSashWindowsContentProvider}.
	 * 
	 * @param query Should be a subtype PanelTerm (Folder, HSash, VSash)
	 * @throws QueryException 
	 * 
	 * TODO Ensure that the method can only be called once. For example,
	 * let this class extends {@link SimpleSashWindowsContentProvider}, and the constructor
	 * call this method.
	 */
	public void createModel(IModelExp query) throws PagesModelException {
		
		Object first ;
		if( query instanceof PanelTerm) {
			first = getFirstWindowModel();
		}
		else {
			throw new PagesModelException("Don't know how to get the model associated to the first term of the expression (" + query.toString() + ")");
		}
		
		// Create a surrounding WindowTerm
		WindowTerm windowTerm = new WindowTerm((PanelTerm)query);
		
		CreateModelInSimpleContentProviderVisitor visitor = new CreateModelInSimpleContentProviderVisitor(contentProvider);
		windowTerm.accept(visitor, first);
	}

	/**
	 * Get element in the model.
	 * Each model element whose corresponding model query part as a name is added to the result map.
	 * The element is then accessible with the name set in the query part.
	 * 
	 * @param query
	 * @return
	 * @throws QueryException
	 */
	public Map<String, Object> queryModel(IModelExp query) throws PagesModelException {
		
		Object first;
		if( query instanceof WindowTerm) {
			first = getFirstWindowModel();
		}
		else if( query instanceof PanelTerm) {
			first = getFirstPanelModel();
		}
		else {
			throw new PagesModelException("Don't know how to get the model associated to the first term of the expression (" + query.toString() + ")");
		}
		
		QueryVisitor visitor = new QueryVisitor();
		query.accept(visitor, first);
		
		return visitor.getResult();
	}

	/**
	 * Get the model of the first the first window (in actual implementation their is only one window).
	 * @return
	 */
	private RootModel getFirstWindowModel() {
		// Silly method to get the RootModel
		return (RootModel)((AbstractPanelModel)contentProvider.getRootModel()).getParent();
	}

	/**
	 * Get the panel of the first window (in actual implementation their is only one window).
	 * @return
	 */
	private AbstractPanelModel getFirstPanelModel() {
		// In this implementation, the root is always of type AbstractPanelModel
		return (AbstractPanelModel)contentProvider.getRootModel();
	}
	
}
