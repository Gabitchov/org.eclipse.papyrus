/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.ui.toolbox.notification.builders;

import java.util.HashMap;
import java.util.Map;


/**
 * The Class Context.
 */
public interface IContext {

	/**
	 * This constant allows the user to retrieve the composite created if he filled a ICreationComposite
	 */
	public static String COMPOSITE_CREATED = "composite_created";

	public void put(String s, Object o);

	public Object get(String s);

	public static class Context implements IContext {

		private Map<String, Object> objects = new HashMap<String, Object>();;

		public void put(String s, Object o) {
			objects.put(s, o);
		}

		public Object get(String s) {
			return objects.get(s);
		}

	}

}
