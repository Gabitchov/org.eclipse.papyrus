/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.design.profile.architecture.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.design.profile.architecture.ArchitecturePackage;
import org.eclipse.papyrus.design.profile.architecture.Layer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Layer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.design.profile.architecture.impl.LayerImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.design.profile.architecture.impl.LayerImpl#getParentFolder <em>Parent Folder</em>}</li>
 *   <li>{@link org.eclipse.papyrus.design.profile.architecture.impl.LayerImpl#getBase_Package <em>Base Package</em>}</li>
 *   <li>{@link org.eclipse.papyrus.design.profile.architecture.impl.LayerImpl#isDeprecated <em>Is Deprecated</em>}</li>
 *   <li>{@link org.eclipse.papyrus.design.profile.architecture.impl.LayerImpl#getDeprecatedComment <em>Deprecated Comment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.design.profile.architecture.impl.LayerImpl#getReferent <em>Referent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LayerImpl extends ElementImpl implements Layer {
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
	 * The default value of the '{@link #getParentFolder() <em>Parent Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentFolder()
	 * @generated
	 * @ordered
	 */
	protected static final String PARENT_FOLDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParentFolder() <em>Parent Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentFolder()
	 * @generated
	 * @ordered
	 */
	protected String parentFolder = PARENT_FOLDER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_Package() <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Package()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Package base_Package;

	/**
	 * The default value of the '{@link #isDeprecated() <em>Is Deprecated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeprecated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DEPRECATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDeprecated() <em>Is Deprecated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeprecated()
	 * @generated
	 * @ordered
	 */
	protected boolean isDeprecated = IS_DEPRECATED_EDEFAULT;

	/**
	 * The default value of the '{@link #getDeprecatedComment() <em>Deprecated Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeprecatedComment()
	 * @generated
	 * @ordered
	 */
	protected static final String DEPRECATED_COMMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDeprecatedComment() <em>Deprecated Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeprecatedComment()
	 * @generated
	 * @ordered
	 */
	protected String deprecatedComment = DEPRECATED_COMMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getReferent() <em>Referent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferent()
	 * @generated
	 * @ordered
	 */
	protected static final String REFERENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReferent() <em>Referent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferent()
	 * @generated
	 * @ordered
	 */
	protected String referent = REFERENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LayerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArchitecturePackage.Literals.LAYER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.LAYER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParentFolder() {
		return parentFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentFolder(String newParentFolder) {
		String oldParentFolder = parentFolder;
		parentFolder = newParentFolder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.LAYER__PARENT_FOLDER, oldParentFolder, parentFolder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package getBase_Package() {
		if (base_Package != null && base_Package.eIsProxy()) {
			InternalEObject oldBase_Package = (InternalEObject)base_Package;
			base_Package = (org.eclipse.uml2.uml.Package)eResolveProxy(oldBase_Package);
			if (base_Package != oldBase_Package) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchitecturePackage.LAYER__BASE_PACKAGE, oldBase_Package, base_Package));
			}
		}
		return base_Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package basicGetBase_Package() {
		return base_Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Package(org.eclipse.uml2.uml.Package newBase_Package) {
		org.eclipse.uml2.uml.Package oldBase_Package = base_Package;
		base_Package = newBase_Package;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.LAYER__BASE_PACKAGE, oldBase_Package, base_Package));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDeprecated() {
		return isDeprecated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDeprecated(boolean newIsDeprecated) {
		boolean oldIsDeprecated = isDeprecated;
		isDeprecated = newIsDeprecated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.LAYER__IS_DEPRECATED, oldIsDeprecated, isDeprecated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDeprecatedComment() {
		return deprecatedComment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeprecatedComment(String newDeprecatedComment) {
		String oldDeprecatedComment = deprecatedComment;
		deprecatedComment = newDeprecatedComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.LAYER__DEPRECATED_COMMENT, oldDeprecatedComment, deprecatedComment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReferent() {
		return referent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferent(String newReferent) {
		String oldReferent = referent;
		referent = newReferent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.LAYER__REFERENT, oldReferent, referent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArchitecturePackage.LAYER__NAME:
				return getName();
			case ArchitecturePackage.LAYER__PARENT_FOLDER:
				return getParentFolder();
			case ArchitecturePackage.LAYER__BASE_PACKAGE:
				if (resolve) return getBase_Package();
				return basicGetBase_Package();
			case ArchitecturePackage.LAYER__IS_DEPRECATED:
				return isDeprecated();
			case ArchitecturePackage.LAYER__DEPRECATED_COMMENT:
				return getDeprecatedComment();
			case ArchitecturePackage.LAYER__REFERENT:
				return getReferent();
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
			case ArchitecturePackage.LAYER__NAME:
				setName((String)newValue);
				return;
			case ArchitecturePackage.LAYER__PARENT_FOLDER:
				setParentFolder((String)newValue);
				return;
			case ArchitecturePackage.LAYER__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)newValue);
				return;
			case ArchitecturePackage.LAYER__IS_DEPRECATED:
				setIsDeprecated((Boolean)newValue);
				return;
			case ArchitecturePackage.LAYER__DEPRECATED_COMMENT:
				setDeprecatedComment((String)newValue);
				return;
			case ArchitecturePackage.LAYER__REFERENT:
				setReferent((String)newValue);
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
			case ArchitecturePackage.LAYER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ArchitecturePackage.LAYER__PARENT_FOLDER:
				setParentFolder(PARENT_FOLDER_EDEFAULT);
				return;
			case ArchitecturePackage.LAYER__BASE_PACKAGE:
				setBase_Package((org.eclipse.uml2.uml.Package)null);
				return;
			case ArchitecturePackage.LAYER__IS_DEPRECATED:
				setIsDeprecated(IS_DEPRECATED_EDEFAULT);
				return;
			case ArchitecturePackage.LAYER__DEPRECATED_COMMENT:
				setDeprecatedComment(DEPRECATED_COMMENT_EDEFAULT);
				return;
			case ArchitecturePackage.LAYER__REFERENT:
				setReferent(REFERENT_EDEFAULT);
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
			case ArchitecturePackage.LAYER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ArchitecturePackage.LAYER__PARENT_FOLDER:
				return PARENT_FOLDER_EDEFAULT == null ? parentFolder != null : !PARENT_FOLDER_EDEFAULT.equals(parentFolder);
			case ArchitecturePackage.LAYER__BASE_PACKAGE:
				return base_Package != null;
			case ArchitecturePackage.LAYER__IS_DEPRECATED:
				return isDeprecated != IS_DEPRECATED_EDEFAULT;
			case ArchitecturePackage.LAYER__DEPRECATED_COMMENT:
				return DEPRECATED_COMMENT_EDEFAULT == null ? deprecatedComment != null : !DEPRECATED_COMMENT_EDEFAULT.equals(deprecatedComment);
			case ArchitecturePackage.LAYER__REFERENT:
				return REFERENT_EDEFAULT == null ? referent != null : !REFERENT_EDEFAULT.equals(referent);
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
		result.append(", parentFolder: ");
		result.append(parentFolder);
		result.append(", isDeprecated: ");
		result.append(isDeprecated);
		result.append(", deprecatedComment: ");
		result.append(deprecatedComment);
		result.append(", referent: ");
		result.append(referent);
		result.append(')');
		return result.toString();
	}

} //LayerImpl
