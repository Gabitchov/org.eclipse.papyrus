/**
 * Copyright (c) 2012, 2013 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *    Gregoire Dupé (Mia-Software) - Bug 418885 - ETypedElementSwitchQuery implemented using a deprecated query evaluator extension point
 */
package org.eclipse.papyrus.emf.facet.custom.core.internal.query;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.emf.facet.efacet.core.IDerivedTypedElementManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.efacet.core.query.IDerivedTypedElementImplementation;
import org.eclipse.papyrus.emf.facet.efacet.core.query.IDerivedTypedElementImplementationFactory;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.CustomPackage;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementSwitchQuery;
import org.osgi.framework.Bundle;

/**
 * @deprecated replaced by {@link SwitchQueryImplementationFactory}
 */
@Deprecated
public class ETypedElementSwitchQueryImplementationFactory implements IDerivedTypedElementImplementationFactory {

	public IDerivedTypedElementImplementation create(final Query query, final Bundle bundle, final IDerivedTypedElementManager derivedTEManager)
			throws DerivedTypedElementException {
		if (!(query instanceof ETypedElementSwitchQuery)) {
			throw new IllegalArgumentException("The given DerivedTypedElement does not have a IsOneOfQuery"); //$NON-NLS-1$
		}
		final ETypedElementSwitchQueryImplementation evaluator = new ETypedElementSwitchQueryImplementation(
				(ETypedElementSwitchQuery) query, derivedTEManager);
		evaluator.setCheckResultType(false);
		return evaluator;
	}

	public EClass getManagedQueryType() {
		return CustomPackage.eINSTANCE.getETypedElementSwitchQuery();
	}

}
