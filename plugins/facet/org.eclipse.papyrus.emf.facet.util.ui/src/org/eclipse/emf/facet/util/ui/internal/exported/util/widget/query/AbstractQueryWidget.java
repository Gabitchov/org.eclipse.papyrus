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
package org.eclipse.emf.facet.util.ui.internal.exported.util.widget.query;

import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.AbstractCommandWidget;
import org.eclipse.swt.widgets.Composite;

/**
 * This abstract class must be used by the plug-ins extending this plug-in. It
 * provides a simple way to create the widget for the edition of the query.
 * 
 * @since 0.3
 */
public abstract class AbstractQueryWidget<P extends Object> extends
		AbstractCommandWidget {

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this widget.
	 * @param editingDomain
	 *            the current editing domain.
	 * @param properties
	 *            the properties.
	 */
	protected AbstractQueryWidget(final Composite parent) {
		super(parent);
	}
}
