/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.core.sashwindows.di;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage
 * @generated
 */
public interface DiFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DiFactory eINSTANCE = org.eclipse.papyrus.infra.core.sashwindows.di.impl.DiFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Sash Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sash Model</em>'.
	 * @generated
	 */
	SashModel createSashModel();

	/**
	 * Returns a new object of class '<em>Window</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Window</em>'.
	 * @generated
	 */
	Window createWindow();

	/**
	 * Returns a new object of class '<em>Position</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Position</em>'.
	 * @generated
	 */
	Position createPosition();

	/**
	 * Returns a new object of class '<em>Size</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Size</em>'.
	 * @generated
	 */
	Size createSize();

	/**
	 * Returns a new object of class '<em>Tab Folder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tab Folder</em>'.
	 * @generated
	 */
	TabFolder createTabFolder();

	/**
	 * Returns a new object of class '<em>Page Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Page Ref</em>'.
	 * @generated
	 */
	PageRef createPageRef();

	/**
	 * Returns a new object of class '<em>Sash Panel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sash Panel</em>'.
	 * @generated
	 */
	SashPanel createSashPanel();

	/**
	 * Returns a new object of class '<em>Abstract Page</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract Page</em>'.
	 * @generated
	 */
	AbstractPage createAbstractPage();

	/**
	 * Returns a new object of class '<em>Page List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Page List</em>'.
	 * @generated
	 */
	@Deprecated
	PageList createPageList();

	/**
	 * Returns a new object of class '<em>Sash Windows Mngr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sash Windows Mngr</em>'.
	 * @generated
	 */
	SashWindowsMngr createSashWindowsMngr();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DiPackage getDiPackage();

} //DiFactory
