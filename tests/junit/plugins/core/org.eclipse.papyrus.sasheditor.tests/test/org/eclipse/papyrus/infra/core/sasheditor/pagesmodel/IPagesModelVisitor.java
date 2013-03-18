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

package org.eclipse.papyrus.infra.core.sasheditor.pagesmodel;

/**
 * Visitor used to visit query structure.
 * 
 * @author cedric dumoulin
 *
 * @param M Type of the models provided to visit() and walk(). This is the common 
 * ancestor of the provided types.
 * 
 */
public interface IPagesModelVisitor <M>{

	/**
	 * If true, parent are visited before children.
	 * If false, parent are visited after children.
	 * @return
	 */
	public boolean isVisitingParentFirst();
	
	/**
	 * Walk the node and its children. Call visit visit method appropiatly.
	 * This method encapsulate the navigation between nodes.
	 * 
	 * @param windowTerm The term to navigate
	 * @param windowModel the model that maybe correspond to the term.
	 * @throws PagesModelException 
	 * 
	 */
	public void walk( SashPagesModel windowTerm, M windowModel ) throws PagesModelException;
	public void walk( WindowTerm windowTerm, M windowModel ) throws PagesModelException;
	public void walk( Folder folder, M folderModel ) throws PagesModelException;
	
	public void walk(HSash sash, M sashModel) throws PagesModelException;
	public void walk(VSash sash, M sashModel) throws PagesModelException;

	public void walk(Page page, M pageModel) throws PagesModelException;


	/**
	 * Visit the corresponding term.
	 * @param windowTerm The term to visit
	 * @param windowModel The corresponding model found while walking the expr.
	 */
//	public void visit( SashPagesModel windowTerm, M windowModel ) throws PagesModelException;
//	public void visit( WindowTerm windowTerm, M windowModel ) throws PagesModelException;
//	public void visit( Folder folder, M folderModel ) throws PagesModelException;
//	
//	public void visit(HSash sash, M sashModel) throws PagesModelException;
//	public void visit(VSash sash, M sashModel) throws PagesModelException;
//
//	public void visit(Page page, M pageModel) throws PagesModelException;
	
}
