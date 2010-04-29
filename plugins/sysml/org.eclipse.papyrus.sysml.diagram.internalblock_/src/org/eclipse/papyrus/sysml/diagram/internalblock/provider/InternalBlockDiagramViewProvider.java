/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.provider;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.part.InternalBlockDiagramEditPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.factory.InternalBlockDiagramViewFactory;

// TODO : Implements provides against diagram type
public class InternalBlockDiagramViewProvider extends AbstractViewProvider {

	protected Class getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {
		if(InternalBlockDiagramEditPart.DIAGRAM_ID.equals(diagramKind)) {
			return InternalBlockDiagramViewFactory.class;
		}
		return null;
	}
}
