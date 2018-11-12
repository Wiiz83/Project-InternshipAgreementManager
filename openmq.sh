#!/bin/bash
. ./path.cfg
cd ${config[openmq_path]}
./mq/bin/imqbrokerd -port 56421