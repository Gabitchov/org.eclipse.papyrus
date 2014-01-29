/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.providers;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.papyrus.infra.emf.appearance.style.ILabelMaskProvider;
import org.eclipse.papyrus.uml.diagram.sequence.edit.helpers.MessageLabelHelper;
import org.eclipse.uml2.uml.Message;

/**
 * An IAdapterFactory for retrieving the {@link ILabelMaskProvider} from a UML
 * Message
 * 
 * @author Camille Letavernier
 * 
 */
public class MessageLabelMaskProviderAdapterFactory implements IAdapterFactory {

	@Override
	public ILabelMaskProvider getAdapter(Object adaptableObject, Class adapterType) {
		if(adapterType == ILabelMaskProvider.class) {
			if(adaptableObject instanceof Message) {
				return MessageLabelHelper.getInstance();
			}
		}
		return null;
	}

	@Override
	public Class<?>[] getAdapterList() {
		return new Class[]{ ILabelMaskProvider.class };
	}

}
