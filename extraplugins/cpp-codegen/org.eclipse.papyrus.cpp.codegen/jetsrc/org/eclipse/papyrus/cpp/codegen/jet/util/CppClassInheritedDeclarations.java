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

public class CppClassInheritedDeclarations
{
  protected static String nl;
  public static synchronized CppClassInheritedDeclarations create(String lineSeparator)
  {
    nl = lineSeparator;
    CppClassInheritedDeclarations result = new CppClassInheritedDeclarations();
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
	Classifier currentClass	= (Classifier) argument;
	String targetName		= "";
	String visibility		= "";
	String decl				= "";
	
	// Get generalization and implementation relationships
	Iterator<DirectedRelationship> relationshipIt =
		currentClass.getSourceDirectedRelationships().iterator();
	// Iterator impIt = currentClass.getImplementations().iterator();
	
	while (relationshipIt.hasNext()) {
		
		DirectedRelationship relationship = relationshipIt.next();
		
		if ((relationship instanceof Generalization) ||
		    (relationship instanceof InterfaceRealization))
		{
			org.eclipse.uml2.uml.Classifier target = null;
			if (relationship.getTargets ().size() > 0) {
				// there should always be at least one element in the target
				// list and it should be a classifier, but better check.
				org.eclipse.uml2.uml.Element element =
					relationship.getTargets().get(0);
				if (element instanceof org.eclipse.uml2.uml.Classifier) {
					target = (org.eclipse.uml2.uml.Classifier) element;
				}
			}
			if (target != null) {
				// If not <NoCodeGen>
				if (!GenUtils.hasStereotype(target, CppNoCodeGen.class))
				{
					CppVisibility cppVisibility = GenUtils.getApplication(relationship, CppVisibility.class);
					if (cppVisibility != null) {
						visibility	= cppVisibility.getValue();
					} else {
						visibility	= "public";
					}

					targetName = GenUtils.qualifiedName (target);		
					if (!decl.equals("")) {
						decl = decl + ", ";
					}
					decl = decl+visibility+" "+targetName;
				}
			}
		}
	}
	
	// Parse implementations
	// RS: removed code: Implementation does not exist in UML2 v2.
	// TODO: replace Implementation with new UML2 constructions?
//	Implementation currentImp;
//	
//	while (impIt.hasNext()) {
//		
//		currentImp		= (Implementation) impIt.next();
//		currentNE		= (NamedElement) currentImp;
//		
//		// get visibility and target name
//		visibility		= currentNE.getVisibilityAsString();
//		
//		// If not <NoCodeGen>
//		if (!GenUtils.hasStereotype(currentImp.getTarget(), CppNoCodeGen.class)) {
//		
//			targetName		= currentImp.getTarget().getName();
//		
//			if (!decl.equals("")) {
//				decl = decl + ", ";
//			}	
//			decl			= decl+visibility+" "+targetName;
//		
//		}
//	}
	
	
	// ":" if decl non empty 
	String prefix	= "";
	if (!decl.equals("")) {
		prefix	= " : ";
	}	
	
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////
    stringBuffer.append(TEXT_1);
    stringBuffer.append( prefix );
    stringBuffer.append( decl );
    return stringBuffer.toString();
  }
}