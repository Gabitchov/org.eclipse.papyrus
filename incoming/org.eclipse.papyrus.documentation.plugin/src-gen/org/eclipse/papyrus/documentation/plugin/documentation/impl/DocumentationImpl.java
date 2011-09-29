/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.documentation.plugin.documentation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.documentation.plugin.documentation.Comment;
import org.eclipse.papyrus.documentation.plugin.documentation.Dependency;
import org.eclipse.papyrus.documentation.plugin.documentation.Documentation;
import org.eclipse.papyrus.documentation.plugin.documentation.DocumentationPackage;
import org.eclipse.papyrus.documentation.plugin.documentation.Person;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Documentation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.documentation.plugin.documentation.impl.DocumentationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.documentation.plugin.documentation.impl.DocumentationImpl#getImplicitDependencies <em>Implicit Dependencies</em>}</li>
 *   <li>{@link org.eclipse.papyrus.documentation.plugin.documentation.impl.DocumentationImpl#getReferent <em>Referent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.documentation.plugin.documentation.impl.DocumentationImpl#getAdditionalComments <em>Additional Comments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentationImpl extends EModelElementImpl implements Documentation {
	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getImplicitDependencies() <em>Implicit Dependencies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplicitDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<Dependency> implicitDependencies;

	/**
	 * The cached value of the '{@link #getReferent() <em>Referent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferent()
	 * @generated
	 * @ordered
	 */
	protected EList<Person> referent;

	/**
	 * The cached value of the '{@link #getAdditionalComments() <em>Additional Comments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditionalComments()
	 * @generated
	 * @ordered
	 */
	protected EList<Comment> additionalComments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DocumentationPackage.Literals.DOCUMENTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DocumentationPackage.DOCUMENTATION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Dependency> getImplicitDependencies() {
		if (implicitDependencies == null) {
			implicitDependencies = new EObjectContainmentEList<Dependency>(Dependency.class, this, DocumentationPackage.DOCUMENTATION__IMPLICIT_DEPENDENCIES);
		}
		return implicitDependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Person> getReferent() {
		if (referent == null) {
			referent = new EObjectContainmentEList<Person>(Person.class, this, DocumentationPackage.DOCUMENTATION__REFERENT);
		}
		return referent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Comment> getAdditionalComments() {
		if (additionalComments == null) {
			additionalComments = new EObjectContainmentEList<Comment>(Comment.class, this, DocumentationPackage.DOCUMENTATION__ADDITIONAL_COMMENTS);
		}
		return additionalComments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DocumentationPackage.DOCUMENTATION__IMPLICIT_DEPENDENCIES:
				return ((InternalEList<?>)getImplicitDependencies()).basicRemove(otherEnd, msgs);
			case DocumentationPackage.DOCUMENTATION__REFERENT:
				return ((InternalEList<?>)getReferent()).basicRemove(otherEnd, msgs);
			case DocumentationPackage.DOCUMENTATION__ADDITIONAL_COMMENTS:
				return ((InternalEList<?>)getAdditionalComments()).basicRemove(otherEnd, msgs);
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
			case DocumentationPackage.DOCUMENTATION__DESCRIPTION:
				return getDescription();
			case DocumentationPackage.DOCUMENTATION__IMPLICIT_DEPENDENCIES:
				return getImplicitDependencies();
			case DocumentationPackage.DOCUMENTATION__REFERENT:
				return getReferent();
			case DocumentationPackage.DOCUMENTATION__ADDITIONAL_COMMENTS:
				return getAdditionalComments();
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
			case DocumentationPackage.DOCUMENTATION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case DocumentationPackage.DOCUMENTATION__IMPLICIT_DEPENDENCIES:
				getImplicitDependencies().clear();
				getImplicitDependencies().addAll((Collection<? extends Dependency>)newValue);
				return;
			case DocumentationPackage.DOCUMENTATION__REFERENT:
				getReferent().clear();
				getReferent().addAll((Collection<? extends Person>)newValue);
				return;
			case DocumentationPackage.DOCUMENTATION__ADDITIONAL_COMMENTS:
				getAdditionalComments().clear();
				getAdditionalComments().addAll((Collection<? extends Comment>)newValue);
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
			case DocumentationPackage.DOCUMENTATION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case DocumentationPackage.DOCUMENTATION__IMPLICIT_DEPENDENCIES:
				getImplicitDependencies().clear();
				return;
			case DocumentationPackage.DOCUMENTATION__REFERENT:
				getReferent().clear();
				return;
			case DocumentationPackage.DOCUMENTATION__ADDITIONAL_COMMENTS:
				getAdditionalComments().clear();
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
			case DocumentationPackage.DOCUMENTATION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case DocumentationPackage.DOCUMENTATION__IMPLICIT_DEPENDENCIES:
				return implicitDependencies != null && !implicitDependencies.isEmpty();
			case DocumentationPackage.DOCUMENTATION__REFERENT:
				return referent != null && !referent.isEmpty();
			case DocumentationPackage.DOCUMENTATION__ADDITIONAL_COMMENTS:
				return additionalComments != null && !additionalComments.isEmpty();
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
		result.append(" (description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //DocumentationImpl
