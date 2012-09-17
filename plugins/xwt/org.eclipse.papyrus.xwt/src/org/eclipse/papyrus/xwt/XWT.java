/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Soyatec - initial API and implementation
 *     Anyware-tech - add multiple loaders
 *******************************************************************************/
package org.eclipse.papyrus.xwt;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
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
import org.eclipse.papyrus.xwt.core.IBinding;
import org.eclipse.papyrus.xwt.core.TriggerBase;
import org.eclipse.papyrus.xwt.databinding.IBindingContext;
import org.eclipse.papyrus.xwt.input.ICommand;
import org.eclipse.papyrus.xwt.internal.core.UpdateSourceTrigger;
import org.eclipse.papyrus.xwt.internal.utils.UserData;
import org.eclipse.papyrus.xwt.metadata.IEvent;
import org.eclipse.papyrus.xwt.metadata.IMetaclass;
import org.eclipse.papyrus.xwt.metadata.IProperty;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Widget;

/**
 * XWT is the main class of the XWT framework. It provides most of the services
 * in API.
 * 
 * @author yyang
 */
public class XWT {

	private static List<IXWTInitializer> initializers = new ArrayList<IXWTInitializer>();

	private static Thread displayThread;

	private static final Object displayLock = new Object();

	/**
	 * Get the system logger.
	 * 
	 * @returnF
	 */
	public static ILogger getLogger() {
		return XWTLoaderManager.getActive().getLogger();
	}

	/**
	 * Create a UI Profile with the provide data and apply it immediately.
	 * 
	 * @param profileData
	 * @return
	 */
	public static Object createUIProfile() {
		return XWTLoaderManager.getActive().createUIProfile();
	}

	/**
	 * Put the Profile in place
	 * 
	 * @param profile
	 * @return
	 */
	public static boolean applyProfile(Object profile) {
		return XWTLoaderManager.getActive().applyProfile(profile);
	}

	/**
	 * Restore the previous profile
	 * 
	 * @return
	 */
	public static Object restoreProfile() {
		return XWTLoaderManager.getActive().restoreProfile();
	}

	/**
	 * 
	 * @param nsmapace
	 * @param handler
	 */
	public static void registerNamespaceHandler(String nsmapace, INamespaceHandler handler) {
		XWTLoaderManager.getActive().registerNamespaceHandler(nsmapace, handler);
	}

	/**
	 * 
	 * @param nsmapace
	 */
	public static void unregisterNamespaceHandler(String nsmapace) {
		XWTLoaderManager.getActive().unregisterNamespaceHandler(nsmapace);
	}

	/**
	 * 
	 * @param nsmapace
	 * @return
	 */
	public static INamespaceHandler getNamespaceHandler(String nsmapace) {
		return XWTLoaderManager.getActive().getNamespaceHandler(nsmapace);
	}

	/**
	 * Register an Observable IChangeListener for a given UI element. The second
	 * registration of the same listener on the same UI Element has no effect.
	 * 
	 * @param context
	 * @param listener
	 * @return
	 */
	public static boolean addObservableChangeListener(Object context, IChangeListener listener) {
		return XWTLoaderManager.getActive().addObservableChangeListener(context, listener);
	}

	/**
	 * Undo the registration of the Observable IChangeListener for a given UI
	 * element.
	 * 
	 * @param context
	 * @param listener
	 */
	public static void removeObservableChangeListener(Object context, IChangeListener listener) {
		XWTLoaderManager.getActive().removeObservableChangeListener(context, listener);
	}

	/**
	 * Find an existing IObservableValue
	 * 
	 * @param nsmapace
	 * @return null if it doesn't exist.
	 */
	public static IObservableValue findObservableValue(Object context, Object data, String propertyName) {
		return XWTLoaderManager.getActive().findObservableValue(context, data, propertyName);
	}

	/**
	 * Find an existing IObservableValue
	 * 
	 * @param nsmapace
	 * @return null if it doesn't exist.
	 */
	public static IObservableList findObservableList(Object context, Object data, String propertyName) {
		return XWTLoaderManager.getActive().findObservableList(context, data, propertyName);
	}

	/**
	 * Find an existing IObservableValue
	 * 
	 * @param nsmapace
	 * @return null if it doesn't exist.
	 */
	public static IObservableSet findObservableSet(Object context, Object data, String propertyName) {
		return XWTLoaderManager.getActive().findObservableSet(context, data, propertyName);
	}

	/**
	 * get or create a IObservableValue
	 * 
	 * @param nsmapace
	 * @return return null or raises an exception XWTException if fails
	 */
	public static IObservableValue observableValue(Object context, Object data, String propertyName, UpdateSourceTrigger updateSourceTrigger) {
		return XWTLoaderManager.getActive().observableValue(context, data, propertyName, updateSourceTrigger);
	}

	/**
	 * get or create a IObservable
	 * 
	 * @param nsmapace
	 * @return return null or raises an exception XWTException if fails
	 */
	public static IObservable observe(Object context, Object data, String propertyName, UpdateSourceTrigger updateSourceTrigger) {
		return XWTLoaderManager.getActive().observe(context, data, propertyName, updateSourceTrigger);
	}

	/**
	 * get or create a IObservable
	 * 
	 * @param nsmapace
	 * @return return null or raises an exception XWTException if fails
	 */
	public static IObservableFactory observableFactory(Object context, String propertyName, UpdateSourceTrigger updateSourceTrigger) {
		return XWTLoaderManager.getActive().observableFactory(context, propertyName, updateSourceTrigger);
	}

	/**
	 * get or create a IObservableValue
	 * 
	 * @param nsmapace
	 * @return return null or raises an exception XWTException if fails
	 */
	public static IObservableValue observableValue(Object context, Object data, String propertyName) {
		return XWTLoaderManager.getActive().observableValue(context, data, propertyName, UpdateSourceTrigger.Default);
	}

	/**
	 * Change the system logger
	 * 
	 * @param logger
	 */
	public static void setLogger(ILogger log) {
		XWTLoaderManager.getActive().setLogger(log);
	}

	/**
	 * Get the name of the element, which is defined by <code>Name</code> or <code>x:Name</code>. Return <code>null</code>
	 * 
	 * @param object
	 * @return
	 */
	public static String getElementName(Object object) {
		return XWTLoaderManager.getActive().getElementName(object);
	}

	/**
	 * Find a named UI element.
	 * 
	 * @param context
	 *        the start point of research.
	 * @param name
	 * @return
	 */
	public static Object findElementByName(Object context, String name) {
		return XWTLoaderManager.getActive().findElementByName(context, name);
	}

	/**
	 * Get the DataContext of given element
	 * 
	 * @param context
	 * @return
	 */
	public static Object getDataContext(Object element, Class<?> targetType) {
		Object value = XWTLoaderManager.getActive().getDataContext(element);
		if(targetType == null || !targetType.isInstance(value)) {
			if(value instanceof IBinding) {
				return ((IBinding)value).getValue(targetType);
			}
			if(value instanceof IObservableValue) {
				return ((IObservableValue)value).getValue();
			}
		}
		return value;
	}

	/**
	 * Returns the {@link BindingContext} within the upper scope of the control.
	 * <p>
	 * Each UI Element may have a local DataBindingContext property. While locating DataBindingContext, if the current UI Element has not the
	 * property, the parent's will be used.
	 * <p>
	 * If none is found, a default one will be created as default for the current scope
	 * <p>
	 * If still not found {@link XWTException} thrown...
	 * 
	 * @param element
	 * @return
	 */
	public static IBindingContext getBindingContext(Object element) {
		return XWTLoaderManager.getActive().getBindingContext(element);
	}

	/**
	 * Get the DataContext of given element
	 * 
	 * @param context
	 * @return
	 */
	public static Object getDataContext(Object element) {
		return getDataContext(element, null);
	}

	/**
	 * Set the DataContext of given element
	 * 
	 * @param context
	 * @return
	 */
	public static void setDataContext(Object element, Object dataContext) {
		XWTLoaderManager.getActive().setDataContext(UserData.getWidget(element), dataContext);
	}

	/**
	 * Get the Triggers of given element
	 * 
	 * @param context
	 * @return
	 */
	public static TriggerBase[] getTriggers(Widget element) {
		return XWTLoaderManager.getActive().getTriggers(element);
	}

	/**
	 * Get the Triggers of given element
	 * 
	 * @param context
	 * @return
	 */
	public static void setTriggers(Widget element, TriggerBase[] triggers) {
		XWTLoaderManager.getActive().setTriggers(element, triggers);
	}

	/**
	 * Get the CLR (Common Language Runtime) object. If no CLR object is found
	 * in this element, the research will be propagated in it parent.
	 * 
	 * @param widget
	 * @return
	 */
	public static Object getCLR(Object widget) {
		return UserData.getCLR(widget);
	}

	/**
	 * Find the root shell
	 * 
	 * @param context
	 * @return
	 */
	public static Shell findShell(Object context) {
		return UserData.findShell(context);
	}

	public static IProperty findProperty(Object object, String name) {
		IMetaclass metaclass = XWTLoaderManager.getActive().getMetaclass(object);
		return metaclass.findProperty(name);
	}

	public static Object findResource(Object object, String name) {
		return XWTLoaderManager.getActive().findResource(object, name);
	}

	public static Map<String, Object> getResources(Object object) {
		return XWTLoaderManager.getActive().getResources(object);
	}

	public static IEvent findEvent(Object object, String name) {
		IMetaclass metaclass = XWTLoaderManager.getActive().getMetaclass(object);
		return metaclass.findEvent(name);
	}

	public static IMetaclass getMetaclass(Object object) {
		return XWTLoaderManager.getActive().getMetaclass(object);
	}

	/**
	 * Load the file content. All widget will be created but they are showed.
	 * This method return the root element.
	 * 
	 */
	static public Object load(URL file) throws Exception {
		XWT.checkInitialization();
		return XWTLoaderManager.getActive().load(file);
	}

	/**
	 * Load the content from IUIResource. All widget will be created but they
	 * are showed. This method return the root element.
	 * 
	 */
	static public Object load(IUIResource resource) throws Exception {
		XWT.checkInitialization();
		return XWTLoaderManager.getActive().load(resource);
	}

	/**
	 * Load the file content. All widget will be created but they are showed.
	 * This method return the root element.
	 * 
	 */
	static public Object load(URL file, Object dataContext) throws Exception {
		XWT.checkInitialization();
		return XWTLoaderManager.getActive().load(file, dataContext);
	}

	/**
	 * Load the content from IUIResource. All widget will be created but they
	 * are showed. This method return the root element.
	 * 
	 */
	static public Object load(IUIResource resource, Object dataContext) throws Exception {
		XWT.checkInitialization();
		return XWTLoaderManager.getActive().load(resource, dataContext);
	}

	/**
	 * Load the file content under a UI Object. All widget will be created. This
	 * method returns the root element. The DataContext will be associated to
	 * the root element.
	 */
	static public Object load(Object parent, URL file) throws Exception {
		return XWTLoaderManager.getActive().load(parent, file);
	}

	/**
	 * Load the file content under a UI Object. All widget will be created. This
	 * method returns the root element. The DataContext will be associated to
	 * the root element.
	 * 
	 */
	static public Object load(Object parent, IUIResource resource) throws Exception {
		return XWTLoaderManager.getActive().load(parent, resource);
	}

	/**
	 * Load the file content under a UI Object with a DataContext. All widget
	 * will be created. This method returns the root element. The DataContext
	 * will be associated to the root element.
	 */
	static public Object load(Object parent, URL file, Object dataContext) throws Exception {
		return XWTLoaderManager.getActive().load(parent, file, dataContext);
	}

	/**
	 * Load the content from IUIResource.
	 * 
	 * @param stream
	 * @param input
	 * @param parsingCallback
	 *        null if the callback is not necessary
	 * @return
	 * @throws Exception
	 */
	static public IUIResource loadAsResource(InputStream stream, URL input, IBeforeParsingCallback parsingCallback) throws Exception {
		return XWTLoaderManager.getActive().loadAsResource(stream, input, parsingCallback);
	}

	/**
	 * Load the content from IUIResource.
	 * 
	 * @param stream
	 * @param input
	 * @param parsingCallback
	 *        null if the callback is not necessary
	 * @return
	 * @throws Exception
	 */
	static public IUIResource loadAsResource(InputStream stream, URL input) throws Exception {
		return XWTLoaderManager.getActive().loadAsResource(stream, input);
	}

	/**
	 * Load the content from IUIResource.
	 * 
	 * @param input
	 * @param parsingCallback
	 *        null if the callback is not necessary
	 * @return
	 * @throws Exception
	 */
	static public IUIResource loadAsResource(URL input, IBeforeParsingCallback parsingCallback) throws Exception {
		return XWTLoaderManager.getActive().loadAsResource(null, input, parsingCallback);
	}

	/**
	 * Load the content from IUIResource.
	 * 
	 * @param input
	 * @return
	 * @throws Exception
	 */
	static public IUIResource loadAsResource(URL input) throws Exception {
		return XWTLoaderManager.getActive().loadAsResource(null, input);
	}

	/**
	 * Load the file content under a UI Object with a DataContext. All widget
	 * will be created. This method returns the root element. The DataContext
	 * will be associated to the root element.
	 */
	static public Object load(Object parent, IUIResource resource, Object dataContext) throws Exception {
		return XWTLoaderManager.getActive().load(parent, resource, dataContext);
	}

	static public Object load(Object parent, IUIResource resource, Map<String, Object> options) throws Exception {
		return XWTLoaderManager.getActive().load(parent, resource, options);
	}

	/**
	 * Open and show the file content in a new Shell.
	 */
	static public void open(final URL url) throws Exception {
		XWT.checkInitialization();
		XWTLoaderManager.getActive().open(url);
	}

	/**
	 * Open and show the file content in a new Shell.
	 */
	static public void open(final Class<?> type) throws Exception {
		XWT.checkInitialization();
		XWTLoaderManager.getActive().open(type);
	}

	/**
	 * Open and show the file content in a new Shell.
	 */
	static public void open(final IUIResource resource) throws Exception {
		XWT.checkInitialization();
		XWTLoaderManager.getActive().open(resource);
	}

	/**
	 * load the content from a stream with a style, a DataContext and a
	 * ResourceDictionary. The root elements will be hold by UI Object parent
	 */
	static public Object load(Object parent, InputStream stream, URL file, Object dataContext) throws Exception {
		return XWTLoaderManager.getActive().load(parent, stream, file, dataContext);
	}

	/**
	 * load the file content. The corresponding UI element is not yet created
	 */
	static public void open(URL url, Object dataContext) throws Exception {
		XWT.checkInitialization();
		XWTLoaderManager.getActive().open(url, dataContext);
	}

	/**
	 * load the content from IUIResource. The corresponding UI element is not
	 * yet created
	 */
	static public void open(IUIResource resource, Object dataContext) throws Exception {
		XWT.checkInitialization();
		XWTLoaderManager.getActive().open(resource, dataContext);
	}

	/**
	 * load the file content. The corresponding UI element is not yet created
	 */
	static public void open(Class<?> type, Object dataContext) throws Exception {
		open(type.getResource(type.getSimpleName() + IConstants.XWT_EXTENSION_SUFFIX), dataContext);
	}

	/**
	 * load the file content. The corresponding UI element is not yet created
	 */
	static public void open(URL url, Map<String, Object> options) throws Exception {
		XWT.checkInitialization();
		XWTLoaderManager.getActive().open(url, options);
	}

	/**
	 * load the content from IUIResource. The corresponding UI element is not
	 * yet created
	 */
	static public void open(IUIResource resource, Map<String, Object> options) throws Exception {
		XWT.checkInitialization();
		XWTLoaderManager.getActive().open(resource, options);
	}

	static public Object convertFrom(Class<?> targetType, String string) {
		return XWTLoaderManager.getActive().convertFrom(targetType, string);
	}

	static public Object loadWithOptions(URL url, Map<String, Object> options) throws Exception {
		return XWTLoaderManager.getActive().loadWithOptions(url, options);
	}

	static public Object loadWithOptions(IUIResource resource, Map<String, Object> options) throws Exception {
		return XWTLoaderManager.getActive().loadWithOptions(resource, options);
	}

	/**
	 * 
	 * @param stream
	 * @param url
	 * @param options
	 * @return
	 * @throws Exception
	 */
	static public Object load(InputStream stream, URL url) throws Exception {
		XWT.checkInitialization();
		return loadWithOptions(stream, url, Collections.<String, Object> emptyMap());
	}

	/**
	 * 
	 * @param stream
	 * @param url
	 * @param options
	 * @return
	 * @throws Exception
	 */
	static public Object loadWithOptions(InputStream stream, URL url, Map<String, Object> options) throws Exception {
		XWT.checkInitialization();
		return XWTLoaderManager.getActive().loadWithOptions(stream, url, options);
	}

	/**
	 * Metaclass services to return all registered Metaclasses.
	 * 
	 * @param stream
	 * @param url
	 * @param loadData
	 * @return
	 * @throws Exception
	 */
	static public IMetaclass[] getAllMetaclasses() {
		return XWTLoaderManager.getActive().getAllMetaclasses();
	}

	/**
	 * Get the corresponding Metaclass
	 * 
	 * @param tagName
	 * @param ns
	 *        The namespace
	 * @return
	 */
	static public IMetaclass getMetaclass(String tagName, String ns) {
		return XWTLoaderManager.getActive().getMetaclass(tagName, ns);
	}

	/**
	 * Register a Data converter
	 * 
	 * @param converter
	 * @param type
	 */
	public static void registerEventGroup(Class<?> type, IEventGroup eventGroup) {
		XWTLoaderManager.getActive().registerEventGroup(type, eventGroup);
	}

	/**
	 * Register a Data converter
	 * 
	 * @param converter
	 * @param type
	 */
	public static void registerConvertor(IConverter converter) {
		XWTLoaderManager.getActive().registerConvertor(converter);
	}

	/**
	 * Register a command to a name
	 * 
	 * @param name
	 * @param command
	 */
	public static void registerCommand(String name, ICommand command) {
		XWTLoaderManager.getActive().registerCommand(name, command);
	}

	/**
	 * Add a default style
	 * 
	 * @param style
	 * @return
	 */
	public static void addDefaultStyle(IStyle style) {
		XWTLoaderManager.getActive().addDefaultStyle(style);
	}

	public static void addDataProviderFactory(String name, IDataProviderFactory dataProviderFactory) {
		XWTLoaderManager.getActive().addDataProviderFactory(name, dataProviderFactory);
	}

	public static void removeDataProviderFactory(String name) {
		XWTLoaderManager.getActive().removeDataProviderFactory(name);
	}

	public static void removeDataProviderFactory(IDataProviderFactory dataProviderFactory) {
		XWTLoaderManager.getActive().removeDataProviderFactory(dataProviderFactory);
	}

	public static Collection<IDataProviderFactory> getDataProviderFactories() {
		return XWTLoaderManager.getActive().getDataProviderFactories();
	}

	/**
	 * Register UI type
	 * 
	 * @param javaclass
	 */
	static public IMetaclass registerMetaclass(Class<?> type) {
		return XWTLoaderManager.getActive().registerMetaclass(type);
	}

	/**
	 * Register UI type
	 * 
	 * @param javaclass
	 */
	static public void registerMetaclass(IMetaclass type) {
		XWTLoaderManager.getActive().registerMetaclass(type);
	}

	/**
	 * Get the dynamic property value
	 * 
	 * @param javaclass
	 */
	static public Object getPropertyValue(Object uiElement, IProperty property) {
		return XWTLoaderManager.getActive().getPropertyValue(uiElement, property);
	}

	/**
	 * Get the dynamic property value
	 * 
	 * @param javaclass
	 */
	static public Object getPropertyValue(Object uiElement, String propertyName) {
		IMetaclass metaclass = XWT.getMetaclass(uiElement);
		IProperty property = metaclass.findProperty(propertyName);
		if(property == null) {
			return null;
		}
		return XWTLoaderManager.getActive().getPropertyValue(uiElement, property);
	}

	/**
	 * Set the dynamic property value
	 * 
	 * @param javaclass
	 */
	static public void setPropertyValue(Object uiElement, IProperty property, Object value) {
		XWTLoaderManager.getActive().setPropertyValue(uiElement, property, value);
	}

	/**
	 * Set the dynamic property value
	 * 
	 * @param javaclass
	 */
	static public void setPropertyValue(Object uiElement, String propertyName, Object value) {
		IMetaclass metaclass = XWT.getMetaclass(uiElement);
		IProperty property = metaclass.findProperty(propertyName);
		if(property == null) {
			throw new XWTException("Property " + propertyName + " not found.");
		}
		XWTLoaderManager.getActive().setPropertyValue(uiElement, property, value);
	}

	/**
	 * Remove the dynamic property value
	 * 
	 * @param javaclass
	 */
	static public void removePropertyValue(Object uiElement, IProperty property) {
		XWTLoaderManager.getActive().removePropertyValue(uiElement, property);
	}

	/**
	 * Remove the dynamic property value
	 * 
	 * @param javaclass
	 */
	static public boolean hasPropertyValue(Object uiElement, IProperty property) {
		return XWTLoaderManager.getActive().hasPropertyValue(uiElement, property);
	}

	/**
	 * Find a Data converter
	 * 
	 * @param converter
	 * @param type
	 */
	static public IConverter findConvertor(Class<?> source, Class<?> target) {
		return XWTLoaderManager.getActive().findConvertor(source, target);
	}

	/**
	 * Switch current loading context
	 * 
	 */
	public static void setLoadingContext(ILoadingContext loadingContext) {
		XWTLoaderManager.getActive().setLoadingContext(loadingContext);
	}

	/**
	 * Return current loading context
	 * 
	 * @return ILoadingContext
	 */
	public static ILoadingContext getLoadingContext() {
		return XWTLoaderManager.getActive().getLoadingContext();
	}

	/**
	 * Add a tracking option
	 * 
	 * @param tracking
	 */
	static public void addTracking(Tracking tracking) {
		XWTLoaderManager.getActive().addTracking(tracking);
	}

	/**
	 * Test if the tracking on argument is enabled.
	 * 
	 * @param tracking
	 * @return
	 */
	static public boolean isTracking(Tracking tracking) {
		return XWTLoaderManager.getActive().isTracking(tracking);
	}

	/**
	 * Get all tracking options
	 * 
	 * @return
	 */
	static public Set<Tracking> getTrackings() {
		return XWTLoaderManager.getActive().getTrackings();
	}

	/**
	 * Set up the default ICLRFactory
	 * 
	 * @param factory
	 */
	static public void setCLRFactory(ICLRFactory factory) {
		XWTLoaderManager.getActive().setCLRFactory(factory);
	}

	static public boolean checkInitialization() {
		if(isAllInitializersInitialized()) {
			return false;
		}
		return checkInitialization(-1);
	}

	static public boolean checkInitialization(long timeoutMillis) {
		long started = System.currentTimeMillis();
		while(true) {
			if(timeoutMillis != -1 && System.currentTimeMillis() - started > timeoutMillis) {
				return false;
			}

			if(isAllInitializersInitialized()) {
				return false;
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				return false;
			}
		}
	}

	private static boolean isAllInitializersInitialized() {
		synchronized(initializers) {
			for(IXWTInitializer initializer : initializers) {
				if(!initializer.isInitialized()) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * The default CLRFactory.
	 * 
	 * @return
	 */
	static public ICLRFactory getCLRFactory() {
		return XWTLoaderManager.getActive().getCLRFactory();
	}

	/**
	 * Find a command by name
	 * 
	 * @param name
	 * @return
	 */
	static public ICommand getCommand(String name) {
		return XWTLoaderManager.getActive().getCommand(name);
	}

	public static IDataProvider findDataProvider(Object dataContext) {
		return XWTLoaderManager.getActive().findDataProvider(dataContext);
	}

	static public Realm getRealm() {
		return XWTLoaderManager.getActive().getRealm();
	}

	static public boolean isXWTNamespace(String namespace) {
		return IConstants.XWT_X_NAMESPACE.equals(namespace) || IConstants.XWT_NAMESPACE.equals(namespace) || namespace.startsWith(IConstants.XAML_CLR_NAMESPACE_PROTO);
	}

	/**
	 * Check if the value of a property is to resolve.
	 * 
	 * @param type
	 *        type of property
	 * @return
	 */
	public static boolean isFileResolveType(Class<?> type) {
		return XWTLoaderManager.getActive().isFileResolveType(type);
	}

	/**
	 * Register the value of a property is to resolve.
	 * 
	 * @param type
	 *        type of property
	 * @return
	 */
	public static void registerFileResolveType(Class<?> type) {
		XWTLoaderManager.getActive().registerFileResolveType(type);
	}

	/**
	 * Register the value of a property is to resolve.
	 * 
	 * @param type
	 *        type of property
	 * @return
	 */
	public static void unregisterFileResolveType(Class<?> type) {
		XWTLoaderManager.getActive().unregisterFileResolveType(type);
	}

	static class DisplayThread extends Thread implements Listener {

		protected long startTime = -1;

		protected boolean toStop = false;

		protected Runnable runnable;

		public DisplayThread(Runnable runnable) {
			this.runnable = runnable;
		}

		public void handleEvent(Event event) {
		}
	}

	/**
	 * Run in UI context.
	 * 
	 * @param runnable
	 */
	public static void runOnUIThread(final Runnable runnable) {
		String platform = SWT.getPlatform();
		if(platform.startsWith("win")) {
			XWTLoaderManager.getDefault();
			runnable.run();
		} else if(platform.startsWith("rap")) {
			XWTLoaderManager.getDefault();
			runnable.run();
		} else if(platform.endsWith("gtk") || platform.endsWith("cocoa")) {
			synchronized(displayLock) {
				if(displayThread == null || !displayThread.isAlive()) {
					try {
						Field field = Display.class.getDeclaredField("Default");
						if(field != null) {
							field.setAccessible(true);
							Display defaultDisplay = (Display)field.get(null);
							if(defaultDisplay != null) {
								displayThread = defaultDisplay.getThread();
							}
						}
					} catch (Exception e) {
					}
				}

				if(displayThread == null || !displayThread.isAlive()) {
					displayThread = new Thread() {

						private long startTime = -1;

						private Display display;

						private boolean toStop = false;

						private boolean ignoreNotification = false;

						protected Runnable runnable = new Runnable() {

							public void run() {
								if(ignoreNotification) {
									startTime = -1;
									return;
								}
								if(startTime == -1) {
									startTime = System.currentTimeMillis();
								} else {
									if((System.currentTimeMillis() - startTime) > 10000 && display.getActiveShell() == null && display.getShells().length == 0) {
										toStop = true;
										display.wake();
									} else {
										startTime = System.currentTimeMillis();
									}
								}
							}
						};

						@Override
						public void run() {
							// Set default XWT ICLRFactory
							XWTLoaderManager.getDefault();
							display = Display.getDefault();
							runnable.run();
							while(true) {
								if(!display.readAndDispatch()) {
									display.timerExec(10000, runnable);
									display.sleep();
									ignoreNotification = true;
								}
								if(toStop) {
									break;
								}
								startTime = -1;
							}
						}
					};
					displayThread.start();
				} else {
					XWTLoaderManager.getDefault();
					XWT.checkInitialization();
					Display display = Display.findDisplay(displayThread);
					if(display != null) {
						display.syncExec(runnable);
					}
				}
			}
		} else {
			throw new UnsupportedOperationException();
		}
	}

	public static void addInitializer(IXWTInitializer initializer) {
		synchronized(initializers) {
			if(!XWTLoaderManager.isStarted()) {
				initializers.add(initializer);
			}
		}
	}

	static List<IXWTInitializer> getInitializers() {
		return initializers;
	}

	public static Object findParent(Object element, Class<?> type) {
		Widget widget = UserData.getWidget(element);
		if(widget == null) {
			return null;
		}
		return UserData.findParent(widget, type);
	}

	static void runInitializers(IXWTLoader loader) {
		synchronized(initializers) {
			for(IXWTInitializer initializer : XWT.getInitializers()) {
				initializer.initialize(loader);
			}
		}
	}
}
