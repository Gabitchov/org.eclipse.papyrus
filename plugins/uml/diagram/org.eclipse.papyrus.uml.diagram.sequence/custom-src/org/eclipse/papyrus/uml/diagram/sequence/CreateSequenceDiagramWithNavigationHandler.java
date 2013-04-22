/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence;

import org.eclipse.papyrus.infra.gmfdiag.navigation.CreateDiagramWithNavigationHandler;

public class CreateSequenceDiagramWithNavigationHandler extends CreateDiagramWithNavigationHandler {

	public CreateSequenceDiagramWithNavigationHandler() {
		super(new CreateSequenceDiagramCommand(), new SequenceDiagramCreationCondition());
	}
}
