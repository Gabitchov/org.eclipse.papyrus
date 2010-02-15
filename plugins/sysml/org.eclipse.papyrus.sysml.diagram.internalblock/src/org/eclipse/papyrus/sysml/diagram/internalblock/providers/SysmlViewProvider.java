/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN) tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.providers.IViewProvider;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.MeasurementUnit;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.diagram.composite.edit.parts.*;
import org.eclipse.papyrus.diagram.composite.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.composite.providers.UMLViewProvider;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.sysml.diagram.internalblock.IBDCreation;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.parts.FlowPortEditPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.parts.ResourceEditPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.part.SysmlVisualIDRegistry;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;


/**
 * @generated
 */
public class SysmlViewProvider extends UMLViewProvider implements IViewProvider {

	//TODO: Find a way to return false if we are in a composite diagram
	@Override
	public boolean provides(IOperation operation) {
		if(operation instanceof CreateDiagramViewOperation) {
			return provides((CreateDiagramViewOperation)operation);
		}
		if(operation instanceof CreateNodeViewOperation) {
			return provides((CreateNodeViewOperation)operation);
		}
		if(operation instanceof CreateEdgeViewOperation) {
			return provides((CreateEdgeViewOperation)operation);
		}
		if(operation instanceof CreateViewForKindOperation) {
			return provides((CreateViewForKindOperation)operation);
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateViewForKindOperation op) {
		/*
		 * if (op.getViewKind() == Node.class) return getNodeViewClass(op.getSemanticAdapter(),
		 * op.getContainerView(), op.getSemanticHint()) != null; if (op.getViewKind() == Edge.class)
		 * return getEdgeViewClass(op.getSemanticAdapter(), op.getContainerView(),
		 * op.getSemanticHint()) != null;
		 */
		return op.getContainerView().getType() == IBDCreation.MODEL_ID;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateDiagramViewOperation op) {
		return ResourceEditPart.MODEL_ID.equals(op.getSemanticHint())
				&& SysmlVisualIDRegistry.getDiagramVisualID(getSemanticElement(op.getSemanticAdapter())) != -1;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateNodeViewOperation op) {
		if(op.getContainerView() == null) {
			return false;
		}
		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		EObject domainElement = getSemanticElement(op.getSemanticAdapter());
		int visualID;
		if(op.getSemanticHint() == null) {
			// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
			// In this situation there should be NO elementType, visualID will be determined
			// by VisualIDRegistry.getNodeVisualID() for domainElement.
			if(elementType != null || domainElement == null) {
				return false;
			}
			visualID = SysmlVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement);
		} else {
			visualID = SysmlVisualIDRegistry.getVisualID(op.getSemanticHint());
			if(elementType != null) {
				if(!SysmlElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
					return false; // foreign element type
				}
				String elementTypeHint = ((IHintedType)elementType).getSemanticHint();
				if(!op.getSemanticHint().equals(elementTypeHint)) {
					return false; // if semantic hint is specified it should be the same as in
					// element type
				}
				if (domainElement != null
						&& visualID != SysmlVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
					return visualID != UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement); // visual
					// id
					// for
					// node
					// EClass
					// should
					// match
					// visual
					// id
					// from
					// element
					// type
				}
			} else {
				if(!ResourceEditPart.MODEL_ID.equals(SysmlVisualIDRegistry.getModelID(op.getContainerView()))) {
					return false; // foreign diagram
				}
				switch(visualID) {
				case FlowPortEditPart.VISUAL_ID:
					if (domainElement == null
							|| visualID != SysmlVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
						return false; // visual id in semantic hint should match visual id for
						// domain element
					}
					break;
				default:
					return false;
				}
			}
		}
		return FlowPortEditPart.VISUAL_ID == visualID || ActivityCompositeEditPart.VISUAL_ID == visualID
				|| InteractionCompositeEditPart.VISUAL_ID == visualID
				|| ProtocolStateMachineCompositeEditPart.VISUAL_ID == visualID
				|| StateMachineCompositeEditPart.VISUAL_ID == visualID
				|| FunctionBehaviorCompositeEditPart.VISUAL_ID == visualID
				|| OpaqueBehaviorCompositeEditPart.VISUAL_ID == visualID
				|| ComponentCompositeEditPart.VISUAL_ID == visualID || DeviceCompositeEditPart.VISUAL_ID == visualID
				|| ExecutionEnvironmentCompositeEditPart.VISUAL_ID == visualID
				|| NodeCompositeEditPart.VISUAL_ID == visualID || ClassCompositeEditPart.VISUAL_ID == visualID
				|| ClassClassifierEditPart.VISUAL_ID == visualID
				|| CollaborationCompositeEditPart.VISUAL_ID == visualID || InterfaceEditPart.VISUAL_ID == visualID
				|| PrimitiveTypeEditPart.VISUAL_ID == visualID || EnumerationEditPart.VISUAL_ID == visualID
				|| DataTypeEditPart.VISUAL_ID == visualID || ActorEditPart.VISUAL_ID == visualID
				|| DeploymentSpecificationEditPart.VISUAL_ID == visualID || ArtifactEditPart.VISUAL_ID == visualID
				|| InformationItemEditPart.VISUAL_ID == visualID || SignalEditPart.VISUAL_ID == visualID
				|| UseCaseEditPart.VISUAL_ID == visualID || SignalEventEditPart.VISUAL_ID == visualID
				|| CallEventEditPart.VISUAL_ID == visualID || AnyReceiveEventEditPart.VISUAL_ID == visualID
				|| SendSignalEventEditPart.VISUAL_ID == visualID || SendOperationEventEditPart.VISUAL_ID == visualID
				|| ChangeEventEditPart.VISUAL_ID == visualID || TimeEventEditPart.VISUAL_ID == visualID
				|| CreationEventEditPart.VISUAL_ID == visualID || DestructionEventEditPart.VISUAL_ID == visualID
				|| ExecutionEventEditPart.VISUAL_ID == visualID || DurationObservationEditPart.VISUAL_ID == visualID
				|| TimeObservationEditPart.VISUAL_ID == visualID || LiteralBooleanEditPart.VISUAL_ID == visualID
				|| LiteralIntegerEditPart.VISUAL_ID == visualID || LiteralNullEditPart.VISUAL_ID == visualID
				|| LiteralStringEditPart.VISUAL_ID == visualID || LiteralUnlimitedNaturalEditPart.VISUAL_ID == visualID
				|| StringExpressionEditPart.VISUAL_ID == visualID || OpaqueExpressionEditPart.VISUAL_ID == visualID
				|| TimeExpressionEditPart.VISUAL_ID == visualID || ExpressionEditPart.VISUAL_ID == visualID
				|| DurationEditPart.VISUAL_ID == visualID || TimeIntervalEditPart.VISUAL_ID == visualID
				|| DurationIntervalEditPart.VISUAL_ID == visualID || IntervalEditPart.VISUAL_ID == visualID
				|| InstanceValueEditPart.VISUAL_ID == visualID || CommentEditPart.VISUAL_ID == visualID
				|| DurationConstraintEditPart.VISUAL_ID == visualID || TimeConstraintEditPart.VISUAL_ID == visualID
				|| IntervalConstraintEditPart.VISUAL_ID == visualID
				|| InteractionConstraintEditPart.VISUAL_ID == visualID || ConstraintEditPart.VISUAL_ID == visualID
				|| PortEditPart.VISUAL_ID == visualID || PropertyPartEditPartCN.VISUAL_ID == visualID
				|| CollaborationRoleEditPartCN.VISUAL_ID == visualID
				|| CollaborationUseEditPartCN.VISUAL_ID == visualID
				|| ActivityCompositeEditPartCN.VISUAL_ID == visualID
				|| InteractionCompositeEditPartCN.VISUAL_ID == visualID
				|| ProtocolStateMachineCompositeEditPartCN.VISUAL_ID == visualID
				|| StateMachineCompositeEditPartCN.VISUAL_ID == visualID
				|| FunctionBehaviorCompositeEditPartCN.VISUAL_ID == visualID
				|| OpaqueBehaviorCompositeEditPartCN.VISUAL_ID == visualID
				|| ComponentCompositeEditPartCN.VISUAL_ID == visualID
				|| DeviceCompositeEditPartCN.VISUAL_ID == visualID
				|| ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID == visualID
				|| NodeCompositeEditPartCN.VISUAL_ID == visualID || ClassCompositeEditPartCN.VISUAL_ID == visualID
				|| CollaborationCompositeEditPartCN.VISUAL_ID == visualID || InterfaceEditPartCN.VISUAL_ID == visualID
				|| PrimitiveTypeEditPartCN.VISUAL_ID == visualID || EnumerationEditPartCN.VISUAL_ID == visualID
				|| DataTypeEditPartCN.VISUAL_ID == visualID || ActorEditPartCN.VISUAL_ID == visualID
				|| DeploymentSpecificationEditPartCN.VISUAL_ID == visualID || ArtifactEditPartCN.VISUAL_ID == visualID
				|| InformationItemEditPartCN.VISUAL_ID == visualID || SignalEditPartCN.VISUAL_ID == visualID
				|| UseCaseEditPartCN.VISUAL_ID == visualID || CommentEditPartCN.VISUAL_ID == visualID
				|| PropertyEditPartCLN.VISUAL_ID == visualID || OperationEditPartCLN.VISUAL_ID == visualID
				|| ReceptionEditPartCLN.VISUAL_ID == visualID || EnumerationLiteralEditPartCLN.VISUAL_ID == visualID
				|| ActivityEditPartCLN.VISUAL_ID == visualID || InteractionEditPartCLN.VISUAL_ID == visualID
				|| ProtocolStateMachineEditPartCLN.VISUAL_ID == visualID
				|| StateMachineEditPartCLN.VISUAL_ID == visualID || FunctionBehaviorEditPartCLN.VISUAL_ID == visualID
				|| OpaqueBehaviorEditPartCLN.VISUAL_ID == visualID || CollaborationEditPartCLN.VISUAL_ID == visualID
				|| InterfaceEditPartCLN.VISUAL_ID == visualID || EnumerationEditPartCLN.VISUAL_ID == visualID
				|| PrimitiveTypeEditPartCLN.VISUAL_ID == visualID || DataTypeEditPartCLN.VISUAL_ID == visualID
				|| ClassEditPartCLN.VISUAL_ID == visualID;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateEdgeViewOperation op) {
		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		if(!SysmlElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
			return false; // foreign element type
		}
		String elementTypeHint = ((IHintedType)elementType).getSemanticHint();
		if(elementTypeHint == null || (op.getSemanticHint() != null && !elementTypeHint.equals(op.getSemanticHint()))) {
			return false; // our hint is visual id and must be specified, and it should be the same
			// as in element type
		}
		int visualID = SysmlVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(op.getSemanticAdapter());
		if(domainElement != null && visualID != SysmlVisualIDRegistry.getLinkWithClassVisualID(domainElement)) {
			return false; // visual id for link EClass should match visual id from element type
		}
		return true;
	}

	/**
	 * @generated
	 */
	public Diagram createDiagram(IAdaptable semanticAdapter, String diagramKind, PreferencesHint preferencesHint) {
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		diagram.getStyles().add(NotationFactory.eINSTANCE.createDiagramStyle());
		diagram.setType(ResourceEditPart.MODEL_ID);
		diagram.setElement(getSemanticElement(semanticAdapter));
		diagram.setMeasurementUnit(MeasurementUnit.PIXEL_LITERAL);
		return diagram;
	}

	/**
	 * @generated NOT
	 */
	public Node createNode(IAdaptable semanticAdapter, View containerView, String semanticHint, int index,
			boolean persisted, PreferencesHint preferencesHint) {
		final EObject domainElement = getSemanticElement(semanticAdapter);
		final int visualID;
		if(semanticHint == null) {
			visualID = SysmlVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		} else {
			visualID = SysmlVisualIDRegistry.getVisualID(semanticHint);
		}
		switch(visualID) {
		case FlowPortEditPart.VISUAL_ID:
			return createFlowPort_2001(domainElement, containerView, index, persisted, preferencesHint);
		}
		String oldType = containerView.getType();
		containerView.setType(PackageEditPart.MODEL_ID);
		Node node = super.createNode(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);
		if(node.getElement().eClass() == PortandflowsPackage.Literals.FLOW_PORT) {
			node.setElement(((FlowPort)node.getElement()).getBase_Port());
		}
		containerView.setType(oldType);
		return node;
	}

	/**
	 * Add return super in case we are in a composite diagram
	 * 
	 * @generated NOT
	 */
	public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index,
			boolean persisted, PreferencesHint preferencesHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		String elementTypeHint = ((IHintedType)elementType).getSemanticHint();
		switch(SysmlVisualIDRegistry.getVisualID(elementTypeHint)) {
		}
		// can never happen, provided #provides(CreateEdgeViewOperation) is correct
		return super.createEdge(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);
	}

	/**
	 * @generated
	 */
	public Node createFlowPort_2001(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(SysmlVisualIDRegistry.getType(FlowPortEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(((FlowPort)domainElement).getBase_Port());
		stampShortcut(containerView, node);
		// initializeFromPreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		initForegroundFromPrefs(node, prefStore, "Port");

		initBackgroundFromPrefs(node, prefStore, "Port");

		Node label5125 = createLabel(node, UMLVisualIDRegistry.getType(PortNameEditPart.VISUAL_ID));
		label5125.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5125 = (Location)label5125.getLayoutConstraint();
		location5125.setX(0);
		location5125.setY(5);
		Node label6029 = createLabel(node, UMLVisualIDRegistry.getType(PortAppliedStereotypeEditPart.VISUAL_ID));
		label6029.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6029 = (Location)label6029.getLayoutConstraint();
		location6029.setX(0);
		location6029.setY(5);
		return node;
		// org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
		// IPreferenceConstants.PREF_LINE_COLOR);
		// ViewUtil.setStructuralFeatureValue(node,
		// NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities
		// .RGBToInteger(lineRGB));
		// FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		// if (nodeFontStyle != null) {
		// FontData fontData = PreferenceConverter.getFontData(prefStore,
		// IPreferenceConstants.PREF_DEFAULT_FONT);
		// nodeFontStyle.setFontName(fontData.getName());
		// nodeFontStyle.setFontHeight(fontData.getHeight());
		// nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
		// nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
		// org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
		// IPreferenceConstants.PREF_FONT_COLOR);
		// nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		// }
		// org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
		// IPreferenceConstants.PREF_FILL_COLOR);
		// ViewUtil.setStructuralFeatureValue(node,
		// NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities
		// .RGBToInteger(fillRGB));
		// return node;
	}

	/**
	 * @generated
	 */
	private Node createLabel(View owner, String hint) {
		DecorationNode rv = NotationFactory.eINSTANCE.createDecorationNode();
		rv.setType(hint);
		ViewUtil.insertChildView(owner, rv, ViewUtil.APPEND, true);
		return rv;
	}

	/**
	 * @generated
	 */
	private void stampShortcut(View containerView, Node target) {
		if(!ResourceEditPart.MODEL_ID.equals(SysmlVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", ResourceEditPart.MODEL_ID); //$NON-NLS-1$
			target.getEAnnotations().add(shortcutAnnotation);
		}
	}

	/**
	 * @generated
	 */
	private EObject getSemanticElement(IAdaptable semanticAdapter) {
		if(semanticAdapter == null) {
			return null;
		}
		EObject eObject = (EObject)semanticAdapter.getAdapter(EObject.class);
		if(eObject != null) {
			return EMFCoreUtil.resolve(TransactionUtil.getEditingDomain(eObject), eObject);
		}
		return null;
	}

	/**
	 * @generated
	 */
	private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if(semanticAdapter == null) {
			return null;
		}
		return (IElementType)semanticAdapter.getAdapter(IElementType.class);
	}

	private void initFontStyleFromPrefs(View view, final IPreferenceStore store, String elementName) {
		String fontConstant = PreferenceConstantHelper.getElementConstant(elementName, PreferenceConstantHelper.FONT);
		String fontColorConstant = PreferenceConstantHelper.getElementConstant(elementName,
				PreferenceConstantHelper.COLOR_FONT);

		FontStyle viewFontStyle = (FontStyle)view.getStyle(NotationPackage.Literals.FONT_STYLE);
		if(viewFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(store, fontConstant);
			viewFontStyle.setFontName(fontData.getName());
			viewFontStyle.setFontHeight(fontData.getHeight());
			viewFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			viewFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);

			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(store, fontColorConstant);
			viewFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
	}

	private void initForegroundFromPrefs(View view, final IPreferenceStore store, String elementName) {
		String lineColorConstant = PreferenceConstantHelper.getElementConstant(elementName,
				PreferenceConstantHelper.COLOR_LINE);
		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(store, lineColorConstant);
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities
				.RGBToInteger(lineRGB));
	}

	private void initBackgroundFromPrefs(View view, final IPreferenceStore store, String elementName) {
		String fillColorConstant = PreferenceConstantHelper.getElementConstant(elementName,
				PreferenceConstantHelper.COLOR_FILL);
		String gradientColorConstant = PreferenceConstantHelper.getElementConstant(elementName,
				PreferenceConstantHelper.COLOR_GRADIENT);
		String gradientPolicyConstant = PreferenceConstantHelper.getElementConstant(elementName,
				PreferenceConstantHelper.GRADIENT_POLICY);

		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(store, fillColorConstant);
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities
				.RGBToInteger(fillRGB));

		FillStyle fillStyle = (FillStyle)view.getStyle(NotationPackage.Literals.FILL_STYLE);
		fillStyle.setFillColor(FigureUtilities.RGBToInteger(fillRGB).intValue());

		;
		if(store.getBoolean(gradientPolicyConstant)) {
			GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(store
					.getString(gradientColorConstant));
			fillStyle.setGradient(gradientPreferenceConverter.getGradientData());
			fillStyle.setTransparency(gradientPreferenceConverter.getTransparency());
		}
	}
}
