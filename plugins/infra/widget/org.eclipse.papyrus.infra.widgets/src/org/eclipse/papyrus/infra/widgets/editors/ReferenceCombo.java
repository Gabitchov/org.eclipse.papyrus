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
 *  Thibault Le Ouay t.leouay@sherpa-eng.com - Add binding implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.editors;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.tools.databinding.AggregatedObservable;
import org.eclipse.papyrus.infra.widgets.databinding.ComboObservableValue;
import org.eclipse.papyrus.infra.widgets.providers.EncapsulatedContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.UnchangedObject;
import org.eclipse.papyrus.infra.widgets.providers.UnsetObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;


/**
 * An editor representing a single reference as a Combo Box
 * This Editor needs a ContentProvider and a LabelProvider,
 * describing the objects that can be referred by this property
 *
 * @author Camille Letavernier
 *
 */
public class ReferenceCombo extends AbstractValueEditor { //implements SelectionListener {

	/**
	 * The viewer displaying the available values from the model
	 */
	protected ComboViewer viewer;

	/**
	 * The combo used to select the reference
	 */
	protected CCombo combo;

	protected boolean unsettable;

	//	protected Button unset;

	protected EncapsulatedContentProvider contentProvider;


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

		combo = factory.createCCombo(this, style | SWT.BORDER);
		combo.setBackground(new Color(combo.getDisplay(), 255, 255, 255));
		combo.setLayoutData(getDefaultLayoutData());
		combo.setEditable(false);

		viewer = new ComboViewer(combo);

		//		unset = new Button(this, SWT.PUSH);
		//		unset.setImage(Activator.getDefault().getImage("/icons/Delete_12x12.gif")); //$NON-NLS-1$
		//		unset.setToolTipText("Unset the current value");
		//		unset.addSelectionListener(this);

		((GridLayout)getLayout()).numColumns++;

		setCommitOnFocusLost(combo);
		controlDecoration = new ControlDecoration(combo, SWT.TOP | SWT.LEFT);
		GridData gridData = getDefaultLayoutData();
		combo.setLayoutData(gridData);
		gridData.horizontalIndent = FieldDecorationRegistry.getDefault().getMaximumDecorationWidth();
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
		this.contentProvider = new EncapsulatedContentProvider(provider);
		viewer.setContentProvider(contentProvider);
		viewer.setInput(""); //$NON-NLS-1$
		updateControls();
		doBinding();
	}

	@Override
	protected void doBinding() {
		if(contentProvider == null || modelProperty == null) {
			return;
		}

		setWidgetObservable(getObservableValue(), true);
		if(modelProperty instanceof AggregatedObservable) {
			if(((AggregatedObservable)modelProperty).hasDifferentValues()) {
				contentProvider.addTemporaryElement(UnchangedObject.instance);
				viewer.refresh();
			}
		}
		super.doBinding();
	}

	protected IObservableValue getObservableValue() {
		return new ComboObservableValue(viewer, modelProperty);
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

	/**
	 * Sets the value for this widget
	 *
	 * @param value
	 */
	public void setValue(Object value) {
		if(value == null) {
			viewer.setSelection(new StructuredSelection());
		} else {
			viewer.setSelection(new StructuredSelection(value), true);
		}
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
		updateControls();
	}

	/**
	 * Updates the controls display
	 */
	protected void updateControls() {
		//		setExclusion(unset, !unsettable);

		//		if(isReadOnly() && unsettable) {
		//			unset.setEnabled(false);
		//		}

		if(contentProvider != null) {
			if(unsettable) {
				contentProvider.addTemporaryElement(UnsetObject.instance);
			} else {
				contentProvider.removeTemporaryElement(UnsetObject.instance);
			}
			viewer.refresh();
		}
	}

	/**
	 * Changes the viewer for this editor.
	 * The viewer should use a CCombo
	 *
	 * @param comboViewer
	 */
	public void setViewer(ComboViewer comboViewer) {
		this.viewer = comboViewer;
		this.combo = viewer.getCCombo();
	}

	//FIXME error avec multiplicité nulllpointerexception l285
	@Override
	public void updateStatus(IStatus status) {
		switch(status.getSeverity()) {
		case IStatus.OK:
			controlDecoration.hide();
			break;
		case IStatus.WARNING:
			FieldDecoration warning = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_WARNING);
			controlDecoration.setImage(warning.getImage());
			controlDecoration.showHoverText(status.getMessage());
			controlDecoration.setDescriptionText(status.getMessage());
			controlDecoration.show();
			break;
		case IStatus.ERROR:
			FieldDecoration error = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			controlDecoration.setImage(error.getImage());
			controlDecoration.showHoverText(status.getMessage());
			controlDecoration.setDescriptionText(status.getMessage());
			controlDecoration.show();
			break;
		default:
			controlDecoration.hide();
			break;
		}


	}

	//	protected void unsetAction() {
	//		viewer.setSelection(StructuredSelection.EMPTY);
	//		if(modelProperty != null) {
	//			modelProperty.setValue(null);
	//		}
	//	}

	//	public void widgetSelected(SelectionEvent e) {
	//		if(e.widget == unset) {
	//			unsetAction();
	//		}
	//	}

	//	public void widgetDefaultSelected(SelectionEvent e) {
	//		//Nothing
	//	}
}
