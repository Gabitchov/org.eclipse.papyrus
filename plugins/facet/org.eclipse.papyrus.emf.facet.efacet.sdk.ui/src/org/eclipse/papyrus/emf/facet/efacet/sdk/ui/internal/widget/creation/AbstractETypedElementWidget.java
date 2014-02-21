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
package org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.creation;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IETypedElementWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.component.metaclass.GetElementTypeWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.component.properties.GetOrderedWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.component.properties.GetUniqueWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.component.properties.bounds.GetLowerBoundWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.component.properties.bounds.GetUpperBoundWidget;
import org.eclipse.emf.facet.util.emf.ui.internal.exported.wizard.ISelectETypeWizard;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * Abstract widget implement {@link IETypedElementWidget}.
 */
public abstract class AbstractETypedElementWidget<T extends ETypedElement, C extends EObject, CW extends Object>
		extends AbstractENamedElementWidget<T, C, CW>
		implements
		IETypedElementWidget<C, CW> {

	private static final int HORIZ_SPACING = 110;
	private static final int COLUMN_NUMBER = 3;

	private final PropertyElement2<Integer> lowerBdProperty;
	private final PropertyElement2<Integer> upperBdProperty;
	private final PropertyElement2<EClassifier> typeProperty;
	private final PropertyElement2<Boolean> orderedProperty;
	private final PropertyElement2<Boolean> uniqueProperty;

	private GetLowerBoundWidget lowerBoundWidget;
	private GetUpperBoundWidget upperBoundWidget;
	private GetElementTypeWidget elementTypeWidget;
	private GetOrderedWidget orderedWidget;
	private GetUniqueWidget uniqueWidget;
	private Composite composite;

	public AbstractETypedElementWidget(final Composite parent,
			final EditingDomain editingDomain,
			final PropertyElement2<C> containerProperty,
			final PropertyElement2<String> nameProperty,
			final PropertyElement2<Integer> lowerBdProperty,
			final PropertyElement2<Integer> upperBdProperty,
			final PropertyElement2<EClassifier> typeProperty,
			final PropertyElement2<Boolean> orderedProperty,
			final PropertyElement2<Boolean> uniqueProperty) {
		super(parent, editingDomain, containerProperty, nameProperty);
		this.lowerBdProperty = lowerBdProperty;
		this.upperBdProperty = upperBdProperty;
		this.typeProperty = typeProperty;
		this.orderedProperty = orderedProperty;
		this.uniqueProperty = uniqueProperty;
	}

	@Override
	protected void addSubWidgets() {
		super.addSubWidgets();
		this.lowerBoundWidget = new GetLowerBoundWidget(this,
				this.lowerBdProperty);
		addSubWidget(this.lowerBoundWidget);
		this.upperBoundWidget = new GetUpperBoundWidget(this,
				this.upperBdProperty);
		addSubWidget(this.upperBoundWidget);
		this.elementTypeWidget = new GetElementTypeWidget(this,
				this.typeProperty, null, this.getETypeSelectionOption());
		addSubWidget(this.elementTypeWidget);
		this.composite = new Composite(this, SWT.NONE);
		final GridLayout gridLayout = new GridLayout(COLUMN_NUMBER, false);
		gridLayout.horizontalSpacing = HORIZ_SPACING;
		gridLayout.marginWidth = 0;
		this.composite.setLayout(gridLayout);
		this.orderedWidget = new GetOrderedWidget(this.composite,
				this.orderedProperty);
		addSubWidget(this.orderedWidget);
		this.uniqueWidget = new GetUniqueWidget(this.composite,
				this.uniqueProperty);
		addSubWidget(this.uniqueWidget);
	}

	protected final Composite getComposite() {
		return this.composite;
	}

	/**
	 * @return the type selection option.
	 */
	protected abstract Class<? extends EClassifier> getETypeSelectionOption();

	/**
	 * @return the lowerBoundProperty
	 */
	protected final PropertyElement2<Integer> getLowerBoundProperty() {
		return this.lowerBdProperty;
	}

	/**
	 * @return the upperBoundProperty
	 */
	protected final PropertyElement2<Integer> getUpperBoundProperty() {
		return this.upperBdProperty;
	}

	/**
	 * @return the typeProperty
	 */
	protected final PropertyElement2<EClassifier> getTypeProperty() {
		return this.typeProperty;
	}

	/**
	 * @return the orderedProperty
	 */
	protected final PropertyElement2<Boolean> getOrderedProperty() {
		return this.orderedProperty;
	}

	/**
	 * @return the uniqueProperty
	 */
	protected final PropertyElement2<Boolean> getUniqueProperty() {
		return this.uniqueProperty;
	}

	public boolean isOrdered() {
		return this.orderedWidget.isSelected();
	}

	public void setOrdered(final boolean value) {
		this.orderedWidget.setPropertyEnabled(value);
	}

	public boolean isUnique() {
		return this.uniqueWidget.isSelected();
	}

	public void setUnique(final boolean value) {
		this.uniqueWidget.setPropertyEnabled(value);
	}

	public int getLowerBound() {
		return this.lowerBoundWidget.getBoundValue();
	}

	public void setLowerBound(final int value) {
		this.lowerBoundWidget.setBoundValue(value);
	}

	public int getUpperBound() {
		return this.upperBoundWidget.getBoundValue();
	}

	public void setUpperBound(final int value) {
		this.upperBoundWidget.setBoundValue(value);
	}

	public EClassifier getEType() {
		return this.typeProperty.getValue2();
	}

	public void setEType(final EClassifier value) {
		this.typeProperty.setValue(value);
	}

	public ISelectETypeWizard<EClassifier> pressTypeButton() {
		return this.elementTypeWidget.pressButton();
	}

	public String getElementTypeName() {
		return this.elementTypeWidget.getText();
	}
}
