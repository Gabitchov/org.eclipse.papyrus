package org.eclipse.papyrus.diagram.clazz.custom.policies;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.diagram.clazz.edit.parts.GeneralizationSetEditPart;

public class GeneralizationSetLabelDisplayEditPolicy extends AbstractEditPolicy implements NotificationListener, IPapyrusListener {

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void activate() {
		getDiagramEventBroker().addNotificationListener(((EObject) getHost().getModel()), this);
		getDiagramEventBroker().addNotificationListener(((View) getHost().getModel()).getElement(), this);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void deactivate() {
		getDiagramEventBroker().removeNotificationListener(((EObject) getHost().getModel()), this);
		getDiagramEventBroker().removeNotificationListener(((View) getHost().getModel()).getElement(), this);
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
				List<EditPart> editpartList = ((DiagramGraphicalViewer) (getHost().getViewer())).findEditPartsForElement(elementID, GeneralizationSetEditPart.class);
				if (editpartList.size() > 1) {
					for (int i = 0; i < getHost().getChildren().size(); i++) {
						((View) ((EditPart) getHost().getChildren().get(i)).getModel()).setVisible(false);
					}
				}
			}
		}
	}

}
