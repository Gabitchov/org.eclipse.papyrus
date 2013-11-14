/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Ansgar Radermacher - ansgar.radermacher@cea.fr CEA LIST - initial API and implementation
 *
 *******************************************************************************/

package org.eclipse.papyrus.texteditor.cdt.sync;

import org.eclipse.cdt.core.model.ICElement;
import org.eclipse.cdt.core.model.IFunctionDeclaration;
import org.eclipse.cdt.core.model.IParent;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Transition;

public class ObtainICElement {
	/**
	 * Return the ICelement associated with a UML element. Currently, only methods are supported.
	 * @param parent the parent (typically the translation unit of a CDT file)  
	 * @param element A named UML element
	 * @throws CoreException
	 */
	public static ICElement getICElement(IParent parent, NamedElement element) {
		try {	
			for(ICElement child : parent.getChildren()) {
				if(child instanceof IParent) {
					return getICElement((IParent)child, element);
				}
				if(child instanceof IFunctionDeclaration) {
					IFunctionDeclaration function = (IFunctionDeclaration) child;
					
					if (element instanceof Operation) {
						if (child.getElementName().endsWith(Namespace.SEPARATOR + element.getName())) {
							// check, if number of parameter matches. TODO: this only handles a part of possible overloading cases
							if (function.getNumberOfParameters() == countParameters(((Operation) element).getOwnedParameters())) {
								return child;
							}
						}
					}
					else if (element instanceof Transition) {
						Transition transition = (Transition) element;
						if (child.getElementName().endsWith(Namespace.SEPARATOR + transition.getEffect().getName())) {
							if (function.getNumberOfParameters() == countParameters(transition.getEffect().getOwnedParameters())) {
								return child;
							}
						}
					}
				}
			}
		}
		catch (CoreException e) {
		}
		return null;
	}

	/**
	 * Count the number of parameters without taking the return parameter into account
	 *
	 * @param list
	 * @return
	 */
	public static int countParameters(EList<Parameter> list) {
		int params = 0;
		for (Parameter par : list) {
			if (par.getDirection() != ParameterDirectionKind.RETURN_LITERAL) {
				params++;
			}
		}
		return params;
	}
}
