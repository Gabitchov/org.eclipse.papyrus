
package org.eclipse.papyrus.message.editor.xtext;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class UmlMessageStandaloneSetup extends UmlMessageStandaloneSetupGenerated{

	public static void doSetup() {
		new UmlMessageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

