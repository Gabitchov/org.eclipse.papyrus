/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
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

	/**
	 * Check is a combination of stereotypes appears in a list (independently from the order of the combination)
	 * 
	 * @param list
	 *        the list to search in
	 * @param combinaison
	 *        the combination to find
	 * @return
	 */
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

	/**
	 * Find a combination of stereotypes appears in a list of combination (independently from the order of the combination)
	 * 
	 * @param list
	 *        the list to search in
	 * @param combinaison
	 *        the combination to find
	 * @return
	 */
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

	/**
	 * Generate the stereotype combinations for the facade
	 * 
	 * @param facade
	 *        the facade to generate the combinations for
	 * @param editingDomain
	 */
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

					AddCommand addIncompatibilitiesCommand = new AddCommand(editingDomain, baseMeta, ExtensiondefinitionPackage.eINSTANCE.getBaseMetaclass_IncompatibleStereotypes(), combination);
					editingDomain.getCommandStack().execute(addIncompatibilitiesCommand);
				}
			}
		}
	}

	/**
	 * Remove the stereotype combinations from the facade
	 * 
	 * @param facade
	 * @param editingDomain
	 */
	public static void clearAllStereotypeCombinations(Facade facade, AdapterFactoryEditingDomain editingDomain) {
		for(ExtensionDefinition extensionDefinition : facade.getExtensionDefinitions()) {
			for(BaseMetaclass baseMeta : extensionDefinition.getBaseMetaclasses()) {

				List<Combination> possibleCombinations = ProfileUtils.getPossibleCombinations(baseMeta);

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

	/**
	 * Check whether the baseMetaclass has a combination that is required
	 * 
	 * @param baseMeta
	 * @return
	 */
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

	/**
	 * Initialize the isPossible of all the extension definitions of a Facade
	 * 
	 * @param facade
	 * @param editingDomain
	 */
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
