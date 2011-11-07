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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.uml2.uml.ParameterableElement;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;

/**
 * Utility class for <code>org.eclipse.uml2.uml.TemplateSignature</code><BR>
 */
public class TemplateSignatureUtil {

	public static Set<org.eclipse.uml2.uml.Type> getAccessibleTypes(TemplateSignature signature) {
		Set<org.eclipse.uml2.uml.Type> list = new HashSet<org.eclipse.uml2.uml.Type>();

		for(Iterator<org.eclipse.uml2.uml.TemplateParameter> i = signature.getParameters().iterator(); i.hasNext();) {
			TemplateParameter current = i.next();
			ParameterableElement exposedElement = current.getOwnedParameteredElement();
			if(exposedElement instanceof org.eclipse.uml2.uml.Type) {
				list.add((org.eclipse.uml2.uml.Type)exposedElement);
			}
		}
		return list;
	}

	/**
	 * Retrieve a type accessible in this Signature, given its name.
	 * 
	 * @param name
	 *        the name of the type to find
	 * 
	 * @return the type found or <code>null</code> if not found.
	 */
	public static org.eclipse.uml2.uml.Type findTypeByName(TemplateSignature signature, String name) {
		org.eclipse.uml2.uml.Type type = null;
		boolean isFound = false;
		if("".equals(name)) {
			Activator.getDefault().getLog().log(
					new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Name parameter should not be an empty string."));
		} else {
			Iterator<org.eclipse.uml2.uml.Type> it = TemplateSignatureUtil.getAccessibleTypes(signature).iterator();
			while(!isFound && it.hasNext()) {
				org.eclipse.uml2.uml.Type t = it.next();
				if(t.getName().equals(name)) {
					isFound = true;
					type = t;
				}
			}
		}

		return type;
	}

}
