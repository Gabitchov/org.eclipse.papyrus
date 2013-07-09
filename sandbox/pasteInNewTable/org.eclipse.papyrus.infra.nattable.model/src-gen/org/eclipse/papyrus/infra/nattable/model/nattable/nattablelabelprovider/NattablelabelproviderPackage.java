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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
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
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderFactory
 * @model kind="package"
 * @generated
 */
public interface NattablelabelproviderPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "nattablelabelprovider"; //$NON-NLS-1$

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
	String eNS_PREFIX = "nattablelabelprovider"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NattablelabelproviderPackage eINSTANCE = org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.NattablelabelproviderPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelProviderConfiguration <em>ILabel Provider Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelProviderConfiguration
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.NattablelabelproviderPackageImpl#getILabelProviderConfiguration()
	 * @generated
	 */
	int ILABEL_PROVIDER_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILABEL_PROVIDER_CONFIGURATION__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

	/**
	 * The number of structural features of the '<em>ILabel Provider Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILABEL_PROVIDER_CONFIGURATION_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILABEL_PROVIDER_CONFIGURATION___GET_EANNOTATION__STRING = EcorePackage.EMODEL_ELEMENT___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>ILabel Provider Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILABEL_PROVIDER_CONFIGURATION_OPERATION_COUNT = EcorePackage.EMODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.ObjectLabelProviderConfigurationImpl <em>Object Label Provider Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.ObjectLabelProviderConfigurationImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.NattablelabelproviderPackageImpl#getObjectLabelProviderConfiguration()
	 * @generated
	 */
	int OBJECT_LABEL_PROVIDER_CONFIGURATION = 2;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_LABEL_PROVIDER_CONFIGURATION__EANNOTATIONS = ILABEL_PROVIDER_CONFIGURATION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Display Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_LABEL_PROVIDER_CONFIGURATION__DISPLAY_ICON = ILABEL_PROVIDER_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Display Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_LABEL_PROVIDER_CONFIGURATION__DISPLAY_LABEL = ILABEL_PROVIDER_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Object Label Provider Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_LABEL_PROVIDER_CONFIGURATION_FEATURE_COUNT = ILABEL_PROVIDER_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_LABEL_PROVIDER_CONFIGURATION___GET_EANNOTATION__STRING = ILABEL_PROVIDER_CONFIGURATION___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Object Label Provider Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_LABEL_PROVIDER_CONFIGURATION_OPERATION_COUNT = ILABEL_PROVIDER_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.FeatureLabelProviderConfigurationImpl <em>Feature Label Provider Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.FeatureLabelProviderConfigurationImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.NattablelabelproviderPackageImpl#getFeatureLabelProviderConfiguration()
	 * @generated
	 */
	int FEATURE_LABEL_PROVIDER_CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_LABEL_PROVIDER_CONFIGURATION__EANNOTATIONS = OBJECT_LABEL_PROVIDER_CONFIGURATION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Display Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_ICON = OBJECT_LABEL_PROVIDER_CONFIGURATION__DISPLAY_ICON;

	/**
	 * The feature id for the '<em><b>Display Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_LABEL = OBJECT_LABEL_PROVIDER_CONFIGURATION__DISPLAY_LABEL;

	/**
	 * The feature id for the '<em><b>Display Is Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_IS_DERIVED = OBJECT_LABEL_PROVIDER_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Display Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_TYPE = OBJECT_LABEL_PROVIDER_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Display Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_MULTIPLICITY = OBJECT_LABEL_PROVIDER_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_NAME = OBJECT_LABEL_PROVIDER_CONFIGURATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Feature Label Provider Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_LABEL_PROVIDER_CONFIGURATION_FEATURE_COUNT = OBJECT_LABEL_PROVIDER_CONFIGURATION_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_LABEL_PROVIDER_CONFIGURATION___GET_EANNOTATION__STRING = OBJECT_LABEL_PROVIDER_CONFIGURATION___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Feature Label Provider Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_LABEL_PROVIDER_CONFIGURATION_OPERATION_COUNT = OBJECT_LABEL_PROVIDER_CONFIGURATION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelProviderConfiguration <em>ILabel Provider Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ILabel Provider Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelProviderConfiguration
	 * @generated
	 */
	EClass getILabelProviderConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration <em>Feature Label Provider Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Label Provider Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration
	 * @generated
	 */
	EClass getFeatureLabelProviderConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration#isDisplayIsDerived <em>Display Is Derived</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Is Derived</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration#isDisplayIsDerived()
	 * @see #getFeatureLabelProviderConfiguration()
	 * @generated
	 */
	EAttribute getFeatureLabelProviderConfiguration_DisplayIsDerived();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration#isDisplayType <em>Display Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Type</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration#isDisplayType()
	 * @see #getFeatureLabelProviderConfiguration()
	 * @generated
	 */
	EAttribute getFeatureLabelProviderConfiguration_DisplayType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration#isDisplayMultiplicity <em>Display Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Multiplicity</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration#isDisplayMultiplicity()
	 * @see #getFeatureLabelProviderConfiguration()
	 * @generated
	 */
	EAttribute getFeatureLabelProviderConfiguration_DisplayMultiplicity();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration#isDisplayName <em>Display Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Name</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration#isDisplayName()
	 * @see #getFeatureLabelProviderConfiguration()
	 * @generated
	 */
	EAttribute getFeatureLabelProviderConfiguration_DisplayName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ObjectLabelProviderConfiguration <em>Object Label Provider Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Label Provider Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ObjectLabelProviderConfiguration
	 * @generated
	 */
	EClass getObjectLabelProviderConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ObjectLabelProviderConfiguration#isDisplayIcon <em>Display Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Icon</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ObjectLabelProviderConfiguration#isDisplayIcon()
	 * @see #getObjectLabelProviderConfiguration()
	 * @generated
	 */
	EAttribute getObjectLabelProviderConfiguration_DisplayIcon();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ObjectLabelProviderConfiguration#isDisplayLabel <em>Display Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Label</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ObjectLabelProviderConfiguration#isDisplayLabel()
	 * @see #getObjectLabelProviderConfiguration()
	 * @generated
	 */
	EAttribute getObjectLabelProviderConfiguration_DisplayLabel();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NattablelabelproviderFactory getNattablelabelproviderFactory();

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
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelProviderConfiguration <em>ILabel Provider Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelProviderConfiguration
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.NattablelabelproviderPackageImpl#getILabelProviderConfiguration()
		 * @generated
		 */
		EClass ILABEL_PROVIDER_CONFIGURATION = eINSTANCE.getILabelProviderConfiguration();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.FeatureLabelProviderConfigurationImpl <em>Feature Label Provider Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.FeatureLabelProviderConfigurationImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.NattablelabelproviderPackageImpl#getFeatureLabelProviderConfiguration()
		 * @generated
		 */
		EClass FEATURE_LABEL_PROVIDER_CONFIGURATION = eINSTANCE.getFeatureLabelProviderConfiguration();

		/**
		 * The meta object literal for the '<em><b>Display Is Derived</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_IS_DERIVED = eINSTANCE.getFeatureLabelProviderConfiguration_DisplayIsDerived();

		/**
		 * The meta object literal for the '<em><b>Display Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_TYPE = eINSTANCE.getFeatureLabelProviderConfiguration_DisplayType();

		/**
		 * The meta object literal for the '<em><b>Display Multiplicity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_MULTIPLICITY = eINSTANCE.getFeatureLabelProviderConfiguration_DisplayMultiplicity();

		/**
		 * The meta object literal for the '<em><b>Display Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_NAME = eINSTANCE.getFeatureLabelProviderConfiguration_DisplayName();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.ObjectLabelProviderConfigurationImpl <em>Object Label Provider Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.ObjectLabelProviderConfigurationImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.NattablelabelproviderPackageImpl#getObjectLabelProviderConfiguration()
		 * @generated
		 */
		EClass OBJECT_LABEL_PROVIDER_CONFIGURATION = eINSTANCE.getObjectLabelProviderConfiguration();

		/**
		 * The meta object literal for the '<em><b>Display Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_LABEL_PROVIDER_CONFIGURATION__DISPLAY_ICON = eINSTANCE.getObjectLabelProviderConfiguration_DisplayIcon();

		/**
		 * The meta object literal for the '<em><b>Display Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_LABEL_PROVIDER_CONFIGURATION__DISPLAY_LABEL = eINSTANCE.getObjectLabelProviderConfiguration_DisplayLabel();

	}

} //NattablelabelproviderPackage
