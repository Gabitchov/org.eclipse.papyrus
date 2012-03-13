package org.eclipse.papyrus.diagram.statemachine.custom.listeners;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.DestroyElementPapyrusCommand;
import org.eclipse.papyrus.diagram.common.listeners.AbstractPapyrusModifcationTriggerListener;
import org.eclipse.papyrus.diagram.common.util.predicates.ViewTypePredicate;
import org.eclipse.papyrus.diagram.statemachine.custom.commands.CreateViewCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateEditPart;
import org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.uml2.uml.State;

public abstract class AbstractStateListener extends AbstractPapyrusModifcationTriggerListener {

	public AbstractStateListener() {
		super();
	}

	protected abstract String getFactoryHint(EStructuralFeature feature);

	protected abstract int getCompartmentID();

	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		EObject selectedEObject = req.getElementToDestroy();
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(selectedEObject);
		if(provider != null) {
			// Retrieve delete command from the Element Edit service
			ICommand deleteCommand = provider.getEditCommand(req);
			if(deleteCommand != null) {
				return new ICommandProxy(deleteCommand);
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Get the necessary destroy command which will be compose to cc
	 * @param oldObject
	 * @param cc
	 */
	protected void getDestroyCommand(Object oldObject, CompositeCommand cc) {
		if(oldObject instanceof EObject) {
			//destroy element
			EObject oldEObject = (EObject)oldObject;
			Iterable<View> referencingView = getReferencingView(oldEObject);
			for(View v : referencingView) {
				DestroyElementRequest req = new DestroyElementRequest(v, false);
				DestroyElementPapyrusCommand destroyReferencingViewCommand = new DestroyElementPapyrusCommand(req);
				if(destroyReferencingViewCommand != null && destroyReferencingViewCommand.canExecute()) {
					cc.compose(destroyReferencingViewCommand);
				}
			}
		}
	}

	/**
	 * Compose to cc the commands needed to create all necessary views
	 * @param notif {@link Notification}
	 * @param object New value of the {@link Notification}
	 * @param cc {@link CompositeCommand} resulting
	 */
	protected void getCreationCommand(Notification notif, Object object, CompositeCommand cc) {
		if(object instanceof EObject) {
			EObject newEObject = (EObject)object;
			Object notifier = notif.getNotifier();
			if(notifier instanceof State) {
				State state = (State)notifier;
				Iterable<View> referencingViews = getReferencingView(state, new ViewTypePredicate(UMLVisualIDRegistry.getType(StateEditPart.VISUAL_ID)));
				for(View containerView : referencingViews) {
					ViewDescriptor descriptor = new ViewDescriptor(new EObjectAdapter(newEObject), Node.class, getFactoryHint((EStructuralFeature)notif.getFeature()), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
					EditingDomain editinDomain = AdapterFactoryEditingDomain.getEditingDomainFor(newEObject);
					if(editinDomain instanceof TransactionalEditingDomain) {
						CreateViewCommand createViewCommand = new CreateViewCommand((TransactionalEditingDomain)editinDomain, descriptor, ViewUtil.getChildBySemanticHint(containerView, UMLVisualIDRegistry.getType(getCompartmentID())));
						if(createViewCommand != null && createViewCommand.canExecute()) {
							cc.compose(createViewCommand);
						}
					}
				}
			}
		}
	}

}
