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
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.infrastructure.datatypes;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Datatype</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * A CompositeDatatype represents a non-scalar datatype. Take as an example a CompositeDatatype "MyCountries" that can refer, e.g., to an Enumeration
 * "CountryEnumeration" {USA, Canada, Japan, EU} via two EADatatypePrototypes (record variables): FirstCountry and SecondCountry. Then an attribute
 * typed by this CompositeDatatype "MyCountries" may have a value like: (EU (identified as FirstCountry), Japan (identified as SecondCountry)).
 * 
 * Semantics:
 * A CompositeDatatype represents a non-scalar datatype. The contained datatypePrototypes act as record variables to identify the ordered datatype
 * instances of the tuple (the CompositeDatatype).
 * 
 * Notation:
 * The datatype CompositeDatatype is denoted using the rectangle symbol with keyword «Datatype CompositeDatatype».
 * 
 * Extension: UML Datatype
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.CompositeDatatype#getDatatypePrototype <em>Datatype Prototype</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.DatatypesPackage#getCompositeDatatype()
 * @model
 * @generated
 */
public interface CompositeDatatype extends EADatatype {

	/**
	 * Returns the value of the '<em><b>Datatype Prototype</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EADatatypePrototype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Datatype Prototype</em>' containment reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Datatype Prototype</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.DatatypesPackage#getCompositeDatatype_DatatypePrototype()
	 * @model required="true"
	 * @generated
	 */
	EList<EADatatypePrototype> getDatatypePrototype();

} // CompositeDatatype
