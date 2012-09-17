/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.xwt;

import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.papyrus.xwt.callback.IBeforeParsingCallback;
import org.eclipse.papyrus.xwt.callback.ICreatedCallback;
import org.eclipse.papyrus.xwt.callback.ILoadedCallback;
import org.eclipse.papyrus.xwt.core.TriggerBase;
import org.eclipse.papyrus.xwt.databinding.IBindingContext;
import org.eclipse.papyrus.xwt.input.ICommand;
import org.eclipse.papyrus.xwt.internal.core.UpdateSourceTrigger;
import org.eclipse.papyrus.xwt.metadata.IMetaclass;
import org.eclipse.papyrus.xwt.metadata.IProperty;
import org.eclipse.swt.widgets.Composite;

/**
 * XWT loader interface
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public interface IXWTLoader {

	// Properties

	/**
	 * The URL which open XWT file
	 * 
	 */
	String URL_PROPERTY = "XWT.URL";

	/**
	 * style of type int is used to create SWT element
	 */
	String CONTAINER_PROPERTY = "XWT.Container";

	String INIT_STYLE_PROPERTY = "XWT.Style";

	/**
	 * Used for editor/designer to pass design mode
	 */
	String DESIGN_MODE_PROPERTY = "XWT.DesignMode";

	/**
	 * Default styles to apply. The value should be a collection or Array of
	 * IStyle
	 * 
	 */
	String DEFAULT_STYLES_PROPERTY = "XWT.DefaultStyles";

	/**
	 * Enabled or disabled the styles. By default, it is enabled
	 * 
	 */
	String DISABLE_STYLES_PROPERTY = "XWT.DisabledStyles";

	/**
	 * The DataContext to setup in root element
	 * 
	 */
	String DATACONTEXT_PROPERTY = "XWT.DataContext";

	/**
	 * The BindingContext to setup in root element
	 * 
	 */
	String BINDING_CONTEXT_PROPERTY = "XWT.BindingContext";

	/**
	 * The CLR class
	 * 
	 */
	String CLASS_PROPERTY = "XWT.Class";

	/**
	 * The CLR class factory
	 * 
	 */
	String CLASS_FACTORY_PROPERTY = "XWT.ClassFactory";

	/**
	 * Resources to associate to root element
	 * 
	 */
	String RESOURCE_DICTIONARY_PROPERTY = "XWT.Resources";

	/**
	 * Resources to associate to root element
	 * 
	 */
	String LOADED_CALLBACK = ILoadedCallback.class.getName();

	/**
	 * Action to invoke after the creation of each UI element before the properties setting
	 * 
	 */
	String CREATED_CALLBACK = ICreatedCallback.class.getName();

	/**
	 * Action to invoke before parsing the XML file
	 * 
	 */
	String BEFORE_PARSING_CALLBACK = IBeforeParsingCallback.class.getName();

	String[] ALL_PROPERTIES = { URL_PROPERTY, CONTAINER_PROPERTY, INIT_STYLE_PROPERTY, DATACONTEXT_PROPERTY, BINDING_CONTEXT_PROPERTY, RESOURCE_DICTIONARY_PROPERTY, CLASS_PROPERTY, CLASS_FACTORY_PROPERTY, LOADED_CALLBACK, CREATED_CALLBACK, BEFORE_PARSING_CALLBACK, DESIGN_MODE_PROPERTY };

	/**
	 * Register an Observable IChangeListener for a given UI element. The second
	 * registration of the same listener on the same UI Element has no effect.
	 * 
	 * @param control
	 * @param listener
	 * @return
	 */
	boolean addObservableChangeListener(Object control, IChangeListener listener);

	/**
	 * Undo the registration of the Observable IChangeListener for a given UI
	 * element.
	 * 
	 * @param context
	 * @param listener
	 */
	void removeObservableChangeListener(Object context, IChangeListener listener);

	/**
	 * Find the used IObservable value for given data.
	 * 
	 * @param nsmapace
	 * @return
	 */
	IObservable observe(Object context, Object data, String propertyName, UpdateSourceTrigger updateSourceTrigger);

	/**
	 * Find the used IObservableFactory value for given data.
	 * 
	 * @param nsmapace
	 * @return
	 */
	IObservableFactory observableFactory(Object context, String propertyName, UpdateSourceTrigger updateSourceTrigger);

	/**
	 * Find the used IObservableValue value for given data.
	 * 
	 * @param nsmapace
	 * @return
	 */
	IObservableValue observableValue(Object context, Object data, String propertyName, UpdateSourceTrigger updateSourceTrigger);

	/**
	 * Find the used IObservableList value for given data.
	 * 
	 * @param nsmapace
	 * @return
	 */
	IObservableList findObservableList(Object context, Object data, String propertyName);

	/**
	 * Find the used IObservableList value for given data.
	 * 
	 * @param nsmapace
	 * @return
	 */
	IObservableSet findObservableSet(Object context, Object data, String propertyName);

	/**
	 * Find the used IObservableValue value for given data.
	 * 
	 * @param context
	 * @param data
	 * @param propertyName
	 * @return
	 */
	IObservableValue findObservableValue(Object context, Object data, String propertyName);

	/**
	 * Find the resource in Resources Dictionary attached in the UI Element.
	 * If the key isn't found, the research will be propagated in its parent.
	 * 
	 * @param object
	 * @param key
	 * @return
	 */
	Object findResource(Object object, String key);

	/**
	 * Get the Resources Dictionary attached in the UI Element.
	 * 
	 * @param object
	 * @return
	 */
	Map<String, Object> getResources(Object object);

	/**
	 * 
	 * @param nsmapace
	 * @param handler
	 */
	void registerNamespaceHandler(String nsmapace, INamespaceHandler handler);

	/**
	 * 
	 * @param nsmapace
	 */
	void unregisterNamespaceHandler(String nsmapace);

	/**
	 * 
	 * @param nsmapace
	 * @return
	 */
	INamespaceHandler getNamespaceHandler(String nsmapace);

	/**
	 * 
	 * @return
	 */
	Realm getRealm();

	/**
	 * Get the system logger.
	 * 
	 * @return
	 */
	ILogger getLogger();

	/**
	 * Change the system logger
	 * 
	 * @param logger
	 */
	void setLogger(ILogger log);

	/**
	 * This namespace service returns the associated or declared namespace for a
	 * given class.
	 * 
	 * @param javaclass
	 * @return
	 */
	String getNamespace(Class<?> javaclass);

	/**
	 * Get the name of the element, which is defined by <code>Name</code> or <code>x:Name</code>. Return <code>null</code>
	 * 
	 * @param object
	 * @return
	 */
	String getElementName(Object object);

	/**
	 * Find a named UI element.
	 * 
	 * @param context
	 *        the start point of research.
	 * @param name
	 * @return
	 */
	Object findElementByName(Object context, String name);

	/**
	 * Get the DataContext of given element
	 * 
	 * @param context
	 * @return
	 */
	Object getDataContext(Object element);

	/**
	 * Get the Triggers of given element
	 * 
	 * @param context
	 * @return
	 */
	TriggerBase[] getTriggers(Object element);

	/**
	 * Change the DataContext of given element
	 * 
	 * @param context
	 * @return
	 */
	void setDataContext(Object widget, Object dataContext);

	/**
	 * Changes the default data context of given element
	 * 
	 * @param widget
	 * @param dataBindingContext
	 */
	void setDataBindingContext(Object widget, Object dataBindingContext);

	/**
	 * Change the Triggers of given element
	 * 
	 * @param context
	 * @return
	 */
	void setTriggers(Object widget, TriggerBase[] triggers);

	/**
	 * Find the closet parent of type Composite
	 * 
	 * @param context
	 * @return
	 */
	Composite findCompositeParent(Object context);

	/**
	 * Get the Metaclass of the given object
	 * 
	 * @param context
	 * @return
	 */
	IMetaclass getMetaclass(Object object);

	/**
	 * Load the file content. All widget will be created but they are showed.
	 * This method return the root element.
	 * 
	 */
	Object load(URL file) throws Exception;

	/**
	 * Load the file content with a DataContext. All widget will be created but
	 * they are showed. This method returns the root element. The DataContext
	 * will be associated to the root element.
	 */
	Object load(URL file, Object dataContext) throws Exception;

	Object load(IUIResource resource, Object dataContext) throws Exception;

	/**
	 * Load the file content under a UI Object. All widget will be created. This
	 * method returns the root element. The DataContext will be associated to
	 * the root element.
	 */
	Object load(Object parent, URL file) throws Exception;

	/**
	 * Load the file content under a UI Object. All widget will be created. This
	 * method returns the root element. The DataContext will be associated to
	 * the root element.
	 */
	Object load(Object parent, IUIResource resource) throws Exception;

	/**
	 * Load the file content under a UI Object with a DataContext. All widget
	 * will be created. This method returns the root element. The DataContext
	 * will be associated to the root element.
	 */
	Object load(Object parent, URL file, Object dataContext) throws Exception;

	/**
	 * Load the file content under a UI Object with a DataContext. All widget
	 * will be created. This method returns the root element. The DataContext
	 * will be associated to the root element.
	 */
	Object load(Object parent, IUIResource resource, Object dataContext) throws Exception;

	/**
	 * Load the file content under a UI Object with a DataContext. All widget
	 * will be created. This method returns the root element. The DataContext
	 * will be associated to the root element.
	 */
	Object load(Object parent, IUIResource resource, Map<String, Object> options) throws Exception;

	/**
	 * Load the file content under a UI Object with a DataContext. All widget
	 * will be created. This method returns the root element. The DataContext
	 * will be associated to the root element.
	 */
	Object load(Object parent, Class<?> viewType, Object dataContext) throws Exception;

	/**
	 * Load the file content under a UI Object with a DataContext. All widget
	 * will be created. This method returns the root element. The DataContext
	 * will be associated to the root element.
	 */
	Object loadWithOptions(Class<?> viewType, Map<String, Object> options) throws Exception;

	/**
	 * Open and show the file content in a new Shell.
	 */
	void open(Class<?> type) throws Exception;

	/**
	 * Open and show the file content in a new Shell.
	 */
	void open(URL url) throws Exception;

	void open(IUIResource resource) throws Exception;

	/**
	 * load the content from a stream with a style, a DataContext and a
	 * ResourceDictionary. The root elements will be hold by UI Object parent
	 */
	Object load(Object parent, InputStream stream, URL file, Object dataContext) throws Exception;

	/**
	 * load the file content. The corresponding UI element is not yet created
	 */
	void open(URL url, Object dataContext) throws Exception;

	void open(IUIResource resource, Object dataContext) throws Exception;

	/**
	 * load the file content. The corresponding UI element is not yet created
	 */
	void open(Class<?> type, Object dataContext) throws Exception;

	/**
	 * load the file content. The corresponding UI element is not yet created
	 */
	void open(URL url, Map<String, Object> options) throws Exception;

	void open(IUIResource resource, final Map<String, Object> options) throws Exception;

	/**
	 * Data conversion service from String to a given type
	 * 
	 * @param type
	 * @param string
	 * @return
	 */
	Object convertFrom(IMetaclass type, String string);

	/**
	 * Data conversion service from String to a given type
	 * 
	 * @param targetType
	 * @param string
	 * @return
	 */
	Object convertFrom(Class<?> targetType, String string);

	Object loadWithOptions(URL url, Map<String, Object> options) throws Exception;

	/**
	 * 
	 * @param stream
	 * @param url
	 * @param options
	 * @return
	 * @throws Exception
	 */
	Object load(InputStream stream, URL url) throws Exception;

	Object load(IUIResource resource) throws Exception;

	public IUIResource loadAsResource(InputStream stream, URL input) throws Exception;

	public IUIResource loadAsResource(InputStream stream, URL input, IBeforeParsingCallback parsingCallback) throws Exception;

	public IUIResource loadAsResource(URL input) throws Exception;

	public IUIResource loadAsResource(URL input, IBeforeParsingCallback parsingCallback) throws Exception;

	/**
	 * Generic load method
	 * 
	 * @param stream
	 * @param url
	 * @param loadData
	 * @return
	 * @throws Exception
	 */
	Object loadWithOptions(InputStream stream, URL url, Map<String, Object> options) throws Exception;

	Object loadWithOptions(IUIResource resource, Map<String, Object> options) throws Exception;

	/**
	 * Metaclass services to return all registered Metaclasses.
	 * 
	 * @param stream
	 * @param url
	 * @param loadData
	 * @return
	 * @throws Exception
	 */
	IMetaclass[] getAllMetaclasses();

	/**
	 * Get the corresponding Metaclass
	 * 
	 * @param tagName
	 * @param ns
	 *        The namespace
	 * @return
	 */
	IMetaclass getMetaclass(String tagName, String ns);

	/**
	 * Register UI type
	 * 
	 * @param javaclass
	 */
	IMetaclass registerMetaclass(Class<?> type);

	/**
	 * Register UI type
	 * 
	 * @param javaclass
	 */
	void registerMetaclass(IMetaclass type);

	/**
	 * Get the dynamic property value
	 * 
	 * @param javaclass
	 */
	Object getPropertyValue(Object uiElement, IProperty property);

	/**
	 * Set the dynamic property value
	 * 
	 * @param javaclass
	 */
	void setPropertyValue(Object uiElement, IProperty property, Object value);

	/**
	 * Remove the dynamic property value
	 * 
	 * @param javaclass
	 */
	void removePropertyValue(Object uiElement, IProperty property);

	/**
	 * Remove the dynamic property value
	 * 
	 * @param javaclass
	 */
	boolean hasPropertyValue(Object uiElement, IProperty property);

	/**
	 * Register Metaclass factory
	 * 
	 * @param javaclass
	 */
	void registerMetaclassFactory(IMetaclassFactory metaclassFactory);

	/**
	 * Find a Data converter
	 * 
	 * @param converter
	 * @param type
	 */
	IConverter findConvertor(Class<?> source, Class<?> target);

	/**
	 * Register a Data converter
	 * 
	 * @param converter
	 * @param type
	 */
	void registerConvertor(IConverter converter);

	/**
	 * Add a tracking option
	 * 
	 * @param tracking
	 */
	void addTracking(Tracking tracking);

	/**
	 * Test if the tracking on argument is enabled.
	 * 
	 * @param tracking
	 * @return
	 */
	boolean isTracking(Tracking tracking);

	/**
	 * Get all tracking options
	 * 
	 * @return
	 */
	Set<Tracking> getTrackings();

	/**
	 * Remove a tracking option.
	 * 
	 * @param tracking
	 */
	void removeTracking(Tracking tracking);

	/**
	 * Register a command to a name
	 * 
	 * @param name
	 * @param command
	 */
	void registerCommand(String name, ICommand command);

	/**
	 * Register a command to a name
	 * 
	 * @param name
	 * @param command
	 */
	void registerEventGroup(Class<?> type, IEventGroup eventGroup);

	/**
	 * Find a command by name
	 * 
	 * @param name
	 * @return
	 */
	ICommand getCommand(String name);

	/**
	 * Return all registered commands
	 * 
	 * @return
	 */
	Map<String, ICommand> getCommands();

	/**
	 * Unregister a command
	 * 
	 * @param name
	 */
	void unregisterCommand(String name);

	/**
	 * Add a default style
	 * 
	 * @param style
	 * @return
	 */
	void addDefaultStyle(IStyle style);

	/**
	 * Remove a default style
	 * 
	 * @param style
	 * @return
	 */
	void removeDefaultStyle(IStyle style);

	Collection<IStyle> getDefaultStyles();

	void addDataProviderFactory(String name, IDataProviderFactory dataProviderFactory);

	void removeDataProviderFactory(String name);

	void removeDataProviderFactory(IDataProviderFactory dataProvider);

	Collection<IDataProviderFactory> getDataProviderFactories();

	IDataProvider findDataProvider(Object dataContext);

	ILoadingContext findLoadingContext(Object container);

	ILoadingContext getLoadingContext(Object object);

	ILoadingContext getLoadingContext();

	void setLoadingContext(ILoadingContext loadingContext);

	/**
	 * Create a UI Profile with the provide data and apply it immediately.
	 * 
	 * @param profileData
	 * @return
	 */
	public Object createUIProfile();

	/**
	 * Put the Profile in place
	 * 
	 * @param profile
	 * @return
	 */
	public boolean applyProfile(Object profile);

	/**
	 * Restore the previous profile
	 * 
	 * @return
	 */
	public Object restoreProfile();

	/**
	 * Set up the default ICLRFactory
	 * 
	 * @param factory
	 */
	public void setCLRFactory(ICLRFactory factory);

	/**
	 * The default CLRFactory.
	 * 
	 * @return
	 */
	public ICLRFactory getCLRFactory();

	/**
	 * Returns the {@link BindingContext} of the element
	 * 
	 * @param element
	 * @param contextName
	 * @return
	 */
	IBindingContext getBindingContext(Object element);

	/**
	 * Check if the value of a property is to resolve.
	 * 
	 * @param type
	 *        type of property
	 * @return
	 */
	boolean isFileResolveType(Class<?> type);

	/**
	 * Register the value of a property is to resolve.
	 * 
	 * @param type
	 *        type of property
	 * @return
	 */
	void registerFileResolveType(Class<?> type);

	/**
	 * Register the value of a property is to resolve.
	 * 
	 * @param type
	 *        type of property
	 * @return
	 */
	void unregisterFileResolveType(Class<?> type);

	public class Utilities {

		public static boolean isPropertyName(String name) {
			for(String propertyName : ALL_PROPERTIES) {
				if(propertyName.equalsIgnoreCase(name)) {
					return true;
				}
			}
			return false;
		}
	}
}
