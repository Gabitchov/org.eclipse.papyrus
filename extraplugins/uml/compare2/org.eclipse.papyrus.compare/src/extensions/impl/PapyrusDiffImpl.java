/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package extensions.impl;

import org.eclipse.emf.compare.impl.DiffImpl;
import org.eclipse.emf.ecore.EClass;

import extensions.ExtensionsPackage;
import extensions.PapyrusDiff;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Papyrus Diff</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class PapyrusDiffImpl extends DiffImpl implements PapyrusDiff {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PapyrusDiffImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExtensionsPackage.Literals.PAPYRUS_DIFF;
	}

} //PapyrusDiffImpl
