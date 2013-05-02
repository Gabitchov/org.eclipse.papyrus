/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.provider;

import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.part.CustomUMLInteractionOverviewEditPartFactory;

public class CustomEditPartProvider extends InteractionOverviewDiagramEditPartProvider {

	public CustomEditPartProvider() {
		setFactory(new CustomUMLInteractionOverviewEditPartFactory());
		setAllowCaching(true);
	}
}
