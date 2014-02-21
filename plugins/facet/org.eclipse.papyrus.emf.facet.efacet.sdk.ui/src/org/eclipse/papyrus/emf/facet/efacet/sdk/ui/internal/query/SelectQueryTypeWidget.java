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
package org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.query;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.IQueryContext;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.IQueryDialogFactoryStrategy;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.component.query.ICreateQueryWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IWithResultDialogCallback;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.dialog.SynchronizedAbstractDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.AbstractWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement;
import org.eclipse.papyrus.emf.facet.util.ui.utils.UIUtils;
import org.eclipse.papyrus.emf.facet.util.ui.utils.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

/**
 * Provide the composite for the query type selection.</p>
 * 
 * Label : [ combobox ] [ TextField ]
 * 
 * When the user select a {@link AbstractQueryDialogFactory}, the associated
 * dialog {@link GetQueryDialog} is created (with the method
 * {@link #createQueryWidgetDialog(AbstractQueryDialogFactory)} using the
 * attributes of the query type) and displayed.
 * 
 * @see Query
 * @see AbstractQueryDialogFactory
 * @see GetQueryDialog
 */
public class SelectQueryTypeWidget extends AbstractWidget {

	private static final int COLUMN_NUMBER = 2;
	private Combo combobox;
	private final PropertyElement queryProp;
	private Text textField;
	private final GridLayout gridLayout;
	private String alertMessage;
	private final boolean comboboxEnabled;
	private final IQueryContext queryContext;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of the composite.
	 * @param properties
	 *            the {@link WidgetProperties} of the parent.
	 * @param queryProp
	 *            the property element that this composite will edit.
	 */
	public SelectQueryTypeWidget(final Composite parent,
			final PropertyElement propertyElement,
			final IQueryContext queryContext) {
		this(parent, propertyElement, false, queryContext);
	}

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of the composite.
	 * @param properties
	 *            the {@link WidgetProperties} of the parent.
	 * @param queryProp
	 *            the property element that this composite will edit.
	 */
	public SelectQueryTypeWidget(final Composite parent,
			final PropertyElement queryProperty, final boolean comboboxEnabled,
			final IQueryContext queryContext) {
		super(parent);
		this.queryProp = queryProperty;
		this.comboboxEnabled = comboboxEnabled;
		this.gridLayout = new GridLayout(COLUMN_NUMBER, false);
		this.gridLayout.marginWidth = 0;
		this.queryContext = queryContext;
	}

	@Override
	protected void addSubWidgets() {
		final Composite composite = new Composite(this, SWT.NONE);
		composite.setLayout(this.gridLayout);
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		boolean enabled = this.comboboxEnabled;
		if (!this.comboboxEnabled) {
			enabled = this.queryProp.getValue() != null;
		}

		final List<String> elements = new LinkedList<String>();
		elements.add(Messages.Select_query_type);
		elements.addAll(IQueryWidgetCompositeFactoryFactory.INSTANCE
				.getRegisteredQueryWidgetsComposite());
		final SelectionListener listener = new SelectionListener() {

			public void widgetSelected(final SelectionEvent event) {
				onSelection();
			}

			public void widgetDefaultSelected(final SelectionEvent event) {
				// NOTHING
			}
		};
		this.combobox = UIUtils.createCombobox(composite, enabled, elements,
				Messages.SelectQueryTypeWizardPage_Query_Type, listener);
		this.textField = UIUtils.createTextField(composite, "", false, null); //$NON-NLS-1$
		refresh();
	}

	/**
	 * Select the item in the combobox with the name in parameter.
	 * 
	 * @param selection
	 *            the name of the selection.
	 */
	public IDialog<ICreateQueryWidget> selectQueryType(final String selection) {
		IDialog<ICreateQueryWidget> result = null;
		int index = 0;
		for (final String item : this.combobox.getItems()) {
			if (item.equals(selection)) {
				this.combobox.select(index);
				result = onSelection();
				break;
			}
			++index;
		}
		return result;
	}

	@Override
	public String getError() {
		String result = null;

		if (this.queryProp.getValue() == null) {
			result = Messages.Facet_mustSelectQuery;
		}

		return result;
	}

	/**
	 * This method check if the comboBox is enabled and set the default value if
	 * not (combobox selection and textField alert message).
	 */
	private void refresh() {
		this.combobox.select(0);
		if (this.combobox.isEnabled()) {
			if (this.queryProp.getValue() != null) {
				final Query query = (Query) this.queryProp.getValue();
				this.textField.setText(query.toString());
			}
		} else {
			this.queryProp.setValue(null);
			// The alert message has the default color because it's not possible
			// to change the text color if the text field is disabled.
			if (this.alertMessage != null) {
				this.textField.setText(this.alertMessage);
			}
		}
	}

	/**
	 * @param enabled
	 *            set if the selection combobox is enabled or not.
	 */
	public void setSelectionEnabled(final boolean enabled) {
		this.combobox.setEnabled(enabled);
		refresh();
	}

	/**
	 * @return if the combobox is enabled or not.
	 */
	public boolean isSelectionEnabled() {
		return this.combobox.isEnabled();
	}

	/**
	 * Set the alert message that will be displayed if the checkbox is not
	 * checked.
	 * 
	 * @param alertMessage
	 *            the alertMessage to set
	 */
	public void setAlertMessage(final String alertMessage) {
		this.alertMessage = alertMessage;
	}

	/**
	 * The action when an element of the combobox is selected.</p>
	 * 
	 * If the default element is selected, the property value is set to null.
	 */
	protected IDialog<ICreateQueryWidget> onSelection() {
		IDialog<ICreateQueryWidget> result = null;
		final int selectionIndex = this.combobox.getSelectionIndex();
		if (selectionIndex == 0) {
			this.queryProp.setValue(null);
			this.textField.setText(this.alertMessage);
		} else {
			final String selectionName = this.combobox.getItem(selectionIndex);
			final IQueryDialogFactoryStrategy strategy = IQueryWidgetCompositeFactoryFactory.INSTANCE
					.getQueryDialogFactoryStrategy(selectionName);
			final IWithResultDialogCallback<IQueryCreationResult> callback = new IWithResultDialogCallback<IQueryCreationResult>() {
				public void commited(final IQueryCreationResult qcResult) {
					onDialogCommitted(qcResult);
				}

				public void canceled(final IQueryCreationResult qcResult) {
					checkQuery(null);
				}
			};
			final IDialog<ICreateQueryWidget> dialog = new GetQueryDialog(
					callback,
					strategy, this.queryContext);
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					dialog.open();
				}
			});
			result = new SynchronizedAbstractDialog<ICreateQueryWidget>(dialog,
					Display.getDefault());
		}
		return result;
	}

	@Override
	public void notifyChanged() {
		// No action has to be done if a change appends.
	}

	/**
	 * Action to do when the dialog opened with the button "..." is closed with
	 * the "OK" button.
	 */
	protected void onDialogCommitted(final IQueryCreationResult qcResult) {
		if (checkQuery(qcResult.getQuery()) && (qcResult.getLabel() != null)) {
			this.textField.setText(qcResult.getLabel());
		}
	}

	/**
	 * Check if the query is the query exists.
	 * 
	 * @param query
	 * 
	 * @return true if the query exists.
	 */
	protected boolean checkQuery(final Query query) {
		if (query == null) {
			this.combobox.select(0);
			if (this.alertMessage != null) {
				this.textField.setText(this.alertMessage);
			}
		}
		if (query != null) {
			this.queryProp.setValue(query);
		}
		return query != null;
	}

	/**
	 * @return the text of the text associated with the query.
	 */
	public String getText() {
		return this.textField.getText();
	}
}
