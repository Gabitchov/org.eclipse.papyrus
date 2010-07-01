
package org.eclipse.papyrus.property.editor.xtext;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class UmlPropertyStandaloneSetup extends UmlPropertyStandaloneSetupGenerated{

	public static void doSetup() {
		new UmlPropertyStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

