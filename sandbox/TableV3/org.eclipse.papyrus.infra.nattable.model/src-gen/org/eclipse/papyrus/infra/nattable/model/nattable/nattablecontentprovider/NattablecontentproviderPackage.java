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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.NattablecontentproviderFactory
 * @model kind="package"
 * @generated
 */
public interface NattablecontentproviderPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "nattablecontentprovider"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/nattable/model/table/nattablecontentprovider"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "nattablecontentprovider"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NattablecontentproviderPackage eINSTANCE = org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.impl.NattablecontentproviderPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider <em>IAxis Contents Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.impl.NattablecontentproviderPackageImpl#getIAxisContentsProvider()
	 * @generated
	 */
	int IAXIS_CONTENTS_PROVIDER = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IAXIS_CONTENTS_PROVIDER__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Java Content Provider Ids</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IAXIS_CONTENTS_PROVIDER__JAVA_CONTENT_PROVIDER_IDS = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initial Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IAXIS_CONTENTS_PROVIDER__INITIAL_DIRECTION = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>IAxis Contents Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IAXIS_CONTENTS_PROVIDER_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IAXIS_CONTENTS_PROVIDER___GET_EANNOTATION__STRING = EcorePackage.EMODEL_ELEMENT___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Get Axis</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IAXIS_CONTENTS_PROVIDER___GET_AXIS = EcorePackage.EMODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>IAxis Contents Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IAXIS_CONTENTS_PROVIDER_OPERATION_COUNT = EcorePackage.EMODEL_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.impl.DefaultContentProviderImpl <em>Default Content Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.impl.DefaultContentProviderImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.impl.NattablecontentproviderPackageImpl#getDefaultContentProvider()
	 * @generated
	 */
	int DEFAULT_CONTENT_PROVIDER = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_CONTENT_PROVIDER__EANNOTATIONS = IAXIS_CONTENTS_PROVIDER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Java Content Provider Ids</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_CONTENT_PROVIDER__JAVA_CONTENT_PROVIDER_IDS = IAXIS_CONTENTS_PROVIDER__JAVA_CONTENT_PROVIDER_IDS;

	/**
	 * The feature id for the '<em><b>Initial Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_CONTENT_PROVIDER__INITIAL_DIRECTION = IAXIS_CONTENTS_PROVIDER__INITIAL_DIRECTION;

	/**
	 * The feature id for the '<em><b>Axis</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_CONTENT_PROVIDER__AXIS = IAXIS_CONTENTS_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Default Content Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_CONTENT_PROVIDER_FEATURE_COUNT = IAXIS_CONTENTS_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_CONTENT_PROVIDER___GET_EANNOTATION__STRING = IAXIS_CONTENTS_PROVIDER___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Get Axis</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_CONTENT_PROVIDER___GET_AXIS = IAXIS_CONTENTS_PROVIDER___GET_AXIS;

	/**
	 * The number of operations of the '<em>Default Content Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_CONTENT_PROVIDER_OPERATION_COUNT = IAXIS_CONTENTS_PROVIDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.ISynchronizedAxisContentProvider <em>ISynchronized Axis Content Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.ISynchronizedAxisContentProvider
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.impl.NattablecontentproviderPackageImpl#getISynchronizedAxisContentProvider()
	 * @generated
	 */
	int ISYNCHRONIZED_AXIS_CONTENT_PROVIDER = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.impl.EMFFeatureContentProviderImpl <em>EMF Feature Content Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.impl.EMFFeatureContentProviderImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.impl.NattablecontentproviderPackageImpl#getEMFFeatureContentProvider()
	 * @generated
	 */
	int EMF_FEATURE_CONTENT_PROVIDER = 2;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_FEATURE_CONTENT_PROVIDER__EANNOTATIONS = DEFAULT_CONTENT_PROVIDER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Java Content Provider Ids</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_FEATURE_CONTENT_PROVIDER__JAVA_CONTENT_PROVIDER_IDS = DEFAULT_CONTENT_PROVIDER__JAVA_CONTENT_PROVIDER_IDS;

	/**
	 * The feature id for the '<em><b>Initial Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_FEATURE_CONTENT_PROVIDER__INITIAL_DIRECTION = DEFAULT_CONTENT_PROVIDER__INITIAL_DIRECTION;

	/**
	 * The feature id for the '<em><b>Axis</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_FEATURE_CONTENT_PROVIDER__AXIS = DEFAULT_CONTENT_PROVIDER__AXIS;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_FEATURE_CONTENT_PROVIDER__FEATURE = DEFAULT_CONTENT_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EMF Feature Content Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_FEATURE_CONTENT_PROVIDER_FEATURE_COUNT = DEFAULT_CONTENT_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_FEATURE_CONTENT_PROVIDER___GET_EANNOTATION__STRING = DEFAULT_CONTENT_PROVIDER___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Get Axis</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_FEATURE_CONTENT_PROVIDER___GET_AXIS = DEFAULT_CONTENT_PROVIDER___GET_AXIS;

	/**
	 * The number of operations of the '<em>EMF Feature Content Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_FEATURE_CONTENT_PROVIDER_OPERATION_COUNT = DEFAULT_CONTENT_PROVIDER_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISYNCHRONIZED_AXIS_CONTENT_PROVIDER__EANNOTATIONS = IAXIS_CONTENTS_PROVIDER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Java Content Provider Ids</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISYNCHRONIZED_AXIS_CONTENT_PROVIDER__JAVA_CONTENT_PROVIDER_IDS = IAXIS_CONTENTS_PROVIDER__JAVA_CONTENT_PROVIDER_IDS;

	/**
	 * The feature id for the '<em><b>Initial Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISYNCHRONIZED_AXIS_CONTENT_PROVIDER__INITIAL_DIRECTION = IAXIS_CONTENTS_PROVIDER__INITIAL_DIRECTION;

	/**
	 * The number of structural features of the '<em>ISynchronized Axis Content Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISYNCHRONIZED_AXIS_CONTENT_PROVIDER_FEATURE_COUNT = IAXIS_CONTENTS_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISYNCHRONIZED_AXIS_CONTENT_PROVIDER___GET_EANNOTATION__STRING = IAXIS_CONTENTS_PROVIDER___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Get Axis</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISYNCHRONIZED_AXIS_CONTENT_PROVIDER___GET_AXIS = IAXIS_CONTENTS_PROVIDER___GET_AXIS;

	/**
	 * The number of operations of the '<em>ISynchronized Axis Content Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISYNCHRONIZED_AXIS_CONTENT_PROVIDER_OPERATION_COUNT = IAXIS_CONTENTS_PROVIDER_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.AxisDirection <em>Axis Direction</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.AxisDirection
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.impl.NattablecontentproviderPackageImpl#getAxisDirection()
	 * @generated
	 */
	int AXIS_DIRECTION = 4;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider <em>IAxis Contents Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IAxis Contents Provider</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider
	 * @generated
	 */
	EClass getIAxisContentsProvider();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider#getJavaContentProviderIds <em>Java Content Provider Ids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Java Content Provider Ids</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider#getJavaContentProviderIds()
	 * @see #getIAxisContentsProvider()
	 * @generated
	 */
	EAttribute getIAxisContentsProvider_JavaContentProviderIds();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider#getInitialDirection <em>Initial Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Direction</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider#getInitialDirection()
	 * @see #getIAxisContentsProvider()
	 * @generated
	 */
	EAttribute getIAxisContentsProvider_InitialDirection();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider#getAxis() <em>Get Axis</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Axis</em>' operation.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider#getAxis()
	 * @generated
	 */
	EOperation getIAxisContentsProvider__GetAxis();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.DefaultContentProvider <em>Default Content Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default Content Provider</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.DefaultContentProvider
	 * @generated
	 */
	EClass getDefaultContentProvider();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.DefaultContentProvider#getAxis <em>Axis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Axis</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.DefaultContentProvider#getAxis()
	 * @see #getDefaultContentProvider()
	 * @generated
	 */
	EReference getDefaultContentProvider_Axis();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.EMFFeatureContentProvider <em>EMF Feature Content Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMF Feature Content Provider</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.EMFFeatureContentProvider
	 * @generated
	 */
	EClass getEMFFeatureContentProvider();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.EMFFeatureContentProvider#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.EMFFeatureContentProvider#getFeature()
	 * @see #getEMFFeatureContentProvider()
	 * @generated
	 */
	EReference getEMFFeatureContentProvider_Feature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.ISynchronizedAxisContentProvider <em>ISynchronized Axis Content Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ISynchronized Axis Content Provider</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.ISynchronizedAxisContentProvider
	 * @generated
	 */
	EClass getISynchronizedAxisContentProvider();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.AxisDirection <em>Axis Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Axis Direction</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.AxisDirection
	 * @generated
	 */
	EEnum getAxisDirection();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NattablecontentproviderFactory getNattablecontentproviderFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider <em>IAxis Contents Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.impl.NattablecontentproviderPackageImpl#getIAxisContentsProvider()
		 * @generated
		 */
		EClass IAXIS_CONTENTS_PROVIDER = eINSTANCE.getIAxisContentsProvider();

		/**
		 * The meta object literal for the '<em><b>Java Content Provider Ids</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IAXIS_CONTENTS_PROVIDER__JAVA_CONTENT_PROVIDER_IDS = eINSTANCE.getIAxisContentsProvider_JavaContentProviderIds();

		/**
		 * The meta object literal for the '<em><b>Initial Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IAXIS_CONTENTS_PROVIDER__INITIAL_DIRECTION = eINSTANCE.getIAxisContentsProvider_InitialDirection();

		/**
		 * The meta object literal for the '<em><b>Get Axis</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IAXIS_CONTENTS_PROVIDER___GET_AXIS = eINSTANCE.getIAxisContentsProvider__GetAxis();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.impl.DefaultContentProviderImpl <em>Default Content Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.impl.DefaultContentProviderImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.impl.NattablecontentproviderPackageImpl#getDefaultContentProvider()
		 * @generated
		 */
		EClass DEFAULT_CONTENT_PROVIDER = eINSTANCE.getDefaultContentProvider();

		/**
		 * The meta object literal for the '<em><b>Axis</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFAULT_CONTENT_PROVIDER__AXIS = eINSTANCE.getDefaultContentProvider_Axis();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.impl.EMFFeatureContentProviderImpl <em>EMF Feature Content Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.impl.EMFFeatureContentProviderImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.impl.NattablecontentproviderPackageImpl#getEMFFeatureContentProvider()
		 * @generated
		 */
		EClass EMF_FEATURE_CONTENT_PROVIDER = eINSTANCE.getEMFFeatureContentProvider();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMF_FEATURE_CONTENT_PROVIDER__FEATURE = eINSTANCE.getEMFFeatureContentProvider_Feature();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.ISynchronizedAxisContentProvider <em>ISynchronized Axis Content Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.ISynchronizedAxisContentProvider
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.impl.NattablecontentproviderPackageImpl#getISynchronizedAxisContentProvider()
		 * @generated
		 */
		EClass ISYNCHRONIZED_AXIS_CONTENT_PROVIDER = eINSTANCE.getISynchronizedAxisContentProvider();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.AxisDirection <em>Axis Direction</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.AxisDirection
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.impl.NattablecontentproviderPackageImpl#getAxisDirection()
		 * @generated
		 */
		EEnum AXIS_DIRECTION = eINSTANCE.getAxisDirection();

	}

} //NattablecontentproviderPackage
