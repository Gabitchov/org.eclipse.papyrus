/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.core.util.tests;

import static org.eclipse.papyrus.cdo.core.tests.AbstractPapyrusCDOTest.lessThan;
import static org.eclipse.papyrus.cdo.core.tests.AbstractPapyrusCDOTest.lessThanOrEqualTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.papyrus.cdo.core.util.JobWaiter;
import org.junit.After;
import org.junit.Test;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;


/**
 * This is the JobWaiterTest type. Enjoy.
 */
public class JobWaiterTest {

	private Stopwatch watch = new Stopwatch();

	private List<TestJob> jobsToClean = Lists.newArrayListWithExpectedSize(1);

	@Test
	public void testWaitForJob() throws InterruptedException {
		Job job = new TestJob(3).start();

		watch.start();
		boolean done = JobWaiter.waitFor(job, 10, TimeUnit.SECONDS);
		watch.stop();

		assertThat(done, is(true));
		assertThat(watch.elapsedTime(TimeUnit.SECONDS), lessThanOrEqualTo(3L));
	}

	@Test
	public void testWaitForFamily() throws InterruptedException {
		for(int i = 0; i < 3; i++) {
			new TestJob(3).start();
		}

		watch.start();
		boolean done = JobWaiter.waitFor(this, 10, TimeUnit.SECONDS);
		watch.stop();

		assertThat(done, is(true));
		assertThat(watch.elapsedTime(TimeUnit.SECONDS), lessThanOrEqualTo(3L));
	}

	@Test
	public void testWaitForJob_timeout() throws InterruptedException {
		Job job = new TestJob(10).start();

		watch.start();
		boolean done = JobWaiter.waitFor(job, 3, TimeUnit.SECONDS);
		watch.stop();

		assertThat(done, is(false));
		assertThat(watch.elapsedTime(TimeUnit.SECONDS), lessThan(5L));
	}

	@Test
	public void testWaitForFamily_timeout() throws InterruptedException {
		for(int i = 0; i < 3; i++) {
			new TestJob(10).start();
		}

		watch.start();
		boolean done = JobWaiter.waitFor(this, 3, TimeUnit.SECONDS);
		watch.stop();

		assertThat(done, is(false));
		assertThat(watch.elapsedTime(TimeUnit.SECONDS), lessThan(5L));
	}

	//
	// Test framework
	//

	@After
	public void cleanUpJob() throws InterruptedException {
		for(Job next : jobsToClean) {
			next.cancel();
		}

		Job.getJobManager().join(this, null);
	}

	private class TestJob extends Job {

		private final int iterations;

		private final AtomicBoolean cancelled = new AtomicBoolean();

		private Semaphore startSema = new Semaphore(0);

		TestJob(int iterations) {
			super("Test Job");

			this.iterations = iterations;

			jobsToClean.add(this);
		}

		@Override
		public boolean belongsTo(Object family) {
			return family == JobWaiterTest.this;
		}

		@Override
		protected void canceling() {
			cancelled.set(true);
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			startSema.release();

			for(int i = iterations; (i > 0) && !cancelled.get(); i--) {
				try {
					Thread.sleep(1000L);
				} catch (Exception e) {
					// fine.  Keep going
				}
			}

			return Status.OK_STATUS;
		}

		TestJob start() throws InterruptedException {
			schedule();
			startSema.acquire();
			return this;
		}
	}
}
