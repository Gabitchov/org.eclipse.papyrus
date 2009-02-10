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
 *  Yann TANGUY (CEA LIST) Yann.Tanguy@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.umlutils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.uml2.uml.ParameterableElement;
import org.eclipse.uml2.uml.TemplateParameter;

/**
 * 
 * TODO To change the template for this generated type comment go to Window - Preferences - Java - Code Style - Code Templates Problem : Generalization is not a NamedElement, as such it do not have
 * any Name nor Visibility !!!
 */
public class TemplateSignature extends Element {

	private org.eclipse.uml2.uml.TemplateSignature uml2TemplateSignature;

	public TemplateSignature(org.eclipse.uml2.uml.TemplateSignature t) {
		super(t);
		uml2TemplateSignature = t;
	}

	public org.eclipse.uml2.uml.TemplateSignature getUml2TemplateSignature() {
		return uml2TemplateSignature;
	}

	public String getLabel() {
		return "a template signature";
	}

	public Set<org.eclipse.papyrus.umlutils.Type> getAccessibleTypes() {
		Set<org.eclipse.papyrus.umlutils.Type> list = new HashSet<org.eclipse.papyrus.umlutils.Type>();
		for (Iterator<org.eclipse.uml2.uml.TemplateParameter> i = uml2TemplateSignature.getParameters().iterator(); i.hasNext();) {
			TemplateParameter current = i.next();
			ParameterableElement exposedElement = current.getOwnedParameteredElement();
			if (exposedElement instanceof org.eclipse.uml2.uml.Type) {
				list.add(new org.eclipse.papyrus.umlutils.Type((org.eclipse.uml2.uml.Type) exposedElement));
			}
		}
		return list;
	}

	/**
	 * Retrieve a type accessible in this Signature, given its name.
	 * 
	 * @param name
	 *            the name of the type to find
	 * 
	 * @return the type found or <code>null</code> if not found.
	 */
	public Type findTypeByName(String name) {
		Type type = null;
		boolean isFound = false;
		Assert.isNotEmptyString(name, "findTypeByName(name)");

		Iterator<Type> it = this.getAccessibleTypes().iterator();
		while (!isFound && it.hasNext()) {
			Type t = it.next();
			if (t.getName().equals(name)) {
				isFound = true;
				type = t;
			}
		}

		return type;
	}

}
