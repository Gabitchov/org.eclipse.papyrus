/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.tabbedproperties.appearance;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractNotationPropertiesSection;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ForkNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.JoinNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.part.CustomMessages;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.common.ui.helper.HelpComponentFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.forms.widgets.ImageHyperlink;

/**
 * Section to use in the properties view. This section enables to switch the
 * direction of a segment representation (for fork or join).
 */
public class SwitchSegmentDirectionSection extends AbstractNotationPropertiesSection {

	/** path to the switch icon */
	private static final String ICON_PATH = "icons/switchSegmentOrientation.gif";

	/** The switch image. */
	public static Image switchImage = null;
	/** Load the switch icon once */
	static {
		try {
			switchImage = new Image(Display.getDefault(), UMLDiagramEditorPlugin.getInstance().getBundle().getResource(ICON_PATH).openStream());
		} catch (IOException e) {
			UMLDiagramEditorPlugin.getInstance().logError(e.getMessage(), e);
		}
	}

	/** current edit part */
	protected IGraphicalEditPart editPart;

	/**
	 * Create controls to enable direction switch
	 */
	@Override
	public void initializeControls(Composite parent) {
		super.initializeControls(parent);
		GridLayout layout = new GridLayout(2, false);
		Group switchGroup = getWidgetFactory().createGroup(composite, CustomMessages.ForkJoinSegmentSwitchOrientation_actionLabel);
		switchGroup.setLayout(layout);
		// create switch button
		Button button = new Button(switchGroup, SWT.PUSH);
		button.setImage(switchImage);
		GridData gd = new GridData(SWT.CENTER, SWT.CENTER, true, true);
		button.setLayoutData(gd);
		button.addSelectionListener(new SelectionListener() {

			/**
			 * {@inheritDoc}
			 */
			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			/**
			 * {@inheritDoc}
			 */
			public void widgetSelected(SelectionEvent e) {
				switchSelectedSegmentsOrientation();
				refresh();
			}
		});
		// create help
		ImageHyperlink help = HelpComponentFactory.createHelpComponent(switchGroup, getWidgetFactory(), CustomMessages.ForkJoinSegmentSwitchOrientation_helpMessage);
		gd = new GridData(SWT.RIGHT, SWT.CENTER, false, true);
		help.setLayoutData(gd);
		help.setBackground(switchGroup.getBackground());
	}

	/**
	 * Switch the orientation of each selected segment figure.
	 */
	protected void switchSelectedSegmentsOrientation() {
		CompositeCommand globalCommand = new CompositeCommand(CustomMessages.ForkJoinSegmentSwitchOrientation_actionLabel);
		List<?> editparts = getInput();
		for(Object part : editparts) {
			Object view = null;
			Figure figure = null;
			if(part instanceof JoinNodeEditPart) {
				view = ((JoinNodeEditPart)part).getModel();
				figure = ((JoinNodeEditPart)part).getPrimaryShape();
			} else if(part instanceof ForkNodeEditPart) {
				view = ((ForkNodeEditPart)part).getModel();
				figure = ((ForkNodeEditPart)part).getPrimaryShape();
			}
			// append a command for selected part only if correct configuration
			if(view instanceof View && figure != null) {
				TransactionalEditingDomain editingdomain = EditorUtils.getTransactionalEditingDomain();
				SwitchSegmentOrientation switchCom = new SwitchSegmentOrientation(editingdomain, figure, (View)view);
				globalCommand.add(switchCom);
			}
		}
		// execute the command for all parts
		if(!globalCommand.isEmpty() && globalCommand.canExecute()) {
			CommandStack stack = (CommandStack)EditorUtils.getMultiDiagramEditor().getAdapter(CommandStack.class);
			if(stack != null) {
				stack.execute(new ICommandProxy(globalCommand));
			}
		}
	}

	/**
	 * This class is a command which switches the orientation of a figure. The
	 * figure's width and height are switched, rotating the figure on its
	 * center. (center location kept)
	 */
	private class SwitchSegmentOrientation extends AbstractTransactionalCommand {

		/** The figure to switch */
		private Figure selectedFigure = null;

		/** The model view for the figure to switch */
		private View selectedView = null;

		/**
		 * Construct a switch orientation command.
		 * 
		 * @param domain
		 *        transactional editing domain
		 * @param figure
		 *        the figure to rotate
		 * @param view
		 *        the view which is the model of the figure
		 */
		SwitchSegmentOrientation(TransactionalEditingDomain domain, Figure figure, View view) {
			super(domain, CustomMessages.ForkJoinSegmentSwitchOrientation_actionLabel, null);
			selectedFigure = figure;
			selectedView = view;
		}

		/**
		 * Execute the command, rotating the figure.
		 * 
		 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
		 *      org.eclipse.core.runtime.IAdaptable)
		 * 
		 * @param monitor
		 *        progress monitor
		 * @param info
		 *        adapter for information
		 * @return the result of the command
		 * @throws ExecutionException
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			if(selectedFigure == null || selectedView == null) {
				return CommandResult.newCancelledCommandResult();
			}
			Dimension newSize = selectedFigure.getSize().getTransposed();
			Point newLocation = selectedFigure.getLocation().getCopy();
			newLocation.translate((newSize.height - newSize.width) / 2, (newSize.width - newSize.height) / 2);
			ViewUtil.setStructuralFeatureValue(selectedView, NotationPackage.eINSTANCE.getLocation_X(), newLocation.x);
			ViewUtil.setStructuralFeatureValue(selectedView, NotationPackage.eINSTANCE.getLocation_Y(), newLocation.y);
			ViewUtil.setStructuralFeatureValue(selectedView, NotationPackage.eINSTANCE.getSize_Width(), newSize.width);
			ViewUtil.setStructuralFeatureValue(selectedView, NotationPackage.eINSTANCE.getSize_Height(), newSize.height);
			return CommandResult.newOKCommandResult();
		}

		/**
		 * @see org.eclipse.emf.workspace.AbstractEMFOperation#canUndo()
		 * @return true if command can undo
		 */
		@Override
		public boolean canUndo() {
			return selectedFigure != null && selectedView != null;
		}

		/**
		 * @see org.eclipse.emf.workspace.AbstractEMFOperation#canRedo()
		 * @return true if command can redo
		 */
		@Override
		public boolean canRedo() {
			return selectedFigure != null && selectedView != null;
		}

		/**
		 * Undo the switch (by switching again)
		 * 
		 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doUndo(org.eclipse.core.runtime.IProgressMonitor,
		 *      org.eclipse.core.runtime.IAdaptable)
		 * 
		 * @param monitor
		 *        progress monitor
		 * @param info
		 *        adapter for information
		 * @return the result of the command
		 * @throws ExecutionException
		 */
		@Override
		protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			return doExecute(monitor, info);
		}

		/**
		 * Redo the switch (by switching again)
		 * 
		 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doRedo(org.eclipse.core.runtime.IProgressMonitor,
		 *      org.eclipse.core.runtime.IAdaptable)
		 * 
		 * @param monitor
		 *        progress monitor
		 * @param info
		 *        adapter for information
		 * @return the result of the command
		 * @throws ExecutionException
		 */
		@Override
		protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			return doExecute(monitor, info);
		}
	}
}
