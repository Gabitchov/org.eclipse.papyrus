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

import org.eclipse.uml2.uml.*;
import java.util.*;
import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;
import Cpp.*;

public class CppClassIncludeFriendDeclaration
{
  protected static String nl;
  public static synchronized CppClassIncludeFriendDeclaration create(String lineSeparator)
  {
    nl = lineSeparator;
    CppClassIncludeFriendDeclaration result = new CppClassIncludeFriendDeclaration();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////

	// Retrieve the class
	Classifier currentClass = (Classifier) argument;
//	NamedElement currentElt = (NamedElement) argument;

	// Prepare Dependency includes declarations ...
	// Retrieve package used by current package (dependencies)
	Iterator<Classifier> friendClassesIt = GenUtils.getUsedClassifiers(currentClass).iterator();
	
	// Parsing all as NamedElement
	String friendClass	= "";
			
	while (friendClassesIt.hasNext()) {					
		Classifier cClass = friendClassesIt.next();		

		if (GenUtils.hasStereotype(cClass, CppFriend.class) &&
			(!GenUtils.hasStereotype(cClass, CppNoCodeGen.class))) {
				
			CppClassFriendDeclaration jetIDecl
							= new CppClassFriendDeclaration();
			
			friendClass		= friendClass+jetIDecl.generate(cClass);
		}
	}
		
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////
    stringBuffer.append(TEXT_1);
    stringBuffer.append( friendClass );
    return stringBuffer.toString();
  }
}