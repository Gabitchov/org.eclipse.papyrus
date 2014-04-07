/*******************************************************************************
 * Copyright (c) 2006 - 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.cpp.codegen.utils;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.papyrus.C_Cpp.ExternLibrary;
import org.eclipse.papyrus.C_Cpp.External;
import org.eclipse.papyrus.C_Cpp.NoCodeGen;
import org.eclipse.papyrus.C_Cpp.Typedef;
import org.eclipse.papyrus.C_Cpp.Visibility;
import org.eclipse.papyrus.acceleo.GenUtils;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ClassifierTemplateParameter;
import org.eclipse.uml2.uml.ConnectableElementTemplateParameter;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.OperationTemplateParameter;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.ParameterableElement;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.util.UMLUtil;



/**
 * Some utilities specific to C++ code generation: a set of static methods that is intended
 * for use from Acceleo templates.
 * 
 * @author wassim, ansgar
 * 
 */
public class CppGenUtils {

	public static final String ANSI_C_LIB = "AnsiCLibrary"; //$NON-NLS-1$

	/**
	 * Return a list of template parameters without type
	 * 
	 * @param classifier
	 * @return
	 */
	public static String getTemplateParametersWoType(Classifier classifier) {
		String tparamWoType = ""; //$NON-NLS-1$

		Iterator<TemplateParameter> it = GenUtils.getTemplateParameters(classifier).iterator();

		while(it.hasNext()) {
			TemplateParameter currentTParam = it.next();
			tparamWoType = tparamWoType + GenUtils.getTemplateName(currentTParam);

			if(it.hasNext()) {
				tparamWoType = tparamWoType + ", "; //$NON-NLS-1$
			}
		}
		return tparamWoType;
	}

	/**
	 * The standard UML and MARTE libraries do not apply the stereotype "Typedef". Yet, we want to treat these
	 * types in an identical way, i.e. we use a typedef to the associated primitive C++ type
	 * 
	 * @param type
	 * @return
	 */
	public static String getStdtypes(PrimitiveType type) {
		Object owner = type.getOwner();
		String owningPkgName = ""; //$NON-NLS-1$
		if(owner instanceof Package) {
			owningPkgName = ((Package)owner).getName();
		}
		if(owningPkgName.equals("PrimitiveTypes") || // used in UML >= 2.4 //$NON-NLS-1$
		   owningPkgName.equals("UMLPrimitiveTypes") || // used in UML < 2.4 //$NON-NLS-1$
		   owningPkgName.equals("MARTE_PrimitivesTypes")) { //$NON-NLS-1$
			String td = null;
			String name = type.getName();

			if(name.equals("Boolean")) { //$NON-NLS-1$
				td = "bool"; //$NON-NLS-1$
			} else if(name.equals("Integer")) { //$NON-NLS-1$
				td = "int"; //$NON-NLS-1$
			} else if(name.equals("String")) { //$NON-NLS-1$
				td = "const char *"; //$NON-NLS-1$
			} else if(name.equals("Unlimited Natural")) { //$NON-NLS-1$
				td = "unsigned long"; //$NON-NLS-1$
			}
			if(td != null) {
				return "typedef " + td + " " + name + ";"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
			// else unknown within UMLPrimitiveTypes, treat in standard way
		}

		return ""; //$NON-NLS-1$
	}

	/**
	 * Return a kind of qualifiedName, except if
	 *  - The named element has the stereotype External or NoCodeGen
	 *  - The named element is part of the ANSI C library
	 *  - The named element is a primitive type that has no further definition via a stereotype (TODO: why is this required/useful?)
	 * @param ne
	 * @return
	 */
	public static String cppQualifiedName(NamedElement ne) {
		if (ne == null) {
			return "undefined"; //$NON-NLS-1$
		}
		Object owner = ne.getOwner();
		String owningPkgName = ""; //$NON-NLS-1$
		if(owner instanceof Package) {
			owningPkgName = ((Package)owner).getName();
		}
		if(		GenUtils.hasStereotype(ne, External.class) ||
				GenUtils.hasStereotypeTree(ne, NoCodeGen.class) ||
				GenUtils.hasStereotypeTree(ne, ExternLibrary.class)) {
			return ne.getName();
		}
		else if(owningPkgName.equals(ANSI_C_LIB)) {
			// always use the short name for types within the ANSI C library
			return ne.getName();
		}

		String qName = ne.getName();
        if(currentNS == ne.getNamespace()) {
        	// return simple name, if in current namespace
            return qName;
        }
        if(ne instanceof PrimitiveType) {
        	if(!GenUtils.hasStereotype(ne, Typedef.class) && (getStdtypes((PrimitiveType)ne).length() == 0)) {
        		// is a primitive type without further definition and not a standard primitive type
               	// => assume that it is a external type without namespace
        		return qName;
        	}
        }

        for(Namespace ns : ne.allNamespaces()) {
        	// don't add top-level
        	if(ns.getOwner() != null) {
        		qName = ns.getName() + "::" + qName; //$NON-NLS-1$
        	}
        }
        if(qName.contains("::")) { //$NON-NLS-1$
        	// is a qualified name => make path absolute
            return "::" + qName; //$NON-NLS-1$
        } else {
        	return qName;
        }
    }

	
	/**
	 * Returns the string that is used within a C++ template declaration, e.g. the "Class XY" in template<class XY>.
	 *
	 * @return the template type formated as string
	 */
	public static String getTemplateTypeName(TemplateParameter templateParam) {
		String prefix = ""; //$NON-NLS-1$
		String name = "";  //$NON-NLS-1$

		// Retrieve name of the ParameteredElement (when possible = it is a NamedElement
		ParameterableElement pElt = templateParam.getParameteredElement();
		if((pElt != null) && (pElt instanceof NamedElement)) {
			name = ((NamedElement)pElt).getName();
			if(templateParam instanceof ClassifierTemplateParameter) {
				// prefix name with "class" to indicate that the following type is a classifier
				prefix = "class "; //$NON-NLS-1$
			} else if(templateParam instanceof OperationTemplateParameter) {
				// no prefix
			} else if(templateParam instanceof ConnectableElementTemplateParameter) {
				// no prefix
			} else {// uml2TemplateParameter instanceof TemplateParameter
				// TODO: literal integer is a value specification, but we use the fact that is also a named element
				// e.g. would produce an <int N> parameter and ignore the value behind (which is ok for the
				// declaration of the template, but not for its use.
				if(pElt instanceof LiteralInteger) {
					prefix = "int "; //$NON-NLS-1$
				} else if(pElt instanceof LiteralString) {
					prefix = "String "; //$NON-NLS-1$
				} else if(pElt instanceof LiteralBoolean) {
					prefix = "Boolean "; //$NON-NLS-1$
				} else if(pElt instanceof LiteralUnlimitedNatural) {
					prefix = "UnlimitedNatural "; //$NON-NLS-1$
				} else {
					prefix = pElt.eClass().getName() + " "; //$NON-NLS-1$
				}
			}
		} else {
			name = "undefined"; //$NON-NLS-1$
		}

		return (prefix + name);
	}


	/**
	 * Return a C++ namespace definition for a named element
	 * 
	 * @param ne
	 *        a named element
	 * @return a C++ namespace definition for a named element
	 */
	public static String getNamespace(NamedElement ne) {
		String namespace = ""; //$NON-NLS-1$
		for(Namespace ns : ne.allNamespaces()) {
			if(ns.getOwner() != null) {
				String nsName = ns.getName();
				if(!namespace.equals("")) { //$NON-NLS-1$
					nsName += "::"; //$NON-NLS-1$
				}
				namespace = nsName + namespace;
			}
		}
		if(!namespace.equals("")) { //$NON-NLS-1$
			namespace = "\n" + "using namespace " + namespace + ";\n"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		return namespace;
	}

	/**
	 * Return a C++ open-namespace definition for a named element
	 * 
	 * @param ne
	 *        a named element
	 * @return a C++ open-namespace definition for a named element
	 */
	public static String openNS(NamedElement ne) {
		String openNS = ""; //$NON-NLS-1$
		currentNS = ne.getNamespace();
		if(ne instanceof Package) {
			openNS = "namespace " + ne.getName() + " {\n"; //$NON-NLS-1$ //$NON-NLS-2$
		}
		for(Namespace ns : ne.allNamespaces()) {
			if(ns.getOwner() != null) {
				openNS = "namespace " + ns.getName() + " {\n" + openNS; //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		return openNS;
	}

	
	/**
	 * Return a C++ close-namespace definition for a named element
	 * 
	 * @param ne
	 *        a named element
	 * @return a C++ close-namespace definition for a named element
	 */
	public static String closeNS(NamedElement ne) {
		String closeNS = ""; //$NON-NLS-1$
		if(ne instanceof Package) {
			closeNS = "} // of namespace " + ne.getName() + "\n"; //$NON-NLS-1$ //$NON-NLS-2$
		}
		for(Namespace ns : ne.allNamespaces()) {
			if(ns.getOwner() != null) {
				closeNS += "} // of namespace " + ns.getName() + "\n"; //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		return closeNS;
	}
	
	
	/**
	 * Return the C++ visibility (on generalizations) in text form. Return public, if no stereotype
	 * visibility exists
	 *
	 * @param element
	 * @return
	 */
	public static String getGeneralizationVisibility(Element element) {
		// get visibility and target name
		Visibility cppVisibility = UMLUtil.getStereotypeApplication(element, Visibility.class);
		if(cppVisibility != null) {
			return cppVisibility.getValue();
		} else {
			return "public"; //$NON-NLS-1$
		}
	}

	private static Namespace currentNS;

	private static VisibilityKind currVisibility = null;
	private static final Pattern EmptySectionRegex = Pattern.compile("^\\s*$"); //$NON-NLS-1$

	/**
	 * Update the current visibility to the specified value without writing this value to
	 * the output.  This is to be used when setting the default visibility of a class/struct.
	 */
	public static void resetVisibility(VisibilityKind v) {
		currVisibility = v;
	}

	/**
	 * Create a section of code with the appropriate visibility.  Merges the content with
	 * the previously declared visibility (if appropriate).  Ignore empty content.
	 */
	public static String getSection(VisibilityKind visibility, String content) {
		// Bug 425208: Don't update the visibility until we know for sure that it
		//             will be written to the output.
		VisibilityKind newVisibility = null;
		if (!visibility.equals(currVisibility)) {
			newVisibility = visibility;
		}

		// Filter out empty sections.
		Matcher m = EmptySectionRegex.matcher(content);
		if (content.isEmpty() || m.matches()) {
			return ""; //$NON-NLS-1$
		}

		// Don't write duplicate visibility modifiers.
		if (newVisibility == null) {
			return content;
		}

		currVisibility = newVisibility;
		return currVisibility.toString() + ":\n" + content; //$NON-NLS-1$
	}
}
