/**
 * Copyright (c) 2011 Mia-Software.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Nicolas Guyomar (Mia-Software) - Bug 349546 - EMF Facet facetSet editor
 *  Gregoire Dupe (Mia-Software) - Bug 373248 - Clean PMD errors
 */
package org.eclipse.emf.facet.efacet.ui.internal.composites;

import org.eclipse.emf.facet.efacet.core.internal.query.QueryEvaluatorFactoryRegistry;
import org.eclipse.emf.facet.efacet.core.query.IQueryEvaluatorFactory;
import org.eclipse.emf.facet.efacet.ui.internal.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

@SuppressWarnings("PMD.ConstructorCallsOverridableMethod")
//@SuppressWarnings("PMD.ConstructorCallsOverridableMethod") This class is
//deprecated, we won't then spend to many time to conforms to PMD rules.
@Deprecated
//TODO @Deprecated must be removed after a refactoring planed by https://bugs.eclipse.org/bugs/show_bug.cgi?id=364601
public class SelectQueryTypeComposite extends Composite {

	private Combo queryTypeComboBox;
	private Label queryTypeLabel;
	private static final int NUMBER_COLUMN = 3;

	public SelectQueryTypeComposite(final Composite parent, final int style) {
		super(parent, style);
		init();
	}

	@Override
	public void setEnabled(final boolean visible) {
		this.queryTypeComboBox.setEnabled(visible);
		this.queryTypeLabel.setEnabled(visible);
	}

	private void init() {
		GridLayout gridLayout = new GridLayout(SelectQueryTypeComposite.NUMBER_COLUMN, false);
		setLayout(gridLayout);
		createCompositeWidget();
		initializeWidgets();
	}

	protected void createCompositeWidget() {
		this.queryTypeLabel = new Label(this, SWT.NONE);
		this.queryTypeComboBox = new Combo(this, SWT.DROP_DOWN | SWT.READ_ONLY);
	}

	private void initializeWidgets() {
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);

		this.queryTypeLabel.setText(Messages.SelectQueryTypeWizardPage_Query_Type);
		this.queryTypeComboBox.setLayoutData(gd);

		for (IQueryEvaluatorFactory factory : QueryEvaluatorFactoryRegistry.INSTANCE.getInstalledQueryFactories()) {
			this.queryTypeComboBox.add(factory.getManagedQueryType().getName());
		}
		this.queryTypeComboBox.select(0);
		this.queryTypeComboBox.addSelectionListener(new SelectionListener() {
			public void widgetSelected(final SelectionEvent e) {
				queryTypeSelected();
			}

			public void widgetDefaultSelected(final SelectionEvent e) {
				// Nothing
			}
		});
	}

	protected void queryTypeSelected() {
		// Intended to be overridden
	}

	protected void setQueryTypeLabel(final Label queryTypeLabel) {
		this.queryTypeLabel = queryTypeLabel;
	}

	protected void setQueryTypeComboBox(final Combo queryTypeComboBox) {
		this.queryTypeComboBox = queryTypeComboBox;
	}

	public String getSelectedQueryType() {
		if (this.queryTypeComboBox.getSelectionIndex() != -1) {
			return this.queryTypeComboBox.getItem(this.queryTypeComboBox.getSelectionIndex());
		}
		return null;
	}

}
