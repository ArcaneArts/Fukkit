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
3. Since we're using manifold here, follow the [Amulet setup instructions](https://github.com/ArcaneArts/Amulet#project-setup)~~~~