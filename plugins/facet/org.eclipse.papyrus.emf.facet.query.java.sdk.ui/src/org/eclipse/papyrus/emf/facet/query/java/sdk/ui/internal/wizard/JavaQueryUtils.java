/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.wizard;

import java.util.Locale;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.emf.facet.efacet.core.FacetUtils;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.IQueryContext;
import org.eclipse.jdt.core.IJavaProject;

public final class JavaQueryUtils {

	private JavaQueryUtils() {
		// Must no be used
	}

	private static final String UNKONWN = "unkonwn"; //$NON-NLS-1$

	public static String getDefaultPackageName(
			final IQueryContext queryContext,
			final IJavaProject javaProject) {
		String sourceClassName = UNKONWN;
		final Facet facet = queryContext.getFacet();
		final EClass eClass = FacetUtils.findExtendedEClass(facet);
		if (eClass != null) {
			sourceClassName = eClass.getName();
		}
		final String packageName = javaProject.getProject().getName()
				+ ".queries." + sourceClassName.toLowerCase(Locale.getDefault()); //$NON-NLS-1$
		return packageName;
	}

}
