/**
 *  Copyright (c) 2011, 2012 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 * 	Gregoire Dupe (Mia-Software) - Design
 * 	Nicolas Guyomar (Mia-Software) - Implementation
 * 	Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 * 	Nicolas Bros (Mia-Software) - Bug 361823 - [Restructuring] eFacet2 meta-model
 *       Gregoire Dupe (Mia-Software) - Bug 366055 - NavigationQuery
 *       Gregoire Dupe (Mia-Software) - Bug 369673 - [Facet] IsOneOfQuery
 *       Olivier Remaud (Soft-Maint) - Bug 369824 - Add a simple way to return string literal constants from a customization query
 *       Gregoire Dupe (Mia-software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *       Gregoire Dupe (Mia-software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 */
package org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementResult;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.RuntimePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ETyped Element Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.ETypedElementResultImpl#getDerivedTypedElement <em>Derived Typed Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.ETypedElementResultImpl#getParameterValues <em>Parameter Values</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.ETypedElementResultImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl.ETypedElementResultImpl#getException <em>Exception</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ETypedElementResultImpl extends EObjectImpl implements ETypedElementResult {
	/**
	 * The cached value of the '{@link #getDerivedTypedElement() <em>Derived Typed Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivedTypedElement()
	 * @generated
	 * @ordered
	 */
	protected ETypedElement derivedTypedElement;

	/**
	 * The cached value of the '{@link #getParameterValues() <em>Parameter Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterValues()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterValue> parameterValues;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected EObject source;

	/**
	 * The default value of the '{@link #getException() <em>Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getException()
	 * @generated
	 * @ordered
	 */
	protected static final Throwable EXCEPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getException() <em>Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getException()
	 * @generated
	 * @ordered
	 */
	protected Throwable exception = EXCEPTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ETypedElementResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RuntimePackage.Literals.ETYPED_ELEMENT_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ETypedElement getDerivedTypedElement() {
		if (derivedTypedElement != null && derivedTypedElement.eIsProxy()) {
			InternalEObject oldDerivedTypedElement = (InternalEObject)derivedTypedElement;
			derivedTypedElement = (ETypedElement)eResolveProxy(oldDerivedTypedElement);
			if (derivedTypedElement != oldDerivedTypedElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RuntimePackage.ETYPED_ELEMENT_RESULT__DERIVED_TYPED_ELEMENT, oldDerivedTypedElement, derivedTypedElement));
			}
		}
		return derivedTypedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ETypedElement basicGetDerivedTypedElement() {
		return derivedTypedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDerivedTypedElement(ETypedElement newDerivedTypedElement) {
		ETypedElement oldDerivedTypedElement = derivedTypedElement;
		derivedTypedElement = newDerivedTypedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimePackage.ETYPED_ELEMENT_RESULT__DERIVED_TYPED_ELEMENT, oldDerivedTypedElement, derivedTypedElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterValue> getParameterValues() {
		if (parameterValues == null) {
			parameterValues = new EObjectContainmentEList<ParameterValue>(ParameterValue.class, this, RuntimePackage.ETYPED_ELEMENT_RESULT__PARAMETER_VALUES);
		}
		return parameterValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RuntimePackage.ETYPED_ELEMENT_RESULT__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(EObject newSource) {
		EObject oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimePackage.ETYPED_ELEMENT_RESULT__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Throwable getException() {
		return exception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setException(Throwable newException) {
		Throwable oldException = exception;
		exception = newException;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuntimePackage.ETYPED_ELEMENT_RESULT__EXCEPTION, oldException, exception));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RuntimePackage.ETYPED_ELEMENT_RESULT__PARAMETER_VALUES:
				return ((InternalEList<?>)getParameterValues()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RuntimePackage.ETYPED_ELEMENT_RESULT__DERIVED_TYPED_ELEMENT:
				if (resolve) return getDerivedTypedElement();
				return basicGetDerivedTypedElement();
			case RuntimePackage.ETYPED_ELEMENT_RESULT__PARAMETER_VALUES:
				return getParameterValues();
			case RuntimePackage.ETYPED_ELEMENT_RESULT__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case RuntimePackage.ETYPED_ELEMENT_RESULT__EXCEPTION:
				return getException();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RuntimePackage.ETYPED_ELEMENT_RESULT__DERIVED_TYPED_ELEMENT:
				setDerivedTypedElement((ETypedElement)newValue);
				return;
			case RuntimePackage.ETYPED_ELEMENT_RESULT__PARAMETER_VALUES:
				getParameterValues().clear();
				getParameterValues().addAll((Collection<? extends ParameterValue>)newValue);
				return;
			case RuntimePackage.ETYPED_ELEMENT_RESULT__SOURCE:
				setSource((EObject)newValue);
				return;
			case RuntimePackage.ETYPED_ELEMENT_RESULT__EXCEPTION:
				setException((Throwable)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case RuntimePackage.ETYPED_ELEMENT_RESULT__DERIVED_TYPED_ELEMENT:
				setDerivedTypedElement((ETypedElement)null);
				return;
			case RuntimePackage.ETYPED_ELEMENT_RESULT__PARAMETER_VALUES:
				getParameterValues().clear();
				return;
			case RuntimePackage.ETYPED_ELEMENT_RESULT__SOURCE:
				setSource((EObject)null);
				return;
			case RuntimePackage.ETYPED_ELEMENT_RESULT__EXCEPTION:
				setException(EXCEPTION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RuntimePackage.ETYPED_ELEMENT_RESULT__DERIVED_TYPED_ELEMENT:
				return derivedTypedElement != null;
			case RuntimePackage.ETYPED_ELEMENT_RESULT__PARAMETER_VALUES:
				return parameterValues != null && !parameterValues.isEmpty();
			case RuntimePackage.ETYPED_ELEMENT_RESULT__SOURCE:
				return source != null;
			case RuntimePackage.ETYPED_ELEMENT_RESULT__EXCEPTION:
				return EXCEPTION_EDEFAULT == null ? exception != null : !EXCEPTION_EDEFAULT.equals(exception);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (exception: "); //$NON-NLS-1$
		result.append(exception);
		result.append(')');
		return result.toString();
	}

} //ETypedElementResultImpl
