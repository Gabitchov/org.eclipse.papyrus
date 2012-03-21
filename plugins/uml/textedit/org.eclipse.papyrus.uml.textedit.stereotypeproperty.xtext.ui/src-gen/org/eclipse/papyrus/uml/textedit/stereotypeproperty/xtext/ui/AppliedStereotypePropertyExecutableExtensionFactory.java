/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass.
 */
public class AppliedStereotypePropertyExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.ui.internal.AppliedStereotypePropertyActivator.getInstance().getBundle();
	}

	@Override
	protected Injector getInjector() {
		return org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.ui.internal.AppliedStereotypePropertyActivator.getInstance().getInjector("org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.AppliedStereotypeProperty");
	}

}
