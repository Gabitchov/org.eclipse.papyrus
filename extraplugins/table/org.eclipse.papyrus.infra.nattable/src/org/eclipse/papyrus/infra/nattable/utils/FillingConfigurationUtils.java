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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.utils;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IFillingConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.PasteEObjectConfiguration;


public class FillingConfigurationUtils {


	private FillingConfigurationUtils() {
		//to prevent instanciation
	}

	/**
	 * 
	 * @param table
	 *        the table
	 * @param onColumn
	 *        <code>true</code> if the user is working on column and false if not
	 * @return
	 *         the list of the filling configuration used by the table
	 */
	//FIXME : doesn't yet manage the local filling configuration
	public static final Collection<IFillingConfiguration> getFillingConfigurationUsedInTable(final Table table, final boolean onColumn) {
		final Collection<IFillingConfiguration> confs = new ArrayList<IFillingConfiguration>();


		AbstractHeaderAxisConfiguration tableHeaderAxisConfiguration;
		if(onColumn) {
			tableHeaderAxisConfiguration = HeaderAxisConfigurationManagementUtils.getColumnAbstractHeaderAxisInTableConfiguration(table);
		} else {
			tableHeaderAxisConfiguration = HeaderAxisConfigurationManagementUtils.getRowAbstractHeaderAxisInTableConfiguration(table);
		}

		for(final IAxisConfiguration currentConfiguration : tableHeaderAxisConfiguration.getOwnedAxisConfigurations()) {
			if(currentConfiguration instanceof IFillingConfiguration) {
				confs.add((IFillingConfiguration)currentConfiguration);
			}
		}

		return confs;
	}

	/**
	 * 
	 * @param table
	 *        the table
	 * @param onColumn
	 *        true if we are working on column
	 * @return
	 *         the element type id to create or <code>null</code> if not found
	 */
	public static String getElementTypeIdToCreate(final Table table, final boolean onColumn) {
		final Collection<IFillingConfiguration> fillingConfiguration = FillingConfigurationUtils.getFillingConfigurationUsedInTable(table, onColumn);
		for(IFillingConfiguration iFillingConfiguration : fillingConfiguration) {
			if(iFillingConfiguration instanceof PasteEObjectConfiguration) {
				return ((PasteEObjectConfiguration)fillingConfiguration).getPastedElementId();
			}
		}
		return null;
	}

	/**
	 * 
	 * @param table
	 *        the table
	 * @param onColumn
	 *        true if we are working on column
	 * @return
	 *         the containment feature to use for created element
	 */
	public static EStructuralFeature getContainmentFeature(final Table table, final boolean onColumn) {
		final Collection<IFillingConfiguration> fillingConfiguration = FillingConfigurationUtils.getFillingConfigurationUsedInTable(table, onColumn);
		for(IFillingConfiguration iFillingConfiguration : fillingConfiguration) {
			if(iFillingConfiguration instanceof PasteEObjectConfiguration) {
				return ((PasteEObjectConfiguration)fillingConfiguration).getPasteElementContainementFeature();
			}
		}
		return null;
	}
}
