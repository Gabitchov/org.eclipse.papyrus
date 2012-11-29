/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.table.instance.papyrustableinstance;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

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
 * @see org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrustableinstanceFactory
 * @model kind="package"
 * @generated
 */
public interface PapyrustableinstancePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "papyrustableinstance";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/Papyrus/Table/0.8.0/papyrustableinstance";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.papyrus.infra.table.instance.papyrustableinstance";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PapyrustableinstancePackage eINSTANCE = org.eclipse.papyrus.infra.table.instance.papyrustableinstance.impl.PapyrustableinstancePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.impl.PapyrusTableInstanceImpl <em>Papyrus Table Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.table.instance.papyrustableinstance.impl.PapyrusTableInstanceImpl
	 * @see org.eclipse.papyrus.infra.table.instance.papyrustableinstance.impl.PapyrustableinstancePackageImpl#getPapyrusTableInstance()
	 * @generated
	 */
	int PAPYRUS_TABLE_INSTANCE = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_INSTANCE__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_INSTANCE__NAME = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_INSTANCE__TYPE = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Synchronized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_INSTANCE__IS_SYNCHRONIZED = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_INSTANCE__TABLE = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Filling Queries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_INSTANCE__FILLING_QUERIES = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Pasted Element Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_INSTANCE__PASTED_ELEMENT_ID = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Pasted Element Containment Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_INSTANCE__PASTED_ELEMENT_CONTAINMENT_FEATURE = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Papyrus Table Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_INSTANCE_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 7;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance <em>Papyrus Table Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Papyrus Table Instance</em>'.
	 * @see org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance
	 * @generated
	 */
	EClass getPapyrusTableInstance();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance#getName()
	 * @see #getPapyrusTableInstance()
	 * @generated
	 */
	EAttribute getPapyrusTableInstance_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance#getType()
	 * @see #getPapyrusTableInstance()
	 * @generated
	 */
	EAttribute getPapyrusTableInstance_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance#isIsSynchronized <em>Is Synchronized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Synchronized</em>'.
	 * @see org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance#isIsSynchronized()
	 * @see #getPapyrusTableInstance()
	 * @generated
	 */
	EAttribute getPapyrusTableInstance_IsSynchronized();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance#getTable()
	 * @see #getPapyrusTableInstance()
	 * @generated
	 */
	EReference getPapyrusTableInstance_Table();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance#getFillingQueries <em>Filling Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Filling Queries</em>'.
	 * @see org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance#getFillingQueries()
	 * @see #getPapyrusTableInstance()
	 * @generated
	 */
	EReference getPapyrusTableInstance_FillingQueries();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance#getPastedElementId <em>Pasted Element Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pasted Element Id</em>'.
	 * @see org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance#getPastedElementId()
	 * @see #getPapyrusTableInstance()
	 * @generated
	 */
	EAttribute getPapyrusTableInstance_PastedElementId();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance#getPastedElementContainmentFeature <em>Pasted Element Containment Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pasted Element Containment Feature</em>'.
	 * @see org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance#getPastedElementContainmentFeature()
	 * @see #getPapyrusTableInstance()
	 * @generated
	 */
	EReference getPapyrusTableInstance_PastedElementContainmentFeature();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PapyrustableinstanceFactory getPapyrustableinstanceFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.impl.PapyrusTableInstanceImpl <em>Papyrus Table Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.table.instance.papyrustableinstance.impl.PapyrusTableInstanceImpl
		 * @see org.eclipse.papyrus.infra.table.instance.papyrustableinstance.impl.PapyrustableinstancePackageImpl#getPapyrusTableInstance()
		 * @generated
		 */
		EClass PAPYRUS_TABLE_INSTANCE = eINSTANCE.getPapyrusTableInstance();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAPYRUS_TABLE_INSTANCE__NAME = eINSTANCE.getPapyrusTableInstance_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAPYRUS_TABLE_INSTANCE__TYPE = eINSTANCE.getPapyrusTableInstance_Type();

		/**
		 * The meta object literal for the '<em><b>Is Synchronized</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAPYRUS_TABLE_INSTANCE__IS_SYNCHRONIZED = eINSTANCE.getPapyrusTableInstance_IsSynchronized();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_TABLE_INSTANCE__TABLE = eINSTANCE.getPapyrusTableInstance_Table();

		/**
		 * The meta object literal for the '<em><b>Filling Queries</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_TABLE_INSTANCE__FILLING_QUERIES = eINSTANCE.getPapyrusTableInstance_FillingQueries();

		/**
		 * The meta object literal for the '<em><b>Pasted Element Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAPYRUS_TABLE_INSTANCE__PASTED_ELEMENT_ID = eINSTANCE.getPapyrusTableInstance_PastedElementId();

		/**
		 * The meta object literal for the '<em><b>Pasted Element Containment Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_TABLE_INSTANCE__PASTED_ELEMENT_CONTAINMENT_FEATURE = eINSTANCE.getPapyrusTableInstance_PastedElementContainmentFeature();

	}

} //PapyrustableinstancePackage
