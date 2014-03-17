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
package org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.widget.query;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.IQueryContext;
import org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.widget.GetOrCreateJavaImplementationWidgetComposite;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.query.AbstractQueryWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * This class provide the main widget for the creation of a Java query.
 */
public class JavaQueryWidget extends AbstractQueryWidget<ETypedElement> {

	private final PropertyElement2<String> implClassNameProp;
	private final IQueryContext queryContext;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this widget.
	 * @param editingDomain
	 *            the current editing domain.
	 * @param properties
	 *            the properties.
	 * @param facetSet
	 *            the main facetSet of the model.
	 * @param facet
	 *            the current facet of the model.
	 */
	public JavaQueryWidget(final Composite parent,
			final IQueryContext queryContext,
			final PropertyElement2<String> implClassNameProp) {
		super(parent);
		this.implClassNameProp = implClassNameProp;
		this.queryContext = queryContext;
	}

	@Override
	protected void addSubWidgets() {
		final GetOrCreateJavaImplementationWidgetComposite widget = new GetOrCreateJavaImplementationWidgetComposite(this,
				this.implClassNameProp, this.queryContext);
		addSubWidget(widget);
	}

	@Override
	public Command getCommand() {
		// No Command to return.
		return null;
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
