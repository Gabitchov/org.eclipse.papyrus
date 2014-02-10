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

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.core.FacetUtils;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.IQueryContext;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IDerivedTypedElementWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IFacetWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.component.query.ICreateQueryWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.query.SelectQueryTypeWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.component.getorcreate.GetOrCreateFacetWidget;
import org.eclipse.emf.facet.util.emf.core.ModelUtils;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * Abstract Widget implementing {@link IDerivedTypedElementWidget}.
 */
public abstract class AbstractDerivedTypedElementWidget<T extends DerivedTypedElement>
		extends
		AbstractETypedElementWidget<T, Facet, IGetOrCreateFilteredElementCommmandWidget<Facet, IFacetWidget>>
		implements
		IDerivedTypedElementWidget {

	private SelectQueryTypeWidget queryTypeWidget;
	private final Facet facet;

	private final PropertyElement2<Query> queryProperty;

	public AbstractDerivedTypedElementWidget(final Composite parent,
			final EditingDomain editingDomain,
			final PropertyElement2<Facet> facetProperty,
			final PropertyElement2<String> nameProperty,
			final PropertyElement2<Integer> lowerBdProperty,
			final PropertyElement2<Integer> upperBdProperty,
			final PropertyElement2<EClassifier> typeProperty,
			final PropertyElement2<Boolean> orderedProperty,
			final PropertyElement2<Boolean> uniqueProperty,
			final PropertyElement2<Query> queryProperty) {
		super(parent, editingDomain, facetProperty, nameProperty,
				lowerBdProperty,
				upperBdProperty, typeProperty, orderedProperty, uniqueProperty);
		this.facet = facetProperty.getValue2();
		this.queryProperty = queryProperty;
	}

	@Override
	protected void addSubWidgets() {
		super.addSubWidgets();
		// Query
		this.queryTypeWidget = new SelectQueryTypeWidget(this,
				this.queryProperty, this.getQueryContext());
		this.queryTypeWidget
				.setAlertMessage(Messages.Query_Select_Name_And_Type);
		addSubWidget(this.queryTypeWidget);
	}
	
	protected final IQueryContext getQueryContext() {
		return new QueryContext(this);
	}

	public SelectQueryTypeWidget getQueryTypeWidgetComposite() {
		return this.queryTypeWidget;
	}

	@Override
	protected GetOrCreateFacetWidget createGetOrCreateElementWidgetComposite() {
		return new GetOrCreateFacetWidget(this, this.getContainerPropery(),
				this.getEditingDomain(), (FacetSet) this.getContainerPropery()
						.getValue2().eContainer());
	}

	@Override
	public void notifyChanged() {
		final Object name = this.getElementNameProperty().getValue();
		final Object type = this.getTypeProperty().getValue();
		final boolean enable = !("".equals(name) || "".equals(type) || type == null); //$NON-NLS-1$ //$NON-NLS-2$
		this.getQueryTypeWidgetComposite().setSelectionEnabled(enable);
	}

	/**
	 * @return the queryProperty
	 */
	public PropertyElement2<Query> getQueryProperty() {
		return this.queryProperty;
	}

	public Query getQueryPropertyValue() {
		return (Query) this.queryProperty.getValue();
	}

	public boolean isQueryEnable() {
		return this.queryTypeWidget.isSelectionEnabled();
	}

	public IDialog<ICreateQueryWidget> selectQueryType(final String queryName) {
		return this.queryTypeWidget.selectQueryType(queryName);
	}

	public String getQueryText() {
		return this.queryTypeWidget.getText();
	}

	public Query getQuery() {
		return (Query) this.queryProperty.getValue();
	}

	public void setQuery(final Query value) {
		this.queryProperty.setValue(value);
	}

	public Facet getFacet() {
		return this.facet;
	}

	private class QueryContext implements IQueryContext {

		private final AbstractDerivedTypedElementWidget<T> widget;

		public QueryContext(final AbstractDerivedTypedElementWidget<T> widget) {
			this.widget = widget;
		}

		public int getUpperBound() {
			return this.widget.getUpperBoundProperty().getValue2().intValue();
		}

		public EClassifier getReturnType() {
			return this.widget.getEType();
		}

		public Resource getResource() {
			return this.widget.getFacet().eResource();
		}

		public Query getQuery() {
			return this.widget.getQueryPropertyValue();
		}

		public IProject getProject() {
			return ModelUtils.getProject(this.widget.getFacet());
		}

		public EObject getIntermediateEObject() {
			return null;
		}

		public Facet getFacet() {
			return this.widget.getFacet();
		}

		public EClassifier getExtendedEClass() {
			return FacetUtils.getExtendedMetaclass(this.widget.getFacet());
		}

		public String getDerivedTypedElementName() {
			return this.widget.getElementNamePropertyValue();
		}

	}

}
