
package org.eclipse.papyrus.transition.editor.xtext;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class UmlTransitionStandaloneSetup extends UmlTransitionStandaloneSetupGenerated{

	public static void doSetup() {
		new UmlTransitionStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

