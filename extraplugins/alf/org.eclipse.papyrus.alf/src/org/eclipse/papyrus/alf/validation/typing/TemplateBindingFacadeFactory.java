/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.alf.validation.typing;

import org.eclipse.emf.ecore.EObject;

public class TemplateBindingFacadeFactory {

	public static TemplateBindingFacadeFactory eInstance = new TemplateBindingFacadeFactory() ;
	
	public TemplateBindingFacade createTemplateBindingFacade() {
		// TODO
		return new TemplateBindingFacade() ;
	}
	
	public TemplateBindingFacade createTemplateBindingFacade(EObject templateBinding) {
		// TODO
		return createTemplateBindingFacade() ;
	}
}
