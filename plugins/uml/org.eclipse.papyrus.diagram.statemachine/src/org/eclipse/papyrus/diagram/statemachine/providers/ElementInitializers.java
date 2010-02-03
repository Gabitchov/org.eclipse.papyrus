package org.eclipse.papyrus.diagram.statemachine.providers;

import org.eclipse.papyrus.diagram.common.helper.NamedElementHelper;
import org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @generated
 */
public class ElementInitializers {

	/**
	 * Custom code
	 * 
	 * @param self
	 * @return
	 */
	private static String getName(org.eclipse.uml2.uml.Element self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self
				.getOwner(), self.eClass());

	}

	/**
	 * @generated
	 */
	public static void init_Region_3000(Region instance) {
		try {
			Object value_0 = name_Region_3000(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_StateMachine_2000(StateMachine instance) {
		try {
			Object value_0 = name_StateMachine_2000(instance);
			instance.setName((String) value_0);
			Region newInstance_1_0 = UMLFactory.eINSTANCE.createRegion();
			instance.getRegions().add(newInstance_1_0);
			Object value_1_0_0 = name_region_StateMachine_2000(newInstance_1_0);
			newInstance_1_0.setName((String) value_1_0_0);

		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	private static String name_Region_3000(Region self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_region_StateMachine_2000(Region self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_StateMachine_2000(StateMachine self) {
		return getName(self);
	}

}
