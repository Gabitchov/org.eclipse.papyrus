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
 *  Vincent Lorenzo (CEA-LIST) - Bug 372644 - Create Customizable tooltips for the TreeViewer using a CustomizableLabelProvider
 *
 *****************************************************************************/

package org.eclipse.papyrus.emf.facet.custom.ui.internal.query;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.custompt.Color;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IColor;

/**
 * 
 * This query is used to get the default background color for the tooltips (255,255,225)
 *
 */
public class ToolTipBackgroundQuery implements IJavaQuery2<EObject, IColor> {

	private static final int BCK_GND_BLUE = 225;
	
	public IColor evaluate(final EObject source,
			final IParameterValueList2 parameterValues,
			final IFacetManager facetManager)
			throws DerivedTypedElementException {
		//default yellow background for tooltip
		return new Color(Color.MAX_VALUE, Color.MAX_VALUE, ToolTipBackgroundQuery.BCK_GND_BLUE);
	}
}
