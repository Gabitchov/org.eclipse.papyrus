/****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Thibault Landre (Atos Origin) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.codegen.utils;


/**
 * Defined constants are used in the dynamic-template and in the java code.
 * 
 * @author tlandre
 */
public class PapyrusGenConstants {

	public final static String IDiagramPreferenceConstantJavaClassName = "IPapyrusPreferencesConstant";

	public final static String DiagramPreferencePageJavaClassName = "DiagramPreferencePage";

	public final static String DiagramPreferencePageCategory = "org.eclipse.papyrus.infra.gmfdiag.preferences.diagrams";

	/**
	 * Get the name of the papyrus preference constant class used to defined the preference
	 * constants of a diagram
	 * 
	 * @return the name of the class
	 */

	public static final String getIDiagramPreferenceConstantJavaClassName() {
		return IDiagramPreferenceConstantJavaClassName;
	}

	/**
	 * Get the name of the diagram preference page class.
	 * <p>
	 * the name is composed of the name of the diagram + "DiagramPreferencePage"
	 * </p>
	 * 
	 * @param diagramName
	 *        the name of the Diagram
	 * @return the name of the java class used for the diagram preference page
	 */

	public static final String getDiagramPreferencePageJavaClassName(String diagramName) {
		return diagramName + DiagramPreferencePageJavaClassName;
	}

	/**
	 * @return the Papyrus diagram category on which preference pages will appear
	 */

	public static final String getDiagramPreferencePageCategory() {
		return DiagramPreferencePageCategory;
	}
}
