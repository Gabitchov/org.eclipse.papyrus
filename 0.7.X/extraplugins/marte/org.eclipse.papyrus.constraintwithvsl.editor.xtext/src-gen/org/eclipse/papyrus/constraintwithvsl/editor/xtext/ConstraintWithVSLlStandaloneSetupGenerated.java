
package org.eclipse.papyrus.constraintwithvsl.editor.xtext;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.ISetup;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Generated from StandaloneSetup.xpt!
 */
@SuppressWarnings("all")
public class ConstraintWithVSLlStandaloneSetupGenerated implements ISetup {

	public Injector createInjectorAndDoEMFRegistration() {
		org.eclipse.papyrus.marte.vsl.VSLStandaloneSetup.doSetup();

		Injector injector = createInjector();
		register(injector);
		return injector;
	}
	
	public Injector createInjector() {
		return Guice.createInjector(new org.eclipse.papyrus.constraintwithvsl.editor.xtext.ConstraintWithVSLlRuntimeModule());
	}
	
	public void register(Injector injector) {
	if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/papyrus/constraintwithvsl/editor/xtext/ConstraintWithVSLl")) {
		EPackage.Registry.INSTANCE.put("http://www.eclipse.org/papyrus/constraintwithvsl/editor/xtext/ConstraintWithVSLl", org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.ConstraintWithVSLlPackage.eINSTANCE);
	}

		org.eclipse.xtext.resource.IResourceFactory resourceFactory = injector.getInstance(org.eclipse.xtext.resource.IResourceFactory.class);
		org.eclipse.xtext.resource.IResourceServiceProvider serviceProvider = injector.getInstance(org.eclipse.xtext.resource.IResourceServiceProvider.class);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("constraintwithvsl", resourceFactory);
		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("constraintwithvsl", serviceProvider);
		




	}
}
