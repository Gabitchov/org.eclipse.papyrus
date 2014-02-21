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
package org.eclipse.emf.facet.custom.ui;

import org.eclipse.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.emf.facet.custom.core.exception.CustomizationException;
import org.eclipse.swt.graphics.FontData;

/**
 * @since 0.4
 */
public interface ICustomOverride {

	String getText(String result, Object object,
			ICustomizationManager customManager,
			IFontPropertiesHandler propertiesHandler) throws CustomizationException;

	FontData getFont(FontData fontData, Object object,
			ICustomizationManager customManager,
			IFontPropertiesHandler propertiesHandler) throws CustomizationException;

}
