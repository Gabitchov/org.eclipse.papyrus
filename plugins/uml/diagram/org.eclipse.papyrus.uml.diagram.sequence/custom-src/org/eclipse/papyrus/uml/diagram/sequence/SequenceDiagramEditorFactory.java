/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence;

import org.eclipse.papyrus.infra.gmfdiag.common.GmfEditorFactory;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.PackageEditPart;

/**
 * The editor factory to launch the sequence diagram.
 */
public class SequenceDiagramEditorFactory extends GmfEditorFactory {

	/**
	 * Instantiates a new sequence diagram editor factory.
	 */
	public SequenceDiagramEditorFactory() {
		super(UmlSequenceDiagramForMultiEditor.class, PackageEditPart.MODEL_ID);
	}
}
