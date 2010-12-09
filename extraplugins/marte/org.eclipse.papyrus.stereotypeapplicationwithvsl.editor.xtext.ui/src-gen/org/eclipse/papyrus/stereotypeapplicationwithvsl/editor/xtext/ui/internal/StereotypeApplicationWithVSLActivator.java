
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
package org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.ui.internal;

import org.apache.log4j.Logger;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

import java.util.Map;
import java.util.HashMap;

/**
 * Generated
 */
public class StereotypeApplicationWithVSLActivator extends AbstractUIPlugin {

	private Map<String,Injector> injectors = new HashMap<String,Injector>();
	private static StereotypeApplicationWithVSLActivator INSTANCE;

	public Injector getInjector(String languageName) {
		return injectors.get(languageName);
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
		try {
			
			injectors.put("org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.StereotypeApplicationWithVSL", Guice.createInjector(
				Modules.override(Modules.override(getRuntimeModule("org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.StereotypeApplicationWithVSL")).with(getUiModule("org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.StereotypeApplicationWithVSL"))).with(getSharedStateModule())
			));
			
		} catch (Exception e) {
			Logger.getLogger(getClass()).error(e.getMessage(), e);
			throw e;
		}
	}
	
	public static StereotypeApplicationWithVSLActivator getInstance() {
		return INSTANCE;
	}
	
	protected Module getRuntimeModule(String grammar) {
		
		if ("org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.StereotypeApplicationWithVSL".equals(grammar)) {
		  return new org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.StereotypeApplicationWithVSLRuntimeModule();
		}
		
		throw new IllegalArgumentException(grammar);
	}
	protected Module getUiModule(String grammar) {
		
		if ("org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.StereotypeApplicationWithVSL".equals(grammar)) {
		  return new org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.ui.StereotypeApplicationWithVSLUiModule(this);
		}
		
		throw new IllegalArgumentException(grammar);
	}
	
	protected Module getSharedStateModule() {
		return new org.eclipse.xtext.ui.shared.SharedStateModule();
	}
	
}
