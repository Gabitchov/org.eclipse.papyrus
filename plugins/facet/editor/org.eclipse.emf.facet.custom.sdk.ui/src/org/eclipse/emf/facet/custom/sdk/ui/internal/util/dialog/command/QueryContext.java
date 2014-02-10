/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.emf.facet.custom.sdk.ui.internal.util.dialog.command;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase;
import org.eclipse.emf.facet.efacet.core.FacetUtils;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.IQueryContext;
import org.eclipse.emf.facet.util.emf.core.ModelUtils;

public class QueryContext implements IQueryContext {

	private final DerivedTypedElement dte;
	private final ETypedElementCase selection;

	public QueryContext(final ETypedElementCase selection) {
		this.selection = selection;
		this.dte = FacetUtils
				.getContainingDerivedTypedElement(selection);
	}

	public int getUpperBound() {
		return this.dte.getUpperBound();
	}

	public EClassifier getReturnType() {
		return this.dte.getEType();
	}

	public Resource getResource() {
		return this.selection.eResource();
	}

	public Query getQuery() {
		return this.selection.getValue();
	}

	public IProject getProject() {
		return ModelUtils.getProject(this.selection);
	}

	public EObject getIntermediateEObject() {
		return this.selection;
	}

	public Facet getFacet() {
		return (Facet) this.dte.eContainer();
	}

	public EClassifier getExtendedEClass() {
		return FacetUtils.getExtendedMetaclass((Facet) this.dte.eContainer());
	}

	public String getDerivedTypedElementName() {
		return this.dte.getName();
	}

}
