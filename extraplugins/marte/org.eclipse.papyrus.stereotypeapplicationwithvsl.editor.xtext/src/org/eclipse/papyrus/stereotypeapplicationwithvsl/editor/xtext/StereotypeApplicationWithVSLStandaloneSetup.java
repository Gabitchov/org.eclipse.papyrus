
package org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class StereotypeApplicationWithVSLStandaloneSetup extends StereotypeApplicationWithVSLStandaloneSetupGenerated{

	public static void doSetup() {
		new StereotypeApplicationWithVSLStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

