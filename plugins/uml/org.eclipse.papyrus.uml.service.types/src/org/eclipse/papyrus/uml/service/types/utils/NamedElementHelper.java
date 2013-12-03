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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.utils;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

/**
 * This singleton is used to find a new element name with
 * no duplication in the same workspace.
 * 
 * Copied in current plug-in to avoid dependencies with oep.diagram.common.
 */
public class NamedElementHelper {

	/** Singleton instance */
	@Deprecated
	public static NamedElementHelper EINSTANCE = new NamedElementHelper();

	@Deprecated
	private String baseString = "default";

	/**
	 * Get the base string to use for default name creation
	 * 
	 * @return the base string
	 * @deprecated should not be used.
	 */
	@Deprecated
	public String getBaseString() {
		return baseString;
	}

	/**
	 * Generic method that returns a new unique name within a {@link Namespace}.
	 * 
	 * @param umlParent
	 *        the parent of the element to create
	 * @param eclass
	 *        the eClass of the element to name
	 * 
	 * @return a distinguishable name within the {@link Namespace} of the umlParent
	 * @deprecated should not be used.
	 */
	@Deprecated
	public String getNewUMLElementName(Element umlParent, EClass eclass) {
		return getNewUMLElementName(umlParent, eclass.getName());
	}

	/**
	 * Generic method that returns a new unique name within a {@link Namespace}.
	 * 
	 * @param umlParent
	 *        the parent of the element to create
	 * @param baseString
	 *        the base string for the new element name
	 * 
	 * @return a distinguishable name within the {@link Namespace} of the umlParent
	 * @deprecated use {@link #getDefaultNameWithIncrementFromBase(String, Collection)} directly.
	 */
	@Deprecated
	public String getNewUMLElementName(Element umlParent, String baseString) {
		return getDefaultNameWithIncrementFromBase(baseString, umlParent.eContents());
		//		this.setBaseString(baseString);
		//		String name = ""; //$NON-NLS-1$
		//
		//		boolean found = false;
		//		// i <10000: avoid infinite loops
		//		for(int i = 1; i < 5; i++) {
		//			found = false;
		//			name = getBaseString() + i;
		//			
		//			Iterator<?> it = umlParent.getOwnedElements().iterator();
		//			while(it.hasNext() && !found) {
		//				Object o = it.next();
		//				if(o instanceof NamedElement) {
		//					if(name.equals(((NamedElement)o).getName())) {
		//						found = true;
		//					}
		//				}
		//			}
		//			if(!found) {
		//				return name;
		//			}
		//		}
		//		return getBaseString() + "X"; //$NON-NLS-1$
	}

	/**
	 * set the base string for the name
	 * 
	 * @param baseString
	 *        a string that is the prefix
	 * @deprecated should not be used.
	 */
	@Deprecated
	public void setBaseString(String baseString) {
		this.baseString = baseString;
	}

	public static String getDefaultNameWithIncrementFromBase(String base, Collection<?> contents) {
		return getDefaultNameWithIncrementFromBase(base, contents, null, "");
	}

	public static String getDefaultNameWithIncrementFromBase(String base, Collection<?> contents, String separator) {
		return getDefaultNameWithIncrementFromBase(base, contents, null, separator);
	}
	
	public static String getDefaultNameWithIncrementFromBase(String base, Collection<?> contents, EObject elementToRename) {
		return getDefaultNameWithIncrementFromBase(base, contents, elementToRename, "");
	}

	public static String getDefaultNameWithIncrementFromBase(String base, Collection<?> contents, EObject elementToRename, String separator) {
		// Not change the name if elementToRename already present in the contents collection and already have a name
		if (contents.contains(elementToRename) && EMFCoreUtil.getName(elementToRename) != null) {
			if (elementToRename instanceof ENamedElement) {
				return ((ENamedElement)elementToRename).getName();
			}
			// UML specific
			if (elementToRename instanceof NamedElement) {
				return ((NamedElement)elementToRename).getName();
			}
		}
		
		if("property".equalsIgnoreCase(base)) {
			base = "Attribute";
		}
		int nextNumber = 0;

		for(Object o : contents) {
			if(o instanceof EObject && o != elementToRename) {
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

		return nextNumber > 0 ? base + separator + nextNumber : base;
	}
}
