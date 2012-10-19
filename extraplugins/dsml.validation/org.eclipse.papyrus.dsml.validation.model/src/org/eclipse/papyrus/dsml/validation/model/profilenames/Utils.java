/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ernest Wozniak (CEA LIST) ernest.wozniak@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - modifications
 *****************************************************************************/
package org.eclipse.papyrus.dsml.validation.model.profilenames;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * Provision of functionality for management of constraints.
 * 
 * 
 */
public class Utils {

	private static final String JAVA_LANGUAGE = "JAVA";

	private static final String OCL_LANGUAGE = "OCL";

	/*
	 * Map holding relations between String representing the qualified name of a
	 * constraint and name of a package to which it belongs. Package name in
	 * this case is built from the predefined prefix and names of the profiles
	 * in which considered constraint is included. Name of this package is used
	 * for the specification of a package in which java class implementing the
	 * constraint is located.
	 */
	private static Map<String, String> constraintToItsPackage = new HashMap<String, String>();

	/**
	 * This method returns the package for the specific constraint.
	 * 
	 * @param constraint
	 *        constraint for which the method will return name of its
	 *        package
	 * @return string representing name of the package
	 */
	public static String getPackageForConstraint(Constraint constraint) {

		return constraint.getContext().getQualifiedName().toLowerCase().replace("::", ".");
	}

	/**
	 * Retrieval of a java constraint body.
	 * 
	 * @param valueSpecification
	 *        ValueSpecification which contains specification of a java code
	 *        validating the constraint.
	 * @return string representing the java code validating constraint
	 */
	public static String getJavaConstraintBody(ValueSpecification valueSpecification) {

		if(valueSpecification == null || !(valueSpecification instanceof OpaqueExpression)) {
			return null;
		}

		int index = 0;
		for(String language : ((OpaqueExpression)valueSpecification).getLanguages()) {
			if(JAVA_LANGUAGE.equalsIgnoreCase(language)) {
				return ((OpaqueExpression)valueSpecification).getBodies().get(index);
			}
			index++;
		}

		return null;
	}

	/**
	 * This method performs check whether for specific constraint exists
	 * specification of a java code.
	 * 
	 * @param constraint
	 *        constraint for which check for existing java code is performed
	 * @return true if there is an existing specification of a java code
	 *         validating constraint
	 */
	public static Boolean hasSpecificationForJava(Constraint constraint) {

		ValueSpecification valueSpec = constraint.getSpecification();

		if(valueSpec == null || !(valueSpec instanceof OpaqueExpression)) {
			return false;
		}

		for(String language : ((OpaqueExpression)valueSpec).getLanguages()) {
			if(JAVA_LANGUAGE.equalsIgnoreCase(language)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * return the qualified name of the stereotype that is the context of the constraint.
	 * 
	 * @param constraint
	 *        the constraint
	 * @return the qualified name of the constraint or ""
	 */
	public static String getConstraintForStereotype(Constraint constraint) {

		Namespace nameSpace = constraint.getContext();
		if(nameSpace instanceof Stereotype) {
			return ((Stereotype)constraint.getContext()).getQualifiedName();
		}
		return "";
	}

	/**
	 * /**
	 * return true if the constraint is to validate something about a stereotype
	 * 
	 * @param constraint
	 *        the constraint
	 * @return true if the context of the constraint is a stereotype
	 */
	public static Boolean isConstraintForStereotype(Constraint constraint) {

		Namespace nameSpace = constraint.getContext();
		if(nameSpace instanceof Stereotype) {
			return true;
		}
		return false;

	}

	/**
	 * Retrieval of an OCL constraint body.
	 * 
	 * @param constraint
	 *        constraint for which OCL body is retrieved
	 * @return OCL constraint body
	 */
	public static String getOCLConstraintBody(Constraint constraint) {

		int index = 0;
		ValueSpecification valueSpec = constraint.getSpecification();

		if(valueSpec != null && valueSpec instanceof OpaqueExpression) {

			for(String language : ((OpaqueExpression)valueSpec).getLanguages()) {
				if(OCL_LANGUAGE.equalsIgnoreCase(language)) {
					return ((OpaqueExpression)valueSpec).getBodies().get(index);
				}
				index++;
			}
		}

		return null;

	}

	/**
	 * Check whether there is specification of an OCL specification
	 * 
	 * @param constraint
	 *        constraint for which check is performed
	 * @return true if there is an existing specification of an OCL expression
	 *         validating the constraint
	 */
	public static Boolean hasSpecificationForOCL(Constraint constraint) {

		ValueSpecification valueSpec = constraint.getSpecification();

		if(valueSpec == null || !(valueSpec instanceof OpaqueExpression)) {
			return false;
		}

		for(String language : ((OpaqueExpression)valueSpec).getLanguages()) {
			if(OCL_LANGUAGE.equalsIgnoreCase(language)) {
				return true;
			}
		}

		return false;
	}


	/**
	 * Method to insert the correspondence between the constraint and the
	 * package in which the java class validating the constraint will be placed.
	 * 
	 * @param constraint
	 *        constraint for which the package is being assigned
	 * @param pkg
	 *        package in which java code validating the constraint will be
	 *        placed
	 */
	public static void putMappnig(Constraint constraint, String pkg) {

		Utils.getConstraintToItsPackage().put(constraint.getQualifiedName(), pkg);
	}

	/**
	 * Getter for constraintToItsPackage map.
	 * 
	 * @return
	 */
	public static Map<String, String> getConstraintToItsPackage() {
		return constraintToItsPackage;
	}

	/**
	 * Setter for constraintToItsPackage map.
	 * 
	 * @param constraintToItsPackage
	 */
	public static void setConstraintToItsPackage(Map<String, String> constraintToItsPackage) {
		Utils.constraintToItsPackage = constraintToItsPackage;
	}
}
