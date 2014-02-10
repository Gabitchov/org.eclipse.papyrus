/**
 * Copyright (c) 2011, 2012 Mia-Software.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Gregoire Dupe (Mia-Software) - Bug 333553 - The user has not to deal with two files to create a facet
 *  Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values.
 *  Nicolas Bros (Mia-Software) - Bug 362191 - [Restructuring] Query mechanism for eFacet2
 *  Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *  Nicolas Bros (Mia-Software) - Bug 376941 - [EFacet] Facet operation arguments in Facet model
 */
package org.eclipse.emf.facet.efacet.core.query;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.facet.efacet.core.IDerivedTypedElementManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.osgi.framework.Bundle;

/**
 * This factory allows clients to create a {@link IDerivedTypedElementImplementation} for queries
 * corresponding to this type of factory.
 *
 * @since 0.2
 * @deprecated replaced by {@link IQueryImplementationFactory}. https://bugs.eclipse.org/bugs/show_bug.cgi?id=377059.
 */
@Deprecated
public interface IDerivedTypedElementImplementationFactory {
	// Copy of org.eclipse.emf.facet.infra.query.core.IModelQueryFactory

	/**
	 * Create a derived typed element implementation, for getting and setting the value of the
	 * derived typed element.
	 *
	 * @param derivedTypedElement
	 *            the derived typed element to create an implementation for
	 * @param queryBundle
	 *            the bundle in which the query used to get or set this derived typed element is
	 *            defined. May be <code>null</code> if the query is not defined in a {@link Bundle}.
	 */
	public IDerivedTypedElementImplementation create(Query derivedTypedElement, Bundle queryBundle, IDerivedTypedElementManager derivedTEManager)
			throws DerivedTypedElementException;

	/**
	 * Return the type of query handled by this implementation.
	 *
	 * @return the type of query this implementation handles.
	 */
	public EClass getManagedQueryType();
}
