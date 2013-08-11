package org.eclipse.papyrus.facadeSpecificEditor.editingSupport;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.papyrus.facade.Facade;
import org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage;
import org.eclipse.papyrus.facadeSpecificEditor.utils.ProfileUtils;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Stereotype;

public class IsPossibleColumnEditingSupport extends EditingSupport {

	protected AdapterFactoryEditingDomain editingDomain;

	protected Composite parent;

	public IsPossibleColumnEditingSupport(ColumnViewer viewer, AdapterFactoryEditingDomain editingDomain, Composite parent) {
		super(viewer);
		this.editingDomain = editingDomain;
		this.parent = parent;
	}

	protected void transformPossibleIntoImpossible(BaseMetaclass element) {
		SetCommand command = new SetCommand(editingDomain, element, ExtensiondefinitionPackage.eINSTANCE.getBaseMetaclass_Possible(), false);
		editingDomain.getCommandStack().execute(command);

	}

	protected void transformImpossibleIntoPossible(BaseMetaclass element) {

		SetCommand command = new SetCommand(editingDomain, element, ExtensiondefinitionPackage.eINSTANCE.getBaseMetaclass_Possible(), true);
		editingDomain.getCommandStack().execute(command);

	}

	protected void transformAllPossibleIntoImpossible(BaseMetaclass element) {
		Facade facade = ((BaseMetaclass)element).getExtensionDefinition().getFacade();
		transformPossibleIntoImpossible((BaseMetaclass)element);

		// All children and generals must be set to Impossible as well
		HashSet<Stereotype> siblings = ProfileUtils.getSiblings(((BaseMetaclass)element).getExtensionDefinition().getStereotype());

		for(ExtensionDefinition extensionDefinition : facade.getExtensionDefinitions()) {
			if(extensionDefinition.getExtension() == ((BaseMetaclass)element).getExtensionDefinition().getExtension()) {
				if(siblings.contains(extensionDefinition.getStereotype())) {
					for(BaseMetaclass baseMetaclass : extensionDefinition.getBaseMetaclasses())
						if(baseMetaclass.getBase() == ((BaseMetaclass)element).getBase()) {
							transformPossibleIntoImpossible(baseMetaclass);
						}
				}
			}
		}

		// Stereotype incompatibility of required extension must be updated too
		// for (ExtensionDefinition extensionDefinition : facade.getExtensionDefinitions()) {
		// if (extensionDefinition.getExtension().isRequired()) {
		// for (BaseMetaclass baseMetaclass : extensionDefinition.getBaseMetaclasses()) {
		// Combination fakeCombinaison = VirtualProfileFactory.eINSTANCE.createCombination();
		// fakeCombinaison.getMetaClasses().add(element);
		//
		// Combination combination = EditionUtils.getCombinationThatMatch(baseMetaclass.getCompatibleStereotypes(), fakeCombinaison);
		// if (combination != null) {
		// StereotypeIncompatibilityColumnEditingSupport.makeItImcompatible(baseMetaclass, combination, false);
		// }
		// }
		// }
		// }

		// EditionUtils.clearStereotypeCombinations(facade, editingDomain);
	}

	protected void transformAllImpossibleIntoPossible(BaseMetaclass element) {
		Facade facade = ((BaseMetaclass)element).getExtensionDefinition().getFacade();
		transformImpossibleIntoPossible((BaseMetaclass)element);

		// All children and generals must be set to Possible as well
		HashSet<Stereotype> siblings = ProfileUtils.getSiblings(((BaseMetaclass)element).getExtensionDefinition().getStereotype());

		for(ExtensionDefinition extensionDefinition : facade.getExtensionDefinitions()) {
			if(extensionDefinition.getExtension() == ((BaseMetaclass)element).getExtensionDefinition().getExtension()) {
				if(siblings.contains(extensionDefinition.getStereotype())) {
					for(BaseMetaclass baseMetaclass : extensionDefinition.getBaseMetaclasses())
						if(baseMetaclass.getBase() == ((BaseMetaclass)element).getBase()) {
							transformImpossibleIntoPossible(baseMetaclass);
						}
				}
			}
		}

		// Stereotype incompatibility of required extension must be updated too
		// for (ExtensionDefinition extensionDefinition : facade.getExtensionDefinitions()) {
		// if (extensionDefinition.getExtension().isRequired()) {
		// for (BaseMetaclass baseMetaclass : extensionDefinition.getBaseMetaclasses()) {
		// Combination fakeCombinaison = VirtualProfileFactory.eINSTANCE.createCombination();
		// fakeCombinaison.getMetaClasses().add(element);
		//
		// Combination combination = EditionUtils.getCombinationThatMatch(baseMetaclass.getIncompatibleStereotypes(), fakeCombinaison);
		// if (combination != null) {
		// StereotypeIncompatibilityColumnEditingSupport.makeItCompatible(baseMetaclass, combination, false);
		// }
		// }
		// }
		// }

		// EditionUtils.initStereotypeCombinations(facade, editingDomain);
	}

	@Override
	protected void setValue(final Object element, final Object value) {
		if(element instanceof BaseMetaclass) {

			if(EditionUtils.hasARequiredCombination((BaseMetaclass)element)) {
				MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Cannot change possibility", "Cannot change because it contains a required metaclass in the combinations");

			} else {

				ProgressMonitorDialog dialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
				try {
					dialog.run(false, false, new IRunnableWithProgress() {

						public void run(IProgressMonitor monitor) {
							monitor.beginTask("Updating stereotypes definitions", IProgressMonitor.UNKNOWN);

							if((Boolean)value == true) {
								transformAllImpossibleIntoPossible((BaseMetaclass)element);
							} else {
								transformAllPossibleIntoImpossible((BaseMetaclass)element);

							}

							Facade facade = ((BaseMetaclass)element).getExtensionDefinition().getFacade();

							// Clear incompatibilities that don't exist anymore
							EditionUtils.clearAllStereotypeCombinations(facade, editingDomain);
							// Init new incompatibilities
							EditionUtils.initAllStereotypeCombinations(facade, editingDomain);

							monitor.done();
						}
					});
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				getViewer().refresh();
			}
		}

	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		if(element instanceof BaseMetaclass) {
			if(!((BaseMetaclass)element).getExtensionDefinition().getExtension().isRequired()) {
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
		if(element instanceof BaseMetaclass) {
			return Boolean.valueOf(((BaseMetaclass)element).isPossible());
		}
		return null;
	}

}
