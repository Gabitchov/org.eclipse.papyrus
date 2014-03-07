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
package org.eclipse.papyrus.eastadl.structure.systemmodeling;

import org.eclipse.emf.ecore.EClass;
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
 * The ADLSystemModel is the top level container of an EAST-ADL2 model. It represents the electronics & software of the vehicle, and its environment,
 * and concepts related to the various abstraction level of models used in EAST-ADL2. It is mainly based on both concepts: Models and architectures.
 * VehicleFeatureModel represents the features of the vehicle, i.e. the externally visible properties
 * The AnalysisArchitecture is the abstract functional description of the vehicle electronics
 * The DesignArchitecture contains the functional specification and hardware architecture of the vehicle electronics
 * The Implementation Architecture contains the software architecture and components and the hardware architecture of the vehicle
 * The Operational Architecture represents the actual software and electronics in the manufactured vehicle
 * The word model vs. architecture is chosen rather informally. Architecture is used where this term is often used in practice, and where the
 * construct is a complete (in some sense) reflection of the aspects that it captures. Model is used in other cases.
 * These models/architectures contain further elements in a hierarchy.. Relations between these elements over the boundaries between the
 * models/architectures are contained in the ADLSystemModel. This is possible because the SystemModel is a specialization of the ADLContext, and is
 * thus able to contain relations. Typical relations are described in the sub-package CoreConstructs (see definition of ADLRelationship,
 * ADLRealization and ADLSatisfy).
 * 
 * Overview:
 * The ADLSystemModel is the top level container of an EAST-ADL2 model. It represents the electronics & software of the vehicle, and its environment,
 * and concepts related to the various abstraction level of models used in EAST-ADL2. It is mainly based on both concepts: Models and architectures.
 * <!-- end-model-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingFactory
 * @model kind="package"
 * @generated
 */
public interface SystemmodelingPackage extends EPackage {

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.SystemModelImpl <em>System Model</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.SystemModelImpl
		 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.SystemmodelingPackageImpl#getSystemModel()
		 * @generated
		 */
		EClass SYSTEM_MODEL = eINSTANCE.getSystemModel();

		/**
		 * The meta object literal for the '<em><b>Implementation Level</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SYSTEM_MODEL__IMPLEMENTATION_LEVEL = eINSTANCE.getSystemModel_ImplementationLevel();

		/**
		 * The meta object literal for the '<em><b>Analysis Level</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SYSTEM_MODEL__ANALYSIS_LEVEL = eINSTANCE.getSystemModel_AnalysisLevel();

		/**
		 * The meta object literal for the '<em><b>Design Level</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SYSTEM_MODEL__DESIGN_LEVEL = eINSTANCE.getSystemModel_DesignLevel();

		/**
		 * The meta object literal for the '<em><b>Vehicle Level</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SYSTEM_MODEL__VEHICLE_LEVEL = eINSTANCE.getSystemModel_VehicleLevel();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SYSTEM_MODEL__BASE_CLASS = eINSTANCE.getSystemModel_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SYSTEM_MODEL__BASE_PACKAGE = eINSTANCE.getSystemModel_Base_Package();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.ImplementationLevelImpl
		 * <em>Implementation Level</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.ImplementationLevelImpl
		 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.SystemmodelingPackageImpl#getImplementationLevel()
		 * @generated
		 */
		EClass IMPLEMENTATION_LEVEL = eINSTANCE.getImplementationLevel();

		/**
		 * The meta object literal for the '<em><b>Autosar System</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference IMPLEMENTATION_LEVEL__AUTOSAR_SYSTEM = eINSTANCE.getImplementationLevel_AutosarSystem();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference IMPLEMENTATION_LEVEL__BASE_CLASS = eINSTANCE.getImplementationLevel_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference IMPLEMENTATION_LEVEL__BASE_PACKAGE = eINSTANCE.getImplementationLevel_Base_Package();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.AnalysisLevelImpl
		 * <em>Analysis Level</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.AnalysisLevelImpl
		 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.SystemmodelingPackageImpl#getAnalysisLevel()
		 * @generated
		 */
		EClass ANALYSIS_LEVEL = eINSTANCE.getAnalysisLevel();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ANALYSIS_LEVEL__BASE_CLASS = eINSTANCE.getAnalysisLevel_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ANALYSIS_LEVEL__BASE_PACKAGE = eINSTANCE.getAnalysisLevel_Base_Package();

		/**
		 * The meta object literal for the '<em><b>Functional Analysis Architecture</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ANALYSIS_LEVEL__FUNCTIONAL_ANALYSIS_ARCHITECTURE = eINSTANCE.getAnalysisLevel_FunctionalAnalysisArchitecture();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.DesignLevelImpl <em>Design Level</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.DesignLevelImpl
		 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.SystemmodelingPackageImpl#getDesignLevel()
		 * @generated
		 */
		EClass DESIGN_LEVEL = eINSTANCE.getDesignLevel();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DESIGN_LEVEL__BASE_CLASS = eINSTANCE.getDesignLevel_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DESIGN_LEVEL__BASE_PACKAGE = eINSTANCE.getDesignLevel_Base_Package();

		/**
		 * The meta object literal for the '<em><b>Functional Design Architecture</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DESIGN_LEVEL__FUNCTIONAL_DESIGN_ARCHITECTURE = eINSTANCE.getDesignLevel_FunctionalDesignArchitecture();

		/**
		 * The meta object literal for the '<em><b>Hardware Design Architecture</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DESIGN_LEVEL__HARDWARE_DESIGN_ARCHITECTURE = eINSTANCE.getDesignLevel_HardwareDesignArchitecture();

		/**
		 * The meta object literal for the '<em><b>Allocation</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DESIGN_LEVEL__ALLOCATION = eINSTANCE.getDesignLevel_Allocation();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.VehicleLevelImpl <em>Vehicle Level</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.VehicleLevelImpl
		 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.SystemmodelingPackageImpl#getVehicleLevel()
		 * @generated
		 */
		EClass VEHICLE_LEVEL = eINSTANCE.getVehicleLevel();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VEHICLE_LEVEL__BASE_PACKAGE = eINSTANCE.getVehicleLevel_Base_Package();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VEHICLE_LEVEL__BASE_CLASS = eINSTANCE.getVehicleLevel_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Technical Feature Model</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VEHICLE_LEVEL__TECHNICAL_FEATURE_MODEL = eINSTANCE.getVehicleLevel_TechnicalFeatureModel();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "systemmodeling";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.papyrusuml.org/EAST-ADL2/Structure/SystemModeling/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "SystemModeling";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	SystemmodelingPackage eINSTANCE = org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.SystemmodelingPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.SystemModelImpl <em>System Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.SystemModelImpl
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.SystemmodelingPackageImpl#getSystemModel()
	 * @generated
	 */
	int SYSTEM_MODEL = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.ImplementationLevelImpl
	 * <em>Implementation Level</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.ImplementationLevelImpl
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.SystemmodelingPackageImpl#getImplementationLevel()
	 * @generated
	 */
	int IMPLEMENTATION_LEVEL = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.AnalysisLevelImpl <em>Analysis Level</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.AnalysisLevelImpl
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.SystemmodelingPackageImpl#getAnalysisLevel()
	 * @generated
	 */
	int ANALYSIS_LEVEL = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.DesignLevelImpl <em>Design Level</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.DesignLevelImpl
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.SystemmodelingPackageImpl#getDesignLevel()
	 * @generated
	 */
	int DESIGN_LEVEL = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYSTEM_MODEL__NAME = ElementsPackage.CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYSTEM_MODEL__BASE_NAMED_ELEMENT = ElementsPackage.CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYSTEM_MODEL__OWNED_COMMENT = ElementsPackage.CONTEXT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYSTEM_MODEL__TRACEABLE_SPECIFICATION = ElementsPackage.CONTEXT__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYSTEM_MODEL__OWNED_RELATIONSHIP = ElementsPackage.CONTEXT__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Implementation Level</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYSTEM_MODEL__IMPLEMENTATION_LEVEL = ElementsPackage.CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Analysis Level</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYSTEM_MODEL__ANALYSIS_LEVEL = ElementsPackage.CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Design Level</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYSTEM_MODEL__DESIGN_LEVEL = ElementsPackage.CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Vehicle Level</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYSTEM_MODEL__VEHICLE_LEVEL = ElementsPackage.CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYSTEM_MODEL__BASE_CLASS = ElementsPackage.CONTEXT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYSTEM_MODEL__BASE_PACKAGE = ElementsPackage.CONTEXT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>System Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYSTEM_MODEL_FEATURE_COUNT = ElementsPackage.CONTEXT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_LEVEL__NAME = ElementsPackage.CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_LEVEL__BASE_NAMED_ELEMENT = ElementsPackage.CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_LEVEL__OWNED_COMMENT = ElementsPackage.CONTEXT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_LEVEL__TRACEABLE_SPECIFICATION = ElementsPackage.CONTEXT__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_LEVEL__OWNED_RELATIONSHIP = ElementsPackage.CONTEXT__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Autosar System</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_LEVEL__AUTOSAR_SYSTEM = ElementsPackage.CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_LEVEL__BASE_CLASS = ElementsPackage.CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_LEVEL__BASE_PACKAGE = ElementsPackage.CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Implementation Level</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_LEVEL_FEATURE_COUNT = ElementsPackage.CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_LEVEL__NAME = ElementsPackage.CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_LEVEL__BASE_NAMED_ELEMENT = ElementsPackage.CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_LEVEL__OWNED_COMMENT = ElementsPackage.CONTEXT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_LEVEL__TRACEABLE_SPECIFICATION = ElementsPackage.CONTEXT__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_LEVEL__OWNED_RELATIONSHIP = ElementsPackage.CONTEXT__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_LEVEL__BASE_CLASS = ElementsPackage.CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_LEVEL__BASE_PACKAGE = ElementsPackage.CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Functional Analysis Architecture</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_LEVEL__FUNCTIONAL_ANALYSIS_ARCHITECTURE = ElementsPackage.CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Analysis Level</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_LEVEL_FEATURE_COUNT = ElementsPackage.CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_LEVEL__NAME = ElementsPackage.CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_LEVEL__BASE_NAMED_ELEMENT = ElementsPackage.CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_LEVEL__OWNED_COMMENT = ElementsPackage.CONTEXT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_LEVEL__TRACEABLE_SPECIFICATION = ElementsPackage.CONTEXT__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_LEVEL__OWNED_RELATIONSHIP = ElementsPackage.CONTEXT__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_LEVEL__BASE_CLASS = ElementsPackage.CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_LEVEL__BASE_PACKAGE = ElementsPackage.CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Functional Design Architecture</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_LEVEL__FUNCTIONAL_DESIGN_ARCHITECTURE = ElementsPackage.CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Hardware Design Architecture</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_LEVEL__HARDWARE_DESIGN_ARCHITECTURE = ElementsPackage.CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Allocation</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_LEVEL__ALLOCATION = ElementsPackage.CONTEXT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Design Level</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESIGN_LEVEL_FEATURE_COUNT = ElementsPackage.CONTEXT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.VehicleLevelImpl <em>Vehicle Level</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.VehicleLevelImpl
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.SystemmodelingPackageImpl#getVehicleLevel()
	 * @generated
	 */
	int VEHICLE_LEVEL = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VEHICLE_LEVEL__NAME = ElementsPackage.CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VEHICLE_LEVEL__BASE_NAMED_ELEMENT = ElementsPackage.CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VEHICLE_LEVEL__OWNED_COMMENT = ElementsPackage.CONTEXT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VEHICLE_LEVEL__TRACEABLE_SPECIFICATION = ElementsPackage.CONTEXT__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VEHICLE_LEVEL__OWNED_RELATIONSHIP = ElementsPackage.CONTEXT__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VEHICLE_LEVEL__BASE_PACKAGE = ElementsPackage.CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VEHICLE_LEVEL__BASE_CLASS = ElementsPackage.CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Technical Feature Model</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VEHICLE_LEVEL__TECHNICAL_FEATURE_MODEL = ElementsPackage.CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Vehicle Level</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VEHICLE_LEVEL_FEATURE_COUNT = ElementsPackage.CONTEXT_FEATURE_COUNT + 3;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.AnalysisLevel <em>Analysis Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Analysis Level</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.AnalysisLevel
	 * @generated
	 */
	EClass getAnalysisLevel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.AnalysisLevel#getBase_Class
	 * <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.AnalysisLevel#getBase_Class()
	 * @see #getAnalysisLevel()
	 * @generated
	 */
	EReference getAnalysisLevel_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.AnalysisLevel#getBase_Package
	 * <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.AnalysisLevel#getBase_Package()
	 * @see #getAnalysisLevel()
	 * @generated
	 */
	EReference getAnalysisLevel_Base_Package();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.papyrus.eastadl.structure.systemmodeling.AnalysisLevel#getFunctionalAnalysisArchitecture
	 * <em>Functional Analysis Architecture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Functional Analysis Architecture</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.AnalysisLevel#getFunctionalAnalysisArchitecture()
	 * @see #getAnalysisLevel()
	 * @generated
	 */
	EReference getAnalysisLevel_FunctionalAnalysisArchitecture();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.DesignLevel <em>Design Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Design Level</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.DesignLevel
	 * @generated
	 */
	EClass getDesignLevel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.DesignLevel#getBase_Class
	 * <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.DesignLevel#getBase_Class()
	 * @see #getDesignLevel()
	 * @generated
	 */
	EReference getDesignLevel_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.DesignLevel#getBase_Package
	 * <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.DesignLevel#getBase_Package()
	 * @see #getDesignLevel()
	 * @generated
	 */
	EReference getDesignLevel_Base_Package();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.DesignLevel#getAllocation
	 * <em>Allocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Allocation</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.DesignLevel#getAllocation()
	 * @see #getDesignLevel()
	 * @generated
	 */
	EReference getDesignLevel_Allocation();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.papyrus.eastadl.structure.systemmodeling.DesignLevel#getFunctionalDesignArchitecture
	 * <em>Functional Design Architecture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Functional Design Architecture</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.DesignLevel#getFunctionalDesignArchitecture()
	 * @see #getDesignLevel()
	 * @generated
	 */
	EReference getDesignLevel_FunctionalDesignArchitecture();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.papyrus.eastadl.structure.systemmodeling.DesignLevel#getHardwareDesignArchitecture <em>Hardware Design Architecture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Hardware Design Architecture</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.DesignLevel#getHardwareDesignArchitecture()
	 * @see #getDesignLevel()
	 * @generated
	 */
	EReference getDesignLevel_HardwareDesignArchitecture();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.ImplementationLevel
	 * <em>Implementation Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Implementation Level</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.ImplementationLevel
	 * @generated
	 */
	EClass getImplementationLevel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.ImplementationLevel#getAutosarSystem
	 * <em>Autosar System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Autosar System</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.ImplementationLevel#getAutosarSystem()
	 * @see #getImplementationLevel()
	 * @generated
	 */
	EReference getImplementationLevel_AutosarSystem();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.ImplementationLevel#getBase_Class
	 * <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.ImplementationLevel#getBase_Class()
	 * @see #getImplementationLevel()
	 * @generated
	 */
	EReference getImplementationLevel_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.ImplementationLevel#getBase_Package
	 * <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.ImplementationLevel#getBase_Package()
	 * @see #getImplementationLevel()
	 * @generated
	 */
	EReference getImplementationLevel_Base_Package();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemModel <em>System Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>System Model</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemModel
	 * @generated
	 */
	EClass getSystemModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemModel#getAnalysisLevel
	 * <em>Analysis Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Analysis Level</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemModel#getAnalysisLevel()
	 * @see #getSystemModel()
	 * @generated
	 */
	EReference getSystemModel_AnalysisLevel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemModel#getDesignLevel
	 * <em>Design Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Design Level</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemModel#getDesignLevel()
	 * @see #getSystemModel()
	 * @generated
	 */
	EReference getSystemModel_DesignLevel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemModel#getImplementationLevel
	 * <em>Implementation Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Implementation Level</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemModel#getImplementationLevel()
	 * @see #getSystemModel()
	 * @generated
	 */
	EReference getSystemModel_ImplementationLevel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemModel#getVehicleLevel
	 * <em>Vehicle Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Vehicle Level</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemModel#getVehicleLevel()
	 * @see #getSystemModel()
	 * @generated
	 */
	EReference getSystemModel_VehicleLevel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemModel#getBase_Class
	 * <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemModel#getBase_Class()
	 * @see #getSystemModel()
	 * @generated
	 */
	EReference getSystemModel_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemModel#getBase_Package
	 * <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemModel#getBase_Package()
	 * @see #getSystemModel()
	 * @generated
	 */
	EReference getSystemModel_Base_Package();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SystemmodelingFactory getSystemmodelingFactory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.VehicleLevel <em>Vehicle Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Vehicle Level</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.VehicleLevel
	 * @generated
	 */
	EClass getVehicleLevel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.VehicleLevel#getBase_Package
	 * <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.VehicleLevel#getBase_Package()
	 * @see #getVehicleLevel()
	 * @generated
	 */
	EReference getVehicleLevel_Base_Package();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.structure.systemmodeling.VehicleLevel#getBase_Class
	 * <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.VehicleLevel#getBase_Class()
	 * @see #getVehicleLevel()
	 * @generated
	 */
	EReference getVehicleLevel_Base_Class();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.eastadl.structure.systemmodeling.VehicleLevel#getTechnicalFeatureModel <em>Technical Feature Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Technical Feature Model</em>'.
	 * @see org.eclipse.papyrus.eastadl.structure.systemmodeling.VehicleLevel#getTechnicalFeatureModel()
	 * @see #getVehicleLevel()
	 * @generated
	 */
	EReference getVehicleLevel_TechnicalFeatureModel();

} //SystemmodelingPackage
