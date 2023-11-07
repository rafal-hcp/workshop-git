#!/bin/bash

while true
do
	clear
	echo "Press [CTRL+C] to stop.."
	git log --decorate --oneline --graph
	sleep 30s
done
