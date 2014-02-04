/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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

package org.eclipse.papyrus.uml.xtext.integration.core;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class ContextElementUtil {

	public static EObject getContextElement(Resource resource) {
		ContextElementAdapter existingAdapter = (ContextElementAdapter) EcoreUtil.getExistingAdapter(resource,
				ContextElementAdapter.class);
		if (existingAdapter != null) {
			return existingAdapter.getElement();
		}
		return null;
	}
}
