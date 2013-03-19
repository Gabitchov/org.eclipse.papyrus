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

import java.util.ArrayList;
import java.util.List;

/**
 * Sash Pages model allow to create a models of the pages represented by the {@link SashWindowsContainer}.
 * Such model can then be used to create corresponding pages and intermediate artifact in a {@link ISashWindowsContentProvider},
 * or to check the structure, ....
 * 
 * <br>
 * The model contains windows. Actually, the {@link SashWindowsContainer} only support one window.
 * 
 * @author cedric dumoulin
 *
 */
public class SashPagesModel implements IModelExp {

	/**
	 * A window have only one panel.
	 */
	protected List<WindowTerm> windows = new ArrayList<WindowTerm>();

	protected String name;
	
	/**
	 * Constructor.
	 *
	 * @param panel
	 */
	public SashPagesModel(WindowTerm window) {
		this.windows.add(window);
	}

	/**
	 * Constructor.
	 *
	 * @param name
	 * @param panel
	 */
	public SashPagesModel(String name, WindowTerm window) {
		this.name = name;
		this.windows.add(window);
	}


	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.IModelObject.sashmodel.query.IQueryTerm#accept(org.eclipse.papyrus.infra.core.sasheditor.IPagesModelVisitor.sashmodel.query.IQueryVisitor, org.eclipse.emf.ecore.EObject)
	 *
	 * @param visitor
	 * @param panel
	 * @throws PagesModelException
	 */
	public <M> void accept(IPagesModelVisitor<M> visitor, M model) throws PagesModelException {

		visitor.walk(this, model);
		
	}


	/**
	 * @return the panel
	 * @throws PagesModelException 
	 */
	public WindowTerm getFirstWindow() throws PagesModelException {
		if( windows.size() >0) {
		return windows.get(0);
		}
		
		// no elements
		throw new PagesModelException("No window found in model.");
	}

	/**
	 * @return the panel
	 */
	public List<WindowTerm> getWindows() {
		return windows;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
