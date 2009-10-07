/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alexia Allanic (Atos Origin) alexia.allanic@atosorigin.com - ZestAlgortihms Implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.layouttool.managealgorithms;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.layouttool.LayoutToolAlgorithms;
import org.eclipse.papyrus.layouttool.utils.Constants;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.Bundle;

/**
 * The class ZestAlgortihms.
 */
public class ZestAlgortihms {

	/**
	 * Gets the registered algorithmes.
	 * 
	 * @return collection of algorithms registered
	 */
	public static Collection<LayoutToolAlgorithms> getRegisteredAlgorithmes() {
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(
				Constants.EXTENSION_POINT_ID_ALGORITHMS);
		LinkedList<LayoutToolAlgorithms> algo = new LinkedList<LayoutToolAlgorithms>();
		for (IConfigurationElement e : elements) {
			try {
				LayoutToolAlgorithms algorithm = new LayoutToolAlgorithms();
				AlgorithmFactory factory = (AlgorithmFactory) e
						.createExecutableExtension(Constants.EXTENSION_CLASS_ALGORITHMS);
				algorithm.setAlgorithm(factory.createAlgorithm());
				if (e.getAttribute(Constants.EXTENSION_NAME) != null) {
					String name = e.getAttribute(Constants.EXTENSION_NAME);
					name = format(name);
					algorithm.setName(name);
				}
				if (e.getAttribute(Constants.EXTENSION_ICON) != null) {
					algorithm.setIcon(getIcon(e, e.getAttribute(Constants.EXTENSION_ICON)));
				}
				if (e.getAttribute(Constants.EXTENSION_TOOLTIP) != null) {
					algorithm.setToolTipText(e.getAttribute(Constants.EXTENSION_TOOLTIP));
				}
				if (e.getAttribute(Constants.EXTENSION_PATH) != null) {
					algorithm.setPath(e.getAttribute(Constants.EXTENSION_PATH));
				}
				algo.add(algorithm);
			} catch (CoreException e1) {
				e1.printStackTrace();
			}
			if (!algo.isEmpty()) {
				Collections.sort(algo, new Comparator<LayoutToolAlgorithms>() {

					public int compare(LayoutToolAlgorithms arg0, LayoutToolAlgorithms arg1) {
						int length0 = 0;
						if (arg0.getPath() != null) {
							String[] pathSplit0 = arg0.getPath().split("\\.");
							length0 = pathSplit0.length;
						}
						int length1 = 0;
						if (arg1.getPath() != null) {
							String[] pathSplit1 = arg1.getPath().split("\\.");
							length1 = pathSplit1.length;
						}
						if (length1 == length0) {
							String a = arg0.getPath() + arg0.getName();
							String b = arg1.getPath() + arg1.getName();
							if (a == null) {
								a = "";
							}
							if (b == null) {
								b = "";
							}
							return a.compareTo(b);
						}
						return length1 - length0;
					}

				});
			}
		}
		return algo;
	}

	/**
	 * Format.
	 * 
	 * @param name
	 *            of algorithm
	 * 
	 * @return name formated
	 */
	private static String format(String name) {
		String[] split = name.split("\\s");
		StringBuffer result = new StringBuffer("");
		for (String s : split) {
			if (s.length() > 0) {
				result.append(s.substring(0, 1).toUpperCase());
				result.append(s.substring(1, s.length()).toLowerCase());
				result.append(" ");
			}
		}
		return result.toString();
	}

	/**
	 * Gets the icon.
	 * 
	 * @param e
	 *            IConfigurationElement
	 * @param attribute
	 *            name of icon
	 * 
	 * @return icon of algorithm
	 */
	private static Image getIcon(IConfigurationElement e, String attribute) {
		try {
			Bundle bundle = Platform.getBundle(e.getContributor().getName());
			if (bundle != null) {
				URL resource = bundle.getResource(attribute);
				if (resource != null) {
					return new Image(Display.getDefault(), resource.openStream());
				}
			}
		} catch (InvalidRegistryObjectException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}
}
