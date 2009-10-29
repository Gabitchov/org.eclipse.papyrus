/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.extension.editorcontext;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.papyrus.core.extension.BadNameExtensionException;
import org.eclipse.papyrus.core.extension.DescriptorExtensionFactory;
import org.eclipse.papyrus.core.extension.ExtensionException;
import org.eclipse.papyrus.core.utils.IDebugChannel;
import org.eclipse.papyrus.core.utils.PapyrusTrace;

/**
 * A factory used to create ContextDescriptor object from Eclipse extensions points elements.
 * 
 * @author Cedric Dumoulin
 *@auhtor Patrick Tessier
 */
public class ContextDescriptorExtensionFactory extends DescriptorExtensionFactory {

	/** singleton eINSTANCE of this class */
	public final static ContextDescriptorExtensionFactory eINSTANCE = new ContextDescriptorExtensionFactory();

	/** constant for the editor diagram **/
	public final static String EDITOR_CONTEXT_EXTENSIONPOINT = "editorContext";

	/** constant for the attribute factoryClass **/
	public final static String CONTEXTCLASS_ATTRIBUTE = "contextClass";

	/** constant for the attribute contextId **/
	public final static String ID_ATTRIBUTE = "id";

	/**
	 * @return the eINSTANCE
	 */
	// @unused
	public static ContextDescriptorExtensionFactory getInstance() {
		return eINSTANCE;
	}

	/**
	 * Create a ContextDescriptor instance corresponding to the ConfigurationElement.
	 * 
	 * @param element
	 *            an {@link IConfigurationElement} see eclipse extension point
	 * @return a ContextDescriptor structure that contains information to the diagram context
	 * @throws BadNameExtensionException
	 **/
	public ContextDescriptor createContextDescriptor(IConfigurationElement element) throws ExtensionException {
		ContextDescriptor res;

		checkTagName(element, EDITOR_CONTEXT_EXTENSIONPOINT);

		res = new ContextDescriptor();
		res.contextClass = (Class<IEditorContext>) parseClass(element, CONTEXTCLASS_ATTRIBUTE,
				EDITOR_CONTEXT_EXTENSIONPOINT);
		res.contextId = element.getAttribute(ID_ATTRIBUTE);
		PapyrusTrace.trace(IDebugChannel.PAPYRUS_EXTENSIONPOINT_LOADING, this, "a context editor ready " + res);

		return res;
	}

}