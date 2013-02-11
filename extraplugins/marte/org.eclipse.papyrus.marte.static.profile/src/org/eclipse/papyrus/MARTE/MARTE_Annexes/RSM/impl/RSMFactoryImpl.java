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
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.*;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.DefaultLink;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Distribute;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.InterRepetition;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMFactory;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Reshape;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Shaped;
import org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.Tiler;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RSMFactoryImpl extends EFactoryImpl implements RSMFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RSMFactory init() {
		try {
			RSMFactory theRSMFactory = (RSMFactory)EPackage.Registry.INSTANCE.getEFactory(RSMPackage.eNS_URI);
			if (theRSMFactory != null) {
				return theRSMFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RSMFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RSMFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case RSMPackage.DEFAULT_LINK: return createDefaultLink();
			case RSMPackage.INTER_REPETITION: return createInterRepetition();
			case RSMPackage.DISTRIBUTE: return createDistribute();
			case RSMPackage.RESHAPE: return createReshape();
			case RSMPackage.TILER: return createTiler();
			case RSMPackage.SHAPED: return createShaped();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultLink createDefaultLink() {
		DefaultLinkImpl defaultLink = new DefaultLinkImpl();
		return defaultLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterRepetition createInterRepetition() {
		InterRepetitionImpl interRepetition = new InterRepetitionImpl();
		return interRepetition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Distribute createDistribute() {
		DistributeImpl distribute = new DistributeImpl();
		return distribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reshape createReshape() {
		ReshapeImpl reshape = new ReshapeImpl();
		return reshape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tiler createTiler() {
		TilerImpl tiler = new TilerImpl();
		return tiler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Shaped createShaped() {
		ShapedImpl shaped = new ShapedImpl();
		return shaped;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RSMPackage getRSMPackage() {
		return (RSMPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RSMPackage getPackage() {
		return RSMPackage.eINSTANCE;
	}

} //RSMFactoryImpl
