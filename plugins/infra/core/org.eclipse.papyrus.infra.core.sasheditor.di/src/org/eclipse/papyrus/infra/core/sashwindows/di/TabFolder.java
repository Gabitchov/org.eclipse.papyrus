/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.core.sashwindows.di;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tab Folder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getTabFolder()
 * @model
 * @generated
 */
public interface TabFolder extends AbstractPanel {

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.core.sashwindows.di.PageRef}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.core.sashwindows.di.PageRef#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getTabFolder_Children()
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.PageRef#getParent
	 * @model opposite="parent" containment="true" ordered="false"
	 * @generated
	 */
	EList<PageRef> getChildren();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model oldIndexDataType="org.eclipse.papyrus.infra.core.sashwindows.di.int" oldIndexRequired="true" oldIndexOrdered="false" newIndexDataType="org.eclipse.papyrus.infra.core.sashwindows.di.int" newIndexRequired="true" newIndexOrdered="false"
	 * @generated
	 */
	void movePage(int oldIndex, int newIndex);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model pageIdentifierDataType="org.eclipse.papyrus.infra.core.sashwindows.di.JavaObject" pageIdentifierRequired="true" pageIdentifierOrdered="false"
	 * @generated
	 */
	void addPage(Object pageIdentifier);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model pageIndexDataType="org.eclipse.papyrus.infra.core.sashwindows.di.int" pageIndexRequired="true" pageIndexOrdered="false"
	 * @generated
	 */
	void removePage(int pageIndex);

} // TabFolder
