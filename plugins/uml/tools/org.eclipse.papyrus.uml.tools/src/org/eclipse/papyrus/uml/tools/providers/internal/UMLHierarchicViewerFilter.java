/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Adaptation to AbstractTreeFilter
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.providers.internal;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.infra.emf.providers.internal.HierarchicViewerFilter;
import org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.UMLPackage;

public class UMLHierarchicViewerFilter extends HierarchicViewerFilter {

	public UMLHierarchicViewerFilter(IHierarchicContentProvider contentProvider) {
		super(contentProvider);
	}

	@Override
	protected Set<EReference> getReferencesToBrowse(EObject element) {
		Set<EReference> result = super.getReferencesToBrowse(element);
		if(element == null || element instanceof PackageImport) {
			result.add(UMLPackage.eINSTANCE.getPackageImport_ImportedPackage());
		}
		return result;
	}
}