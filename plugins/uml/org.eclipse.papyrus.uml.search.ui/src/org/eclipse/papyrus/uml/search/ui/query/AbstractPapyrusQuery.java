/*****************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Christian W. Damus (CEA LIST) - Fix leaking of all UML models in search results
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.search.ui.query;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.uml.search.ui.results.PapyrusSearchResult;
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

	//
	// Nested types
	//
	
	public static final class Empty extends AbstractPapyrusQuery {
		public static final Empty INSTANCE = new Empty();
		
		private Empty() {
			super();
		}
		
		public IStatus run(IProgressMonitor monitor) throws OperationCanceledException {
			return Status.OK_STATUS;
		}

		public String getLabel() {
			return "Empty Papyrus Search";
		}

		public boolean canRerun() {
			return true;
		}

		public boolean canRunInBackground() {
			return true;
		}

		public PapyrusSearchResult getSearchResult() {
			return new PapyrusSearchResult(this);
		}

		@Override
		public String getSearchQueryText() {
			return "";
		}
		
	}
}
