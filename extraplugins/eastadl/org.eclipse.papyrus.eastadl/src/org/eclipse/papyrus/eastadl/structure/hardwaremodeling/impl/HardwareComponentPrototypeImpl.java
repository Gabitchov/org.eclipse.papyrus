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
package org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentPrototype;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwareComponentType;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwaremodelingPackage;
import org.eclipse.papyrus.eastadl.utils.EASTResource;
import org.eclipse.papyrus.uml.tools.utils.ElementUtil;
import org.eclipse.uml2.uml.Image;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Hardware Component Prototype</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwareComponentPrototypeImpl#getType <em>Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwareComponentPrototypeImpl#getBase_Property <em>Base Property</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class HardwareComponentPrototypeImpl extends AllocationTargetImpl implements HardwareComponentPrototype {

	/**
	 * The cached value of the '{@link #getBase_Property() <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_Property()
	 * @generated
	 * @ordered
	 */
	protected Property base_Property;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected HardwareComponentPrototypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public HardwareComponentType basicGetType() {
		HardwareComponentType type = null;

		if(getBase_Property() != null) {

			Type basicType = getBase_Property().getType();


			if(basicType != null) {
				type = (HardwareComponentType)UMLUtil.getStereotypeApplication(basicType, HardwareComponentType.class);
			}
		}

		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Property getBase_Property() {
		if(base_Property != null && base_Property.eIsProxy()) {
			InternalEObject oldBase_Property = (InternalEObject)base_Property;
			base_Property = (Property)eResolveProxy(oldBase_Property);
			if(base_Property != oldBase_Property) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, HardwaremodelingPackage.HARDWARE_COMPONENT_PROTOTYPE__BASE_PROPERTY, oldBase_Property, base_Property));
			}
		}
		return base_Property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Property basicGetBase_Property() {
		return base_Property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Property(Property newBase_Property) {
		Property oldBase_Property = base_Property;
		base_Property = newBase_Property;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HardwaremodelingPackage.HARDWARE_COMPONENT_PROTOTYPE__BASE_PROPERTY, oldBase_Property, base_Property));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case HardwaremodelingPackage.HARDWARE_COMPONENT_PROTOTYPE__TYPE:
			if(resolve)
				return getType();
			return basicGetType();
		case HardwaremodelingPackage.HARDWARE_COMPONENT_PROTOTYPE__BASE_PROPERTY:
			if(resolve)
				return getBase_Property();
			return basicGetBase_Property();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case HardwaremodelingPackage.HARDWARE_COMPONENT_PROTOTYPE__TYPE:
			return basicGetType() != null;
		case HardwaremodelingPackage.HARDWARE_COMPONENT_PROTOTYPE__BASE_PROPERTY:
			return base_Property != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case HardwaremodelingPackage.HARDWARE_COMPONENT_PROTOTYPE__BASE_PROPERTY:
			setBase_Property((Property)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HardwaremodelingPackage.Literals.HARDWARE_COMPONENT_PROTOTYPE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case HardwaremodelingPackage.HARDWARE_COMPONENT_PROTOTYPE__BASE_PROPERTY:
			setBase_Property((Property)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Image getIcon() {

		Image ImageNotFound = null;

		if(getBase_Property() != null) {
			Stereotype st = getBase_Property().getAppliedStereotype(EASTResource.HARDWARECOMPONENTPROTOTYPE_ID);

			Image defaultImage = st.getIcons().get(0);
			Image typeImage = null;

			HardwareComponentType type = getType();
			if((type != null) && (type.getBase_Class() != null)) {
				typeImage = ElementUtil.getStereotypeImage(type.getBase_Class(), "icon");
			}

			if(typeImage != null) {
				return typeImage;
			} else {
				return defaultImage;
			}

		} else {
			return ImageNotFound;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public HardwareComponentType getType() {
		HardwareComponentType type = basicGetType();
		return type != null && type.eIsProxy() ? (HardwareComponentType)eResolveProxy((InternalEObject)type) : type;
	}

} // HardwareComponentPrototypeImpl
