/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (Patrick.Tessier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf;

import java.util.Comparator;

import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
/**
 * this class is used to compare customization by taking in account the rank of the customization
 *
 */
public class CustomizationComparator implements Comparator<Customization>{
	 
    public int compare(Customization o1, Customization o2) {
        return (o1.getRank()<o2.getRank() ? -1 : (o1.getRank()==o2.getRank() ? 0 : 1));
    }
} 
