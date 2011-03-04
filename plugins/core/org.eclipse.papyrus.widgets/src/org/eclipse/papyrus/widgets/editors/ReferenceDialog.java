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

import java.util.Collections;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.widgets.Activator;
import org.eclipse.papyrus.widgets.messages.Messages;
import org.eclipse.papyrus.widgets.providers.EncapsulatedContentProvider;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * An editor representing a single reference as a Label
 * A filtered selection dialog is used to edit the value.
 * Also offers support for unsetting the value.
 * This Editor needs a ContentProvider, and may use an optional LabelProvider,
 * describing the objects that can be referred by this property
 * 
 * @author Camille Letavernier
 * 
 */
public class ReferenceDialog extends AbstractValueEditor implements IChangeListener, DisposeListener {

	/**
	 * The CLabel displaying the current value
	 */
	protected final CLabel currentValueLabel;

	/**
	 * The Button used to edit the current value
	 */
	protected final Button openDialogButton;

	/**
	 * The Button used to unset the current value
	 */
	protected final Button unsetButton;

	/**
	 * The label provider used to display the values in both the label and the
	 * selection dialog
	 */
	protected ILabelProvider labelProvider;

	/**
	 * The content provider, providing the different possible values for the input object
	 */
	protected IStaticContentProvider contentProvider;

	/**
	 * The dialog used to select the value
	 */
	protected final TreeSelectorDialog dialog;

	/**
	 * The current value for this editor
	 */
	protected Object value;

	/**
	 * 
	 * Constructs a new ReferenceDialog in the given parent Composite.
	 * The style will be applied to the CLabel displaying the current value.
	 * 
	 * @param parent
	 * @param style
	 */
	public ReferenceDialog(Composite parent, int style) {
		super(parent, style);

		((GridLayout)getLayout()).numColumns = 4;

		currentValueLabel = factory.createCLabel(this, null, SWT.BORDER | style);
		currentValueLabel.setLayoutData(getDefaultLayoutData());

		dialog = new TreeSelectorDialog(parent.getShell());

		openDialogButton = factory.createButton(this, null, SWT.PUSH);
		openDialogButton.setImage(Activator.getDefault().getImage("/icons/browse_12x12.gif")); //$NON-NLS-1$
		openDialogButton.setToolTipText(Messages.ReferenceDialog_EditValue);
		openDialogButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				dialog.setInitialElementSelections(Collections.singletonList(getValue()));
				int result = dialog.open();
				if(result == Window.OK) {
					Object[] newValue = dialog.getResult();
					if(newValue.length == 0) {
						modelProperty.setValue(null);
					} else {
						modelProperty.setValue(newValue[0]);
					}
					updateLabel();
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				// Nothing
			}

		});

		unsetButton = factory.createButton(this, null, SWT.PUSH);
		unsetButton.setImage(Activator.getDefault().getImage("/icons/Delete_12x12.gif")); //$NON-NLS-1$
		unsetButton.setToolTipText(Messages.ReferenceDialog_UnsetValue);
		unsetButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				if(modelProperty != null) {
					modelProperty.setValue(null);
				} else {
					handleChange(null);
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				//Nothing
			}

		});
	}

	/**
	 * Updates the displayed label for the current value
	 */
	protected void updateLabel() {
		if(currentValueLabel.isDisposed()) {
			Activator.log.warn("Widget is disposed"); //$NON-NLS-1$
			return;
		}

		String valueLabel;
		Image image = null;
		if(getValue() == null)
			valueLabel = Messages.ReferenceDialog_Unset;
		else if(labelProvider == null)
			valueLabel = getValue().toString();
		else {
			valueLabel = labelProvider.getText(getValue());
			image = labelProvider.getImage(getValue());
		}

		currentValueLabel.setText(valueLabel);
		currentValueLabel.setImage(image);
	}

	/**
	 * Sets the Content provider for this editor
	 * 
	 * @param provider
	 *        The content provider used to retrieve the possible values for this Reference
	 */
	public void setContentProvider(IStaticContentProvider provider) {
		dialog.setContentProvider(new EncapsulatedContentProvider(provider));
		if(getValue() != null)
			dialog.setInitialElementSelections(Collections.singletonList(getValue()));

		this.contentProvider = provider;
	}

	/**
	 * Sets the Label provider for this editor
	 * If the label provider is null, a default one will be used.
	 * The same label provider is used for both the editor's label
	 * and the selection dialog.
	 * 
	 * @param provider
	 *        The label provider
	 */
	public void setLabelProvider(ILabelProvider provider) {
		dialog.setLabelProvider(provider);
		this.labelProvider = provider;
		updateLabel();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLabel(String label) {
		super.setLabel(label);
		dialog.setTitle(label);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getValue() {
		return value;
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
	public void setReadOnly(boolean readOnly) {
		currentValueLabel.setEnabled(!readOnly);
		openDialogButton.setEnabled(!readOnly);
		unsetButton.setEnabled(!readOnly);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isReadOnly() {
		return !currentValueLabel.isEnabled();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doBinding() {
		//we don't do a real databinding here
		getParent().addDisposeListener(this);
		modelProperty.addChangeListener(this);
		handleChange(null);
	}

	@Override
	public void refreshValue() {
		handleChange(null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		if(modelProperty != null) {
			modelProperty.removeChangeListener(this);
		}
		getParent().removeDisposeListener(this);
		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 */
	public void handleChange(ChangeEvent event) {
		this.value = modelProperty.getValue();
		dialog.setInitialElementSelections(Collections.singletonList(getValue()));
		updateLabel();
	}

	public void widgetDisposed(DisposeEvent e) {
		dispose();
	}

	@Override
	public void setToolTipText(String text) {
		super.setLabelToolTipText(text);
		currentValueLabel.setToolTipText(text);
	}

}
