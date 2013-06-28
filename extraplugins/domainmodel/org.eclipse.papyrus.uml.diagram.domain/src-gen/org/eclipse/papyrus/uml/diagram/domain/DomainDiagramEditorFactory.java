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
package org.eclipse.papyrus.uml.diagram.domain;

import org.eclipse.papyrus.infra.gmfdiag.common.GmfEditorFactory;
import org.eclipse.papyrus.uml.diagram.domain.provider.ElementTypes;

public class DomainDiagramEditorFactory extends GmfEditorFactory {

	public DomainDiagramEditorFactory() {
		super(DomainDiagramForMultiEditor.class, ElementTypes.DIAGRAM_ID);
	}

}
