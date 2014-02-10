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
package org.eclipse.emf.facet.efacet.sdk.ui.internal.query;

import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.dialog.AbstractCommandDialog;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.IQueryContext;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.IQueryDialogFactoryStrategy;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.component.query.ICreateQueryWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.sync.generated.SynchronizedCreateQueryWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.component.query.CreateQueryWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IWithResultDialogCallback;
import org.eclipse.emf.facet.util.ui.internal.exported.widget.IAbstractWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;

/**
 * This class provide the dialog for the creation of the specific dialog
 * according of the type of the query selected.
 * 
 * To run, this class needs to have into the properties pass in the constructor:
 * <p>
 * <li>The {@link PropertyElement} <code>name</code> with the key
 * <code>EcorePackage.eINSTANCE.getENamedElement_Name()</code></li>
 * </p>
 * <li>The {@link PropertyElement} <code>type</code> with the key
 * <code>EcorePackage.eINSTANCE.getETypedElement_EType()</code></li> </p> <li>
 * The {@link PropertyElement} <code>parent</code> (a {@link Facet}) with the
 * key <code>EcorePackage.eINSTANCE.getEObject__EContainer()</code></li> </p>
 */
public class GetQueryDialog extends
		AbstractCommandDialog<IWithResultDialogCallback<IQueryCreationResult>, ICreateQueryWidget> {

	private final PropertyElement2<Boolean> canBeCachedProp;
	private final PropertyElement2<Boolean> sideEffectsProp;
	private CreateQueryWidget createQueryWidget;
	private boolean valid;
	private final IQueryDialogFactoryStrategy strategy;
	private final IQueryContext queryContext;

	/**
	 * 
	 * @param callback
	 *            the callback.
	 * @param properties
	 *            properties that parent widget had.
	 * @param propertyElement
	 *            the {@link PropertyElement} containing the query
	 * @param qDialogFactoryStrategiy
	 *            an instance of {@link AbstractQueryDialogFactory} needed to
	 *            create the dialog
	 * @param query
	 */
	public GetQueryDialog(
			final IWithResultDialogCallback<IQueryCreationResult> callback,
			final IQueryDialogFactoryStrategy strategy,
			final IQueryContext queryContext) {
		super(callback);
		this.canBeCachedProp = new PropertyElement2<Boolean>(true);
		this.canBeCachedProp.setValue(Boolean.FALSE);
		this.sideEffectsProp = new PropertyElement2<Boolean>(true);
		this.sideEffectsProp.setValue(Boolean.FALSE);
		this.strategy = strategy;
		this.queryContext = queryContext;
	}

	@Override
	public ICreateQueryWidget createWidget() {
		this.createQueryWidget = new CreateQueryWidget(
				this.getDialogComposite(), this.strategy, this.canBeCachedProp,
				this.sideEffectsProp, this.queryContext);
		return new SynchronizedCreateQueryWidget(this.createQueryWidget,
				this.createQueryWidget.getDisplay());
	}

	@Override
	protected String getDialogMessage() {
		return this.strategy.getDialogMessage();
	}

	@Override
	protected String getDialogTitle() {
		return this.strategy.getDialogTitle();
	}

	@Override
	protected void okPressed() {
		this.valid = isValid();
		if (this.valid) {
			final boolean sideEffects = this.sideEffectsProp.getValue2()
					.booleanValue();
			final boolean canBeCashed = this.canBeCachedProp.getValue2()
					.booleanValue();
			final Query query = this.strategy.createQuery(canBeCashed,
					sideEffects, this.queryContext);
			final IWithResultDialogCallback<IQueryCreationResult> callback = getCallback();
			callback.commited(new IQueryCreationResult() {
				public Query getQuery() {
					return query;
				}

				public String getLabel() {
					return GetQueryDialog.this.getConclusionText();
				}
			});
		}
		super.okPressed();
	}

	@Override
	protected void cancelPressed() {
		final IWithResultDialogCallback<IQueryCreationResult> callback = getCallback();
		callback.canceled(null);
		super.cancelPressed();
	}

	@Override
	public boolean isDialogValid() {
		return this.valid;
	}

	private boolean isValid() {
		boolean result = true;
		final String error = getWidget().getError();
		if (error != null) {
			result = false;
		}
		return result;
	}

	public String getConclusionText() {
		return this.strategy.getConclusionText();
	}


	public boolean isCanBeCached() {
		return this.createQueryWidget.isCanBeCached();
	}

	public boolean isHasSideEffect() {
		return this.createQueryWidget.isHasSideEffect();
	}

	public IAbstractWidget getCreateQueryWidget() {
		return this.createQueryWidget.getCreateQueryWidget();
	}

	public IAbstractWidget createSubWidget() {
		return this.strategy.createWidget(this.getDialogComposite(),
				this.queryContext);
	}

}
