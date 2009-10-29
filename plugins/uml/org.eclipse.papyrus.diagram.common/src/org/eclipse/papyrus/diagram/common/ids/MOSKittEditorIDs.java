/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.ids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

// TODO: Auto-generated Javadoc
/**
 * The Class MOSKittEditorIDs.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * @deprecated now it is papyrus editor id
 */
public class MOSKittEditorIDs {

	/** Extension Point functionality. */

	private static final String mapModelToEditorExtensionPoint = "org.eclipse.papyrus.diagram.common.modelToEditorMap";

	/** The Constant ATT_MODELID. */
	private static final String ATT_MODELID = "modelID";

	/** The Constant ATT_EDITORID. */
	private static final String ATT_EDITORID = "editorID";

	/** The Constant ATT_LABEL. */
	private static final String ATT_LABEL = "label";

	/** The cached map model to editor. */
	private static Map<String, String> cachedMapModelToEditor = null;

	/** The cached map model to label. */
	private static Map<String, String> cachedMapModelToLabel = null;

	/**
	 * Gets the all extension model to editor.
	 * 
	 * @return the all extension model to editor
	 */
	public static Map<String, String> getAllExtensionModelToEditor() {
		return getExtensionsMapModelToEditor();
	}

	/**
	 * Gets the all extensions editor i ds.
	 * 
	 * @return the all extensions editor i ds
	 */
	// @unused
	public static List<String> getAllExtensionsEditorIDs() {
		return new ArrayList<String>(getExtensionsMapModelToEditor().values());
	}

	/**
	 * Gets the extensions map model to editor.
	 * 
	 * @return the extensions map model to editor
	 */
	protected static Map<String, String> getExtensionsMapModelToEditor() {
		if (cachedMapModelToEditor == null) {
			buildModelToEditorMap();
		}
		return cachedMapModelToEditor;
	}

	/**
	 * Builds the model to editor map.
	 */
	protected static void buildModelToEditorMap() {
		cachedMapModelToEditor = new HashMap<String, String>();
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(mapModelToEditorExtensionPoint);
		for (IExtension extension : extensionPoint.getExtensions()) {
			processExtensionEditor(extension, cachedMapModelToEditor);
		}
	}

	/**
	 * Process extension editor.
	 * 
	 * @param extension
	 *            the extension
	 * @param map
	 *            the map
	 */
	protected static void processExtensionEditor(IExtension extension, Map<String, String> map) {
		for (IConfigurationElement configElement : extension.getConfigurationElements()) {
			String model = configElement.getAttribute(ATT_MODELID);
			String editor = configElement.getAttribute(ATT_EDITORID);
			map.put(model, editor);
		}
	}

	/**
	 * Gets the extensions map model to label.
	 * 
	 * @return the extensions map model to label
	 */
	public static Map<String, String> getExtensionsMapModelToLabel() {
		if (cachedMapModelToLabel == null) {
			buildMapModelToLabel();
		}
		return cachedMapModelToLabel;
	}

	/**
	 * Builds the map model to label.
	 */
	protected static void buildMapModelToLabel() {
		cachedMapModelToLabel = new HashMap<String, String>();
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(mapModelToEditorExtensionPoint);
		for (IExtension extension : extensionPoint.getExtensions()) {
			processExtensionLabel(extension, cachedMapModelToLabel);
		}
	}

	/**
	 * Process extension label.
	 * 
	 * @param extension
	 *            the extension
	 * @param map
	 *            the map
	 */
	protected static void processExtensionLabel(IExtension extension, Map<String, String> map) {
		for (IConfigurationElement configElement : extension.getConfigurationElements()) {
			String model = configElement.getAttribute(ATT_MODELID);
			String label = configElement.getAttribute(ATT_LABEL);
			if (label != null) {
				map.put(model, label);
			}
		}
	}

}
