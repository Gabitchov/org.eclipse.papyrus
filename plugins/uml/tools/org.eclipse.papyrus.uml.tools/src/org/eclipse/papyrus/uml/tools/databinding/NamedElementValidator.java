/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.databinding;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;


public class NamedElementValidator extends AbstractUMLValidator {

	private EObject source;

	public NamedElementValidator() {
		//nothing

	}

	public NamedElementValidator(EObject source) {
		if(source != null) {
			this.source = source;
		} else {
			this.source = null;
		}
	}

	public IStatus validate(Object value) {
		boolean status = true;
		String string = null;
		if(value instanceof String) {

			string = (String)value;
		}
		if(this.source instanceof NamedElement) {


			Namespace ns = ((NamedElement)this.source).getNamespace();
			if(ns != null) {
				EList<NamedElement> listElement = ns.getMembers();
				for(NamedElement namedElement : listElement) {
					if(namedElement.getName().equals(string) && (this.source != namedElement)) {
						return warning("Same name in namespace");

					}
				}
			}





			if(status) {
				return Status.OK_STATUS;
			}
		}
		return Status.CANCEL_STATUS;
	}
}
