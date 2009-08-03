/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.ids;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

// TODO: Auto-generated Javadoc
/**
 * The Class MOSKittModelIDs.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class MOSKittModelIDs {

	// // UML2 model IDs
	/** The Constant UML2ClassModelID. */
	@Deprecated
	public static final String UML2ClassModelID = "MOSKitt UMLClass";

	/** The Constant UML2ActivityModelID. */
	@Deprecated
	public static final String UML2ActivityModelID = "MOSKitt UMLActivity";

	/** The Constant UML2UseCaseModelID. */
	@Deprecated
	public static final String UML2UseCaseModelID = "MOSKitt UMLUseCase";

	/** The Constant UML2StateMachineModelID. */
	@Deprecated
	public static final String UML2StateMachineModelID = "MOSKitt UMLStateMachine";

	/** The Constant UML2SequenceModelID. */
	@Deprecated
	public static final String UML2SequenceModelID = "MOSKitt UMLSequence";

	/** The Constant UML2ProfileModelID. */
	@Deprecated
	public static final String UML2ProfileModelID = "MOSKitt UMLProfile";

	// // SQL IDs
	/** The Constant SQLModelID. */
	@Deprecated
	public static final String SQLModelID = "Sqlmodel";

	// // WBD IDs
	/** The Constant WBSModelID. */
	@Deprecated
	public static final String WBSModelID = "Wbs";

	/** The all model i ds. */
	@Deprecated
	private static List<String> allModelIDs = null;

	/**
	 * Gets the all model i ds.
	 * 
	 * @return the all model i ds
	 */
	@Deprecated
	public static List<String> getAllModelIDs() {
		if (allModelIDs == null) {
			allModelIDs = new ArrayList<String>();
			allModelIDs.add(UML2ClassModelID);
			allModelIDs.add(UML2ActivityModelID);
			allModelIDs.add(UML2UseCaseModelID);
			allModelIDs.add(UML2StateMachineModelID);
			allModelIDs.add(UML2SequenceModelID);
			allModelIDs.add(SQLModelID);
			allModelIDs.add(WBSModelID);
		}
		return allModelIDs;
	}

	/** Extension Point functionality. */

	private static final String mapModelToEditorExtensionPoint = "org.eclipse.papyrus.diagram.common.modelToEditorMap";

	/** The Constant ATT_MODELID. */
	private static final String ATT_MODELID = "modelID";

	/** The Constant ATT_EDITORID. */
	private static final String ATT_EDITORID = "editorID";

	/** The cached model i ds. */
	private static List<String> cachedModelIDs = null;

	/**
	 * Gets the all extension model i ds.
	 * 
	 * @return the all extension model i ds
	 */
	public static List<String> getAllExtensionModelIDs() {
		if (cachedModelIDs != null) {
			return cachedModelIDs;
		}
		cachedModelIDs = new ArrayList<String>();
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(mapModelToEditorExtensionPoint);
		for (IExtension extension : extensionPoint.getExtensions()) {
			cachedModelIDs.addAll(processExtension(extension));
		}
		return cachedModelIDs;
	}

	/**
	 * Process extension.
	 * 
	 * @param extension
	 *            the extension
	 * 
	 * @return the list< string>
	 */
	protected static List<String> processExtension(IExtension extension) {
		List<String> models = new ArrayList<String>();
		for (IConfigurationElement configElement : extension.getConfigurationElements()) {
			models.add(configElement.getAttribute(ATT_MODELID));
		}
		return models;
	}

}
