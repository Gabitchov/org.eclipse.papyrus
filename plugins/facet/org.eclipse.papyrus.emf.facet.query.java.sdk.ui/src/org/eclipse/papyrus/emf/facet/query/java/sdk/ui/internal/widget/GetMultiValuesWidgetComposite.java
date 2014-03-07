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
 */
package org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.widget;

import org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.component.properties.AbstractGetPropertyWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement;
import org.eclipse.swt.widgets.Composite;

/**
 * This class create a boolean widget to check if the returned value is multiple
 * or not (1 or *).
 */
public class GetMultiValuesWidgetComposite extends AbstractGetPropertyWidget {

	private static final int LABEL_WIDTH_HINT = 110;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this widget.
	 * @param propertyElement
	 *            the property element edited by this widget.
	 */
	public GetMultiValuesWidgetComposite(final Composite parent,
			final PropertyElement propertyElement) {
		super(parent, propertyElement);
		setLabelWidthHint(LABEL_WIDTH_HINT);
	}

	@Override
	protected String getLabel() {
		return Messages.Multi_Values;
	}

	@Override
	public String getError() {
		return null;
	}

	@Override
	public void notifyChanged() {
		// Nothing.
	}

}
