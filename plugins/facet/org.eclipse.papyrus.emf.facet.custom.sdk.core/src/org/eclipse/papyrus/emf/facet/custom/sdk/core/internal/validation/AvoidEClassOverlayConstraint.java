/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 375054 - Add validation warning for overlay on EClass
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.custom.sdk.core.internal.validation;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.EClassCustomization;

/**
 * Creates a warning if a {@link FacetOperation} defined in an {@link EClassCustomization} overrides (i.e. customizes)
 * an overlay operation.
 */
public class AvoidEClassOverlayConstraint extends AbstractModelConstraint {

	private static final List<String> OVERLAY_OPS = Arrays.asList(
			"platform:/plugin/org.eclipse.papyrus.emf.facet.custom.ui/resources/customproperties.efacet#//CustomizedEObject/topLeftOverlay", //$NON-NLS-1$
			"platform:/plugin/org.eclipse.papyrus.emf.facet.custom.ui/resources/customproperties.efacet#//CustomizedEObject/topMiddleOverlay", //$NON-NLS-1$
			"platform:/plugin/org.eclipse.papyrus.emf.facet.custom.ui/resources/customproperties.efacet#//CustomizedEObject/topRightOverlay", //$NON-NLS-1$
			"platform:/plugin/org.eclipse.papyrus.emf.facet.custom.ui/resources/customproperties.efacet#//CustomizedEObject/bottomLeftOverlay", //$NON-NLS-1$
			"platform:/plugin/org.eclipse.papyrus.emf.facet.custom.ui/resources/customproperties.efacet#//CustomizedEObject/bottomMiddleOverlay", //$NON-NLS-1$
			"platform:/plugin/org.eclipse.papyrus.emf.facet.custom.ui/resources/customproperties.efacet#//CustomizedEObject/bottomRightOverlay" //$NON-NLS-1$
	);

	@Override
	public IStatus validate(final IValidationContext ctx) {
		IStatus result = ctx.createSuccessStatus();
		final EObject target = ctx.getTarget();
		if (target instanceof FacetOperation) {
			final FacetOperation facetOperation = (FacetOperation) target;
			final DerivedTypedElement override = facetOperation.getOverride();
			final URI overrideURI = EcoreUtil.getURI(override);
			if (facetOperation.eContainer() instanceof EClassCustomization
					&& AvoidEClassOverlayConstraint.OVERLAY_OPS.contains(overrideURI.toString())) {
				result = ctx.createFailureStatus();
			}
		}
		return result;
	}

}
