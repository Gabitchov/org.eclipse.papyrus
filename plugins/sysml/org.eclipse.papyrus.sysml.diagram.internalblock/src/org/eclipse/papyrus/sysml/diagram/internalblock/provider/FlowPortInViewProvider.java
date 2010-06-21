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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.part.InternalBlockDiagramEditPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.factory.FlowPortInViewFactory;
import org.eclipse.papyrus.sysml.diagram.internalblock.factory.FlowPortNameLabelViewFactory;

public class FlowPortInViewProvider extends AbstractViewProvider {

	private Map<String, Class<?>> nodeMap = new HashMap<String, Class<?>>();
	{
		nodeMap.put(InternalBlockDiagramElementTypes.FLOWPORT_IN.getSemanticHint(), FlowPortInViewFactory.class);
		nodeMap.put(InternalBlockDiagramElementTypes.FLOWPORT_IN_NAME_LABEL_HINT, FlowPortNameLabelViewFactory.class);
	}

	@Override
	protected boolean provides(CreateNodeViewOperation operation) {
		View view = operation.getContainerView();
		if(!InternalBlockDiagramEditPart.DIAGRAM_ID.equals(view.getDiagram().getType())) {
			return false;
		}

		IElementType elementType = (IElementType)operation.getSemanticAdapter().getAdapter(IElementType.class);
		if(InternalBlockDiagramElementTypes.FLOWPORT_IN == elementType) {
			return true;
		}

		return false;
	}

	@Override
	protected Class<?> getNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		return nodeMap.get(semanticHint);
	}
}
