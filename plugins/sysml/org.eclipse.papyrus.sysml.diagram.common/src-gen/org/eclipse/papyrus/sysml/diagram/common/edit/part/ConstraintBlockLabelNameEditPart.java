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
import org.eclipse.papyrus.uml.diagram.common.edit.part.NamedElementNodeLabelNameEditPart;

public class ConstraintBlockLabelNameEditPart extends NamedElementNodeLabelNameEditPart {

	/** Constructor */
	public ConstraintBlockLabelNameEditPart(View view) {
		super(view);
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
	//				return Activator.getInstance().getImage(org.eclipse.papyrus.sysml.constraints.ConstraintsPackage.eINSTANCE.getConstraintBlock());
	//			}
	//		}
	//
	//		return null;
	//	}
}
