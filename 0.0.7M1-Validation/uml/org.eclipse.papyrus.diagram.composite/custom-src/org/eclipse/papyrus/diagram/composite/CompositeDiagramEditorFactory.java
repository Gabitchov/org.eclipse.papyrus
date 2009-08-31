/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.composite;

import org.eclipse.papyrus.core.adaptor.gmf.GmfEditorFactory;
import org.eclipse.papyrus.diagram.composite.edit.parts.PackageEditPart;

public class CompositeDiagramEditorFactory extends GmfEditorFactory {

	public CompositeDiagramEditorFactory() {
		super(UmlCompositeDiagramForMultiEditor.class, PackageEditPart.MODEL_ID);
	}
}
