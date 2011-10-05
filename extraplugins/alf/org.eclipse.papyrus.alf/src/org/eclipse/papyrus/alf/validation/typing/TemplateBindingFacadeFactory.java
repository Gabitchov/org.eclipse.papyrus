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

import org.eclipse.papyrus.alf.alf.TemplateBinding;
import org.eclipse.uml2.uml.Classifier;

public class TemplateBindingFacadeFactory {
	
	// TODO: store bound classifiers to avoid useless recomputing

	public static TemplateBindingFacadeFactory eInstance = new TemplateBindingFacadeFactory() ;
	
	public TemplateBindingFacade createTemplateBindingFacade() {
		return new TemplateBindingFacade() ;
	}
	
	public TemplateBindingFacade createTemplateBindingFacade(TemplateBinding templateBinding, Classifier boundTemplate) throws Exception {
		TemplateBindingFacade bindingFacade = new TemplateBindingFacade() ;
		templateBinding.getBindings().get(0).getActual() ;
		return bindingFacade ;
	}
	
}
