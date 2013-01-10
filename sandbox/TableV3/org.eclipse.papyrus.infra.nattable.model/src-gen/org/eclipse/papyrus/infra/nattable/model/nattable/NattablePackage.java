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
package org.eclipse.papyrus.infra.nattable.model.nattable;

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
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattableFactory
 * @model kind="package"
 * @generated
 */
public interface NattablePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "nattable"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/nattable/model"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "nattable"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NattablePackage eINSTANCE = org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl <em>Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl#getTable()
	 * @generated
	 */
	int TABLE = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__NAME = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__CONTEXT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__DESCRIPTION = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Editor Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__EDITOR_CONFIGURATION = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Vertical Content Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__VERTICAL_CONTENT_PROVIDER = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Horizontal Content Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__HORIZONTAL_CONTENT_PROVIDER = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE___GET_EANNOTATION__STRING = EcorePackage.EMODEL_ELEMENT___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_OPERATION_COUNT = EcorePackage.EMODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.IAxisContentsProvider <em>IAxis Contents Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.IAxisContentsProvider
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl#getIAxisContentsProvider()
	 * @generated
	 */
	int IAXIS_CONTENTS_PROVIDER = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IAXIS_CONTENTS_PROVIDER__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

	/**
	 * The number of structural features of the '<em>IAxis Contents Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IAXIS_CONTENTS_PROVIDER_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

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
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.UserContentProviderImpl <em>User Content Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.UserContentProviderImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl#getUserContentProvider()
	 * @generated
	 */
	int USER_CONTENT_PROVIDER = 2;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_CONTENT_PROVIDER__EANNOTATIONS = IAXIS_CONTENTS_PROVIDER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_CONTENT_PROVIDER__ELEMENTS = IAXIS_CONTENTS_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>User Content Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_CONTENT_PROVIDER_FEATURE_COUNT = IAXIS_CONTENTS_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_CONTENT_PROVIDER___GET_EANNOTATION__STRING = IAXIS_CONTENTS_PROVIDER___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Get Axis</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_CONTENT_PROVIDER___GET_AXIS = IAXIS_CONTENTS_PROVIDER___GET_AXIS;

	/**
	 * The number of operations of the '<em>User Content Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_CONTENT_PROVIDER_OPERATION_COUNT = IAXIS_CONTENTS_PROVIDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.DynamicEMFFeatureContentsProviderImpl <em>Dynamic EMF Feature Contents Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.DynamicEMFFeatureContentsProviderImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl#getDynamicEMFFeatureContentsProvider()
	 * @generated
	 */
	int DYNAMIC_EMF_FEATURE_CONTENTS_PROVIDER = 3;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_EMF_FEATURE_CONTENTS_PROVIDER__EANNOTATIONS = IAXIS_CONTENTS_PROVIDER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_EMF_FEATURE_CONTENTS_PROVIDER__FEATURES = IAXIS_CONTENTS_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dynamic EMF Feature Contents Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_EMF_FEATURE_CONTENTS_PROVIDER_FEATURE_COUNT = IAXIS_CONTENTS_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_EMF_FEATURE_CONTENTS_PROVIDER___GET_EANNOTATION__STRING = IAXIS_CONTENTS_PROVIDER___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Get Axis</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_EMF_FEATURE_CONTENTS_PROVIDER___GET_AXIS = IAXIS_CONTENTS_PROVIDER___GET_AXIS;

	/**
	 * The number of operations of the '<em>Dynamic EMF Feature Contents Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_EMF_FEATURE_CONTENTS_PROVIDER_OPERATION_COUNT = IAXIS_CONTENTS_PROVIDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.IAxis <em>IAxis</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.IAxis
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl#getIAxis()
	 * @generated
	 */
	int IAXIS = 5;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IAXIS__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

	/**
	 * The number of structural features of the '<em>IAxis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IAXIS_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IAXIS___GET_EANNOTATION__STRING = EcorePackage.EMODEL_ELEMENT___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Get Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IAXIS___GET_ELEMENT = EcorePackage.EMODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>IAxis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IAXIS_OPERATION_COUNT = EcorePackage.EMODEL_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.EObjectAxisImpl <em>EObject Axis</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.EObjectAxisImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl#getEObjectAxis()
	 * @generated
	 */
	int EOBJECT_AXIS = 4;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_AXIS__EANNOTATIONS = IAXIS__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Eobject</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_AXIS__EOBJECT = IAXIS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EObject Axis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_AXIS_FEATURE_COUNT = IAXIS_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_AXIS___GET_EANNOTATION__STRING = IAXIS___GET_EANNOTATION__STRING;

	/**
	 * The operation id for the '<em>Get Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_AXIS___GET_ELEMENT = IAXIS___GET_ELEMENT;

	/**
	 * The number of operations of the '<em>EObject Axis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_AXIS_OPERATION_COUNT = IAXIS_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.Table
	 * @generated
	 */
	EClass getTable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.Table#getName()
	 * @see #getTable()
	 * @generated
	 */
	EAttribute getTable_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.Table#getContext()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Context();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.Table#getDescription()
	 * @see #getTable()
	 * @generated
	 */
	EAttribute getTable_Description();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getEditorConfiguration <em>Editor Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Editor Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.Table#getEditorConfiguration()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_EditorConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getVerticalContentProvider <em>Vertical Content Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Vertical Content Provider</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.Table#getVerticalContentProvider()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_VerticalContentProvider();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.Table#getHorizontalContentProvider <em>Horizontal Content Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Horizontal Content Provider</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.Table#getHorizontalContentProvider()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_HorizontalContentProvider();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.IAxisContentsProvider <em>IAxis Contents Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IAxis Contents Provider</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.IAxisContentsProvider
	 * @generated
	 */
	EClass getIAxisContentsProvider();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.IAxisContentsProvider#getAxis() <em>Get Axis</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Axis</em>' operation.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.IAxisContentsProvider#getAxis()
	 * @generated
	 */
	EOperation getIAxisContentsProvider__GetAxis();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.UserContentProvider <em>User Content Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Content Provider</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.UserContentProvider
	 * @generated
	 */
	EClass getUserContentProvider();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.nattable.model.nattable.UserContentProvider#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.UserContentProvider#getElements()
	 * @see #getUserContentProvider()
	 * @generated
	 */
	EReference getUserContentProvider_Elements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.DynamicEMFFeatureContentsProvider <em>Dynamic EMF Feature Contents Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic EMF Feature Contents Provider</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.DynamicEMFFeatureContentsProvider
	 * @generated
	 */
	EClass getDynamicEMFFeatureContentsProvider();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.nattable.model.nattable.DynamicEMFFeatureContentsProvider#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Features</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.DynamicEMFFeatureContentsProvider#getFeatures()
	 * @see #getDynamicEMFFeatureContentsProvider()
	 * @generated
	 */
	EReference getDynamicEMFFeatureContentsProvider_Features();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.EObjectAxis <em>EObject Axis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EObject Axis</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.EObjectAxis
	 * @generated
	 */
	EClass getEObjectAxis();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.EObjectAxis#getEobject <em>Eobject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Eobject</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.EObjectAxis#getEobject()
	 * @see #getEObjectAxis()
	 * @generated
	 */
	EReference getEObjectAxis_Eobject();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.IAxis <em>IAxis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IAxis</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.IAxis
	 * @generated
	 */
	EClass getIAxis();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.IAxis#getElement() <em>Get Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Element</em>' operation.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.IAxis#getElement()
	 * @generated
	 */
	EOperation getIAxis__GetElement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NattableFactory getNattableFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl <em>Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.TableImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl#getTable()
		 * @generated
		 */
		EClass TABLE = eINSTANCE.getTable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE__NAME = eINSTANCE.getTable_Name();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__CONTEXT = eINSTANCE.getTable_Context();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE__DESCRIPTION = eINSTANCE.getTable_Description();

		/**
		 * The meta object literal for the '<em><b>Editor Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__EDITOR_CONFIGURATION = eINSTANCE.getTable_EditorConfiguration();

		/**
		 * The meta object literal for the '<em><b>Vertical Content Provider</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__VERTICAL_CONTENT_PROVIDER = eINSTANCE.getTable_VerticalContentProvider();

		/**
		 * The meta object literal for the '<em><b>Horizontal Content Provider</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__HORIZONTAL_CONTENT_PROVIDER = eINSTANCE.getTable_HorizontalContentProvider();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.IAxisContentsProvider <em>IAxis Contents Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.IAxisContentsProvider
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl#getIAxisContentsProvider()
		 * @generated
		 */
		EClass IAXIS_CONTENTS_PROVIDER = eINSTANCE.getIAxisContentsProvider();

		/**
		 * The meta object literal for the '<em><b>Get Axis</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IAXIS_CONTENTS_PROVIDER___GET_AXIS = eINSTANCE.getIAxisContentsProvider__GetAxis();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.UserContentProviderImpl <em>User Content Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.UserContentProviderImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl#getUserContentProvider()
		 * @generated
		 */
		EClass USER_CONTENT_PROVIDER = eINSTANCE.getUserContentProvider();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_CONTENT_PROVIDER__ELEMENTS = eINSTANCE.getUserContentProvider_Elements();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.DynamicEMFFeatureContentsProviderImpl <em>Dynamic EMF Feature Contents Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.DynamicEMFFeatureContentsProviderImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl#getDynamicEMFFeatureContentsProvider()
		 * @generated
		 */
		EClass DYNAMIC_EMF_FEATURE_CONTENTS_PROVIDER = eINSTANCE.getDynamicEMFFeatureContentsProvider();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_EMF_FEATURE_CONTENTS_PROVIDER__FEATURES = eINSTANCE.getDynamicEMFFeatureContentsProvider_Features();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.impl.EObjectAxisImpl <em>EObject Axis</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.EObjectAxisImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl#getEObjectAxis()
		 * @generated
		 */
		EClass EOBJECT_AXIS = eINSTANCE.getEObjectAxis();

		/**
		 * The meta object literal for the '<em><b>Eobject</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EOBJECT_AXIS__EOBJECT = eINSTANCE.getEObjectAxis_Eobject();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.IAxis <em>IAxis</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.IAxis
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl#getIAxis()
		 * @generated
		 */
		EClass IAXIS = eINSTANCE.getIAxis();

		/**
		 * The meta object literal for the '<em><b>Get Element</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IAXIS___GET_ELEMENT = eINSTANCE.getIAxis__GetElement();

	}

} //NattablePackage
