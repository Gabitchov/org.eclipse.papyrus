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

import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.papyrus.views.properties.runtime.controller.IBoundedValuesController;
import org.eclipse.papyrus.views.properties.runtime.controller.PropertyEditorController;


/**
 * Property editor for references that have multiplicity [n..*]
 */
public class MultipleReferencePropertyEditor extends AbstractTablePropertyEditor {

	/** id of this editor */
	public static final String ID = "org.eclipse.papyrus.views.properties.runtime.multipleReferencePropertyEditor";

	//	/**
	//	 * {@inheritDoc}
	//	 */
	//	@Override
	//	public Composite createContent(Composite parent) {
	//		composite = getWidgetFactory().createComposite(parent, SWT.NONE);
	//		int columnNu = getColumnNumber();
	//		GridLayout layout = new GridLayout(columnNu, false);
	//		layout.marginHeight = 0;
	//		layout.marginWidth = 0;
	//		composite.setLayout(layout);
	//		GridData data = new GridData(SWT.FILL, SWT.FILL, true, false);
	//		composite.setLayoutData(data);
	//
	//		// creates label. No TOP/DOWN/etc. position, always on top
	//		createLabel(composite);
	//
	//		if(!getIsReadOnly()) {
	//			// create Button area
	//			addButton = getWidgetFactory().createButton(composite, "", SWT.NONE);
	//			addButton.setImage(Activator.getImageFromDescriptor(Activator.imageDescriptorFromPlugin(Activator.ID, "icons/Add_12x12.gif")));
	//			data = new GridData(SWT.FILL, SWT.CENTER, false, false);
	//			addButton.setLayoutData(data);
	//			addButton.addMouseListener(new MouseListener() {
	//
	//				/**
	//				 * {@inheritDoc}
	//				 */
	//				@SuppressWarnings("unchecked")
	//				public void mouseUp(MouseEvent e) {
	//					PER
	//				}
	//
	//				/**
	//				 * {@inheritDoc}
	//				 */
	//				public void mouseDown(MouseEvent e) {
	//				}
	//
	//				/**
	//				 * {@inheritDoc}
	//				 */
	//				public void mouseDoubleClick(MouseEvent e) {
	//				}
	//			});
	//
	//			removeButton = getWidgetFactory().createButton(composite, "", SWT.NONE);
	//			removeButton.setImage(Activator.getImageFromDescriptor(Activator.imageDescriptorFromPlugin(Activator.ID, "icons/Delete_12x12.gif")));
	//			data = new GridData(SWT.FILL, SWT.CENTER, false, false);
	//			removeButton.setLayoutData(data);
	//			removeButton.addMouseListener(new MouseListener() {
	//
	//				/**
	//				 * {@inheritDoc}
	//				 */
	//				public void mouseUp(MouseEvent e) {
	//					if(!(getController() instanceof IWizardPropertyEditorController)) {
	//						return;
	//					}
	//					// use selection to remove element
	//					// retrieve selected element(s)
	//					IStructuredSelection selection = (IStructuredSelection)referencesViewer.getSelection();
	//					if(selection == null || selection.isEmpty()) {
	//						// nothing selected. 
	//						return;
	//					}
	//
	//					// copy current value
	//					List<EObject> values = new ArrayList<EObject>(currentValue);
	//					// remove selected elements from values
	//					values.removeAll(selection.toList());
	//
	//					currentValue = values;
	//					getController().updateModel();
	//
	//				}
	//
	//				/**
	//				 * {@inheritDoc}
	//				 */
	//				public void mouseDown(MouseEvent e) {
	//
	//				}
	//
	//				/**
	//				 * {@inheritDoc}
	//				 */
	//				public void mouseDoubleClick(MouseEvent e) {
	//
	//				}
	//			});
	//
	//			if(getController().canMoveValues(new ArrayList<Integer>(), 0)) { // only checks if elements can be moved, not real move, so a 0-delta is fine
	//				Button upButton = getWidgetFactory().createButton(composite, "", SWT.NONE);
	//				upButton.setImage(Activator.getImageFromDescriptor(Activator.imageDescriptorFromPlugin(Activator.ID, "icons/Up_12x12.gif")));
	//				data = new GridData(SWT.FILL, SWT.CENTER, false, false);
	//				upButton.setLayoutData(data);
	//				upButton.addMouseListener(new MouseListener() {
	//
	//					/**
	//					 * {@inheritDoc}
	//					 */
	//					public void mouseUp(MouseEvent e) {
	//						int[] selectionIndices = referencesViewer.getTable().getSelectionIndices();
	//						final List<Integer> selectionList = new ArrayList<Integer>();
	//						final List<Integer> newSelectionList = new ArrayList<Integer>();
	//						for(int i : selectionIndices) {
	//							selectionList.add(i);
	//							newSelectionList.add(i - 1);
	//						}
	//						IUndoableOperation moveOperation = getController().getMoveCurrentValuesOperation(selectionList, -1);
	//						if(moveOperation != null && moveOperation.canExecute()) {
	//							try {
	//								CheckedOperationHistory.getInstance().execute(moveOperation, new NullProgressMonitor(), null);
	//								// try to restore selection in the view
	//								int[] newSelection = new int[newSelectionList.size()];
	//								for(int i = 0; i < newSelectionList.size(); i++) {
	//									newSelection[i] = newSelectionList.get(i);
	//								}
	//								referencesViewer.getTable().select(newSelection);
	//							} catch (ExecutionException e1) {
	//								Activator.log.error(e1);
	//							}
	//						}
	//					}
	//
	//					/**
	//					 * {@inheritDoc}
	//					 */
	//					public void mouseDown(MouseEvent e) {
	//					}
	//
	//					/**
	//					 * {@inheritDoc}
	//					 */
	//					public void mouseDoubleClick(MouseEvent e) {
	//					}
	//				});
	//
	//				Button downButton = getWidgetFactory().createButton(composite, "", SWT.NONE);
	//				downButton.setImage(Activator.getImageFromDescriptor(Activator.imageDescriptorFromPlugin(Activator.ID, "icons/Down_12x12.gif")));
	//				data = new GridData(SWT.FILL, SWT.CENTER, false, false);
	//				downButton.setLayoutData(data);
	//				downButton.addMouseListener(new MouseListener() {
	//
	//					/**
	//					 * {@inheritDoc}
	//					 */
	//					public void mouseUp(MouseEvent e) {
	//						// use selection to remove element
	//						// retrieve selected element(s)
	//						int[] selectionIndices = referencesViewer.getTable().getSelectionIndices();
	//						final List<Integer> selectionList = new ArrayList<Integer>();
	//						final List<Integer> newSelectionList = new ArrayList<Integer>();
	//						for(int i : selectionIndices) {
	//							selectionList.add(i);
	//							newSelectionList.add(i + 1);
	//						}
	//						IUndoableOperation moveOperation = getController().getMoveCurrentValuesOperation(selectionList, +1);
	//						if(moveOperation != null && moveOperation.canExecute()) {
	//							try {
	//								CheckedOperationHistory.getInstance().execute(moveOperation, new NullProgressMonitor(), null);
	//								// try to restore selection in the view
	//								int[] newSelection = new int[newSelectionList.size()];
	//								for(int i = 0; i < newSelectionList.size(); i++) {
	//									newSelection[i] = newSelectionList.get(i);
	//								}
	//								referencesViewer.getTable().select(newSelection);
	//							} catch (ExecutionException e1) {
	//								Activator.log.error(e1);
	//							}
	//						}
	//					}
	//
	//					/**
	//					 * {@inheritDoc}
	//					 */
	//					public void mouseDown(MouseEvent e) {
	//					}
	//
	//					/**
	//					 * {@inheritDoc}
	//					 */
	//					public void mouseDoubleClick(MouseEvent e) {
	//					}
	//				});
	//			}
	//		}
	//
	//		// creates table for the display of references
	//		referenceArea = new Table(composite, SWT.BORDER | SWT.MULTI);
	//		data = new GridData(SWT.FILL, SWT.FILL, true, true, columnNu, 1);
	//		data.heightHint = 80;
	//		referenceArea.setLayoutData(data);
	//		referencesViewer = new TableViewer(referenceArea);
	//		referencesViewer.setContentProvider(new IStructuredContentProvider() {
	//
	//			/**
	//			 * {@inheritDoc}
	//			 */
	//			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	//
	//			}
	//
	//			/**
	//			 * {@inheritDoc}
	//			 */
	//			public void dispose() {
	//
	//			}
	//
	//			/**
	//			 * {@inheritDoc}
	//			 */
	//			public Object[] getElements(Object inputElement) {
	//				if(inputElement instanceof List<?>) {
	//					return ((List<?>)inputElement).toArray();
	//				}
	//				return new Object[0];
	//			}
	//		});
	//		referencesViewer.setLabelProvider(((IBoundedValuesController)getController()).getEditorLabelProvider());
	//
	//		referencesViewer.getControl().setToolTipText(getTooltipText());
	//
	//		return composite;
	//	}

	//	/**
	//	 * {@inheritDoc}
	//	 */
	//	@Override
	//	protected Control createLabel(Composite parent) {
	//		GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
	//		return createLabel(parent, data);
	//	}
	//
	//	/**
	//	 * Returns the number of column for the composite
	//	 * 
	//	 * @return the number of column for the composite
	//	 */
	//	protected int getColumnNumber() {
	//		if(getIsReadOnly()) {
	//			return 1;
	//		}
	//		if(getController().canMoveValues(new ArrayList<Integer>(), 0)) {
	//			return 5;
	//		}
	//		return 3;
	//	}

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
	protected EditingSupport createEditingSupport() {
		return null;
	}

	//	/**
	//	 * {@inheritDoc}
	//	 */
	//	@Override
	//	public void handleContentChanged() {
	//		// this should tells the controller that the input has to be applied to the model
	//		getController().updateModel();
	//	}
	//
	//	/**
	//	 * {@inheritDoc}
	//	 */
	//	@Override
	//	public IStatus init(IPropertyEditorDescriptor descriptor) {
	//		setDescriptor(descriptor);
	//		setTooltipText(descriptor.getTooltipText());
	//		return Status.OK_STATUS;
	//	}
	//
	//	/**
	//	 * {@inheritDoc}
	//	 */
	//	@Override
	//	public List<EObject> getValue() {
	//		if(isValid(referenceArea)) {
	//			return currentValue;
	//		} else {
	//			Activator.log.error("trying to read the value of the reference area whereas the combo is disposed", null);
	//		}
	//		return Collections.emptyList();
	//	}
	//
	//	/**
	//	 * {@inheritDoc}
	//	 */
	//	@SuppressWarnings("unchecked")
	//	@Override
	//	public void setValue(Object valueToEdit) {
	//		if(!isValid(referenceArea)) {
	//			return;
	//		}
	//		if(valueToEdit instanceof EList<?>) {
	//			currentValue = (EList<EObject>)valueToEdit;
	//		} else {
	//			Activator.log.error("Waiting for a list of EObject", null);
	//		}
	//		referencesViewer.setInput((valueToEdit != null) ? valueToEdit : Collections.emptyList());
	//	}
	//
	//	/**
	//	 * {@inheritDoc}
	//	 */
	//	@Override
	//	public void dispose() {
	//		if(isValid(composite)) {
	//			composite.dispose();
	//			composite = null;
	//			setController(null);
	//		}
	//	}
	//
	//	/**
	//	 * {@inheritDoc}
	//	 */
	//	@Override
	//	public boolean isDisposed() {
	//		if(composite == null) {
	//			return true;
	//		}
	//		return composite.isDisposed();
	//	}
}
