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
package org.eclipse.papyrus.properties.runtime.controller.predefined;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.papyrus.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;


/**
 * Operation that returns the list of all predefined controllers for this element
 */
public class GetAllPredefinedPropertyEditorControllersOperation implements IOperation {

	/**
	 * {@inheritDoc}
	 */
	public Collection<IPropertyEditorControllerDescriptor> execute(IProvider provider) {
		if(provider instanceof PredefinedPropertyControllerProvider) {
			return ((PredefinedPropertyControllerProvider)provider).getAllPredefinedProviders();
		}
		return Collections.emptyList();
	}

}
