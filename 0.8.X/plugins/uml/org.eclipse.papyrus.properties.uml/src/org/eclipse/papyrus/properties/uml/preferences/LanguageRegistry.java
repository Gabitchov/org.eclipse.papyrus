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
package org.eclipse.papyrus.properties.uml.preferences;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.properties.uml.Activator;
import org.eclipse.papyrus.properties.uml.languagepreferences.Editor;
import org.eclipse.papyrus.properties.uml.languagepreferences.Language;
import org.eclipse.papyrus.properties.uml.languagepreferences.Preferences;
import org.eclipse.papyrus.properties.uml.languagepreferences.languagepreferencesFactory;
import org.eclipse.papyrus.properties.uml.widgets.BodyEditor;
import org.eclipse.papyrus.properties.util.EMFHelper;


public class LanguageRegistry {

	public static LanguageRegistry instance = new LanguageRegistry();

	private LanguageRegistry() {
		languageMapping = new HashMap<String, List<Editor>>();

		IPath path = Activator.getDefault().getPreferencesPath();
		String preferencesPath = path.toString() + "/languagePreferences.xmi"; //$NON-NLS-1$
		URI preferencesURI = URI.createFileURI(preferencesPath);

		try {
			ResourceSet resourceSet = new ResourceSetImpl();
			preferences = (Preferences)EMFHelper.loadEMFModel(resourceSet, preferencesURI);
		} catch (IOException e) {
			createPreferences(preferencesURI);
		}

		//Init
	}

	private void createPreferences(URI preferencesURI) {
		preferences = languagepreferencesFactory.eINSTANCE.createPreferences();
		Editor defaultEditor = languagepreferencesFactory.eINSTANCE.createEditor();
		defaultEditor.setClass("org.eclipse.papyrus.properties.uml.widgets.NaturalLanguageEditor"); //$NON-NLS-1$

		preferences.getEditors().add(defaultEditor);
		preferences.setDefaultEditor(defaultEditor);

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(preferencesURI);
		resource.getContents().add(preferences);

		persist();
	}

	private void persist() {
		try {
			preferences.eResource().save(Collections.EMPTY_MAP);
		} catch (IOException ex) {
			Activator.log.error(ex);
		}
	}

	public BodyEditor getEditorFor(String language) {
		if(languageMapping.containsKey(language)) {
			List<Editor> editors = languageMapping.get(language);
			if(editors != null && !editors.isEmpty()) {
				return getInstance(editors.get(0));
			}
		}

		return getEditorFor(""); //$NON-NLS-1$
	}

	public void setDefaultEditorFor(String languageName, Editor editor) {
		if(!languageMapping.containsKey(languageName)) {
			languageMapping.put(languageName, new LinkedList<Editor>());
		}

		List<Editor> availableEditors = languageMapping.get(languageName);
		availableEditors.removeAll(Collections.singleton(editor));
		availableEditors.add(0, editor);

		Language language = getLanguage(languageName);
		language.setPreferedEditor(editor);
	}

	public Preferences getPreferences() {
		return preferences;
	}

	public void registerEditor(String language, Editor editor) {
		if(language == null)
			language = ""; //$NON-NLS-1$

		if(!languageMapping.containsKey(language)) {
			languageMapping.put(language, new LinkedList<Editor>());
		}

		List<Editor> editors = languageMapping.get(language);
		if(!editors.contains(editors)) {
			editors.add(editor);
		}
	}

	private Language getLanguage(String name) {
		for(Language language : preferences.getLanguages()) {
			if(language.getName().equals(name)) {
				return language;
			}
		}

		Language language = languagepreferencesFactory.eINSTANCE.createLanguage();
		language.setName(name);
		preferences.getLanguages().add(language);

		return language;
	}

	private BodyEditor getInstance(Editor editor) {
		Class<? extends BodyEditor> editorClass = getEditorClass(editor);
		try {
			return editorClass.newInstance();
		} catch (InstantiationException ex) {
			Activator.log.error(ex);
		} catch (IllegalAccessException ex) {
			Activator.log.error(ex);
		}

		return null;
	}

	private Class<? extends BodyEditor> getEditorClass(Editor editor) {
		String className = editor.getClass_();

		try {
			Class<? extends BodyEditor> clazz = Class.forName(className).asSubclass(BodyEditor.class);
			return clazz;
		} catch (ClassNotFoundException ex) {
			Activator.log.error(ex);
		}

		return null;

	}

	private Map<String, List<Editor>> languageMapping;

	private Preferences preferences;

	public List<String> getLanguages() {
		List<String> result = new LinkedList<String>(languageMapping.keySet());
		result.remove(""); //$NON-NLS-1$
		Collections.sort(result);
		return result;
	}
}
