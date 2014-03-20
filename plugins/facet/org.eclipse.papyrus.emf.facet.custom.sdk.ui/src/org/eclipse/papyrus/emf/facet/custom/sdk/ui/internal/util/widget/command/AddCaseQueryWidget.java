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
package org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.widget.command;

import org.eclipse.emf.common.command.Command;
import org.eclipse.papyrus.emf.facet.custom.sdk.core.ICustomizationCommandFactory;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.widget.property.name.GetCaseQueryNameWidget;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.widget.property.name.GetCaseQueryTypeWidget;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.IQueryContext;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.query.SelectQueryTypeWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.AbstractCommandWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase;
import org.eclipse.swt.widgets.Composite;

/**
 * Widget for the creation of a case query. This Widget return a command (
 * {@link #getCommand()} for the creation of the element into the model.
 * 
 * </p> This widget uses 3 others widgets:
 * 
 * <li> {@link GetCaseQueryNameWidget} to display the name of the query.</li> <li>
 * {@link GetCaseQueryTypeWidget} to display the type of the query.</li> <li>
 * {@link SelectQueryTypeWidget} to select the query and open the query editor.</li>
 */
public class AddCaseQueryWidget extends AbstractCommandWidget {

	private final PropertyElement2<ETypedElementCase> queryCaseProp;
	private final PropertyElement2<Query> queryProperty;
	private final ICustomizationCommandFactory customCmdFactory;
	private final IQueryContext queryContext;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param properties
	 *            the properties.
	 * @param customCmdFactory
	 * @param queryCaseProp
	 * @param queryNameProp
	 * @param queryTypeProp
	 * @param queryProperty
	 */
	public AddCaseQueryWidget(final Composite parent,
			final ICustomizationCommandFactory customCmdFactory,
			final PropertyElement2<ETypedElementCase> queryCaseProperty,
			final PropertyElement2<Query> queryProperty,
			final IQueryContext queryContext) {
		super(parent);
		this.customCmdFactory = customCmdFactory;
		this.queryCaseProp = queryCaseProperty;
		this.queryProperty = queryProperty;
		this.queryContext = queryContext;
	}

	@Override
	public Command getCommand() {
		final ETypedElementCase elementCase = this.queryCaseProp.getValue2();
		final Query query = this.queryProperty.getValue2();
		return this.customCmdFactory.addValueInCase(
				elementCase, query);
	}

	@Override
	protected void addSubWidgets() {
		addSubWidget(new GetCaseQueryNameWidget(this, this.queryCaseProp));
		final SelectQueryTypeWidget queryTypeWidget = new SelectQueryTypeWidget(
				this, this.queryProperty, true, this.queryContext);
		addSubWidget(queryTypeWidget);
	}

	@Override
	public void notifyChanged() {
		// Nothing to do.
	}

	@Override
	public void onDialogValidation() {
		// Nothing to do.
	}
}
