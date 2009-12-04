package org.eclipse.papyrus.diagram.activity.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditor;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.common.providers.BaseModelTypeProvider;
import org.eclipse.papyrus.diagram.common.providers.ModelTypesProviderFactory;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLElementTypes extends ElementInitializers {

	/**
	 * @generated
	 */
	private UMLElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IHintedType Package_79 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.Package_79"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Activity_1001 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.Activity_1001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType SendObjectAction_2001 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.SendObjectAction_2001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType InputPin_2002 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.InputPin_2002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType InputPin_2003 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.InputPin_2003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ValuePin_2004 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.ValuePin_2004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType SendSignalAction_2005 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.SendSignalAction_2005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType InputPin_2006 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.InputPin_2006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType AcceptEventAction_2007 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.AcceptEventAction_2007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType OutputPin_2008 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.OutputPin_2008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ActivityFinalNode_2009 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.ActivityFinalNode_2009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType DecisionNode_2010 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.DecisionNode_2010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType MergeNode_2011 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.MergeNode_2011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType InitialNode_2012 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.InitialNode_2012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType DataStoreNode_2013 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.DataStoreNode_2013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType OpaqueAction_2014 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.OpaqueAction_2014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType OutputPin_2015 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.OutputPin_2015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType InputPin_2016 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.InputPin_2016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ValuePin_2017 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.ValuePin_2017"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType FlowFinalNode_2018 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.FlowFinalNode_2018"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ForkNode_2019 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.ForkNode_2019"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType JoinNode_2020 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.JoinNode_2020"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Pin_2021 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.Pin_2021"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType CreateObjectAction_2022 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.CreateObjectAction_2022"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType OutputPin_2023 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.OutputPin_2023"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType CallBehaviorAction_2024 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.CallBehaviorAction_2024"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType OutputPin_2025 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.OutputPin_2025"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType InputPin_2026 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.InputPin_2026"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType CallOperationAction_2027 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.CallOperationAction_2027"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType InputPin_2028 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.InputPin_2028"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ActivityParameterNode_2029 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.ActivityParameterNode_2029"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ActivityPartition_2030 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.ActivityPartition_2030"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ActivityPartition_2031 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.ActivityPartition_2031"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType OpaqueAction_2032 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.OpaqueAction_2032"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType AcceptEventAction_2033 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.AcceptEventAction_2033"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType Comment_2034 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.Comment_2034"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ControlFlow_3001 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.ControlFlow_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ObjectFlow_3002 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.ObjectFlow_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ObjectNodeSelection_3003 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.ObjectNodeSelection_3003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ExceptionHandler_3004 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.ExceptionHandler_3004"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType ElementOwnedComment_3005 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.ElementOwnedComment_3005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IHintedType CommentAnnotatedElement_3006 = (IHintedType) getElementType("org.eclipse.papyrus.diagram.activity.CommentAnnotatedElement_3006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass && !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return UMLDiagramEditorPlugin.getInstance().getItemImageDescriptor(eClass.getEPackage().getEFactoryInstance().create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap();

			elements.put(Package_79, UMLPackage.eINSTANCE.getPackage());

			elements.put(Activity_1001, UMLPackage.eINSTANCE.getActivity());

			elements.put(Comment_2034, UMLPackage.eINSTANCE.getComment());

			elements.put(SendObjectAction_2001, UMLPackage.eINSTANCE.getSendObjectAction());

			elements.put(InputPin_2002, UMLPackage.eINSTANCE.getInputPin());

			elements.put(InputPin_2003, UMLPackage.eINSTANCE.getInputPin());

			elements.put(ValuePin_2004, UMLPackage.eINSTANCE.getValuePin());

			elements.put(SendSignalAction_2005, UMLPackage.eINSTANCE.getSendSignalAction());

			elements.put(InputPin_2006, UMLPackage.eINSTANCE.getInputPin());

			elements.put(AcceptEventAction_2007, UMLPackage.eINSTANCE.getAcceptEventAction());

			elements.put(OutputPin_2008, UMLPackage.eINSTANCE.getOutputPin());

			elements.put(ActivityFinalNode_2009, UMLPackage.eINSTANCE.getActivityFinalNode());

			elements.put(DecisionNode_2010, UMLPackage.eINSTANCE.getDecisionNode());

			elements.put(MergeNode_2011, UMLPackage.eINSTANCE.getMergeNode());

			elements.put(InitialNode_2012, UMLPackage.eINSTANCE.getInitialNode());

			elements.put(DataStoreNode_2013, UMLPackage.eINSTANCE.getDataStoreNode());

			elements.put(OpaqueAction_2014, UMLPackage.eINSTANCE.getOpaqueAction());

			elements.put(OutputPin_2015, UMLPackage.eINSTANCE.getOutputPin());

			elements.put(InputPin_2016, UMLPackage.eINSTANCE.getInputPin());

			elements.put(ValuePin_2017, UMLPackage.eINSTANCE.getValuePin());

			elements.put(FlowFinalNode_2018, UMLPackage.eINSTANCE.getFlowFinalNode());

			elements.put(ForkNode_2019, UMLPackage.eINSTANCE.getForkNode());

			elements.put(JoinNode_2020, UMLPackage.eINSTANCE.getJoinNode());

			elements.put(Pin_2021, UMLPackage.eINSTANCE.getPin());

			elements.put(CreateObjectAction_2022, UMLPackage.eINSTANCE.getCreateObjectAction());

			elements.put(OutputPin_2023, UMLPackage.eINSTANCE.getOutputPin());

			elements.put(CallBehaviorAction_2024, UMLPackage.eINSTANCE.getCallBehaviorAction());

			elements.put(OutputPin_2025, UMLPackage.eINSTANCE.getOutputPin());

			elements.put(InputPin_2026, UMLPackage.eINSTANCE.getInputPin());

			elements.put(CallOperationAction_2027, UMLPackage.eINSTANCE.getCallOperationAction());

			elements.put(InputPin_2028, UMLPackage.eINSTANCE.getInputPin());

			elements.put(ActivityParameterNode_2029, UMLPackage.eINSTANCE.getActivityParameterNode());

			elements.put(ActivityPartition_2030, UMLPackage.eINSTANCE.getActivityPartition());

			elements.put(ActivityPartition_2031, UMLPackage.eINSTANCE.getActivityPartition());

			elements.put(OpaqueAction_2032, UMLPackage.eINSTANCE.getOpaqueAction());

			elements.put(AcceptEventAction_2033, UMLPackage.eINSTANCE.getAcceptEventAction());

			elements.put(ControlFlow_3001, UMLPackage.eINSTANCE.getControlFlow());

			elements.put(ObjectFlow_3002, UMLPackage.eINSTANCE.getObjectFlow());

			elements.put(ObjectNodeSelection_3003, UMLPackage.eINSTANCE.getObjectNode_Selection());

			elements.put(ExceptionHandler_3004, UMLPackage.eINSTANCE.getExceptionHandler());

			elements.put(ElementOwnedComment_3005, UMLPackage.eINSTANCE.getElement_OwnedComment());

			elements.put(CommentAnnotatedElement_3006, UMLPackage.eINSTANCE.getComment_AnnotatedElement());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet();
			KNOWN_ELEMENT_TYPES.add(Package_79);
			KNOWN_ELEMENT_TYPES.add(Activity_1001);
			KNOWN_ELEMENT_TYPES.add(Comment_2034);
			KNOWN_ELEMENT_TYPES.add(SendObjectAction_2001);
			KNOWN_ELEMENT_TYPES.add(InputPin_2002);
			KNOWN_ELEMENT_TYPES.add(InputPin_2003);
			KNOWN_ELEMENT_TYPES.add(ValuePin_2004);
			KNOWN_ELEMENT_TYPES.add(SendSignalAction_2005);
			KNOWN_ELEMENT_TYPES.add(InputPin_2006);
			KNOWN_ELEMENT_TYPES.add(AcceptEventAction_2007);
			KNOWN_ELEMENT_TYPES.add(OutputPin_2008);
			KNOWN_ELEMENT_TYPES.add(ActivityFinalNode_2009);
			KNOWN_ELEMENT_TYPES.add(DecisionNode_2010);
			KNOWN_ELEMENT_TYPES.add(MergeNode_2011);
			KNOWN_ELEMENT_TYPES.add(InitialNode_2012);
			KNOWN_ELEMENT_TYPES.add(DataStoreNode_2013);
			KNOWN_ELEMENT_TYPES.add(OpaqueAction_2014);
			KNOWN_ELEMENT_TYPES.add(OutputPin_2015);
			KNOWN_ELEMENT_TYPES.add(InputPin_2016);
			KNOWN_ELEMENT_TYPES.add(ValuePin_2017);
			KNOWN_ELEMENT_TYPES.add(FlowFinalNode_2018);
			KNOWN_ELEMENT_TYPES.add(ForkNode_2019);
			KNOWN_ELEMENT_TYPES.add(JoinNode_2020);
			KNOWN_ELEMENT_TYPES.add(Pin_2021);
			KNOWN_ELEMENT_TYPES.add(CreateObjectAction_2022);
			KNOWN_ELEMENT_TYPES.add(OutputPin_2023);
			KNOWN_ELEMENT_TYPES.add(CallBehaviorAction_2024);
			KNOWN_ELEMENT_TYPES.add(OutputPin_2025);
			KNOWN_ELEMENT_TYPES.add(InputPin_2026);
			KNOWN_ELEMENT_TYPES.add(CallOperationAction_2027);
			KNOWN_ELEMENT_TYPES.add(InputPin_2028);
			KNOWN_ELEMENT_TYPES.add(ActivityParameterNode_2029);
			KNOWN_ELEMENT_TYPES.add(ActivityPartition_2030);
			KNOWN_ELEMENT_TYPES.add(ActivityPartition_2031);
			KNOWN_ELEMENT_TYPES.add(OpaqueAction_2032);
			KNOWN_ELEMENT_TYPES.add(AcceptEventAction_2033);
			KNOWN_ELEMENT_TYPES.add(ControlFlow_3001);
			KNOWN_ELEMENT_TYPES.add(ObjectFlow_3002);
			KNOWN_ELEMENT_TYPES.add(ObjectNodeSelection_3003);
			KNOWN_ELEMENT_TYPES.add(ExceptionHandler_3004);
			KNOWN_ELEMENT_TYPES.add(ElementOwnedComment_3005);
			KNOWN_ELEMENT_TYPES.add(CommentAnnotatedElement_3006);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static void refreshImageRegistry() {
		if (imageRegistry != null) {
			imageRegistry.dispose();
			imageRegistry = null;
		}
		imageRegistry = new ImageRegistry();
	}

	/**
	 * @generated
	 */
	static {
		ModelTypesProviderFactory.registerModelTypesProvider(UMLDiagramEditor.ID, new BaseModelTypeProvider() {

			@Override
			public Image getImageHelper(IAdaptable hint) {
				return getImage(hint);
			}
		});
	}

}
