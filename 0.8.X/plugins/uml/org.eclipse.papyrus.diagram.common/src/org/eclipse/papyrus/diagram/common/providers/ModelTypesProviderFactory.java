/*******************************************************************************
 * Copyright (c) 2009 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) – Initial implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.providers;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory that provides IModelTypesProviders.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * @NOT-generated
 */
public class ModelTypesProviderFactory implements IModelTypesProviderFactory {

	public ModelTypesProviderFactory() {
	}

	// //

	private static Map<String, IModelTypesProvider> mapEditorID2IModelTypesProvider = null;

	protected static Map<String, IModelTypesProvider> getMapEditorID2IModelTypesProvider() {
		if(mapEditorID2IModelTypesProvider == null) {
			mapEditorID2IModelTypesProvider = new HashMap<String, IModelTypesProvider>();
		}
		return mapEditorID2IModelTypesProvider;
	}

	public IModelTypesProvider getProviderForEditor(String editorID) {
		if(getMapEditorID2IModelTypesProvider().containsKey(editorID)) {
			return getMapEditorID2IModelTypesProvider().get(editorID);
		}
		return null;
	}

	public static void registerModelTypesProvider(String editorID, IModelTypesProvider provider) {
		getMapEditorID2IModelTypesProvider().put(editorID, provider);
	}

}
