<p align="center">
  <a href="https://www.mdui.org/">
    <img src="https://raw.githubusercontent.com/zdhxiong/mdui/953011ce2911e2e64b6cb242729df82664f6a78a/packages/jetbrains-plugin/src/main/resources/META-INF/pluginIcon.svg" alt="mdui logo" width="165" height="165"/>
  </a>
<span style="font-size: 50px; text-align: center"> For </span>
  <a href="https://laminar.dev/">
    <img src="https://laminar.dev/img/brand/laminar-logo-100px-rounded.png" alt="mdui logo" width="165" height="165"/>
  </a>
</p>

<h1 align="center">Laminar Bindings for MDUI Web Components</h1>

- [MDUI](https://www.mdui.org/en/docs/2/) :  A Material Design 3 (Material You) library of Web Components.
- [Laminar](https://laminar.dev/) :  A Native Scala.js UI library


这是一个MDUI到Laminar的绑定，MDUI是一个不错的UI库, 基于web components，不依赖任何框架。非常适合作为一个通用组件库使用

这个项目包含两个模块

- 跟目录src下的代码生成器，jvm的代码生成器，他的大部分代码来自[laminar-shoelace-components](https://github.com/raquo/laminar-shoelace-components)的Generator
- mdui下的scalajs，用于发布的scalajs项目，自动生成的绑定将会被放入这个工程，便于发布

# 如何使用

```shell
npm install
sbt run
```


生成的代码并没有进行完全的测试，可能存在部分属性不，完全是基于mdui的custom-elements.json生成的。


# License

This project is provided under the MIT license.