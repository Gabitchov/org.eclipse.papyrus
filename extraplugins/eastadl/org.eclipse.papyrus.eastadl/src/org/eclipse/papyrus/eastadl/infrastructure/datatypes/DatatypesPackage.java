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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage;


/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The Datatypes subpackage of EAST-ADL2 defines EAST-ADL2 general-purpose datatypes that may be used to type structural constructs in several
 * different modeling diagrams.
 * 
 * The purpose of the metaclasses in the Datatypes subpackage is to specify the concepts for the specific domain.
 * <!-- end-model-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.DatatypesFactory
 * @model kind="package"
 * @generated
 */
public interface DatatypesPackage extends EPackage {

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EADatatypeImpl <em>EA Datatype</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EADatatypeImpl
		 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getEADatatype()
		 * @generated
		 */
		EClass EA_DATATYPE = eINSTANCE.getEADatatype();

		/**
		 * The meta object literal for the '<em><b>Base Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EA_DATATYPE__BASE_DATA_TYPE = eINSTANCE.getEADatatype_Base_DataType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.RangeableDatatypeImpl
		 * <em>Rangeable Datatype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.RangeableDatatypeImpl
		 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getRangeableDatatype()
		 * @generated
		 */
		EClass RANGEABLE_DATATYPE = eINSTANCE.getRangeableDatatype();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EADatatypePrototypeImpl
		 * <em>EA Datatype Prototype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EADatatypePrototypeImpl
		 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getEADatatypePrototype()
		 * @generated
		 */
		EClass EA_DATATYPE_PROTOTYPE = eINSTANCE.getEADatatypePrototype();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EA_DATATYPE_PROTOTYPE__TYPE = eINSTANCE.getEADatatypePrototype_Type();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EA_DATATYPE_PROTOTYPE__BASE_PROPERTY = eINSTANCE.getEADatatypePrototype_Base_Property();

		/**
		 * The meta object literal for the '<em><b>Base Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EA_DATATYPE_PROTOTYPE__BASE_PARAMETER = eINSTANCE.getEADatatypePrototype_Base_Parameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.ValueTypeImpl <em>Value Type</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.ValueTypeImpl
		 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getValueType()
		 * @generated
		 */
		EClass VALUE_TYPE = eINSTANCE.getValueType();

		/**
		 * The meta object literal for the '<em><b>Semantics</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VALUE_TYPE__SEMANTICS = eINSTANCE.getValueType_Semantics();

		/**
		 * The meta object literal for the '<em><b>Dimension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VALUE_TYPE__DIMENSION = eINSTANCE.getValueType_Dimension();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VALUE_TYPE__UNIT = eINSTANCE.getValueType_Unit();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.RangeableValueTypeImpl
		 * <em>Rangeable Value Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.RangeableValueTypeImpl
		 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getRangeableValueType()
		 * @generated
		 */
		EClass RANGEABLE_VALUE_TYPE = eINSTANCE.getRangeableValueType();

		/**
		 * The meta object literal for the '<em><b>Accuracy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RANGEABLE_VALUE_TYPE__ACCURACY = eINSTANCE.getRangeableValueType_Accuracy();

		/**
		 * The meta object literal for the '<em><b>Resolution</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RANGEABLE_VALUE_TYPE__RESOLUTION = eINSTANCE.getRangeableValueType_Resolution();

		/**
		 * The meta object literal for the '<em><b>Significant Digits</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RANGEABLE_VALUE_TYPE__SIGNIFICANT_DIGITS = eINSTANCE.getRangeableValueType_SignificantDigits();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EnumerationValueTypeImpl
		 * <em>Enumeration Value Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EnumerationValueTypeImpl
		 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getEnumerationValueType()
		 * @generated
		 */
		EClass ENUMERATION_VALUE_TYPE = eINSTANCE.getEnumerationValueType();

		/**
		 * The meta object literal for the '<em><b>Is Multi Valued</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ENUMERATION_VALUE_TYPE__IS_MULTI_VALUED = eINSTANCE.getEnumerationValueType_IsMultiValued();

		/**
		 * The meta object literal for the '<em><b>Literal Semantics</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ENUMERATION_VALUE_TYPE__LITERAL_SEMANTICS = eINSTANCE.getEnumerationValueType_LiteralSemantics();

		/**
		 * The meta object literal for the '<em><b>Base Enumeration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ENUMERATION_VALUE_TYPE__BASE_ENUMERATION = eINSTANCE.getEnumerationValueType_Base_Enumeration();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.CompositeDatatypeImpl
		 * <em>Composite Datatype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.CompositeDatatypeImpl
		 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getCompositeDatatype()
		 * @generated
		 */
		EClass COMPOSITE_DATATYPE = eINSTANCE.getCompositeDatatype();

		/**
		 * The meta object literal for the '<em><b>Datatype Prototype</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COMPOSITE_DATATYPE__DATATYPE_PROTOTYPE = eINSTANCE.getCompositeDatatype_DatatypePrototype();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EAStringImpl <em>EA String</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EAStringImpl
		 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getEAString()
		 * @generated
		 */
		EClass EA_STRING = eINSTANCE.getEAString();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EABooleanImpl <em>EA Boolean</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EABooleanImpl
		 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getEABoolean()
		 * @generated
		 */
		EClass EA_BOOLEAN = eINSTANCE.getEABoolean();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EAFloatImpl <em>EA Float</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EAFloatImpl
		 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getEAFloat()
		 * @generated
		 */
		EClass EA_FLOAT = eINSTANCE.getEAFloat();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EA_FLOAT__MIN = eINSTANCE.getEAFloat_Min();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EA_FLOAT__MAX = eINSTANCE.getEAFloat_Max();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EAIntegerImpl <em>EA Integer</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EAIntegerImpl
		 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getEAInteger()
		 * @generated
		 */
		EClass EA_INTEGER = eINSTANCE.getEAInteger();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EA_INTEGER__MIN = eINSTANCE.getEAInteger_Min();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EA_INTEGER__MAX = eINSTANCE.getEAInteger_Max();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EnumerationLiteralImpl
		 * <em>Enumeration Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EnumerationLiteralImpl
		 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getEnumerationLiteral()
		 * @generated
		 */
		EClass ENUMERATION_LITERAL = eINSTANCE.getEnumerationLiteral();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EnumerationImpl <em>Enumeration</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EnumerationImpl
		 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getEnumeration()
		 * @generated
		 */
		EClass ENUMERATION = eINSTANCE.getEnumeration();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ENUMERATION__LITERAL = eINSTANCE.getEnumeration_Literal();

		/**
		 * The meta object literal for the '<em>javalang Float</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see java.lang.Float
		 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getjavalangFloat()
		 * @generated
		 */
		EDataType JAVALANG_FLOAT = eINSTANCE.getjavalangFloat();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "datatypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.papyrusuml.org/EAST-ADL2/Infrastructure/Datatypes/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "Datatypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	DatatypesPackage eINSTANCE = org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EADatatypeImpl <em>EA Datatype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EADatatypeImpl
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getEADatatype()
	 * @generated
	 */
	int EA_DATATYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_DATATYPE__NAME = ElementsPackage.TRACEABLE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_DATATYPE__BASE_NAMED_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_DATATYPE__OWNED_COMMENT = ElementsPackage.TRACEABLE_SPECIFICATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_DATATYPE__BASE_PACKAGEABLE_ELEMENT = ElementsPackage.TRACEABLE_SPECIFICATION__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_DATATYPE__NOTE = ElementsPackage.TRACEABLE_SPECIFICATION__NOTE;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_DATATYPE__BASE_DATA_TYPE = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EA Datatype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_DATATYPE_FEATURE_COUNT = ElementsPackage.TRACEABLE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.RangeableDatatypeImpl <em>Rangeable Datatype</em>}
	 * ' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.RangeableDatatypeImpl
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getRangeableDatatype()
	 * @generated
	 */
	int RANGEABLE_DATATYPE = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EADatatypePrototypeImpl
	 * <em>EA Datatype Prototype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EADatatypePrototypeImpl
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getEADatatypePrototype()
	 * @generated
	 */
	int EA_DATATYPE_PROTOTYPE = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.ValueTypeImpl <em>Value Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.ValueTypeImpl
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getValueType()
	 * @generated
	 */
	int VALUE_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_DATATYPE_PROTOTYPE__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_DATATYPE_PROTOTYPE__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_DATATYPE_PROTOTYPE__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_DATATYPE_PROTOTYPE__TYPE = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_DATATYPE_PROTOTYPE__BASE_PROPERTY = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_DATATYPE_PROTOTYPE__BASE_PARAMETER = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>EA Datatype Prototype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_DATATYPE_PROTOTYPE_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__NAME = EA_DATATYPE__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__BASE_NAMED_ELEMENT = EA_DATATYPE__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__OWNED_COMMENT = EA_DATATYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__BASE_PACKAGEABLE_ELEMENT = EA_DATATYPE__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__NOTE = EA_DATATYPE__NOTE;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__BASE_DATA_TYPE = EA_DATATYPE__BASE_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Semantics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__SEMANTICS = EA_DATATYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dimension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__DIMENSION = EA_DATATYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__UNIT = EA_DATATYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Value Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE_FEATURE_COUNT = EA_DATATYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGEABLE_DATATYPE__NAME = EA_DATATYPE__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGEABLE_DATATYPE__BASE_NAMED_ELEMENT = EA_DATATYPE__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGEABLE_DATATYPE__OWNED_COMMENT = EA_DATATYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGEABLE_DATATYPE__BASE_PACKAGEABLE_ELEMENT = EA_DATATYPE__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGEABLE_DATATYPE__NOTE = EA_DATATYPE__NOTE;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGEABLE_DATATYPE__BASE_DATA_TYPE = EA_DATATYPE__BASE_DATA_TYPE;

	/**
	 * The number of structural features of the '<em>Rangeable Datatype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGEABLE_DATATYPE_FEATURE_COUNT = EA_DATATYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.RangeableValueTypeImpl
	 * <em>Rangeable Value Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.RangeableValueTypeImpl
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getRangeableValueType()
	 * @generated
	 */
	int RANGEABLE_VALUE_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGEABLE_VALUE_TYPE__NAME = VALUE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGEABLE_VALUE_TYPE__BASE_NAMED_ELEMENT = VALUE_TYPE__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGEABLE_VALUE_TYPE__OWNED_COMMENT = VALUE_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGEABLE_VALUE_TYPE__BASE_PACKAGEABLE_ELEMENT = VALUE_TYPE__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGEABLE_VALUE_TYPE__NOTE = VALUE_TYPE__NOTE;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGEABLE_VALUE_TYPE__BASE_DATA_TYPE = VALUE_TYPE__BASE_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Semantics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGEABLE_VALUE_TYPE__SEMANTICS = VALUE_TYPE__SEMANTICS;

	/**
	 * The feature id for the '<em><b>Dimension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGEABLE_VALUE_TYPE__DIMENSION = VALUE_TYPE__DIMENSION;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGEABLE_VALUE_TYPE__UNIT = VALUE_TYPE__UNIT;

	/**
	 * The feature id for the '<em><b>Accuracy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGEABLE_VALUE_TYPE__ACCURACY = VALUE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resolution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGEABLE_VALUE_TYPE__RESOLUTION = VALUE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Significant Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGEABLE_VALUE_TYPE__SIGNIFICANT_DIGITS = VALUE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Rangeable Value Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RANGEABLE_VALUE_TYPE_FEATURE_COUNT = VALUE_TYPE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EnumerationValueTypeImpl
	 * <em>Enumeration Value Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EnumerationValueTypeImpl
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getEnumerationValueType()
	 * @generated
	 */
	int ENUMERATION_VALUE_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_VALUE_TYPE__NAME = VALUE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_VALUE_TYPE__BASE_NAMED_ELEMENT = VALUE_TYPE__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_VALUE_TYPE__OWNED_COMMENT = VALUE_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_VALUE_TYPE__BASE_PACKAGEABLE_ELEMENT = VALUE_TYPE__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_VALUE_TYPE__NOTE = VALUE_TYPE__NOTE;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_VALUE_TYPE__BASE_DATA_TYPE = VALUE_TYPE__BASE_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Semantics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_VALUE_TYPE__SEMANTICS = VALUE_TYPE__SEMANTICS;

	/**
	 * The feature id for the '<em><b>Dimension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_VALUE_TYPE__DIMENSION = VALUE_TYPE__DIMENSION;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_VALUE_TYPE__UNIT = VALUE_TYPE__UNIT;

	/**
	 * The feature id for the '<em><b>Is Multi Valued</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_VALUE_TYPE__IS_MULTI_VALUED = VALUE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Literal Semantics</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_VALUE_TYPE__LITERAL_SEMANTICS = VALUE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Enumeration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_VALUE_TYPE__BASE_ENUMERATION = VALUE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Enumeration Value Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_VALUE_TYPE_FEATURE_COUNT = VALUE_TYPE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.CompositeDatatypeImpl <em>Composite Datatype</em>}
	 * ' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.CompositeDatatypeImpl
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getCompositeDatatype()
	 * @generated
	 */
	int COMPOSITE_DATATYPE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DATATYPE__NAME = EA_DATATYPE__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DATATYPE__BASE_NAMED_ELEMENT = EA_DATATYPE__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DATATYPE__OWNED_COMMENT = EA_DATATYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DATATYPE__BASE_PACKAGEABLE_ELEMENT = EA_DATATYPE__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DATATYPE__NOTE = EA_DATATYPE__NOTE;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DATATYPE__BASE_DATA_TYPE = EA_DATATYPE__BASE_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Datatype Prototype</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DATATYPE__DATATYPE_PROTOTYPE = EA_DATATYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Datatype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DATATYPE_FEATURE_COUNT = EA_DATATYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EAStringImpl <em>EA String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EAStringImpl
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getEAString()
	 * @generated
	 */
	int EA_STRING = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_STRING__NAME = EA_DATATYPE__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_STRING__BASE_NAMED_ELEMENT = EA_DATATYPE__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_STRING__OWNED_COMMENT = EA_DATATYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_STRING__BASE_PACKAGEABLE_ELEMENT = EA_DATATYPE__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_STRING__NOTE = EA_DATATYPE__NOTE;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_STRING__BASE_DATA_TYPE = EA_DATATYPE__BASE_DATA_TYPE;

	/**
	 * The number of structural features of the '<em>EA String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_STRING_FEATURE_COUNT = EA_DATATYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EABooleanImpl <em>EA Boolean</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EABooleanImpl
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getEABoolean()
	 * @generated
	 */
	int EA_BOOLEAN = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_BOOLEAN__NAME = EA_DATATYPE__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_BOOLEAN__BASE_NAMED_ELEMENT = EA_DATATYPE__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_BOOLEAN__OWNED_COMMENT = EA_DATATYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_BOOLEAN__BASE_PACKAGEABLE_ELEMENT = EA_DATATYPE__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_BOOLEAN__NOTE = EA_DATATYPE__NOTE;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_BOOLEAN__BASE_DATA_TYPE = EA_DATATYPE__BASE_DATA_TYPE;

	/**
	 * The number of structural features of the '<em>EA Boolean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_BOOLEAN_FEATURE_COUNT = EA_DATATYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EAFloatImpl <em>EA Float</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EAFloatImpl
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getEAFloat()
	 * @generated
	 */
	int EA_FLOAT = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_FLOAT__NAME = RANGEABLE_DATATYPE__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_FLOAT__BASE_NAMED_ELEMENT = RANGEABLE_DATATYPE__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_FLOAT__OWNED_COMMENT = RANGEABLE_DATATYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_FLOAT__BASE_PACKAGEABLE_ELEMENT = RANGEABLE_DATATYPE__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_FLOAT__NOTE = RANGEABLE_DATATYPE__NOTE;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_FLOAT__BASE_DATA_TYPE = RANGEABLE_DATATYPE__BASE_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_FLOAT__MIN = RANGEABLE_DATATYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_FLOAT__MAX = RANGEABLE_DATATYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EA Float</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_FLOAT_FEATURE_COUNT = RANGEABLE_DATATYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EAIntegerImpl <em>EA Integer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EAIntegerImpl
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getEAInteger()
	 * @generated
	 */
	int EA_INTEGER = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_INTEGER__NAME = RANGEABLE_DATATYPE__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_INTEGER__BASE_NAMED_ELEMENT = RANGEABLE_DATATYPE__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_INTEGER__OWNED_COMMENT = RANGEABLE_DATATYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_INTEGER__BASE_PACKAGEABLE_ELEMENT = RANGEABLE_DATATYPE__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_INTEGER__NOTE = RANGEABLE_DATATYPE__NOTE;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_INTEGER__BASE_DATA_TYPE = RANGEABLE_DATATYPE__BASE_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_INTEGER__MIN = RANGEABLE_DATATYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_INTEGER__MAX = RANGEABLE_DATATYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EA Integer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EA_INTEGER_FEATURE_COUNT = RANGEABLE_DATATYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EnumerationLiteralImpl
	 * <em>Enumeration Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EnumerationLiteralImpl
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getEnumerationLiteral()
	 * @generated
	 */
	int ENUMERATION_LITERAL = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The number of structural features of the '<em>Enumeration Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EnumerationImpl <em>Enumeration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.EnumerationImpl
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getEnumeration()
	 * @generated
	 */
	int ENUMERATION = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__NAME = EA_DATATYPE__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__BASE_NAMED_ELEMENT = EA_DATATYPE__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__OWNED_COMMENT = EA_DATATYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Packageable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__BASE_PACKAGEABLE_ELEMENT = EA_DATATYPE__BASE_PACKAGEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Note</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__NOTE = EA_DATATYPE__NOTE;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__BASE_DATA_TYPE = EA_DATATYPE__BASE_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__LITERAL = EA_DATATYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enumeration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_FEATURE_COUNT = EA_DATATYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '<em>javalang Float</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see java.lang.Float
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl#getjavalangFloat()
	 * @generated
	 */
	int JAVALANG_FLOAT = 13;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EADatatype <em>EA Datatype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>EA Datatype</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.EADatatype
	 * @generated
	 */
	EClass getEADatatype();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EADatatype#getBase_DataType
	 * <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Data Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.EADatatype#getBase_DataType()
	 * @see #getEADatatype()
	 * @generated
	 */
	EReference getEADatatype_Base_DataType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EADatatypePrototype
	 * <em>EA Datatype Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>EA Datatype Prototype</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.EADatatypePrototype
	 * @generated
	 */
	EClass getEADatatypePrototype();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EADatatypePrototype#getType
	 * <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.EADatatypePrototype#getType()
	 * @see #getEADatatypePrototype()
	 * @generated
	 */
	EReference getEADatatypePrototype_Type();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EADatatypePrototype#getBase_Property
	 * <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.EADatatypePrototype#getBase_Property()
	 * @see #getEADatatypePrototype()
	 * @generated
	 */
	EReference getEADatatypePrototype_Base_Property();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EADatatypePrototype#getBase_Parameter
	 * <em>Base Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Parameter</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.EADatatypePrototype#getBase_Parameter()
	 * @see #getEADatatypePrototype()
	 * @generated
	 */
	EReference getEADatatypePrototype_Base_Parameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.CompositeDatatype <em>Composite Datatype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Composite Datatype</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.CompositeDatatype
	 * @generated
	 */
	EClass getCompositeDatatype();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.CompositeDatatype#getDatatypePrototype <em>Datatype Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Datatype Prototype</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.CompositeDatatype#getDatatypePrototype()
	 * @see #getCompositeDatatype()
	 * @generated
	 */
	EReference getCompositeDatatype_DatatypePrototype();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EAString <em>EA String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>EA String</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.EAString
	 * @generated
	 */
	EClass getEAString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EABoolean <em>EA Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>EA Boolean</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.EABoolean
	 * @generated
	 */
	EClass getEABoolean();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EAFloat <em>EA Float</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>EA Float</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.EAFloat
	 * @generated
	 */
	EClass getEAFloat();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EAFloat#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.EAFloat#getMin()
	 * @see #getEAFloat()
	 * @generated
	 */
	EAttribute getEAFloat_Min();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EAFloat#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.EAFloat#getMax()
	 * @see #getEAFloat()
	 * @generated
	 */
	EAttribute getEAFloat_Max();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EAInteger <em>EA Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>EA Integer</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.EAInteger
	 * @generated
	 */
	EClass getEAInteger();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EAInteger#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.EAInteger#getMin()
	 * @see #getEAInteger()
	 * @generated
	 */
	EAttribute getEAInteger_Min();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EAInteger#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.EAInteger#getMax()
	 * @see #getEAInteger()
	 * @generated
	 */
	EAttribute getEAInteger_Max();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DatatypesFactory getDatatypesFactory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EnumerationLiteral <em>Enumeration Literal</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Enumeration Literal</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.EnumerationLiteral
	 * @generated
	 */
	EClass getEnumerationLiteral();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.Enumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Enumeration</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.Enumeration
	 * @generated
	 */
	EClass getEnumeration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.Enumeration#getLiteral
	 * <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Literal</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.Enumeration#getLiteral()
	 * @see #getEnumeration()
	 * @generated
	 */
	EReference getEnumeration_Literal();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EnumerationValueType
	 * <em>Enumeration Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Enumeration Value Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.EnumerationValueType
	 * @generated
	 */
	EClass getEnumerationValueType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EnumerationValueType#isIsMultiValued
	 * <em>Is Multi Valued</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Is Multi Valued</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.EnumerationValueType#isIsMultiValued()
	 * @see #getEnumerationValueType()
	 * @generated
	 */
	EAttribute getEnumerationValueType_IsMultiValued();

	/**
	 * Returns the meta object for the attribute list '
	 * {@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EnumerationValueType#getLiteralSemantics <em>Literal Semantics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Literal Semantics</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.EnumerationValueType#getLiteralSemantics()
	 * @see #getEnumerationValueType()
	 * @generated
	 */
	EAttribute getEnumerationValueType_LiteralSemantics();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EnumerationValueType#getBase_Enumeration <em>Base Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Enumeration</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.EnumerationValueType#getBase_Enumeration()
	 * @see #getEnumerationValueType()
	 * @generated
	 */
	EReference getEnumerationValueType_Base_Enumeration();

	/**
	 * Returns the meta object for data type '{@link java.lang.Float <em>javalang Float</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>javalang Float</em>'.
	 * @see java.lang.Float
	 * @model instanceClass="java.lang.Float"
	 * @generated
	 */
	EDataType getjavalangFloat();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.RangeableDatatype <em>Rangeable Datatype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Rangeable Datatype</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.RangeableDatatype
	 * @generated
	 */
	EClass getRangeableDatatype();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.RangeableValueType
	 * <em>Rangeable Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Rangeable Value Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.RangeableValueType
	 * @generated
	 */
	EClass getRangeableValueType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.RangeableValueType#getAccuracy
	 * <em>Accuracy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Accuracy</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.RangeableValueType#getAccuracy()
	 * @see #getRangeableValueType()
	 * @generated
	 */
	EAttribute getRangeableValueType_Accuracy();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.RangeableValueType#getResolution
	 * <em>Resolution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Resolution</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.RangeableValueType#getResolution()
	 * @see #getRangeableValueType()
	 * @generated
	 */
	EAttribute getRangeableValueType_Resolution();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.RangeableValueType#getSignificantDigits
	 * <em>Significant Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Significant Digits</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.RangeableValueType#getSignificantDigits()
	 * @see #getRangeableValueType()
	 * @generated
	 */
	EAttribute getRangeableValueType_SignificantDigits();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.ValueType <em>Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Value Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.ValueType
	 * @generated
	 */
	EClass getValueType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.ValueType#getSemantics
	 * <em>Semantics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Semantics</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.ValueType#getSemantics()
	 * @see #getValueType()
	 * @generated
	 */
	EAttribute getValueType_Semantics();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.ValueType#getDimension
	 * <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Dimension</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.ValueType#getDimension()
	 * @see #getValueType()
	 * @generated
	 */
	EAttribute getValueType_Dimension();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.ValueType#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.ValueType#getUnit()
	 * @see #getValueType()
	 * @generated
	 */
	EAttribute getValueType_Unit();

} //DatatypesPackage
