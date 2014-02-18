/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann TANGUY (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.utils;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.osgi.util.NLS;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Utility class for <code>org.eclipse.uml2.uml.NamedElement</code><BR>
 */
public class NamedElementUtil {

	public static final String COPY_OF = "CopyOf";
	
	public static final String QUALIFIED_NAME_SEPARATOR = "::";

	private final static String PUBLIC_STRING = "+";

	private final static String PROTECTED_STRING = "#";

	private final static String PRIVATE_STRING = "-";

	private final static String PACKAGE_STRING = "~";

	/**
	 * A helper method to calculate the max depth of an element
	 * 
	 * @param the
	 *        named element
	 * @return the maximum depth found in qualified name
	 */
	public static int getQualifiedNameMaxDepth(NamedElement namedElement) {
		int d = 0;
		String s = namedElement.getQualifiedName();
		if(s == null) {
			return 0;
		}
		int n = 0;
		while((n = s.indexOf(QUALIFIED_NAME_SEPARATOR, n)) != -1) {
			n += 2;
			d++;
		}
		return d;
	}

	/**
	 * generate a default name for the eobject in parameter the format is :
	 * "eclassName"+"max(elementOfTheSameName in the container)" + 1
	 * 
	 * @param newElement
	 * @return
	 */
	public static String getDefaultNameWithIncrement(EObject newElement) {
		if(newElement.eContainer() != null) {
			return getDefaultNameWithIncrement(newElement, newElement.eContainer().eContents());
		}
		return null;
	}

	/**
	 * generate a default name for the eobject in parameter the format is :
	 * "eclassName"+"max(elementOfTheSameName in the container)" + 1 the method checks already
	 * existing element in contents parameter
	 * 
	 * @param newElement
	 */
	@SuppressWarnings("rawtypes")
	public static String getDefaultNameWithIncrement(EObject newElement, Collection contents) {
		return getDefaultNameWithIncrement("", newElement, contents);
	}

	@SuppressWarnings("rawtypes")
	public static String getDefaultCopyNameWithIncrement(NamedElement namedElement, Collection contents) {
		String newName = NLS.bind(COPY_OF + "_{0}_", namedElement.getName());
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(newName, contents);
	}
	
	@SuppressWarnings("rawtypes")
	public static String getDefaultNameWithIncrement(String prefix, EObject newElement, Collection contents) {
		if(prefix == null) {
			prefix = "";
		}
		return getDefaultNameWithIncrementFromBase(prefix + newElement.eClass().getName(), contents);
	}

	@SuppressWarnings("rawtypes")
	public static String getDefaultNameWithIncrementFromBase(String base, Collection contents) {
		if(base.equalsIgnoreCase("property")) {
			base = "Attribute";
		}
		int nextNumber = 1;

		for(Object o : contents) {
			if(o instanceof EObject) {
				String name = EMFCoreUtil.getName((EObject)o);
				if(name != null && name.startsWith(base)) {
					String end = name.substring(base.length());
					int nextNumberTmp = 1;

					try {
						nextNumberTmp = Integer.parseInt(end) + 1;
					} catch (NumberFormatException ex) {
					}

					if(nextNumberTmp > nextNumber) {
						nextNumber = nextNumberTmp;
					}
				}
			}
		}

		return base + nextNumber;
	}

	/**
	 * Give the visibility of the {@link NamedElement} as a string, as defined in the UML2 standard.
	 * 
	 * @return A String representing the visibility of the {@link NamedElement}. Possible values:
	 *         <ul>
	 *         <li>public: <code>"+"</code>
	 *         <li>private: <code>"-"</code>
	 *         <li>protected: <code>"#"</code>
	 *         <li>package: <code>"~"</code>
	 *         </ul>
	 */
	public static String getVisibilityAsSign(NamedElement element) {
		String vKindValue = "";

		switch(element.getVisibility().getValue()) {
		case org.eclipse.uml2.uml.VisibilityKind.PUBLIC:
			vKindValue = PUBLIC_STRING;
			break;
		case org.eclipse.uml2.uml.VisibilityKind.PRIVATE:
			vKindValue = PRIVATE_STRING;
			break;
		case org.eclipse.uml2.uml.VisibilityKind.PACKAGE:
			vKindValue = PACKAGE_STRING;
			break;
		case org.eclipse.uml2.uml.VisibilityKind.PROTECTED:
			vKindValue = PROTECTED_STRING;
			break;
		}
		return vKindValue;
	}

	/**
	 * Returns the name of an element, given its qualified name
	 * 
	 * @param qualifiedName
	 *        the qualified name of the element
	 * @return the name of the element. It shall never be <code>null</code>.
	 */
	public static String getNameFromQualifiedName(String qualifiedName) {
		String name = qualifiedName.substring(qualifiedName.lastIndexOf(NamedElement.SEPARATOR) + NamedElement.SEPARATOR.length());
		return (name != null) ? name : "";
	}

	/**
	 * 
	 * @param childQualifiedName
	 *        the qualifiedName of an element
	 * @return
	 *         the qualified name of its parent
	 */
	public static String getParentQualifiedName(final String childQualifiedName) {
		final String childName = getNameFromQualifiedName(childQualifiedName);
		final String parentQualifiedName = childQualifiedName.substring(0, childQualifiedName.length() - (NamedElement.SEPARATOR.length() + childName.length()));
		return (parentQualifiedName != null) ? parentQualifiedName : "";
	}


	public static String getName(NamedElement element) {
		if(element.getName() != null) {
			return element.getName();
		} else {
			return (NamedElementUtil.getDefaultNameWithIncrement(element));
		}
	}
}
