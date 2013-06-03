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
package extensions;

import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.compare.diagram.internal.extensions.NodeChange;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Papyrus Generalization Change</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link extensions.PapyrusGeneralizationChange#getGeneralizationChange <em>Generalization Change</em>}</li>
 *   <li>{@link extensions.PapyrusGeneralizationChange#getInheritedFeatureNodeChange <em>Inherited Feature Node Change</em>}</li>
 * </ul>
 * </p>
 *
 * @see extensions.ExtensionsPackage#getPapyrusGeneralizationChange()
 * @model
 * @generated
 */
@SuppressWarnings("restriction")
public interface PapyrusGeneralizationChange extends PapyrusDiff {
	/**
	 * Returns the value of the '<em><b>Generalization Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generalization Change</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generalization Change</em>' reference.
	 * @see #setGeneralizationChange(ReferenceChange)
	 * @see extensions.ExtensionsPackage#getPapyrusGeneralizationChange_GeneralizationChange()
	 * @model
	 * @generated
	 */
	ReferenceChange getGeneralizationChange();

	/**
	 * Sets the value of the '{@link extensions.PapyrusGeneralizationChange#getGeneralizationChange <em>Generalization Change</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generalization Change</em>' reference.
	 * @see #getGeneralizationChange()
	 * @generated
	 */
	void setGeneralizationChange(ReferenceChange value);

	/**
	 * Returns the value of the '<em><b>Inherited Feature Node Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inherited Feature Node Change</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherited Feature Node Change</em>' reference.
	 * @see #setInheritedFeatureNodeChange(NodeChange)
	 * @see extensions.ExtensionsPackage#getPapyrusGeneralizationChange_InheritedFeatureNodeChange()
	 * @model
	 * @generated
	 */
	NodeChange getInheritedFeatureNodeChange();

	/**
	 * Sets the value of the '{@link extensions.PapyrusGeneralizationChange#getInheritedFeatureNodeChange <em>Inherited Feature Node Change</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inherited Feature Node Change</em>' reference.
	 * @see #getInheritedFeatureNodeChange()
	 * @generated
	 */
	void setInheritedFeatureNodeChange(NodeChange value);

} // PapyrusGeneralizationChange
