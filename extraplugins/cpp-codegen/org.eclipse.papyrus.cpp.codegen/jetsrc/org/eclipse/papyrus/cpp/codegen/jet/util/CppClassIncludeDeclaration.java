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
import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;
import Cpp.*;

public class CppClassIncludeDeclaration
{
  protected static String nl;
  public static synchronized CppClassIncludeDeclaration create(String lineSeparator)
  {
    nl = lineSeparator;
    CppClassIncludeDeclaration result = new CppClassIncludeDeclaration();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "#include <";
  protected final String TEXT_2 = ">";
  protected final String TEXT_3 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////

	
	// Retrieve header file suffix
	String headerFileSuffix = Activator.getDefault().getPluginPreferences().getString("headSuffix");
	
	
	// Retrieve the class
	NamedElement currentNE	= (NamedElement) argument;
	String cClassPath		= "";
	Package	nearestPkg		= currentNE.getNearestPackage();
	String cClassName = currentNE.getName();
	
	if ( //!(nearestPkg.getUml2Package() instanceof org.eclipse.uml2.uml.Model)  
			/*&& */!(GenUtils.hasStereotype(nearestPkg, CppRoot.class))) {
		cClassPath 	= GenUtils.getFullPath(nearestPkg)+"/";	
	}
		
	
	// If an external class is referred
	CppExternClass extClass = GenUtils.getApplication(currentNE, CppExternClass.class);
	CppTemplate template = GenUtils.getApplication(currentNE, CppTemplate.class);
	if (extClass != null) {
		cClassPath = "";
		cClassName = extClass.getName();
		if ((cClassName == null) || cClassName.equals ("")) {
			// default value
			cClassName = currentNE.getQualifiedName ().replace ("::", "/") + "." + headerFileSuffix;
			// strip model name
			cClassName = cClassName.substring (currentNE.getModel ().getName ().length () + 1);
		}
	} else if (template != null) {
		cClassPath = "";
		cClassName = template.getDeclaration();	
	}
	else cClassName=cClassName+"."+headerFileSuffix;
		
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////
    stringBuffer.append(TEXT_1);
    stringBuffer.append( cClassPath );
    stringBuffer.append( cClassName );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}