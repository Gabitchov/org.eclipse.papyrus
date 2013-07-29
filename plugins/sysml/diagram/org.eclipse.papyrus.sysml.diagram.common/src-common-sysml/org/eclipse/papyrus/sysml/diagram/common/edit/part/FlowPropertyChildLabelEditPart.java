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
package org.eclipse.papyrus.sysml.diagram.common.edit.part;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AbstractElementChildLabelEditPart;

/**
 * Edit part for {@link FlowProperty} used as Child label node.
 */
public class FlowPropertyChildLabelEditPart extends AbstractElementChildLabelEditPart {

	/** Constructor */
	public FlowPropertyChildLabelEditPart(View view) {
		super(view);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
	}

	//	/**
	//	 * {@inheritDoc}
	//	 */
	//	@Override
	//	protected Image getLabelIcon() {
	//		EObject parserElement = getParserElement();
	//		if(parserElement == null) {
	//			return null;
	//		}
	//
	//		List<View> views = DiagramEditPartsUtil.findViews(parserElement, getViewer());
	//		for(View view : views) {
	//			if(NameLabelIconHelper.showLabelIcon(view)) {
	//				return labelProvider.getImage(parserElement);
	//			}
	//		}
	//
	//		return null;
	//	}
}
