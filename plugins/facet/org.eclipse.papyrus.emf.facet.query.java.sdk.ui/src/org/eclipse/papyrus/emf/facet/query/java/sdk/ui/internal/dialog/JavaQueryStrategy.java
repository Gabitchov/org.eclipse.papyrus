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
package org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.dialog;

import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.IQueryContext;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.IQueryDialogFactoryStrategy;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.query.AbstractQueryDialogFactory;
import org.eclipse.papyrus.emf.facet.query.java.metamodel.v0_2_0.javaquery.JavaQuery;
import org.eclipse.papyrus.emf.facet.query.java.metamodel.v0_2_0.javaquery.JavaQueryFactory;
import org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.widget.query.JavaQueryWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.widget.IAbstractWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * This class will be used for the creation of a java query.
 * 
 * @see AbstractQueryDialogFactory
 * @see JavaQueryWidget
 */
public class JavaQueryStrategy implements IQueryDialogFactoryStrategy {

	private final PropertyElement2<String> implClassNameProp;

	public JavaQueryStrategy() {
		this.implClassNameProp = new PropertyElement2<String>(true);
	}

	public IAbstractWidget createWidget(
			final Composite parent, final IQueryContext queryContext) {
		return new JavaQueryWidget(parent, queryContext,
				this.implClassNameProp);
	}

	public Query createQuery(final boolean canBeCached,
			final boolean sideEffects, final IQueryContext queryContext) {
		JavaQuery result = null;
		final String implClassName = (String) this.implClassNameProp.getValue();
		final JavaQuery query = JavaQueryFactory.eINSTANCE.createJavaQuery();
		query.setCanBeCached(canBeCached);
		query.setCanHaveSideEffects(sideEffects);
		if (implClassName != null) {
			query.setImplementationClassName(implClassName);
			result = query;
		}
		return result;
	}

	public String getDialogMessage() {
		return Messages.JavaQueryWizardPage_Java_query_creation_page;
	}

	public String getDialogTitle() {
		return Messages.JavaQueryWizardPage_Java_Query;
	}

	public String getConclusionText() {
		return this.implClassNameProp.getValue2();
	}

}
