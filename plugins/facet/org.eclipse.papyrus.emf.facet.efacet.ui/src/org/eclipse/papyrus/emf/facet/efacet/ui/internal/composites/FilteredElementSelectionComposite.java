/*******************************************************************************
 * Copyright (c) 2010, 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.facet.efacet.ui.internal.composites;

import org.eclipse.emf.facet.efacet.ui.internal.Messages;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.FilteredList;

/**
 * A control for selecting an element from a list of elements, that can be filtered using the
 * associated text field.
 */
public class FilteredElementSelectionComposite extends Composite {

	private final Text filterText;
	private final FilteredList fFilteredList;

	public FilteredElementSelectionComposite(final Composite parent, final boolean matchAnywhere, final boolean multiSelection) {
		super(parent, SWT.BORDER);
		setLayout(new GridLayout());

		this.filterText = createFilterText(this);
		this.fFilteredList = createFilteredList(this, multiSelection);

		final String matchPrefix;
		if (matchAnywhere) {
			matchPrefix = "*"; //$NON-NLS-1$
		} else {
			matchPrefix = ""; //$NON-NLS-1$
		}

		this.filterText.addModifyListener(new ModifyListener() {
			public void modifyText(final ModifyEvent e) {
				getfFilteredList().setFilter(matchPrefix + getFilterText().getText());
			}
		});

		this.filterText.addKeyListener(new KeyListener() {
			public void keyPressed(final KeyEvent e) {
				if (e.keyCode == SWT.ARROW_DOWN) {
					getfFilteredList().setFocus();
				}
			}

			public void keyReleased(final KeyEvent e) {
				// nothing
			}
		});
	}

	public void setElements(final Object[] elements) {
		this.fFilteredList.setElements(elements);
	}

	protected static FilteredList createFilteredList(final Composite parent, final boolean multiSelection) {
		int multi;
		if (multiSelection) {
			multi = SWT.MULTI;
		} else {
			multi = SWT.SINGLE;
		}
		final FilteredList filteredList = new FilteredList(parent, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | multi, new LabelProvider(), true,
				false, true);

		final GridData data = new GridData();
		data.grabExcessVerticalSpace = true;
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = GridData.FILL;
		data.verticalAlignment = GridData.FILL;
		filteredList.setLayoutData(data);
		filteredList.setFilter(""); //$NON-NLS-1$

		return filteredList;
	}

	protected static Text createFilterText(final Composite parent) {
		final Text text = new Text(parent, SWT.BORDER);
		text.setMessage(Messages.FilteredElementSelectionControl_type_filter_text);

		final GridData data = new GridData();
		data.grabExcessVerticalSpace = false;
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = GridData.FILL;
		data.verticalAlignment = GridData.BEGINNING;
		text.setLayoutData(data);

		return text;
	}

	public Object getFirstSelectedElement() {
		final Object[] selection = this.fFilteredList.getSelection();
		if (selection.length > 0) {
			return selection[0];
		}
		return null;
	}

	public Object[] getSelectedElements() {
		Object[] selection = this.fFilteredList.getSelection();
		if (selection.length == 0) {
			return null;
		}
		return selection;
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
}
