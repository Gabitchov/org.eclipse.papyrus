/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are property of the CEA, their use is subject to specific agreement 
 * with the CEA.
 * 
 * Contributors:
 *    CEA List - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.cpp.codegen.jet;

import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;
import Cpp.CppInclude;
import org.eclipse.uml2.uml.Class;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.TemplateParameterSubstitution;
import org.eclipse.papyrus.cpp.codegen.jet.util.*;
import java.util.*;
import org.eclipse.papyrus.cpp.codegen.Activator;

public class CppBindHeader
{
  protected static String nl;
  public static synchronized CppBindHeader create(String lineSeparator)
  {
    nl = lineSeparator;
    CppBindHeader result = new CppBindHeader();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "#ifndef ";
  protected final String TEXT_2 = "_H" + NL + "#define ";
  protected final String TEXT_3 = "_H" + NL + "" + NL + "/************************************************************";
  protected final String TEXT_4 = NL + "              ";
  protected final String TEXT_5 = " template binding header" + NL + " ************************************************************/" + NL;
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = NL + NL + "#include <";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = ">" + NL;
  protected final String TEXT_14 = NL;
  protected final String TEXT_15 = " " + NL + "/************************************************************/" + NL + "typedef ";
  protected final String TEXT_16 = " <";
  protected final String TEXT_17 = "> ";
  protected final String TEXT_18 = ";" + NL;
  protected final String TEXT_19 = NL;
  protected final String TEXT_20 = NL + NL + "/************************************************************" + NL + "              End of ";
  protected final String TEXT_21 = " template binding header" + NL + " ************************************************************/" + NL + "" + NL + "#endif";
  protected final String TEXT_22 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////
	
		// Retrieve the class
		Class currentClass		= (Class) argument;

		// Get the package name
		String className		= currentClass.getName();
		String classFullName	= GenUtils.getFullName (currentClass);
		String classFULLNAME	= classFullName.toUpperCase(); 
		String classparent      = "";
		String openNS			= GenUtils.openNS (currentClass); 
		String closeNS			= GenUtils.closeNS (currentClass);
		 
		// Include declaration "CppInclude"
		String headerDecl		= "";
		CppInclude cppInclude =  GenUtils.getApplication(currentClass, CppInclude.class);
		if (cppInclude != null) {
			headerDecl =  "// Include from CppInclude declaration" + NL + cppInclude.getHeader() + NL;
		}

		// Prepare owner package header include
		Package ownerPackage	= currentClass.getPackage();
		String ownerInclude		= "";
		if (ownerPackage != null) {
			// Create an util template to prepare the declaration
			CppOwnerPackageIncludeDeclaration jetOwnerInclude		
			= new CppOwnerPackageIncludeDeclaration();
			// Execute the util template
			ownerInclude		= jetOwnerInclude.generate(ownerPackage);
		}

		// Retrieve header file suffix
		String headerFileSuffix = Activator.getDefault().getPluginPreferences().getString("headSuffix");

		//find path for the package owning current class
		String  fullPath	= "";
		String  separ		= "";

		if (ownerPackage != null) {
			fullPath		= GenUtils.getFullPath (ownerPackage);
			separ			= "/";
		} // else fullPath == ""

		org.eclipse.uml2.uml.TemplateBinding tb = GenUtils.getTemplateBindings(currentClass);

		// prepare parent class declaration
		EList<org.eclipse.uml2.uml.Element> templates = tb.getTargets();
		Class templateClass = (Class) ((TemplateSignature)templates.get(0)).getOwner();	
		classparent		= templateClass.getName();               	

		// Prepare bindings parameter declaration

		String tParamDecl="";
		TemplateParameterSubstitution paramsub;
		Iterator<TemplateParameterSubstitution> tps = tb.getParameterSubstitutions().iterator();
		while(tps.hasNext()) {
			paramsub	=	(TemplateParameterSubstitution)tps.next();

			CppTemplateBindingParameter	jetTParam	
			=	new CppTemplateBindingParameter();
			tParamDecl			= tParamDecl+jetTParam.generate(paramsub);

			if (tps.hasNext()) {
				tParamDecl			= tParamDecl+", ";
			}
		}


		// Prepare dependency includes
		CppClassAllIncludesDeclaration jetClassIncludes
		= new CppClassAllIncludesDeclaration();
		String classIncludes			= jetClassIncludes.generate(argument);
		if (!classIncludes.equals("")) {
			classIncludes	= "/* Structural includes (inheritance, dependencies...       */"+NL+classIncludes;
		}
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////
    stringBuffer.append(TEXT_1);
    stringBuffer.append( classFULLNAME );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( classFULLNAME );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append( ownerInclude );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    stringBuffer.append( classIncludes );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    stringBuffer.append( headerDecl );
    stringBuffer.append(TEXT_11);
    stringBuffer.append( fullPath );
    stringBuffer.append( separ );
    stringBuffer.append( classparent );
    stringBuffer.append(TEXT_12);
    stringBuffer.append( headerFileSuffix );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    stringBuffer.append( openNS );
    stringBuffer.append(TEXT_15);
    stringBuffer.append( classparent );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( tParamDecl );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(TEXT_19);
    stringBuffer.append( closeNS );
    stringBuffer.append(TEXT_20);
    stringBuffer.append( className );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(TEXT_22);
    return stringBuffer.toString();
  }
}