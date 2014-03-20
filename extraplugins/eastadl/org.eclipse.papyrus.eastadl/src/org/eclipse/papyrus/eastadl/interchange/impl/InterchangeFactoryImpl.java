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
package org.eclipse.papyrus.eastadl.interchange.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.eastadl.interchange.*;
import org.eclipse.papyrus.eastadl.interchange.InterchangeFactory;
import org.eclipse.papyrus.eastadl.interchange.InterchangePackage;
import org.eclipse.papyrus.eastadl.interchange.RIFExportArea;
import org.eclipse.papyrus.eastadl.interchange.RIFImportArea;


/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class InterchangeFactoryImpl extends EFactoryImpl implements InterchangeFactory {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static InterchangePackage getPackage() {
		return InterchangePackage.eINSTANCE;
	}

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static InterchangeFactory init() {
		try {
			InterchangeFactory theInterchangeFactory = (InterchangeFactory)EPackage.Registry.INSTANCE.getEFactory(InterchangePackage.eNS_URI);
			if(theInterchangeFactory != null) {
				return theInterchangeFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new InterchangeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InterchangeFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch(eClass.getClassifierID()) {
		case InterchangePackage.RIF_EXPORT_AREA:
			return createRIFExportArea();
		case InterchangePackage.RIF_IMPORT_AREA:
			return createRIFImportArea();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RIFExportArea createRIFExportArea() {
		RIFExportAreaImpl rifExportArea = new RIFExportAreaImpl();
		return rifExportArea;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RIFImportArea createRIFImportArea() {
		RIFImportAreaImpl rifImportArea = new RIFImportAreaImpl();
		return rifImportArea;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InterchangePackage getInterchangePackage() {
		return (InterchangePackage)getEPackage();
	}

} // InterchangeFactoryImpl
