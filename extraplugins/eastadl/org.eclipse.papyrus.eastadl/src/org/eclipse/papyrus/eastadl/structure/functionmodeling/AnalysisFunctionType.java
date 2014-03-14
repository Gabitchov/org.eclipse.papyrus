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
package org.eclipse.papyrus.eastadl.structure.functionmodeling;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Analysis Function Type</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * The AnalysisFunctionType is a concrete FunctionType and therefore inherits the elementary function properties from the abstract metaclass
 * FunctionType. The AnalysisFunctionType is used to model the functional structure on AnalysisLevel. The syntax of AnalysisFunctionTypes is inspired
 * from the type-prototype pattern used by AUTOSAR.
 * 
 * The AnalysisFunctions may interact with other AnalysisFunctions (i.e., also FunctionalDevices) through their FunctionPorts.
 * 
 * Furthermore, an AnalysisFunction may be decomposed into (sub-)AnalysisFunctions. This allows breaking up hierarchically the functionalities
 * provided by the parent AnalysisFunction into subfunctionalities.
 * 
 * A FunctionBehavior may be associated with each AnalysisFunction. In the case where the AnalysisFunction is decomposed, the behavior is a
 * specification for the composed behavior of the subAnalysisFunction. If the AnalysisFunction is not decomposed (i.e., if the AnalysisFunction is
 * elementary), then the behavior is describing the behavior of the subAnalysisFunction, which is to be used when building the global behavior of the
 * FunctionalAnalysisArchitecture by composition of the leaf behaviors.
 * 
 * 
 * Semantics:
 * The AnalysisFunctionType represents a node in a tree structure corresponding to the functional decomposition of a top level AnalysisFunction. The
 * AnalysisFunction is representing the analysis function used to describe the functionalities provided by a vehicle on the AnalysisLevel. At the
 * AnalysisLevel, AnalysisFunctions are defined and structured according to the functional requirements, i.e., the functionalities provided to the
 * user.
 * 
 * Constraints:
 * [1] AnalysisFunctionTypes may only be used on AnalysisLevel.
 * 
 * 
 * Extension: UML Class, specialization of SysML::Block
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.AnalysisFunctionType#getPart <em>Part</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getAnalysisFunctionType()
 * @model
 * @generated
 */
public interface AnalysisFunctionType extends FunctionType {

	/**
	 * Returns the value of the '<em><b>Part</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.structure.functionmodeling.AnalysisFunctionPrototype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Part</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage#getAnalysisFunctionType_Part()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<AnalysisFunctionPrototype> getPart();

} // AnalysisFunctionType
