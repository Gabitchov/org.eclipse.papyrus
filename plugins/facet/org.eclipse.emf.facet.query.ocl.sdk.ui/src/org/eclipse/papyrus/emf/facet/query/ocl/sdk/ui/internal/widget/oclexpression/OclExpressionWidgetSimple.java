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
package org.eclipse.papyrus.emf.facet.query.ocl.sdk.ui.internal.widget.oclexpression;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.papyrus.emf.facet.query.ocl.core.util.OclQueryUtil;
import org.eclipse.papyrus.emf.facet.query.ocl.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.query.ocl.sdk.ui.widget.oclexpression.IOCLExpressionWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.AbstractWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement;
import org.eclipse.ocl.ParserException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * Simple widget for the edition of a complexe OCl expression.
 */
public class OclExpressionWidgetSimple extends AbstractWidget implements
		IOCLExpressionWidget {

	private static final String UNREC_VAR = "Unrecognized variable"; //$NON-NLS-1$
	private static final int TEXT_HEIGHT = 100;
	private final EClassifier context;
	private final String expression;
	private Text text;
	private final PropertyElement oclExpressionProp;

	public OclExpressionWidgetSimple(final Composite parent,
			final EClassifier context, final String expression,
			final PropertyElement oclExpressionProp) {
		super(parent);
		this.context = context;
		this.expression = expression;
		this.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		this.oclExpressionProp = oclExpressionProp;
	}

	@Override
	protected void addSubWidgets() {
		this.text = new Text(this, SWT.MULTI | SWT.V_SCROLL);
		final GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.heightHint = TEXT_HEIGHT;
		this.text.setLayoutData(gridData);

		if (this.expression != null) {
			this.text.setText(this.expression);
		}
	}

	@Override
	public String getError() {
		String result = null;

		final String textExpression = this.text.getText().trim();
		if ("".equals(textExpression)) { //$NON-NLS-1$
			result = Messages.OclExpression_Error;
		} else {
			try {
				OclQueryUtil.createOCLExpression(this.context, textExpression);
				this.oclExpressionProp.setValue(textExpression);
			} catch (final ParserException exception) {
				if (exception.getMessage().contains(UNREC_VAR)) {
					this.oclExpressionProp.setValue(textExpression);
				} else {
					result = Messages.OclExpression_Error
							+ " :\n - " + exception.getMessage(); //$NON-NLS-1$
				}
			}
		}

		return result;
	}

	@Override
	public void notifyChanged() {
		// Nothing to do.
	}

	public void setExpression(final String expression) {
		this.text.setText(expression);
	}

}
