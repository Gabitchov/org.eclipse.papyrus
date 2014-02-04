/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.utils;

import java.util.Iterator;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.diagram.internalblock.Activator;
import org.eclipse.papyrus.sysml.diagram.internalblock.provider.ElementTypes;
import org.eclipse.papyrus.uml.diagram.common.locator.PortPositionLocatorUtils;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;

/**
 * This class fix Port and FlowPort location during diagram opening (no edit part exists yet).
 */
public class FixPortsLocationOnOpening {

	/**
	 * This method fix the diagram Port and FlowPort locations.
	 * 
	 * @param diagram
	 *        the diagram
	 */
	public void fix(Diagram diagram) {

		// Parse diagram content
		Iterator<EObject> it = diagram.eAllContents();
		while(it.hasNext()) {
			EObject current = it.next();

			// Select Port and FlowPorts
			if(!(current instanceof Shape)) {
				continue;
			}
			
			Shape portView = (Shape)current;
			String currentType = portView.getType();
			if(SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID.equals(currentType) || UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID.equals(currentType)) {

				int borderItemOffset = 10;
				View parentView = ViewUtil.getViewContainer(portView);
				
				if (parentView instanceof Shape){
					Shape parentShape = (Shape)parentView;
					
					Bounds portViewBounds = (Bounds)portView.getLayoutConstraint();
					Bounds parentViewBounds = (Bounds)parentShape.getLayoutConstraint();

					final Rectangle portBounds = new Rectangle(portViewBounds.getX(), portViewBounds.getY(), portViewBounds.getWidth(), portViewBounds.getHeight());

					int parentWidth = parentViewBounds.getWidth();
					int parentHeight = parentViewBounds.getHeight();
					if((parentWidth == -1) && (parentHeight == -1)) {
						// warning the size may not be set in notation (default size), in such a case get default size from preferences.
						String parentPrefKey = ElementTypes.DIAGRAM_ID + "_" + parentShape.getType();
						parentWidth = Activator.getInstance().getPreferenceStore().getInt(PreferencesConstantsHelper.getElementConstant(parentPrefKey, PreferencesConstantsHelper.WIDTH));
						parentHeight = Activator.getInstance().getPreferenceStore().getInt(PreferencesConstantsHelper.getElementConstant(parentPrefKey, PreferencesConstantsHelper.HEIGHT));
					}
					final Rectangle parentBounds = new Rectangle(parentViewBounds.getX(), parentViewBounds.getY(), parentWidth, parentHeight);

					// Calculate the valid location based on currently stored location and parent bounds
					final Rectangle validLocation = PortPositionLocatorUtils.getBorderLocation(parentBounds, portBounds, borderItemOffset);

					// Fix when current location is not the valid location (only possible if parent size is set)
					if((!portBounds.equals(validLocation)) && (parentViewBounds.getWidth() != -1) && (parentViewBounds.getHeight() != -1)) {

						TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(diagram);
						Command fixCommand = new FixLocationCommand(editingDomain, "Fix Port location on opening", portViewBounds, validLocation);
						editingDomain.getCommandStack().execute(fixCommand);
					}
				}


			}
		}
	}

	/**
	 * This command set the Port view with valid locations.
	 */
	public class FixLocationCommand extends RecordingCommand {

		/** Port view bounds. */
		private Bounds portViewBounds;

		/** Port valid bounds (only the location is used here). */
		private Rectangle portValidBounds;

		/** Constructor. */
		public FixLocationCommand(TransactionalEditingDomain domain, String label, Bounds portViewBounds, Rectangle portValidBounds) {
			super(domain, label);
			this.portViewBounds = portViewBounds;
			this.portValidBounds = portValidBounds;
		}

		@Override
		protected void doExecute() {
			portViewBounds.setX(portValidBounds.x());
			portViewBounds.setY(portValidBounds.y());
		}

		@Override
		public boolean canUndo() {
			return false;
		}

	}
}
