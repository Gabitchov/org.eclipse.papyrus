/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Jerome Benois (Obeo) jerome.benois@obeo.fr - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.core.extension.commands;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.papyrus.core.extension.BadNameExtensionException;
import org.eclipse.papyrus.core.extension.DescriptorExtensionFactory;
import org.eclipse.papyrus.core.extension.ExtensionException;
import org.eclipse.papyrus.core.utils.IDebugChannel;
import org.eclipse.papyrus.core.utils.PapyrusTrace;

/**
 * A factory used to create CreationCommand object from Eclipse extensions points elements.
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class CreationCommandExtensionFactory extends DescriptorExtensionFactory {

	/** singleton eINSTANCE of this class */
	public final static CreationCommandExtensionFactory eINSTANCE = new CreationCommandExtensionFactory();

	/** constant for the creation command **/
	public final static String CREATION_COMMAND_EXTENSIONPOINT = "creationCommand";

	/** constant for the attribute creationCommandClass **/
	public final static String CREATION_COMMAND_CLASS_ATTR = "creationCommandClass";

	/** constant for the attribute label **/
	public final static String LABEL_ATTR = "label";

	/** constant for the attribute contextId **/
	public final static String ID_ATTRIBUTE = "id";

	/**
	 * @return the eINSTANCE
	 */
	public static CreationCommandExtensionFactory getInstance() {
		return eINSTANCE;
	}

	/**
	 * Create a CreationCommand instance corresponding to the ConfigurationElement.
	 * 
	 * @param element
	 *            an {@link IConfigurationElement} see eclipse extension point
	 * @return a CreationCommandDescriptor structure that contains information to the creation diagram command
	 * @throws BadNameExtensionException
	 **/
	public CreationCommandDescriptor createCreationCommand(IConfigurationElement element) throws ExtensionException {
		CreationCommandDescriptor res;

		checkTagName(element, CREATION_COMMAND_EXTENSIONPOINT);

		res = new CreationCommandDescriptor();
		res.creationCommandClass = (Class<ICreationCommand>) parseClass(element, CREATION_COMMAND_CLASS_ATTR, CREATION_COMMAND_EXTENSIONPOINT);
		res.commandId = element.getAttribute(ID_ATTRIBUTE);
		res.label = element.getAttribute(LABEL_ATTR);
		PapyrusTrace.trace(IDebugChannel.PAPYRUS_EXTENSIONPOINT_LOADING, this, "a creation command ready " + res);

		return res;
	}

}