/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.adapters.modisco;

import org.eclipse.papyrus.core.adaptor.emf.CreateDiagramHandler;

/**
 * Eclipse handler to create a Modisco Browser Editor.
 * @todo Let it extends a class that is not emf related.
 * 
 * @author cedric dumoulin
 *
 */
public class CreateModiscoBrowserHandler extends CreateDiagramHandler {

	@Override
	protected void addNewDiagram() {
		addNewDiagram("Modisco Browser", ModiscoBrowserEditorFactory.MODISCO_EDITOR_TYPE, null);
	}

}
