/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.contexts;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.View#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.View#getSections <em>Sections</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.View#getDatacontexts <em>Datacontexts</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.View#getElementMultiplicity <em>Element Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.View#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.View#isAutomaticContext <em>Automatic Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getView()
 * @model
 * @generated
 */
public interface View extends DisplayUnit {
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
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getView_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.contexts.View#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Sections</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.properties.contexts.Section}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sections</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sections</em>' reference list.
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getView_Sections()
	 * @model
	 * @generated
	 */
	EList<Section> getSections();

	/**
	 * Returns the value of the '<em><b>Datacontexts</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.properties.contexts.DataContextElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Datacontexts</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Datacontexts</em>' reference list.
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getView_Datacontexts()
	 * @model
	 * @generated
	 */
	EList<DataContextElement> getDatacontexts();

	/**
	 * Returns the value of the '<em><b>Element Multiplicity</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Multiplicity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Multiplicity</em>' attribute.
	 * @see #setElementMultiplicity(int)
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getView_ElementMultiplicity()
	 * @model default="1" required="true"
	 * @generated
	 */
	int getElementMultiplicity();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.contexts.View#getElementMultiplicity <em>Element Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Multiplicity</em>' attribute.
	 * @see #getElementMultiplicity()
	 * @generated
	 */
	void setElementMultiplicity(int value);

	/**
	 * Returns the value of the '<em><b>Context</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.properties.contexts.Context#getViews <em>Views</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' container reference.
	 * @see #setContext(Context)
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getView_Context()
	 * @see org.eclipse.papyrus.properties.contexts.Context#getViews
	 * @model opposite="views" required="true" transient="false"
	 * @generated
	 */
	Context getContext();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.contexts.View#getContext <em>Context</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' container reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(Context value);

	/**
	 * Returns the value of the '<em><b>Automatic Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Automatic Context</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Automatic Context</em>' attribute.
	 * @see #setAutomaticContext(boolean)
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getView_AutomaticContext()
	 * @model required="true"
	 * @generated
	 */
	boolean isAutomaticContext();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.contexts.View#isAutomaticContext <em>Automatic Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Automatic Context</em>' attribute.
	 * @see #isAutomaticContext()
	 * @generated
	 */
	void setAutomaticContext(boolean value);

} // View
