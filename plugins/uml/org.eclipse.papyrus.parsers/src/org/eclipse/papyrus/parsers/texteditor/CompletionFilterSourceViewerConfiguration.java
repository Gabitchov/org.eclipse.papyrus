/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.parsers.texteditor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

/**
 * The Class CompletionFilterSourceViewerConfiguration.
 */
public class CompletionFilterSourceViewerConfiguration extends SourceViewerConfiguration {

	ICompletionFilter filter = null;

	/**
	 * Instantiates a new completion filter source viewer configuration without active filter
	 */
	public CompletionFilterSourceViewerConfiguration() {
		filter = new NullCompletionFilter();
	}

	/**
	 * Instantiates a new completion filter source viewer configuration with active filter
	 * 
	 * @param filter the filter
	 */
	public CompletionFilterSourceViewerConfiguration(ICompletionFilter filter) {
		this.filter = filter;
	}

	/**
	 * The Interface ICompletionFilter to set up the filter
	 */
	public interface ICompletionFilter {

		/**
		 * Filter.
		 * 
		 * @param context
		 * @param e
		 * 
		 * @return true if object is filtered, false if it is not
		 */
		public boolean filter(int context, EObject e);
	}

	/**
	 * NullCompletionFilter to disable filter as default behavior
	 */
	public static class NullCompletionFilter implements ICompletionFilter {

		/**
		 * @see org.eclipse.papyrus.parsers.texteditor.CompletionFilterSourceViewerConfiguration.ICompletionFilter#filter(int, org.eclipse.emf.ecore.EObject)
		 */
		public boolean filter(int context, EObject e) {
			return false;
		}
	}

	/**
	 * Gets the filter.
	 * 
	 * @return the filter
	 */
	protected ICompletionFilter getFilter() {
		return filter;
	}

}
