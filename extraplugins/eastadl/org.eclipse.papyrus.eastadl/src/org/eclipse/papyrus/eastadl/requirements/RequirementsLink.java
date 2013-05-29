/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.requirements;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * RequirementsLink represents a relation between two or more Requirements. Source and target Requirements of the relation are distinguished, which means that the relation is directed (from source to target). If such a distinction does not make sense, then use a RequirementsGroup instead.
 * 
 * The standard case will be a relation with one source and one target Requirement. However, it is possible to have several source and/or several target Requirements so that general relations can be expressed with instances of this metaclass.
 * 
 * The semantic of a concrete Requirement relation can be provided by the modeler. In particular, three ways are conceivable:
 * 
 * (1) The user attributes of the relation can be used to specify its meaning, for example with a user attribute called "relationType" which is set to values such as "needs" or "excludes".
 * 
 * (2) The UserAttributeElementType can be used. Certain types will be used for certain relation semantics.
 * 
 * (3) RequirementsRelationGroups can be used, i.e. all relations with an "excludes" meaning are put in one relation group and all with a "needs" meaning are put in another.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.requirements.RequirementsLink#isIsBidirectional <em>Is Bidirectional</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.requirements.RequirementsLink#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.requirements.RequirementsLink#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getRequirementsLink()
 * @model
 * @generated
 */
public interface RequirementsLink extends RequirementsRelationship {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.requirements.Requirement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getRequirementsLink_Source()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<Requirement> getSource();

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.requirements.Requirement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getRequirementsLink_Target()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<Requirement> getTarget();

	/**
	 * Returns the value of the '<em><b>Is Bidirectional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Bidirectional</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Bidirectional</em>' attribute.
	 * @see #setIsBidirectional(boolean)
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getRequirementsLink_IsBidirectional()
	 * @model unique="false" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsBidirectional();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsLink#isIsBidirectional <em>Is Bidirectional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Bidirectional</em>' attribute.
	 * @see #isIsBidirectional()
	 * @generated
	 */
	void setIsBidirectional(boolean value);

} // RequirementsLink
