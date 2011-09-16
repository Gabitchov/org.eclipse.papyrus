/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.diagramtemplate.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.diagramtemplate.AbstractSelection;
import org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage;
import org.eclipse.papyrus.diagramtemplate.SelectionKind;
import org.eclipse.papyrus.diagramtemplate.SelectionRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Selection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.impl.AbstractSelectionImpl#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.impl.AbstractSelectionImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.impl.AbstractSelectionImpl#getSelectionRef <em>Selection Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.impl.AbstractSelectionImpl#isSubTypes <em>Sub Types</em>}</li>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.impl.AbstractSelectionImpl#getStereotypedBy <em>Stereotyped By</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractSelectionImpl extends EObjectImpl implements AbstractSelection {
	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected EObject element;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final SelectionKind KIND_EDEFAULT = SelectionKind.FOR_ALL;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected SelectionKind kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSelectionRef() <em>Selection Ref</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectionRef()
	 * @generated
	 * @ordered
	 */
	protected EList<SelectionRef> selectionRef;

	/**
	 * The default value of the '{@link #isSubTypes() <em>Sub Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSubTypes()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SUB_TYPES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSubTypes() <em>Sub Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSubTypes()
	 * @generated
	 * @ordered
	 */
	protected boolean subTypes = SUB_TYPES_EDEFAULT;

	/**
	 * The default value of the '{@link #getStereotypedBy() <em>Stereotyped By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypedBy()
	 * @generated
	 * @ordered
	 */
	protected static final String STEREOTYPED_BY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStereotypedBy() <em>Stereotyped By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypedBy()
	 * @generated
	 * @ordered
	 */
	protected String stereotypedBy = STEREOTYPED_BY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractSelectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramTemplatePackage.Literals.ABSTRACT_SELECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getElement() {
		if (element != null && element.eIsProxy()) {
			InternalEObject oldElement = (InternalEObject)element;
			element = eResolveProxy(oldElement);
			if (element != oldElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramTemplatePackage.ABSTRACT_SELECTION__ELEMENT, oldElement, element));
			}
		}
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(EObject newElement) {
		EObject oldElement = element;
		element = newElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramTemplatePackage.ABSTRACT_SELECTION__ELEMENT, oldElement, element));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectionKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(SelectionKind newKind) {
		SelectionKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramTemplatePackage.ABSTRACT_SELECTION__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SelectionRef> getSelectionRef() {
		if (selectionRef == null) {
			selectionRef = new EObjectContainmentEList<SelectionRef>(SelectionRef.class, this, DiagramTemplatePackage.ABSTRACT_SELECTION__SELECTION_REF);
		}
		return selectionRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSubTypes() {
		return subTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubTypes(boolean newSubTypes) {
		boolean oldSubTypes = subTypes;
		subTypes = newSubTypes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramTemplatePackage.ABSTRACT_SELECTION__SUB_TYPES, oldSubTypes, subTypes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStereotypedBy() {
		return stereotypedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotypedBy(String newStereotypedBy) {
		String oldStereotypedBy = stereotypedBy;
		stereotypedBy = newStereotypedBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramTemplatePackage.ABSTRACT_SELECTION__STEREOTYPED_BY, oldStereotypedBy, stereotypedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramTemplatePackage.ABSTRACT_SELECTION__SELECTION_REF:
				return ((InternalEList<?>)getSelectionRef()).basicRemove(otherEnd, msgs);
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
			case DiagramTemplatePackage.ABSTRACT_SELECTION__ELEMENT:
				if (resolve) return getElement();
				return basicGetElement();
			case DiagramTemplatePackage.ABSTRACT_SELECTION__KIND:
				return getKind();
			case DiagramTemplatePackage.ABSTRACT_SELECTION__SELECTION_REF:
				return getSelectionRef();
			case DiagramTemplatePackage.ABSTRACT_SELECTION__SUB_TYPES:
				return isSubTypes();
			case DiagramTemplatePackage.ABSTRACT_SELECTION__STEREOTYPED_BY:
				return getStereotypedBy();
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
			case DiagramTemplatePackage.ABSTRACT_SELECTION__ELEMENT:
				setElement((EObject)newValue);
				return;
			case DiagramTemplatePackage.ABSTRACT_SELECTION__KIND:
				setKind((SelectionKind)newValue);
				return;
			case DiagramTemplatePackage.ABSTRACT_SELECTION__SELECTION_REF:
				getSelectionRef().clear();
				getSelectionRef().addAll((Collection<? extends SelectionRef>)newValue);
				return;
			case DiagramTemplatePackage.ABSTRACT_SELECTION__SUB_TYPES:
				setSubTypes((Boolean)newValue);
				return;
			case DiagramTemplatePackage.ABSTRACT_SELECTION__STEREOTYPED_BY:
				setStereotypedBy((String)newValue);
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
			case DiagramTemplatePackage.ABSTRACT_SELECTION__ELEMENT:
				setElement((EObject)null);
				return;
			case DiagramTemplatePackage.ABSTRACT_SELECTION__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case DiagramTemplatePackage.ABSTRACT_SELECTION__SELECTION_REF:
				getSelectionRef().clear();
				return;
			case DiagramTemplatePackage.ABSTRACT_SELECTION__SUB_TYPES:
				setSubTypes(SUB_TYPES_EDEFAULT);
				return;
			case DiagramTemplatePackage.ABSTRACT_SELECTION__STEREOTYPED_BY:
				setStereotypedBy(STEREOTYPED_BY_EDEFAULT);
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
			case DiagramTemplatePackage.ABSTRACT_SELECTION__ELEMENT:
				return element != null;
			case DiagramTemplatePackage.ABSTRACT_SELECTION__KIND:
				return kind != KIND_EDEFAULT;
			case DiagramTemplatePackage.ABSTRACT_SELECTION__SELECTION_REF:
				return selectionRef != null && !selectionRef.isEmpty();
			case DiagramTemplatePackage.ABSTRACT_SELECTION__SUB_TYPES:
				return subTypes != SUB_TYPES_EDEFAULT;
			case DiagramTemplatePackage.ABSTRACT_SELECTION__STEREOTYPED_BY:
				return STEREOTYPED_BY_EDEFAULT == null ? stereotypedBy != null : !STEREOTYPED_BY_EDEFAULT.equals(stereotypedBy);
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(", subTypes: ");
		result.append(subTypes);
		result.append(", stereotypedBy: ");
		result.append(stereotypedBy);
		result.append(')');
		return result.toString();
	}

} //AbstractSelectionImpl
