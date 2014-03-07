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
package org.eclipse.papyrus.emf.facet.query.ocl.sdk.ui.internal.widget.query;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.IQueryContext;
import org.eclipse.papyrus.emf.facet.query.ocl.metamodel.oclquery.OclQuery;
import org.eclipse.papyrus.emf.facet.query.ocl.sdk.ui.internal.widget.PrintQueryContextWidget;
import org.eclipse.papyrus.emf.facet.query.ocl.sdk.ui.internal.widget.PrintQueryReturnTypeWidget;
import org.eclipse.papyrus.emf.facet.query.ocl.sdk.ui.internal.widget.oclexpression.OclExpressionWidgetSimple;
import org.eclipse.papyrus.emf.facet.query.ocl.sdk.ui.widget.IOclQueryWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.query.AbstractQueryWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * It is the main widget of the main dialog. This widget add the expected return
 * type and display the tree.
 */
public class OclQueryWidget extends AbstractQueryWidget<ETypedElement> implements IOclQueryWidget {

	private final PropertyElement oclExpressionProp;
	private OclExpressionWidgetSimple oclExprWidget;
	private final IQueryContext queryContext;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this widget.
	 * @param properties
	 *            the properties for this widget.
	 * @param context
	 *            the context of the OCL expression.
	 * @param returnType
	 *            the type that the OCL expression must return.
	 * @param initialQuery
	 *            the initial {@link OclQuery} if there is one (can be null).
	 * @param facet
	 */
	public OclQueryWidget(final Composite parent,
			final PropertyElement oclExpressionProp,
			final IQueryContext queryContext) {
		super(parent);
		this.queryContext = queryContext;
		this.oclExpressionProp = oclExpressionProp;
	}

	@Override
	protected void addSubWidgets() {
		final EClassifier extendedEClass = this.queryContext
				.getExtendedEClass();
		addSubWidget(new PrintQueryContextWidget(this,
				new PropertyElement2<EClassifier>(false, extendedEClass)));
		final EClassifier returnType = this.queryContext.getReturnType();
		addSubWidget(new PrintQueryReturnTypeWidget(this,
				new PropertyElement2<EClassifier>(false, returnType)));
		String expression;
		final Query initialQuery = this.queryContext.getQuery();
		if (initialQuery instanceof OclQuery) {
			final OclQuery oclQuery = (OclQuery) initialQuery;
			expression = oclQuery.getOclExpression();
		} else {
			expression = (String) this.oclExpressionProp.getValue();
		}
		this.oclExprWidget = new OclExpressionWidgetSimple(this,
				extendedEClass, expression, this.oclExpressionProp);
		addSubWidget(this.oclExprWidget);
	}

	@Override
	public Command getCommand() {
		// This widget doesn't create any command.
		return null;
	}

	@Override
	public void notifyChanged() {
		// Nothing to do.
	}

	@Override
	public void onDialogValidation() {
		// Nothing
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.emf.facet.query.ocl.sdk.ui.internal.widget.query.IOclQueryWidget#setExpression(java.lang.String)
	 */
	public void setExpression(final String expression) {
		this.oclExprWidget.setExpression(expression);
	}
}
