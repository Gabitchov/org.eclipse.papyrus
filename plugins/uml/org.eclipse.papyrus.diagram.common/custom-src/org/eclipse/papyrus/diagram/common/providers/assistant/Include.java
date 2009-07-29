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

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * List of element types to be added. Created for the
 * 'es.cv.gvcase.mdt.common.editorAssistantProvider' extension point.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * 
 */
public class Include {

	public List<ElementType> ElementType;

	public List addTypes(List types) {
		if (types != null) {
			for (ElementType elementType : this.ElementType) {
				IElementType type = elementType.getElementType(elementType.typeID);
				if (type != null && !types.contains(type)) {
					types.add(type);
				}
			}
		}
		return types;
	}

}
