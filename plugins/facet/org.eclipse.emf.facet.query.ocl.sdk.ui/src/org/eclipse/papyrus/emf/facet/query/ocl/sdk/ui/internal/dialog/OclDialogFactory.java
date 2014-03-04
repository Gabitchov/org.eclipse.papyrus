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
package org.eclipse.papyrus.emf.facet.query.ocl.sdk.ui.internal.dialog;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.IQueryContext;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.IQueryDialogFactoryStrategy;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.query.AbstractQueryDialogFactory;
import org.eclipse.papyrus.emf.facet.query.ocl.metamodel.oclquery.OclQuery;
import org.eclipse.papyrus.emf.facet.query.ocl.metamodel.oclquery.OclQueryFactory;
import org.eclipse.papyrus.emf.facet.query.ocl.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.query.ocl.sdk.ui.internal.widget.query.OclQueryWidget;
import org.eclipse.papyrus.emf.facet.query.ocl.sdk.ui.internal.widget.query.SynchonizedOclQueryWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.widget.IAbstractWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * Concrete implementation of {@link AbstractQueryDialogFactory} for the
 * creation of OCLExpression.
 * 
 * @see AbstractQueryDialogFactory
 */
public class OclDialogFactory implements IQueryDialogFactoryStrategy {

	private final PropertyElement2<String> oclExpressionProp;

	public OclDialogFactory() {
		this.oclExpressionProp = new PropertyElement2<String>(false,
				Messages.OclDialogFactory_OclExpression);
	}

	public IAbstractWidget createWidget(
			final Composite parent, final IQueryContext queryContext) {
		// An OCL query by definition can't have side effects.
		return new SynchonizedOclQueryWidget(new OclQueryWidget(parent,
				this.oclExpressionProp, queryContext), parent.getDisplay());
	}

	public String getDialogMessage() {
		return Messages.OclQueryDialogFactory_Dialog_Desc;
	}

	public String getDialogTitle() {
		return Messages.OclQueryDialogFactory_Dialog_Title;
	}

	public String getConclusionText() {
		return this.oclExpressionProp.getValue2();
	}

	public OclQuery createQuery(final boolean canBeCached,
			final boolean sideEffects, final IQueryContext queryContext) {
		OclQuery query = null;
		final String oclExpression = (String) this.oclExpressionProp.getValue();
		final EClassifier context = queryContext.getExtendedEClass();
		if ((oclExpression != null) && (context != null)) {
			query = OclQueryFactory.eINSTANCE.createOclQuery();
			query.setCanBeCached(true);
			query.setCanHaveSideEffects(false);
			query.setOclExpression(oclExpression);
			query.setContext(context);
		}
		return query;
	}

}
