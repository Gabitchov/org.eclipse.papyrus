/*****************************************************************************
 * Copyright (c) 2011 Nicolas Deblock & Cedric Dumoulin & Manuel Giles.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Nicolas Deblock  nico.deblock@gmail.com  - Meta-model conception
 * 	Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Meta-model conception 
 * 	Manuel Giles	 giles.manu@live.fr		 - Meta-model conception
 *
 *****************************************************************************/

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.Signature;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethodBody;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParent;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JDT Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTMethodImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTMethodImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTMethodImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTMethodImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTMethodImpl#isFinal <em>Final</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTMethodImpl#isStatic <em>Static</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTMethodImpl#getExceptions <em>Exceptions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTMethodImpl#isSynchronized <em>Synchronized</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTMethodImpl#isConstructor <em>Constructor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTMethodImpl#getBodies <em>Bodies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JDTMethodImpl extends JDTMemberImpl implements JDTMethod {

	/**
	 * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturnType()
	 * @generated
	 * @ordered
	 */
	protected JDTParameter returnType;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<JDTParameter> parameters;

	/**
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isFinal() <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFinal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FINAL_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isStatic() <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStatic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STATIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #getExceptions() <em>Exceptions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExceptions()
	 * @generated
	 * @ordered
	 */
	protected EList<JDTType> exceptions;

	/**
	 * The default value of the '{@link #isSynchronized() <em>Synchronized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSynchronized()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SYNCHRONIZED_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isConstructor() <em>Constructor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConstructor()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONSTRUCTOR_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isConstructor() <em>Constructor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConstructor()
	 * @generated
	 * @ordered
	 */
	protected boolean constructor = CONSTRUCTOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBodies() <em>Bodies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodies()
	 * @generated
	 * @ordered
	 */
	protected EList<JDTMethodBody> bodies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JDTMethodImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JdtmmPackage.Literals.JDT_METHOD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JDTParameter getReturnType() {
		return returnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReturnType(JDTParameter newReturnType, NotificationChain msgs) {
		JDTParameter oldReturnType = returnType;
		returnType = newReturnType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_METHOD__RETURN_TYPE, oldReturnType, newReturnType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturnType(JDTParameter newReturnType) {
		if (newReturnType != returnType) {
			NotificationChain msgs = null;
			if (returnType != null)
				msgs = ((InternalEObject)returnType).eInverseRemove(this, JdtmmPackage.JDT_PARAMETER__RETURN_OWNER, JDTParameter.class, msgs);
			if (newReturnType != null)
				msgs = ((InternalEObject)newReturnType).eInverseAdd(this, JdtmmPackage.JDT_PARAMETER__RETURN_OWNER, JDTParameter.class, msgs);
			msgs = basicSetReturnType(newReturnType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_METHOD__RETURN_TYPE, newReturnType, newReturnType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JDTParameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentWithInverseEList<JDTParameter>(JDTParameter.class, this, JdtmmPackage.JDT_METHOD__PARAMETERS, JdtmmPackage.JDT_PARAMETER__PARAMETER_OWNER);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JDTType> getExceptions() {
		if (exceptions == null) {
			exceptions = new EObjectResolvingEList<JDTType>(JDTType.class, this, JdtmmPackage.JDT_METHOD__EXCEPTIONS);
		}
		return exceptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isSynchronized() {
		// Ensure that you remove @generated or mark it @generated NOT
		return isFlagSet(Flags.AccSynchronized);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setSynchronized(boolean newSynchronized) {
		// Ensure that you remove @generated or mark it @generated NOT
		setFlag(Flags.AccSynchronized, newSynchronized);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isConstructor() {
		return constructor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstructor(boolean newConstructor) {
		boolean oldConstructor = constructor;
		constructor = newConstructor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_METHOD__CONSTRUCTOR, oldConstructor, constructor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JDTMethodBody> getBodies() {
		if (bodies == null) {
			bodies = new EObjectContainmentWithInverseEList<JDTMethodBody>(JDTMethodBody.class, this, JdtmmPackage.JDT_METHOD__BODIES, JdtmmPackage.JDT_METHOD_BODY__OWNER);
		}
		return bodies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JDTType getOwner() {
		if (eContainerFeatureID() != JdtmmPackage.JDT_METHOD__OWNER) return null;
		return (JDTType)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(JDTType newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, JdtmmPackage.JDT_METHOD__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(JDTType newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != JdtmmPackage.JDT_METHOD__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, JdtmmPackage.JDT_TYPE__METHODS, JDTType.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_METHOD__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwner() {
		return getOwner() != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JdtmmPackage.JDT_METHOD__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((JDTType)otherEnd, msgs);
			case JdtmmPackage.JDT_METHOD__RETURN_TYPE:
				if (returnType != null)
					msgs = ((InternalEObject)returnType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JdtmmPackage.JDT_METHOD__RETURN_TYPE, null, msgs);
				return basicSetReturnType((JDTParameter)otherEnd, msgs);
			case JdtmmPackage.JDT_METHOD__PARAMETERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getParameters()).basicAdd(otherEnd, msgs);
			case JdtmmPackage.JDT_METHOD__BODIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBodies()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JdtmmPackage.JDT_METHOD__OWNER:
				return basicSetOwner(null, msgs);
			case JdtmmPackage.JDT_METHOD__RETURN_TYPE:
				return basicSetReturnType(null, msgs);
			case JdtmmPackage.JDT_METHOD__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case JdtmmPackage.JDT_METHOD__BODIES:
				return ((InternalEList<?>)getBodies()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case JdtmmPackage.JDT_METHOD__OWNER:
				return eInternalContainer().eInverseRemove(this, JdtmmPackage.JDT_TYPE__METHODS, JDTType.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JdtmmPackage.JDT_METHOD__OWNER:
				return getOwner();
			case JdtmmPackage.JDT_METHOD__RETURN_TYPE:
				return getReturnType();
			case JdtmmPackage.JDT_METHOD__PARAMETERS:
				return getParameters();
			case JdtmmPackage.JDT_METHOD__ABSTRACT:
				return isAbstract();
			case JdtmmPackage.JDT_METHOD__FINAL:
				return isFinal();
			case JdtmmPackage.JDT_METHOD__STATIC:
				return isStatic();
			case JdtmmPackage.JDT_METHOD__EXCEPTIONS:
				return getExceptions();
			case JdtmmPackage.JDT_METHOD__SYNCHRONIZED:
				return isSynchronized();
			case JdtmmPackage.JDT_METHOD__CONSTRUCTOR:
				return isConstructor();
			case JdtmmPackage.JDT_METHOD__BODIES:
				return getBodies();
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
			case JdtmmPackage.JDT_METHOD__OWNER:
				setOwner((JDTType)newValue);
				return;
			case JdtmmPackage.JDT_METHOD__RETURN_TYPE:
				setReturnType((JDTParameter)newValue);
				return;
			case JdtmmPackage.JDT_METHOD__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends JDTParameter>)newValue);
				return;
			case JdtmmPackage.JDT_METHOD__ABSTRACT:
				setAbstract((Boolean)newValue);
				return;
			case JdtmmPackage.JDT_METHOD__FINAL:
				setFinal((Boolean)newValue);
				return;
			case JdtmmPackage.JDT_METHOD__STATIC:
				setStatic((Boolean)newValue);
				return;
			case JdtmmPackage.JDT_METHOD__EXCEPTIONS:
				getExceptions().clear();
				getExceptions().addAll((Collection<? extends JDTType>)newValue);
				return;
			case JdtmmPackage.JDT_METHOD__SYNCHRONIZED:
				setSynchronized((Boolean)newValue);
				return;
			case JdtmmPackage.JDT_METHOD__CONSTRUCTOR:
				setConstructor((Boolean)newValue);
				return;
			case JdtmmPackage.JDT_METHOD__BODIES:
				getBodies().clear();
				getBodies().addAll((Collection<? extends JDTMethodBody>)newValue);
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
			case JdtmmPackage.JDT_METHOD__OWNER:
				setOwner((JDTType)null);
				return;
			case JdtmmPackage.JDT_METHOD__RETURN_TYPE:
				setReturnType((JDTParameter)null);
				return;
			case JdtmmPackage.JDT_METHOD__PARAMETERS:
				getParameters().clear();
				return;
			case JdtmmPackage.JDT_METHOD__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case JdtmmPackage.JDT_METHOD__FINAL:
				setFinal(FINAL_EDEFAULT);
				return;
			case JdtmmPackage.JDT_METHOD__STATIC:
				setStatic(STATIC_EDEFAULT);
				return;
			case JdtmmPackage.JDT_METHOD__EXCEPTIONS:
				getExceptions().clear();
				return;
			case JdtmmPackage.JDT_METHOD__SYNCHRONIZED:
				setSynchronized(SYNCHRONIZED_EDEFAULT);
				return;
			case JdtmmPackage.JDT_METHOD__CONSTRUCTOR:
				setConstructor(CONSTRUCTOR_EDEFAULT);
				return;
			case JdtmmPackage.JDT_METHOD__BODIES:
				getBodies().clear();
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
			case JdtmmPackage.JDT_METHOD__OWNER:
				return isSetOwner();
			case JdtmmPackage.JDT_METHOD__RETURN_TYPE:
				return returnType != null;
			case JdtmmPackage.JDT_METHOD__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case JdtmmPackage.JDT_METHOD__ABSTRACT:
				return isAbstract() != ABSTRACT_EDEFAULT;
			case JdtmmPackage.JDT_METHOD__FINAL:
				return isFinal() != FINAL_EDEFAULT;
			case JdtmmPackage.JDT_METHOD__STATIC:
				return isStatic() != STATIC_EDEFAULT;
			case JdtmmPackage.JDT_METHOD__EXCEPTIONS:
				return exceptions != null && !exceptions.isEmpty();
			case JdtmmPackage.JDT_METHOD__SYNCHRONIZED:
				return isSynchronized() != SYNCHRONIZED_EDEFAULT;
			case JdtmmPackage.JDT_METHOD__CONSTRUCTOR:
				return constructor != CONSTRUCTOR_EDEFAULT;
			case JdtmmPackage.JDT_METHOD__BODIES:
				return bodies != null && !bodies.isEmpty();
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
		result.append(" (constructor: ");
		result.append(constructor);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JDTParent getParent() {
		return getOwner();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JDTParent basicGetParent() {
		return getOwner();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetParent() {
  		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isAbstract() {
		// Ensure that you remove @generated or mark it @generated NOT
		return isFlagSet(Flags.AccAbstract);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isFinal() {
		// Ensure that you remove @generated or mark it @generated NOT
		return isFlagSet(Flags.AccFinal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isStatic() {
		return isFlagSet(Flags.AccStatic);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setAbstract(boolean newAbstract) {
		// Ensure that you remove @generated or mark it @generated NOT
		setFlag(Flags.AccAbstract, newAbstract);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setFinal(boolean newFinal) {

		setFlag(Flags.AccFinal, newFinal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setStatic(boolean newStatic) {
		setFlag(Flags.AccStatic, newStatic);
	}

	@Override
	public String getJDTSignature() {
		List<String> lst = new ArrayList<String>();

		// signature of parameter
		for(JDTParameter p : parameters)
			lst.add(p.getJDTSignature());

		String[] params = new String[lst.size()];
		lst.toArray(params);

		// signature of return
		String returnTypeStr = Signature.createTypeSignature("void", false);
		if(returnType != null)
			returnTypeStr = returnType.getJDTSignature();

		return Signature.createMethodSignature(params, returnTypeStr);
	}


} //JDTMethodImpl
