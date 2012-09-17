/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.constraints.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.infra.constraints.CompositeConstraint;
import org.eclipse.papyrus.infra.constraints.ConstraintsFactory;
import org.eclipse.papyrus.infra.constraints.ConstraintsPackage;
import org.eclipse.papyrus.infra.constraints.ReferenceProperty;
import org.eclipse.papyrus.infra.constraints.SimpleConstraint;
import org.eclipse.papyrus.infra.constraints.ValueProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConstraintsFactoryImpl extends EFactoryImpl implements ConstraintsFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConstraintsFactory init() {
		try {
			ConstraintsFactory theConstraintsFactory = (ConstraintsFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/constraints/0.9"); 
			if (theConstraintsFactory != null) {
				return theConstraintsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ConstraintsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ConstraintsPackage.SIMPLE_CONSTRAINT: return createSimpleConstraint();
			case ConstraintsPackage.COMPOSITE_CONSTRAINT: return createCompositeConstraint();
			case ConstraintsPackage.VALUE_PROPERTY: return createValueProperty();
			case ConstraintsPackage.REFERENCE_PROPERTY: return createReferenceProperty();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleConstraint createSimpleConstraint() {
		SimpleConstraintImpl simpleConstraint = new SimpleConstraintImpl();
		return simpleConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeConstraint createCompositeConstraint() {
		CompositeConstraintImpl compositeConstraint = new CompositeConstraintImpl();
		return compositeConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueProperty createValueProperty() {
		ValuePropertyImpl valueProperty = new ValuePropertyImpl();
		return valueProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceProperty createReferenceProperty() {
		ReferencePropertyImpl referenceProperty = new ReferencePropertyImpl();
		return referenceProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintsPackage getConstraintsPackage() {
		return (ConstraintsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ConstraintsPackage getPackage() {
		return ConstraintsPackage.eINSTANCE;
	}

} //ConstraintsFactoryImpl
