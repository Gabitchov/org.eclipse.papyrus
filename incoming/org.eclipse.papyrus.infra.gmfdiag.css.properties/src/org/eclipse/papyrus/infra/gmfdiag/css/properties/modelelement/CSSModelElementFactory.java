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

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.css.modelstylesheets.ModelStyleSheets;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.Activator;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElementFactory;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;

public class CSSModelElementFactory implements ModelElementFactory {

	public ModelElement createFromSource(Object sourceElement, DataContextElement context) {

		View source = NotationHelper.findView(sourceElement);
		if(source == null) {
			Activator.log.warn("Unable to resolve the selected element to a GMF View"); //$NON-NLS-1$
			return null;
		}

		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(source);

		//Style EObject (For ModelStyleSheets)
		if("ModelStyleSheets".equals(context.getName())) {
			return null;
			//ModelStyleSheets cssModel = findCSSModel(source);
			//if(cssModel == null) {
			//	Activator.log.warn("Cannot find the CSSModelElement associated to this object");
			//	return new ModelStyleSheetsModelElement(source, domain);
			//}
			//return new EMFModelElement(cssModel, domain);
		}

		//Style EAnnotation (For all other CSS properties)
		if(!(source instanceof EModelElement)) {
			Activator.log.warn("The selected element must be an EModelElement"); //$NON-NLS-1$
			return null;
		}

		return new CSSModelElement(source, domain);
	}

	protected ModelStyleSheets findCSSModel(EObject source) {
		Resource resource = source.eResource();
		if(resource != null) {
			for(EObject rootElement : resource.getContents()) {
				if(rootElement instanceof ModelStyleSheets) {
					return (ModelStyleSheets)rootElement;
				}
			}
		}
		return null;
	}
}
