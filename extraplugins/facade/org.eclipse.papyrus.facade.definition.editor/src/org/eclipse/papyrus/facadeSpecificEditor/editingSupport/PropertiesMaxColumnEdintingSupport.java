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

public class PropertiesMaxColumnEdintingSupport extends EditingSupport {

	protected AdapterFactoryEditingDomain editingDomain;

	protected Composite parent;

	public PropertiesMaxColumnEdintingSupport(ColumnViewer viewer, AdapterFactoryEditingDomain editingDomain, Composite parent) {
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
						int upperReference = 0;

						if(((VirtualProperty)element).getRepresentedElement() instanceof Property) {
							upperReference = ((Property)((VirtualProperty)element).getRepresentedElement()).getUpper();

						} else if(((VirtualProperty)element).getRepresentedElement() instanceof EStructuralFeature) {
							upperReference = ((EStructuralFeature)((VirtualProperty)element).getRepresentedElement()).getUpperBound();
						}

						if(upperReference != -1) {
							if(intValue != -1) {
								if(intValue <= upperReference) {
									isOk = true;
								}
							}

						} else {
							isOk = true;
						}

						if(isOk) {
							SetCommand command = new SetCommand(editingDomain, (VirtualProperty)element, VirtualmetamodelPackage.eINSTANCE.getVirtualProperty_Upper(), intValue); //$NON-NLS-1$
							editingDomain.getCommandStack().execute(command);
							getViewer().refresh();
						} else {
							MessageDialog.openWarning(Display.getCurrent().getActiveShell(), "Problem with upper bound", "Custom upper bound must be <= " + upperReference);
						}
					} else {
						MessageDialog.openWarning(Display.getCurrent().getActiveShell(), "Problem with upper bound", "Upper bound must be an between [-1 and +inf[");
					}
				}

			} catch (NumberFormatException ex) {
				MessageDialog.openWarning(Display.getCurrent().getActiveShell(), "Problem with upper bound", "Lower bound must be an integer.");
			}
		}
	}

	@Override
	protected Object getValue(Object element) {
		if(element instanceof VirtualProperty) {

			return ((VirtualProperty)element).getUpper() + "";

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
