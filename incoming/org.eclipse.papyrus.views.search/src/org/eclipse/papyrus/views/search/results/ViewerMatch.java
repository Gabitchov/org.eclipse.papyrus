/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.search.results;

import org.eclipse.papyrus.views.search.scope.ScopeEntry;

/**
 * 
 * A match raised by a viewer (i.e. something that is a view of a real match) in a model
 * 
 */
public class ViewerMatch extends AbstractResultEntry {

	/**
	 * The model element that is represented by the viewer
	 */
	protected Object semanticElement;

	public ViewerMatch(Object source, ScopeEntry scopeEntry, Object semanticElement) {
		super(UNSPECIFIED, UNSPECIFIED, source, scopeEntry);
		this.semanticElement = semanticElement;

		this.parent = getLastParent(this, scopeEntry);
		//		this.parent = new ResultEntry(scopeEntry.getResource(), scopeEntry);

	}

	public Object getSemanticElement() {
		return semanticElement;
	}

	public void setSemanticElement(Object semanticElement) {
		this.semanticElement = semanticElement;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.search.results.AbstractResultEntry#elementToDisplay()
	 * 
	 * @return
	 */
	@Override
	public Object elementToDisplay() {
		return source;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.search.results.AbstractResultEntry#elementToCheckFilterFor()
	 * 
	 * @return
	 */
	@Override
	public Object elementToCheckFilterFor() {
		return semanticElement;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.search.results.AbstractResultEntry#elementToOpen()
	 * 
	 * @return
	 */
	@Override
	public Object elementToOpen() {
		return source;
	}

}
