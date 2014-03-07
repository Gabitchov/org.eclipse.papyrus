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

import org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification;
import org.eclipse.uml2.uml.DataType;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EA Datatype</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * The EADatatype is a metaclass, which signifies a type whose instances are identified only by their value. The EADatatype metaclass represents the
 * description of the value set for some variable, parameter etc. without a description of how these possible values are represented on implementation
 * level. The implementation representation is defined on implementation level by the AUTOSAR concept PrimitiveTypeWithSemantics, and the implemented
 * datatype shall be associated with a Realization relationship. The realizing datatype must match the EADatatype regarding range, resolution, unit,
 * and dimension.
 * 
 * Semantics:
 * EADatatype metaclass is a special kind of classifier, similar to a class. It differs from the class in that instances of a data type are identified
 * only by their value.
 * 
 * Constraints:
 * [1] In the case of an AR implementation, an EADatatype is realized generally by PrimitiveTypeWithSemantics, which has to be consistent w.r.t.
 * range, resolution, etc.
 * 
 * Notation:
 * The EADatatype is denoted using the rectangle symbol with keyword «Datatype».
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EADatatype#getBase_DataType <em>Base Data Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.DatatypesPackage#getEADatatype()
 * @model abstract="true"
 * @generated
 */
public interface EADatatype extends TraceableSpecification {

	/**
	 * Returns the value of the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Data Type</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Data Type</em>' reference.
	 * @see #setBase_DataType(DataType)
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.DatatypesPackage#getEADatatype_Base_DataType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DataType getBase_DataType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EADatatype#getBase_DataType <em>Base Data Type</em>}'
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Data Type</em>' reference.
	 * @see #getBase_DataType()
	 * @generated
	 */
	void setBase_DataType(DataType value);

} // EADatatype
