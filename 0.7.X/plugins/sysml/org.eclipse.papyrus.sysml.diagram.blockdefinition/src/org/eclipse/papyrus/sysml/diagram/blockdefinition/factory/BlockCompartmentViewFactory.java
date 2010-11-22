/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.factory;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.ListCompartmentViewFactory;
import org.eclipse.gmf.runtime.notation.ListCompartment;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;

public class BlockCompartmentViewFactory extends ListCompartmentViewFactory {

	@Override
	protected Node createNode(){
		ListCompartment result =  NotationFactory.eINSTANCE.createListCompartment();
		return result;
	}

}
