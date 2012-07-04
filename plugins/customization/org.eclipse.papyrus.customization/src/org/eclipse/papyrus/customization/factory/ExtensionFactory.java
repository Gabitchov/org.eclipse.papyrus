/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.factory;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.customization.model.customizationplugin.CustomizableElement;
import org.eclipse.papyrus.customization.plugin.PluginEditor;


public interface ExtensionFactory {

	public static ExtensionFactoryRegistry registry = ExtensionFactoryRegistry.instance;

	public void addElement(CustomizableElement element, PluginEditor editor);

	public EClass getCustomizableElementClass();

	public String getName();
}
