/**
 */
package org.eclipse.papyrus.facade.virtualmetamodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.facade.virtualmetamodel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VirtualmetamodelFactoryImpl extends EFactoryImpl implements VirtualmetamodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VirtualmetamodelFactory init() {
		try {
			VirtualmetamodelFactory theVirtualmetamodelFactory = (VirtualmetamodelFactory)EPackage.Registry.INSTANCE.getEFactory(VirtualmetamodelPackage.eNS_URI);
			if (theVirtualmetamodelFactory != null) {
				return theVirtualmetamodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new VirtualmetamodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualmetamodelFactoryImpl() {
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
			case VirtualmetamodelPackage.VIRTUAL_METAMODEL: return createVirtualMetamodel();
			case VirtualmetamodelPackage.VIRTUAL_METACLASS: return createVirtualMetaclass();
			case VirtualmetamodelPackage.VIRTUAL_PROPERTY: return createVirtualProperty();
			case VirtualmetamodelPackage.VIRTUAL_OPERATION: return createVirtualOperation();
			case VirtualmetamodelPackage.VIRTUAL_PARAMETER: return createVirtualParameter();
			case VirtualmetamodelPackage.VIRTUAL_DATATYPE: return createVirtualDatatype();
			case VirtualmetamodelPackage.VIRTUAL_ENUM: return createVirtualEnum();
			case VirtualmetamodelPackage.VIRTUAL_LITERAL: return createVirtualLiteral();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualMetamodel createVirtualMetamodel() {
		VirtualMetamodelImpl virtualMetamodel = new VirtualMetamodelImpl();
		return virtualMetamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualMetaclass createVirtualMetaclass() {
		VirtualMetaclassImpl virtualMetaclass = new VirtualMetaclassImpl();
		return virtualMetaclass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualProperty createVirtualProperty() {
		VirtualPropertyImpl virtualProperty = new VirtualPropertyImpl();
		return virtualProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualOperation createVirtualOperation() {
		VirtualOperationImpl virtualOperation = new VirtualOperationImpl();
		return virtualOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualParameter createVirtualParameter() {
		VirtualParameterImpl virtualParameter = new VirtualParameterImpl();
		return virtualParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualDatatype createVirtualDatatype() {
		VirtualDatatypeImpl virtualDatatype = new VirtualDatatypeImpl();
		return virtualDatatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualEnum createVirtualEnum() {
		VirtualEnumImpl virtualEnum = new VirtualEnumImpl();
		return virtualEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualLiteral createVirtualLiteral() {
		VirtualLiteralImpl virtualLiteral = new VirtualLiteralImpl();
		return virtualLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualmetamodelPackage getVirtualmetamodelPackage() {
		return (VirtualmetamodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static VirtualmetamodelPackage getPackage() {
		return VirtualmetamodelPackage.eINSTANCE;
	}

} //VirtualmetamodelFactoryImpl
