package org.eclipse.papyrus.facadeSpecificEditor.editingSupport;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.papyrus.facade.Facade;
import org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass;
import org.eclipse.papyrus.facade.extensiondefinition.Combination;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinitionKind;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage;
import org.eclipse.papyrus.facadeSpecificEditor.utils.ProfileUtils;


public class EditionUtils {

	public static boolean containsCombination(List<Combination> list, Combination combinaison) {
		for(Combination item : list) {
			if(item.getMembers().size() == combinaison.getMembers().size()) {
				if(item.getMembers().containsAll(combinaison.getMembers())) {
					return true;
				}
			}
		}

		return false;

	}

	public static Combination getCombinationThatMatch(List<Combination> list, Combination combinaison) {
		for(Combination item : list) {
			if(item.getMembers().size() == combinaison.getMembers().size()) {
				if(item.getMembers().containsAll(combinaison.getMembers())) {
					return item;
				}
			}
		}

		return null;

	}

	public static void initAllStereotypeCombinations(Facade facade, AdapterFactoryEditingDomain editingDomain) {

		for(ExtensionDefinition extensionDefinition : facade.getExtensionDefinitions()) {
			for(BaseMetaclass baseMeta : extensionDefinition.getBaseMetaclasses()) {

				List<Combination> possibleCombinations = ProfileUtils.getPossibleCombinations(baseMeta);

				List<Combination> toAdd = new ArrayList<Combination>();

				for(Combination combinaison : possibleCombinations) {

					if(!containsCombination(baseMeta.getIncompatibleStereotypes(), combinaison)) {
						if(!containsCombination(baseMeta.getCompatibleStereotypes(), combinaison)) {
							toAdd.add(combinaison);
						}
					}
				}

				for(Combination combination : toAdd) {
					// if (baseMeta.getExtensionDefinition().getExtension().isRequired()) {
					// if (combination.getMetaClasses().size() == 1) {
					// if (combination.getMetaClasses().get(0).isPossible()) {
					// AddCommand addIncompatibilitiesCommand = new AddCommand(editingDomain, baseMeta, FacadeMetamodelPackage.eINSTANCE.getBaseMetaclass_CompatibleStereotypes(), combination);
					// editingDomain.getCommandStack().execute(addIncompatibilitiesCommand);
					// } else {
					// AddCommand addIncompatibilitiesCommand = new AddCommand(editingDomain, baseMeta, FacadeMetamodelPackage.eINSTANCE.getBaseMetaclass_IncompatibleStereotypes(), combination);
					// editingDomain.getCommandStack().execute(addIncompatibilitiesCommand);
					// }
					// } else {
					// AddCommand addIncompatibilitiesCommand = new AddCommand(editingDomain, baseMeta, FacadeMetamodelPackage.eINSTANCE.getBaseMetaclass_IncompatibleStereotypes(), combination);
					// editingDomain.getCommandStack().execute(addIncompatibilitiesCommand);
					// }
					// } else {
					// if (containsOnlyRequired(combination)) {
					// AddCommand addIncompatibilitiesCommand = new AddCommand(editingDomain, baseMeta, FacadeMetamodelPackage.eINSTANCE.getBaseMetaclass_CompatibleStereotypes(), combination);
					// editingDomain.getCommandStack().execute(addIncompatibilitiesCommand);
					// } else {
					AddCommand addIncompatibilitiesCommand = new AddCommand(editingDomain, baseMeta, ExtensiondefinitionPackage.eINSTANCE.getBaseMetaclass_IncompatibleStereotypes(), combination);
					editingDomain.getCommandStack().execute(addIncompatibilitiesCommand);
					// }
					// }
				}

				// if (baseMeta.isPossible()) {
				// // if (baseMeta.getExtensionDefinition().getExtension().isRequired()) {
				// AddCommand addIncompatibilitiesCommand = new AddCommand(editingDomain, baseMeta, FacadeMetamodelPackage.eINSTANCE.getBaseMetaclass_CompatibleStereotypes(), toAdd);
				// editingDomain.getCommandStack().execute(addIncompatibilitiesCommand);
				// // }
				// } else {
				// AddCommand addIncompatibilitiesCommand = new AddCommand(editingDomain, baseMeta, FacadeMetamodelPackage.eINSTANCE.getBaseMetaclass_IncompatibleStereotypes(), toAdd);
				// editingDomain.getCommandStack().execute(addIncompatibilitiesCommand);
				// }

			}
		}
	}

	public static void clearAllStereotypeCombinations(Facade facade, AdapterFactoryEditingDomain editingDomain) {
		for(ExtensionDefinition extensionDefinition : facade.getExtensionDefinitions()) {
			for(BaseMetaclass baseMeta : extensionDefinition.getBaseMetaclasses()) {

				List<Combination> possibleCombinations = ProfileUtils.getPossibleCombinations(baseMeta);

				// System.err.println("For : " + baseMeta.getExtensionDefinition().getStereotype().getName());
				// for (Combination combination : possibleCombinations) {
				// System.err.print("\t");
				// for (BaseMetaclass metaclass : combination.getMetaClasses()) {
				// System.err.print(metaclass.getExtensionDefinition().getStereotype().getName() + ", ");
				// }
				// System.err.println();
				//
				// }

				List<Combination> incompatibilitiesToRemove = new ArrayList<Combination>();

				for(Combination incompatibleBase : baseMeta.getIncompatibleStereotypes()) {
					if(!containsCombination(possibleCombinations, incompatibleBase)) {
						incompatibilitiesToRemove.add(incompatibleBase);
					}

				}
				RemoveCommand removeIncompatibilityCommand = new RemoveCommand(editingDomain, baseMeta, ExtensiondefinitionPackage.eINSTANCE.getBaseMetaclass_IncompatibleStereotypes(), incompatibilitiesToRemove); //$NON-NLS-1$
				editingDomain.getCommandStack().execute(removeIncompatibilityCommand);

				List<Combination> compatibilitiesToRemove = new ArrayList<Combination>();

				for(Combination compatibleBase : baseMeta.getCompatibleStereotypes()) {
					if(!containsCombination(possibleCombinations, compatibleBase)) {
						compatibilitiesToRemove.add(compatibleBase);
					}
				}
				RemoveCommand removeCompatibilityCommand = new RemoveCommand(editingDomain, baseMeta, ExtensiondefinitionPackage.eINSTANCE.getBaseMetaclass_CompatibleStereotypes(), compatibilitiesToRemove); //$NON-NLS-1$
				editingDomain.getCommandStack().execute(removeCompatibilityCommand);

			}
		}
	}

	public static boolean hasARequiredCombination(BaseMetaclass baseMeta) {

		List<Combination> combinaisonsToCheck = new ArrayList<Combination>();

		combinaisonsToCheck.addAll(baseMeta.getCompatibleStereotypes());
		combinaisonsToCheck.addAll(baseMeta.getIncompatibleStereotypes());

		for(Combination combination : combinaisonsToCheck) {
			for(BaseMetaclass metaclass : combination.getMembers()) {
				if(metaclass.getExtensionDefinition().getKind() == ExtensionDefinitionKind.MULTI_GENERALIZATION) {
					if(metaclass.getExtensionDefinition().getExtension().isRequired()) {
						return true;
					}
				}
			}
		}
		return false;

	}

	public static void initIsPossible(Facade facade, AdapterFactoryEditingDomain editingDomain) {
		for(ExtensionDefinition extensionDefinition : facade.getExtensionDefinitions()) {
			for(BaseMetaclass baseMeta : extensionDefinition.getBaseMetaclasses()) {
				// If it has a combination that contains a required
				if(hasARequiredCombination(baseMeta)) {
					baseMeta.setPossible(false);
				} else {
					baseMeta.setPossible(true);
				}
			}
		}

	}
}
