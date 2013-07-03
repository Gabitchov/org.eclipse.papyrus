/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderFactory
 * @model kind="package"
 * @generated
 */
public interface NattableaxisproviderPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "nattableaxisprovider"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/nattable/model/table/nattableaxisprovider"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "nattableaxisprovider"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	NattableaxisproviderPackage eINSTANCE = org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.NattableaxisproviderPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.AbstractAxisProviderImpl
	 * <em>Abstract Axis Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.AbstractAxisProviderImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.NattableaxisproviderPackageImpl#getAbstractAxisProvider()
	 * @generated
	 */
	int ABSTRACT_AXIS_PROVIDER = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_AXIS_PROVIDER__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_AXIS_PROVIDER__DESCRIPTION = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_AXIS_PROVIDER__NAME = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Abstract Axis Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_AXIS_PROVIDER_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_AXIS_PROVIDER___GET_EANNOTATION__STRING = EcorePackage.EMODEL_ELEMENT___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Get Axis</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_AXIS_PROVIDER___GET_AXIS = EcorePackage.EMODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Abstract Axis Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_AXIS_PROVIDER_OPERATION_COUNT = EcorePackage.EMODEL_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.AxisProviderImpl
	 * <em>Axis Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.AxisProviderImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.NattableaxisproviderPackageImpl#getAxisProvider()
	 * @generated
	 */
	int AXIS_PROVIDER = 3;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AXIS_PROVIDER__EANNOTATIONS = ABSTRACT_AXIS_PROVIDER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AXIS_PROVIDER__DESCRIPTION = ABSTRACT_AXIS_PROVIDER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AXIS_PROVIDER__NAME = ABSTRACT_AXIS_PROVIDER__NAME;

	/**
	 * The feature id for the '<em><b>Axis</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AXIS_PROVIDER__AXIS = ABSTRACT_AXIS_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Axis Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AXIS_PROVIDER_FEATURE_COUNT = ABSTRACT_AXIS_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AXIS_PROVIDER___GET_EANNOTATION__STRING = ABSTRACT_AXIS_PROVIDER___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Get Axis</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AXIS_PROVIDER___GET_AXIS = ABSTRACT_AXIS_PROVIDER___GET_AXIS;

	/**
	 * The number of operations of the '<em>Axis Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AXIS_PROVIDER_OPERATION_COUNT = ABSTRACT_AXIS_PROVIDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.IMasterAxisProvider
	 * <em>IMaster Axis Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.IMasterAxisProvider
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.NattableaxisproviderPackageImpl#getIMasterAxisProvider()
	 * @generated
	 */
	int IMASTER_AXIS_PROVIDER = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMASTER_AXIS_PROVIDER__EANNOTATIONS = AXIS_PROVIDER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMASTER_AXIS_PROVIDER__DESCRIPTION = AXIS_PROVIDER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMASTER_AXIS_PROVIDER__NAME = AXIS_PROVIDER__NAME;

	/**
	 * The feature id for the '<em><b>Axis</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMASTER_AXIS_PROVIDER__AXIS = AXIS_PROVIDER__AXIS;

	/**
	 * The feature id for the '<em><b>Disconnect Slave</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMASTER_AXIS_PROVIDER__DISCONNECT_SLAVE = AXIS_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>IMaster Axis Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMASTER_AXIS_PROVIDER_FEATURE_COUNT = AXIS_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMASTER_AXIS_PROVIDER___GET_EANNOTATION__STRING = AXIS_PROVIDER___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Get Axis</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMASTER_AXIS_PROVIDER___GET_AXIS = AXIS_PROVIDER___GET_AXIS;

	/**
	 * The number of operations of the '<em>IMaster Axis Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMASTER_AXIS_PROVIDER_OPERATION_COUNT = AXIS_PROVIDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.ISlaveAxisProvider
	 * <em>ISlave Axis Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.ISlaveAxisProvider
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.NattableaxisproviderPackageImpl#getISlaveAxisProvider()
	 * @generated
	 */
	int ISLAVE_AXIS_PROVIDER = 2;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ISLAVE_AXIS_PROVIDER__EANNOTATIONS = AXIS_PROVIDER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ISLAVE_AXIS_PROVIDER__DESCRIPTION = AXIS_PROVIDER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ISLAVE_AXIS_PROVIDER__NAME = AXIS_PROVIDER__NAME;

	/**
	 * The feature id for the '<em><b>Axis</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ISLAVE_AXIS_PROVIDER__AXIS = AXIS_PROVIDER__AXIS;

	/**
	 * The number of structural features of the '<em>ISlave Axis Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ISLAVE_AXIS_PROVIDER_FEATURE_COUNT = AXIS_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ISLAVE_AXIS_PROVIDER___GET_EANNOTATION__STRING = AXIS_PROVIDER___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Get Axis</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ISLAVE_AXIS_PROVIDER___GET_AXIS = AXIS_PROVIDER___GET_AXIS;

	/**
	 * The number of operations of the '<em>ISlave Axis Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ISLAVE_AXIS_PROVIDER_OPERATION_COUNT = AXIS_PROVIDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.SlaveObjectAxisProviderImpl
	 * <em>Slave Object Axis Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.SlaveObjectAxisProviderImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.NattableaxisproviderPackageImpl#getSlaveObjectAxisProvider()
	 * @generated
	 */
	int SLAVE_OBJECT_AXIS_PROVIDER = 4;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SLAVE_OBJECT_AXIS_PROVIDER__EANNOTATIONS = ISLAVE_AXIS_PROVIDER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SLAVE_OBJECT_AXIS_PROVIDER__DESCRIPTION = ISLAVE_AXIS_PROVIDER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SLAVE_OBJECT_AXIS_PROVIDER__NAME = ISLAVE_AXIS_PROVIDER__NAME;

	/**
	 * The feature id for the '<em><b>Axis</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SLAVE_OBJECT_AXIS_PROVIDER__AXIS = ISLAVE_AXIS_PROVIDER__AXIS;

	/**
	 * The number of structural features of the '<em>Slave Object Axis Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SLAVE_OBJECT_AXIS_PROVIDER_FEATURE_COUNT = ISLAVE_AXIS_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SLAVE_OBJECT_AXIS_PROVIDER___GET_EANNOTATION__STRING = ISLAVE_AXIS_PROVIDER___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Get Axis</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SLAVE_OBJECT_AXIS_PROVIDER___GET_AXIS = ISLAVE_AXIS_PROVIDER___GET_AXIS;

	/**
	 * The number of operations of the '<em>Slave Object Axis Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SLAVE_OBJECT_AXIS_PROVIDER_OPERATION_COUNT = ISLAVE_AXIS_PROVIDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.MasterObjectAxisProviderImpl
	 * <em>Master Object Axis Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.MasterObjectAxisProviderImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.NattableaxisproviderPackageImpl#getMasterObjectAxisProvider()
	 * @generated
	 */
	int MASTER_OBJECT_AXIS_PROVIDER = 5;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MASTER_OBJECT_AXIS_PROVIDER__EANNOTATIONS = IMASTER_AXIS_PROVIDER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MASTER_OBJECT_AXIS_PROVIDER__DESCRIPTION = IMASTER_AXIS_PROVIDER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MASTER_OBJECT_AXIS_PROVIDER__NAME = IMASTER_AXIS_PROVIDER__NAME;

	/**
	 * The feature id for the '<em><b>Axis</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MASTER_OBJECT_AXIS_PROVIDER__AXIS = IMASTER_AXIS_PROVIDER__AXIS;

	/**
	 * The feature id for the '<em><b>Disconnect Slave</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MASTER_OBJECT_AXIS_PROVIDER__DISCONNECT_SLAVE = IMASTER_AXIS_PROVIDER__DISCONNECT_SLAVE;

	/**
	 * The number of structural features of the '<em>Master Object Axis Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MASTER_OBJECT_AXIS_PROVIDER_FEATURE_COUNT = IMASTER_AXIS_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MASTER_OBJECT_AXIS_PROVIDER___GET_EANNOTATION__STRING = IMASTER_AXIS_PROVIDER___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Get Axis</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MASTER_OBJECT_AXIS_PROVIDER___GET_AXIS = IMASTER_AXIS_PROVIDER___GET_AXIS;

	/**
	 * The number of operations of the '<em>Master Object Axis Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MASTER_OBJECT_AXIS_PROVIDER_OPERATION_COUNT = IMASTER_AXIS_PROVIDER_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider
	 * <em>Abstract Axis Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Abstract Axis Provider</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider
	 * @generated
	 */
	EClass getAbstractAxisProvider();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider#getAxis()
	 * <em>Get Axis</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the '<em>Get Axis</em>' operation.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider#getAxis()
	 * @generated
	 */
	EOperation getAbstractAxisProvider__GetAxis();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.IMasterAxisProvider
	 * <em>IMaster Axis Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>IMaster Axis Provider</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.IMasterAxisProvider
	 * @generated
	 */
	EClass getIMasterAxisProvider();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.IMasterAxisProvider#isDisconnectSlave <em>Disconnect Slave</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Disconnect Slave</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.IMasterAxisProvider#isDisconnectSlave()
	 * @see #getIMasterAxisProvider()
	 * @generated
	 */
	EAttribute getIMasterAxisProvider_DisconnectSlave();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.ISlaveAxisProvider
	 * <em>ISlave Axis Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>ISlave Axis Provider</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.ISlaveAxisProvider
	 * @generated
	 */
	EClass getISlaveAxisProvider();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AxisProvider
	 * <em>Axis Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Axis Provider</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AxisProvider
	 * @generated
	 */
	EClass getAxisProvider();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AxisProvider#getAxis <em>Axis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Axis</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AxisProvider#getAxis()
	 * @see #getAxisProvider()
	 * @generated
	 */
	EReference getAxisProvider_Axis();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.SlaveObjectAxisProvider
	 * <em>Slave Object Axis Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Slave Object Axis Provider</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.SlaveObjectAxisProvider
	 * @generated
	 */
	EClass getSlaveObjectAxisProvider();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.MasterObjectAxisProvider
	 * <em>Master Object Axis Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Master Object Axis Provider</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.MasterObjectAxisProvider
	 * @generated
	 */
	EClass getMasterObjectAxisProvider();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NattableaxisproviderFactory getNattableaxisproviderFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each operation of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.AbstractAxisProviderImpl
		 * <em>Abstract Axis Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.AbstractAxisProviderImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.NattableaxisproviderPackageImpl#getAbstractAxisProvider()
		 * @generated
		 */
		EClass ABSTRACT_AXIS_PROVIDER = eINSTANCE.getAbstractAxisProvider();

		/**
		 * The meta object literal for the '<em><b>Get Axis</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EOperation ABSTRACT_AXIS_PROVIDER___GET_AXIS = eINSTANCE.getAbstractAxisProvider__GetAxis();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.IMasterAxisProvider
		 * <em>IMaster Axis Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.IMasterAxisProvider
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.NattableaxisproviderPackageImpl#getIMasterAxisProvider()
		 * @generated
		 */
		EClass IMASTER_AXIS_PROVIDER = eINSTANCE.getIMasterAxisProvider();

		/**
		 * The meta object literal for the '<em><b>Disconnect Slave</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute IMASTER_AXIS_PROVIDER__DISCONNECT_SLAVE = eINSTANCE.getIMasterAxisProvider_DisconnectSlave();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.ISlaveAxisProvider
		 * <em>ISlave Axis Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.ISlaveAxisProvider
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.NattableaxisproviderPackageImpl#getISlaveAxisProvider()
		 * @generated
		 */
		EClass ISLAVE_AXIS_PROVIDER = eINSTANCE.getISlaveAxisProvider();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.AxisProviderImpl
		 * <em>Axis Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.AxisProviderImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.NattableaxisproviderPackageImpl#getAxisProvider()
		 * @generated
		 */
		EClass AXIS_PROVIDER = eINSTANCE.getAxisProvider();

		/**
		 * The meta object literal for the '<em><b>Axis</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference AXIS_PROVIDER__AXIS = eINSTANCE.getAxisProvider_Axis();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.SlaveObjectAxisProviderImpl
		 * <em>Slave Object Axis Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.SlaveObjectAxisProviderImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.NattableaxisproviderPackageImpl#getSlaveObjectAxisProvider()
		 * @generated
		 */
		EClass SLAVE_OBJECT_AXIS_PROVIDER = eINSTANCE.getSlaveObjectAxisProvider();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.MasterObjectAxisProviderImpl
		 * <em>Master Object Axis Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.MasterObjectAxisProviderImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.NattableaxisproviderPackageImpl#getMasterObjectAxisProvider()
		 * @generated
		 */
		EClass MASTER_OBJECT_AXIS_PROVIDER = eINSTANCE.getMasterObjectAxisProvider();

	}

} //NattableaxisproviderPackage
