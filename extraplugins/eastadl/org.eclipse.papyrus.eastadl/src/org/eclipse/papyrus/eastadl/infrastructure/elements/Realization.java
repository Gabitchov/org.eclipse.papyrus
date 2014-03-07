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
package org.eclipse.papyrus.eastadl.infrastructure.elements;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Realization</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * The Realization is a relationship which relates two or more elements across boundaries of the EAST-ADL2 abstraction levels.
 * 
 * It identifies an element that serves as a specification within this realization relationship and on the other side it identifies an element that is
 * supposed to realize this specification on a lower abstraction level or an implementation.
 * 
 * 
 * Semantics:
 * The modification of the supplier realized element impact the realizing client entity. The Realization metaclass implies the semantics that the
 * realizing client is not complete, without the supplier.
 * 
 * Notation:
 * A Realization relationship is shown as a dashed line with a triangular arrowhead at the end that corresponds to the realized entity. The entity at
 * the tail of the arrow (the realizing EAElement or the realizing ARElement) depends on the entity at the arrowhead (the realized EAElement).
 * 
 * Changes:
 * Renamed from Realization.
 * 
 * Extension: Realization
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.elements.Realization#getRealized <em>Realized</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.elements.Realization#getRealizedBy <em>Realized By</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.elements.Realization#getBase_Realization <em>Base Realization</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.elements.Realization#getRealizedBy_path <em>Realized By path</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.elements.Realization#getRealized_path <em>Realized path</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage#getRealization()
 * @model
 * @generated
 */
public interface Realization extends Relationship {

	/**
	 * Returns the value of the '<em><b>Realized</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of ADL entities, which are realized by the set of client ADL entities or realized by the set of client AUTOSAR elements.
	 * {derived from UML::DirectedRelationship::target}
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Realized</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage#getRealization_Realized()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<EAElement> getRealized();

	/**
	 * Returns the value of the '<em><b>Realized By</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of client ADL entities, realizing the set of supplier ADL entities.
	 * {derived from UML::Dependency::client}
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Realized By</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage#getRealization_RealizedBy()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<NamedElement> getRealizedBy();

	/**
	 * Returns the value of the '<em><b>Base Realization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Realization</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Realization</em>' reference.
	 * @see #setBase_Realization(org.eclipse.uml2.uml.Realization)
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage#getRealization_Base_Realization()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Realization getBase_Realization();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.infrastructure.elements.Realization#getBase_Realization <em>Base Realization</em>}'
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Realization</em>' reference.
	 * @see #getBase_Realization()
	 * @generated
	 */
	void setBase_Realization(org.eclipse.uml2.uml.Realization value);

	/**
	 * Returns the value of the '<em><b>Realized By path</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realized By path</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Realized By path</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage#getRealization_RealizedBy_path()
	 * @model
	 * @generated
	 */
	EList<NamedElement> getRealizedBy_path();

	/**
	 * Returns the value of the '<em><b>Realized path</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realized path</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Realized path</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage#getRealization_Realized_path()
	 * @model
	 * @generated
	 */
	EList<NamedElement> getRealized_path();

} // Realization
