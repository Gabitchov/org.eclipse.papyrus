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
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.appearance.helper.VisualInformationPapyrusConstants;
import org.eclipse.papyrus.infra.emf.appearance.style.AnnotationStyleProvider;
import org.eclipse.papyrus.infra.emf.appearance.style.AppearanceStyleProvider;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.helper.StringHelper;
import org.w3c.dom.Element;
import org.w3c.dom.css.CSSValue;

/**
 * Standard implementation of Papyrus Custom Style, CSS-based
 *
 * @author Camille Letavernier
 */
//FIXME: Use constants for the CSS Properties elementIcon, qualifiedNameDepth and shadow
@SuppressWarnings("restriction")
public class CSSCustomStyleDelegate implements CustomStyle {

	private View view;

	private ExtendedCSSEngine engine;

	private Element element;

	private static final String NONE = "none";

	private static final String FULL = "full";

	private static int NONE_VALUE = 1000;

	private static int FULL_VALUE = 0;

	private static final AppearanceStyleProvider provider = new AnnotationStyleProvider();

	/**
	 * Constructor
	 *
	 * @param view
	 *        The GMF view on which the custom style is applied
	 * @param engine
	 *        The CSS engine used to handle the custom properties
	 */
	public CSSCustomStyleDelegate(View view, ExtendedCSSEngine engine) {
		this.view = view;
		this.engine = engine;
		this.element = engine.getElement(this.view);
	}

	public boolean showElementIcon() {
		EAnnotation displayNameLabelIcon = view.getEAnnotation(VisualInformationPapyrusConstants.DISPLAY_NAMELABELICON);
		if(displayNameLabelIcon != null) {
			return provider.showElementIcon(view);
		}

		CSSValue cssValue = engine.retrievePropertyValue(element, "elementIcon");
		if(cssValue == null) {
			return false;
		}
		return (Boolean)engine.convert(cssValue, Boolean.class, null);
	}

	public int getQualifiedNameDepth() {
		EAnnotation qualifiedNameAnnotation = view.getEAnnotation(VisualInformationPapyrusConstants.QUALIFIED_NAME);
		if(qualifiedNameAnnotation != null) {
			return provider.getQualifiedNameDepth(view);
		}

		CSSValue cssValue = engine.retrievePropertyValue(element, "qualifiedNameDepth");
		if(cssValue == null) {
			return NONE_VALUE;
		}

		String cssText = cssValue.getCssText();

		if(StringHelper.equals(FULL, cssText)) {
			return FULL_VALUE;
		}

		if(StringHelper.equals(NONE, cssText)) {
			return NONE_VALUE;
		}

		try {
			int value = Integer.parseInt(cssText);
			return value > 0 ? -value : value;
		} catch (NumberFormatException ex) {
			engine.handleExceptions(ex);
			return NONE_VALUE;
		}
	}

	public boolean showShadow() {
		EAnnotation shadowAnnotation = view.getEAnnotation(VisualInformationPapyrusConstants.SHADOWFIGURE);

		if(shadowAnnotation != null) {
			return provider.showShadow(view);
		}

		CSSValue cssValue = engine.retrievePropertyValue(element, "shadow");
		if(cssValue == null) {
			return false;
		}
		return (Boolean)engine.convert(cssValue, Boolean.class, null);
	}

}
