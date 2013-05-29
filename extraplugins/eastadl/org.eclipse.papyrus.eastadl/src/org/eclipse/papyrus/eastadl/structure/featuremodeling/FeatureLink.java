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
package org.eclipse.papyrus.eastadl.structure.featuremodeling;

import org.eclipse.papyrus.eastadl.infrastructure.elements.Relationship;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.Dependency;


/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Feature Link</b></em>'. <!--
 * end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A FeatureLink resembles a Relationship between two Features referred to as 'start' and 'end' feature (such as "feature S requires feature E" or "S excludes E").
 * 
 * The type of the FeatureLink specifies the precise semantics of the relationship. There are several predefined types, for example "needs" states that S requires E. In addition, user-defined types are allowed as well. For user-defined types, attribute 'customType' provides a unique identifier of the custom link type and attribute 'isBidirectional' states whether the link is uni- or bidirectional.
 * 
 * FeatureLinks are similar to FeatureConstraints but much more restricted. The rationale for having FeatureLinks in addition to FeatureConstraints is that in many cases FeatureLinks are sufficient and tools can deal with them more easily and appropriately (e.g. they can easily be presented visually as arrows in a diagram).
 * 
 * 
 * Semantics:
 * The FeatureLink is a relationship between Features that may constraint the selection of Features involved in the relationship.
 * 
 * 
 * Constraints:
 * [1] The start and end Features of a FeatureLink must be contained in the FeatureModel that contains the FeatureLink.
 * 
 * Extension:
 * AssociationClass
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#isIsBidirectional <em>Is Bidirectional</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#getCustomType <em>Custom Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#getBase_Dependency <em>Base Dependency</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#getStart <em>Start</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#getEnd <em>End</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#getBase_AssociationClass <em>Base Association Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeatureLink()
 * @model
 * @generated
 */
public interface FeatureLink extends Relationship {

	/**
	 * Returns the value of the '<em><b>Custom Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Custom Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Custom Type</em>' attribute.
	 * @see #setCustomType(String)
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeatureLink_CustomType()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getCustomType();

	/**
	 * Returns the value of the '<em><b>End</b></em>' reference. It is bidirectional and its
	 * opposite is '
	 * {@link org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature#getEndingLink
	 * <em>Ending Link</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> The target feature of the dependency. {derived
	 * from UML::DirectedRelationship::target} <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>End</em>' reference.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeatureLink_End()
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature#getEndingLink
	 * @model opposite="endingLink" required="true" transient="true" changeable="false"
	 *        volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	Feature getEnd();

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.eastadl.structure.featuremodeling.VariabilityDependencyKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.VariabilityDependencyKind
	 * @see #setKind(VariabilityDependencyKind)
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeatureLink_Kind()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	VariabilityDependencyKind getKind();

	/**
	 * Returns the value of the '<em><b>Start</b></em>' reference. It is bidirectional and its
	 * opposite is '
	 * {@link org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature#getStartingLink
	 * <em>Starting Link</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> The source feature of the dependency. {derived
	 * from UML::DirectedRelationship::source} <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Start</em>' reference.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeatureLink_Start()
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature#getStartingLink
	 * @model opposite="startingLink" required="true" transient="true" changeable="false"
	 *        volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	Feature getStart();

	/**
	 * Returns the value of the '<em><b>Is Bidirectional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Bidirectional</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Bidirectional</em>' attribute.
	 * @see #setIsBidirectional(boolean)
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeatureLink_IsBidirectional()
	 * @model dataType="org.eclipse.uml2.types.Boolean" ordered="false"
	 * @generated
	 */
	boolean isIsBidirectional();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#getCustomType <em>Custom Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Custom Type</em>' attribute.
	 * @see #getCustomType()
	 * @generated
	 */
	void setCustomType(String value);

	/**
	 * Returns the value of the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Dependency</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Dependency</em>' reference.
	 * @see #setBase_Dependency(Dependency)
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeatureLink_Base_Dependency()
	 * @model ordered="false"
	 * @generated
	 */
	Dependency getBase_Dependency();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#getBase_Dependency <em>Base Dependency</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Dependency</em>' reference.
	 * @see #getBase_Dependency()
	 * @generated
	 */
	void setBase_Dependency(Dependency value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#getEnd <em>End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' reference.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(Feature value);

	/**
	 * Returns the value of the '<em><b>Base Association Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Association Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Association Class</em>' reference.
	 * @see #setBase_AssociationClass(AssociationClass)
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage#getFeatureLink_Base_AssociationClass()
	 * @model ordered="false"
	 * @generated
	 */
	AssociationClass getBase_AssociationClass();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#getBase_AssociationClass <em>Base Association Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Association Class</em>' reference.
	 * @see #getBase_AssociationClass()
	 * @generated
	 */
	void setBase_AssociationClass(AssociationClass value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#isIsBidirectional <em>Is Bidirectional</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Bidirectional</em>' attribute.
	 * @see #isIsBidirectional()
	 * @generated
	 */
	void setIsBidirectional(boolean value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.eastadl.structure.featuremodeling.VariabilityDependencyKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(VariabilityDependencyKind value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink#getStart <em>Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' reference.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(Feature value);

} // FeatureLink
