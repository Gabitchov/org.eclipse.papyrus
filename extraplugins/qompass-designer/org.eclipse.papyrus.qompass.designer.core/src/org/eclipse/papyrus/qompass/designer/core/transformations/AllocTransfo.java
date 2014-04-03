package org.eclipse.papyrus.qompass.designer.core.transformations;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.qompass.designer.core.deployment.AllocUtils;
import org.eclipse.papyrus.uml.tools.utils.ConnectorUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Transform the allocations towards an execution resource (thread) into a suitable connection
 * Current restriction: a thread needs to be defined the same composite as the component which
 * is allocated to this thread.
 */
public class AllocTransfo {
	public static final String MAIN = "main"; //$NON-NLS-1$
	
	/**
	 * 
	 * @param copy The copy class. Currently unused
	 * @param composite A composite. We analyze the allocations of the properties within this
	 *	Composite. The composite must be an element of the target model that can be modified.
	 */
	public void transformAllocs(LazyCopier copy, Class composite) {
		EList<Property> attributeList = new BasicEList<Property>();
		attributeList.addAll(composite.getOwnedAttributes());	// use a copy, since the loop eventually destroys an element of the list.
		for (Property attribute : attributeList) {
			Type type = attribute.getType();
			if (!(type instanceof Class)) {
				continue;
			}
			Property thread = AllocUtils.getThreadAlloc(attribute);
			if (thread != null) {
				// this attribute represents a thread.
				if (thread.getName().equals(MAIN)) {
					// TODO: currently, no support for setting up the priority of the main thread.
					//       we need to get a cleaner solution for the main thread. 
					// destroy eventual connector and associated thread => thread as component with unconnected start thread
					Connector conn = ConnectorUtil.getConnector(composite, attribute, thread);
					// Connector targetConn = copy.getCopy(conn);
					// Property targetThread = copy.getCopy(thread);
					if (conn != null) {
						conn.destroy();
					}
					// destroy not only the thread, but also the slot within the composites instance specification
					// (that references the thread via its defining feature).
					for (Setting setting : UMLUtil.getInverseReferences(thread)) {
						if (setting.getEObject() instanceof Slot) {
							((Element) setting.getEObject()).destroy();
						}
					}
					thread.destroy();	
				}
				// check, if there is already a connector between the attribute and the thread
				else if (!ConnectorUtil.existsConnector(composite, attribute, thread)) {
					// no connector => create;
					Class component =  (Class) type;
					Connector c = composite.createOwnedConnector("alloc to " + thread.getName()); //$NON-NLS-1$
					ConnectorEnd ce1 = c.createEnd();
					ce1.setPartWithPort(attribute);
					// TODO: should really use start port instead...
					// ce1.setRole(AllocUtils.getStartPort(component));
					NamedElement ne = Utils.getNamedElementFromList(component.getAllAttributes(), "lc"); //$NON-NLS-1$
					if (ne instanceof Property) {
						ce1.setRole((Property) ne);
					}
					ConnectorEnd ce2 = c.createEnd();
					ce2.setPartWithPort(thread);
					Type threadT = thread.getType();
					if (threadT instanceof Class) {
						// TODO: nicer way to obtain port ...
						Property rLC = ((Class) threadT).getAttribute("rLC", null); //$NON-NLS-1$
						if (rLC instanceof Port) {
							ce2.setRole(rLC);
						}
					}
				}
			}
		}
	}
}
