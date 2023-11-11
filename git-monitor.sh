#!/bin/bash

while true
do
	clear
	echo "Press [CTRL+C] to stop.."
	git log --decorate --oneline --graph --all
	sleep 30s
done
