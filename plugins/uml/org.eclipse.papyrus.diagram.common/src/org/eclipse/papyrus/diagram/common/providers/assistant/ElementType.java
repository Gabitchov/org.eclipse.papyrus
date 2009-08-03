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

import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * Representation of an IElementType by its ID. Created for the
 * 'es.cv.gvcase.mdt.common.editorAssistantProvider' extension point.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * 
 */
public class ElementType {

	public String typeID;

	/**
	 * Retrieves the IElementType from the registry of EMF types.
	 * 
	 * @param id
	 * @return
	 */
	public IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

}
