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

	@Override
	protected void setValue(Object element, Object value) {
		if(element instanceof VirtualElement) {

			VirtualMetamodel metamodel = facade.getVirtualmetamodel();

			if(PrunerUtils.canBeUnkept((VirtualElement)element, metamodel)) {
				SetCommand command = new SetCommand(editingDomain, (VirtualElement)element, VirtualmetamodelPackage.eINSTANCE.getVirtualElement_Kept(), (Boolean)value); //$NON-NLS-1$
				editingDomain.getCommandStack().execute(command);
				getViewer().refresh();
			}


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
