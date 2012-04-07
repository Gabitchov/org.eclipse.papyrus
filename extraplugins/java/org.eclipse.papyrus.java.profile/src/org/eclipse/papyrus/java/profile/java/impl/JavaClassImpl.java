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
import org.eclipse.papyrus.java.profile.java.JavaClass;
import org.eclipse.papyrus.java.profile.java.JavaPackage;

import org.eclipse.uml2.uml.Classifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaClassImpl#getBase_Classifier <em>Base Classifier</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaClassImpl#isFinal <em>Is Final</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaClassImpl#isAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaClassImpl#isStatic <em>Is Static</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaClassImpl#getExplicitPlainTextRequiredImports <em>Explicit Plain Text Required Imports</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaClassImpl#getExplicitRequiredImports <em>Explicit Required Imports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JavaClassImpl extends JavaGenImpl implements JavaClass {
	/**
	 * The cached value of the '{@link #getBase_Classifier() <em>Base Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Classifier()
	 * @generated
	 * @ordered
	 */
	protected Classifier base_Classifier;

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
	protected JavaClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavaPackage.Literals.JAVA_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier getBase_Classifier() {
		if (base_Classifier != null && base_Classifier.eIsProxy()) {
			InternalEObject oldBase_Classifier = (InternalEObject)base_Classifier;
			base_Classifier = (Classifier)eResolveProxy(oldBase_Classifier);
			if (base_Classifier != oldBase_Classifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JavaPackage.JAVA_CLASS__BASE_CLASSIFIER, oldBase_Classifier, base_Classifier));
			}
		}
		return base_Classifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier basicGetBase_Classifier() {
		return base_Classifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Classifier(Classifier newBase_Classifier) {
		Classifier oldBase_Classifier = base_Classifier;
		base_Classifier = newBase_Classifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JAVA_CLASS__BASE_CLASSIFIER, oldBase_Classifier, base_Classifier));
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
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JAVA_CLASS__IS_FINAL, oldIsFinal, isFinal));
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
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JAVA_CLASS__IS_ABSTRACT, oldIsAbstract, isAbstract));
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
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JAVA_CLASS__IS_STATIC, oldIsStatic, isStatic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getExplicitPlainTextRequiredImports() {
		if (explicitPlainTextRequiredImports == null) {
			explicitPlainTextRequiredImports = new EDataTypeEList<String>(String.class, this, JavaPackage.JAVA_CLASS__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS);
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
			explicitRequiredImports = new EObjectResolvingEList<Classifier>(Classifier.class, this, JavaPackage.JAVA_CLASS__EXPLICIT_REQUIRED_IMPORTS);
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
			case JavaPackage.JAVA_CLASS__BASE_CLASSIFIER:
				if (resolve) return getBase_Classifier();
				return basicGetBase_Classifier();
			case JavaPackage.JAVA_CLASS__IS_FINAL:
				return isFinal();
			case JavaPackage.JAVA_CLASS__IS_ABSTRACT:
				return isAbstract();
			case JavaPackage.JAVA_CLASS__IS_STATIC:
				return isStatic();
			case JavaPackage.JAVA_CLASS__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS:
				return getExplicitPlainTextRequiredImports();
			case JavaPackage.JAVA_CLASS__EXPLICIT_REQUIRED_IMPORTS:
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
			case JavaPackage.JAVA_CLASS__BASE_CLASSIFIER:
				setBase_Classifier((Classifier)newValue);
				return;
			case JavaPackage.JAVA_CLASS__IS_FINAL:
				setIsFinal((Boolean)newValue);
				return;
			case JavaPackage.JAVA_CLASS__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case JavaPackage.JAVA_CLASS__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case JavaPackage.JAVA_CLASS__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS:
				getExplicitPlainTextRequiredImports().clear();
				getExplicitPlainTextRequiredImports().addAll((Collection<? extends String>)newValue);
				return;
			case JavaPackage.JAVA_CLASS__EXPLICIT_REQUIRED_IMPORTS:
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
			case JavaPackage.JAVA_CLASS__BASE_CLASSIFIER:
				setBase_Classifier((Classifier)null);
				return;
			case JavaPackage.JAVA_CLASS__IS_FINAL:
				setIsFinal(IS_FINAL_EDEFAULT);
				return;
			case JavaPackage.JAVA_CLASS__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case JavaPackage.JAVA_CLASS__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case JavaPackage.JAVA_CLASS__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS:
				getExplicitPlainTextRequiredImports().clear();
				return;
			case JavaPackage.JAVA_CLASS__EXPLICIT_REQUIRED_IMPORTS:
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
			case JavaPackage.JAVA_CLASS__BASE_CLASSIFIER:
				return base_Classifier != null;
			case JavaPackage.JAVA_CLASS__IS_FINAL:
				return isFinal != IS_FINAL_EDEFAULT;
			case JavaPackage.JAVA_CLASS__IS_ABSTRACT:
				return isAbstract != IS_ABSTRACT_EDEFAULT;
			case JavaPackage.JAVA_CLASS__IS_STATIC:
				return isStatic != IS_STATIC_EDEFAULT;
			case JavaPackage.JAVA_CLASS__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS:
				return explicitPlainTextRequiredImports != null && !explicitPlainTextRequiredImports.isEmpty();
			case JavaPackage.JAVA_CLASS__EXPLICIT_REQUIRED_IMPORTS:
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
		result.append(" (isFinal: ");
		result.append(isFinal);
		result.append(", isAbstract: ");
		result.append(isAbstract);
		result.append(", isStatic: ");
		result.append(isStatic);
		result.append(", explicitPlainTextRequiredImports: ");
		result.append(explicitPlainTextRequiredImports);
		result.append(')');
		return result.toString();
	}

} //JavaClassImpl
