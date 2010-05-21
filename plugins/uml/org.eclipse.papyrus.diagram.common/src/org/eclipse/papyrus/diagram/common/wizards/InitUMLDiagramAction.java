/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.diagram.common.wizards;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.wizards.CreateModelWizard;
import org.eclipse.papyrus.wizards.InitDiagramAction;

/**
 * @deprecated the class is not used - there is no references to it in Papyrus
 */
public class InitUMLDiagramAction extends InitDiagramAction {

	@Override
	protected CreateModelWizard getCreateModelWizard(URI domainModelURI) {
		return new CreateUMLModelWizard(domainModelURI);
	}


}
