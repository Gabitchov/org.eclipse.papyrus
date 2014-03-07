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
package org.eclipse.papyrus.eastadl.interchange;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage;


/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The interchange part of an EAST-ADL2 system model is for exchanging model data with external stakeholders. E.g. it provides elements (see RIFArea)
 * for importing resp. exporting requirements specifications into resp. out of an EAST-ADL2 system model.
 * <!-- end-model-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.interchange.InterchangeFactory
 * @model kind="package"
 * @generated
 */
public interface InterchangePackage extends EPackage {

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
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
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.interchange.impl.RIFAreaImpl <em>RIF Area</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.interchange.impl.RIFAreaImpl
		 * @see org.eclipse.papyrus.eastadl.interchange.impl.InterchangePackageImpl#getRIFArea()
		 * @generated
		 */
		EClass RIF_AREA = eINSTANCE.getRIFArea();

		/**
		 * The meta object literal for the '<em><b>Root Requirement Container</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference RIF_AREA__ROOT_REQUIREMENT_CONTAINER = eINSTANCE.getRIFArea_RootRequirementContainer();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference RIF_AREA__BASE_CLASS = eINSTANCE.getRIFArea_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Interchange Req Spec Object</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference RIF_AREA__INTERCHANGE_REQ_SPEC_OBJECT = eINSTANCE.getRIFArea_InterchangeReqSpecObject();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.interchange.impl.RIFExportAreaImpl <em>RIF Export Area</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.interchange.impl.RIFExportAreaImpl
		 * @see org.eclipse.papyrus.eastadl.interchange.impl.InterchangePackageImpl#getRIFExportArea()
		 * @generated
		 */
		EClass RIF_EXPORT_AREA = eINSTANCE.getRIFExportArea();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.interchange.impl.RIFImportAreaImpl <em>RIF Import Area</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.interchange.impl.RIFImportAreaImpl
		 * @see org.eclipse.papyrus.eastadl.interchange.impl.InterchangePackageImpl#getRIFImportArea()
		 * @generated
		 */
		EClass RIF_IMPORT_AREA = eINSTANCE.getRIFImportArea();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "interchange";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.papyrusuml.org/EAST-ADL2/Interchange/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "Interchange";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	InterchangePackage eINSTANCE = org.eclipse.papyrus.eastadl.interchange.impl.InterchangePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.interchange.impl.RIFAreaImpl <em>RIF Area</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.interchange.impl.RIFAreaImpl
	 * @see org.eclipse.papyrus.eastadl.interchange.impl.InterchangePackageImpl#getRIFArea()
	 * @generated
	 */
	int RIF_AREA = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RIF_AREA__NAME = ElementsPackage.CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RIF_AREA__BASE_NAMED_ELEMENT = ElementsPackage.CONTEXT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RIF_AREA__OWNED_COMMENT = ElementsPackage.CONTEXT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RIF_AREA__TRACEABLE_SPECIFICATION = ElementsPackage.CONTEXT__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RIF_AREA__OWNED_RELATIONSHIP = ElementsPackage.CONTEXT__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Root Requirement Container</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RIF_AREA__ROOT_REQUIREMENT_CONTAINER = ElementsPackage.CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RIF_AREA__BASE_CLASS = ElementsPackage.CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Interchange Req Spec Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RIF_AREA__INTERCHANGE_REQ_SPEC_OBJECT = ElementsPackage.CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>RIF Area</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RIF_AREA_FEATURE_COUNT = ElementsPackage.CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.interchange.impl.RIFExportAreaImpl <em>RIF Export Area</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.interchange.impl.RIFExportAreaImpl
	 * @see org.eclipse.papyrus.eastadl.interchange.impl.InterchangePackageImpl#getRIFExportArea()
	 * @generated
	 */
	int RIF_EXPORT_AREA = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RIF_EXPORT_AREA__NAME = RIF_AREA__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RIF_EXPORT_AREA__BASE_NAMED_ELEMENT = RIF_AREA__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RIF_EXPORT_AREA__OWNED_COMMENT = RIF_AREA__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RIF_EXPORT_AREA__TRACEABLE_SPECIFICATION = RIF_AREA__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RIF_EXPORT_AREA__OWNED_RELATIONSHIP = RIF_AREA__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Root Requirement Container</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RIF_EXPORT_AREA__ROOT_REQUIREMENT_CONTAINER = RIF_AREA__ROOT_REQUIREMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RIF_EXPORT_AREA__BASE_CLASS = RIF_AREA__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Interchange Req Spec Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RIF_EXPORT_AREA__INTERCHANGE_REQ_SPEC_OBJECT = RIF_AREA__INTERCHANGE_REQ_SPEC_OBJECT;

	/**
	 * The number of structural features of the '<em>RIF Export Area</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RIF_EXPORT_AREA_FEATURE_COUNT = RIF_AREA_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.interchange.impl.RIFImportAreaImpl <em>RIF Import Area</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.interchange.impl.RIFImportAreaImpl
	 * @see org.eclipse.papyrus.eastadl.interchange.impl.InterchangePackageImpl#getRIFImportArea()
	 * @generated
	 */
	int RIF_IMPORT_AREA = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RIF_IMPORT_AREA__NAME = RIF_AREA__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RIF_IMPORT_AREA__BASE_NAMED_ELEMENT = RIF_AREA__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RIF_IMPORT_AREA__OWNED_COMMENT = RIF_AREA__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Traceable Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RIF_IMPORT_AREA__TRACEABLE_SPECIFICATION = RIF_AREA__TRACEABLE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Owned Relationship</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RIF_IMPORT_AREA__OWNED_RELATIONSHIP = RIF_AREA__OWNED_RELATIONSHIP;

	/**
	 * The feature id for the '<em><b>Root Requirement Container</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RIF_IMPORT_AREA__ROOT_REQUIREMENT_CONTAINER = RIF_AREA__ROOT_REQUIREMENT_CONTAINER;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RIF_IMPORT_AREA__BASE_CLASS = RIF_AREA__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Interchange Req Spec Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RIF_IMPORT_AREA__INTERCHANGE_REQ_SPEC_OBJECT = RIF_AREA__INTERCHANGE_REQ_SPEC_OBJECT;

	/**
	 * The number of structural features of the '<em>RIF Import Area</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RIF_IMPORT_AREA_FEATURE_COUNT = RIF_AREA_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.interchange.RIFArea <em>RIF Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>RIF Area</em>'.
	 * @see org.eclipse.papyrus.eastadl.interchange.RIFArea
	 * @generated
	 */
	EClass getRIFArea();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.interchange.RIFArea#getRootRequirementContainer
	 * <em>Root Requirement Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Root Requirement Container</em>'.
	 * @see org.eclipse.papyrus.eastadl.interchange.RIFArea#getRootRequirementContainer()
	 * @see #getRIFArea()
	 * @generated
	 */
	EReference getRIFArea_RootRequirementContainer();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.interchange.RIFArea#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.eastadl.interchange.RIFArea#getBase_Class()
	 * @see #getRIFArea()
	 * @generated
	 */
	EReference getRIFArea_Base_Class();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.interchange.RIFArea#getInterchangeReqSpecObject
	 * <em>Interchange Req Spec Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Interchange Req Spec Object</em>'.
	 * @see org.eclipse.papyrus.eastadl.interchange.RIFArea#getInterchangeReqSpecObject()
	 * @see #getRIFArea()
	 * @generated
	 */
	EReference getRIFArea_InterchangeReqSpecObject();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.interchange.RIFExportArea <em>RIF Export Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>RIF Export Area</em>'.
	 * @see org.eclipse.papyrus.eastadl.interchange.RIFExportArea
	 * @generated
	 */
	EClass getRIFExportArea();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.interchange.RIFImportArea <em>RIF Import Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>RIF Import Area</em>'.
	 * @see org.eclipse.papyrus.eastadl.interchange.RIFImportArea
	 * @generated
	 */
	EClass getRIFImportArea();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	InterchangeFactory getInterchangeFactory();

} // InterchangePackage
