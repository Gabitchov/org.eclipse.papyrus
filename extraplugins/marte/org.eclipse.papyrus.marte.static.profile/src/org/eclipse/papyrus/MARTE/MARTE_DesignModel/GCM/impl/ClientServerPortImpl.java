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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerKind;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerPort;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerSpecification;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.PortSpecificationKind;
import org.eclipse.papyrus.MARTE.utils.MarteResource;
import org.eclipse.uml2.uml.Image;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Stereotype;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Client Server Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.ClientServerPortImpl#getBase_Port <em>Base Port</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.ClientServerPortImpl#getSpecificationKind <em>Specification Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.ClientServerPortImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.ClientServerPortImpl#getProvInterface <em>Prov Interface</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.ClientServerPortImpl#getReqInterface <em>Req Interface</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.ClientServerPortImpl#getFeaturesSpec <em>Features Spec</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClientServerPortImpl extends EObjectImpl implements ClientServerPort {
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
	 * The default value of the '{@link #getSpecificationKind() <em>Specification Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecificationKind()
	 * @generated
	 * @ordered
	 */
	protected static final PortSpecificationKind SPECIFICATION_KIND_EDEFAULT = PortSpecificationKind.INTERFACE_BASED;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final ClientServerKind KIND_EDEFAULT = ClientServerKind.PROREQ;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected ClientServerKind kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProvInterface() <em>Prov Interface</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvInterface()
	 * @generated
	 * @ordered
	 */
	protected EList<Interface> provInterface;

	/**
	 * The cached value of the '{@link #getReqInterface() <em>Req Interface</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReqInterface()
	 * @generated
	 * @ordered
	 */
	protected EList<Interface> reqInterface;

	/**
	 * The cached value of the '{@link #getFeaturesSpec() <em>Features Spec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeaturesSpec()
	 * @generated
	 * @ordered
	 */
	protected ClientServerSpecification featuresSpec;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClientServerPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GCMPackage.Literals.CLIENT_SERVER_PORT;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GCMPackage.CLIENT_SERVER_PORT__BASE_PORT, oldBase_Port, base_Port));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GCMPackage.CLIENT_SERVER_PORT__BASE_PORT, oldBase_Port, base_Port));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PortSpecificationKind getSpecificationKind() {
		// TODO: implement this method to return the 'Specification Kind' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		// throw new UnsupportedOperationException();
		
		PortSpecificationKind portSpecKind = SPECIFICATION_KIND_EDEFAULT;
		if(getBase_Port() != null) {
			if(getBase_Port().getType() != null && getBase_Port().getType() instanceof Signal) {
				if(getProvInterface() != null) {
					// getProvInterface().clear();
					// FIXME 404786: [MARTE] ClientServerPortImpl.getSpecificationKind tries to modify the model from a ReadOnly transaction
					// https://bugs.eclipse.org/bugs/show_bug.cgi?id=404786
					System.err.println("Error: ClientServerPort " + getBase_Port().getQualifiedName() + " is Atomic. provInterface shall be empty");
				}
				if(getReqInterface() != null) {
					// FIXME 404786: [MARTE] ClientServerPortImpl.getSpecificationKind tries to modify the model from a ReadOnly transaction
					// https://bugs.eclipse.org/bugs/show_bug.cgi?id=404786
					// getReqInterface().clear();
					System.err.println("Error: ClientServerPort " + getBase_Port().getQualifiedName() + " is Atomic. reqInterface shall be empty");
				}
				if(getFeaturesSpec() != null) {
					// FIXME 404786: [MARTE] ClientServerPortImpl.getSpecificationKind tries to modify the model from a ReadOnly transaction
					// https://bugs.eclipse.org/bugs/show_bug.cgi?id=404786
					// setFeaturesSpec(null);
					System.err.println("Error: ClientServerPort " + getBase_Port().getQualifiedName() + " is Atomic. featureSpec shall be empty");
				}
				portSpecKind = PortSpecificationKind.ATOMIC;
			}
			else if(getBase_Port().getType() == null) {
				if (getFeaturesSpec() != null) {
					/*
					if(getProvInterface() != null)
					
						getProvInterface().clear();
					if(getReqInterface() != null)
						getReqInterface().clear();
						*/
					portSpecKind = PortSpecificationKind.FEATURE_BASED;
				}
				else if(getProvInterface() != null || getReqInterface() != null ) {
					if(getFeaturesSpec() != null)
						setFeaturesSpec(null);
					portSpecKind = PortSpecificationKind.INTERFACE_BASED;
				}
			}
			else {
				System.err.println("Error: ClientServerPort " + getBase_Port().getQualifiedName() + " is Atomic. It must be typed by a Signal");
			}
		}
		
		return portSpecKind;

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecificationKind(PortSpecificationKind newSpecificationKind) {
		// TODO: implement this method to set the 'Specification Kind' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClientServerKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(ClientServerKind newKind) {
		ClientServerKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GCMPackage.CLIENT_SERVER_PORT__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Interface> getProvInterface() {
		if (provInterface == null) {
			provInterface = new EObjectResolvingEList<Interface>(Interface.class, this, GCMPackage.CLIENT_SERVER_PORT__PROV_INTERFACE);
		}
		return provInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Interface> getReqInterface() {
		if (reqInterface == null) {
			reqInterface = new EObjectResolvingEList<Interface>(Interface.class, this, GCMPackage.CLIENT_SERVER_PORT__REQ_INTERFACE);
		}
		return reqInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClientServerSpecification getFeaturesSpec() {
		if (featuresSpec != null && featuresSpec.eIsProxy()) {
			InternalEObject oldFeaturesSpec = (InternalEObject)featuresSpec;
			featuresSpec = (ClientServerSpecification)eResolveProxy(oldFeaturesSpec);
			if (featuresSpec != oldFeaturesSpec) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GCMPackage.CLIENT_SERVER_PORT__FEATURES_SPEC, oldFeaturesSpec, featuresSpec));
			}
		}
		return featuresSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClientServerSpecification basicGetFeaturesSpec() {
		return featuresSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeaturesSpec(ClientServerSpecification newFeaturesSpec) {
		ClientServerSpecification oldFeaturesSpec = featuresSpec;
		featuresSpec = newFeaturesSpec;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GCMPackage.CLIENT_SERVER_PORT__FEATURES_SPEC, oldFeaturesSpec, featuresSpec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GCMPackage.CLIENT_SERVER_PORT__BASE_PORT:
				if (resolve) return getBase_Port();
				return basicGetBase_Port();
			case GCMPackage.CLIENT_SERVER_PORT__SPECIFICATION_KIND:
				return getSpecificationKind();
			case GCMPackage.CLIENT_SERVER_PORT__KIND:
				return getKind();
			case GCMPackage.CLIENT_SERVER_PORT__PROV_INTERFACE:
				return getProvInterface();
			case GCMPackage.CLIENT_SERVER_PORT__REQ_INTERFACE:
				return getReqInterface();
			case GCMPackage.CLIENT_SERVER_PORT__FEATURES_SPEC:
				if (resolve) return getFeaturesSpec();
				return basicGetFeaturesSpec();
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
			case GCMPackage.CLIENT_SERVER_PORT__BASE_PORT:
				setBase_Port((Port)newValue);
				return;
			case GCMPackage.CLIENT_SERVER_PORT__SPECIFICATION_KIND:
				setSpecificationKind((PortSpecificationKind)newValue);
				return;
			case GCMPackage.CLIENT_SERVER_PORT__KIND:
				setKind((ClientServerKind)newValue);
				return;
			case GCMPackage.CLIENT_SERVER_PORT__PROV_INTERFACE:
				getProvInterface().clear();
				getProvInterface().addAll((Collection<? extends Interface>)newValue);
				return;
			case GCMPackage.CLIENT_SERVER_PORT__REQ_INTERFACE:
				getReqInterface().clear();
				getReqInterface().addAll((Collection<? extends Interface>)newValue);
				return;
			case GCMPackage.CLIENT_SERVER_PORT__FEATURES_SPEC:
				setFeaturesSpec((ClientServerSpecification)newValue);
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
			case GCMPackage.CLIENT_SERVER_PORT__BASE_PORT:
				setBase_Port((Port)null);
				return;
			case GCMPackage.CLIENT_SERVER_PORT__SPECIFICATION_KIND:
				setSpecificationKind(SPECIFICATION_KIND_EDEFAULT);
				return;
			case GCMPackage.CLIENT_SERVER_PORT__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case GCMPackage.CLIENT_SERVER_PORT__PROV_INTERFACE:
				getProvInterface().clear();
				return;
			case GCMPackage.CLIENT_SERVER_PORT__REQ_INTERFACE:
				getReqInterface().clear();
				return;
			case GCMPackage.CLIENT_SERVER_PORT__FEATURES_SPEC:
				setFeaturesSpec((ClientServerSpecification)null);
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
			case GCMPackage.CLIENT_SERVER_PORT__BASE_PORT:
				return base_Port != null;
			case GCMPackage.CLIENT_SERVER_PORT__SPECIFICATION_KIND:
				return getSpecificationKind() != SPECIFICATION_KIND_EDEFAULT;
			case GCMPackage.CLIENT_SERVER_PORT__KIND:
				return kind != KIND_EDEFAULT;
			case GCMPackage.CLIENT_SERVER_PORT__PROV_INTERFACE:
				return provInterface != null && !provInterface.isEmpty();
			case GCMPackage.CLIENT_SERVER_PORT__REQ_INTERFACE:
				return reqInterface != null && !reqInterface.isEmpty();
			case GCMPackage.CLIENT_SERVER_PORT__FEATURES_SPEC:
				return featuresSpec != null;
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
			Stereotype st = getBase_Port().getAppliedStereotype(MarteResource.CLIENT_SERVER_PORT_ID);

			Image defaultImage = st.getIcons().get(2);
			Image image = null;

			if(getSpecificationKind() == PortSpecificationKind.INTERFACE_BASED) {
				if(!getReqInterface().isEmpty() && getProvInterface().isEmpty()) {
					image = st.getIcons().get(0);
				} else if(!getProvInterface().isEmpty() && getReqInterface().isEmpty() ) {
					image = st.getIcons().get(1);
				} else {
					// Default proreq
					image = defaultImage;
				}
			}
			
			else if (getSpecificationKind() == PortSpecificationKind.FEATURE_BASED){
				image = defaultImage;
			}
			
			else if(getSpecificationKind() == PortSpecificationKind.ATOMIC) {
				if(getKind() ==  ClientServerKind.PROVIDED) {
					image = st.getIcons().get(1);
				}
				
				else if(getKind() ==  ClientServerKind.REQUIRED) {
					image = st.getIcons().get(0);
				}
				
				else {
					// Default proreq
					image = defaultImage;					
				}
			}

			return image;

		} else {
			return ImageNotFound;
		}
	}


} //ClientServerPortImpl
