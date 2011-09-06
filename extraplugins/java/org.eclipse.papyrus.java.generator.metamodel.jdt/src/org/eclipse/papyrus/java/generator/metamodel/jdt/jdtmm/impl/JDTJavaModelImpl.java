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

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaModel;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaProject;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JDT Java Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTJavaModelImpl#getJavaProject <em>Java Project</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class JDTJavaModelImpl extends JDTParentJavaElementImpl implements JDTJavaModel {

	/**
	 * The cached value of the '{@link #getJavaProject() <em>Java Project</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getJavaProject()
	 * @generated
	 * @ordered
	 */
	protected EList<JDTJavaProject> javaProject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected JDTJavaModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JdtmmPackage.Literals.JDT_JAVA_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<JDTJavaProject> getJavaProject() {
		if(javaProject == null) {
			javaProject = new EObjectContainmentWithInverseEList<JDTJavaProject>(JDTJavaProject.class, this, JdtmmPackage.JDT_JAVA_MODEL__JAVA_PROJECT, JdtmmPackage.JDT_JAVA_PROJECT__JAVA_MODEL);
		}
		return javaProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case JdtmmPackage.JDT_JAVA_MODEL__JAVA_PROJECT:
			return ((InternalEList<InternalEObject>)(InternalEList<?>)getJavaProject()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case JdtmmPackage.JDT_JAVA_MODEL__JAVA_PROJECT:
			return ((InternalEList<?>)getJavaProject()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case JdtmmPackage.JDT_JAVA_MODEL__JAVA_PROJECT:
			return getJavaProject();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case JdtmmPackage.JDT_JAVA_MODEL__JAVA_PROJECT:
			getJavaProject().clear();
			getJavaProject().addAll((Collection<? extends JDTJavaProject>)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case JdtmmPackage.JDT_JAVA_MODEL__JAVA_PROJECT:
			getJavaProject().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case JdtmmPackage.JDT_JAVA_MODEL__JAVA_PROJECT:
			return javaProject != null && !javaProject.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //JDTJavaModelImpl
