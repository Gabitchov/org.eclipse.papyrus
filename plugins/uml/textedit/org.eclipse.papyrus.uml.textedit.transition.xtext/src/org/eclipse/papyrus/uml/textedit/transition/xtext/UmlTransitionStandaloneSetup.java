
package org.eclipse.papyrus.uml.textedit.transition.xtext;

import org.eclipse.papyrus.uml.textedit.transition.xtext.UmlTransitionStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class UmlTransitionStandaloneSetup extends UmlTransitionStandaloneSetupGenerated{

	public static void doSetup() {
		new UmlTransitionStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

