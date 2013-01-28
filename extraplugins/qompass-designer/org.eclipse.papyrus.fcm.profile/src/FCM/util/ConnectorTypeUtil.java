package FCM.util;

import java.util.ArrayList;

import org.eclipse.uml2.uml.Collaboration;

import FCM.InteractionComponent;

public class ConnectorTypeUtil {

	protected Collaboration connectionPattern = null;

	protected InteractionComponent connectorComp = null;

	protected FCMUtil.RoleBindingTable bindingTable = null;

	public FCMUtil.RoleBindingTable getRoleBindings(FCM.Connector connector) {
		if(connector.getIc() instanceof InteractionComponent) {
			connectorComp = (InteractionComponent)connector.getIc();
			connectionPattern = connectorComp.getConnectionPattern();
			bindingTable = new FCMUtil.RoleBindingTable();
			for(org.eclipse.uml2.uml.ConnectableElement role : connectionPattern.getRoles()) {
				bindingTable.addEntry(role, new ArrayList<org.eclipse.uml2.uml.NamedElement>());
			}
			return bindingTable;
		}
		return null;
	}
}
