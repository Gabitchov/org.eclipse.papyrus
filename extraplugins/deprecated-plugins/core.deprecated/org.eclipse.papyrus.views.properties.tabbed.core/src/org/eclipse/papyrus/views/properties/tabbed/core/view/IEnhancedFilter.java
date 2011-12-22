/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.tabbed.core.view;

import org.eclipse.jface.viewers.IFilter;


/**
 * Improved interface for section filters, as the section can also be removed by another one which could be enabled.
 */
public interface IEnhancedFilter extends IFilter {

	/**
	 * Indicates if the element can display the selected object, without any display preference
	 * 
	 * @param objectToTest
	 *        the object to Test
	 * @return <code>true</code> if the filtered element is enable, without display preferences filter.
	 */
	public boolean selectWithoutVisibility(Object objectToTest);

}
