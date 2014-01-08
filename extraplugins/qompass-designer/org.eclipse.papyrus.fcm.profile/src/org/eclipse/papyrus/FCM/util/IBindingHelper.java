/**
 * Copyright (c) 2013 CEA LIST
 * 
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Ansgar Radermacher - Initial API and implementation
 * 
 */

package org.eclipse.papyrus.FCM.util;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.TemplateBinding;

/**
 * BindingHelper interface. The interface is intentionally left empty. Implementations
 * (such as Qompass designer) might check for subclasses.
 *
 */
public interface IBindingHelper {
	public void handleElement(TemplateBinding binding, Element object);
}
