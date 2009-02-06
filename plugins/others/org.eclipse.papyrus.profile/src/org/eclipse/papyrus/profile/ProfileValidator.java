/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.profile;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLValidator;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfileValidator.
 * 
 * @author Chokri Mraidha
 */

public class ProfileValidator extends UMLValidator{
	
	/**
	 * The validation errors.
	 */
	protected String validationErrors="";
	
	/**
	 * The valid.
	 */
	protected boolean valid = true;
	
	/**
	 * The Constructor.
	 */
	public ProfileValidator() {
		super();
	}

	/**
	 * Validate papyrus UML profile.
	 * 
	 * @param profile the profile
	 * 
	 * @return true, if validate papyrus UML profile
	 */
	public boolean validatePapyrusUMLProfile(Profile profile) {
		
		EList profileStereotypes = profile.getOwnedStereotypes();
		Iterator profileIter = profileStereotypes.iterator();

		while(profileIter.hasNext()) {
			Stereotype element = (Stereotype)profileIter.next();
			EList ownedProp = element.getAllAttributes();
			Iterator propIter = ownedProp.iterator();
			while(propIter.hasNext()) {
				Property prop = (Property)propIter.next();
				
				// check if property type is defined
				valid = validateProfile_validatePapyrusUMLUndefined(prop);
				
				if(((prop.getType() instanceof PrimitiveType) || (prop.getType() instanceof Enumeration ))) {
					valid = validateProfile_validatePapyrusUMLDefaultValueRequired(prop);
				}
				
				else {
					if(prop.getLower() != 0) {
						if(prop.getName().length()>=5) {
							if(!prop.getName().substring(0, 5).equals("base_")) {
								valid = false;
								addError("Lower value for "+prop.getQualifiedName()+" must be 0\n");
							}
						}
						else {
							valid = false;
							addError("Lower value for "+prop.getQualifiedName()+" must be 0\n");
						}
					}
						
				}
				
			}
		}
		
		return valid;
	}
	
	/**
	 * This method checks if all mandatory default values for properties have been set.
	 * 
	 * @param property the property
	 * 
	 * @return true if valid false otherwise
	 */
	public boolean validateProfile_validatePapyrusUMLDefaultValueRequired(Property property) {
		if((property.getLower() != 0) && !(property.isSetDefault())) {
			valid = false;
			addError("Default value required for "+property.getQualifiedName()+"\n");
		}
		
		return valid;
	}
	
	/**
	 * Validate profile_validate papyrus UML undefined.
	 * 
	 * @param property the property
	 * 
	 * @return true, if validate profile_validate papyrus UML undefined
	 */
	public boolean validateProfile_validatePapyrusUMLUndefined(Property property) {
		if(property.getType()==null) {
			valid = false;
			addError("Undefined type for "+property.getQualifiedName()+"\n");
		}
		
		return valid;
	}

	/**
	 * Adds the error.
	 * 
	 * @param error the error
	 */
	protected void addError(String error) {
		validationErrors = validationErrors+error;
	}

	/**
	 * Gets the errors.
	 * 
	 * @return the errors
	 */
	public String getErrors() {
		return validationErrors;
	}
	
}
