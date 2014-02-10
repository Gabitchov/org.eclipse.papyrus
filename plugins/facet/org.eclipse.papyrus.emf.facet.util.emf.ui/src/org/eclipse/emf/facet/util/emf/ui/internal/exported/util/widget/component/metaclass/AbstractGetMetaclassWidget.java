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
package org.eclipse.emf.facet.util.emf.ui.internal.exported.util.widget.component.metaclass;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.facet.util.emf.ui.internal.exported.util.wizard.SelectETypeWizardImpl;
import org.eclipse.emf.facet.util.emf.ui.internal.exported.util.wizard.SynchronizedSelectETypeWizard;
import org.eclipse.emf.facet.util.emf.ui.internal.exported.wizard.ISelectETypeWizard;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.component.getorcreate.AbstractGetOrCreateElementWithWizardButtonWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * This abstract class provides a simple way for the selection of a type.
 * 
 * Label : [ textField ][...] </p>
 * 
 * The button will display the {@link SelectETypeWizardImpl} wizard when
 * pressed. </p>
 * 
 * The {@link #getLabel()} method have to be override and provide the label of
 * the 'Label'.</p>
 * 
 * The {@link #createTextField(boolean)} create a non editable text field.</p>
 * 
 * The {@link #getETypeSelectionOption()} have to be override and type of the
 * selection in the wizard.</p>
 * 
 * If the value of the {@link PropertyElement} is null, then the message
 * returned by {@link #getErrorMessage()} is displayed on the top of the dialog.
 * 
 * @see SelectETypeWizardImpl
 * @see ETypeSelectionOptions
 * 
 * @see GetConformanceMetaclassWidget
 * @see GetElementTypeWidget
 * @see GetExtendedMetaclassWidget
 * @since 0.3
 */
public abstract class AbstractGetMetaclassWidget<T extends EClassifier>
		extends
		AbstractGetOrCreateElementWithWizardButtonWidget<T, ISelectETypeWizard<T>> {

	private final PropertyElement2<? extends EPackage> ePackagePropery;
	private final Class<? extends T> eTypeOption;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param editingDomain
	 *            the current editing domain.
	 * @param typeProperty
	 *            the property element that will be edited by this composite.
	 * @param ePackageProperty
	 *            the property element to get the super, main, element of the
	 *            model.
	 */
	protected AbstractGetMetaclassWidget(final Composite parent,
			final PropertyElement2<T> typeProperty,
			final PropertyElement2<? extends EPackage> ePackageProperty,
			final Class<? extends T> eTypeOption) {
		super(parent, typeProperty);
		this.ePackagePropery = ePackageProperty;
		this.eTypeOption = eTypeOption;
	}

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param editingDomain
	 *            the current editing domain.
	 * @param propertyElement
	 *            the property element that will be edited by this composite.
	 * @param ePackageProperty
	 *            the property element to get the super, main, element of the
	 *            model.
	 * @param buttonEnabled
	 *            boolean to set if the button is enabled or not.
	 */
	protected AbstractGetMetaclassWidget(final Composite parent,
			final PropertyElement2<T> propertyElement,
			final PropertyElement2<EPackage> ePackageProperty,
			final boolean buttonEnabled, final Class<T> eTypeOption) {
		this(parent, propertyElement, ePackageProperty, eTypeOption);
		this.setButtonEnabled(buttonEnabled);
	}

	/**
	 * @return return the label. Null if no label have to be displayed.
	 */
	@Override
	protected abstract String getLabel();

	@Override
	public String getError() {
		String error = null;
		final EClassifier eclassifier = this.getPropertyElement().getValue2();
		if (eclassifier == null) {
			error = getErrorMessage();
		}
		return error;
	}

	@Override
	protected void onWizardCommited(final ISelectETypeWizard<T> wizard) {
		final T eClassifier = wizard.getSelectedEClassifier();
		getPropertyElement().setValue2(eClassifier);
		setText(eClassifier.getName());
		fireChanged();
	}

	@Override
	protected void onWizardCanceled() {
		fireChanged();
	}

	/**
	 * Return the EPackage.
	 * 
	 * @return the ePackage.
	 */
	protected abstract EPackage getEPackage();

	/**
	 * @return the facetSetProperty
	 */
	public PropertyElement2<? extends EPackage> getEPackageProperty() {
		return this.ePackagePropery;
	}

	public void setValue(final T eClassifier) {
		getPropertyElement().setValue2(eClassifier);
	}

	@Override
	protected ISelectETypeWizard<T> createIWizard() {
		final EPackage parent = getEPackage();
		return new SelectETypeWizardImpl<T>(this.eTypeOption, parent);
	}

	@Override
	protected ISelectETypeWizard<T> createSynchronizedWizard(
			final ISelectETypeWizard<T> wizard) {
		return new SynchronizedSelectETypeWizard<T>(wizard,
				this.getDisplay());
	}
}
