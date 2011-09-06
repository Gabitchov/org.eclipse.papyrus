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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParent;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage;

import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitor;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitorException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JDT Java Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTJavaElementImpl#getParent <em>Parent</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTJavaElementImpl#getElementName <em>Element Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTJavaElementImpl#getElementType <em>Element Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTJavaElementImpl#getComment <em>Comment</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTJavaElementImpl#isGenerated <em>Generated</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class JDTJavaElementImpl extends EObjectImpl implements JDTJavaElement {

	/**
	 * The default value of the '{@link #getElementName() <em>Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getElementName()
	 * @generated
	 * @ordered
	 */
	protected static final String ELEMENT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElementName() <em>Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getElementName()
	 * @generated
	 * @ordered
	 */
	protected String elementName = ELEMENT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getElementType() <em>Element Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getElementType()
	 * @generated
	 * @ordered
	 */
	protected static final int ELEMENT_TYPE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getElementType() <em>Element Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getElementType()
	 * @generated
	 * @ordered
	 */
	protected int elementType = ELEMENT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected String comment = COMMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #isGenerated() <em>Generated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isGenerated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GENERATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isGenerated() <em>Generated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isGenerated()
	 * @generated
	 * @ordered
	 */
	protected boolean generated = GENERATED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected JDTJavaElementImpl() {
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
		return JdtmmPackage.Literals.JDT_JAVA_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JDTParent getParent() {
		JDTParent parent = basicGetParent();
		return parent != null && parent.eIsProxy() ? (JDTParent)eResolveProxy((InternalEObject)parent) : parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JDTParent basicGetParent() {
		// TODO: implement this method to return the 'Parent' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getElementName() {
		return elementName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setElementName(String newElementName) {
		String oldElementName = elementName;
		elementName = newElementName;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_JAVA_ELEMENT__ELEMENT_NAME, oldElementName, elementName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getElementType() {
		return elementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setElementType(int newElementType) {
		int oldElementType = elementType;
		elementType = newElementType;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_JAVA_ELEMENT__ELEMENT_TYPE, oldElementType, elementType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setComment(String newComment) {
		String oldComment = comment;
		comment = newComment;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_JAVA_ELEMENT__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isGenerated() {
		return generated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setGenerated(boolean newGenerated) {
		boolean oldGenerated = generated;
		generated = newGenerated;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_JAVA_ELEMENT__GENERATED, oldGenerated, generated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated not
	 */
	public String getQualifiedName() {
		return getElementName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @throws JDTVisitorException
	 * @generated NOT
	 */
	public void accept(JDTVisitor visitor) throws JDTVisitorException {
		visitor.visit(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getJDTSignature() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
		case JdtmmPackage.JDT_JAVA_ELEMENT__PARENT:
			if(resolve)
				return getParent();
			return basicGetParent();
		case JdtmmPackage.JDT_JAVA_ELEMENT__ELEMENT_NAME:
			return getElementName();
		case JdtmmPackage.JDT_JAVA_ELEMENT__ELEMENT_TYPE:
			return getElementType();
		case JdtmmPackage.JDT_JAVA_ELEMENT__COMMENT:
			return getComment();
		case JdtmmPackage.JDT_JAVA_ELEMENT__GENERATED:
			return isGenerated();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case JdtmmPackage.JDT_JAVA_ELEMENT__ELEMENT_NAME:
			setElementName((String)newValue);
			return;
		case JdtmmPackage.JDT_JAVA_ELEMENT__ELEMENT_TYPE:
			setElementType((Integer)newValue);
			return;
		case JdtmmPackage.JDT_JAVA_ELEMENT__COMMENT:
			setComment((String)newValue);
			return;
		case JdtmmPackage.JDT_JAVA_ELEMENT__GENERATED:
			setGenerated((Boolean)newValue);
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
		case JdtmmPackage.JDT_JAVA_ELEMENT__ELEMENT_NAME:
			setElementName(ELEMENT_NAME_EDEFAULT);
			return;
		case JdtmmPackage.JDT_JAVA_ELEMENT__ELEMENT_TYPE:
			setElementType(ELEMENT_TYPE_EDEFAULT);
			return;
		case JdtmmPackage.JDT_JAVA_ELEMENT__COMMENT:
			setComment(COMMENT_EDEFAULT);
			return;
		case JdtmmPackage.JDT_JAVA_ELEMENT__GENERATED:
			setGenerated(GENERATED_EDEFAULT);
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
		case JdtmmPackage.JDT_JAVA_ELEMENT__PARENT:
			return basicGetParent() != null;
		case JdtmmPackage.JDT_JAVA_ELEMENT__ELEMENT_NAME:
			return ELEMENT_NAME_EDEFAULT == null ? elementName != null : !ELEMENT_NAME_EDEFAULT.equals(elementName);
		case JdtmmPackage.JDT_JAVA_ELEMENT__ELEMENT_TYPE:
			return elementType != ELEMENT_TYPE_EDEFAULT;
		case JdtmmPackage.JDT_JAVA_ELEMENT__COMMENT:
			return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
		case JdtmmPackage.JDT_JAVA_ELEMENT__GENERATED:
			return generated != GENERATED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if(eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (elementName: ");
		result.append(elementName);
		result.append(", elementType: ");
		result.append(elementType);
		result.append(", comment: ");
		result.append(comment);
		result.append(", generated: ");
		result.append(generated);
		result.append(')');
		return result.toString();
	}

} //JDTJavaElementImpl
