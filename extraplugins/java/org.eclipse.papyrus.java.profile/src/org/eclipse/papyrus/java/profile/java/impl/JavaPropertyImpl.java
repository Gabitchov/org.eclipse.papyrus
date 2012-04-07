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
import org.eclipse.papyrus.java.profile.java.JavaPackage;
import org.eclipse.papyrus.java.profile.java.JavaProperty;
import org.eclipse.papyrus.java.profile.java.TrueFalseDefault;

import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaPropertyImpl#isAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaPropertyImpl#isFinal <em>Is Final</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaPropertyImpl#getBase_Property <em>Base Property</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaPropertyImpl#isTransient <em>Is Transient</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaPropertyImpl#getGenerateGetter <em>Generate Getter</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaPropertyImpl#getGenerateSetter <em>Generate Setter</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaPropertyImpl#isStatic <em>Is Static</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaPropertyImpl#getExplicitPlainTextRequiredImports <em>Explicit Plain Text Required Imports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JavaPropertyImpl extends JavaNamedElementImpl implements JavaProperty {
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
	 * The cached value of the '{@link #getBase_Property() <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Property()
	 * @generated
	 * @ordered
	 */
	protected Property base_Property;

	/**
	 * The default value of the '{@link #isTransient() <em>Is Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransient()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_TRANSIENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTransient() <em>Is Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransient()
	 * @generated
	 * @ordered
	 */
	protected boolean isTransient = IS_TRANSIENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getGenerateGetter() <em>Generate Getter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerateGetter()
	 * @generated
	 * @ordered
	 */
	protected static final TrueFalseDefault GENERATE_GETTER_EDEFAULT = TrueFalseDefault.DEFAULT;

	/**
	 * The cached value of the '{@link #getGenerateGetter() <em>Generate Getter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerateGetter()
	 * @generated
	 * @ordered
	 */
	protected TrueFalseDefault generateGetter = GENERATE_GETTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getGenerateSetter() <em>Generate Setter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerateSetter()
	 * @generated
	 * @ordered
	 */
	protected static final TrueFalseDefault GENERATE_SETTER_EDEFAULT = TrueFalseDefault.DEFAULT;

	/**
	 * The cached value of the '{@link #getGenerateSetter() <em>Generate Setter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerateSetter()
	 * @generated
	 * @ordered
	 */
	protected TrueFalseDefault generateSetter = GENERATE_SETTER_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JavaPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavaPackage.Literals.JAVA_PROPERTY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JAVA_PROPERTY__IS_ABSTRACT, oldIsAbstract, isAbstract));
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
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JAVA_PROPERTY__IS_FINAL, oldIsFinal, isFinal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getBase_Property() {
		if (base_Property != null && base_Property.eIsProxy()) {
			InternalEObject oldBase_Property = (InternalEObject)base_Property;
			base_Property = (Property)eResolveProxy(oldBase_Property);
			if (base_Property != oldBase_Property) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JavaPackage.JAVA_PROPERTY__BASE_PROPERTY, oldBase_Property, base_Property));
			}
		}
		return base_Property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetBase_Property() {
		return base_Property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Property(Property newBase_Property) {
		Property oldBase_Property = base_Property;
		base_Property = newBase_Property;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JAVA_PROPERTY__BASE_PROPERTY, oldBase_Property, base_Property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTransient() {
		return isTransient;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsTransient(boolean newIsTransient) {
		boolean oldIsTransient = isTransient;
		isTransient = newIsTransient;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JAVA_PROPERTY__IS_TRANSIENT, oldIsTransient, isTransient));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrueFalseDefault getGenerateGetter() {
		return generateGetter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenerateGetter(TrueFalseDefault newGenerateGetter) {
		TrueFalseDefault oldGenerateGetter = generateGetter;
		generateGetter = newGenerateGetter == null ? GENERATE_GETTER_EDEFAULT : newGenerateGetter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JAVA_PROPERTY__GENERATE_GETTER, oldGenerateGetter, generateGetter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrueFalseDefault getGenerateSetter() {
		return generateSetter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenerateSetter(TrueFalseDefault newGenerateSetter) {
		TrueFalseDefault oldGenerateSetter = generateSetter;
		generateSetter = newGenerateSetter == null ? GENERATE_SETTER_EDEFAULT : newGenerateSetter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JAVA_PROPERTY__GENERATE_SETTER, oldGenerateSetter, generateSetter));
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
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JAVA_PROPERTY__IS_STATIC, oldIsStatic, isStatic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getExplicitPlainTextRequiredImports() {
		if (explicitPlainTextRequiredImports == null) {
			explicitPlainTextRequiredImports = new EDataTypeEList<String>(String.class, this, JavaPackage.JAVA_PROPERTY__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS);
		}
		return explicitPlainTextRequiredImports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JavaPackage.JAVA_PROPERTY__IS_ABSTRACT:
				return isAbstract();
			case JavaPackage.JAVA_PROPERTY__IS_FINAL:
				return isFinal();
			case JavaPackage.JAVA_PROPERTY__BASE_PROPERTY:
				if (resolve) return getBase_Property();
				return basicGetBase_Property();
			case JavaPackage.JAVA_PROPERTY__IS_TRANSIENT:
				return isTransient();
			case JavaPackage.JAVA_PROPERTY__GENERATE_GETTER:
				return getGenerateGetter();
			case JavaPackage.JAVA_PROPERTY__GENERATE_SETTER:
				return getGenerateSetter();
			case JavaPackage.JAVA_PROPERTY__IS_STATIC:
				return isStatic();
			case JavaPackage.JAVA_PROPERTY__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS:
				return getExplicitPlainTextRequiredImports();
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
			case JavaPackage.JAVA_PROPERTY__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case JavaPackage.JAVA_PROPERTY__IS_FINAL:
				setIsFinal((Boolean)newValue);
				return;
			case JavaPackage.JAVA_PROPERTY__BASE_PROPERTY:
				setBase_Property((Property)newValue);
				return;
			case JavaPackage.JAVA_PROPERTY__IS_TRANSIENT:
				setIsTransient((Boolean)newValue);
				return;
			case JavaPackage.JAVA_PROPERTY__GENERATE_GETTER:
				setGenerateGetter((TrueFalseDefault)newValue);
				return;
			case JavaPackage.JAVA_PROPERTY__GENERATE_SETTER:
				setGenerateSetter((TrueFalseDefault)newValue);
				return;
			case JavaPackage.JAVA_PROPERTY__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case JavaPackage.JAVA_PROPERTY__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS:
				getExplicitPlainTextRequiredImports().clear();
				getExplicitPlainTextRequiredImports().addAll((Collection<? extends String>)newValue);
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
			case JavaPackage.JAVA_PROPERTY__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case JavaPackage.JAVA_PROPERTY__IS_FINAL:
				setIsFinal(IS_FINAL_EDEFAULT);
				return;
			case JavaPackage.JAVA_PROPERTY__BASE_PROPERTY:
				setBase_Property((Property)null);
				return;
			case JavaPackage.JAVA_PROPERTY__IS_TRANSIENT:
				setIsTransient(IS_TRANSIENT_EDEFAULT);
				return;
			case JavaPackage.JAVA_PROPERTY__GENERATE_GETTER:
				setGenerateGetter(GENERATE_GETTER_EDEFAULT);
				return;
			case JavaPackage.JAVA_PROPERTY__GENERATE_SETTER:
				setGenerateSetter(GENERATE_SETTER_EDEFAULT);
				return;
			case JavaPackage.JAVA_PROPERTY__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case JavaPackage.JAVA_PROPERTY__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS:
				getExplicitPlainTextRequiredImports().clear();
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
			case JavaPackage.JAVA_PROPERTY__IS_ABSTRACT:
				return isAbstract != IS_ABSTRACT_EDEFAULT;
			case JavaPackage.JAVA_PROPERTY__IS_FINAL:
				return isFinal != IS_FINAL_EDEFAULT;
			case JavaPackage.JAVA_PROPERTY__BASE_PROPERTY:
				return base_Property != null;
			case JavaPackage.JAVA_PROPERTY__IS_TRANSIENT:
				return isTransient != IS_TRANSIENT_EDEFAULT;
			case JavaPackage.JAVA_PROPERTY__GENERATE_GETTER:
				return generateGetter != GENERATE_GETTER_EDEFAULT;
			case JavaPackage.JAVA_PROPERTY__GENERATE_SETTER:
				return generateSetter != GENERATE_SETTER_EDEFAULT;
			case JavaPackage.JAVA_PROPERTY__IS_STATIC:
				return isStatic != IS_STATIC_EDEFAULT;
			case JavaPackage.JAVA_PROPERTY__EXPLICIT_PLAIN_TEXT_REQUIRED_IMPORTS:
				return explicitPlainTextRequiredImports != null && !explicitPlainTextRequiredImports.isEmpty();
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
		result.append(" (isAbstract: ");
		result.append(isAbstract);
		result.append(", isFinal: ");
		result.append(isFinal);
		result.append(", isTransient: ");
		result.append(isTransient);
		result.append(", generateGetter: ");
		result.append(generateGetter);
		result.append(", generateSetter: ");
		result.append(generateSetter);
		result.append(", isStatic: ");
		result.append(isStatic);
		result.append(", explicitPlainTextRequiredImports: ");
		result.append(explicitPlainTextRequiredImports);
		result.append(')');
		return result.toString();
	}

} //JavaPropertyImpl
