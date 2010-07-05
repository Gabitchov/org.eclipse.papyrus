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
package org.eclipse.papyrus.properties.runtime.propertyeditor;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.controller.IBoundedValuesController;
import org.eclipse.papyrus.properties.runtime.controller.ILabelProviderController;
import org.eclipse.papyrus.properties.runtime.controller.IWizardPropertyEditorController;
import org.eclipse.papyrus.properties.runtime.controller.PropertyEditorController;
import org.eclipse.papyrus.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.PlatformUI;


/**
 * Property editor for references that have multiplicity [n..*]
 */
public class MultipleStructuralFeaturesPropertyEditor extends AbstractPropertyEditor {

	/** id of this editor */
	public static final String ID = "org.eclipse.papyrus.properties.runtime.multipleStructuralFeaturesPropertyEditor";

	/** main composite created by this property editor */
	protected Composite composite;

	/** button to add a reference or modify existing one */
	protected Button addButton;

	/** button to remove reference */
	protected Button removeButton;

	/** table area that displays the reference name or toString */
	protected Table referenceArea;

	/** table area that displays the reference name or toString */
	protected TableViewer referencesViewer;

	/** current Value */
	protected EList<EObject> currentValue;

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

		// creates label. No TOP/DOWN/etc. position, always on top
		createLabel(composite);

		// create Button area
		addButton = getWidgetFactory().createButton(composite, "", SWT.NONE);
		addButton.setImage(Activator.getImageFromDescriptor(Activator.imageDescriptorFromPlugin(Activator.ID, "icons/Add_12x12.gif")));
		data = new GridData(SWT.FILL, SWT.CENTER, false, false);
		addButton.setLayoutData(data);
		addButton.addMouseListener(new MouseListener() {

			/**
			 * {@inheritDoc}
			 */
			public void mouseUp(MouseEvent e) {
				// pops up a window to ask for a new reference
				Display tmp = Display.getCurrent();
				if(tmp == null && PlatformUI.isWorkbenchRunning()) {
					tmp = PlatformUI.getWorkbench().getDisplay();
				}
				final Display display = (tmp != null) ? tmp : Display.getDefault();

				// 2 possibilities:
				// we can create only one type of element, so the element is created, and then, a pop up dialog is displayed
				// several elements can be created (ex: nestedClassifiers for a class, we can create a class or an interface or any implementation of classifier
				if(getController() instanceof IWizardPropertyEditorController) {
					List<IUndoableOperation> availableCommands = ((IWizardPropertyEditorController)getController()).getAvailableCreationOperations();
					if(availableCommands.isEmpty()) {
						Activator.log.warn("no command was available to create elements for this view");
						return;
					} else if(availableCommands.size() == 1) {
						// only one command is available, create the element
						try {
							OperationHistoryFactory.getOperationHistory().execute(availableCommands.get(0), new NullProgressMonitor(), null);
						} catch (ExecutionException e1) {
							Activator.log.error(e1);
						}
					} else if(availableCommands.size() > 1) {
						Menu menu = new Menu(addButton);
						for(final IUndoableOperation operation : availableCommands) {
							MenuItem item = new MenuItem(menu, SWT.NONE);
							item.setText(operation.getLabel());
							item.addSelectionListener(new SelectionListener() {

								public void widgetSelected(SelectionEvent e) {
									MessageDialog.openConfirm(display.getActiveShell(), "This is a debug message", "create with operation " + operation.getLabel());
								}

								public void widgetDefaultSelected(SelectionEvent e) {

								}
							});
						}
					}
				}
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

		removeButton = getWidgetFactory().createButton(composite, "", SWT.NONE);
		removeButton.setImage(Activator.getImageFromDescriptor(Activator.imageDescriptorFromPlugin(Activator.ID, "icons/Delete_12x12.gif")));
		data = new GridData(SWT.FILL, SWT.CENTER, false, false);
		removeButton.setLayoutData(data);
		removeButton.addMouseListener(new MouseListener() {

			/**
			 * {@inheritDoc}
			 */
			public void mouseUp(MouseEvent e) {
				// TODO implement remove action
				// use selection to remove element
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

		Button upButton = getWidgetFactory().createButton(composite, "", SWT.NONE);
		upButton.setImage(Activator.getImageFromDescriptor(Activator.imageDescriptorFromPlugin(Activator.ID, "icons/Up_12x12.gif")));
		data = new GridData(SWT.FILL, SWT.CENTER, false, false);
		upButton.setLayoutData(data);
		upButton.addMouseListener(new MouseListener() {

			/**
			 * {@inheritDoc}
			 */
			public void mouseUp(MouseEvent e) {
				// TODO implement UP action
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

		Button downButton = getWidgetFactory().createButton(composite, "", SWT.NONE);
		downButton.setImage(Activator.getImageFromDescriptor(Activator.imageDescriptorFromPlugin(Activator.ID, "icons/Down_12x12.gif")));
		data = new GridData(SWT.FILL, SWT.CENTER, false, false);
		downButton.setLayoutData(data);
		downButton.addMouseListener(new MouseListener() {

			/**
			 * {@inheritDoc}
			 */
			public void mouseUp(MouseEvent e) {
				// TODO implement down button			
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

		// creates table for the display of references
		referenceArea = new Table(composite, SWT.BORDER);
		data = new GridData(SWT.FILL, SWT.FILL, true, true, 5, 1);
		data.heightHint = 80;
		referenceArea.setLayoutData(data);
		referencesViewer = new TableViewer(referenceArea);
		referencesViewer.setContentProvider(new IStructuredContentProvider() {

			/**
			 * {@inheritDoc}
			 */
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

			}

			/**
			 * {@inheritDoc}
			 */
			public void dispose() {

			}

			/**
			 * {@inheritDoc}
			 */
			public Object[] getElements(Object inputElement) {
				if(inputElement instanceof List<?>) {
					return ((List<?>)inputElement).toArray();
				}
				return new Object[0];
			}
		});
		referencesViewer.setLabelProvider(((ILabelProviderController)getController()).getEditorLabelProvider());
		return composite;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createLabel(Composite parent) {
		GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		return createLabel(parent, data);
	}

	/**
	 * Returns the number of column for the composite
	 * 
	 * @return the number of column for the composite
	 */
	protected int getColumnNumber() {
		return 5;
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
		return Status.OK_STATUS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<EObject> getValue() {
		if(isValid(referenceArea)) {
			return currentValue;
		} else {
			Activator.log.error("trying to read the value of the reference area whereas the combo is disposed", null);
		}
		return Collections.emptyList();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void setValue(Object valueToEdit) {
		if(!isValid(referenceArea)) {
			return;
		}
		if(valueToEdit instanceof EList<?>) {
			currentValue = (EList<EObject>)valueToEdit;
		} else {
			Activator.log.error("Waiting for a list of EObject", null);
		}
		referencesViewer.setInput((valueToEdit != null) ? valueToEdit : Collections.emptyList());
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

}
