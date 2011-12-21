/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.constraints;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.papyrus.infra.constraints.ConstraintsFactory
 * @model kind="package"
 * @generated
 */
public interface ConstraintsPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "constraints";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/constraints/0.9";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "constraints";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConstraintsPackage eINSTANCE = org.eclipse.papyrus.infra.constraints.impl.ConstraintsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.constraints.impl.DisplayUnitImpl <em>Display Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.constraints.impl.DisplayUnitImpl
	 * @see org.eclipse.papyrus.infra.constraints.impl.ConstraintsPackageImpl#getDisplayUnit()
	 * @generated
	 */
	int DISPLAY_UNIT = 0;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_UNIT__CONSTRAINTS = 0;

	/**
	 * The feature id for the '<em><b>Element Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_UNIT__ELEMENT_MULTIPLICITY = 1;

	/**
	 * The number of structural features of the '<em>Display Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_UNIT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.constraints.impl.ConstraintDescriptorImpl <em>Constraint Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.constraints.impl.ConstraintDescriptorImpl
	 * @see org.eclipse.papyrus.infra.constraints.impl.ConstraintsPackageImpl#getConstraintDescriptor()
	 * @generated
	 */
	int CONSTRAINT_DESCRIPTOR = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_DESCRIPTOR__NAME = 0;

	/**
	 * The feature id for the '<em><b>Display</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_DESCRIPTOR__DISPLAY = 1;

	/**
	 * The feature id for the '<em><b>Overrideable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_DESCRIPTOR__OVERRIDEABLE = 2;

	/**
	 * The feature id for the '<em><b>Overridden Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_DESCRIPTOR__OVERRIDDEN_CONSTRAINTS = 3;

	/**
	 * The number of structural features of the '<em>Constraint Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_DESCRIPTOR_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.constraints.impl.SimpleConstraintImpl <em>Simple Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.constraints.impl.SimpleConstraintImpl
	 * @see org.eclipse.papyrus.infra.constraints.impl.ConstraintsPackageImpl#getSimpleConstraint()
	 * @generated
	 */
	int SIMPLE_CONSTRAINT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_CONSTRAINT__NAME = CONSTRAINT_DESCRIPTOR__NAME;

	/**
	 * The feature id for the '<em><b>Display</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_CONSTRAINT__DISPLAY = CONSTRAINT_DESCRIPTOR__DISPLAY;

	/**
	 * The feature id for the '<em><b>Overrideable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_CONSTRAINT__OVERRIDEABLE = CONSTRAINT_DESCRIPTOR__OVERRIDEABLE;

	/**
	 * The feature id for the '<em><b>Overridden Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_CONSTRAINT__OVERRIDDEN_CONSTRAINTS = CONSTRAINT_DESCRIPTOR__OVERRIDDEN_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Constraint Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_CONSTRAINT__CONSTRAINT_TYPE = CONSTRAINT_DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_CONSTRAINT__PROPERTIES = CONSTRAINT_DESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Simple Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_DESCRIPTOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.constraints.impl.CompositeConstraintImpl <em>Composite Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.constraints.impl.CompositeConstraintImpl
	 * @see org.eclipse.papyrus.infra.constraints.impl.ConstraintsPackageImpl#getCompositeConstraint()
	 * @generated
	 */
	int COMPOSITE_CONSTRAINT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONSTRAINT__NAME = CONSTRAINT_DESCRIPTOR__NAME;

	/**
	 * The feature id for the '<em><b>Display</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONSTRAINT__DISPLAY = CONSTRAINT_DESCRIPTOR__DISPLAY;

	/**
	 * The feature id for the '<em><b>Overrideable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONSTRAINT__OVERRIDEABLE = CONSTRAINT_DESCRIPTOR__OVERRIDEABLE;

	/**
	 * The feature id for the '<em><b>Overridden Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONSTRAINT__OVERRIDDEN_CONSTRAINTS = CONSTRAINT_DESCRIPTOR__OVERRIDDEN_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONSTRAINT__CONSTRAINTS = CONSTRAINT_DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_DESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.constraints.impl.ConfigPropertyImpl <em>Config Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.constraints.impl.ConfigPropertyImpl
	 * @see org.eclipse.papyrus.infra.constraints.impl.ConstraintsPackageImpl#getConfigProperty()
	 * @generated
	 */
	int CONFIG_PROPERTY = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY__NAME = 0;

	/**
	 * The number of structural features of the '<em>Config Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_PROPERTY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.constraints.impl.ValuePropertyImpl <em>Value Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.constraints.impl.ValuePropertyImpl
	 * @see org.eclipse.papyrus.infra.constraints.impl.ConstraintsPackageImpl#getValueProperty()
	 * @generated
	 */
	int VALUE_PROPERTY = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PROPERTY__NAME = CONFIG_PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PROPERTY__VALUE = CONFIG_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Value Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PROPERTY_FEATURE_COUNT = CONFIG_PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.constraints.impl.ReferencePropertyImpl <em>Reference Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.constraints.impl.ReferencePropertyImpl
	 * @see org.eclipse.papyrus.infra.constraints.impl.ConstraintsPackageImpl#getReferenceProperty()
	 * @generated
	 */
	int REFERENCE_PROPERTY = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PROPERTY__NAME = CONFIG_PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PROPERTY__VALUE = CONFIG_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PROPERTY_FEATURE_COUNT = CONFIG_PROPERTY_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.constraints.DisplayUnit <em>Display Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Display Unit</em>'.
	 * @see org.eclipse.papyrus.infra.constraints.DisplayUnit
	 * @generated
	 */
	EClass getDisplayUnit();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.constraints.DisplayUnit#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see org.eclipse.papyrus.infra.constraints.DisplayUnit#getConstraints()
	 * @see #getDisplayUnit()
	 * @generated
	 */
	EReference getDisplayUnit_Constraints();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.constraints.DisplayUnit#getElementMultiplicity <em>Element Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element Multiplicity</em>'.
	 * @see org.eclipse.papyrus.infra.constraints.DisplayUnit#getElementMultiplicity()
	 * @see #getDisplayUnit()
	 * @generated
	 */
	EAttribute getDisplayUnit_ElementMultiplicity();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.constraints.ConstraintDescriptor <em>Constraint Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint Descriptor</em>'.
	 * @see org.eclipse.papyrus.infra.constraints.ConstraintDescriptor
	 * @generated
	 */
	EClass getConstraintDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.constraints.ConstraintDescriptor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.constraints.ConstraintDescriptor#getName()
	 * @see #getConstraintDescriptor()
	 * @generated
	 */
	EAttribute getConstraintDescriptor_Name();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.infra.constraints.ConstraintDescriptor#getDisplay <em>Display</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Display</em>'.
	 * @see org.eclipse.papyrus.infra.constraints.ConstraintDescriptor#getDisplay()
	 * @see #getConstraintDescriptor()
	 * @generated
	 */
	EReference getConstraintDescriptor_Display();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.constraints.ConstraintDescriptor#isOverrideable <em>Overrideable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Overrideable</em>'.
	 * @see org.eclipse.papyrus.infra.constraints.ConstraintDescriptor#isOverrideable()
	 * @see #getConstraintDescriptor()
	 * @generated
	 */
	EAttribute getConstraintDescriptor_Overrideable();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.constraints.ConstraintDescriptor#getOverriddenConstraints <em>Overridden Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Overridden Constraints</em>'.
	 * @see org.eclipse.papyrus.infra.constraints.ConstraintDescriptor#getOverriddenConstraints()
	 * @see #getConstraintDescriptor()
	 * @generated
	 */
	EReference getConstraintDescriptor_OverriddenConstraints();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.constraints.SimpleConstraint <em>Simple Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Constraint</em>'.
	 * @see org.eclipse.papyrus.infra.constraints.SimpleConstraint
	 * @generated
	 */
	EClass getSimpleConstraint();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.constraints.SimpleConstraint#getConstraintType <em>Constraint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Constraint Type</em>'.
	 * @see org.eclipse.papyrus.infra.constraints.SimpleConstraint#getConstraintType()
	 * @see #getSimpleConstraint()
	 * @generated
	 */
	EReference getSimpleConstraint_ConstraintType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.constraints.SimpleConstraint#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.eclipse.papyrus.infra.constraints.SimpleConstraint#getProperties()
	 * @see #getSimpleConstraint()
	 * @generated
	 */
	EReference getSimpleConstraint_Properties();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.constraints.CompositeConstraint <em>Composite Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Constraint</em>'.
	 * @see org.eclipse.papyrus.infra.constraints.CompositeConstraint
	 * @generated
	 */
	EClass getCompositeConstraint();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.constraints.CompositeConstraint#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see org.eclipse.papyrus.infra.constraints.CompositeConstraint#getConstraints()
	 * @see #getCompositeConstraint()
	 * @generated
	 */
	EReference getCompositeConstraint_Constraints();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.constraints.ConfigProperty <em>Config Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Config Property</em>'.
	 * @see org.eclipse.papyrus.infra.constraints.ConfigProperty
	 * @generated
	 */
	EClass getConfigProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.constraints.ConfigProperty#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.constraints.ConfigProperty#getName()
	 * @see #getConfigProperty()
	 * @generated
	 */
	EAttribute getConfigProperty_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.constraints.ValueProperty <em>Value Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Property</em>'.
	 * @see org.eclipse.papyrus.infra.constraints.ValueProperty
	 * @generated
	 */
	EClass getValueProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.constraints.ValueProperty#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.infra.constraints.ValueProperty#getValue()
	 * @see #getValueProperty()
	 * @generated
	 */
	EAttribute getValueProperty_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.constraints.ReferenceProperty <em>Reference Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Property</em>'.
	 * @see org.eclipse.papyrus.infra.constraints.ReferenceProperty
	 * @generated
	 */
	EClass getReferenceProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.constraints.ReferenceProperty#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see org.eclipse.papyrus.infra.constraints.ReferenceProperty#getValue()
	 * @see #getReferenceProperty()
	 * @generated
	 */
	EReference getReferenceProperty_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConstraintsFactory getConstraintsFactory();

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
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.constraints.impl.DisplayUnitImpl <em>Display Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.constraints.impl.DisplayUnitImpl
		 * @see org.eclipse.papyrus.infra.constraints.impl.ConstraintsPackageImpl#getDisplayUnit()
		 * @generated
		 */
		EClass DISPLAY_UNIT = eINSTANCE.getDisplayUnit();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISPLAY_UNIT__CONSTRAINTS = eINSTANCE.getDisplayUnit_Constraints();

		/**
		 * The meta object literal for the '<em><b>Element Multiplicity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISPLAY_UNIT__ELEMENT_MULTIPLICITY = eINSTANCE.getDisplayUnit_ElementMultiplicity();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.constraints.impl.ConstraintDescriptorImpl <em>Constraint Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.constraints.impl.ConstraintDescriptorImpl
		 * @see org.eclipse.papyrus.infra.constraints.impl.ConstraintsPackageImpl#getConstraintDescriptor()
		 * @generated
		 */
		EClass CONSTRAINT_DESCRIPTOR = eINSTANCE.getConstraintDescriptor();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT_DESCRIPTOR__NAME = eINSTANCE.getConstraintDescriptor_Name();

		/**
		 * The meta object literal for the '<em><b>Display</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_DESCRIPTOR__DISPLAY = eINSTANCE.getConstraintDescriptor_Display();

		/**
		 * The meta object literal for the '<em><b>Overrideable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT_DESCRIPTOR__OVERRIDEABLE = eINSTANCE.getConstraintDescriptor_Overrideable();

		/**
		 * The meta object literal for the '<em><b>Overridden Constraints</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_DESCRIPTOR__OVERRIDDEN_CONSTRAINTS = eINSTANCE.getConstraintDescriptor_OverriddenConstraints();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.constraints.impl.SimpleConstraintImpl <em>Simple Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.constraints.impl.SimpleConstraintImpl
		 * @see org.eclipse.papyrus.infra.constraints.impl.ConstraintsPackageImpl#getSimpleConstraint()
		 * @generated
		 */
		EClass SIMPLE_CONSTRAINT = eINSTANCE.getSimpleConstraint();

		/**
		 * The meta object literal for the '<em><b>Constraint Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_CONSTRAINT__CONSTRAINT_TYPE = eINSTANCE.getSimpleConstraint_ConstraintType();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_CONSTRAINT__PROPERTIES = eINSTANCE.getSimpleConstraint_Properties();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.constraints.impl.CompositeConstraintImpl <em>Composite Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.constraints.impl.CompositeConstraintImpl
		 * @see org.eclipse.papyrus.infra.constraints.impl.ConstraintsPackageImpl#getCompositeConstraint()
		 * @generated
		 */
		EClass COMPOSITE_CONSTRAINT = eINSTANCE.getCompositeConstraint();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_CONSTRAINT__CONSTRAINTS = eINSTANCE.getCompositeConstraint_Constraints();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.constraints.impl.ConfigPropertyImpl <em>Config Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.constraints.impl.ConfigPropertyImpl
		 * @see org.eclipse.papyrus.infra.constraints.impl.ConstraintsPackageImpl#getConfigProperty()
		 * @generated
		 */
		EClass CONFIG_PROPERTY = eINSTANCE.getConfigProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIG_PROPERTY__NAME = eINSTANCE.getConfigProperty_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.constraints.impl.ValuePropertyImpl <em>Value Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.constraints.impl.ValuePropertyImpl
		 * @see org.eclipse.papyrus.infra.constraints.impl.ConstraintsPackageImpl#getValueProperty()
		 * @generated
		 */
		EClass VALUE_PROPERTY = eINSTANCE.getValueProperty();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_PROPERTY__VALUE = eINSTANCE.getValueProperty_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.constraints.impl.ReferencePropertyImpl <em>Reference Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.constraints.impl.ReferencePropertyImpl
		 * @see org.eclipse.papyrus.infra.constraints.impl.ConstraintsPackageImpl#getReferenceProperty()
		 * @generated
		 */
		EClass REFERENCE_PROPERTY = eINSTANCE.getReferenceProperty();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_PROPERTY__VALUE = eINSTANCE.getReferenceProperty_Value();

	}

} //ConstraintsPackage
