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
package org.eclipse.papyrus.uml.diagram.common.utils;

import org.eclipse.gmf.runtime.notation.EObjectValueStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Property;

/**
 * Utility class for Association graphical end - property mapping.
 */
public class AssociationViewUtils {

	/** ID for the source end - property mapping of an association */
	public static final String SEMANTIC_SOURCE_END = "semantic_source_end";

	/** ID for the target end - property mapping of an association */
	public static final String SEMANTIC_TARGET_END = "semantic_target_end";

	/**
	 * Get the semantic end from the source of an edge representing an Association.
	 * 
	 * @param view
	 *        the Association view.
	 * @return the Property corresponding to the source of the graphical end.
	 */
	public static Property getSourceSemanticEnd(View view) {
		EObjectValueStyle semanticStyle = (EObjectValueStyle)view.getNamedStyle(NotationPackage.eINSTANCE.getEObjectValueStyle(), SEMANTIC_SOURCE_END);
		return semanticStyle == null ? null : (Property)semanticStyle.getEObjectValue();
	}

	/**
	 * Get the semantic end from the target of an edge representing an Association.
	 * 
	 * @param view
	 *        the Association view.
	 * @return the Property corresponding to the target of the graphical end.
	 */
	public static Property getTargetSemanticEnd(View view) {
		EObjectValueStyle semanticStyle = (EObjectValueStyle)view.getNamedStyle(NotationPackage.eINSTANCE.getEObjectValueStyle(), SEMANTIC_TARGET_END);
		return semanticStyle == null ? null : (Property)semanticStyle.getEObjectValue();
	}

	/**
	 * Set the semantic end for the source of an edge representing an Association.
	 * 
	 * @param view
	 *        the Association view.
	 * @param end
	 *        the Property corresponding to the source of the graphical end.
	 */
	public static void setSourceSemanticEnd(View view, Property end) {
		EObjectValueStyle semanticStyle = (EObjectValueStyle)view.getNamedStyle(NotationPackage.eINSTANCE.getEObjectValueStyle(), SEMANTIC_SOURCE_END);
		semanticStyle.setEObjectValue(end);
	}

	/**
	 * Set the semantic end for the target of an edge representing an Association.
	 * 
	 * @param view
	 *        the Association view.
	 * @param end
	 *        the Property corresponding to the target of the graphical end.
	 */
	public static void setTargetSemanticEnd(View view, Property end) {
		EObjectValueStyle semanticStyle = (EObjectValueStyle)view.getNamedStyle(NotationPackage.eINSTANCE.getEObjectValueStyle(), SEMANTIC_TARGET_END);
		semanticStyle.setEObjectValue(end);
	}
}
