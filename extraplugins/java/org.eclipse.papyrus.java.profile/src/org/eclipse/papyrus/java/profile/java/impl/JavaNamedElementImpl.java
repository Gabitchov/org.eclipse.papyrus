/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.java.profile.java.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.papyrus.java.profile.java.JavaNamedElement;
import org.eclipse.papyrus.java.profile.java.JavaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaNamedElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaNamedElementImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaNamedElementImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaNamedElementImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.impl.JavaNamedElementImpl#isGenerated <em>Is Generated</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class JavaNamedElementImpl extends EObjectImpl implements JavaNamedElement {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTHOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected String author = AUTHOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected String comment = COMMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #isGenerated() <em>Is Generated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGenerated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_GENERATED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isGenerated() <em>Is Generated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGenerated()
	 * @generated
	 * @ordered
	 */
	protected boolean isGenerated = IS_GENERATED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JavaNamedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavaPackage.Literals.JAVA_NAMED_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JAVA_NAMED_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthor(String newAuthor) {
		String oldAuthor = author;
		author = newAuthor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JAVA_NAMED_ELEMENT__AUTHOR, oldAuthor, author));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JAVA_NAMED_ELEMENT__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComment(String newComment) {
		String oldComment = comment;
		comment = newComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JAVA_NAMED_ELEMENT__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGenerated() {
		return isGenerated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsGenerated(boolean newIsGenerated) {
		boolean oldIsGenerated = isGenerated;
		isGenerated = newIsGenerated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JAVA_NAMED_ELEMENT__IS_GENERATED, oldIsGenerated, isGenerated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JavaPackage.JAVA_NAMED_ELEMENT__NAME:
				return getName();
			case JavaPackage.JAVA_NAMED_ELEMENT__AUTHOR:
				return getAuthor();
			case JavaPackage.JAVA_NAMED_ELEMENT__VERSION:
				return getVersion();
			case JavaPackage.JAVA_NAMED_ELEMENT__COMMENT:
				return getComment();
			case JavaPackage.JAVA_NAMED_ELEMENT__IS_GENERATED:
				return isGenerated();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JavaPackage.JAVA_NAMED_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case JavaPackage.JAVA_NAMED_ELEMENT__AUTHOR:
				setAuthor((String)newValue);
				return;
			case JavaPackage.JAVA_NAMED_ELEMENT__VERSION:
				setVersion((String)newValue);
				return;
			case JavaPackage.JAVA_NAMED_ELEMENT__COMMENT:
				setComment((String)newValue);
				return;
			case JavaPackage.JAVA_NAMED_ELEMENT__IS_GENERATED:
				setIsGenerated((Boolean)newValue);
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
			case JavaPackage.JAVA_NAMED_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case JavaPackage.JAVA_NAMED_ELEMENT__AUTHOR:
				setAuthor(AUTHOR_EDEFAULT);
				return;
			case JavaPackage.JAVA_NAMED_ELEMENT__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case JavaPackage.JAVA_NAMED_ELEMENT__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case JavaPackage.JAVA_NAMED_ELEMENT__IS_GENERATED:
				setIsGenerated(IS_GENERATED_EDEFAULT);
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
			case JavaPackage.JAVA_NAMED_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case JavaPackage.JAVA_NAMED_ELEMENT__AUTHOR:
				return AUTHOR_EDEFAULT == null ? author != null : !AUTHOR_EDEFAULT.equals(author);
			case JavaPackage.JAVA_NAMED_ELEMENT__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case JavaPackage.JAVA_NAMED_ELEMENT__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case JavaPackage.JAVA_NAMED_ELEMENT__IS_GENERATED:
				return isGenerated != IS_GENERATED_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", author: ");
		result.append(author);
		result.append(", version: ");
		result.append(version);
		result.append(", comment: ");
		result.append(comment);
		result.append(", isGenerated: ");
		result.append(isGenerated);
		result.append(')');
		return result.toString();
	}

} //JavaNamedElementImpl
