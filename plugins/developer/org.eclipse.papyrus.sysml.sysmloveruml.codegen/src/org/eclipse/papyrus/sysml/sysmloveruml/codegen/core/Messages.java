/**
 *  Copyright (c) 2011 Atos.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Atos - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.sysml.sysmloveruml.codegen.core;

import org.eclipse.osgi.util.NLS;
/**
 * Externalize messages.
 * @author "Arthur Daussy <a href="mailto:arthur.daussy@atos.net">arthur.daussy@atos.net</a>"
 *
 */
public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.sysml.sysmloveruml.codegen.core.messages"; //$NON-NLS-1$

	public static String SysMLOverUmlGenModelGenerator_GENERATOR_LABEL;

	public static String SysMLOverUmlGenModelGenerator_package;

	public static String SysMLOverUmlGenModelGenerator_SysMLAdapterFactoryRegisteryTemplate;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
