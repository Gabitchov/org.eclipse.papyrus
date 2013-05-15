/*****************************************************************************
 * Copyright (c) 2011 Atos
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE - tristan.faure@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider;


/**
 * Interface for adaptation, if instantiated it mean it can be opened
 * 
 * @author tfaure
 * 
 */
public interface IOpenable {

	Object getPageIdentifier();

	static class Openable implements IOpenable {

		private final Object identifier;

		public Openable(Object identifier) {
			this.identifier = identifier;
		}

		public Object getPageIdentifier() {
			return identifier;
		}
	}
}
