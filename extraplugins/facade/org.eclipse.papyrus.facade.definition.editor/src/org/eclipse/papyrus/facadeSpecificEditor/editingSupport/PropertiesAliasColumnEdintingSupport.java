package org.eclipse.papyrus.facadeSpecificEditor.editingSupport;

import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage;
import org.eclipse.swt.widgets.Composite;

public class PropertiesAliasColumnEdintingSupport extends EditingSupport {

	protected AdapterFactoryEditingDomain editingDomain;

	protected Composite parent;

	public PropertiesAliasColumnEdintingSupport(ColumnViewer viewer, AdapterFactoryEditingDomain editingDomain, Composite parent) {
		super(viewer);
		this.editingDomain = editingDomain;
		this.parent = parent;
	}

	@Override
	protected void setValue(Object element, Object value) {
		if(element instanceof VirtualProperty) {
			//			if(!(((VirtualProperty)element).getRepresentedElement() instanceof Property)) {
			SetCommand command = new SetCommand(editingDomain, (VirtualProperty)element, VirtualmetamodelPackage.eINSTANCE.getVirtualElement_AliasName(), (String)value); //$NON-NLS-1$
			editingDomain.getCommandStack().execute(command);
			getViewer().refresh();
			//			}
		}
	}

	@Override
	protected Object getValue(Object element) {
		if(element instanceof VirtualProperty) {
			//			if(!(((VirtualProperty)element).getRepresentedElement() instanceof Property)) {
			if(((VirtualProperty)element).getAliasName() == null) {
				return "";
			} else {
				return ((VirtualProperty)element).getAliasName();
			}
			//			}
		}
		return null;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		//		if(!(((VirtualProperty)element).getRepresentedElement() instanceof Property)) {
		return new TextCellEditor(parent);
		//		} else {
		//			return null;
		//		}
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

}
