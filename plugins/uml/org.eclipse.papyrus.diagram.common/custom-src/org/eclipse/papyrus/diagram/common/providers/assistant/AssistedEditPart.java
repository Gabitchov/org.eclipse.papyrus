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

import java.util.List;

import org.eclipse.core.runtime.Platform;

/**
 * A customization to add or remove IElementTypes for an EditPart. Created for
 * the 'es.cv.gvcase.mdt.common.editorAssistantProvider' extension point.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * 
 */
public class AssistedEditPart {

	public String editPartClass;

	public List<Include> Include;

	public List<Exclude> Exclude;

	public Object customizerClass;

	/**
	 * Customizes the types for this edit part, removing and adding types.
	 * 
	 * @return
	 */
	public List customizeTypes(List types) {
		types = removeTypes(types);
		types = addTypes(types);
		if (customizerClass != null) {
			AssistantCustomizeEditPart assistant = (AssistantCustomizeEditPart) Platform
					.getAdapterManager().getAdapter(customizerClass,
							AssistantCustomizeEditPart.class);
			if (assistant != null) {
				types = assistant.customizeTypes(types);
			}
		}
		return types;
	}

	/**
	 * Removes the types specified in extensions.
	 * 
	 * @param types
	 * @return
	 */
	protected List removeTypes(List types) {
		if (this.Exclude != null && types != null) {
			for (Exclude exclude : this.Exclude)
				types = exclude.removeTypes(types);
		}
		return types;
	}

	/**
	 * Adds the types specified in extensions.
	 * 
	 * @param types
	 * @return
	 */
	protected List addTypes(List types) {
		if (this.Include != null && types != null) {
			for (Include include : this.Include) {
				types = include.addTypes(types);
			}
		}
		return types;
	}

}
