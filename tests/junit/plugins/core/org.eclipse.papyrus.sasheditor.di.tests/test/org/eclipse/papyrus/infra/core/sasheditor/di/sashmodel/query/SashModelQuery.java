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

package org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.sashwindows.di.AbstractPanel;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashModel;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.infra.core.sashwindows.di.Window;

/**
 * Class used to check and query (from tests) the DiContentProvider.
 * <br>
 * This class also provide a set of static constructor helping in writing query.
 * <br>
 * Examples:
 * <ul>
 *   <li>PanelTerm query = folder("a", page(), page() );</li>
 *   <li>query = hSash( folder( page("p1"), page() ), vSash("s2",  folder( page() ),  folder( page() )) );</li>
 *   <li>PanelTerm query = hSash( folder("f1", page("p1"), page("p2"), page("p3") ), folder("f2", page("p4") ) );</li>
 *   <li></li>
 * </ul>
 * @author cedric dumoulin
 *
 */
public class SashModelQuery {

	/**
	 * Model to query.
	 */
	protected SashModel sashModel;
	
	/**
	 * Static constructor for {@link Page}.
	 * @return
	 */
	static public Page page() {
		return new Page();
	}
	
	/**
	 * Static constructor for {@link Page}.
	 * @return
	 */
	static public Page page(String name) {
		return new Page(name);
	}
	
	/**
	 * Static constructor for {@link Folder}.
	 * @return
	 */
	static public Folder folder( Page ...pages ) {
		return new Folder(pages);
	}
	
	/**
	 * Static constructor for {@link Folder}.
	 * @return
	 */
	static public Folder folder( String name, Page ...pages ) {
		return new Folder(name, pages);
	}
	
	/**
	 * Static constructor for {@link VSash}.
	 * @return
	 */
	static public VSash vSash( String name, PanelTerm up, PanelTerm down) {
		return new VSash(name, up, down);
	}
	
	/**
	 * Static constructor for {@link VSash}.
	 * @return
	 */
	static public VSash vSash( PanelTerm up, PanelTerm down) {
		return new VSash(up, down);
	}
	
	/**
	 * Static constructor for {@link HSash}.
	 * @return
	 */
	static public HSash hSash( String name, PanelTerm left, PanelTerm right) {
		return new HSash(name, left, right);
	}
	
	/**
	 * Static constructor for {@link HSash}.
	 * @return
	 */
	static public HSash hSash( PanelTerm left, PanelTerm right) {
		return new HSash(left, right);
	}
	
	/**
	 * Constructor.
	 *
	 * @param modelMngr
	 */
	public SashModelQuery(SashWindowsMngr modelMngr) {
		this.sashModel = modelMngr.getSashModel();
	}

	/**
	 * Constructor.
	 *
	 * @param sashModel
	 */
	public SashModelQuery(SashModel sashModel) {
		this.sashModel = sashModel;
	}


	/**
	 * Check if the sashModel is conformed to the specified query.
	 * @param query
	 * @throws QueryException 
	 */
	public void assertConform(IQueryExp query) throws QueryException {
		
		EObject first;
		if( query instanceof WindowTerm) {
			first = getFirstWindowModel();
		}
		else if( query instanceof PanelTerm) {
			first = getFirstPanelModel();
		}
		else {
			throw new QueryException("Don't know how to get the model associated to the first term of the expression (" + query.toString() + ")");
		}
		
		CheckVisitor visitor = new CheckVisitor();
		query.accept(visitor, first);
	}

	/**
	 * Create an internal model conform to the specified query.
	 * Any previous model is disguarded.
	 * 
	 * @param query Should be a subtype PanelTerm (Folder, HSash, VSash)
	 * @throws QueryException 
	 */
	public void createModel(IQueryExp query) throws QueryException {
		
		Window first;
		if( query instanceof PanelTerm) {
			first = getFirstWindowModel();
		}
		else {
			throw new QueryException("Don't know how to get the model associated to the first term of the expression (" + query.toString() + ")");
		}
		
		// Create a surrounding WindowTerm
		WindowTerm windowTerm = new WindowTerm((PanelTerm)query);
		
		CreateModelVisitor visitor = new CreateModelVisitor();
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
	public Map<String, Object> queryModel(IQueryExp query) throws QueryException {
		
		EObject first;
		if( query instanceof WindowTerm) {
			first = getFirstWindowModel();
		}
		else if( query instanceof PanelTerm) {
			first = getFirstPanelModel();
		}
		else {
			throw new QueryException("Don't know how to get the model associated to the first term of the expression (" + query.toString() + ")");
		}
		
		QueryVisitor visitor = new QueryVisitor();
		query.accept(visitor, first);
		
		return visitor.getResult();
	}

	/**
	 * Get the model of the first the first window (in actual implementation their is only one window).
	 * @return
	 */
	private Window getFirstWindowModel() {
		return sashModel.getWindows().get(0);
	}

	/**
	 * Get the panel of the first window (in actual implementation their is only one window).
	 * @return
	 */
	private AbstractPanel getFirstPanelModel() {
		return sashModel.getWindows().get(0).getPanel();
	}
	
}
