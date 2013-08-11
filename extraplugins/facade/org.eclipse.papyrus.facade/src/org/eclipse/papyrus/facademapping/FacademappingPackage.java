/**
 */
package org.eclipse.papyrus.facademapping;

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
 * @see org.eclipse.papyrus.facademapping.FacademappingFactory
 * @model kind="package"
 * @generated
 */
public interface FacademappingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "facademapping";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/facademapping";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "facademapping";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FacademappingPackage eINSTANCE = org.eclipse.papyrus.facademapping.impl.FacademappingPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.facademapping.impl.MappingImpl <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.facademapping.impl.MappingImpl
	 * @see org.eclipse.papyrus.facademapping.impl.FacademappingPackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 0;

	/**
	 * The feature id for the '<em><b>Uml Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__UML_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Specific Domain Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__SPECIFIC_DOMAIN_ELEMENT = 1;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.facademapping.impl.StereotypedMappingImpl <em>Stereotyped Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.facademapping.impl.StereotypedMappingImpl
	 * @see org.eclipse.papyrus.facademapping.impl.FacademappingPackageImpl#getStereotypedMapping()
	 * @generated
	 */
	int STEREOTYPED_MAPPING = 1;

	/**
	 * The feature id for the '<em><b>Uml Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPED_MAPPING__UML_ELEMENT = MAPPING__UML_ELEMENT;

	/**
	 * The feature id for the '<em><b>Specific Domain Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPED_MAPPING__SPECIFIC_DOMAIN_ELEMENT = MAPPING__SPECIFIC_DOMAIN_ELEMENT;

	/**
	 * The feature id for the '<em><b>Applied Stereotypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPED_MAPPING__APPLIED_STEREOTYPES = MAPPING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPED_MAPPING__KIND = MAPPING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Stereotyped Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPED_MAPPING_FEATURE_COUNT = MAPPING_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Stereotyped Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPED_MAPPING_OPERATION_COUNT = MAPPING_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.facademapping.impl.FacadeMapppingImpl <em>Facade Mappping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.facademapping.impl.FacadeMapppingImpl
	 * @see org.eclipse.papyrus.facademapping.impl.FacademappingPackageImpl#getFacadeMappping()
	 * @generated
	 */
	int FACADE_MAPPPING = 2;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACADE_MAPPPING__MAPPINGS = 0;

	/**
	 * The number of structural features of the '<em>Facade Mappping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACADE_MAPPPING_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Facade Mappping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACADE_MAPPPING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.facademapping.ExtensionDefinitionKind <em>Extension Definition Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.facademapping.ExtensionDefinitionKind
	 * @see org.eclipse.papyrus.facademapping.impl.FacademappingPackageImpl#getExtensionDefinitionKind()
	 * @generated
	 */
	int EXTENSION_DEFINITION_KIND = 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.facademapping.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see org.eclipse.papyrus.facademapping.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.facademapping.Mapping#getUmlElement <em>Uml Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Uml Element</em>'.
	 * @see org.eclipse.papyrus.facademapping.Mapping#getUmlElement()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_UmlElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.facademapping.Mapping#getSpecificDomainElement <em>Specific Domain Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Specific Domain Element</em>'.
	 * @see org.eclipse.papyrus.facademapping.Mapping#getSpecificDomainElement()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_SpecificDomainElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.facademapping.StereotypedMapping <em>Stereotyped Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stereotyped Mapping</em>'.
	 * @see org.eclipse.papyrus.facademapping.StereotypedMapping
	 * @generated
	 */
	EClass getStereotypedMapping();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.facademapping.StereotypedMapping#getAppliedStereotypes <em>Applied Stereotypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Applied Stereotypes</em>'.
	 * @see org.eclipse.papyrus.facademapping.StereotypedMapping#getAppliedStereotypes()
	 * @see #getStereotypedMapping()
	 * @generated
	 */
	EReference getStereotypedMapping_AppliedStereotypes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.facademapping.StereotypedMapping#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.papyrus.facademapping.StereotypedMapping#getKind()
	 * @see #getStereotypedMapping()
	 * @generated
	 */
	EAttribute getStereotypedMapping_Kind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.facademapping.FacadeMappping <em>Facade Mappping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Facade Mappping</em>'.
	 * @see org.eclipse.papyrus.facademapping.FacadeMappping
	 * @generated
	 */
	EClass getFacadeMappping();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.facademapping.FacadeMappping#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mappings</em>'.
	 * @see org.eclipse.papyrus.facademapping.FacadeMappping#getMappings()
	 * @see #getFacadeMappping()
	 * @generated
	 */
	EReference getFacadeMappping_Mappings();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.facademapping.ExtensionDefinitionKind <em>Extension Definition Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Extension Definition Kind</em>'.
	 * @see org.eclipse.papyrus.facademapping.ExtensionDefinitionKind
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
	FacademappingFactory getFacademappingFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.facademapping.impl.MappingImpl <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.facademapping.impl.MappingImpl
		 * @see org.eclipse.papyrus.facademapping.impl.FacademappingPackageImpl#getMapping()
		 * @generated
		 */
		EClass MAPPING = eINSTANCE.getMapping();

		/**
		 * The meta object literal for the '<em><b>Uml Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__UML_ELEMENT = eINSTANCE.getMapping_UmlElement();

		/**
		 * The meta object literal for the '<em><b>Specific Domain Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__SPECIFIC_DOMAIN_ELEMENT = eINSTANCE.getMapping_SpecificDomainElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.facademapping.impl.StereotypedMappingImpl <em>Stereotyped Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.facademapping.impl.StereotypedMappingImpl
		 * @see org.eclipse.papyrus.facademapping.impl.FacademappingPackageImpl#getStereotypedMapping()
		 * @generated
		 */
		EClass STEREOTYPED_MAPPING = eINSTANCE.getStereotypedMapping();

		/**
		 * The meta object literal for the '<em><b>Applied Stereotypes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEREOTYPED_MAPPING__APPLIED_STEREOTYPES = eINSTANCE.getStereotypedMapping_AppliedStereotypes();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEREOTYPED_MAPPING__KIND = eINSTANCE.getStereotypedMapping_Kind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.facademapping.impl.FacadeMapppingImpl <em>Facade Mappping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.facademapping.impl.FacadeMapppingImpl
		 * @see org.eclipse.papyrus.facademapping.impl.FacademappingPackageImpl#getFacadeMappping()
		 * @generated
		 */
		EClass FACADE_MAPPPING = eINSTANCE.getFacadeMappping();

		/**
		 * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACADE_MAPPPING__MAPPINGS = eINSTANCE.getFacadeMappping_Mappings();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.facademapping.ExtensionDefinitionKind <em>Extension Definition Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.facademapping.ExtensionDefinitionKind
		 * @see org.eclipse.papyrus.facademapping.impl.FacademappingPackageImpl#getExtensionDefinitionKind()
		 * @generated
		 */
		EEnum EXTENSION_DEFINITION_KIND = eINSTANCE.getExtensionDefinitionKind();

	}

} //FacademappingPackage
