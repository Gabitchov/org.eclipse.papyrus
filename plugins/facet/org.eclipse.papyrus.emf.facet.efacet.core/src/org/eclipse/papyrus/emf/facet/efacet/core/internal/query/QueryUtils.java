/*******************************************************************************
 * Copyright (c) 2011, 2012 Mia-Software
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software) - Bug 361612 - New core for new version of the Facet metamodel
 *     Nicolas Bros (Mia-Software) - Bug 362191 - [Restructuring] Query mechanism for eFacet2
 *     Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *     Nicolas Bros (Mia-Software) - Bug 376941 - [EFacet] Facet operation arguments in Facet model
 *******************************************************************************/
package org.eclipse.emf.facet.efacet.core.internal.query;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.facet.efacet.core.FacetUtils;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;

public final class QueryUtils {

	private QueryUtils() {
		// utility class
	}

	/** @return a description to help identify this query in error messages */
	public static String getQueryDescription(final Query query) {
		StringBuffer sb = new StringBuffer();
		sb.append("[Query eClass:"); //$NON-NLS-1$
		sb.append(query.eClass().getName());
		DerivedTypedElement owningDerivedTypedElement = QueryUtils
				.getOwningDerivedTypedElement(query);
		if (owningDerivedTypedElement != null) {
			sb.append(" defined on "); //$NON-NLS-1$
			sb.append(owningDerivedTypedElement.getClass().getSimpleName());
			EClassifier eType = owningDerivedTypedElement.getEType();
			if (eType != null) {
				sb.append(" of type '"); //$NON-NLS-1$
				sb.append(eType.getName());
				sb.append("' named: '"); //$NON-NLS-1$
			} else {
				sb.append(" named: '"); //$NON-NLS-1$
			}
			sb.append(owningDerivedTypedElement.getName());
			sb.append("'"); //$NON-NLS-1$
		} else {
			sb.append(" with a null owning derived typed element"); //$NON-NLS-1$
		}
		sb.append("]"); //$NON-NLS-1$
		return sb.toString();
	}

	// Moved from
	// org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.impl.QueryImpl
	public static EClassifier getReturnType(final Query query) {
		EClassifier result = null;
		final DerivedTypedElement owningDTE = QueryUtils
				.getOwningDerivedTypedElement(query);
		if (owningDTE != null) {
			result = owningDTE.getEType();
		}
		return result;
	}

	// Moved from
	// org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.impl.QueryImpl
	public static EClassifier getSourceType(final Query query) {
		EClassifier result = null;
		final DerivedTypedElement owningDTE = QueryUtils
				.getOwningDerivedTypedElement(query);
		if (owningDTE != null) {
			final EObject eContainer = QueryUtils.getOwningDerivedTypedElement(
					query).eContainer();
			if (eContainer instanceof Facet) {
				final Facet facet = (Facet) eContainer;
				result = FacetUtils.getExtendedMetaclass(facet);
			} else if (eContainer instanceof ETypedElement) {
				final ETypedElement typedElement = (ETypedElement) eContainer;
				result = typedElement.getEType();
			}
		}
		return result;
	}

	// Moved from
	// org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.impl.QueryImpl
	public static DerivedTypedElement getOwningDerivedTypedElement(
			final Query query) {
		DerivedTypedElement result = null;
		EObject container = query.eContainer();
		while (container != null) {
			if (container instanceof DerivedTypedElement) {
				result = (DerivedTypedElement) container;
				break;
			}
			container = container.eContainer();
		}
		if (result == null) {
			throw new IllegalStateException(
					"Query must always be contained by a DerivedTypedElement"); //$NON-NLS-1$
		}
		return (DerivedTypedElement) container;
	
	}

	// Moved from
	// org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.impl.QueryImpl
	public static boolean isMany(final Query query) {
		boolean result = false;
		final DerivedTypedElement owningDTE = QueryUtils
				.getOwningDerivedTypedElement(query);
		if (owningDTE != null) {
			result = owningDTE.isMany();
		}
		return result;
	}
}
