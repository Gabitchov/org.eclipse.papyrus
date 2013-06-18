/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ernest Wozniak (CEA LIST) ernest.wozniak@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.dsml.validation.model.elements.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.papyrus.dsml.validation.IDSMLValidation;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.Category;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IConstraintProvider;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IConstraintsManager;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Management of validationRules assigned to the stereotypes specified in the
 * defined profile.
 * 
 * 
 */
public class ConstraintManagerImpl implements IConstraintsManager {

	private List<IConstraintProvider> constraintsProviders = new ArrayList<IConstraintProvider>();

	private Map<Stereotype, List<Constraint>> constraintsOfStereotype = new HashMap<Stereotype, List<Constraint>>();

	private Category primeCategory;

	private IConstraintProvider constraintProvider;



	/**
	 * 
	 * Constructor.
	 * 
	 * @param profile
	 */
	public ConstraintManagerImpl(Profile profile) {

		extractElements(profile);

	}

	/**
	 * Method to get all the elements from the model, necessary to build a
	 * plugin for validationRules validation.
	 * 
	 * @param root
	 *        root profile for which the validation plugin will be generated
	 */
	private void extractElements(Profile root) {

		//get the list of validationRules for each stereotype
		createStereotypeToConstraintsMapping(root);

		//the top profile becomes the prime category
		primeCategory = new CategoryImpl(root.getName().toLowerCase(), null);

		//construct all sub categories
		relateCategoriesWithConstraints(root, primeCategory);
	}

	/**
	 * Recursive function to relate categories with the validationRules
	 * a profile becomes a category
	 * a stereotype becomes a category
	 * 
	 * @param element
	 *        element for which function will find validationRules and its
	 *        related categories
	 * @param category
	 *        category for a group of validationRules
	 */
	private void relateCategoriesWithConstraints(Element element, Category category) {


		if(element instanceof Profile) {

			//creation of a category
			ConstraintCategoryImpl subCategory = new ConstraintCategoryImpl(((Profile)element).getName(), category);
			// add the category to the list of category
			category.getSubcategories().add(subCategory);
			//creation of a provider
			//construct one constraint provider
			constraintProvider = new ConstraintProviderImpl();
			// associate validation to category to provider
			constraintProvider.getConstraintsCategories().add(subCategory);
			constraintsProviders.add(constraintProvider);
			if(((Profile)element).getDefinition() != null) {
				constraintProvider.setEPackage(((Profile)element).getDefinition());
			}

			//iterate on all direct element of the profile
			for(NamedElement subElement : ((Profile)element).getOwnedMembers()) {

				//this a profile
				if(subElement instanceof Profile) {
					this.relateCategoriesWithConstraints(subElement, subCategory);
				} else if(subElement instanceof Stereotype) {

					//create validation rules
					if(this.constraintsOfStereotype.get(subElement) != null) {
						for(Constraint constraint : this.constraintsOfStereotype.get(subElement)) {
							try {
								subCategory.getConstraints().add(new ValidationRuleImpl(constraint, subCategory));
							} catch (WrongStereotypeException e) {
								e.printStackTrace();
							}
						}
					}

				}
			}

		}
	}

	/**
	 * create a category from the owner category and the sub-element that will becomes a category
	 * 
	 * @param category
	 *        the category owner
	 * @param subElement
	 *        the element that will become a category
	 * @return the category
	 */
	protected Category createCategory(Category category, NamedElement subElement) {
		Category subCategory;
		subCategory = new CategoryImpl(category.getName() + "." + subElement.getName().toLowerCase(), category);
		return subCategory;
	}

	/**
	 * Recursive method that finds validationRules of each stereotype defined in the
	 * model.
	 * it add validationRules only if there are stereotype validationRules
	 * 
	 * @param profile
	 *        root profile with stereotypes for which validationRules defined in
	 *        the model will be found
	 */
	private void createStereotypeToConstraintsMapping(Profile profile) {

		for(Element element : profile.allOwnedElements()) {

			if(element instanceof Constraint) {
				if(element.getAppliedStereotype(IDSMLValidation.VALIDATIONRULE_STEREOTYPE) != null) {

					Element contextElement = ((Constraint)element).getContext();

					//get the stereotype to add the constraint
					if(contextElement instanceof Stereotype) {
						if(this.constraintsOfStereotype.keySet().contains(contextElement)) {
							this.constraintsOfStereotype.get(contextElement).add((Constraint)element);
						} else {
							List<Constraint> constraintsList = new ArrayList<Constraint>();
							constraintsList.add((Constraint)element);
							this.constraintsOfStereotype.put((Stereotype)contextElement, constraintsList);
						}
					}
				}
			}
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IConstraintsManager#getConstraintsProviders()
	 * 
	 */

	public List<IConstraintProvider> getConstraintsProviders() {
		return this.constraintsProviders;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IConstraintsManager#getPrimeCategory()
	 * 
	 */
	public Category getPrimeCategory() {
		return this.primeCategory;
	}

}
