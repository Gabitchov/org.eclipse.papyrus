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
package org.eclipse.papyrus.eastadl.variability;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration Decision</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * ConfigurationDecision represents a single, atomized rule on how to configure the target feature model(s) of the containing ConfigurationDecisionModel, depending on a given configuration of the source feature model(s). Two examples are: "all North American (USA+Canada) cars except A-Class have cruise control" (one ConfigurationDecision) or "all Canadian cars have adaptive cruise control" (another ConfigurationDecision). All ConfigurationDecisions within a single ConfigurationDecisionModel then specify how the target feature model(s) are to be configured depending on the configuration of the source feature model(s).
 * 
 * Example: Lets assume we have two FeatureModels: FM1 and FM2. FM1 has possible end-customer decisions like USA, Canada, EU, Japan and A-Class, C-Class, etc. FM2 has another possible end-customer decision such as CruiseControl, AdaptiveCruiseControl, RearWiper, RainSensor. End-customer decisions in FM2 describe possible technical features of the delivered products. By way of a set of ConfigurationDecisions it is now possible to define the configuration of FM2 (i.e. if there is a RainSensor, etc.) in dependency of a configuration of FM1. In other words, with a ConfigurationDecision we can express something like: "If USA is selected in FM1 AND A-Class is not selected in FM1, then CruiseControl will be selected in FM2".
 * 
 * The two most important constituents of a ConfigurationDecision are its 'criterion' and 'effect'. The effect is a list of things to select and deselect in the target(!) configuration(s), whereas the criterion formulates a condition on the source(!) configuration(s) under which this ConfigurationDecision's effect will actually be applied to the target configuration(s). In the first example above, the criterion would be "USA & not A-Class" and the effect would be "CruiseControl[+]".
 * 
 * 
 * Semantics:
 * The ConfigurationDecision excludes or includes Features based on a given criterion.
 * 
 * The elements of the criterion and effect attributes may be identified through the target and the source in the selectionCriterion. The criterion and effect attributes can contain a VSL expression with qualified names of the identified elements. 
 * 
 * Extension:
 * Class
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecision#getEffect <em>Effect</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecision#getCriterion <em>Criterion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecision#isIsEquivalence <em>Is Equivalence</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecision#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecision#getSelectionCriterion <em>Selection Criterion</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getConfigurationDecision()
 * @model
 * @generated
 */
public interface ConfigurationDecision extends ConfigurationDecisionModelEntry {
	/**
	 * Returns the value of the '<em><b>Criterion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The inclusionCriterion gives the criterion to select the respective products (e.g. Northern American cars).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Criterion</em>' attribute.
	 * @see #setCriterion(String)
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getConfigurationDecision_Criterion()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getCriterion();

	/**
	 * Returns the value of the '<em><b>Effect</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The rationale gives the reason for the specified product decision, especially for the inclusion criterion and the selection of included and excluded features.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Effect</em>' attribute.
	 * @see #setEffect(String)
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getConfigurationDecision_Effect()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getEffect();

	/**
	 * Returns the value of the '<em><b>Selection Criterion</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selection Criterion</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selection Criterion</em>' reference.
	 * @see #setSelectionCriterion(SelectionCriterion)
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getConfigurationDecision_SelectionCriterion()
	 * @model ordered="false"
	 * @generated
	 */
	SelectionCriterion getSelectionCriterion();

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getConfigurationDecision_Target()
	 * @model
	 * @generated
	 */
	EList<NamedElement> getTarget();

	/**
	 * Returns the value of the '<em><b>Is Equivalence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Means that the included and excluded features are selected if and only if the specified inclusion criterion holds.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Equivalence</em>' attribute.
	 * @see #setIsEquivalence(boolean)
	 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getConfigurationDecision_IsEquivalence()
	 * @model unique="false" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsEquivalence();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecision#getCriterion <em>Criterion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Criterion</em>' attribute.
	 * @see #getCriterion()
	 * @generated
	 */
	void setCriterion(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecision#getEffect <em>Effect</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Effect</em>' attribute.
	 * @see #getEffect()
	 * @generated
	 */
	void setEffect(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecision#isIsEquivalence <em>Is Equivalence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Equivalence</em>' attribute.
	 * @see #isIsEquivalence()
	 * @generated
	 */
	void setIsEquivalence(boolean value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.variability.ConfigurationDecision#getSelectionCriterion <em>Selection Criterion</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selection Criterion</em>' reference.
	 * @see #getSelectionCriterion()
	 * @generated
	 */
	void setSelectionCriterion(SelectionCriterion value);

} // ConfigurationDecision
