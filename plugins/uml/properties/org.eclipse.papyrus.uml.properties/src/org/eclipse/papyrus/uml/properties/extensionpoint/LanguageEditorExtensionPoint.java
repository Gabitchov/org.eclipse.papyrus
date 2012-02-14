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
package org.eclipse.papyrus.uml.properties.extensionpoint;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.papyrus.uml.properties.languagepreferences.Editor;
import org.eclipse.papyrus.uml.properties.languagepreferences.languagepreferencesFactory;
import org.eclipse.papyrus.uml.properties.preferences.LanguageRegistry;

/**
 * Handles the language extension point
 * This extension point allows the registration of custom widgets
 * for editing a specific language.
 * 
 * @author Camille Letavernier
 */
public class LanguageEditorExtensionPoint {

	/**
	 * The languageEditor extension point
	 */
	public static final String EXTENSION_ID = Activator.PLUGIN_ID + ".languageEditor"; //$NON-NLS-1$

	/**
	 * Constructor.
	 */
	public LanguageEditorExtensionPoint() {

		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

		for(IConfigurationElement e : config) {
			String languageName = e.getAttribute("language"); //$NON-NLS-1$
			String editorClassName = e.getAttribute("editor"); //$NON-NLS-1$

			Editor editor = languagepreferencesFactory.eINSTANCE.createEditor();
			editor.setClass(editorClassName);
			LanguageRegistry.instance.registerEditor(languageName, editor);
		}
	}

}
