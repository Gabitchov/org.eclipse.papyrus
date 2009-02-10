/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi SCHNEKENBURGER (CEA LIST) Remi.schnekenburger@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.umlutils;

import java.util.Iterator;

import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;

/**
 * 
 * 
 */
public class Type extends org.eclipse.papyrus.umlutils.NamedElement {

	/**
	 * 
	 */
	private org.eclipse.uml2.uml.Type uml2Type;

	/**
	 * 
	 * 
	 * @param uml2Type
	 */
	public Type(org.eclipse.uml2.uml.Type uml2Type) {
		super(uml2Type);
		this.uml2Type = uml2Type;
	}

	/**
	 * 
	 */
	public Type() {
		this.uml2Type = null;
	}

	/**
	 * 
	 * 
	 * @return Returns the uml2Type.
	 */
	public org.eclipse.uml2.uml.Type getUml2Type() {
		return uml2Type;
	}

	/**
	 * Converts an uml2 Type to a valid C type. The type can be a Class. The string is then the full name (ie prefixed with the package name) of the class. The string contains a space at the end (to
	 * allow direct concatenation).
	 * 
	 * @param useGlib
	 * @param useC99
	 * 
	 * @return the type as a string
	 */
	public String getDeclaration(boolean useGlib, boolean useC99) {
		String stringType = new String(" /* Default type, no type defined in" + " model */ int");

		if (uml2Type != null) {
			if (uml2Type instanceof org.eclipse.uml2.uml.Class) {
				// For a class : get the full name
				Class tempClass = new Class((org.eclipse.uml2.uml.Class) uml2Type);
				stringType = tempClass.getFullName();
				if (tempClass.isDynamic()) {
					stringType += "*";
				}
			} else {
				// For a simple Type get C type from the <<cType>> stereotype and
				// name tagged value or convert UML types to ctype if necessary
				if (hasStereotype("cType")) {
					stringType = getTaggedValue("cType", "name");
				} else {
					stringType = convertUMLType(uml2Type.getName(), useGlib, useC99);
				}
			}
		}

		return stringType + " ";
	}

	/**
	 * Convert an UML type to a c type. The way types are converted depends on how the Class is parametered.
	 * 
	 * @param useGlib
	 *            Is the Glib used to generate code.
	 * @param umlType
	 *            the uml type to convert
	 * @param useC99
	 * 
	 * @return the correspondin c type
	 */
	private String convertUMLType(String umlType, boolean useGlib, boolean useC99) {
		String cType = umlType;
		if (umlType.equalsIgnoreCase("UnlimitedNatural")) {
			cType = "signed";
		}
		if (umlType.equalsIgnoreCase("Integer")) {
			cType = "int";
		}
		if (umlType.equalsIgnoreCase("String")) {
			if (useGlib) {
				cType = "GString*";
			} else {
				cType = "char*";
			}
		}
		if (umlType.equalsIgnoreCase("Boolean")) {
			if (useC99) {
				cType = "_Bool";
			}
		}
		return cType;
	}

	/**
	 * Tells if the type is a class or a basic type.
	 * 
	 * @return
	 */
	public boolean isClass() {
		boolean isClass = false;
		if (uml2Type != null) {
			isClass = uml2Type instanceof org.eclipse.uml2.uml.Class;
		}
		return isClass;
	}

	/**
	 * Tells if the type is an interface or a basic type.
	 * 
	 * @return
	 */
	public boolean isInterface() {
		boolean isInterface = false;
		if (uml2Type != null) {
			isInterface = uml2Type instanceof org.eclipse.uml2.uml.Interface;
		}
		return isInterface;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public Class getTypeClass() {
		Class typeClass = new Class((org.eclipse.uml2.uml.Class) uml2Type);
		return typeClass;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public Interface getTypeInterface() {
		Interface typeInterface = new Interface((org.eclipse.uml2.uml.Interface) uml2Type);
		return typeInterface;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public boolean isTextType() {
		return uml2Type.getName().equalsIgnoreCase("String");
	}

	/**
	 * Get a string that displays the name of the type, and then its namespace.
	 * <p>
	 * For example: "String - UMLPrimitiveType"
	 * 
	 * @return a string that displays information about the type
	 */
	public String getInfoString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(uml2Type.getName());
		buffer.append(" - ");
		String tmp = "";
		Iterator it = uml2Type.allNamespaces().iterator();
		while (it.hasNext()) {
			Namespace namespace = (Namespace) it.next();
			if (it.hasNext()) {
				tmp = NamedElement.SEPARATOR + namespace.getName() + tmp;
			} else {
				tmp = namespace.getName() + tmp;
			}
		}
		buffer.append(tmp);
		return buffer.toString();
	}
}
