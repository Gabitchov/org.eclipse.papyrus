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
import Cpp.CppNoCodeGen;
import org.eclipse.uml2.uml.*;
import org.eclipse.uml2.uml.Package;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.cpp.codegen.jet.util.*;
import org.eclipse.papyrus.cpp.codegen.jet.doc.*;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import org.eclipse.papyrus.cpp.codegen.Activator;

public class CppPackageHeader
{
  protected static String nl;
  public static synchronized CppPackageHeader create(String lineSeparator)
  {
    nl = lineSeparator;
    CppPackageHeader result = new CppPackageHeader();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "#ifndef PKG_";
  protected final String TEXT_2 = NL + "#define PKG_";
  protected final String TEXT_3 = NL + NL + "/************************************************************" + NL + "              Pkg_";
  protected final String TEXT_4 = " package header" + NL + " ************************************************************/" + NL;
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL + "\t" + NL + "/* Package dependency header include                        */";
  protected final String TEXT_7 = NL + "#include <";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = ">";
  protected final String TEXT_10 = NL + NL + "/* CppInclude header declarations insert                    */";
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = NL;
  protected final String TEXT_14 = NL + "/* Types Defined in the package                             */";
  protected final String TEXT_15 = NL;
  protected final String TEXT_16 = NL;
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = NL + NL + "/************************************************************" + NL + "              End of Pkg_";
  protected final String TEXT_19 = " package header" + NL + " ************************************************************/" + NL + "" + NL + "#endif";
  protected final String TEXT_20 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
//////////////////////////////////////////////////////////////////////////////////////////
// Java preparation
//////////////////////////////////////////////////////////////////////////////////////////
	
		// Retrieve the package
		Package currentPackage	= (Package) argument;
		Package fatherPackage	= currentPackage.getNestingPackage(); // return owner package

		// Get the package name
		String packageName		= currentPackage.getName();
		String packageFULLNAME	= GenUtils.getFullName (currentPackage).toUpperCase(); 
		String openNS			= GenUtils.openNS (currentPackage) + "namespace " + currentPackage.getName () + " {\n"; 
		String closeNS			= "} // of namespace" + currentPackage.getName () + "\n" + GenUtils.closeNS (currentPackage); 

		// Prepare the header declarations for this package
		String headerDecl		= "";
		CppInclude cppInclude =  GenUtils.getApplication(currentPackage, CppInclude.class);
		if (cppInclude != null) {
			headerDecl =  "// Include from CppInclude declaration" + NL + cppInclude.getHeader() + NL;
		}

		// Retrieve header file suffix
		String headerFileSuffix = Activator.getDefault().getPluginPreferences().getString("headSuffix");


		// Prepare Father include declaration
		String fatherPkgInclude	= "";
		if (fatherPackage != null) {
			// Create an util template to prepare the declaration
			CppOwnerPackageIncludeDeclaration jetPkgInclude		
			= new CppOwnerPackageIncludeDeclaration();
			// Execute the util template
			fatherPkgInclude		= jetPkgInclude.generate(fatherPackage);
		}


		// Prepare Dependency includes declarations ...
		// Retrieve package used by current package (dependencies)
		
		String		cFullName			= ""; // used in java to contruct and in template to read list

		// Get packages linked by dependencies
		EList<Package> usedPackages = GenUtils.getUsedPackages (currentPackage);
		Set<String>	usedPackagesNames = new HashSet<String>();
		// Add imported packages
		usedPackages.addAll(currentPackage.getImportedPackages());

		Iterator<Package> usedPackagesIt = usedPackages.iterator();
		Iterator<String> usedPackagesNamesIt;

		// Refactor as a new Set containing names to be declared for packages (with path)
		while(usedPackagesIt.hasNext()) {
			Package currentUsedPackage	= usedPackagesIt.next();
			String	cPackageName		= currentUsedPackage.getName();
			String  cPackagePath		= GenUtils.getFullPath (currentUsedPackage);

			cFullName					= cPackagePath+"/Pkg_"+cPackageName;				

			// Add this name to the set if codegen stereotype is not applied
			PackageImport packImport = currentPackage.getPackageImport(currentUsedPackage);
			if(!GenUtils.hasStereotype(packImport, CppNoCodeGen.class)) {
				if (!GenUtils.hasStereotype(currentUsedPackage, CppNoCodeGen.class)) {
					usedPackagesNames.add(cFullName);
				}
			}
		}

		// and prepare the Iterator for the template...
		usedPackagesNamesIt		= usedPackagesNames.iterator();



		// Prepare owned type and enum declaration
		String typeDef		= "";
		String enumDef		= "";

		Iterator<Type> typeIt		= currentPackage.getOwnedTypes().iterator();
		while (typeIt.hasNext()) {
			Type currentElt			= typeIt.next();
			if (!GenUtils.hasStereotype(currentElt, CppNoCodeGen.class)) {
				if (currentElt instanceof org.eclipse.uml2.uml.PrimitiveType) {

					PrimitiveType currentType	= (PrimitiveType) currentElt;
					CppPrimitiveTypeDefinition jetPrimitiveType	= new CppPrimitiveTypeDefinition();
					// Execute the util template
					typeDef			= typeDef+jetPrimitiveType.generate(currentType);

				} else if (currentElt instanceof org.eclipse.uml2.uml.Enumeration) {

					Enumeration currentEnum	= (Enumeration) currentElt;
					CppEnumerationDefinition jetEnum			= new CppEnumerationDefinition();
					// Execute the util template
					enumDef			= enumDef+jetEnum.generate(currentEnum);

				}
			}
		}
	
	
//////////////////////////////////////////////////////////////////////////////////////////
// The following part contains the template
//////////////////////////////////////////////////////////////////////////////////////////
    stringBuffer.append(TEXT_1);
    stringBuffer.append( packageFULLNAME );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( packageFULLNAME );
    stringBuffer.append(TEXT_3);
    stringBuffer.append( packageName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( fatherPkgInclude );
    stringBuffer.append(TEXT_6);
    	// For every depency linked package
	while(usedPackagesNamesIt.hasNext()) { 
		cFullName = (String) usedPackagesNamesIt.next();			
    stringBuffer.append(TEXT_7);
    stringBuffer.append( cFullName );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( headerFileSuffix );
    stringBuffer.append(TEXT_9);
    	}																
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    stringBuffer.append( headerDecl );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    stringBuffer.append( openNS );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    stringBuffer.append( typeDef );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( enumDef );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( closeNS );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( packageName );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(TEXT_20);
    return stringBuffer.toString();
  }
}