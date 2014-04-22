/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.query;

import org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.custompt.URIImage;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;

public class DataContextsImageQuery implements IJavaQuery2<Context, IImage> {
	public IImage evaluate(final Context context, 
			final IParameterValueList2 parameterValues,
			final IFacetManager facetManager)
			throws DerivedTypedElementException {
		return new URIImage("platform:/plugin/org.eclipse.papyrus.customization.properties/icons/DataContexts.gif");
	}
}
