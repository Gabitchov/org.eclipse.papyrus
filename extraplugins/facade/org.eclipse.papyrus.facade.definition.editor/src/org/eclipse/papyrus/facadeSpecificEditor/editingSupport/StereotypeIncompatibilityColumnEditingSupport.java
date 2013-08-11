package org.eclipse.papyrus.facadeSpecificEditor.editingSupport;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.facade.Facade;
import org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass;
import org.eclipse.papyrus.facade.extensiondefinition.Combination;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionFactory;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage;
import org.eclipse.papyrus.facadeSpecificEditor.FacadeSpecificEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Stereotype;

public class StereotypeIncompatibilityColumnEditingSupport extends EditingSupport {

	protected AdapterFactoryEditingDomain editingDomain;

	protected Composite parent;

	public StereotypeIncompatibilityColumnEditingSupport(ColumnViewer viewer, AdapterFactoryEditingDomain editingDomain, Composite parent) {
		super(viewer);
		this.editingDomain = editingDomain;
		this.parent = parent;
	}

	protected void transformCompatibleIntoIncompatible(BaseMetaclass baseMetaclass, Combination combinaison) {
		AddCommand command = new AddCommand(editingDomain, baseMetaclass, ExtensiondefinitionPackage.eINSTANCE.getBaseMetaclass_IncompatibleStereotypes(), combinaison); //$NON-NLS-1$
		editingDomain.getCommandStack().execute(command);
		RemoveCommand removeCommand = new RemoveCommand(editingDomain, baseMetaclass, ExtensiondefinitionPackage.eINSTANCE.getBaseMetaclass_CompatibleStereotypes(), combinaison); //$NON-NLS-1$
		editingDomain.getCommandStack().execute(removeCommand);
	}

	protected void transformAllCompatibleIntoIncompatible(BaseMetaclass baseMetaclass, Combination combinaison) {
		Facade facade = baseMetaclass.getExtensionDefinition().getFacade();

		transformCompatibleIntoIncompatible(baseMetaclass, combinaison);

		// baseMetaclass, all children and generals must be set to Compatible
		//		HashSet<Stereotype> siblings = ProfileUtils.getSiblings(baseMetaclass.getExtensionDefinition().getStereotype());
		//		for(ExtensionDefinition extensionDefinition : facade.getExtensionDefinitions()) {
		//			if(extensionDefinition.getExtension() == baseMetaclass.getExtensionDefinition().getExtension()) {
		//				if(siblings.contains(extensionDefinition.getStereotype())) {
		//					for(BaseMetaclass baseMetaclass1 : extensionDefinition.getBaseMetaclasses())
		//
		//						if(baseMetaclass1.getBase() == baseMetaclass.getBase()) {
		//							Combination combi = EditionUtils.getCombinationThatMatch(baseMetaclass1.getCompatibleStereotypes(), combinaison);
		//							if(combi != null) {
		//								transformCompatibleIntoIncompatible(baseMetaclass1, combi);
		//							} else {
		//								System.err.println("Problem to find combinaison in sibling");
		//							}
		//						}
		//				}
		//			}
		//		}
	}

	protected void transformImcompatibleIntoCompatible(BaseMetaclass baseMetaclass, Combination combinaison) {
		RemoveCommand removeCommand = new RemoveCommand(editingDomain, baseMetaclass, ExtensiondefinitionPackage.eINSTANCE.getBaseMetaclass_IncompatibleStereotypes(), combinaison); //$NON-NLS-1$
		editingDomain.getCommandStack().execute(removeCommand);
		AddCommand addCommand = new AddCommand(editingDomain, baseMetaclass, ExtensiondefinitionPackage.eINSTANCE.getBaseMetaclass_CompatibleStereotypes(), combinaison); //$NON-NLS-1$
		editingDomain.getCommandStack().execute(addCommand);
	}

	protected void transformAllImcompatibleIntoCompatible(BaseMetaclass baseMetaclass, Combination combinaison) {
		Facade facade = baseMetaclass.getExtensionDefinition().getFacade();

		transformImcompatibleIntoCompatible(baseMetaclass, combinaison);

		// baseMetaclass, all children and generals must be set to Incompatible
		//		HashSet<Stereotype> siblings = ProfileUtils.getSiblings(baseMetaclass.getExtensionDefinition().getStereotype());
		//		for(ExtensionDefinition extensionDefinition : facade.getExtensionDefinitions()) {
		//			if(extensionDefinition.getExtension() == baseMetaclass.getExtensionDefinition().getExtension()) {
		//				if(siblings.contains(extensionDefinition.getStereotype())) {
		//					for(BaseMetaclass baseMetaclass1 : extensionDefinition.getBaseMetaclasses())
		//						if(baseMetaclass1.getBase() == baseMetaclass.getBase()) {
		//							Combination combi = EditionUtils.getCombinationThatMatch(baseMetaclass1.getIncompatibleStereotypes(), combinaison);
		//							if(combi != null) {
		//								transformImcompatibleIntoCompatible(baseMetaclass1, combi);
		//							} else {
		//								System.err.println("Problem to find combinaison in sibling");
		//							}
		//						}
		//				}
		//			}
		//		}
	}

	protected BaseMetaclass findCorrespondingGeneral(BaseMetaclass containerBaseMetaClass) {

		Stereotype containerGeneral = containerBaseMetaClass.getExtensionDefinition().getExtension().getStereotype();

		Facade facade = containerBaseMetaClass.getExtensionDefinition().getFacade();

		for(ExtensionDefinition extensionDefinition : facade.getExtensionDefinitions()) {
			if(extensionDefinition.getExtension() == containerBaseMetaClass.getExtensionDefinition().getExtension()) {
				if(extensionDefinition.getStereotype() == containerGeneral) {
					for(BaseMetaclass baseMetaclass : extensionDefinition.getBaseMetaclasses()) {
						if(baseMetaclass.getBase() == containerBaseMetaClass.getBase()) {
							return baseMetaclass;
						}
					}
				}
			}
		}

		return null;

	}

	protected void proceedTheOtherWayCompatibleIntoIncompatible(Combination combination, boolean iAmNotARequired) {

		for(BaseMetaclass meta : ((Combination)combination).getMembers()) {
			// Build fake Combination that contain all the basemetaclass of the combinaison except the basemetaclass we are processing
			Combination fakeCombination = ExtensiondefinitionFactory.eINSTANCE.createCombination();
			for(BaseMetaclass metaFake : ((Combination)combination).getMembers()) {
				if(meta != metaFake) {
					fakeCombination.getMembers().add(metaFake);
				}
			}
			// fake Combination + the general basemetaclass that own this combinaison
			if(iAmNotARequired) {
				BaseMetaclass containerBaseMetaClass = (BaseMetaclass)((Combination)combination).eContainer();
				//				BaseMetaclass general = findCorrespondingGeneral(containerBaseMetaClass);
				BaseMetaclass general = containerBaseMetaClass;
				fakeCombination.getMembers().add(general);
			}

			// if (!EditionUtils.containsOnlyRequired(fakeCombination)) {
			// We go through the compatible combinaison of this basemeta and try to find the fake
			Combination combinaison = EditionUtils.getCombinationThatMatch(meta.getCompatibleStereotypes(), fakeCombination);
			if(combinaison != null) {
				transformAllCompatibleIntoIncompatible(meta, combinaison);
			} else {
				System.err.println("Problem to find combinaison CompatibleIntoIncompatible");
			}
			// }
		}
	}

	protected void proceedTheOtherWayImcompatibleIntoCompatible(Combination combination, boolean iAmNotARequired) {
		for(BaseMetaclass meta : ((Combination)combination).getMembers()) {
			// Build fake Combination that contain all the basemetaclass of the combinaison except the basemetaclass we are processing
			Combination fakeCombination = ExtensiondefinitionFactory.eINSTANCE.createCombination();
			for(BaseMetaclass metaFake : ((Combination)combination).getMembers()) {
				if(meta != metaFake) {
					fakeCombination.getMembers().add(metaFake);
				}
			}
			// fake Combination + the basemetaclass that own this combinaison
			if(iAmNotARequired) {
				BaseMetaclass containerBaseMetaClass = (BaseMetaclass)((Combination)combination).eContainer();
				//				BaseMetaclass general = findCorrespondingGeneral(containerBaseMetaClass);
				BaseMetaclass general = containerBaseMetaClass;
				fakeCombination.getMembers().add(general);
			}

			// if (!EditionUtils.containsOnlyRequired(fakeCombination)) {
			// We go through the incompatible combinaison of this basemeta and try to find the fake
			Combination combinaison = EditionUtils.getCombinationThatMatch(meta.getIncompatibleStereotypes(), fakeCombination);
			if(combinaison != null) {
				transformAllImcompatibleIntoCompatible(meta, combinaison);
			} else {
				System.err.println("Problem to find combinaison ImcompatibleIntoCompatible");
			}
			// }

		}
	}

	// protected void updateRequiredIntoIncompatible(Facade facade, BaseMetaclass baseMetaclass, Combination combination) {
	// for (ExtensionDefinition extensionDefinition : facade.getExtensionDefinitions()) {
	// if (extensionDefinition.getExtension().isRequired()) {
	// for (BaseMetaclass baseMetaclass2 : extensionDefinition.getBaseMetaclasses()) {
	// if (baseMetaclass2.getMetaclass() == baseMetaclass.getMetaclass()) {
	// // Build fake combination
	// Combination fakeCombination = FacadeMetamodelFactory.eINSTANCE.createCombination();
	// for (BaseMetaclass metaFake : combination.getMetaClasses()) {
	// fakeCombination.getMetaClasses().add(metaFake);
	// }
	// BaseMetaclass containerBaseMetaClass = (BaseMetaclass) combination.eContainer();
	// BaseMetaclass general = findCorrespondingGeneral(containerBaseMetaClass);
	// fakeCombination.getMetaClasses().add(general);
	//
	// // We go through the compatible combinaison of this basemeta and try to find the fake
	// Combination combinaison = EditionUtils.getCombinationThatMatch(baseMetaclass2.getCompatibleStereotypes(), fakeCombination);
	// if (combinaison != null) {
	// transformCompatibleIntoIncompatible(baseMetaclass2, combinaison);
	// } else {
	// System.err.println("Problem to find combinaison-update");
	// }
	// }
	//
	// }
	// }
	//
	// }
	//
	// }
	//
	// protected void updateRequiredIntoCompatible(Facade facade, BaseMetaclass baseMetaclass, Combination combination) {
	// for (ExtensionDefinition extensionDefinition : facade.getExtensionDefinitions()) {
	// if (extensionDefinition.getExtension().isRequired()) {
	// for (BaseMetaclass baseMetaclass2 : extensionDefinition.getBaseMetaclasses()) {
	// if (baseMetaclass2.getMetaclass() == baseMetaclass.getMetaclass()) {
	// // Build fake combination
	// Combination fakeCombination = FacadeMetamodelFactory.eINSTANCE.createCombination();
	// for (BaseMetaclass metaFake : combination.getMetaClasses()) {
	// fakeCombination.getMetaClasses().add(metaFake);
	// }
	// BaseMetaclass containerBaseMetaClass = (BaseMetaclass) combination.eContainer();
	// BaseMetaclass general = findCorrespondingGeneral(containerBaseMetaClass);
	// fakeCombination.getMetaClasses().add(general);
	//
	// // We go through the compatible combinaison of this basemeta and try to find the fake
	// Combination combinaison = EditionUtils.getCombinationThatMatch(baseMetaclass2.getIncompatibleStereotypes(), fakeCombination);
	// if (combinaison != null) {
	// transformImcompatibleIntoCompatible(baseMetaclass2, combinaison);
	// } else {
	// System.err.println("Problem to find combinaison-update");
	// }
	// }
	//
	// }
	// }
	//
	// }
	//
	// }

	protected void makeItImcompatible(BaseMetaclass baseMetaclass, Combination combination, boolean bothWays) {

		// if (!EditionUtils.containsOnlyRequired(combination)) {
		// Facade facade = baseMetaclass.getExtensionDefinition().getFacade();

		// Make it incompatible
		// First way
		transformAllCompatibleIntoIncompatible(baseMetaclass, combination);

		// if (!baseMetaclass.getExtensionDefinition().getExtension().isRequired()) {
		// The other way
		proceedTheOtherWayCompatibleIntoIncompatible(combination, true);

		// updateRequiredIntoIncompatible(facade, baseMetaclass, combination);
		// } else {
		// if (bothWays) {
		// if (((Combination) combination).getMetaClasses().size() == 1) {
		// // System.err.println("Ici : " + ((Combination) combination).getMetaClasses().get(0).getExtensionDefinition().getStereotype());
		// IsPossibleColumnEditingSupport.transformAllPossibleIntoImpossible(((Combination) combination).getMetaClasses().get(0));
		// } else {
		// proceedTheOtherWayCompatibleIntoIncompatible(combination, false);
		// }
		// }
		// }
		// } else {
		// MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Cannot because required", "All those stereotypes are required");
		// }
	}

	protected void makeItCompatible(BaseMetaclass baseMetaclass, Combination combination, boolean bothWays) {
		// Facade facade = baseMetaclass.getExtensionDefinition().getFacade();

		// First way
		transformAllImcompatibleIntoCompatible(baseMetaclass, (Combination)combination);

		// if (!baseMetaclass.getExtensionDefinition().getExtension().isRequired()) {
		// The other way
		proceedTheOtherWayImcompatibleIntoCompatible(combination, true);

		// updateRequiredIntoCompatible(facade, baseMetaclass, combination);
		// } else {
		// if (bothWays) {
		// if (((Combination) combination).getMetaClasses().size() == 1) {
		// // System.err.println("Ici : " + ((Combination) combination).getMetaClasses().get(0).getExtensionDefinition().getStereotype());
		// IsPossibleColumnEditingSupport.transformAllImpossibleIntoPossible(((Combination) combination).getMetaClasses().get(0));
		// } else {
		// proceedTheOtherWayImcompatibleIntoCompatible(combination, false);
		// }
		// }
		// }
	}

	@Override
	protected void setValue(final Object element, final Object value) {
		if(element instanceof Combination) {

			ProgressMonitorDialog dialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
			try {
				dialog.run(false, false, new IRunnableWithProgress() {

					public void run(IProgressMonitor monitor) {
						monitor.beginTask("Updating stereotypes definitions", IProgressMonitor.UNKNOWN);

						ISelection selection = FacadeSpecificEditor.getExtensionDefintionTreeViewer().getSelection();
						if(selection instanceof IStructuredSelection) {
							Object first = ((IStructuredSelection)selection).getFirstElement();

							if(first instanceof BaseMetaclass) {
								BaseMetaclass baseMetaclass = (BaseMetaclass)first;

								if((Boolean)value == false) {
									makeItImcompatible(baseMetaclass, (Combination)element, true);
								} else {
									// Make it compatible
									makeItCompatible(baseMetaclass, (Combination)element, true);

								}

							}
						}

						monitor.done();
					}
				});
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			getViewer().refresh();
			FacadeSpecificEditor.getExtensionDefintionTreeViewer().refresh();
		}
	}

	@Override
	protected Object getValue(Object element) {
		if(element instanceof Combination) {
			ISelection selection = FacadeSpecificEditor.getExtensionDefintionTreeViewer().getSelection();
			if(selection instanceof IStructuredSelection) {
				Object first = ((IStructuredSelection)selection).getFirstElement();

				if(first instanceof BaseMetaclass) {
					EList<Combination> incompatibleStereotypes = ((BaseMetaclass)first).getIncompatibleStereotypes();
					if(incompatibleStereotypes.contains(element)) {
						return Boolean.valueOf(false);
					} else {
						return Boolean.valueOf(true);
					}
				}
			}

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
