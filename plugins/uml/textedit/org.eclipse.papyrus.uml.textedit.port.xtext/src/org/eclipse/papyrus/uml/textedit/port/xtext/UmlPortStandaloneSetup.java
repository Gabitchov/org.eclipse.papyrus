/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.port.xtext;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class UmlPortStandaloneSetup extends UmlPortStandaloneSetupGenerated{

	public static void doSetup() {
		new UmlPortStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

