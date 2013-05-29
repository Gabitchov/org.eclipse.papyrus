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
package org.eclipse.papyrus.eastadl.infrastructure.userattributes;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage;


/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * User attributes in EAST-ADL2 are primarily intended to provide a mechanism for augmenting the elements of an EAST-ADL2 model with customized meta-information.  All instances of metaclass ADLEntity can have user attributes attached to them.  The scope and structuring of this meta-information can be defined on a per-project basis by defining user attributes for certain types of EAST-ADL2 elements within UATemplates.
 * Since EAST-ADL2 requirements are in their most general form simple objects with all information contained in user-customized, project-specific attributes, the concept of user attributes is also perfectly suitable to define those attributes of requirements.  In that sense, basic requirements in EAST-ADL2 can be seen as "empty" elements which only provide a node to which user attributes can be attached in order to supply the requirement with all necessary information, including its main textual description.  However, in case of requirements the context in which the available user attributes are defined is different: here the container of the requirements is the point where user attribute definitions are store and these are then applicable only within this container.
 * The role of user attributes within the overall EAST-ADL2 is thus twofold: they (1) provide a means to customize the language to specific company and project needs and (2) constitute an important part of the requirements support of the language.
 * The mechanism of user attributes was optimized for flexibility and simplicity.  In particular, the actual attributes attached to an element and/or their values may well conflict the attribute definitions in effect for this element.  For example, it is perfectly legal to not provide an attribute value if an attribute definition was specified or, the other way round, to provide a value for an undefined attribute.  The attribute definitions are merely meant as a guideline for the engineer and as a basis for optionally checking if all attribute values are correct with respect to attribute definitions (by way of appropriate tool support).  With this conception of attribute values and definitions, many intricacies and difficult situations during the creation and evolution of a model are circumvented and complex interdependencies between parts of the model are avoided.  For example, it is made sure that a model and all its user attribute values can be safely viewed and edited even if the attribute definitions (i.e. UATemplates) for the model are temporarily unavailable or permanently lost.
 * 
 * Overview:
 * The stereotypes defined in this subprofile provide a set of constructs to help user define their own attributes. The core construct in EAST-ADL2, the ADLEntity, inherits from UserAttributableElement stereotype so that virtually any types of EAST-ADL2 entities might be enhanced with user-defined attributes. Of course in a UML model one is allowed to add attributes to the classes and UML elements on which stereotypes are applied, yet this mechanism enables to distinguish between attributes meant to be interpreted as compliant with EASt-ADL2 language and other if any.
 * <!-- end-model-doc -->
 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserattributesFactory
 * @model kind="package"
 * @generated
 */
public interface UserattributesPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserAttributeElementTypeImpl <em>User Attribute Element Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserAttributeElementTypeImpl
		 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserattributesPackageImpl#getUserAttributeElementType()
		 * @generated
		 */
		EClass USER_ATTRIBUTE_ELEMENT_TYPE = eINSTANCE.getUserAttributeElementType();

		/**
		 * The meta object literal for the '<em><b>Extended Element Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_ATTRIBUTE_ELEMENT_TYPE__EXTENDED_ELEMENT_TYPE = eINSTANCE.getUserAttributeElementType_ExtendedElementType();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_ATTRIBUTE_ELEMENT_TYPE__ATTRIBUTE = eINSTANCE.getUserAttributeElementType_Attribute();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_ATTRIBUTE_ELEMENT_TYPE__BASE_CLASS = eINSTANCE.getUserAttributeElementType_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Valid For</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER_ATTRIBUTE_ELEMENT_TYPE__VALID_FOR = eINSTANCE.getUserAttributeElementType_ValidFor();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserAttributeDefinitionImpl <em>User Attribute Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserAttributeDefinitionImpl
		 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserattributesPackageImpl#getUserAttributeDefinition()
		 * @generated
		 */
		EClass USER_ATTRIBUTE_DEFINITION = eINSTANCE.getUserAttributeDefinition();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_ATTRIBUTE_DEFINITION__BASE_PROPERTY = eINSTANCE.getUserAttributeDefinition_Base_Property();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_ATTRIBUTE_DEFINITION__BASE_CLASS = eINSTANCE.getUserAttributeDefinition_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER_ATTRIBUTE_DEFINITION__DEFAULT_VALUE = eINSTANCE.getUserAttributeDefinition_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_ATTRIBUTE_DEFINITION__TYPE = eINSTANCE.getUserAttributeDefinition_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserAttributeableElementImpl <em>User Attributeable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserAttributeableElementImpl
		 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserattributesPackageImpl#getUserAttributeableElement()
		 * @generated
		 */
		EClass USER_ATTRIBUTEABLE_ELEMENT = eINSTANCE.getUserAttributeableElement();

		/**
		 * The meta object literal for the '<em><b>Ua Value</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_ATTRIBUTEABLE_ELEMENT__UA_VALUE = eINSTANCE.getUserAttributeableElement_UaValue();

		/**
		 * The meta object literal for the '<em><b>Ua Type</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_ATTRIBUTEABLE_ELEMENT__UA_TYPE = eINSTANCE.getUserAttributeableElement_UaType();

		/**
		 * The meta object literal for the '<em><b>Attributed Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_ATTRIBUTEABLE_ELEMENT__ATTRIBUTED_ELEMENT = eINSTANCE.getUserAttributeableElement_AttributedElement();

		/**
		 * The meta object literal for the '<em><b>Base Named Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_ATTRIBUTEABLE_ELEMENT__BASE_NAMED_ELEMENT = eINSTANCE.getUserAttributeableElement_Base_NamedElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserAttributeValueImpl <em>User Attribute Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserAttributeValueImpl
		 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserattributesPackageImpl#getUserAttributeValue()
		 * @generated
		 */
		EClass USER_ATTRIBUTE_VALUE = eINSTANCE.getUserAttributeValue();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_ATTRIBUTE_VALUE__BASE_CLASS = eINSTANCE.getUserAttributeValue_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER_ATTRIBUTE_VALUE__VALUE = eINSTANCE.getUserAttributeValue_Value();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_ATTRIBUTE_VALUE__BASE_PROPERTY = eINSTANCE.getUserAttributeValue_Base_Property();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_ATTRIBUTE_VALUE__DEFINITION = eINSTANCE.getUserAttributeValue_Definition();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "userattributes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.papyrusuml.org/EAST-ADL2/Infrastructure/UserAttributes/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "UserAttributes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UserattributesPackage eINSTANCE = org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserattributesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserAttributeableElementImpl <em>User Attributeable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserAttributeableElementImpl
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserattributesPackageImpl#getUserAttributeableElement()
	 * @generated
	 */
	int USER_ATTRIBUTEABLE_ELEMENT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserAttributeElementTypeImpl <em>User Attribute Element Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserAttributeElementTypeImpl
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserattributesPackageImpl#getUserAttributeElementType()
	 * @generated
	 */
	int USER_ATTRIBUTE_ELEMENT_TYPE = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserAttributeDefinitionImpl <em>User Attribute Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserAttributeDefinitionImpl
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserattributesPackageImpl#getUserAttributeDefinition()
	 * @generated
	 */
	int USER_ATTRIBUTE_DEFINITION = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserAttributeValueImpl <em>User Attribute Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserAttributeValueImpl
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserattributesPackageImpl#getUserAttributeValue()
	 * @generated
	 */
	int USER_ATTRIBUTE_VALUE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTE_ELEMENT_TYPE__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTE_ELEMENT_TYPE__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTE_ELEMENT_TYPE__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extended Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTE_ELEMENT_TYPE__EXTENDED_ELEMENT_TYPE = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTE_ELEMENT_TYPE__ATTRIBUTE = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTE_ELEMENT_TYPE__BASE_CLASS = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Valid For</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTE_ELEMENT_TYPE__VALID_FOR = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>User Attribute Element Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTE_ELEMENT_TYPE_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTE_DEFINITION__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTE_DEFINITION__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTE_DEFINITION__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTE_DEFINITION__BASE_CLASS = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTE_DEFINITION__DEFAULT_VALUE = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTE_DEFINITION__TYPE = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTE_DEFINITION__BASE_PROPERTY = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>User Attribute Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTE_DEFINITION_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Ua Value</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTEABLE_ELEMENT__UA_VALUE = 0;

	/**
	 * The feature id for the '<em><b>Ua Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTEABLE_ELEMENT__UA_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Attributed Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTEABLE_ELEMENT__ATTRIBUTED_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTEABLE_ELEMENT__BASE_NAMED_ELEMENT = 3;

	/**
	 * The number of structural features of the '<em>User Attributeable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTEABLE_ELEMENT_FEATURE_COUNT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTE_VALUE__NAME = ElementsPackage.EA_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTE_VALUE__BASE_NAMED_ELEMENT = ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTE_VALUE__OWNED_COMMENT = ElementsPackage.EA_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTE_VALUE__BASE_CLASS = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTE_VALUE__VALUE = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTE_VALUE__BASE_PROPERTY = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTE_VALUE__DEFINITION = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>User Attribute Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ATTRIBUTE_VALUE_FEATURE_COUNT = ElementsPackage.EA_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeableElement <em>User Attributeable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Attributeable Element</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeableElement
	 * @generated
	 */
	EClass getUserAttributeableElement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeableElement#getUaType <em>Ua Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ua Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeableElement#getUaType()
	 * @see #getUserAttributeableElement()
	 * @generated
	 */
	EReference getUserAttributeableElement_UaType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeableElement#getAttributedElement <em>Attributed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attributed Element</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeableElement#getAttributedElement()
	 * @see #getUserAttributeableElement()
	 * @generated
	 */
	EReference getUserAttributeableElement_AttributedElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeableElement#getBase_NamedElement <em>Base Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Named Element</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeableElement#getBase_NamedElement()
	 * @see #getUserAttributeableElement()
	 * @generated
	 */
	EReference getUserAttributeableElement_Base_NamedElement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeableElement#getUaValue <em>Ua Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ua Value</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeableElement#getUaValue()
	 * @see #getUserAttributeableElement()
	 * @generated
	 */
	EReference getUserAttributeableElement_UaValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeDefinition <em>User Attribute Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Attribute Definition</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeDefinition
	 * @generated
	 */
	EClass getUserAttributeDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeDefinition#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeDefinition#getBase_Class()
	 * @see #getUserAttributeDefinition()
	 * @generated
	 */
	EReference getUserAttributeDefinition_Base_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeDefinition#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeDefinition#getDefaultValue()
	 * @see #getUserAttributeDefinition()
	 * @generated
	 */
	EAttribute getUserAttributeDefinition_DefaultValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeDefinition#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeDefinition#getType()
	 * @see #getUserAttributeDefinition()
	 * @generated
	 */
	EReference getUserAttributeDefinition_Type();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeDefinition#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeDefinition#getBase_Property()
	 * @see #getUserAttributeDefinition()
	 * @generated
	 */
	EReference getUserAttributeDefinition_Base_Property();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeElementType <em>User Attribute Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Attribute Element Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeElementType
	 * @generated
	 */
	EClass getUserAttributeElementType();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeElementType#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attribute</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeElementType#getAttribute()
	 * @see #getUserAttributeElementType()
	 * @generated
	 */
	EReference getUserAttributeElementType_Attribute();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeElementType#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeElementType#getBase_Class()
	 * @see #getUserAttributeElementType()
	 * @generated
	 */
	EReference getUserAttributeElementType_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeElementType#getExtendedElementType <em>Extended Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Extended Element Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeElementType#getExtendedElementType()
	 * @see #getUserAttributeElementType()
	 * @generated
	 */
	EReference getUserAttributeElementType_ExtendedElementType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeElementType#getValidFor <em>Valid For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Valid For</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeElementType#getValidFor()
	 * @see #getUserAttributeElementType()
	 * @generated
	 */
	EAttribute getUserAttributeElementType_ValidFor();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UserattributesFactory getUserattributesFactory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeValue <em>User Attribute Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Attribute Value</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeValue
	 * @generated
	 */
	EClass getUserAttributeValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeValue#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeValue#getBase_Class()
	 * @see #getUserAttributeValue()
	 * @generated
	 */
	EReference getUserAttributeValue_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeValue#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeValue#getDefinition()
	 * @see #getUserAttributeValue()
	 * @generated
	 */
	EReference getUserAttributeValue_Definition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeValue#getValue()
	 * @see #getUserAttributeValue()
	 * @generated
	 */
	EAttribute getUserAttributeValue_Value();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeValue#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeValue#getBase_Property()
	 * @see #getUserAttributeValue()
	 * @generated
	 */
	EReference getUserAttributeValue_Base_Property();

} //UserattributesPackage
