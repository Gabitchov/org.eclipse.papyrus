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

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage;
import org.eclipse.papyrus.facadeSpecificEditor.Messages;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Property;

public class PropertiesToKeepColumnEditingSupport extends EditingSupport {

	protected AdapterFactoryEditingDomain editingDomain;

	protected Composite parent;

	public PropertiesToKeepColumnEditingSupport(ColumnViewer viewer, AdapterFactoryEditingDomain editingDomain, Composite parent) {
		super(viewer);
		this.editingDomain = editingDomain;
		this.parent = parent;
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
			boolean canBeUnkept = true;
			if(element instanceof VirtualProperty) {
				if(((VirtualElement)element).getRepresentedElement() instanceof EStructuralFeature) {
					if(((EStructuralFeature)((VirtualElement)element).getRepresentedElement()).getLowerBound() > 0) {
						canBeUnkept = false;
						MessageDialog.openWarning(Display.getCurrent().getActiveShell(), Messages.PropertiesToKeepColumnEditingSupport_0, Messages.PropertiesToKeepColumnEditingSupport_1);
					}
				} else if(((VirtualElement)element).getRepresentedElement() instanceof Property) {
					if(((Property)((VirtualElement)element).getRepresentedElement()).getLower() > 0) {
						canBeUnkept = false;
						MessageDialog.openWarning(Display.getCurrent().getActiveShell(), Messages.PropertiesToKeepColumnEditingSupport_2, Messages.PropertiesToKeepColumnEditingSupport_3);
					}
				}

			}

			if(canBeUnkept) {
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
