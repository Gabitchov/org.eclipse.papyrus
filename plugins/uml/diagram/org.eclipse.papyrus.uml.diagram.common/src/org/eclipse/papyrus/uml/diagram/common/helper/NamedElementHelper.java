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
package org.eclipse.papyrus.uml.diagram.common.helper;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.Element;

/**
 * This singleton is used to find a new name of element
 * 
 * @deprecated use {@link NamedElementUtil} instead.
 */
@Deprecated
public class NamedElementHelper {

	public static NamedElementHelper EINSTANCE = new NamedElementHelper();

	private String baseString = "default";

	/**
	 * @deprecated should not be used
	 */
	@Deprecated
	public String getBaseString() {
		return baseString;
	}

	/**
	 * Generic method that returns a new unique name within a namespace.
	 * 
	 * @param umlParent
	 *        the parent of the element to create
	 * @param eclass
	 *        the eclass of the element to name
	 * 
	 * @return a distinguisable name within the namespace of the umlParent
	 * @deprecated
	 */
	@Deprecated
	public String getNewUMLElementName(Element umlParent, EClass eclass) {
		return getNewUMLElementName(umlParent, eclass.getName());
	}

	/**
	 * Generic method that returns a new unique name within a namespace.
	 * 
	 * @param umlParent
	 *        the parent of the element to create
	 * @param baseString
	 *        the base string for the new element name
	 * 
	 * @return a distinguishable name within the namespace of the umlParent
	 * 
	 * @deprecated use {@link NamedElementUtil#getDefaultNameWithIncrementFromBase(String, java.util.Collection)} directly.
	 */
	@Deprecated
	public String getNewUMLElementName(Element umlParent, String baseString) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(baseString, umlParent.eContents());
		//		this.setBaseString(baseString);
		//		String name = ""; //$NON-NLS-1$
		//
		//		boolean found = false;
		//		// i <10000: avoid infinite loops
		//		for(int i = 0; i < 10001; i++) {
		//			found = false;
		//			name = getBaseString() + i;
		//			Iterator it = umlParent.getOwnedElements().iterator();
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
	 * @deprecated should not be used
	 */
	@Deprecated
	public void setBaseString(String baseString) {
		this.baseString = baseString;
	}
}
