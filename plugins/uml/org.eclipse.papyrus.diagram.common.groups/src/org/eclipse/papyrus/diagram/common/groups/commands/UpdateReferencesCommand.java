package org.eclipse.papyrus.diagram.common.groups.commands;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.diagram.common.groups.core.utils.Utils;
import org.eclipse.papyrus.diagram.common.groups.groupcontainment.AbstractContainerNodeDescriptor;


public class UpdateReferencesCommand extends AbstractTransactionalCommand {

	private List<IGraphicalEditPart> childrenPart;

	private AbstractContainerNodeDescriptor descriptor;

	private CreateElementRequestAdapter elementAdapter;

	public UpdateReferencesCommand(TransactionalEditingDomain domain, String label, List<IGraphicalEditPart> children, AbstractContainerNodeDescriptor descriptor, CreateElementRequestAdapter adapter) {
		super(domain, label, null);
		this.descriptor = descriptor;
		elementAdapter = adapter;
		this.childrenPart = children;


	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {
		Object createdElement = elementAdapter.getAdapter(EObject.class);
		if(createdElement instanceof EObject) {
			EObject eObjectCreatedElement = (EObject)createdElement;
			for(IGraphicalEditPart part : childrenPart) {
				EObject childElement = part.resolveSemanticElement();
				List<EReference> refs = descriptor.getReferenceFor(childElement.eClass());
				for(EReference ref : refs) {
					//Add reference to the father
					if(ref != null && ref.isMany()) {
						//ref.getEOpposite()
						Collection<EObject> collection = (Collection<EObject>)eObjectCreatedElement.eGet(ref);
						if(!collection.contains(childElement)) {
							collection.add(childElement);
						}
						//Remove all element which have a model sons in the collection
					} else if(ref != null && !ref.isMany()) {
						eObjectCreatedElement.eSet(ref, childElement);
					}
				}
				Utils.withDrawRedundantElementReferenced(childElement);
			}
		}

		return CommandResult.newOKCommandResult();
	}


}
