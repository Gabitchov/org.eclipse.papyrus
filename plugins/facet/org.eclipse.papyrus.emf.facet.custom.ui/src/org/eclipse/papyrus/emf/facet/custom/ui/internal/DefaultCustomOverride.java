/**
 *  Copyright (c) 2013 Soft-Maint.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      David Couvrand (Soft-Maint) - Bug 422058 - Implementation of strikethrough and underline in the CustomizedLabelProvider
 */
package org.eclipse.papyrus.emf.facet.custom.ui.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.custom.ui.ICustomOverride;
import org.eclipse.papyrus.emf.facet.custom.ui.IFontPropertiesHandler;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.papyrus.emf.facet.custom.core.exception.CustomizationException;
import org.eclipse.swt.graphics.FontData;

public class DefaultCustomOverride implements ICustomOverride {

	public String getText(final String result, final Object object,
			final ICustomizationManager customManager,
			final IFontPropertiesHandler propertiesHandler)
			throws CustomizationException {
		String newResult = result;
		if (object instanceof EObject) {
			final EObject eObject = (EObject) object;
			final FacetOperation isStruckProp = propertiesHandler
					.getIsStruckthroughProperty();
			final boolean isStruckthrough = customManager.getCustomValueOf(
					eObject, isStruckProp, Boolean.class).booleanValue();
			if (isStruckthrough) {
				newResult = String.format("--%s--", newResult); //$NON-NLS-1$
			}
			final FacetOperation isUnderlinedProp = propertiesHandler
					.getIsUnderlinedProperty();
			final boolean isUnderlined = customManager.getCustomValueOf(
					eObject, isUnderlinedProp, Boolean.class).booleanValue();
			if (isUnderlined) {
				newResult =  String.format("__%s__", newResult); //$NON-NLS-1$
			}
		}
		return newResult;
	}

	public FontData getFont(final FontData fontData, final Object object,
			final ICustomizationManager customManager,
			final IFontPropertiesHandler propertiesHandler) {
		return fontData;
	}

}
