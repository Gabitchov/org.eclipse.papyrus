/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  E.D.Willink - Initial API and implementation
 *  CEA LIST - Architecture refactoring
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.textedit.constraintwithessentialocl.xtext;

import org.eclipse.ocl.examples.xtext.essentialocl.ui.internal.EssentialOCLActivator;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLPlugin;

import com.google.inject.Module;

/**
 * The main plugin class to be used in the desktop.
 */
public class EssentialOCLPopupPlugin extends EssentialOCLActivator
{
	// The shared instance.
	private static EssentialOCLPopupPlugin plugin;

	/**
	 * Returns the shared instance.
	 */
	public static EssentialOCLPopupPlugin getInstance() {
		return plugin;
	}

	/**
	 * Obtains my plug-in ID.
	 * 
	 * @return my plug-in ID
	 */
	public static String getPluginId() {
		return getInstance().getBundle().getSymbolicName();
	}

	/**
	 * The constructor.
	 */
	public EssentialOCLPopupPlugin() {
		super();
		plugin = this;
	}
	
	
	protected Module getRuntimeModule(String grammar) {
		if (EssentialOCLPlugin.LANGUAGE_ID.equals(grammar)) {
		  return new EssentialOCLPopupRuntimeModule();
		}
		
		throw new IllegalArgumentException(grammar);
	}
	
	protected Module getUiModule(String grammar) {
		if (EssentialOCLPlugin.LANGUAGE_ID.equals(grammar)) {
		  return new EssentialOCLPopupUiModule(this);
		}
		
		throw new IllegalArgumentException(grammar);
	}
}
