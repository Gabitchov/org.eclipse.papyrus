/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Saadia Dhouib saadia.dhouib@cea.fr  - Adapted from Composite Structure Diagram
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.communication;

import org.eclipse.papyrus.core.adaptor.gmf.GmfEditorFactory;
import org.eclipse.papyrus.diagram.communication.edit.parts.ModelEditPart;

/**
 * 
 * Specialization for communication diagram
 * 
 */
public class CommunicationDiagramEditorFactory extends GmfEditorFactory {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public CommunicationDiagramEditorFactory() {
		super(UmlCommunicationDiagramForMultiEditor.class, ModelEditPart.MODEL_ID);

	}
}
