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
package org.eclipse.papyrus.diagram.sequence.part;

import org.eclipse.papyrus.core.adaptor.gmf.GmfEditorFactory;
import org.eclipse.papyrus.diagram.sequence.edit.parts.PackageEditPart;

/**
 * A factory for creating SequenceDiagramEditor objects.
 */
public class SequenceDiagramEditorFactory extends GmfEditorFactory {

	/**
	 * Instantiates a new sequence diagram editor factory.
	 */
	public SequenceDiagramEditorFactory() {
		super(UMLSequenceDiagramForMultiEditor.class, PackageEditPart.MODEL_ID);
	}

}
