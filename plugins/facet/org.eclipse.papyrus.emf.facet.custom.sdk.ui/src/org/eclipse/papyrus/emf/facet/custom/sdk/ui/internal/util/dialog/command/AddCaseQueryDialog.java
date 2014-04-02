/**
 *  Copyright (c) 2012 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.dialog.command;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.dialog.AbstractCustomizationMainDialog;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.widget.command.AddCaseQueryWidget;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.IQueryContext;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.ICommandWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase;

/**
 * Concrete dialog for the creation of a query in a case.
 */
public class AddCaseQueryDialog extends
		AbstractCustomizationMainDialog<ICommandWidget> {

	private AddCaseQueryWidget addCaseQueryW;
	private final PropertyElement2<ETypedElementCase> queryCaseProp;
	private final PropertyElement2<Query> queryValueProp;
	private final IQueryContext queryContext;

	/**
	 * Constructor.
	 * 
	 * @param selection
	 *            the selection in the model (custom file).
	 */
	public AddCaseQueryDialog(final ETypedElementCase selection,
			final EditingDomain editingDomain) {
		super(selection, editingDomain);
		this.queryContext = new QueryContext(selection);
		this.queryCaseProp = new PropertyElement2<ETypedElementCase>(true);
		this.queryValueProp = new PropertyElement2<Query>(true);
		if (selection != null) {
			this.queryCaseProp.setValue2(selection);
		}
	}

	@Override
	protected ICommandWidget createWidget() {
		this.addCaseQueryW = new AddCaseQueryWidget(this.getDialogComposite(),
				getCustomCmdFactory(), this.queryCaseProp, this.queryValueProp,
				this.queryContext);
		return this.addCaseQueryW;
	}

	@Override
	protected String getDialogMessage() {
		return Messages.Add_Customization_message;
	}

	@Override
	protected String getDialogTitle() {
		return Messages.Add_Customization_title;
	}

	/**
	 * @return the addCaseQueryWidget
	 */
	public AddCaseQueryWidget getAddCaseQueryWidget() {
		return this.addCaseQueryW;
	}

}
