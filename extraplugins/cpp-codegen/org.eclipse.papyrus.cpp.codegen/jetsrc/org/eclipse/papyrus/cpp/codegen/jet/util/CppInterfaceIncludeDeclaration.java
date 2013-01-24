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

import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.papyrus.cpp.codegen.Activator;
import Cpp.*;
import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;

public class CppInterfaceIncludeDeclaration
{
  protected static String nl;
  public static synchronized CppInterfaceIncludeDeclaration create(String lineSeparator)
  {
    nl = lineSeparator;
    CppInterfaceIncludeDeclaration result = new CppInterfaceIncludeDeclaration();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "#include <";
  protected final String TEXT_2 = ".";
  protected final String TEXT_3 = ">";
  protected final String TEXT_4 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////

	
	// Retrieve header file suffix
	String headerFileSuffix = Activator.getDefault().getPluginPreferences().getString("headSuffix");

	// Retrieve the interface
	NamedElement currentNE	= (NamedElement) argument;
	String iInterfacePath = "";
	Package	nearestPkg = currentNE.getNearestPackage();
	String iInterfaceName = currentNE.getName();
	
	if ( //!(nearestPkg.getUml2Package() instanceof org.eclipse.uml2.uml.Model)  
			/*&&*/ !(GenUtils.hasStereotype(nearestPkg, CppRoot.class))) {
		iInterfacePath = GenUtils.getFullPath (nearestPkg) + "/";	
	}
		
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////
    stringBuffer.append(TEXT_1);
    stringBuffer.append( iInterfacePath );
    stringBuffer.append( iInterfaceName );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( headerFileSuffix );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}