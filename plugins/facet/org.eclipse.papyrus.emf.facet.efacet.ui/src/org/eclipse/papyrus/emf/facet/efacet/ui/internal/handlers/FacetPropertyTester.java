/**
 * Copyright (c) 2011 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Nicolas Guyomar (Mia-Software) - Bug 349546 - EMF Facet facetSet editor
 */
package org.eclipse.emf.facet.efacet.ui.internal.handlers;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.facet.efacet.Facet;
import org.eclipse.emf.facet.efacet.FacetAttribute;
import org.eclipse.emf.facet.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.FacetReference;
import org.eclipse.emf.facet.efacet.FacetSet;
import org.eclipse.jface.viewers.StructuredSelection;

@Deprecated
//TODO @Deprecated must be removed after a refactoring planed by https://bugs.eclipse.org/bugs/show_bug.cgi?id=364601
public class FacetPropertyTester extends PropertyTester {

	private static final String IS_FACET = "isFacet"; //$NON-NLS-1$
	private static final String IS_FACET_SET = "isFacetSet"; //$NON-NLS-1$
	private static final String IS_FACET_OP = "isFacetOperation"; //$NON-NLS-1$
	private static final String IS_FACET_ATT = "isFacetAttribute"; //$NON-NLS-1$
	private static final String IS_FACET_REF = "isFacetReference"; //$NON-NLS-1$

	public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
		boolean result = false;
		if (expectedValue instanceof Boolean && receiver instanceof StructuredSelection) {
			final StructuredSelection selection = (StructuredSelection) receiver;
			Boolean test = null;
			if (property.equalsIgnoreCase(FacetPropertyTester.IS_FACET)) {
				test = Boolean.valueOf(selection.getFirstElement() instanceof Facet);
			} else if (property.equalsIgnoreCase(FacetPropertyTester.IS_FACET_ATT)) {
				test = Boolean.valueOf(selection.getFirstElement() instanceof FacetAttribute);
			} else if (property.equalsIgnoreCase(FacetPropertyTester.IS_FACET_OP)) {
				test = Boolean.valueOf(selection.getFirstElement() instanceof FacetOperation);
			} else if (property.equalsIgnoreCase(FacetPropertyTester.IS_FACET_REF)) {
				test = Boolean.valueOf(selection.getFirstElement() instanceof FacetReference);
			} else if (property.equalsIgnoreCase(FacetPropertyTester.IS_FACET_SET)) {
				test = Boolean.valueOf(selection.getFirstElement() instanceof FacetSet);
			}
			if (test != null) {
				result = expectedValue.equals(test);
			}
		}
		return result;
	}
}
