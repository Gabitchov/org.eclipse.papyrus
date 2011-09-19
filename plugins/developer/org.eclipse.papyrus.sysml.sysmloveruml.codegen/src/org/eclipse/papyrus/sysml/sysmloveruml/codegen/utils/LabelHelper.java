/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.sysmloveruml.codegen.utils;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.papyrus.sysml.sysmloveruml.codegen.SysMLOverUMLGeneratorPlugin;

/**
 * Helper to print label during generation.
 * 
 * @author "Arthur Daussy <a href="mailto:arthur.daussy@atos.net
 *         ">arthur.daussy@atos.net</a>"
 */
public final class LabelHelper {

	/**
	 * Path to template repository.
	 */
	public static final String TEMPLATE_LOCATION = SysMLOverUMLGeneratorPlugin.INSTANCE.getBaseURL().toString() + "templates"; //$NON-NLS-1$

	/**
	 * Class path name.
	 */
	public static final String CLASSPATH_VARIABLE_NAME = "SYSML_OVER_UML_GENERATOR"; //$NON-NLS-1$

	/**
	 * Get the name of the extension class of the Adapter Factory Class
	 * 
	 * @param genPackage
	 * @return
	 */
	public static String getAdapterFactoryExtensionName(GenPackage genPackage) {
		return genPackage.getAdapterFactoryClassName() + "forUmlOverSysLM"; //$NON-NLS-1$
	}
}
