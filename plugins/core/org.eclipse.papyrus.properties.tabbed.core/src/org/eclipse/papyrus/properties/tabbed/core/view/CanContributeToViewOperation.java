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
package org.eclipse.papyrus.properties.tabbed.core.view;

import java.util.Arrays;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;


/**
 *
 */
@Deprecated
public class CanContributeToViewOperation implements IOperation {

	/** the object to test */
	private Object objectToTest;

	/**
	 * Creates a new CanContributeToViewOperation.
	 * 
	 * @param objectToTest
	 *        the object to test
	 */
	public CanContributeToViewOperation(Object objectToTest) {
		this.objectToTest = objectToTest;
	}

	/**
	 * {@inheritDoc}
	 */
	public Boolean execute(IProvider provider) {
		if(provider instanceof XMLPropertyViewProvider) {
			return ((XMLPropertyViewProvider)provider).canContributeToPropertyView(Arrays.asList(objectToTest));
		}
		return false;
	}

}
