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
package org.eclipse.papyrus.eastadl.structure.hardwaremodeling;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Power Hardware Pin</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * PowerHardwarePin represents a pin that is primarily intended for power supply, either providing or consuming energy.
 * 
 * Semantics:
 * A PowerHardwarePin is primarily intended to be a power supply. The direction attribute of the pin defines whether it is providing or consuming
 * energy
 * 
 * Notation:
 * PowerHardwarePin is shown as a solid square with PWR inside. Its name may appear outside the square.
 * <!-- end-model-doc -->
 * 
 * 
 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwaremodelingPackage#getPowerHardwarePin()
 * @model
 * @generated
 */
public interface PowerHardwarePin extends HardwarePin {
} // PowerHardwarePin
