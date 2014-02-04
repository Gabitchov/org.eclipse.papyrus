package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.common.util.MessageDirection;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.AppliedStereotypeExternalNodeLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.UMLTextSelectionEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.locator.GateLocator;
import org.eclipse.papyrus.uml.diagram.sequence.parsers.MessageFormatParser;
import org.eclipse.papyrus.uml.diagram.sequence.util.GateHelper;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * 1. Refactoring with a BorderItemLabelEditPart.
 * 2. Add displaying stereotypes.
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class GateNameEditPart extends BorderItemLabelEditPart implements IPapyrusEditPart {

	public static final String GATE_NAME_TYPE = "Gate_Name";

	static {
		registerSnapBackPosition(GATE_NAME_TYPE, new Point(-32, 0));
	}

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public GateNameEditPart(View view) {
		super(view);
	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new LabelDirectEditPolicy());
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new UMLTextSelectionEditPolicy());
		//Display stereotype on name figure.
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeExternalNodeLabelEditPolicy());
	}

	public IFigure getPrimaryShape() {
		return getFigure();
	}

	public IBorderItemLocator getBorderItemLocator() {
		IFigure parentFigure = getFigure().getParent();
		if(parentFigure != null && parentFigure.getLayoutManager() != null) {
			Object constraint = parentFigure.getLayoutManager().getConstraint(getFigure());
			return (IBorderItemLocator)constraint;
		}
		return null;
	}

	@Override
	protected Point getLocation() {
		Point location = super.getLocation();
		if(location.x == 0 && location.y == 0) {
			Dimension size = getSize();
			EditPart parent = getParent();
			if(parent instanceof GateEditPart) {
				GateEditPart gateEditPart = ((GateEditPart)parent);
				EObject elt = gateEditPart.resolveSemanticElement();
				Dimension preferredSize = getFigure().getPreferredSize(size.width, size.height);
				IBorderItemLocator locator = gateEditPart.getBorderItemLocator();
				if(locator instanceof GateLocator) {
					int alignment = ((GateLocator)locator).getAlignment(((GateLocator)locator).getConstraint());
					if(PositionConstants.LEFT == alignment) {
						if(gateEditPart.getTargetConnections().isEmpty()) {
							location.x = -preferredSize.width - 1;
						} else {
							location.x = GateEditPart.DEFAULT_SIZE.width + 1;
						}
						if(elt instanceof Gate && GateHelper.isInnerCFGate((Gate)elt)) {
							location.y = GateEditPart.DEFAULT_SIZE.height - 2;//move fown
						} else {
							location.y = -GateEditPart.DEFAULT_SIZE.height + 2;//move up
						}
					} else if(PositionConstants.RIGHT == alignment) {
						if(gateEditPart.getSourceConnections().isEmpty()) {
							location.x = GateEditPart.DEFAULT_SIZE.width + 1;
						} else {
							location.x = -preferredSize.width - 1;
						}
						if(elt instanceof Gate && GateHelper.isInnerCFGate((Gate)elt)) {
							location.y = GateEditPart.DEFAULT_SIZE.height - 2;//move fown
						} else {
							location.y = -GateEditPart.DEFAULT_SIZE.height + 2;//move up
						}
					} else if(PositionConstants.TOP == alignment) {
						location.y = -GateEditPart.DEFAULT_SIZE.height - 1;
					} else if(PositionConstants.BOTTOM == alignment) {
						location.y = GateEditPart.DEFAULT_SIZE.height + 1;
					}
				}
			}
		}
		return location;
	}

	@Override
	protected IParser createParser() {
		return new GateNameParser();
	}

	@Override
	protected IFigure createFigurePrim() {
		return new GateNameFigure();
	}

	public class GateNameParser extends MessageFormatParser implements ISemanticParser {

		/**
		 * Constructor.
		 * 
		 * @param features
		 */
		public GateNameParser() {
			super(new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() });
		}

		/**
		 * @see org.eclipse.papyrus.uml.diagram.sequence.parsers.MessageFormatParser#getPrintString(org.eclipse.core.runtime.IAdaptable, int)
		 * 
		 * @param adapter
		 * @param flags
		 * @return
		 */
		@Override
		public String getPrintString(IAdaptable adapter, int flags) {
			//			Object element = adapter.getAdapter(EObject.class);
			//			if(element instanceof Gate) {
			//				Gate gate = (Gate)element;
			//				if(gate.eContainer() instanceof CombinedFragment) {
			//					Gate outerGate = GateHelper.getOuterCFGate(gate);
			//					if(outerGate != null) {
			//						gate = outerGate;
			//					}
			//				} else if(gate.eContainer() instanceof Interaction) {
			//					Gate actualGate = GateHelper.getActualGate(gate);
			//					if(actualGate != null) {
			//						gate = actualGate;
			//					}
			//				}
			//				String printString = getPrintString(gate);
			//				if(printString != null) {
			//					return printString;
			//				}
			//			}
			return super.getPrintString(adapter, flags);
		}

		/**
		 * @param gate
		 */
		protected String getPrintString(Gate gate) {
			Message message = gate.getMessage();
			if(message != null) {
				MessageDirection direction = null;
				EObject parent = gate.eContainer();
				if(parent instanceof CombinedFragment) {
					CombinedFragment cf = ((CombinedFragment)parent);
					if(gate == message.getSendEvent()) {
						MessageEnd receiveEvent = message.getReceiveEvent();
						Lifeline lifeline = getCoveredBy(receiveEvent);
						if(!cf.getCovereds().contains(lifeline)) {
							direction = MessageDirection.OUT;
						}
					} else {
						MessageEnd sendEvent = message.getSendEvent();
						Lifeline coveredBy = getCoveredBy(sendEvent);
						if(!cf.getCovereds().contains(coveredBy)) {
							direction = MessageDirection.IN;
						}
					}
				} else if(parent instanceof Interaction) {
					if(gate == message.getSendEvent()) {
						direction = MessageDirection.IN;
					} else if(gate == message.getReceiveEvent()) {
						direction = MessageDirection.OUT;
					}
				}
				if(direction == null) {
					if(gate == message.getSendEvent()) {
						direction = MessageDirection.OUT;
					} else if(gate == message.getReceiveEvent()) {
						direction = MessageDirection.IN;
					}
				}
				if(direction != null) {
					StringBuffer buf = new StringBuffer();
					buf.append(direction.getName() + "_");
					buf.append(message.getName());
					return new String(buf);
				}
			}
			return null;
		}

		private Lifeline getCoveredBy(MessageEnd messageEnd) {
			if(messageEnd == null) {
				return null;
			}
			if(messageEnd instanceof OccurrenceSpecification) {
				return ((OccurrenceSpecification)messageEnd).getCovered();
			}
			return null;
		}

		protected EStructuralFeature getEStructuralFeature(Object notification) {
			EStructuralFeature featureImpl = null;
			if(notification instanceof Notification) {
				Object feature = ((Notification)notification).getFeature();
				if(feature instanceof EStructuralFeature) {
					featureImpl = (EStructuralFeature)feature;
				}
			}
			return featureImpl;
		}

		private boolean isValidFeature(EStructuralFeature feature) {
			return UMLPackage.eINSTANCE.getNamedElement_Name().equals(feature);
		}

		/**
		 * @see org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser#getSemanticElementsBeingParsed(org.eclipse.emf.ecore.EObject)
		 * 
		 * @param element
		 * @return
		 */
		public List getSemanticElementsBeingParsed(EObject element) {
			if(element instanceof Gate) {
				return Collections.singletonList(element);
			}
			return Collections.emptyList();
		}

		/**
		 * @see org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser#areSemanticElementsAffected(org.eclipse.emf.ecore.EObject,
		 *      java.lang.Object)
		 * 
		 * @param listener
		 * @param notification
		 * @return
		 */
		public boolean areSemanticElementsAffected(EObject listener, Object notification) {
			EStructuralFeature feature = getEStructuralFeature(notification);
			return isValidFeature(feature);
		}
	}

	public class GateNameFigure extends Figure implements ILabelFigure, IPapyrusNodeUMLElementFigure {

		protected static final String LEFT_BRACE = "{";

		protected static final String RIGHT_BRACE = "}";

		private WrappingLabel namedLabel;

		private Label stereotypesLabel;

		private Label stereotypePropertiesLabel;

		/**
		 * Constructor.
		 * 
		 */
		public GateNameFigure() {
			setBorder(new MarginBorder(2));
			ToolbarLayout layout = new ToolbarLayout(false);
			layout.setStretchMinorAxis(true);
			setLayoutManager(layout);
			createContents();
		}

		protected void createContents() {
			namedLabel = new WrappingLabel();
			namedLabel.setTextWrap(true);
			namedLabel.setAlignment(PositionConstants.CENTER);
			add(namedLabel);
		}

		public void setStereotypeDisplay(String stereotypes, Image image) {
			if(stereotypes == null || stereotypes.trim().equals("")) {
				if(stereotypesLabel != null) {
					this.remove(stereotypesLabel);
				}
				stereotypesLabel = null;
			} else {
				if(stereotypesLabel == null) {
					stereotypesLabel = new Label(stereotypes, image);
					this.add(stereotypesLabel, 0);
				} else {
					stereotypesLabel.setText(stereotypes);
					stereotypesLabel.setIcon(image);
				}
			}
		}


		public void setStereotypePropertiesInBrace(String stereotypeProperties) {
			if(stereotypeProperties == null || stereotypeProperties.trim().equals("")) {
				if(stereotypePropertiesLabel != null) {
					this.remove(stereotypePropertiesLabel);
				}
				stereotypePropertiesLabel = null;
			} else {
				if(stereotypePropertiesLabel == null) {
					stereotypePropertiesLabel = new Label();
					int index = this.getChildren().indexOf(stereotypesLabel);
					this.add(stereotypePropertiesLabel, index + 1);
				}
				stereotypePropertiesLabel.setText(LEFT_BRACE + stereotypeProperties + RIGHT_BRACE);
			}
		}


		public void setStereotypePropertiesInCompartment(String stereotypeProperties) {

		}


		public Label getStereotypesLabel() {
			return stereotypesLabel;
		}


		public void setText(String text) {
			namedLabel.setText(text);
		}


		public String getText() {
			return namedLabel.getText();
		}


		public void setIcon(Image icon) {
			namedLabel.setIcon(icon);
		}


		public Image getIcon() {
			return namedLabel.getIcon();
		}

	}
}
