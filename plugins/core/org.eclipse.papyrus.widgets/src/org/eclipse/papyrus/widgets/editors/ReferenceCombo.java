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
package org.eclipse.papyrus.widgets.editors;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.widgets.Activator;
import org.eclipse.papyrus.widgets.providers.EncapsulatedContentProvider;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;


/**
 * An editor representing a single reference as a Combo Box
 * This Editor needs a ContentProvider and a LabelProvider,
 * describing the objects that can be referred by this property
 * 
 * @author Camille Letavernier
 * 
 */
public class ReferenceCombo extends AbstractValueEditor implements SelectionListener {

	/**
	 * The viewer displaying the available values from the model
	 */
	private ComboViewer viewer;

	/**
	 * The combo used to select the reference
	 */
	private CCombo combo;

	private boolean unsettable;

	protected Button unset;

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

		((GridLayout)getLayout()).numColumns = 3;

		combo = factory.createCCombo(this, style | SWT.BORDER);
		combo.setBackground(new Color(combo.getDisplay(), 255, 255, 255));
		combo.setLayoutData(getDefaultLayoutData());
		combo.setEditable(false);

		viewer = new ComboViewer(combo);

		unset = new Button(this, SWT.PUSH);
		unset.setImage(Activator.getDefault().getImage("/icons/Delete_12x12.gif")); //$NON-NLS-1$
		unset.setToolTipText("Unset the current value");
		unset.addSelectionListener(this);

		setCommitOnFocusLost(combo);
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

		if(labelProvider != null) {
			setLabelProvider(labelProvider);
		}
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
	 *         The ComboViewer associated to this editor
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
		if(selection.isEmpty()) {
			return null;
		}
		return selection.getFirstElement();
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		combo.setEnabled(!readOnly);
		updateControls();
	}

	@Override
	public boolean isReadOnly() {
		return !combo.isEnabled();
	}

	@Override
	public void setToolTipText(String text) {
		combo.setToolTipText(text);
		super.setLabelToolTipText(text);
	}

	public void setUnsettable(boolean unsettable) {
		this.unsettable = unsettable;
	}

	protected void updateControls() {
		unset.setEnabled(unsettable && !isReadOnly());
	}

	protected void unsetAction() {
		viewer.setSelection(StructuredSelection.EMPTY);
		//		if (modelProperty != null){
		//			modelProperty.setValue(null);
		//		}
	}

	public void widgetSelected(SelectionEvent e) {
		if(e.widget == unset) {
			unsetAction();
		}
	}

	public void widgetDefaultSelected(SelectionEvent e) {
		//Nothing
	}
}
