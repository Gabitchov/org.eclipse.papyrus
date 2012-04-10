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

package org.eclipse.papyrus.xwt.internal.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.papyrus.xwt.IConstants;
import org.eclipse.papyrus.xwt.Tracking;
import org.eclipse.papyrus.xwt.XWT;
import org.eclipse.papyrus.xwt.internal.utils.LoggerManager;
import org.eclipse.papyrus.xwt.internal.utils.ObjectUtil;
import org.eclipse.papyrus.xwt.internal.xml.Attribute;
import org.eclipse.papyrus.xwt.internal.xml.Element;
import org.eclipse.papyrus.xwt.jface.JFacesHelper;
import org.eclipse.swt.widgets.Widget;

/**
 * @author liang.zhang
 * 
 */
public class DataBindingTrack {

	private String bindingError = "";

	private Set<String> errorElements = null;

	private List<Element> widgetList = null;

	private Map<Element, String> bindingMap;

	public DataBindingTrack() {
		widgetList = new ArrayList<Element>();
		errorElements = new HashSet<String>();
		bindingMap = new HashMap<Element, String>();
	}

	public void addWidgetElement(Element element) {
		widgetList.add(element);
	}

	private void addErrorWidgetId(String elementId) {
		errorElements.add(elementId);
	}

	private void addBindingMessageToMap(Element element, String bindingMessage) {
		bindingMap.put(element, bindingMessage);
	}

	private int validateParentElementError(Element bindingElement) {
		int isError = 0;
		if(!bindingError.equals("")) {
			Object parentObj = bindingElement.getParent();
			while(parentObj != null) {
				bindingElement = (Element)parentObj;
				if(errorElements.contains(bindingElement.getId())) {
					isError = 1;
					break;
				}
				parentObj = bindingElement.getParent();
			}
		}
		return isError;
	}

	private String getCurrentWidgetPosition(Element element) {
		if(element.getParent() != null) {
			return " " + getCurrentWidgetPosition((Element)element.getParent());
		}
		return "";
	}

	public String getDataBindMessage() {
		StringBuffer message = new StringBuffer("");
		Iterator<Element> widgetIt = widgetList.iterator();
		Set<Element> keys = bindingMap.keySet();
		while(widgetIt.hasNext()) {
			Element element = widgetIt.next();
			int parentHasError = validateParentElementError(element);
			if(parentHasError == 0) {
				String content = getCurrentWidgetPosition(element);
				if(!message.toString().equals("")) {
					content += "+ ";
				}
				content = content + element.getName();
				if(XWT.isTracking(Tracking.NAME)) {
					Attribute nameAttr = element.getAttribute("Name");
					if(nameAttr == null) {
						nameAttr = element.getAttribute(IConstants.XWT_X_NAMESPACE, "Name");
					}
					if(nameAttr != null) {
						content += " <" + nameAttr.getContent() + ">";
					}
				}
				message.append(content);
				if(XWT.isTracking(Tracking.DATABINDING)) {
					if(keys.contains(element)) {
						message.append(bindingMap.get(element));
					} else {
						message.append("\n");
					}
				}
			}
		}
		return message.toString();
	}

	private void setBindingErrorMessage(String bindingError) {
		this.bindingError = bindingError;
	}

	public void tracking(Object swtObject, Element element, Object dataContext) {
		String bindingMessage = "";
		if(swtObject instanceof Binding) {
			String error = "";
			Binding newInstance = (Binding)swtObject;
			String path = null;
			Attribute attr = element.getAttribute("Path");
			if(null == attr)
				attr = element.getAttribute("path");
			if(null != attr)
				path = attr.getContent();
			Object dataContext2 = null;
			try {
				dataContext2 = newInstance.getValue(null);
				if(path != null && path.length() > 0) {
					String[] paths = path.trim().split("\\.");
					if(paths.length > 1) {
						String path1 = "";
						for(int i = 0; i < paths.length - 1; i++) {
							path1 = paths[i];
							if(dataContext2 != null) {
								dataContext2 = getObserveData(dataContext2, path1);
							}
						}
					}
				}
			} catch (Exception ex) {
				addErrorWidgetId(element.getParent().getParent().getId());
				setBindingErrorMessage("-> Error");
				error = "-> Error";
			}
			if(dataContext2 != null) {
				bindingMessage = " (DataContext=" + dataContext2.getClass().getSimpleName() + ", Path=" + path + ")" + error + "\n";
				addBindingMessageToMap((Element)element.getParent().getParent(), bindingMessage);// bindingMap.put((Element) element.getParent().getParent(), bindingMessage);
			}
		} else if(swtObject instanceof Widget) {
			addWidgetElement(element);
			if(dataContext != null) {
				bindingMessage = " (DataContext=" + dataContext.getClass().getSimpleName() + ")\n";
				addBindingMessageToMap(element, bindingMessage);
			}
		} else if(JFacesHelper.isViewer(swtObject)) {
			if(dataContext != null) {
				bindingMessage = " (DataContext=" + dataContext.getClass().getSimpleName() + ")\n";
				addBindingMessageToMap(element, bindingMessage);// bindingMap.put(element, bindingMessage);
			}
		} else if(element.attributeNames(IConstants.XWT_X_NAMESPACE).length > 0) {
			// ??
			if(element.getParent() != null && element.getParent().getParent() != null) {
				bindingMessage = " (DataContext=" + element.getName() + ")\n";
				addBindingMessageToMap((Element)element.getParent().getParent(), bindingMessage);// bindingMap.put((Element) element.getParent().getParent(), bindingMessage);
			}
		}
	}

	public static Object getObserveData(Object dataContext, String path) {
		try {
			Class<?> dataContextClass = dataContext.getClass();
			Method getMethod = ObjectUtil.findGetter(dataContextClass, path, null);
			if(getMethod != null) {
				return getMethod.invoke(dataContext);
			}
		} catch (SecurityException e) {
			LoggerManager.log(e);
		} catch (IllegalArgumentException e) {
			LoggerManager.log(e);
		} catch (IllegalAccessException e) {
			LoggerManager.log(e);
		} catch (InvocationTargetException e) {
			LoggerManager.log(e);
		}
		return null;
	}

}
