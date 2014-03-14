/*******************************************************************************
 * Copyright (c) 2010, 2011, 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.composite;

import org.eclipse.papyrus.emf.facet.util.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.composite.IFilteredElementSelectionComposite;
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
 * A control for selecting an element from a list of elements, that can be
 * filtered using the associated text field.
 * 
 * @since 0.3
 */
public class FilteredElementSelectionComposite extends Composite implements
		IFilteredElementSelectionComposite {

	private final Text filterText;
	private final FilteredList fFilteredList;
	private String matchPrefix;

	public FilteredElementSelectionComposite(final Composite parent,
			final boolean matchAnywhere, final boolean multiSelection) {
		super(parent, SWT.BORDER);
		setLayout(new GridLayout());

		this.filterText = createFilterText(this);
		this.fFilteredList = createFilteredList(this, multiSelection);

		this.filterText.addModifyListener(new ModifyListener() {
			public void modifyText(final ModifyEvent event) {
				getfFilteredList().setFilter(
						getMatchPrefix(matchAnywhere)
								+ getFilterText().getText());
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

	protected String getMatchPrefix(final boolean matchAnywhere) {
		if (matchAnywhere) {
			this.matchPrefix = "*"; //$NON-NLS-1$
		} else {
			this.matchPrefix = ""; //$NON-NLS-1$
		}
		return this.matchPrefix;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.composite.
	 * IFilteredElementSelectionComposite#setElements(java.lang.Object[])
	 */
	public void setElements(final Object[] elements) {
		this.fFilteredList.setElements(elements);
	}

	protected static FilteredList createFilteredList(final Composite parent,
			final boolean multiSelection) {
		int multi;
		if (multiSelection) {
			multi = SWT.MULTI;
		} else {
			multi = SWT.SINGLE;
		}
		final FilteredList filteredList = new FilteredList(parent, SWT.BORDER
				| SWT.V_SCROLL | SWT.H_SCROLL | multi, new LabelProvider(),
				true, false, true);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.composite.
	 * IFilteredElementSelectionComposite#getFirstSelectedElement()
	 */
	public Object getFirstSelectedElement() {
		Object result = null;
		final Object[] selection = this.fFilteredList.getSelection();
		if (selection.length > 0) {
			result = selection[0];
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.composite.
	 * IFilteredElementSelectionComposite#getSelectedElements()
	 */
	public Object[] getSelectedElements() {
		Object[] result = null;
		if (this.fFilteredList.getSelection().length > 0) {
			result = this.fFilteredList.getSelection();
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.composite.
	 * IFilteredElementSelectionComposite#getFilteredList()
	 */
	public FilteredList getFilteredList() {
		return this.fFilteredList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.composite.
	 * IFilteredElementSelectionComposite#getFilterText()
	 */
	public Text getFilterText() {
		return this.filterText;
	}

	protected FilteredList getfFilteredList() {
		return this.fFilteredList;
	}
}
