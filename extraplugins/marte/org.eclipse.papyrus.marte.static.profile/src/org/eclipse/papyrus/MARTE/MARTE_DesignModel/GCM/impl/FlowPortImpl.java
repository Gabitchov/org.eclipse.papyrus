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
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowDirectionKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowSpecification;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMPackage;
import org.eclipse.papyrus.MARTE.utils.MarteResource;
import org.eclipse.papyrus.uml.tools.utils.ElementUtil;
import org.eclipse.uml2.uml.Image;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flow Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.FlowPortImpl#isIsAtomic <em>Is Atomic</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.FlowPortImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.FlowPortImpl#getBase_Port <em>Base Port</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FlowPortImpl extends EObjectImpl implements FlowPort {
	/**
	 * The default value of the '{@link #isIsAtomic() <em>Is Atomic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAtomic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ATOMIC_EDEFAULT = false;

	/**
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected static final FlowDirectionKind DIRECTION_EDEFAULT = FlowDirectionKind.INOUT;

	/**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected FlowDirectionKind direction = DIRECTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_Port() <em>Base Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Port()
	 * @generated
	 * @ordered
	 */
	protected Port base_Port;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FlowPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GCMPackage.Literals.FLOW_PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isIsAtomic() {
		// TODO: implement this method to return the 'Is Atomic' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		// throw new UnsupportedOperationException();
		
		Port port = getBase_Port();
		Type portType = port.getType();
		if(portType != null) {
			// get flowSpecification stereotype
			FlowSpecification flowSpec = 
				(FlowSpecification) ElementUtil.hasStereotype(portType, GCMPackage.eINSTANCE.getFlowSpecification());
			
			// flowSpecification stereotype is applied
			if(flowSpec != null) {
				return false;
			}
		}
		
		// untyped port or port not typed with a flowSpecification.
		return true;

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAtomic(boolean newIsAtomic) {
		// TODO: implement this method to set the 'Is Atomic' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowDirectionKind getDirection() {
		return direction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirection(FlowDirectionKind newDirection) {
		FlowDirectionKind oldDirection = direction;
		direction = newDirection == null ? DIRECTION_EDEFAULT : newDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GCMPackage.FLOW_PORT__DIRECTION, oldDirection, direction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getBase_Port() {
		if (base_Port != null && base_Port.eIsProxy()) {
			InternalEObject oldBase_Port = (InternalEObject)base_Port;
			base_Port = (Port)eResolveProxy(oldBase_Port);
			if (base_Port != oldBase_Port) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GCMPackage.FLOW_PORT__BASE_PORT, oldBase_Port, base_Port));
			}
		}
		return base_Port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port basicGetBase_Port() {
		return base_Port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Port(Port newBase_Port) {
		Port oldBase_Port = base_Port;
		base_Port = newBase_Port;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GCMPackage.FLOW_PORT__BASE_PORT, oldBase_Port, base_Port));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GCMPackage.FLOW_PORT__IS_ATOMIC:
				return isIsAtomic();
			case GCMPackage.FLOW_PORT__DIRECTION:
				return getDirection();
			case GCMPackage.FLOW_PORT__BASE_PORT:
				if (resolve) return getBase_Port();
				return basicGetBase_Port();
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
			case GCMPackage.FLOW_PORT__IS_ATOMIC:
				setIsAtomic((Boolean)newValue);
				return;
			case GCMPackage.FLOW_PORT__DIRECTION:
				setDirection((FlowDirectionKind)newValue);
				return;
			case GCMPackage.FLOW_PORT__BASE_PORT:
				setBase_Port((Port)newValue);
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
			case GCMPackage.FLOW_PORT__IS_ATOMIC:
				setIsAtomic(IS_ATOMIC_EDEFAULT);
				return;
			case GCMPackage.FLOW_PORT__DIRECTION:
				setDirection(DIRECTION_EDEFAULT);
				return;
			case GCMPackage.FLOW_PORT__BASE_PORT:
				setBase_Port((Port)null);
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
			case GCMPackage.FLOW_PORT__IS_ATOMIC:
				return isIsAtomic() != IS_ATOMIC_EDEFAULT;
			case GCMPackage.FLOW_PORT__DIRECTION:
				return direction != DIRECTION_EDEFAULT;
			case GCMPackage.FLOW_PORT__BASE_PORT:
				return base_Port != null;
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
		result.append(" (direction: ");
		result.append(direction);
		result.append(')');
		return result.toString();
	}
	
	/**
	 * 
	 * @return
	 * @generated NOT
	 */
	public Image getIcon() {

		Image ImageNotFound = null;

		if(getBase_Port() != null) {
			Stereotype st = getBase_Port().getAppliedStereotype(MarteResource.FLOW_PORT_ID);

			Image defaultImage = st.getIcons().get(0);
			Image image = null;

			if(isIsAtomic()) {
				if(getDirection() == FlowDirectionKind.OUT) {
					image = st.getIcons().get(1);
				} else if(getDirection() == FlowDirectionKind.INOUT) {
					image = st.getIcons().get(2);
				} else {
					// Default : IN
					image = defaultImage;
				}

			}
			
			else {
				image = st.getIcons().get(2);
			}

			return image;

		} else {
			return ImageNotFound;
		}
	}


} //FlowPortImpl
