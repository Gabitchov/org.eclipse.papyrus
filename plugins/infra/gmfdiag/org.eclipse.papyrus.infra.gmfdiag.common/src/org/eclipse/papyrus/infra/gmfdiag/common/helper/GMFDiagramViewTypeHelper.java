/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.helper;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.gmfdiag.common.AbstractPapyrusGmfCreateDiagramCommandHandler;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusDiagram;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView;
import org.eclipse.papyrus.infra.viewpoints.policy.IViewTypeHelper;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;

/**
 * Represents the dynamic contribution of a policy to menus
 * @author Laurent Wouters
 */
public class GMFDiagramViewTypeHelper implements IViewTypeHelper {
	/**
	 * ID of the extension point for Papyrus diagrams
	 */
	private static final String EXTENSION_PAPYRUS_DIAGRAM = "org.eclipse.papyrus.infra.core.papyrusDiagram";
	
	private static class NakedViewPrototype extends DiagramPrototype {
		private final String label;
		private final String icon;
		public NakedViewPrototype(PapyrusView configuration, String category, AbstractPapyrusGmfCreateDiagramCommandHandler command, String label, String icon) {
			super(configuration, category, command);
			this.label = label;
			this.icon = icon;
		}
		@Override
		public String getLabel() { return label; }
		@Override
		public String getIconURI() { return icon; }
	}
	
	private static class Implementation {
		public final String name;
		public final String icon;
		public final String language;
		public final AbstractPapyrusGmfCreateDiagramCommandHandler command;
		public Implementation(String name, String icon, String language, AbstractPapyrusGmfCreateDiagramCommandHandler command) {
			this.name = name;
			this.icon = icon;
			this.language = language;
			this.command = command;
		}
	}
	
	
	/**
	 * The cache of prototypes
	 */
	private Map<PapyrusView, DiagramPrototype> cache;
	
	/**
	 * The cache of implementations
	 */
	private Map<String, Implementation> implementations;
	
	/**
	 * @see org.eclipse.papyrus.infra.viewpoints.policy.IViewTypeHelper#isSupported(org.eclipse.emf.ecore.EClass)
	 */
	public boolean isSupported(EClass type) {
		return EcoreUtil.equals(type, ConfigurationPackage.eINSTANCE.getPapyrusDiagram());
	}

	/**
	 * @see org.eclipse.papyrus.infra.viewpoints.policy.IViewTypeHelper#isSupported(org.eclipse.emf.ecore.EObject)
	 */
	public boolean isSupported(EObject view) {
		return (view instanceof Diagram);
	}
	
	/**
	 * @see org.eclipse.papyrus.infra.viewpoints.policy.IViewTypeHelper#getPrototypeFor(org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView)
	 */
	public ViewPrototype getPrototypeFor(PapyrusView configuration) {
		if (!(configuration instanceof PapyrusDiagram))
			return null;
		if (implementations == null)
			buildImplementationCache();
		if (cache == null)
			cache = new HashMap<PapyrusView, DiagramPrototype>();
		if (cache.containsKey(configuration))
			return cache.get(configuration);
		if (!implementations.containsKey(configuration.getImplementationID()))
			return null;
		Implementation impl = implementations.get(configuration.getImplementationID());
		if (ViewPrototype.isNatural(configuration)) {
			NakedViewPrototype proto = new NakedViewPrototype(configuration, impl.language, impl.command, impl.name, impl.icon);
			cache.put(configuration, proto);
			return proto;
		} else {
			DiagramPrototype proto = new DiagramPrototype(configuration, impl.language, impl.command);
			cache.put(configuration, proto);
			return proto;
		}
	}
	
	/**
	 * @see org.eclipse.papyrus.infra.viewpoints.policy.IViewTypeHelper#getPrototypeOf(org.eclipse.emf.ecore.EObject)
	 */
	public ViewPrototype getPrototypeOf(EObject view) {
		if (!(view instanceof Diagram))
			return null;
		return DiagramUtils.getPrototype((Diagram)view);
	}
	
	/**
	 * Builds the cache of metadata
	 */
	private void buildImplementationCache() {
		implementations = new HashMap<String, Implementation>();
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint point = registry.getExtensionPoint(EXTENSION_PAPYRUS_DIAGRAM);
		IExtension[] extensions = point.getExtensions();
		for (int i=0; i!=extensions.length; i++) {
			IConfigurationElement[] elements = extensions[i].getConfigurationElements();
			for (int j=0; j!=elements.length; j++) {
				if (elements[j].getName().equals("creationCommand")) {
					try {
						Object obj = elements[j].createExecutableExtension("creationCommandClass");
						if (obj instanceof AbstractPapyrusGmfCreateDiagramCommandHandler) {
							AbstractPapyrusGmfCreateDiagramCommandHandler command = (AbstractPapyrusGmfCreateDiagramCommandHandler)obj;
							String label = elements[j].getAttribute("label");
							String icon = elements[j].getAttribute("icon");
							String language = elements[j].getAttribute("language");
							String implID = command.getCreatedDiagramType();
							if (!icon.startsWith("platform:/"))
								icon = "platform:/plugin/" + extensions[i].getContributor().getName() + "/" + icon;
							if (!implementations.containsKey(implID))
								implementations.put(implID, new Implementation(label, icon, language, command));
						}
					}
					catch (CoreException e) { }
				}
			}
		}
	}
}
