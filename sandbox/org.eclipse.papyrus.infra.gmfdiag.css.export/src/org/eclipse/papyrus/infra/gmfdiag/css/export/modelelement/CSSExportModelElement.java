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
package org.eclipse.papyrus.infra.gmfdiag.css.export.modelelement;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.gmfdiag.css.export.csscustomization.CsscustomizationPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.theme.Theme;
import org.eclipse.papyrus.infra.gmfdiag.css.theme.ThemeManager;
import org.eclipse.papyrus.infra.gmfdiag.css.theme.ThemeManager.EmptyTheme;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.StaticContentProvider;
import org.eclipse.papyrus.views.properties.modelelement.EMFModelElement;


public class CSSExportModelElement extends EMFModelElement {

	/**
	 * 
	 * Constructs a new CSSExportModelElement for the given EObject
	 * 
	 * @param source
	 */
	public CSSExportModelElement(EObject source) {
		super(source);
	}

	/**
	 * 
	 * Constructs a new CSSExportModelElement for the given EObject and Editing Domain
	 * 
	 * @param source
	 * @param domain
	 */
	public CSSExportModelElement(EObject source, EditingDomain domain) {
		super(source, domain);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStaticContentProvider getContentProvider(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);
		if(feature == CsscustomizationPackage.eINSTANCE.getCSSStylesheet_Theme()) {
			List<Theme> allThemes = ThemeManager.instance.getThemes();
			String[] themeIds = new String[allThemes.size() - 1]; //-1 to ignore the EmptyTheme

			int i = 0;
			for(Theme theme : allThemes) {
				if(theme != EmptyTheme.instance) {
					themeIds[i++] = theme.getId();
				}
			}

			return new StaticContentProvider(themeIds);
		}

		return super.getContentProvider(propertyPath);
	}

}
