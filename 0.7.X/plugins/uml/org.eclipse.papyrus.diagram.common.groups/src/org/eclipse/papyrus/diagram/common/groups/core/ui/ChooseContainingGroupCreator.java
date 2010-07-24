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
package org.eclipse.papyrus.diagram.common.groups.core.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.command.Command;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.diagram.common.groups.Messages;
import org.eclipse.papyrus.diagram.common.groups.core.PendingGroupNotificationsManager;
import org.eclipse.papyrus.diagram.common.groups.core.ui.utils.CreatorUtils;
import org.eclipse.papyrus.diagram.common.groups.core.utils.Utils;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * This class creates composite for choosing which group among the list will contain the element
 * 
 * @author vhemery
 */
public class ChooseContainingGroupCreator extends CompositeCreatorWithCommand {

	/** the list to choose among and their selection */
	private Map<IGraphicalEditPart, List<IGraphicalEditPart>> elementsAndParents;

	/**
	 * Construct a new composite creator.
	 * 
	 * @param elementsParents
	 *        the element parts which are created or moved and their possible parents to choose among
	 */
	public ChooseContainingGroupCreator(Map<IGraphicalEditPart, List<IGraphicalEditPart>> elementsParents) {
		elementsAndParents = new HashMap<IGraphicalEditPart, List<IGraphicalEditPart>>(elementsParents);
	}

	/**
	 * Get the map with elements and their parents which has been used to construct this creator
	 * 
	 * @return map of elements and their parents at creator initialization time
	 */
	public Map<IGraphicalEditPart, List<IGraphicalEditPart>> getElementsAndParents() {
		return elementsAndParents;
	}

	/**
	 * 
	 * Create the composite to choose an element in the parent using the toolkit
	 * 
	 * @see org.eclipse.papyrus.ui.toolbox.notification.ICompositeCreator#createComposite(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.ui.forms.widgets.FormToolkit)
	 * @param parent
	 *        parent composite
	 * @param toolkit
	 *        toolkit to use to create widgets
	 * @return composite to choose an element
	 */
	public Composite createComposite(Composite parent, FormToolkit toolkit) {
		if(toolkit == null) {
			toolkit = new FormToolkit(parent.getDisplay());
		}
		Composite top = toolkit.createComposite(parent, SWT.NONE);
		top.setLayout(new FormLayout());

		FormText textLabel = toolkit.createFormText(top, false);
		textLabel.setText(Messages.ChooseContainingGroupCreator_Message, false, true);
		FormData data = CreatorUtils.getTopFormData();
		textLabel.setLayoutData(data);

		Control previousControl = textLabel;
		for(final Entry<IGraphicalEditPart, List<IGraphicalEditPart>> elementSelection : elementsAndParents.entrySet()) {
			String objectLabel = CreatorUtils.getLabel(elementSelection.getKey());
			FormText text = toolkit.createFormText(top, false);
			text.setText(NLS.bind(Messages.ChooseContainingGroupCreator_Contained, objectLabel), false, true);
			data = CreatorUtils.getFormDataUnder(previousControl);
			text.setLayoutData(data);
			previousControl = text;

			CCombo combo = new CCombo(top, SWT.BORDER | SWT.READ_ONLY);
			ComboViewer viewer = new ComboViewer(combo);
			viewer.setLabelProvider(new LabelProvider() {

				/**
				 * Get text for graphical edit part
				 * 
				 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
				 * 
				 * @param element
				 *        edit part
				 * @return text with element name
				 */
				@Override
				public String getText(Object element) {
					if(element instanceof IGraphicalEditPart) {
						IGraphicalEditPart parentPart = (IGraphicalEditPart)element;
						return CreatorUtils.getLabel(parentPart);
					}
					return "";
				}
			});
			viewer.add(elementSelection.getValue().toArray(new IGraphicalEditPart[elementSelection.getValue().size()]));
			EditPart initialParent = elementSelection.getKey().getParent();
			if(initialParent instanceof IGraphicalEditPart) {
				viewer.setSelection(new StructuredSelection(initialParent));
			}
			combo.pack();
			viewer.addSelectionChangedListener(new ISelectionChangedListener() {

				/**
				 * Update selected decision
				 * 
				 * @param event
				 *        selection change event
				 */
				public void selectionChanged(SelectionChangedEvent event) {
					if(!event.getSelection().isEmpty() && event.getSelection() instanceof IStructuredSelection) {
						Object newParent = ((IStructuredSelection)event.getSelection()).getFirstElement();
						if(newParent instanceof IGraphicalEditPart) {
							Command cmd = Utils.getUpdateGraphicalParentCmd(elementSelection.getKey(), (IGraphicalEditPart)newParent);
							addResultingCommandForObject(elementSelection.getKey(), cmd);
						}
					}
				}
			});
			toolkit.adapt(combo, true, true);
			data = CreatorUtils.getFormDataUnder(previousControl);
			combo.setLayoutData(data);
			previousControl = combo;
		}
		return top;
	}

	/**
	 * Get label to choose containing group
	 * 
	 * @see org.eclipse.papyrus.diagram.common.groups.core.ui.CompositeCreatorWithCommand#getRunLabel()
	 * @return string label
	 */
	@Override
	protected String getRunLabel() {
		return Messages.ChooseContainingGroupCreator_Run;
	}

	/**
	 * Remove the notification in {@link PendingGroupNotificationsManager}
	 * 
	 * @see org.eclipse.papyrus.diagram.common.groups.core.ui.CompositeCreatorWithCommand#removeNotification()
	 */
	@Override
	protected void removeNotification() {
		IGraphicalEditPart anyKey = elementsAndParents.keySet().iterator().next();
		if(anyKey != null) {
			DiagramEditPart diagram = DiagramEditPartsUtil.getDiagramEditPart(anyKey);
			PendingGroupNotificationsManager manager = PendingGroupNotificationsManager.getInstanceForDiagram(diagram);
			if(manager != null) {
				manager.removeChooseParentNotification();
			}
		}
	}
}
