/*****************************************************************************
 * Copyright (c) 2011 Nicolas Deblock & Manuel Giles.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Nicolas Deblock  nico.deblock@gmail.com  - Initial API and implementation
 * 	Manuel Giles	 giles.manu@live.fr		 - Initial API and implementation
 * 	Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Idea of the java generator project & help for the conception 
 *
 *****************************************************************************/

package org.eclipse.papyrus.java.generator.jdtsynchronizer.impl;



import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.papyrus.java.generator.jdtsynchronizer.GeneratorPreference;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMember;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType;

/**
 * gathers all the util function to synchronize with JDT
 * 
 * @author Nicolas Deblock and Manuel Giles
 * 
 */
public class SynchTools {


	/**
	 * Find a IJavaElement in a list of IJavaElement
	 * It's util to search a children of a IJavaElement
	 * 
	 * @param <U>
	 *        a IJavaElement
	 * @param lstElement
	 *        list of IJavaElement
	 * @param elementName
	 *        name of IJavaElement which is search
	 * @return the element who is search, null if there is no element find
	 */
	public static <U extends IJavaElement> U searchIJavaElement(U[] lstElement, String elementName) {
		for(U e : lstElement) {
			if(e.getElementName().equals(elementName))
				return e;
		}
		return null;
	}

	/**
	 * return the visibility of jdtMember :
	 * public or private or protected, abstract, static, final, synchronized
	 * 
	 * @param jdtMember
	 * @return visibility of jdtMember
	 */
	public static String getVisibility(JDTMember jdtMember) {
		StringBuffer buffer = new StringBuffer();

		if(Flags.isPublic(jdtMember.getFlags()))
			buffer.append("public ");
		if(Flags.isPrivate(jdtMember.getFlags()))
			buffer.append("private ");
		if(Flags.isProtected(jdtMember.getFlags()))
			buffer.append("protected ");

		if(Flags.isAbstract(jdtMember.getFlags()))
			buffer.append("abstract ");

		if(Flags.isStatic(jdtMember.getFlags()))
			buffer.append("static ");
		if(Flags.isFinal(jdtMember.getFlags()))
			buffer.append("final ");
		if(Flags.isSynchronized(jdtMember.getFlags()))
			buffer.append("synchronized ");
		return buffer.toString();
	}

	/**
	 * allow to know if a type is primitive
	 * 
	 * @param typename
	 * @return true if typename is a primive type
	 */
	public static boolean isPrimiveType(String typename) {
		if(typename.equals("byte"))
			return true;
		if(typename.equals("char"))
			return true;
		if(typename.equals("double"))
			return true;
		if(typename.equals("float"))
			return true;
		if(typename.equals("int"))
			return true;
		if(typename.equals("long"))
			return true;
		if(typename.equals("short"))
			return true;
		if(typename.equals("boolean"))
			return true;
		if(typename.equals("String"))
			return true;
		return false;
	}

	/**
	 * return the default return of a type (ex: 0 for a int, false for a boolean, null for a class,...)
	 * 
	 * @param typename
	 * @return true if typename is a primive type
	 */
	public static String defaultReturn(String typename) {
		if(typename.equals("byte"))
			return "0";
		if(typename.equals("char"))
			return "0";
		if(typename.equals("double"))
			return "0";
		if(typename.equals("float"))
			return "0";
		if(typename.equals("int"))
			return "0";
		if(typename.equals("long"))
			return "0";
		if(typename.equals("short"))
			return "0";
		if(typename.equals("boolean"))
			return "false";

		return "null";
	}

	/**
	 * return the Class of a primitive type (ex : int => Integer)
	 * 
	 * @param typename
	 * @return true if typename is a primive type
	 */
	private static String getPrimiveTypeClass(String typename) {
		if(typename.equals("byte"))
			return "Byte";
		if(typename.equals("char"))
			return "Character";
		if(typename.equals("double"))
			return "Double";
		if(typename.equals("float"))
			return "Float";
		if(typename.equals("int"))
			return "Integer";
		if(typename.equals("long"))
			return "Long";
		if(typename.equals("short"))
			return "Short";
		if(typename.equals("boolean"))
			return "Boolean";
		return typename;
	}


	public static String getPackageFragment(JDTType type) {
		try {
			if(type.getCompilationUnit() != null) {
				return type.getCompilationUnit().getPackageFragment().getQualifiedName();
			}
			else
				return getPackageFragment(type.getOwner());
		} catch (NullPointerException e) {
			// id null pointer exception, we return null
			return null;
		}
	}

	public static void createImport(IType itype, JDTType currentType, JDTType importType) throws JavaModelException {
		String packageCurrentType = getPackageFragment(currentType);
		String packageImportType = getPackageFragment(importType);

		// if no package to import, stop
		if(packageImportType == null)
			return;


		// if they have the same package, and if it is not a nested class, we stop
		if(packageCurrentType != null && importType.getCompilationUnit() != null && packageCurrentType.equals(packageImportType))
			return;

		String _import = importType.getQualifiedName();
		if(!SynchTools.isPrimiveType(_import) && _import.contains("."))
			itype.getCompilationUnit().createImport(_import, null, null);
	}

	/**
	 * Get the multivalued declaration for the specified typeName.
	 * 
	 * @param type The enclosing type that will contains the declaration. Requested to ajust import.
	 * @param typeName The type for wich a multivalued statement is requested
	 * @param preference The preferences
	 * @return The multivalued statement for the specified typeName.
	 * 
	 * @throws JavaModelException
	 */
	public static String getMultiValued(IType type, String typeName, GeneratorPreference preference) throws JavaModelException {
		// create the import
		String _classQualifiedName = preference.genericClassForMultiValue();
		String _class = _classQualifiedName.substring(_classQualifiedName.lastIndexOf(".") + 1);

		type.getCompilationUnit().createImport(_classQualifiedName, null, null);
		return _class + "<" + getPrimiveTypeClass(typeName) + ">";
	}

}
