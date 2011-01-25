/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.contexts;

import org.eclipse.papyrus.properties.ui.CompositeWidget;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.Section#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.Section#getTab <em>Tab</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.Section#getSectionFile <em>Section File</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.Section#getWidget <em>Widget</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getSection()
 * @model
 * @generated
 */
public interface Section extends DisplayUnit {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getSection_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.contexts.Section#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Tab</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.properties.contexts.Tab#getSections <em>Sections</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tab</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tab</em>' container reference.
	 * @see #setTab(Tab)
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getSection_Tab()
	 * @see org.eclipse.papyrus.properties.contexts.Tab#getSections
	 * @model opposite="sections" required="true" transient="false"
	 * @generated
	 */
	Tab getTab();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.contexts.Section#getTab <em>Tab</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tab</em>' container reference.
	 * @see #getTab()
	 * @generated
	 */
	void setTab(Tab value);

	/**
	 * Returns the value of the '<em><b>Section File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Section File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Section File</em>' attribute.
	 * @see #setSectionFile(String)
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getSection_SectionFile()
	 * @model required="true"
	 * @generated
	 */
	String getSectionFile();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.contexts.Section#getSectionFile <em>Section File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Section File</em>' attribute.
	 * @see #getSectionFile()
	 * @generated
	 */
	void setSectionFile(String value);

	/**
	 * Returns the value of the '<em><b>Widget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Widget</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Widget</em>' reference.
	 * @see #setWidget(CompositeWidget)
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getSection_Widget()
	 * @model required="true"
	 * @generated
	 */
	CompositeWidget getWidget();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.contexts.Section#getWidget <em>Widget</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Widget</em>' reference.
	 * @see #getWidget()
	 * @generated
	 */
	void setWidget(CompositeWidget value);

} // Section
