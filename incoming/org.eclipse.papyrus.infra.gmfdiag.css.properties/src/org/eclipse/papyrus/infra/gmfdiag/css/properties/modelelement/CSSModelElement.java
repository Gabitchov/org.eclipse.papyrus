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
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSAnnotations;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.creation.StyleSheetFactory;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding.DiagramStyleSheetObservableList;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.provider.CSSStyleSheetContentProvider;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.provider.CSSStyleSheetLabelProvider;
import org.eclipse.papyrus.infra.gmfdiag.properties.modelelement.CustomStyleModelElement;
import org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;


public class CSSModelElement extends CustomStyleModelElement {

	public CSSModelElement(View source, DataContextElement context) {
		super(source, context);
	}

	public CSSModelElement(View source, EditingDomain domain, DataContextElement element) {
		super(source, domain, element);
	}

	@Override
	public ReferenceValueFactory getValueFactory(String propertyPath) {
		if(CSSAnnotations.CSS_DIAGRAM_STYLESHEETS_KEY.equals(propertyPath)) {
			return new StyleSheetFactory((View)this.source);
		}

		return super.getValueFactory(propertyPath);
	}

	@Override
	public IObservable doGetObservable(String propertyPath) {
		if(CSSAnnotations.CSS_DIAGRAM_STYLESHEETS_KEY.equals(propertyPath)) {
			return new DiagramStyleSheetObservableList((View)source, domain, propertyPath);
		}
		return super.doGetObservable(propertyPath);
	}

	@Override
	public ILabelProvider getLabelProvider(String propertyPath) {
		if(CSSAnnotations.CSS_DIAGRAM_STYLESHEETS_KEY.equals(propertyPath)) {
			return new CSSStyleSheetLabelProvider();
		}
		return super.getLabelProvider(propertyPath);
	}

	@Override
	public IStaticContentProvider getContentProvider(String propertyPath) {
		return new CSSStyleSheetContentProvider(source);
	}

}
