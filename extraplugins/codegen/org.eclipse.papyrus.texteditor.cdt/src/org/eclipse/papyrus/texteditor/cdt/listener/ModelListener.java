/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) Ansgar.Radermacher@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.texteditor.cdt.listener;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.uml.tools.listeners.PapyrusStereotypeListener;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;

/**
 * Main listener for model changes (registered via plugin.xml). It will delegate
 * to the sub-listeners for specific sub-elements (type, operation, port, ...) that
 * can be found in this package
 * 
 */
public class ModelListener implements IPapyrusListener {

	/**
	 * set to true, if a synchronization from an CDT editor to the model is active
	 */
	public static boolean syncFromEditor;

	public void notifyChanged(Notification notification) {
		Object notifier = notification.getNotifier();
		int eventType = notification.getEventType();
		if(syncFromEditor) {
			return;
		}
		if((eventType == Notification.REMOVING_ADAPTER) ||
			(eventType == Notification.RESOLVE)) {
			// does not indicate a modification of the element
			return;
		}

		OperationHistoryListener.init();
		try {
			// TODO: kind of get nearest classifier

			if(notifier instanceof Classifier) {
				Classifier classifier = (Classifier)notifier;
				if((eventType == Notification.REMOVE) ||
					(eventType == PapyrusStereotypeListener.MODIFIED_STEREOTYPE)) {
					regenList.add(classifier);
				}
				// don't treat addition here, since operations/properties do not have their final names yet
				// IStorage storage = new TextStorage(string);
			}
			else if(notifier instanceof Feature) {
				// if a feature is added, it is first generated with a dummy name, then the name is corrected.
				Feature feature = (Feature)notifier;
				Element owner = feature.getOwner();
				if(owner instanceof Classifier) {
					regenList.add((Classifier)owner);
				}
			}
			else if(notifier instanceof Parameter) {
				Parameter parameter = (Parameter)notifier;
				Element owner = parameter.getOperation().getOwner();
				if(owner instanceof Classifier) {
					regenList.add((Classifier)owner);
				}
			}
			else if(notifier instanceof DirectedRelationship) {
				// if a feature is added, it is first generated with a dummy name, then the name is corrected.
				DirectedRelationship dr = (DirectedRelationship)notifier;
				for(Element client : dr.getSources()) {
					if(client instanceof Classifier) {
						regenList.add((Classifier)client);
					}
				}
			}
			else if(notifier instanceof Package) {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static EList<Classifier> regenList = new UniqueEList<Classifier>();
}
