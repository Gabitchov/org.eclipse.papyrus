/**
 * Copyright (c) 2007, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.editor

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import xpt.Common

@Singleton class ResourceSetModificationListener extends xpt.editor.ResourceSetModificationListener {
	@Inject extension Common;

	

	override notifyChanged(GenDiagram it) '''
		«generatedMemberComment»	
		public void notifyChanged(org.eclipse.emf.common.notify.Notification notification) {
			if (notification.getNotifier() instanceof org.eclipse.emf.ecore.resource.ResourceSet) {
				super.notifyChanged(notification);
			}
			if (!notification.isTouch() && myModifiedFilter.matches(notification)) {
				if (notification.getNotifier() instanceof org.eclipse.emf.ecore.resource.Resource) {
					org.eclipse.emf.ecore.resource.Resource resource = (org.eclipse.emf.ecore.resource.Resource) notification.getNotifier();
					if (resource.isLoaded()) {
						boolean modified = false;
						for (java.util.Iterator<org.eclipse.emf.ecore.resource.Resource> it = myInfo.getLoadedResourcesIterator(); it.hasNext() && !modified;) {
							org.eclipse.emf.ecore.resource.Resource nextResource = (org.eclipse.emf.ecore.resource.Resource) it.next();
							if (nextResource.isLoaded()) {
								modified = nextResource.isModified();
							}
						}
						boolean dirtyStateChanged = false;
						synchronized (myInfo) {
							if (modified != myInfo.fCanBeSaved) {
								myInfo.fCanBeSaved = modified;
								dirtyStateChanged = true;
							}
							«IF null == editorGen.application»
							if (!resource.isModified()) {
								myInfo.setSynchronized(resource);
							}
							«ENDIF»
						}
						if (dirtyStateChanged) {
							fireElementDirtyStateChanged(myInfo.getEditorInput(), modified);
			
							if (!modified) {
								myInfo.setModificationStamp(computeModificationStamp(myInfo));
							}
						}
					}
				}
			}
		}
	'''
}
