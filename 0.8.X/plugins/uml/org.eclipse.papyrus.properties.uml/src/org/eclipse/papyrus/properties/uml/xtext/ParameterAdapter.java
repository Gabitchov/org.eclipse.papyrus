/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.uml.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.widgets.xtext.adapter.IXtextAdapter;

import com.google.inject.Injector;


public class ParameterAdapter implements IXtextAdapter {

	public EObject reconcile(EObject sourceModelObject, EObject xtextObject) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getText(EObject modelObject) {
		//ParameterPopupEditor config = new ParameterPopupEditor();
		//return config.getTextToEdit(modelObject);
		return null;
	}

	public Injector getInjector(EObject sourceModelObject) {
		//		Injector injector = InjectorFactory.createInjector((Parameter)sourceModelObject);
		//		System.out.println(injector.getInstance(Element.class));
		//		return injector;
		return null;
	}

}
