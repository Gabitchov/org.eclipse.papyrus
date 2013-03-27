/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are property of the CEA, their use is subject to specific agreement 
 * with the CEA.
 * 
 * Contributors:
 *    CEA List - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.cpp.codegen.jet.util;

import Cpp.*;
import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Package;
import org.eclipse.emf.common.util.UniqueEList;
import java.util.*;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Classifier;

public class CppInterfaceAllIncludesDeclaration
{
  protected static String nl;
  public static synchronized CppInterfaceAllIncludesDeclaration create(String lineSeparator)
  {
    nl = lineSeparator;
    CppInterfaceAllIncludesDeclaration result = new CppInterfaceAllIncludesDeclaration();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////

		// Retrieve the interface
		Interface currentInterface		= (Interface) argument;
		
		// Prepare Dependency includes declarations ...
		// Retrieve package used by current package (dependencies)
		// use a unique list to avoid duplicates
		EList<Classifier> usedClasses = new UniqueEList<Classifier> ();
	
		String newInclude		= "";

		// class attributes dependencies
		usedClasses.addAll (GenUtils.getOwnedAttributeTypes(currentInterface));
		// operation parameters dependencies	
		usedClasses.addAll (GenUtils.getIncludesFromOperations(currentInterface));
		// dependencies and associations
		usedClasses.addAll (GenUtils.getRelationships(currentInterface));

		Iterator<Classifier> usedClassesIt = usedClasses.iterator();
		// Parsing all as NamedElement
		String includes = "";

		while (usedClassesIt.hasNext())
		{					
			Classifier cl = usedClassesIt.next ();

			// Only add include if this is not for the current class
			if (!currentInterface.equals(cl)) {
				// ... and if it does not have the stereotype "CppNoCodeGen", unless
				// it has stereotype "CppExternalClass"
				if ( (!GenUtils.hasStereotype(cl, CppNoCodeGen.class)) ||
						 GenUtils.hasStereotype(cl, CppExternClass.class)) {

					if ((cl instanceof Enumeration) || (cl instanceof PrimitiveType))
					{
						// Enumeration is not defined in a separate file, but in the
						// package that owns it => include the owning package (might be a duplicate input, if owning
						// package is also the owner of current interface) 
						CppOwnerPackageIncludeDeclaration jetIDecl
							= new CppOwnerPackageIncludeDeclaration();
						if (cl.getOwner() instanceof Package) { 
							newInclude = jetIDecl.generate (cl.getOwner ());
						}
						else {
							newInclude = "";
						}
					}
					else {
						// include the file associated with the classifier 
						CppClassIncludeDeclaration jetIDecl
							= new CppClassIncludeDeclaration();
						newInclude = jetIDecl.generate (cl);
					}

					includes = includes+newInclude;
				}
			}
		}
		
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////
    stringBuffer.append(TEXT_1);
    stringBuffer.append( includes );
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}