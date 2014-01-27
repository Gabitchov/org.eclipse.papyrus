package org.eclipse.papyrus.uml.diagram.statemachine.custom.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
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
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.helpers.Zone;
import org.eclipse.papyrus.uml.diagram.statemachine.providers.ElementInitializers;
import org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * Create a region.
 * TODO: Differences with generated RegionCreateCommand ? (is the latter used?)
 */
public class CustomFirstRegionInStateMachineCreateElementCommand extends AbstractTransactionalCommand {

	IAdaptable adaptable;

	IAdaptable adaptableForDropped = null;

	PreferencesHint prefHints;

	CreateViewRequest.ViewDescriptor viewDescriptor;

	CreateElementRequest createElementRequest;

	String dropLocation = Zone.NONE;

	public CustomFirstRegionInStateMachineCreateElementCommand(IAdaptable adaptable, IAdaptable adaptableForDropped, PreferencesHint prefHints, TransactionalEditingDomain domain, String label, String dropLocation) {
		super(domain, label, null);
		this.adaptable = adaptable;
		this.adaptableForDropped = adaptableForDropped;
		this.prefHints = prefHints;

		viewDescriptor = new ViewDescriptor(adaptable, prefHints);

		// make sure the return object is available even before
		// executing/undoing/redoing
		setResult(CommandResult.newOKCommandResult(viewDescriptor));

		this.dropLocation = dropLocation;
	}

	@Override
	public boolean canExecute() {
		if (true) return true;
		View compartment = (View)adaptable.getAdapter(View.class);
		if(compartment.getChildren().isEmpty()) {
			View owner = (View)compartment.eContainer();
			return true;
			/*
			State state = (State)owner.getElement();
			if(state.getSubmachine() == null)
				return true;
			return false;
			*/
		}
		// CHECK THIS		
		//		else{
		//			ENamedElement namedElement =  PackageUtil.getElement("notation.View.visible");
		//			if(ViewUtil.getStructuralFeatureValue(compartment, (EStructuralFeature)namedElement).equals(new Boolean(false))){
		//				SetPropertyCommand showCompartment = new SetPropertyCommand(getEditingDomain(), adaptable, "notation.View.visible", "Visibility", true);
		//				showCompartment.setOptions(Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE));
		//
		//				try {
		//					showCompartment.execute(null, null);
		//				} catch (ExecutionException e) {
		//				}				
		//
		//			}
		//			return false;
		//		}
		return true;
	}

	protected void doConfigure(Region newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
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
		View ownerView = (View)adaptable.getAdapter(View.class);
		Node compartment = (Node)ownerView.getChildren().get(1);
		
		// get state bounds
		int height = Zone.getHeight(ownerView);
		int width = Zone.getWidth(ownerView);
		if(height < Zone.defaultHeight) {
			height = Zone.defaultHeight;
			Zone.setHeight(ownerView, height);
		}
		if(width < Zone.defaultWidth) {
			width = Zone.defaultWidth;
			Zone.setWidth(ownerView, width);
		}

		if(adaptableForDropped == null) {
			Region umlRegion = UMLFactory.eINSTANCE.createRegion();

			createElementRequest = new CreateElementRequest(getEditingDomain(), ownerView, UMLElementTypes.Region_3000);

			StateMachine umlState = (StateMachine)ownerView.getElement();
			umlState.getRegions().add(umlRegion);

			ElementInitializers.getInstance().init_Region_3000(umlRegion);

			doConfigure(umlRegion, monitor, info);

			adaptableForDropped = new SemanticAdapter(umlRegion, null);
		}

		// create a view for the new region on the stateMachineCompartment
		String semanticHint = ((IHintedType)UMLElementTypes.Region_3000).getSemanticHint();
		Node newRegion = (Node)ViewService.getInstance().createNode(adaptableForDropped, compartment, semanticHint, -1, prefHints);

		// add region specific annotation
		Zone.createRegionDefaultAnnotation(newRegion);

		// adjust bounds and zone
		LayoutConstraint lc = compartment.getLayoutConstraint();
		if(lc instanceof Bounds) {
			Bounds bounds = (Bounds) lc;
			Zone.setWidth(newRegion, bounds.getWidth());
			Zone.setHeight(newRegion, bounds.getHeight());
		}

		viewDescriptor.setView(newRegion);

		return CommandResult.newOKCommandResult(viewDescriptor);
	}
}
