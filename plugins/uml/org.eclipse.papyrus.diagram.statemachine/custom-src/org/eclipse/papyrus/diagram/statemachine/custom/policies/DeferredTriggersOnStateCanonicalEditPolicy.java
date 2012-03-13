package org.eclipse.papyrus.diagram.statemachine.custom.policies;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateDeferredTriggerEditPart;
import org.eclipse.papyrus.diagram.statemachine.part.UMLNodeDescriptor;
import org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLSwitch;


public class DeferredTriggersOnStateCanonicalEditPolicy extends CanonicalEditPolicy {

	@Override
	protected List getSemanticChildrenList() {
		View viewObject = (View)getHost().getModel();
		LinkedList<EObject> result = new LinkedList<EObject>();
		List<UMLNodeDescriptor> childDescriptors = org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramUpdater.getState_6000SemanticChildren(viewObject);
		for(UMLNodeDescriptor d : childDescriptors) {
			result.add(d.getModelElement());
		}
		return result;
	}



	@Override
	protected EStructuralFeature getFeatureToSynchronize() {
		return UMLPackage.Literals.STATE__DEFERRABLE_TRIGGER;
	}




	public static List<UMLNodeDescriptor> getState_LabelSemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		State modelElement = (State)view.getElement();
		LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
//		{
//			Behavior childElement = modelElement.getEntry();
//			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
//			if(visualID == EntryStateBehaviorEditPart.VISUAL_ID) {
//				result.add(new UMLNodeDescriptor(childElement, visualID));
//			}
//		}
//		{
//			Behavior childElement = modelElement.getDoActivity();
//			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
//			if(visualID == DoActivityStateBehaviorStateEditPart.VISUAL_ID) {
//				result.add(new UMLNodeDescriptor(childElement, visualID));
//			}
//		}
//		{
//			Behavior childElement = modelElement.getExit();
//			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
//			if(visualID == ExitStateBehaviorEditPart.VISUAL_ID) {
//				result.add(new UMLNodeDescriptor(childElement, visualID));
//			}
//		}
//		for(Iterator<?> it = modelElement.getIncomings().iterator(); it.hasNext();) {
//			Transition childElement = (Transition)it.next();
//			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
//			if(visualID == InternalTransitionEditPart.VISUAL_ID) {
//				result.add(new UMLNodeDescriptor(childElement, visualID));
//				continue;
//			}
//		}
		for(Iterator<?> it = modelElement.getDeferrableTriggers().iterator(); it.hasNext();) {
			Trigger childElement = (Trigger)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == StateDeferredTriggerEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}
	
	/**
	 * Convenience method to create a view descriptor.  Will call
	 * {@link #getViewDescriptor(IAdaptable, Class, String, int)}
	 * @param element semantic element.
	 * @return view descriptor
	 */
	@Override
	protected CreateViewRequest.ViewDescriptor getViewDescriptor( EObject element ) {
		//
		// create the view descriptor
		String factoryHint = getDefaultFactoryHint();
		IAdaptable elementAdapter =
			new CanonicalElementAdapter(element, factoryHint);
		
		int pos = getViewIndexFor(element);
		CreateViewRequest.ViewDescriptor descriptor = 
			getViewDescriptor(
				elementAdapter,
				Node.class,
				getFactoryHint(elementAdapter, factoryHint),
				pos);
		return descriptor;
	}





	@Override
	protected String getFactoryHint(IAdaptable elementAdapter) {
		Object eObject = elementAdapter.getAdapter(EObject.class);
		
		if (eObject instanceof EObject){
			return getVisualHintSwitch().doSwitch((EObject) eObject);
		}
		return super.getFactoryHint(elementAdapter);
	}
	
	private static LabelChildSemanticHintSwitch visaulIDSwitch = null;
	
	protected LabelChildSemanticHintSwitch getVisualHintSwitch(){
		if(visaulIDSwitch == null){
			visaulIDSwitch = new LabelChildSemanticHintSwitch();
		}
		return visaulIDSwitch;
	}
	
	private class LabelChildSemanticHintSwitch extends UMLSwitch<String>{

		@Override
		public String caseTrigger(Trigger object) {	
			return UMLVisualIDRegistry.getType(StateDeferredTriggerEditPart.VISUAL_ID);
		}

		@Override
		public String defaultCase(EObject object) {
			return getDefaultFactoryHint();
		}
		
	}
	
	
}
