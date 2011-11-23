/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.uml.datatype;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.papyrus.properties.uml.Activator;
import org.eclipse.papyrus.properties.util.ClassLoader;


public class DataTypeProvider {

	private final Map<String, Class<? extends DataTypeObservableValue>> observableDataTypes = new HashMap<String, Class<? extends DataTypeObservableValue>>();

	public static final String EXTENSION_ID = Activator.PLUGIN_ID + ".datatype"; //$NON-NLS-1$

	private DataTypeProvider(){
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

		for(IConfigurationElement e : config) {
			String dataTypeName = e.getAttribute("dataType"); //$NON-NLS-1$
			String observableClassName = e.getAttribute("observable"); //$NON-NLS-1$

			ClassLoader loader = new ClassLoader();
			Class<? extends DataTypeObservableValue> observableClass = loader.loadClass(observableClassName, DataTypeObservableValue.class);

			if(observableClass != null) {
				observableDataTypes.put(dataTypeName, observableClass);
			}
		}
	}

	public DataTypeObservableValue getObservableDataType(EDataType dataType) {
		ClassLoader loader = new ClassLoader();
		for(String key : observableDataTypes.keySet()) {
			if(key.equals(dataType.getName())) {
				return loader.newInstance(observableDataTypes.get(key));
			}
		}
		return null;
	}

	public boolean canHandle(EDataType eType) {
		return this.observableDataTypes.containsKey(eType.getName());
	}

	public static DataTypeProvider instance = new DataTypeProvider();
}
