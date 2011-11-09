/*****************************************************************************
 * Copyright (c) 2011 Atos Origin Integration.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin Integration) tristan.faure@atosorigin.com - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.onefile.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.onefile.Activator;
import org.osgi.framework.Bundle;

/**
 * Helper class able to get the correct {@link IPapyrusModelFactory}
 * 
 * @author tfaure
 * 
 */
public class PapyrusModelHelper {

	private static final String MODEL_FACTORY = "modelFactory";
	static List<Segment> segments;

	static {
		IConfigurationElement[] elements = Platform
				.getExtensionRegistry()
				.getConfigurationElementsFor(Activator.PLUGIN_ID, MODEL_FACTORY);
		segments = new ArrayList<PapyrusModelHelper.Segment>(elements.length);
		for (IConfigurationElement e : elements) {
			Segment s = new PapyrusModelHelper.Segment();
			try {
				s.priority = Integer.parseInt(e.getAttribute("priority"));
				s.bundle = Platform.getBundle(e.getContributor().getName());
				s.className = e.getAttribute("instance");
				segments.add(s);
			} catch (NumberFormatException ex) {
				// in case of exception the process continue but the stack is
				// traced
				ex.printStackTrace();
			}
		}
		// sort elements according to their priorities
		Collections.sort(segments, new Comparator<Segment>() {
			public int compare(Segment o1, Segment o2) {
				Integer val1 = 0;
				Integer val2 = 0;
				if (o1 != null) {
					val1 = o1.priority;
				}
				if (o2 != null) {
					val2 = o2.priority;
				}
				return val1.compareTo(val2);
			}
		});
	}

	/**
	 * get the {@link IPapyrusModelFactory} in the current platform
	 * 
	 * @return a {@link IPapyrusModelFactory}
	 */
	public static IPapyrusModelFactory getPapyrusModelFactory() {
		if (segments == null || segments.size() == 0) {
			throw new RuntimeException(
					"Initialisation error, please register extension to "
							+ Activator.PLUGIN_ID + "." + MODEL_FACTORY);
		}
		// segments are sorted by priorities, the highest is at the end of the
		// list
		return segments.get(segments.size() - 1).getFactory();
	}

	/**
	 * Utility class to save extension point information
	 * 
	 */
	private static class Segment {
		public String className;
		Bundle bundle;
		int priority;
		IPapyrusModelFactory instance = null;

		IPapyrusModelFactory getFactory() {
			if (instance == null) {
				try {
					instance = (IPapyrusModelFactory) bundle.loadClass(
							className).newInstance();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			return instance;
		}
	}
}
