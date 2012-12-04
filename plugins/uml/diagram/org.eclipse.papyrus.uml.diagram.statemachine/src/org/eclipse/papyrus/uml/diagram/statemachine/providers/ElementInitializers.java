package org.eclipse.papyrus.uml.diagram.statemachine.providers;

import java.util.Iterator;

import org.eclipse.papyrus.uml.diagram.common.helper.NamedElementHelper;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.expressions.UMLAbstractExpression;
import org.eclipse.papyrus.uml.diagram.statemachine.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConnectionPointReference;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * @generated
 */
public class ElementInitializers {

	/**
	 * @generated
	 */
	public static ElementInitializers getInstance() {
		ElementInitializers cached = UMLDiagramEditorPlugin.getInstance().getElementInitializers();
		if(cached == null) {
			UMLDiagramEditorPlugin.getInstance().setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}

	/**
	 * Custom code
	 * 
	 * @param self
	 * @return
	 */
	private static String getName(org.eclipse.uml2.uml.Element self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	 * @generated
	 */
	public void init_ConnectionPointReference_18000(ConnectionPointReference instance) {
		try {
			Object value_0 = name_ConnectionPointReference_18000(instance);
			instance.setName((java.lang.String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Comment_666(Comment instance) {
		try {
			Object value_0 = body_Comment_666(instance);
			instance.setBody((java.lang.String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Constraint_668(Constraint instance) {
		try {
			Object value_0 = name_Constraint_668(instance);
			instance.setName((java.lang.String)value_0);
			Object value_1 = specification_Constraint_668(instance);
			instance.setSpecification((ValueSpecification)value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Transition_680(Transition instance) {
		try {
			Object value_0 = name_Transition_680(instance);
			instance.setName((java.lang.String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_FinalState_5000(FinalState instance) {
		try {
			Object value_0 = name_FinalState_5000(instance);
			instance.setName((java.lang.String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Pseudostate_10000(Pseudostate instance) {
		try {
			Object value_0 = kind_Pseudostate_10000(instance);
			value_0 = UMLAbstractExpression.performCast(value_0, UMLPackage.eINSTANCE.getPseudostateKind());
			instance.setKind((PseudostateKind)value_0);
			Object value_1 = name_Pseudostate_10000(instance);
			instance.setName((java.lang.String)value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Pseudostate_11000(Pseudostate instance) {
		try {
			Object value_0 = kind_Pseudostate_11000(instance);
			value_0 = UMLAbstractExpression.performCast(value_0, UMLPackage.eINSTANCE.getPseudostateKind());
			instance.setKind((PseudostateKind)value_0);
			Object value_1 = name_Pseudostate_11000(instance);
			instance.setName((java.lang.String)value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Pseudostate_12000(Pseudostate instance) {
		try {
			Object value_0 = kind_Pseudostate_12000(instance);
			value_0 = UMLAbstractExpression.performCast(value_0, UMLPackage.eINSTANCE.getPseudostateKind());
			instance.setKind((PseudostateKind)value_0);
			Object value_1 = name_Pseudostate_12000(instance);
			instance.setName((java.lang.String)value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Pseudostate_13000(Pseudostate instance) {
		try {
			Object value_0 = kind_Pseudostate_13000(instance);
			value_0 = UMLAbstractExpression.performCast(value_0, UMLPackage.eINSTANCE.getPseudostateKind());
			instance.setKind((PseudostateKind)value_0);
			Object value_1 = name_Pseudostate_13000(instance);
			instance.setName((java.lang.String)value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Pseudostate_14000(Pseudostate instance) {
		try {
			Object value_0 = kind_Pseudostate_14000(instance);
			value_0 = UMLAbstractExpression.performCast(value_0, UMLPackage.eINSTANCE.getPseudostateKind());
			instance.setKind((PseudostateKind)value_0);
			Object value_1 = name_Pseudostate_14000(instance);
			instance.setName((java.lang.String)value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Pseudostate_15000(Pseudostate instance) {
		try {
			Object value_0 = kind_Pseudostate_15000(instance);
			value_0 = UMLAbstractExpression.performCast(value_0, UMLPackage.eINSTANCE.getPseudostateKind());
			instance.setKind((PseudostateKind)value_0);
			Object value_1 = name_Pseudostate_15000(instance);
			instance.setName((java.lang.String)value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Pseudostate_16000(Pseudostate instance) {
		try {
			Object value_0 = kind_Pseudostate_16000(instance);
			value_0 = UMLAbstractExpression.performCast(value_0, UMLPackage.eINSTANCE.getPseudostateKind());
			instance.setKind((PseudostateKind)value_0);
			Object value_1 = name_Pseudostate_16000(instance);
			instance.setName((java.lang.String)value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Pseudostate_17000(Pseudostate instance) {
		try {
			Object value_0 = kind_Pseudostate_17000(instance);
			value_0 = UMLAbstractExpression.performCast(value_0, UMLPackage.eINSTANCE.getPseudostateKind());
			instance.setKind((PseudostateKind)value_0);
			Object value_1 = name_Pseudostate_17000(instance);
			instance.setName((java.lang.String)value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Pseudostate_8000(Pseudostate instance) {
		try {
			Object value_0 = kind_Pseudostate_8000(instance);
			value_0 = UMLAbstractExpression.performCast(value_0, UMLPackage.eINSTANCE.getPseudostateKind());
			instance.setKind((PseudostateKind)value_0);
			Object value_1 = name_Pseudostate_8000(instance);
			instance.setName((java.lang.String)value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Pseudostate_9000(Pseudostate instance) {
		try {
			Object value_0 = kind_Pseudostate_9000(instance);
			value_0 = UMLAbstractExpression.performCast(value_0, UMLPackage.eINSTANCE.getPseudostateKind());
			instance.setKind((PseudostateKind)value_0);
			Object value_1 = name_Pseudostate_9000(instance);
			instance.setName((java.lang.String)value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Region_3000(Region instance) {
		try {
			Object value_0 = name_Region_3000(instance);
			instance.setName((java.lang.String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_State_6000(State instance) {
		try {
			Object value_0 = name_State_6000(instance);
			instance.setName((java.lang.String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_StateMachine_2000(StateMachine instance) {
		try {
			Object value_0 = name_StateMachine_2000(instance);
			instance.setName((java.lang.String)value_0);
			Region newInstance_1_0 = UMLFactory.eINSTANCE.createRegion();
			instance.getRegions().add(newInstance_1_0);
			Object value_1_0_0 = name_region_StateMachine_2000(newInstance_1_0);
			newInstance_1_0.setName((java.lang.String)value_1_0_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Transition_7000(Transition instance) {
		try {
			Object value_0 = name_Transition_7000(instance);
			instance.setName((java.lang.String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	private PseudostateKind kind_Pseudostate_10000(Pseudostate self) {
		return PseudostateKind.FORK_LITERAL;
	}

	/**
	 * @generated
	 */
	private PseudostateKind kind_Pseudostate_11000(Pseudostate self) {
		return PseudostateKind.CHOICE_LITERAL;
	}

	/**
	 * @generated
	 */
	private PseudostateKind kind_Pseudostate_12000(Pseudostate self) {
		return PseudostateKind.JUNCTION_LITERAL;
	}

	/**
	 * @generated
	 */
	private PseudostateKind kind_Pseudostate_13000(Pseudostate self) {
		return PseudostateKind.SHALLOW_HISTORY_LITERAL;
	}

	/**
	 * @generated
	 */
	private PseudostateKind kind_Pseudostate_14000(Pseudostate self) {
		return PseudostateKind.DEEP_HISTORY_LITERAL;
	}

	/**
	 * @generated
	 */
	private PseudostateKind kind_Pseudostate_15000(Pseudostate self) {
		return PseudostateKind.TERMINATE_LITERAL;
	}

	/**
	 * @generated
	 */
	private PseudostateKind kind_Pseudostate_16000(Pseudostate self) {
		return PseudostateKind.ENTRY_POINT_LITERAL;
	}

	/**
	 * @generated
	 */
	private PseudostateKind kind_Pseudostate_17000(Pseudostate self) {
		return PseudostateKind.EXIT_POINT_LITERAL;
	}

	/**
	 * @generated
	 */
	private PseudostateKind kind_Pseudostate_8000(Pseudostate self) {
		return PseudostateKind.INITIAL_LITERAL;
	}

	/**
	 * @generated
	 */
	private PseudostateKind kind_Pseudostate_9000(Pseudostate self) {
		return PseudostateKind.JOIN_LITERAL;
	}

	/**
	 * @generated
	 */
	private java.lang.String name_ConnectionPointReference_18000(ConnectionPointReference self) {
		//provides a new name taking into account the pseudostatekind if any
		String baseString = self.eClass().getName();
		if(self instanceof Pseudostate) {
			baseString = ((Pseudostate)self).getKind().getLiteral();
			baseString = baseString.substring(0, 1).toUpperCase() + baseString.substring(1);
		}
		String name = ""; //$NON-NLS-1$
		Element umlParent = self.getOwner();
		boolean found = false;
		// i <10000: avoid infinite loops
		for(int i = 0; i < 10001; i++) {
			found = false;
			name = baseString + i;
			Iterator it = umlParent.getOwnedElements().iterator();
			while(it.hasNext() && !found) {
				Object o = it.next();
				if(o instanceof NamedElement) {
					if(name.equals(((NamedElement)o).getName())) {
						found = true;
					}
				}
			}
			if(!found) {
				return name;
			}
		}
		return baseString + "X"; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private java.lang.String body_Comment_666(Comment self) {
		// TODO: implement this method to return value  
		// for org.eclipse.uml2.uml.UMLPackage.eINSTANCE.getComment_Body()
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException("No user java implementation provided in 'body_Comment_666' operation"); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private java.lang.String name_Constraint_668(Constraint self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());
	}

	/**
	 * @generated
	 */
	private ValueSpecification specification_Constraint_668(Constraint self) {
		LiteralString literalString = UMLFactory.eINSTANCE.createLiteralString();
		literalString.setValue("");
		return literalString;
	}

	/**
	 * @generated
	 */
	private java.lang.String name_Transition_680(Transition self) {
		//provides a new name taking into account the pseudostatekind if any
		String baseString = self.eClass().getName();
		if(self instanceof Pseudostate) {
			baseString = ((Pseudostate)self).getKind().getLiteral();
			baseString = baseString.substring(0, 1).toUpperCase() + baseString.substring(1);
		}
		String name = ""; //$NON-NLS-1$
		Element umlParent = self.getOwner();
		boolean found = false;
		// i <10000: avoid infinite loops
		for(int i = 0; i < 10001; i++) {
			found = false;
			name = baseString + i;
			Iterator it = umlParent.getOwnedElements().iterator();
			while(it.hasNext() && !found) {
				Object o = it.next();
				if(o instanceof NamedElement) {
					if(name.equals(((NamedElement)o).getName())) {
						found = true;
					}
				}
			}
			if(!found) {
				return name;
			}
		}
		return baseString + "X"; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private java.lang.String name_FinalState_5000(FinalState self) {
		//provides a new name taking into account the pseudostatekind if any
		String baseString = self.eClass().getName();
		if(self instanceof Pseudostate) {
			baseString = ((Pseudostate)self).getKind().getLiteral();
			baseString = baseString.substring(0, 1).toUpperCase() + baseString.substring(1);
		}
		String name = ""; //$NON-NLS-1$
		Element umlParent = self.getOwner();
		boolean found = false;
		// i <10000: avoid infinite loops
		for(int i = 0; i < 10001; i++) {
			found = false;
			name = baseString + i;
			Iterator it = umlParent.getOwnedElements().iterator();
			while(it.hasNext() && !found) {
				Object o = it.next();
				if(o instanceof NamedElement) {
					if(name.equals(((NamedElement)o).getName())) {
						found = true;
					}
				}
			}
			if(!found) {
				return name;
			}
		}
		return baseString + "X"; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private java.lang.String name_Pseudostate_10000(Pseudostate self) {
		//provides a new name taking into account the pseudostatekind if any
		String baseString = self.eClass().getName();
		if(self instanceof Pseudostate) {
			baseString = ((Pseudostate)self).getKind().getLiteral();
			baseString = baseString.substring(0, 1).toUpperCase() + baseString.substring(1);
		}
		String name = ""; //$NON-NLS-1$
		Element umlParent = self.getOwner();
		boolean found = false;
		// i <10000: avoid infinite loops
		for(int i = 0; i < 10001; i++) {
			found = false;
			name = baseString + i;
			Iterator it = umlParent.getOwnedElements().iterator();
			while(it.hasNext() && !found) {
				Object o = it.next();
				if(o instanceof NamedElement) {
					if(name.equals(((NamedElement)o).getName())) {
						found = true;
					}
				}
			}
			if(!found) {
				return name;
			}
		}
		return baseString + "X"; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private java.lang.String name_Pseudostate_11000(Pseudostate self) {
		//provides a new name taking into account the pseudostatekind if any
		String baseString = self.eClass().getName();
		if(self instanceof Pseudostate) {
			baseString = ((Pseudostate)self).getKind().getLiteral();
			baseString = baseString.substring(0, 1).toUpperCase() + baseString.substring(1);
		}
		String name = ""; //$NON-NLS-1$
		Element umlParent = self.getOwner();
		boolean found = false;
		// i <10000: avoid infinite loops
		for(int i = 0; i < 10001; i++) {
			found = false;
			name = baseString + i;
			Iterator it = umlParent.getOwnedElements().iterator();
			while(it.hasNext() && !found) {
				Object o = it.next();
				if(o instanceof NamedElement) {
					if(name.equals(((NamedElement)o).getName())) {
						found = true;
					}
				}
			}
			if(!found) {
				return name;
			}
		}
		return baseString + "X"; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private java.lang.String name_Pseudostate_12000(Pseudostate self) {
		//provides a new name taking into account the pseudostatekind if any
		String baseString = self.eClass().getName();
		if(self instanceof Pseudostate) {
			baseString = ((Pseudostate)self).getKind().getLiteral();
			baseString = baseString.substring(0, 1).toUpperCase() + baseString.substring(1);
		}
		String name = ""; //$NON-NLS-1$
		Element umlParent = self.getOwner();
		boolean found = false;
		// i <10000: avoid infinite loops
		for(int i = 0; i < 10001; i++) {
			found = false;
			name = baseString + i;
			Iterator it = umlParent.getOwnedElements().iterator();
			while(it.hasNext() && !found) {
				Object o = it.next();
				if(o instanceof NamedElement) {
					if(name.equals(((NamedElement)o).getName())) {
						found = true;
					}
				}
			}
			if(!found) {
				return name;
			}
		}
		return baseString + "X"; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private java.lang.String name_Pseudostate_13000(Pseudostate self) {
		//provides a new name taking into account the pseudostatekind if any
		String baseString = self.eClass().getName();
		if(self instanceof Pseudostate) {
			baseString = ((Pseudostate)self).getKind().getLiteral();
			baseString = baseString.substring(0, 1).toUpperCase() + baseString.substring(1);
		}
		String name = ""; //$NON-NLS-1$
		Element umlParent = self.getOwner();
		boolean found = false;
		// i <10000: avoid infinite loops
		for(int i = 0; i < 10001; i++) {
			found = false;
			name = baseString + i;
			Iterator it = umlParent.getOwnedElements().iterator();
			while(it.hasNext() && !found) {
				Object o = it.next();
				if(o instanceof NamedElement) {
					if(name.equals(((NamedElement)o).getName())) {
						found = true;
					}
				}
			}
			if(!found) {
				return name;
			}
		}
		return baseString + "X"; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private java.lang.String name_Pseudostate_14000(Pseudostate self) {
		//provides a new name taking into account the pseudostatekind if any
		String baseString = self.eClass().getName();
		if(self instanceof Pseudostate) {
			baseString = ((Pseudostate)self).getKind().getLiteral();
			baseString = baseString.substring(0, 1).toUpperCase() + baseString.substring(1);
		}
		String name = ""; //$NON-NLS-1$
		Element umlParent = self.getOwner();
		boolean found = false;
		// i <10000: avoid infinite loops
		for(int i = 0; i < 10001; i++) {
			found = false;
			name = baseString + i;
			Iterator it = umlParent.getOwnedElements().iterator();
			while(it.hasNext() && !found) {
				Object o = it.next();
				if(o instanceof NamedElement) {
					if(name.equals(((NamedElement)o).getName())) {
						found = true;
					}
				}
			}
			if(!found) {
				return name;
			}
		}
		return baseString + "X"; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private java.lang.String name_Pseudostate_15000(Pseudostate self) {
		//provides a new name taking into account the pseudostatekind if any
		String baseString = self.eClass().getName();
		if(self instanceof Pseudostate) {
			baseString = ((Pseudostate)self).getKind().getLiteral();
			baseString = baseString.substring(0, 1).toUpperCase() + baseString.substring(1);
		}
		String name = ""; //$NON-NLS-1$
		Element umlParent = self.getOwner();
		boolean found = false;
		// i <10000: avoid infinite loops
		for(int i = 0; i < 10001; i++) {
			found = false;
			name = baseString + i;
			Iterator it = umlParent.getOwnedElements().iterator();
			while(it.hasNext() && !found) {
				Object o = it.next();
				if(o instanceof NamedElement) {
					if(name.equals(((NamedElement)o).getName())) {
						found = true;
					}
				}
			}
			if(!found) {
				return name;
			}
		}
		return baseString + "X"; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private java.lang.String name_Pseudostate_16000(Pseudostate self) {
		//provides a new name taking into account the pseudostatekind if any
		String baseString = self.eClass().getName();
		if(self instanceof Pseudostate) {
			baseString = ((Pseudostate)self).getKind().getLiteral();
			baseString = baseString.substring(0, 1).toUpperCase() + baseString.substring(1);
		}
		String name = ""; //$NON-NLS-1$
		Element umlParent = self.getOwner();
		boolean found = false;
		// i <10000: avoid infinite loops
		for(int i = 0; i < 10001; i++) {
			found = false;
			name = baseString + i;
			Iterator it = umlParent.getOwnedElements().iterator();
			while(it.hasNext() && !found) {
				Object o = it.next();
				if(o instanceof NamedElement) {
					if(name.equals(((NamedElement)o).getName())) {
						found = true;
					}
				}
			}
			if(!found) {
				return name;
			}
		}
		return baseString + "X"; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private java.lang.String name_Pseudostate_17000(Pseudostate self) {
		//provides a new name taking into account the pseudostatekind if any
		String baseString = self.eClass().getName();
		if(self instanceof Pseudostate) {
			baseString = ((Pseudostate)self).getKind().getLiteral();
			baseString = baseString.substring(0, 1).toUpperCase() + baseString.substring(1);
		}
		String name = ""; //$NON-NLS-1$
		Element umlParent = self.getOwner();
		boolean found = false;
		// i <10000: avoid infinite loops
		for(int i = 0; i < 10001; i++) {
			found = false;
			name = baseString + i;
			Iterator it = umlParent.getOwnedElements().iterator();
			while(it.hasNext() && !found) {
				Object o = it.next();
				if(o instanceof NamedElement) {
					if(name.equals(((NamedElement)o).getName())) {
						found = true;
					}
				}
			}
			if(!found) {
				return name;
			}
		}
		return baseString + "X"; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private java.lang.String name_Pseudostate_8000(Pseudostate self) {
		//provides a new name taking into account the pseudostatekind if any
		String baseString = self.eClass().getName();
		if(self instanceof Pseudostate) {
			baseString = ((Pseudostate)self).getKind().getLiteral();
			baseString = baseString.substring(0, 1).toUpperCase() + baseString.substring(1);
		}
		String name = ""; //$NON-NLS-1$
		Element umlParent = self.getOwner();
		boolean found = false;
		// i <10000: avoid infinite loops
		for(int i = 0; i < 10001; i++) {
			found = false;
			name = baseString + i;
			Iterator it = umlParent.getOwnedElements().iterator();
			while(it.hasNext() && !found) {
				Object o = it.next();
				if(o instanceof NamedElement) {
					if(name.equals(((NamedElement)o).getName())) {
						found = true;
					}
				}
			}
			if(!found) {
				return name;
			}
		}
		return baseString + "X"; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private java.lang.String name_Pseudostate_9000(Pseudostate self) {
		//provides a new name taking into account the pseudostatekind if any
		String baseString = self.eClass().getName();
		if(self instanceof Pseudostate) {
			baseString = ((Pseudostate)self).getKind().getLiteral();
			baseString = baseString.substring(0, 1).toUpperCase() + baseString.substring(1);
		}
		String name = ""; //$NON-NLS-1$
		Element umlParent = self.getOwner();
		boolean found = false;
		// i <10000: avoid infinite loops
		for(int i = 0; i < 10001; i++) {
			found = false;
			name = baseString + i;
			Iterator it = umlParent.getOwnedElements().iterator();
			while(it.hasNext() && !found) {
				Object o = it.next();
				if(o instanceof NamedElement) {
					if(name.equals(((NamedElement)o).getName())) {
						found = true;
					}
				}
			}
			if(!found) {
				return name;
			}
		}
		return baseString + "X"; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private java.lang.String name_Region_3000(Region self) {
		//provides a new name taking into account the pseudostatekind if any
		String baseString = self.eClass().getName();
		if(self instanceof Pseudostate) {
			baseString = ((Pseudostate)self).getKind().getLiteral();
			baseString = baseString.substring(0, 1).toUpperCase() + baseString.substring(1);
		}
		String name = ""; //$NON-NLS-1$
		Element umlParent = self.getOwner();
		boolean found = false;
		// i <10000: avoid infinite loops
		for(int i = 0; i < 10001; i++) {
			found = false;
			name = baseString + i;
			Iterator it = umlParent.getOwnedElements().iterator();
			while(it.hasNext() && !found) {
				Object o = it.next();
				if(o instanceof NamedElement) {
					if(name.equals(((NamedElement)o).getName())) {
						found = true;
					}
				}
			}
			if(!found) {
				return name;
			}
		}
		return baseString + "X"; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private java.lang.String name_region_StateMachine_2000(Region self) {
		//provides a new name taking into account the pseudostatekind if any
		String baseString = self.eClass().getName();
		if(self instanceof Pseudostate) {
			baseString = ((Pseudostate)self).getKind().getLiteral();
			baseString = baseString.substring(0, 1).toUpperCase() + baseString.substring(1);
		}
		String name = ""; //$NON-NLS-1$
		Element umlParent = self.getOwner();
		boolean found = false;
		// i <10000: avoid infinite loops
		for(int i = 0; i < 10001; i++) {
			found = false;
			name = baseString + i;
			Iterator it = umlParent.getOwnedElements().iterator();
			while(it.hasNext() && !found) {
				Object o = it.next();
				if(o instanceof NamedElement) {
					if(name.equals(((NamedElement)o).getName())) {
						found = true;
					}
				}
			}
			if(!found) {
				return name;
			}
		}
		return baseString + "X"; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private java.lang.String name_State_6000(State self) {
		//provides a new name taking into account the pseudostatekind if any
		String baseString = self.eClass().getName();
		if(self instanceof Pseudostate) {
			baseString = ((Pseudostate)self).getKind().getLiteral();
			baseString = baseString.substring(0, 1).toUpperCase() + baseString.substring(1);
		}
		String name = ""; //$NON-NLS-1$
		Element umlParent = self.getOwner();
		boolean found = false;
		// i <10000: avoid infinite loops
		for(int i = 0; i < 10001; i++) {
			found = false;
			name = baseString + i;
			Iterator it = umlParent.getOwnedElements().iterator();
			while(it.hasNext() && !found) {
				Object o = it.next();
				if(o instanceof NamedElement) {
					if(name.equals(((NamedElement)o).getName())) {
						found = true;
					}
				}
			}
			if(!found) {
				return name;
			}
		}
		return baseString + "X"; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private java.lang.String name_StateMachine_2000(StateMachine self) {
		//provides a new name taking into account the pseudostatekind if any
		String baseString = self.eClass().getName();
		if(self instanceof Pseudostate) {
			baseString = ((Pseudostate)self).getKind().getLiteral();
			baseString = baseString.substring(0, 1).toUpperCase() + baseString.substring(1);
		}
		String name = ""; //$NON-NLS-1$
		Element umlParent = self.getOwner();
		boolean found = false;
		// i <10000: avoid infinite loops
		for(int i = 0; i < 10001; i++) {
			found = false;
			name = baseString + i;
			Iterator it = umlParent.getOwnedElements().iterator();
			while(it.hasNext() && !found) {
				Object o = it.next();
				if(o instanceof NamedElement) {
					if(name.equals(((NamedElement)o).getName())) {
						found = true;
					}
				}
			}
			if(!found) {
				return name;
			}
		}
		return baseString + "X"; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private java.lang.String name_Transition_7000(Transition self) {
		//provides a new name taking into account the pseudostatekind if any
		String baseString = self.eClass().getName();
		if(self instanceof Pseudostate) {
			baseString = ((Pseudostate)self).getKind().getLiteral();
			baseString = baseString.substring(0, 1).toUpperCase() + baseString.substring(1);
		}
		String name = ""; //$NON-NLS-1$
		Element umlParent = self.getOwner();
		boolean found = false;
		// i <10000: avoid infinite loops
		for(int i = 0; i < 10001; i++) {
			found = false;
			name = baseString + i;
			Iterator it = umlParent.getOwnedElements().iterator();
			while(it.hasNext() && !found) {
				Object o = it.next();
				if(o instanceof NamedElement) {
					if(name.equals(((NamedElement)o).getName())) {
						found = true;
					}
				}
			}
			if(!found) {
				return name;
			}
		}
		return baseString + "X"; //$NON-NLS-1$
	}
}
