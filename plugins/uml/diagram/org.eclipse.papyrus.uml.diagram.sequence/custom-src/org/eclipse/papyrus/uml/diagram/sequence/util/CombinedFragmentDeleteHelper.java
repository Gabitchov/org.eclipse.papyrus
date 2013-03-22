package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.PopupMenuCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.menus.PopupMenu;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.EditHelperContext;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionInteractionCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;

public class CombinedFragmentDeleteHelper {

	public static class EditRequest extends AbstractEditCommandRequest {

		/** element to edit */
		private Element elementToEdit;

		public EditRequest(TransactionalEditingDomain editingDomain, Element elementToEdit) {
			super(editingDomain);
			this.elementToEdit = elementToEdit;
		}

		public Object getEditHelperContext() {
			IClientContext context = getClientContext();

			if(context == null) {
				return getElementToEdit();
			} else {
				return new EditHelperContext(getElementToEdit(), context);
			}
		}

		public Element getElementToEdit() {
			return elementToEdit;
		}
	}

	public static class MoveOperandFragmentsCommand extends EditElementCommand {

		private InteractionFragment parent;

		private EList<InteractionFragment> fragmentsToMove;

		private InteractionOperand sourceOperand;

		private CombinedFragment combinedFragment;

		private CombinedFragmentEditPart host;

		public MoveOperandFragmentsCommand(CombinedFragmentEditPart host, CombinedFragment cf, InteractionOperand op, EditRequest editRequest) {
			super(null, editRequest.getElementToEdit(), editRequest);
			InteractionOperand enclosingOp = cf.getEnclosingOperand();
			if(enclosingOp != null) {
				Element owner = enclosingOp.getOwner();
				if(owner instanceof CombinedFragment) {
					this.parent = enclosingOp;
				}
			} else {
				Element owner = cf.getOwner();
				if(owner instanceof Interaction) {
					this.parent = (InteractionFragment)owner;
				}
			}
			this.host = host;
			this.sourceOperand = op;
			this.combinedFragment = cf;
			fragmentsToMove = op.getFragments();
		}

		public boolean canExecute() {
			return (sourceOperand != null && combinedFragment != null);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			if(parent != null && !fragmentsToMove.isEmpty()) {
				List<CombinedFragmentEditPart> parts = collectCombinedFragmentParts();
				if(parent instanceof InteractionOperand) {
					((InteractionOperand)parent).getFragments().addAll(fragmentsToMove);
					moveToOperandPart((InteractionOperandEditPart)host.getParent(), parts);  
				} else if(parent instanceof Interaction) {
					((Interaction)parent).getFragments().addAll(fragmentsToMove);
					moveToInteractionPart((InteractionInteractionCompartmentEditPart)host.getParent(), parts);  
				}
			}
			sourceOperand.getFragments().clear();
			return CommandResult.newOKCommandResult();
		}
		
		private void moveToOperandPart(GraphicalEditPart op, List<CombinedFragmentEditPart> keepParts) {
			if(!keepParts.isEmpty()) {
				Rectangle parentBounds = getAbsoluteBounds((AbstractGraphicalEditPart)op.getParent());
				for(CombinedFragmentEditPart cef : keepParts) {
					View view = cef.getNotationView();
					op.getNotationView().getPersistedChildren().add(view);

					Bounds bounds = (Bounds)((Shape)cef.getNotationView()).getLayoutConstraint();
					Rectangle absolute = getAbsoluteBounds(cef);
					bounds.setX(absolute.x() - parentBounds.x());
					bounds.setY(absolute.y() - parentBounds.y());
				}
			}
		}

		private void moveToInteractionPart(GraphicalEditPart op, List<CombinedFragmentEditPart> keepParts) {
			if(!keepParts.isEmpty()) {
				Rectangle b = getAbsoluteBounds(op);
				for(CombinedFragmentEditPart cef : keepParts) {
					View view = cef.getNotationView();
					op.getNotationView().getPersistedChildren().add(view);
					Bounds bounds = (Bounds)((Shape)cef.getNotationView()).getLayoutConstraint();

					Rectangle absolute = getAbsoluteBounds(cef);
					absolute.performTranslate(-b.x, -b.y);

					bounds.setX(absolute.x() - 5);
					bounds.setY(absolute.y() - 6);
				}
			}
		}

		private List<CombinedFragmentEditPart> collectCombinedFragmentParts() {
			List<CombinedFragmentEditPart> parts = new ArrayList<CombinedFragmentEditPart>();
			for(InteractionFragment f : fragmentsToMove) {
				if(f instanceof CombinedFragment) {
					EditPart p = findEditPartByModel(host, f);
					if(p instanceof CombinedFragmentEditPart)
						parts.add((CombinedFragmentEditPart)p);
				}
			}
			return parts;
		}
	}

	static public class SelectLabelProvider extends org.eclipse.jface.viewers.LabelProvider {

		public String getText(Object object) {
			return object.toString();
		}

		public Image getImage(Object object) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_ETOOL_DELETE);
		}
	}

	public static class SelectAndDeleteCommand extends PopupMenuCommand {

		private String choice;

		private CompositeTransactionalCommand deletaAllCommand;

		private CompositeTransactionalCommand keepCommand;

		private String[] labels;

		public SelectAndDeleteCommand(CompositeTransactionalCommand deletaAllCommand, CompositeTransactionalCommand keepCommand, String[] labels) {
			super("prompt for delete", Display.getCurrent().getActiveShell());
			PopupMenu popupMenu = new PopupMenu(Arrays.asList(labels), new SelectLabelProvider());
			setPopupMenu(popupMenu);
			this.labels = labels;
			this.deletaAllCommand = deletaAllCommand;
			this.keepCommand = keepCommand;
		}

		protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, org.eclipse.core.runtime.IAdaptable info) throws ExecutionException {
			CommandResult cmdResult = super.doExecuteWithResult(progressMonitor, info);
			if(!cmdResult.getStatus().isOK()) {
				return cmdResult;
			}
			this.choice = cmdResult.getReturnValue().toString();
			if(choice.contains(labels[0])) {
				deletaAllCommand.execute(progressMonitor, info);
				return deletaAllCommand.getCommandResult();
			} else {
				keepCommand.execute(progressMonitor, info);
				return keepCommand.getCommandResult();
			}
		}

		protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
			if(choice != null && choice.contains(labels[0])) {
				deletaAllCommand.undo(progressMonitor, info);
				return deletaAllCommand.getCommandResult();
			} else {
				keepCommand.undo(progressMonitor, info);
				return keepCommand.getCommandResult();
			}
		}

		protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
			if(choice.contains(labels[0])) {
				deletaAllCommand.redo(progressMonitor, info);
				return deletaAllCommand.getCommandResult();
			} else {
				keepCommand.redo(progressMonitor, info);
				return keepCommand.getCommandResult();
			}
		}
	}

	static class DeleteCombinedFragmentCommand extends AbstractTransactionalCommand {

		private IElementEditService provider;

		private DestroyElementRequest req;

		public DeleteCombinedFragmentCommand(TransactionalEditingDomain domain, IElementEditService provider, DestroyElementRequest req) {
			super(domain, null, null);
			this.provider = provider;
			this.req = req;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			ICommand deleteCommand = provider.getEditCommand(req);
			try {
				deleteCommand.execute(monitor, info);
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			return CommandResult.newOKCommandResult();
		}
	}


	public static ICommand createDestroyElementCommand(CombinedFragment cf, TransactionalEditingDomain transactionalEditingDomain, IElementEditService provider, DestroyElementRequest req, ICommand deleteCommand, CombinedFragmentEditPart host) {
		CompositeTransactionalCommand deleteAll = new CompositeTransactionalCommand(transactionalEditingDomain, null);
		deleteAll.add(deleteCommand);

		CompositeTransactionalCommand deleteCfOnly = new CompositeTransactionalCommand(transactionalEditingDomain, null);
		{
			// remove children from operands and append to parent combined fragment
			for(InteractionOperand op : cf.getOperands()) {
				deleteCfOnly.add(new MoveOperandFragmentsCommand(host, cf, op, new EditRequest(transactionalEditingDomain, cf)));
			}

			deleteCfOnly.add(new DeleteCombinedFragmentCommand(transactionalEditingDomain, provider, req));
		}
		return new SelectAndDeleteCommand(deleteAll, deleteCfOnly, new String[]{ "Delete all", "Keep contents" });
	}

	public static ICommand createDeleteViewCommand(CombinedFragment cf, TransactionalEditingDomain transactionalEditingDomain, CombinedFragmentEditPart host) {
		CompositeTransactionalCommand deleteAll = new CompositeTransactionalCommand(transactionalEditingDomain, null);
		{
			// Get the elements associated with the CF
			List<Element> elements = SequenceUtil.getCombinedFragmentAssociatedElement(cf);
			// Create the delete view commands
			SequenceDeleteHelper.deleteView(deleteAll, elements, transactionalEditingDomain);
		}

		CompositeTransactionalCommand deleteCfOnly = new CompositeTransactionalCommand(transactionalEditingDomain, null);
		{
			// remove children from operands and append to parent combined fragment
			for(InteractionOperand op : cf.getOperands()) {
				deleteCfOnly.add(new MoveOperandFragmentsCommand(host, cf, op, new EditRequest(transactionalEditingDomain, cf)));
			}

			// delete operands from combined fragment
			for(Element element : cf.getOperands()) {
				SequenceDeleteHelper.deleteView(deleteCfOnly, element, transactionalEditingDomain);
			}
		}
		return new SelectAndDeleteCommand(deleteAll, deleteCfOnly, new String[]{ "Hide all", "Keep contents" });
	}

	static Rectangle getAbsoluteBounds(AbstractGraphicalEditPart part) {
		Rectangle b = part.getFigure().getBounds().getCopy();
		part.getFigure().translateToAbsolute(b);
		return b;
	}

	public static EditPart findEditPartByModel(EditPart part, EObject m) {
		List children = part.getChildren();
		if(children != null && children.size() > 0) {
			for(Object o : children) {
				EditPart p = (EditPart)o;

				Object model = p.getModel();
				if(model != null && model instanceof View && m.equals(((View)model).getElement()))
					return p;

				EditPart res = findEditPartByModel(p, m);
				if(res != null)
					return res;
			}
		}
		return null;
	}
}
