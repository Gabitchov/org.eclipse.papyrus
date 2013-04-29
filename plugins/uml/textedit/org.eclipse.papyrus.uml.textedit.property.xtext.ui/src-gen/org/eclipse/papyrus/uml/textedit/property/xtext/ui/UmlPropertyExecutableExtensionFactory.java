/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.uml.textedit.property.xtext.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import org.eclipse.papyrus.uml.textedit.property.xtext.ui.internal.UmlPropertyActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class UmlPropertyExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return UmlPropertyActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return UmlPropertyActivator.getInstance().getInjector(UmlPropertyActivator.ORG_ECLIPSE_PAPYRUS_UML_TEXTEDIT_PROPERTY_XTEXT_UMLPROPERTY);
	}
	
}
