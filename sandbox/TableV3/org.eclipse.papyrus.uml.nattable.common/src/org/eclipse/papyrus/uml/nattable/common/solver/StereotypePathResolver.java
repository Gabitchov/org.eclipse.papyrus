/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.common.solver;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.nattable.common.solver.IPathResolver;
import org.eclipse.papyrus.uml.nattable.common.utils.Constants;


public class StereotypePathResolver implements IPathResolver {

	public boolean handles(final String path) {
		return path.startsWith(Constants.PROPERTY_OF_STEREOTYPE_PREFIX);
	}

	public Object getRealObject(final String path, final EObject context) {
		// TODO Auto-generated method stub
		return null;
	}



}
