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

import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.ExtensiblePackage;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.dialog.query.IQueryDialogFactory;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.AbstractWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.query.AbstractQueryWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement;
import org.eclipse.emf.facet.util.ui.utils.WidgetProperties;
import org.eclipse.swt.widgets.Composite;

/**
 * This abstract class must be extended by the plug-in which has to extend this
 * plug-in. This abstract class must provide a simple way to create an dialog
 * for the creation of the query</p>
 * 
 * The {@link #createWidget()} method must return a widget that extends
 * {@link AbstractQueryWidget} class add provide a widget for the edition of the
 * query.</p>
 * 
 * The {@link #createQuery()} method must return the final query created. The query
 * must be a subclass of {@link Query}.</p>
 * 
 * The {@link #getDialogMessage()} method must return a simple text that will
 * notice the user that he successfully create the query.
 * 
 * @see WidgetProperties
 * @see PropertyElement
 * @see AbstractQueryWidget
 * @see Query
 */
public abstract class AbstractQueryDialogFactory<Q extends Query> implements
		IQueryDialogFactory {

	public static final ETypedElement QUERY_NAME = EcorePackage.eINSTANCE
			.getENamedElement_Name();
	public static final ETypedElement QUERY_TYPE = EcorePackage.eINSTANCE
			.getETypedElement_EType();
	public static final ETypedElement CAN_BE_CACHED = ExtensiblePackage.eINSTANCE
			.getQuery_CanBeCached();
	public static final ETypedElement SIDE_EFFECTS = ExtensiblePackage.eINSTANCE
			.getQuery_CanHaveSideEffects();
	private DerivedTypedElement dte;

	private IDialog<?> parentDialog;
	private WidgetProperties<ETypedElement> properties;
	private Q initialQuery;
	private final PropertyElement canBeCachedProp = getProperties()
			.getProperty(AbstractQueryDialogFactory.CAN_BE_CACHED);
	private final PropertyElement sideEffectsProp = getProperties()
			.getProperty(AbstractQueryDialogFactory.SIDE_EFFECTS);

	/**
	 * @return the widget associated to the dialog. The widget will contain all
	 *         the necessaries {@link AbstractWidget} for the creation of the
	 *         query.
	 */
	public abstract AbstractQueryWidget<ETypedElement> createWidget(
			Composite parent);

	/**
	 * Return a map with the specific properties of the query.
	 * 
	 * @return the properties
	 */
	public abstract Map<ETypedElement, PropertyElement> createSpecificProperties();

	/**
	 * @return the query created by this widget. Null if no query have been
	 *         created.
	 */
	public abstract Query createQuery();

	/**
	 * @return the message description of the dialog.
	 */
	public abstract String getDialogMessage();

	/**
	 * @return the title of the dialog.
	 */
	public abstract String getDialogTitle();

	/**
	 * @return a text that the extension must set for the main dialog (to let
	 *         the user know that he create the query).
	 */
	public abstract String getConclusionText();

	/**
	 * @return the parentDialog
	 */
	public IDialog<?> getParent() {
		return this.parentDialog;
	}

	/**
	 * @param queryName
	 *            the queryName to set
	 */
	public void setQueryName(final String queryName) {
		getQueryNameProperty().setValue(queryName);
	}

	/**
	 * @return the facetset
	 */
	public DerivedTypedElement getDerivedTypedElement() {
		return this.dte;
	}

	/**
	 * @param queryName
	 *            the queryName to set
	 */
	public void setQueryType(final EClassifier queryType) {
		getQueryTypeProperty().setValue(queryType);
	}

	/**
	 * @return the query type.
	 */
	public PropertyElement getQueryTypeProperty() {
		return getProperties().getProperty(
				AbstractQueryDialogFactory.QUERY_TYPE);
	}

	/**
	 * This method return a singleton of the properties {@link WidgetProperties}
	 * with the initialization of some standard properties as: </nl> <li>The
	 * query name : {@link #getQueryNameProperty()}</li> <li>If the query can be
	 * cached : {@link #getCanBeCachedProperty()}</li> <li>If the query can have
	 * side effects : {@link #getCanHaveSideEffects()}</li> </nl>
	 * 
	 * @return the properties
	 */
	public WidgetProperties<ETypedElement> getProperties() {
		if (this.properties == null) {
			this.properties = new WidgetProperties<ETypedElement>();

			// Query Name
			this.properties.addProperty(AbstractQueryDialogFactory.QUERY_NAME,
					new PropertyElement("QueryName", String.class, false)); //$NON-NLS-1$
			// CanBeCached
			this.properties.addProperty(
					AbstractQueryDialogFactory.CAN_BE_CACHED,
					new PropertyElement("CanBeCached", Boolean.class, true, //$NON-NLS-1$
							Boolean.FALSE));
			// CanHaveSideEffects
			this.properties.addProperty(
					AbstractQueryDialogFactory.SIDE_EFFECTS,
					new PropertyElement("CanHaveSideEffects", Boolean.class, //$NON-NLS-1$
							true, Boolean.FALSE));
			// QueryType
			this.properties.addProperty(AbstractQueryDialogFactory.QUERY_TYPE,
					new PropertyElement("QueryType", EClassifier.class, true)); //$NON-NLS-1$
		}
		return this.properties;
	}

	/**
	 * The the specific properties to the existing properties.
	 */
	public void addSpecificProperties() {
		// Adding user's properties
		final Map<ETypedElement, PropertyElement> userProp = createSpecificProperties();
		if (userProp != null) {
			for (final ETypedElement element : userProp.keySet()) {
				this.properties.addProperty(element, userProp.get(element));
			}
		}
	}

	/**
	 * @return the queryNameProperty
	 */
	public PropertyElement getQueryNameProperty() {
		return getProperties().getProperty(
				AbstractQueryDialogFactory.QUERY_NAME);
	}

	/**
	 * @return the CanBeCachedProperty
	 */
	public PropertyElement getCanBeCachedProperty() {
		return this.canBeCachedProp;
	}

	public boolean isCanBeCachedPropertyValue() {
		return ((Boolean) this.canBeCachedProp.getValue()).booleanValue();
	}

	/**
	 * @return the CanHaveSideEffects
	 */
	public PropertyElement getCanHaveSideEffects() {
		return this.sideEffectsProp;
	}

	public boolean isCanHaveSideEffectsValue() {
		return ((Boolean) this.sideEffectsProp.getValue()).booleanValue();
	}

	/**
	 * @return the initialQuery
	 */
	public Q getInitialQuery() {
		return this.initialQuery;
	}

	/**
	 * @param initialQuery the initialQuery to set
	 */
	public void setInitialQuery(final Q initialQuery) {
		this.initialQuery = initialQuery;
	}

	public void commit() {
		this.parentDialog.commit();
	}

	public void cancel() {
		this.parentDialog.cancel();
	}

	public int open() {
		return this.parentDialog.open();
	}

	public boolean isDialogValid() {
		return this.parentDialog.isDialogValid();
	}

}
