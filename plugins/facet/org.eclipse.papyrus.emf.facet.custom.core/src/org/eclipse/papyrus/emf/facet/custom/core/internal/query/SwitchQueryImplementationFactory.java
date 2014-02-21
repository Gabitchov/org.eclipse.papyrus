/**
 * Copyright (c) 2013 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Gregoire Dupe (Mia-Software) - Bug 418885 - ETypedElementSwitchQuery implemented using a deprecated query evaluator extension point
 */
package org.eclipse.papyrus.emf.facet.custom.core.internal.query;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.emf.facet.efacet.core.IDerivedTypedElementManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.efacet.core.query.IQueryImplementation;
import org.eclipse.papyrus.emf.facet.efacet.core.query.IQueryImplementationFactory;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.CustomPackage;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementSwitchQuery;
import org.osgi.framework.Bundle;

public class SwitchQueryImplementationFactory implements
		IQueryImplementationFactory {

	public IQueryImplementation create(final Query query, final Bundle bundle,
			final IDerivedTypedElementManager manager)
			throws DerivedTypedElementException {
		if (!(query instanceof ETypedElementSwitchQuery)) {
			throw new IllegalArgumentException(
					"The given DerivedTypedElement does not have a ETypedElementSwitchQuery"); //$NON-NLS-1$
		}
		final ETypedElementSwitchQuery switchQuery = (ETypedElementSwitchQuery) query;
		return new SwitchQueryImplementation(switchQuery);
	}

	public EClass getManagedQueryType() {
		return CustomPackage.eINSTANCE.getETypedElementSwitchQuery();
	}
}
