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

[简体中文](/README.md)

- [MDUI](https://www.mdui.org/en/docs/2/) :  A Material Design 3 (Material You) library of Web Components.
- [Laminar](https://laminar.dev/) :  A Native Scala.js UI library
- Dependencies Version
  - Scala 3.4.2
  - ScalaJs 1.16.0
  - Laminar 17.0.0


This is a binding from MDUI to Laminar. MDUI is a good UI library based on web components and does not rely on any framework. Very suitable for use as a universal component library.

This project contains two modules

- The code generator in the directory src , work in the JVM, where most of the code comes from the generator in [laminar-shoelace-components](https://github.com/raquo/laminar-shoelace-components)
- Scalajs under MDUI, used for publishing scalajs projects. The automatically generated binding will be placed in this project for easy publishing

# What work has been done

- Removed most of the rules originally defined for Shoelaces and removed some hard code.
- Try to generator all code from `custom-elements.json`, support more type.
- Adjustments have been made to the supported types, and the support for enumeration properties has been well received
- Added separate compilation processing for @ mdui/icon, which can be used like using Laminar tags

The generated code has not been fully tested, and there may be some incomplete attributes, which are entirely generated based on mdui's custom elements. json. But the effect is great, the quality of the source code is very high

# How to use

sbt :

```scala
libraryDependencies += "io.github.elgca" %%% "laminar-mdui" % "0.1.0"
```

compile
```shell
npm install
sbt run
```

using:

```scala
import elgca.laminar.components.mdui

mdui.Button(
    _.variant.elevated,
    "This is Button"
)

//使用Icon

mdui.Button(
    _.slots.icon(
        mdui.Icon(_.name := "360")
    )
)

//Or

mdui.Button(
  _.slots.icon(
    mdui.icon.IconmduiIcon10mp()
  )
)

```

# License

This project is provided under the MIT license.****