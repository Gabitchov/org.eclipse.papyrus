/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers.stackmodel.diagram;

import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.diagram.common.handler.CreateDiagramHandler;

public class CreateLayersTreeDiagramHandler extends CreateDiagramHandler {

	@Override
	protected void addNewDiagram(ServicesRegistry registry) {
		addNewDiagram("Layers Tree Editor", LayersTreeDiagramEditorFactory.EMF_DIAGRAM_TYPE, null, registry);
	}

	public void createDiagram(ServicesRegistry registry) {
		addNewDiagram(registry);
	}
}
