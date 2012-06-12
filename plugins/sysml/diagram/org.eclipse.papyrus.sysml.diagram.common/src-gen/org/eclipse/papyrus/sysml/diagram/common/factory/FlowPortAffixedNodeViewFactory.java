/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.common.factory;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.factory.ShapeViewFactory;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;

public class FlowPortAffixedNodeViewFactory extends ShapeViewFactory {

	/**
	 * Creates FlowPort view and add Label and Compartment nodes
	 */
	@Override
	protected void decorateView(View containerView, View view, IAdaptable element, String semanticHint, int index, boolean persisted) {
		getViewService().createNode(element, view, SysMLGraphicalTypes.AFFIXEDLABEL_SYSML_FLOWPORT_LABEL_ID, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(element, view, UMLGraphicalTypes.AFFIXEDLABEL_UML_APPLIEDSTEREOTYPE_ID, ViewUtil.APPEND, persisted, getPreferencesHint());
		// this action needs to be done after the compartments creation
		super.decorateView(containerView, view, element, semanticHint, index, persisted);
	}
}
