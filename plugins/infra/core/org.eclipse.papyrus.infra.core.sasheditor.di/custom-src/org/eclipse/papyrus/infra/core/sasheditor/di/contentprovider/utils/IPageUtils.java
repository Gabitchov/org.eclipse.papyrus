/*****************************************************************************
 * Copyright (c) 2010 LIFL & CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin (LIFL) cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.utils;

import org.eclipse.papyrus.infra.core.sasheditor.editor.IPage;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;


/**
 * Class providing a utility methods allowing to get the real Model from the {@link IPage#getRawModel()}.
 * The utility takes into account the bug 309943.
 * 
 * @author cedric dumoulin
 *
 */
public class IPageUtils {
	
	/**
	 * Get the real model rather than the PageRef. This method is a trick to temporally solve the bug 309943.
	 * @param page
	 * @return
	 */
	public static Object getRawModel(IPage page) {
		
		if(page == null)
			return null;
		
		Object pageModel = page.getRawModel();
		// Get the real model because of bug
		if( pageModel instanceof PageRef)
		{
			return ((PageRef)pageModel).getPageIdentifier();
		}
		// do not use trick
		return pageModel;
	}

	/**
	 * Lookup the IPage model corresponding to the identifier from the {@link ISashWindowsContainer}.
	 * The identifier can be either a {@link PageRef} or a emf Diagram.
	 * <br>
	 * This method can be used as a hack to bug 401107
	 * 
	 * @param container
	 * @param identifier
	 * @return The corresponding IPage, or null if not found.
	 */
	public static IPage lookupModelPage(ISashWindowsContainer container, Object identifier) {
		
		LookupIPageVisitor visitor = new LookupIPageVisitor(identifier);
		container.visit( visitor);
		return visitor.getResult();
	}
}
