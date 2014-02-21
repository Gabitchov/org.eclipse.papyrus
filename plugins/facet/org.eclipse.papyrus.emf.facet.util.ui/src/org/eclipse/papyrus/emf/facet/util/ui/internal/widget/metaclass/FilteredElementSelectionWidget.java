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
 */
package org.eclipse.emf.facet.util.ui.internal.widget.metaclass;

import org.eclipse.emf.facet.util.ui.internal.Messages;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.AbstractWidget;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.FilteredList;

/**
 * A control for selecting an element from a list of elements, that can be
 * filtered using the associated text field.
 */
public class FilteredElementSelectionWidget extends
		AbstractWidget {

	private static final String MATCH_PREFIX = "*"; //$NON-NLS-1$
	private static final int FILTER_WIDTH_HINT = 350;

	private Text filterText;
	private FilteredList fFilteredList;
	private final Object[] elements;
	private static final boolean MULTISELECTION = false;

	public FilteredElementSelectionWidget(final Composite parent,
			final Object[] elements) {
		super(parent);
		this.elements = elements.clone();
		final GridData gridData = new GridData(SWT.FILL);
		gridData.widthHint = FILTER_WIDTH_HINT;
		setLayoutData(gridData);
	}

	public void setElements(final Object[] elements) {
		this.fFilteredList.setElements(elements);
	}

	private void createFilteredList(final Composite parent) {
		int multi;
		if (MULTISELECTION) {
			multi = SWT.MULTI;
		} else {
			multi = SWT.SINGLE;
		}
		this.fFilteredList = new FilteredList(parent, SWT.BORDER | SWT.V_SCROLL
				| SWT.H_SCROLL | multi, new LabelProvider(), true, false, true);

		final GridData data = new GridData();
		data.grabExcessVerticalSpace = true;
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = GridData.FILL;
		data.verticalAlignment = GridData.FILL;
		this.fFilteredList.setLayoutData(data);
		this.fFilteredList.setFilter(""); //$NON-NLS-1$
		this.fFilteredList.setElements(this.elements);
	}

	private void createFilterText(final Composite parent) {
		this.filterText = new Text(parent, SWT.BORDER);
		this.filterText
				.setMessage(Messages.FilteredElementSelectionControl_type_filter_text);
		final GridData data = new GridData();
		data.grabExcessVerticalSpace = false;
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = GridData.FILL;
		data.verticalAlignment = GridData.BEGINNING;
		this.filterText.setLayoutData(data);
		this.filterText.addModifyListener(new ModifyListener() {
			public void modifyText(final ModifyEvent event) {
				getfFilteredList().setFilter(
						MATCH_PREFIX + getFilterText().getText());
			}
		});
		this.filterText.addKeyListener(new KeyListener() {

			public void keyPressed(final KeyEvent event) {
				if (event.keyCode == SWT.ARROW_DOWN) {
					getfFilteredList().setFocus();
				}
			}

			public void keyReleased(final KeyEvent event) {
				// nothing
			}
		});
	}

	public Object getFirstSelectedElement() {
		Object result = null;
		final Object[] selection = this.fFilteredList.getSelection();
		if (selection.length > 0) {
			result = selection[0];
		}
		return result;
	}

	public Object[] getSelectedElements() {
		Object[] result = null;
		final Object[] selection = this.fFilteredList.getSelection();
		if (selection.length != 0) {
			result = selection;
		}
		return result;
	}

	public FilteredList getFilteredList() {
		return this.fFilteredList;
	}

	public Text getFilterText() {
		return this.filterText;
	}

	protected FilteredList getfFilteredList() {
		return this.fFilteredList;
	}

	@Override
	protected void addSubWidgets() {
		createFilterText(this);
		createFilteredList(this);
	}

	@Override
	public String getError() {
		return null;
	}

	@Override
	public void notifyChanged() {
		// No action has to be done if a change appends.
	}
}
