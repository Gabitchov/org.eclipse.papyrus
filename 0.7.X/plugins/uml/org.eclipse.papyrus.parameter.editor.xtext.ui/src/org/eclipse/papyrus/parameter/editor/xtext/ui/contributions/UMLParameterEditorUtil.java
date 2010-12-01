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

import org.eclipse.emf.common.util.EList;
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
		buffer.append(" "); //$NON-NLS-1$
		buffer.append(NamedElementUtil.getVisibilityAsSign(parameter));

		// direction
		buffer.append(" "); //$NON-NLS-1$
		buffer.append(parameter.getDirection().getLiteral());

		// name
		buffer.append(" "); //$NON-NLS-1$
		if(parameter.getName() != null) {
			buffer.append(parameter.getName());
		}

		// type
		if(parameter.getType() != null) {
			EList<Namespace> namespaces = parameter.allNamespaces();
			buffer.append(" : " + getTypeLabel(parameter.getType(), namespaces.get(namespaces.size() - 1))); //$NON-NLS-1$
		} else {
			buffer.append(" : " + TypeUtil.UNDEFINED_TYPE_NAME); //$NON-NLS-1$
		}

		// multiplicity -> do not display [1]
		String multiplicity = MultiplicityElementUtil.getMultiplicityAsString(parameter);
		if(!multiplicity.trim().equals("[1]")) { //$NON-NLS-1$
			buffer.append(multiplicity);
		}

		// default value
		if(parameter.getDefault() != null) {
			buffer.append(" = "); //$NON-NLS-1$
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

		if(!buffer.toString().equals("")) { //$NON-NLS-1$
			buffer.insert(0, "{effect: "); //$NON-NLS-1$
			buffer.append("}"); //$NON-NLS-1$
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
	public static String getTypeLabel(Type type, Namespace model) {
		String label = ""; //$NON-NLS-1$

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
			label += visitedPackages.get(i).getName() + "::"; //$NON-NLS-1$
		}

		return label + type.getName();
	}
}
