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
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.conversion.NumberToStringConverter;
import org.eclipse.core.databinding.conversion.StringToNumberConverter;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableSetContentProvider;
import org.eclipse.papyrus.xwt.animation.Drawing;
import org.eclipse.papyrus.xwt.callback.IBeforeParsingCallback;
import org.eclipse.papyrus.xwt.collection.CollectionViewSource;
import org.eclipse.papyrus.xwt.converters.BindingToObject;
import org.eclipse.papyrus.xwt.converters.CollectionToBoolean;
import org.eclipse.papyrus.xwt.converters.CollectionToInteger;
import org.eclipse.papyrus.xwt.converters.DateToString;
import org.eclipse.papyrus.xwt.converters.EnumToString;
import org.eclipse.papyrus.xwt.converters.IStatusToBoolean;
import org.eclipse.papyrus.xwt.converters.IStatusToString;
import org.eclipse.papyrus.xwt.converters.ListToIObservableCollection;
import org.eclipse.papyrus.xwt.converters.ListToSet;
import org.eclipse.papyrus.xwt.converters.ObjectToBoolean;
import org.eclipse.papyrus.xwt.converters.ObjectToISelection;
import org.eclipse.papyrus.xwt.converters.ObjectToString;
import org.eclipse.papyrus.xwt.converters.SelectionToBoolean;
import org.eclipse.papyrus.xwt.converters.SetToIObservableCollection;
import org.eclipse.papyrus.xwt.converters.StringToBoolean;
import org.eclipse.papyrus.xwt.converters.StringToColor;
import org.eclipse.papyrus.xwt.converters.StringToDoubleArray;
import org.eclipse.papyrus.xwt.converters.StringToFont;
import org.eclipse.papyrus.xwt.converters.StringToFormAttachment;
import org.eclipse.papyrus.xwt.converters.StringToIValidationRule;
import org.eclipse.papyrus.xwt.converters.StringToIValueConverter;
import org.eclipse.papyrus.xwt.converters.StringToImage;
import org.eclipse.papyrus.xwt.converters.StringToIntArray;
import org.eclipse.papyrus.xwt.converters.StringToInteger;
import org.eclipse.papyrus.xwt.converters.StringToPoint;
import org.eclipse.papyrus.xwt.converters.StringToRectangle;
import org.eclipse.papyrus.xwt.converters.StringToType;
import org.eclipse.papyrus.xwt.converters.StringToURL;
import org.eclipse.papyrus.xwt.core.Condition;
import org.eclipse.papyrus.xwt.core.DataTrigger;
import org.eclipse.papyrus.xwt.core.EventTrigger;
import org.eclipse.papyrus.xwt.core.IBinding;
import org.eclipse.papyrus.xwt.core.IUserDataConstants;
import org.eclipse.papyrus.xwt.core.MultiDataTrigger;
import org.eclipse.papyrus.xwt.core.MultiTrigger;
import org.eclipse.papyrus.xwt.core.RadioEventGroup;
import org.eclipse.papyrus.xwt.core.Setter;
import org.eclipse.papyrus.xwt.core.Style;
import org.eclipse.papyrus.xwt.core.Trigger;
import org.eclipse.papyrus.xwt.core.TriggerBase;
import org.eclipse.papyrus.xwt.databinding.BindingContext;
import org.eclipse.papyrus.xwt.databinding.IBindingContext;
import org.eclipse.papyrus.xwt.dataproviders.ObjectDataProvider;
import org.eclipse.papyrus.xwt.input.ICommand;
import org.eclipse.papyrus.xwt.internal.core.BindingExpressionPath;
import org.eclipse.papyrus.xwt.internal.core.Core;
import org.eclipse.papyrus.xwt.internal.core.MetaclassManager;
import org.eclipse.papyrus.xwt.internal.core.MultiBinding;
import org.eclipse.papyrus.xwt.internal.core.ScopeKeeper;
import org.eclipse.papyrus.xwt.internal.core.ScopeManager;
import org.eclipse.papyrus.xwt.internal.core.UIResource;
import org.eclipse.papyrus.xwt.internal.core.UpdateSourceTrigger;
import org.eclipse.papyrus.xwt.internal.utils.ObjectUtil;
import org.eclipse.papyrus.xwt.internal.utils.UserData;
import org.eclipse.papyrus.xwt.javabean.ResourceLoaderFactory;
import org.eclipse.papyrus.xwt.javabean.ValueConvertorRegister;
import org.eclipse.papyrus.xwt.javabean.metadata.BindingMetaclass;
import org.eclipse.papyrus.xwt.javabean.metadata.ComboBoxCellEditorMetaclass;
import org.eclipse.papyrus.xwt.javabean.metadata.ExpandItemHeightAction;
import org.eclipse.papyrus.xwt.javabean.metadata.TableEditorMetaclass;
import org.eclipse.papyrus.xwt.javabean.metadata.TableViewerColumnMetaClass;
import org.eclipse.papyrus.xwt.javabean.metadata.properties.AbstractProperty;
import org.eclipse.papyrus.xwt.javabean.metadata.properties.ColumnViewerColumnsProperty;
import org.eclipse.papyrus.xwt.javabean.metadata.properties.DataProperty;
import org.eclipse.papyrus.xwt.javabean.metadata.properties.DynamicBeanProperty;
import org.eclipse.papyrus.xwt.javabean.metadata.properties.DynamicProperty;
import org.eclipse.papyrus.xwt.javabean.metadata.properties.InputBeanProperty;
import org.eclipse.papyrus.xwt.javabean.metadata.properties.MultiSelectionBeanProperty;
import org.eclipse.papyrus.xwt.javabean.metadata.properties.PropertiesConstants;
import org.eclipse.papyrus.xwt.javabean.metadata.properties.SingleSelectionBeanProperty;
import org.eclipse.papyrus.xwt.javabean.metadata.properties.StyleProperty;
import org.eclipse.papyrus.xwt.javabean.metadata.properties.TableColumnEditorProperty;
import org.eclipse.papyrus.xwt.javabean.metadata.properties.TableEditorDynamicProperty;
import org.eclipse.papyrus.xwt.javabean.metadata.properties.TableItemEditorProperty;
import org.eclipse.papyrus.xwt.javabean.metadata.properties.TableItemProperty;
import org.eclipse.papyrus.xwt.javabean.metadata.properties.TableViewerColumnDynamicProperty;
import org.eclipse.papyrus.xwt.javabean.metadata.properties.TableViewerColumnImageProperty;
import org.eclipse.papyrus.xwt.javabean.metadata.properties.TableViewerColumnTextProperty;
import org.eclipse.papyrus.xwt.javabean.metadata.properties.TableViewerColumnWidthProperty;
import org.eclipse.papyrus.xwt.javabean.metadata.properties.TriggersProperty;
import org.eclipse.papyrus.xwt.jface.ComboBoxCellEditor;
import org.eclipse.papyrus.xwt.jface.DefaultCellModifier;
import org.eclipse.papyrus.xwt.jface.JFaceInitializer;
import org.eclipse.papyrus.xwt.jface.JFacesHelper;
import org.eclipse.papyrus.xwt.jface.ObservableTreeContentProvider;
import org.eclipse.papyrus.xwt.jface.ViewerFilter;
import org.eclipse.papyrus.xwt.metadata.DefaultLoadingType;
import org.eclipse.papyrus.xwt.metadata.DelegateProperty;
import org.eclipse.papyrus.xwt.metadata.ILoadingType;
import org.eclipse.papyrus.xwt.metadata.IMetaclass;
import org.eclipse.papyrus.xwt.metadata.IProperty;
import org.eclipse.papyrus.xwt.metadata.IValueLoading;
import org.eclipse.papyrus.xwt.utils.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ControlEditor;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.IME;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TreeItem;

/**
 * Default XWT loader
 * 
 * @author yyang (yves.yang@soyatec.com) jliu (jin.liu@soyatec.com)
 */
public class XWTLoader implements IXWTLoader {

	// Declarations
	private Stack<Core> cores;

	public Realm realm;

	public XWTLoader() {
		initialize();
	}

	public Object createUIProfile() {
		Core core = new Core(new ResourceLoaderFactory(), this);
		cores.push(core);
		return core;
	}

	public boolean applyProfile(Object profile) {
		if(profile instanceof Core) {
			if(cores.peek() == profile) {
				return false;
			}
			cores.push((Core)profile);
			return true;
		}
		throw new XWTException("Wrong UI Profile.");
	}

	public Object restoreProfile() {
		if(cores.size() > 1) {
			return cores.pop();
		}
		throw new XWTException("No user-defined UI Profile.");
	}

	public Realm getRealm() {
		if(realm != null) {
			return realm;
		}
		Display display = Display.getCurrent();
		if(display == null) {
			display = Display.getDefault();
		}
		return SWTObservables.getRealm(display);
	}

	protected Core getCurrentCore() {
		return cores.peek();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#getLogger()
	 */
	public ILogger getLogger() {
		return getCurrentCore().getLogger();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#setLogger(org.eclipse.papyrus.xwt.ILogger)
	 */
	public void setLogger(ILogger log) {
		getCurrentCore().setLogger(log);
	}

	/**
	 * Get the dynamic property value
	 * 
	 * @param javaclass
	 */
	public Object getPropertyValue(Object uiElement, IProperty property) {
		return UserData.getLocalData(uiElement, property);
	}

	/**
	 * Set the dynamic property value
	 * 
	 * @param javaclass
	 */
	public void setPropertyValue(Object uiElement, IProperty property, Object value) {
		UserData.setLocalData(uiElement, property, value);
	}

	/**
	 * Remove the dynamic property value
	 * 
	 * @param javaclass
	 */
	public void removePropertyValue(Object uiElement, IProperty property) {
		UserData.removeLocalData(uiElement, property);
	}

	/**
	 * Remove the dynamic property value
	 * 
	 * @param javaclass
	 */
	public boolean hasPropertyValue(Object uiElement, IProperty property) {
		return UserData.hasLocalData(uiElement, property);
	}

	/**
	 * Register an Observable IChangeListener for a given UI element. The second
	 * registration of the same listener on the same UI Element has no effect.
	 * 
	 * @param context
	 * @param listener
	 * @return <code>true</code> the listener is added, <code>false</code> if
	 *         the listener already exists
	 */
	public boolean addObservableChangeListener(Object control, IChangeListener listener) {
		ScopeKeeper scope = UserData.findScopeKeeper(control);
		if(scope != null) {
			return scope.addChangeListener(listener);
		}
		return false;
	}

	/**
	 * Undo the registration of the Observable IChangeListener for a given UI
	 * element.
	 * 
	 * @param context
	 * @param listener
	 */
	public void removeObservableChangeListener(Object control, IChangeListener listener) {
		ScopeKeeper scope = UserData.findScopeKeeper(control);
		if(scope != null) {
			scope.removeChangeListener(listener);
		}
	}

	/**
	 * 
	 * @param nsmapace
	 * @return
	 */
	public IObservable observe(Object control, Object data, String fullPath, UpdateSourceTrigger updateSourceTrigger) {
		return ScopeManager.observe(control, data, new BindingExpressionPath(fullPath), updateSourceTrigger);
	}

	/**
	 * 
	 * @param nsmapace
	 * @return
	 */
	public IObservableFactory observableFactory(Object control, String fullPath, UpdateSourceTrigger updateSourceTrigger) {
		return ScopeManager.observableFactory(control, new BindingExpressionPath(fullPath), updateSourceTrigger);
	}

	/**
	 * 
	 * @param nsmapace
	 * @return
	 */
	public IObservableList findObservableList(Object context, Object data, String fullPath) {
		return ScopeManager.findObservableList(context, null, data, fullPath);
	}

	/**
	 * 
	 * @param nsmapace
	 * @return
	 */
	public IObservableSet findObservableSet(Object context, Object data, String fullPath) {
		return ScopeManager.findObservableSet(context, null, data, fullPath);
	}

	/**
	 * 
	 * @param nsmapace
	 * @return
	 */
	public IObservableValue observableValue(Object control, Object data, String fullPath, UpdateSourceTrigger updateSourceTrigger) {
		return ScopeManager.observableValue(control, data, fullPath, updateSourceTrigger);
	}

	/**
	 * 
	 * @param nsmapace
	 * @return
	 */
	public IObservableValue findObservableValue(Object context, Object data, String fullPath) {
		return ScopeManager.findObservableValue(context, null, data, fullPath);
	}

	/**
	 * 
	 */
	public Object findResource(Object object, String key) {
		return UserData.findResource(object, key);
	}

	public Map<String, Object> getResources(Object object) {
		return UserData.getLocalResources(object);
	}

	/**
	 * 
	 * @param nsmapace
	 * @param handler
	 */
	public void registerNamespaceHandler(String nsmapace, INamespaceHandler handler) {
		getCurrentCore().registerNamespaceHandler(nsmapace, handler);
	}

	/**
	 * 
	 * @param nsmapace
	 */
	public void unregisterNamespaceHandler(String nsmapace) {
		getCurrentCore().unregisterNamespaceHandler(nsmapace);
	}

	/**
	 * 
	 * @param nsmapace
	 * @return
	 */
	public INamespaceHandler getNamespaceHandler(String nsmapace) {
		for(int i = cores.size() - 1; i >= 0; i--) {
			Core core = cores.get(i);
			INamespaceHandler handler = core.getNamespaceHandler(nsmapace);
			if(handler != null) {
				return handler;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#getNamespace(java.lang.Class)
	 */
	public String getNamespace(Class<?> javaclass) {
		if(getMetaclass(javaclass) != null) {
			return IConstants.XWT_NAMESPACE;
		}
		Package javaPackage = javaclass.getPackage();
		if(javaPackage == null) {
			return IConstants.XAML_CLR_NAMESPACE_PROTO;
		}
		return IConstants.XAML_CLR_NAMESPACE_PROTO + javaclass.getPackage().getName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#getElementName(java.lang.Object)
	 */
	public String getElementName(Object object) {
		return UserData.getElementName(object);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.IXWTLoader#findElementByName(org.eclipse.swt.widgets
	 * .Widget, java.lang.String)
	 */
	public Object findElementByName(Object context, String name) {
		return UserData.findElementByName(context, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.IXWTLoader#getDataBindingContext(java.lang.Object,
	 * java.lang.String)
	 */
	public IBindingContext getBindingContext(Object element) {
		IBindingContext dataBindingContext = UserData.getBindingContext(element);
		if(dataBindingContext == null) {
			dataBindingContext = UserData.createBindingContext(element);
		}
		return dataBindingContext;
	}

	public ICLRFactory getCLRFactory() {
		for(int i = cores.size() - 1; i >= 0; i--) {
			Core core = cores.get(i);
			ICLRFactory factory = core.getCLRFactory();
			if(factory != null) {
				return factory;
			}
		}
		return null;
	}

	public void setCLRFactory(ICLRFactory clrFactory) {
		cores.peek().setCLRFactory(clrFactory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.IXWTLoader#getDataContext(org.eclipse.swt.widgets.
	 * Widget)
	 */
	public Object getDataContext(Object element) {
		return UserData.getDataContext(element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.IXWTLoader#getDataContext(org.eclipse.swt.widgets.
	 * Widget)
	 */
	public TriggerBase[] getTriggers(Object element) {
		return UserData.getTriggers(element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.IXWTLoader#setDataBindingContext(java.lang.Object,
	 * java.lang.Object)
	 */
	public void setDataBindingContext(Object widget, Object dataBindingContext) {
		UserData.setBindingContext(widget, dataBindingContext);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.IXWTLoader#setDataContext(org.eclipse.swt.widgets.
	 * Widget, java.lang.Object)
	 */
	public void setDataContext(Object widget, Object dataContext) {
		UserData.setDataContext(widget, dataContext);
	}

	/**
	 * Get the Triggers of given element
	 * 
	 * @param context
	 * @return
	 */
	public void setTriggers(Object element, TriggerBase[] triggers) {
		UserData.setTriggers(element, triggers);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.IXWTLoader#findCompositeParent(org.eclipse.swt.widgets
	 * .Widget)
	 */
	public Composite findCompositeParent(Object context) {
		return UserData.findCompositeParent(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#getMetaclass(java.lang.Object)
	 */
	public IMetaclass getMetaclass(Object object) {
		for(int i = cores.size() - 1; i >= 0; i--) {
			Core core = cores.get(i);
			IMetaclass metaclass = core.findMetaclass(object);
			if(metaclass != null) {
				return metaclass;
			}
		}
		Class<?> javaClass = null;
		if(object instanceof Class<?>) {
			javaClass = (Class<?>)object;
		} else {
			javaClass = object.getClass();
		}
		Class<?> superclass = javaClass.getSuperclass();
		IMetaclass superMetaclass = null;
		if(superclass != null) {
			superMetaclass = getMetaclass(superclass);
		}
		return getCurrentCore().registerMetaclass(javaClass, IConstants.XWT_NAMESPACE, superMetaclass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#load(java.net.URL)
	 */
	public Object load(URL file) throws Exception {
		return loadWithOptions(file, Collections.<String, Object> emptyMap());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#load(java.net.URL, java.lang.Object)
	 */
	public Object load(URL file, Object dataContext) throws Exception {
		return load(null, file, dataContext);
	}

	public Object load(IUIResource resource, Object dataContext) throws Exception {
		return load(null, resource, dataContext);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.IXWTLoader#load(org.eclipse.swt.widgets.Composite,
	 * java.net.URL)
	 */
	public Object load(Object parent, URL file) throws Exception {
		HashMap<String, Object> options = new HashMap<String, Object>();
		options.put(CONTAINER_PROPERTY, parent);
		return loadWithOptions(file, options);
	}

	public Object load(Object parent, IUIResource resource) throws Exception {
		HashMap<String, Object> options = new HashMap<String, Object>();
		options.put(CONTAINER_PROPERTY, parent);
		return loadWithOptions(resource, options);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.IXWTLoader#load(org.eclipse.swt.widgets.Composite,
	 * java.net.URL, java.lang.Object)
	 */
	public Object load(Object parent, URL file, Object dataContext) throws Exception {
		HashMap<String, Object> options = new HashMap<String, Object>();
		options.put(CONTAINER_PROPERTY, parent);
		options.put(DATACONTEXT_PROPERTY, dataContext);
		return loadWithOptions(file, options);
	}

	public Object load(Object parent, IUIResource resource, Object dataContext) throws Exception {
		HashMap<String, Object> options = new HashMap<String, Object>();
		options.put(CONTAINER_PROPERTY, parent);
		options.put(DATACONTEXT_PROPERTY, dataContext);
		return loadWithOptions(resource, options);
	}

	public Object load(Object parent, IUIResource resource, Map<String, Object> options) throws Exception {
		if(options.isEmpty()) {
			options = new HashMap<String, Object>();
		}
		options.put(CONTAINER_PROPERTY, parent);
		return loadWithOptions(resource, options);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.IXWTLoader#load(org.eclipse.swt.widgets.Composite,
	 * java.lang.Class, java.lang.Object)
	 */
	public Object load(Object parent, Class<?> viewType, Object dataContext) throws Exception {
		HashMap<String, Object> options = new HashMap<String, Object>();
		options.put(CONTAINER_PROPERTY, parent);
		options.put(DATACONTEXT_PROPERTY, dataContext);
		return loadWithOptions(viewType, options);
	}

	protected Map<String, Object> prepareOptions(Map<String, Object> options, URL url) {
		Boolean disabledStyle = (Boolean)options.get(DISABLE_STYLES_PROPERTY);
		if(!Boolean.TRUE.equals(disabledStyle)) {
			Collection<IStyle> defaultStyles = getDefaultStyles();
			Object styles = options.get(DEFAULT_STYLES_PROPERTY);
			if(styles != null) {
				if(styles instanceof IStyle) {
					defaultStyles.add((IStyle)styles);
				} else if(styles instanceof Collection) {
					for(Object element : (Collection<?>)styles) {
						if(element instanceof IStyle) {
							defaultStyles.add((IStyle)element);
						} else {
							throw new XWTException("IStyle is expected in [styles] parameters.");
						}
					}
				} else if(styles instanceof Object[]) {
					for(Object element : (Object[])styles) {
						if(element instanceof IStyle) {
							defaultStyles.add((IStyle)element);
						} else {
							throw new XWTException("IStyle is expected in [styles] parameters.");
						}
					}
				}
				options.remove(DEFAULT_STYLES_PROPERTY);
			}
			if(!defaultStyles.isEmpty()) {
				ResourceDictionary dictionary = (ResourceDictionary)options.get(RESOURCE_DICTIONARY_PROPERTY);
				if(dictionary == null) {
					dictionary = new ResourceDictionary();
					if(options == Collections.EMPTY_MAP) {
						options = new HashMap<String, Object>();
					}
					options.put(RESOURCE_DICTIONARY_PROPERTY, dictionary);
				}
				dictionary.put(Core.DEFAULT_STYLES_KEY, defaultStyles);
			}
		}
		// Register URL property
		if(options == Collections.EMPTY_MAP) {
			options = new HashMap<String, Object>();
		}
		options.put(URL_PROPERTY, url);
		return options;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#loadWithOptions(java.lang.Class,
	 * java.util.Map)
	 */
	public Object loadWithOptions(Class<?> viewType, Map<String, Object> options) throws Exception {
		ILoadingContext context = getLoadingContext();
		try {
			setLoadingContext(new DefaultLoadingContext(viewType.getClassLoader()));
			options = prepareOptions(options, null);
			return loadWithOptions(viewType.getResource(viewType.getSimpleName() + ".xwt"), options);
		} finally {
			setLoadingContext(context);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#open(java.lang.Class)
	 */
	public void open(Class<?> type) throws Exception {
		open(type.getResource(type.getSimpleName() + IConstants.XWT_EXTENSION_SUFFIX), Collections.emptyMap());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#open(java.net.URL)
	 */
	public void open(URL url) throws Exception {
		open(url, Collections.emptyMap());
	}

	public void open(IUIResource resource) throws Exception {
		open(resource, Collections.emptyMap());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.IXWTLoader#load(org.eclipse.swt.widgets.Composite,
	 * java.io.InputStream, java.net.URL, java.lang.Object)
	 */
	public Object load(Object parent, InputStream stream, URL file, Object dataContext) throws Exception {
		HashMap<String, Object> options = new HashMap<String, Object>();
		options.put(CONTAINER_PROPERTY, parent);
		options.put(DATACONTEXT_PROPERTY, dataContext);
		return loadWithOptions(stream, file, options);
	}

	public IUIResource loadAsResource(InputStream stream, URL input) throws Exception {
		return loadAsResource(stream, input, null);
	}

	public IUIResource loadAsResource(InputStream stream, URL input, IBeforeParsingCallback parsingCallback) throws Exception {
		return getCurrentCore().loadAsResource(stream, input, parsingCallback);
	}

	public IUIResource loadAsResource(URL input) throws Exception {
		return loadAsResource(null, input, null);
	}

	public IUIResource loadAsResource(URL input, IBeforeParsingCallback parsingCallback) throws Exception {
		return loadAsResource(null, input, parsingCallback);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#open(java.net.URL, java.lang.Object)
	 */
	public void open(URL url, Object dataContext) throws Exception {
		HashMap<String, Object> options = new HashMap<String, Object>();
		options.put(DATACONTEXT_PROPERTY, dataContext);
		open(url, options);
	}

	public void open(IUIResource resource, Object dataContext) throws Exception {
		HashMap<String, Object> options = new HashMap<String, Object>();
		options.put(DATACONTEXT_PROPERTY, dataContext);
		open(resource, options);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#open(java.lang.Class,
	 * java.lang.Object)
	 */
	public void open(Class<?> type, Object dataContext) throws Exception {
		open(type.getResource(type.getSimpleName() + IConstants.XWT_EXTENSION_SUFFIX), dataContext);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#open(java.net.URL, java.util.Map)
	 */
	public void open(final URL url, final Map<String, Object> options) throws Exception {
		if(SWT.getPlatform().startsWith("win")) {
			if(Display.getCurrent() == null) {
				new Display();
			}
			Realm.runWithDefault(getRealm(), new Runnable() {

				public void run() {
					try {
						if(url == null) {
							throw new XWTException("UI Resource is not found.");
						}
						Object element = loadWithOptions(url, options);
						Shell shell = XWT.findShell(element);
						if(shell == null) {
							throw new XWTException("Root element must be a control.");
						}
						shell.addDisposeListener(new DisposeListener() {

							public void widgetDisposed(DisposeEvent e) {
								Shell[] shells = Display.getCurrent().getShells();
								if(shells.length == 0) {
									ResourceManager.resources.dispose();
								}
							}
						});
						shell.open();
						while(!shell.isDisposed()) {
							if(!shell.getDisplay().readAndDispatch()) {
								shell.getDisplay().sleep();
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			return;
		}
		Display defaultDisplay = Display.getDefault();
		if(Thread.currentThread() == defaultDisplay.getThread()) {
			Realm.runWithDefault(getRealm(), new Runnable() {

				public void run() {
					try {
						if(url == null) {
							throw new XWTException("UI Resource is not found.");
						}
						Object element = loadWithOptions(url, options);
						Shell shell = XWT.findShell(element);
						shell.open();
						long startTime = -1;
						while(true) {
							if(!Display.getDefault().readAndDispatch()) {
								Display.getDefault().sleep();
							}
							Shell[] shells = Display.getDefault().getShells();
							if(shells.length == 0) {
								if(startTime == -1) {
									startTime = System.currentTimeMillis();
								} else if((System.currentTimeMillis() - startTime) > 1000) {
									break;
								}
							} else {
								startTime = -1;
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} else {
			defaultDisplay.asyncExec(new Runnable() {

				public void run() {
					Realm.runWithDefault(getRealm(), new Runnable() {

						public void run() {
							try {
								if(url == null) {
									throw new XWTException("UI Resource is not found.");
								}
								Object element = loadWithOptions(url, options);
								Shell shell = XWT.findShell(element);
								if(shell == null) {
									throw new XWTException("Root element must be a control.");
								}
								shell.open();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			});
		}
	}

	public void open(final IUIResource resource, final Map<String, Object> options) throws Exception {
		if(SWT.getPlatform().startsWith("win")) {
			if(Display.getCurrent() == null) {
				new Display();
			}
			Realm.runWithDefault(getRealm(), new Runnable() {

				public void run() {
					try {
						Object element = loadWithOptions(resource, options);
						Shell shell = XWT.findShell(element);
						if(shell == null) {
							throw new XWTException("Root element must be a control.");
						}
						shell.addDisposeListener(new DisposeListener() {

							public void widgetDisposed(DisposeEvent e) {
								Shell[] shells = Display.getCurrent().getShells();
								if(shells.length == 0) {
									ResourceManager.resources.dispose();
								}
							}
						});
						shell.open();
						while(!shell.isDisposed()) {
							if(!shell.getDisplay().readAndDispatch()) {
								shell.getDisplay().sleep();
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			return;
		}
		Display defaultDisplay = Display.getDefault();
		if(Thread.currentThread() == defaultDisplay.getThread()) {
			Realm.runWithDefault(getRealm(), new Runnable() {

				public void run() {
					try {
						Object element = loadWithOptions(resource, options);
						Shell shell = XWT.findShell(element);
						if(shell == null) {
							throw new XWTException("Root element must be a control.");
						}
						shell.open();
						long startTime = -1;
						while(true) {
							if(!Display.getDefault().readAndDispatch()) {
								Display.getDefault().sleep();
							}
							Shell[] shells = Display.getDefault().getShells();
							if(shells.length == 0) {
								if(startTime == -1) {
									startTime = System.currentTimeMillis();
								} else if((System.currentTimeMillis() - startTime) > 1000) {
									break;
								}
							} else {
								startTime = -1;
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} else {
			defaultDisplay.asyncExec(new Runnable() {

				public void run() {
					Realm.runWithDefault(getRealm(), new Runnable() {

						public void run() {
							try {
								Object element = loadWithOptions(resource, options);
								Shell shell = XWT.findShell(element);
								if(shell == null) {
									throw new XWTException("Root element must be a control.");
								}
								shell.open();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			});
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.IXWTLoader#convertFrom(org.eclipse.papyrus.xwt.metadata
	 * .IMetaclass, java.lang.String)
	 */
	public Object convertFrom(IMetaclass type, String string) {
		Class<?> targetType = type.getType();
		return convertFrom(targetType, string);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#convertFrom(java.lang.Class,
	 * java.lang.String)
	 */
	public Object convertFrom(Class<?> targetType, String string) {
		if(targetType == String.class) {
			return string;
		}
		IConverter converter = findConvertor(String.class, targetType);
		if(converter != null) {
			return converter.convert(string);
		}
		if(targetType == Object.class) {
			return string;
		}
		throw new XWTException("Converter is missing of type: " + targetType.getName() + " from String");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#loadWithOptions(java.net.URL,
	 * java.util.Map)
	 */
	public Object loadWithOptions(URL url, Map<String, Object> options) throws Exception {
		if(url == null) {
			throw new XWTException("UI Resource is not found.");
		}
		Composite object = (Composite)options.get(CONTAINER_PROPERTY);
		ILoadingContext loadingContext = (object != null ? getLoadingContext(object) : getLoadingContext());
		options = prepareOptions(options, url);
		Object visualObject = getCurrentCore().load(loadingContext, url, options);
		return visualObject;
	}

	public Object loadWithOptions(IUIResource resource, Map<String, Object> options) throws Exception {
		UIResource uiResource = (UIResource)resource;
		Object object = options.get(CONTAINER_PROPERTY);
		ILoadingContext loadingContext = (object != null ? getLoadingContext(object) : getLoadingContext());
		options = prepareOptions(options, uiResource.getURL());
		Object visualObject = getCurrentCore().load(loadingContext, resource, options);
		return visualObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#load(java.io.InputStream,
	 * java.net.URL)
	 */
	public Object load(InputStream stream, URL url) throws Exception {
		return loadWithOptions(stream, url, Collections.<String, Object> emptyMap());
	}

	public Object load(IUIResource resource) throws Exception {
		return loadWithOptions(resource, Collections.<String, Object> emptyMap());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#loadWithOptions(java.io.InputStream,
	 * java.net.URL, java.util.Map)
	 */
	public Object loadWithOptions(InputStream stream, URL base, Map<String, Object> options) throws Exception {
		Composite object = (Composite)options.get(CONTAINER_PROPERTY);
		ILoadingContext loadingContext = (object != null ? getLoadingContext(object) : getLoadingContext());
		options = prepareOptions(options, base);
		Control visualObject = getCurrentCore().load(loadingContext, stream, base, options);
		return visualObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#getAllMetaclasses()
	 */
	public IMetaclass[] getAllMetaclasses() {
		Collection<IMetaclass> collector = new ArrayList<IMetaclass>();
		for(int i = cores.size() - 1; i >= 0; i--) {
			Core core = cores.get(i);
			Collection<IMetaclass> metaclasses = core.getAllMetaclasses(IConstants.XWT_NAMESPACE);
			collector.addAll(metaclasses);
		}
		return collector.toArray(new IMetaclass[collector.size()]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#getMetaclass(java.lang.String,
	 * java.lang.String)
	 */
	public IMetaclass getMetaclass(String tagName, String ns) {
		for(int i = cores.size() - 1; i >= 0; i--) {
			Core core = cores.get(i);
			IMetaclass metaclass = core.getMetaclass(getLoadingContext(), tagName, ns);
			if(metaclass != null) {
				return metaclass;
			}
		}
		throw new XWTException("Type " + tagName + " is not found.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#registerMetaclass(java.lang.Class)
	 */
	public IMetaclass registerMetaclass(Class<?> type) {
		return getCurrentCore().registerMetaclass(type, IConstants.XWT_NAMESPACE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#registerMetaclass(java.lang.Class)
	 */
	public void registerMetaclass(IMetaclass type) {
		getCurrentCore().registerMetaclass(type, IConstants.XWT_NAMESPACE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.IXWTLoader#registerMetaclassFactory(org.eclipse.e4
	 * .xwt.IMetaclassFactory)
	 */
	public void registerMetaclassFactory(IMetaclassFactory metaclassFactory) {
		getCurrentCore().registerMetaclassFactory(metaclassFactory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#findConvertor(java.lang.Class,
	 * java.lang.Class)
	 */
	public IConverter findConvertor(Class<?> source, Class<?> target) {
		source = ObjectUtil.normalizedType(source);
		target = ObjectUtil.normalizedType(target);
		for(int i = cores.size() - 1; i >= 0; i--) {
			Core core = cores.get(i);
			IConverter converter = core.findConvertor(source, target);
			if(converter != null) {
				return converter;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.IXWTLoader#registerConvertor(org.eclipse.core.databinding
	 * .conversion.IConverter)
	 */
	public void registerConvertor(IConverter converter) {
		getCurrentCore().registerConvertor(converter);
	}

	protected void registerConvertor(Class<?> converter, String methodName) {
		getCurrentCore().registerConvertor(converter, methodName);
	}

	protected void registerConvertor(Class<?> converterType, String methodName, boolean value) {
		getCurrentCore().registerConvertor(converterType, methodName, value);
	}

	protected void registerConvertor(ValueConvertorRegister convertorRegister, Class<?> source, Class<?> target, Class<?> converterType, String methodName, boolean value) {
		getCurrentCore().registerConvertor(convertorRegister, source, target, converterType, methodName, value);
	}

	protected IConverter loadConvertor(Class<?> converter, String methodName, boolean value) {
		return getCurrentCore().loadConvertor(converter, methodName, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.IXWTLoader#addTracking(org.eclipse.papyrus.xwt.Tracking)
	 */
	public void addTracking(Tracking tracking) {
		getCurrentCore().addTracking(tracking);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.IXWTLoader#isTracking(org.eclipse.papyrus.xwt.Tracking)
	 */
	public boolean isTracking(Tracking tracking) {
		return getCurrentCore().isTracking(tracking);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#getTrackings()
	 */
	public Set<Tracking> getTrackings() {
		return getCurrentCore().getTrackings();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.IXWTLoader#removeTracking(org.eclipse.papyrus.xwt.Tracking)
	 */
	public void removeTracking(Tracking tracking) {
		getCurrentCore().removeTracking(tracking);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#registerCommand(java.lang.String,
	 * org.eclipse.papyrus.xwt.input.ICommand)
	 */
	public void registerCommand(String name, ICommand command) {
		getCurrentCore().registerCommand(name, command);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#getCommand(java.lang.String)
	 */
	public ICommand getCommand(String name) {
		for(int i = cores.size() - 1; i >= 0; i--) {
			Core core = cores.get(i);
			ICommand command = core.getCommand(name);
			if(command != null) {
				return command;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#getCommands()
	 */
	public Map<String, ICommand> getCommands() {
		HashMap<String, ICommand> collector = new HashMap<String, ICommand>();
		for(int i = cores.size() - 1; i >= 0; i--) {
			Core core = cores.get(i);
			Map<String, ICommand> map = core.getCommands();
			if(map != null) {
				collector.putAll(map);
			}
		}
		return collector;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#unregisterCommand(java.lang.String)
	 */
	public void unregisterCommand(String name) {
		getCurrentCore().unregisterCommand(name);
	}

	/**
	 * Register a command to a name
	 * 
	 * @param name
	 * @param command
	 */
	public void registerEventGroup(Class<?> type, IEventGroup eventGroup) {
		IMetaclass metaclass = getMetaclass(type);
		metaclass.addEventGroup(eventGroup);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.IXWTLoader#addDefaultStyle(org.eclipse.papyrus.xwt.IStyle)
	 */
	public void addDefaultStyle(IStyle style) {
		getCurrentCore().addDefaultStyle(style);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.IXWTLoader#removeDefaultStyle(org.eclipse.papyrus.xwt.IStyle
	 * )
	 */
	public void removeDefaultStyle(IStyle style) {
		getCurrentCore().removeDefaultStyle(style);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#getDefaultStyles()
	 */
	public Collection<IStyle> getDefaultStyles() {
		return getCurrentCore().getDefaultStyles();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.IXWTLoader#addDataProviderFactory(org.eclipse.papyrus.xwt
	 * .IDataProviderFactory)
	 */
	public void addDataProviderFactory(String name, IDataProviderFactory dataProviderFactory) {
		getCurrentCore().addDataProviderFactory(name, dataProviderFactory);
		registerMetaclass(dataProviderFactory.getType());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.IXWTLoader#removeDataProviderFactory(org.eclipse.e4
	 * .xwt.IDataProviderFactory)
	 */
	public void removeDataProviderFactory(String name) {
		getCurrentCore().removeDataProviderFactory(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.IXWTLoader#removeDataProviderFactory(org.eclipse.e4
	 * .xwt.IDataProviderFactory)
	 */
	public void removeDataProviderFactory(IDataProviderFactory dataProviderFactory) {
		getCurrentCore().removeDataProviderFactory(dataProviderFactory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#getDataProviderFactories()
	 */
	public Collection<IDataProviderFactory> getDataProviderFactories() {
		ArrayList<IDataProviderFactory> collector = new ArrayList<IDataProviderFactory>();
		for(int i = cores.size() - 1; i >= 0; i--) {
			Core core = cores.get(i);
			Collection<IDataProviderFactory> factories = core.getDataProviderFactories();
			if(factories != null) {
				collector.addAll(factories);
			}
		}
		return collector;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#findDataProvider(java.lang.Object)
	 */
	public IDataProvider findDataProvider(Object dataContext) {
		for(int i = cores.size() - 1; i >= 0; i--) {
			Core core = cores.get(i);
			IDataProvider provider = core.findDataProvider(dataContext);
			if(provider != null) {
				return provider;
			}
		}
		return null;
	}

	private synchronized void initialize() {
		cores = new Stack<Core>();
		Core core = new Core(new ResourceLoaderFactory(), this);
		cores.push(core);

		core.registerService(ValueConvertorRegister.class, new ValueConvertorRegister());

		core.registerMetaclassManager(IConstants.XWT_NAMESPACE, new MetaclassManager(null, null, this));
		core.registerMetaclass(new BindingMetaclass(this), IConstants.XWT_NAMESPACE);
		core.registerMetaclass(new BindingMetaclass(MultiBinding.class, this), IConstants.XWT_NAMESPACE);
		core.registerMetaclass(new TableEditorMetaclass(core.getMetaclass(ControlEditor.class, IConstants.XWT_NAMESPACE), this), IConstants.XWT_NAMESPACE);

		registerConvertor(ObjectToString.FROM_OBJECT);
		registerConvertor(DateToString.instance);
		registerConvertor(EnumToString.instance);
		registerConvertor(StringToInteger.instance);
		// It is not supported by eclipse 3.4.1
		registerConvertor(StringToNumberConverter.class, "toBigDecimal");
		registerConvertor(StringToNumberConverter.class, "toByte", false);

		registerConvertor(StringToNumberConverter.toLong(false));

		// It is not supported by eclipse 3.4.1
		registerConvertor(StringToNumberConverter.class, "toShort", false);

		registerConvertor(StringToNumberConverter.toFloat(false));
		registerConvertor(StringToNumberConverter.toDouble(false));

		registerConvertor(NumberToStringConverter.fromInteger(false));

		// It is not supported by eclipse 3.4.1
		registerConvertor(NumberToStringConverter.class, "fromBigDecimal");
		registerConvertor(NumberToStringConverter.class, "fromByte", false);

		registerConvertor(NumberToStringConverter.fromLong(false));

		// It is not supported by eclipse 3.4.1
		registerConvertor(NumberToStringConverter.class, "fromShort", false);

		registerConvertor(NumberToStringConverter.fromFloat(false));
		registerConvertor(NumberToStringConverter.fromDouble(false));

		registerConvertor(StringToBoolean.instance);
		registerConvertor(ObjectToBoolean.instance);
		registerConvertor(SelectionToBoolean.instance);
		registerConvertor(CollectionToBoolean.instance);
		registerConvertor(CollectionToInteger.instance);
		registerConvertor(StringToIntArray.instance);
		registerConvertor(StringToDoubleArray.instance);
		registerConvertor(BindingToObject.instance);
		registerConvertor(StringToColor.instance);
		registerConvertor(StringToFont.instance);
		registerConvertor(StringToImage.instance);
		registerConvertor(StringToPoint.instance);
		registerConvertor(StringToRectangle.instance);
		registerConvertor(StringToURL.instance);
		registerConvertor(StringToType.instance);
		registerConvertor(StringToFormAttachment.instance);
		registerConvertor(StringToIValidationRule.instance);
		registerConvertor(StringToIValueConverter.instance);
		registerConvertor(ListToIObservableCollection.instance);
		registerConvertor(SetToIObservableCollection.instance);
		registerConvertor(ObjectToISelection.instance);
		registerConvertor(ListToSet.instance);
		//		registerConvertor(StringToKeyTime.instance);
		//		registerConvertor(StringToKeySpline.instance);

		registerConvertor(IStatusToString.instance);
		registerConvertor(IStatusToBoolean.instance);

		ValueConvertorRegister convertorRegister = (ValueConvertorRegister)core.getService(ValueConvertorRegister.class);
		convertorRegister.register(String.class, float.class, StringToNumberConverter.toFloat(true));
		convertorRegister.register(String.class, int.class, StringToInteger.instance);

		// It is not supported by eclipse 3.4.1
		// convertorRegister.register(String.class, short.class,
		// StringToNumberConverter.toShort(true));
		registerConvertor(convertorRegister, String.class, short.class, StringToNumberConverter.class, "toShort", true);

		convertorRegister.register(String.class, long.class, StringToNumberConverter.toLong(true));

		// It is not supported by eclipse 3.4.1
		// convertorRegister.register(String.class, byte.class,
		// StringToNumberConverter.toByte(true));
		registerConvertor(convertorRegister, String.class, byte.class, StringToNumberConverter.class, "toByte", true);

		convertorRegister.register(String.class, boolean.class, StringToBoolean.instance);
		convertorRegister.register(String.class, double.class, StringToNumberConverter.toDouble(true));

		convertorRegister.register(float.class, String.class, NumberToStringConverter.fromFloat(true));
		convertorRegister.register(int.class, String.class, NumberToStringConverter.fromInteger(true));

		// It is not supported by eclipse 3.4.1
		// convertorRegister.register(short.class, String.class,
		// NumberToStringConverter.fromShort(true));
		registerConvertor(convertorRegister, short.class, String.class, NumberToStringConverter.class, "fromShort", true);

		convertorRegister.register(long.class, String.class, NumberToStringConverter.fromLong(true));

		// It is not supported by eclipse 3.4.1
		// convertorRegister.register(byte.class, String.class,
		// NumberToStringConverter.fromByte(true));
		registerConvertor(convertorRegister, byte.class, String.class, NumberToStringConverter.class, "fromByte", true);

		convertorRegister.register(double.class, String.class, NumberToStringConverter.fromDouble(true));

		Class<?> type = org.eclipse.swt.widgets.Widget.class;
		IMetaclass metaclass = registerMetaclass(type);
		IProperty drawingProperty = new AbstractProperty(IUserDataConstants.XWT_DRAWING_KEY, Drawing.class) {

			public void setValue(Object target, Object value) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
				if(!ObjectUtil.isAssignableFrom(IBinding.class, getType())) {
					if(value != null) {
						value = ObjectUtil.resolveValue(value, getType(), value);
					}
				}
			}

			public Object getValue(Object target) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchFieldException {
				return null;
			}
		};
		metaclass.addProperty(drawingProperty);
		IProperty dataContextProperty = new DataProperty(IConstants.XAML_DATA_CONTEXT, IUserDataConstants.XWT_DATACONTEXT_KEY);
		metaclass.addProperty(dataContextProperty);
		ILoadingType loadingType = new DefaultLoadingType(IValueLoading.PostChildren, new IProperty[]{ dataContextProperty });

		metaclass.addProperty(new DataProperty(IConstants.XAML_BINDING_CONTEXT, IUserDataConstants.XWT_BINDING_CONTEXT_KEY));
		metaclass.addProperty(new TriggersProperty(loadingType));
		metaclass.addProperty(new StyleProperty());
		registerEventGroup(type, new RadioEventGroup(IEventConstants.KEY_GROUP));
		registerEventGroup(type, new RadioEventGroup(IEventConstants.MOUSE_GROUP));
		registerEventGroup(type, new RadioEventGroup(IEventConstants.MOUSE_MOVING_GROUP));
		registerEventGroup(type, new RadioEventGroup(IEventConstants.FOCUS_GROUP));
		registerEventGroup(type, new RadioEventGroup(IEventConstants.EXPAND_GROUP));
		registerEventGroup(type, new RadioEventGroup(IEventConstants.WINDOW_GROUP));
		registerEventGroup(type, new RadioEventGroup(IEventConstants.ACTIVATION_GROUP));
		registerEventGroup(type, new RadioEventGroup(IEventConstants.HARD_KEY));
		type = org.eclipse.swt.browser.Browser.class;
		IMetaclass browserMetaclass = registerMetaclass(type);

		browserMetaclass.addProperty(new DynamicProperty(type, String.class, PropertiesConstants.PROPERTY_URL, loadingType));
		browserMetaclass.addProperty(new DynamicProperty(type, String.class, PropertiesConstants.PROPERTY_TEXT, loadingType));

		IMetaclass buttonMetaclass = registerMetaclass(Button.class);
		buttonMetaclass.addProperty(new DataProperty(IConstants.XAML_COMMAND, IUserDataConstants.XWT_COMMAND_KEY, ICommand.class));

		registerMetaclass(org.eclipse.swt.widgets.Canvas.class);
		registerMetaclass(org.eclipse.swt.widgets.Caret.class);
		metaclass = registerMetaclass(org.eclipse.swt.widgets.Combo.class);
		if(metaclass != null) {
			IProperty property = metaclass.findProperty("text");
			IProperty inputProperty = new DelegateProperty(property, loadingType);
			metaclass.addProperty(inputProperty);
		}

		registerMetaclass(org.eclipse.swt.widgets.Composite.class);
		registerMetaclass(org.eclipse.swt.widgets.CoolBar.class);
		registerMetaclass(org.eclipse.swt.widgets.CoolItem.class);
		registerMetaclass(org.eclipse.swt.widgets.DateTime.class);
		registerMetaclass(org.eclipse.swt.widgets.Decorations.class);
		registerMetaclass(org.eclipse.swt.widgets.ExpandBar.class);
		IMetaclass expandItemMetaclass = registerMetaclass(ExpandItem.class);
		expandItemMetaclass.findProperty("control").addSetPostAction(new ExpandItemHeightAction());

		registerMetaclass(Group.class);
		registerMetaclass(IME.class);
		registerMetaclass(Label.class);
		registerMetaclass(Link.class);
		registerMetaclass(Listener.class);
		registerMetaclass(List.class);
		registerMetaclass(Menu.class);
		IMetaclass menuItemMetaclass = registerMetaclass(MenuItem.class);
		menuItemMetaclass.addProperty(new DataProperty(IConstants.XAML_COMMAND, IUserDataConstants.XWT_COMMAND_KEY, ICommand.class));

		registerMetaclass(org.eclipse.swt.widgets.MessageBox.class);
		registerMetaclass(org.eclipse.swt.widgets.ProgressBar.class);
		registerMetaclass(org.eclipse.swt.widgets.Sash.class);

		registerMetaclass(org.eclipse.swt.widgets.Scale.class);
		registerMetaclass(org.eclipse.swt.widgets.ScrollBar.class);
		registerMetaclass(org.eclipse.swt.widgets.Shell.class);
		registerMetaclass(org.eclipse.swt.widgets.Slider.class);
		registerMetaclass(org.eclipse.swt.widgets.Spinner.class);
		registerMetaclass(org.eclipse.swt.widgets.TabFolder.class);
		registerMetaclass(org.eclipse.swt.widgets.TabItem.class);

		registerMetaclass(org.eclipse.swt.widgets.Table.class);
		type = org.eclipse.swt.widgets.TableItem.class;
		metaclass = registerMetaclass(type);
		metaclass.addProperty(new TableItemProperty());
		metaclass.addProperty(new TableItemEditorProperty());
		metaclass.addProperty(new DynamicBeanProperty(TableItem.class, String[].class, PropertiesConstants.PROPERTY_TEXTS, PropertiesConstants.PROPERTY_TEXT));

		registerMetaclass(TableItemProperty.Cell.class);
		registerMetaclass(ControlEditor.class);
		registerMetaclass(TableEditor.class);

		IMetaclass TableEditorMetaclass = core.getMetaclass(TableEditor.class, IConstants.XWT_NAMESPACE);
		TableEditorMetaclass.addProperty(new TableEditorDynamicProperty(loadingType));

		type = org.eclipse.swt.widgets.TableColumn.class;
		metaclass = registerMetaclass(type);
		metaclass.addProperty(new TableColumnEditorProperty());

		registerMetaclass(org.eclipse.swt.widgets.Text.class);
		registerMetaclass(org.eclipse.swt.widgets.ToolBar.class);
		registerMetaclass(org.eclipse.swt.widgets.ToolItem.class);
		registerMetaclass(org.eclipse.swt.widgets.ToolTip.class);
		registerMetaclass(org.eclipse.swt.widgets.Tracker.class);
		registerMetaclass(org.eclipse.swt.widgets.Tray.class);
		registerMetaclass(org.eclipse.swt.widgets.Tree.class);
		registerMetaclass(org.eclipse.swt.widgets.TreeColumn.class);
		type = org.eclipse.swt.widgets.TreeItem.class;
		registerMetaclass(type);
		metaclass = registerMetaclass(type);
		metaclass.addProperty(new DynamicBeanProperty(TreeItem.class, String[].class, PropertiesConstants.PROPERTY_TEXTS, PropertiesConstants.PROPERTY_TEXT));
		if(metaclass != null) {
			IProperty property = metaclass.findProperty("expanded");
			IProperty expandedProperty = new DelegateProperty(property, loadingType);
			metaclass.addProperty(expandedProperty);
		}

		// registerMetaclass(org.eclipse.swt.layout.FillData.class);
		registerMetaclass(org.eclipse.swt.layout.FillLayout.class);
		registerMetaclass(org.eclipse.swt.layout.FormAttachment.class);
		registerMetaclass(org.eclipse.swt.layout.FormData.class);
		registerMetaclass(org.eclipse.swt.layout.FormLayout.class);
		registerMetaclass(org.eclipse.swt.layout.GridData.class);
		registerMetaclass(org.eclipse.swt.layout.GridLayout.class);
		registerMetaclass(org.eclipse.swt.layout.RowData.class);
		registerMetaclass(org.eclipse.swt.layout.RowLayout.class);
		registerMetaclass(org.eclipse.swt.custom.StackLayout.class);

		registerMetaclass(org.eclipse.swt.custom.CLabel.class);
		metaclass = registerMetaclass(org.eclipse.swt.custom.CCombo.class);
		if(metaclass != null) {
			IProperty property = metaclass.findProperty("text");
			IProperty inputProperty = new DelegateProperty(property, loadingType);
			metaclass.addProperty(inputProperty);
		}
		registerMetaclass(org.eclipse.swt.custom.CTabFolder.class);
		registerMetaclass(org.eclipse.swt.custom.CTabItem.class);
		metaclass = registerMetaclass(org.eclipse.swt.custom.SashForm.class);
		if(metaclass != null) {
			IProperty property = metaclass.findProperty("weights");
			IProperty inputProperty = new DelegateProperty(property, loadingType);
			metaclass.addProperty(inputProperty);
		}

		registerMetaclass(org.eclipse.swt.custom.StyledText.class);
		registerMetaclass(org.eclipse.swt.custom.ScrolledComposite.class);
		registerMetaclass(org.eclipse.swt.custom.TableTree.class);
		registerMetaclass(org.eclipse.swt.custom.ViewForm.class);
		registerMetaclass(org.eclipse.swt.custom.CBanner.class);
		registerMetaclass(org.eclipse.swt.custom.TableCursor.class);

		type = org.eclipse.jface.viewers.Viewer.class;
		metaclass = core.getMetaclass(type, IConstants.XWT_NAMESPACE);
		if(metaclass != null) {
			IProperty property = metaclass.findProperty("Input");
			IProperty inputProperty = new InputBeanProperty(property, loadingType);
			metaclass.addProperty(inputProperty);
			metaclass.addProperty(new DataProperty(IConstants.XAML_DATA_CONTEXT, IUserDataConstants.XWT_DATACONTEXT_KEY));

			metaclass.removeProperty("selection");

			metaclass.addProperty(new DataProperty(PropertiesConstants.PROPERTY_BINDING_PATH, IUserDataConstants.XWT_PROPERTY_DATA_KEY, String.class));
			metaclass.addProperty(new DataProperty(PropertiesConstants.PROPERTY_ITEM_TEXT, IUserDataConstants.XWT_PROPERTY_ITEM_TEXT_KEY, IBinding.class));
			metaclass.addProperty(new DataProperty(PropertiesConstants.PROPERTY_ITEM_IMAGE, IUserDataConstants.XWT_PROPERTY_ITEM_IMAGE_KEY, IBinding.class));
			ILoadingType inputLoadingType = new DefaultLoadingType(IValueLoading.PostChildren, new IProperty[]{ inputProperty });
			metaclass.addProperty(new SingleSelectionBeanProperty(PropertiesConstants.PROPERTY_SINGLE_SELECTION, inputLoadingType));
			metaclass.addProperty(new MultiSelectionBeanProperty(PropertiesConstants.PROPERTY_MULTI_SELECTION, inputLoadingType));
		}

		type = org.eclipse.jface.viewers.AbstractListViewer.class;
		metaclass = core.getMetaclass(type, IConstants.XWT_NAMESPACE);
		if(metaclass != null) {
			metaclass.addInitializer(new JFaceInitializer());
		}

		type = org.eclipse.jface.viewers.ColumnViewer.class;
		metaclass = core.getMetaclass(type, IConstants.XWT_NAMESPACE);
		if(metaclass != null) {
			metaclass.addProperty(new DynamicBeanProperty(type, String[].class, PropertiesConstants.PROPERTY_COLUMN_PROPERTIES));
			metaclass.addProperty(new ColumnViewerColumnsProperty());

			metaclass.addInitializer(new JFaceInitializer());
		}

		for(Class<?> cls : JFacesHelper.getSupportedElements()) {
			registerMetaclass(cls);
		}
		type = org.eclipse.jface.viewers.TableViewer.class;
		metaclass = core.getMetaclass(type, IConstants.XWT_NAMESPACE);
		IProperty property = metaclass.findProperty("table");
		if(property instanceof AbstractProperty) {
			AbstractProperty abstractProperty = (AbstractProperty)property;
			abstractProperty.setValueAsParent(true);
		}

		core.registerMetaclass(new ComboBoxCellEditorMetaclass(core.getMetaclass(ComboBoxCellEditor.class.getSuperclass(), IConstants.XWT_NAMESPACE), this), IConstants.XWT_NAMESPACE);

		type = org.eclipse.jface.viewers.TableViewerColumn.class;
		core.registerMetaclass(new TableViewerColumnMetaClass(core.getMetaclass(type.getSuperclass(), IConstants.XWT_NAMESPACE), this), IConstants.XWT_NAMESPACE);

		metaclass = core.getMetaclass(type, IConstants.XWT_NAMESPACE);
		//
		// PROPERTY_DATA_KEY
		//
		metaclass.addProperty(new TableViewerColumnWidthProperty());
		metaclass.addProperty(new TableViewerColumnTextProperty());
		metaclass.addProperty(new TableViewerColumnImageProperty());
		metaclass.addProperty(new TableViewerColumnDynamicProperty(PropertiesConstants.PROPERTY_BINDING_PATH, IUserDataConstants.XWT_PROPERTY_DATA_KEY, String.class));
		metaclass.addProperty(new TableViewerColumnDynamicProperty(PropertiesConstants.PROPERTY_ITEM_TEXT, IUserDataConstants.XWT_PROPERTY_ITEM_TEXT_KEY, IBinding.class));
		metaclass.addProperty(new TableViewerColumnDynamicProperty(PropertiesConstants.PROPERTY_ITEM_IMAGE, IUserDataConstants.XWT_PROPERTY_ITEM_IMAGE_KEY, IBinding.class));

		registerMetaclass(DefaultCellModifier.class);
		registerMetaclass(ViewerFilter.class);

		// DataBinding stuff
		registerMetaclass(BindingContext.class);

		registerMetaclass(ObjectDataProvider.class);

		registerMetaclass(Style.class);
		registerMetaclass(Setter.class);

		registerMetaclass(Trigger.class);
		registerMetaclass(MultiTrigger.class);
		registerMetaclass(EventTrigger.class);
		registerMetaclass(DataTrigger.class);
		registerMetaclass(MultiDataTrigger.class);
		registerMetaclass(Condition.class);

		//		registerConvertor(StringToDuration.instance);
		//		registerConvertor(StringToTimeSpan.instance);
		//		registerConvertor(StringToRepeatBehavior.instance);

		registerMetaclass(CollectionViewSource.class);

		registerMetaclass(ObservableListContentProvider.class);
		registerMetaclass(ObservableSetContentProvider.class);
		registerMetaclass(ObservableTreeContentProvider.class);

		registerFileResolveType(Image.class);
		registerFileResolveType(URL.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#findLoadingContext(java.lang.Object)
	 */
	public ILoadingContext findLoadingContext(Object container) {
		for(int i = cores.size() - 1; i >= 0; i--) {
			Core core = cores.get(i);
			ILoadingContext context = core.findLoadingContext(container);
			if(context != null) {
				return context;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.xwt.IXWTLoader#getLoadingContext(org.eclipse.swt.widgets
	 * .Composite)
	 */
	public ILoadingContext getLoadingContext(Object object) {
		return findLoadingContext(object);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.xwt.IXWTLoader#getLoadingContext()
	 */
	public ILoadingContext getLoadingContext() {
		return getCurrentCore().getLoadingContext();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.e4.xwt.IXWTLoader#setLoadingContext(org.eclipse.papyrus.xwt.
	 * ILoadingContext)
	 */
	public void setLoadingContext(ILoadingContext loadingContext) {
		getCurrentCore().setLoadingContext(loadingContext);
	}

	/**
	 * Check if the value of a property is to resolve.
	 * 
	 * @param type
	 *        type of property
	 * @return
	 */
	public boolean isFileResolveType(Class<?> type) {
		return getCurrentCore().isFileResolveType(type);
	}

	/**
	 * Register the value of a property is to resolve.
	 * 
	 * @param type
	 *        type of property
	 * @return
	 */
	public void registerFileResolveType(Class<?> type) {
		getCurrentCore().registerFileResolveType(type);
	}

	/**
	 * Register the value of a property is to resolve.
	 * 
	 * @param type
	 *        type of property
	 * @return
	 */
	public void unregisterFileResolveType(Class<?> type) {
		getCurrentCore().unregisterFileResolveType(type);
	}
}
