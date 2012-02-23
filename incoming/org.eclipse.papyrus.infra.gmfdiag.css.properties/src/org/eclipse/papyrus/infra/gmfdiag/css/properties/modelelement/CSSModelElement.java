/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.properties.modelelement;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSAnnotations;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding.CSSClassObservableList;
import org.eclipse.papyrus.views.properties.modelelement.AnnotationModelElement;


public class CSSModelElement extends AnnotationModelElement {

	public CSSModelElement(EModelElement source, EditingDomain domain) {
		super(source, domain, CSSAnnotations.CSS_ANNOTATION);
	}

	@Override
	public IObservable doGetObservable(String propertyPath) {
		if(propertyPath.equals(CSSAnnotations.CSS_GMF_CLASS_KEY)) {
			return new CSSClassObservableList(domain, source);
		}
		if(propertyPath.equals(CSSAnnotations.CSS_DIAGRAM_STYLESHEETS_KEY)) {
			return null; //Unsupported yet
		}
		return super.doGetObservable(propertyPath);
	}
}
