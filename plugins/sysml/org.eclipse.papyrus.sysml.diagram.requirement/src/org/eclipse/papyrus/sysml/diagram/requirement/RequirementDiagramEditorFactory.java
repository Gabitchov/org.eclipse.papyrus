/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement;

import org.eclipse.papyrus.core.adaptor.gmf.GmfEditorFactory;
import org.eclipse.papyrus.sysml.diagram.requirement.edit.part.RequirementDiagramEditPart;

/**
 * Factory for the SysML Requirement Diagram
 */
public class RequirementDiagramEditorFactory extends GmfEditorFactory {

	/**
	 * Constructor.
	 * 
	 */
	public RequirementDiagramEditorFactory() {
		super(RequirementDiagramForMultiEditor.class, RequirementDiagramEditPart.DIAGRAM_ID);
	}

}
