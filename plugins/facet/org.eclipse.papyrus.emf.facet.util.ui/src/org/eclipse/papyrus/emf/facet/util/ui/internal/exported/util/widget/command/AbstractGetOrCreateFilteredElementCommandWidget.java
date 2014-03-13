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
package org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command;

import java.util.Map;

import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.dialog.AbstractDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.dialog.SynchronizedAbstractDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.component.CreateElementWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.widget.metaclass.FilteredElementSelectionWidget;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * This abstract class allows the user to select or create an element (the
 * concretes classes extending this abstract class will specify the type for
 * this elements).</p>
 * 
 * The widget contains two composite:
 * <nl>
 * <li> {@link FilteredElementSelectionWidget} : display a filtered list with the
 * elements returned by {@link #getElements()}</li>
 * <li> {@link CreateElementWidget} : create a "new..." button, and display the
 * dialog returned by {@link #createDialog()} when clicked</li>
 * </nl>
 * 
 * @see GetOrCreateFacetSetWidget
 * @see GetOrCreateFacetWidget
 * @see GetOrCreateOperationWidget
 * @see FilteredElementSelectionWidget
 * @see CreateElementWidget
 * @since 0.3
 */
public abstract class AbstractGetOrCreateFilteredElementCommandWidget<T extends Object, W extends Object>
		extends AbstractCommandWidget implements IGetOrCreateFilteredElementCommmandWidget<T, W> {

	private static final int COLUMNS_NUMBER = 2;
	private FilteredElementSelectionWidget elementSelection;
	private CreateElementWidget<W> createElementW;

	/**
	 * Constructor. Initialize a new layout containing {@value #COLUMN_NUMBER}
	 * columns.
	 * 
	 * @param parent
	 *            the parent of this widget.
	 * @param editingDomain
	 *            the current editing domain.
	 * @param properties
	 *            the properties.
	 */
	protected AbstractGetOrCreateFilteredElementCommandWidget(
			final Composite parent) {
		super(parent);
		this.setLayout(new GridLayout(COLUMNS_NUMBER, false));
	}

	@Override
	protected void addSubWidgets() {
		final Object[] array = getElements().keySet().toArray();
		this.elementSelection = new FilteredElementSelectionWidget(this, array);
		addSubWidget(this.elementSelection);
		final IDialog<W> dialog = createDialog();
		if (dialog != null) {
			this.createElementW = new CreateElementWidget<W>(this, dialog);
			addSubWidget(this.createElementW);
		}
	}

	/**
	 * This method must return the all the elements that the user can choose
	 * (with the name to display has the key to the map). The method
	 * {@link #getSuperFacetSet(Object)} can be useful.
	 * 
	 * @return a map of the elements to display.
	 */
	protected abstract Map<String, T> getElements();

	/**
	 * @return the dialog that the "New..." button of this widget will open.
	 *         Null if you want no "New..." button.
	 * 
	 * @see AbstractDialog
	 */
	protected abstract IDialog<W> createDialog();

	/**
	 * Update the filtered list. The list will be updated with the elements
	 * returned by {@link #getElements()}.
	 */
	public void updateFilteredList() {
		this.elementSelection.setElements(getElements().keySet().toArray());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget#getElementSelected()
	 */
	public T getElementSelected() {
		T result = null;
		final Object selectedElement = this.elementSelection
				.getFirstSelectedElement();
		if (selectedElement != null) {
			final String elementName = selectedElement.toString();
			result = getElements().get(elementName);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget#selectElement(T)
	 */
	public void selectElement(final T element) {
		Object[] selectionsParam = new Object[1];
		for (String key : getElements().keySet()) {
			if (getElements().get(key) == element) {
				selectionsParam[0] = key;
				this.elementSelection.getFilteredList().setSelection(
						selectionsParam);
				break;
			}
		}
	}

	public void selectElementByName(final String name) {
		final T element = this.getElements().get(name);
		selectElement(element);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget#pressNewButton()
	 */
	public IDialog<W> pressNewButton() {
		return new SynchronizedAbstractDialog<W>(
				this.createElementW.pressNewButton(), this.getDisplay());
	}
}
