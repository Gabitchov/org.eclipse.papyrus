/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.activity.part;

import org.eclipse.papyrus.core.adaptor.gmf.GmfEditorFactory;
import org.eclipse.papyrus.diagram.activity.edit.parts.PackageEditPart;

/**
 * A factory for creating ActivityDiagramEditor objects.
 */
public class ActivityDiagramEditorFactory extends GmfEditorFactory {

	/**
	 * Instantiates a new activity diagram editor factory.
	 */
	public ActivityDiagramEditorFactory() {
		super(UMLActivityDiagramForMultiEditor.class, PackageEditPart.MODEL_ID);
	}

}
