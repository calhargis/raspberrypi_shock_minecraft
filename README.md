# raspberrypi_shock_minecraft
Raspberrypi minecraft shock server

This repository contains code for a Minecraft plugin that connects a Minecraft Server on a Raspberry Pi to electric shock collars. When enabled, this plugin will activate GPIO pins on a Raspberry Pi when a specified player takes damage in game

DISCLAIMER:
Do not use this plugin. It will physically hurt you

INSTRUCTIONS BEFORE USING:
In order for the executable files to work correctly, both `shockExecutable` files need to be in the same directory and the path to that directory needs to be specified. By default, the plugin will assume the executables are in `/home/pi/minecraft/`. If this needs to be changed, the `/setdirectory` command should be used to specify the correct directory.

This repository includes `shockExecutable1.sh` and `shockExecutable2.sh` as safe stand-in executables for the plugin interface. Each invocation appends a line to `shock-executions.log` in the same directory instead of controlling GPIO hardware.

Commands:
```
/toggleshock
```
This command allows the functionality of the plugin to be enabled or disabled. The plugin starts disabled by default.

```
/setshock [player]
```
This command allows the specification of a player to be connected to a shock collar.

```
/setshock2 [player]
```
This command allows the specification of a second player to be connected to a second shock collar.

```
/setdirectory
```
This command is used to specify the file directory of the executable files.
