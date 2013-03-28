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
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderFactory
 * @model kind="package"
 * @generated
 */
public interface NattableaxisproviderPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "nattableaxisprovider"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/nattable/model/table/nattableaxisprovider"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "nattableaxisprovider"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NattableaxisproviderPackage eINSTANCE = org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.NattableaxisproviderPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.AbstractAxisProviderImpl <em>Abstract Axis Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.AbstractAxisProviderImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.NattableaxisproviderPackageImpl#getAbstractAxisProvider()
	 * @generated
	 */
	int ABSTRACT_AXIS_PROVIDER = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_AXIS_PROVIDER__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Java Axis Manager Ids</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_AXIS_PROVIDER__JAVA_AXIS_MANAGER_IDS = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Axis Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_AXIS_PROVIDER__AXIS_CONFIGURATION = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Pasted Element Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_AXIS_PROVIDER__PASTED_ELEMENT_TYPE_ID = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Pasted Element Containment Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_AXIS_PROVIDER__PASTED_ELEMENT_CONTAINMENT_FEATURE = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Abstract Axis Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_AXIS_PROVIDER_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_AXIS_PROVIDER___GET_EANNOTATION__STRING = EcorePackage.EMODEL_ELEMENT___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Get Axis</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_AXIS_PROVIDER___GET_AXIS = EcorePackage.EMODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Abstract Axis Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_AXIS_PROVIDER_OPERATION_COUNT = EcorePackage.EMODEL_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.DefaultAxisProviderImpl <em>Default Axis Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.DefaultAxisProviderImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.NattableaxisproviderPackageImpl#getDefaultAxisProvider()
	 * @generated
	 */
	int DEFAULT_AXIS_PROVIDER = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_AXIS_PROVIDER__EANNOTATIONS = ABSTRACT_AXIS_PROVIDER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Java Axis Manager Ids</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_AXIS_PROVIDER__JAVA_AXIS_MANAGER_IDS = ABSTRACT_AXIS_PROVIDER__JAVA_AXIS_MANAGER_IDS;

	/**
	 * The feature id for the '<em><b>Axis Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_AXIS_PROVIDER__AXIS_CONFIGURATION = ABSTRACT_AXIS_PROVIDER__AXIS_CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Pasted Element Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_AXIS_PROVIDER__PASTED_ELEMENT_TYPE_ID = ABSTRACT_AXIS_PROVIDER__PASTED_ELEMENT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Pasted Element Containment Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_AXIS_PROVIDER__PASTED_ELEMENT_CONTAINMENT_FEATURE = ABSTRACT_AXIS_PROVIDER__PASTED_ELEMENT_CONTAINMENT_FEATURE;

	/**
	 * The feature id for the '<em><b>Axis</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_AXIS_PROVIDER__AXIS = ABSTRACT_AXIS_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Default Axis Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_AXIS_PROVIDER_FEATURE_COUNT = ABSTRACT_AXIS_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_AXIS_PROVIDER___GET_EANNOTATION__STRING = ABSTRACT_AXIS_PROVIDER___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Get Axis</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_AXIS_PROVIDER___GET_AXIS = ABSTRACT_AXIS_PROVIDER___GET_AXIS;

	/**
	 * The number of operations of the '<em>Default Axis Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_AXIS_PROVIDER_OPERATION_COUNT = ABSTRACT_AXIS_PROVIDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.EMFFeatureValueAxisProviderImpl <em>EMF Feature Value Axis Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.EMFFeatureValueAxisProviderImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.NattableaxisproviderPackageImpl#getEMFFeatureValueAxisProvider()
	 * @generated
	 */
	int EMF_FEATURE_VALUE_AXIS_PROVIDER = 2;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_FEATURE_VALUE_AXIS_PROVIDER__EANNOTATIONS = DEFAULT_AXIS_PROVIDER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Java Axis Manager Ids</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_FEATURE_VALUE_AXIS_PROVIDER__JAVA_AXIS_MANAGER_IDS = DEFAULT_AXIS_PROVIDER__JAVA_AXIS_MANAGER_IDS;

	/**
	 * The feature id for the '<em><b>Axis Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_FEATURE_VALUE_AXIS_PROVIDER__AXIS_CONFIGURATION = DEFAULT_AXIS_PROVIDER__AXIS_CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Pasted Element Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_FEATURE_VALUE_AXIS_PROVIDER__PASTED_ELEMENT_TYPE_ID = DEFAULT_AXIS_PROVIDER__PASTED_ELEMENT_TYPE_ID;

	/**
	 * The feature id for the '<em><b>Pasted Element Containment Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_FEATURE_VALUE_AXIS_PROVIDER__PASTED_ELEMENT_CONTAINMENT_FEATURE = DEFAULT_AXIS_PROVIDER__PASTED_ELEMENT_CONTAINMENT_FEATURE;

	/**
	 * The feature id for the '<em><b>Axis</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_FEATURE_VALUE_AXIS_PROVIDER__AXIS = DEFAULT_AXIS_PROVIDER__AXIS;

	/**
	 * The feature id for the '<em><b>Listen Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_FEATURE_VALUE_AXIS_PROVIDER__LISTEN_FEATURE = DEFAULT_AXIS_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EMF Feature Value Axis Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_FEATURE_VALUE_AXIS_PROVIDER_FEATURE_COUNT = DEFAULT_AXIS_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_FEATURE_VALUE_AXIS_PROVIDER___GET_EANNOTATION__STRING = DEFAULT_AXIS_PROVIDER___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Get Axis</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_FEATURE_VALUE_AXIS_PROVIDER___GET_AXIS = DEFAULT_AXIS_PROVIDER___GET_AXIS;

	/**
	 * The number of operations of the '<em>EMF Feature Value Axis Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_FEATURE_VALUE_AXIS_PROVIDER_OPERATION_COUNT = DEFAULT_AXIS_PROVIDER_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider <em>Abstract Axis Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Axis Provider</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider
	 * @generated
	 */
	EClass getAbstractAxisProvider();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider#getJavaAxisManagerIds <em>Java Axis Manager Ids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Java Axis Manager Ids</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider#getJavaAxisManagerIds()
	 * @see #getAbstractAxisProvider()
	 * @generated
	 */
	EAttribute getAbstractAxisProvider_JavaAxisManagerIds();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider#getAxisConfiguration <em>Axis Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Axis Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider#getAxisConfiguration()
	 * @see #getAbstractAxisProvider()
	 * @generated
	 */
	EReference getAbstractAxisProvider_AxisConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider#getPastedElementTypeId <em>Pasted Element Type Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pasted Element Type Id</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider#getPastedElementTypeId()
	 * @see #getAbstractAxisProvider()
	 * @generated
	 */
	EAttribute getAbstractAxisProvider_PastedElementTypeId();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider#getPastedElementContainmentFeature <em>Pasted Element Containment Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pasted Element Containment Feature</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider#getPastedElementContainmentFeature()
	 * @see #getAbstractAxisProvider()
	 * @generated
	 */
	EReference getAbstractAxisProvider_PastedElementContainmentFeature();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider#getAxis() <em>Get Axis</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Axis</em>' operation.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider#getAxis()
	 * @generated
	 */
	EOperation getAbstractAxisProvider__GetAxis();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.DefaultAxisProvider <em>Default Axis Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default Axis Provider</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.DefaultAxisProvider
	 * @generated
	 */
	EClass getDefaultAxisProvider();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.DefaultAxisProvider#getAxis <em>Axis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Axis</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.DefaultAxisProvider#getAxis()
	 * @see #getDefaultAxisProvider()
	 * @generated
	 */
	EReference getDefaultAxisProvider_Axis();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.EMFFeatureValueAxisProvider <em>EMF Feature Value Axis Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMF Feature Value Axis Provider</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.EMFFeatureValueAxisProvider
	 * @generated
	 */
	EClass getEMFFeatureValueAxisProvider();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.EMFFeatureValueAxisProvider#getListenFeature <em>Listen Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Listen Feature</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.EMFFeatureValueAxisProvider#getListenFeature()
	 * @see #getEMFFeatureValueAxisProvider()
	 * @generated
	 */
	EReference getEMFFeatureValueAxisProvider_ListenFeature();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NattableaxisproviderFactory getNattableaxisproviderFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.AbstractAxisProviderImpl <em>Abstract Axis Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.AbstractAxisProviderImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.NattableaxisproviderPackageImpl#getAbstractAxisProvider()
		 * @generated
		 */
		EClass ABSTRACT_AXIS_PROVIDER = eINSTANCE.getAbstractAxisProvider();

		/**
		 * The meta object literal for the '<em><b>Java Axis Manager Ids</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_AXIS_PROVIDER__JAVA_AXIS_MANAGER_IDS = eINSTANCE.getAbstractAxisProvider_JavaAxisManagerIds();

		/**
		 * The meta object literal for the '<em><b>Axis Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_AXIS_PROVIDER__AXIS_CONFIGURATION = eINSTANCE.getAbstractAxisProvider_AxisConfiguration();

		/**
		 * The meta object literal for the '<em><b>Pasted Element Type Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_AXIS_PROVIDER__PASTED_ELEMENT_TYPE_ID = eINSTANCE.getAbstractAxisProvider_PastedElementTypeId();

		/**
		 * The meta object literal for the '<em><b>Pasted Element Containment Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_AXIS_PROVIDER__PASTED_ELEMENT_CONTAINMENT_FEATURE = eINSTANCE.getAbstractAxisProvider_PastedElementContainmentFeature();

		/**
		 * The meta object literal for the '<em><b>Get Axis</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_AXIS_PROVIDER___GET_AXIS = eINSTANCE.getAbstractAxisProvider__GetAxis();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.DefaultAxisProviderImpl <em>Default Axis Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.DefaultAxisProviderImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.NattableaxisproviderPackageImpl#getDefaultAxisProvider()
		 * @generated
		 */
		EClass DEFAULT_AXIS_PROVIDER = eINSTANCE.getDefaultAxisProvider();

		/**
		 * The meta object literal for the '<em><b>Axis</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFAULT_AXIS_PROVIDER__AXIS = eINSTANCE.getDefaultAxisProvider_Axis();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.EMFFeatureValueAxisProviderImpl <em>EMF Feature Value Axis Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.EMFFeatureValueAxisProviderImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.NattableaxisproviderPackageImpl#getEMFFeatureValueAxisProvider()
		 * @generated
		 */
		EClass EMF_FEATURE_VALUE_AXIS_PROVIDER = eINSTANCE.getEMFFeatureValueAxisProvider();

		/**
		 * The meta object literal for the '<em><b>Listen Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMF_FEATURE_VALUE_AXIS_PROVIDER__LISTEN_FEATURE = eINSTANCE.getEMFFeatureValueAxisProvider_ListenFeature();

	}

} //NattableaxisproviderPackage
