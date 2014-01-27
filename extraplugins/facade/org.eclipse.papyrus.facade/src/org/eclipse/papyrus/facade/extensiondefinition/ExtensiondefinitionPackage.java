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
package org.eclipse.papyrus.facade.extensiondefinition;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionFactory
 * @model kind="package"
 * @generated
 */
public interface ExtensiondefinitionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "extensiondefinition";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/extensiondefinition";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "extensiondefinition";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExtensiondefinitionPackage eINSTANCE = org.eclipse.papyrus.facade.extensiondefinition.impl.ExtensiondefinitionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.facade.extensiondefinition.impl.ExtensionDefinitionImpl <em>Extension Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.facade.extensiondefinition.impl.ExtensionDefinitionImpl
	 * @see org.eclipse.papyrus.facade.extensiondefinition.impl.ExtensiondefinitionPackageImpl#getExtensionDefinition()
	 * @generated
	 */
	int EXTENSION_DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_DEFINITION__EXTENSION = 0;

	/**
	 * The feature id for the '<em><b>Base Metaclasses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_DEFINITION__BASE_METACLASSES = 1;

	/**
	 * The feature id for the '<em><b>Facade</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_DEFINITION__FACADE = 2;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_DEFINITION__STEREOTYPE = 3;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_DEFINITION__KIND = 4;

	/**
	 * The number of structural features of the '<em>Extension Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_DEFINITION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Extension Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_DEFINITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.facade.extensiondefinition.impl.BaseMetaclassImpl <em>Base Metaclass</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.facade.extensiondefinition.impl.BaseMetaclassImpl
	 * @see org.eclipse.papyrus.facade.extensiondefinition.impl.ExtensiondefinitionPackageImpl#getBaseMetaclass()
	 * @generated
	 */
	int BASE_METACLASS = 1;

	/**
	 * The feature id for the '<em><b>Incompatible Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METACLASS__INCOMPATIBLE_STEREOTYPES = 0;

	/**
	 * The feature id for the '<em><b>Base</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METACLASS__BASE = 1;

	/**
	 * The feature id for the '<em><b>Extension Definition</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METACLASS__EXTENSION_DEFINITION = 2;

	/**
	 * The feature id for the '<em><b>Compatible Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METACLASS__COMPATIBLE_STEREOTYPES = 3;

	/**
	 * The feature id for the '<em><b>Possible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METACLASS__POSSIBLE = 4;

	/**
	 * The number of structural features of the '<em>Base Metaclass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METACLASS_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Base Metaclass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_METACLASS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.facade.extensiondefinition.impl.CombinationImpl <em>Combination</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.facade.extensiondefinition.impl.CombinationImpl
	 * @see org.eclipse.papyrus.facade.extensiondefinition.impl.ExtensiondefinitionPackageImpl#getCombination()
	 * @generated
	 */
	int COMBINATION = 2;

	/**
	 * The feature id for the '<em><b>Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINATION__MEMBERS = 0;

	/**
	 * The number of structural features of the '<em>Combination</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Combination</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBINATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinitionKind <em>Extension Definition Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinitionKind
	 * @see org.eclipse.papyrus.facade.extensiondefinition.impl.ExtensiondefinitionPackageImpl#getExtensionDefinitionKind()
	 * @generated
	 */
	int EXTENSION_DEFINITION_KIND = 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition <em>Extension Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Definition</em>'.
	 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition
	 * @generated
	 */
	EClass getExtensionDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Extension</em>'.
	 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition#getExtension()
	 * @see #getExtensionDefinition()
	 * @generated
	 */
	EReference getExtensionDefinition_Extension();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition#getBaseMetaclasses <em>Base Metaclasses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Base Metaclasses</em>'.
	 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition#getBaseMetaclasses()
	 * @see #getExtensionDefinition()
	 * @generated
	 */
	EReference getExtensionDefinition_BaseMetaclasses();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition#getFacade <em>Facade</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Facade</em>'.
	 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition#getFacade()
	 * @see #getExtensionDefinition()
	 * @generated
	 */
	EReference getExtensionDefinition_Facade();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition#getStereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Stereotype</em>'.
	 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition#getStereotype()
	 * @see #getExtensionDefinition()
	 * @generated
	 */
	EReference getExtensionDefinition_Stereotype();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition#getKind()
	 * @see #getExtensionDefinition()
	 * @generated
	 */
	EAttribute getExtensionDefinition_Kind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass <em>Base Metaclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Metaclass</em>'.
	 * @see org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass
	 * @generated
	 */
	EClass getBaseMetaclass();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass#getIncompatibleStereotypes <em>Incompatible Stereotypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Incompatible Stereotypes</em>'.
	 * @see org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass#getIncompatibleStereotypes()
	 * @see #getBaseMetaclass()
	 * @generated
	 */
	EReference getBaseMetaclass_IncompatibleStereotypes();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass#getBase <em>Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base</em>'.
	 * @see org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass#getBase()
	 * @see #getBaseMetaclass()
	 * @generated
	 */
	EReference getBaseMetaclass_Base();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass#getExtensionDefinition <em>Extension Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Extension Definition</em>'.
	 * @see org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass#getExtensionDefinition()
	 * @see #getBaseMetaclass()
	 * @generated
	 */
	EReference getBaseMetaclass_ExtensionDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass#getCompatibleStereotypes <em>Compatible Stereotypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Compatible Stereotypes</em>'.
	 * @see org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass#getCompatibleStereotypes()
	 * @see #getBaseMetaclass()
	 * @generated
	 */
	EReference getBaseMetaclass_CompatibleStereotypes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass#isPossible <em>Possible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Possible</em>'.
	 * @see org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass#isPossible()
	 * @see #getBaseMetaclass()
	 * @generated
	 */
	EAttribute getBaseMetaclass_Possible();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.facade.extensiondefinition.Combination <em>Combination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Combination</em>'.
	 * @see org.eclipse.papyrus.facade.extensiondefinition.Combination
	 * @generated
	 */
	EClass getCombination();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.facade.extensiondefinition.Combination#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Members</em>'.
	 * @see org.eclipse.papyrus.facade.extensiondefinition.Combination#getMembers()
	 * @see #getCombination()
	 * @generated
	 */
	EReference getCombination_Members();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinitionKind <em>Extension Definition Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Extension Definition Kind</em>'.
	 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinitionKind
	 * @generated
	 */
	EEnum getExtensionDefinitionKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExtensiondefinitionFactory getExtensiondefinitionFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.facade.extensiondefinition.impl.ExtensionDefinitionImpl <em>Extension Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.facade.extensiondefinition.impl.ExtensionDefinitionImpl
		 * @see org.eclipse.papyrus.facade.extensiondefinition.impl.ExtensiondefinitionPackageImpl#getExtensionDefinition()
		 * @generated
		 */
		EClass EXTENSION_DEFINITION = eINSTANCE.getExtensionDefinition();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_DEFINITION__EXTENSION = eINSTANCE.getExtensionDefinition_Extension();

		/**
		 * The meta object literal for the '<em><b>Base Metaclasses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_DEFINITION__BASE_METACLASSES = eINSTANCE.getExtensionDefinition_BaseMetaclasses();

		/**
		 * The meta object literal for the '<em><b>Facade</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_DEFINITION__FACADE = eINSTANCE.getExtensionDefinition_Facade();

		/**
		 * The meta object literal for the '<em><b>Stereotype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_DEFINITION__STEREOTYPE = eINSTANCE.getExtensionDefinition_Stereotype();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION_DEFINITION__KIND = eINSTANCE.getExtensionDefinition_Kind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.facade.extensiondefinition.impl.BaseMetaclassImpl <em>Base Metaclass</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.facade.extensiondefinition.impl.BaseMetaclassImpl
		 * @see org.eclipse.papyrus.facade.extensiondefinition.impl.ExtensiondefinitionPackageImpl#getBaseMetaclass()
		 * @generated
		 */
		EClass BASE_METACLASS = eINSTANCE.getBaseMetaclass();

		/**
		 * The meta object literal for the '<em><b>Incompatible Stereotypes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_METACLASS__INCOMPATIBLE_STEREOTYPES = eINSTANCE.getBaseMetaclass_IncompatibleStereotypes();

		/**
		 * The meta object literal for the '<em><b>Base</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_METACLASS__BASE = eINSTANCE.getBaseMetaclass_Base();

		/**
		 * The meta object literal for the '<em><b>Extension Definition</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_METACLASS__EXTENSION_DEFINITION = eINSTANCE.getBaseMetaclass_ExtensionDefinition();

		/**
		 * The meta object literal for the '<em><b>Compatible Stereotypes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_METACLASS__COMPATIBLE_STEREOTYPES = eINSTANCE.getBaseMetaclass_CompatibleStereotypes();

		/**
		 * The meta object literal for the '<em><b>Possible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASE_METACLASS__POSSIBLE = eINSTANCE.getBaseMetaclass_Possible();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.facade.extensiondefinition.impl.CombinationImpl <em>Combination</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.facade.extensiondefinition.impl.CombinationImpl
		 * @see org.eclipse.papyrus.facade.extensiondefinition.impl.ExtensiondefinitionPackageImpl#getCombination()
		 * @generated
		 */
		EClass COMBINATION = eINSTANCE.getCombination();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMBINATION__MEMBERS = eINSTANCE.getCombination_Members();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinitionKind <em>Extension Definition Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinitionKind
		 * @see org.eclipse.papyrus.facade.extensiondefinition.impl.ExtensiondefinitionPackageImpl#getExtensionDefinitionKind()
		 * @generated
		 */
		EEnum EXTENSION_DEFINITION_KIND = eINSTANCE.getExtensionDefinitionKind();

	}

} //ExtensiondefinitionPackage
