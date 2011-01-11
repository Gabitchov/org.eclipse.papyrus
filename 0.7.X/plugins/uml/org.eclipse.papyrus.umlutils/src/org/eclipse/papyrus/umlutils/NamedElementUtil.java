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
package org.eclipse.papyrus.umlutils;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Utility class for <code>org.eclipse.uml2.uml.NamedElement</code><BR>
 */
public class NamedElementUtil {

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
	public static String getDefaultNameWithIncrement(EObject newElement, Collection<EObject> contents) {
		String eclassName = newElement.eClass().getName();
		if(eclassName.length() > 0) {
			eclassName = eclassName.substring(0, 1).toLowerCase() + eclassName.substring(1, eclassName.length());
		}
		
		return getDefaultNameWithIncrementFromBase(eclassName, contents);
	}
	
	@SuppressWarnings("rawtypes")
	public static String getDefaultNameWithIncrementFromBase(String base, Collection contents) {
		int nextNumber = -1;

		for(Object o : contents) {
			if(o instanceof NamedElement) {
				String name = ((NamedElement)o).getName();
				if(name != null && name.startsWith(base)) {
					String end = name.substring(base.length());
					int nextNumberTmp = -1;

					if(end.trim().equals("")) {
						nextNumberTmp = 0;
					} else {
						try {
							nextNumberTmp = Integer.parseInt(end) + 1;
						} catch (NumberFormatException ex) {
							nextNumberTmp = -1;
						}
					}

					if(nextNumberTmp > nextNumber) {
						nextNumber = nextNumberTmp;
					}
				}
			}
		}

		if(nextNumber == -1) {
			return base;
		} else {
			return base + nextNumber;
		}
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


	public static String getName(NamedElement element) {
		if(element.getName() != null) {
			return element.getName();
		} else {
			return (NamedElementUtil.getDefaultNameWithIncrement(element));
		}
	}
}
