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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Internal Binding</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * The InternalBinding is the private, internal ConfigurationDecisionModel of the ConfigurableContainer. It defines how the internal, lower-level
 * variability of the ConfigurableContainer is bound, i.e. configured, depending on a given configuration of the ConfigurableContainer's public
 * feature model. This way, the binding of this internal variability is encapsulated and hidden behind the public feature model, which serves as a
 * variability-related interface.
 * 
 * Note that for this use case, the source and target feature models need not be defined explicitly because they are deduced implicitly: the
 * ConfigurableContainer's public feature model serves as the (single) target feature model, and the source feature models are deduced from the
 * ConfigurableContainer's internal variability (esp. other, lower-level ConfigurableContainers which are contained).
 * 
 * For a definition of the precise meaning of 'internal variability' in the above sense (also called variable content) refer to the documentation of
 * meta-class ConfigurableContainer.
 * <!-- end-model-doc -->
 * 
 * 
 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage#getInternalBinding()
 * @model
 * @generated
 */
public interface InternalBinding extends ConfigurationDecisionModel {
} // InternalBinding
