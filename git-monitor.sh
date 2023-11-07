#!/bin/bash

while true
do
	echo "Press [CTRL+C] to stop.."
	clear
	git log --decorate --oneline --graph
	sleep 1500
done
