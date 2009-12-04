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

import java.util.List;

import org.eclipse.core.runtime.Platform;

/**
 * Root info element for a {@link ViewInfo} structure in a Diagram. It stores the editor identifier
 * for which this is applied and the factory that can provide an image and label provider.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * @NOT-generated
 */
public class RootViewInfo {

	/**
	 * The editor that this ViewInfo structure applies to.
	 * 
	 * @NOT-generated
	 */
	public String editorID;

	/**
	 * The factory that will provide a label and image provider.
	 * 
	 * @NOT-generated
	 */
	public Object modelTypes;

	/**
	 * List with children ViewInfo elements.
	 * 
	 * @NOT-generated
	 */
	public List<Object> BaseViewInfo;

	/**
	 * 
	 * @NOT-generated This attribute is not for the extension point.
	 */
	public ViewInfo headViewInfo;

	/**
	 * Gets an {@link IModelTypesProvider} via the specified {@link IModelTypesProviderFactory} using the defined editorID.
	 * 
	 * @return
	 */
	// @unused
	public IModelTypesProvider getModelTypesProvider() {
		if(editorID != null && modelTypes != null) {
			IModelTypesProviderFactory factory = (IModelTypesProviderFactory)Platform.getAdapterManager().getAdapter(
					modelTypes, IModelTypesProviderFactory.class);
			if(factory != null) {
				return factory.getProviderForEditor(editorID);
			}
		}
		return null;
	}

}
