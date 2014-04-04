/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.tests.bug.pro20130916;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.text.TextFlow;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7.AbstractNodeTest;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;


/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class BaseStereotypesTest extends AbstractNodeTest {

	private static final URI SYSML_PROFILE = URI.createURI("pathmap://SysML_PROFILES/SysML.profile.uml");

	private static final String COMPARTMENT = UMLVisualInformationPapyrusConstant.STEREOTYPE_COMPARTMENT_LOCATION;

	private static final String COMMENT = UMLVisualInformationPapyrusConstant.STEREOTYPE_COMMENT_LOCATION;

	private static final String BRACE = UMLVisualInformationPapyrusConstant.STEREOTYPE_BRACE_LOCATION;

	protected void prepareStereotypes(EditPart editPart) {
		assertNotNull("editPart", editPart);
		View view = getDiagramElement(editPart);
		assertNotNull("view", view);
		Element element = getElement(editPart);
		assertNotNull("element", element);
		Stereotype appliedStereotype = applyStereotype(editPart);
		assertNotNull("appliedStereotype", appliedStereotype);
		waitForComplete();
	}

	protected void doTestDisplayStereotypeInCompartment(EditPart editPart, EditPart stereotypeEditPart) {
		if(stereotypeEditPart == null) {
			stereotypeEditPart = editPart;
		}
		prepareStereotypes(editPart);
		final View diagramElement = getDiagramElement(editPart);
		setDisplayPlaceValue(diagramElement, COMPARTMENT);
		//doCheck
		//1. Check Compartment
		final boolean displayInCompartment = AppliedStereotypeHelper.hasAppliedStereotypesPropertiesToDisplay(diagramElement, UMLVisualInformationPapyrusConstant.STEREOTYPE_COMPARTMENT_LOCATION);
		assertTrue("displayInCompartment", displayInCompartment);
		final View node = ((GraphicalEditPart)editPart).getNotationView();
		int i = 0;
		//we go through all sub nodes
		Node compartmentNode = null;
		while(i < node.getChildren().size()) {
			if((node.getChildren().get(i)) instanceof Node) {
				final Node currentNode = (Node)(node.getChildren().get(i));
				if(currentNode.getType().equals("AppliedStereotypeCompartement")) {
					if(currentNode.isVisible()) {
						compartmentNode = currentNode;
						break;
					}
				}
			}
			i++;
		}
		String stereotypesToDisplay = stereotypesOnlyToDisplay(diagramElement, getElement(editPart));
		if(compartmentNode != null) {
			EditPart compartmentEditPart = null;
			List children = editPart.getChildren();
			for(Object object : children) {
				if(compartmentNode == ((EditPart)object).getModel()) {
					compartmentEditPart = (EditPart)object;
					break;
				}
			}
			if(compartmentEditPart != null) {
				IFigure figure = findLabelFigure(((org.eclipse.gef.GraphicalEditPart)compartmentEditPart).getFigure(), stereotypesToDisplay);
				if(figure != null) {
					return;
				}
			}
		}
		//2. check on main/external figure.
		IFigure stereotypeFigure = null;
		IFigure primaryShape = null;
		if(stereotypeEditPart instanceof IPapyrusEditPart) {
			primaryShape = ((IPapyrusEditPart)stereotypeEditPart).getPrimaryShape();
		} else if(stereotypeEditPart instanceof org.eclipse.gef.GraphicalEditPart) {
			primaryShape = ((org.eclipse.gef.GraphicalEditPart)stereotypeEditPart).getFigure();
		}
		if(primaryShape instanceof IPapyrusNodeUMLElementFigure) {
			stereotypeFigure = ((IPapyrusNodeUMLElementFigure)primaryShape).getStereotypesLabel();
		}
		assertNotNull(stereotypeFigure);
		String actualValue = getFigureText(stereotypeFigure);
		assertEquals("stereotype displayed in Compartment", stereotypesToDisplay, actualValue);
	}

	protected String stereotypesOnlyToDisplay(View diagramElement, Element element) {
		// list of stereotypes to display
		String stereotypesToDisplay = AppliedStereotypeHelper.getStereotypesToDisplay(diagramElement);
		// Kind of the representation
		String stereotypespresentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind(diagramElement);

		// check the presentation kind. if only icon => do not display
		// stereotypes
		if(UMLVisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION.equals(stereotypespresentationKind)) {
			return ""; // empty string, so stereotype label should not be
						// displayed
		}

		// stereotypes with qualified name to display
		String stereotypesToDisplayWithQN = AppliedStereotypeHelper.getStereotypesQNToDisplay(diagramElement);

		// the set is empty
		if(stereotypesToDisplayWithQN.length() == 0 && stereotypesToDisplay.length() == 0) {
			return "";
		}
		// vertical representation
		if(UMLVisualInformationPapyrusConstant.STEREOTYPE_TEXT_VERTICAL_PRESENTATION.equals(stereotypespresentationKind)) {
			return Activator.ST_LEFT + stereotypesToDisplay(element, Activator.ST_RIGHT + "\n" + Activator.ST_LEFT, stereotypesToDisplay, stereotypesToDisplayWithQN) + Activator.ST_RIGHT;
		} else {// horizontal representation
			return Activator.ST_LEFT + stereotypesToDisplay(element, ", ", stereotypesToDisplay, stereotypesToDisplayWithQN) + Activator.ST_RIGHT;

		}
	}

	protected String stereotypesToDisplay(Element element, String separator, String stereotypesToDisplay, String stereotypeWithQualifiedName) {

		// AL Changes Feb. 07 - Beg
		// Style Handling for STEREOTYPE_NAME_APPEARANCE from
		// ProfileApplicationPreferencePage
		// Stereotype displayed according to UML standard (first letter forced
		// to lower case) -
		// default -
		// or kept as entered by user (user controlled)

		// Get the preference from PreferenceStore. there should be an assert
		final IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		assert store != null : "The preference store was not found";
		if(store == null) {
			return "";
		}
		String sNameAppearance = store.getString(UMLVisualInformationPapyrusConstant.P_STEREOTYPE_NAME_APPEARANCE);

		StringTokenizer strQualifiedName = new StringTokenizer(stereotypesToDisplay, ",");
		String out = "";
		while(strQualifiedName.hasMoreElements()) {
			String currentStereotype = strQualifiedName.nextToken();

			// check if current stereotype is applied
			final Element umlElement = element;
			Stereotype stereotype = umlElement.getAppliedStereotype(currentStereotype);
			if(stereotype != null) {
				String name = currentStereotype;
				if((stereotypeWithQualifiedName.indexOf(currentStereotype)) == -1) {
					// property value contains qualifiedName ==> extract name
					// from it
					StringTokenizer strToken = new StringTokenizer(currentStereotype, "::");

					while(strToken.hasMoreTokens()) {
						name = strToken.nextToken();
					}
				}
				// AL Changes Feb. 07 - Beg
				// Handling STEREOTYPE_NAME_APPEARANCE preference (from
				// ProfileApplicationPreferencePage)
				// Previously lowercase forced onto first letter (standard UML)
				// stereotypesToDisplay = stereotypesToDisplay+name.substring(0,
				// 1).toLowerCase()+name.substring(1,
				// name.length())+","+separator;

				// check that the name has not already been added to the
				// displayed string
				if(sNameAppearance.equals(UMLVisualInformationPapyrusConstant.P_STEREOTYPE_NAME_DISPLAY_USER_CONTROLLED)) {
					if(out.indexOf(name) == -1) {
						out = out + name + separator;
					}
				} else { // VisualInformationPapyrusConstants.P_STEREOTYPE_NAME_DISPLAY_UML_CONFORM))
					// {
					name = name.substring(0, 1).toLowerCase() + name.substring(1, name.length());
					if(out.indexOf(name) == -1) {
						out = out + name + separator;
					}
				}
			}
		}
		if(out.endsWith(",")) {
			return out.substring(0, out.length() - 1);
		}
		if(out.endsWith(separator)) {
			return out.substring(0, out.length() - separator.length());
		}
		return out;
	}

	protected String getFigureText(IFigure figure) {
		if(figure instanceof Label) {
			return ((Label)figure).getText();
		} else if(figure instanceof WrappingLabel) {
			return ((WrappingLabel)figure).getText();
		} else if(figure instanceof ILabelFigure) {
			return ((ILabelFigure)figure).getText();
		} else if(figure instanceof TextFlow) {
			return ((TextFlow)figure).getText();
		}
		return null;
	}

	protected void doTestDisplayStereotypeWithBrace(EditPart editPart, EditPart stereotypeEditPart) {
		if(stereotypeEditPart == null) {
			stereotypeEditPart = editPart;
		}
		prepareStereotypes(editPart);
		final View diagramElement = getDiagramElement(editPart);
		setDisplayPlaceValue(diagramElement, BRACE);
		//doCheck
		final boolean displayInBrace = AppliedStereotypeHelper.hasAppliedStereotypesPropertiesToDisplay(diagramElement, UMLVisualInformationPapyrusConstant.STEREOTYPE_BRACE_LOCATION);
		assertTrue("displayInBrace", displayInBrace);
		final String stereotypesPropertiesToDisplay = AppliedStereotypeHelper.getAppliedStereotypesPropertiesToDisplay(diagramElement);
		String todisplay = StereotypeUtil.getPropertiesValuesInBrace(stereotypesPropertiesToDisplay, getElement(editPart));
		String stereotypeInBrace = "{" + todisplay + "}";
		IFigure label = findLabelFigure(getFigure(stereotypeEditPart), stereotypeInBrace);
		assertNotNull("Stereotype displayed with brace", label);
	}

	private IFigure findLabelFigure(IFigure figure, String labelText) {
		if(figure == null || labelText == null) {
			return null;
		}
		String value = getFigureText(figure);
		if(labelText.equals(value)) {
			return figure;
		}
		List children = figure.getChildren();
		for(Object object : children) {
			IFigure child = (IFigure)object;
			IFigure fig = findLabelFigure(child, labelText);
			if(fig != null) {
				return fig;
			}
		}
		return null;
	}

	private IFigure getFigure(EditPart editPart) {
		if(editPart instanceof org.eclipse.gef.GraphicalEditPart) {
			return ((org.eclipse.gef.GraphicalEditPart)editPart).getFigure();
		}
		return null;
	}

	protected void doTestDisplayStereotypeComment(EditPart editPart) {
		prepareStereotypes(editPart);
		final View diagramElement = getDiagramElement(editPart);
		setDisplayPlaceValue(diagramElement, COMMENT);
		//doCheck
		waitForComplete();
		Node commentNode = getAppliedStereotypeCommentNode(diagramElement);
		assertNotNull("commentNode", commentNode);
	}

	protected Node getAppliedStereotypeCommentNode(View semanticView) {
		if(semanticView == null) {
			return null;
		}
		Edge appliedStereotypeLink = null;
		//look for all links with the id AppliedStereotypesCommentLinkEditPart.ID
		@SuppressWarnings("unchecked")
		Iterator<Edge> edgeIterator = semanticView.getSourceEdges().iterator();
		while(edgeIterator.hasNext()) {
			Edge edge = edgeIterator.next();
			if(edge.getType().equals("AppliedStereotypesCommentLink")) {
				appliedStereotypeLink = edge;
			}

		}
		if(appliedStereotypeLink == null) {
			return null;
		}
		return (Node)appliedStereotypeLink.getTarget();

	}

	protected Stereotype applyStereotype(EditPart editPart) {
		assertNotNull("editPart", editPart);
		final Element element = getElement(editPart);
		assertNotNull("element", element);
		Model model = getModel(element);
		assertNotNull("model", model);
		Profile profile = applyProfile(model);
		assertNotNull("profile", profile);
		final View diagramElement = getDiagramElement(editPart);
		EList<PackageableElement> packagedElements = profile.getPackagedElements();
		for(PackageableElement elt : packagedElements) {
			if(elt instanceof Stereotype) {
				final Stereotype stereotype = (Stereotype)elt;
				if(!element.isStereotypeApplicable(stereotype)) {
					continue;
				}
				Stereotype appliedStereotype = element.getAppliedStereotype(stereotype.getQualifiedName());
				if(appliedStereotype == null) {
					//Apply the stereotype if possible.
					getCommandStack().execute(new RecordingCommand(getEditingDomain()) {

						@Override
						protected void doExecute() {
							element.applyStereotype(stereotype);
						}
					});
					appliedStereotype = element.getAppliedStereotype(stereotype.getQualifiedName());
					//Display current stereotype
					String presentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind(diagramElement);
					getCommandStack().execute(AppliedStereotypeHelper.getAddAppliedStereotypeCommand(getEditingDomain(), diagramElement, appliedStereotype.getQualifiedName(), presentationKind));
					if(appliedStereotype != null) {
						//Display all properties of it.
						Iterator<Property> propIt = appliedStereotype.getAllAttributes().iterator();
						while(propIt.hasNext()) {
							final Property currentProp = propIt.next();
							boolean adding = false;
							// Select authorized properties
							if(currentProp.getAssociation() != null) {
								if(!currentProp.getName().startsWith("base_")) {
									adding = true;
								}
							} else {
								adding = true;
							}
							if(adding) {
								String appliedStereotypeListToAdd = stereotype.getQualifiedName() + "." + currentProp.getName();
								RecordingCommand command = AppliedStereotypeHelper.getAddAppliedStereotypePropertiesCommand(getEditingDomain(), diagramElement, appliedStereotypeListToAdd);
								getCommandStack().execute(command);
							}
						}
					}
				}
				return appliedStereotype;
			}
		}
		return null;
	}

	protected Profile applyProfile(final Model model) {
		ResourceSet resourceSet = model.eResource().getResourceSet();
		Resource resource = resourceSet.getResource(SYSML_PROFILE, true);
		Profile profileToApply = null;
		if(!resource.getContents().isEmpty()) {
			EObject eObject = resource.getContents().get(0);
			if(eObject instanceof Profile) {
				profileToApply = (Profile)eObject;
			}
		}
		assertNotNull("profileToApply", profileToApply);
		final Profile allocationsProfile = (Profile)profileToApply.getPackagedElement("Allocations");
		assertNotNull("allocationsProfile", allocationsProfile);
		getCommandStack().execute(new RecordingCommand(getEditingDomain()) {

			@Override
			protected void doExecute() {
				PackageUtil.applyProfile(model, allocationsProfile, true);
			}
		});
		return allocationsProfile;
	}

	protected View getDiagramElement(EditPart editPart) {
		if(editPart == null) {
			return null;
		}
		Object model = editPart.getModel();
		if(model instanceof View) {
			return (View)model;
		}
		return null;
	}

	protected Element getElement(EditPart editPart) {
		View diagramElement = getDiagramElement(editPart);
		if(diagramElement == null) {
			return null;
		}
		return (Element)ViewUtil.resolveSemanticElement(diagramElement);
	}

	protected Model getModel(EObject obj) {
		if(obj instanceof Model) {
			return (Model)obj;
		}
		EObject parent = obj.eContainer();
		while(parent != null && !(parent instanceof Model)) {
			parent = parent.eContainer();
		}
		return (Model)parent;
	}

	protected void setDisplayPlaceValue(EModelElement diagramElement, String stereotypePlacePresentation) {
		assertNotNull("DiagramElement", diagramElement);
		assertNotNull("Stereotype placement", stereotypePlacePresentation);
		String oldDisplayPlace = AppliedStereotypeHelper.getAppliedStereotypesPropertiesLocalization(diagramElement);
		TransactionalEditingDomain domain = getDiagramEditPart().getEditingDomain();
		RecordingCommand command = AppliedStereotypeHelper.getSetAppliedStereotypePropertiesLocalizationCommand(domain, diagramElement, stereotypePlacePresentation);
		domain.getCommandStack().execute(command);
		assertEquals("Stereotype placement", stereotypePlacePresentation, AppliedStereotypeHelper.getAppliedStereotypesPropertiesLocalization(diagramElement));
		domain.getCommandStack().undo();
		assertEquals("Stereotype placement undo", oldDisplayPlace, AppliedStereotypeHelper.getAppliedStereotypesPropertiesLocalization(diagramElement));
		domain.getCommandStack().redo();
		assertEquals("Stereotype placement redo", stereotypePlacePresentation, AppliedStereotypeHelper.getAppliedStereotypesPropertiesLocalization(diagramElement));
	}

	/**
	 * test apply profile to model and apply stereotype to a EditPart.
	 */
	protected void innerTestApplyProfile() {
		DiagramEditPart diagram = getDiagramEditPart();
		assertNotNull("diagram", diagram);
		Stereotype stereotype = applyStereotype(diagram);
		assertNotNull("appliedStereotype", stereotype);
	}

	public void checkConnectionHorizontally(ConnectionNodeEditPart conn, int tolerance) {
		assertNotNull("connection", conn);
		Point start = SequenceUtil.getAbsoluteEdgeExtremity(conn, true);
		Point end = SequenceUtil.getAbsoluteEdgeExtremity(conn, false);
		int distance = Math.abs(start.y - end.y);
		assertTrue("connection horizontally (" + distance + ")", distance <= tolerance);
	}

}
