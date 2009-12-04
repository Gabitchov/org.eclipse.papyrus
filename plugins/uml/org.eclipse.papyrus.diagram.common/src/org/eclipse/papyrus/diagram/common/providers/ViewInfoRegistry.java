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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.diagram.common.util.ExtensionPointParser;

/**
 * Registry for {@link ViewInfo} structures. It stores ViewInfo structures for
 * editor identifiers. It can provide ViewInfo structures for an editor. It can
 * also provide ViewInfo substructures for a visualID for an editor.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * @NOT-generated
 */
public class ViewInfoRegistry {

	// // singleton

	/** The instance */
	private static final ViewInfoRegistry INSTANCE = new ViewInfoRegistry();

	/** Constructor */
	private ViewInfoRegistry() {
	}

	/** Gets the singleton instance of this registry */
	public static ViewInfoRegistry getInstance() {
		return INSTANCE;
	}

	/**
	 * Extension point identifier.
	 * 
	 * @NOT-generated
	 */
	private static final String extensionPointID = "es.cv.gvcase.mdt.common.viewInfo";

	/** Extension Point identifier getter. */
	protected static String getExtensionPointID() {
		return extensionPointID;
	}

	/**
	 * Mapping storage for the editor identifier to RootViewInfo structures.
	 * 
	 * @NOT-generated
	 */
	private static Map<String, RootViewInfo> mapEditorID2RootViewInfo = null;

	/** Mapping storage getter. */
	protected static Map<String, RootViewInfo> getMapEditorID2RootViewInfo() {
		if(mapEditorID2RootViewInfo == null) {
			mapEditorID2RootViewInfo = new HashMap<String, RootViewInfo>();
		}
		return mapEditorID2RootViewInfo;
	}

	/**
	 * Gets the mapping from editors identifiers to RootViewInfo structures; as
	 * defined in the extension point. This method reads the extension point
	 * each time it is invoked.
	 * 
	 * @return
	 */
	public Map<String, RootViewInfo> getEditorIdsToViewInfos() {
		return readMapEditorID2RootViewInfo();
	}

	/**
	 * Gets all the editor identifiers that have a RootViewInfo structure
	 * associated in this registry.
	 * 
	 * @return
	 */
	public Collection<String> getAllEditorIDs() {
		return readMapEditorID2RootViewInfo().keySet();
	}

	/**
	 * Gets all the RootViewInfo structures associated to one or mode editors in
	 * this registry.
	 * 
	 * @return
	 */
	public Collection<RootViewInfo> getAllRootViewInfos() {
		return readMapEditorID2RootViewInfo().values();
	}

	/**
	 * Gets the RootViewInfo structure for the given editor.
	 * 
	 * @param editorID
	 * @return
	 */
	public RootViewInfo getRootViewInfoForEditor(String editorID) {
		return readMapEditorID2RootViewInfo().get(editorID);
	}

	/**
	 * Gets the ViewInfo structure, starting with the Head ViewInfo, for the
	 * given editor.
	 * 
	 * @param editorID
	 * @return
	 */
	public ViewInfo getHeadViewInfoForEditor(String editorID) {
		RootViewInfo rootViewInfo = readMapEditorID2RootViewInfo()
				.get(editorID);
		if(rootViewInfo != null && rootViewInfo.headViewInfo != null
				&& rootViewInfo.headViewInfo.getType() == ViewInfo.Head) {
			return rootViewInfo.headViewInfo;
		}
		return null;
	}

	/**
	 * Gets the ViewInfo structure, starting with the given visualID, for the
	 * given editor.
	 * 
	 * @param editorID
	 * @param visualID
	 * @return
	 */
	public ViewInfo getViewInfoForVisualIDForEditor(String editorID,
			int visualID) {
		if(editorID == null || editorID.length() <= 0) {
			return null;
		}
		ViewInfo headViewInfo = getHeadViewInfoForEditor(editorID);
		if(headViewInfo == null) {
			return null;
		}
		return findViewInfoByVisualIDInChildren(headViewInfo, visualID);
	}

	protected ViewInfo findViewInfoByVisualIDInChildren(ViewInfo viewInfo,
			int visualID) {
		if(viewInfo.getVisualID() == visualID) {
			return viewInfo;
		}
		ViewInfo foundViewInfo = null;
		for(ViewInfo childrenViewInfo : viewInfo.getChildren()) {
			foundViewInfo = findViewInfoByVisualIDInChildren(childrenViewInfo,
					visualID);
			if(foundViewInfo != null) {
				return foundViewInfo;
			}
		}
		return null;
	}

	/**
	 * Reads, processes, and stores the RootViewInfo structures defined in the
	 * extension point
	 * 
	 * @return
	 */
	protected Map<String, RootViewInfo> readMapEditorID2RootViewInfo() {
		Map<String, RootViewInfo> map = getMapEditorID2RootViewInfo();
		ExtensionPointParser parser = new ExtensionPointParser(
				getExtensionPointID(), new Class[]{ RootViewInfo.class,
				BaseViewInfo.class });
		for(Object object : parser.parseExtensionPoint()) {
			RootViewInfo rootViewInfo = (RootViewInfo)Platform
					.getAdapterManager().getAdapter(object, RootViewInfo.class);
			if(rootViewInfo != null) {
				if(processRootViewInfo(rootViewInfo)) {
					map.put(rootViewInfo.editorID, rootViewInfo);
				}
			}
		}
		return map;
	}

	/**
	 * Processes a RootViewInfo that has been read from the extension point. The
	 * child nodes defined in the extension point are structures hierarchically
	 * as defined by their parent visualIDs.
	 * 
	 * @param rootViewInfo
	 * @return
	 */
	protected boolean processRootViewInfo(RootViewInfo rootViewInfo) {
		if(rootViewInfo == null || rootViewInfo.BaseViewInfo == null
				|| rootViewInfo.BaseViewInfo.size() <= 0) {
			return false;
		}
		// find Head node
		BaseViewInfo headViewInfo = findHeadNodeInRootViewInfo(rootViewInfo);
		if(headViewInfo == null) {
			return false;
		}
		// store the headViewInfo
		rootViewInfo.headViewInfo = headViewInfo;
		// add all other non-Head nodes
		if(addKnownTypesViewInfo(rootViewInfo)) {
			return true;
		} else {
			return false;
		}
	}

	protected BaseViewInfo findHeadNodeInRootViewInfo(RootViewInfo rootViewInfo) {
		if(rootViewInfo == null || rootViewInfo.BaseViewInfo == null
				|| rootViewInfo.BaseViewInfo.size() <= 0) {
			return null;
		}
		for(Object object : rootViewInfo.BaseViewInfo) {
			BaseViewInfo baseViewInfo = (BaseViewInfo)Platform
					.getAdapterManager().getAdapter(object, BaseViewInfo.class);
			if(baseViewInfo != null && ViewInfo.Head == baseViewInfo.getType()) {
				baseViewInfo.rootViewInfo = rootViewInfo;
				return baseViewInfo;
			}
		}
		return null;
	}

	protected boolean addKnownTypesViewInfo(RootViewInfo rootViewInfo) {
		if(rootViewInfo.headViewInfo == null || rootViewInfo == null
				|| rootViewInfo.BaseViewInfo == null
				|| rootViewInfo.BaseViewInfo.size() <= 0) {
			return false;
		}
		ViewInfo headViewInfo = rootViewInfo.headViewInfo;
		for(Object object : rootViewInfo.BaseViewInfo) {
			BaseViewInfo baseViewInfo = (BaseViewInfo)Platform
					.getAdapterManager().getAdapter(object, BaseViewInfo.class);
			if(baseViewInfo != null && ViewInfo.Head != baseViewInfo.getType()
					&& ViewInfo.None != baseViewInfo.getType()) {
				baseViewInfo.rootViewInfo = rootViewInfo;
				headViewInfo.addNode(Integer.valueOf(baseViewInfo.parent),
						baseViewInfo);
			}
		}
		return true;
	}

}
