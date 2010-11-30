/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.parameter.editor.xtext.ui.contributions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.parameter.editor.xtext.validation.UmlParameterJavaValidator;
import org.eclipse.papyrus.umlutils.MultiplicityElementUtil;
import org.eclipse.papyrus.umlutils.NamedElementUtil;
import org.eclipse.papyrus.umlutils.ParameterUtil;
import org.eclipse.papyrus.umlutils.TypeUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterEffectKind;
import org.eclipse.uml2.uml.Type;

/**
 * 
 * This class provides methods to get the label to display for a Parameter
 * 
 * 
 */
public class UMLParameterEditorUtil extends ParameterUtil {

	/**
	 * Returns the string used to represent this parameter
	 * 
	 * @param parameter
	 *        a parameter
	 * @return
	 *         the string used to represent this parameter
	 */
	public static String getLabel(Parameter parameter) {
		StringBuffer buffer = new StringBuffer();
		// visibility
		buffer.append(" ");
		buffer.append(NamedElementUtil.getVisibilityAsSign(parameter));

		// direction
		buffer.append(" ");
		buffer.append(parameter.getDirection().getLiteral());

		// name
		buffer.append(" ");
		if(parameter.getName() != null) {
			buffer.append(parameter.getName());
		}

		// type
		// type
		if(parameter.getType() != null) {
			buffer.append(" : " + getTypeLabel(parameter.getType()));
		} else {
			buffer.append(" : " + TypeUtil.UNDEFINED_TYPE_NAME);
		}

		// multiplicity -> do not display [1]
		String multiplicity = MultiplicityElementUtil.getMultiplicityAsString(parameter);
		if(!multiplicity.trim().equals("[1]")) {
			buffer.append(multiplicity);
		}

		// default value
		if(parameter.getDefault() != null) {
			buffer.append(" = ");
			buffer.append(parameter.getDefault());
		}

		// property modifiers
		buffer.append(ParameterUtil.getModifiersAsString(parameter, false));
		buffer.append(getEffectAsString(parameter));
		return buffer.toString();

	}

	/**
	 * Returns the effect of the parameter as a String
	 * 
	 * @param parameter
	 *        the parameter
	 * @return
	 *         The effect of the parameter as a String
	 */
	public static String getEffectAsString(Parameter parameter) {
		StringBuffer buffer = new StringBuffer();
		ParameterEffectKind effect = parameter.getEffect();
		buffer.append(effect.toString());

		if(!buffer.toString().equals("")) {
			buffer.insert(0, "{effect: ");
			buffer.append("}");
		}
		return buffer.toString();
	}

	/**
	 * Returns the name of the type with its qualified name
	 * 
	 * @param type
	 *        a type
	 * @return
	 *         the name of the type with its qualified name
	 */
	public static String getTypeLabel(Type type) {
		String label = "";

		Namespace model = UmlParameterJavaValidator.getInstance().getModel();
		List<Package> importedPackages = new ArrayList<Package>(model.getImportedPackages());

		List<Package> visitedPackages = new ArrayList<Package>();
		Package currentPackage = type.getNearestPackage();

		boolean rootFound = false;

		while(currentPackage != null && !rootFound) {
			visitedPackages.add(currentPackage);
			if(importedPackages.contains(currentPackage) || currentPackage == model) {
				rootFound = true;
			}
			Element owner = currentPackage.getOwner();
			while(owner != null && !(owner instanceof Package))
				owner = owner.getOwner();

			currentPackage = owner != null ? (Package)owner : null;
		}

		for(int i = visitedPackages.size() - 1; i >= 0; i--) {
			label += visitedPackages.get(i).getName() + "::";
		}

		return label + type.getName();
	}
}
