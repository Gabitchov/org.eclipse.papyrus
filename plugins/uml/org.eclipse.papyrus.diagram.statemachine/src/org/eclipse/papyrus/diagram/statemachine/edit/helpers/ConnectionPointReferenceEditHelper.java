package org.eclipse.papyrus.diagram.statemachine.edit.helpers;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.uml2.uml.Pseudostate;

/**
 * @generated
 */
public class ConnectionPointReferenceEditHelper extends UMLBaseEditHelper {

	public static final String PARAMETER_CONFIGURE_CONNECTION_POINT_REFERENCE = StateEditHelper.class
			.getName()
			+ ":ConfigureConnectionPointReference"; //$NON-NLS-1$

	/**
	 * @NOT generated
	 */
	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {
		//		ConnectionPointReference pointReference = (ConnectionPointReference) req
		//				.getElementToConfigure();
		//		PseudostateKind kind = UMLElementTypes.ConnectionPointReference_2006
		//				.equals(req.getTypeToConfigure()) ? PseudostateKind.ENTRY_POINT_LITERAL
		//				: PseudostateKind.EXIT_POINT_LITERAL;
		//		SelectConnectionPointsDialog selectDialog = new SelectConnectionPointsDialog(
		//				Display.getCurrent().getActiveShell(), pointReference
		//						.getState().getSubmachine(), kind);
		//		if (selectDialog.open() == Window.OK) {
		//			Collection<Pseudostate> selectedConnectionReferences = selectDialog
		//					.getSelectedConnectionPoints();
		//			if (!selectedConnectionReferences.isEmpty()) {
		//				List<Pseudostate> connectionPoints = selectDialog
		//						.getSelectedConnectionPoints();
		//				if (!connectionPoints.isEmpty()) {
		//					CompositeCommand composite = new CompositeCommand(req
		//							.getLabel());
		//					boolean isEntry = connectionPoints.get(0).getKind() == PseudostateKind.ENTRY_POINT_LITERAL;
		//					EStructuralFeature feature = isEntry ? UMLPackage.eINSTANCE
		//							.getConnectionPointReference_Entry()
		//							: UMLPackage.eINSTANCE
		//									.getConnectionPointReference_Exit();
		//					for (Iterator<Pseudostate> iterator = connectionPoints
		//							.iterator(); iterator.hasNext();) {
		//						Pseudostate connectionPoint = iterator.next();
		//						SetRequest request = new SetRequest(pointReference,
		//								feature, connectionPoint);
		//						composite.add(new SetValueCommand(request));
		//					}
		//					return composite;
		//				}
		//			}
		//		}

		return super.getConfigureCommand(req);
	}

	/**
	 * @NOT generated 
	 */
	public static class ConnectionPointReferencesWrapper {

		public void addConnectionPointReference(Pseudostate reference) {
			myConnectionPointReferences.add(reference);
		}

		public void addConnectionPointReference(
				Collection<Pseudostate> references) {
			myConnectionPointReferences.addAll(references);
		}

		public List<Pseudostate> getConnectionPointReferences() {
			return myConnectionPointReferences;
		}

		private List<Pseudostate> myConnectionPointReferences = new LinkedList<Pseudostate>();
	}
}
