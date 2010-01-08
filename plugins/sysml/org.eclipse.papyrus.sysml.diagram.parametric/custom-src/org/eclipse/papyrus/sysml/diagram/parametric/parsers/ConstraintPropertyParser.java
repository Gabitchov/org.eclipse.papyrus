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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.parsers;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.diagramprofile.parsers.ResourceEObjectParserProvider;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.ConstraintPropertyNameEditPart;
import org.eclipse.uml2.uml.UMLPackage;

public class ConstraintPropertyParser extends ResourceEObjectParserProvider {

	@Override
	public EStructuralFeature getEStructuralFeatureFromOCLResult() {
		return UMLPackage.Literals.NAMED_ELEMENT__NAME;
	}

	@Override
	public String getOclRule() {
		return "self.base_Property";
	}

	@Override
	public String getTargetType() {
		return String.valueOf(ConstraintPropertyNameEditPart.VISUAL_ID);
	}

}
