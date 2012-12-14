/*******************************************************************************
 * Copyright (c) 2006 - 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.cpp.codegen.utils;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.papyrus.cpp.codegen.Constants;
import org.eclipse.papyrus.cpp.codegen.jet.util.CppClassIncludeDeclaration;
import org.eclipse.papyrus.cpp.codegen.jet.util.CppOwnerPackageIncludeDeclaration;
import org.eclipse.papyrus.cpp.codegen.jet.util.CppStaticAttributeImplementation;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;

import Cpp.CppConst;
import Cpp.CppExternClass;
import Cpp.CppInclude;
import Cpp.CppNoCodeGen;

/**
 * A set of utility functions related to classes.
 * 
 * @author ansgar (ansgar.radermacher@cea.fr)
 * 
 */
public class ClassUtils {

	/**
	 * Generate the "pre-body" statements that are stored in the CppInclude stereotype
	 * "pre" means: add before the ".cpp" file includes its own header file of a program
	 * 
	 * @param currentClass
	 * @return generated text
	 */
	public static String getCppIncludePreBody(Classifier currentClass) {
		CppInclude cppInclude = GenUtils.getApplication(currentClass, CppInclude.class);
		if(cppInclude != null) {
			return GenUtils.addNL(cppInclude.getPreBody());
		}
		return "";
	}

	/**
	 * Generate the body statements that are stored in the CppInclude stereotype
	 * Body means that these statements are added at the beginning of the "body" (the ".cpp") file.
	 * 
	 * @param currentClass
	 * @return generated text
	 */
	public static String getCppIncludeBody(Classifier currentClass) {
		CppInclude cppInclude = GenUtils.getApplication(currentClass, CppInclude.class);
		if(cppInclude != null) {
			return GenUtils.addNL(cppInclude.getBody());
		}
		return "";
	}

	/**
	 * Generated include statements related to dependencies.
	 * 
	 * @param currentCl
	 * @return generated text
	 */
	public static String createIncludeDecl(Classifier currentCl) {
		EList<Classifier> depClassifiers = GenUtils.getDependencies(currentCl);
		return createIncludeDecl(depClassifiers, currentCl);
	}

	public static String createIncludeDecl(EList<Classifier> usedClassifiers, Classifier currentCl)
	{
		String includes = "";
		String forwardDecls = Constants.forwardDecl;

		// avoid duplicates
		EList<Package> ownerPackages = new UniqueEList<Package>();

		for(Classifier cl : usedClassifiers) {

			// Only add include if this is not for the current class
			if(!currentCl.equals(cl)) {
				// ... and if it does not have the stereotype "CppNoCodeGen", unless
				// it has stereotype "CppExternalClass"
				if((!GenUtils.hasStereotype(cl, CppNoCodeGen.class)) ||
					GenUtils.hasStereotype(cl, CppExternClass.class)) {
					String newInclude = "";

					if((cl instanceof Enumeration) || (cl instanceof PrimitiveType))
					{
						// Enumeration is not defined in a separate file, but in the
						// package that owns it => include the owning package (might be a duplicate input, if owning
						// package is also the owner of current class)
						if(cl.getOwner() instanceof Package) {
							Package owner = (Package)cl.getOwner();
							if(!ownerPackages.contains(owner)) {
								ownerPackages.add(owner);
								CppOwnerPackageIncludeDeclaration jetIDecl = new CppOwnerPackageIncludeDeclaration();
								newInclude = jetIDecl.generate(owner);
							}
						}
					}
					else {
						// include the file associated with the classifier 
						CppClassIncludeDeclaration jetIDecl = new CppClassIncludeDeclaration();
						newInclude = jetIDecl.generate(cl);
					}

					includes = includes + newInclude;

					// generate a forward declaration
					// this is useful, even if the ".h" file associated with the class is included:
					//   in case of cyclic dependencies, the include file may actually not be included since
					//   its #ifndef rule will exclude code.
					//   Don't generate forward for external classes, which may actually be non-classes
					/*
					 * if ((cl instanceof Class) && !GenUtils.hasStereotype(cl, CppdxternClass)) {
					 * Class classWithoutBinding = (Class) cl;
					 * if (classWithoutBinding.getTemplateBindings().isEmpty()) {
					 * CppClassIncludeClassDeclaration jetCDecl
					 * = new CppClassIncludeClassDeclaration();
					 * String newClass = jetCDecl.generate(classWithoutBinding);
					 * forwardDecls += newClass;
					 * }
					 * }
					 */
				}
			}
		}
		includes += forwardDecls;
		return includes;
	}

	/**
	 * get the list of static attributes for the implementation
	 * 
	 * @param currentClass
	 * @return
	 */
	public static String getStaticAttributes(Classifier currentClass) {
		String attrSDecl = "";

		CppStaticAttributeImplementation jetSAttDecl = new CppStaticAttributeImplementation();

		for(Property attribute : currentClass.getAttributes()) {

			// check that the attribute is not a static const, in that case it is declared and defined in the header file

			// Static and not constant (constant static attributes are declared within the class declaration) 
			if(attribute.isStatic() && !GenUtils.hasStereotype(attribute, CppConst.class)) {
				attrSDecl = attrSDecl + jetSAttDecl.generate(attribute);
			}
		}
		if(attrSDecl.length() > 0) {
			attrSDecl = Constants.staticAttributes + "\n" + attrSDecl;
		}
		return attrSDecl;
	}
}
