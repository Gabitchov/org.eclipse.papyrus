/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.constraints.environment;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.papyrus.infra.constraints.environment.EnvironmentFactory
 * @model kind="package"
 * @generated
 */
public interface EnvironmentPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "environment";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/constraints/environment/0.9";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "environment";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EnvironmentPackage eINSTANCE = org.eclipse.papyrus.infra.constraints.environment.impl.EnvironmentPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.constraints.environment.impl.ConstraintEnvironmentImpl <em>Constraint Environment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.constraints.environment.impl.ConstraintEnvironmentImpl
	 * @see org.eclipse.papyrus.infra.constraints.environment.impl.EnvironmentPackageImpl#getConstraintEnvironment()
	 * @generated
	 */
	int CONSTRAINT_ENVIRONMENT = 0;

	/**
	 * The feature id for the '<em><b>Constraint Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ENVIRONMENT__CONSTRAINT_TYPES = 0;

	/**
	 * The number of structural features of the '<em>Constraint Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ENVIRONMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.constraints.environment.impl.ConstraintTypeImpl <em>Constraint Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.constraints.environment.impl.ConstraintTypeImpl
	 * @see org.eclipse.papyrus.infra.constraints.environment.impl.EnvironmentPackageImpl#getConstraintType()
	 * @generated
	 */
	int CONSTRAINT_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_TYPE__LABEL = 0;

	/**
	 * The feature id for the '<em><b>Constraint Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_TYPE__CONSTRAINT_CLASS = 1;

	/**
	 * The number of structural features of the '<em>Constraint Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_TYPE_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.constraints.environment.ConstraintEnvironment <em>Constraint Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint Environment</em>'.
	 * @see org.eclipse.papyrus.infra.constraints.environment.ConstraintEnvironment
	 * @generated
	 */
	EClass getConstraintEnvironment();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.constraints.environment.ConstraintEnvironment#getConstraintTypes <em>Constraint Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraint Types</em>'.
	 * @see org.eclipse.papyrus.infra.constraints.environment.ConstraintEnvironment#getConstraintTypes()
	 * @see #getConstraintEnvironment()
	 * @generated
	 */
	EReference getConstraintEnvironment_ConstraintTypes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.constraints.environment.ConstraintType <em>Constraint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint Type</em>'.
	 * @see org.eclipse.papyrus.infra.constraints.environment.ConstraintType
	 * @generated
	 */
	EClass getConstraintType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.constraints.environment.ConstraintType#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.papyrus.infra.constraints.environment.ConstraintType#getLabel()
	 * @see #getConstraintType()
	 * @generated
	 */
	EAttribute getConstraintType_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.constraints.environment.ConstraintType#getConstraintClass <em>Constraint Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint Class</em>'.
	 * @see org.eclipse.papyrus.infra.constraints.environment.ConstraintType#getConstraintClass()
	 * @see #getConstraintType()
	 * @generated
	 */
	EAttribute getConstraintType_ConstraintClass();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EnvironmentFactory getEnvironmentFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.constraints.environment.impl.ConstraintEnvironmentImpl <em>Constraint Environment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.constraints.environment.impl.ConstraintEnvironmentImpl
		 * @see org.eclipse.papyrus.infra.constraints.environment.impl.EnvironmentPackageImpl#getConstraintEnvironment()
		 * @generated
		 */
		EClass CONSTRAINT_ENVIRONMENT = eINSTANCE.getConstraintEnvironment();

		/**
		 * The meta object literal for the '<em><b>Constraint Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_ENVIRONMENT__CONSTRAINT_TYPES = eINSTANCE.getConstraintEnvironment_ConstraintTypes();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.constraints.environment.impl.ConstraintTypeImpl <em>Constraint Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.constraints.environment.impl.ConstraintTypeImpl
		 * @see org.eclipse.papyrus.infra.constraints.environment.impl.EnvironmentPackageImpl#getConstraintType()
		 * @generated
		 */
		EClass CONSTRAINT_TYPE = eINSTANCE.getConstraintType();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT_TYPE__LABEL = eINSTANCE.getConstraintType_Label();

		/**
		 * The meta object literal for the '<em><b>Constraint Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT_TYPE__CONSTRAINT_CLASS = eINSTANCE.getConstraintType_ConstraintClass();

	}

} //EnvironmentPackage
