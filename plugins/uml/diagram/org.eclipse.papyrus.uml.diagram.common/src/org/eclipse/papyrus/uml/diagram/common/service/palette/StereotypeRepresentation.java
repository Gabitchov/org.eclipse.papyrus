/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.service.palette;

import java.util.ArrayList;

import org.eclipse.uml2.uml.Stereotype;

/**
 * 
 * This class is used to represent a {@link org.eclipse.uml2.uml.Stereotype}
 * 
 */
public class StereotypeRepresentation {

	/**
	 * the stereotype qualified name
	 */
	private String stereotypeQualifiedName;

	/**
	 * the properties owned by the stereotype
	 */
	private ArrayList<PropertyRepresentation> properties;

	/**
	 * the UML stereotype represented by this class
	 */
	private Stereotype stereotype;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param qualifiedName
	 */
	public StereotypeRepresentation(String qualifiedName) {
		this.stereotypeQualifiedName = qualifiedName;
		properties = new ArrayList<PropertyRepresentation>();
		this.setUMLStereotype(null);
	}

	/**
	 * 
	 * Constructor. Note : the properties are neither copied nor duplicated
	 * 
	 * @param ste
	 *        the {@link StereotypeRepresentation} uses to instantiate a new {@link StereotypeRepresentation}
	 */
	public StereotypeRepresentation(StereotypeRepresentation ste) {
		this.stereotypeQualifiedName = ste.getStereotypeQualifiedName();
		properties = new ArrayList<PropertyRepresentation>();
		setUMLStereotype(ste.getUMLStereotype());
	}

	/**
	 * Adds a property to this stereotype This method fills the field {@link StereotypeRepresentation} in the property
	 * 
	 * @param property
	 *        the property to add
	 */
	public void addProperty(PropertyRepresentation property) {
		property.setStereotype(this);
		properties.add(property);
	}

	/**
	 * Returns all the {@link PropertyRepresentation} owned by this stereotype
	 * 
	 * @return all the {@link PropertyRepresentation} owned by this stereotype
	 */
	public ArrayList<PropertyRepresentation> getPropertyRepresentations() {
		return properties;
	}

	/**
	 * Returns all the properties containing values owned by this stereotype
	 * 
	 * @return all the properties containing values owned by this stereotype
	 */
	public ArrayList<PropertyRepresentation> getPropertiesWithValues() {
		ArrayList<PropertyRepresentation> propertiesToSave = new ArrayList<PropertyRepresentation>();
		for(PropertyRepresentation prop : properties) {
			if(prop.hasValues()) {
				propertiesToSave.add(prop);
			}
		}
		return propertiesToSave;
	}

	/**
	 * Setter for {@link #stereotypeQualifiedName}
	 * 
	 * @return the stereotype qualified name
	 */
	public String getStereotypeQualifiedName() {
		return stereotypeQualifiedName;
	}

	/**
	 * Returns the {@link PropertyRepresentation} corresponding the parameters
	 * 
	 * @param stereotypeQualifiedName
	 *        the stereotype qualified name
	 * @param propertyQualifiedName
	 *        the property qualified name
	 * @return <ul>
	 *         <li>the corresponding {@link PropertyRepresentation}</li>
	 *         <li>{@code null} if the corresponding property was not found</li>
	 *         </ul>
	 */
	public PropertyRepresentation getPropertyRepresentation(String stereotypeQualifiedName, String propertyQualifiedName) {
		for(PropertyRepresentation prop : properties) {
			if(prop.getPropertyId().equals(stereotypeQualifiedName + PropertyRepresentation.separator + propertyQualifiedName)) {
				return prop;
			}
		}
		return null;
	}

	/**
	 * Returns the {@link PropertyRepresentation} which need to be defined at
	 * runtime
	 * 
	 * @return the {@link PropertyRepresentation} which need to be defined at
	 *         runtime
	 */
	public ArrayList<PropertyRepresentation> getRuntimeProperties() {
		ArrayList<PropertyRepresentation> propertiesToSave = new ArrayList<PropertyRepresentation>();
		for(PropertyRepresentation prop : properties) {
			if(prop.isRuntime()) {
				propertiesToSave.add(prop);
			}
		}
		return propertiesToSave;
	}

	/**
	 * Setter for {@link #stereotype}
	 * 
	 * @param stereotype
	 */
	public void setUMLStereotype(Stereotype stereotype) {
		this.stereotype = stereotype;
	}

	/**
	 * Getter for {@link #stereotype}
	 * 
	 * @return {@link #stereotype}
	 */
	public Stereotype getUMLStereotype() {

		org.eclipse.core.runtime.Assert.isNotNull(stereotype, "Stereotype has not been set!"); //$NON-NLS-1$
		return stereotype;
	}

	/**
	 * 
	 * @return <ul>
	 *         <li>  {@code true} if there is runtime properties in this stereotype
	 *         <li> {@code false} if not</li>
	 *         </ul>
	 */
	public boolean hasRuntimeProperties() {
		for(PropertyRepresentation prop : properties) {
			if(prop.isRuntime()) {
				return true;
			}
		}
		return false;
	}

}
