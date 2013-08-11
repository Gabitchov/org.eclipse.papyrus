package org.eclipse.papyrus.facadeSpecificEditor.editingSupport;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Property;

public class PropertiesMinColumnEdintingSupport extends EditingSupport {

	protected AdapterFactoryEditingDomain editingDomain;

	protected Composite parent;

	public PropertiesMinColumnEdintingSupport(ColumnViewer viewer, AdapterFactoryEditingDomain editingDomain, Composite parent) {
		super(viewer);
		this.editingDomain = editingDomain;
		this.parent = parent;
	}

	@Override
	protected void setValue(Object element, Object value) {
		if(element instanceof VirtualProperty) {

			try {

				if(((VirtualProperty)element).getRepresentedElement() instanceof Property || ((VirtualProperty)element).getRepresentedElement() instanceof EStructuralFeature) {
					boolean isOk = false;
					int intValue = Integer.valueOf((String)value);


					if(intValue >= -1) {
						int lowerReference = 0;

						if(((VirtualProperty)element).getRepresentedElement() instanceof Property) {
							lowerReference = ((Property)((VirtualProperty)element).getRepresentedElement()).getLower();

						} else if(((VirtualProperty)element).getRepresentedElement() instanceof EStructuralFeature) {
							lowerReference = ((EStructuralFeature)((VirtualProperty)element).getRepresentedElement()).getLowerBound();
						}

						if(lowerReference != -1) {
							if(intValue >= lowerReference) {
								isOk = true;
							}
						}

						if(isOk) {
							SetCommand command = new SetCommand(editingDomain, (VirtualProperty)element, VirtualmetamodelPackage.eINSTANCE.getVirtualProperty_Lower(), intValue); //$NON-NLS-1$
							editingDomain.getCommandStack().execute(command);
							getViewer().refresh();
						} else {
							MessageDialog.openWarning(Display.getCurrent().getActiveShell(), "Problem with lower bound", "Custom lower bound must be >= " + lowerReference);
						}
					} else {
						MessageDialog.openWarning(Display.getCurrent().getActiveShell(), "Problem with upper bound", "Lower bound must be an between [-1 and +inf[");
					}
				}

			} catch (NumberFormatException ex) {
				MessageDialog.openWarning(Display.getCurrent().getActiveShell(), "Problem with lower bound", "Lower bound must be an integer.");
			}
		}
	}

	@Override
	protected Object getValue(Object element) {
		if(element instanceof VirtualProperty) {

			return ((VirtualProperty)element).getLower() + "";

		}
		return null;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		if(element instanceof VirtualProperty) {
			return new TextCellEditor(parent);
		}
		return null;
	}

	@Override
	protected boolean canEdit(Object element) {
		if(element instanceof VirtualProperty) {
			return true;
		}
		return false;
	}

}
