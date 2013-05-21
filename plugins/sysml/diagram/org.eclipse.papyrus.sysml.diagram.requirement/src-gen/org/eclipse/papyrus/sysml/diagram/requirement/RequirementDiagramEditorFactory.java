/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * CEA LIST- Initial API and implementation
 * Nizar GUEDIDI (CEA LIST)- modification
 *
 ****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement;

import org.eclipse.papyrus.infra.gmfdiag.common.GmfEditorFactory;
import org.eclipse.papyrus.sysml.diagram.requirement.provider.ElementTypes;

public class RequirementDiagramEditorFactory extends GmfEditorFactory {

	public RequirementDiagramEditorFactory() {
		super(RequirementDiagramForMultiEditor.class, ElementTypes.DIAGRAM_ID);
	}

}
