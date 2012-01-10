#!/bin/bash
loc=$(dirname "$0")
cd "$loc"
scp vlorenzo@build.eclipse.org:/opt/public/jobs/papyrus-trunk-nightly/config.xml config_papyrus-trunk-nightly.xml 
scp vlorenzo@build.eclipse.org:/opt/public/jobs/papyrus-trunk-extra-nightly/config.xml config_papyrus-trunk-extra-nightly.xml 
scp vlorenzo@build.eclipse.org:/opt/public/jobs/papyrus-0.8-maintenance-nightly/config.xml config_papyrus-0.8-maintenance-nightly.xml 
scp vlorenzo@build.eclipse.org:/opt/public/jobs/papyrus-0.8-maintenance-extra-nightly/config.xml config_papyrus-0.8-maintenance-extra-nightly.xml 
