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
package org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.widget.creation;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.IEStructuralFeatureWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.widget.component.properties.GetChangeableWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.widget.component.properties.GetDerivedWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.widget.component.properties.GetTransientWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.widget.component.properties.GetVolatileWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * Abstract widget implementing {@link IEStructuralFeatureWidget}.
 */
public abstract class AbstractEStructuralFeatureWidget<T extends DerivedTypedElement>
		extends AbstractDerivedTypedElementWidget<T> implements
		IEStructuralFeatureWidget {

	private final DerivedTypedElement dte;
	private final PropertyElement2<Boolean> volatileProperty;
	private final PropertyElement2<Boolean> changeProperty;
	private final PropertyElement2<Boolean> derivedProperty;
	private final PropertyElement2<Boolean> transientProperty;

	private GetVolatileWidget volatileWidget;
	private GetChangeableWidget changeableWidget;
	private GetDerivedWidget derivedWidget;
	private GetTransientWidget transientWidget;

	public AbstractEStructuralFeatureWidget(final DerivedTypedElement dte,
			final Composite parent,
			final EditingDomain editingDomain,
			final PropertyElement2<Facet> facetProperty,
			final PropertyElement2<String> nameProperty,
			final PropertyElement2<Integer> lowerBdProperty,
			final PropertyElement2<Integer> upperBdProperty,
			final PropertyElement2<EClassifier> typeProperty,
			final PropertyElement2<Boolean> orderedProperty,
			final PropertyElement2<Boolean> uniqueProperty,
			final PropertyElement2<Query> queryProperty,
			final PropertyElement2<Boolean> volatileProperty,
			final PropertyElement2<Boolean> changeProperty,
			final PropertyElement2<Boolean> derivedProperty,
			final PropertyElement2<Boolean> transientProperty) {
		super(parent, editingDomain, facetProperty, nameProperty,
				lowerBdProperty, upperBdProperty, typeProperty,
				orderedProperty, uniqueProperty, queryProperty);
		this.dte = dte;
		this.volatileProperty = volatileProperty;
		this.changeProperty = changeProperty;
		this.derivedProperty = derivedProperty;
		this.transientProperty = transientProperty;
	}

	@Override
	protected void addSubWidgets() {
		super.addSubWidgets();
		this.volatileWidget = new GetVolatileWidget(getComposite(),
				this.volatileProperty);
		addSubWidget(this.volatileWidget);
		this.changeableWidget = new GetChangeableWidget(getComposite(),
				this.changeProperty);
		addSubWidget(this.changeableWidget);
		this.derivedWidget = new GetDerivedWidget(getComposite(),
				this.derivedProperty);
		addSubWidget(this.derivedWidget);
		this.transientWidget = new GetTransientWidget(getComposite(),
				this.transientProperty);
		addSubWidget(this.transientWidget);
	}

	@Override
	public Command getCommand() {
		return this.getCommandFactory()
				.createEditFacetStructuralFeatureCommand(this.dte,
						this.getContainer(), this.getElementName(),
						this.getLowerBoundProperty().getValue2().intValue(),
						this.getUpperBoundProperty().getValue2().intValue(),
						this.getTypeProperty().getValue2(),
						this.getOrderedProperty().getValue2().booleanValue(),
						this.getUniqueProperty().getValue2().booleanValue(),
						this.getQueryPropertyValue(),
						this.volatileProperty.getValue2().booleanValue(),
						this.changeProperty.getValue2().booleanValue(),
						this.derivedProperty.getValue2().booleanValue(),
						this.transientProperty.getValue2().booleanValue());
	}
	public boolean isTransient() {
		return this.transientWidget.isSelected();
	}
	public void setTransient(final boolean value) {
		this.transientWidget.setPropertyEnabled(value);
	}

	public boolean isVolatile() {
		return this.volatileWidget.isSelected();
	}

	public void setVolatile(final boolean value) {
		this.volatileWidget.setPropertyEnabled(value);
	}

	public boolean isChangeable() {
		return this.changeableWidget.isSelected();
	}

	public void setChangeable(final boolean value) {
		this.changeableWidget.setPropertyEnabled(value);
	}

	public boolean isDerived() {
		return this.derivedWidget.isSelected();
	}

	public void setDerived(final boolean value) {
		this.derivedWidget.setPropertyEnabled(value);
	}
}
