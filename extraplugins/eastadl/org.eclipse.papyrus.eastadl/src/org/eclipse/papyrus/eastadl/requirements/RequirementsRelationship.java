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

import org.eclipse.papyrus.eastadl.infrastructure.elements.Relationship;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A relation between two or more requirements.  Source and target requirements of the relation are distinguished, which means that the relation is directed (from source to target).  If such a distinction does not make sense, then use a ReqGroup instead.
 * The standard case will be a relation with one source and one target requirement.  However, it is possible to have several source and-or several target requirements so that general n:m relations can be expressed with instances of this class.
 * The semantic of a concrete requirement relation is not defined by the EAST-ADL2 and therefore needs to be provided by the modeler.  In particular, three ways are conceivable:
 * 1) The user attributes of the relation can be used to specify its meaning, for example with a user attribute called relationType which is set to values such as needs or excludes.
 * 2) The uaType (user attributeable element type) can be used.  Certain types will be used for certain relation semantics.
 * 3) ReqRelationGroups can be used, i.e. all relations with an excludes meaning are put in one relation group and all with a needs meaning are put in another
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.requirements.RequirementsRelationship#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getRequirementsRelationship()
 * @model abstract="true"
 * @generated
 */
public interface RequirementsRelationship extends Relationship {
	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getRequirementsRelationship_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsRelationship#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

} // RequirementsRelationship
