/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime.propertyeditor;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.controller.IBoundedValuesController;
import org.eclipse.papyrus.views.properties.runtime.controller.PropertyEditorController;
import org.eclipse.papyrus.views.properties.runtime.dialogs.PropertyDialog;
import org.eclipse.papyrus.views.properties.runtime.dialogs.ReferenceExplorerDialog;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.DialogDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.PropertyViewService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;


/**
 * Property editor for references that have multiplicity [0..1] or [1..1]
 */
public class SimpleReferencePropertyEditor extends AbstractPropertyEditor {

	/** id of this editor */
	public static final String ID = "org.eclipse.papyrus.views.properties.runtime.simpleReferencePropertyEditor";

	/** main composite created by this property editor */
	protected Composite composite;

	/** button to add a reference or modify existing one */
	protected Button addButton;

	/** button to remove reference */
	protected Button removeButton;

	/** label area that displays the reference */
	protected CLabel referenceArea;

	/** current Value */
	protected Object currentValue;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Composite createContent(Composite parent) {
		composite = getWidgetFactory().createComposite(parent, SWT.NONE);
		int columnNu = getColumnNumber();
		GridLayout layout = new GridLayout(columnNu, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		composite.setLayout(layout);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, false);
		composite.setLayoutData(data);

		if((getDescriptor().getLabelPosition() & (SWT.LEFT | SWT.TOP)) != 0) {
			createLabel(composite);
		}

		// referenceArea = getWidgetFactory().createText(composite, "", SWT.READ_ONLY | SWT.BORDER);
		referenceArea = getWidgetFactory().createCLabel(composite, "", SWT.BORDER);
		data = new GridData(SWT.FILL, SWT.FILL, true, true);
		referenceArea.setLayoutData(data);
		referenceArea.addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
				// nothing to do here
			}

			public void mouseDown(MouseEvent e) {
				// nothing to do here
			}

			public void mouseDoubleClick(MouseEvent e) {
				openPropertyDialog();
			}
		});
		referenceArea.setToolTipText(getTooltipText());

		addButton = getWidgetFactory().createButton(composite, "", SWT.NONE);
		addButton.setImage(Activator.getImageFromDescriptor(Activator.imageDescriptorFromPlugin(Activator.ID, "icons/Add_12x12.gif")));
		data = new GridData(SWT.FILL, SWT.CENTER, false, false);
		addButton.setLayoutData(data);
		addButton.addMouseListener(new MouseListener() {

			/**
			 * {@inheritDoc}
			 */
			public void mouseUp(MouseEvent e) {
				openReferenceDialog();
			}

			/**
			 * {@inheritDoc}
			 */
			public void mouseDown(MouseEvent e) {
			}

			/**
			 * {@inheritDoc}
			 */
			public void mouseDoubleClick(MouseEvent e) {
			}
		});
		addButton.setEnabled(!getIsReadOnly());

		removeButton = getWidgetFactory().createButton(composite, "", SWT.NONE);
		removeButton.setImage(Activator.getImageFromDescriptor(Activator.imageDescriptorFromPlugin(Activator.ID, "icons/Delete_12x12.gif")));
		data = new GridData(SWT.FILL, SWT.CENTER, false, false);
		removeButton.setLayoutData(data);
		removeButton.addMouseListener(new MouseListener() {

			/**
			 * {@inheritDoc}
			 */
			public void mouseUp(MouseEvent e) {
				removeValueAction();
			}

			/**
			 * {@inheritDoc}
			 */
			public void mouseDown(MouseEvent e) {

			}

			/**
			 * {@inheritDoc}
			 */
			public void mouseDoubleClick(MouseEvent e) {

			}
		});
		removeButton.setEnabled(!getIsReadOnly());

		if((getDescriptor().getLabelPosition() & (SWT.RIGHT | SWT.BOTTOM)) != 0) {
			createLabel(composite);
		}

		return composite;
	}

	/**
	 * Removes the current value.
	 */
	protected void removeValueAction() {
		// remove the reference of the element
		currentValue = null;
		getController().updateModel();
	}

	/**
	 * Opens the property dialog of current value and apply changes
	 */
	protected void openPropertyDialog() {

		/*
		 * deactivated part
		 * // open property dialog on the current object
		 * List<Object> objectsToEdit = Arrays.asList(getValue());
		 * 
		 * // find editor descriptor...
		 * DialogDescriptor descriptor = PropertyViewService.getInstance().getDialogDescriptor(objectsToEdit);
		 * 
		 * if(descriptor != null) {
		 * Shell parentShell = getShell();
		 * PropertyDialog dialog = new PropertyDialog(parentShell, descriptor, objectsToEdit, getWidgetFactory());
		 * dialog.open();
		 * }
		 * 
		 * // end of deactivated
		 */
	}

	/**
	 * Opens the reference dialog and apply changes
	 */
	protected void openReferenceDialog() {
		// pops up a window to ask for a new reference
		Shell currentShell = getShell();
		ReferenceExplorerDialog dialog = new ReferenceExplorerDialog(currentShell, (IBoundedValuesController)getController(), false);
		// should select the current value by default
		if(Dialog.OK == dialog.open()) {
			currentValue = dialog.getFirstResult();
			getController().updateModel();
		}
	}

	/**
	 * Returns a shell where dialogs can be displayed
	 * 
	 * @return a shell where dialogs can be displayed
	 */
	protected Shell getShell() {
		Display display = Display.getCurrent();
		if(display == null && PlatformUI.isWorkbenchRunning()) {
			display = PlatformUI.getWorkbench().getDisplay();
		}
		display = (display != null) ? display : Display.getDefault();
		return display.getActiveShell();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createLabel(Composite parent) {
		GridData data = new GridData(SWT.LEFT, SWT.CENTER, false, false, (getColumnNumber() == 3) ? 3 : 1, 1);
		String text = getDescriptor().getLabel();
		int size = computeLabelSize(parent, text);
		data.minimumWidth = Math.max(LABEL_MAX_WIDTH, size);
		data.widthHint = data.minimumWidth;
		return createLabel(parent, data);
	}

	/**
	 * Returns the number of column for the composite
	 * 
	 * @return the number of column for the composite
	 */
	protected int getColumnNumber() {
		if((getDescriptor().getLabelPosition() & (SWT.TOP | SWT.BOTTOM)) != 0) {
			return 3;
		}
		return 4;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handleContentChanged() {
		// this should tells the controller that the input has to be applied to the model
		getController().updateModel();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus init(IPropertyEditorDescriptor descriptor) {
		setDescriptor(descriptor);
		setTooltipText(descriptor.getTooltipText());
		return Status.OK_STATUS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getValue() {
		if(isValid(referenceArea)) {
			return currentValue;
		} else {
			Activator.log.error("trying to read the value of the reference area whereas the combo is disposed", null);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setValue(Object valueToEdit) {
		if(!isValid(referenceArea)) {
			return;
		}
		currentValue = valueToEdit;

		// check if the model handler is able to give an improved text provider (for example, binding messages)
		if(valueToEdit != null) {
			referenceArea.setText(((IBoundedValuesController)getController()).getEditorLabelProvider().getText(valueToEdit));
			referenceArea.setImage(((IBoundedValuesController)getController()).getEditorLabelProvider().getImage(valueToEdit));
		} else {
			referenceArea.setText("<Undefined>");
			referenceArea.setImage(null);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setController(PropertyEditorController controller) {
		assert (controller instanceof IBoundedValuesController) : "Controller should be a IboundedValuesController";
		super.setController(controller);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		if(isValid(composite)) {
			composite.dispose();
			composite = null;
			setController(null);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDisposed() {
		if(composite == null) {
			return false;
		}
		return composite.isDisposed();
	}
}
