/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.textedit.message.xtext;


// TODO: Auto-generated Javadoc
/**
 * Initialization support for running Xtext languages
 * without equinox extension registry.
 */
public class UmlMessageStandaloneSetup extends UmlMessageStandaloneSetupGenerated{

	/**
	 * Do setup.
	 */
	public static void doSetup() {
		new UmlMessageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

