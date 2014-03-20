/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.editor;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.edit.gui.AbstractDialogCellEditor;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer.MoveDirectionEnum;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.ITableAxisElementProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.Cell;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.widgets.editors.TreeSelectorDialog;
import org.eclipse.papyrus.infra.widgets.providers.EncapsulatedContentProvider;
import org.eclipse.papyrus.uml.nattable.utils.UMLTableUtils;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLFilteredLabelProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * 
 * This dialog is used to edit the single reference
 * 
 */
public class SingleReferenceValueCellEditor extends AbstractDialogCellEditor {

	/**
	 * the selected value
	 */
	private EObject returnedValue;

	/**
	 * the table axis element provider
	 */
	protected ITableAxisElementProvider manager;

	/**
	 * the axis element
	 */
	private Object axisElement;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param axisElement
	 *        the axis element
	 * @param elementProvider
	 *        the table axis element provider
	 */
	public SingleReferenceValueCellEditor(final Object axisElement, final ITableAxisElementProvider elementProvider) {
		this.axisElement = axisElement;
		this.manager = elementProvider;
	}


	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.edit.gui.AbstractDialogCellEditor#open()
	 * 
	 * @return
	 */
	@Override
	public int open() {
		int result = ((TreeSelectorDialog)this.dialog).open();
		if (manager instanceof IAdaptable) {
			NatTable nattable = (NatTable) ((IAdaptable) manager).getAdapter(NatTable.class);
			if (nattable != null && !nattable.isDisposed()) {
				nattable.forceFocus();
			}
		}
		return result;
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.edit.gui.AbstractDialogCellEditor#createDialogInstance()
	 * 
	 * @return
	 */
	@Override
	public Object createDialogInstance() {
		int columnIndex = this.layerCell.getColumnIndex();
		int rowIndex = this.layerCell.getRowIndex();
		Object row = this.manager.getRowElement(rowIndex);
		Object column = this.manager.getColumnElement(columnIndex);
		row = AxisUtils.getRepresentedElement(row);
		column = AxisUtils.getRepresentedElement(column);
		Element editedElement = null;
		Object feature = null;
		if(row instanceof EObject && column == this.axisElement) {
			editedElement = (Element)row;
			feature = column;
		} else {
			editedElement = (Element)column;
			feature = row;
		}

		Cell cell = ((INattableModelManager)manager).getCell(column, row);//FIXME : move this method in this interface

		EStructuralFeature realFeature = null;
		EObject realEditedObject = null;
		Stereotype stereotype = null;
		List<Stereotype> stereotypesWithEditedFeatureAppliedOnElement = null;
		if(feature instanceof EStructuralFeature) {
			realFeature = (EStructuralFeature)feature;
			realEditedObject = editedElement;
		} else {
			final String id = AxisUtils.getPropertyId(this.axisElement);
			stereotypesWithEditedFeatureAppliedOnElement = UMLTableUtils.getAppliedStereotypesWithThisProperty(editedElement, id);
			stereotype = stereotypesWithEditedFeatureAppliedOnElement.get(0);
			realEditedObject = editedElement.getStereotypeApplication(stereotypesWithEditedFeatureAppliedOnElement.get(0));
			Property prop = UMLTableUtils.getRealStereotypeProperty(editedElement, id);
			realFeature = realEditedObject.eClass().getEStructuralFeature(prop.getName());
		}
		if(stereotypesWithEditedFeatureAppliedOnElement != null && stereotypesWithEditedFeatureAppliedOnElement.size() > 1) {
			//TODO : not yet managed
		} else {
			this.dialog = createDialog(realEditedObject, realFeature, stereotype, editedElement.eResource().getResourceSet(), cell);
		}
		return this.dialog;
	}

	/**
	 * 
	 * @param realEditedObject
	 *        the real edited object : the stereotype application or the edited Element
	 * @param realFeature
	 *        the real edited feature : the feature of the stereotype application or the the feature of the edited Element
	 * @param stereotype
	 *        the stereotype if we are are editing a stereotype application
	 * @param resourceSet
	 *        the resourceset
	 * @param cell
	 *        the cell which contains problems (or <code>null</code>)
	 * @return
	 *         the dialog to edit the property
	 */
	protected Object createDialog(EObject realEditedObject, EStructuralFeature realFeature, Stereotype stereotype, ResourceSet resourceSet, final Cell cell) {
		final UMLContentProvider p = new UMLContentProvider(realEditedObject, realFeature, stereotype, resourceSet);
		final StringBuffer dialogTitle = new StringBuffer(realFeature.getName());
		if(dialogTitle.length() > 0) {
			String first = dialogTitle.substring(0, 1).toUpperCase();
			dialogTitle.replace(0, 1, first);
		}
		final Object value = realEditedObject.eGet(realFeature);

		final TreeSelectorDialog dialog = new TreeSelectorDialog(Display.getDefault().getActiveShell()) {

			/**
			 * 
			 * @see org.eclipse.papyrus.infra.widgets.editors.TreeSelectorDialog#okPressed()
			 * 
			 */
			@Override
			public void okPressed() {
				super.okPressed();
				SingleReferenceValueCellEditor.this.returnedValue = (EObject)getResult()[0];
				SingleReferenceValueCellEditor.this.editHandler.commit(returnedValue, MoveDirectionEnum.NONE);
			}


			//TODO : this class must managed to problem resolution
			//TODO : create a method createContents() in TreeSelectorDialog and paste the current contents of its method create()
			//			public void createContents() {
			//
			//				if(cell != null) {
			//					Group grp = null;
			//					CLabel cLabel = null;
			//					for(final Problem pb : cell.getProblems()) {
			//						if(pb instanceof StringResolutionProblem) {
			//							final String pastedString = ((StringResolutionProblem)pb).getValueAsString();
			//							final Collection<String> unresolvedString = ((StringResolutionProblem)pb).getUnresolvedString();
			//							if(cLabel == null) {
			//								cLabel = new CLabel(getDialogArea(), SWT.NONE);
			//								cLabel.setImage(IconAndMessageDialog.getImage(DLG_IMG_MESSAGE_ERROR));
			//								cLabel.setText("Some pasted string have not been resolved. \nSelect the resolved string");
			//							}
			//							//we init the title of the label
			//							//							grp = new Group(getDialogArea(), SWT.NONE);
			//							//							grp.setText("Unresolved Pasted Strings");
			//							//							grp.setLayout(new org.eclipse.swt.layout.GridLayout());
			//							//							grp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
			//							final Group group1 = new Group(getDialogArea(), SWT.NONE);
			//							group1.setText("Full Pasted String : " + pastedString);
			//							group1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
			//							group1.setLayout(new GridLayout());
			//							//							Label label = new Label(group1, SWT.NONE);
			//							//							label.setText("Mark As Resolved");
			//							for(final String current : unresolvedString) {
			//								Button button = new Button(group1, SWT.CHECK);
			//								button.setText(current);
			//								button.addSelectionListener(new SelectionListener() {
			//
			//									@Override
			//									public void widgetSelected(SelectionEvent e) {
			//										int i = 0;
			//										i++;
			//									}
			//
			//									@Override
			//									public void widgetDefaultSelected(SelectionEvent e) {
			//										int i = 0;
			//										i++;
			//									}
			//								});
			//								GridData buttonData = new GridData(SWT.FILL, SWT.FILL, true, false);
			//								buttonData.horizontalIndent = 10;
			//								button.setLayoutData(buttonData);
			//
			//							}
			//
			//
			//
			//						}
			//					}
			//				}
			//				super.createContents();
			//			};

		};


		ITreeContentProvider provider = new EncapsulatedContentProvider(p);
		dialog.setContentProvider(provider);
		dialog.setLabelProvider(new UMLFilteredLabelProvider());
		dialog.setInitialElementSelections(Collections.singletonList(value));
		dialog.setTitle(dialogTitle.toString());
		return dialog;
	}


	@Override
	public Object getDialogInstance() {
		return this.dialog;
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.edit.gui.AbstractDialogCellEditor#getEditorValue()
	 * 
	 * @return
	 */
	@Override
	public Object getEditorValue() {
		return this.returnedValue;
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.edit.gui.AbstractDialogCellEditor#setEditorValue(java.lang.Object)
	 * 
	 * @param value
	 */
	@Override
	public void setEditorValue(Object value) {

	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.edit.gui.AbstractDialogCellEditor#close()
	 * 
	 */
	@Override
	public void close() {
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.edit.gui.AbstractDialogCellEditor#isClosed()
	 * 
	 * @return
	 */
	@Override
	public boolean isClosed() {
		return false;
	}

}
