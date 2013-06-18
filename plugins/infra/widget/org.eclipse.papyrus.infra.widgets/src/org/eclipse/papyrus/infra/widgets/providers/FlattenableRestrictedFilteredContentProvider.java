/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.providers;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.widgets.messages.Messages;
import org.eclipse.papyrus.infra.widgets.selectors.ReferenceSelector;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * 
 * @author JC236769
 * 
 */
public class FlattenableRestrictedFilteredContentProvider extends AbstractFilteredContentProvider implements IStaticContentProvider, IRestrictedContentProvider, IFlattenableContentProvider {

	private boolean isFlat = false;

	private ReferenceSelector selector;

	protected IRestrictedContentProvider provider;

	protected HierarchicToFlatContentProvider flatProvider;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param provider
	 *        the encapsulated content provider
	 * @param selector
	 *        the reference selector (we need it to refresh it)
	 */
	public FlattenableRestrictedFilteredContentProvider(IRestrictedContentProvider provider, ReferenceSelector selector) {
		this.provider = provider;
		flatProvider = new HierarchicToFlatContentProvider(provider);
		this.selector = selector;
	}

	/**
	 * Add 2 checkboxes to the dialog
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.providers.AbstractFilteredContentProvider#createAfter(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 */
	@Override
	public void createAfter(final Composite parent) {

		super.createAfter(parent);
		Composite checkboxSection = new Composite(parent, SWT.NONE);
		checkboxSection.setLayout(new FillLayout(SWT.VERTICAL));
		final Button onlyCurrentContainersCheckbox = new Button(checkboxSection, SWT.CHECK);
		onlyCurrentContainersCheckbox.setText(Messages.FlattenableRestrictedFilteredContentProvider_AllPossibleContentsMessage);

		final Button showFlatListOfFeaturesCheckbox = new Button(checkboxSection, SWT.CHECK);
		showFlatListOfFeaturesCheckbox.setText(Messages.FlattenableRestrictedFilteredContentProvider_FlatViewMessage);
		onlyCurrentContainersCheckbox.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				setRestriction(!onlyCurrentContainersCheckbox.getSelection());
				viewer.refresh();
				selector.refresh();
			}

			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});
		showFlatListOfFeaturesCheckbox.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {

				setFlat(showFlatListOfFeaturesCheckbox.getSelection());
				viewer.refresh();
				selector.refresh();

			}

			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});
	}

	public Object[] getElements(Object inputElement) {
		if(isFlat) {
			return flatProvider.getElements(inputElement);
		}
		return provider.getElements(inputElement);
	}

	@Override
	public void dispose() {
		flatProvider.dispose();
		provider.dispose();
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		super.inputChanged(viewer, oldInput, newInput);
		flatProvider.inputChanged(viewer, oldInput, newInput);
		provider.inputChanged(viewer, oldInput, newInput);
	}

	public boolean isValidValue(Object element) {
		return provider.isValidValue(element);
	}

	public Object[] getChildren(Object parentElement) {
		if(isFlat) {
			return new Object[0];
		}
		return provider.getChildren(parentElement);
	}

	public Object getParent(Object element) {
		if(isFlat) {
			return null;
		}
		return provider.getParent(element);
	}

	public boolean hasChildren(Object element) {
		if(isFlat) {
			return false;
		}
		return provider.hasChildren(element);
	}

	public void setRestriction(boolean isRestricted) {
		provider.setRestriction(isRestricted);
	}

	public void setFlat(boolean flat) {
		this.isFlat = flat;

	}

	public Object[] getElements() {
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.providers.IInheritedElementContentProvider#setIgnoreInheritedElements(boolean)
	 *
	 * @param ignoreInheritedElements
	 */
	@Override
	public void setIgnoreInheritedElements(boolean ignoreInheritedElements) {
		provider.setIgnoreInheritedElements(ignoreInheritedElements);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.providers.IInheritedElementContentProvider#isIgnoringInheritedElements()
	 *
	 * @return
	 */
	@Override
	public boolean isIgnoringInheritedElements() {
		return provider.isIgnoringInheritedElements();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.providers.IRestrictedContentProvider#isRestricted()
	 *
	 * @return
	 */
	@Override
	public boolean isRestricted() {
		return provider.isRestricted();
	}

}
