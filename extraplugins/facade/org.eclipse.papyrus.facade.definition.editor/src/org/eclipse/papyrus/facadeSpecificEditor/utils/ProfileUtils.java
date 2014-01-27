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
package org.eclipse.papyrus.facadeSpecificEditor.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.facade.Facade;
import org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass;
import org.eclipse.papyrus.facade.extensiondefinition.Combination;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinitionKind;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionFactory;
import org.eclipse.papyrus.facade.utils.CombinationGenerator;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

public class ProfileUtils {

	public static HashSet<Classifier> getAllClassifiers(Classifier element) {

		HashSet<Classifier> output = new HashSet<Classifier>();

		// Fake go through
		EcoreUtil.resolveAll(element);

		EList<Resource> resources = element.eResource().getResourceSet().getResources();
		for(Resource resource : resources) {
			TreeIterator<EObject> it = resource.getAllContents();
			while(it.hasNext()) {
				EObject eObject = (EObject)it.next();
				if(eObject instanceof Classifier) {
					output.add((Classifier)eObject);
				}
			}
		}

		return output;
	}

	public static HashSet<Extension> getAllExtensions(Profile profile) {

		HashSet<Extension> output = new HashSet<Extension>();

		// Fake go through
		EcoreUtil.resolveAll(profile);

		EList<Resource> resources = profile.eResource().getResourceSet().getResources();
		for(Resource resource : resources) {
			TreeIterator<EObject> it = resource.getAllContents();
			while(it.hasNext()) {
				EObject eObject = (EObject)it.next();
				if(eObject instanceof Extension) {
					output.add((Extension)eObject);
				}
			}
		}

		return output;
	}

	public static List<Extension> findExtensions(Stereotype stereotype) {
		List<Extension> extensions = new ArrayList<Extension>();

		for(Property property : stereotype.getAllAttributes()) {
			if(property.getName().startsWith(Extension.METACLASS_ROLE_PREFIX)) {
				if(property.getAssociation() instanceof Extension) {
					extensions.add((Extension)property.getAssociation());
				}
			}
		}

		return extensions;

	}

	public static List<Stereotype> findAllSubsInProfile(Stereotype classifier) {
		List<Stereotype> output = new ArrayList<Stereotype>();

		HashSet<Classifier> classifiers = getAllClassifiers(classifier);
		for(Classifier classifierCandidate : classifiers) {
			if(classifierCandidate.getGenerals().contains(classifier)) {
				if(classifierCandidate instanceof Stereotype) {
					output.add((Stereotype)classifierCandidate);
				}
			}

		}

		return output;
	}

	protected static HashMap<Stereotype, HashSet<Stereotype>> siblingsReference = new HashMap<Stereotype, HashSet<Stereotype>>();

	public static void initSiblings(Stereotype stereotype) {
		siblingsReference.remove(stereotype);
		siblingsReference.put(stereotype, findSibling(stereotype));
	}

	public static void clearSiblings() {
		siblingsReference.clear();
	}

	public static HashSet<Stereotype> getSiblings(Stereotype stereotype) {
		return siblingsReference.get(stereotype);
	}

	protected static HashSet<Stereotype> findSibling(Stereotype stereotype) {
		HashSet<Stereotype> stereotypeRelatives = new HashSet<Stereotype>();

		EList<Classifier> stereotypeGenerals = stereotype.getGenerals();

		if(!stereotypeGenerals.isEmpty()) {
			for(Classifier classifier : stereotypeGenerals) {
				if(classifier instanceof Stereotype) {
					stereotypeRelatives.addAll(findAllSubsInProfile((Stereotype)classifier));

					stereotypeRelatives.add((Stereotype)classifier);
				}
			}
		} else {
			stereotypeRelatives.addAll(findAllSubsInProfile(stereotype));
			stereotypeRelatives.add(stereotype);
		}

		return stereotypeRelatives;
	}

	public static boolean areNotRelatives(Stereotype stereotypeA, Stereotype stereotypeB) {

		HashSet<Stereotype> stereotypeARelatives = getSiblings(stereotypeA);
		HashSet<Stereotype> stereotypeBRelatives = getSiblings(stereotypeB);

		// They must not be relatives
		if(!stereotypeARelatives.contains(stereotypeB) && !stereotypeBRelatives.contains(stereotypeA)) {
			return true;
		}

		return false;
	}

	protected static List<Combination> generatePossibleCombination(List<BaseMetaclass> possibleStereotypes) {
		Vector<BaseMetaclass> elements = new Vector<BaseMetaclass>(possibleStereotypes);
		int[] indices;

		List<Combination> allCombination = new ArrayList<Combination>();
		for(int k = 1; k <= possibleStereotypes.size(); k++) {
			CombinationGenerator combinaisonGenerator = new CombinationGenerator(elements.size(), k);

			while(combinaisonGenerator.hasMore()) {
				// ArrayList<Stereotype> combination = new ArrayList<Stereotype>();
				indices = combinaisonGenerator.getNext();

				Combination combinaison = ExtensiondefinitionFactory.eINSTANCE.createCombination();

				for(int i = 0; i < indices.length; i++) {
					// combination.add();
					combinaison.getMembers().add(elements.get(indices[i]));
				}

				//Check that combination doesn't contain siblings
				boolean containsSiblings = false;
				for(BaseMetaclass baseA : combinaison.getMembers()) {
					for(BaseMetaclass baseB : combinaison.getMembers()) {
						if(baseA != baseB) {
							if(!areNotRelatives(baseA.getExtensionDefinition().getStereotype(), baseB.getExtensionDefinition().getStereotype())) {
								containsSiblings = true;
							}
						}
					}
				}

				if(!containsSiblings) {
					allCombination.add(combinaison);
				}
			}
		}

		return allCombination;
	}

	public static List<Combination> getPossibleCombinations(BaseMetaclass inputElement) {
		List<BaseMetaclass> requiredCompatibleStereotypes = new ArrayList<BaseMetaclass>();
		List<BaseMetaclass> optionalCompatibleStereotypes = new ArrayList<BaseMetaclass>();

		if(inputElement.getExtensionDefinition().getKind() == ExtensionDefinitionKind.MULTI_GENERALIZATION) {

			Facade facade = inputElement.getExtensionDefinition().getFacade();
			for(ExtensionDefinition extensionDefinition : facade.getExtensionDefinitions()) {

				if(extensionDefinition.getKind() == ExtensionDefinitionKind.MULTI_GENERALIZATION) {
					for(BaseMetaclass baseMetaclass : extensionDefinition.getBaseMetaclasses()) {
						if(baseMetaclass.getBase() == inputElement.getBase()) {

							if(baseMetaclass != inputElement) {
								Stereotype inputElementStereo = inputElement.getExtensionDefinition().getStereotype();
								Stereotype baseMetaClassStereo = baseMetaclass.getExtensionDefinition().getStereotype();

								if(ProfileUtils.areNotRelatives(inputElementStereo, baseMetaClassStereo)) {

									if(!baseMetaclass.getExtensionDefinition().getStereotype().isAbstract()) {

										if(baseMetaclass.getExtensionDefinition().getExtension().isRequired()) {
											requiredCompatibleStereotypes.add(baseMetaclass);
										} else {
											optionalCompatibleStereotypes.add(baseMetaclass);
										}

									}
								}
							}
						}
					}
				}
			}
		}

		List<Combination> possibleCombination = generatePossibleCombination(optionalCompatibleStereotypes);
		if(!requiredCompatibleStereotypes.isEmpty()) {
			for(Combination combination : possibleCombination) {
				combination.getMembers().addAll(requiredCompatibleStereotypes);
			}
			Combination combinationRequired = ExtensiondefinitionFactory.eINSTANCE.createCombination();
			combinationRequired.getMembers().addAll(requiredCompatibleStereotypes);
			possibleCombination.add(combinationRequired);
		}

		return possibleCombination;

	}
}
