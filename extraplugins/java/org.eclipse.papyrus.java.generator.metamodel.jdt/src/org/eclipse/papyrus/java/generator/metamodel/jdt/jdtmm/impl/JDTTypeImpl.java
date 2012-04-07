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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.NotifyingList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.Signature;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTCompilationUnit;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParent;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage;
import org.eclipse.papyrus.java.generator.metamodel.jdt.utils.DerivedNotifyingEList;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.eclipse.uml2.common.util.SubsetSupersetEObjectContainmentWithInverseEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JDT Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeImpl#getMethods <em>Methods</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeImpl#getFields <em>Fields</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeImpl#getCompilationUnit <em>Compilation Unit</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeImpl#isClass <em>Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeImpl#isInterface <em>Interface</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeImpl#isEnum <em>Enum</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeImpl#isFinal <em>Final</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeImpl#isStatic <em>Static</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeImpl#getSuperInterfaces <em>Super Interfaces</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeImpl#getSuperClass <em>Super Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeImpl#getSuperInterfaceNames <em>Super Interface Names</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeImpl#getSuperClassName <em>Super Class Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class JDTTypeImpl extends JDTMemberImpl implements JDTType {

	/**
	 * The cached value of the '{@link #getMethods() <em>Methods</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethods()
	 * @generated
	 * @ordered
	 */
	protected EList<JDTMethod> methods;

	/**
	 * The cached value of the '{@link #getFields() <em>Fields</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFields()
	 * @generated
	 * @ordered
	 */
	protected EList<JDTField> fields;

	/**
	 * The default value of the '{@link #isClass() <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClass()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CLASS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isClass() <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClass()
	 * @generated
	 * @ordered
	 */
	protected boolean class_ = CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #isInterface() <em>Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInterface()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INTERFACE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInterface() <em>Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInterface()
	 * @generated
	 * @ordered
	 */
	protected boolean interface_ = INTERFACE_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnum() <em>Enum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnum()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENUM_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnum() <em>Enum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnum()
	 * @generated
	 * @ordered
	 */
	protected boolean enum_ = ENUM_EDEFAULT;

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
	 * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<JDTType> types;

	/**
	 * The cached value of the '{@link #getSuperInterfaces() <em>Super Interfaces</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList<JDTType> superInterfaces;

	/**
	 * The cached value of the '{@link #getSuperClass() <em>Super Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperClass()
	 * @generated
	 * @ordered
	 */
	protected JDTType superClass;

	/**
	 * The default value of the '{@link #getSuperClassName() <em>Super Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String SUPER_CLASS_NAME_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JDTTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JdtmmPackage.Literals.JDT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<JDTJavaElement> getChildren() {
		return new DerivedUnionEObjectEList<JDTJavaElement>(JDTJavaElement.class, this, JdtmmPackage.JDT_TYPE__CHILDREN, CHILDREN_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getChildren() <em>Children</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected static final int[] CHILDREN_ESUBSETS = new int[] {JdtmmPackage.JDT_TYPE__METHODS, JdtmmPackage.JDT_TYPE__FIELDS, JdtmmPackage.JDT_TYPE__TYPES};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JDTMethod> getMethods() {
		if (methods == null) {
			methods = new SubsetSupersetEObjectContainmentWithInverseEList<JDTMethod>(JDTMethod.class, this, JdtmmPackage.JDT_TYPE__METHODS, METHODS_ESUPERSETS, null, JdtmmPackage.JDT_METHOD__OWNER);
		}
		return methods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JDTCompilationUnit getCompilationUnit() {
		if (eContainerFeatureID() != JdtmmPackage.JDT_TYPE__COMPILATION_UNIT) return null;
		return (JDTCompilationUnit)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCompilationUnit(JDTCompilationUnit newCompilationUnit, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCompilationUnit, JdtmmPackage.JDT_TYPE__COMPILATION_UNIT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompilationUnit(JDTCompilationUnit newCompilationUnit) {
		if (newCompilationUnit != eInternalContainer() || (eContainerFeatureID() != JdtmmPackage.JDT_TYPE__COMPILATION_UNIT && newCompilationUnit != null)) {
			if (EcoreUtil.isAncestor(this, newCompilationUnit))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCompilationUnit != null)
				msgs = ((InternalEObject)newCompilationUnit).eInverseAdd(this, JdtmmPackage.JDT_COMPILATION_UNIT__TYPES, JDTCompilationUnit.class, msgs);
			msgs = basicSetCompilationUnit(newCompilationUnit, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_TYPE__COMPILATION_UNIT, newCompilationUnit, newCompilationUnit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCompilationUnit() {
		return getCompilationUnit() != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isClass() {
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass_(boolean newClass) {
		boolean oldClass = class_;
		class_ = newClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_TYPE__CLASS, oldClass, class_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInterface() {
		return interface_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterface(boolean newInterface) {
		boolean oldInterface = interface_;
		interface_ = newInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_TYPE__INTERFACE, oldInterface, interface_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnum() {
		return enum_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnum(boolean newEnum) {
		boolean oldEnum = enum_;
		enum_ = newEnum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_TYPE__ENUM, oldEnum, enum_));
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
	public boolean isFinal() {
		// TODO: implement this method to return the 'Final' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		return isFlagSet(Flags.AccFinal);
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
	public boolean isStatic() {
		return isFlagSet(Flags.AccStatic);
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JDTType> getTypes() {
		if (types == null) {
			types = new SubsetSupersetEObjectContainmentWithInverseEList<JDTType>(JDTType.class, this, JdtmmPackage.JDT_TYPE__TYPES, TYPES_ESUPERSETS, null, JdtmmPackage.JDT_TYPE__OWNER);
		}
		return types;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JDTType getOwner() {
		if (eContainerFeatureID() != JdtmmPackage.JDT_TYPE__OWNER) return null;
		return (JDTType)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(JDTType newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, JdtmmPackage.JDT_TYPE__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(JDTType newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != JdtmmPackage.JDT_TYPE__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, JdtmmPackage.JDT_TYPE__TYPES, JDTType.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_TYPE__OWNER, newOwner, newOwner));
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
	public EList<JDTType> getSuperInterfaces() {
		if (superInterfaces == null) {
			superInterfaces = new EObjectResolvingEList<JDTType>(JDTType.class, this, JdtmmPackage.JDT_TYPE__SUPER_INTERFACES);
		}
		return superInterfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JDTType getSuperClass() {
		if (superClass != null && superClass.eIsProxy()) {
			InternalEObject oldSuperClass = (InternalEObject)superClass;
			superClass = (JDTType)eResolveProxy(oldSuperClass);
			if (superClass != oldSuperClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JdtmmPackage.JDT_TYPE__SUPER_CLASS, oldSuperClass, superClass));
			}
		}
		return superClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JDTType basicGetSuperClass() {
		return superClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperClass(JDTType newSuperClass) {
		JDTType oldSuperClass = superClass;
		superClass = newSuperClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_TYPE__SUPER_CLASS, oldSuperClass, superClass));
	}


	DerivedNotifyingEList<String, JDTType> superInterfaceNames;

	/**
	 * Returns the names of interfaces that this type implements or extends,
	 * in the order in which they are listed in the source.
	 * <p>
	 * For classes, this gives the interfaces that this class implements. For interfaces, this gives the interfaces that this interface extends. An
	 * empty collection is returned if this type does not implement or extend any interfaces. * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<String> getSuperInterfaceNames() {
		// TODO: implement this method to return the 'Super Interface Names' attribute list
		// Ensure that you remove @generated or mark it @generated NOT

		// Return empty collection if there is nothing
		if(getSuperInterfaces().size() == 0)
			return ECollections.emptyEList();

		if(superInterfaceNames == null) {
			// Create a derived list that return the names instead of the original elements.
			superInterfaceNames = new DerivedNotifyingEList<String, JDTType>((NotifyingList<JDTType>)getSuperInterfaces()) {

				/**
				 * Return the name of the JDTtype.
				 */
				@Override
				protected String doGet(int index) {
					return getBackupList().get(index).getElementName();
				}
			};
		}

		return superInterfaceNames;
	}



	/**
	 * Returns the name of this type's superclass, or <code>null</code> for source types that do not specify a superclass.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String getSuperClassName() {
		// TODO: implement this method to return the 'Super Class Name' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		if(getSuperClass() != null) {
			return getSuperClass().getElementName();
		}
		// No superclass
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JDTField> getFields() {
		if (fields == null) {
			fields = new SubsetSupersetEObjectContainmentWithInverseEList<JDTField>(JDTField.class, this, JdtmmPackage.JDT_TYPE__FIELDS, FIELDS_ESUPERSETS, null, JdtmmPackage.JDT_FIELD__OWNER);
		}
		return fields;
	}

	/**
	 * The array of superset feature identifiers for the '{@link #getMethods() <em>Methods</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethods()
	 * @generated
	 * @ordered
	 */
	protected static final int[] METHODS_ESUPERSETS = new int[] {JdtmmPackage.JDT_TYPE__CHILDREN};

	/**
	 * The array of superset feature identifiers for the '{@link #getFields() <em>Fields</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFields()
	 * @generated
	 * @ordered
	 */
	protected static final int[] FIELDS_ESUPERSETS = new int[] {JdtmmPackage.JDT_TYPE__CHILDREN};

	/**
	 * The array of superset feature identifiers for the '{@link #getTypes() <em>Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected static final int[] TYPES_ESUPERSETS = new int[] {JdtmmPackage.JDT_TYPE__CHILDREN};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JdtmmPackage.JDT_TYPE__METHODS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMethods()).basicAdd(otherEnd, msgs);
			case JdtmmPackage.JDT_TYPE__FIELDS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFields()).basicAdd(otherEnd, msgs);
			case JdtmmPackage.JDT_TYPE__COMPILATION_UNIT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCompilationUnit((JDTCompilationUnit)otherEnd, msgs);
			case JdtmmPackage.JDT_TYPE__TYPES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTypes()).basicAdd(otherEnd, msgs);
			case JdtmmPackage.JDT_TYPE__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((JDTType)otherEnd, msgs);
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
			case JdtmmPackage.JDT_TYPE__METHODS:
				return ((InternalEList<?>)getMethods()).basicRemove(otherEnd, msgs);
			case JdtmmPackage.JDT_TYPE__FIELDS:
				return ((InternalEList<?>)getFields()).basicRemove(otherEnd, msgs);
			case JdtmmPackage.JDT_TYPE__COMPILATION_UNIT:
				return basicSetCompilationUnit(null, msgs);
			case JdtmmPackage.JDT_TYPE__TYPES:
				return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
			case JdtmmPackage.JDT_TYPE__OWNER:
				return basicSetOwner(null, msgs);
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
			case JdtmmPackage.JDT_TYPE__COMPILATION_UNIT:
				return eInternalContainer().eInverseRemove(this, JdtmmPackage.JDT_COMPILATION_UNIT__TYPES, JDTCompilationUnit.class, msgs);
			case JdtmmPackage.JDT_TYPE__OWNER:
				return eInternalContainer().eInverseRemove(this, JdtmmPackage.JDT_TYPE__TYPES, JDTType.class, msgs);
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
			case JdtmmPackage.JDT_TYPE__METHODS:
				return getMethods();
			case JdtmmPackage.JDT_TYPE__FIELDS:
				return getFields();
			case JdtmmPackage.JDT_TYPE__COMPILATION_UNIT:
				return getCompilationUnit();
			case JdtmmPackage.JDT_TYPE__CLASS:
				return isClass();
			case JdtmmPackage.JDT_TYPE__INTERFACE:
				return isInterface();
			case JdtmmPackage.JDT_TYPE__ENUM:
				return isEnum();
			case JdtmmPackage.JDT_TYPE__ABSTRACT:
				return isAbstract();
			case JdtmmPackage.JDT_TYPE__FINAL:
				return isFinal();
			case JdtmmPackage.JDT_TYPE__STATIC:
				return isStatic();
			case JdtmmPackage.JDT_TYPE__TYPES:
				return getTypes();
			case JdtmmPackage.JDT_TYPE__OWNER:
				return getOwner();
			case JdtmmPackage.JDT_TYPE__SUPER_INTERFACES:
				return getSuperInterfaces();
			case JdtmmPackage.JDT_TYPE__SUPER_CLASS:
				if (resolve) return getSuperClass();
				return basicGetSuperClass();
			case JdtmmPackage.JDT_TYPE__SUPER_INTERFACE_NAMES:
				return getSuperInterfaceNames();
			case JdtmmPackage.JDT_TYPE__SUPER_CLASS_NAME:
				return getSuperClassName();
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
			case JdtmmPackage.JDT_TYPE__METHODS:
				getMethods().clear();
				getMethods().addAll((Collection<? extends JDTMethod>)newValue);
				return;
			case JdtmmPackage.JDT_TYPE__FIELDS:
				getFields().clear();
				getFields().addAll((Collection<? extends JDTField>)newValue);
				return;
			case JdtmmPackage.JDT_TYPE__COMPILATION_UNIT:
				setCompilationUnit((JDTCompilationUnit)newValue);
				return;
			case JdtmmPackage.JDT_TYPE__CLASS:
				setClass_((Boolean)newValue);
				return;
			case JdtmmPackage.JDT_TYPE__INTERFACE:
				setInterface((Boolean)newValue);
				return;
			case JdtmmPackage.JDT_TYPE__ENUM:
				setEnum((Boolean)newValue);
				return;
			case JdtmmPackage.JDT_TYPE__ABSTRACT:
				setAbstract((Boolean)newValue);
				return;
			case JdtmmPackage.JDT_TYPE__FINAL:
				setFinal((Boolean)newValue);
				return;
			case JdtmmPackage.JDT_TYPE__STATIC:
				setStatic((Boolean)newValue);
				return;
			case JdtmmPackage.JDT_TYPE__TYPES:
				getTypes().clear();
				getTypes().addAll((Collection<? extends JDTType>)newValue);
				return;
			case JdtmmPackage.JDT_TYPE__OWNER:
				setOwner((JDTType)newValue);
				return;
			case JdtmmPackage.JDT_TYPE__SUPER_INTERFACES:
				getSuperInterfaces().clear();
				getSuperInterfaces().addAll((Collection<? extends JDTType>)newValue);
				return;
			case JdtmmPackage.JDT_TYPE__SUPER_CLASS:
				setSuperClass((JDTType)newValue);
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
			case JdtmmPackage.JDT_TYPE__METHODS:
				getMethods().clear();
				return;
			case JdtmmPackage.JDT_TYPE__FIELDS:
				getFields().clear();
				return;
			case JdtmmPackage.JDT_TYPE__COMPILATION_UNIT:
				setCompilationUnit((JDTCompilationUnit)null);
				return;
			case JdtmmPackage.JDT_TYPE__CLASS:
				setClass_(CLASS_EDEFAULT);
				return;
			case JdtmmPackage.JDT_TYPE__INTERFACE:
				setInterface(INTERFACE_EDEFAULT);
				return;
			case JdtmmPackage.JDT_TYPE__ENUM:
				setEnum(ENUM_EDEFAULT);
				return;
			case JdtmmPackage.JDT_TYPE__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case JdtmmPackage.JDT_TYPE__FINAL:
				setFinal(FINAL_EDEFAULT);
				return;
			case JdtmmPackage.JDT_TYPE__STATIC:
				setStatic(STATIC_EDEFAULT);
				return;
			case JdtmmPackage.JDT_TYPE__TYPES:
				getTypes().clear();
				return;
			case JdtmmPackage.JDT_TYPE__OWNER:
				setOwner((JDTType)null);
				return;
			case JdtmmPackage.JDT_TYPE__SUPER_INTERFACES:
				getSuperInterfaces().clear();
				return;
			case JdtmmPackage.JDT_TYPE__SUPER_CLASS:
				setSuperClass((JDTType)null);
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
			case JdtmmPackage.JDT_TYPE__METHODS:
				return methods != null && !methods.isEmpty();
			case JdtmmPackage.JDT_TYPE__FIELDS:
				return fields != null && !fields.isEmpty();
			case JdtmmPackage.JDT_TYPE__COMPILATION_UNIT:
				return isSetCompilationUnit();
			case JdtmmPackage.JDT_TYPE__CLASS:
				return class_ != CLASS_EDEFAULT;
			case JdtmmPackage.JDT_TYPE__INTERFACE:
				return interface_ != INTERFACE_EDEFAULT;
			case JdtmmPackage.JDT_TYPE__ENUM:
				return enum_ != ENUM_EDEFAULT;
			case JdtmmPackage.JDT_TYPE__ABSTRACT:
				return isAbstract() != ABSTRACT_EDEFAULT;
			case JdtmmPackage.JDT_TYPE__FINAL:
				return isFinal() != FINAL_EDEFAULT;
			case JdtmmPackage.JDT_TYPE__STATIC:
				return isStatic() != STATIC_EDEFAULT;
			case JdtmmPackage.JDT_TYPE__TYPES:
				return types != null && !types.isEmpty();
			case JdtmmPackage.JDT_TYPE__OWNER:
				return isSetOwner();
			case JdtmmPackage.JDT_TYPE__SUPER_INTERFACES:
				return superInterfaces != null && !superInterfaces.isEmpty();
			case JdtmmPackage.JDT_TYPE__SUPER_CLASS:
				return superClass != null;
			case JdtmmPackage.JDT_TYPE__SUPER_INTERFACE_NAMES:
				return !getSuperInterfaceNames().isEmpty();
			case JdtmmPackage.JDT_TYPE__SUPER_CLASS_NAME:
				return SUPER_CLASS_NAME_EDEFAULT == null ? getSuperClassName() != null : !SUPER_CLASS_NAME_EDEFAULT.equals(getSuperClassName());
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
		result.append(" (class: ");
		result.append(class_);
		result.append(", interface: ");
		result.append(interface_);
		result.append(", enum: ");
		result.append(enum_);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetChildren() {
		return super.isSetChildren()
			|| eIsSet(JdtmmPackage.JDT_TYPE__METHODS)
			|| eIsSet(JdtmmPackage.JDT_TYPE__FIELDS)
			|| eIsSet(JdtmmPackage.JDT_TYPE__TYPES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JDTParent getParent() {
		return getCompilationUnit();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JDTParent basicGetParent() {
		return getCompilationUnit();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetParent() {
  		return false;
	}

	@Override
	public String getJDTSignature() {
		return Signature.createTypeSignature(getElementName(), false);
	}

	@Override
	public String getQualifiedName() {
		// if it's a intern class, it's special
		if(getOwner() != null)
			return getOwner().getQualifiedName() + "." + getElementName();

		// else, return the qualified name of the package + "." + the name of the type
		if(getCompilationUnit().getPackageFragment() == null)
			return getElementName();
		if(getCompilationUnit().getPackageFragment().getQualifiedName() == null)
			return getElementName();
		return getCompilationUnit().getPackageFragment().getQualifiedName() + "." + getElementName();
	}
} //JDTTypeImpl
