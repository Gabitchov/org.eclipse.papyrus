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
package org.eclipse.papyrus.eastadl.structure.functionmodeling.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionalDevice;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage;


/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Functional Device</b></em> '. <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class FunctionalDeviceImpl extends AnalysisFunctionTypeImpl implements FunctionalDevice {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected FunctionalDeviceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionmodelingPackage.Literals.FUNCTIONAL_DEVICE;
	}

} // FunctionalDeviceImpl
