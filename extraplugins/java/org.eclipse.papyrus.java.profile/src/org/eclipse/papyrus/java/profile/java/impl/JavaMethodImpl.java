/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.java.profile.java.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.java.profile.java.JavaMethod;
import org.eclipse.papyrus.java.profile.java.JavaPackage;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Operation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaMethodImpl#isStatic <em>Is Static</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaMethodImpl#isFinal <em>Is Final</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaMethodImpl#isAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaMethodImpl#isNative <em>Is Native</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaMethodImpl#isSynchronized <em>Is Synchronized</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaMethodImpl#isConstructor <em>Is Constructor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaMethodImpl#getBase_Operation <em>Base Operation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaMethodImpl#getExplicitPlainTextRequiredImports <em>Explicit Plain Text Required Imports</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaMethodImpl#getExplicitRequiredImports <em>Explicit Required Imports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JavaMethodImpl extends JavaNamedElementImpl implements JavaMethod {
	/**
	 * The default value of the '{@link #isStatic() <em>Is Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStatic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_STATIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStatic() <em>Is Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStatic()
	 * @generated
	 * @ordered
	 */
	protected boolean isStatic = IS_STATIC_EDEFAULT;

	/**
	 * The default value of the '{@link #isFinal() <em>Is Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFinal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_FINAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFinal() <em>Is Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFinal()
	 * @generated
	 * @ordered
	 */
	protected boolean isFinal = IS_FINAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean isAbstract = IS_ABSTRACT_EDEFAULT;

	/**
	 * The default value of the '{@link #isNative() <em>Is Native</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNative()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_NATIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNative() <em>Is Native</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNative()
	 * @generated
	 * @ordered
	 */
	protected boolean isNative = IS_NATIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #isSynchronized() <em>Is Synchronized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSynchronized()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_SYNCHRONIZED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSynchronized() <em>Is Synchronized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSynchronized()
	 * @generated
	 * @ordered
	 */
	protected boolean isSynchronized = IS_SYNCHRONIZED_EDEFAULT;

	/**
	 * The default value of the '{@link #isConstructor() <em>Is Constructor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConstructor()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CONSTRUCTOR_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isConstructor() <em>Is Constructor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConstructor()
	 * @generated
	 * @ordered
	 */
	protected boolean isConstructor = IS_CONSTRUCTOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_Operation() <em>Base Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Operation()
	 * @generated
	 * @ordered
	 */
	protected Operation base_Operation;

	/**
	 * The cached value of the '{@link #getExplicitPlainTextRequiredImports() <em>Explicit Plain Text Required Imports</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExplicitPlainTextRequiredImports()
	 * @generated
	 * @ordered
	 */
	protected EList<String> explicitPlainTextRequiredImports;

	/**
	 * The cached value of the '{@link #getExplicitRequiredImports() <em>Explicit Required Imports</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExplicitRequiredImports()
	 * @generated
	 * @ordered
	 */
	protected EList<Classifier> explicitRequiredImports;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JavaMethodImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavaPackage.Literals.JAVA_METHOD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStatic() {
		return isStatic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsStatic(boolean newIsStatic) {
		boolean oldIsStatic = isStatic;
		isStatic = newIsStatic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JAVA_METHOD__IS_STATIC, oldIsStatic, isStatic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFinal() {
		return isFinal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsFinal(boolean newIsFinal) {
		boolean oldIsFinal = isFinal;
		isFinal = newIsFinal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JAVA_METHOD__IS_FINAL, oldIsFinal, isFinal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstract() {
		return isAbstract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAbstract(boolean newIsAbstract) {
		boolean oldIsAbstract = isAbstract;
		isAbstract = newIsAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JAVA_METHOD__IS_ABSTRACT, oldIsAbstract, isAbstract));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNative() {
		return isNative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsNative(boolean newIsNative) {
		boolean oldIsNative = isNative;
		isNative = newIsNative;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JAVA_METHOD__IS_NATIVE, oldIsNative, isNative));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSynchronized() {
		return isSynchronized;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSynchronized(boolean newIsSynchronized) {
		boolean oldIsSynchronized = isSynchronized;
		isSynchronized = newIsSynchronized;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JAVA_METHOD__IS_SYNCHRONIZED, oldIsSynchronized, isSynchronized));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isConstructor() {
		return isConstructor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsConstructor(boolean newIsConstructor) {
		boolean oldIsConstructor = isConstructor;
		isConstructor = newIsConstructor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JAVA_METHOD__IS_CONSTRUCTOR, oldIsConstructor, isConstructor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getBase_Operation() {
		if (base_Operation != null && base_Operation.eIsProxy()) {
			InternalEObject oldBase_Operation = (InternalEObject)base_Operation;
			base_Operation = (Operation)eResolveProxy(oldBase_Operation);
			if (base_Operation != oldBase_Operation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JavaPackage.JAVA_METHOD__BASE_OPERATION, oldBase_Operation, base_Operation));
			}
		}
		return base_Operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetBase_Operation() {
		return base_Operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Operation(Operation newBase_Operation) {
		Operation oldBase_Operation = base_Operation;
		base_Operation = newBase_Operation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JAVA_METHOD__BASE_OPERATION, oldBase_Operation, base_Operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getExplicitPlainTextRequiredImports() {
		if (explicitPlainTextRequiredImports == null) {
			explicitPlainTextRequiredImports = new EDataTypeEList<String>(String.class, this, JavaPackage.JAVA_METHOD__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS);
		}
		return explicitPlainTextRequiredImports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Classifier> getExplicitRequiredImports() {
		if (explicitRequiredImports == null) {
			explicitRequiredImports = new EObjectResolvingEList<Classifier>(Classifier.class, this, JavaPackage.JAVA_METHOD__EXPLICIT_REQUIRED_IMPORTS);
		}
		return explicitRequiredImports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier getExplicitRequiredImports(String name) {
		return getExplicitRequiredImports(name, false, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier getExplicitRequiredImports(String name, boolean ignoreCase, EClass eClass) {
		explicitRequiredImportsLoop: for (Classifier explicitRequiredImports : getExplicitRequiredImports()) {
			if (eClass != null && !eClass.isInstance(explicitRequiredImports))
				continue explicitRequiredImportsLoop;
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(explicitRequiredImports.getName()) : name.equals(explicitRequiredImports.getName())))
				continue explicitRequiredImportsLoop;
			return explicitRequiredImports;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JavaPackage.JAVA_METHOD__IS_STATIC:
				return isStatic();
			case JavaPackage.JAVA_METHOD__IS_FINAL:
				return isFinal();
			case JavaPackage.JAVA_METHOD__IS_ABSTRACT:
				return isAbstract();
			case JavaPackage.JAVA_METHOD__IS_NATIVE:
				return isNative();
			case JavaPackage.JAVA_METHOD__IS_SYNCHRONIZED:
				return isSynchronized();
			case JavaPackage.JAVA_METHOD__IS_CONSTRUCTOR:
				return isConstructor();
			case JavaPackage.JAVA_METHOD__BASE_OPERATION:
				if (resolve) return getBase_Operation();
				return basicGetBase_Operation();
			case JavaPackage.JAVA_METHOD__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS:
				return getExplicitPlainTextRequiredImports();
			case JavaPackage.JAVA_METHOD__EXPLICIT_REQUIRED_IMPORTS:
				return getExplicitRequiredImports();
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
			case JavaPackage.JAVA_METHOD__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case JavaPackage.JAVA_METHOD__IS_FINAL:
				setIsFinal((Boolean)newValue);
				return;
			case JavaPackage.JAVA_METHOD__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case JavaPackage.JAVA_METHOD__IS_NATIVE:
				setIsNative((Boolean)newValue);
				return;
			case JavaPackage.JAVA_METHOD__IS_SYNCHRONIZED:
				setIsSynchronized((Boolean)newValue);
				return;
			case JavaPackage.JAVA_METHOD__IS_CONSTRUCTOR:
				setIsConstructor((Boolean)newValue);
				return;
			case JavaPackage.JAVA_METHOD__BASE_OPERATION:
				setBase_Operation((Operation)newValue);
				return;
			case JavaPackage.JAVA_METHOD__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS:
				getExplicitPlainTextRequiredImports().clear();
				getExplicitPlainTextRequiredImports().addAll((Collection<? extends String>)newValue);
				return;
			case JavaPackage.JAVA_METHOD__EXPLICIT_REQUIRED_IMPORTS:
				getExplicitRequiredImports().clear();
				getExplicitRequiredImports().addAll((Collection<? extends Classifier>)newValue);
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
			case JavaPackage.JAVA_METHOD__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case JavaPackage.JAVA_METHOD__IS_FINAL:
				setIsFinal(IS_FINAL_EDEFAULT);
				return;
			case JavaPackage.JAVA_METHOD__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case JavaPackage.JAVA_METHOD__IS_NATIVE:
				setIsNative(IS_NATIVE_EDEFAULT);
				return;
			case JavaPackage.JAVA_METHOD__IS_SYNCHRONIZED:
				setIsSynchronized(IS_SYNCHRONIZED_EDEFAULT);
				return;
			case JavaPackage.JAVA_METHOD__IS_CONSTRUCTOR:
				setIsConstructor(IS_CONSTRUCTOR_EDEFAULT);
				return;
			case JavaPackage.JAVA_METHOD__BASE_OPERATION:
				setBase_Operation((Operation)null);
				return;
			case JavaPackage.JAVA_METHOD__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS:
				getExplicitPlainTextRequiredImports().clear();
				return;
			case JavaPackage.JAVA_METHOD__EXPLICIT_REQUIRED_IMPORTS:
				getExplicitRequiredImports().clear();
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
			case JavaPackage.JAVA_METHOD__IS_STATIC:
				return isStatic != IS_STATIC_EDEFAULT;
			case JavaPackage.JAVA_METHOD__IS_FINAL:
				return isFinal != IS_FINAL_EDEFAULT;
			case JavaPackage.JAVA_METHOD__IS_ABSTRACT:
				return isAbstract != IS_ABSTRACT_EDEFAULT;
			case JavaPackage.JAVA_METHOD__IS_NATIVE:
				return isNative != IS_NATIVE_EDEFAULT;
			case JavaPackage.JAVA_METHOD__IS_SYNCHRONIZED:
				return isSynchronized != IS_SYNCHRONIZED_EDEFAULT;
			case JavaPackage.JAVA_METHOD__IS_CONSTRUCTOR:
				return isConstructor != IS_CONSTRUCTOR_EDEFAULT;
			case JavaPackage.JAVA_METHOD__BASE_OPERATION:
				return base_Operation != null;
			case JavaPackage.JAVA_METHOD__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS:
				return explicitPlainTextRequiredImports != null && !explicitPlainTextRequiredImports.isEmpty();
			case JavaPackage.JAVA_METHOD__EXPLICIT_REQUIRED_IMPORTS:
				return explicitRequiredImports != null && !explicitRequiredImports.isEmpty();
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
		result.append(" (isStatic: ");
		result.append(isStatic);
		result.append(", isFinal: ");
		result.append(isFinal);
		result.append(", isAbstract: ");
		result.append(isAbstract);
		result.append(", isNative: ");
		result.append(isNative);
		result.append(", isSynchronized: ");
		result.append(isSynchronized);
		result.append(", isConstructor: ");
		result.append(isConstructor);
		result.append(", explicitPlainTextRequiredImports: ");
		result.append(explicitPlainTextRequiredImports);
		result.append(')');
		return result.toString();
	}

} //JavaMethodImpl
