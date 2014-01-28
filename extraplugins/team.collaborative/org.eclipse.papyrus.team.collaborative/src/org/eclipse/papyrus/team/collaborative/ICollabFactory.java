package org.eclipse.papyrus.team.collaborative;

import java.util.Set;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.team.collaborative.participants.locker.ILocker;
import org.eclipse.papyrus.team.collaborative.participants.locker.IUnlocker;
import org.eclipse.papyrus.team.collaborative.participants.version.ICommitter;
import org.eclipse.papyrus.team.collaborative.participants.version.IReverter;
import org.eclipse.papyrus.team.collaborative.participants.version.IUpdater;


/**
 * Factory for creating all necessary participant for collaborative actions
 * 
 * @author adaussy
 * 
 */
public interface ICollabFactory {

	ILocker createLocker(Set<IExtendedURI> uris, ResourceSet resourceSet);

	IUnlocker createUnlocker(Set<IExtendedURI> uris, ResourceSet resourceSet);

	IReverter createReverter(Set<IExtendedURI> uris, ResourceSet resourceSet);

	ICommitter createCommitter(Set<IExtendedURI> uris, ResourceSet resourceSet);

	IUpdater createUpdater(Set<IExtendedURI> uris, ResourceSet resourceSet);

	boolean provide(Set<IExtendedURI> uris, ResourceSet resourceSet);

}
