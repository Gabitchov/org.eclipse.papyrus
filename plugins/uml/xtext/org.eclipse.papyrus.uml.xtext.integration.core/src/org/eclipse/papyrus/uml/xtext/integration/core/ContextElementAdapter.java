/**
 * Copyright (c) 2012 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package org.eclipse.papyrus.uml.xtext.integration.core;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.XtextResource;

/**
 * The {@link ContextElementAdapter} is added to the FakeResource to get access
 * to the context element for scoping/validation.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */

public class ContextElementAdapter extends AdapterImpl {

	public interface IContextElementProvider {
		public EObject getContextObject();
	}
	
	/**
	 * Some editors, might require a resource initialization with the context object, for instance the
	 * OCL editor. These editors should implement the interface. IContextElementProviderWithResourceUpdate
	 */
	public interface IContextElementProviderWithInit extends IContextElementProvider {
		/**
		 * Initialize the resource according to the context object. This function needs to be
		 * called after resource creation and addition to the resource set
		 * @param resource the xtext resource for the editor.
		 */
		public void initResource(XtextResource resource);
	}

	private final IContextElementProvider provider;

	public ContextElementAdapter(IContextElementProvider provider) {
		this.provider = provider;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == ContextElementAdapter.class;
	}

	public EObject getElement() {
		return provider.getContextObject();
	}
}
