/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.properties.WorkspaceViewerProperties;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.commands.CheckedDiagramCommandStack;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.CommandIds;
import org.eclipse.papyrus.infra.tools.util.EclipseCommandUtils;
import org.eclipse.papyrus.infra.widgets.util.IRevealSemanticElement;
import org.eclipse.papyrus.infra.widgets.util.NavigationTarget;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;

/**
 * 
 * This GMF editor contains a methods in order to reveal visual element from a list of semantic element.
 * 
 */

@SuppressWarnings("restriction")
//suppress the warning for WorkspaceViewerProperties
public class SynchronizableGmfDiagramEditor extends DiagramDocumentEditor implements IRevealSemanticElement, NavigationTarget {

	public SynchronizableGmfDiagramEditor(boolean hasFlyoutPalette) {
		super(hasFlyoutPalette);
	}

	/**
	 * reveal all editpart that represent an element in the given list.
	 * 
	 * @see org.eclipse.papyrus.infra.core.ui.IRevealSemanticElement#revealSemanticElement(java.util.List)
	 * 
	 */
	public void revealSemanticElement(List<?> elementList) {
		revealElement(elementList);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean revealElement(Object element) {
		return revealElement(Collections.singleton(element));
	}


	/**
	 * {@inheritDoc}
	 * 
	 * reveal all editpart that represent an element in the given list.
	 * 
	 * @see org.eclipse.papyrus.infra.core.ui.IRevealSemanticElement#revealSemanticElement(java.util.List)
	 * 
	 */
	public boolean revealElement(Collection<?> elementList) {
		//create an instance that can get semantic element from gmf
		SemanticFromGMFElement semanticFromGMFElement = new SemanticFromGMFElement();

		// get the graphical viewer
		GraphicalViewer graphicalViewer = getGraphicalViewer();
		if(graphicalViewer != null) {

			//look for among all edit part if the semantic is contained in the list
			Iterator<?> iter = graphicalViewer.getEditPartRegistry().values().iterator();
			IGraphicalEditPart researchedEditPart = null;

			while(iter.hasNext() && researchedEditPart == null) {
				Object currentEditPart = iter.next();
				//look for only among IPrimary editpart to avoid compartment and labels of links
				if(currentEditPart instanceof IPrimaryEditPart) {
					if(elementList.contains(semanticFromGMFElement.getSemanticElement(currentEditPart))) {
						researchedEditPart = ((IGraphicalEditPart)currentEditPart);
						break;
					}
				}
			}

			//We may also search for a GMF View (Instead of a semantic model Element)
			if(researchedEditPart == null) {
				for(Object element : elementList) {
					if(graphicalViewer.getEditPartRegistry().containsKey(element)) {
						researchedEditPart = (IGraphicalEditPart)graphicalViewer.getEditPartRegistry().get(element);
						break;
					}
				}
			}

			//an editpart has been found so put selection on it.
			if(researchedEditPart != null) {
				graphicalViewer.select(researchedEditPart); //Set selection
				graphicalViewer.reveal(researchedEditPart); //If needed, scroll to make the edit part visible
				return true;
			}
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class type) {
		if(type == DiagramEditPart.class) {
			return getDiagramEditPart();
		}
		if(type == Diagram.class) {
			return getDiagram();
		}
		return super.getAdapter(type);
	}

	/**
	 * Configures my diagram edit domain with its command stack.
	 * This method has been completely overridden in order to use a proxy stack.
	 */
	@Override
	protected void configureDiagramEditDomain() {

		DefaultEditDomain editDomain = getEditDomain();

		if(editDomain != null) {
			CommandStack stack = editDomain.getCommandStack();
			if(stack != null) {
				// dispose the old stack
				stack.dispose();
			}

			// create and assign the new stack
			CheckedDiagramCommandStack diagramStack = new CheckedDiagramCommandStack(getDiagramEditDomain());

			editDomain.setCommandStack(diagramStack);
		}

		DiagramEditDomain diagEditDomain = (DiagramEditDomain)getDiagramEditDomain();
		diagEditDomain.setActionManager(createActionManager());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
		super.setFocus();
		updateToggleActionState();
	}


	/**
	 * this command update the status of the toggle actions
	 */
	protected void updateToggleActionState() {
		final ICommandService commandService = (ICommandService)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getService(ICommandService.class);
		if(commandService != null) {
			final IPreferenceStore wsPreferenceStore = ((DiagramGraphicalViewer)getDiagramGraphicalViewer()).getWorkspaceViewerPreferenceStore();
			org.eclipse.core.commands.Command command = commandService.getCommand(CommandIds.VIEW_GRID_COMMAND);
			EclipseCommandUtils.updateToggleCommandState(command, wsPreferenceStore.getBoolean(WorkspaceViewerProperties.VIEWGRID));

			command = commandService.getCommand(CommandIds.VIEW_RULER_COMMAND);
			EclipseCommandUtils.updateToggleCommandState(command, wsPreferenceStore.getBoolean(WorkspaceViewerProperties.VIEWRULERS));

			command = commandService.getCommand(CommandIds.VIEW_PAGE_BREAK_COMMAND);
			EclipseCommandUtils.updateToggleCommandState(command, wsPreferenceStore.getBoolean(WorkspaceViewerProperties.VIEWPAGEBREAKS));

			command = commandService.getCommand(CommandIds.SNAP_TO_GRID_COMMAND);
			EclipseCommandUtils.updateToggleCommandState(command, wsPreferenceStore.getBoolean(WorkspaceViewerProperties.SNAPTOGRID));

		} else {
			throw new RuntimeException(String.format("The Eclipse service {0} has not been found", ICommandService.class)); //$NON-NLS-1$
		}
	}


	@Override
	protected void addDefaultPreferences() {
		super.addDefaultPreferences();
		final PreferencesHint preferencesHint = getPreferencesHint();
		final IPreferenceStore globalPreferenceStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		final String diagramType = getDiagram().getType();
		//get the preferences
		final boolean viewGrid = globalPreferenceStore.getBoolean(PreferencesConstantsHelper.getDiagramConstant(diagramType, PreferencesConstantsHelper.VIEW_GRID));
		final boolean viewRuler = globalPreferenceStore.getBoolean(PreferencesConstantsHelper.getDiagramConstant(diagramType, PreferencesConstantsHelper.VIEW_RULER));
		final int rulerUnit = globalPreferenceStore.getInt(PreferencesConstantsHelper.getDiagramConstant(diagramType, PreferencesConstantsHelper.RULER_UNITS));
		final boolean snapToGrid = globalPreferenceStore.getBoolean(PreferencesConstantsHelper.getDiagramConstant(diagramType, PreferencesConstantsHelper.SNAP_TO_GRID));
		final boolean snapToGeometry = globalPreferenceStore.getBoolean(PreferencesConstantsHelper.getDiagramConstant(diagramType, PreferencesConstantsHelper.SNAP_TO_GEOMETRY));
		final RGB rgb = PreferenceConverter.getColor(globalPreferenceStore, PreferencesConstantsHelper.getDiagramConstant(diagramType, PreferencesConstantsHelper.GRID_LINE_COLOR));
		final int gridLineColor = FigureUtilities.RGBToInteger(rgb);
		final double gridSpacing = globalPreferenceStore.getDouble(PreferencesConstantsHelper.getDiagramConstant(diagramType, PreferencesConstantsHelper.GRID_SPACING));
		final boolean gridOrder = globalPreferenceStore.getBoolean(PreferencesConstantsHelper.getDiagramConstant(diagramType, PreferencesConstantsHelper.GRID_ORDER));
		final int gridLineStyle = globalPreferenceStore.getInt(PreferencesConstantsHelper.getDiagramConstant(diagramType, PreferencesConstantsHelper.GRID_LINE_STYLE));

		//set the preferences
		final IPreferenceStore localStore = getWorkspaceViewerPreferenceStore();
		//		localStore.setValue(PreferencesConstantsHelper.SHOW_GRID_CONSTANT, viewGrid);
		//		localStore.setValue(PreferencesConstantsHelper.SHOW_RULER_CONSTANT, viewRuler);
		//		localStore.setValue(PreferencesConstantsHelper.RULER_UNITS_CONSTANT, rulerUnit);
		//		localStore.setValue(PreferencesConstantsHelper.SNAP_TO_GRID_CONSTANT, snapToGrid);
		//		localStore.setValue(PreferencesConstantsHelper.SNAP_TO_SHAPE_CONSTANT, snapToGeometry);
		//		localStore.setValue(PreferencesConstantsHelper.GRID_COLOR_CONSTANT, gridLineColor);
		//		localStore.setValue(PreferencesConstantsHelper.GRID_SPACING_CONSTANT, gridSpacing);
		//		localStore.setValue(PreferencesConstantsHelper.GRID_ORDER_CONSTANT, gridOrder);
		//		localStore.setValue(PreferencesConstantsHelper.GRID_STYLE_CONSTANT, gridLineStyle);

		localStore.setDefault(PreferencesConstantsHelper.VIEW_GRID_CONSTANT, viewGrid);
		localStore.setDefault(PreferencesConstantsHelper.VIEW_RULERS_CONSTANT, viewRuler);
		localStore.setDefault(PreferencesConstantsHelper.RULER_UNITS_CONSTANT, rulerUnit);
		localStore.setDefault(PreferencesConstantsHelper.SNAP_TO_GRID_CONSTANT, snapToGrid);
		localStore.setDefault(PreferencesConstantsHelper.SNAP_TO_GEOMETRY_CONSTANT, snapToGeometry);
		localStore.setDefault(PreferencesConstantsHelper.GRID_LINE_COLOR_CONSTANT, gridLineColor);
		localStore.setDefault(PreferencesConstantsHelper.GRID_SPACING_CONSTANT, gridSpacing);
		localStore.setDefault(PreferencesConstantsHelper.GRID_ORDER_CONSTANT, gridOrder);
		localStore.setDefault(PreferencesConstantsHelper.GRID_LINE_STYLE_CONSTANT, gridLineStyle);

	}


}
