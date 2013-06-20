/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.robotml.diagram.datatypedef;

import org.eclipse.papyrus.infra.gmfdiag.common.GmfEditorFactory;
import org.eclipse.papyrus.robotml.diagram.datatypedef.edit.part.DatatypeDefEditPart;

public class DatatypeDefEditorFactory extends GmfEditorFactory {

	public DatatypeDefEditorFactory() {
		super(DatatypeDefForMultiEditor.class, DatatypeDefEditPart.DIAGRAM_ID);
	}

}
