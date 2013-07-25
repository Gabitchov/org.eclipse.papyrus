/*****************************************************************************
 * Copyright (c) 2013 PROTEUS Project consortium.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nicolas DU LAC (INTEMPORA) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.robotml.generators.common.mmqueries;

import java.util.List;
import java.util.LinkedList;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.papyrus.RobotML.*;



/**
 * 
 * @author scdtnsm
 *
 */
public class ArchitectureQueries {
	
	/** 
	 * Checks whether or not a port is a "source port" from the point of view of a given connector.
	 * A source port can be an output port for a connector stepping out of a component or it can be
	 * an input port for a connector linking a component model input port to a component input port
	 * inside the component model (e.g. from the model boundaries to a component inside the model). 
	 */
	static private boolean isSourcePort(ConnectorEnd end, Port p) {
		return ((isAnInputPort(p) &&end.getPartWithPort() == null) || (isAnOutputPort(p) && end.getPartWithPort() != null));
		
	}
	
	/**
	 * Checks whether or not a port is a "destination port" from the point of view of a given connector.
	 * A destination port can be an input port for a connector stepping out of a component or it can be
	 * an output port for a connector linking a component model output port to a component output port
	 * inside the component model (e.g. from a component inside the model to the model boundaries). 
	 */
	static private boolean isDestPort(ConnectorEnd end, Port p) {
		return ((isAnOutputPort(p) && end.getPartWithPort() == null) || (isAnInputPort(p) && end.getPartWithPort() != null));
		
	}
	
	/** 
	 * Retrieves the source port for a given connector 
	 * @see isDestPort and isSourcePort
	 */
	static private int getSourcePort(org.eclipse.uml2.uml.Connector conn,  Port[] dest_port) {
		
		if (conn.getEnds().get(0).getRole() instanceof Port) {
			Port test_1 = (Port)conn.getEnds().get(0).getRole();
			if (isSourcePort(conn.getEnds().get(0),test_1)) {
				dest_port[0] = test_1;
				return 0;
			}
			Port test_2 = (Port)conn.getEnds().get(1).getRole();
			if (isSourcePort(conn.getEnds().get(1),test_2)) {
				dest_port[0] = test_2;
				return 1;
			}
		}
		dest_port = null;
		return -1;
	}
	
	/** 
	 * Retrieves the destination port for a given connector 
	 * @see isDestPort and isSourcePort
	 */
	public static int getDestPort(org.eclipse.uml2.uml.Connector conn, Port[] dest_port) {
		if (conn.getEnds().get(0).getRole() instanceof Port) {
			Port test_1 = (Port)conn.getEnds().get(0).getRole();
			if (isDestPort(conn.getEnds().get(0),test_1)) {
				dest_port[0] = test_1;
				return 0;
			}
			Port test_2 = (Port)conn.getEnds().get(1).getRole();
			if (isDestPort(conn.getEnds().get(1),test_2)) {
				dest_port[0] = test_2;
				return 1;
			}
		}
		dest_port = null;
		return -1;
	}
	
	/** 
	 * Get the source port name of a connector.
	 */
	static public String getSourcePortName(org.eclipse.uml2.uml.Connector conn) {
		String inputName;
		Port[] inputPort = new Port[1];
		int index = getSourcePort(conn, inputPort);
		if (index < 0)
			return "Unknown";
		
		inputName = inputPort[0].getName(); 

		return inputName;
	}
	
	/**
	 * Retrieve the model name of a component at the source of a connector.
	 * @param conn
	 * @return a string or null if no component has been found at the source of a connector.
	 */
	static public String getSourceComponentTypeNameForConnector(org.eclipse.uml2.uml.Connector conn) {
		Property prop = getSourceComponentForConnector(conn);
		if (prop == null)
			return null;
		return prop.getType().getName();
	}
	
	/**
	 * Retrieve the instance name of a component at the source of a connector.
	 * @param conn
	 * @return a string or null if no component has been found at the source of a connector.
	 */
	static public String getSourceComponentInstanceNameForConnector(org.eclipse.uml2.uml.Connector conn) {
		Property prop = getSourceComponentForConnector(conn);
		if (prop == null)
			return null;
		return prop.getName();
	}
	
	/**
	 * Get the source component instance of a connector
	 */
	static public org.eclipse.uml2.uml.Property getSourceComponentForConnector(org.eclipse.uml2.uml.Connector conn) {
		Property input;
		Port[] inputPort = new Port[1];
		int index = getSourcePort(conn, inputPort);
		if ( (index < 0) || (conn.getEnds().get(index).getPartWithPort()==null) )
			return null; 
		else
			input = conn.getEnds().get(index).getPartWithPort();
		return input;
	}
	
	/** 
	 * Get the destination port name of a connector
	 */
	static public String getDestPortName(org.eclipse.uml2.uml.Connector conn) {
		String outputName;
		Port[] outputPort = new Port[1];
		int index = getDestPort(conn, outputPort);
		if (index < 0)
			return "Unknown";
		
		outputName = outputPort[0].getName(); 

		return outputName;
	}
	
	/**
	 * Get the destination component instance of a connector
	 */
	static public org.eclipse.uml2.uml.Property getDestComponentForConnector(org.eclipse.uml2.uml.Connector conn) {
		Property output;
		Port[] outputPort = new Port[1];
		int index = getDestPort(conn, outputPort);
		if ( (index < 0) || (conn.getEnds().get(index).getPartWithPort()==null) )
			return null; 
		else
			output = conn.getEnds().get(index).getPartWithPort();
		return output;
	}

	/**
	 * Retrieve the model name (or type name) of a component at the destination of a connector.
	 * @param conn
	 * @return a string or null if no component has been found at the destination of a connector.
	 */
	static public String getDestComponentTypeNameForConnector(org.eclipse.uml2.uml.Connector conn) {
		Property prop = getDestComponentForConnector(conn);
		if (prop == null)
			return null;
		return prop.getType().getName();
	}
	
	/**
	 * Retrieve the instance name of a component at the destination of a connector.
	 * @param conn
	 * @return a string or null if no component has been found at the destination of a connector.
	 */
	static public String getDestComponentInstanceNameForConnector(org.eclipse.uml2.uml.Connector conn) {
		Property prop = getDestComponentForConnector(conn);
		if (prop == null)
			return null;
		return prop.getName();
	}
		
	/**
	 * Retrieves all the connectors between subcomponents inside a given component model.
	 * (does not retrieve connectors between component model boundaries and subcomponents inside the model).
	 */
	static public List<org.eclipse.uml2.uml.Connector> getInternalConnectors(org.eclipse.uml2.uml.Class c) {
		LinkedList<org.eclipse.uml2.uml.Connector> connectors = new LinkedList<org.eclipse.uml2.uml.Connector>();
		for (Connector conn : c.getOwnedConnectors()) {
			if (conn.getEnds().size() >= 2 && (conn.getEnds().get(0).getPartWithPort() != null) && (conn.getEnds().get(1).getPartWithPort() != null)) {
				connectors.add(conn);
			}
		}
		return connectors;
	}

	/**
	 * Retrieves all the connectors between the input component model boundaries and subcomponents that are inside the model.
	 * (does not retrieve connectors between subcomponents inside the component model, nor connectors from subcomponents to component model outputs).
	 */
	static public List<org.eclipse.uml2.uml.Connector> getExternalInputConnectors(org.eclipse.uml2.uml.Class c) {
		LinkedList<org.eclipse.uml2.uml.Connector> connectors = new LinkedList<org.eclipse.uml2.uml.Connector>();
		for (Connector conn : c.getOwnedConnectors()) {
			if (conn.getEnds().size() >= 2) {// && (conn.getEnds().get(1).getPartWithPort() != null)) {
				if (conn.getEnds().get(0).getRole() instanceof Port && conn.getEnds().get(1).getRole() instanceof Port) {
					Port port_1 = (Port)conn.getEnds().get(0).getRole();
					Port port_2 = (Port)conn.getEnds().get(1).getRole();
					if ((isAnInputPort(port_1) && conn.getEnds().get(0).getPartWithPort() == null) || (isAnInputPort(port_2) && conn.getEnds().get(1).getPartWithPort() == null)) {
						connectors.add(conn);
					}
				}
			}
		}
		return connectors;
	}
	
	/**
	 * Retrieves all the connectors between subcomponents that are inside the component model and the component model outputs.
	 * (does not retrieve connectors between subcomponents inside the component model, nor connectors from component model inputs to subcomponents).
	 */
	static public List<org.eclipse.uml2.uml.Connector> getExternalOutputConnectors(org.eclipse.uml2.uml.Class c) {
		LinkedList<org.eclipse.uml2.uml.Connector> connectors = new LinkedList<org.eclipse.uml2.uml.Connector>();
		for (Connector conn : c.getOwnedConnectors()) {
			if (conn.getEnds().size() >= 2) {// && (conn.getEnds().get(0).getPartWithPort() != null)) {
				if (conn.getEnds().get(0).getRole() instanceof Port && conn.getEnds().get(1).getRole() instanceof Port) {
					Port port_1 = (Port)conn.getEnds().get(0).getRole();
					Port port_2 = (Port)conn.getEnds().get(1).getRole();
					if ((isAnOutputPort(port_1) && conn.getEnds().get(0).getPartWithPort() == null) || (isAnOutputPort(port_2) && conn.getEnds().get(1).getPartWithPort() == null)) {
						connectors.add(conn);
					}
				}
			}
		}
		return connectors;
	}
	
	/**
	 * Retrieves the highest level class into which a given model is contained.
	 * (a model can be contained in a model ... which is contained in a class).
	 */
	static public org.eclipse.uml2.uml.Class getRootClassForModel(org.eclipse.uml2.uml.Model m) {
		for (Element ne : m.getOwnedElements()) {
				if (ne instanceof org.eclipse.uml2.uml.Class) {
					return ( org.eclipse.uml2.uml.Class)ne;
				} else if (ne instanceof org.eclipse.uml2.uml.Model) {
					return getRootClassForModel((org.eclipse.uml2.uml.Model)ne);
				}
		}
		return null;
	}
	/**
	 * On a given class (a RobotML system), retrieve all the contained systems.
	 * Recursive. 
	 */
	static public List<org.eclipse.uml2.uml.Property> getAllSubComponentsInClass(org.eclipse.uml2.uml.Class c)
	{
		LinkedList<org.eclipse.uml2.uml.Property> sub_components = new LinkedList<org.eclipse.uml2.uml.Property>();
		List <org.eclipse.uml2.uml.Property> level_1 = getLevel1SubComponentsForComponent(c);
		sub_components.addAll(level_1);
		for (Property prop : level_1) {
			List<Property> next_levels = getAllSubComponentsInClass((org.eclipse.uml2.uml.Class)prop.getType());
			sub_components.addAll(next_levels);
		}
		return sub_components;
	}
	
	/**
	 * On a given class (a RobotML system), retrieve all the contained systems.
	 * Not recursive. Retrieves only one level deep.
	 */
	static public List<org.eclipse.uml2.uml.Property> getLevel1SubComponentsForComponent(org.eclipse.uml2.uml.Class c)
	{
		LinkedList<org.eclipse.uml2.uml.Property> sub_components = new LinkedList<org.eclipse.uml2.uml.Property>();
		for (org.eclipse.uml2.uml.Property prop : c.getAllAttributes()) {
			Type t = prop.getType();
			if (t instanceof org.eclipse.uml2.uml.Class) {
				if (GeneralQueries.hasStereotype((org.eclipse.uml2.uml.Class)t, org.eclipse.papyrus.RobotML.System.class)) {
					sub_components.add(prop);
				}
			}
		}
		return sub_components;
	}
	
	/**
	 * On a given class (a RobotML system), retrieve all the contained systems.
	 * Not recursive. Retrieves only one level deep.
	 * @deprecated replaced by getLevel1SubComponentsForComponent(org.eclipse.uml2.uml.Class c) which uses the RobotML API instead of stereotype names.
	 */
	static public List<org.eclipse.uml2.uml.Property> getLevel1SubComponentsForComponentWithStereotype(org.eclipse.uml2.uml.Class c, String stereotype)
	{
		LinkedList<org.eclipse.uml2.uml.Property> sub_components = new LinkedList<org.eclipse.uml2.uml.Property>();
		for (Property prop : c.getAllAttributes()) {
			Type t = prop.getType();
			if (t instanceof org.eclipse.uml2.uml.Class) {
//				if(GeneralQueries.hasStereotype((org.eclipse.uml2.uml.Class) t, stereotype))
				if(GeneralQueries.inheritsFrom((org.eclipse.uml2.uml.Class) t, stereotype))
				{
					sub_components.add(prop);
				}
			}
		}
		return sub_components;
	}

	
	/**
	 * As its name says, retrieves the output ports for a given element.
	 */
	static public List<org.eclipse.uml2.uml.Port> getOutputPortsForElement(Element elt) {
		LinkedList<org.eclipse.uml2.uml.Port> found_output_ports = new LinkedList<org.eclipse.uml2.uml.Port>();		
		for (Element child : elt.getOwnedElements()) {
			if (child instanceof org.eclipse.uml2.uml.Port) {
				if (isAnOutputPort((org.eclipse.uml2.uml.Port)child)) {
					found_output_ports.add((org.eclipse.uml2.uml.Port)child);
				}
			}
		}
		return found_output_ports;
	}
	
	/**
	 * As its name says, retrieves the input ports for a given element.
	 */
	static public List<Port> getInputPortsForElement(Element elt) {
		LinkedList<Port> found_input_ports = new LinkedList<org.eclipse.uml2.uml.Port>();
		for (Element child : elt.getOwnedElements()) {
			if (child instanceof NamedElement && child instanceof org.eclipse.uml2.uml.Port) {
				if (isAnInputPort((org.eclipse.uml2.uml.Port)child)) {
					Port found_port = (org.eclipse.uml2.uml.Port)child;
					found_input_ports.add(found_port);
				}
			}
		}
		return found_input_ports;
	}
	
	static public List<org.eclipse.uml2.uml.Property> getOnPort(org.eclipse.uml2.uml.Parameter param)
	{
		LinkedList<org.eclipse.uml2.uml.Property> result = new LinkedList<org.eclipse.uml2.uml.Property>();
		for(Stereotype st : param.getAppliedStereotypes())
		{
			if(st.getName().contains("OnPort"))
			{
				for(Property p: st.getAttributes())
				{
					result.add((Property)p);
				}
			}
		}
		
		return result;
	}
	
	/**
	 * Retrieves all the component models available inside a RobotML model.
	 */
	static public List<NamedElement> getComponentModels(Model model)
	{
		LinkedList<NamedElement> found_elts = new LinkedList<NamedElement>();
		for (Element elt : model.allOwnedElements()) {
			if (elt instanceof org.eclipse.uml2.uml.Class) {
				if (GeneralQueries.hasStereotype((org.eclipse.uml2.uml.Class)elt,org.eclipse.papyrus.RobotML.System.class) &&
					false == GeneralQueries.hasStereotype((org.eclipse.uml2.uml.Class)elt, org.eclipse.papyrus.RobotML.Platform.class)) {
					found_elts.add((NamedElement)elt);
				}
			}
		}
		return found_elts;
	}
	
	/**
	 * Is the elt at the root of the model hierarchy ?
	 * @param elt
	 * @return
	 */
	static public Boolean isRootModel(Model elt)
	{
		if (elt==null)
			return false;
		return (elt.getOwner() == null);
	}
	
	/**
	 * Does this class contain properties that are classes themselves ?
	 * (i.e. is this class a container of sub-classes)
	 * @param c
	 * @return
	 */
	static public Boolean isMacroComponent(org.eclipse.uml2.uml.Class c)
	{
		boolean result = false;
		if (getLevel1SubComponentsForComponent(c).size() > 0) {
			result = true;
		}
		return result;
	}
	
	static public Boolean hasNativeImplementation(org.eclipse.uml2.uml.Class c)
	{
		org.eclipse.papyrus.RobotML.System sys = org.eclipse.uml2.uml.util.UMLUtil.getStereotypeApplication(c, org.eclipse.papyrus.RobotML.System.class);
		if (sys == null)
			return false;
		return sys.isNative();
	}
	
	static public String getNativeLibraryPathForComponent(org.eclipse.uml2.uml.Class c) 
	{
		org.eclipse.papyrus.RobotML.System sys = org.eclipse.uml2.uml.util.UMLUtil.getStereotypeApplication(c, org.eclipse.papyrus.RobotML.System.class);
		if (sys == null)
			return null;
		return sys.getLibraryPath();
	}
	
	static public String getNativeComponentNameForComponent(org.eclipse.uml2.uml.Class c) 
	{
		org.eclipse.papyrus.RobotML.System sys = org.eclipse.uml2.uml.util.UMLUtil.getStereotypeApplication(c, org.eclipse.papyrus.RobotML.System.class);
		if (sys == null)
			return null;
		return sys.getLibraryComponentName();
	}
	
	static public int getOutputPortBufferSize(Port p) {
		org.eclipse.papyrus.RobotML.DataFlowPort dfp = org.eclipse.uml2.uml.util.UMLUtil.getStereotypeApplication(p, org.eclipse.papyrus.RobotML.DataFlowPort.class);
		if (dfp == null)
			return 0;
		return dfp.getBufferSize();
	}
	/**
	 * 
	 */
	static public String getComponentFileName(org.eclipse.uml2.uml.Class c, String end) {
		return c.getName()+end;
	}
	
	/**
	 *  @TODO: author to add some doc.
	 */
	static public Boolean isPortConnected(Port p1)
	{
		if (p1.getEnds().size()>0) {
			Connector conn = (Connector)p1.getEnds().get(0).getOwner();
			return isConnectionValid(conn);
		}
		else return false;		
	}
	
	/**
	 * @TODO: author to add some doc. Middleware specific?
	 */
	static public String getConnectionOtherSide(Port p1)
	{
		if (p1.getEnds().size()>0) {
			Connector conn = (Connector)p1.getEnds().get(0).getOwner();
			ConnectorEnd e1 = conn.getEnds().get(0);
			ConnectorEnd e2 = conn.getEnds().get(1);
			Port p2 = null;
			java.lang.System.out.println("p1="+p1.getName());
			Property c2 = null;
			if (e1.getRole() == p1)
			{
				p2 = (Port)e2.getRole();
				c2 = (Property)e2.getPartWithPort();
				java.lang.System.out.println("1 - p2="+p2.getName()+", c2="+c2.getName());
			}
			else if (e2.getRole() == p1) {
				p2 = (Port)e1.getRole();
				c2 = (Property)e1.getPartWithPort();
				java.lang.System.out.println("2 - p2="+p2.getName()+", c2="+c2.getName());
			}
			if (c2.getName().equals(((NamedElement)conn.getOwner()).getName())) 
			{
				return "@"+p2.getName();
			}
			else {
				return "@"+c2.getName()+"."+p2.getName();
			}
		}
		else {
			return "?????";
		}
	}
	
	/**
	 * Is this property a DataFlow Port
	 * @param port
	 * @return is this a DataFlow port ?
	 */
	static public Boolean isDataFlowPort(Port port) {
		DataFlowPort dfp = UMLUtil.getStereotypeApplication(port, DataFlowPort.class);
		if (dfp == null)
			return false;
		return true;
	}
	
	/**
	 * For DataFlow ports: is it an Input Port ?
	 * @param port
	 * @return false if the port is not a DataFlowPort or not an input port.  
	 */
	static public Boolean isAnInputPort(Port port)
	{
		try {
			DataFlowPort dfp = UMLUtil.getStereotypeApplication(port, DataFlowPort.class);
			if (dfp == null)
				return false;
			if (dfp.getDirection() == DataFlowDirectionKind.IN)
				return true;
			return false;
		} catch (Exception e) {
			java.lang.System.out.println("EXCEPTION caught:" + e.toString());
		}
		return false;
	}
	
	/**
	 * For DataFlow ports: is it an Output Port ?
	 * @param port
	 * @return false if the port is not a DataFlowPort or not an output port.  
	 */
	static public Boolean isAnOutputPort(Port port)
	{
		try {
			DataFlowPort dfp = UMLUtil.getStereotypeApplication(port, DataFlowPort.class);
			if (dfp == null)
				return false;
			if (dfp.getDirection() == DataFlowDirectionKind.OUT)
				return true;
			return false;
		} catch (Exception e) {
			java.lang.System.out.println("EXCEPTION caught:" + e.toString());
		}
		return false;
	}
	
	/**
	 * For RobotML ServicePorts: is the port a "Provided" port?
	 * @param port
	 * @return false if the port is not a ServicePort or not a "Provided" ServicePort.
	 */
	static public Boolean isAProvidedPort(Port port) {
		try {
			ServicePort sp = UMLUtil.getStereotypeApplication(port, ServicePort.class);
			if (sp == null)
				return false;
			if (sp.getKind() == ServiceFlowKind.PROVIDED)
				return true;
			return false;
		} catch (Exception e) {
			java.lang.System.out.println("EXCEPTION caught:" + e.toString());
		}
		return false;
	}

	/**
	 * For RobotML ServicePorts: is the port a "Required" port?
	 * @param port
	 * @return false if the port is not a ServicePort or not a "Required" ServicePort.
	 */
	static public Boolean isARequiredPort(Port port) {
		try {
			ServicePort sp = UMLUtil.getStereotypeApplication(port, ServicePort.class);
			if (sp == null)
				return false;
			if (sp.getKind() == ServiceFlowKind.REQUIRED)
				return true;
			return false;
		} catch (Exception e) {
			java.lang.System.out.println("EXCEPTION caught:" + e.toString());
		}
		return false;
	}
	
	/**
	 * Is this property a Service Port
	 * @param port
	 * @return is this a service port ?
	 */
	static public Boolean isServicePort(Port port) {
		ServicePort serviceport = UMLUtil.getStereotypeApplication(port, ServicePort.class);
		return serviceport != null;
	}
	
	/**
	 * @TOOD: author to add some doc.
	 */
	static public Boolean definesConnections(org.eclipse.uml2.uml.Class cl)
	{
		return cl.getOwnedConnectors().size()>0;
	}
	
	/**
	 * @TODO: author to add some doc
	 */
	static public Boolean isConnectionValid(Connector connector)
	{
		if (connector.getEnds().size() != 2) 
		{
			return false;
		}
		for (ConnectorEnd cend : connector.getEnds()) 
		{
			if ((cend.getRole()==null)||(cend.getPartWithPort()==null)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @TODO: this seems to be middleware specific. To be moved to corresponding middleware generator project.
	 */
	static public String getConnectionDefinition(Connector connector)
	{
		ConnectorEnd e1 = connector.getEnds().get(0);
		ConnectorEnd e2 = connector.getEnds().get(1);
		return 
			e1.getPartWithPort().getName()+"."+e1.getRole().getName()+".connectTo("+e2.getPartWithPort().getName()+"."+e2.getRole().getName()+")";
	}
	
	static public Port getConnectedPort(Port port)
	{
		if (port.getEnds().size() == 0)
			return null;
		
		Connector conn = (Connector)port.getEnds().get(0).getOwner();
		ConnectorEnd e1 = conn.getEnds().get(0);
		ConnectorEnd e2 = conn.getEnds().get(1);
		return (e1.getRole() == port) ? (Port)e2.getRole() : (Port)e1.getRole();
	}
	
	/**
	 * Get external connectors to a port 
	 * @param port
	 * @return a list of connectors which are connected to the port.
	 */
	static public List<org.eclipse.uml2.uml.Connector> getConnectionsFromPort(Port port)
	{
		LinkedList<org.eclipse.uml2.uml.Connector> connectors = new LinkedList<org.eclipse.uml2.uml.Connector>();
		
		for (ConnectorEnd connEnd : port.getEnds())
		{
			Connector conn = (Connector)connEnd.getOwner();

			if (conn.getEnds().size() >= 2 &&
				conn.getEnds().get(0).getPartWithPort() != null &&
				conn.getEnds().get(1).getPartWithPort() != null)
			{
				connectors.add(conn);
			}
		}
		
		return connectors;
	}

	/**
	 * Debug function: prints info about a given dataflow port.
	 */
	static public void inspectDataFlowPort(Port port)
	{
		//
		Stereotype pst = port.getAppliedStereotypes().get(0);
		 
		// Type du port
		if (port.getType()!= null) {
			java.lang.System.out.println("\t\t* type: "+port.getType().getName());
		}
		else {
			java.lang.System.err.println("\t\t\t* port "+port.getName()+" has no type ! ");
		}
		//
		//
		// A partir des attributs ci-dessous, on peut récupérer:
		// - la taille du buffer
		// - la direction (énuméré IN ou OUT)
		// - le protocole de synchronization (énuméré SYNCH ou ASYNCH ou UNDEFINED)
		//
		for (Property propSt : pst.getAllAttributes()) 
		{
			java.lang.System.out.println("\t\t* port stereotype has attribute: "+propSt.getName()+" - "+port.getValue(pst, propSt.getName()));
		}					
		
	}
	
	/**
	 * Debug function. Prints info about a given service port.
	 */
	static public void inspectServicePort(Port port)
	{
		//
		Stereotype pst = port.getAppliedStereotypes().get(0);
		 
		//
		if (port.getType()!= null) {
			java.lang.System.out.println("\t\t* type: "+port.getType().getName());
		}
		else {
			java.lang.System.err.println("\t\t\t* port "+port.getName()+" has no type ! ");
		}
		// A partir des attributs ci-dessous, on peut récupérer:
		// - le type d'interface(énuméré Provided ou Required)
		// - le protocole de synchronization (énuméré SYNCH ou ASYNCH ou UNDEFINED)
		//
		
		for (Property propSt : pst.getAllAttributes()) 
		{
			java.lang.System.out.println("\t\t* port stereotype has attribute: "+propSt.getName()+" - "+port.getValue(pst, propSt.getName()));
		}							
	}
	
	static public Boolean isAnAncestorOf(Class current_elt, Class other_elt)
	{
		Boolean result = false;
		if(current_elt != null && other_elt != null)
		{
			if(current_elt == other_elt)
			{
				result = true;
			}
			else
			{
				for(Class parent : current_elt.getSuperClasses())
				{
					current_elt = parent;
					if(other_elt == current_elt)
					{
						result = true;
						break;
					}
				}
			}
		}
		
		return result;
	}
	
	/**
	 * For DataFlow ports: is it an Output Port ?
	 * @param port
	 * @return false if the port is not a DataFlowPort or not an input/output port.  
	 */
	static public Boolean isAnInputOutputPort(Port port)
	{
		try {
			DataFlowPort dfp = UMLUtil.getStereotypeApplication(port, DataFlowPort.class);
			if (dfp == null)
				return false;
			if (dfp.getDirection() == DataFlowDirectionKind.INOUT)
				return true;
			return false;
		} catch (Exception e) {
			java.lang.System.out.println("EXCEPTION caught:" + e.toString());
		}
		return false;
	}
	
}
