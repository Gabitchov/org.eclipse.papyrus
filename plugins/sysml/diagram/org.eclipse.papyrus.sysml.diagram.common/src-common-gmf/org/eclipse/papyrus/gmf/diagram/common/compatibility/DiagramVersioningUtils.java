/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.gmf.diagram.common.compatibility;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.StringValueStyle;

/**
 * This class provide several convenience methods to tag a diagram with a version number
 * in a notation style, or retrieve this version number.
 */
public class DiagramVersioningUtils {

	/**
	 * The ID for the diagram internal version number stored in Notation model. 
	 */
	private static final String DIAGRAM_COMPATIBILITY_VERSION = "diagram_compatibility_version";

	/**
	 * The ID for the diagram internal version number stored in Notation model. 
	 */
	public static final String UNDEFINED_VERSION = "undefined";

	/**
	 * Get the diagram compatibility version.
	 * @param diagram the diagram
	 * @return the compatibility version.
	 */
	public static String getCompatibilityVersion(Diagram diagram) {
		StringValueStyle semanticStyle = (StringValueStyle)diagram.getNamedStyle(NotationPackage.eINSTANCE.getStringValueStyle(), DIAGRAM_COMPATIBILITY_VERSION);
		return semanticStyle == null ? UNDEFINED_VERSION : semanticStyle.getStringValue();
	}

	/**
	 * Set the diagram compatibility version.
	 * @param diagram the diagram
	 * @param version the compatibility version
	 */
	@SuppressWarnings("unchecked")
	public static void setCompatibilityVersion(Diagram diagram, String version) {
		StringValueStyle style = (StringValueStyle)diagram.getNamedStyle(NotationPackage.eINSTANCE.getStringValueStyle(), DIAGRAM_COMPATIBILITY_VERSION);
		if (style == null) {
			style = NotationFactory.eINSTANCE.createStringValueStyle();
			style.setName(DIAGRAM_COMPATIBILITY_VERSION);
			diagram.getStyles().add(style);
		}
		style.setStringValue(version);
	}
}
