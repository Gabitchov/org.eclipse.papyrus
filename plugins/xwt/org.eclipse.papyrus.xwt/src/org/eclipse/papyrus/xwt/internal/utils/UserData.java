/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.xwt.internal.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.xwt.IObservableValueListener;
import org.eclipse.papyrus.xwt.XWT;
import org.eclipse.papyrus.xwt.core.IUserDataConstants;
import org.eclipse.papyrus.xwt.core.TriggerBase;
import org.eclipse.papyrus.xwt.databinding.BindingContext;
import org.eclipse.papyrus.xwt.databinding.IBindingContext;
import org.eclipse.papyrus.xwt.internal.core.IEventController;
import org.eclipse.papyrus.xwt.internal.core.ScopeKeeper;
import org.eclipse.papyrus.xwt.javabean.Controller;
import org.eclipse.papyrus.xwt.jface.JFacesHelper;
import org.eclipse.papyrus.xwt.metadata.IProperty;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ControlEditor;
import org.eclipse.swt.custom.TableTreeItem;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Caret;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;

public class UserData {

	private HashMap<Object, Object> dictionary = null;

	private IObservableValueListener observableValueManager;

	protected IObservableValueListener getObservableValueManager() {
		return observableValueManager;
	}

	protected void setObservableValueManager(IObservableValueListener observableValueManager) {
		this.observableValueManager = observableValueManager;
	}

	public void setData(Object key, Object value) {
		if(dictionary == null) {
			dictionary = new HashMap<Object, Object>();
		}
		dictionary.put(key, value);
		if(observableValueManager != null && (key instanceof IProperty)) {
			IObservableValue observableValue = observableValueManager.getValue((IProperty)key);
			observableValue.setValue(value);
		}
	}

	public Object getData(Object key) {
		if(dictionary == null) {
			return null;
		}
		return dictionary.get(key);
	}

	public Object removeData(Object key) {
		if(dictionary == null) {
			return null;
		}
		return dictionary.remove(key);
	}

	public boolean containsKey(Object key) {
		if(dictionary == null) {
			return false;
		}
		return dictionary.containsKey(key);
	}

	public Collection<Object> keySet() {
		if(dictionary == null) {
			return Collections.emptyList();
		}
		return dictionary.keySet();
	}

	public static boolean isUIElementType(Object element) {
		if(element instanceof Class<?>) {
			Class<?> elementType = (Class<?>)element;
			return Widget.class.isAssignableFrom(elementType) || Viewer.class.isAssignableFrom(elementType) || ControlEditor.class.isAssignableFrom(elementType);
		}
		return false;
	}

	public static void bindNameContext(Object element, ScopeKeeper nameContext) {
		Widget widget = getWidget(element);
		if(widget == null) {
			return;
		}
		UserData dataDictionary = updateDataDictionary(widget);
		if(dataDictionary.getData(IUserDataConstants.XWT_NAMECONTEXT_KEY) != null) {
			throw new IllegalStateException("Name context is already set");
		}
		dataDictionary.setData(IUserDataConstants.XWT_NAMECONTEXT_KEY, nameContext);
	}

	protected static UserData updateDataDictionary(Object target) {
		Widget widget = getWidget(target);
		if(widget == null) {
			return null;
		}
		UserData dataDictionary = (UserData)widget.getData(IUserDataConstants.XWT_USER_DATA_KEY);
		if(dataDictionary == null) {
			dataDictionary = new UserData();
			widget.setData(IUserDataConstants.XWT_USER_DATA_KEY, dataDictionary);
		}
		return dataDictionary;
	}

	public static Shell findShell(Object element) {
		Widget widget = getWidget(element);
		if(widget == null) {
			return null;
		}
		if(widget instanceof Shell) {
			return (Shell)widget;
		}
		Control parent = (Control)findParent(widget, Control.class);
		if(parent != null) {
			return parent.getShell();
		}
		return null;
	}

	/**
	 * Find the root widget used by XWT. In fact, it tries to find the root
	 * ScopeKeeper
	 * 
	 * @param element
	 * @return
	 */
	public static Widget findRootWidget(Object element) {
		Widget root = null;
		Widget current = getWidget(element);
		while(current != null) {
			ScopeKeeper scopeKeeper = findScopeKeeper(current);
			if(scopeKeeper != null) {
				root = current;
			}
			current = getTreeParent(current);
		}

		return root;
	}

	public static Composite findCompositeParent(Object element) {
		Widget widget = getWidget(element);
		if(widget == null) {
			return null;
		}
		Control control = getParent(widget);
		while(control != null && !(control instanceof Composite)) {
			control = getParent(control);
		}
		return (Composite)control;
	}

	public static Object findParent(Widget element, Class<?> type) {
		Widget widget = getTreeParent(element);
		while(widget != null && !(type.isInstance(widget))) {
			widget = getTreeParent(widget);
		}
		return widget;
	}

	public static ScopeKeeper findScopeKeeper(Object element) {
		ScopeKeeper scopeKeeper = getLocalScopeKeeper(element);
		if(scopeKeeper != null) {
			return scopeKeeper;
		}
		Widget parent = getTreeParent(element);
		if(parent != null && !parent.isDisposed()) {
			return findScopeKeeper(parent);
		}
		return null;
	}

	public static Widget findScopeRoot(Object element) {
		Widget widget = getWidget(element);
		if(widget == null) {
			return null;
		}

		Widget current = widget;
		while(current != null) {
			UserData dataDictionary = (UserData)current.getData(IUserDataConstants.XWT_USER_DATA_KEY);
			if(dataDictionary != null) {
				Object data = dataDictionary.getData(IUserDataConstants.XWT_NAMECONTEXT_KEY);
				if(data != null) {
					return current;
				}
			}

			current = getTreeParent(current);
		}

		return null;
	}

	public static ScopeKeeper getLocalScopeKeeper(Object element) {
		Widget widget = getWidget(element);
		if(widget == null) {
			return null;
		}
		UserData dataDictionary = (UserData)widget.getData(IUserDataConstants.XWT_USER_DATA_KEY);
		if(dataDictionary != null) {
			Object data = dataDictionary.getData(IUserDataConstants.XWT_NAMECONTEXT_KEY);
			if(data != null) {
				return (ScopeKeeper)data;
			}
		}
		return null;
	}

	public static Object findElementByName(Object context, String name) {
		Widget widget = getWidget(context);
		if(widget == null) {
			return null;
		}
		UserData dataDictionary = (UserData)widget.getData(IUserDataConstants.XWT_USER_DATA_KEY);
		if(dataDictionary != null) {
			ScopeKeeper nameContext = (ScopeKeeper)dataDictionary.getData(IUserDataConstants.XWT_NAMECONTEXT_KEY);
			if(nameContext != null) {
				Object element = nameContext.getNamedObject(name);
				if(element != null) {
					return element;
				}
			}
		}
		Widget parent = getTreeParent(widget);
		if(parent != null) {
			return findElementByName(parent, name);
		}
		return null;
	}

	public static String getElementName(Object object) {
		Widget widget = getWidget(object);
		UserData dataDictionary = (UserData)widget.getData(IUserDataConstants.XWT_USER_DATA_KEY);
		if(dataDictionary != null) {
			return (String)dataDictionary.getData(IUserDataConstants.XWT_NAME_KEY);
		}
		return null;
	}

	public static void setElementName(Object object, String name, boolean updateScope) {
		Widget widget = getWidget(object);
		UserData dataDictionary = (UserData)widget.getData(IUserDataConstants.XWT_USER_DATA_KEY);
		if(dataDictionary != null) {
			dataDictionary.setData(IUserDataConstants.XWT_NAME_KEY, name);
			if(updateScope) {
				ScopeKeeper keeper = findScopeKeeper(object);
				if(keeper != null) {
					keeper.addNamedObject(name, object);
				}
			}
		}
	}

	public static void setCLR(Object widget, Object type) {
		setLocalData(widget, IUserDataConstants.XWT_CLR_KEY, type);
	}

	public static Object getCLR(Object element) {
		Widget widget = getWidget(element);
		if(widget == null) {
			return null;
		}
		UserData dataDictionary = (UserData)widget.getData(IUserDataConstants.XWT_USER_DATA_KEY);
		if(dataDictionary != null) {
			Object data = dataDictionary.getData(IUserDataConstants.XWT_CLR_KEY);
			if(data != null) {
				return data;
			}
		}
		Widget parent = getParent(widget);
		if(parent != null) {
			return getCLR(parent);
		}
		return null;
	}

	public static Widget getTreeParent(Object element) {
		Widget widget = getWidget(element);
		if(widget == null) {
			return null;
		}
		UserData dataDictionary = (UserData)widget.getData(IUserDataConstants.XWT_USER_DATA_KEY);
		if(dataDictionary != null) {
			widget = (Widget)dataDictionary.getData(IUserDataConstants.XWT_PARENT_KEY);
			if(widget != null) {
				return widget;
			}
		}
		return getParent(element);
	}

	public static Control getParent(Object element) {
		Widget widget = getWidget(element);
		if(widget instanceof Control) {
			Control control = (Control)widget;
			return control.getParent();
		} else if(widget instanceof Menu) {
			Menu item = (Menu)widget;
			return item.getParent();
		} else if(widget instanceof MenuItem) {
			MenuItem item = (MenuItem)widget;
			Menu menu = item.getParent();
			if(menu == null) {
				return null;
			}
			return menu.getParent();
		} else if(widget instanceof ScrollBar) {
			ScrollBar item = (ScrollBar)widget;
			return item.getParent();
		} else if(widget instanceof ToolTip) {
			ToolTip item = (ToolTip)widget;
			return item.getParent();
		} else if(widget instanceof CoolItem) {
			CoolItem item = (CoolItem)widget;
			return item.getParent();
		} else if(widget instanceof CTabItem) {
			CTabItem item = (CTabItem)widget;
			return item.getParent();
		} else if(widget instanceof ExpandItem) {
			ExpandItem item = (ExpandItem)widget;
			return item.getParent();
		} else if(widget instanceof TabItem) {
			TabItem item = (TabItem)widget;
			return item.getParent();
		} else if(widget instanceof TableColumn) {
			TableColumn item = (TableColumn)widget;
			return item.getParent();
		} else if(widget instanceof TableItem) {
			TableItem item = (TableItem)widget;
			return item.getParent();
		} else if(widget instanceof TableTreeItem) {
			TableTreeItem item = (TableTreeItem)widget;
			return item.getParent();
		} else if(widget instanceof ToolItem) {
			ToolItem item = (ToolItem)widget;
			return item.getParent();
		} else if(widget instanceof TreeColumn) {
			TreeColumn item = (TreeColumn)widget;
			return item.getParent();
		} else if(widget instanceof TreeItem) {
			TreeItem item = (TreeItem)widget;
			return item.getParent();
		} else if(widget instanceof Caret) {
			Caret item = (Caret)widget;
			return item.getParent();
		}
		return null;
	}

	public static IEventController findEventController(Object widget) {
		return (IEventController)findData(widget, IUserDataConstants.XWT_CONTROLLER_KEY);
	}

	public static Object getDataContext(Object widget) {
		return findData(widget, IUserDataConstants.XWT_DATACONTEXT_KEY);
	}

	public static IBindingContext getBindingContext(Object widget) {
		return (IBindingContext)findData(widget, IUserDataConstants.XWT_BINDING_CONTEXT_KEY);
	}

	public static TriggerBase[] getTriggers(Object element) {
		Widget widget = getWidget(element);
		if(widget == null) {
			return TriggerBase.EMPTY_ARRAY;
		}
		UserData dataDictionary = (UserData)widget.getData(IUserDataConstants.XWT_USER_DATA_KEY);
		if(dataDictionary != null) {
			TriggerBase[] triggers = (TriggerBase[])dataDictionary.getData(IUserDataConstants.XWT_TRIGGERS_KEY);
			if(triggers != null) {
				return triggers;
			}
		}
		return TriggerBase.EMPTY_ARRAY;
	}

	public static void setTriggers(Object widget, TriggerBase[] triggers) {
		setLocalData(widget, IUserDataConstants.XWT_TRIGGERS_KEY, triggers);
	}

	public static Widget getDataContextHost(Object element) {
		Widget widget = getWidget(element);
		if(widget == null) {
			return null;
		}
		UserData dataDictionary = (UserData)widget.getData(IUserDataConstants.XWT_USER_DATA_KEY);
		Object host = null;
		if(dataDictionary != null) {
			host = dataDictionary.getData(IUserDataConstants.XWT_DATACONTEXT_KEY);
			if(host != null) {
				return widget;
			}
		}
		Widget parent = widget;
		while(parent != null) {
			dataDictionary = (UserData)parent.getData(IUserDataConstants.XWT_USER_DATA_KEY);
			if(dataDictionary != null) {
				host = dataDictionary.getData(IUserDataConstants.XWT_DATACONTEXT_KEY);
				if(host != null) {
					return parent;
				}
				parent = (Widget)dataDictionary.getData(IUserDataConstants.XWT_PARENT_KEY);
			} else {
				parent = getParent(parent);
			}
		}
		return null;
	}

	public static void setBindingContext(Object widget, Object bindingContext) {
		setLocalData(widget, IUserDataConstants.XWT_BINDING_CONTEXT_KEY, bindingContext);
	}

	public static void setDataContext(Object widget, Object dataContext) {
		setLocalData(widget, IUserDataConstants.XWT_DATACONTEXT_KEY, dataContext);
	}

	public static Widget getWidget(Object target) {
		if(JFacesHelper.isViewer(target)) {
			return JFacesHelper.getControl(target);
		} else if(target instanceof Widget) {
			return (Widget)target;
		} else if(target instanceof TableViewerColumn) {
			return ((TableViewerColumn)target).getColumn();
		} else if(target instanceof ControlEditor) {
			return ((ControlEditor)target).getEditor();
		}
		return null;
	}

	public static Viewer getLocalViewer(Object object) {
		return (Viewer)getLocalData(object, IUserDataConstants.XWT_VIEWER_KEY);
	}

	public static Object getLocalDataContext(Object object) {
		return getLocalData(object, IUserDataConstants.XWT_DATACONTEXT_KEY);
	}

	public static boolean hasLocalDataContext(Object object) {
		return hasLocalData(object, IUserDataConstants.XWT_DATACONTEXT_KEY);
	}

	public static Object getLocalData(Object object, IProperty property) {
		Widget widget = getWidget(object);
		if(widget == null) {
			return null;
		}
		UserData dataDictionary = (UserData)widget.getData(IUserDataConstants.XWT_USER_DATA_KEY);
		if(dataDictionary == null) {
			return null;
		}
		return dataDictionary.getData(property);
	}

	public static Object getLocalData(Object object, String key) {
		Widget widget = getWidget(object);
		if(widget == null) {
			return null;
		}
		UserData dataDictionary = (UserData)widget.getData(IUserDataConstants.XWT_USER_DATA_KEY);
		if(dataDictionary == null) {
			return null;
		}
		return dataDictionary.getData(key);
	}

	public static boolean hasLocalData(Object object, String propertyName) {
		Widget widget = getWidget(object);
		if(widget == null) {
			return false;
		}
		UserData dataDictionary = (UserData)widget.getData(IUserDataConstants.XWT_USER_DATA_KEY);
		if(dataDictionary == null) {
			return false;
		}
		return dataDictionary.containsKey(propertyName);
	}

	public static boolean hasLocalData(Object object, IProperty property) {
		Widget widget = getWidget(object);
		if(widget == null) {
			return false;
		}
		UserData dataDictionary = (UserData)widget.getData(IUserDataConstants.XWT_USER_DATA_KEY);
		if(dataDictionary == null) {
			return false;
		}
		return dataDictionary.containsKey(property);
	}

	public static void removeLocalData(Object object, IProperty property) {
		Widget widget = getWidget(object);
		if(widget == null) {
			return;
		}
		UserData dataDictionary = (UserData)widget.getData(IUserDataConstants.XWT_USER_DATA_KEY);
		if(dataDictionary == null) {
			return;
		}
		dataDictionary.removeData(property);
	}

	public static void removeLocalData(Object object, String key) {
		Widget widget = getWidget(object);
		if(widget == null) {
			return;
		}
		UserData dataDictionary = (UserData)widget.getData(IUserDataConstants.XWT_USER_DATA_KEY);
		if(dataDictionary == null) {
			return;
		}
		dataDictionary.removeData(key);
	}

	public static Map<String, Object> getLocalResources(Object object) {
		return (Map<String, Object>)getLocalData(object, IUserDataConstants.XWT_RESOURCES_KEY);
	}

	public static Object findResource(Object object, String key) {
		Map<String, Object> map = (Map<String, Object>)getLocalData(object, IUserDataConstants.XWT_RESOURCES_KEY);
		if(map.containsKey(key)) {
			return map.get(key);
		}

		Object parent = getTreeParent(object);
		if(parent != null) {
			return findResource(parent, key);
		}
		return null;
	}

	public static void setResources(Object object, Map<?, ?> resources) {
		setLocalData(object, IUserDataConstants.XWT_RESOURCES_KEY, resources);
	}

	public static void setParent(Object object, Object parent) {
		setLocalData(object, IUserDataConstants.XWT_PARENT_KEY, parent);
	}

	public static void setViewer(Object object, Object parent) {
		setLocalData(object, IUserDataConstants.XWT_VIEWER_KEY, parent);
	}

	public static void setEventController(Object object, IEventController controller) {
		setLocalData(object, IUserDataConstants.XWT_CONTROLLER_KEY, controller);
	}

	public static IEventController updateEventController(Object object) {
		UserData dataDictionary = updateDataDictionary(object);
		IEventController controller = (IEventController)dataDictionary.getData(IUserDataConstants.XWT_CONTROLLER_KEY);
		if(controller == null) {
			controller = new Controller();
			dataDictionary.setData(IUserDataConstants.XWT_CONTROLLER_KEY, controller);
		}
		return controller;
	}

	public static void setLocalData(Object object, String key, Object value) {
		UserData dataDictionary = updateDataDictionary(object);
		dataDictionary.setData(key, value);
	}

	public static void setLocalData(Object object, IProperty property, Object value) {
		UserData dataDictionary = updateDataDictionary(object);
		dataDictionary.setData(property, value);
	}

	public static IObservableValueListener getObservableValueManager(Object object) {
		Widget widget = getWidget(object);
		if(widget == null) {
			return null;
		}

		UserData userData = (UserData)widget.getData(IUserDataConstants.XWT_USER_DATA_KEY);
		if(userData != null) {
			return userData.getObservableValueManager();
		}
		return null;
	}

	public static void setObservableValueManager(Object object, IObservableValueListener eventManager) {
		Widget widget = getWidget(object);
		if(widget == null) {
			throw new IllegalStateException("Not SWT Widget");
		}
		UserData userData = updateDataDictionary(object);
		userData.setObservableValueManager(eventManager);
	}

	public static Object findData(Object object, String key) {
		Widget widget = getWidget(object);
		if(widget == null) {
			return Collections.EMPTY_MAP;
		}

		UserData dataDictionary = (UserData)widget.getData(IUserDataConstants.XWT_USER_DATA_KEY);
		Object resources = null;
		if(dataDictionary != null) {
			resources = dataDictionary.getData(key);
			if(resources != null) {
				return resources;
			}
		}
		Widget parent = widget;
		while(parent != null) {
			dataDictionary = (UserData)parent.getData(IUserDataConstants.XWT_USER_DATA_KEY);
			if(dataDictionary != null) {
				resources = dataDictionary.getData(key);
				if(resources != null) {
					return resources;
				}
				parent = (Widget)dataDictionary.getData(IUserDataConstants.XWT_PARENT_KEY);
			} else {
				parent = getParent(parent);
			}
		}
		return null;
	}

	public static Map<?, ?> getResources(Object object) {
		return (Map<?, ?>)findData(object, IUserDataConstants.XWT_RESOURCES_KEY);
	}

	public static void setObjectName(Object object, String name) {
		Widget widget = getWidget(object);
		ScopeKeeper nameScoped;
		if(UserData.findElementByName(widget, name) != null) {
			// throw an exception or log a message?
			return;
		}
		Widget parent = UserData.getTreeParent(widget);
		UserData dataDictionary = (UserData)parent.getData(IUserDataConstants.XWT_USER_DATA_KEY);
		if(dataDictionary != null) {
			if(dataDictionary.getData(IUserDataConstants.XWT_NAMECONTEXT_KEY) != null) {
				nameScoped = (ScopeKeeper)dataDictionary.getData(IUserDataConstants.XWT_NAMECONTEXT_KEY);
			} else {
				ScopeKeeper parentNameScope = findScopeKeeper(parent);
				nameScoped = new ScopeKeeper(parentNameScope, widget);
				bindNameContext(parent, nameScoped);
			}
			nameScoped.addNamedObject(name, widget);
		}
		// throw an exception or log a message?
	}

	public static IBindingContext createBindingContext(Object host) {
		Widget widget = getWidget(host);
		final IBindingContext dataBindingContext = new BindingContext(widget);
		dataBindingContext.setRealm(XWT.getRealm());
		widget.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				dataBindingContext.dispose();
			}
		});

		UserData.setLocalData(host, IUserDataConstants.XWT_BINDING_CONTEXT_KEY, dataBindingContext);

		return dataBindingContext;
	}

}
