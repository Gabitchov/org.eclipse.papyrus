#!/bin/bash
loc=$(dirname "$0")
cd "$loc"

jobs=$(ssh vlorenzo@build.eclipse.org ls -1 /opt/public/jobs | grep papyrus)

for job in $jobs; do
  scp vlorenzo@build.eclipse.org:/opt/public/jobs/${job}/config.xml hudsonJobs/${job}.xml
done
