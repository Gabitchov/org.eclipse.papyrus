/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.tabbed.core.view.subfeatures;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.state.ITraversableModelElement;
import org.eclipse.papyrus.views.properties.runtime.view.IFragmentDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.views.properties.tabbed.core.view.DynamicSectionDescriptor;
import org.eclipse.papyrus.views.properties.tabbed.core.view.SectionDescriptorState;
import org.eclipse.papyrus.views.properties.tabbed.core.view.subfeatures.SubFeatureDescriptor.SubFeatureDescriptorState;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


/**
 * Descriptor for sections using controllers.
 */
public class DynamicSubFeatureSectionDescriptor extends DynamicSectionDescriptor {

	/** maximal number of columns in the display */
	protected final int maxColumn;

	/** descriptor to give access to the sub-elements */
	protected final SubFeatureDescriptor subFeatureDescriptor;

	/** descriptor for container */
	protected final SubFeatureContainerDescriptor subFeatureContainerDescriptor;

	/**
	 * Creates a new DynamicSectionDescriptor.
	 * 
	 * @param id
	 *        identifier of the section descriptor
	 * @param tabId
	 *        identifier of the tab where the section will be displayed
	 * @param constraints
	 *        list of constraints used to see if the section should be displayed or not
	 * @param selectionSize
	 *        size of the selection
	 * @param adapterID
	 *        identifier of the adapter
	 * @param replacedSectionIds
	 *        list of replaced sections by this one
	 * @param afterSectionId
	 *        identifier of the section this one should be placed after
	 * @param fragmentDescriptors
	 *        list of fragments descriptors inside this section
	 * @param subFeatureDescriptor
	 *        descriptor of the sub-feature
	 * @param maxColumn
	 *        number max of columns for the layout
	 * @param containerDescriptor
	 *        descriptor of the container
	 */
	public DynamicSubFeatureSectionDescriptor(String id, String tabId, List<IConstraintDescriptor> constraints, int selectionSize, String adapterID, List<String> replacedSectionIds, String afterSectionId, List<IFragmentDescriptor> fragmentDescriptors, SubFeatureDescriptor subFeatureDescriptor, int maxColumn, SubFeatureContainerDescriptor containerDescriptor) {
		super(id, tabId, constraints, selectionSize, adapterID, replacedSectionIds, afterSectionId, fragmentDescriptors);
		this.maxColumn = maxColumn;
		this.subFeatureDescriptor = subFeatureDescriptor;
		this.subFeatureContainerDescriptor = containerDescriptor;
	}

	/**
	 * Returns the subFeatureDescriptor for this descriptor
	 * 
	 * @return the subFeatureDescriptor for this descriptor
	 */
	public SubFeatureDescriptor getSubFeatureDescriptor() {
		return subFeatureDescriptor;
	}

	/**
	 * Returns the subFeatureContainerDescriptor for this descriptor
	 * 
	 * @return the subFeatureContainerDescriptor for this descriptor
	 */
	public SubFeatureContainerDescriptor getSubFeatureContainerDescriptor() {
		return subFeatureContainerDescriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ISection getSectionClass() {
		return new DynamicSubFeatureSection(fragmentDescriptors, subFeatureDescriptor, maxColumn, subFeatureContainerDescriptor, adapterId);
	}

	/**
	 * Returns the maximum column number for the layout
	 * 
	 * @return the maximum column number for the layout
	 */
	public int getMaxColumn() {
		return maxColumn;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SubFeatureSectionDescriptorState createState(boolean readOnly) {
		return new SubFeatureSectionDescriptorState(this, readOnly);
	}

	/**
	 * State for {@link SubFeatureContainerDescriptor}
	 */
	public class SubFeatureSectionDescriptorState extends SectionDescriptorState {

		/** state for the {@link SubFeatureDescriptor} */
		private SubFeatureDescriptorState subFeatureDescriptorState;

		/** state for the {@link SubFeatureContainerDescriptor} */
		private SubFeatureContainerDescriptorState subFeatureContainerDescriptorState;

		/** number max of column for this sub feature section */
		private int maxColumn;

		/** change support for this bean */
		private PropertyChangeSupport changeSupport;

		/**
		 * Creates a new SubFeatureSectionDescriptorState.
		 * 
		 * @param sectionDescriptor
		 *        descriptor managed by this state
		 * @param readOnly
		 *        read only mode of this state
		 */
		public SubFeatureSectionDescriptorState(DynamicSubFeatureSectionDescriptor sectionDescriptor, boolean readOnly) {
			super(sectionDescriptor, readOnly);

			maxColumn = sectionDescriptor.getMaxColumn();

			subFeatureDescriptorState = sectionDescriptor.getSubFeatureDescriptor().createState(readOnly);
			subFeatureContainerDescriptorState = sectionDescriptor.getSubFeatureContainerDescriptor().createState(readOnly);
			// register change support
			changeSupport = new PropertyChangeSupport(this);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getEditionDialogId() {
			return "SubFeatureSectionDescriptorStateDialog";
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
			super.addPropertyChangeListener(listener);
			changeSupport.addPropertyChangeListener(listener);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
			super.removePropertyChangeListener(listener);
			changeSupport.removePropertyChangeListener(listener);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public List<? extends ITraversableModelElement> getChildren() {
			List<ITraversableModelElement> list = new ArrayList<ITraversableModelElement>();
			list.add(subFeatureDescriptorState);
			list.add(subFeatureContainerDescriptorState);
			list.addAll(super.getChildren());
			return list;
		}

		/**
		 * Returns the subFeatureDescriptorState for this state
		 * 
		 * @return the subFeatureDescriptorState for this state
		 */
		public SubFeatureDescriptorState getSubFeatureDescriptorState() {
			return subFeatureDescriptorState;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Node generateNode(Document document) {
			Element node = document.createElement("subFeatureSection");
			node.setAttribute("id", getId());
			node.setAttribute("tabId", getTargetTab());
			node.setAttribute("adapterId", getAdapterId());
			node.setAttribute("maxColumn", "" + maxColumn);

			node.appendChild(subFeatureDescriptorState.generateNode(document));
			node.appendChild(subFeatureContainerDescriptorState.generateNode(document));

			generateReplacedSectionStates(node, document);

			generateFragmentDescriptorStateNodes(node, document);
			return node;
		}

		/**
		 * Sets the maxColumn for this state
		 * 
		 * @param maxColumn
		 *        the maxColumn to set
		 */
		public void setMaxColumn(int maxColumn) {
			changeSupport.firePropertyChange("maxColumn", this.maxColumn, this.maxColumn = maxColumn);
		}

		/**
		 * Returns the maxColumn for this state
		 * 
		 * @return the maxColumn for this state
		 */
		public int getMaxColumn() {
			return maxColumn;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getText() {
			return "Sub-Feature Section: " + getId() + " in tab: " + getTargetTab() + " (max column:" + maxColumn + ")";
		}

		/**
		 * {@inheritDoc}
		 */
		public Image getImage() {
			return org.eclipse.papyrus.views.properties.tabbed.core.Activator.getImage("/icons/Section.gif");
		}

	}

}
