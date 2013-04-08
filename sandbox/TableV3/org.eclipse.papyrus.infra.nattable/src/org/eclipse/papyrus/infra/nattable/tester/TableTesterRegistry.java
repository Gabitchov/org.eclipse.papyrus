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
package org.eclipse.papyrus.infra.nattable.tester;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.messages.Messages;


public class TableTesterRegistry {


	private static final String EXTENSION_ID = "org.eclipse.papyrus.infra.nattable.tester"; //$NON-NLS-1$

	private static final String CLASS_ATTRIBUTE = "class"; //$NON-NLS-1$

	private static final String ID_ATTRIBUTE = "id"; //$NON-NLS-1$

	private Map<String, ITableTester> testers;

	public static final TableTesterRegistry INSTANCE = new TableTesterRegistry();

	private TableTesterRegistry() {
		//to prevent instanciation
	}

	/**
	 * 
	 * @param tableType
	 *        the type of the table
	 * @return
	 *         the URI of the configuration to use for this table or <code>null</code> if not found
	 */
	public ITableTester getTableTester(final String testerId) {
		if(this.testers == null) {
			this.testers = new HashMap<String, ITableTester>();
			final IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);
			for(final IConfigurationElement iConfigurationElement : configElements) {
				String id = iConfigurationElement.getAttribute(ID_ATTRIBUTE);
				if(this.testers.containsKey(id)) {
					Activator.log.warn(String.format(Messages.TableTesterRegistry_SeveralTesterAreRegisteredWithTheSameId, id));
				} else {
					ITableTester tester = null;
					try {
						tester = (ITableTester)iConfigurationElement.createExecutableExtension(CLASS_ATTRIBUTE);
						this.testers.put(id, tester);
					} catch (CoreException e) {
						Activator.log.error(String.format(Messages.TableTesterRegistry_TheClassCantBeLoaded, id), e);
					}

				}
			}
		}
		return this.testers.get(testerId);
	}
}
