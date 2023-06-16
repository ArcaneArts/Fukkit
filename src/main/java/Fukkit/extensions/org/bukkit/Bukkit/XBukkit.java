package Fukkit.extensions.org.bukkit.Bukkit;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import org.bukkit.Bukkit;

@Extension
public class XBukkit {
  public static void helloWorld(@This Bukkit thiz) {
    System.out.println("hello world!");
  }
}