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
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.table.axis;

import java.util.List;

import org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.FeatureIdAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;
import org.eclipse.papyrus.views.properties.table.custom.MultiplicityHandler;

/**
 * An AxisManager for custom/derived UML features (Such as Multiplicity)
 * 
 * @author Camille Letavernier
 * 
 */
public class DerivedUMLPropertiesAxisManager extends AbstractAxisManager {

	public static final String AXIS_MANAGER_ID = "org.eclipse.papyrus.uml.nattable.derived.features.axis.manager"; //$NON-NLS-1$

	public static final String PROPERTIES_PREFIX = "uml_derived_features:/";

	public static final String MULTIPLICITY = PROPERTIES_PREFIX + "multiplicity";

	@Override
	public synchronized void updateAxisContents() {

		final List<IAxis> axis = getRepresentedContentProvider().getAxis();
		final List<Object> axisElements = getTableManager().getElementsList(getRepresentedContentProvider());
		for(int i = 0; i < axis.size(); i++) {
			IAxis current = axis.get(i);
			if(current instanceof FeatureIdAxis) {
				FeatureIdAxis featureIDAxis = (FeatureIdAxis)current;
				String featureID = featureIDAxis.getElement();
				if(featureID != null && featureID.startsWith(PROPERTIES_PREFIX)) {
					if(MULTIPLICITY.equals(featureID)) {
						Object element = MultiplicityHandler.getInstance();
						int position = axisElements.indexOf(element);
						if(position == -1) { //New element
							axisElements.add(MultiplicityHandler.getInstance());
						} else if(position != i) { //Change position
							axisElements.remove(position);
							axisElements.add(i, element);
						}
					}
				}
			}
		}
	}

}
