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
import org.eclipse.papyrus.facade.Facade;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage;
import org.eclipse.papyrus.facadeSpecificEditor.utils.PrunerUtils;
import org.eclipse.swt.widgets.Composite;

public class MetaclassToKeepColumnEditingSupport extends EditingSupport {

	protected AdapterFactoryEditingDomain editingDomain;

	protected Composite parent;

	protected Facade facade;

	public MetaclassToKeepColumnEditingSupport(ColumnViewer viewer, AdapterFactoryEditingDomain editingDomain, Composite parent, Facade facade) {
		super(viewer);
		this.editingDomain = editingDomain;
		this.parent = parent;
		this.facade = facade;
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
		if(element instanceof VirtualElement) {

			VirtualMetamodel metamodel = facade.getVirtualmetamodel();

			if((Boolean)value == false) {
				if(PrunerUtils.classifierUnkeep((VirtualElement)element, metamodel, editingDomain)) {

					getViewer().refresh();
				}
			} else {
				SetCommand command = new SetCommand(editingDomain, (VirtualElement)element, VirtualmetamodelPackage.eINSTANCE.getVirtualElement_Kept(), (Boolean)value); //$NON-NLS-1$
				editingDomain.getCommandStack().execute(command);
				getViewer().refresh();
			}

		}
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
			return Boolean.valueOf(((VirtualElement)element).isKept());
		}
		return null;
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

		return new CheckboxCellEditor(parent);

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

}
