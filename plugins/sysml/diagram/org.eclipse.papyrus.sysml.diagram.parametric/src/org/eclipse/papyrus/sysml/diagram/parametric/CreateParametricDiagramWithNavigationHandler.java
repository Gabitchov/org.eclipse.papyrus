/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Régis CHEVREL: chevrel.regis <at> gmail.com
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric;

import org.eclipse.papyrus.infra.gmfdiag.navigation.CreateDiagramWithNavigationHandler;


public class CreateParametricDiagramWithNavigationHandler extends CreateDiagramWithNavigationHandler {

	public CreateParametricDiagramWithNavigationHandler() {
		super(new ParametricDiagramCreateCommand(), new ParametricDiagramCondition());
	}

}
