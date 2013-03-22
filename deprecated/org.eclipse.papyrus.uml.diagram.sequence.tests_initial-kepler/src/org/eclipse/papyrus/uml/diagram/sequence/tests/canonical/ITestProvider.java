/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.tests.canonical;

import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.uml2.uml.Element;

interface ITestProvider {

	int getEditPartChildrenSize();

	Element getDropElement();

	int getSemanticChildrenSize();

	int getViewChildrenSize();

	GraphicalEditPart getParentEditPart();

	GraphicalEditPart getDestroyEditPart();
}
