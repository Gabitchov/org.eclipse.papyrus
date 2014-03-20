/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.clazz.custom.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.GeneralizationSetEditPart;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.swt.widgets.Display;

/**
 * this policy allows displaying generalizationSet without label if it references the same semantic
 * element. It allows placing correctly anchors in this case
 */
public class GeneralizationSetLabelDisplayEditPolicy extends AbstractEditPolicy implements NotificationListener, IPapyrusListener {

	/** stores the host associated semantic element */
	protected EObject hostSemanticElement;

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void activate() {
		View view = (View) getHost().getModel();
		hostSemanticElement = view.getElement();
		getDiagramEventBroker().addNotificationListener(view, this);
		getDiagramEventBroker().addNotificationListener(hostSemanticElement, this);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void deactivate() {
		View view = (View) getHost().getModel();
		getDiagramEventBroker().removeNotificationListener(view, this);
		getDiagramEventBroker().removeNotificationListener(hostSemanticElement, this);
		// removes the reference to the semantic element
		hostSemanticElement = null;
	}

	/**
	 * 
	 * @param editPart
	 * @return
	 */
	public Collection<GeneralizationSetEditPart> getAllSameSemanticGeneralizationSet(GeneralizationEditPart editPart) {
		// look for all Generalization set connected to the source location that reference the same
		// generalizationSet
		List<GeneralizationSetEditPart> result = new ArrayList<GeneralizationSetEditPart>();
		List<Object> linkList = new ArrayList<Object>();
		for (Object object : editPart.getSourceConnections()) {
			linkList.add(object);
		}
		for (Object object : editPart.getTargetConnections()) {
			linkList.add(object);
		}
		// remove reconnected link
		linkList.remove(getHost());
		// get the link that refer the same model element

		Iterator<Object> iterator = linkList.iterator();
		while (iterator.hasNext()) {
			Object currentObject = iterator.next();
			if (currentObject instanceof GeneralizationSetEditPart) {
				if (((GeneralizationSetEditPart) getHost()).resolveSemanticElement().equals(((GeneralizationSetEditPart) currentObject).resolveSemanticElement())) {
					result.add((GeneralizationSetEditPart) currentObject);
				}
			}
		}
		return result;
	}

	/**
	 * Gets the diagram event broker from the editing domain.
	 * 
	 * @return the diagram event broker
	 */
	private DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		if (theEditingDomain != null) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
	}

	/**
	 * 
	 * {@inheritedDoc}
	 */
	public void notifyChanged(Notification notification) {
		if (getHost().getViewer() instanceof DiagramGraphicalViewer) {
			if (getHost() instanceof GeneralizationSetEditPart) {
				String elementID = EMFCoreUtil.getProxyID(((GeneralizationSetEditPart) getHost()).resolveSemanticElement());
				List<EditPart> editpartList = new ArrayList<EditPart>();
				for (Object object : ((DiagramGraphicalViewer) (getHost().getViewer())).findEditPartsForElement(elementID, GeneralizationSetEditPart.class)) {
					editpartList.add((EditPart) object);
				}

				if (editpartList.size() > 1 && editpartList.indexOf(getHost()) > 0) {
					try {
						((IGraphicalEditPart) getHost()).getEditingDomain().runExclusive(new Runnable() {

							public void run() {
								Display.getCurrent().asyncExec(new Runnable() {

									public void run() {
										for (int i = 0; i < getHost().getChildren().size(); i++) {
											SetRequest setRequest = new SetRequest((View) ((EditPart) getHost().getChildren().get(i)).getModel(), NotationPackage.eINSTANCE.getView_Visible(), false);
											SetValueCommand setValueCommand = new SetValueCommand(setRequest);
											((IGraphicalEditPart) getHost()).getDiagramEditDomain().getDiagramCommandStack().execute(new ICommandProxy(setValueCommand));
											// refresh();
										}
									}
								});
							}
						});
					} catch (Exception e) {
						Activator.log.error(e);
					}
				}
			}
		}
		if (notification.getNotifier() instanceof RelativeBendpoints) {
			try {
				((IGraphicalEditPart) getHost()).getEditingDomain().runExclusive(new Runnable() {

					public void run() {
						Display.getCurrent().asyncExec(new Runnable() {

							public void run() {
								if (getAllSameSemanticGeneralizationSet(((GeneralizationEditPart) ((GeneralizationSetEditPart) getHost()).getTarget())).size() != 0) {
									ReconnectRequest reconnectRequest = new ReconnectRequest();
									reconnectRequest.setType(GraphicalNodeEditPolicy.REQ_RECONNECT_TARGET);
									reconnectRequest.setConnectionEditPart(((GeneralizationSetEditPart) getHost()));
									reconnectRequest.setTargetEditPart(((GeneralizationSetEditPart) getHost()).getTarget());
									Command command = ((GeneralizationSetEditPart) getHost()).getTarget().getCommand(reconnectRequest);
									((GeneralizationSetEditPart) getHost()).getDiagramEditDomain().getDiagramCommandStack().execute(command);
								}
								if (getAllSameSemanticGeneralizationSet(((GeneralizationEditPart) ((GeneralizationSetEditPart) getHost()).getSource())).size() != 0) {
									ReconnectRequest reconnectRequest = new ReconnectRequest();
									reconnectRequest.setType(GraphicalNodeEditPolicy.REQ_RECONNECT_SOURCE);
									reconnectRequest.setConnectionEditPart(((GeneralizationSetEditPart) getHost()));
									reconnectRequest.setTargetEditPart(((GeneralizationSetEditPart) getHost()).getSource());
									Command command = ((GeneralizationSetEditPart) getHost()).getSource().getCommand(reconnectRequest);
									((GeneralizationSetEditPart) getHost()).getDiagramEditDomain().getDiagramCommandStack().execute(command);
								}
							}
						});
					}
				});
			} catch (Exception e) {
				Activator.log.error(e);
			}
		}
	}
}
