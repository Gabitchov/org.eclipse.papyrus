/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.widgets;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.HierarchicToFlatContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.TreeToFlatContentProvider;
import org.eclipse.swt.widgets.Composite;

/**
 * A PropertyEditor for editing references through a ComboBox
 * 
 * @see org.eclipse.papyrus.infra.widgets.editors.ReferenceCombo
 * 
 * @author Camille Letavernier
 */
public class ReferenceCombo extends AbstractPropertyEditor {

	/**
	 * The ReferenceCombo widget
	 */
	protected org.eclipse.papyrus.infra.widgets.editors.ReferenceCombo combo;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *        The composite in which the widget will be displayed
	 * @param style
	 *        The style for the widget
	 */
	public ReferenceCombo(Composite parent, int style) {
		combo = new org.eclipse.papyrus.infra.widgets.editors.ReferenceCombo(parent, style);
		super.setEditor(combo);
	}

	@Override
	protected void doBinding() {
		IStaticContentProvider contentProvider = input.getContentProvider(propertyPath);
		if(contentProvider instanceof IHierarchicContentProvider) {
			contentProvider = new HierarchicToFlatContentProvider((IHierarchicContentProvider)contentProvider);
			//combo.setViewer(new EncapsulatedComboViewer(combo.getViewer()));
		} else if(contentProvider instanceof ITreeContentProvider) {
			contentProvider = new TreeToFlatContentProvider((ITreeContentProvider)contentProvider);
			//combo.setViewer(new EncapsulatedComboViewer(combo.getViewer()));
		}

		ILabelProvider labelProvider = input.getLabelProvider(propertyPath);

		combo.setProviders(contentProvider, labelProvider);
		combo.setUnsettable(!input.isMandatory(propertyPath));

		super.doBinding();
	}

}
