/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.contexts.DataContextPackage;
import org.eclipse.papyrus.views.properties.contexts.Property;
import org.eclipse.papyrus.views.properties.environment.Namespace;

/**
 * A Helper class for miscellaneous elements of the Property view framework
 * 
 * @author Camille Letavernier
 */
public class PropertiesUtil {

	/**
	 * @param source
	 * @return
	 *         the given String with the first letter capitalized
	 */
	public static String firstToUpper(String source) {
		if(source.length() == 0) {
			return source;
		}
		return source.substring(0, 1).toUpperCase() + source.substring(1);
	}

	/**
	 * @param source
	 * @return
	 *         the given String with the first letter lowered
	 */
	public static String firstToLower(String source) {
		if(source.length() == 0) {
			return source;
		}
		return source.substring(0, 1).toLowerCase() + source.substring(1);
	}

	/**
	 * Returns the formatted label of the property
	 * 
	 * @param property
	 * @return
	 */
	public static String getLabel(Property property) {
		if(property.getLabel() == null || property.getLabel().trim().equals("")) {
			return getLabel(property.getName());
		}

		return property.getLabel();
	}

	/**
	 * @param variableName
	 * @return
	 *         A formatted version of the given variable name
	 */
	public static String getLabel(String variableName) {
		//"CamelCase" to "Natural case"
		String formattedValue = variableName;

		//replace fooBar by foo Bar
		formattedValue = formattedValue.replaceAll("([a-z])([A-Z])", "$1 $2"); //$NON-NLS-1$ //$NON-NLS-2$

		//replace FOOAndBar by FOO And Bar
		formattedValue = formattedValue.replaceAll("([A-Z]+)([A-Z])([a-z])", "$1 $2$3"); //$NON-NLS-1$ //$NON-NLS-2$

		//Capitalize the first word and lower the other ones : foo Bar -> Foo bar
		//Keep the upper case for acronyms FOO Bar -> FOO bar
		String[] words = formattedValue.split("\\s+"); //$NON-NLS-1$
		formattedValue = firstToUpper(words[0]);
		for(int i = 1; i < words.length; i++) {
			formattedValue += " "; //$NON-NLS-1$
			if(words[i].matches("^[A-Z]{2,}")) { //$NON-NLS-1$
				formattedValue += words[i];
			} else {
				formattedValue += firstToLower(words[i]);
			}
		}

		Activator.log.debug("\"" + formattedValue + "\""); //$NON-NLS-1$ //$NON-NLS-2$
		return formattedValue;
	}

	/**
	 * Tests if the given value is equal to the namespace's value
	 * 
	 * @param namespace
	 * @param value
	 * @return
	 *         True if they are equal
	 */
	public static boolean namespaceEquals(Namespace namespace, String value) {
		if(namespace == null) {
			return value == null || value.trim().equals(""); //$NON-NLS-1$
		} else {
			return namespace.getValue().equals(value);
		}
	}

	/**
	 * Tests if the given name is equal to the namespace's name
	 * 
	 * @param namespace
	 * @param name
	 * @return
	 *         True if they are equal
	 */
	public static boolean namespaceEqualsByName(Namespace namespace, String name) {
		if(namespace == null) {
			return name == null || name.trim().equals(""); //$NON-NLS-1$
		} else {
			return namespace.getName().equals(name);
		}
	}

	/**
	 * Return the full value of the namespace declaration
	 * e.g. clr-namespace:org.eclipse.papyrus.views.properties
	 * 
	 * @param namespace
	 *        The namespace we want to prefix
	 * @return
	 *         The prefixed namespace
	 */
	public static String getPrefixedValue(Namespace namespace) {
		String prefixedValue = ""; //$NON-NLS-1$
		if(namespace.getPrefix() != null && !namespace.getPrefix().trim().equals("")) { //$NON-NLS-1$
			prefixedValue = namespace.getPrefix() + ":"; //$NON-NLS-1$
		}
		prefixedValue += namespace.getValue();

		return prefixedValue;
	}

	/**
	 * Return the full name of the namespace declaration
	 * e.g. xmlns:ppe
	 * 
	 * @param namespace
	 *        The namespace for which we want to get the qualified name
	 * @return
	 *         The namespace's qualified name
	 */
	public static String getQualifiedName(Namespace namespace) {
		if(namespace.getName() == null || namespace.getName().trim().equals("")) { //$NON-NLS-1$
			return "xmlns"; //$NON-NLS-1$
		} else {
			return "xmlns:" + namespace.getName(); //$NON-NLS-1$
		}
	}

	/**
	 * Retrieve the DataContextElement matching the given qualifiedName.
	 * 
	 * @param qualifiedName
	 *        The fully qualified name of the DataContextElement. The separator is ":"
	 *        e.g. : UML:NamedElement
	 * @param fromContextElements
	 *        The collection of DataContextElements in which the method should look
	 * @return
	 *         The matching DataContextElement, or null if none was found
	 */
	public static DataContextElement getContextElementByQualifiedName(String qualifiedName, Collection<? extends DataContextElement> fromContextElements) {
		int index = qualifiedName.indexOf(":"); //$NON-NLS-1$
		if(index >= 0) {
			String name = qualifiedName.substring(0, index);
			qualifiedName = qualifiedName.substring(qualifiedName.indexOf(":") + 1, qualifiedName.length()); //$NON-NLS-1$
			for(DataContextElement contextElement : fromContextElements) {
				if(contextElement instanceof DataContextPackage && contextElement.getName().equals(name)) {
					DataContextElement result = getContextElementByQualifiedName(qualifiedName, ((DataContextPackage)contextElement).getElements());
					if(result != null) {
						return result;
					}
				}
			}
		} else {
			for(DataContextElement element : fromContextElements) {
				if(element.getName().equals(qualifiedName)) {
					return element;
				}
			}
		}
		return null;
	}

	/**
	 * Returns the list of Context on which the given context depends, directly
	 * or indirectly
	 * 
	 * @param context
	 *        The context for which we want to retrieve the list of dependencies
	 * @return
	 *         The list of Contexts on which the given context depends
	 */
	public static List<Context> getDependencies(Context context) {
		List<Context> result = new LinkedList<Context>();
		if(context == null) {
			return result;
		}

		result.add(context);
		findDependencies(context, result);
		return result;
	}

	private static void findDependencies(Context context, List<Context> result) {
		for(Context dependency : context.getDependencies()) {
			if(!result.contains(dependency)) {
				result.add(dependency);
				findDependencies(dependency, result);
			}
		}
	}

	/**
	 * Returns the set of DataContextElement containing the whole inheritance hierarchy
	 * for the given source DataContextElements
	 * 
	 * @param source
	 *        The collection of DataContextElements for which we want to retrieve all inherited elements
	 * @return
	 *         All DataContextElements inherited (Directly or indirectly) by at least one of the source
	 *         context elements
	 */
	public static Set<DataContextElement> getAllContextElements(Collection<DataContextElement> source) {
		Set<DataContextElement> result = new HashSet<DataContextElement>();
		getAllContextElements(source, result);
		return result;
	}

	private static void getAllContextElements(Collection<DataContextElement> source, Set<DataContextElement> result) {
		for(DataContextElement element : source) {
			if(!result.contains(element)) {
				result.add(element);
				getAllContextElements(element.getSupertypes(), result);
			}
		}
	}

	/**
	 * A util method to make big strings fit in a restricted amount of space,
	 * such as a tooltip. The method will add new lines in the string at
	 * a regular interval.
	 * 
	 * @param string
	 *        The string to split
	 * @param maxCharPerLine
	 *        The maximum number of characters per line in the resulting string
	 * @return
	 *         The split string
	 */
	public static String resizeString(String string, int maxCharPerLine) {
		if(string == null || string.trim().length() <= maxCharPerLine) {
			return string.trim();
		}

		String[] stringChunks = string.split("\n|\r|\r\n|\n\r"); //$NON-NLS-1$

		List<String> chunks = new LinkedList<String>();

		for(String chunk : stringChunks) {
			chunk = chunk.trim();
			if(chunk.length() > maxCharPerLine) {
				Matcher matcher = Pattern.compile("(.{0," + maxCharPerLine + "}\\b\\p{Punct}?)").matcher(chunk); //$NON-NLS-1$ //$NON-NLS-2$
				while(matcher.find()) {
					String group = matcher.group(1);
					chunks.add(group);
				}
			} else {
				chunks.add(chunk);
			}
		}

		String result = ""; //$NON-NLS-1$
		for(String chunk : chunks) {
			result += chunk.trim() + "\n"; //$NON-NLS-1$
		}

		return result.trim();
	}
}
