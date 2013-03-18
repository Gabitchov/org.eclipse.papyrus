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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface NattableaxisconfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "nattableaxisconfiguration"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/nattable/model/table/nattableaxisconfiguration"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "nattableaxisconfiguration"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NattableaxisconfigurationPackage eINSTANCE = org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AbstractAxisConfigurationImpl <em>Abstract Axis Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AbstractAxisConfigurationImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getAbstractAxisConfiguration()
	 * @generated
	 */
	int ABSTRACT_AXIS_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_AXIS_CONFIGURATION__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Label Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_AXIS_CONFIGURATION__LABEL_CONFIGURATION = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Axis Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_AXIS_CONFIGURATION_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_AXIS_CONFIGURATION___GET_EANNOTATION__STRING = EcorePackage.EMODEL_ELEMENT___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Abstract Axis Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_AXIS_CONFIGURATION_OPERATION_COUNT = EcorePackage.EMODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.DefaultAxisConfigurationImpl <em>Default Axis Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.DefaultAxisConfigurationImpl
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getDefaultAxisConfiguration()
	 * @generated
	 */
	int DEFAULT_AXIS_CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_AXIS_CONFIGURATION__EANNOTATIONS = ABSTRACT_AXIS_CONFIGURATION__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Label Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_AXIS_CONFIGURATION__LABEL_CONFIGURATION = ABSTRACT_AXIS_CONFIGURATION__LABEL_CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Index Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_AXIS_CONFIGURATION__INDEX_STYLE = ABSTRACT_AXIS_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Display Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_AXIS_CONFIGURATION__DISPLAY_INDEX = ABSTRACT_AXIS_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Display Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_AXIS_CONFIGURATION__DISPLAY_LABEL = ABSTRACT_AXIS_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Display Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_AXIS_CONFIGURATION__DISPLAY_FILTER = ABSTRACT_AXIS_CONFIGURATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Default Axis Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_AXIS_CONFIGURATION_FEATURE_COUNT = ABSTRACT_AXIS_CONFIGURATION_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_AXIS_CONFIGURATION___GET_EANNOTATION__STRING = ABSTRACT_AXIS_CONFIGURATION___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Default Axis Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_AXIS_CONFIGURATION_OPERATION_COUNT = ABSTRACT_AXIS_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisIndexStyle <em>Axis Index Style</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisIndexStyle
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getAxisIndexStyle()
	 * @generated
	 */
	int AXIS_INDEX_STYLE = 2;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractAxisConfiguration <em>Abstract Axis Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Axis Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractAxisConfiguration
	 * @generated
	 */
	EClass getAbstractAxisConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractAxisConfiguration#getLabelConfiguration <em>Label Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Label Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractAxisConfiguration#getLabelConfiguration()
	 * @see #getAbstractAxisConfiguration()
	 * @generated
	 */
	EReference getAbstractAxisConfiguration_LabelConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.DefaultAxisConfiguration <em>Default Axis Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default Axis Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.DefaultAxisConfiguration
	 * @generated
	 */
	EClass getDefaultAxisConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.DefaultAxisConfiguration#getIndexStyle <em>Index Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index Style</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.DefaultAxisConfiguration#getIndexStyle()
	 * @see #getDefaultAxisConfiguration()
	 * @generated
	 */
	EAttribute getDefaultAxisConfiguration_IndexStyle();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.DefaultAxisConfiguration#isDisplayIndex <em>Display Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Index</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.DefaultAxisConfiguration#isDisplayIndex()
	 * @see #getDefaultAxisConfiguration()
	 * @generated
	 */
	EAttribute getDefaultAxisConfiguration_DisplayIndex();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.DefaultAxisConfiguration#isDisplayLabel <em>Display Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Label</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.DefaultAxisConfiguration#isDisplayLabel()
	 * @see #getDefaultAxisConfiguration()
	 * @generated
	 */
	EAttribute getDefaultAxisConfiguration_DisplayLabel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.DefaultAxisConfiguration#isDisplayFilter <em>Display Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Filter</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.DefaultAxisConfiguration#isDisplayFilter()
	 * @see #getDefaultAxisConfiguration()
	 * @generated
	 */
	EAttribute getDefaultAxisConfiguration_DisplayFilter();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisIndexStyle <em>Axis Index Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Axis Index Style</em>'.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisIndexStyle
	 * @generated
	 */
	EEnum getAxisIndexStyle();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NattableaxisconfigurationFactory getNattableaxisconfigurationFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AbstractAxisConfigurationImpl <em>Abstract Axis Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.AbstractAxisConfigurationImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getAbstractAxisConfiguration()
		 * @generated
		 */
		EClass ABSTRACT_AXIS_CONFIGURATION = eINSTANCE.getAbstractAxisConfiguration();

		/**
		 * The meta object literal for the '<em><b>Label Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_AXIS_CONFIGURATION__LABEL_CONFIGURATION = eINSTANCE.getAbstractAxisConfiguration_LabelConfiguration();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.DefaultAxisConfigurationImpl <em>Default Axis Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.DefaultAxisConfigurationImpl
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getDefaultAxisConfiguration()
		 * @generated
		 */
		EClass DEFAULT_AXIS_CONFIGURATION = eINSTANCE.getDefaultAxisConfiguration();

		/**
		 * The meta object literal for the '<em><b>Index Style</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFAULT_AXIS_CONFIGURATION__INDEX_STYLE = eINSTANCE.getDefaultAxisConfiguration_IndexStyle();

		/**
		 * The meta object literal for the '<em><b>Display Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFAULT_AXIS_CONFIGURATION__DISPLAY_INDEX = eINSTANCE.getDefaultAxisConfiguration_DisplayIndex();

		/**
		 * The meta object literal for the '<em><b>Display Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFAULT_AXIS_CONFIGURATION__DISPLAY_LABEL = eINSTANCE.getDefaultAxisConfiguration_DisplayLabel();

		/**
		 * The meta object literal for the '<em><b>Display Filter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFAULT_AXIS_CONFIGURATION__DISPLAY_FILTER = eINSTANCE.getDefaultAxisConfiguration_DisplayFilter();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisIndexStyle <em>Axis Index Style</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisIndexStyle
		 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl#getAxisIndexStyle()
		 * @generated
		 */
		EEnum AXIS_INDEX_STYLE = eINSTANCE.getAxisIndexStyle();

	}

} //NattableaxisconfigurationPackage
