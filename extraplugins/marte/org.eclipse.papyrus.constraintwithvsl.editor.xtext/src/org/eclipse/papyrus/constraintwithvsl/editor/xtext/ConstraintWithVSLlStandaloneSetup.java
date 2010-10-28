
package org.eclipse.papyrus.constraintwithvsl.editor.xtext;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ConstraintWithVSLlStandaloneSetup extends ConstraintWithVSLlStandaloneSetupGenerated{

	public static void doSetup() {
		new ConstraintWithVSLlStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

