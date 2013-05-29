/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.structure.functionmodeling.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.infrastructure.datatypes.EADatatype;
import org.eclipse.papyrus.eastadl.infrastructure.elements.Comment;
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;
import org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionFlowPort;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPort;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage;
import org.eclipse.papyrus.sysml.portandflows.internal.impl.FlowPortImpl;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Function Flow Port</b></em> '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionFlowPortImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionFlowPortImpl#getBase_NamedElement <em>Base Named Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionFlowPortImpl#getOwnedComment <em>Owned Comment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionFlowPortImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionFlowPortImpl extends FlowPortImpl implements FunctionFlowPort {

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
	 * The cached value of the '{@link #getBase_NamedElement() <em>Base Named Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_NamedElement()
	 * @generated
	 * @ordered
	 */
	protected NamedElement base_NamedElement;

	/**
	 * The cached value of the '{@link #getOwnedComment() <em>Owned Comment</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedComment()
	 * @generated
	 * @ordered
	 */
	protected EList<Comment> ownedComment;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionFlowPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EADatatype basicGetType() {
		EADatatype dataType = null;

		if(getBase_Port() != null) {
			Type umlType = getBase_Port().getType();

			
			if(umlType != null) {
				dataType = (EADatatype)UMLUtil.getStereotypeApplication(umlType, EADatatype.class);
			}
		}

		return dataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == EAElement.class) {
			switch (derivedFeatureID) {
				case FunctionmodelingPackage.FUNCTION_FLOW_PORT__NAME: return ElementsPackage.EA_ELEMENT__NAME;
				case FunctionmodelingPackage.FUNCTION_FLOW_PORT__BASE_NAMED_ELEMENT: return ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT;
				case FunctionmodelingPackage.FUNCTION_FLOW_PORT__OWNED_COMMENT: return ElementsPackage.EA_ELEMENT__OWNED_COMMENT;
				default: return -1;
			}
		}
		if (baseClass == FunctionPort.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == EAElement.class) {
			switch (baseFeatureID) {
				case ElementsPackage.EA_ELEMENT__NAME: return FunctionmodelingPackage.FUNCTION_FLOW_PORT__NAME;
				case ElementsPackage.EA_ELEMENT__BASE_NAMED_ELEMENT: return FunctionmodelingPackage.FUNCTION_FLOW_PORT__BASE_NAMED_ELEMENT;
				case ElementsPackage.EA_ELEMENT__OWNED_COMMENT: return FunctionmodelingPackage.FUNCTION_FLOW_PORT__OWNED_COMMENT;
				default: return -1;
			}
		}
		if (baseClass == FunctionPort.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FunctionmodelingPackage.FUNCTION_FLOW_PORT__NAME:
				return getName();
			case FunctionmodelingPackage.FUNCTION_FLOW_PORT__BASE_NAMED_ELEMENT:
				if (resolve) return getBase_NamedElement();
				return basicGetBase_NamedElement();
			case FunctionmodelingPackage.FUNCTION_FLOW_PORT__OWNED_COMMENT:
				return getOwnedComment();
			case FunctionmodelingPackage.FUNCTION_FLOW_PORT__TYPE:
				if (resolve) return getType();
				return basicGetType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FunctionmodelingPackage.FUNCTION_FLOW_PORT__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case FunctionmodelingPackage.FUNCTION_FLOW_PORT__BASE_NAMED_ELEMENT:
				return base_NamedElement != null;
			case FunctionmodelingPackage.FUNCTION_FLOW_PORT__OWNED_COMMENT:
				return ownedComment != null && !ownedComment.isEmpty();
			case FunctionmodelingPackage.FUNCTION_FLOW_PORT__TYPE:
				return basicGetType() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FunctionmodelingPackage.FUNCTION_FLOW_PORT__NAME:
				setName((String)newValue);
				return;
			case FunctionmodelingPackage.FUNCTION_FLOW_PORT__BASE_NAMED_ELEMENT:
				setBase_NamedElement((NamedElement)newValue);
				return;
			case FunctionmodelingPackage.FUNCTION_FLOW_PORT__OWNED_COMMENT:
				getOwnedComment().clear();
				getOwnedComment().addAll((Collection<? extends Comment>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionmodelingPackage.Literals.FUNCTION_FLOW_PORT;
	}


	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FunctionmodelingPackage.FUNCTION_FLOW_PORT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FunctionmodelingPackage.FUNCTION_FLOW_PORT__BASE_NAMED_ELEMENT:
				setBase_NamedElement((NamedElement)null);
				return;
			case FunctionmodelingPackage.FUNCTION_FLOW_PORT__OWNED_COMMENT:
				getOwnedComment().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String getName() {
		return getBase_Port().getName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Comment> getOwnedComment() {
		if (ownedComment == null) {
			ownedComment = new EObjectResolvingEList<Comment>(Comment.class, this, FunctionmodelingPackage.FUNCTION_FLOW_PORT__OWNED_COMMENT);
		}
		return ownedComment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EADatatype getType() {
		EADatatype type = basicGetType();
		return type != null && type.eIsProxy() ? (EADatatype)eResolveProxy((InternalEObject)type) : type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isIsAtomic() {
		// Always true in EAST-ADL2
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setName(String newName) {
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement getBase_NamedElement() {
		if (base_NamedElement != null && base_NamedElement.eIsProxy()) {
			InternalEObject oldBase_NamedElement = (InternalEObject)base_NamedElement;
			base_NamedElement = (NamedElement)eResolveProxy(oldBase_NamedElement);
			if (base_NamedElement != oldBase_NamedElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FunctionmodelingPackage.FUNCTION_FLOW_PORT__BASE_NAMED_ELEMENT, oldBase_NamedElement, base_NamedElement));
			}
		}
		return base_NamedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement basicGetBase_NamedElement() {
		return base_NamedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_NamedElement(NamedElement newBase_NamedElement) {
		NamedElement oldBase_NamedElement = base_NamedElement;
		base_NamedElement = newBase_NamedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionmodelingPackage.FUNCTION_FLOW_PORT__BASE_NAMED_ELEMENT, oldBase_NamedElement, base_NamedElement));
	}

} // FunctionFlowPortImpl
