
package org.eclipse.papyrus.uml.textedit.property.xtext;

import org.eclipse.papyrus.uml.textedit.property.xtext.UmlPropertyStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class UmlPropertyStandaloneSetup extends UmlPropertyStandaloneSetupGenerated{

	public static void doSetup() {
		new UmlPropertyStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

