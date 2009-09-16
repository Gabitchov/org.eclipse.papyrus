/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.extensionpoints.editors.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.extensionpoints.editors.configuration.DefaultDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.definition.DirectEditorExtensionPoint;

/**
 * 
 */
public class DirectEditorsUtil {

	/**
	 * Finds a editor for specific language and object to edit type
	 * 
	 * @param language
	 *            the language to edit
	 * @param objectToEdit
	 *            the type of object to edit
	 * @return the extension point proxy that manages this kind of editor
	 */
	public static IDirectEditorConfiguration findEditorConfiguration(String language, String objectToEdit) {
		DirectEditorExtensionPoint[] extensionPoints = DirectEditorExtensionPoint.getDirectEditorConfigurations();
		for (DirectEditorExtensionPoint directEditorExtensionPoint : extensionPoints) {
			final String lang = directEditorExtensionPoint.getLanguage();
			final String oToEdit = directEditorExtensionPoint.getObjectToEdit();
			if (lang.equals(language) && oToEdit.equals(objectToEdit)) {
				// extension point found!
				return directEditorExtensionPoint.getDirectEditorConfiguration();
			}
		}
		return new DefaultDirectEditorConfiguration();
	}

	/**
	 * finds if an editor for specific language and object is available to edit type
	 * 
	 * @param language
	 *            the language to edit
	 * @param objectToEdit
	 *            the type of object to edit
	 * @return <code>true</code> if an editor exists
	 */
	public static boolean hasSpecificEditorConfiguration(String language, String objectToEdit) {
		DirectEditorExtensionPoint[] extensionPoints = DirectEditorExtensionPoint.getDirectEditorConfigurations();
		for (DirectEditorExtensionPoint directEditorExtensionPoint : extensionPoints) {
			final String lang = directEditorExtensionPoint.getLanguage();
			final String oToEdit = directEditorExtensionPoint.getObjectToEdit();
			if (lang.equals(language) && oToEdit.equals(objectToEdit)) {
				// extension point found!
				return true;
			}
		}
		return false;
	}

	/**
	 * finds if an editor for specific object is available to edit type
	 * 
	 * @param language
	 *            the language to edit
	 * @param objectToEdit
	 *            the type of object to edit
	 * @return <code>true</code> if an editor exists
	 */
	public static boolean hasSpecificEditorConfiguration(String objectToEdit) {
		DirectEditorExtensionPoint[] extensionPoints = DirectEditorExtensionPoint.getDirectEditorConfigurations();
		for (DirectEditorExtensionPoint directEditorExtensionPoint : extensionPoints) {
			final String oToEdit = directEditorExtensionPoint.getObjectToEdit();
			if (oToEdit.equals(objectToEdit)) {
				// extension point found!
				return true;
			}
		}
		return false;
	}

	/**
	 * returns the list of languages that are available from extension points
	 * 
	 * @return the list of languages that have an extended editor
	 */
	public static List<String> getLanguages(String objectToEdit) {
		List<String> languages = new ArrayList<String>();
		DirectEditorExtensionPoint[] extensionPoints = DirectEditorExtensionPoint.getDirectEditorConfigurations();
		for (DirectEditorExtensionPoint directEditorExtensionPoint : extensionPoints) {
			if (objectToEdit == null || directEditorExtensionPoint.getObjectToEdit().equals(objectToEdit)) {
				String lang = directEditorExtensionPoint.getLanguage();
				if (!languages.contains(lang)) {
					languages.add(lang);
				}
			}
		}
		return languages;
	}
}
