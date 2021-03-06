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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel;
import org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder;
import org.eclipse.papyrus.infra.core.sashwindows.di.Window;

/**
 * Visitor used to collect element in the model.
 * Each element in the model associated with a{@link IQueryTerm} whose name is set is collectted.
 * The collected element is then accessible from the result map, using the name set in the IQueryTerm.
 * 
 *  
 * @author cedric dumoulin
 *
 */
public class QueryVisitor implements IQueryVisitor {
	
	/**
	 * The result map.
	 */
	protected Map<String, Object>result = new HashMap<String, Object>();
	
	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryVisitor#visit(org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.WindowTerm, org.eclipse.papyrus.infra.core.sashwindows.di.Window)
	 *
	 * @param windowTerm
	 * @param windowModel
	 */
	public void visit(WindowTerm windowTerm, Window windowModel) {
      collect( windowTerm, windowModel);
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryVisitor#visit(org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.Folder, org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder)
	 *
	 * @param folder
	 * @param folderModel
	 */
	public void visit(Folder folder, TabFolder folderModel) {
		collect(folder, folderModel);

	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryVisitor#visit(org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.HSash, org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel)
	 *
	 * @param sash
	 * @param sashModel
	 */
	public void visit(HSash sash, SashPanel sashModel) {
		collect(sash, sashModel);

	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryVisitor#visit(org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.VSash, org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel)
	 *
	 * @param sash
	 * @param sashModel
	 */
	public void visit(VSash sash, SashPanel sashModel) {
		collect(sash, sashModel);

	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryVisitor#visit(org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.Page, org.eclipse.papyrus.infra.core.sashwindows.di.PageRef)
	 *
	 * @param page
	 * @param pageModel
	 */
	public void visit(Page page, PageRef pageModel) {
		collect(page, pageModel);

	}

	/**
	 * Add the element associated to the query to the result, if the query has a name.
	 * @param iQueryTerm
	 * @param element
	 */
	protected void collect( IQueryTerm iQueryTerm, Object element) {
		
		if( iQueryTerm.getName() == null) {
			return;
		}
		
		result.put(iQueryTerm.getName(), element);
	}
	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query.IQueryVisitor#isVisitingParentFirst()
	 *
	 * @return
	 */
	public boolean isVisitingParentFirst() {
		return true;
	}

	/**
	 * @return the result
	 */
	public Map<String, Object> getResult() {
		return result;
	}

}
