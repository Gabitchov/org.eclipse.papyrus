/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.robotml.modelexplorer.query;

import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.uml2.uml.Element;

/** Check is the element has a stereotype icon that can be used */
public class HasImageQuery implements IJavaModelQuery<Element, Boolean> {

	public Boolean evaluate(final Element context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {

		IJavaModelQuery<Element, String> ImgageGetter = new GetImageQuery();
		String temp_img_path = ImgageGetter.evaluate(context, parameterValues);
		if(!"".equals(temp_img_path)) {
			return true;
		}

		return false;
	}
}
