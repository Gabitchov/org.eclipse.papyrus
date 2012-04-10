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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.papyrus.xwt.IConstants;
import org.eclipse.papyrus.xwt.ILoadingContext;
import org.eclipse.papyrus.xwt.IMetaclassFactory;
import org.eclipse.papyrus.xwt.IXWTLoader;
import org.eclipse.papyrus.xwt.metadata.IMetaclass;

/**
 * @author yyang (yves.yang@soyatec.com)
 */
public class MetaclassService {

	protected Map<String, MetaclassManager> map = new HashMap<String, MetaclassManager>();

	protected ArrayList<IMetaclassFactory> factories = new ArrayList<IMetaclassFactory>();

	private IXWTLoader xwtLoader;

	public MetaclassService(IXWTLoader xwtLoader) {
		this.xwtLoader = xwtLoader;
	}

	public IMetaclass getMetaclass(ILoadingContext context, String name, String namespace) {
		MetaclassManager manager = map.get(namespace);
		if(manager == null) {
			manager = new MetaclassManager(this, map.get(IConstants.XWT_NAMESPACE), xwtLoader);
			map.put(namespace, manager);
		}
		return manager.getMetaclass(context, name, namespace);
	}

	public IMetaclass findMetaclass(Class<?> type) {
		MetaclassManager manager = map.get(IConstants.XWT_NAMESPACE);
		if(manager == null) {
			return null;
		}
		return manager.getMetaclass(type);
	}

	public IMetaclass getMetaclass(Class<?> type) {
		MetaclassManager manager = map.get(IConstants.XWT_NAMESPACE);
		if(manager == null) {
			return null;
		}
		IMetaclass metaclass = manager.getMetaclass(type);
		if(metaclass == null) {
			String packageName = "";
			Package packageObject = type.getPackage();
			if(packageObject != null) {
				packageName = packageObject.getName();
			}
			String key = IConstants.XAML_CLR_NAMESPACE_PROTO + ":" + packageName;
			MetaclassManager childManager = map.get(key);
			if(childManager == null) {
				childManager = new MetaclassManager(this, manager, xwtLoader);
				map.put(key, childManager);
			}
			metaclass = childManager.getMetaclass(type);
			if(metaclass == null) {
				childManager.register(type);
				metaclass = childManager.getMetaclass(type);
			}
		}
		return metaclass;
	}

	public IMetaclass getMetaclass(Class<?> type, String namespace) {
		MetaclassManager manager = map.get(namespace);
		if(manager == null) {
			manager = new MetaclassManager(this, null, xwtLoader);
			map.put(namespace, manager);
		}
		IMetaclass metaclass = manager.getMetaclass(type);
		if(metaclass == null) {
			metaclass = manager.getMetaclass(type);
			if(metaclass == null) {
				manager.register(type);
				metaclass = manager.getMetaclass(type);
			}
		}
		return metaclass;
	}

	public IMetaclass register(Class<?> metaclass, String namespace) {
		MetaclassManager manager = map.get(namespace);
		if(manager == null) {
			throw new IllegalStateException();
		}
		return manager.register(metaclass);
	}

	public IMetaclass register(Class<?> metaclass, String namespace, IMetaclass superMetaclass) {
		MetaclassManager manager = map.get(namespace);
		if(manager == null) {
			throw new IllegalStateException();
		}
		return manager.register(metaclass, superMetaclass);
	}

	public void register(IMetaclass metaclass, String namespace) {
		MetaclassManager manager = map.get(namespace);
		if(manager == null) {
			manager = new MetaclassManager(this, null, xwtLoader);
			map.put(namespace, manager);
		}
		manager.register(metaclass);
	}

	public Collection<IMetaclass> getAllMetaclasses(String namespace) {
		MetaclassManager manager = map.get(namespace);
		if(manager == null) {
			throw new IllegalStateException();
		}
		return manager.getAllMetaclasses();
	}

	public void register(String namespace, MetaclassManager manager) {
		map.put(namespace, manager);
	}

	public void registerFactory(IMetaclassFactory metaclassFactory) {
		factories.add(metaclassFactory);
	}

	public IMetaclassFactory findFactory(Class<?> javaClass) {
		for(int i = factories.size() - 1; i >= 0; i--) {
			IMetaclassFactory factory = factories.get(i);
			if(factory.isFactoryOf(javaClass)) {
				return factory;
			}
		}
		return null;
	}
}
