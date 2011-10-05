/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.uml.modelexplorer.recipetest;

import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.uml2.uml.Package;

/** return Cyan if the package contains memebers and yellow if not */
public class GetBackgroundPackageColor implements IJavaModelQuery<Package, String> {

	public String evaluate(final Package context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		if(context.getOwnedElements().size() == 0) {
			return new String("(255,255,128)"); //yellow
		} else {
			return new String("(128,255,255)"); //cyan
		}

	}
}
