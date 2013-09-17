/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.layers.configmodel.layersconfig.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.layers.configmodel.layersconfig.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigPackage
 * @generated
 */
public class LayersconfigSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static LayersconfigPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersconfigSwitch() {
		if (modelPackage == null) {
			modelPackage = LayersconfigPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case LayersconfigPackage.FOLDER: {
				Folder folder = (Folder)theEObject;
				T result = caseFolder(folder);
				if (result == null) result = caseFolderElement(folder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersconfigPackage.FOLDER_ELEMENT: {
				FolderElement folderElement = (FolderElement)theEObject;
				T result = caseFolderElement(folderElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersconfigPackage.LAYER_OPERATOR_CONFIG: {
				LayerOperatorConfig layerOperatorConfig = (LayerOperatorConfig)theEObject;
				T result = caseLayerOperatorConfig(layerOperatorConfig);
				if (result == null) result = caseInstanciableElement(layerOperatorConfig);
				if (result == null) result = caseFolderElement(layerOperatorConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersconfigPackage.INSTANCIABLE_ELEMENT: {
				InstanciableElement instanciableElement = (InstanciableElement)theEObject;
				T result = caseInstanciableElement(instanciableElement);
				if (result == null) result = caseFolderElement(instanciableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersconfigPackage.OPERATOR_CONFIG: {
				OperatorConfig operatorConfig = (OperatorConfig)theEObject;
				T result = caseOperatorConfig(operatorConfig);
				if (result == null) result = caseInstanciableElement(operatorConfig);
				if (result == null) result = caseFolderElement(operatorConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersconfigPackage.PROPERTY_ID: {
				PropertyId propertyId = (PropertyId)theEObject;
				T result = casePropertyId(propertyId);
				if (result == null) result = caseFolderElement(propertyId);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersconfigPackage.TYPE_CONFIG: {
				TypeConfig typeConfig = (TypeConfig)theEObject;
				T result = caseTypeConfig(typeConfig);
				if (result == null) result = caseFolderElement(typeConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersconfigPackage.LAYER_OPERATOR_MULTIPLE_BINDING: {
				LayerOperatorMultipleBinding layerOperatorMultipleBinding = (LayerOperatorMultipleBinding)theEObject;
				T result = caseLayerOperatorMultipleBinding(layerOperatorMultipleBinding);
				if (result == null) result = caseFolderElement(layerOperatorMultipleBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersconfigPackage.OPERATOR_BINDING: {
				OperatorBinding operatorBinding = (OperatorBinding)theEObject;
				T result = caseOperatorBinding(operatorBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Folder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Folder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFolder(Folder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Folder Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Folder Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFolderElement(FolderElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Layer Operator Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Layer Operator Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLayerOperatorConfig(LayerOperatorConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instanciable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instanciable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstanciableElement(InstanciableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operator Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operator Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperatorConfig(OperatorConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Id</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Id</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyId(PropertyId object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeConfig(TypeConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Layer Operator Multiple Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Layer Operator Multiple Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLayerOperatorMultipleBinding(LayerOperatorMultipleBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operator Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operator Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperatorBinding(OperatorBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //LayersconfigSwitch
