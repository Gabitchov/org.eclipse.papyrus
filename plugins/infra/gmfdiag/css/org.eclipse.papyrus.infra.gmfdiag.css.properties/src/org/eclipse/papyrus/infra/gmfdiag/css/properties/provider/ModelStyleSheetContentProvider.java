/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mickaël ADAM (ALL4TEC) mickael.adam@all4tec.net
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.properties.provider;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.papyrus.infra.emf.providers.EMFContentProvider;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage;
import org.eclipse.papyrus.infra.widgets.providers.AbstractStaticContentProvider;


public class ModelStyleSheetContentProvider extends EMFContentProvider {

	private EObject context;

	public ModelStyleSheetContentProvider(EObject sourceEObject) {
		super(sourceEObject, StylesheetsPackage.eINSTANCE.getModelStyleSheets_Stylesheets());
		this.context = sourceEObject;
	}

	/**
	 * Returns the content provider associated to feature being edited
	 * 
	 * @param editedEObject
	 *        The object being edited
	 * @param feature
	 *        The object's feature being edited
	 * @return
	 *         A content provider returning all the values valid for the given feature
	 */
	@Override
	protected IStructuredContentProvider getSemanticProvider(EObject editedEObject, EStructuralFeature feature) {

		return new AbstractStaticContentProvider() {

			public Object[] getElements() {
				List<Object> result = new LinkedList<Object>();
				for(Resource resource : ModelStyleSheetContentProvider.this.context.eResource().getResourceSet().getResources()) {
					for(Object object : resource.getContents()) {
						if(object instanceof StyleSheet) {
							result.add(object);
						}
					}
				}
				return result.toArray();
			}
		};
	}

}
