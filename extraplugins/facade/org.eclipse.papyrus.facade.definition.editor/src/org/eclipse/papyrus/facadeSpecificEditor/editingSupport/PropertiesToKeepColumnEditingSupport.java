package org.eclipse.papyrus.facadeSpecificEditor.editingSupport;

import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage;
import org.eclipse.swt.widgets.Composite;

public class PropertiesToKeepColumnEditingSupport extends EditingSupport {

	protected AdapterFactoryEditingDomain editingDomain;

	protected Composite parent;

	public PropertiesToKeepColumnEditingSupport(ColumnViewer viewer, AdapterFactoryEditingDomain editingDomain, Composite parent) {
		super(viewer);
		this.editingDomain = editingDomain;
		this.parent = parent;
	}

	@Override
	protected void setValue(Object element, Object value) {
		if(element instanceof VirtualElement) {

			SetCommand command = new SetCommand(editingDomain, (VirtualElement)element, VirtualmetamodelPackage.eINSTANCE.getVirtualElement_Kept(), (Boolean)value); //$NON-NLS-1$
			editingDomain.getCommandStack().execute(command);
			getViewer().refresh();

		}
	}

	@Override
	protected Object getValue(Object element) {
		if(element instanceof VirtualElement) {

			return Boolean.valueOf(((VirtualElement)element).isKept());

		}
		return null;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {

		return new CheckboxCellEditor(parent);


	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

}
