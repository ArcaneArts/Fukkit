# ChumBukkit
Amulet &amp; Manifold extensions for Bukkit

# Add to Project

Due to the abandoned nature of Jitpack, they still only support jdk11, so we need to add ChumBukkit as a source dependency in gradle (for now). Hopefully in the future this wont be so bad.

1. In settings.gradle, add the following
```gradle
sourceControl {
    gitRepository("https://github.com/VolmitSoftware/ChumBukkit.git") {
        producesModule("com.volmit:ChumBukkit")
    }
}
```
2. Specify the dependency as `implementation 'com.volmit:ChumBukkit:<VERSION>'`
3. Since we're using manifold here, follow the [Amulet setup instructions](https://github.com/ArcaneArts/Amulet#project-setup)

## Problems
If you are having any issues building, generally the following will fix the problem
1. :clean
2. Invalidate Caches Restart
3. :build

## Updating ChumBukkit
Due to the use of source dependencies, **ITJ Refresh Project will NOT update ChumBukkit** you need to actually run :build on your project to build the new chumbukkit dependencies. 
