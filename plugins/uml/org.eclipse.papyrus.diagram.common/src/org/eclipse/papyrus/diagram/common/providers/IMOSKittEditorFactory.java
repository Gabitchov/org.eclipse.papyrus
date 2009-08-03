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

import org.eclipse.ui.IEditorPart;

/**
 * A factory that creates an {@link IEditorPart} for the given object.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * 
 */
public interface IMOSKittEditorFactory {

	/**
	 * True if it can provide an {@link IEditorPart} for the given {@link Object}.
	 * 
	 * @param object
	 * @return
	 */
	boolean providesFor(Object object);

	/**
	 * Will give an {@link IEditorPart} that can edit the given {@link Object}.
	 * 
	 * @param object
	 * @return
	 */
	IEditorPart createEditorFor(Object object);

}
