/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) – Initial implementation.
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.diagram.common.Activator;

/**
 * A basic simple IExtensionPoint parser. It parses an IExtensionPoint and stores values in
 * instances of the specified Classes specified. It uses java reflection to get the elements and
 * their attributes to parse. It can handle String, Boolean and Object attributes. It can handle any
 * IExtensionPoint as long as the proper Classes are provided. <br>
 * It needs the IExtensionPoint string ID. It needs an Array of Classes to create instances of that
 * kind. If the Classes are internal to another Class, an instance of the enclosing Class is
 * required. <br>
 * The Classes provided must follow these rules:
 * <ul>
 * <li>Each Class simple name must be equal to one of the elements defined in the IExtensionPoint to
 * be parsed.</li>
 * <li>There must be one Class for each one of the elements defined in the IExtensionPoint.</li>
 * <li>Each Class must have one attribute of type String, Boolean or Object for each attribute
 * defined for its matching element in the IExtensionPoint.</li>
 * <li>Each Class must have one attribute of type List for each type of child element it can have as
 * defined in the IExtensionPoint. The name of this List attribute will be equal to the type of
 * elements to be stored in it.</li>
 * <li>Use Boolean instead of boolean, this allows that field to be null, indicating it has not been
 * initialized.</li>
 * </ul>
 * <br>
 * The method parseExtensionPoint will return a List of Objects with a data structure similar to the
 * one defined in the IExtensionPoint.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * 
 */
public class ExtensionPointParser {

	/**
	 * <Class>es from which create instances.
	 */
	private Class<Object>[] classes = null;

	/**
	 * Enclosing instance for internal <Class>es.
	 */
	private Object enclosingInstance = null;

	/**
	 * <IExtensionPoint> full name identifier.
	 */
	private String extensionPointID = null;

	/**
	 * Constructor without enclosing <Class>.
	 * 
	 * @param extensionPointID
	 * @param classes
	 */
	public ExtensionPointParser(String extensionPointID, Class<Object>[] classes) {
		this.classes = classes;
		this.extensionPointID = extensionPointID;
	}

	/**
	 * Constructor with enclosing <Class>.
	 * 
	 * @param extensionPointID
	 * @param classes
	 * @param enclosingInstance
	 */
	// @unused
	public ExtensionPointParser(String extensionPointID, Class<Object>[] classes, Object enclosingInstance) {
		this.classes = classes;
		this.extensionPointID = extensionPointID;
		this.enclosingInstance = enclosingInstance;
	}

	public Class<Object>[] getClasses() {
		return classes;
	}

	public String getExtensionPointID() {
		return extensionPointID;
	}

	public Class getEnclosingClass() {
		if (getEnclosingInstance() != null) {
			return getEnclosingInstance().getClass();
		}
		return null;
	}

	public Object getEnclosingInstance() {
		return enclosingInstance;
	}

	/**
	 * Parses the <IExtensionPoint> specified in the constructor. Returns a <List> of <Object>
	 * instances created from the <Class>es provided in the constructor. Fields with null value in
	 * the returned <Object>s have not been initialized, as those values were not specified in the
	 * <IExtensionPoint>.
	 * 
	 * @return
	 */
	public List<Object> parseExtensionPoint() {
		if (getExtensionPointID() == null || getClasses() == null || getClasses().length <= 0) {
			return Collections.EMPTY_LIST;
		}

		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(getExtensionPointID());

		// In case the extension point does not exist, show an error
		if (extensionPoint == null) {
			Activator.getDefault().logError("The Extension Point ID provided does not exist", null);
			return Collections.EMPTY_LIST;
		}

		// parse every root IConfigurationElement in this IExtensionPoint.
		List<Object> objects = new ArrayList<Object>();
		for (IConfigurationElement element : extensionPoint.getConfigurationElements()) {
			Object object = parseConfigurationElement(element);
			if (object != null) {
				objects.add(object);
			}
		}

		return objects;
	}

	/**
	 * Parse an <IConfigurationElement>, including its attributes and its children elements,
	 * 
	 * @param element
	 * @return
	 */
	protected Object parseConfigurationElement(IConfigurationElement element) {
		if (element == null) {
			return null;
		}

		Object object = createInstance(element);
		if (object == null) {
			return null;
		}

		// Added by gmerin to store the pluginID that contributed this object
		if (object instanceof IObjectWithContributorId) {
			String pluginID = element.getContributor().getName();
			((IObjectWithContributorId) object).setContributorId(pluginID);
		}
		// end gmerin

		for (Field field : object.getClass().getDeclaredFields()) {
			if (field.getType().isAssignableFrom(List.class) && !field.getType().isAssignableFrom(Object.class)) {
				// List fields are handled later
				continue;
			}
			String attribute = field.getName();
			if (attribute == null || attribute.contains("$")) {
				// a field with "$" is a pointer to the enclosing instance; and
				// never accessible
				continue;
			}
			Object value = parseAttribute(element, attribute);
			if (!(value instanceof String)) {
				if (field.getType().isAssignableFrom(List.class)) {
					try {
						if (field.get(object) == null) {
							// if a list without value, set to EMPTY_LIST
							field.set(object, Collections.EMPTY_LIST);
						}
					} catch (IllegalArgumentException e) {
						error("Cannot acces field " + attribute, e);
					} catch (IllegalAccessException e) {
						error("Cannot acces field " + attribute, e);
					}
				}
				continue;
			}
			String valueString = (String) value;
			try {
				if (field.getType().isAssignableFrom(Object.class)) {
					// an Object field is instantiated
					Object instantiation = null;
					try {
						instantiation = element.createExecutableExtension(attribute);
						field.set(object, instantiation);
					} catch (CoreException e) {
						error("Cannot create instance of " + valueString, e);
						instantiation = null;
					}
				} else if (field.getType().isAssignableFrom(Boolean.class)) {
					// a Boolean field is parsed to its primitive value.
					field.set(object, Boolean.valueOf(valueString));
				} else {
					field.set(object, valueString);
				}
			} catch (IllegalAccessException ex) {
				error("Cannot acces field " + attribute, ex);
				return null;
			} catch (IllegalArgumentException ex) {
				error("Illegal value for " + attribute, ex);
				return null;
			}
		}
		// parse all children element
		List<Object> objects = new ArrayList<Object>();
		for (IConfigurationElement child : element.getChildren()) {
			Object parsedChild = parseConfigurationElement(child);
			if (parsedChild != null) {
				objects.add(parsedChild);
			}
		}
		// add those children element to the proper <List> attribute
		addChildrenToInstance(object, objects);
		// object ready!
		return object;
	}

	/**
	 * Gets an attribute from an <IconfigurationElement>.
	 * 
	 * @param element
	 * @param attribute
	 * @return
	 */
	protected Object parseAttribute(IConfigurationElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	/**
	 * Adds children instances to the proper <List> attribute of the instance parent.
	 * 
	 * @param instance
	 * @param children
	 */
	protected void addChildrenToInstance(Object instance, List<Object> children) {
		for (Object child : children) {
			String name = child.getClass().getSimpleName();
			try {
				Field field = instance.getClass().getField(name);
				Object value = field.get(instance);
				if (field.getType().isAssignableFrom(List.class)) {
					if (value == null) {
						value = new ArrayList<Object>();
						field.set(instance, value);
					}
					((List) value).add(child);
				}
			} catch (NoSuchFieldException ex) {
				error("No field named " + name, ex);
				return;
			} catch (IllegalAccessException ex) {
				error("Field " + name + " not accessible", ex);
				return;
			}
		}
	}

	/**
	 * Creates an instance of an <Object> searching for the matching <Class> by simple name. The
	 * list of <Class>es to be used are provided in the constructor. Internal <Class>es must also
	 * provide an enclosing instance in the constructor.
	 * 
	 * @param element
	 * @return
	 */
	protected Object createInstance(IConfigurationElement element) {
		String name = element.getName();
		for (Class<Object> clazz : getClasses()) {
			if (clazz.getSimpleName().equals(name)) {
				try {
					Class[] parameters = null;
					if (getEnclosingClass() != null) {
						parameters = new Class[] { getEnclosingClass() };
					} else {
						parameters = new Class[0];
					}
					Constructor<Object> constructor = clazz.getConstructor(parameters);
					Object[] arguments = null;
					if (getEnclosingInstance() != null) {
						arguments = new Object[] { getEnclosingInstance() };
					} else {
						arguments = new Object[0];
					}
					return constructor.newInstance(arguments);
				} catch (IllegalAccessException ex) {
					error("Cannot access constructor for " + name, ex);
					return null;
				} catch (IllegalArgumentException ex) {
					error("Cannot create instance of type " + name, ex);
					return null;
				} catch (InstantiationException ex) {
					error("Cannot create instance of type " + name, ex);
					return null;
				} catch (NoSuchMethodException ex) {
					error("Cannot find constructor for " + name, ex);
					return null;
				} catch (InvocationTargetException ex) {
					error("Cannot invoke constructor for " + name, ex);
					return null;
				}
			}
		}
		return null;
	}

	private void error(String message, Throwable throwable) {
		Activator.getDefault().logError(message, throwable);
	}

}
