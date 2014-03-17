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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Type</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * From SysML:
 * A ValueType defines types of values that may be used to express information about a system, but cannot be identified as the target of any
 * reference. Since a value cannot be identified except by means of the value itself, each such value within a model is independent of any other,
 * unless other forms of constraints are imposed. Value types may be used to type properties, operation parameters, or potentially other elements
 * within SysML. SysML defines ValueType as a stereotype of UML DataType to establish a more neutral term for system values that may never be given a
 * concrete data representation. For example, the SysML "Real" ValueType expresses the mathematical concept of a real number, but does not impose any
 * restrictions on the precision or scale of a fixed or floating-point representation that expresses this concept. More specific value types can
 * define the concrete data representations that a digital computer can process, such as conventional Float, Integer, or String types. SysML ValueType
 * adds an ability to carry a unit of measure or dimension associated with the value. A dimension is a kind of quantity that may be stated in terms of
 * defined units, but does not restrict the selection of a unit to state the value. A unit is a particular value in terms of which a quantity of the
 * same dimension may be expressed. A SysML ValueType may define its own properties and/or operations, just as for a UML DataType.
 * 
 * Semantics:
 * The abstract ValueType defines types of values that may be used to express information about a system. The ValueType adds an ability to carry a
 * description, a dimension associated with the value, and a unit of measure. A dimension is a kind of quantity that may be stated in terms of defined
 * units, but does not restrict the selection of a unit to state the value. A unit is a particular value in terms of which a quantity of the same
 * dimension may be expressed.
 * Logical and physical datatypes cannot be distinguished on the type. The context (e.g., EnvironmentModel or FunctionalAnalysisArchitecture) decides
 * if a speed datatype is physical or logical. On AnalysisLevel or DesignLevel, physical datatypes shall not be interpreted in the implementation
 * sense as this would include int32, coding formula, etc.
 * 
 * Extension: UML Datatype
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.ValueType#getSemantics <em>Semantics</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.ValueType#getDimension <em>Dimension</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.ValueType#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.DatatypesPackage#getValueType()
 * @model abstract="true"
 * @generated
 */
public interface ValueType extends EADatatype {

	/**
	 * Returns the value of the '<em><b>Semantics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Semantics</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Semantics</em>' attribute.
	 * @see #setSemantics(String)
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.DatatypesPackage#getValueType_Semantics()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getSemantics();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.ValueType#getSemantics <em>Semantics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Semantics</em>' attribute.
	 * @see #getSemantics()
	 * @generated
	 */
	void setSemantics(String value);

	/**
	 * Returns the value of the '<em><b>Dimension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimension</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Dimension</em>' attribute.
	 * @see #setDimension(String)
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.DatatypesPackage#getValueType_Dimension()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getDimension();

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Unit</em>' attribute.
	 * @see #setUnit(String)
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.DatatypesPackage#getValueType_Unit()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getUnit();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.ValueType#getDimension <em>Dimension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Dimension</em>' attribute.
	 * @see #getDimension()
	 * @generated
	 */
	void setDimension(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.ValueType#getUnit <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Unit</em>' attribute.
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(String value);

} // ValueType
