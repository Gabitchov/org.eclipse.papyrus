/*****************************************************************************
 * Copyright (c) 2012 ATOS.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Olivier Mélois (Atos) olivier.melois@atos.net - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.sysml.diagram.requirement.edit.policy;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Edit policy responsible of the display of stereotypes. It does not rely
 * on commands to get the stereotypes (the computation of the text was
 * formerly processed by commands executed when the object was dragged
 * from a palette, from instance).
 * 
 * @author omelois
 */
public class CustomAppliedStereotypeLabelDisplayEditPolicy extends AppliedStereotypeNodeLabelDisplayEditPolicy {

	@Override
	public String stereotypesOnlyToDisplay() {
		Object hostModel = getHost().getModel();
		String result = ""; //$NON-NLS-1$
		View view = (View)hostModel;
		EObject viewElement = view.getElement();
		Element element = (Element)viewElement;
		Iterator<Stereotype> listStereotype = element.getAppliedStereotypes().iterator();
		StringBuffer buffer = new StringBuffer();
		while(listStereotype.hasNext()) {
			Stereotype stereotypec = listStereotype.next();
			String stereotype_string = stereotypec.getQualifiedName();
			buffer.append(stereotype_string);
			if(listStereotype.hasNext()) {
				buffer.append(","); //$NON-NLS-1$
			}
		}
		result = buffer.toString();

		if(result.length() != 0) {
			String stereotypespresentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind(view);

			// vertical representation
			if(UMLVisualInformationPapyrusConstant.STEREOTYPE_TEXT_VERTICAL_PRESENTATION.equals(stereotypespresentationKind)) {
				return Activator.ST_LEFT + stereotypesToDisplay(Activator.ST_RIGHT + "\n" + Activator.ST_LEFT, result, "") + Activator.ST_RIGHT;
			} else {// horizontal representation
				return Activator.ST_LEFT + stereotypesToDisplay(", ", result, "") + Activator.ST_RIGHT;
			}
		}

		return result;
	}

	@Override
	public void activate() {
		super.activate();
	}
}
