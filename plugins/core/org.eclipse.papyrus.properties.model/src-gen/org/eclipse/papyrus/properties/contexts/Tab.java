/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.contexts;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tab</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.Tab#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.Tab#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.Tab#getCategory <em>Category</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.Tab#getImage <em>Image</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.Tab#getAfterTab <em>After Tab</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.Tab#getSections <em>Sections</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getTab()
 * @model
 * @generated
 */
public interface Tab extends EObject {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getTab_Label()
	 * @model required="true"
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.contexts.Tab#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getTab_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.contexts.Tab#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' attribute.
	 * @see #setCategory(String)
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getTab_Category()
	 * @model required="true"
	 * @generated
	 */
	String getCategory();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.contexts.Tab#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(String value);

	/**
	 * Returns the value of the '<em><b>Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image</em>' attribute.
	 * @see #setImage(String)
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getTab_Image()
	 * @model
	 * @generated
	 */
	String getImage();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.contexts.Tab#getImage <em>Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image</em>' attribute.
	 * @see #getImage()
	 * @generated
	 */
	void setImage(String value);

	/**
	 * Returns the value of the '<em><b>After Tab</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>After Tab</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>After Tab</em>' reference.
	 * @see #setAfterTab(Tab)
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getTab_AfterTab()
	 * @model
	 * @generated
	 */
	Tab getAfterTab();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.contexts.Tab#getAfterTab <em>After Tab</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>After Tab</em>' reference.
	 * @see #getAfterTab()
	 * @generated
	 */
	void setAfterTab(Tab value);

	/**
	 * Returns the value of the '<em><b>Sections</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.properties.contexts.Section}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.properties.contexts.Section#getTab <em>Tab</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sections</em>' containment reference list.
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getTab_Sections()
	 * @see org.eclipse.papyrus.properties.contexts.Section#getTab
	 * @model opposite="tab" containment="true"
	 * @generated
	 */
	EList<Section> getSections();

} // Tab
