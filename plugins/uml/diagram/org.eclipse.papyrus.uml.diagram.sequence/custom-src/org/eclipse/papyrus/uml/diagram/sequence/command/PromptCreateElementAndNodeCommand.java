package org.eclipse.papyrus.uml.diagram.sequence.command;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateOrSelectElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.menus.PopupMenu;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.Messages;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.uml2.uml.InteractionFragment;

public class PromptCreateElementAndNodeCommand extends CreateOrSelectElementCommand {

	private static final List<IElementType> executionTypes = new ArrayList<IElementType>();
	static {
		executionTypes.add(UMLElementTypes.ActionExecutionSpecification_3006);
		executionTypes.add(UMLElementTypes.BehaviorExecutionSpecification_3003);
	}

	private final CompoundCommand command;

	private TransactionalEditingDomain editingDomain;

	private ConnectionViewDescriptor descriptor;

	private ShapeNodeEditPart targetEP;

	private EObject target;

	private Point location;

	private InteractionFragment container;

	private CreateConnectionRequest request;

	private EditPart sourceEP;

	public PromptCreateElementAndNodeCommand(Command createCommand, TransactionalEditingDomain editingDomain, ConnectionViewDescriptor descriptor, ShapeNodeEditPart targetEP, EObject target, EditPart sourceEP, CreateConnectionRequest request, InteractionFragment container) {
		super(Display.getCurrent().getActiveShell(), executionTypes);
		this.editingDomain = editingDomain;
		this.descriptor = descriptor;
		this.targetEP = targetEP;
		this.target = target;
		this.sourceEP = sourceEP;
		this.request = request;
		this.location = request.getLocation();
		this.container = container;
		command = new CompoundCommand();
		command.add(createCommand);

		//Repair the location of Popup menu.
		setPopupMenu(new PopupMenu(executionTypes, getLabelProvider()) {

			@Override
			public boolean show(Control parent) {
				Menu menu = new Menu(parent);
				createMenuItems(menu, this, new ArrayList());

				menu.setVisible(true);
				org.eclipse.swt.graphics.Point loc = getMenuLocation();
				if(loc != null) {
					menu.setLocation(loc);
				}
				Display display = menu.getDisplay();
				while(!menu.isDisposed() && menu.isVisible()) {
					if(!display.readAndDispatch())
						display.sleep();
				}

				if(!menu.isDisposed()) {
					menu.dispose();

					if(getResult() != null) {
						return true;
					}
				}
				return false;
			}
		});
	}

	protected org.eclipse.swt.graphics.Point getMenuLocation() {
		if(location == null || sourceEP == null || sourceEP.getViewer() == null) {
			return null;
		}
		Control control = sourceEP.getViewer().getControl();
		org.eclipse.swt.graphics.Point menuLoc = new org.eclipse.swt.graphics.Point(location.x, location.y);
		return control.toDisplay(menuLoc);
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		sourceEP.eraseSourceFeedback(request);
		targetEP.eraseSourceFeedback(request);
		CommandResult cmdResult = super.doExecuteWithResult(progressMonitor, info);
		if(!cmdResult.getStatus().isOK()) {
			return cmdResult;
		}
		Object returnValue = cmdResult.getReturnValue();
		if(!(returnValue instanceof IHintedType)) {
			return cmdResult;
		}
		IHintedType connectionType = (IHintedType)returnValue;
		CreateElementAndNodeCommand createExecutionSpecificationCommand = new CreateElementAndNodeCommand(editingDomain, (ShapeNodeEditPart)targetEP, target, connectionType, location);
		createExecutionSpecificationCommand.putCreateElementRequestParameter(SequenceRequestConstant.INTERACTIONFRAGMENT_CONTAINER, container);
		command.add(new ICommandProxy(createExecutionSpecificationCommand));
		// put the anchor at the top of the figure
		ChangeEdgeTargetCommand changeTargetCommand = new ChangeEdgeTargetCommand(editingDomain, createExecutionSpecificationCommand, descriptor, "(1.0, 0.0)");
		command.add(new ICommandProxy(changeTargetCommand));
		command.execute();
		return CommandResult.newOKCommandResult(descriptor);
	}

	public boolean canUndo() {
		return command != null && command.canUndo();
	}

	protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		if(command != null) {
			command.redo();
		}
		return super.doRedoWithResult(progressMonitor, info);
	}

	protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		if(command != null) {
			command.undo();
		}
		return super.doUndoWithResult(progressMonitor, info);
	}

	protected ILabelProvider getLabelProvider() {
		return new LabelProvider() {

			@Override
			public String getText(Object object) {
				if(object instanceof IHintedType) {
					IHintedType elementType = (IHintedType)object;
					switch(UMLVisualIDRegistry.getVisualID(elementType.getSemanticHint())) {
					case ActionExecutionSpecificationEditPart.VISUAL_ID:
						return Messages.createActionExecutionSpecification2CreationTool_title;
					case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
						return Messages.createBehaviorExecutionSpecification3CreationTool_title;
					}
				}
				return super.getText(object);
			}
		};
	}
}
