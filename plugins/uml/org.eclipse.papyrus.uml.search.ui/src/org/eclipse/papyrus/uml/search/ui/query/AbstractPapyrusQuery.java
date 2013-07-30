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
package org.eclipse.papyrus.uml.search.ui.query;

import org.eclipse.search.ui.ISearchQuery;

/**
 * 
 * Papyrus specific search query
 * 
 */
public abstract class AbstractPapyrusQuery implements ISearchQuery {

	/**
	 * Getter for the text query
	 * 
	 * @return the the query text
	 */
	public abstract String getSearchQueryText();

	public boolean isCaseSensitive() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isRegularExpression() {
		// TODO Auto-generated method stub
		return false;
	}

}
