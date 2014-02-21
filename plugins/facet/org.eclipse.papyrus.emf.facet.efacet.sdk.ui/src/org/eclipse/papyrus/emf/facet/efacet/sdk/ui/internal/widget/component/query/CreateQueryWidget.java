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
package org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.widget.component.query;

import org.eclipse.emf.common.command.Command;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.IQueryContext;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.IQueryDialogFactoryStrategy;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.component.query.ICreateQueryWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.query.AbstractQueryDialogFactory;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.AbstractCommandWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.widget.IAbstractWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement;
import org.eclipse.swt.widgets.Composite;

/**
 * This widget is the base of the query creation widget.</p>
 * 
 * The name, canBeCashed and canHavSideEffects are originally present and the
 * others properties needed by the query are returned by the concrete widget
 * returned by {@link AbstractQueryDialogFactory#createWidget()}.
 * 
 * @see AbstractQueryDialogFactory
 */
public class CreateQueryWidget extends AbstractCommandWidget implements
		ICreateQueryWidget {

	private final IQueryDialogFactoryStrategy strategy;
	// Widgets
	private GetCanBeCachedWidget canBeCachedWidget;
	private GetCanHaveSideEffectsWidget sideEffectsWidget;
	private IAbstractWidget queryWidget;
	// Properties
	private final PropertyElement canBeCachedProp;
	private final PropertyElement sideEffectsProp;
	private final IQueryContext queryContext;


	public CreateQueryWidget(final Composite parent,
			final IQueryDialogFactoryStrategy strategy,
			final PropertyElement canBeCachedProp,
			final PropertyElement sideEffectsProp,
			final IQueryContext queryContext) {
		super(parent);
		this.strategy = strategy;
		this.canBeCachedProp = canBeCachedProp;
		this.sideEffectsProp = sideEffectsProp;
		this.queryContext = queryContext;
	}

	@Override
	public Command getCommand() {
		return null;
	}

	@Override
	protected void addSubWidgets() {
		this.canBeCachedWidget = new GetCanBeCachedWidget(this,
				this.canBeCachedProp);
		addSubWidget(this.canBeCachedWidget);
		this.sideEffectsWidget = new GetCanHaveSideEffectsWidget(this,
				this.sideEffectsProp);
		addSubWidget(this.sideEffectsWidget);
		this.queryWidget = this.strategy.createWidget(this, this.queryContext);
		addSubWidget(this.queryWidget);
	}

	@Override
	public void notifyChanged() {
		// No action has to be done if a change appends.
	}

	@Override
	public void onDialogValidation() {
		// Nothing.
	}

	/**
	 * @return CanBeCached value.
	 */
	public boolean isCanBeCached() {
		return this.canBeCachedWidget.isSelected();
	}

	/**
	 * @return HasSideEffect value.
	 */
	public boolean isHasSideEffect() {
		return this.sideEffectsWidget.isSelected();
	}

	public IAbstractWidget getCreateQueryWidget() {
		return this.queryWidget;
	}

}
