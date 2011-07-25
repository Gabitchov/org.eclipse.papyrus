/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.newchild.ncpolicy.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.newchild.ncpolicy.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NcpolicyFactoryImpl extends EFactoryImpl implements NcpolicyFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NcpolicyFactory init() {
		try {
			NcpolicyFactory theNcpolicyFactory = (NcpolicyFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/newchild/policy"); 
			if (theNcpolicyFactory != null) {
				return theNcpolicyFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NcpolicyFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NcpolicyFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case NcpolicyPackage.NEW_EMF_CHILD_MENU: return createNewEMFChildMenu();
			case NcpolicyPackage.NEW_CHILD_POLICY_SET: return createNewChildPolicySet();
			case NcpolicyPackage.FILTER_POLICY: return createFilterPolicy();
			case NcpolicyPackage.REPLACE_POLICY: return createReplacePolicy();
			case NcpolicyPackage.CUSTOM_POLICY: return createCustomPolicy();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case NcpolicyPackage.CREATE_IN:
				return createCreateInFromString(eDataType, initialValue);
			case NcpolicyPackage.LAYOUT:
				return createLayoutFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case NcpolicyPackage.CREATE_IN:
				return convertCreateInToString(eDataType, instanceValue);
			case NcpolicyPackage.LAYOUT:
				return convertLayoutToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewEMFChildMenu createNewEMFChildMenu() {
		NewEMFChildMenuImpl newEMFChildMenu = new NewEMFChildMenuImpl();
		return newEMFChildMenu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewChildPolicySet createNewChildPolicySet() {
		NewChildPolicySetImpl newChildPolicySet = new NewChildPolicySetImpl();
		return newChildPolicySet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterPolicy createFilterPolicy() {
		FilterPolicyImpl filterPolicy = new FilterPolicyImpl();
		return filterPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplacePolicy createReplacePolicy() {
		ReplacePolicyImpl replacePolicy = new ReplacePolicyImpl();
		return replacePolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomPolicy createCustomPolicy() {
		CustomPolicyImpl customPolicy = new CustomPolicyImpl();
		return customPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateIn createCreateInFromString(EDataType eDataType, String initialValue) {
		CreateIn result = CreateIn.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCreateInToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Layout createLayoutFromString(EDataType eDataType, String initialValue) {
		Layout result = Layout.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLayoutToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NcpolicyPackage getNcpolicyPackage() {
		return (NcpolicyPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static NcpolicyPackage getPackage() {
		return NcpolicyPackage.eINSTANCE;
	}

} //NcpolicyFactoryImpl
