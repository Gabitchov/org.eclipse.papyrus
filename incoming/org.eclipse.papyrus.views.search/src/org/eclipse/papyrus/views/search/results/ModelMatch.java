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
 * A real result entry in a model
 * 
 */
public abstract class ModelMatch extends AbstractResultEntry {

	public ModelMatch(int offset, int lenght, Object source, ScopeEntry scopeEntry) {
		super(offset, lenght, source, scopeEntry);
	}

}
