# BlockGPT
### A plugin that integrates Minecraft with Google Gemini AI

## For developers
At the moment, there is no specific documentation, but here is how you can use BlockGPT in your project:
1. Download the latest .jar file from the versions page
2. Add this file to your project as an external library
  - You can also do steps 1 and 2 via JitPack

    Click [here](https://jitpack.io/#jvrcruzGAMES/BlockGPT) for instructions on how to install via JitPack

- Use the following code to get the GeminiLibrary class 
### Spigot
```java
GeminiLibrary library = ((BlockGPT) Bukkit.getPluginManager().getPlugin("BlockGPT")).getGeminiAPI()
```
