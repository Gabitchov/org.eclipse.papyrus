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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facadeSpecificEditor.editingSupport;

import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage;
import org.eclipse.swt.widgets.Composite;

public class MetaclassUseRepresentedColumnEditingSupport extends EditingSupport {

	protected AdapterFactoryEditingDomain editingDomain;

	protected Composite parent;

	public MetaclassUseRepresentedColumnEditingSupport(ColumnViewer viewer, AdapterFactoryEditingDomain editingDomain, Composite parent) {
		super(viewer);
		this.editingDomain = editingDomain;
		this.parent = parent;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#getCellEditor(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	protected CellEditor getCellEditor(Object element) {
		if(element instanceof VirtualElement) {
			return new CheckboxCellEditor(parent);
		}

		return null;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#canEdit(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#getValue(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	protected Object getValue(Object element) {
		if(element instanceof VirtualElement) {
			return Boolean.valueOf(((VirtualElement)element).isUseRepresented());
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#setValue(java.lang.Object, java.lang.Object)
	 * 
	 * @param element
	 * @param value
	 */
	@Override
	protected void setValue(Object element, Object value) {
		if(element instanceof VirtualMetaclass) {

			SetCommand command = new SetCommand(editingDomain, (VirtualMetaclass)element, VirtualmetamodelPackage.eINSTANCE.getVirtualElement_UseRepresented(), (Boolean)value); //$NON-NLS-1$
			editingDomain.getCommandStack().execute(command);
			getViewer().refresh();

		}
	}
}
