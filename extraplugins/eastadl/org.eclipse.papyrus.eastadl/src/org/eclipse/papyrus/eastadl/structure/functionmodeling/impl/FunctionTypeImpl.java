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

import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ContextImpl;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionConnector;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionPort;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionType;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.PortGroup;
import org.eclipse.papyrus.eastadl.utils.EASTResource;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Image;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Function Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionTypeImpl#isEncapsulated <em>Is Encapsulated</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionTypeImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionTypeImpl#isIsElementary <em>Is Elementary</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionTypeImpl#getPort <em>Port</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionTypeImpl#getPortGroup <em>Port Group</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionTypeImpl#getConnector <em>Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FunctionTypeImpl extends ContextImpl implements FunctionType {

	/**
	 * The default value of the '{@link #isEncapsulated() <em>Is Encapsulated</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isEncapsulated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ENCAPSULATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEncapsulated() <em>Is Encapsulated</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isEncapsulated()
	 * @generated
	 * @ordered
	 */
	protected boolean isEncapsulated = IS_ENCAPSULATED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * The default value of the '{@link #isIsElementary() <em>Is Elementary</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isIsElementary()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ELEMENTARY_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Block.class) {
			switch (derivedFeatureID) {
				case FunctionmodelingPackage.FUNCTION_TYPE__IS_ENCAPSULATED: return BlocksPackage.BLOCK__IS_ENCAPSULATED;
				case FunctionmodelingPackage.FUNCTION_TYPE__BASE_CLASS: return BlocksPackage.BLOCK__BASE_CLASS;
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
		if (baseClass == Block.class) {
			switch (baseFeatureID) {
				case BlocksPackage.BLOCK__IS_ENCAPSULATED: return FunctionmodelingPackage.FUNCTION_TYPE__IS_ENCAPSULATED;
				case BlocksPackage.BLOCK__BASE_CLASS: return FunctionmodelingPackage.FUNCTION_TYPE__BASE_CLASS;
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
			case FunctionmodelingPackage.FUNCTION_TYPE__IS_ENCAPSULATED:
				return isEncapsulated();
			case FunctionmodelingPackage.FUNCTION_TYPE__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case FunctionmodelingPackage.FUNCTION_TYPE__IS_ELEMENTARY:
				return isIsElementary();
			case FunctionmodelingPackage.FUNCTION_TYPE__PORT:
				return getPort();
			case FunctionmodelingPackage.FUNCTION_TYPE__PORT_GROUP:
				return getPortGroup();
			case FunctionmodelingPackage.FUNCTION_TYPE__CONNECTOR:
				return getConnector();
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
			case FunctionmodelingPackage.FUNCTION_TYPE__IS_ENCAPSULATED:
				return isEncapsulated != IS_ENCAPSULATED_EDEFAULT;
			case FunctionmodelingPackage.FUNCTION_TYPE__BASE_CLASS:
				return base_Class != null;
			case FunctionmodelingPackage.FUNCTION_TYPE__IS_ELEMENTARY:
				return isIsElementary() != IS_ELEMENTARY_EDEFAULT;
			case FunctionmodelingPackage.FUNCTION_TYPE__PORT:
				return !getPort().isEmpty();
			case FunctionmodelingPackage.FUNCTION_TYPE__PORT_GROUP:
				return !getPortGroup().isEmpty();
			case FunctionmodelingPackage.FUNCTION_TYPE__CONNECTOR:
				return !getConnector().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FunctionmodelingPackage.FUNCTION_TYPE__IS_ENCAPSULATED:
				setIsEncapsulated((Boolean)newValue);
				return;
			case FunctionmodelingPackage.FUNCTION_TYPE__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
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
		return FunctionmodelingPackage.Literals.FUNCTION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEncapsulated() {
		return isEncapsulated;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FunctionmodelingPackage.FUNCTION_TYPE__IS_ENCAPSULATED:
				setIsEncapsulated(IS_ENCAPSULATED_EDEFAULT);
				return;
			case FunctionmodelingPackage.FUNCTION_TYPE__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FunctionmodelingPackage.FUNCTION_TYPE__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<FunctionConnector> getConnector() {

		EList<FunctionConnector> connectors = new BasicEList<FunctionConnector>();
		FunctionConnector currentConnectorPrototype;

		if(getBase_Class() != null) {
			// Parse owned Connectors
			Iterator<Connector> itDep = getBase_Class().getOwnedConnectors().iterator();
			while(itDep.hasNext()) {
				Connector currentConnector = itDep.next();

				// Test if currentProperty is stereotyped ADLFunctionPrototype
				currentConnectorPrototype = (FunctionConnector)UMLUtil.getStereotypeApplication(currentConnector,
					FunctionConnector.class);

				if(currentConnectorPrototype != null) {
					connectors.add(currentConnectorPrototype);
				}
			}
		}

		// Convert to InternalEList<?>
		return new BasicInternalEList<FunctionConnector>(FunctionConnector.class, connectors.size(), connectors
			.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Image getIcon() {

		if(getBase_Class() != null) {
			Stereotype st = getBase_Class().getAppliedStereotype(EASTResource.FUNCTIONTYPE_ID);
			EList<Image> images = st.getIcons();

			if(isIsElementary()) {
				return images.get(1);
			} else {
				return images.get(0);
			}
		} else {
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<FunctionPort> getPort() {

		EList<FunctionPort> groupedPorts = new BasicEList<FunctionPort>();
		FunctionPort currentADLFlowPort;

		if(getBase_Class() != null) {
			// Parse owned Ports
			Iterator<Port> itDep = getBase_Class().getOwnedPorts().iterator();
			while(itDep.hasNext()) {
				Port currentPort = itDep.next();

				// Test if currentPort is stereotyped FlowPort
				currentADLFlowPort = (FunctionPort)UMLUtil.getStereotypeApplication(currentPort,
					FunctionPort.class);

				if(currentADLFlowPort != null) {
					groupedPorts.add(currentADLFlowPort);
				}
			}
		}

		// Convert to InternalEList<?>
		return new BasicInternalEList<FunctionPort>(FunctionPort.class, groupedPorts.size(), groupedPorts.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<PortGroup> getPortGroup() {

		EList<PortGroup> portGroups = new BasicEList<PortGroup>();
		PortGroup currentADLPortGroup;

		if(getBase_Class() != null) {
			// Parse owned Ports
			Iterator<Classifier> itDep = getBase_Class().getNestedClassifiers().iterator();
			while(itDep.hasNext()) {
				Classifier currentClass = itDep.next();

				// Test if currentPort is stereotyped ADLFlowPort
				currentADLPortGroup = (PortGroup)UMLUtil.getStereotypeApplication(currentClass,
					PortGroup.class);

				if(currentADLPortGroup != null) {
					portGroups.add(currentADLPortGroup);
				}
			}
		}

		// Convert to InternalEList<?>
		return new BasicInternalEList<PortGroup>(PortGroup.class, portGroups.size(), portGroups.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isIsElementary() {
		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionmodelingPackage.FUNCTION_TYPE__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsEncapsulated(boolean newIsEncapsulated) {
		boolean oldIsEncapsulated = isEncapsulated;
		isEncapsulated = newIsEncapsulated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FunctionmodelingPackage.FUNCTION_TYPE__IS_ENCAPSULATED, oldIsEncapsulated, isEncapsulated));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isEncapsulated: ");
		result.append(isEncapsulated);
		result.append(')');
		return result.toString();
	}

} // FunctionTypeImpl
