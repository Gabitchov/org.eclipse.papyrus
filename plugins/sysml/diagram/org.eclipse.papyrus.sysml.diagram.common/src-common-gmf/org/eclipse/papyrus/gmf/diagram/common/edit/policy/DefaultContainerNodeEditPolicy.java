package org.eclipse.papyrus.gmf.diagram.common.edit.policy;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionEndsCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ContainerNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.commands.CreateViewCommand;

/**
 * Default container node edit policy replacement used to replace {@link CreateCommand} by {@link CreateViewCommand},
 * different implementation of the canExecute() method.
 * See https://bugs.eclipse.org/bugs/show_bug.cgi?id=346739.
 */
public class DefaultContainerNodeEditPolicy extends ContainerNodeEditPolicy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		if (!(request instanceof CreateConnectionViewRequest))
			return null;
		CreateConnectionViewRequest req = (CreateConnectionViewRequest) request;
		CompositeCommand cc = new CompositeCommand(
			DiagramUIMessages.Commands_CreateCommand_Connection_Label);
		Diagram diagramView = ((View)getHost().getModel())
				.getDiagram();
        
		// TransactionalEditingDomain editingDomain = getEditingDomain();
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
        CreateCommand createCommand = new CreateViewCommand(editingDomain, req
				.getConnectionViewDescriptor(), diagramView.getDiagram());
        //
		setViewAdapter((IAdaptable) createCommand.getCommandResult()
				.getReturnValue());
        
        
        SetConnectionEndsCommand sceCommand = new SetConnectionEndsCommand(editingDomain, StringStatics.BLANK);
		sceCommand.setEdgeAdaptor(getViewAdapter());
		sceCommand.setNewSourceAdaptor(new EObjectAdapter(getView()));
		ConnectionAnchor sourceAnchor = getConnectableEditPart()
				.getSourceConnectionAnchor(request);
		SetConnectionAnchorsCommand scaCommand = new SetConnectionAnchorsCommand(editingDomain, StringStatics.BLANK);
		scaCommand.setEdgeAdaptor(getViewAdapter());
		scaCommand.setNewSourceTerminal(getConnectableEditPart()
				.mapConnectionAnchorToTerminal(sourceAnchor));
		SetConnectionBendpointsCommand sbbCommand = new SetConnectionBendpointsCommand(editingDomain);
		sbbCommand.setEdgeAdapter(getViewAdapter());
		cc.compose(createCommand);
		cc.compose(sceCommand);
		cc.compose(scaCommand);
		cc.compose(sbbCommand);
		Command c = new ICommandProxy(cc);
		request.setStartCommand(c);
		return c;
	}
}
