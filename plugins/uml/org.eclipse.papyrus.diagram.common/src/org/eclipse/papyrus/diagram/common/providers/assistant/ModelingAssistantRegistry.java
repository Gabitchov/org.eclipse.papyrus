/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) – Initial implementation.
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.providers.assistant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.diagram.common.util.ExtensionPointParser;

/**
 * Registry that stores modeling assistants for editors. Created for the
 * 'es.cv.gvcase.mdt.common.editorAssistantProvider' extension point.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * 
 */
public class ModelingAssistantRegistry {

	// Singleton registry

	private static final ModelingAssistantRegistry Instance = new ModelingAssistantRegistry();

	private ModelingAssistantRegistry() {
	}

	/**
	 * Singleton instance.
	 * 
	 * @return
	 */
	// @unused
	public static ModelingAssistantRegistry getInstance() {
		return Instance;
	}

	// assistant extension point

	private static final String modelingAssistantExtensionPointID = "org.eclipse.papyrus.diagram.common.editorAssistantProvider";

	private static final Class<Object>[] classes = new Class[]{ Assistant.class, AssistedEditPart.class,
			Include.class, Exclude.class, ElementType.class };

	private static final Map<String, List<Assistant>> mapEditorID2Assistant = new HashMap<String, List<Assistant>>();

	/**
	 * Retrieves from the registry an assistant for the given editor.
	 * 
	 * @param editorID
	 * @return
	 */
	public List<Assistant> getAssistantForEditor(String editorID) {
		if(getMapEditorID2Assistant().containsKey(editorID)) {
			return getMapEditorID2Assistant().get(editorID);
		}
		return Collections.emptyList();
	}

	/**
	 * The registry of editors to assistants.
	 * 
	 * @return
	 */
	public Map<String, List<Assistant>> getMapEditorID2Assistant() {
		mapEditorID2Assistant.clear();

		ExtensionPointParser parser = new ExtensionPointParser(modelingAssistantExtensionPointID, classes);
		List<Object> extensions = parser.parseExtensionPoint();
		for(Object object : extensions) {
			Assistant assistant = (Assistant)Platform.getAdapterManager().getAdapter(object, Assistant.class);
			if(assistant != null && assistant.editorID != null) {
				if(!mapEditorID2Assistant.containsKey(assistant.editorID)) {
					mapEditorID2Assistant.put(assistant.editorID, new ArrayList<Assistant>());
				}
				mapEditorID2Assistant.get(assistant.editorID).add(assistant);
			}
		}

		return mapEditorID2Assistant;
	}

	// Types for an EditPart customization

	/**
	 * Customizes the list of types for an edit part according to the extensions.
	 * 
	 * @param editorID
	 * @param editPart
	 * @param types
	 * @return
	 */
	// @unused
	public List customizeTypesForEditPart(String editorID, EditPart editPart, List types) {
		for(Assistant assistant : getAssistantForEditor(editorID)) {
			if(assistant != null) {
				types = assistant.customizeTypesForEditPart(editPart, types);
			}
		}
		return types;
	}

}
