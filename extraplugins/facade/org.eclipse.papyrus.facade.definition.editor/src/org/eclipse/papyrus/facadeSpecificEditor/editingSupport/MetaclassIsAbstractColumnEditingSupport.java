package org.eclipse.papyrus.facadeSpecificEditor.editingSupport;


import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage;
import org.eclipse.papyrus.facadeSpecificEditor.metamodel.MetamodelUtils;
import org.eclipse.swt.widgets.Composite;

public class MetaclassIsAbstractColumnEditingSupport extends EditingSupport {

	protected AdapterFactoryEditingDomain editingDomain;

	protected Composite parent;

	public MetaclassIsAbstractColumnEditingSupport(ColumnViewer viewer, AdapterFactoryEditingDomain editingDomain, Composite parent) {
		super(viewer);
		this.editingDomain = editingDomain;
		this.parent = parent;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		if(element instanceof VirtualMetaclass) {

			if(MetamodelUtils.canBeAbstract((VirtualMetaclass)element)) {
				return new CheckboxCellEditor(parent);
			}
		}

		return null;
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected Object getValue(Object element) {
		if(element instanceof VirtualMetaclass) {
			return Boolean.valueOf(((VirtualMetaclass)element).isAbstract());
		}
		return null;
	}

	@Override
	protected void setValue(Object element, Object value) {
		if(element instanceof VirtualMetaclass) {

			SetCommand command = new SetCommand(editingDomain, (VirtualMetaclass)element, VirtualmetamodelPackage.eINSTANCE.getVirtualMetaclass_Abstract(), (Boolean)value); //$NON-NLS-1$
			editingDomain.getCommandStack().execute(command);
			getViewer().refresh();

		}

	}

}
