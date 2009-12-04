package org.eclipse.papyrus.diagram.statemachine.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.util.BasicEcoreSwitch;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ConnectionPointReference2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ConnectionPointReferenceEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ElementOwnedCommentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.FinalStateEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate10EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate11EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate12EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate13EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate14EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate3EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate4EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate5EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate6EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate7EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate8EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Pseudostate9EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.Region2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionSubvertices2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionSubverticesEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.State2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.State3EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.State4EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachine2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionEditPart;
import org.eclipse.papyrus.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConnectionPointReference;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.uml2.uml.util.UMLSwitch;

/**
 * @generated
 */
@SuppressWarnings("unchecked")
public class UMLDiagramUpdater {

	/**
	 * @generated
	 */
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null
				|| view.getElement().eIsProxy();
	}

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case StateMachine2EditPart.VISUAL_ID:
			return getStateMachine_1001SemanticChildren(view);
		case State2EditPart.VISUAL_ID:
			return getState_2003SemanticChildren(view);
		case State3EditPart.VISUAL_ID:
			return getState_2005SemanticChildren(view);
		case State4EditPart.VISUAL_ID:
			return getState_2017SemanticChildren(view);
		case RegionSubverticesEditPart.VISUAL_ID:
			return getRegionSubvertices_5001SemanticChildren(view);
		case RegionSubvertices2EditPart.VISUAL_ID:
			return getRegionSubvertices_5002SemanticChildren(view);
		case StateMachineEditPart.VISUAL_ID:
			return getPackage_79SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated NOT
	 * 
	 *            Modified to handle a StateMachine as canvas element.
	 */
	public static List getStateMachine_1001SemanticChildren(View view) {
		if(view.getElement() instanceof StateMachine == false) {
			return Collections.EMPTY_LIST;
		}
		StateMachine modelElement = (StateMachine)view.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getRegions().iterator(); it.hasNext();) {
			Region childElement = (Region)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if(visualID == RegionEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getConnectionPoints().iterator(); it
				.hasNext();) {
			Pseudostate childElement = (Pseudostate)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if(visualID == Pseudostate13EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == Pseudostate14EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_2003SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		State modelElement = (State)view.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getRegions().iterator(); it.hasNext();) {
			Region childElement = (Region)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if(visualID == Region2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getConnectionPoints().iterator(); it
				.hasNext();) {
			Pseudostate childElement = (Pseudostate)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if(visualID == Pseudostate11EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == Pseudostate12EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_2005SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		State modelElement = (State)view.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getConnections().iterator(); it
				.hasNext();) {
			ConnectionPointReference childElement = (ConnectionPointReference)it
					.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if(visualID == ConnectionPointReferenceEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConnectionPointReference2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_2017SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		State modelElement = (State)view.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getConnectionPoints().iterator(); it
				.hasNext();) {
			Pseudostate childElement = (Pseudostate)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if(visualID == Pseudostate9EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == Pseudostate10EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRegionSubvertices_5001SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Region modelElement = (Region)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getSubvertices().iterator(); it
				.hasNext();) {
			Vertex childElement = (Vertex)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if(visualID == StateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == State2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == State3EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == FinalStateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PseudostateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == Pseudostate2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == Pseudostate3EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == Pseudostate4EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == Pseudostate5EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == Pseudostate6EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == Pseudostate7EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == Pseudostate8EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == State4EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRegionSubvertices_5002SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Region modelElement = (Region)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getSubvertices().iterator(); it
				.hasNext();) {
			Vertex childElement = (Vertex)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if(visualID == StateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == State2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == State3EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == FinalStateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PseudostateEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == Pseudostate2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == Pseudostate3EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == Pseudostate4EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == Pseudostate5EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == Pseudostate6EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == Pseudostate7EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == Pseudostate8EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == State4EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated NOT
	 * 
	 *            modified to handle a StateMachine as a canvas element.
	 */
	static class ThisDiagramUpdaterSwitch extends
			BasicEcoreSwitch<List<UMLNodeDescriptor>, View> {

		@Override
		public List<UMLNodeDescriptor> doSwitch(EObject modelElement) {

			final View view = getInfo();
			if(view == null) {
				return Collections.EMPTY_LIST;
			}

			UMLSwitch<List<UMLNodeDescriptor>> aSwitch = new UMLSwitch<List<UMLNodeDescriptor>>() {

				@Override
				public List<UMLNodeDescriptor> casePackage(Package modelElement) {
					List<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
					for(Iterator it = modelElement.getPackagedElements()
							.iterator(); it.hasNext();) {
						PackageableElement childElement = (PackageableElement)it
								.next();
						int visualID = UMLVisualIDRegistry.getNodeVisualID(
								view, childElement);
						if(visualID == StateMachine2EditPart.VISUAL_ID) {
							result.add(new UMLNodeDescriptor(childElement,
									visualID));
							continue;
						}
					}
					for(Iterator it = modelElement.getOwnedComments()
							.iterator(); it.hasNext();) {
						Comment childElement = (Comment)it.next();
						int visualID = UMLVisualIDRegistry.getNodeVisualID(
								view, childElement);
						if(visualID == CommentEditPart.VISUAL_ID) {
							result.add(new UMLNodeDescriptor(childElement,
									visualID));
							continue;
						}
					}
					return result;
				}

				@Override
				public List<UMLNodeDescriptor> caseStateMachine(
						StateMachine modelElement) {
					List<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
					for(Iterator it = modelElement.getOwnedComments()
							.iterator(); it.hasNext();) {
						Comment childElement = (Comment)it.next();
						int visualID = UMLVisualIDRegistry.getNodeVisualID(
								view, childElement);
						if(visualID == CommentEditPart.VISUAL_ID) {
							result.add(new UMLNodeDescriptor(childElement,
									visualID));
							continue;
						}
					}
					result.add(new UMLNodeDescriptor(modelElement,
							StateMachine2EditPart.VISUAL_ID));
					return result;
				}

				@Override
				public List<UMLNodeDescriptor> caseClass(Class modelElement) {
					List<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
					for(Iterator it = modelElement.getOwnedComments()
							.iterator(); it.hasNext();) {
						Comment childElement = (Comment)it.next();
						int visualID = UMLVisualIDRegistry.getNodeVisualID(
								view, childElement);
						if(visualID == CommentEditPart.VISUAL_ID) {
							result.add(new UMLNodeDescriptor(childElement,
									visualID));
							continue;
						}
					}
					for(Iterator it = modelElement.getNestedClassifiers()
							.iterator(); it.hasNext();) {
						Classifier childElement = (Classifier)it.next();
						int visualID = UMLVisualIDRegistry.getNodeVisualID(
								view, childElement);
						if(visualID == StateMachine2EditPart.VISUAL_ID) {
							result.add(new UMLNodeDescriptor(childElement,
									visualID));
							continue;
						}
					}
					return result;
				}

			};
			return aSwitch.doSwitch(modelElement);
		}
	}

	/**
	 * @generated
	 */
	private static ThisDiagramUpdaterSwitch aSwitch = new ThisDiagramUpdaterSwitch();

	/**
	 * @generated
	 */
	public static List getPackage_79SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		EObject modelElement = (EObject)view.getElement();
		aSwitch.setInfo(view);
		List<UMLNodeDescriptor> result = aSwitch.doSwitch(modelElement);
		if(result == null || result.size() <= 0) {
			return Collections.EMPTY_LIST;
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case StateMachineEditPart.VISUAL_ID:
			return getPackage_79ContainedLinks(view);
		case StateMachine2EditPart.VISUAL_ID:
			return getStateMachine_1001ContainedLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2024ContainedLinks(view);
		case RegionEditPart.VISUAL_ID:
			return getRegion_2001ContainedLinks(view);
		case StateEditPart.VISUAL_ID:
			return getState_2002ContainedLinks(view);
		case State2EditPart.VISUAL_ID:
			return getState_2003ContainedLinks(view);
		case Region2EditPart.VISUAL_ID:
			return getRegion_2004ContainedLinks(view);
		case State3EditPart.VISUAL_ID:
			return getState_2005ContainedLinks(view);
		case ConnectionPointReferenceEditPart.VISUAL_ID:
			return getConnectionPointReference_2006ContainedLinks(view);
		case ConnectionPointReference2EditPart.VISUAL_ID:
			return getConnectionPointReference_2007ContainedLinks(view);
		case FinalStateEditPart.VISUAL_ID:
			return getFinalState_2008ContainedLinks(view);
		case PseudostateEditPart.VISUAL_ID:
			return getPseudostate_2009ContainedLinks(view);
		case Pseudostate2EditPart.VISUAL_ID:
			return getPseudostate_2010ContainedLinks(view);
		case Pseudostate3EditPart.VISUAL_ID:
			return getPseudostate_2011ContainedLinks(view);
		case Pseudostate4EditPart.VISUAL_ID:
			return getPseudostate_2012ContainedLinks(view);
		case Pseudostate5EditPart.VISUAL_ID:
			return getPseudostate_2013ContainedLinks(view);
		case Pseudostate6EditPart.VISUAL_ID:
			return getPseudostate_2014ContainedLinks(view);
		case Pseudostate7EditPart.VISUAL_ID:
			return getPseudostate_2015ContainedLinks(view);
		case Pseudostate8EditPart.VISUAL_ID:
			return getPseudostate_2016ContainedLinks(view);
		case State4EditPart.VISUAL_ID:
			return getState_2017ContainedLinks(view);
		case Pseudostate9EditPart.VISUAL_ID:
			return getPseudostate_2018ContainedLinks(view);
		case Pseudostate10EditPart.VISUAL_ID:
			return getPseudostate_2019ContainedLinks(view);
		case Pseudostate11EditPart.VISUAL_ID:
			return getPseudostate_2020ContainedLinks(view);
		case Pseudostate12EditPart.VISUAL_ID:
			return getPseudostate_2021ContainedLinks(view);
		case Pseudostate13EditPart.VISUAL_ID:
			return getPseudostate_2022ContainedLinks(view);
		case Pseudostate14EditPart.VISUAL_ID:
			return getPseudostate_2023ContainedLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_3001ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case StateMachine2EditPart.VISUAL_ID:
			return getStateMachine_1001IncomingLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2024IncomingLinks(view);
		case RegionEditPart.VISUAL_ID:
			return getRegion_2001IncomingLinks(view);
		case StateEditPart.VISUAL_ID:
			return getState_2002IncomingLinks(view);
		case State2EditPart.VISUAL_ID:
			return getState_2003IncomingLinks(view);
		case Region2EditPart.VISUAL_ID:
			return getRegion_2004IncomingLinks(view);
		case State3EditPart.VISUAL_ID:
			return getState_2005IncomingLinks(view);
		case ConnectionPointReferenceEditPart.VISUAL_ID:
			return getConnectionPointReference_2006IncomingLinks(view);
		case ConnectionPointReference2EditPart.VISUAL_ID:
			return getConnectionPointReference_2007IncomingLinks(view);
		case FinalStateEditPart.VISUAL_ID:
			return getFinalState_2008IncomingLinks(view);
		case PseudostateEditPart.VISUAL_ID:
			return getPseudostate_2009IncomingLinks(view);
		case Pseudostate2EditPart.VISUAL_ID:
			return getPseudostate_2010IncomingLinks(view);
		case Pseudostate3EditPart.VISUAL_ID:
			return getPseudostate_2011IncomingLinks(view);
		case Pseudostate4EditPart.VISUAL_ID:
			return getPseudostate_2012IncomingLinks(view);
		case Pseudostate5EditPart.VISUAL_ID:
			return getPseudostate_2013IncomingLinks(view);
		case Pseudostate6EditPart.VISUAL_ID:
			return getPseudostate_2014IncomingLinks(view);
		case Pseudostate7EditPart.VISUAL_ID:
			return getPseudostate_2015IncomingLinks(view);
		case Pseudostate8EditPart.VISUAL_ID:
			return getPseudostate_2016IncomingLinks(view);
		case State4EditPart.VISUAL_ID:
			return getState_2017IncomingLinks(view);
		case Pseudostate9EditPart.VISUAL_ID:
			return getPseudostate_2018IncomingLinks(view);
		case Pseudostate10EditPart.VISUAL_ID:
			return getPseudostate_2019IncomingLinks(view);
		case Pseudostate11EditPart.VISUAL_ID:
			return getPseudostate_2020IncomingLinks(view);
		case Pseudostate12EditPart.VISUAL_ID:
			return getPseudostate_2021IncomingLinks(view);
		case Pseudostate13EditPart.VISUAL_ID:
			return getPseudostate_2022IncomingLinks(view);
		case Pseudostate14EditPart.VISUAL_ID:
			return getPseudostate_2023IncomingLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_3001IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case StateMachine2EditPart.VISUAL_ID:
			return getStateMachine_1001OutgoingLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2024OutgoingLinks(view);
		case RegionEditPart.VISUAL_ID:
			return getRegion_2001OutgoingLinks(view);
		case StateEditPart.VISUAL_ID:
			return getState_2002OutgoingLinks(view);
		case State2EditPart.VISUAL_ID:
			return getState_2003OutgoingLinks(view);
		case Region2EditPart.VISUAL_ID:
			return getRegion_2004OutgoingLinks(view);
		case State3EditPart.VISUAL_ID:
			return getState_2005OutgoingLinks(view);
		case ConnectionPointReferenceEditPart.VISUAL_ID:
			return getConnectionPointReference_2006OutgoingLinks(view);
		case ConnectionPointReference2EditPart.VISUAL_ID:
			return getConnectionPointReference_2007OutgoingLinks(view);
		case FinalStateEditPart.VISUAL_ID:
			return getFinalState_2008OutgoingLinks(view);
		case PseudostateEditPart.VISUAL_ID:
			return getPseudostate_2009OutgoingLinks(view);
		case Pseudostate2EditPart.VISUAL_ID:
			return getPseudostate_2010OutgoingLinks(view);
		case Pseudostate3EditPart.VISUAL_ID:
			return getPseudostate_2011OutgoingLinks(view);
		case Pseudostate4EditPart.VISUAL_ID:
			return getPseudostate_2012OutgoingLinks(view);
		case Pseudostate5EditPart.VISUAL_ID:
			return getPseudostate_2013OutgoingLinks(view);
		case Pseudostate6EditPart.VISUAL_ID:
			return getPseudostate_2014OutgoingLinks(view);
		case Pseudostate7EditPart.VISUAL_ID:
			return getPseudostate_2015OutgoingLinks(view);
		case Pseudostate8EditPart.VISUAL_ID:
			return getPseudostate_2016OutgoingLinks(view);
		case State4EditPart.VISUAL_ID:
			return getState_2017OutgoingLinks(view);
		case Pseudostate9EditPart.VISUAL_ID:
			return getPseudostate_2018OutgoingLinks(view);
		case Pseudostate10EditPart.VISUAL_ID:
			return getPseudostate_2019OutgoingLinks(view);
		case Pseudostate11EditPart.VISUAL_ID:
			return getPseudostate_2020OutgoingLinks(view);
		case Pseudostate12EditPart.VISUAL_ID:
			return getPseudostate_2021OutgoingLinks(view);
		case Pseudostate13EditPart.VISUAL_ID:
			return getPseudostate_2022OutgoingLinks(view);
		case Pseudostate14EditPart.VISUAL_ID:
			return getPseudostate_2023OutgoingLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_3001OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated NOT
	 * 
	 *            Modified to handle an Activity as a canvas element.
	 */
	public static List getPackage_79ContainedLinks(View view) {
		EObject modelElement = view.getElement();
		if(modelElement instanceof Element) {
			List result = new LinkedList();
			result
					.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002((Element)modelElement));
			return result;
		}
		return null;
	}

	/**
	 * @generated
	 */
	public static List getStateMachine_1001ContainedLinks(View view) {
		StateMachine modelElement = (StateMachine)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_2024ContainedLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRegion_2001ContainedLinks(View view) {
		Region modelElement = (Region)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Transition_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_2002ContainedLinks(View view) {
		State modelElement = (State)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_2003ContainedLinks(View view) {
		State modelElement = (State)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRegion_2004ContainedLinks(View view) {
		Region modelElement = (Region)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Transition_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_2005ContainedLinks(View view) {
		State modelElement = (State)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConnectionPointReference_2006ContainedLinks(View view) {
		ConnectionPointReference modelElement = (ConnectionPointReference)view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConnectionPointReference_2007ContainedLinks(View view) {
		ConnectionPointReference modelElement = (ConnectionPointReference)view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFinalState_2008ContainedLinks(View view) {
		FinalState modelElement = (FinalState)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2009ContainedLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2010ContainedLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2011ContainedLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2012ContainedLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2013ContainedLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2014ContainedLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2015ContainedLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2016ContainedLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_2017ContainedLinks(View view) {
		State modelElement = (State)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2018ContainedLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2019ContainedLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2020ContainedLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2021ContainedLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2022ContainedLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2023ContainedLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated not
	 */
	public static List getTransition_3001ContainedLinks(View view) {
		Transition modelElement = (Transition)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStateMachine_1001IncomingLinks(View view) {
		StateMachine modelElement = (StateMachine)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_2024IncomingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_Element_OwnedComment_3002(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRegion_2001IncomingLinks(View view) {
		Region modelElement = (Region)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_2002IncomingLinks(View view) {
		State modelElement = (State)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_3001(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_2003IncomingLinks(View view) {
		State modelElement = (State)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_3001(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRegion_2004IncomingLinks(View view) {
		Region modelElement = (Region)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_2005IncomingLinks(View view) {
		State modelElement = (State)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_3001(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConnectionPointReference_2006IncomingLinks(View view) {
		ConnectionPointReference modelElement = (ConnectionPointReference)view
				.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_3001(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConnectionPointReference_2007IncomingLinks(View view) {
		ConnectionPointReference modelElement = (ConnectionPointReference)view
				.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_3001(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFinalState_2008IncomingLinks(View view) {
		FinalState modelElement = (FinalState)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_3001(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2009IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_3001(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2010IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_3001(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2011IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_3001(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2012IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_3001(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2013IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_3001(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2014IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_3001(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2015IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_3001(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2016IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_3001(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_2017IncomingLinks(View view) {
		State modelElement = (State)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_3001(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2018IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_3001(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2019IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_3001(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2020IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_3001(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2021IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_3001(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2022IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_3001(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2023IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_3001(
				modelElement, crossReferences));
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTransition_3001IncomingLinks(View view) {
		Transition modelElement = (Transition)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStateMachine_1001OutgoingLinks(View view) {
		StateMachine modelElement = (StateMachine)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_2024OutgoingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRegion_2001OutgoingLinks(View view) {
		Region modelElement = (Region)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_2002OutgoingLinks(View view) {
		State modelElement = (State)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_2003OutgoingLinks(View view) {
		State modelElement = (State)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRegion_2004OutgoingLinks(View view) {
		Region modelElement = (Region)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_2005OutgoingLinks(View view) {
		State modelElement = (State)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConnectionPointReference_2006OutgoingLinks(View view) {
		ConnectionPointReference modelElement = (ConnectionPointReference)view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConnectionPointReference_2007OutgoingLinks(View view) {
		ConnectionPointReference modelElement = (ConnectionPointReference)view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFinalState_2008OutgoingLinks(View view) {
		FinalState modelElement = (FinalState)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2009OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2010OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2011OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2012OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2013OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2014OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2015OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2016OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getState_2017OutgoingLinks(View view) {
		State modelElement = (State)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2018OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2019OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2020OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2021OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2022OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_2023OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_3001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTransition_3001OutgoingLinks(View view) {
		Transition modelElement = (Transition)view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Transition_3001(
			Region container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getTransitions().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Transition) {
				continue;
			}
			Transition link = (Transition)linkObject;
			if(TransitionEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Vertex dst = link.getTarget();
			Vertex src = link.getSource();
			result
					.add(new org.eclipse.papyrus.diagram.statemachine.part.UMLLinkDescriptor(
					src, dst, link, UMLElementTypes.Transition_3001,
					TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Transition_3001(
			Vertex target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it
					.next();
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE
					.getTransition_Target()
					|| false == setting.getEObject() instanceof Transition) {
				continue;
			}
			Transition link = (Transition)setting.getEObject();
			if(TransitionEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Vertex src = link.getSource();
			result
					.add(new org.eclipse.papyrus.diagram.statemachine.part.UMLLinkDescriptor(
					src, target, link, UMLElementTypes.Transition_3001,
					TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Element_OwnedComment_3002(
			Comment target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it
					.next();
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE
					.getElement_OwnedComment()) {
				result
						.add(new org.eclipse.papyrus.diagram.statemachine.part.UMLLinkDescriptor(
						setting.getEObject(), target,
						UMLElementTypes.ElementOwnedComment_3002,
						ElementOwnedCommentEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
			Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it
					.next();
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE
					.getComment_AnnotatedElement()) {
				result
						.add(new org.eclipse.papyrus.diagram.statemachine.part.UMLLinkDescriptor(
						setting.getEObject(), target,
						UMLElementTypes.CommentAnnotatedElement_3003,
						CommentAnnotatedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Transition_3001(
			Vertex source) {
		Region container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if(element instanceof Region) {
				container = (Region)element;
			}
		}
		if(container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getTransitions().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Transition) {
				continue;
			}
			Transition link = (Transition)linkObject;
			if(TransitionEditPart.VISUAL_ID != UMLVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Vertex dst = link.getTarget();
			Vertex src = link.getSource();
			if(src != source) {
				continue;
			}
			result
					.add(new org.eclipse.papyrus.diagram.statemachine.part.UMLLinkDescriptor(
					src, dst, link, UMLElementTypes.Transition_3001,
					TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated not
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Element_OwnedComment_3002(
			Element source) {
		return new LinkedList();
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_3003(
			Comment source) {
		Collection result = new LinkedList();
		for(Iterator destinations = source.getAnnotatedElements().iterator(); destinations
				.hasNext();) {
			Element destination = (Element)destinations.next();
			result
					.add(new org.eclipse.papyrus.diagram.statemachine.part.UMLLinkDescriptor(
					source, destination,
					UMLElementTypes.CommentAnnotatedElement_3003,
					CommentAnnotatedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	public static UMLLinkDescriptor createLinkDescriptorFromModelElement(
			EObject eObject) {
		int linkID = UMLVisualIDRegistry.getLinkWithClassVisualID(eObject);
		switch(linkID) {
		case TransitionEditPart.VISUAL_ID:
			return createLinkDescriptorFromTransition((Transition)eObject);
		default:
			return null;
		}
	}

	private static UMLLinkDescriptor createLinkDescriptorFromTransition(
			Transition transition) {
		Vertex src = transition.getSource();
		Vertex target = transition.getTarget();
		return new org.eclipse.papyrus.diagram.statemachine.part.UMLLinkDescriptor(
				src, target, transition, UMLElementTypes.Transition_3001,
				TransitionEditPart.VISUAL_ID);
	}

}
