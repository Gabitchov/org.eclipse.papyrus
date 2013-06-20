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
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.designer.core.transformations;

/**
 * A set of constants used for the CIF. In particular prefixes for the operations
 * to access the implementation of a provided interface and connect a required interface
 *
 */
public class PrefixConstants {

	public static String getP_Prefix = "get_"; //$NON-NLS-1$

	public static String getConnQ_Prefix = ""; //$NON-NLS-1$

	public static String connectQ_Prefix = "connect_"; //$NON-NLS-1$

	@Deprecated
	public static String equivIntfPrefix = "CCM_"; //$NON-NLS-1$

	public static String attributePrefix = ""; //$NON-NLS-1$

	enum CIFvariant {
		UML, CCM
	};

	/**
	 * Initialize a specific CIF variant
	 * 
	 * TODO might be currently unused
	 * @param cif
	 */
	void init(CIFvariant cif) {
		if(cif == CIFvariant.UML) {
			getP_Prefix = "get_";
			// empty indicates that no getConnQ operation should be generated
			getConnQ_Prefix = "";
			connectQ_Prefix = "connect_";
			// equivIntfPrefix = "CCM_";
			attributePrefix = "";
		} else if(cif == CIFvariant.CCM) {
			getP_Prefix = "get_";
			getConnQ_Prefix = "getconnection_";
			connectQ_Prefix = "connect_";
			// equivIntfPrefix = "CCM_";
			attributePrefix = "m_";
		}
	}
};
