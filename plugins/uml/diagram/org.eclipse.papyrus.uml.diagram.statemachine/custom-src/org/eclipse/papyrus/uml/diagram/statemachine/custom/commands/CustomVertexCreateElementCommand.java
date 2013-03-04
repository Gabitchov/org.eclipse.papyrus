package org.eclipse.papyrus.uml.diagram.statemachine.custom.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.statemachine.providers.ElementInitializers;
import org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.Vertex;

/**
 * Create a vertex (sub-state), used only in composition with region creation
 * in CustomStateCreationEditPolicy
 * TODO: create a more cleaner combination of region creation and state creation that behaves exactly like the state
 * creation. Current differences: there's no pop-up for editing its name, (2) positioning is always top-left.
 * => use unchanged StateCreateCommand instead
 */
@Deprecated
public class CustomVertexCreateElementCommand extends AbstractTransactionalCommand {

	IAdaptable adaptable;

	PreferencesHint prefHints;

	IHintedType hint;

	CreateViewRequest.ViewDescriptor viewDescriptor;

	CreateElementRequest createElementRequest;

	public CustomVertexCreateElementCommand(IAdaptable adaptable, IHintedType hint, PreferencesHint prefHints, TransactionalEditingDomain domain, String label) {
		super(domain, label, null);
		this.adaptable = adaptable;
		this.hint = hint;
		this.prefHints = prefHints;

		viewDescriptor = new ViewDescriptor(adaptable, prefHints);

		// make sure the return object is available even before
		// executing/undoing/redoing
		setResult(CommandResult.newOKCommandResult(viewDescriptor));

	}

	protected void doConfigure(Vertex newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IElementType elementType = createElementRequest.getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(createElementRequest.getClientContext());
		configureRequest.addParameters(createElementRequest.getParameters());
		ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if(configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// adapt the view at execution time
		View regionView = (View)adaptable.getAdapter(View.class);
		View compartment = (View)regionView.getChildren().get(0);
		// hack
		viewDescriptor = new ViewDescriptor(new SemanticAdapter(null, (EObject)adaptable.getAdapter(EObject.class)), prefHints);

		Region owner = (Region)regionView.getElement();
		Vertex newVertex = null;
		if(hint.getSemanticHint().equals(((IHintedType)UMLElementTypes.FinalState_5000).getSemanticHint())) {
			newVertex = UMLFactory.eINSTANCE.createFinalState();
			owner.getSubvertices().add(newVertex);
			ElementInitializers.getInstance().init_FinalState_5000((FinalState)newVertex);
			createElementRequest = new CreateElementRequest(getEditingDomain(), regionView, UMLElementTypes.FinalState_5000);
		} else if(hint.getSemanticHint().equals(((IHintedType)UMLElementTypes.State_6000).getSemanticHint())) {
			newVertex = UMLFactory.eINSTANCE.createState();
			owner.getSubvertices().add(newVertex);
			ElementInitializers.getInstance().init_State_6000((State)newVertex);
			createElementRequest = new CreateElementRequest(getEditingDomain(), regionView, UMLElementTypes.State_6000);
		} else {
			newVertex = UMLFactory.eINSTANCE.createPseudostate();
			if(hint.getSemanticHint().equals(((IHintedType)UMLElementTypes.Pseudostate_8000).getSemanticHint())) {
				owner.getSubvertices().add(newVertex);
				ElementInitializers.getInstance().init_Pseudostate_8000((Pseudostate)newVertex);
				createElementRequest = new CreateElementRequest(getEditingDomain(), regionView, UMLElementTypes.Pseudostate_8000);
			} else if(hint.getSemanticHint().equals(((IHintedType)UMLElementTypes.Pseudostate_9000).getSemanticHint())) {
				owner.getSubvertices().add(newVertex);
				ElementInitializers.getInstance().init_Pseudostate_9000((Pseudostate)newVertex);
				createElementRequest = new CreateElementRequest(getEditingDomain(), regionView, UMLElementTypes.Pseudostate_9000);
			} else if(hint.getSemanticHint().equals(((IHintedType)UMLElementTypes.Pseudostate_10000).getSemanticHint())) {
				owner.getSubvertices().add(newVertex);
				ElementInitializers.getInstance().init_Pseudostate_10000((Pseudostate)newVertex);
				createElementRequest = new CreateElementRequest(getEditingDomain(), regionView, UMLElementTypes.Pseudostate_10000);
			} else if(hint.getSemanticHint().equals(((IHintedType)UMLElementTypes.Pseudostate_11000).getSemanticHint())) {
				owner.getSubvertices().add(newVertex);
				ElementInitializers.getInstance().init_Pseudostate_11000((Pseudostate)newVertex);
				createElementRequest = new CreateElementRequest(getEditingDomain(), regionView, UMLElementTypes.Pseudostate_11000);
			} else if(hint.getSemanticHint().equals(((IHintedType)UMLElementTypes.Pseudostate_12000).getSemanticHint())) {
				owner.getSubvertices().add(newVertex);
				ElementInitializers.getInstance().init_Pseudostate_12000((Pseudostate)newVertex);
				createElementRequest = new CreateElementRequest(getEditingDomain(), regionView, UMLElementTypes.Pseudostate_12000);
			} else if(hint.getSemanticHint().equals(((IHintedType)UMLElementTypes.Pseudostate_13000).getSemanticHint())) {
				owner.getSubvertices().add(newVertex);
				ElementInitializers.getInstance().init_Pseudostate_13000((Pseudostate)newVertex);
				createElementRequest = new CreateElementRequest(getEditingDomain(), regionView, UMLElementTypes.Pseudostate_13000);
			} else if(hint.getSemanticHint().equals(((IHintedType)UMLElementTypes.Pseudostate_14000).getSemanticHint())) {
				owner.getSubvertices().add(newVertex);
				ElementInitializers.getInstance().init_Pseudostate_14000((Pseudostate)newVertex);
				createElementRequest = new CreateElementRequest(getEditingDomain(), regionView, UMLElementTypes.Pseudostate_14000);
			} else if(hint.getSemanticHint().equals(((IHintedType)UMLElementTypes.Pseudostate_15000).getSemanticHint())) {
				owner.getSubvertices().add(newVertex);
				ElementInitializers.getInstance().init_Pseudostate_15000((Pseudostate)newVertex);
				createElementRequest = new CreateElementRequest(getEditingDomain(), regionView, UMLElementTypes.Pseudostate_15000);
			} else if(hint.getSemanticHint().equals(((IHintedType)UMLElementTypes.Pseudostate_16000).getSemanticHint())) {
				((State)owner.eContainer()).getConnectionPoints().add((Pseudostate)newVertex);
				ElementInitializers.getInstance().init_Pseudostate_16000((Pseudostate)newVertex);
				createElementRequest = new CreateElementRequest(getEditingDomain(), regionView, UMLElementTypes.Pseudostate_16000);
			} else if(hint.getSemanticHint().equals(((IHintedType)UMLElementTypes.Pseudostate_17000).getSemanticHint())) {
				((State)owner.eContainer()).getConnectionPoints().add((Pseudostate)newVertex);
				ElementInitializers.getInstance().init_Pseudostate_17000((Pseudostate)newVertex);
				createElementRequest = new CreateElementRequest(getEditingDomain(), regionView, UMLElementTypes.Pseudostate_17000);
			}
		}

		doConfigure(newVertex, monitor, info);

		// create a view for the new vertex on the regionCompartment
		IAdaptable newVertexAdapatable = new SemanticAdapter(newVertex, null);

		// see below
		// View newVertexView;

		if(hint.getSemanticHint().equals(((IHintedType)UMLElementTypes.Pseudostate_16000).getSemanticHint()) || hint.getSemanticHint().equals(((IHintedType)UMLElementTypes.Pseudostate_17000).getSemanticHint())) {
			// newVertexView =
			ViewService.getInstance().createNode(newVertexAdapatable, (View)regionView.eContainer().eContainer(), hint.getSemanticHint(), -1, prefHints);
		} else {
			// newVertexView =
			ViewService.getInstance().createNode(newVertexAdapatable, compartment, hint.getSemanticHint(), -1, prefHints);

		}
		// removed viewDescriptor.setView: problematic since region can be moved along with state immediately after creation along with state
		// can cause bug 397730
		// viewDescriptor.setView(newVertexView);

		return CommandResult.newOKCommandResult(viewDescriptor);
	}

}
