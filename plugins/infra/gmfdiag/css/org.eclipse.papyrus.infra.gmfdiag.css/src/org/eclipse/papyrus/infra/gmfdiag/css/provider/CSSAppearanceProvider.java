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

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.papyrus.infra.emf.appearance.helper.VisualInformationPapyrusConstants;
import org.eclipse.papyrus.infra.emf.appearance.style.AnnotationStyleProvider;

/**
 * An appearance provider based on CSS. It reuses the AnnotationStyleProvider:
 * if a property is changed manually, a standard annotation will be used.
 * 
 * @author Camille Letavernier
 * 
 */
public class CSSAppearanceProvider extends AnnotationStyleProvider {

	@Override
	public boolean showElementIcon(EModelElement modelElement) {
		EAnnotation displayNameLabelIcon = modelElement.getEAnnotation(VisualInformationPapyrusConstants.DISPLAY_NAMELABELICON);
		if(displayNameLabelIcon != null || !(modelElement instanceof CustomStyle)) {
			return super.showElementIcon(modelElement);
		}

		return ((CustomStyle)modelElement).showElementIcon();
	}

	@Override
	public int getQualifiedNameDepth(EModelElement modelElement) {
		EAnnotation qualifiedNameAnnotation = modelElement.getEAnnotation(VisualInformationPapyrusConstants.QUALIFIED_NAME);
		if(qualifiedNameAnnotation != null || !(modelElement instanceof CustomStyle)) {
			return super.getQualifiedNameDepth(modelElement);
		}

		return ((CustomStyle)modelElement).getQualifiedNameDepth();
	}

	@Override
	public boolean showShadow(EModelElement modelElement) {
		EAnnotation shadowAnnotation = modelElement.getEAnnotation(VisualInformationPapyrusConstants.SHADOWFIGURE);

		if(shadowAnnotation != null || !(modelElement instanceof CustomStyle)) {
			return super.showShadow(modelElement);
		}

		return ((CustomStyle)modelElement).showShadow();
	}

}
