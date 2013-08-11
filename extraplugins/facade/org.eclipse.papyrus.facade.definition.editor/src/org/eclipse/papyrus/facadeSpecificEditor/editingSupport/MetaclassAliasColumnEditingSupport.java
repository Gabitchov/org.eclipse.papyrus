package org.eclipse.papyrus.facadeSpecificEditor.editingSupport;

import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage;
import org.eclipse.swt.widgets.Composite;

public class MetaclassAliasColumnEditingSupport extends EditingSupport {

	protected AdapterFactoryEditingDomain editingDomain;

	protected Composite parent;

	public MetaclassAliasColumnEditingSupport(ColumnViewer viewer, AdapterFactoryEditingDomain editingDomain, Composite parent) {
		super(viewer);
		this.editingDomain = editingDomain;
		this.parent = parent;
	}

	@Override
	protected void setValue(Object element, Object value) {
		if(element instanceof VirtualMetaclass) {
			SetCommand command = new SetCommand(editingDomain, (VirtualMetaclass)element, VirtualmetamodelPackage.eINSTANCE.getVirtualElement_AliasName(), (String)value); //$NON-NLS-1$
			editingDomain.getCommandStack().execute(command);
			getViewer().refresh();
		}
	}

	@Override
	protected Object getValue(Object element) {
		if(element instanceof VirtualMetaclass) {
			if(((VirtualMetaclass)element).getAliasName() == null) {
				return "";
			} else {
				return ((VirtualMetaclass)element).getAliasName();
			}
		}
		return null;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		return new TextCellEditor(parent);
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

}
