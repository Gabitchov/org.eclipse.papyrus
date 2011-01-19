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
package org.eclipse.papyrus.editors;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.editors.providers.EncapsulatedContentProvider;
import org.eclipse.papyrus.editors.providers.IStaticContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;


/**
 * An editor representing a single reference as a Combo Box
 * This Editor needs a ContentProvider and a LabelProvider,
 * describing the objects that can be referred by this property
 * 
 * @author Camille Letavernier
 * 
 */
public class ReferenceCombo extends AbstractValueEditor {

	/**
	 * The viewer displaying the available values from the model
	 */
	private ComboViewer viewer;

	/**
	 * The displayed control
	 */
	private CCombo control;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 *        The Composite in which this editor is diplayed
	 * @param style
	 *        The style for this editor's combo
	 */
	public ReferenceCombo(Composite parent, int style) {
		this(parent, style, null);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 *        The Composite in which this editor is diplayed
	 * @param style
	 *        The style for this editor's combo
	 * @param label
	 *        The label for this editor
	 */
	public ReferenceCombo(Composite parent, int style, String label) {
		super(parent, label);

		control = factory.createCCombo(this, style | SWT.BORDER);
		control.setBackground(new Color(control.getDisplay(), 255, 255, 255));
		control.setLayoutData(getDefaultLayoutData());
		control.setEditable(false);
		viewer = new ComboViewer(control);
	}

	/**
	 * Sets the Content and Label providers for this editor
	 * 
	 * @param contentProvider
	 * 
	 * @param labelProvider
	 */
	public void setProviders(IStaticContentProvider contentProvider, ILabelProvider labelProvider) {
		Assert.isNotNull(contentProvider, "The content provider should not be null"); //$NON-NLS-1$
		setContentProvider(contentProvider);

		if(labelProvider != null)
			setLabelProvider(labelProvider);
	}

	/**
	 * Sets the content provider for this combo. The Content provider should
	 * specify the objects that can be referred by this property
	 * 
	 * @param provider
	 */
	public void setContentProvider(IStaticContentProvider provider) {
		viewer.setContentProvider(new EncapsulatedContentProvider(provider));
		viewer.setInput(""); //$NON-NLS-1$
		setWidgetObservable(ViewerProperties.singleSelection().observe(viewer), true);
	}

	/**
	 * The Label provider associated to the available objects that
	 * can be referred by this property
	 * 
	 * @param provider
	 */
	public void setLabelProvider(ILabelProvider provider) {
		viewer.setLabelProvider(provider);
	}

	/**
	 * Retrieves the ComboViewer associated to this Editor
	 * 
	 * @return
	 */
	public ComboViewer getViewer() {
		return viewer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getEditableType() {
		return Object.class;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getValue() {
		IStructuredSelection selection = (IStructuredSelection)viewer.getSelection();
		if(selection.isEmpty())
			return null;
		return selection.getFirstElement();
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		control.setEnabled(!readOnly);
	}

	@Override
	public boolean isReadOnly() {
		return !control.isEnabled();
	}
}
