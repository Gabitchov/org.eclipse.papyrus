/*******************************************************************************
 * Copyright (c) 2009 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) – Initial implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.providers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.diagram.common.util.ExtensionPointParser;
import org.eclipse.papyrus.diagram.common.util.MDTUtil;
import org.eclipse.ui.IEditorPart;

/**
 * A registry that stores IMOSKittEditorFactories as defined in the
 * 'es.cv.gvcase.mdt.common.moskittEditorFactories' extension point. <br>
 * It can provide IEditorParts for Diagrams, EObjects or editor identifiers.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es>Francisco Javier Cano Muñoz</a>
 * 
 */
public class MOSKittEditorFactoryRegistry {

	// // Singleton

	private static final MOSKittEditorFactoryRegistry INSTANCE = new MOSKittEditorFactoryRegistry();

	private MOSKittEditorFactoryRegistry() {
	}

	// @unused
	public static final MOSKittEditorFactoryRegistry getInstance() {
		return INSTANCE;
	}

	// // Maps

	private static Map<String, IMOSKittEditorFactory> mapEditorID2Factory = null;

	private static Map<String, IMOSKittEditorFactory> mapEClass2Factory = null;

	private static Map<String, IMOSKittEditorFactory> mapModel2Factory = null;

	protected static Map<String, IMOSKittEditorFactory> getMapEditorID2Factory() {
		if (mapEditorID2Factory == null) {
			mapEditorID2Factory = new HashMap<String, IMOSKittEditorFactory>();
		}
		return mapEditorID2Factory;
	}

	protected static Map<String, IMOSKittEditorFactory> getMapEClass2Factory() {
		if (mapEClass2Factory == null) {
			mapEClass2Factory = new HashMap<String, IMOSKittEditorFactory>();
		}
		return mapEClass2Factory;
	}

	protected static Map<String, IMOSKittEditorFactory> getMapModel2Factory() {
		if (mapModel2Factory == null) {
			mapModel2Factory = new HashMap<String, IMOSKittEditorFactory>();
		}
		return mapModel2Factory;
	}

	// // getter methods

	// @unused
	public IEditorPart getEditorFor(Object object) {
		if (object == null) {
			return null;
		}
		// check Diagram
		Diagram diagram = (Diagram) Platform.getAdapterManager().getAdapter(object, Diagram.class);
		if (diagram != null) {
			return getEditorForDiagram(diagram);
		}
		// check EObject's EClass
		EObject eObject = (EObject) Platform.getAdapterManager().getAdapter(object, EObject.class);
		if (eObject != null) {
			return getEditorForEObject(eObject);
		}
		// check editorID
		String editorID = (String) Platform.getAdapterManager().getAdapter(object, String.class);
		if (editorID != null) {
			return getEditorForEditorID(editorID);
		}
		// no editor fot object
		return null;
	}

	public IEditorPart getEditorForEditorID(String editorID) {
		if (editorID == null) {
			return null;
		}
		readExtensionPoint();
		if (getMapEditorID2Factory().containsKey(editorID)) {
			IMOSKittEditorFactory factory = getMapEditorID2Factory().get(editorID);
			if (factory != null) {
				return factory.createEditorFor(editorID);
			}
		}
		return null;
	}

	public IEditorPart getEditorForEObject(EObject eObject) {
		if (eObject == null) {
			return null;
		}
		readExtensionPoint();
		Class eObjectClass = eObject.getClass();
		// check for every EClass registered if any of them is a superclass of
		// the given object.
		for (String eClass : getMapEClass2Factory().keySet()) {
			if (MDTUtil.isOfType(eObjectClass, eClass)) {
				IMOSKittEditorFactory factory = getMapEClass2Factory().get(eClass);
				if (factory != null) {
					return factory.createEditorFor(eObject);
				}
			}
		}
		return null;
	}

	public IEditorPart getEditorForDiagram(Diagram diagram) {
		if (diagram == null || diagram.getType() == null) {
			return null;
		}
		readExtensionPoint();
		if (getMapModel2Factory().containsKey(diagram.getType())) {
			IMOSKittEditorFactory factory = getMapModel2Factory().get(diagram.getType());
			if (factory != null) {
				return factory.createEditorFor(diagram);
			}
		}
		return null;
	}

	// // read extension Point

	private static final String ExtensionPointID = "org.eclipse.papyrus.diagram.common.moskittEditorFactory";

	protected void readExtensionPoint() {
		ExtensionPointParser parser = new ExtensionPointParser(ExtensionPointID,
				new Class[] { MOSKittEditorFactory.class });
		MOSKittEditorFactory factory = null;
		List<MOSKittEditorFactory> factories = new ArrayList<MOSKittEditorFactory>();
		// parse extension point
		for (Object object : parser.parseExtensionPoint()) {
			factory = (MOSKittEditorFactory) Platform.getAdapterManager()
					.getAdapter(object, MOSKittEditorFactory.class);
			if (factory != null) {
				factories.add(factory);
			}
		}
		// store all factories in the mappings
		for (MOSKittEditorFactory editorFactoryElement : factories) {
			IMOSKittEditorFactory editorFactory = null;
			if (editorFactoryElement.factory != null) {
				editorFactory = (IMOSKittEditorFactory) Platform.getAdapterManager().getAdapter(
						editorFactoryElement.factory, IMOSKittEditorFactory.class);
				if (editorFactory != null) {
					if (editorFactoryElement.diagramType != null) {
						getMapModel2Factory().put(editorFactoryElement.diagramType, editorFactory);
					}
					if (editorFactoryElement.eClass != null) {
						getMapEClass2Factory().put(editorFactoryElement.eClass, editorFactory);
					}
					if (editorFactoryElement.editorID != null) {
						getMapEditorID2Factory().put(editorFactoryElement.editorID, editorFactory);
					}
				}
			}
		}
	}

}
