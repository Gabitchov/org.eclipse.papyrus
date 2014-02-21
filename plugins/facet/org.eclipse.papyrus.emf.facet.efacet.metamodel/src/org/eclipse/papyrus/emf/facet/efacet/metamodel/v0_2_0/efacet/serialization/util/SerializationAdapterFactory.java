/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 * 	Gregoire Dupe (Mia-Software) - Design
 * 	Nicolas Guyomar (Mia-Software) - Implementation
 * 	Emmanuelle RouillÃ© (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 * 	Nicolas Bros (Mia-Software) - Bug 361823 - [Restructuring] eFacet2 meta-model
 */
package org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.*;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.AbstractAttributeInstance;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.AbstractReferenceInstance;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.ExtendedEObjectReference;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedAttributeInstance;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedContainmentReferenceInstance;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedReferenceInstance;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SerializationPackage;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedAttributeInstance;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedContainmentReferenceInstance;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedReferenceInstance;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SerializationPackage
 * @generated
 */
public class SerializationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SerializationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SerializationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SerializationPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SerializationSwitch<Adapter> modelSwitch =
		new SerializationSwitch<Adapter>() {
			@Override
			public Adapter caseAbstractReferenceInstance(AbstractReferenceInstance object) {
				return createAbstractReferenceInstanceAdapter();
			}
			@Override
			public Adapter caseMultiValuedContainmentReferenceInstance(MultiValuedContainmentReferenceInstance object) {
				return createMultiValuedContainmentReferenceInstanceAdapter();
			}
			@Override
			public Adapter caseMultiValuedReferenceInstance(MultiValuedReferenceInstance object) {
				return createMultiValuedReferenceInstanceAdapter();
			}
			@Override
			public Adapter caseSingleValuedAttributeInstance(SingleValuedAttributeInstance object) {
				return createSingleValuedAttributeInstanceAdapter();
			}
			@Override
			public Adapter caseExtendedEObjectReference(ExtendedEObjectReference object) {
				return createExtendedEObjectReferenceAdapter();
			}
			@Override
			public Adapter caseSingleValuedContainmentReferenceInstance(SingleValuedContainmentReferenceInstance object) {
				return createSingleValuedContainmentReferenceInstanceAdapter();
			}
			@Override
			public Adapter caseSingleValuedReferenceInstance(SingleValuedReferenceInstance object) {
				return createSingleValuedReferenceInstanceAdapter();
			}
			@Override
			public Adapter caseMultiValuedAttributeInstance(MultiValuedAttributeInstance object) {
				return createMultiValuedAttributeInstanceAdapter();
			}
			@Override
			public Adapter caseAbstractAttributeInstance(AbstractAttributeInstance object) {
				return createAbstractAttributeInstanceAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.AbstractReferenceInstance <em>Abstract Reference Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.AbstractReferenceInstance
	 * @generated
	 */
	public Adapter createAbstractReferenceInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedContainmentReferenceInstance <em>Multi Valued Containment Reference Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedContainmentReferenceInstance
	 * @generated
	 */
	public Adapter createMultiValuedContainmentReferenceInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedReferenceInstance <em>Multi Valued Reference Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedReferenceInstance
	 * @generated
	 */
	public Adapter createMultiValuedReferenceInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedAttributeInstance <em>Single Valued Attribute Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedAttributeInstance
	 * @generated
	 */
	public Adapter createSingleValuedAttributeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.ExtendedEObjectReference <em>Extended EObject Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.ExtendedEObjectReference
	 * @generated
	 */
	public Adapter createExtendedEObjectReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedContainmentReferenceInstance <em>Single Valued Containment Reference Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedContainmentReferenceInstance
	 * @generated
	 */
	public Adapter createSingleValuedContainmentReferenceInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedReferenceInstance <em>Single Valued Reference Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedReferenceInstance
	 * @generated
	 */
	public Adapter createSingleValuedReferenceInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedAttributeInstance <em>Multi Valued Attribute Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedAttributeInstance
	 * @generated
	 */
	public Adapter createMultiValuedAttributeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.AbstractAttributeInstance <em>Abstract Attribute Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.AbstractAttributeInstance
	 * @generated
	 */
	public Adapter createAbstractAttributeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SerializationAdapterFactory
