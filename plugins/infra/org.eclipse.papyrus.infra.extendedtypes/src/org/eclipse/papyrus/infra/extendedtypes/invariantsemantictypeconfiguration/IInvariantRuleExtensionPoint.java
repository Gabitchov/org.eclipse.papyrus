/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration;

import org.eclipse.papyrus.infra.extendedtypes.Activator;


/**
 * @author RS211865
 */
public interface IInvariantRuleExtensionPoint {
	
	/** ID of the extension point */
	public final static String EXTENSION_POINT_ID = Activator.PLUGIN_ID + ".invariantRule";
	
	public static final String ELEMENT_MATCHER_CLASS = "elementMatcher";

	public static final String CONTAINER_DESCRIPTOR_CLASS = "semanticTypeDescriptor";

	public static final String EDIT_HELPER_ADVICE_CLASS = "editHelperAdvice";
	
	public static final String RULE_CONFIGURATION_CLASS = "configurationClass";

	public static final String CONFIGURATION_MODEL_CREATION = "configurationModelCreation";

	public static final String CREATION_ELEMENT_VALIDATOR_CLASS = "creationElementValidator"; 
	
}
