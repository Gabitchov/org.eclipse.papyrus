/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 372626 - Aggregates
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.efacet.ui.internal.exported;

public final class EFacetUIConstants {

	private static final String CATALOG_VIEW_ID = "org.eclipse.papyrus.emf.facet.efacet.ui.view.catalog"; //$NON-NLS-1$

	private EFacetUIConstants() {
		// utility class
	}

	public static String getFacetSetsCatalogViewId() {
		return EFacetUIConstants.CATALOG_VIEW_ID;
	}
}
