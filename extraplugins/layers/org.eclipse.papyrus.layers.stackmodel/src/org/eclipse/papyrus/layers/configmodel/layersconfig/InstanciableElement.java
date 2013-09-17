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
package org.eclipse.papyrus.layers.configmodel.layersconfig;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instanciable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.configmodel.layersconfig.InstanciableElement#getClassname <em>Classname</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.configmodel.layersconfig.InstanciableElement#getBundleID <em>Bundle ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.configmodel.layersconfig.InstanciableElement#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.configmodel.layersconfig.InstanciableElement#getIconPath <em>Icon Path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.configmodel.layersconfig.InstanciableElement#getClassnameKind <em>Classname Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigPackage#getInstanciableElement()
 * @model abstract="true"
 * @generated
 */
public interface InstanciableElement extends FolderElement {
	/**
	 * Returns the value of the '<em><b>Classname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classname</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classname</em>' attribute.
	 * @see #setClassname(String)
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigPackage#getInstanciableElement_Classname()
	 * @model dataType="org.eclipse.papyrus.layers.configmodel.layersconfig.String" required="true" ordered="false"
	 * @generated
	 */
	String getClassname();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.InstanciableElement#getClassname <em>Classname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classname</em>' attribute.
	 * @see #getClassname()
	 * @generated
	 */
	void setClassname(String value);

	/**
	 * Returns the value of the '<em><b>Bundle ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bundle ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bundle ID</em>' attribute.
	 * @see #setBundleID(String)
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigPackage#getInstanciableElement_BundleID()
	 * @model dataType="org.eclipse.papyrus.layers.configmodel.layersconfig.String" required="true" ordered="false"
	 * @generated
	 */
	String getBundleID();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.InstanciableElement#getBundleID <em>Bundle ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bundle ID</em>' attribute.
	 * @see #getBundleID()
	 * @generated
	 */
	void setBundleID(String value);

	/**
	 * Returns the value of the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Display Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display Name</em>' attribute.
	 * @see #setDisplayName(String)
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigPackage#getInstanciableElement_DisplayName()
	 * @model dataType="org.eclipse.papyrus.layers.configmodel.layersconfig.String" required="true" ordered="false"
	 * @generated
	 */
	String getDisplayName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.InstanciableElement#getDisplayName <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Name</em>' attribute.
	 * @see #getDisplayName()
	 * @generated
	 */
	void setDisplayName(String value);

	/**
	 * Returns the value of the '<em><b>Icon Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon Path</em>' attribute.
	 * @see #setIconPath(String)
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigPackage#getInstanciableElement_IconPath()
	 * @model dataType="org.eclipse.papyrus.layers.configmodel.layersconfig.String" required="true" ordered="false"
	 * @generated
	 */
	String getIconPath();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.InstanciableElement#getIconPath <em>Icon Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon Path</em>' attribute.
	 * @see #getIconPath()
	 * @generated
	 */
	void setIconPath(String value);

	/**
	 * Returns the value of the '<em><b>Classname Kind</b></em>' attribute.
	 * The default value is <code>"UNDEFINED"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.layers.configmodel.layersconfig.ClassnameKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classname Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classname Kind</em>' attribute.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.ClassnameKind
	 * @see #setClassnameKind(ClassnameKind)
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigPackage#getInstanciableElement_ClassnameKind()
	 * @model default="UNDEFINED" required="true" ordered="false"
	 * @generated
	 */
	ClassnameKind getClassnameKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.InstanciableElement#getClassnameKind <em>Classname Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classname Kind</em>' attribute.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.ClassnameKind
	 * @see #getClassnameKind()
	 * @generated
	 */
	void setClassnameKind(ClassnameKind value);

} // InstanciableElement
