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

import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel;
import org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder;

/**
 * Visitor used to visit query structure.
 * 
 * @author cedric dumoulin
 *
 */
public interface IQueryVisitor {

	public void visit( WindowTerm windowTerm, org.eclipse.papyrus.infra.core.sashwindows.di.Window windowModel );
	public void visit( Folder folder, TabFolder folderModel );
	
	public void visit(HSash sash, SashPanel sashModel);
	public void visit(VSash sash, SashPanel sashModel);

	public void visit(Page page, PageRef pageModel) throws QueryException;
	
	/**
	 * If true, parent are visited before children.
	 * If false, parent are visited after children.
	 * @return
	 */
	public boolean isVisitingParentFirst();

}
