/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.core.sashwindows.di;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sash Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Root node of the model describing the sash windows, panels and pages.
 * A SashModel can have several windows containing panels separated by sashes. Such panels can be folders 
 * containing pages.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.SashModel#getWindows <em>Windows</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.SashModel#getCurrentSelection <em>Current Selection</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getSashModel()
 * @model
 * @generated
 */
public interface SashModel extends EObject {

	/**
	 * Returns the value of the '<em><b>Windows</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.core.sashwindows.di.Window}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Windows</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Windows</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getSashModel_Windows()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Window> getWindows();

	/**
	 * Returns the value of the '<em><b>Current Selection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Selection</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Selection</em>' reference.
	 * @see #setCurrentSelection(TabFolder)
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#getSashModel_CurrentSelection()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	TabFolder getCurrentSelection();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.sashwindows.di.SashModel#getCurrentSelection <em>Current Selection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Selection</em>' reference.
	 * @see #getCurrentSelection()
	 * @generated
	 */
	void setCurrentSelection(TabFolder value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model pageIdentifierDataType="org.eclipse.papyrus.infra.core.sashwindows.di.JavaObject" pageIdentifierRequired="true" pageIdentifierOrdered="false"
	 * @generated
	 * @deprecated use {@link #addPage(TabFolder, Object)}
	 */
	void addPage(Object pageIdentifier);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model pageIdentifierDataType="org.eclipse.papyrus.infra.core.sashwindows.di.JavaObject" pageIdentifierRequired="true" pageIdentifierOrdered="false"
	 * @generated
	 */
	void addPage(TabFolder folder, Object pageIdentifier);
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model pageIdentifierDataType="org.eclipse.papyrus.infra.core.sashwindows.di.JavaObject" pageIdentifierRequired="true" pageIdentifierOrdered="false"
	 * @generated
	 */
	void removePage(Object pageIdentifier);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model pageIdentifierDataType="org.eclipse.papyrus.infra.core.sashwindows.di.JavaObject" pageIdentifierRequired="true" pageIdentifierOrdered="false"
	 * @generated
	 */
	void removePageAndEmptyFolder(Object pageIdentifier);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model selectionRequired="true" selectionOrdered="false"
	 * @generated
	 */
	void setCurrentSelectionSilently(TabFolder selection);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Lookup the pageRef identified by the pageIdentifier.
	 * Return the pageRef or null if not found.
	 * Lookup in the entire SashModel structure.
	 * <!-- end-model-doc -->
	 * @model required="true" ordered="false" pageIdentifierDataType="org.eclipse.papyrus.infra.core.sashwindows.di.JavaObject" pageIdentifierRequired="true" pageIdentifierOrdered="false"
	 * @generated
	 */
	PageRef lookupPage(Object pageIdentifier);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model srcParentFolderRequired="true" srcParentFolderOrdered="false" srcIndexDataType="org.eclipse.papyrus.infra.core.sashwindows.di.int" srcIndexRequired="true" srcIndexOrdered="false" targetParentFolderRequired="true" targetParentFolderOrdered="false" targetIndexDataType="org.eclipse.papyrus.infra.core.sashwindows.di.int" targetIndexRequired="true" targetIndexOrdered="false"
	 * @generated
	 */
	void movePage(TabFolder srcParentFolder, int srcIndex, TabFolder targetParentFolder, int targetIndex);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model folderToInsertRequired="true" folderToInsertOrdered="false" refFolderRequired="true" refFolderOrdered="false" refFolderSideDataType="org.eclipse.papyrus.infra.core.sashwindows.di.int" refFolderSideRequired="true" refFolderSideOrdered="false"
	 * @generated
	 */
	void insertFolder(TabFolder folderToInsert, TabFolder refFolder, int refFolderSide);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model srcParentFolderRequired="true" srcParentFolderOrdered="false" srcIndexDataType="org.eclipse.papyrus.infra.core.sashwindows.di.int" srcIndexRequired="true" srcIndexOrdered="false" targetParentFolderRequired="true" targetParentFolderOrdered="false"
	 * @generated
	 */
	void movePage(TabFolder srcParentFolder, int srcIndex, TabFolder targetParentFolder);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model folderRequired="true" folderOrdered="false"
	 * @generated
	 */
	void removeEmptyFolder(TabFolder folder);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Remove all pages from the model. Only left one empty top level folder.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	void removeAllPages();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Remove pages other than the one specified from the model. Intermediate folders are also removed.
	 * <!-- end-model-doc -->
	 * @model pageIdentifierDataType="org.eclipse.papyrus.infra.core.sashwindows.di.JavaObject" pageIdentifierRequired="true" pageIdentifierOrdered="false"
	 * @generated
	 */
	void removeOtherPages(Object pageIdentifier);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Get the first available window.
	 * <!-- end-model-doc -->
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Window lookupFirstWindow();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Lookup the first available folder.
	 * <!-- end-model-doc -->
	 * @model required="true" ordered="false"
	 * @generated
	 */
	TabFolder lookupFirstFolder();

} // SashModel
