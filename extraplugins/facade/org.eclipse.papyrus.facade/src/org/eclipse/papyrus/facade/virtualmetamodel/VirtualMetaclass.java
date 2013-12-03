/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facade.virtualmetamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Metaclass</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass#getAppliedStereotypes <em>Applied Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass#getParents <em>Parents</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass#isStereotypeInterface <em>Stereotype Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage#getVirtualMetaclass()
 * @model
 * @generated
 */
public interface VirtualMetaclass extends VirtualClassifier {
	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #setAbstract(boolean)
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage#getVirtualMetaclass_Abstract()
	 * @model
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Applied Stereotypes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applied Stereotypes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applied Stereotypes</em>' reference list.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage#getVirtualMetaclass_AppliedStereotypes()
	 * @model
	 * @generated
	 */
	EList<BaseMetaclass> getAppliedStereotypes();

	/**
	 * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualOperation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' containment reference list.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage#getVirtualMetaclass_Operations()
	 * @model containment="true"
	 * @generated
	 */
	EList<VirtualOperation> getOperations();

	/**
	 * Returns the value of the '<em><b>Parents</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parents</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parents</em>' reference list.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage#getVirtualMetaclass_Parents()
	 * @model
	 * @generated
	 */
	EList<VirtualMetaclass> getParents();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty#getVirtualMetaclass <em>Virtual Metaclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage#getVirtualMetaclass_Properties()
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty#getVirtualMetaclass
	 * @model opposite="virtualMetaclass" containment="true"
	 * @generated
	 */
	EList<VirtualProperty> getProperties();

	/**
	 * Returns the value of the '<em><b>Stereotype Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype Interface</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotype Interface</em>' attribute.
	 * @see #setStereotypeInterface(boolean)
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage#getVirtualMetaclass_StereotypeInterface()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true"
	 * @generated
	 */
	boolean isStereotypeInterface();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass#isStereotypeInterface <em>Stereotype Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotype Interface</em>' attribute.
	 * @see #isStereotypeInterface()
	 * @generated
	 */
	void setStereotypeInterface(boolean value);

} // VirtualMetaclass
