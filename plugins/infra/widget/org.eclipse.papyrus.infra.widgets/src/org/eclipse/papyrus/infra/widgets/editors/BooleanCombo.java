/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Thibault Le Ouay t.leouay@sherpa-eng.com - Add binding implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.editors;

import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.widgets.providers.AbstractStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.EncapsulatedContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;

/**
 * An editor representing a boolean value as a combo box, with
 * two options (true / false)
 *
 * @author Camille Letavernier
 *
 */
public class BooleanCombo extends AbstractValueEditor {

	private ComboViewer viewer;

	/**
	 * Constructor.
	 *
	 * @param parent
	 *        The Composite widget in which this editor will be displayed
	 */
	public BooleanCombo(Composite parent) {
		this(parent, SWT.NONE, null);
	}

	/**
	 *
	 * Constructor.
	 *
	 * @param parent
	 *        The Composite widget in which this editor will be displayed
	 * @param style
	 *        The style of this editor's CCombo
	 * @param label
	 *        This editor's label
	 */
	public BooleanCombo(Composite parent, int style, String label) {
		super(parent, style, label);
		CCombo combo = factory.createCCombo(this, style | SWT.BORDER);
		combo.setBackground(new Color(combo.getDisplay(), 255, 255, 255));
		combo.setLayoutData(getDefaultLayoutData());
		combo.setEditable(false);
		viewer = createComboViewer(combo);

		viewer.setContentProvider(new EncapsulatedContentProvider(new AbstractStaticContentProvider() {

			@Override
			public Object[] getElements() {
				return new Boolean[]{ Boolean.TRUE, Boolean.FALSE };
			}
		}));

		viewer.setInput(""); //$NON-NLS-1$

		setWidgetObservable(ViewerProperties.singleSelection().observe(viewer));

		setCommitOnFocusLost(combo);

	}

	/**
	 * Creates the combo viewer
	 *
	 * @param combo
	 *        The parent combo
	 * @return the combo viewer.
	 */
	protected ComboViewer createComboViewer(CCombo combo) {
		return new ComboViewer(combo);
	}

	/**
	 *
	 * Constructor.
	 *
	 * @param parent
	 *        The Composite widget in which this editor will be displayed
	 * @param style
	 *        The style of this editor's CCombo
	 */
	public BooleanCombo(Composite parent, int style) {
		this(parent, style, null);
	}

	/**
	 *
	 * Constructor.
	 *
	 * @param parent
	 *        The Composite widget in which this editor will be displayed
	 * @param label
	 *        This editor's label
	 */
	public BooleanCombo(Composite parent, String label) {
		this(parent, SWT.NONE, label);
	}

	@Override
	public Object getValue() {
		return ((StructuredSelection)viewer.getSelection()).getFirstElement();
	}

	@Override
	public Object getEditableType() {
		return Boolean.class;
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		viewer.getCCombo().setEnabled(!readOnly);
	}

	@Override
	public boolean isReadOnly() {
		return !viewer.getCCombo().isEnabled();
	}

	@Override
	public void setToolTipText(String text) {
		viewer.getCCombo().setToolTipText(text);
		super.setLabelToolTipText(text);
	}

}
