/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage
 * @generated
 */
public interface PapyrusgmfgenextensionFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	PapyrusgmfgenextensionFactory eINSTANCE = org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Extended Gen View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Extended Gen View</em>'.
	 * @generated
	 */
	ExtendedGenView createExtendedGenView();

	/**
	 * Returns a new object of class '<em>Commented Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Commented Element</em>'.
	 * @generated
	 */
	CommentedElement createCommentedElement();

	/**
	 * Returns a new object of class '<em>Property Refresh Hook</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Property Refresh Hook</em>'.
	 * @generated
	 */
	PropertyRefreshHook createPropertyRefreshHook();

	/**
	 * Returns a new object of class '<em>External Hook</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>External Hook</em>'.
	 * @generated
	 */
	ExternalHook createExternalHook();

	/**
	 * Returns a new object of class '<em>Specific Locator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Specific Locator</em>'.
	 * @generated
	 */
	SpecificLocator createSpecificLocator();

	/**
	 * Returns a new object of class '<em>Papyrus Extension Root Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Papyrus Extension Root Node</em>'.
	 * @generated
	 */
	PapyrusExtensionRootNode createPapyrusExtensionRootNode();

	/**
	 * Returns a new object of class '<em>Alternate Canvas</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Alternate Canvas</em>'.
	 * @generated
	 */
	AlternateCanvas createAlternateCanvas();

	/**
	 * Returns a new object of class '<em>Alternate Gen Top Level Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Alternate Gen Top Level Node</em>'.
	 * @generated
	 */
	AlternateGenTopLevelNode createAlternateGenTopLevelNode();

	/**
	 * Returns a new object of class '<em>Alternate Gen Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Alternate Gen Link</em>'.
	 * @generated
	 */
	AlternateGenLink createAlternateGenLink();

	/**
	 * Returns a new object of class '<em>Mutating Canvas</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Mutating Canvas</em>'.
	 * @generated
	 */
	MutatingCanvas createMutatingCanvas();

	/**
	 * Returns a new object of class '<em>Owned Editpart</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Owned Editpart</em>'.
	 * @generated
	 */
	OwnedEditpart createOwnedEditpart();

	/**
	 * Returns a new object of class '<em>Specific Diagram Updater</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Specific Diagram Updater</em>'.
	 * @generated
	 */
	SpecificDiagramUpdater createSpecificDiagramUpdater();

	/**
	 * Returns a new object of class '<em>Gen Node Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Gen Node Constraint</em>'.
	 * @generated
	 */
	GenNodeConstraint createGenNodeConstraint();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	PapyrusgmfgenextensionPackage getPapyrusgmfgenextensionPackage();

} //PapyrusgmfgenextensionFactory
