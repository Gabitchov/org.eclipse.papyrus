
package org.eclipse.papyrus.marte.vsl;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class VSLStandaloneSetup extends VSLStandaloneSetupGenerated{

	public static void doSetup() {
		new VSLStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

