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
package org.eclipse.papyrus.infra.gmfdiag.css.provider;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.papyrus.infra.emf.appearance.style.AnnotationStyleProvider;

/**
 * An appearance provider based on CSS. It reuses the AnnotationStyleProvider:
 * if a property is changed manually, a standard annotation will be used.
 * 
 * @author Camille Letavernier
 * 
 */
//FIXME: Currently, manual changes on the appearance properties are not 
//correctly taken into account
public class CSSAppearanceProvider extends AnnotationStyleProvider {

	@Override
	public boolean showElementIcon(EModelElement modelElement) {
		boolean result = super.showElementIcon(modelElement);
		if(!result && modelElement instanceof CustomStyle) {
			return ((CustomStyle)modelElement).showElementIcon();
		}
		return result;
	}

	@Override
	public int getQualifiedNameDepth(EModelElement modelElement) {
		int result = super.getQualifiedNameDepth(modelElement);
		if(result == 1000 && modelElement instanceof CustomStyle) {
			return ((CustomStyle)modelElement).getQualifiedNameDepth();
		}
		return result;
	}

	@Override
	public boolean showShadow(EModelElement modelElement) {
		boolean result = super.showShadow(modelElement);
		if(!result && modelElement instanceof CustomStyle) {
			return ((CustomStyle)modelElement).showShadow();
		}
		return result;
	}

}
