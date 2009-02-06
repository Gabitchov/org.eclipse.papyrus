/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.core.multidiagram;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.papyrus.di.CoreSemanticModelBridge;
import org.eclipse.papyrus.di.Diagram;
import org.eclipse.papyrus.di.DiagramElement;
import org.eclipse.papyrus.sasheditor.sash.SashWindowsModelManagerImpl;
import org.eclipse.papyrus.sasheditor.sash.ITilePart.IListener;
import org.eclipse.papyrus.sasheditor.sash.ITilePart.ITilePartNodeModel;
import org.eclipse.papyrus.sasheditor.sash.SashPart.ISashModel;
import org.eclipse.papyrus.sasheditor.sash.TabFolderPart.ITabFolderModel;
import org.eclipse.swt.SWT;

/**
 * Implements the methods required by the sasheditor plugin.
 * Sasheditor calls these interface in reaction to user changes.
 * Implementation delegate to SashDiagramModelManager in order to have 
 * multiple inheritance.
 * 
 * The concrete type for T is di2.Diagram
 */
public class SashWindowModelManagerWrapper extends SashWindowsModelManagerImpl<Diagram> {

	/** Log object */
	protected Logger log = Logger.getLogger(getClass().getName());

	/** Manager of the diagram model. */
	protected SashDiagramModelManager diagramModelManager;

	/** activated flag */
	private boolean isActivated = false;

	/**
	 * Listener to changes on the Diagram model nodes
	 */
	private ResourceSetListener modelChangeListener = new ResourceSetListenerImpl() {

		/**
		 * Create a filter to be aware of change on node diagram
		 * 
		 * @see org.eclipse.emf.transaction.ResourceSetListenerImpl#getFilter()
		 */
		@Override
		public NotificationFilter getFilter() {
			// TODO Provide a more accurate filter
			// PB: NotificationFilter can't be extended because the CT is protected.
			return NotificationFilter.createNotifierTypeFilter(Diagram.class);
		}

		@Override
		public void resourceSetChanged(ResourceSetChangeEvent event) {

			// Filter : only retain Notification form SashNodes
			// TODO improve ?
			List<Notification> sashNodeNotification = new ArrayList<Notification>();

			for (Notification cur : event.getNotifications()) {
				if (SashDiagramModelUtil.isSashDiagramNode(cur.getNotifier())) {
					sashNodeNotification.add(cur);
				}
			}
			if (sashNodeNotification.size() == 0)
				return;

			// Have real event.
			System.out.println("resourceSetChanged(" + event.getSource() + ")");
			for (Notification cur : event.getNotifications()) {
				System.out.println("  notification: " + cur);
			}

			fireModelChangedEvent();
		}
	};

	/**
	 * Constructor.
	 */
	public SashWindowModelManagerWrapper(SashDiagramModelManager diagramModelManager) {
		this.diagramModelManager = diagramModelManager;
		activate();
	}

	/**
	 * Activate listeners.
	 */
	public void activate() {
		if (isActivated)
			return;

		isActivated = true;
		diagramModelManager.addChangeListener(modelChangeListener);
	}

	/**
	 * Deactivate listeners.
	 */
	public void deactivate() {
		if (!isActivated)
			return;

		isActivated = false;
		diagramModelManager.removeChangeListener(modelChangeListener);
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.SashWindowsModelManagerImpl#createFolder(java.lang.Object, int, java.lang.Object, int)
	 */
	@Override
	public void createFolder(Object srcfolder, int srcTabIndex, Object targetfolder, int position) {
		diagramModelManager.doMoveTabToFolderSide((Diagram) srcfolder, srcTabIndex, (Diagram) targetfolder, position);

	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.SashWindowsModelManagerImpl#moveTab(java.lang.Object, int, int)
	 */
	@Override
	public void moveTab(Diagram srcfolder, int srcTabIndex, int targetIndex) {
		diagramModelManager.doMoveTab((Diagram) srcfolder, srcTabIndex, targetIndex);

	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.SashWindowsModelManagerImpl#moveTab(java.lang.Object, int, java.lang.Object, int)
	 */
	@Override
	public void moveTab(Diagram srcfolder, int srcTabIndex, Diagram targetfolder, int targetIndex) {
		diagramModelManager.doMoveTab((Diagram) srcfolder, srcTabIndex, (Diagram) targetfolder, targetIndex);

	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ISashWindowsModelManager#createTilePartModel(java.lang.Object)
	 */
	public ITilePartNodeModel<Diagram> createTilePartModel(Diagram model) {

		// Check model
//		assert (model instanceof Diagram);

//		if (!(model instanceof Diagram))
//			throw new RuntimeException("Bad Sashwindow model. Model should be a Diagram (found '" + (model!=null?model.getClass():"model=null") + "')");
		Diagram node = model;

		if (SashDiagramModelManager.TAB_FOLDER_WINDOW.equals(node.getType())) {
			return new TabFolderModel(node);
		} else if (SashDiagramModelManager.SASH_WINDOW.equals(node.getType()) || SashDiagramModelManager.SASHH_WINDOW.equals(node.getType())) {
			return new SashWindowModel(node, SWT.HORIZONTAL);
		} else if (SashDiagramModelManager.SASHV_WINDOW.equals(node.getType())) {
			return new SashWindowModel(node, SWT.VERTICAL);
		}
		// TODO throw an exception or a warning if nothing is found
		log.warning("Unrecognize type for SashDiagramNode '" + model + "'");
		return null;
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ISashWindowsModelManager#getSashWindowsModelRoot()
	 */
	public Diagram getSashWindowsModelRoot() {
		return diagramModelManager.getModelRoot();
	}

	/**
     * Common ancestor for NodeModel implementation
     */
	protected abstract class TabPartNodeModel implements ITilePartNodeModel<Diagram> {

		protected Diagram node;

		/**
		 * List of observers
		 */
		private List<IListener<Diagram>> observers;

		private Adapter nodeListener;

		private boolean isActivated = false;

		/**
		 * Constructor
		 */
		protected TabPartNodeModel(Diagram node) {
			this.node = node;
		}

		/**
		 * Get the real model.
		 * 
		 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart.ITilePartNodeModel#getNodeModel()
		 */
		public Diagram getNodeModel() {
			return node;
		}

		/**
		 * Add a listener.
		 * 
		 * @see org.eclipse.papyrus.sasheditor.sash.TilePart.ITilePartNodeModel#addChangeListener(org.eclipse.papyrus.sasheditor.sash.TilePart.IListener)
		 */
		public void addChangeListener(IListener<Diagram> listener) {
			if (observers == null) {
				observers = new ArrayList<IListener<Diagram>>();
			}
			observers.add(listener);
		}

		/**
		 * Remove the listener.
		 * 
		 * @see org.eclipse.papyrus.sasheditor.sash.TilePart.ITilePartNodeModel#removeChangeListener(org.eclipse.papyrus.sasheditor.sash.TilePart.IListener)
		 */
		public void removeChangeListener(IListener<Diagram> listener) {
			if (observers == null) {
				return;
			}
			observers.remove(listener);
		}

		/**
		 * Notify observers of a change.
		 */
		protected void notifyObservers() {
			if (observers == null) {
				return;
			}
			for (IListener<Diagram> cur : observers) {
				cur.notifyChanged(this);
			}
		}

		/**
		 * Activate listening on nested EMF object.
		 */
		public void activate() {
			if (isActivated)
				return;

			isActivated = true;

			if (nodeListener == null) {
				nodeListener = new AdapterImpl() {

					@Override
					public void notifyChanged(Notification msg) {
						System.out.println(this.getClass().getSimpleName() + ".notifyChanged()");
						notifyObservers();
					}
				};
			}

			node.eAdapters().add(nodeListener);
		}

		/**
		 * Deactivate listening on the node. Do not remove observers.
		 */
		public void deactivate() {
			if (!isActivated || nodeListener == null)
				return;
			isActivated = false;
			;

			node.eAdapters().remove(nodeListener);

		}

	}

	/**
	 * Wrapper required by TabFolderPart to access folder model.
	 */
	protected class TabFolderModel extends TabPartNodeModel implements ITabFolderModel<Diagram> {

		protected TabFolderModel(Diagram node) {
			super(node);
		}

		/**
		 * Get all childs of this FolderModel.
		 * 
		 * @see org.eclipse.papyrus.sasheditor.sash.TabFolderPart.ITabFolderModel#getChildModels()
		 */
		public List<Object> getChildModels() {
			List<Object> res = new ArrayList<Object>();
			for (DiagramElement cur : node.getContained()) {
				try {
					// The real diagram is in a nested bridge
					Diagram diagram = (Diagram) cur;
					res.add(((CoreSemanticModelBridge) diagram.getSemanticModel()).getElement());
				} catch (ClassCastException e) {
					// error
					log.severe("Bad nested element inside a TabFolder element in the di2.");
				}
			}
			return res;
		}

		public Diagram getFolderNode() {
			return node;
		}
	}

	/**
	 * Wrapper required by SashPart to access sash model.
	 */
	protected class SashWindowModel extends TabPartNodeModel implements ISashModel<Diagram> {

		/** Direction of the Sash */
		private int direction;

		/**
		 * Constructor
		 */
		public SashWindowModel(Diagram node, int direction) {
			super(node);
			this.direction = direction;

		}

		/**
		 * 
		 * @see org.eclipse.papyrus.sasheditor.sash.SashPart.ISashModel#getChildModels()
		 */
		public List<Diagram> getChildModels() {
			List<?> res = node.getContained();
			// The list only contains Diagram, because we only add diagrams inside.
			// But there is no way to enforce this law :-(
			return (List<Diagram>)res;
		}

		/**
		 * @return the direction
		 */
		public int getSashDirection() {
			return direction;
		}

	}
}
