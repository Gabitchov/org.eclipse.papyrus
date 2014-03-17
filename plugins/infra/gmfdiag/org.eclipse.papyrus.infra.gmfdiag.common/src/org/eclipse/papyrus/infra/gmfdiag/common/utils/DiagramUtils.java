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
package org.eclipse.papyrus.infra.gmfdiag.common.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView;
import org.eclipse.papyrus.infra.viewpoints.policy.PolicyChecker;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;
import org.eclipse.papyrus.infra.viewpoints.style.PapyrusViewStyle;
import org.eclipse.papyrus.infra.viewpoints.style.StylePackage;

/**
 * Utilities for the management of configuration-related data on views and diagrams
 * @author Laurent Wouters
 */
public class DiagramUtils {
	
	/**
	 * Gets the diagram associated to the given edit part
	 * @param part The edit part
	 * @return The diagram associated to the edit part, or <code>null</code> if none is found
	 */
	public static Diagram getDiagramFrom(EditPart part) {
		EditPart current = part;
		while (current != null) {
			Object model = current.getModel();
			if (model instanceof Diagram)
				return (Diagram)model;
			current = current.getParent();
		}
		return null;
	}
	
	/**
	 * Gets the owner of a diagram as it will appear in the model explorer.
	 * In the case where the diagram does not yet have a defined owner, the diagram's root element will be returned instead.
	 * @param diagram A diagram
	 * @return The diagram's owner
	 */
	public static EObject getOwner(Diagram diagram) {
		Style style = diagram.getStyle(StylePackage.Literals.PAPYRUS_VIEW_STYLE);
		if (style != null) {
			PapyrusViewStyle pvs = (PapyrusViewStyle)style;
			EObject value = pvs.getOwner();
			if (value != null)
				return value;
		}
		// This is the legacy fallback for old diagrams
		return diagram.getElement();
	}
	
	/**
	 * Sets the owner of a diagram as it will appear in the model explorer
	 * @param diagram A diagram
	 * @param owner The new diagram's owner
	 */
	public static void setOwner(Diagram diagram, EObject owner) {
		Style style = diagram.getStyle(StylePackage.Literals.PAPYRUS_VIEW_STYLE);
		if (style != null) {
			PapyrusViewStyle pvs = (PapyrusViewStyle)style;
			pvs.setOwner(owner);
		} else {
			PapyrusViewStyle pvs = (PapyrusViewStyle)diagram.createStyle(StylePackage.Literals.PAPYRUS_VIEW_STYLE);
			pvs.setOwner(owner);
		}
	}
	
	/**
	 * Gets the prototype of a diagram
	 * @param diagram A diagram
	 * @return The diagram's prototype
	 */
	public static ViewPrototype getPrototype(Diagram diagram) {
		Style style = diagram.getStyle(StylePackage.Literals.PAPYRUS_VIEW_STYLE);
		if (style != null) {
			PapyrusViewStyle pvs = (PapyrusViewStyle)style;
			PapyrusView config = pvs.getConfiguration();
			if (config != null) {
				if (PolicyChecker.getCurrent().isInViewpoint(config))
					return ViewPrototype.get(config);
				return ViewPrototype.UNAVAILABLE_DIAGRAM;
			}
			return ViewPrototype.get(diagram.getType(), pvs.getOwner(), diagram.getElement());
		}
		// This is the legacy fallback for old diagrams
		if ("Package".equals(diagram.getType())) {
			for (ViewPrototype prototype : PolicyChecker.getCurrent().getAllPrototypes()) {
				if ("UML Package Diagram".equals(prototype.getLabel()))
					return prototype;
			}
		}
		return ViewPrototype.get(diagram.getType(), diagram.getElement(), diagram.getElement());
	}
	
	/**
	 * Sets the prototype of a diagram
	 * @param diagram A diagram
	 * @param configuration The new diagram's prototype
	 */
	public static void setPrototype(Diagram diagram, ViewPrototype prototype) {
		Style style = diagram.getStyle(StylePackage.Literals.PAPYRUS_VIEW_STYLE);
		if (style != null) {
			PapyrusViewStyle pvs = (PapyrusViewStyle)style;
			pvs.setConfiguration(prototype.getConfiguration());
		} else {
			PapyrusViewStyle pvs = (PapyrusViewStyle)diagram.createStyle(StylePackage.Literals.PAPYRUS_VIEW_STYLE);
			pvs.setConfiguration(prototype.getConfiguration());
		}
	}
}
