/*******************************************************************************
 *  Copyright (c) 2012 CEA LIST.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Vincent Lorenzo (CEA-LIST) - Bug 373255 - Add tooltips providing a documentation for the selected elements in the Select ETypedElement Dialog
 *    
 *******************************************************************************/

package org.eclipse.papyrus.emf.facet.custom.ui.internal.query;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DocumentedElement;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.osgi.util.NLS;

/**
 * 
 * This query returns the tooltip to display for DocumentedElement and
 * EModelElement
 * 
 */
public class ToolTipTextQuery implements IJavaQuery2<EObject, String> {

	/** the URI used by EAnnotation for the documentation for the documentation */
	public static final String URI_GEN_MODEL = "http://www.eclipse.org/emf/2002/GenModel"; //$NON-NLS-1$

	/** the key to get the documentation in an EAnnotation */
	public static final String DOCUMENTATION = "documentation"; //$NON-NLS-1$

	/** the String displayed when there is no documentation */
	public static final String NO_DOCUMENTATION = Messages.ToolTipTextQuery_NoDocumentation;

	public String evaluate(final EObject source,
			final IParameterValueList2 parameterValues,
			final IFacetManager facetManager) {
		String result = null;
		final String documentation = getDocumentation(source);
		if (documentation != null) {
			result = NLS.bind(Messages.ToolTipTextQuery_Documentation,
				documentation);
		}
		return result;
	}

	/**
	 * 
	 * @param source
	 * @param parameterValues
	 * @param facetManager
	 * @return the documentation for DocumentedElement and EModelElement
	 */
	private static String getDocumentation(final EObject source) {
		String documentation = ""; //$NON-NLS-1$
		if (source instanceof DocumentedElement) {
			documentation = ((DocumentedElement) source).getDocumentation();
		} else if (source instanceof EModelElement) {
			final EAnnotation eAnnotation = ((EModelElement) source)
					.getEAnnotation(ToolTipTextQuery.URI_GEN_MODEL);
			if (eAnnotation != null) {
				documentation = eAnnotation.getDetails().get(
						ToolTipTextQuery.DOCUMENTATION);
			}
		}
		return documentation;
	}
}