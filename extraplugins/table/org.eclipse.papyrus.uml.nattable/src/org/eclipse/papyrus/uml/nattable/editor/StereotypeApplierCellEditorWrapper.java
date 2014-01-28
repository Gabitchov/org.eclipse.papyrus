/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		 Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.editor;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.edit.ICellEditHandler;
import org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor;
import org.eclipse.nebula.widgets.nattable.edit.editor.IEditErrorHandler;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer.MoveDirectionEnum;
import org.eclipse.nebula.widgets.nattable.widget.EditModeEnum;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.manager.table.ITableAxisElementProvider;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.uml.nattable.utils.UMLTableUtils;
import org.eclipse.papyrus.uml.tools.commands.ApplyStereotypeCommand;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Wrapper to apply stereotypes if required before to do the edition
 * see bug 426709: [Table 2][Stereotype] Papyrus Table must allows to edit stereotype properties even if the required stereotypes is not yet applied
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=426709
 * 
 * elementProvider
 */
public class StereotypeApplierCellEditorWrapper implements ICellEditor {

	/** the wrapped celleditor. */
	protected final ICellEditor wrappedCellEditor;

	/**
	 * the edited axis
	 */
	protected final Object axisElement;

	/**
	 * the table element provider
	 */
	protected final ITableAxisElementProvider elementProvider;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param wrappedCellEditor
	 *        the wrapped cell editor
	 * @param axisElement
	 *        the edited axis
	 * @param elementProvider
	 *        the axis element provider
	 */
	public StereotypeApplierCellEditorWrapper(final ICellEditor wrappedCellEditor, final Object axisElement, final ITableAxisElementProvider elementProvider) {
		this.wrappedCellEditor = wrappedCellEditor;
		this.axisElement = axisElement;
		this.elementProvider = elementProvider;
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor#activateCell(org.eclipse.swt.widgets.Composite, java.lang.Object,
	 *      org.eclipse.nebula.widgets.nattable.widget.EditModeEnum, org.eclipse.nebula.widgets.nattable.edit.ICellEditHandler,
	 *      org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell, org.eclipse.nebula.widgets.nattable.config.IConfigRegistry)
	 * 
	 * @param parent
	 * @param originalCanonicalValue
	 * @param editMode
	 * @param editHandler
	 * @param cell
	 * @param configRegistry
	 * @return
	 */

	@Override
	public Control activateCell(Composite parent, Object originalCanonicalValue, EditModeEnum editMode, ICellEditHandler editHandler, ILayerCell cell, IConfigRegistry configRegistry) {
		int columnIndex = cell.getColumnIndex();
		int rowIndex = cell.getRowIndex();
		Object row = this.elementProvider.getRowElement(rowIndex);
		Object column = this.elementProvider.getColumnElement(columnIndex);
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

		if(!(feature instanceof EStructuralFeature)) {
			final String id = AxisUtils.getPropertyId(this.axisElement);
			applyRequiredStereotype(editedElement, id);
		}
		return this.wrappedCellEditor.activateCell(parent, originalCanonicalValue, editMode, editHandler, cell, configRegistry);
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor#getColumnIndex()
	 * 
	 * @return
	 */

	@Override
	public int getColumnIndex() {
		return this.wrappedCellEditor.getColumnIndex();
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor#getRowIndex()
	 * 
	 * @return
	 */

	@Override
	public int getRowIndex() {
		return this.wrappedCellEditor.getRowIndex();
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor#getColumnPosition()
	 * 
	 * @return
	 */

	@Override
	public int getColumnPosition() {
		return this.wrappedCellEditor.getColumnPosition();
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor#getRowPosition()
	 * 
	 * @return
	 */

	@Override
	public int getRowPosition() {
		return this.wrappedCellEditor.getRowPosition();
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor#getEditorValue()
	 * 
	 * @return
	 */

	@Override
	public Object getEditorValue() {
		return this.wrappedCellEditor.getEditorValue();
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor#setEditorValue(java.lang.Object)
	 * 
	 * @param value
	 */

	@Override
	public void setEditorValue(Object value) {
		this.wrappedCellEditor.setEditorValue(value);
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor#getCanonicalValue()
	 * 
	 * @return
	 */

	@Override
	public Object getCanonicalValue() {
		return this.wrappedCellEditor.getCanonicalValue();
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor#getCanonicalValue(org.eclipse.nebula.widgets.nattable.edit.editor.IEditErrorHandler)
	 * 
	 * @param conversionErrorHandler
	 * @return
	 */

	@Override
	public Object getCanonicalValue(IEditErrorHandler conversionErrorHandler) {
		return this.wrappedCellEditor.getCanonicalValue(conversionErrorHandler);
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor#setCanonicalValue(java.lang.Object)
	 * 
	 * @param canonicalValue
	 */

	@Override
	public void setCanonicalValue(Object canonicalValue) {
		this.wrappedCellEditor.setCanonicalValue(canonicalValue);
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor#validateCanonicalValue(java.lang.Object)
	 * 
	 * @param canonicalValue
	 * @return
	 */

	@Override
	public boolean validateCanonicalValue(Object canonicalValue) {
		return this.wrappedCellEditor.validateCanonicalValue(canonicalValue);
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor#validateCanonicalValue(java.lang.Object,
	 *      org.eclipse.nebula.widgets.nattable.edit.editor.IEditErrorHandler)
	 * 
	 * @param canonicalValue
	 * @param validationErrorHandler
	 * @return
	 */

	@Override
	public boolean validateCanonicalValue(Object canonicalValue, IEditErrorHandler validationErrorHandler) {
		return this.wrappedCellEditor.validateCanonicalValue(canonicalValue, validationErrorHandler);
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor#commit(org.eclipse.nebula.widgets.nattable.selection.SelectionLayer.MoveDirectionEnum)
	 * 
	 * @param direction
	 * @return
	 */

	@Override
	public boolean commit(MoveDirectionEnum direction) {
		return this.wrappedCellEditor.commit(direction);
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor#commit(org.eclipse.nebula.widgets.nattable.selection.SelectionLayer.MoveDirectionEnum,
	 *      boolean)
	 * 
	 * @param direction
	 * @param closeAfterCommit
	 * @return
	 */

	@Override
	public boolean commit(MoveDirectionEnum direction, boolean closeAfterCommit) {
		return this.wrappedCellEditor.commit(direction, closeAfterCommit);
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor#commit(org.eclipse.nebula.widgets.nattable.selection.SelectionLayer.MoveDirectionEnum,
	 *      boolean, boolean)
	 * 
	 * @param direction
	 * @param closeAfterCommit
	 * @param skipValidation
	 * @return
	 */

	@Override
	public boolean commit(MoveDirectionEnum direction, boolean closeAfterCommit, boolean skipValidation) {
		return this.wrappedCellEditor.commit(direction, closeAfterCommit, skipValidation);
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor#close()
	 * 
	 */

	@Override
	public void close() {
		this.wrappedCellEditor.close();
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor#isClosed()
	 * 
	 * @return
	 */

	@Override
	public boolean isClosed() {
		return this.wrappedCellEditor.isClosed();
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor#getEditorControl()
	 * 
	 * @return
	 */

	@Override
	public Control getEditorControl() {
		return this.wrappedCellEditor.getEditorControl();
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor#createEditorControl(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 * @return
	 */

	@Override
	public Control createEditorControl(Composite parent) {
		return this.wrappedCellEditor.createEditorControl(parent);
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor#openInline(org.eclipse.nebula.widgets.nattable.config.IConfigRegistry,
	 *      java.util.List)
	 * 
	 * @param configRegistry
	 * @param configLabels
	 * @return
	 */

	@Override
	public boolean openInline(IConfigRegistry configRegistry, List<String> configLabels) {
		return this.wrappedCellEditor.openInline(configRegistry, configLabels);
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor#supportMultiEdit(org.eclipse.nebula.widgets.nattable.config.IConfigRegistry,
	 *      java.util.List)
	 * 
	 * @param configRegistry
	 * @param configLabels
	 * @return
	 */

	@Override
	public boolean supportMultiEdit(IConfigRegistry configRegistry, List<String> configLabels) {
		return this.wrappedCellEditor.supportMultiEdit(configRegistry, configLabels);
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor#openAdjacentEditor()
	 * 
	 * @return
	 */

	@Override
	public boolean openAdjacentEditor() {
		return this.wrappedCellEditor.openAdjacentEditor();
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor#activateAtAnyPosition()
	 * 
	 * @return
	 */

	@Override
	public boolean activateAtAnyPosition() {
		return this.wrappedCellEditor.activateAtAnyPosition();
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor#addEditorControlListeners()
	 * 
	 */

	@Override
	public void addEditorControlListeners() {
		this.wrappedCellEditor.addEditorControlListeners();
	}

	/**
	 * Removes the editor control listeners.
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor#removeEditorControlListeners()
	 */

	@Override
	public void removeEditorControlListeners() {
		this.wrappedCellEditor.removeEditorControlListeners();
	}

	/**
	 * 
	 * @param el
	 *        an element of the model
	 * @param propertyId
	 *        the id of the edited property
	 * @return <code>true</code> if a stereotype has been applied
	 */
	private static final boolean applyRequiredStereotype(final Element el, final String propertyId) {
		if(UMLTableUtils.getAppliedStereotypesWithThisProperty(el, propertyId).size() == 0) {
			final List<Stereotype> stereotypesList = UMLTableUtils.getApplicableStereotypesWithThisProperty(el, propertyId);
			if(stereotypesList.size() == 1) {
				TransactionalEditingDomain domain = null;
				try {
					domain = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(el);
					final ApplyStereotypeCommand applyCommand = new ApplyStereotypeCommand(el, stereotypesList.get(0), domain);
					domain.getCommandStack().execute(applyCommand);
					return true;
				} catch (ServiceException e) {
					Activator.log.error("EditingDomain not found", e); //$NON-NLS-1$
				}
			}
		}
		return false;
	}

}
