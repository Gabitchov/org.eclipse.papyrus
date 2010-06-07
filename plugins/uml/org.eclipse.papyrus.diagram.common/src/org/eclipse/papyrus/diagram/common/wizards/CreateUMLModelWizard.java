/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Thibault Landre (thibault.landre@atosorigin.com) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.wizards;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.wizards.CreateModelWizard;
import org.eclipse.papyrus.wizards.SelectDiagramKindPage;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

public class CreateUMLModelWizard extends CreateModelWizard {

	/**
	 * This ID is the id defined in the extension "org.eclipse.ui.newWizards" of
	 * the wizard.
	 */
	// @unused
	public static final String ID_UMLWIZARD = "org.eclipse.papyrus.wizards.createumlmodel";

	public CreateUMLModelWizard() {
		super();
	}

	public CreateUMLModelWizard(URI domainModelURI) {
		super(domainModelURI);
	}

	@Override
	protected String getModelContentType() {
		return UMLPackage.eCONTENT_TYPE;
	}

	@Override
	protected String getModelFileExtension() {
		return "uml";
	}

}
