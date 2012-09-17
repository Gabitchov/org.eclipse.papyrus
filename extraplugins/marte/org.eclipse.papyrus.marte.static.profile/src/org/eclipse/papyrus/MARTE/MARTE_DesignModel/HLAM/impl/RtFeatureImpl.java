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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.HLAMPackage;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtFeature;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.RtSpecification;
import org.eclipse.papyrus.uml.tools.utils.ElementUtil;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.InvocationAction;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Signal;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rt Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtFeatureImpl#getBase_BehavioralFeature <em>Base Behavioral Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtFeatureImpl#getBase_Message <em>Base Message</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtFeatureImpl#getBase_Signal <em>Base Signal</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtFeatureImpl#getBase_Port <em>Base Port</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtFeatureImpl#getBase_InvocationAction <em>Base Invocation Action</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.HLAM.impl.RtFeatureImpl#getSpecification <em>Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RtFeatureImpl extends EObjectImpl implements RtFeature {
	/**
	 * The cached value of the '{@link #getBase_BehavioralFeature() <em>Base Behavioral Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_BehavioralFeature()
	 * @generated
	 * @ordered
	 */
	protected BehavioralFeature base_BehavioralFeature;

	/**
	 * The cached value of the '{@link #getBase_Message() <em>Base Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Message()
	 * @generated
	 * @ordered
	 */
	protected Message base_Message;

	/**
	 * The cached value of the '{@link #getBase_Signal() <em>Base Signal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Signal()
	 * @generated
	 * @ordered
	 */
	protected Signal base_Signal;

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
	 * The cached value of the '{@link #getBase_InvocationAction() <em>Base Invocation Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_InvocationAction()
	 * @generated
	 * @ordered
	 */
	protected InvocationAction base_InvocationAction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RtFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HLAMPackage.Literals.RT_FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehavioralFeature getBase_BehavioralFeature() {
		if (base_BehavioralFeature != null && base_BehavioralFeature.eIsProxy()) {
			InternalEObject oldBase_BehavioralFeature = (InternalEObject)base_BehavioralFeature;
			base_BehavioralFeature = (BehavioralFeature)eResolveProxy(oldBase_BehavioralFeature);
			if (base_BehavioralFeature != oldBase_BehavioralFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HLAMPackage.RT_FEATURE__BASE_BEHAVIORAL_FEATURE, oldBase_BehavioralFeature, base_BehavioralFeature));
			}
		}
		return base_BehavioralFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehavioralFeature basicGetBase_BehavioralFeature() {
		return base_BehavioralFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_BehavioralFeature(BehavioralFeature newBase_BehavioralFeature) {
		BehavioralFeature oldBase_BehavioralFeature = base_BehavioralFeature;
		base_BehavioralFeature = newBase_BehavioralFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_FEATURE__BASE_BEHAVIORAL_FEATURE, oldBase_BehavioralFeature, base_BehavioralFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message getBase_Message() {
		if (base_Message != null && base_Message.eIsProxy()) {
			InternalEObject oldBase_Message = (InternalEObject)base_Message;
			base_Message = (Message)eResolveProxy(oldBase_Message);
			if (base_Message != oldBase_Message) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HLAMPackage.RT_FEATURE__BASE_MESSAGE, oldBase_Message, base_Message));
			}
		}
		return base_Message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message basicGetBase_Message() {
		return base_Message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Message(Message newBase_Message) {
		Message oldBase_Message = base_Message;
		base_Message = newBase_Message;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_FEATURE__BASE_MESSAGE, oldBase_Message, base_Message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signal getBase_Signal() {
		if (base_Signal != null && base_Signal.eIsProxy()) {
			InternalEObject oldBase_Signal = (InternalEObject)base_Signal;
			base_Signal = (Signal)eResolveProxy(oldBase_Signal);
			if (base_Signal != oldBase_Signal) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HLAMPackage.RT_FEATURE__BASE_SIGNAL, oldBase_Signal, base_Signal));
			}
		}
		return base_Signal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signal basicGetBase_Signal() {
		return base_Signal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Signal(Signal newBase_Signal) {
		Signal oldBase_Signal = base_Signal;
		base_Signal = newBase_Signal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_FEATURE__BASE_SIGNAL, oldBase_Signal, base_Signal));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HLAMPackage.RT_FEATURE__BASE_PORT, oldBase_Port, base_Port));
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
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_FEATURE__BASE_PORT, oldBase_Port, base_Port));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvocationAction getBase_InvocationAction() {
		if (base_InvocationAction != null && base_InvocationAction.eIsProxy()) {
			InternalEObject oldBase_InvocationAction = (InternalEObject)base_InvocationAction;
			base_InvocationAction = (InvocationAction)eResolveProxy(oldBase_InvocationAction);
			if (base_InvocationAction != oldBase_InvocationAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HLAMPackage.RT_FEATURE__BASE_INVOCATION_ACTION, oldBase_InvocationAction, base_InvocationAction));
			}
		}
		return base_InvocationAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvocationAction basicGetBase_InvocationAction() {
		return base_InvocationAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_InvocationAction(InvocationAction newBase_InvocationAction) {
		InvocationAction oldBase_InvocationAction = base_InvocationAction;
		base_InvocationAction = newBase_InvocationAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HLAMPackage.RT_FEATURE__BASE_INVOCATION_ACTION, oldBase_InvocationAction, base_InvocationAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<RtSpecification> getSpecification() {
		// TODO: implement this method to return the 'Specification' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		// throw new UnsupportedOperationException();
		
		EList<RtSpecification> ownedRtSpecifications = new BasicEList<RtSpecification>();
		Object base = null;
		if(getBase_InvocationAction()!=null)
			base = getBase_InvocationAction();
		else if(getBase_BehavioralFeature()!=null)
			base = getBase_BehavioralFeature();
		else if(getBase_Message()!=null)
			base = getBase_Message();
		else if(getBase_Signal()!=null)
			base = getBase_Signal();
		else if(getBase_Port()!=null)
			base = getBase_Port();
		
		if(base != null) {
			Iterator<Comment> ownedComments = ((NamedElement)base).getOwnedComments().iterator();
			while(ownedComments.hasNext()) {
				Comment currentComment = ownedComments.next();
				RtSpecification currentRtSpec = (RtSpecification)ElementUtil.hasStereotype(currentComment, HLAMPackage.eINSTANCE.getRtSpecification());
				if(currentRtSpec != null)
					ownedRtSpecifications.add(currentRtSpec);
			}
		}
		
		
		return new BasicInternalEList<RtSpecification> (
			RtSpecification.class,
			ownedRtSpecifications.size(),
			ownedRtSpecifications.toArray()
		);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HLAMPackage.RT_FEATURE__BASE_BEHAVIORAL_FEATURE:
				if (resolve) return getBase_BehavioralFeature();
				return basicGetBase_BehavioralFeature();
			case HLAMPackage.RT_FEATURE__BASE_MESSAGE:
				if (resolve) return getBase_Message();
				return basicGetBase_Message();
			case HLAMPackage.RT_FEATURE__BASE_SIGNAL:
				if (resolve) return getBase_Signal();
				return basicGetBase_Signal();
			case HLAMPackage.RT_FEATURE__BASE_PORT:
				if (resolve) return getBase_Port();
				return basicGetBase_Port();
			case HLAMPackage.RT_FEATURE__BASE_INVOCATION_ACTION:
				if (resolve) return getBase_InvocationAction();
				return basicGetBase_InvocationAction();
			case HLAMPackage.RT_FEATURE__SPECIFICATION:
				return getSpecification();
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
			case HLAMPackage.RT_FEATURE__BASE_BEHAVIORAL_FEATURE:
				setBase_BehavioralFeature((BehavioralFeature)newValue);
				return;
			case HLAMPackage.RT_FEATURE__BASE_MESSAGE:
				setBase_Message((Message)newValue);
				return;
			case HLAMPackage.RT_FEATURE__BASE_SIGNAL:
				setBase_Signal((Signal)newValue);
				return;
			case HLAMPackage.RT_FEATURE__BASE_PORT:
				setBase_Port((Port)newValue);
				return;
			case HLAMPackage.RT_FEATURE__BASE_INVOCATION_ACTION:
				setBase_InvocationAction((InvocationAction)newValue);
				return;
			case HLAMPackage.RT_FEATURE__SPECIFICATION:
				getSpecification().clear();
				getSpecification().addAll((Collection<? extends RtSpecification>)newValue);
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
			case HLAMPackage.RT_FEATURE__BASE_BEHAVIORAL_FEATURE:
				setBase_BehavioralFeature((BehavioralFeature)null);
				return;
			case HLAMPackage.RT_FEATURE__BASE_MESSAGE:
				setBase_Message((Message)null);
				return;
			case HLAMPackage.RT_FEATURE__BASE_SIGNAL:
				setBase_Signal((Signal)null);
				return;
			case HLAMPackage.RT_FEATURE__BASE_PORT:
				setBase_Port((Port)null);
				return;
			case HLAMPackage.RT_FEATURE__BASE_INVOCATION_ACTION:
				setBase_InvocationAction((InvocationAction)null);
				return;
			case HLAMPackage.RT_FEATURE__SPECIFICATION:
				getSpecification().clear();
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
			case HLAMPackage.RT_FEATURE__BASE_BEHAVIORAL_FEATURE:
				return base_BehavioralFeature != null;
			case HLAMPackage.RT_FEATURE__BASE_MESSAGE:
				return base_Message != null;
			case HLAMPackage.RT_FEATURE__BASE_SIGNAL:
				return base_Signal != null;
			case HLAMPackage.RT_FEATURE__BASE_PORT:
				return base_Port != null;
			case HLAMPackage.RT_FEATURE__BASE_INVOCATION_ACTION:
				return base_InvocationAction != null;
			case HLAMPackage.RT_FEATURE__SPECIFICATION:
				return !getSpecification().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RtFeatureImpl
