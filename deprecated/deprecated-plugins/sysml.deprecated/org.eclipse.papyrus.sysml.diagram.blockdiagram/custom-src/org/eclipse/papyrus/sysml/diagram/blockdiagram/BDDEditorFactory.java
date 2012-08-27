/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdiagram;

import org.eclipse.papyrus.core.adaptor.gmf.GmfEditorFactory;


public class BDDEditorFactory extends GmfEditorFactory {

	public BDDEditorFactory() {
		super(BDDDiagramForMultiEditor.class, BDDCreation.MODEL_ID);
	}

}
