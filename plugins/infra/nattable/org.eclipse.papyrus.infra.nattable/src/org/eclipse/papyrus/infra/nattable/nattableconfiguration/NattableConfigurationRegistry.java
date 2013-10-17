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
package org.eclipse.papyrus.infra.nattable.nattableconfiguration;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattabletester.AbstractTableTester;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattabletester.JavaTableTester;
import org.eclipse.papyrus.infra.nattable.tester.ITableTester;
import org.eclipse.papyrus.infra.nattable.tester.TableTesterRegistry;


public class NattableConfigurationRegistry {

	public static final String EXTENSION_ID = "org.eclipse.papyrus.infra.nattable.configuration"; //$NON-NLS-1$

	public static final String FILE_ATTRIBUTE = "file"; //$NON-NLS-1$

	/**
	 * the table configuration identified by the type of the table
	 */
	private Map<String, TableConfiguration> configsURI;

	private ResourceSet resourceSet;

	public static final NattableConfigurationRegistry INSTANCE = new NattableConfigurationRegistry();

	private NattableConfigurationRegistry() {
		//to prevent instantiation
		initFields();
	}


	/**
	 * 
	 * @return
	 *         the list of the known table configuration
	 */
	public Collection<TableConfiguration> getTableConfigurations() {
		return configsURI.values();
	}

	/**
	 * 
	 * 
	 * @param newTableConfiguration
	 * @return
	 */
	public void registerTableConfiguration(final TableConfiguration newTableConfiguration) {
		configsURI.put(newTableConfiguration.getType(), newTableConfiguration);
	}


	/**
	 * 
	 * @param tableType
	 *        the type of the table
	 * @return
	 *         the URI of the configuration to use for this table or <code>null</code> if not found
	 */
	public URI getConfigurationURI(final String tableType) {
		return this.configsURI.get(tableType).eResource().getURI();
	}

	/**
	 * inits the fields of the class
	 */
	private void initFields() {
		if(this.configsURI == null) {
			this.configsURI = new HashMap<String, TableConfiguration>();
			final IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);
			this.resourceSet = new ResourceSetImpl();
			for(final IConfigurationElement iConfigurationElement : configElements) {
				Object file = iConfigurationElement.getAttribute(FILE_ATTRIBUTE);
				IContributor contributor = iConfigurationElement.getContributor();
				//we build the uri for the file
				URI uri = URI.createPlatformPluginURI(contributor.getName() + "/" + file.toString(), true);//$NON-NLS-1$ //TODO : maybe a best way?
				Resource res = this.resourceSet.getResource(uri, true);
				if(res.getContents().size() > 0) {
					EObject first = res.getContents().get(0);
					if(first instanceof TableConfiguration) {
						String type = ((TableConfiguration)first).getType();
						if(type != null) {
							if(!this.configsURI.containsKey(type)) {
								this.configsURI.put(type, (TableConfiguration)first);
							} else {
								Activator.log.warn(String.format(Messages.NattableConfigurationRegistry_SeveralConfigurationsWithTheSameType, type));
							}
						} else {
							Activator.log.warn(String.format(Messages.NattableConfigurationRegistry_NoTypeForAConfiguration, uri));
						}
					} else {
						Activator.log.warn(String.format(Messages.NattableConfigurationRegistry_TableConfigurationNotFound, uri));
					}
				} else {
					Activator.log.warn(String.format(Messages.NattableConfigurationRegistry_ResourceEmpty, uri));
				}
			}
		}
	}

	/**
	 * 
	 * @param tableType
	 *        the table type to create
	 * @param tableContext
	 *        the table context
	 * @return
	 *         a status {@link IStatus#OK} when wa can create the table or {@link IStatus#ERROR} if not
	 */
	public IStatus canCreateTable(final String tableType, final Object tableContext) {
		TableConfiguration config = this.configsURI.get(tableType);
		if(config != null) {
			AbstractTableTester tester = config.getCreationTester();
			if(tester instanceof JavaTableTester) {
				final String testerId = ((JavaTableTester)tester).getTester();
				final ITableTester myTester = TableTesterRegistry.INSTANCE.getTableTester(testerId);
				if(myTester != null) {
					return myTester.isAllowed(tableContext);
				} else {
					new Status(IStatus.ERROR, Activator.PLUGIN_ID, Messages.NattableConfigurationRegistry_TesterNotFound);
				}
			} else if(tester == null) {
				return new Status(IStatus.OK, Activator.PLUGIN_ID, Messages.NattableConfigurationRegistry_NoTesterForThisConfiguration);
			} else {
				new Status(IStatus.ERROR, Activator.PLUGIN_ID, Messages.NattableConfigurationRegistry_TesterNotManager);
			}
		}
		return new Status(IStatus.ERROR, Activator.PLUGIN_ID, Messages.NattableConfigurationRegistry_ConfigurationNotFound);
	}

}
