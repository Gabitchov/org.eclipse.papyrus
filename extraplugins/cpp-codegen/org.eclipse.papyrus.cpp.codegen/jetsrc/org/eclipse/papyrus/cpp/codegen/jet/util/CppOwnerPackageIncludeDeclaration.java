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

import org.eclipse.uml2.uml.Package;
import org.eclipse.papyrus.cpp.codegen.Activator;
import Cpp.*;
import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;

public class CppOwnerPackageIncludeDeclaration
{
  protected static String nl;
  public static synchronized CppOwnerPackageIncludeDeclaration create(String lineSeparator)
  {
    nl = lineSeparator;
    CppOwnerPackageIncludeDeclaration result = new CppOwnerPackageIncludeDeclaration();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " \t" + NL + "/* Owner package header include                             */" + NL + "#include <";
  protected final String TEXT_2 = "/Pkg_";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = ">";
  protected final String TEXT_5 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////
	
	// Retrieve the type passed as argument
	Package currentPkg		= (Package) argument;
	String currentPkgName	= currentPkg.getName();
	String currentPkgPath	= GenUtils.getFullPath (currentPkg);
	
	// Retrieve header file suffix
	String headerFileSuffix = Activator.getDefault().getPluginPreferences().getString("headSuffix");

	// Prepare Father include declaration
	boolean isRoot = false;
	
	// The currentElt has the CppRoot stereotype
	if (GenUtils.hasStereotype(currentPkg, CppRoot.class)) {
		isRoot = true;
	}
	// The currentPkg is the model root package
	//if (currentPkg instanceof org.eclipse.uml2.uml.Model){
	//	isRoot = true;
	//}
	
	
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////
    	// if currentPkg is not root it is referenced here
	if (!isRoot) {	 												
    stringBuffer.append(TEXT_1);
    stringBuffer.append( currentPkgPath );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( currentPkgName );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( headerFileSuffix );
    stringBuffer.append(TEXT_4);
    	// endif 
	}                                                               
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}