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
package org.eclipse.papyrus.eastadl.timing.timingconstraints;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Age Timing Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Different tolerances on over-/undersampling can be identified when the solution has been modeled.
 * 
 * An age constraint is of interest in control engineering when looking back through the system.
 * 
 * In case of over- or undersampling, there is no one-to-one relation possible between the occurrences of stimuli and responses of the associated event chain. Thus, the age constraint defines the semantic of which delay must be constrained.
 * 
 * The attribute upper is applicable in worst-case analysis.
 * 
 * The attribute lower is applicable in best-case analysis.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage#getAgeTimingConstraint()
 * @model
 * @generated
 */
public interface AgeTimingConstraint extends DelayConstraint {

} // AgeTimingConstraint
